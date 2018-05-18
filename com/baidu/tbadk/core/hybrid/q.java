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
import com.baidu.ar.util.Constants;
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
    private static final int[] aeT = {TbConfig.POST_IMAGE_SMALL, 2000, 3500, 4600, 6000, 8000};
    private static final int[] aeU = {201, 202, HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION};
    private static final int[] aeV = {HttpStatus.SC_NOT_IMPLEMENTED, HttpStatus.SC_BAD_GATEWAY, HttpStatus.SC_SERVICE_UNAVAILABLE};
    private final f aeO;
    private final com.baidu.tbadk.core.hybrid.c aeP;
    private final c aeQ;
    private final HashMap<String, h> aeR;
    private int aeS;
    private final HashMap<String, m> ael;
    private String logId;
    private int status;

    private q(WebView webView, com.baidu.tbadk.core.hybrid.b bVar) {
        this(webView, new f(), new com.baidu.tbadk.core.hybrid.c(), bVar);
    }

    private q(WebView webView, f fVar, com.baidu.tbadk.core.hybrid.c cVar, com.baidu.tbadk.core.hybrid.b bVar) {
        super(webView, bVar);
        this.logId = String.valueOf(System.currentTimeMillis());
        this.status = -1;
        this.aeS = -1;
        this.aeO = fVar;
        this.aeP = cVar;
        this.aeP.a(this);
        this.aeO.a(this);
        this.aeQ = new c(this);
        this.aeR = new HashMap<>(16);
        this.ael = new HashMap<>(8);
        init();
    }

    public static l a(boolean z, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(webView);
        }
        q qVar = new q(webView, bVar);
        qVar.aeO.a(webViewClient);
        qVar.aeP.a(webChromeClient);
        return qVar;
    }

    public static l a(boolean z, BridgeWebView bridgeWebView, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(bridgeWebView);
        }
        WebViewClient webViewClient = bridgeWebView.webViewClient;
        WebChromeClient webChromeClient = bridgeWebView.chromeClient;
        q qVar = new q(bridgeWebView, bVar);
        qVar.aeO.a(webViewClient);
        qVar.aeP.a(webChromeClient);
        return qVar;
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void a(String str, d dVar) {
        if (this.aeR.put(str, dVar) != null) {
            throw new IllegalArgumentException("handler " + str + " exists.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void a(m mVar) {
        a(mVar, mVar.type == 3);
    }

    @Override // com.baidu.tbadk.core.hybrid.i
    public void ug() {
        this.aeS++;
        final int i = this.aeS;
        HashMap hashMap = new HashMap();
        hashMap.put("platform", Constants.OS_TYPE_VALUE);
        hashMap.put("version", "1.0");
        hashMap.put("logid", ul());
        a(m.a(hashMap, aeT[this.aeS % aeT.length], new k() { // from class: com.baidu.tbadk.core.hybrid.q.1
            @Override // com.baidu.tbadk.core.hybrid.k
            public void a(m mVar, JSONObject jSONObject) {
                q.this.a(mVar, i);
            }

            @Override // com.baidu.tbadk.core.hybrid.k
            public void b(int i2, Throwable th) {
                if (i2 == 1) {
                    if (i < q.aeV.length) {
                        q.this.um();
                    }
                    if (i >= 0 && i < q.aeV.length) {
                        q.this.T(String.valueOf(q.aeV[i]), "");
                        return;
                    }
                    BdLog.e("pingIndex " + i + " out of bounds.");
                    e.l(q.this.ul(), "103", "ping timeout for index " + i);
                }
            }
        }), true);
        T("100", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, int i) {
        this.status = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i >= 0 && i < aeU.length) {
            T(String.valueOf(aeU[i]), String.valueOf(currentTimeMillis - mVar.start));
        } else {
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.i
    public void dg(String str) {
        if (TextUtils.isEmpty(str)) {
            e.df("invalid callbackId.");
            return;
        }
        m remove = this.ael.remove(str);
        if (remove != null) {
            e.df("(" + remove.cmd + ", " + remove.method + ", " + str + ") timeout.");
            remove.b(1, (Throwable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dj(String str) {
        this.aeS = -1;
        if (this.status != 2 && this.status != 1) {
            e.df("current status " + this.status + ", broken because url changed to " + str);
            this.status = 2;
        }
        if (p.dh(str) && p.di(str)) {
            e.df("current status " + this.status + ", constructing bridge for " + str);
            if (this.aeF != null) {
                this.aeF.tY();
            }
            b(this.aeE);
            if (this.aeF != null) {
                this.aeF.tZ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String Q(String str, String str2) {
        e.df("got js prompt in url:" + str + " with content:" + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString("messageType");
            if ("ping".equals(optString)) {
                c(jSONObject.optString("callbackId"), jSONObject.optJSONObject("outputData"));
            } else if ("request".equals(optString)) {
                a(jSONObject.optString(IntentConfig.CMD), jSONObject.optString("method"), jSONObject.optJSONObject("inputData"), jSONObject);
            } else if ("response".equals(optString)) {
                c(jSONObject.optString("callbackId"), jSONObject.optJSONObject("outputData"));
            } else {
                e.l(ul(), "105", "invalid message type " + optString);
            }
            return null;
        } catch (JSONException e) {
            e.l(ul(), "109", e.getMessage());
            return null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void init() {
        if (this.status != -1) {
            throw new IllegalStateException("Can't init bridge more than once.");
        }
        this.aeE.getSettings().setJavaScriptEnabled(true);
        this.aeE.setWebViewClient(this.aeO);
        this.aeE.setWebChromeClient(this.aeP);
        this.aeE.removeJavascriptInterface("searchBoxJavaBridge_");
        this.status = 1;
    }

    private void a(m mVar, boolean z) {
        if (!z) {
            if (this.status != 0) {
                e.l(ul(), "101", "(" + mVar.cmd + ", " + mVar.method + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(mVar.cmd) || TextUtils.isEmpty(mVar.method)) {
                e.l(ul(), "102", "the alias class or method is empty");
                mVar.b(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(mVar.aeJ)) {
            if (mVar.type != 3) {
                this.ael.put(mVar.aeJ, mVar);
                if (mVar.aeK > 0) {
                    this.aeQ.sendMessageDelayed(Message.obtain(this.aeQ, 2, mVar.aeJ), mVar.aeK);
                } else if (mVar.cmd != null || mVar.method != null) {
                    e.df("ignore timeout check for method call (" + mVar.cmd + ", " + mVar.method + ").");
                }
            } else {
                e.df("ignore timeout check for response method, callbackId " + mVar.aeJ);
            }
        }
        try {
            String ui = mVar.ui();
            if (Build.VERSION.SDK_INT >= 19) {
                this.aeE.evaluateJavascript(ui, null);
            } else {
                this.aeE.loadUrl(ui);
            }
            e.df(ui);
        } catch (NullPointerException e) {
            T("500", e.getMessage());
        } catch (JSONException e2) {
            if (z) {
                T("102", e2.getMessage());
            } else {
                e.df(e2.getMessage());
            }
            mVar.b(2, e2);
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.status != 0) {
            e.l(ul(), "106", "bridge is not ready");
        }
        h hVar = this.aeR.get(str);
        if (hVar == null) {
            hVar = new b(this, str);
            e.l(ul(), "107", "cmd " + str + " not found");
        }
        hVar.a(str2, jSONObject, jSONObject2);
    }

    private void c(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.df("invalid callbackId.");
            return;
        }
        this.aeQ.removeMessages(2, str);
        m remove = this.ael.remove(str);
        if (remove != null) {
            remove.m(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ul() {
        return this.logId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(String str, String str2) {
        e.k(ul(), str, str2);
    }

    private void b(WebView webView) {
        this.logId = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder un = un();
            un.append(new String(bArr));
            webView.loadUrl("javascript:" + un.toString());
            this.aeQ.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            T("102", th.getMessage());
            e.df(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void um() {
        e.df("reInject for pingIndex " + this.aeS);
        b(this.aeE);
    }

    private StringBuilder un() throws JSONException {
        StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", Constants.OS_TYPE_VALUE);
        jSONObject.put("version", "1.0");
        jSONObject.put("logid", ul());
        sb.append(jSONObject.toString());
        sb.append(';');
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Handler {
        private final WeakReference<i> aeX;

        public c(i iVar) {
            this.aeX = new WeakReference<>(iVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i iVar = this.aeX.get();
            if (iVar == null) {
                e.df("TimeHandler got null bridge reference.");
                return;
            }
            switch (message.what) {
                case 1:
                    iVar.ug();
                    return;
                case 2:
                    iVar.dg((String) message.obj);
                    return;
                default:
                    throw new IllegalArgumentException("Invalid message.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements h {
        private final l aek;
        private final String cmd;

        protected b(l lVar, String str) {
            this.aek = lVar;
            this.cmd = str;
        }

        @Override // com.baidu.tbadk.core.hybrid.h
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            String optString = jSONObject2.optString("callbackId");
            if (TextUtils.isEmpty(optString)) {
                e.df("scope " + this.cmd + " not found!");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", "107");
            hashMap.put("errMsg", "cmd " + this.cmd + " not found");
            this.aek.a(m.c(optString, hashMap));
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
