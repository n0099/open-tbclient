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
import com.baidu.android.imsdk.chatmessage.sync.SyncStrategy;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.coloros.mcssdk.PushManager;
import com.sina.weibo.sdk.constant.WBConstants;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q extends l implements i {
    private static final int[] cgA = {1500, 2000, 3500, 4600, SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME, 8000};
    private static final int[] cgB = {201, 202, 203};
    private static final int[] cgC = {501, 502, 503};
    private final HashMap<String, m> cfQ;
    private final f cgu;
    private final com.baidu.tbadk.core.hybrid.c cgv;
    private final c cgw;
    private final HashMap<String, h> cgx;
    private String cgy;
    private int cgz;
    private int status;

    private q(WebView webView, com.baidu.tbadk.core.hybrid.b bVar) {
        this(webView, new f(), new com.baidu.tbadk.core.hybrid.c(), bVar);
    }

    private q(WebView webView, f fVar, com.baidu.tbadk.core.hybrid.c cVar, com.baidu.tbadk.core.hybrid.b bVar) {
        super(webView, bVar);
        this.cgy = String.valueOf(System.currentTimeMillis());
        this.status = -1;
        this.cgz = -1;
        this.cgu = fVar;
        this.cgv = cVar;
        this.cgv.a(this);
        this.cgu.a(this);
        this.cgw = new c(this);
        this.cgx = new HashMap<>(16);
        this.cfQ = new HashMap<>(8);
        init();
    }

    public static l a(boolean z, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(webView);
        }
        q qVar = new q(webView, bVar);
        qVar.cgu.b(webViewClient);
        qVar.cgv.b(webChromeClient);
        return qVar;
    }

    public static l a(boolean z, BridgeWebView bridgeWebView, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(bridgeWebView);
        }
        WebViewClient webViewClient = bridgeWebView.webViewClient;
        WebChromeClient webChromeClient = bridgeWebView.chromeClient;
        q qVar = new q(bridgeWebView, bVar);
        qVar.cgu.b(webViewClient);
        qVar.cgv.b(webChromeClient);
        return qVar;
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void a(String str, d dVar) {
        if (this.cgx.put(str, dVar) != null) {
            throw new IllegalArgumentException("handler " + str + " exists.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void a(m mVar) {
        a(mVar, mVar.type == 3);
    }

    @Override // com.baidu.tbadk.core.hybrid.i
    public void alx() {
        this.cgz++;
        final int i = this.cgz;
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "android");
        hashMap.put("version", "1.0");
        hashMap.put("logid", alC());
        a(m.a(hashMap, cgA[this.cgz % cgA.length], new k() { // from class: com.baidu.tbadk.core.hybrid.q.1
            @Override // com.baidu.tbadk.core.hybrid.k
            public void a(m mVar, JSONObject jSONObject) {
                q.this.a(mVar, i);
            }

            @Override // com.baidu.tbadk.core.hybrid.k
            public void b(int i2, Throwable th) {
                if (i2 == 1) {
                    if (i < q.cgC.length) {
                        q.this.alD();
                    }
                    if (i >= 0 && i < q.cgC.length) {
                        q.this.bO(String.valueOf(q.cgC[i]), "");
                        return;
                    }
                    BdLog.e("pingIndex " + i + " out of bounds.");
                    e.I(q.this.alC(), TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY, "ping timeout for index " + i);
                }
            }
        }), true);
        bO("100", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, int i) {
        this.status = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i >= 0 && i < cgB.length) {
            bO(String.valueOf(cgB[i]), String.valueOf(currentTimeMillis - mVar.bCV));
        } else {
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.i
    public void nt(String str) {
        if (TextUtils.isEmpty(str)) {
            e.ns("invalid callbackId.");
            return;
        }
        m remove = this.cfQ.remove(str);
        if (remove != null) {
            e.ns("(" + remove.cmd + ", " + remove.method + ", " + str + ") timeout.");
            remove.b(1, (Throwable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nw(String str) {
        this.cgz = -1;
        if (this.status != 2 && this.status != 1) {
            e.ns("current status " + this.status + ", broken because url changed to " + str);
            this.status = 2;
        }
        if (p.nu(str) && p.nv(str)) {
            e.ns("current status " + this.status + ", constructing bridge for " + str);
            if (this.cgl != null) {
                this.cgl.alp();
            }
            b(this.cgk);
            if (this.cgl != null) {
                this.cgl.alq();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String bL(String str, String str2) {
        e.ns("got js prompt in url:" + str + " with content:" + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString(PushManager.MESSAGE_TYPE);
            if ("ping".equals(optString)) {
                n(jSONObject.optString(WBConstants.SHARE_CALLBACK_ID), jSONObject.optJSONObject("outputData"));
            } else if ("request".equals(optString)) {
                a(jSONObject.optString("cmd"), jSONObject.optString("method"), jSONObject.optJSONObject("inputData"), jSONObject);
            } else if ("response".equals(optString)) {
                n(jSONObject.optString(WBConstants.SHARE_CALLBACK_ID), jSONObject.optJSONObject("outputData"));
            } else {
                e.I(alC(), TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN, "invalid message type " + optString);
            }
            return null;
        } catch (JSONException e) {
            e.I(alC(), TbEnum.SystemMessage.EVENT_ID_INVITE_GROUP, e.getMessage());
            return null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void init() {
        if (this.status != -1) {
            throw new IllegalStateException("Can't init bridge more than once.");
        }
        this.cgk.getSettings().setJavaScriptEnabled(true);
        this.cgk.setWebViewClient(this.cgu);
        this.cgk.setWebChromeClient(this.cgv);
        this.cgk.removeJavascriptInterface("searchBoxJavaBridge_");
        this.status = 1;
    }

    private void a(m mVar, boolean z) {
        if (!z) {
            if (this.status != 0) {
                e.I(alC(), TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY, "(" + mVar.cmd + ", " + mVar.method + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(mVar.cmd) || TextUtils.isEmpty(mVar.method)) {
                e.I(alC(), TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY, "the alias class or method is empty");
                mVar.b(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(mVar.cgp)) {
            if (mVar.type != 3) {
                this.cfQ.put(mVar.cgp, mVar);
                if (mVar.cgq > 0) {
                    this.cgw.sendMessageDelayed(Message.obtain(this.cgw, 2, mVar.cgp), mVar.cgq);
                } else if (mVar.cmd != null || mVar.method != null) {
                    e.ns("ignore timeout check for method call (" + mVar.cmd + ", " + mVar.method + ").");
                }
            } else {
                e.ns("ignore timeout check for response method, callbackId " + mVar.cgp);
            }
        }
        try {
            String alz = mVar.alz();
            if (Build.VERSION.SDK_INT >= 19) {
                this.cgk.evaluateJavascript(alz, null);
            } else {
                this.cgk.loadUrl(alz);
            }
            e.ns(alz);
        } catch (NullPointerException e) {
            bO("500", e.getMessage());
        } catch (JSONException e2) {
            if (z) {
                bO(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY, e2.getMessage());
            } else {
                e.ns(e2.getMessage());
            }
            mVar.b(2, e2);
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.status != 0) {
            e.I(alC(), TbEnum.SystemMessage.EVENT_ID_GROUP_QUIT, "bridge is not ready");
        }
        h hVar = this.cgx.get(str);
        if (hVar == null) {
            hVar = new b(this, str);
            e.I(alC(), TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP, "cmd " + str + " not found");
        }
        hVar.a(str2, jSONObject, jSONObject2);
    }

    private void n(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.ns("invalid callbackId.");
            return;
        }
        this.cgw.removeMessages(2, str);
        m remove = this.cfQ.remove(str);
        if (remove != null) {
            remove.bv(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String alC() {
        return this.cgy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bO(String str, String str2) {
        e.H(alC(), str, str2);
    }

    private void b(WebView webView) {
        this.cgy = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder alE = alE();
            alE.append(new String(bArr));
            webView.loadUrl("javascript:" + alE.toString());
            this.cgw.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            bO(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY, th.getMessage());
            e.ns(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alD() {
        e.ns("reInject for pingIndex " + this.cgz);
        b(this.cgk);
    }

    private StringBuilder alE() throws JSONException {
        StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", "android");
        jSONObject.put("version", "1.0");
        jSONObject.put("logid", alC());
        sb.append(jSONObject.toString());
        sb.append(';');
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Handler {
        private final WeakReference<i> cgE;

        public c(i iVar) {
            this.cgE = new WeakReference<>(iVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i iVar = this.cgE.get();
            if (iVar == null) {
                e.ns("TimeHandler got null bridge reference.");
                return;
            }
            switch (message.what) {
                case 1:
                    iVar.alx();
                    return;
                case 2:
                    iVar.nt((String) message.obj);
                    return;
                default:
                    throw new IllegalArgumentException("Invalid message.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements h {
        private final l cfP;
        private final String cmd;

        protected b(l lVar, String str) {
            this.cfP = lVar;
            this.cmd = str;
        }

        @Override // com.baidu.tbadk.core.hybrid.h
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            String optString = jSONObject2.optString(WBConstants.SHARE_CALLBACK_ID);
            if (TextUtils.isEmpty(optString)) {
                e.ns("scope " + this.cmd + " not found!");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP);
            hashMap.put("errMsg", "cmd " + this.cmd + " not found");
            this.cfP.a(m.h(optString, hashMap));
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
