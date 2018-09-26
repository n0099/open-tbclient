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
import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q extends l implements i {
    private static final int[] apD = {TbConfig.POST_IMAGE_SMALL, 2000, 3500, 4600, 6000, 8000};
    private static final int[] apE = {201, 202, HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION};
    private static final int[] apF = {501, HttpStatus.SC_BAD_GATEWAY, HttpStatus.SC_SERVICE_UNAVAILABLE};
    private final HashMap<String, m> aoT;
    private final c apA;
    private final HashMap<String, h> apB;
    private int apC;
    private final f apy;
    private final com.baidu.tbadk.core.hybrid.c apz;
    private String logId;
    private int status;

    private q(WebView webView, com.baidu.tbadk.core.hybrid.b bVar) {
        this(webView, new f(), new com.baidu.tbadk.core.hybrid.c(), bVar);
    }

    private q(WebView webView, f fVar, com.baidu.tbadk.core.hybrid.c cVar, com.baidu.tbadk.core.hybrid.b bVar) {
        super(webView, bVar);
        this.logId = String.valueOf(System.currentTimeMillis());
        this.status = -1;
        this.apC = -1;
        this.apy = fVar;
        this.apz = cVar;
        this.apz.a(this);
        this.apy.a(this);
        this.apA = new c(this);
        this.apB = new HashMap<>(16);
        this.aoT = new HashMap<>(8);
        init();
    }

    public static l a(boolean z, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(webView);
        }
        q qVar = new q(webView, bVar);
        qVar.apy.a(webViewClient);
        qVar.apz.a(webChromeClient);
        return qVar;
    }

    public static l a(boolean z, BridgeWebView bridgeWebView, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(bridgeWebView);
        }
        WebViewClient webViewClient = bridgeWebView.webViewClient;
        WebChromeClient webChromeClient = bridgeWebView.chromeClient;
        q qVar = new q(bridgeWebView, bVar);
        qVar.apy.a(webViewClient);
        qVar.apz.a(webChromeClient);
        return qVar;
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void a(String str, d dVar) {
        if (this.apB.put(str, dVar) != null) {
            throw new IllegalArgumentException("handler " + str + " exists.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void a(m mVar) {
        a(mVar, mVar.type == 3);
    }

    @Override // com.baidu.tbadk.core.hybrid.i
    public void yP() {
        this.apC++;
        final int i = this.apC;
        HashMap hashMap = new HashMap();
        hashMap.put("platform", HttpConstants.OS_TYPE_VALUE);
        hashMap.put("version", "1.0");
        hashMap.put("logid", yU());
        a(m.a(hashMap, apD[this.apC % apD.length], new k() { // from class: com.baidu.tbadk.core.hybrid.q.1
            @Override // com.baidu.tbadk.core.hybrid.k
            public void a(m mVar, JSONObject jSONObject) {
                q.this.a(mVar, i);
            }

            @Override // com.baidu.tbadk.core.hybrid.k
            public void b(int i2, Throwable th) {
                if (i2 == 1) {
                    if (i < q.apF.length) {
                        q.this.yV();
                    }
                    if (i >= 0 && i < q.apF.length) {
                        q.this.ac(String.valueOf(q.apF[i]), "");
                        return;
                    }
                    BdLog.e("pingIndex " + i + " out of bounds.");
                    e.m(q.this.yU(), "103", "ping timeout for index " + i);
                }
            }
        }), true);
        ac("100", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, int i) {
        this.status = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i >= 0 && i < apE.length) {
            ac(String.valueOf(apE[i]), String.valueOf(currentTimeMillis - mVar.apu));
        } else {
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.i
    public void dX(String str) {
        if (TextUtils.isEmpty(str)) {
            e.dW("invalid callbackId.");
            return;
        }
        m remove = this.aoT.remove(str);
        if (remove != null) {
            e.dW("(" + remove.cmd + ", " + remove.method + ", " + str + ") timeout.");
            remove.b(1, (Throwable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ea(String str) {
        this.apC = -1;
        if (this.status != 2 && this.status != 1) {
            e.dW("current status " + this.status + ", broken because url changed to " + str);
            this.status = 2;
        }
        if (p.dY(str) && p.dZ(str)) {
            e.dW("current status " + this.status + ", constructing bridge for " + str);
            if (this.apn != null) {
                this.apn.yH();
            }
            b(this.apm);
            if (this.apn != null) {
                this.apn.yI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String Z(String str, String str2) {
        e.dW("got js prompt in url:" + str + " with content:" + str2);
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
                e.m(yU(), "105", "invalid message type " + optString);
            }
            return null;
        } catch (JSONException e) {
            e.m(yU(), "109", e.getMessage());
            return null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void init() {
        if (this.status != -1) {
            throw new IllegalStateException("Can't init bridge more than once.");
        }
        this.apm.getSettings().setJavaScriptEnabled(true);
        this.apm.setWebViewClient(this.apy);
        this.apm.setWebChromeClient(this.apz);
        this.apm.removeJavascriptInterface("searchBoxJavaBridge_");
        this.status = 1;
    }

    private void a(m mVar, boolean z) {
        if (!z) {
            if (this.status != 0) {
                e.m(yU(), "101", "(" + mVar.cmd + ", " + mVar.method + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(mVar.cmd) || TextUtils.isEmpty(mVar.method)) {
                e.m(yU(), "102", "the alias class or method is empty");
                mVar.b(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(mVar.aps)) {
            if (mVar.type != 3) {
                this.aoT.put(mVar.aps, mVar);
                if (mVar.apt > 0) {
                    this.apA.sendMessageDelayed(Message.obtain(this.apA, 2, mVar.aps), mVar.apt);
                } else if (mVar.cmd != null || mVar.method != null) {
                    e.dW("ignore timeout check for method call (" + mVar.cmd + ", " + mVar.method + ").");
                }
            } else {
                e.dW("ignore timeout check for response method, callbackId " + mVar.aps);
            }
        }
        try {
            String yR = mVar.yR();
            if (Build.VERSION.SDK_INT >= 19) {
                this.apm.evaluateJavascript(yR, null);
            } else {
                this.apm.loadUrl(yR);
            }
            e.dW(yR);
        } catch (NullPointerException e) {
            ac("500", e.getMessage());
        } catch (JSONException e2) {
            if (z) {
                ac("102", e2.getMessage());
            } else {
                e.dW(e2.getMessage());
            }
            mVar.b(2, e2);
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.status != 0) {
            e.m(yU(), "106", "bridge is not ready");
        }
        h hVar = this.apB.get(str);
        if (hVar == null) {
            hVar = new b(this, str);
            e.m(yU(), "107", "cmd " + str + " not found");
        }
        hVar.a(str2, jSONObject, jSONObject2);
    }

    private void f(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.dW("invalid callbackId.");
            return;
        }
        this.apA.removeMessages(2, str);
        m remove = this.aoT.remove(str);
        if (remove != null) {
            remove.w(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String yU() {
        return this.logId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(String str, String str2) {
        e.l(yU(), str, str2);
    }

    private void b(WebView webView) {
        this.logId = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder yW = yW();
            yW.append(new String(bArr));
            webView.loadUrl("javascript:" + yW.toString());
            this.apA.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            ac("102", th.getMessage());
            e.dW(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yV() {
        e.dW("reInject for pingIndex " + this.apC);
        b(this.apm);
    }

    private StringBuilder yW() throws JSONException {
        StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", HttpConstants.OS_TYPE_VALUE);
        jSONObject.put("version", "1.0");
        jSONObject.put("logid", yU());
        sb.append(jSONObject.toString());
        sb.append(';');
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Handler {
        private final WeakReference<i> apH;

        public c(i iVar) {
            this.apH = new WeakReference<>(iVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i iVar = this.apH.get();
            if (iVar == null) {
                e.dW("TimeHandler got null bridge reference.");
                return;
            }
            switch (message.what) {
                case 1:
                    iVar.yP();
                    return;
                case 2:
                    iVar.dX((String) message.obj);
                    return;
                default:
                    throw new IllegalArgumentException("Invalid message.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements h {
        private final l aoS;
        private final String cmd;

        protected b(l lVar, String str) {
            this.aoS = lVar;
            this.cmd = str;
        }

        @Override // com.baidu.tbadk.core.hybrid.h
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            String optString = jSONObject2.optString(WBConstants.SHARE_CALLBACK_ID);
            if (TextUtils.isEmpty(optString)) {
                e.dW("scope " + this.cmd + " not found!");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", "107");
            hashMap.put("errMsg", "cmd " + this.cmd + " not found");
            this.aoS.a(m.d(optString, hashMap));
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
