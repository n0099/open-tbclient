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
import com.baidu.down.common.intercepter.IIntercepter;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.searchbox.ui.animview.praise.PraiseDataPassUtil;
import com.coloros.mcssdk.PushManager;
import com.sina.weibo.sdk.constant.WBConstants;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q extends l implements i {
    private static final int[] cXl = {1500, 2000, 3500, 4600, SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME, 8000};
    private static final int[] cXm = {201, 202, 203};
    private static final int[] cXn = {501, 502, 503};
    private final HashMap<String, m> cWD;
    private final f cXg;
    private final com.baidu.tbadk.core.hybrid.c cXh;
    private final c cXi;
    private final HashMap<String, h> cXj;
    private int cXk;
    private String logId;
    private int status;

    private q(WebView webView, com.baidu.tbadk.core.hybrid.b bVar) {
        this(webView, new f(), new com.baidu.tbadk.core.hybrid.c(), bVar);
    }

    private q(WebView webView, f fVar, com.baidu.tbadk.core.hybrid.c cVar, com.baidu.tbadk.core.hybrid.b bVar) {
        super(webView, bVar);
        this.logId = String.valueOf(System.currentTimeMillis());
        this.status = -1;
        this.cXk = -1;
        this.cXg = fVar;
        this.cXh = cVar;
        this.cXh.a(this);
        this.cXg.a(this);
        this.cXi = new c(this);
        this.cXj = new HashMap<>(16);
        this.cWD = new HashMap<>(8);
        init();
    }

    public static l a(boolean z, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(webView);
        }
        q qVar = new q(webView, bVar);
        qVar.cXg.a(webViewClient);
        qVar.cXh.a(webChromeClient);
        return qVar;
    }

    public static l a(boolean z, BridgeWebView bridgeWebView, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(bridgeWebView);
        }
        WebViewClient webViewClient = bridgeWebView.webViewClient;
        WebChromeClient webChromeClient = bridgeWebView.chromeClient;
        q qVar = new q(bridgeWebView, bVar);
        qVar.cXg.a(webViewClient);
        qVar.cXh.a(webChromeClient);
        return qVar;
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void a(String str, d dVar) {
        if (this.cXj.put(str, dVar) != null) {
            throw new IllegalArgumentException("handler " + str + " exists.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void a(m mVar) {
        a(mVar, mVar.type == 3);
    }

    @Override // com.baidu.tbadk.core.hybrid.i
    public void aFl() {
        this.cXk++;
        final int i = this.cXk;
        HashMap hashMap = new HashMap();
        hashMap.put("platform", PraiseDataPassUtil.KEY_FROM_OS);
        hashMap.put("version", "1.0");
        hashMap.put("logid", aFq());
        a(m.a(hashMap, cXl[this.cXk % cXl.length], new k() { // from class: com.baidu.tbadk.core.hybrid.q.1
            @Override // com.baidu.tbadk.core.hybrid.k
            public void a(m mVar, JSONObject jSONObject) {
                q.this.a(mVar, i);
            }

            @Override // com.baidu.tbadk.core.hybrid.k
            public void b(int i2, Throwable th) {
                if (i2 == 1) {
                    if (i < q.cXn.length) {
                        q.this.aFr();
                    }
                    if (i >= 0 && i < q.cXn.length) {
                        q.this.cv(String.valueOf(q.cXn[i]), "");
                        return;
                    }
                    BdLog.e("pingIndex " + i + " out of bounds.");
                    e.U(q.this.aFq(), TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY, "ping timeout for index " + i);
                }
            }
        }), true);
        cv("100", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, int i) {
        this.status = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i >= 0 && i < cXm.length) {
            cv(String.valueOf(cXm[i]), String.valueOf(currentTimeMillis - mVar.start));
        } else {
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.i
    public void sX(String str) {
        if (TextUtils.isEmpty(str)) {
            e.debug("invalid callbackId.");
            return;
        }
        m remove = this.cWD.remove(str);
        if (remove != null) {
            e.debug("(" + remove.cmd + ", " + remove.method + ", " + str + ") timeout.");
            remove.b(1, (Throwable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ta(String str) {
        this.cXk = -1;
        if (this.status != 2 && this.status != 1) {
            e.debug("current status " + this.status + ", broken because url changed to " + str);
            this.status = 2;
        }
        if (p.sY(str) && p.sZ(str)) {
            e.debug("current status " + this.status + ", constructing bridge for " + str);
            if (this.cWY != null) {
                this.cWY.aFe();
            }
            b(this.cWX);
            if (this.cWY != null) {
                this.cWY.aFf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String cs(String str, String str2) {
        e.debug("got js prompt in url:" + str + " with content:" + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString(PushManager.MESSAGE_TYPE);
            if ("ping".equals(optString)) {
                o(jSONObject.optString(WBConstants.SHARE_CALLBACK_ID), jSONObject.optJSONObject("outputData"));
            } else if ("request".equals(optString)) {
                a(jSONObject.optString("cmd"), jSONObject.optString("method"), jSONObject.optJSONObject("inputData"), jSONObject);
            } else if (IIntercepter.TYPE_RESPONSE.equals(optString)) {
                o(jSONObject.optString(WBConstants.SHARE_CALLBACK_ID), jSONObject.optJSONObject("outputData"));
            } else {
                e.U(aFq(), TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN, "invalid message type " + optString);
            }
            return null;
        } catch (JSONException e) {
            e.U(aFq(), TbEnum.SystemMessage.EVENT_ID_INVITE_GROUP, e.getMessage());
            return null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void init() {
        if (this.status != -1) {
            throw new IllegalStateException("Can't init bridge more than once.");
        }
        this.cWX.getSettings().setJavaScriptEnabled(true);
        this.cWX.setWebViewClient(this.cXg);
        this.cWX.setWebChromeClient(this.cXh);
        this.cWX.removeJavascriptInterface("searchBoxJavaBridge_");
        this.status = 1;
    }

    private void a(m mVar, boolean z) {
        if (!z) {
            if (this.status != 0) {
                e.U(aFq(), TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY, "(" + mVar.cmd + ", " + mVar.method + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(mVar.cmd) || TextUtils.isEmpty(mVar.method)) {
                e.U(aFq(), TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY, "the alias class or method is empty");
                mVar.b(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(mVar.cXc)) {
            if (mVar.type != 3) {
                this.cWD.put(mVar.cXc, mVar);
                if (mVar.timeout > 0) {
                    this.cXi.sendMessageDelayed(Message.obtain(this.cXi, 2, mVar.cXc), mVar.timeout);
                } else if (mVar.cmd != null || mVar.method != null) {
                    e.debug("ignore timeout check for method call (" + mVar.cmd + ", " + mVar.method + ").");
                }
            } else {
                e.debug("ignore timeout check for response method, callbackId " + mVar.cXc);
            }
        }
        try {
            String aFn = mVar.aFn();
            if (Build.VERSION.SDK_INT >= 19) {
                this.cWX.evaluateJavascript(aFn, null);
            } else {
                this.cWX.loadUrl(aFn);
            }
            e.debug(aFn);
        } catch (NullPointerException e) {
            cv("500", e.getMessage());
        } catch (JSONException e2) {
            if (z) {
                cv(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY, e2.getMessage());
            } else {
                e.debug(e2.getMessage());
            }
            mVar.b(2, e2);
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.status != 0) {
            e.U(aFq(), TbEnum.SystemMessage.EVENT_ID_GROUP_QUIT, "bridge is not ready");
        }
        h hVar = this.cXj.get(str);
        if (hVar == null) {
            hVar = new b(this, str);
            e.U(aFq(), TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP, "cmd " + str + " not found");
        }
        hVar.a(str2, jSONObject, jSONObject2);
    }

    private void o(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.debug("invalid callbackId.");
            return;
        }
        this.cXi.removeMessages(2, str);
        m remove = this.cWD.remove(str);
        if (remove != null) {
            remove.cl(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aFq() {
        return this.logId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cv(String str, String str2) {
        e.T(aFq(), str, str2);
    }

    private void b(WebView webView) {
        this.logId = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder aFs = aFs();
            aFs.append(new String(bArr));
            webView.loadUrl("javascript:" + aFs.toString());
            this.cXi.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            cv(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY, th.getMessage());
            e.debug(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFr() {
        e.debug("reInject for pingIndex " + this.cXk);
        b(this.cWX);
    }

    private StringBuilder aFs() throws JSONException {
        StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", PraiseDataPassUtil.KEY_FROM_OS);
        jSONObject.put("version", "1.0");
        jSONObject.put("logid", aFq());
        sb.append(jSONObject.toString());
        sb.append(';');
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Handler {
        private final WeakReference<i> cXp;

        public c(i iVar) {
            this.cXp = new WeakReference<>(iVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i iVar = this.cXp.get();
            if (iVar == null) {
                e.debug("TimeHandler got null bridge reference.");
                return;
            }
            switch (message.what) {
                case 1:
                    iVar.aFl();
                    return;
                case 2:
                    iVar.sX((String) message.obj);
                    return;
                default:
                    throw new IllegalArgumentException("Invalid message.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements h {
        private final l cWC;
        private final String cmd;

        protected b(l lVar, String str) {
            this.cWC = lVar;
            this.cmd = str;
        }

        @Override // com.baidu.tbadk.core.hybrid.h
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            String optString = jSONObject2.optString(WBConstants.SHARE_CALLBACK_ID);
            if (TextUtils.isEmpty(optString)) {
                e.debug("scope " + this.cmd + " not found!");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP);
            hashMap.put("errMsg", "cmd " + this.cmd + " not found");
            this.cWC.a(m.i(optString, hashMap));
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
