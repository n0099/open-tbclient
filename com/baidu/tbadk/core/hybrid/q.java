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
    private static final int[] bQo = {TbConfig.POST_IMAGE_SMALL, 2000, 3500, 4600, 6000, 8000};
    private static final int[] bQp = {201, 202, 203};
    private static final int[] bQq = {501, 502, 503};
    private final HashMap<String, m> bPG;
    private final f bQj;
    private final com.baidu.tbadk.core.hybrid.c bQk;
    private final c bQl;
    private final HashMap<String, h> bQm;
    private int bQn;
    private String logId;
    private int status;

    private q(WebView webView, com.baidu.tbadk.core.hybrid.b bVar) {
        this(webView, new f(), new com.baidu.tbadk.core.hybrid.c(), bVar);
    }

    private q(WebView webView, f fVar, com.baidu.tbadk.core.hybrid.c cVar, com.baidu.tbadk.core.hybrid.b bVar) {
        super(webView, bVar);
        this.logId = String.valueOf(System.currentTimeMillis());
        this.status = -1;
        this.bQn = -1;
        this.bQj = fVar;
        this.bQk = cVar;
        this.bQk.a(this);
        this.bQj.a(this);
        this.bQl = new c(this);
        this.bQm = new HashMap<>(16);
        this.bPG = new HashMap<>(8);
        init();
    }

    public static l a(boolean z, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(webView);
        }
        q qVar = new q(webView, bVar);
        qVar.bQj.b(webViewClient);
        qVar.bQk.b(webChromeClient);
        return qVar;
    }

    public static l a(boolean z, BridgeWebView bridgeWebView, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(bridgeWebView);
        }
        WebViewClient webViewClient = bridgeWebView.webViewClient;
        WebChromeClient webChromeClient = bridgeWebView.chromeClient;
        q qVar = new q(bridgeWebView, bVar);
        qVar.bQj.b(webViewClient);
        qVar.bQk.b(webChromeClient);
        return qVar;
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void a(String str, d dVar) {
        if (this.bQm.put(str, dVar) != null) {
            throw new IllegalArgumentException("handler " + str + " exists.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void a(m mVar) {
        a(mVar, mVar.type == 3);
    }

    @Override // com.baidu.tbadk.core.hybrid.i
    public void ahC() {
        this.bQn++;
        final int i = this.bQn;
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "android");
        hashMap.put("version", "1.0");
        hashMap.put("logid", ahH());
        a(m.a(hashMap, bQo[this.bQn % bQo.length], new k() { // from class: com.baidu.tbadk.core.hybrid.q.1
            @Override // com.baidu.tbadk.core.hybrid.k
            public void a(m mVar, JSONObject jSONObject) {
                q.this.a(mVar, i);
            }

            @Override // com.baidu.tbadk.core.hybrid.k
            public void b(int i2, Throwable th) {
                if (i2 == 1) {
                    if (i < q.bQq.length) {
                        q.this.ahI();
                    }
                    if (i >= 0 && i < q.bQq.length) {
                        q.this.bJ(String.valueOf(q.bQq[i]), "");
                        return;
                    }
                    BdLog.e("pingIndex " + i + " out of bounds.");
                    e.E(q.this.ahH(), "103", "ping timeout for index " + i);
                }
            }
        }), true);
        bJ("100", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, int i) {
        this.status = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i >= 0 && i < bQp.length) {
            bJ(String.valueOf(bQp[i]), String.valueOf(currentTimeMillis - mVar.bkY));
        } else {
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.i
    public void mW(String str) {
        if (TextUtils.isEmpty(str)) {
            e.mV("invalid callbackId.");
            return;
        }
        m remove = this.bPG.remove(str);
        if (remove != null) {
            e.mV("(" + remove.cmd + ", " + remove.method + ", " + str + ") timeout.");
            remove.b(1, (Throwable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mZ(String str) {
        this.bQn = -1;
        if (this.status != 2 && this.status != 1) {
            e.mV("current status " + this.status + ", broken because url changed to " + str);
            this.status = 2;
        }
        if (p.mX(str) && p.mY(str)) {
            e.mV("current status " + this.status + ", constructing bridge for " + str);
            if (this.bQa != null) {
                this.bQa.ahu();
            }
            b(this.bPZ);
            if (this.bQa != null) {
                this.bQa.ahv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String bG(String str, String str2) {
        e.mV("got js prompt in url:" + str + " with content:" + str2);
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
                e.E(ahH(), "105", "invalid message type " + optString);
            }
            return null;
        } catch (JSONException e) {
            e.E(ahH(), "109", e.getMessage());
            return null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void init() {
        if (this.status != -1) {
            throw new IllegalStateException("Can't init bridge more than once.");
        }
        this.bPZ.getSettings().setJavaScriptEnabled(true);
        this.bPZ.setWebViewClient(this.bQj);
        this.bPZ.setWebChromeClient(this.bQk);
        this.bPZ.removeJavascriptInterface("searchBoxJavaBridge_");
        this.status = 1;
    }

    private void a(m mVar, boolean z) {
        if (!z) {
            if (this.status != 0) {
                e.E(ahH(), "101", "(" + mVar.cmd + ", " + mVar.method + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(mVar.cmd) || TextUtils.isEmpty(mVar.method)) {
                e.E(ahH(), "102", "the alias class or method is empty");
                mVar.b(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(mVar.bQe)) {
            if (mVar.type != 3) {
                this.bPG.put(mVar.bQe, mVar);
                if (mVar.bQf > 0) {
                    this.bQl.sendMessageDelayed(Message.obtain(this.bQl, 2, mVar.bQe), mVar.bQf);
                } else if (mVar.cmd != null || mVar.method != null) {
                    e.mV("ignore timeout check for method call (" + mVar.cmd + ", " + mVar.method + ").");
                }
            } else {
                e.mV("ignore timeout check for response method, callbackId " + mVar.bQe);
            }
        }
        try {
            String ahE = mVar.ahE();
            if (Build.VERSION.SDK_INT >= 19) {
                this.bPZ.evaluateJavascript(ahE, null);
            } else {
                this.bPZ.loadUrl(ahE);
            }
            e.mV(ahE);
        } catch (NullPointerException e) {
            bJ("500", e.getMessage());
        } catch (JSONException e2) {
            if (z) {
                bJ("102", e2.getMessage());
            } else {
                e.mV(e2.getMessage());
            }
            mVar.b(2, e2);
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.status != 0) {
            e.E(ahH(), "106", "bridge is not ready");
        }
        h hVar = this.bQm.get(str);
        if (hVar == null) {
            hVar = new b(this, str);
            e.E(ahH(), "107", "cmd " + str + " not found");
        }
        hVar.a(str2, jSONObject, jSONObject2);
    }

    private void n(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.mV("invalid callbackId.");
            return;
        }
        this.bQl.removeMessages(2, str);
        m remove = this.bPG.remove(str);
        if (remove != null) {
            remove.aW(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ahH() {
        return this.logId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJ(String str, String str2) {
        e.D(ahH(), str, str2);
    }

    private void b(WebView webView) {
        this.logId = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder ahJ = ahJ();
            ahJ.append(new String(bArr));
            webView.loadUrl("javascript:" + ahJ.toString());
            this.bQl.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            bJ("102", th.getMessage());
            e.mV(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahI() {
        e.mV("reInject for pingIndex " + this.bQn);
        b(this.bPZ);
    }

    private StringBuilder ahJ() throws JSONException {
        StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", "android");
        jSONObject.put("version", "1.0");
        jSONObject.put("logid", ahH());
        sb.append(jSONObject.toString());
        sb.append(';');
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Handler {
        private final WeakReference<i> bQs;

        public c(i iVar) {
            this.bQs = new WeakReference<>(iVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i iVar = this.bQs.get();
            if (iVar == null) {
                e.mV("TimeHandler got null bridge reference.");
                return;
            }
            switch (message.what) {
                case 1:
                    iVar.ahC();
                    return;
                case 2:
                    iVar.mW((String) message.obj);
                    return;
                default:
                    throw new IllegalArgumentException("Invalid message.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements h {
        private final l bPF;
        private final String cmd;

        protected b(l lVar, String str) {
            this.bPF = lVar;
            this.cmd = str;
        }

        @Override // com.baidu.tbadk.core.hybrid.h
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            String optString = jSONObject2.optString(WBConstants.SHARE_CALLBACK_ID);
            if (TextUtils.isEmpty(optString)) {
                e.mV("scope " + this.cmd + " not found!");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", "107");
            hashMap.put("errMsg", "cmd " + this.cmd + " not found");
            this.bPF.a(m.h(optString, hashMap));
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
