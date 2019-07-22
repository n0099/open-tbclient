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
    private static final int[] bPH = {TbConfig.POST_IMAGE_SMALL, 2000, 3500, 4600, 6000, 8000};
    private static final int[] bPI = {201, 202, 203};
    private static final int[] bPJ = {501, 502, 503};
    private final HashMap<String, m> bOZ;
    private final f bPC;
    private final com.baidu.tbadk.core.hybrid.c bPD;
    private final c bPE;
    private final HashMap<String, h> bPF;
    private int bPG;
    private String logId;
    private int status;

    private q(WebView webView, com.baidu.tbadk.core.hybrid.b bVar) {
        this(webView, new f(), new com.baidu.tbadk.core.hybrid.c(), bVar);
    }

    private q(WebView webView, f fVar, com.baidu.tbadk.core.hybrid.c cVar, com.baidu.tbadk.core.hybrid.b bVar) {
        super(webView, bVar);
        this.logId = String.valueOf(System.currentTimeMillis());
        this.status = -1;
        this.bPG = -1;
        this.bPC = fVar;
        this.bPD = cVar;
        this.bPD.a(this);
        this.bPC.a(this);
        this.bPE = new c(this);
        this.bPF = new HashMap<>(16);
        this.bOZ = new HashMap<>(8);
        init();
    }

    public static l a(boolean z, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(webView);
        }
        q qVar = new q(webView, bVar);
        qVar.bPC.b(webViewClient);
        qVar.bPD.b(webChromeClient);
        return qVar;
    }

    public static l a(boolean z, BridgeWebView bridgeWebView, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(bridgeWebView);
        }
        WebViewClient webViewClient = bridgeWebView.webViewClient;
        WebChromeClient webChromeClient = bridgeWebView.chromeClient;
        q qVar = new q(bridgeWebView, bVar);
        qVar.bPC.b(webViewClient);
        qVar.bPD.b(webChromeClient);
        return qVar;
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void a(String str, d dVar) {
        if (this.bPF.put(str, dVar) != null) {
            throw new IllegalArgumentException("handler " + str + " exists.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void a(m mVar) {
        a(mVar, mVar.type == 3);
    }

    @Override // com.baidu.tbadk.core.hybrid.i
    public void ahw() {
        this.bPG++;
        final int i = this.bPG;
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "android");
        hashMap.put("version", "1.0");
        hashMap.put("logid", ahB());
        a(m.a(hashMap, bPH[this.bPG % bPH.length], new k() { // from class: com.baidu.tbadk.core.hybrid.q.1
            @Override // com.baidu.tbadk.core.hybrid.k
            public void a(m mVar, JSONObject jSONObject) {
                q.this.a(mVar, i);
            }

            @Override // com.baidu.tbadk.core.hybrid.k
            public void b(int i2, Throwable th) {
                if (i2 == 1) {
                    if (i < q.bPJ.length) {
                        q.this.ahC();
                    }
                    if (i >= 0 && i < q.bPJ.length) {
                        q.this.bJ(String.valueOf(q.bPJ[i]), "");
                        return;
                    }
                    BdLog.e("pingIndex " + i + " out of bounds.");
                    e.E(q.this.ahB(), "103", "ping timeout for index " + i);
                }
            }
        }), true);
        bJ("100", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, int i) {
        this.status = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i >= 0 && i < bPI.length) {
            bJ(String.valueOf(bPI[i]), String.valueOf(currentTimeMillis - mVar.bkA));
        } else {
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.i
    public void mU(String str) {
        if (TextUtils.isEmpty(str)) {
            e.mT("invalid callbackId.");
            return;
        }
        m remove = this.bOZ.remove(str);
        if (remove != null) {
            e.mT("(" + remove.cmd + ", " + remove.method + ", " + str + ") timeout.");
            remove.b(1, (Throwable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mX(String str) {
        this.bPG = -1;
        if (this.status != 2 && this.status != 1) {
            e.mT("current status " + this.status + ", broken because url changed to " + str);
            this.status = 2;
        }
        if (p.mV(str) && p.mW(str)) {
            e.mT("current status " + this.status + ", constructing bridge for " + str);
            if (this.bPt != null) {
                this.bPt.aho();
            }
            b(this.bPs);
            if (this.bPt != null) {
                this.bPt.ahp();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String bG(String str, String str2) {
        e.mT("got js prompt in url:" + str + " with content:" + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString(PushManager.MESSAGE_TYPE);
            if ("ping".equals(optString)) {
                n(jSONObject.optString(WBConstants.SHARE_CALLBACK_ID), jSONObject.optJSONObject("outputData"));
            } else if ("request".equals(optString)) {
                a(jSONObject.optString(IntentConfig.CMD), jSONObject.optString("method"), jSONObject.optJSONObject("inputData"), jSONObject);
            } else if ("response".equals(optString)) {
                n(jSONObject.optString(WBConstants.SHARE_CALLBACK_ID), jSONObject.optJSONObject("outputData"));
            } else {
                e.E(ahB(), "105", "invalid message type " + optString);
            }
            return null;
        } catch (JSONException e) {
            e.E(ahB(), "109", e.getMessage());
            return null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void init() {
        if (this.status != -1) {
            throw new IllegalStateException("Can't init bridge more than once.");
        }
        this.bPs.getSettings().setJavaScriptEnabled(true);
        this.bPs.setWebViewClient(this.bPC);
        this.bPs.setWebChromeClient(this.bPD);
        this.bPs.removeJavascriptInterface("searchBoxJavaBridge_");
        this.status = 1;
    }

    private void a(m mVar, boolean z) {
        if (!z) {
            if (this.status != 0) {
                e.E(ahB(), "101", "(" + mVar.cmd + ", " + mVar.method + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(mVar.cmd) || TextUtils.isEmpty(mVar.method)) {
                e.E(ahB(), "102", "the alias class or method is empty");
                mVar.b(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(mVar.bPx)) {
            if (mVar.type != 3) {
                this.bOZ.put(mVar.bPx, mVar);
                if (mVar.bPy > 0) {
                    this.bPE.sendMessageDelayed(Message.obtain(this.bPE, 2, mVar.bPx), mVar.bPy);
                } else if (mVar.cmd != null || mVar.method != null) {
                    e.mT("ignore timeout check for method call (" + mVar.cmd + ", " + mVar.method + ").");
                }
            } else {
                e.mT("ignore timeout check for response method, callbackId " + mVar.bPx);
            }
        }
        try {
            String ahy = mVar.ahy();
            if (Build.VERSION.SDK_INT >= 19) {
                this.bPs.evaluateJavascript(ahy, null);
            } else {
                this.bPs.loadUrl(ahy);
            }
            e.mT(ahy);
        } catch (NullPointerException e) {
            bJ("500", e.getMessage());
        } catch (JSONException e2) {
            if (z) {
                bJ("102", e2.getMessage());
            } else {
                e.mT(e2.getMessage());
            }
            mVar.b(2, e2);
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.status != 0) {
            e.E(ahB(), "106", "bridge is not ready");
        }
        h hVar = this.bPF.get(str);
        if (hVar == null) {
            hVar = new b(this, str);
            e.E(ahB(), "107", "cmd " + str + " not found");
        }
        hVar.a(str2, jSONObject, jSONObject2);
    }

    private void n(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.mT("invalid callbackId.");
            return;
        }
        this.bPE.removeMessages(2, str);
        m remove = this.bOZ.remove(str);
        if (remove != null) {
            remove.aW(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ahB() {
        return this.logId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJ(String str, String str2) {
        e.D(ahB(), str, str2);
    }

    private void b(WebView webView) {
        this.logId = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder ahD = ahD();
            ahD.append(new String(bArr));
            webView.loadUrl("javascript:" + ahD.toString());
            this.bPE.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            bJ("102", th.getMessage());
            e.mT(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahC() {
        e.mT("reInject for pingIndex " + this.bPG);
        b(this.bPs);
    }

    private StringBuilder ahD() throws JSONException {
        StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", "android");
        jSONObject.put("version", "1.0");
        jSONObject.put("logid", ahB());
        sb.append(jSONObject.toString());
        sb.append(';');
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Handler {
        private final WeakReference<i> bPL;

        public c(i iVar) {
            this.bPL = new WeakReference<>(iVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i iVar = this.bPL.get();
            if (iVar == null) {
                e.mT("TimeHandler got null bridge reference.");
                return;
            }
            switch (message.what) {
                case 1:
                    iVar.ahw();
                    return;
                case 2:
                    iVar.mU((String) message.obj);
                    return;
                default:
                    throw new IllegalArgumentException("Invalid message.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements h {
        private final l bOY;
        private final String cmd;

        protected b(l lVar, String str) {
            this.bOY = lVar;
            this.cmd = str;
        }

        @Override // com.baidu.tbadk.core.hybrid.h
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            String optString = jSONObject2.optString(WBConstants.SHARE_CALLBACK_ID);
            if (TextUtils.isEmpty(optString)) {
                e.mT("scope " + this.cmd + " not found!");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", "107");
            hashMap.put("errMsg", "cmd " + this.cmd + " not found");
            this.bOY.a(m.h(optString, hashMap));
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
