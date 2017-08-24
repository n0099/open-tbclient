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
    private static final int[] aet = {1500, 2000, 3500, 4600, 6000, 8000};
    private static final int[] aeu = {201, 202, 203};
    private static final int[] aev = {501, 502, 503};
    private final HashMap<String, q> adu;
    private final g aeo;
    private final com.baidu.tbadk.core.hybrid.c aep;
    private final c aeq;
    private final HashMap<String, k> aer;
    private int aes;
    private String logId;
    private int status;

    private x(WebView webView, com.baidu.tbadk.core.hybrid.b bVar) {
        this(webView, new g(), new com.baidu.tbadk.core.hybrid.c(), bVar);
    }

    private x(WebView webView, g gVar, com.baidu.tbadk.core.hybrid.c cVar, com.baidu.tbadk.core.hybrid.b bVar) {
        super(webView, bVar);
        this.logId = String.valueOf(System.currentTimeMillis());
        this.status = -1;
        this.aes = -1;
        this.aeo = gVar;
        this.aep = cVar;
        this.aep.a(this);
        this.aeo.a(this);
        this.aeq = new c(this);
        this.aer = new HashMap<>(16);
        this.adu = new HashMap<>(8);
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
        xVar.aeo.a(webViewClient);
        xVar.aep.a(webChromeClient);
        return xVar;
    }

    public static p a(boolean z, f fVar, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(fVar);
        }
        WebViewClient webViewClient = fVar.webViewClient;
        WebChromeClient webChromeClient = fVar.chromeClient;
        x xVar = new x(fVar, bVar);
        xVar.aeo.a(webViewClient);
        xVar.aep.a(webChromeClient);
        return xVar;
    }

    @Override // com.baidu.tbadk.core.hybrid.p
    public void a(String str, d dVar) {
        if (this.aer.put(str, dVar) != null) {
            throw new IllegalArgumentException("handler " + str + " exists.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.p
    public void a(q qVar) {
        a(qVar, qVar.type == 3);
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void tY() {
        this.aes++;
        final int i = this.aes;
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "android");
        hashMap.put("version", BuildConfig.VERSION_NAME);
        hashMap.put("logid", uj());
        a(q.a(hashMap, aet[this.aes % aet.length], new n() { // from class: com.baidu.tbadk.core.hybrid.x.1
            @Override // com.baidu.tbadk.core.hybrid.n
            public void a(q qVar, JSONObject jSONObject) {
                x.this.a(qVar, i);
            }

            @Override // com.baidu.tbadk.core.hybrid.n
            public void b(int i2, Throwable th) {
                if (i2 == 1) {
                    if (i < x.aev.length) {
                        x.this.uk();
                    }
                    if (i >= 0 && i < x.aev.length) {
                        x.this.R(String.valueOf(x.aev[i]), "");
                        return;
                    }
                    BdLog.e("pingIndex " + i + " out of bounds.");
                    e.k(x.this.uj(), "103", "ping timeout for index " + i);
                }
            }
        }), true);
        R("100", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q qVar, int i) {
        this.status = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i >= 0 && i < aeu.length) {
            R(String.valueOf(aeu[i]), String.valueOf(currentTimeMillis - qVar.start));
        } else {
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void de(String str) {
        if (TextUtils.isEmpty(str)) {
            e.cZ("invalid callbackId.");
            return;
        }
        q remove = this.adu.remove(str);
        if (remove != null) {
            e.cZ("(" + remove.cmd + ", " + remove.method + ", " + str + ") timeout.");
            remove.b(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void di(String str) {
        this.aes = -1;
        if (this.status != 2 && this.status != 1) {
            e.cZ("current status " + this.status + ", broken because url changed to " + str);
            this.status = 2;
        }
        if (w.dg(str) && w.dh(str)) {
            e.cZ("current status " + this.status + ", constructing bridge for " + str);
            if (this.aec != null) {
                this.aec.tO();
            }
            d(this.aeb);
            if (this.aec != null) {
                this.aec.tP();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String O(String str, String str2) {
        e.cZ("got js prompt in url:" + str + " with content:" + str2);
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
                e.k(uj(), "105", "invalid message type " + optString);
            }
            return null;
        } catch (JSONException e) {
            e.k(uj(), "109", e.getMessage());
            return null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void init() {
        if (this.status != -1) {
            throw new IllegalStateException("Can't init bridge more than once.");
        }
        this.aeb.getSettings().setJavaScriptEnabled(true);
        this.aeb.setWebViewClient(this.aeo);
        this.aeb.setWebChromeClient(this.aep);
        this.aeb.removeJavascriptInterface("searchBoxJavaBridge_");
        this.status = 1;
    }

    private void a(q qVar, boolean z) {
        if (!z) {
            if (this.status != 0) {
                e.k(uj(), "101", "(" + qVar.cmd + ", " + qVar.method + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(qVar.cmd) || TextUtils.isEmpty(qVar.method)) {
                e.k(uj(), "102", "the alias class or method is empty");
                qVar.b(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(qVar.aeg)) {
            if (qVar.type != 3) {
                this.adu.put(qVar.aeg, qVar);
                if (qVar.aeh > 0) {
                    this.aeq.sendMessageDelayed(Message.obtain(this.aeq, 2, qVar.aeg), qVar.aeh);
                } else if (qVar.cmd != null || qVar.method != null) {
                    e.cZ("ignore timeout check for method call (" + qVar.cmd + ", " + qVar.method + ").");
                }
            } else {
                e.cZ("ignore timeout check for response method, callbackId " + qVar.aeg);
            }
        }
        try {
            String ua = qVar.ua();
            this.aeb.loadUrl(ua);
            e.cZ(ua);
        } catch (NullPointerException e) {
            R("500", e.getMessage());
        } catch (JSONException e2) {
            if (z) {
                R("102", e2.getMessage());
            } else {
                e.cZ(e2.getMessage());
            }
            qVar.b(2, e2);
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.status != 0) {
            e.k(uj(), "106", "bridge is not ready");
        }
        k kVar = this.aer.get(str);
        if (kVar == null) {
            kVar = new b(this, str);
            e.k(uj(), "107", "cmd " + str + " not found");
        }
        kVar.a(str2, jSONObject, jSONObject2);
    }

    private void c(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.cZ("invalid callbackId.");
            return;
        }
        this.aeq.removeMessages(2, str);
        q remove = this.adu.remove(str);
        if (remove != null) {
            remove.k(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String uj() {
        return this.logId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(String str, String str2) {
        e.j(uj(), str, str2);
    }

    private void d(WebView webView) {
        this.logId = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder ul = ul();
            ul.append(new String(bArr));
            webView.loadUrl("javascript:" + ul.toString());
            this.aeq.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            R("102", th.getMessage());
            e.cZ(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uk() {
        e.cZ("reInject for pingIndex " + this.aes);
        d(this.aeb);
    }

    private StringBuilder ul() throws JSONException {
        StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", "android");
        jSONObject.put("version", BuildConfig.VERSION_NAME);
        jSONObject.put("logid", uj());
        sb.append(jSONObject.toString());
        sb.append(';');
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Handler {
        private final WeakReference<l> aey;

        public c(l lVar) {
            this.aey = new WeakReference<>(lVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            l lVar = this.aey.get();
            if (lVar == null) {
                e.cZ("TimeHandler got null bridge reference.");
                return;
            }
            switch (message.what) {
                case 1:
                    lVar.tY();
                    return;
                case 2:
                    lVar.de((String) message.obj);
                    return;
                default:
                    throw new IllegalArgumentException("Invalid message.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements k {
        private final p adt;
        private final String cmd;

        protected b(p pVar, String str) {
            this.adt = pVar;
            this.cmd = str;
        }

        @Override // com.baidu.tbadk.core.hybrid.k
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            String optString = jSONObject2.optString("callbackId");
            if (TextUtils.isEmpty(optString)) {
                e.cZ("scope " + this.cmd + " not found!");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", "107");
            hashMap.put("errMsg", "cmd " + this.cmd + " not found");
            this.adt.a(q.c(optString, hashMap));
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
            qVar.b(4, null);
        }
    }
}
