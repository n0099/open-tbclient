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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.coloros.mcssdk.PushManager;
import com.sina.weibo.sdk.constant.WBConstants;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q extends l implements i {
    private static final int[] bHh = {TbConfig.POST_IMAGE_SMALL, 2000, 3500, 4600, 6000, 8000};
    private static final int[] bHi = {201, 202, 203};
    private static final int[] bHj = {501, 502, 503};
    private final HashMap<String, m> bGy;
    private final f bHc;
    private final com.baidu.tbadk.core.hybrid.c bHd;
    private final c bHe;
    private final HashMap<String, h> bHf;
    private int bHg;
    private String logId;
    private int status;

    private q(WebView webView, com.baidu.tbadk.core.hybrid.b bVar) {
        this(webView, new f(), new com.baidu.tbadk.core.hybrid.c(), bVar);
    }

    private q(WebView webView, f fVar, com.baidu.tbadk.core.hybrid.c cVar, com.baidu.tbadk.core.hybrid.b bVar) {
        super(webView, bVar);
        this.logId = String.valueOf(System.currentTimeMillis());
        this.status = -1;
        this.bHg = -1;
        this.bHc = fVar;
        this.bHd = cVar;
        this.bHd.a(this);
        this.bHc.a(this);
        this.bHe = new c(this);
        this.bHf = new HashMap<>(16);
        this.bGy = new HashMap<>(8);
        init();
    }

    public static l a(boolean z, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(webView);
        }
        q qVar = new q(webView, bVar);
        qVar.bHc.b(webViewClient);
        qVar.bHd.b(webChromeClient);
        return qVar;
    }

    public static l a(boolean z, BridgeWebView bridgeWebView, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(bridgeWebView);
        }
        WebViewClient webViewClient = bridgeWebView.webViewClient;
        WebChromeClient webChromeClient = bridgeWebView.chromeClient;
        q qVar = new q(bridgeWebView, bVar);
        qVar.bHc.b(webViewClient);
        qVar.bHd.b(webChromeClient);
        return qVar;
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void a(String str, d dVar) {
        if (this.bHf.put(str, dVar) != null) {
            throw new IllegalArgumentException("handler " + str + " exists.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void a(m mVar) {
        a(mVar, mVar.type == 3);
    }

    @Override // com.baidu.tbadk.core.hybrid.i
    public void abC() {
        this.bHg++;
        final int i = this.bHg;
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "android");
        hashMap.put("version", "1.0");
        hashMap.put("logid", abH());
        a(m.a(hashMap, bHh[this.bHg % bHh.length], new k() { // from class: com.baidu.tbadk.core.hybrid.q.1
            @Override // com.baidu.tbadk.core.hybrid.k
            public void a(m mVar, JSONObject jSONObject) {
                q.this.a(mVar, i);
            }

            @Override // com.baidu.tbadk.core.hybrid.k
            public void b(int i2, Throwable th) {
                if (i2 == 1) {
                    if (i < q.bHj.length) {
                        q.this.abI();
                    }
                    if (i >= 0 && i < q.bHj.length) {
                        q.this.bA(String.valueOf(q.bHj[i]), "");
                        return;
                    }
                    BdLog.e("pingIndex " + i + " out of bounds.");
                    e.C(q.this.abH(), "103", "ping timeout for index " + i);
                }
            }
        }), true);
        bA("100", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, int i) {
        this.status = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i >= 0 && i < bHi.length) {
            bA(String.valueOf(bHi[i]), String.valueOf(currentTimeMillis - mVar.bGY));
        } else {
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.i
    public void lD(String str) {
        if (TextUtils.isEmpty(str)) {
            e.lC("invalid callbackId.");
            return;
        }
        m remove = this.bGy.remove(str);
        if (remove != null) {
            e.lC("(" + remove.cmd + ", " + remove.method + ", " + str + ") timeout.");
            remove.b(1, (Throwable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lG(String str) {
        this.bHg = -1;
        if (this.status != 2 && this.status != 1) {
            e.lC("current status " + this.status + ", broken because url changed to " + str);
            this.status = 2;
        }
        if (p.lE(str) && p.lF(str)) {
            e.lC("current status " + this.status + ", constructing bridge for " + str);
            if (this.bGS != null) {
                this.bGS.abu();
            }
            b(this.bGR);
            if (this.bGS != null) {
                this.bGS.abv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String bx(String str, String str2) {
        e.lC("got js prompt in url:" + str + " with content:" + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString(PushManager.MESSAGE_TYPE);
            if ("ping".equals(optString)) {
                m(jSONObject.optString(WBConstants.SHARE_CALLBACK_ID), jSONObject.optJSONObject("outputData"));
            } else if ("request".equals(optString)) {
                a(jSONObject.optString(IntentConfig.CMD), jSONObject.optString("method"), jSONObject.optJSONObject("inputData"), jSONObject);
            } else if ("response".equals(optString)) {
                m(jSONObject.optString(WBConstants.SHARE_CALLBACK_ID), jSONObject.optJSONObject("outputData"));
            } else {
                e.C(abH(), "105", "invalid message type " + optString);
            }
            return null;
        } catch (JSONException e) {
            e.C(abH(), "109", e.getMessage());
            return null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void init() {
        if (this.status != -1) {
            throw new IllegalStateException("Can't init bridge more than once.");
        }
        this.bGR.getSettings().setJavaScriptEnabled(true);
        this.bGR.setWebViewClient(this.bHc);
        this.bGR.setWebChromeClient(this.bHd);
        this.bGR.removeJavascriptInterface("searchBoxJavaBridge_");
        this.status = 1;
    }

    private void a(m mVar, boolean z) {
        if (!z) {
            if (this.status != 0) {
                e.C(abH(), "101", "(" + mVar.cmd + ", " + mVar.method + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(mVar.cmd) || TextUtils.isEmpty(mVar.method)) {
                e.C(abH(), "102", "the alias class or method is empty");
                mVar.b(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(mVar.bGW)) {
            if (mVar.type != 3) {
                this.bGy.put(mVar.bGW, mVar);
                if (mVar.bGX > 0) {
                    this.bHe.sendMessageDelayed(Message.obtain(this.bHe, 2, mVar.bGW), mVar.bGX);
                } else if (mVar.cmd != null || mVar.method != null) {
                    e.lC("ignore timeout check for method call (" + mVar.cmd + ", " + mVar.method + ").");
                }
            } else {
                e.lC("ignore timeout check for response method, callbackId " + mVar.bGW);
            }
        }
        try {
            String abE = mVar.abE();
            if (Build.VERSION.SDK_INT >= 19) {
                this.bGR.evaluateJavascript(abE, null);
            } else {
                this.bGR.loadUrl(abE);
            }
            e.lC(abE);
        } catch (NullPointerException e) {
            bA("500", e.getMessage());
        } catch (JSONException e2) {
            if (z) {
                bA("102", e2.getMessage());
            } else {
                e.lC(e2.getMessage());
            }
            mVar.b(2, e2);
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.status != 0) {
            e.C(abH(), "106", "bridge is not ready");
        }
        h hVar = this.bHf.get(str);
        if (hVar == null) {
            hVar = new b(this, str);
            e.C(abH(), "107", "cmd " + str + " not found");
        }
        hVar.a(str2, jSONObject, jSONObject2);
    }

    private void m(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.lC("invalid callbackId.");
            return;
        }
        this.bHe.removeMessages(2, str);
        m remove = this.bGy.remove(str);
        if (remove != null) {
            remove.aK(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String abH() {
        return this.logId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bA(String str, String str2) {
        e.B(abH(), str, str2);
    }

    private void b(WebView webView) {
        this.logId = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder abJ = abJ();
            abJ.append(new String(bArr));
            webView.loadUrl("javascript:" + abJ.toString());
            this.bHe.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            bA("102", th.getMessage());
            e.lC(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abI() {
        e.lC("reInject for pingIndex " + this.bHg);
        b(this.bGR);
    }

    private StringBuilder abJ() throws JSONException {
        StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", "android");
        jSONObject.put("version", "1.0");
        jSONObject.put("logid", abH());
        sb.append(jSONObject.toString());
        sb.append(';');
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Handler {
        private final WeakReference<i> bHl;

        public c(i iVar) {
            this.bHl = new WeakReference<>(iVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i iVar = this.bHl.get();
            if (iVar == null) {
                e.lC("TimeHandler got null bridge reference.");
                return;
            }
            switch (message.what) {
                case 1:
                    iVar.abC();
                    return;
                case 2:
                    iVar.lD((String) message.obj);
                    return;
                default:
                    throw new IllegalArgumentException("Invalid message.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements h {
        private final l bGx;
        private final String cmd;

        protected b(l lVar, String str) {
            this.bGx = lVar;
            this.cmd = str;
        }

        @Override // com.baidu.tbadk.core.hybrid.h
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            String optString = jSONObject2.optString(WBConstants.SHARE_CALLBACK_ID);
            if (TextUtils.isEmpty(optString)) {
                e.lC("scope " + this.cmd + " not found!");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", "107");
            hashMap.put("errMsg", "cmd " + this.cmd + " not found");
            this.bGx.a(m.i(optString, hashMap));
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
