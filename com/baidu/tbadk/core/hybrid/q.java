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
    private static final int[] avh = {TbConfig.POST_IMAGE_SMALL, 2000, 3500, 4600, 6000, 8000};
    private static final int[] avi = {201, 202, 203};
    private static final int[] avj = {501, 502, 503};
    private final HashMap<String, m> auy;
    private final f avc;
    private final com.baidu.tbadk.core.hybrid.c avd;
    private final c ave;
    private final HashMap<String, h> avf;
    private int avg;
    private String logId;
    private int status;

    private q(WebView webView, com.baidu.tbadk.core.hybrid.b bVar) {
        this(webView, new f(), new com.baidu.tbadk.core.hybrid.c(), bVar);
    }

    private q(WebView webView, f fVar, com.baidu.tbadk.core.hybrid.c cVar, com.baidu.tbadk.core.hybrid.b bVar) {
        super(webView, bVar);
        this.logId = String.valueOf(System.currentTimeMillis());
        this.status = -1;
        this.avg = -1;
        this.avc = fVar;
        this.avd = cVar;
        this.avd.a(this);
        this.avc.a(this);
        this.ave = new c(this);
        this.avf = new HashMap<>(16);
        this.auy = new HashMap<>(8);
        init();
    }

    public static l a(boolean z, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(webView);
        }
        q qVar = new q(webView, bVar);
        qVar.avc.a(webViewClient);
        qVar.avd.a(webChromeClient);
        return qVar;
    }

    public static l a(boolean z, BridgeWebView bridgeWebView, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(bridgeWebView);
        }
        WebViewClient webViewClient = bridgeWebView.webViewClient;
        WebChromeClient webChromeClient = bridgeWebView.chromeClient;
        q qVar = new q(bridgeWebView, bVar);
        qVar.avc.a(webViewClient);
        qVar.avd.a(webChromeClient);
        return qVar;
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void a(String str, d dVar) {
        if (this.avf.put(str, dVar) != null) {
            throw new IllegalArgumentException("handler " + str + " exists.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void a(m mVar) {
        a(mVar, mVar.type == 3);
    }

    @Override // com.baidu.tbadk.core.hybrid.i
    public void Be() {
        this.avg++;
        final int i = this.avg;
        HashMap hashMap = new HashMap();
        hashMap.put("platform", HttpConstants.OS_TYPE_VALUE);
        hashMap.put("version", "1.0");
        hashMap.put("logid", Bj());
        a(m.a(hashMap, avh[this.avg % avh.length], new k() { // from class: com.baidu.tbadk.core.hybrid.q.1
            @Override // com.baidu.tbadk.core.hybrid.k
            public void a(m mVar, JSONObject jSONObject) {
                q.this.a(mVar, i);
            }

            @Override // com.baidu.tbadk.core.hybrid.k
            public void b(int i2, Throwable th) {
                if (i2 == 1) {
                    if (i < q.avj.length) {
                        q.this.Bk();
                    }
                    if (i >= 0 && i < q.avj.length) {
                        q.this.ap(String.valueOf(q.avj[i]), "");
                        return;
                    }
                    BdLog.e("pingIndex " + i + " out of bounds.");
                    e.p(q.this.Bj(), "103", "ping timeout for index " + i);
                }
            }
        }), true);
        ap("100", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, int i) {
        this.status = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i >= 0 && i < avi.length) {
            ap(String.valueOf(avi[i]), String.valueOf(currentTimeMillis - mVar.auY));
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
        m remove = this.auy.remove(str);
        if (remove != null) {
            e.em("(" + remove.cmd + ", " + remove.method + ", " + str + ") timeout.");
            remove.b(1, (Throwable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eq(String str) {
        this.avg = -1;
        if (this.status != 2 && this.status != 1) {
            e.em("current status " + this.status + ", broken because url changed to " + str);
            this.status = 2;
        }
        if (p.eo(str) && p.ep(str)) {
            e.em("current status " + this.status + ", constructing bridge for " + str);
            if (this.auS != null) {
                this.auS.AW();
            }
            b(this.auR);
            if (this.auS != null) {
                this.auS.AX();
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
                e.p(Bj(), "105", "invalid message type " + optString);
            }
            return null;
        } catch (JSONException e) {
            e.p(Bj(), "109", e.getMessage());
            return null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void init() {
        if (this.status != -1) {
            throw new IllegalStateException("Can't init bridge more than once.");
        }
        this.auR.getSettings().setJavaScriptEnabled(true);
        this.auR.setWebViewClient(this.avc);
        this.auR.setWebChromeClient(this.avd);
        this.auR.removeJavascriptInterface("searchBoxJavaBridge_");
        this.status = 1;
    }

    private void a(m mVar, boolean z) {
        if (!z) {
            if (this.status != 0) {
                e.p(Bj(), "101", "(" + mVar.cmd + ", " + mVar.method + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(mVar.cmd) || TextUtils.isEmpty(mVar.method)) {
                e.p(Bj(), "102", "the alias class or method is empty");
                mVar.b(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(mVar.auW)) {
            if (mVar.type != 3) {
                this.auy.put(mVar.auW, mVar);
                if (mVar.auX > 0) {
                    this.ave.sendMessageDelayed(Message.obtain(this.ave, 2, mVar.auW), mVar.auX);
                } else if (mVar.cmd != null || mVar.method != null) {
                    e.em("ignore timeout check for method call (" + mVar.cmd + ", " + mVar.method + ").");
                }
            } else {
                e.em("ignore timeout check for response method, callbackId " + mVar.auW);
            }
        }
        try {
            String Bg = mVar.Bg();
            if (Build.VERSION.SDK_INT >= 19) {
                this.auR.evaluateJavascript(Bg, null);
            } else {
                this.auR.loadUrl(Bg);
            }
            e.em(Bg);
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
            e.p(Bj(), "106", "bridge is not ready");
        }
        h hVar = this.avf.get(str);
        if (hVar == null) {
            hVar = new b(this, str);
            e.p(Bj(), "107", "cmd " + str + " not found");
        }
        hVar.a(str2, jSONObject, jSONObject2);
    }

    private void f(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.em("invalid callbackId.");
            return;
        }
        this.ave.removeMessages(2, str);
        m remove = this.auy.remove(str);
        if (remove != null) {
            remove.z(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Bj() {
        return this.logId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(String str, String str2) {
        e.o(Bj(), str, str2);
    }

    private void b(WebView webView) {
        this.logId = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder Bl = Bl();
            Bl.append(new String(bArr));
            webView.loadUrl("javascript:" + Bl.toString());
            this.ave.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            ap("102", th.getMessage());
            e.em(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bk() {
        e.em("reInject for pingIndex " + this.avg);
        b(this.auR);
    }

    private StringBuilder Bl() throws JSONException {
        StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", HttpConstants.OS_TYPE_VALUE);
        jSONObject.put("version", "1.0");
        jSONObject.put("logid", Bj());
        sb.append(jSONObject.toString());
        sb.append(';');
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Handler {
        private final WeakReference<i> avl;

        public c(i iVar) {
            this.avl = new WeakReference<>(iVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i iVar = this.avl.get();
            if (iVar == null) {
                e.em("TimeHandler got null bridge reference.");
                return;
            }
            switch (message.what) {
                case 1:
                    iVar.Be();
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
        private final l aux;
        private final String cmd;

        protected b(l lVar, String str) {
            this.aux = lVar;
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
            this.aux.a(m.e(optString, hashMap));
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
