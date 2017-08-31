package com.baidu.tbadk.core.hybrid;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.BuildConfig;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class x extends p implements l {
    private static final int[] adB = {1500, 2000, 3500, 4600, 6000, 8000};
    private static final int[] adC = {201, 202, 203};
    private static final int[] adD = {501, 502, 503};
    private final HashMap<String, q> acA;
    private int adA;
    private final g adw;
    private final com.baidu.tbadk.core.hybrid.c adx;
    private final c ady;
    private final HashMap<String, k> adz;
    private String logId;
    private int status;

    private x(WebView webView, com.baidu.tbadk.core.hybrid.b bVar) {
        this(webView, new g(), new com.baidu.tbadk.core.hybrid.c(), bVar);
    }

    private x(WebView webView, g gVar, com.baidu.tbadk.core.hybrid.c cVar, com.baidu.tbadk.core.hybrid.b bVar) {
        super(webView, bVar);
        this.logId = String.valueOf(System.currentTimeMillis());
        this.status = -1;
        this.adA = -1;
        this.adw = gVar;
        this.adx = cVar;
        this.adx.a(this);
        this.adw.a(this);
        this.ady = new c(this);
        this.adz = new HashMap<>(16);
        this.acA = new HashMap<>(8);
        init();
    }

    public static p a(boolean z, WebView webView, com.baidu.tbadk.core.hybrid.b bVar) {
        return z ? new x(webView, bVar) : new a(webView);
    }

    public static p a(boolean z, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(webView);
        }
        x xVar = new x(webView, bVar);
        xVar.adw.a(webViewClient);
        xVar.adx.a(webChromeClient);
        return xVar;
    }

    public static p a(boolean z, f fVar, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(fVar);
        }
        WebViewClient webViewClient = fVar.webViewClient;
        WebChromeClient webChromeClient = fVar.chromeClient;
        x xVar = new x(fVar, bVar);
        xVar.adw.a(webViewClient);
        xVar.adx.a(webChromeClient);
        return xVar;
    }

    @Override // com.baidu.tbadk.core.hybrid.p
    public void a(String str, d dVar) {
        if (this.adz.put(str, dVar) != null) {
            throw new IllegalArgumentException("handler " + str + " exists.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.p
    public void a(q qVar) {
        a(qVar, qVar.type == 3);
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void tU() {
        this.adA++;
        final int i = this.adA;
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "android");
        hashMap.put("version", BuildConfig.VERSION_NAME);
        hashMap.put("logid", ue());
        a(q.a(hashMap, adB[this.adA % adB.length], new n() { // from class: com.baidu.tbadk.core.hybrid.x.1
            @Override // com.baidu.tbadk.core.hybrid.n
            public void a(q qVar, JSONObject jSONObject) {
                x.this.a(qVar, i);
            }

            @Override // com.baidu.tbadk.core.hybrid.n
            public void b(int i2, Throwable th) {
                if (i2 == 1) {
                    if (i < x.adD.length) {
                        x.this.uf();
                    }
                    if (i >= 0 && i < x.adD.length) {
                        x.this.T(String.valueOf(x.adD[i]), "");
                        return;
                    }
                    BdLog.e("pingIndex " + i + " out of bounds.");
                    e.k(x.this.ue(), "103", "ping timeout for index " + i);
                }
            }
        }), true);
        T("100", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q qVar, int i) {
        this.status = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i >= 0 && i < adC.length) {
            T(String.valueOf(adC[i]), String.valueOf(currentTimeMillis - qVar.start));
        } else {
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void cU(String str) {
        if (TextUtils.isEmpty(str)) {
            e.cP("invalid callbackId.");
            return;
        }
        q remove = this.acA.remove(str);
        if (remove != null) {
            e.cP("(" + remove.cmd + ", " + remove.method + ", " + str + ") timeout.");
            remove.b(1, (Throwable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cY(String str) {
        this.adA = -1;
        if (this.status != 2 && this.status != 1) {
            e.cP("current status " + this.status + ", broken because url changed to " + str);
            this.status = 2;
        }
        if (w.cW(str) && w.cX(str)) {
            e.cP("current status " + this.status + ", constructing bridge for " + str);
            if (this.adj != null) {
                this.adj.tK();
            }
            b(this.adi);
            if (this.adj != null) {
                this.adj.tL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String Q(String str, String str2) {
        e.cP("got js prompt in url:" + str + " with content:" + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString("messageType");
            if ("ping".equals(optString)) {
                c(jSONObject.optString("callbackId"), jSONObject.optJSONObject("outputData"));
            } else if ("request".equals(optString)) {
                a(jSONObject.optString(IntentConfig.CMD), jSONObject.optString(PushConstants.EXTRA_METHOD), jSONObject.optJSONObject("inputData"), jSONObject);
            } else if ("response".equals(optString)) {
                c(jSONObject.optString("callbackId"), jSONObject.optJSONObject("outputData"));
            } else {
                e.k(ue(), "105", "invalid message type " + optString);
            }
            return null;
        } catch (JSONException e) {
            e.k(ue(), "109", e.getMessage());
            return null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void init() {
        if (this.status != -1) {
            throw new IllegalStateException("Can't init bridge more than once.");
        }
        this.adi.getSettings().setJavaScriptEnabled(true);
        this.adi.setWebViewClient(this.adw);
        this.adi.setWebChromeClient(this.adx);
        this.adi.removeJavascriptInterface("searchBoxJavaBridge_");
        this.status = 1;
    }

    private void a(q qVar, boolean z) {
        if (!z) {
            if (this.status != 0) {
                e.k(ue(), "101", "(" + qVar.cmd + ", " + qVar.method + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(qVar.cmd) || TextUtils.isEmpty(qVar.method)) {
                e.k(ue(), "102", "the alias class or method is empty");
                qVar.b(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(qVar.adn)) {
            if (qVar.type != 3) {
                this.acA.put(qVar.adn, qVar);
                if (qVar.ado > 0) {
                    this.ady.sendMessageDelayed(Message.obtain(this.ady, 2, qVar.adn), qVar.ado);
                } else if (qVar.cmd != null || qVar.method != null) {
                    e.cP("ignore timeout check for method call (" + qVar.cmd + ", " + qVar.method + ").");
                }
            } else {
                e.cP("ignore timeout check for response method, callbackId " + qVar.adn);
            }
        }
        try {
            String tW = qVar.tW();
            this.adi.loadUrl(tW);
            e.cP(tW);
        } catch (NullPointerException e) {
            T("500", e.getMessage());
        } catch (JSONException e2) {
            if (z) {
                T("102", e2.getMessage());
            } else {
                e.cP(e2.getMessage());
            }
            qVar.b(2, e2);
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.status != 0) {
            e.k(ue(), "106", "bridge is not ready");
        }
        k kVar = this.adz.get(str);
        if (kVar == null) {
            kVar = new b(this, str);
            e.k(ue(), "107", "cmd " + str + " not found");
        }
        kVar.a(str2, jSONObject, jSONObject2);
    }

    private void c(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.cP("invalid callbackId.");
            return;
        }
        this.ady.removeMessages(2, str);
        q remove = this.acA.remove(str);
        if (remove != null) {
            remove.e(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ue() {
        return this.logId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(String str, String str2) {
        e.j(ue(), str, str2);
    }

    private void b(WebView webView) {
        this.logId = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder ug = ug();
            ug.append(new String(bArr));
            webView.loadUrl("javascript:" + ug.toString());
            this.ady.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            T("102", th.getMessage());
            e.cP(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uf() {
        e.cP("reInject for pingIndex " + this.adA);
        b(this.adi);
    }

    private StringBuilder ug() throws JSONException {
        StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", "android");
        jSONObject.put("version", BuildConfig.VERSION_NAME);
        jSONObject.put("logid", ue());
        sb.append(jSONObject.toString());
        sb.append(';');
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Handler {
        private final WeakReference<l> adG;

        public c(l lVar) {
            this.adG = new WeakReference<>(lVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            l lVar = this.adG.get();
            if (lVar == null) {
                e.cP("TimeHandler got null bridge reference.");
                return;
            }
            switch (message.what) {
                case 1:
                    lVar.tU();
                    return;
                case 2:
                    lVar.cU((String) message.obj);
                    return;
                default:
                    throw new IllegalArgumentException("Invalid message.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements k {
        private final p acz;
        private final String cmd;

        protected b(p pVar, String str) {
            this.acz = pVar;
            this.cmd = str;
        }

        @Override // com.baidu.tbadk.core.hybrid.k
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            String optString = jSONObject2.optString("callbackId");
            if (TextUtils.isEmpty(optString)) {
                e.cP("scope " + this.cmd + " not found!");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", "107");
            hashMap.put("errMsg", "cmd " + this.cmd + " not found");
            this.acz.a(q.b(optString, hashMap));
        }
    }

    /* loaded from: classes.dex */
    private static final class a extends p {
        private a(WebView webView) {
            super(webView, null);
        }

        @Override // com.baidu.tbadk.core.hybrid.p
        public void a(String str, d dVar) {
        }

        @Override // com.baidu.tbadk.core.hybrid.p
        public void a(q qVar) {
            qVar.b(4, (Throwable) null);
        }
    }
}
