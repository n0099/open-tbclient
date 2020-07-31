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
import com.baidu.searchbox.ui.CoolPraiseGuideLottieView;
import com.sina.weibo.sdk.constant.WBConstants;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q extends l implements i {
    private static final int[] dYa = {1500, 2000, 3500, 4600, SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME, CoolPraiseGuideLottieView.ANIM_DURATION};
    private static final int[] dYb = {201, 202, 203};
    private static final int[] dYc = {501, 502, 503};
    private final f dXV;
    private final com.baidu.tbadk.core.hybrid.c dXW;
    private final c dXX;
    private final HashMap<String, h> dXY;
    private int dXZ;
    private final HashMap<String, m> dXt;
    private String logId;
    private int status;

    private q(WebView webView, com.baidu.tbadk.core.hybrid.b bVar) {
        this(webView, new f(), new com.baidu.tbadk.core.hybrid.c(), bVar);
    }

    private q(WebView webView, f fVar, com.baidu.tbadk.core.hybrid.c cVar, com.baidu.tbadk.core.hybrid.b bVar) {
        super(webView, bVar);
        this.logId = String.valueOf(System.currentTimeMillis());
        this.status = -1;
        this.dXZ = -1;
        this.dXV = fVar;
        this.dXW = cVar;
        this.dXW.a(this);
        this.dXV.a(this);
        this.dXX = new c(this);
        this.dXY = new HashMap<>(16);
        this.dXt = new HashMap<>(8);
        init();
    }

    public static l a(boolean z, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(webView);
        }
        q qVar = new q(webView, bVar);
        qVar.dXV.a(webViewClient);
        qVar.dXW.a(webChromeClient);
        return qVar;
    }

    public static l a(boolean z, BridgeWebView bridgeWebView, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(bridgeWebView);
        }
        WebViewClient webViewClient = bridgeWebView.webViewClient;
        WebChromeClient webChromeClient = bridgeWebView.chromeClient;
        q qVar = new q(bridgeWebView, bVar);
        qVar.dXV.a(webViewClient);
        qVar.dXW.a(webChromeClient);
        return qVar;
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void a(String str, d dVar) {
        if (this.dXY.put(str, dVar) != null) {
            throw new IllegalArgumentException("handler " + str + " exists.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void a(m mVar) {
        a(mVar, mVar.type == 3);
    }

    @Override // com.baidu.tbadk.core.hybrid.i
    public void aZx() {
        this.dXZ++;
        final int i = this.dXZ;
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "android");
        hashMap.put("version", "1.0");
        hashMap.put("logid", aZC());
        a(m.a(hashMap, dYa[this.dXZ % dYa.length], new k() { // from class: com.baidu.tbadk.core.hybrid.q.1
            @Override // com.baidu.tbadk.core.hybrid.k
            public void a(m mVar, JSONObject jSONObject) {
                q.this.a(mVar, i);
            }

            @Override // com.baidu.tbadk.core.hybrid.k
            public void b(int i2, Throwable th) {
                if (i2 == 1) {
                    if (i < q.dYc.length) {
                        q.this.aZD();
                    }
                    if (i >= 0 && i < q.dYc.length) {
                        q.this.dk(String.valueOf(q.dYc[i]), "");
                        return;
                    }
                    BdLog.e("pingIndex " + i + " out of bounds.");
                    e.aa(q.this.aZC(), TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY, "ping timeout for index " + i);
                }
            }
        }), true);
        dk("100", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, int i) {
        this.status = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i >= 0 && i < dYb.length) {
            dk(String.valueOf(dYb[i]), String.valueOf(currentTimeMillis - mVar.start));
        } else {
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.i
    public void xq(String str) {
        if (TextUtils.isEmpty(str)) {
            e.debug("invalid callbackId.");
            return;
        }
        m remove = this.dXt.remove(str);
        if (remove != null) {
            e.debug("(" + remove.cmd + ", " + remove.method + ", " + str + ") timeout.");
            remove.b(1, (Throwable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xt(String str) {
        this.dXZ = -1;
        if (this.status != 2 && this.status != 1) {
            e.debug("current status " + this.status + ", broken because url changed to " + str);
            this.status = 2;
        }
        if (p.xr(str) && p.xs(str)) {
            e.debug("current status " + this.status + ", constructing bridge for " + str);
            if (this.dXN != null) {
                this.dXN.aZq();
            }
            b(this.dXM);
            if (this.dXN != null) {
                this.dXN.aZr();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String dh(String str, String str2) {
        e.debug("got js prompt in url:" + str + " with content:" + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString("messageType");
            if ("ping".equals(optString)) {
                p(jSONObject.optString(WBConstants.SHARE_CALLBACK_ID), jSONObject.optJSONObject("outputData"));
            } else if ("request".equals(optString)) {
                a(jSONObject.optString("cmd"), jSONObject.optString("method"), jSONObject.optJSONObject("inputData"), jSONObject);
            } else if (IIntercepter.TYPE_RESPONSE.equals(optString)) {
                p(jSONObject.optString(WBConstants.SHARE_CALLBACK_ID), jSONObject.optJSONObject("outputData"));
            } else {
                e.aa(aZC(), TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN, "invalid message type " + optString);
            }
            return null;
        } catch (JSONException e) {
            e.aa(aZC(), TbEnum.SystemMessage.EVENT_ID_INVITE_GROUP, e.getMessage());
            return null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void init() {
        if (this.status != -1) {
            throw new IllegalStateException("Can't init bridge more than once.");
        }
        this.dXM.getSettings().setJavaScriptEnabled(true);
        this.dXM.setWebViewClient(this.dXV);
        this.dXM.setWebChromeClient(this.dXW);
        this.dXM.removeJavascriptInterface("searchBoxJavaBridge_");
        this.status = 1;
    }

    private void a(m mVar, boolean z) {
        if (!z) {
            if (this.status != 0) {
                e.aa(aZC(), TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY, "(" + mVar.cmd + ", " + mVar.method + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(mVar.cmd) || TextUtils.isEmpty(mVar.method)) {
                e.aa(aZC(), TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY, "the alias class or method is empty");
                mVar.b(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(mVar.dXR)) {
            if (mVar.type != 3) {
                this.dXt.put(mVar.dXR, mVar);
                if (mVar.timeout > 0) {
                    this.dXX.sendMessageDelayed(Message.obtain(this.dXX, 2, mVar.dXR), mVar.timeout);
                } else if (mVar.cmd != null || mVar.method != null) {
                    e.debug("ignore timeout check for method call (" + mVar.cmd + ", " + mVar.method + ").");
                }
            } else {
                e.debug("ignore timeout check for response method, callbackId " + mVar.dXR);
            }
        }
        try {
            String aZz = mVar.aZz();
            if (Build.VERSION.SDK_INT >= 19) {
                this.dXM.evaluateJavascript(aZz, null);
            } else {
                this.dXM.loadUrl(aZz);
            }
            e.debug(aZz);
        } catch (NullPointerException e) {
            dk("500", e.getMessage());
        } catch (JSONException e2) {
            if (z) {
                dk(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY, e2.getMessage());
            } else {
                e.debug(e2.getMessage());
            }
            mVar.b(2, e2);
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.status != 0) {
            e.aa(aZC(), TbEnum.SystemMessage.EVENT_ID_GROUP_QUIT, "bridge is not ready");
        }
        h hVar = this.dXY.get(str);
        if (hVar == null) {
            hVar = new b(this, str);
            e.aa(aZC(), TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP, "cmd " + str + " not found");
        }
        hVar.a(str2, jSONObject, jSONObject2);
    }

    private void p(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.debug("invalid callbackId.");
            return;
        }
        this.dXX.removeMessages(2, str);
        m remove = this.dXt.remove(str);
        if (remove != null) {
            remove.cP(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aZC() {
        return this.logId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dk(String str, String str2) {
        e.Z(aZC(), str, str2);
    }

    private void b(WebView webView) {
        this.logId = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder aZE = aZE();
            aZE.append(new String(bArr));
            webView.loadUrl("javascript:" + aZE.toString());
            this.dXX.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            dk(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY, th.getMessage());
            e.debug(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZD() {
        e.debug("reInject for pingIndex " + this.dXZ);
        b(this.dXM);
    }

    private StringBuilder aZE() throws JSONException {
        StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", "android");
        jSONObject.put("version", "1.0");
        jSONObject.put("logid", aZC());
        sb.append(jSONObject.toString());
        sb.append(';');
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Handler {
        private final WeakReference<i> dYe;

        public c(i iVar) {
            this.dYe = new WeakReference<>(iVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i iVar = this.dYe.get();
            if (iVar == null) {
                e.debug("TimeHandler got null bridge reference.");
                return;
            }
            switch (message.what) {
                case 1:
                    iVar.aZx();
                    return;
                case 2:
                    iVar.xq((String) message.obj);
                    return;
                default:
                    throw new IllegalArgumentException("Invalid message.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements h {
        private final String cmd;
        private final l dXs;

        protected b(l lVar, String str) {
            this.dXs = lVar;
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
            this.dXs.a(m.n(optString, hashMap));
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
