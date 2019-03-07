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
import com.sina.weibo.sdk.constant.WBConstants;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q extends l implements i {
    private static final int[] bHd = {TbConfig.POST_IMAGE_SMALL, 2000, 3500, 4600, 6000, 8000};
    private static final int[] bHe = {201, 202, 203};
    private static final int[] bHf = {501, 502, 503};
    private final f bGY;
    private final com.baidu.tbadk.core.hybrid.c bGZ;
    private final HashMap<String, m> bGu;
    private final c bHa;
    private final HashMap<String, h> bHb;
    private int bHc;
    private String logId;
    private int status;

    private q(WebView webView, com.baidu.tbadk.core.hybrid.b bVar) {
        this(webView, new f(), new com.baidu.tbadk.core.hybrid.c(), bVar);
    }

    private q(WebView webView, f fVar, com.baidu.tbadk.core.hybrid.c cVar, com.baidu.tbadk.core.hybrid.b bVar) {
        super(webView, bVar);
        this.logId = String.valueOf(System.currentTimeMillis());
        this.status = -1;
        this.bHc = -1;
        this.bGY = fVar;
        this.bGZ = cVar;
        this.bGZ.a(this);
        this.bGY.a(this);
        this.bHa = new c(this);
        this.bHb = new HashMap<>(16);
        this.bGu = new HashMap<>(8);
        init();
    }

    public static l a(boolean z, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(webView);
        }
        q qVar = new q(webView, bVar);
        qVar.bGY.b(webViewClient);
        qVar.bGZ.b(webChromeClient);
        return qVar;
    }

    public static l a(boolean z, BridgeWebView bridgeWebView, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(bridgeWebView);
        }
        WebViewClient webViewClient = bridgeWebView.webViewClient;
        WebChromeClient webChromeClient = bridgeWebView.chromeClient;
        q qVar = new q(bridgeWebView, bVar);
        qVar.bGY.b(webViewClient);
        qVar.bGZ.b(webChromeClient);
        return qVar;
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void a(String str, d dVar) {
        if (this.bHb.put(str, dVar) != null) {
            throw new IllegalArgumentException("handler " + str + " exists.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void a(m mVar) {
        a(mVar, mVar.type == 3);
    }

    @Override // com.baidu.tbadk.core.hybrid.i
    public void abF() {
        this.bHc++;
        final int i = this.bHc;
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "android");
        hashMap.put("version", "1.0");
        hashMap.put("logid", abK());
        a(m.a(hashMap, bHd[this.bHc % bHd.length], new k() { // from class: com.baidu.tbadk.core.hybrid.q.1
            @Override // com.baidu.tbadk.core.hybrid.k
            public void a(m mVar, JSONObject jSONObject) {
                q.this.a(mVar, i);
            }

            @Override // com.baidu.tbadk.core.hybrid.k
            public void b(int i2, Throwable th) {
                if (i2 == 1) {
                    if (i < q.bHf.length) {
                        q.this.abL();
                    }
                    if (i >= 0 && i < q.bHf.length) {
                        q.this.bA(String.valueOf(q.bHf[i]), "");
                        return;
                    }
                    BdLog.e("pingIndex " + i + " out of bounds.");
                    e.C(q.this.abK(), "103", "ping timeout for index " + i);
                }
            }
        }), true);
        bA("100", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, int i) {
        this.status = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i >= 0 && i < bHe.length) {
            bA(String.valueOf(bHe[i]), String.valueOf(currentTimeMillis - mVar.bGU));
        } else {
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.i
    public void lC(String str) {
        if (TextUtils.isEmpty(str)) {
            e.lB("invalid callbackId.");
            return;
        }
        m remove = this.bGu.remove(str);
        if (remove != null) {
            e.lB("(" + remove.cmd + ", " + remove.method + ", " + str + ") timeout.");
            remove.b(1, (Throwable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lF(String str) {
        this.bHc = -1;
        if (this.status != 2 && this.status != 1) {
            e.lB("current status " + this.status + ", broken because url changed to " + str);
            this.status = 2;
        }
        if (p.lD(str) && p.lE(str)) {
            e.lB("current status " + this.status + ", constructing bridge for " + str);
            if (this.bGO != null) {
                this.bGO.abx();
            }
            b(this.bGN);
            if (this.bGO != null) {
                this.bGO.aby();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String bx(String str, String str2) {
        e.lB("got js prompt in url:" + str + " with content:" + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString("messageType");
            if ("ping".equals(optString)) {
                m(jSONObject.optString(WBConstants.SHARE_CALLBACK_ID), jSONObject.optJSONObject("outputData"));
            } else if ("request".equals(optString)) {
                a(jSONObject.optString(IntentConfig.CMD), jSONObject.optString("method"), jSONObject.optJSONObject("inputData"), jSONObject);
            } else if ("response".equals(optString)) {
                m(jSONObject.optString(WBConstants.SHARE_CALLBACK_ID), jSONObject.optJSONObject("outputData"));
            } else {
                e.C(abK(), "105", "invalid message type " + optString);
            }
            return null;
        } catch (JSONException e) {
            e.C(abK(), "109", e.getMessage());
            return null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void init() {
        if (this.status != -1) {
            throw new IllegalStateException("Can't init bridge more than once.");
        }
        this.bGN.getSettings().setJavaScriptEnabled(true);
        this.bGN.setWebViewClient(this.bGY);
        this.bGN.setWebChromeClient(this.bGZ);
        this.bGN.removeJavascriptInterface("searchBoxJavaBridge_");
        this.status = 1;
    }

    private void a(m mVar, boolean z) {
        if (!z) {
            if (this.status != 0) {
                e.C(abK(), "101", "(" + mVar.cmd + ", " + mVar.method + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(mVar.cmd) || TextUtils.isEmpty(mVar.method)) {
                e.C(abK(), "102", "the alias class or method is empty");
                mVar.b(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(mVar.bGS)) {
            if (mVar.type != 3) {
                this.bGu.put(mVar.bGS, mVar);
                if (mVar.bGT > 0) {
                    this.bHa.sendMessageDelayed(Message.obtain(this.bHa, 2, mVar.bGS), mVar.bGT);
                } else if (mVar.cmd != null || mVar.method != null) {
                    e.lB("ignore timeout check for method call (" + mVar.cmd + ", " + mVar.method + ").");
                }
            } else {
                e.lB("ignore timeout check for response method, callbackId " + mVar.bGS);
            }
        }
        try {
            String abH = mVar.abH();
            if (Build.VERSION.SDK_INT >= 19) {
                this.bGN.evaluateJavascript(abH, null);
            } else {
                this.bGN.loadUrl(abH);
            }
            e.lB(abH);
        } catch (NullPointerException e) {
            bA("500", e.getMessage());
        } catch (JSONException e2) {
            if (z) {
                bA("102", e2.getMessage());
            } else {
                e.lB(e2.getMessage());
            }
            mVar.b(2, e2);
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.status != 0) {
            e.C(abK(), "106", "bridge is not ready");
        }
        h hVar = this.bHb.get(str);
        if (hVar == null) {
            hVar = new b(this, str);
            e.C(abK(), "107", "cmd " + str + " not found");
        }
        hVar.a(str2, jSONObject, jSONObject2);
    }

    private void m(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.lB("invalid callbackId.");
            return;
        }
        this.bHa.removeMessages(2, str);
        m remove = this.bGu.remove(str);
        if (remove != null) {
            remove.aK(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String abK() {
        return this.logId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bA(String str, String str2) {
        e.B(abK(), str, str2);
    }

    private void b(WebView webView) {
        this.logId = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder abM = abM();
            abM.append(new String(bArr));
            webView.loadUrl("javascript:" + abM.toString());
            this.bHa.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            bA("102", th.getMessage());
            e.lB(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abL() {
        e.lB("reInject for pingIndex " + this.bHc);
        b(this.bGN);
    }

    private StringBuilder abM() throws JSONException {
        StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", "android");
        jSONObject.put("version", "1.0");
        jSONObject.put("logid", abK());
        sb.append(jSONObject.toString());
        sb.append(';');
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Handler {
        private final WeakReference<i> bHh;

        public c(i iVar) {
            this.bHh = new WeakReference<>(iVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i iVar = this.bHh.get();
            if (iVar == null) {
                e.lB("TimeHandler got null bridge reference.");
                return;
            }
            switch (message.what) {
                case 1:
                    iVar.abF();
                    return;
                case 2:
                    iVar.lC((String) message.obj);
                    return;
                default:
                    throw new IllegalArgumentException("Invalid message.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements h {
        private final l bGt;
        private final String cmd;

        protected b(l lVar, String str) {
            this.bGt = lVar;
            this.cmd = str;
        }

        @Override // com.baidu.tbadk.core.hybrid.h
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            String optString = jSONObject2.optString(WBConstants.SHARE_CALLBACK_ID);
            if (TextUtils.isEmpty(optString)) {
                e.lB("scope " + this.cmd + " not found!");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", "107");
            hashMap.put("errMsg", "cmd " + this.cmd + " not found");
            this.bGt.a(m.i(optString, hashMap));
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
