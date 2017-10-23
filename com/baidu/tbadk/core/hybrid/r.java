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
    private static final int[] acX = {1500, 2000, 3500, 4600, 6000, 8000};
    private static final int[] acY = {201, 202, 203};
    private static final int[] acZ = {501, 502, 503};
    private final g acS;
    private final com.baidu.tbadk.core.hybrid.c acT;
    private final c acU;
    private final HashMap<String, i> acV;
    private int acW;
    private final HashMap<String, n> acp;
    private String logId;
    private int status;

    private r(WebView webView, com.baidu.tbadk.core.hybrid.b bVar) {
        this(webView, new g(), new com.baidu.tbadk.core.hybrid.c(), bVar);
    }

    private r(WebView webView, g gVar, com.baidu.tbadk.core.hybrid.c cVar, com.baidu.tbadk.core.hybrid.b bVar) {
        super(webView, bVar);
        this.logId = String.valueOf(System.currentTimeMillis());
        this.status = -1;
        this.acW = -1;
        this.acS = gVar;
        this.acT = cVar;
        this.acT.a(this);
        this.acS.a(this);
        this.acU = new c(this);
        this.acV = new HashMap<>(16);
        this.acp = new HashMap<>(8);
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
        rVar.acS.a(webViewClient);
        rVar.acT.a(webChromeClient);
        return rVar;
    }

    public static m a(boolean z, f fVar, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(fVar);
        }
        WebViewClient webViewClient = fVar.webViewClient;
        WebChromeClient webChromeClient = fVar.chromeClient;
        r rVar = new r(fVar, bVar);
        rVar.acS.a(webViewClient);
        rVar.acT.a(webChromeClient);
        return rVar;
    }

    @Override // com.baidu.tbadk.core.hybrid.m
    public void a(String str, d dVar) {
        if (this.acV.put(str, dVar) != null) {
            throw new IllegalArgumentException("handler " + str + " exists.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.m
    public void a(n nVar) {
        a(nVar, nVar.type == 3);
    }

    @Override // com.baidu.tbadk.core.hybrid.j
    public void tF() {
        this.acW++;
        final int i = this.acW;
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "android");
        hashMap.put("version", BuildConfig.VERSION_NAME);
        hashMap.put("logid", tK());
        a(n.a(hashMap, acX[this.acW % acX.length], new l() { // from class: com.baidu.tbadk.core.hybrid.r.1
            @Override // com.baidu.tbadk.core.hybrid.l
            public void a(n nVar, JSONObject jSONObject) {
                r.this.a(nVar, i);
            }

            @Override // com.baidu.tbadk.core.hybrid.l
            public void b(int i2, Throwable th) {
                if (i2 == 1) {
                    if (i < r.acZ.length) {
                        r.this.tL();
                    }
                    if (i >= 0 && i < r.acZ.length) {
                        r.this.S(String.valueOf(r.acZ[i]), "");
                        return;
                    }
                    BdLog.e("pingIndex " + i + " out of bounds.");
                    e.k(r.this.tK(), "103", "ping timeout for index " + i);
                }
            }
        }), true);
        S("100", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar, int i) {
        this.status = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i >= 0 && i < acY.length) {
            S(String.valueOf(acY[i]), String.valueOf(currentTimeMillis - nVar.start));
        } else {
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.j
    public void cP(String str) {
        if (TextUtils.isEmpty(str)) {
            e.cO("invalid callbackId.");
            return;
        }
        n remove = this.acp.remove(str);
        if (remove != null) {
            e.cO("(" + remove.cmd + ", " + remove.method + ", " + str + ") timeout.");
            remove.b(1, (Throwable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cS(String str) {
        this.acW = -1;
        if (this.status != 2 && this.status != 1) {
            e.cO("current status " + this.status + ", broken because url changed to " + str);
            this.status = 2;
        }
        if (q.cQ(str) && q.cR(str)) {
            e.cO("current status " + this.status + ", constructing bridge for " + str);
            if (this.acJ != null) {
                this.acJ.tx();
            }
            b(this.acI);
            if (this.acJ != null) {
                this.acJ.ty();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String P(String str, String str2) {
        e.cO("got js prompt in url:" + str + " with content:" + str2);
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
                e.k(tK(), "105", "invalid message type " + optString);
            }
            return null;
        } catch (JSONException e) {
            e.k(tK(), "109", e.getMessage());
            return null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void init() {
        if (this.status != -1) {
            throw new IllegalStateException("Can't init bridge more than once.");
        }
        this.acI.getSettings().setJavaScriptEnabled(true);
        this.acI.setWebViewClient(this.acS);
        this.acI.setWebChromeClient(this.acT);
        this.acI.removeJavascriptInterface("searchBoxJavaBridge_");
        this.status = 1;
    }

    private void a(n nVar, boolean z) {
        if (!z) {
            if (this.status != 0) {
                e.k(tK(), "101", "(" + nVar.cmd + ", " + nVar.method + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(nVar.cmd) || TextUtils.isEmpty(nVar.method)) {
                e.k(tK(), "102", "the alias class or method is empty");
                nVar.b(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(nVar.acN)) {
            if (nVar.type != 3) {
                this.acp.put(nVar.acN, nVar);
                if (nVar.acO > 0) {
                    this.acU.sendMessageDelayed(Message.obtain(this.acU, 2, nVar.acN), nVar.acO);
                } else if (nVar.cmd != null || nVar.method != null) {
                    e.cO("ignore timeout check for method call (" + nVar.cmd + ", " + nVar.method + ").");
                }
            } else {
                e.cO("ignore timeout check for response method, callbackId " + nVar.acN);
            }
        }
        try {
            String tH = nVar.tH();
            this.acI.loadUrl(tH);
            e.cO(tH);
        } catch (NullPointerException e) {
            S("500", e.getMessage());
        } catch (JSONException e2) {
            if (z) {
                S("102", e2.getMessage());
            } else {
                e.cO(e2.getMessage());
            }
            nVar.b(2, e2);
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.status != 0) {
            e.k(tK(), "106", "bridge is not ready");
        }
        i iVar = this.acV.get(str);
        if (iVar == null) {
            iVar = new b(this, str);
            e.k(tK(), "107", "cmd " + str + " not found");
        }
        iVar.a(str2, jSONObject, jSONObject2);
    }

    private void c(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.cO("invalid callbackId.");
            return;
        }
        this.acU.removeMessages(2, str);
        n remove = this.acp.remove(str);
        if (remove != null) {
            remove.g(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String tK() {
        return this.logId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(String str, String str2) {
        e.j(tK(), str, str2);
    }

    private void b(WebView webView) {
        this.logId = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder tM = tM();
            tM.append(new String(bArr));
            webView.loadUrl("javascript:" + tM.toString());
            this.acU.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            S("102", th.getMessage());
            e.cO(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tL() {
        e.cO("reInject for pingIndex " + this.acW);
        b(this.acI);
    }

    private StringBuilder tM() throws JSONException {
        StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", "android");
        jSONObject.put("version", BuildConfig.VERSION_NAME);
        jSONObject.put("logid", tK());
        sb.append(jSONObject.toString());
        sb.append(';');
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Handler {
        private final WeakReference<j> adc;

        public c(j jVar) {
            this.adc = new WeakReference<>(jVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            j jVar = this.adc.get();
            if (jVar == null) {
                e.cO("TimeHandler got null bridge reference.");
                return;
            }
            switch (message.what) {
                case 1:
                    jVar.tF();
                    return;
                case 2:
                    jVar.cP((String) message.obj);
                    return;
                default:
                    throw new IllegalArgumentException("Invalid message.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements i {
        private final m aco;
        private final String cmd;

        protected b(m mVar, String str) {
            this.aco = mVar;
            this.cmd = str;
        }

        @Override // com.baidu.tbadk.core.hybrid.i
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            String optString = jSONObject2.optString("callbackId");
            if (TextUtils.isEmpty(optString)) {
                e.cO("scope " + this.cmd + " not found!");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", "107");
            hashMap.put("errMsg", "cmd " + this.cmd + " not found");
            this.aco.a(n.b(optString, hashMap));
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
