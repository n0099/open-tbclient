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
    private static final int[] azk = {TbConfig.POST_IMAGE_SMALL, 2000, 3500, 4600, 6000, 8000};
    private static final int[] azl = {201, 202, 203};
    private static final int[] azm = {501, 502, 503};
    private final HashMap<String, m> ayB;
    private final f azf;
    private final com.baidu.tbadk.core.hybrid.c azg;
    private final c azh;
    private final HashMap<String, h> azi;
    private int azj;
    private String logId;
    private int status;

    private q(WebView webView, com.baidu.tbadk.core.hybrid.b bVar) {
        this(webView, new f(), new com.baidu.tbadk.core.hybrid.c(), bVar);
    }

    private q(WebView webView, f fVar, com.baidu.tbadk.core.hybrid.c cVar, com.baidu.tbadk.core.hybrid.b bVar) {
        super(webView, bVar);
        this.logId = String.valueOf(System.currentTimeMillis());
        this.status = -1;
        this.azj = -1;
        this.azf = fVar;
        this.azg = cVar;
        this.azg.a(this);
        this.azf.a(this);
        this.azh = new c(this);
        this.azi = new HashMap<>(16);
        this.ayB = new HashMap<>(8);
        init();
    }

    public static l a(boolean z, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(webView);
        }
        q qVar = new q(webView, bVar);
        qVar.azf.a(webViewClient);
        qVar.azg.a(webChromeClient);
        return qVar;
    }

    public static l a(boolean z, BridgeWebView bridgeWebView, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(bridgeWebView);
        }
        WebViewClient webViewClient = bridgeWebView.webViewClient;
        WebChromeClient webChromeClient = bridgeWebView.chromeClient;
        q qVar = new q(bridgeWebView, bVar);
        qVar.azf.a(webViewClient);
        qVar.azg.a(webChromeClient);
        return qVar;
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void a(String str, d dVar) {
        if (this.azi.put(str, dVar) != null) {
            throw new IllegalArgumentException("handler " + str + " exists.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void a(m mVar) {
        a(mVar, mVar.type == 3);
    }

    @Override // com.baidu.tbadk.core.hybrid.i
    public void Cv() {
        this.azj++;
        final int i = this.azj;
        HashMap hashMap = new HashMap();
        hashMap.put("platform", HttpConstants.OS_TYPE_VALUE);
        hashMap.put("version", "1.0");
        hashMap.put("logid", CA());
        a(m.a(hashMap, azk[this.azj % azk.length], new k() { // from class: com.baidu.tbadk.core.hybrid.q.1
            @Override // com.baidu.tbadk.core.hybrid.k
            public void a(m mVar, JSONObject jSONObject) {
                q.this.a(mVar, i);
            }

            @Override // com.baidu.tbadk.core.hybrid.k
            public void b(int i2, Throwable th) {
                if (i2 == 1) {
                    if (i < q.azm.length) {
                        q.this.CB();
                    }
                    if (i >= 0 && i < q.azm.length) {
                        q.this.at(String.valueOf(q.azm[i]), "");
                        return;
                    }
                    BdLog.e("pingIndex " + i + " out of bounds.");
                    e.p(q.this.CA(), "103", "ping timeout for index " + i);
                }
            }
        }), true);
        at("100", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, int i) {
        this.status = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i >= 0 && i < azl.length) {
            at(String.valueOf(azl[i]), String.valueOf(currentTimeMillis - mVar.azb));
        } else {
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.i
    public void eO(String str) {
        if (TextUtils.isEmpty(str)) {
            e.eN("invalid callbackId.");
            return;
        }
        m remove = this.ayB.remove(str);
        if (remove != null) {
            e.eN("(" + remove.cmd + ", " + remove.method + ", " + str + ") timeout.");
            remove.b(1, (Throwable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eR(String str) {
        this.azj = -1;
        if (this.status != 2 && this.status != 1) {
            e.eN("current status " + this.status + ", broken because url changed to " + str);
            this.status = 2;
        }
        if (p.eP(str) && p.eQ(str)) {
            e.eN("current status " + this.status + ", constructing bridge for " + str);
            if (this.ayV != null) {
                this.ayV.Cn();
            }
            b(this.ayU);
            if (this.ayV != null) {
                this.ayV.Co();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String aq(String str, String str2) {
        e.eN("got js prompt in url:" + str + " with content:" + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString("messageType");
            if ("ping".equals(optString)) {
                g(jSONObject.optString(WBConstants.SHARE_CALLBACK_ID), jSONObject.optJSONObject("outputData"));
            } else if ("request".equals(optString)) {
                a(jSONObject.optString(IntentConfig.CMD), jSONObject.optString("method"), jSONObject.optJSONObject("inputData"), jSONObject);
            } else if ("response".equals(optString)) {
                g(jSONObject.optString(WBConstants.SHARE_CALLBACK_ID), jSONObject.optJSONObject("outputData"));
            } else {
                e.p(CA(), "105", "invalid message type " + optString);
            }
            return null;
        } catch (JSONException e) {
            e.p(CA(), "109", e.getMessage());
            return null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void init() {
        if (this.status != -1) {
            throw new IllegalStateException("Can't init bridge more than once.");
        }
        this.ayU.getSettings().setJavaScriptEnabled(true);
        this.ayU.setWebViewClient(this.azf);
        this.ayU.setWebChromeClient(this.azg);
        this.ayU.removeJavascriptInterface("searchBoxJavaBridge_");
        this.status = 1;
    }

    private void a(m mVar, boolean z) {
        if (!z) {
            if (this.status != 0) {
                e.p(CA(), "101", "(" + mVar.cmd + ", " + mVar.method + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(mVar.cmd) || TextUtils.isEmpty(mVar.method)) {
                e.p(CA(), "102", "the alias class or method is empty");
                mVar.b(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(mVar.ayZ)) {
            if (mVar.type != 3) {
                this.ayB.put(mVar.ayZ, mVar);
                if (mVar.aza > 0) {
                    this.azh.sendMessageDelayed(Message.obtain(this.azh, 2, mVar.ayZ), mVar.aza);
                } else if (mVar.cmd != null || mVar.method != null) {
                    e.eN("ignore timeout check for method call (" + mVar.cmd + ", " + mVar.method + ").");
                }
            } else {
                e.eN("ignore timeout check for response method, callbackId " + mVar.ayZ);
            }
        }
        try {
            String Cx = mVar.Cx();
            if (Build.VERSION.SDK_INT >= 19) {
                this.ayU.evaluateJavascript(Cx, null);
            } else {
                this.ayU.loadUrl(Cx);
            }
            e.eN(Cx);
        } catch (NullPointerException e) {
            at("500", e.getMessage());
        } catch (JSONException e2) {
            if (z) {
                at("102", e2.getMessage());
            } else {
                e.eN(e2.getMessage());
            }
            mVar.b(2, e2);
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.status != 0) {
            e.p(CA(), "106", "bridge is not ready");
        }
        h hVar = this.azi.get(str);
        if (hVar == null) {
            hVar = new b(this, str);
            e.p(CA(), "107", "cmd " + str + " not found");
        }
        hVar.a(str2, jSONObject, jSONObject2);
    }

    private void g(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.eN("invalid callbackId.");
            return;
        }
        this.azh.removeMessages(2, str);
        m remove = this.ayB.remove(str);
        if (remove != null) {
            remove.A(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String CA() {
        return this.logId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(String str, String str2) {
        e.o(CA(), str, str2);
    }

    private void b(WebView webView) {
        this.logId = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder CC = CC();
            CC.append(new String(bArr));
            webView.loadUrl("javascript:" + CC.toString());
            this.azh.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            at("102", th.getMessage());
            e.eN(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CB() {
        e.eN("reInject for pingIndex " + this.azj);
        b(this.ayU);
    }

    private StringBuilder CC() throws JSONException {
        StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", HttpConstants.OS_TYPE_VALUE);
        jSONObject.put("version", "1.0");
        jSONObject.put("logid", CA());
        sb.append(jSONObject.toString());
        sb.append(';');
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Handler {
        private final WeakReference<i> azo;

        public c(i iVar) {
            this.azo = new WeakReference<>(iVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i iVar = this.azo.get();
            if (iVar == null) {
                e.eN("TimeHandler got null bridge reference.");
                return;
            }
            switch (message.what) {
                case 1:
                    iVar.Cv();
                    return;
                case 2:
                    iVar.eO((String) message.obj);
                    return;
                default:
                    throw new IllegalArgumentException("Invalid message.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements h {
        private final l ayA;
        private final String cmd;

        protected b(l lVar, String str) {
            this.ayA = lVar;
            this.cmd = str;
        }

        @Override // com.baidu.tbadk.core.hybrid.h
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            String optString = jSONObject2.optString(WBConstants.SHARE_CALLBACK_ID);
            if (TextUtils.isEmpty(optString)) {
                e.eN("scope " + this.cmd + " not found!");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", "107");
            hashMap.put("errMsg", "cmd " + this.cmd + " not found");
            this.ayA.a(m.f(optString, hashMap));
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
