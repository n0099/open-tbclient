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
    private static final int[] auu = {TbConfig.POST_IMAGE_SMALL, 2000, 3500, 4600, 6000, 8000};
    private static final int[] auv = {201, 202, 203};
    private static final int[] auw = {501, 502, 503};
    private final HashMap<String, m> atL;
    private final f aup;
    private final com.baidu.tbadk.core.hybrid.c auq;
    private final c aur;
    private final HashMap<String, h> aus;
    private int aut;
    private String logId;
    private int status;

    private q(WebView webView, com.baidu.tbadk.core.hybrid.b bVar) {
        this(webView, new f(), new com.baidu.tbadk.core.hybrid.c(), bVar);
    }

    private q(WebView webView, f fVar, com.baidu.tbadk.core.hybrid.c cVar, com.baidu.tbadk.core.hybrid.b bVar) {
        super(webView, bVar);
        this.logId = String.valueOf(System.currentTimeMillis());
        this.status = -1;
        this.aut = -1;
        this.aup = fVar;
        this.auq = cVar;
        this.auq.a(this);
        this.aup.a(this);
        this.aur = new c(this);
        this.aus = new HashMap<>(16);
        this.atL = new HashMap<>(8);
        init();
    }

    public static l a(boolean z, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(webView);
        }
        q qVar = new q(webView, bVar);
        qVar.aup.a(webViewClient);
        qVar.auq.a(webChromeClient);
        return qVar;
    }

    public static l a(boolean z, BridgeWebView bridgeWebView, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(bridgeWebView);
        }
        WebViewClient webViewClient = bridgeWebView.webViewClient;
        WebChromeClient webChromeClient = bridgeWebView.chromeClient;
        q qVar = new q(bridgeWebView, bVar);
        qVar.aup.a(webViewClient);
        qVar.auq.a(webChromeClient);
        return qVar;
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void a(String str, d dVar) {
        if (this.aus.put(str, dVar) != null) {
            throw new IllegalArgumentException("handler " + str + " exists.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void a(m mVar) {
        a(mVar, mVar.type == 3);
    }

    @Override // com.baidu.tbadk.core.hybrid.i
    public void AX() {
        this.aut++;
        final int i = this.aut;
        HashMap hashMap = new HashMap();
        hashMap.put("platform", HttpConstants.OS_TYPE_VALUE);
        hashMap.put("version", "1.0");
        hashMap.put("logid", Bc());
        a(m.a(hashMap, auu[this.aut % auu.length], new k() { // from class: com.baidu.tbadk.core.hybrid.q.1
            @Override // com.baidu.tbadk.core.hybrid.k
            public void a(m mVar, JSONObject jSONObject) {
                q.this.a(mVar, i);
            }

            @Override // com.baidu.tbadk.core.hybrid.k
            public void b(int i2, Throwable th) {
                if (i2 == 1) {
                    if (i < q.auw.length) {
                        q.this.Bd();
                    }
                    if (i >= 0 && i < q.auw.length) {
                        q.this.ap(String.valueOf(q.auw[i]), "");
                        return;
                    }
                    BdLog.e("pingIndex " + i + " out of bounds.");
                    e.p(q.this.Bc(), "103", "ping timeout for index " + i);
                }
            }
        }), true);
        ap("100", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, int i) {
        this.status = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i >= 0 && i < auv.length) {
            ap(String.valueOf(auv[i]), String.valueOf(currentTimeMillis - mVar.aul));
        } else {
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.i
    public void en(String str) {
        if (TextUtils.isEmpty(str)) {
            e.em("invalid callbackId.");
            return;
        }
        m remove = this.atL.remove(str);
        if (remove != null) {
            e.em("(" + remove.cmd + ", " + remove.method + ", " + str + ") timeout.");
            remove.b(1, (Throwable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eq(String str) {
        this.aut = -1;
        if (this.status != 2 && this.status != 1) {
            e.em("current status " + this.status + ", broken because url changed to " + str);
            this.status = 2;
        }
        if (p.eo(str) && p.ep(str)) {
            e.em("current status " + this.status + ", constructing bridge for " + str);
            if (this.auf != null) {
                this.auf.AP();
            }
            b(this.aue);
            if (this.auf != null) {
                this.auf.AQ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String am(String str, String str2) {
        e.em("got js prompt in url:" + str + " with content:" + str2);
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
                e.p(Bc(), "105", "invalid message type " + optString);
            }
            return null;
        } catch (JSONException e) {
            e.p(Bc(), "109", e.getMessage());
            return null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void init() {
        if (this.status != -1) {
            throw new IllegalStateException("Can't init bridge more than once.");
        }
        this.aue.getSettings().setJavaScriptEnabled(true);
        this.aue.setWebViewClient(this.aup);
        this.aue.setWebChromeClient(this.auq);
        this.aue.removeJavascriptInterface("searchBoxJavaBridge_");
        this.status = 1;
    }

    private void a(m mVar, boolean z) {
        if (!z) {
            if (this.status != 0) {
                e.p(Bc(), "101", "(" + mVar.cmd + ", " + mVar.method + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(mVar.cmd) || TextUtils.isEmpty(mVar.method)) {
                e.p(Bc(), "102", "the alias class or method is empty");
                mVar.b(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(mVar.auj)) {
            if (mVar.type != 3) {
                this.atL.put(mVar.auj, mVar);
                if (mVar.auk > 0) {
                    this.aur.sendMessageDelayed(Message.obtain(this.aur, 2, mVar.auj), mVar.auk);
                } else if (mVar.cmd != null || mVar.method != null) {
                    e.em("ignore timeout check for method call (" + mVar.cmd + ", " + mVar.method + ").");
                }
            } else {
                e.em("ignore timeout check for response method, callbackId " + mVar.auj);
            }
        }
        try {
            String AZ = mVar.AZ();
            if (Build.VERSION.SDK_INT >= 19) {
                this.aue.evaluateJavascript(AZ, null);
            } else {
                this.aue.loadUrl(AZ);
            }
            e.em(AZ);
        } catch (NullPointerException e) {
            ap("500", e.getMessage());
        } catch (JSONException e2) {
            if (z) {
                ap("102", e2.getMessage());
            } else {
                e.em(e2.getMessage());
            }
            mVar.b(2, e2);
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.status != 0) {
            e.p(Bc(), "106", "bridge is not ready");
        }
        h hVar = this.aus.get(str);
        if (hVar == null) {
            hVar = new b(this, str);
            e.p(Bc(), "107", "cmd " + str + " not found");
        }
        hVar.a(str2, jSONObject, jSONObject2);
    }

    private void f(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.em("invalid callbackId.");
            return;
        }
        this.aur.removeMessages(2, str);
        m remove = this.atL.remove(str);
        if (remove != null) {
            remove.z(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Bc() {
        return this.logId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(String str, String str2) {
        e.o(Bc(), str, str2);
    }

    private void b(WebView webView) {
        this.logId = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder Be = Be();
            Be.append(new String(bArr));
            webView.loadUrl("javascript:" + Be.toString());
            this.aur.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            ap("102", th.getMessage());
            e.em(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bd() {
        e.em("reInject for pingIndex " + this.aut);
        b(this.aue);
    }

    private StringBuilder Be() throws JSONException {
        StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", HttpConstants.OS_TYPE_VALUE);
        jSONObject.put("version", "1.0");
        jSONObject.put("logid", Bc());
        sb.append(jSONObject.toString());
        sb.append(';');
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Handler {
        private final WeakReference<i> auy;

        public c(i iVar) {
            this.auy = new WeakReference<>(iVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i iVar = this.auy.get();
            if (iVar == null) {
                e.em("TimeHandler got null bridge reference.");
                return;
            }
            switch (message.what) {
                case 1:
                    iVar.AX();
                    return;
                case 2:
                    iVar.en((String) message.obj);
                    return;
                default:
                    throw new IllegalArgumentException("Invalid message.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements h {
        private final l atK;
        private final String cmd;

        protected b(l lVar, String str) {
            this.atK = lVar;
            this.cmd = str;
        }

        @Override // com.baidu.tbadk.core.hybrid.h
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            String optString = jSONObject2.optString(WBConstants.SHARE_CALLBACK_ID);
            if (TextUtils.isEmpty(optString)) {
                e.em("scope " + this.cmd + " not found!");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", "107");
            hashMap.put("errMsg", "cmd " + this.cmd + " not found");
            this.atK.a(m.e(optString, hashMap));
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
