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
public class r extends m implements j {
    private static final int[] adk = {1500, 2000, 3500, 4600, 6000, 8000};
    private static final int[] adl = {201, 202, 203};
    private static final int[] adm = {501, 502, 503};
    private final HashMap<String, n> acB;
    private final g adf;
    private final com.baidu.tbadk.core.hybrid.c adg;
    private final c adh;
    private final HashMap<String, i> adi;
    private int adj;
    private String logId;
    private int status;

    private r(WebView webView, com.baidu.tbadk.core.hybrid.b bVar) {
        this(webView, new g(), new com.baidu.tbadk.core.hybrid.c(), bVar);
    }

    private r(WebView webView, g gVar, com.baidu.tbadk.core.hybrid.c cVar, com.baidu.tbadk.core.hybrid.b bVar) {
        super(webView, bVar);
        this.logId = String.valueOf(System.currentTimeMillis());
        this.status = -1;
        this.adj = -1;
        this.adf = gVar;
        this.adg = cVar;
        this.adg.a(this);
        this.adf.a(this);
        this.adh = new c(this);
        this.adi = new HashMap<>(16);
        this.acB = new HashMap<>(8);
        init();
    }

    public static m a(boolean z, WebView webView, com.baidu.tbadk.core.hybrid.b bVar) {
        return z ? new r(webView, bVar) : new a(webView);
    }

    public static m a(boolean z, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(webView);
        }
        r rVar = new r(webView, bVar);
        rVar.adf.a(webViewClient);
        rVar.adg.a(webChromeClient);
        return rVar;
    }

    public static m a(boolean z, f fVar, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(fVar);
        }
        WebViewClient webViewClient = fVar.webViewClient;
        WebChromeClient webChromeClient = fVar.chromeClient;
        r rVar = new r(fVar, bVar);
        rVar.adf.a(webViewClient);
        rVar.adg.a(webChromeClient);
        return rVar;
    }

    @Override // com.baidu.tbadk.core.hybrid.m
    public void a(String str, d dVar) {
        if (this.adi.put(str, dVar) != null) {
            throw new IllegalArgumentException("handler " + str + " exists.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.m
    public void a(n nVar) {
        a(nVar, nVar.type == 3);
    }

    @Override // com.baidu.tbadk.core.hybrid.j
    public void tM() {
        this.adj++;
        final int i = this.adj;
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "android");
        hashMap.put("version", BuildConfig.VERSION_NAME);
        hashMap.put("logid", tR());
        a(n.a(hashMap, adk[this.adj % adk.length], new l() { // from class: com.baidu.tbadk.core.hybrid.r.1
            @Override // com.baidu.tbadk.core.hybrid.l
            public void a(n nVar, JSONObject jSONObject) {
                r.this.a(nVar, i);
            }

            @Override // com.baidu.tbadk.core.hybrid.l
            public void b(int i2, Throwable th) {
                if (i2 == 1) {
                    if (i < r.adm.length) {
                        r.this.tS();
                    }
                    if (i >= 0 && i < r.adm.length) {
                        r.this.T(String.valueOf(r.adm[i]), "");
                        return;
                    }
                    BdLog.e("pingIndex " + i + " out of bounds.");
                    e.k(r.this.tR(), "103", "ping timeout for index " + i);
                }
            }
        }), true);
        T("100", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar, int i) {
        this.status = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i >= 0 && i < adl.length) {
            T(String.valueOf(adl[i]), String.valueOf(currentTimeMillis - nVar.start));
        } else {
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.j
    public void cQ(String str) {
        if (TextUtils.isEmpty(str)) {
            e.cP("invalid callbackId.");
            return;
        }
        n remove = this.acB.remove(str);
        if (remove != null) {
            e.cP("(" + remove.cmd + ", " + remove.method + ", " + str + ") timeout.");
            remove.b(1, (Throwable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cT(String str) {
        this.adj = -1;
        if (this.status != 2 && this.status != 1) {
            e.cP("current status " + this.status + ", broken because url changed to " + str);
            this.status = 2;
        }
        if (q.cR(str) && q.cS(str)) {
            e.cP("current status " + this.status + ", constructing bridge for " + str);
            if (this.acV != null) {
                this.acV.tE();
            }
            b(this.acU);
            if (this.acV != null) {
                this.acV.tF();
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
                e.k(tR(), "105", "invalid message type " + optString);
            }
            return null;
        } catch (JSONException e) {
            e.k(tR(), "109", e.getMessage());
            return null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void init() {
        if (this.status != -1) {
            throw new IllegalStateException("Can't init bridge more than once.");
        }
        this.acU.getSettings().setJavaScriptEnabled(true);
        this.acU.setWebViewClient(this.adf);
        this.acU.setWebChromeClient(this.adg);
        this.acU.removeJavascriptInterface("searchBoxJavaBridge_");
        this.status = 1;
    }

    private void a(n nVar, boolean z) {
        if (!z) {
            if (this.status != 0) {
                e.k(tR(), "101", "(" + nVar.cmd + ", " + nVar.method + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(nVar.cmd) || TextUtils.isEmpty(nVar.method)) {
                e.k(tR(), "102", "the alias class or method is empty");
                nVar.b(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(nVar.acZ)) {
            if (nVar.type != 3) {
                this.acB.put(nVar.acZ, nVar);
                if (nVar.ada > 0) {
                    this.adh.sendMessageDelayed(Message.obtain(this.adh, 2, nVar.acZ), nVar.ada);
                } else if (nVar.cmd != null || nVar.method != null) {
                    e.cP("ignore timeout check for method call (" + nVar.cmd + ", " + nVar.method + ").");
                }
            } else {
                e.cP("ignore timeout check for response method, callbackId " + nVar.acZ);
            }
        }
        try {
            String tO = nVar.tO();
            this.acU.loadUrl(tO);
            e.cP(tO);
        } catch (NullPointerException e) {
            T("500", e.getMessage());
        } catch (JSONException e2) {
            if (z) {
                T("102", e2.getMessage());
            } else {
                e.cP(e2.getMessage());
            }
            nVar.b(2, e2);
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.status != 0) {
            e.k(tR(), "106", "bridge is not ready");
        }
        i iVar = this.adi.get(str);
        if (iVar == null) {
            iVar = new b(this, str);
            e.k(tR(), "107", "cmd " + str + " not found");
        }
        iVar.a(str2, jSONObject, jSONObject2);
    }

    private void c(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.cP("invalid callbackId.");
            return;
        }
        this.adh.removeMessages(2, str);
        n remove = this.acB.remove(str);
        if (remove != null) {
            remove.e(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String tR() {
        return this.logId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(String str, String str2) {
        e.j(tR(), str, str2);
    }

    private void b(WebView webView) {
        this.logId = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder tT = tT();
            tT.append(new String(bArr));
            webView.loadUrl("javascript:" + tT.toString());
            this.adh.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            T("102", th.getMessage());
            e.cP(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tS() {
        e.cP("reInject for pingIndex " + this.adj);
        b(this.acU);
    }

    private StringBuilder tT() throws JSONException {
        StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", "android");
        jSONObject.put("version", BuildConfig.VERSION_NAME);
        jSONObject.put("logid", tR());
        sb.append(jSONObject.toString());
        sb.append(';');
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Handler {
        private final WeakReference<j> adp;

        public c(j jVar) {
            this.adp = new WeakReference<>(jVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            j jVar = this.adp.get();
            if (jVar == null) {
                e.cP("TimeHandler got null bridge reference.");
                return;
            }
            switch (message.what) {
                case 1:
                    jVar.tM();
                    return;
                case 2:
                    jVar.cQ((String) message.obj);
                    return;
                default:
                    throw new IllegalArgumentException("Invalid message.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements i {
        private final m acA;
        private final String cmd;

        protected b(m mVar, String str) {
            this.acA = mVar;
            this.cmd = str;
        }

        @Override // com.baidu.tbadk.core.hybrid.i
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            String optString = jSONObject2.optString("callbackId");
            if (TextUtils.isEmpty(optString)) {
                e.cP("scope " + this.cmd + " not found!");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", "107");
            hashMap.put("errMsg", "cmd " + this.cmd + " not found");
            this.acA.a(n.b(optString, hashMap));
        }
    }

    /* loaded from: classes.dex */
    private static final class a extends m {
        private a(WebView webView) {
            super(webView, null);
        }

        @Override // com.baidu.tbadk.core.hybrid.m
        public void a(String str, d dVar) {
        }

        @Override // com.baidu.tbadk.core.hybrid.m
        public void a(n nVar) {
            nVar.b(4, (Throwable) null);
        }
    }
}
