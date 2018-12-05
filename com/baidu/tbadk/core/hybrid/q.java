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
import com.sina.weibo.sdk.constant.WBConstants;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q extends l implements i {
    private static final int[] ayH = {TbConfig.POST_IMAGE_SMALL, 2000, 3500, 4600, 6000, 8000};
    private static final int[] ayI = {201, 202, 203};
    private static final int[] ayJ = {501, 502, 503};
    private final HashMap<String, m> axY;
    private final f ayC;
    private final com.baidu.tbadk.core.hybrid.c ayD;
    private final c ayE;
    private final HashMap<String, h> ayF;
    private int ayG;
    private String logId;
    private int status;

    private q(WebView webView, com.baidu.tbadk.core.hybrid.b bVar) {
        this(webView, new f(), new com.baidu.tbadk.core.hybrid.c(), bVar);
    }

    private q(WebView webView, f fVar, com.baidu.tbadk.core.hybrid.c cVar, com.baidu.tbadk.core.hybrid.b bVar) {
        super(webView, bVar);
        this.logId = String.valueOf(System.currentTimeMillis());
        this.status = -1;
        this.ayG = -1;
        this.ayC = fVar;
        this.ayD = cVar;
        this.ayD.a(this);
        this.ayC.a(this);
        this.ayE = new c(this);
        this.ayF = new HashMap<>(16);
        this.axY = new HashMap<>(8);
        init();
    }

    public static l a(boolean z, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(webView);
        }
        q qVar = new q(webView, bVar);
        qVar.ayC.a(webViewClient);
        qVar.ayD.a(webChromeClient);
        return qVar;
    }

    public static l a(boolean z, BridgeWebView bridgeWebView, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(bridgeWebView);
        }
        WebViewClient webViewClient = bridgeWebView.webViewClient;
        WebChromeClient webChromeClient = bridgeWebView.chromeClient;
        q qVar = new q(bridgeWebView, bVar);
        qVar.ayC.a(webViewClient);
        qVar.ayD.a(webChromeClient);
        return qVar;
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void a(String str, d dVar) {
        if (this.ayF.put(str, dVar) != null) {
            throw new IllegalArgumentException("handler " + str + " exists.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void a(m mVar) {
        a(mVar, mVar.type == 3);
    }

    @Override // com.baidu.tbadk.core.hybrid.i
    public void Ci() {
        this.ayG++;
        final int i = this.ayG;
        HashMap hashMap = new HashMap();
        hashMap.put("platform", HttpConstants.OS_TYPE_VALUE);
        hashMap.put("version", "1.0");
        hashMap.put("logid", Cn());
        a(m.a(hashMap, ayH[this.ayG % ayH.length], new k() { // from class: com.baidu.tbadk.core.hybrid.q.1
            @Override // com.baidu.tbadk.core.hybrid.k
            public void a(m mVar, JSONObject jSONObject) {
                q.this.a(mVar, i);
            }

            @Override // com.baidu.tbadk.core.hybrid.k
            public void b(int i2, Throwable th) {
                if (i2 == 1) {
                    if (i < q.ayJ.length) {
                        q.this.Co();
                    }
                    if (i >= 0 && i < q.ayJ.length) {
                        q.this.as(String.valueOf(q.ayJ[i]), "");
                        return;
                    }
                    BdLog.e("pingIndex " + i + " out of bounds.");
                    e.p(q.this.Cn(), "103", "ping timeout for index " + i);
                }
            }
        }), true);
        as("100", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, int i) {
        this.status = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i >= 0 && i < ayI.length) {
            as(String.valueOf(ayI[i]), String.valueOf(currentTimeMillis - mVar.ayy));
        } else {
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.i
    public void eF(String str) {
        if (TextUtils.isEmpty(str)) {
            e.eE("invalid callbackId.");
            return;
        }
        m remove = this.axY.remove(str);
        if (remove != null) {
            e.eE("(" + remove.cmd + ", " + remove.method + ", " + str + ") timeout.");
            remove.b(1, (Throwable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eI(String str) {
        this.ayG = -1;
        if (this.status != 2 && this.status != 1) {
            e.eE("current status " + this.status + ", broken because url changed to " + str);
            this.status = 2;
        }
        if (p.eG(str) && p.eH(str)) {
            e.eE("current status " + this.status + ", constructing bridge for " + str);
            if (this.ays != null) {
                this.ays.Ca();
            }
            b(this.ayr);
            if (this.ays != null) {
                this.ays.Cb();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String ap(String str, String str2) {
        e.eE("got js prompt in url:" + str + " with content:" + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString("messageType");
            if ("ping".equals(optString)) {
                f(jSONObject.optString(WBConstants.SHARE_CALLBACK_ID), jSONObject.optJSONObject("outputData"));
            } else if ("request".equals(optString)) {
                a(jSONObject.optString(IntentConfig.CMD), jSONObject.optString("method"), jSONObject.optJSONObject("inputData"), jSONObject);
            } else if ("response".equals(optString)) {
                f(jSONObject.optString(WBConstants.SHARE_CALLBACK_ID), jSONObject.optJSONObject("outputData"));
            } else {
                e.p(Cn(), "105", "invalid message type " + optString);
            }
            return null;
        } catch (JSONException e) {
            e.p(Cn(), "109", e.getMessage());
            return null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void init() {
        if (this.status != -1) {
            throw new IllegalStateException("Can't init bridge more than once.");
        }
        this.ayr.getSettings().setJavaScriptEnabled(true);
        this.ayr.setWebViewClient(this.ayC);
        this.ayr.setWebChromeClient(this.ayD);
        this.ayr.removeJavascriptInterface("searchBoxJavaBridge_");
        this.status = 1;
    }

    private void a(m mVar, boolean z) {
        if (!z) {
            if (this.status != 0) {
                e.p(Cn(), "101", "(" + mVar.cmd + ", " + mVar.method + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(mVar.cmd) || TextUtils.isEmpty(mVar.method)) {
                e.p(Cn(), "102", "the alias class or method is empty");
                mVar.b(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(mVar.ayw)) {
            if (mVar.type != 3) {
                this.axY.put(mVar.ayw, mVar);
                if (mVar.ayx > 0) {
                    this.ayE.sendMessageDelayed(Message.obtain(this.ayE, 2, mVar.ayw), mVar.ayx);
                } else if (mVar.cmd != null || mVar.method != null) {
                    e.eE("ignore timeout check for method call (" + mVar.cmd + ", " + mVar.method + ").");
                }
            } else {
                e.eE("ignore timeout check for response method, callbackId " + mVar.ayw);
            }
        }
        try {
            String Ck = mVar.Ck();
            if (Build.VERSION.SDK_INT >= 19) {
                this.ayr.evaluateJavascript(Ck, null);
            } else {
                this.ayr.loadUrl(Ck);
            }
            e.eE(Ck);
        } catch (NullPointerException e) {
            as("500", e.getMessage());
        } catch (JSONException e2) {
            if (z) {
                as("102", e2.getMessage());
            } else {
                e.eE(e2.getMessage());
            }
            mVar.b(2, e2);
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.status != 0) {
            e.p(Cn(), "106", "bridge is not ready");
        }
        h hVar = this.ayF.get(str);
        if (hVar == null) {
            hVar = new b(this, str);
            e.p(Cn(), "107", "cmd " + str + " not found");
        }
        hVar.a(str2, jSONObject, jSONObject2);
    }

    private void f(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.eE("invalid callbackId.");
            return;
        }
        this.ayE.removeMessages(2, str);
        m remove = this.axY.remove(str);
        if (remove != null) {
            remove.A(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Cn() {
        return this.logId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(String str, String str2) {
        e.o(Cn(), str, str2);
    }

    private void b(WebView webView) {
        this.logId = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder Cp = Cp();
            Cp.append(new String(bArr));
            webView.loadUrl("javascript:" + Cp.toString());
            this.ayE.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            as("102", th.getMessage());
            e.eE(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Co() {
        e.eE("reInject for pingIndex " + this.ayG);
        b(this.ayr);
    }

    private StringBuilder Cp() throws JSONException {
        StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", HttpConstants.OS_TYPE_VALUE);
        jSONObject.put("version", "1.0");
        jSONObject.put("logid", Cn());
        sb.append(jSONObject.toString());
        sb.append(';');
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Handler {
        private final WeakReference<i> ayL;

        public c(i iVar) {
            this.ayL = new WeakReference<>(iVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i iVar = this.ayL.get();
            if (iVar == null) {
                e.eE("TimeHandler got null bridge reference.");
                return;
            }
            switch (message.what) {
                case 1:
                    iVar.Ci();
                    return;
                case 2:
                    iVar.eF((String) message.obj);
                    return;
                default:
                    throw new IllegalArgumentException("Invalid message.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements h {
        private final l axX;
        private final String cmd;

        protected b(l lVar, String str) {
            this.axX = lVar;
            this.cmd = str;
        }

        @Override // com.baidu.tbadk.core.hybrid.h
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            String optString = jSONObject2.optString(WBConstants.SHARE_CALLBACK_ID);
            if (TextUtils.isEmpty(optString)) {
                e.eE("scope " + this.cmd + " not found!");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", "107");
            hashMap.put("errMsg", "cmd " + this.cmd + " not found");
            this.axX.a(m.f(optString, hashMap));
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
