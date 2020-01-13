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
    private static final int[] cTh = {1500, 2000, 3500, 4600, SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME, 8000};
    private static final int[] cTi = {201, 202, 203};
    private static final int[] cTj = {501, 502, 503};
    private final HashMap<String, m> cSz;
    private final f cTc;
    private final com.baidu.tbadk.core.hybrid.c cTd;
    private final c cTe;
    private final HashMap<String, h> cTf;
    private int cTg;
    private String logId;
    private int status;

    private q(WebView webView, com.baidu.tbadk.core.hybrid.b bVar) {
        this(webView, new f(), new com.baidu.tbadk.core.hybrid.c(), bVar);
    }

    private q(WebView webView, f fVar, com.baidu.tbadk.core.hybrid.c cVar, com.baidu.tbadk.core.hybrid.b bVar) {
        super(webView, bVar);
        this.logId = String.valueOf(System.currentTimeMillis());
        this.status = -1;
        this.cTg = -1;
        this.cTc = fVar;
        this.cTd = cVar;
        this.cTd.a(this);
        this.cTc.a(this);
        this.cTe = new c(this);
        this.cTf = new HashMap<>(16);
        this.cSz = new HashMap<>(8);
        init();
    }

    public static l a(boolean z, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(webView);
        }
        q qVar = new q(webView, bVar);
        qVar.cTc.a(webViewClient);
        qVar.cTd.a(webChromeClient);
        return qVar;
    }

    public static l a(boolean z, BridgeWebView bridgeWebView, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(bridgeWebView);
        }
        WebViewClient webViewClient = bridgeWebView.webViewClient;
        WebChromeClient webChromeClient = bridgeWebView.chromeClient;
        q qVar = new q(bridgeWebView, bVar);
        qVar.cTc.a(webViewClient);
        qVar.cTd.a(webChromeClient);
        return qVar;
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void a(String str, d dVar) {
        if (this.cTf.put(str, dVar) != null) {
            throw new IllegalArgumentException("handler " + str + " exists.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void a(m mVar) {
        a(mVar, mVar.type == 3);
    }

    @Override // com.baidu.tbadk.core.hybrid.i
    public void aCZ() {
        this.cTg++;
        final int i = this.cTg;
        HashMap hashMap = new HashMap();
        hashMap.put("platform", PraiseDataPassUtil.KEY_FROM_OS);
        hashMap.put("version", "1.0");
        hashMap.put("logid", aDe());
        a(m.a(hashMap, cTh[this.cTg % cTh.length], new k() { // from class: com.baidu.tbadk.core.hybrid.q.1
            @Override // com.baidu.tbadk.core.hybrid.k
            public void a(m mVar, JSONObject jSONObject) {
                q.this.a(mVar, i);
            }

            @Override // com.baidu.tbadk.core.hybrid.k
            public void b(int i2, Throwable th) {
                if (i2 == 1) {
                    if (i < q.cTj.length) {
                        q.this.aDf();
                    }
                    if (i >= 0 && i < q.cTj.length) {
                        q.this.cm(String.valueOf(q.cTj[i]), "");
                        return;
                    }
                    BdLog.e("pingIndex " + i + " out of bounds.");
                    e.T(q.this.aDe(), TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY, "ping timeout for index " + i);
                }
            }
        }), true);
        cm("100", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, int i) {
        this.status = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i >= 0 && i < cTi.length) {
            cm(String.valueOf(cTi[i]), String.valueOf(currentTimeMillis - mVar.start));
        } else {
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.i
    public void sH(String str) {
        if (TextUtils.isEmpty(str)) {
            e.debug("invalid callbackId.");
            return;
        }
        m remove = this.cSz.remove(str);
        if (remove != null) {
            e.debug("(" + remove.cmd + ", " + remove.method + ", " + str + ") timeout.");
            remove.b(1, (Throwable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sK(String str) {
        this.cTg = -1;
        if (this.status != 2 && this.status != 1) {
            e.debug("current status " + this.status + ", broken because url changed to " + str);
            this.status = 2;
        }
        if (p.sI(str) && p.sJ(str)) {
            e.debug("current status " + this.status + ", constructing bridge for " + str);
            if (this.cSU != null) {
                this.cSU.aCS();
            }
            b(this.cST);
            if (this.cSU != null) {
                this.cSU.aCT();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String cj(String str, String str2) {
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
                e.T(aDe(), TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN, "invalid message type " + optString);
            }
            return null;
        } catch (JSONException e) {
            e.T(aDe(), TbEnum.SystemMessage.EVENT_ID_INVITE_GROUP, e.getMessage());
            return null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void init() {
        if (this.status != -1) {
            throw new IllegalStateException("Can't init bridge more than once.");
        }
        this.cST.getSettings().setJavaScriptEnabled(true);
        this.cST.setWebViewClient(this.cTc);
        this.cST.setWebChromeClient(this.cTd);
        this.cST.removeJavascriptInterface("searchBoxJavaBridge_");
        this.status = 1;
    }

    private void a(m mVar, boolean z) {
        if (!z) {
            if (this.status != 0) {
                e.T(aDe(), TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY, "(" + mVar.cmd + ", " + mVar.method + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(mVar.cmd) || TextUtils.isEmpty(mVar.method)) {
                e.T(aDe(), TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY, "the alias class or method is empty");
                mVar.b(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(mVar.cSY)) {
            if (mVar.type != 3) {
                this.cSz.put(mVar.cSY, mVar);
                if (mVar.timeout > 0) {
                    this.cTe.sendMessageDelayed(Message.obtain(this.cTe, 2, mVar.cSY), mVar.timeout);
                } else if (mVar.cmd != null || mVar.method != null) {
                    e.debug("ignore timeout check for method call (" + mVar.cmd + ", " + mVar.method + ").");
                }
            } else {
                e.debug("ignore timeout check for response method, callbackId " + mVar.cSY);
            }
        }
        try {
            String aDb = mVar.aDb();
            if (Build.VERSION.SDK_INT >= 19) {
                this.cST.evaluateJavascript(aDb, null);
            } else {
                this.cST.loadUrl(aDb);
            }
            e.debug(aDb);
        } catch (NullPointerException e) {
            cm("500", e.getMessage());
        } catch (JSONException e2) {
            if (z) {
                cm(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY, e2.getMessage());
            } else {
                e.debug(e2.getMessage());
            }
            mVar.b(2, e2);
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.status != 0) {
            e.T(aDe(), TbEnum.SystemMessage.EVENT_ID_GROUP_QUIT, "bridge is not ready");
        }
        h hVar = this.cTf.get(str);
        if (hVar == null) {
            hVar = new b(this, str);
            e.T(aDe(), TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP, "cmd " + str + " not found");
        }
        hVar.a(str2, jSONObject, jSONObject2);
    }

    private void o(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.debug("invalid callbackId.");
            return;
        }
        this.cTe.removeMessages(2, str);
        m remove = this.cSz.remove(str);
        if (remove != null) {
            remove.cl(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aDe() {
        return this.logId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cm(String str, String str2) {
        e.S(aDe(), str, str2);
    }

    private void b(WebView webView) {
        this.logId = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder aDg = aDg();
            aDg.append(new String(bArr));
            webView.loadUrl("javascript:" + aDg.toString());
            this.cTe.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            cm(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY, th.getMessage());
            e.debug(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDf() {
        e.debug("reInject for pingIndex " + this.cTg);
        b(this.cST);
    }

    private StringBuilder aDg() throws JSONException {
        StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", PraiseDataPassUtil.KEY_FROM_OS);
        jSONObject.put("version", "1.0");
        jSONObject.put("logid", aDe());
        sb.append(jSONObject.toString());
        sb.append(';');
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Handler {
        private final WeakReference<i> cTl;

        public c(i iVar) {
            this.cTl = new WeakReference<>(iVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i iVar = this.cTl.get();
            if (iVar == null) {
                e.debug("TimeHandler got null bridge reference.");
                return;
            }
            switch (message.what) {
                case 1:
                    iVar.aCZ();
                    return;
                case 2:
                    iVar.sH((String) message.obj);
                    return;
                default:
                    throw new IllegalArgumentException("Invalid message.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements h {
        private final l cSy;
        private final String cmd;

        protected b(l lVar, String str) {
            this.cSy = lVar;
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
            this.cSy.a(m.j(optString, hashMap));
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
