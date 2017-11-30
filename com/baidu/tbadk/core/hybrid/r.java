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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class r extends m implements j {
    private static final int[] adR = {TbConfig.POST_IMAGE_SMALL, 2000, 3500, 4600, 6000, 8000};
    private static final int[] adS = {201, 202, 203};
    private static final int[] adT = {501, 502, 503};
    private final g adM;
    private final com.baidu.tbadk.core.hybrid.c adN;
    private final c adO;
    private final HashMap<String, i> adP;
    private int adQ;
    private final HashMap<String, n> adj;
    private String logId;
    private int status;

    private r(WebView webView, com.baidu.tbadk.core.hybrid.b bVar) {
        this(webView, new g(), new com.baidu.tbadk.core.hybrid.c(), bVar);
    }

    private r(WebView webView, g gVar, com.baidu.tbadk.core.hybrid.c cVar, com.baidu.tbadk.core.hybrid.b bVar) {
        super(webView, bVar);
        this.logId = String.valueOf(System.currentTimeMillis());
        this.status = -1;
        this.adQ = -1;
        this.adM = gVar;
        this.adN = cVar;
        this.adN.a(this);
        this.adM.a(this);
        this.adO = new c(this);
        this.adP = new HashMap<>(16);
        this.adj = new HashMap<>(8);
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
        rVar.adM.a(webViewClient);
        rVar.adN.a(webChromeClient);
        return rVar;
    }

    public static m a(boolean z, f fVar, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(fVar);
        }
        WebViewClient webViewClient = fVar.webViewClient;
        WebChromeClient webChromeClient = fVar.chromeClient;
        r rVar = new r(fVar, bVar);
        rVar.adM.a(webViewClient);
        rVar.adN.a(webChromeClient);
        return rVar;
    }

    @Override // com.baidu.tbadk.core.hybrid.m
    public void a(String str, d dVar) {
        if (this.adP.put(str, dVar) != null) {
            throw new IllegalArgumentException("handler " + str + " exists.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.m
    public void a(n nVar) {
        a(nVar, nVar.type == 3);
    }

    @Override // com.baidu.tbadk.core.hybrid.j
    public void tP() {
        this.adQ++;
        final int i = this.adQ;
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "android");
        hashMap.put("version", BuildConfig.VERSION_NAME);
        hashMap.put("logid", tU());
        a(n.a(hashMap, adR[this.adQ % adR.length], new l() { // from class: com.baidu.tbadk.core.hybrid.r.1
            @Override // com.baidu.tbadk.core.hybrid.l
            public void a(n nVar, JSONObject jSONObject) {
                r.this.a(nVar, i);
            }

            @Override // com.baidu.tbadk.core.hybrid.l
            public void b(int i2, Throwable th) {
                if (i2 == 1) {
                    if (i < r.adT.length) {
                        r.this.tV();
                    }
                    if (i >= 0 && i < r.adT.length) {
                        r.this.S(String.valueOf(r.adT[i]), "");
                        return;
                    }
                    BdLog.e("pingIndex " + i + " out of bounds.");
                    e.k(r.this.tU(), "103", "ping timeout for index " + i);
                }
            }
        }), true);
        S("100", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar, int i) {
        this.status = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i >= 0 && i < adS.length) {
            S(String.valueOf(adS[i]), String.valueOf(currentTimeMillis - nVar.start));
        } else {
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.j
    public void cW(String str) {
        if (TextUtils.isEmpty(str)) {
            e.cV("invalid callbackId.");
            return;
        }
        n remove = this.adj.remove(str);
        if (remove != null) {
            e.cV("(" + remove.cmd + ", " + remove.method + ", " + str + ") timeout.");
            remove.b(1, (Throwable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cZ(String str) {
        this.adQ = -1;
        if (this.status != 2 && this.status != 1) {
            e.cV("current status " + this.status + ", broken because url changed to " + str);
            this.status = 2;
        }
        if (q.cX(str) && q.cY(str)) {
            e.cV("current status " + this.status + ", constructing bridge for " + str);
            if (this.adD != null) {
                this.adD.tH();
            }
            b(this.adC);
            if (this.adD != null) {
                this.adD.tI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String P(String str, String str2) {
        e.cV("got js prompt in url:" + str + " with content:" + str2);
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
                e.k(tU(), "105", "invalid message type " + optString);
            }
            return null;
        } catch (JSONException e) {
            e.k(tU(), "109", e.getMessage());
            return null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void init() {
        if (this.status != -1) {
            throw new IllegalStateException("Can't init bridge more than once.");
        }
        this.adC.getSettings().setJavaScriptEnabled(true);
        this.adC.setWebViewClient(this.adM);
        this.adC.setWebChromeClient(this.adN);
        this.adC.removeJavascriptInterface("searchBoxJavaBridge_");
        this.status = 1;
    }

    private void a(n nVar, boolean z) {
        if (!z) {
            if (this.status != 0) {
                e.k(tU(), "101", "(" + nVar.cmd + ", " + nVar.method + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(nVar.cmd) || TextUtils.isEmpty(nVar.method)) {
                e.k(tU(), "102", "the alias class or method is empty");
                nVar.b(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(nVar.adH)) {
            if (nVar.type != 3) {
                this.adj.put(nVar.adH, nVar);
                if (nVar.adI > 0) {
                    this.adO.sendMessageDelayed(Message.obtain(this.adO, 2, nVar.adH), nVar.adI);
                } else if (nVar.cmd != null || nVar.method != null) {
                    e.cV("ignore timeout check for method call (" + nVar.cmd + ", " + nVar.method + ").");
                }
            } else {
                e.cV("ignore timeout check for response method, callbackId " + nVar.adH);
            }
        }
        try {
            String tR = nVar.tR();
            this.adC.loadUrl(tR);
            e.cV(tR);
        } catch (NullPointerException e) {
            S("500", e.getMessage());
        } catch (JSONException e2) {
            if (z) {
                S("102", e2.getMessage());
            } else {
                e.cV(e2.getMessage());
            }
            nVar.b(2, e2);
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.status != 0) {
            e.k(tU(), "106", "bridge is not ready");
        }
        i iVar = this.adP.get(str);
        if (iVar == null) {
            iVar = new b(this, str);
            e.k(tU(), "107", "cmd " + str + " not found");
        }
        iVar.a(str2, jSONObject, jSONObject2);
    }

    private void c(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.cV("invalid callbackId.");
            return;
        }
        this.adO.removeMessages(2, str);
        n remove = this.adj.remove(str);
        if (remove != null) {
            remove.g(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String tU() {
        return this.logId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(String str, String str2) {
        e.j(tU(), str, str2);
    }

    private void b(WebView webView) {
        this.logId = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder tW = tW();
            tW.append(new String(bArr));
            webView.loadUrl("javascript:" + tW.toString());
            this.adO.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            S("102", th.getMessage());
            e.cV(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tV() {
        e.cV("reInject for pingIndex " + this.adQ);
        b(this.adC);
    }

    private StringBuilder tW() throws JSONException {
        StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", "android");
        jSONObject.put("version", BuildConfig.VERSION_NAME);
        jSONObject.put("logid", tU());
        sb.append(jSONObject.toString());
        sb.append(';');
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Handler {
        private final WeakReference<j> adW;

        public c(j jVar) {
            this.adW = new WeakReference<>(jVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            j jVar = this.adW.get();
            if (jVar == null) {
                e.cV("TimeHandler got null bridge reference.");
                return;
            }
            switch (message.what) {
                case 1:
                    jVar.tP();
                    return;
                case 2:
                    jVar.cW((String) message.obj);
                    return;
                default:
                    throw new IllegalArgumentException("Invalid message.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements i {
        private final m adi;
        private final String cmd;

        protected b(m mVar, String str) {
            this.adi = mVar;
            this.cmd = str;
        }

        @Override // com.baidu.tbadk.core.hybrid.i
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            String optString = jSONObject2.optString("callbackId");
            if (TextUtils.isEmpty(optString)) {
                e.cV("scope " + this.cmd + " not found!");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", "107");
            hashMap.put("errMsg", "cmd " + this.cmd + " not found");
            this.adi.a(n.b(optString, hashMap));
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
