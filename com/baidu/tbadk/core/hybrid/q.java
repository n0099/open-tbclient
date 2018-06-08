package com.baidu.tbadk.core.hybrid;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q extends l implements i {
    private static final int[] amV = {TbConfig.POST_IMAGE_SMALL, 2000, 3500, 4600, 6000, 8000};
    private static final int[] amW = {201, 202, HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION};
    private static final int[] amX = {501, HttpStatus.SC_BAD_GATEWAY, HttpStatus.SC_SERVICE_UNAVAILABLE};
    private final f amQ;
    private final com.baidu.tbadk.core.hybrid.c amR;
    private final c amS;
    private final HashMap<String, h> amT;
    private int amU;
    private final HashMap<String, m> amn;
    private String logId;
    private int status;

    private q(WebView webView, com.baidu.tbadk.core.hybrid.b bVar) {
        this(webView, new f(), new com.baidu.tbadk.core.hybrid.c(), bVar);
    }

    private q(WebView webView, f fVar, com.baidu.tbadk.core.hybrid.c cVar, com.baidu.tbadk.core.hybrid.b bVar) {
        super(webView, bVar);
        this.logId = String.valueOf(System.currentTimeMillis());
        this.status = -1;
        this.amU = -1;
        this.amQ = fVar;
        this.amR = cVar;
        this.amR.a(this);
        this.amQ.a(this);
        this.amS = new c(this);
        this.amT = new HashMap<>(16);
        this.amn = new HashMap<>(8);
        init();
    }

    public static l a(boolean z, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(webView);
        }
        q qVar = new q(webView, bVar);
        qVar.amQ.a(webViewClient);
        qVar.amR.a(webChromeClient);
        return qVar;
    }

    public static l a(boolean z, BridgeWebView bridgeWebView, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(bridgeWebView);
        }
        WebViewClient webViewClient = bridgeWebView.webViewClient;
        WebChromeClient webChromeClient = bridgeWebView.chromeClient;
        q qVar = new q(bridgeWebView, bVar);
        qVar.amQ.a(webViewClient);
        qVar.amR.a(webChromeClient);
        return qVar;
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void a(String str, d dVar) {
        if (this.amT.put(str, dVar) != null) {
            throw new IllegalArgumentException("handler " + str + " exists.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void a(m mVar) {
        a(mVar, mVar.type == 3);
    }

    @Override // com.baidu.tbadk.core.hybrid.i
    public void xE() {
        this.amU++;
        final int i = this.amU;
        HashMap hashMap = new HashMap();
        hashMap.put("platform", HttpConstants.OS_TYPE_VALUE);
        hashMap.put("version", "1.0");
        hashMap.put("logid", xJ());
        a(m.a(hashMap, amV[this.amU % amV.length], new k() { // from class: com.baidu.tbadk.core.hybrid.q.1
            @Override // com.baidu.tbadk.core.hybrid.k
            public void a(m mVar, JSONObject jSONObject) {
                q.this.a(mVar, i);
            }

            @Override // com.baidu.tbadk.core.hybrid.k
            public void b(int i2, Throwable th) {
                if (i2 == 1) {
                    if (i < q.amX.length) {
                        q.this.xK();
                    }
                    if (i >= 0 && i < q.amX.length) {
                        q.this.W(String.valueOf(q.amX[i]), "");
                        return;
                    }
                    BdLog.e("pingIndex " + i + " out of bounds.");
                    e.l(q.this.xJ(), "103", "ping timeout for index " + i);
                }
            }
        }), true);
        W("100", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, int i) {
        this.status = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i >= 0 && i < amW.length) {
            W(String.valueOf(amW[i]), String.valueOf(currentTimeMillis - mVar.start));
        } else {
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.i
    public void dF(String str) {
        if (TextUtils.isEmpty(str)) {
            e.dE("invalid callbackId.");
            return;
        }
        m remove = this.amn.remove(str);
        if (remove != null) {
            e.dE("(" + remove.cmd + ", " + remove.method + ", " + str + ") timeout.");
            remove.b(1, (Throwable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dI(String str) {
        this.amU = -1;
        if (this.status != 2 && this.status != 1) {
            e.dE("current status " + this.status + ", broken because url changed to " + str);
            this.status = 2;
        }
        if (p.dG(str) && p.dH(str)) {
            e.dE("current status " + this.status + ", constructing bridge for " + str);
            if (this.amH != null) {
                this.amH.xw();
            }
            b(this.amG);
            if (this.amH != null) {
                this.amH.xx();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String T(String str, String str2) {
        e.dE("got js prompt in url:" + str + " with content:" + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString("messageType");
            if ("ping".equals(optString)) {
                e(jSONObject.optString("callbackId"), jSONObject.optJSONObject("outputData"));
            } else if ("request".equals(optString)) {
                a(jSONObject.optString(IntentConfig.CMD), jSONObject.optString("method"), jSONObject.optJSONObject("inputData"), jSONObject);
            } else if ("response".equals(optString)) {
                e(jSONObject.optString("callbackId"), jSONObject.optJSONObject("outputData"));
            } else {
                e.l(xJ(), "105", "invalid message type " + optString);
            }
            return null;
        } catch (JSONException e) {
            e.l(xJ(), "109", e.getMessage());
            return null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void init() {
        if (this.status != -1) {
            throw new IllegalStateException("Can't init bridge more than once.");
        }
        this.amG.getSettings().setJavaScriptEnabled(true);
        this.amG.setWebViewClient(this.amQ);
        this.amG.setWebChromeClient(this.amR);
        this.amG.removeJavascriptInterface("searchBoxJavaBridge_");
        this.status = 1;
    }

    private void a(m mVar, boolean z) {
        if (!z) {
            if (this.status != 0) {
                e.l(xJ(), "101", "(" + mVar.cmd + ", " + mVar.method + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(mVar.cmd) || TextUtils.isEmpty(mVar.method)) {
                e.l(xJ(), "102", "the alias class or method is empty");
                mVar.b(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(mVar.amL)) {
            if (mVar.type != 3) {
                this.amn.put(mVar.amL, mVar);
                if (mVar.amM > 0) {
                    this.amS.sendMessageDelayed(Message.obtain(this.amS, 2, mVar.amL), mVar.amM);
                } else if (mVar.cmd != null || mVar.method != null) {
                    e.dE("ignore timeout check for method call (" + mVar.cmd + ", " + mVar.method + ").");
                }
            } else {
                e.dE("ignore timeout check for response method, callbackId " + mVar.amL);
            }
        }
        try {
            String xG = mVar.xG();
            if (Build.VERSION.SDK_INT >= 19) {
                this.amG.evaluateJavascript(xG, null);
            } else {
                this.amG.loadUrl(xG);
            }
            e.dE(xG);
        } catch (NullPointerException e) {
            W("500", e.getMessage());
        } catch (JSONException e2) {
            if (z) {
                W("102", e2.getMessage());
            } else {
                e.dE(e2.getMessage());
            }
            mVar.b(2, e2);
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.status != 0) {
            e.l(xJ(), "106", "bridge is not ready");
        }
        h hVar = this.amT.get(str);
        if (hVar == null) {
            hVar = new b(this, str);
            e.l(xJ(), "107", "cmd " + str + " not found");
        }
        hVar.a(str2, jSONObject, jSONObject2);
    }

    private void e(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.dE("invalid callbackId.");
            return;
        }
        this.amS.removeMessages(2, str);
        m remove = this.amn.remove(str);
        if (remove != null) {
            remove.q(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String xJ() {
        return this.logId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(String str, String str2) {
        e.k(xJ(), str, str2);
    }

    private void b(WebView webView) {
        this.logId = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder xL = xL();
            xL.append(new String(bArr));
            webView.loadUrl("javascript:" + xL.toString());
            this.amS.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            W("102", th.getMessage());
            e.dE(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xK() {
        e.dE("reInject for pingIndex " + this.amU);
        b(this.amG);
    }

    private StringBuilder xL() throws JSONException {
        StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", HttpConstants.OS_TYPE_VALUE);
        jSONObject.put("version", "1.0");
        jSONObject.put("logid", xJ());
        sb.append(jSONObject.toString());
        sb.append(';');
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Handler {
        private final WeakReference<i> amZ;

        public c(i iVar) {
            this.amZ = new WeakReference<>(iVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i iVar = this.amZ.get();
            if (iVar == null) {
                e.dE("TimeHandler got null bridge reference.");
                return;
            }
            switch (message.what) {
                case 1:
                    iVar.xE();
                    return;
                case 2:
                    iVar.dF((String) message.obj);
                    return;
                default:
                    throw new IllegalArgumentException("Invalid message.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements h {
        private final l amm;
        private final String cmd;

        protected b(l lVar, String str) {
            this.amm = lVar;
            this.cmd = str;
        }

        @Override // com.baidu.tbadk.core.hybrid.h
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            String optString = jSONObject2.optString("callbackId");
            if (TextUtils.isEmpty(optString)) {
                e.dE("scope " + this.cmd + " not found!");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", "107");
            hashMap.put("errMsg", "cmd " + this.cmd + " not found");
            this.amm.a(m.c(optString, hashMap));
        }
    }

    /* loaded from: classes.dex */
    private static final class a extends l {
        private a(WebView webView) {
            super(webView, null);
        }

        @Override // com.baidu.tbadk.core.hybrid.l
        public void a(String str, d dVar) {
        }

        @Override // com.baidu.tbadk.core.hybrid.l
        public void a(m mVar) {
            mVar.b(4, (Throwable) null);
        }
    }
}
