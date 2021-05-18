package com.baidu.tbadk.browser;

import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.JsPromptResult;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.livesdk.api.share.Share;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDebugSingleton;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGameCommentActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGameSubPbActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.hybrid.BridgeWebView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mutiprocess.event.TipEvent;
import com.baidu.tbadk.mutiprocess.event.TopToastEvent;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.switchs.QuickWebViewSwitch;
import com.baidu.tbadk.switchs.RedirectInterceptionSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.quickWebView.SingleQuickWebViewBridge;
import com.baidu.tieba.quickWebView.data.QuickWebViewBridgeData;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidubce.auth.NTLMEngineImpl;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import d.a.j0.r.s.b;
import d.a.j0.z0.n0;
import d.a.j0.z0.q;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TbWebViewActivity extends BaseWebViewActivity {
    public static final int FILECHOOSER_RESULTCODE = 1;
    public static final String KEY_TASK_CENTER_PREFIX_URL = "https://haokan.baidu.com/activity/";
    public static final int MAX_NUM_UPLOAD_CHAR = 100;
    public static final HashMap<String, String> mShareToTypes;
    public d.a.k0.d3.l0.a jsBridge;
    public String mBid;
    public CommonTbJsBridge mCommonTbJsBridge;
    public d.a.j0.r.y.l mHybridBridge;
    public s mOnDialogItemClickListener;
    public String mPageFrom;
    public PermissionJudgePolicy mPermissionJudgement;
    public d.a.k0.q2.a mProxy;
    public String mShareInfo;
    public ShareItem mShareItem;
    public String mShareParams;
    public ValueCallback<Uri> mUploadMessage;
    public ValueCallback<Uri[]> mUploadMessageAboveL;
    public WebViewBroadcastReceiver mWebViewCloseReceiver;
    public d.a.j0.t.l timerData;
    public BridgeWebView mWebView = null;
    public int mOfflineErrorType = 0;
    public String mModuleName = "";
    public String mVersion = "0.0.0.0";
    public d.a.k0.d3.l0.c jsCallback = new j();
    public boolean mShowShareItem = true;
    public String mPageType = "normal";
    public String mPageTranslucent = "normal";
    public boolean isDisableGoBack = false;
    public boolean loadMyself = false;
    public final CustomMessageListener mSetShareInfoListener = new k(2016566);
    public final CustomMessageListener mSpringFestivalTimerListener = new l(2156673);
    public final CustomMessageListener mSelfLoadJsListener = new m(2921434);
    public d.a.j0.f0.i mTipsEventListener = new n();
    public d.a.j0.f0.i mTopToastEventListener = new o();
    public boolean isShowFullScreen = false;
    public CustomMessageListener htmlLoadMessageListener = new f(2921023);
    public final CustomMessageListener mSharePage = new g(2921331);

    /* loaded from: classes3.dex */
    public class a extends d.a.j0.r.y.n {
        public a(d.a.j0.r.y.l lVar) {
            super(lVar);
        }

        @d.a.j0.r.y.o(isAsync = false, value = "gameComment")
        private void goToGameComment(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsGameCommentActivityConfig(TbWebViewActivity.this.getPageContext().getPageActivity(), jSONObject.optInt("score"), jSONObject.optInt("forum_id"))));
        }

        @Override // d.a.j0.r.y.n
        public String g() {
            return "TBHY_COMMON_GAME_COMMENT";
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.a.j0.r.y.n {
        public b(d.a.j0.r.y.l lVar) {
            super(lVar);
        }

        @d.a.j0.r.y.o(isAsync = false, value = "enterCommentFloor")
        private void goToFrsGameSubPbActivity(JSONObject jSONObject) {
            if (jSONObject != null && ViewHelper.checkUpIsLogin(TbWebViewActivity.this.getPageContext().getPageActivity())) {
                String optString = jSONObject.optString("forum_id");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsGameSubPbActivityConfig(TbWebViewActivity.this.getPageContext().getPageActivity(), d.a.c.e.m.b.d(optString, 0), jSONObject.optString("comment_id"))));
            }
        }

        @Override // d.a.j0.r.y.n
        public String g() {
            return "TBHY_COMMON_COMMENT_FLOOR";
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnLongClickListener {
        public c() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (TextUtils.isEmpty(TbWebViewActivity.this.mUrl) || !TbWebViewActivity.this.mUrl.contains("haokan.baidu.com/activity/")) {
                return TbWebViewActivity.this.handleLongClick();
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (TbWebViewActivity.this.mWebView != null) {
                    TbWebViewActivity.this.mWebView.destroy();
                    TbWebViewActivity.this.mWebView = null;
                }
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TbWebViewActivity.this.mView.q();
        }
    }

    /* loaded from: classes3.dex */
    public class f extends CustomMessageListener {
        public f(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921023 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TbWebViewActivity.this.mUrl.contains(str) || str.contains(TbWebViewActivity.this.mUrl)) {
                    TbWebViewActivity.this.hideProgressBar();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends CustomMessageListener {
        public g(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TbWebViewActivity.this.mShareParams = (String) customResponsedMessage.getData();
                TbWebViewActivity.this.showRightShareIcon();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f12033e;

        public h(ShareItem shareItem) {
            this.f12033e = shareItem;
        }

        @Override // java.lang.Runnable
        public void run() {
            TbWebViewActivity.this.mView.I(this.f12033e);
        }
    }

    /* loaded from: classes3.dex */
    public class i implements CustomMessageTask.CustomRunnable<String> {
        public i() {
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<ShareItem> run(CustomMessage<String> customMessage) {
            if (customMessage != null && (customMessage.getData() instanceof String)) {
                try {
                    JSONObject jSONObject = new JSONObject(customMessage.getData());
                    String optString = jSONObject.optString("title");
                    String optString2 = jSONObject.optString("desc");
                    String optString3 = jSONObject.optString("img");
                    String optString4 = jSONObject.optString("url");
                    String optString5 = jSONObject.optString("topic");
                    String optString6 = jSONObject.optString("wbtitle");
                    String optString7 = jSONObject.optString("wbcontent");
                    TbWebViewActivity.this.mShareItem = TbWebViewActivity.this.createShareContent(optString, optString4, optString2, optString3);
                    TbWebViewActivity.this.mShareItem.O = optString5;
                    TbWebViewActivity.this.mShareItem.P = optString6;
                    TbWebViewActivity.this.mShareItem.Q = optString7;
                    TbWebViewActivity.this.mShareItem.W = jSONObject.optInt("shareimg");
                    TbWebViewActivity.this.mShareItem.d0 = jSONObject.optInt("weixin_disable");
                    String optString8 = jSONObject.optString("extdata");
                    if (!StringUtils.isNull(optString8)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(optString8);
                            String optString9 = jSONObject2.optString("activityid");
                            String optString10 = jSONObject2.optString("missionid");
                            if (!StringUtils.isNull(optString9) && !StringUtils.isNull(optString10)) {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put(optString9, optString10);
                                TbWebViewActivity.this.mShareItem.S = jSONObject3.toString();
                            }
                        } catch (JSONException unused) {
                        }
                    }
                    return new CustomResponsedMessage<>(2016568, TbWebViewActivity.this.mShareItem);
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class j implements d.a.k0.d3.l0.c {
        public j() {
        }

        @Override // d.a.k0.d3.l0.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            if (TbWebViewActivity.this.jsBridge != null) {
                return TbWebViewActivity.this.jsBridge.b(TbWebViewActivity.this.mWebView, str, jsPromptResult);
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class k extends CustomMessageListener {
        public k(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            TbWebViewActivity.this.mShareInfo = (String) customResponsedMessage.getData();
        }
    }

    /* loaded from: classes3.dex */
    public class l extends CustomMessageListener {
        public l(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof d.a.j0.t.l)) {
                return;
            }
            TbWebViewActivity.this.timerData = (d.a.j0.t.l) customResponsedMessage.getData();
            if (TbWebViewActivity.this.timerData.c()) {
                TbWebViewActivity.this.handlerWebViewResume();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m extends CustomMessageListener {
        public m(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            TbWebViewActivity.this.mWebView.loadUrl(str);
        }
    }

    /* loaded from: classes3.dex */
    public class n extends d.a.j0.f0.i<TipEvent> {
        public n() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.f0.b
        /* renamed from: a */
        public boolean onEvent(TipEvent tipEvent) {
            if (!tipEvent.isCloseCurrentPage) {
                DefaultNavigationBarCoverTip.s(TbWebViewActivity.this.getActivity(), tipEvent.message, tipEvent.linkUrl).u();
                return true;
            } else if (tipEvent.pageId <= 0 || TbWebViewActivity.this.getPageId() != tipEvent.pageId) {
                return true;
            } else {
                DefaultNavigationBarCoverTip.s(TbWebViewActivity.this.getActivity(), tipEvent.message, tipEvent.linkUrl).u();
                return true;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o extends d.a.j0.f0.i<TopToastEvent> {
        public o() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.f0.b
        /* renamed from: a */
        public boolean onEvent(TopToastEvent topToastEvent) {
            TbWebViewActivity.this.showTipToast(topToastEvent.isSuccess(), topToastEvent.getContent());
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class p extends d.a.j0.r.y.n {
        public p(d.a.j0.r.y.l lVar) {
            super(lVar);
        }

        @d.a.j0.r.y.o(isAsync = false, value = "trackFPS")
        private void trackFPS() {
        }

        @Override // d.a.j0.r.y.n
        public String g() {
            return "TBHY_COMMON_Performance";
        }
    }

    /* loaded from: classes3.dex */
    public class q extends d.a.j0.r.y.n {

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ShareItem f12044e;

            public a(ShareItem shareItem) {
                this.f12044e = shareItem;
            }

            @Override // java.lang.Runnable
            public void run() {
                TbWebViewActivity.this.mView.I(this.f12044e);
            }
        }

        public q(d.a.j0.r.y.l lVar) {
            super(lVar);
        }

        @d.a.j0.r.y.o(isAsync = false, value = "share")
        private void share(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString("desc");
            String optString3 = jSONObject.optString("img");
            String optString4 = jSONObject.optString("url");
            String optString5 = jSONObject.optString("bid");
            if (!StringUtils.isNULL(optString5)) {
                TbWebViewActivity tbWebViewActivity = TbWebViewActivity.this;
                tbWebViewActivity.mShareResultToFe = true;
                tbWebViewActivity.mBid = optString5;
            }
            d.a.c.e.m.e.a().post(new a(TbWebViewActivity.this.createShareContent(optString, optString4, optString2, optString3)));
        }

        @Override // d.a.j0.r.y.n
        public String g() {
            return "TBHY_COMMON_Share";
        }
    }

    /* loaded from: classes3.dex */
    public class r extends d.a.j0.r.y.n {
        public r(d.a.j0.r.y.l lVar) {
            super(lVar);
        }

        @d.a.j0.r.y.o(isAsync = false, value = "viewHideSwitch")
        private void viewHideSwitch(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            String optString = jSONObject.optJSONObject("share").optString("value");
            if ("1".equals(optString)) {
                TbWebViewActivity.this.mShowShareItem = true;
            } else if ("0".equals(optString)) {
                TbWebViewActivity.this.mShowShareItem = false;
            }
            TbWebViewActivity tbWebViewActivity = TbWebViewActivity.this;
            tbWebViewActivity.mView.y(tbWebViewActivity.mShowShareItem);
        }

        @Override // d.a.j0.r.y.n
        public String g() {
            return "TBHY_COMMON_UISwitch";
        }
    }

    /* loaded from: classes3.dex */
    public class s implements b.c {

        /* renamed from: b  reason: collision with root package name */
        public String f12048b;

        /* renamed from: a  reason: collision with root package name */
        public int f12047a = 1;

        /* renamed from: c  reason: collision with root package name */
        public List<Integer> f12049c = new ArrayList();

        /* loaded from: classes3.dex */
        public class a extends q.a {
            public a(s sVar) {
            }

            @Override // d.a.j0.z0.q.a
            public void onError(int i2, String str) {
            }

            @Override // d.a.j0.z0.q.a
            public void onSuccess(String str) {
                d.a.c.e.p.l.L(TbadkCoreApplication.getInst(), R.string.tb_webview_download_image_success_tip);
            }
        }

        public s() {
        }

        @Override // d.a.j0.r.s.b.c
        public void a(d.a.j0.r.s.b bVar, int i2, View view) {
            if (bVar != TbWebViewActivity.this.getListMenu() || i2 >= this.f12049c.size() || i2 < 0) {
                return;
            }
            if (this.f12049c.get(i2).intValue() == 1) {
                if (TbWebViewActivity.this.mPermissionJudgement == null) {
                    TbWebViewActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                }
                TbWebViewActivity.this.mPermissionJudgement.clearRequestPermissionList();
                TbWebViewActivity.this.mPermissionJudgement.appendRequestPermission(TbWebViewActivity.this, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                if (TbWebViewActivity.this.mPermissionJudgement.startRequestPermission(TbWebViewActivity.this)) {
                    return;
                }
                new d.a.j0.z0.q(TbWebViewActivity.this.getActivity(), this.f12048b, new a(this)).execute(new String[0]);
            }
            bVar.e();
        }

        public String[] b() {
            this.f12049c.clear();
            ArrayList arrayList = new ArrayList();
            arrayList.add(TbWebViewActivity.this.getPageContext().getString(R.string.save_to_local));
            this.f12049c.add(Integer.valueOf(this.f12047a));
            return (String[]) arrayList.toArray(new String[0]);
        }

        public void c(String str) {
            this.f12048b = str;
        }
    }

    /* loaded from: classes3.dex */
    public class t extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        public boolean f12051a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                TbWebViewActivity.this.mView.p();
            }
        }

        public t() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            TbWebViewActivity tbWebViewActivity = TbWebViewActivity.this;
            BridgeWebView bridgeWebView = tbWebViewActivity.mWebView;
            if (bridgeWebView == null) {
                return;
            }
            this.f12051a = false;
            tbWebViewActivity.mUrl = str;
            bridgeWebView.loadUrl("javascript:window.local_obj.getIfFullScreen(document.getElementsByName(\"fc_fullscreen\")[0].content);");
            String title = TbWebViewActivity.this.mWebView.getTitle();
            if (!TbWebViewActivity.this.mFixTitle && !StringUtils.isNull(title)) {
                TbWebViewActivity.this.mUrlTitle = title;
            }
            if (!TbWebViewActivity.this.isShowFullScreen) {
                TbWebViewActivity tbWebViewActivity2 = TbWebViewActivity.this;
                tbWebViewActivity2.mView.w(tbWebViewActivity2.mUrlTitle);
            }
            if (TbWebViewActivity.this.isTranslucent()) {
                TbWebViewActivity.this.mView.t(false);
            } else {
                TbWebViewActivity tbWebViewActivity3 = TbWebViewActivity.this;
                tbWebViewActivity3.mView.t(tbWebViewActivity3.mIsShowNavBar);
            }
            TbWebViewActivity tbWebViewActivity4 = TbWebViewActivity.this;
            tbWebViewActivity4.mView.y(tbWebViewActivity4.isNeedShowShareItem());
            if (!StringUtils.isNull(TbWebViewActivity.this.mUrl) && TbWebViewActivity.this.mUrl.contains(TbWebViewActivity.KEY_TASK_CENTER_PREFIX_URL)) {
                TbWebViewActivity.this.mView.u(8);
            }
            TbWebViewActivity.this.hideProgressBar();
            TbWebViewActivity.this.stopLoadTimer();
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            TbWebViewActivity tbWebViewActivity = TbWebViewActivity.this;
            if (tbWebViewActivity.mWebView == null) {
                return;
            }
            this.f12051a = true;
            tbWebViewActivity.mUrl = str;
            tbWebViewActivity.showProgressBar();
            TbWebViewActivity.this.startLoadTimer();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            BridgeWebView bridgeWebView = TbWebViewActivity.this.mWebView;
            if (bridgeWebView == null) {
                return;
            }
            this.f12051a = false;
            bridgeWebView.stopLoading();
            TbWebViewActivity.this.stopLoadTimer();
            TbWebViewActivity.this.onReceivedError(i2);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            d.a.j0.l.e eVar;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (RedirectInterceptionSwitch.isOn() && this.f12051a && Build.VERSION.SDK_INT >= 26 && (UtilHelper.isOppoDevice() || UtilHelper.isVivoDevice())) {
                if (URLUtil.isNetworkUrl(str) || !str.startsWith("tiebaclient://")) {
                    return false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921361, str));
                return true;
            }
            int dealOneLinkWithOutJumpWebView = UrlManager.getInstance().dealOneLinkWithOutJumpWebView(TbWebViewActivity.this.getPageContext(), new String[]{str, TbWebViewActivity.this.mUrl});
            if (dealOneLinkWithOutJumpWebView == 1) {
                TbWebViewActivity.this.finish();
                return true;
            } else if (dealOneLinkWithOutJumpWebView == 0) {
                return true;
            } else {
                if (dealOneLinkWithOutJumpWebView == 2) {
                    return false;
                }
                TbWebViewActivity tbWebViewActivity = TbWebViewActivity.this;
                tbWebViewActivity.mUrl = str;
                if (tbWebViewActivity.isShowFullScreen) {
                    TbWebViewActivity.this.isShowFullScreen = false;
                    TbWebViewActivity.this.runOnUiThread(new a());
                }
                TbWebViewActivity.this.hideCrashTip();
                if (URLUtil.isNetworkUrl(TbWebViewActivity.this.mUrl)) {
                    TbWebViewActivity.this.showProgressBar();
                    if (TbWebViewActivity.this.isShowFullScreen && (eVar = TbWebViewActivity.this.mView) != null) {
                        eVar.q();
                    }
                    return false;
                }
                TbWebViewActivity tbWebViewActivity2 = TbWebViewActivity.this;
                Intent parseIntentFromUrl = tbWebViewActivity2.parseIntentFromUrl(tbWebViewActivity2.getApplicationContext(), TbWebViewActivity.this.mUrl);
                if (parseIntentFromUrl != null) {
                    try {
                        TbWebViewActivity.this.startActivity(parseIntentFromUrl);
                    } catch (Throwable unused) {
                    }
                }
                return true;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class u implements DownloadListener {
        public u() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (StringUtils.isNull(str)) {
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                TbWebViewActivity.this.startActivity(intent);
            }
        }

        public /* synthetic */ u(TbWebViewActivity tbWebViewActivity, j jVar) {
            this();
        }
    }

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        mShareToTypes = hashMap;
        hashMap.put(Share.WEIXIN_TIMELINE, Share.WEIXIN_TIMELINE);
        mShareToTypes.put(Share.WEIXIN_FRIEND, Share.WEIXIN_FRIEND);
        mShareToTypes.put(Share.QQDENGLU, "qq_zone");
        mShareToTypes.put(Share.SINAWEIBO, "sina_weibo");
        mShareToTypes.put(Share.QQWEIBO, "qq_weibo");
    }

    private d.a.k0.d3.l0.b buildGameDownloadJSPrompt() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001386, d.a.k0.d3.l0.b.class, getPageContext());
        if (runTask == null || runTask.getData() == null) {
            return null;
        }
        return (d.a.k0.d3.l0.b) runTask.getData();
    }

    private String getLocalUrlByUrl(String str) {
        String str2;
        Iterator<String> it;
        String str3;
        Iterator<String> it2;
        String str4;
        String[] split;
        HashMap hashMap = new HashMap();
        String str5 = null;
        try {
            URL url = new URL(str);
            d.a.k0.q2.d.a c2 = d.a.k0.q2.c.a().c(url.getPath());
            if (c2 == null) {
                try {
                    if (d.a.k0.q2.c.a().b() != null) {
                        this.mOfflineErrorType = 3;
                    }
                    return null;
                } catch (MalformedURLException unused) {
                }
            } else {
                try {
                    if (!c2.f59830e) {
                        this.mOfflineErrorType = 4;
                        d.a.j0.r.z.a.a("OfflineCache", -1L, -1, "readCache", -1, "", "url", str, "hybridName", c2.f59827b, "hybridResult", "processing bundle");
                        return null;
                    }
                    try {
                        String s2 = d.a.k0.q2.b.q().s(c2.f59827b);
                        if (!TextUtils.isEmpty(c2.f59827b) && !TextUtils.isEmpty(c2.f59828c) && !TextUtils.isEmpty(s2)) {
                            this.mModuleName = c2.f59827b;
                            this.mVersion = s2;
                            String str6 = d.a.k0.q2.b.q().p() + "/" + c2.f59827b + "/" + s2 + "/";
                            String str7 = c2.f59828c;
                            if (!c2.f59828c.endsWith(DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION)) {
                                str7 = c2.f59828c + DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION;
                            }
                            String str8 = str6 + str7;
                            File file = new File(str8);
                            ArrayList<String> arrayList = c2.f59829d;
                            if (!str8.contains("/android_asset/")) {
                                if (!file.exists()) {
                                    this.mOfflineErrorType = 2;
                                    d.a.j0.r.z.a.a("OfflineCache", -1L, -1, "readCache", -1, "", "hybridName", this.mModuleName, "hybridResult", "path not found");
                                    return null;
                                } else if (ListUtils.isEmpty(arrayList)) {
                                    return null;
                                } else {
                                    for (String str9 : arrayList) {
                                        if (StringUtils.isNull(str9)) {
                                            d.a.j0.r.z.a.a("OfflineCache", -1L, -1, "readCache", -1, "", "hybridName", this.mModuleName, "hybridResult", "static file path is null");
                                            this.mOfflineErrorType = 1;
                                            return null;
                                        } else if (!new File(str6, str9).exists()) {
                                            this.mOfflineErrorType = 1;
                                            d.a.j0.r.z.a.a("OfflineCache", -1L, -1, "readCache", -1, "", "url", str9, "hybridName", this.mModuleName, "hybridResult", "bundle incomplete");
                                            return null;
                                        }
                                    }
                                }
                            }
                            String query = url.getQuery();
                            str2 = "file://" + str6 + str7;
                            try {
                                if (!TextUtils.isEmpty(query)) {
                                    str2 = str2 + "?" + query;
                                }
                                if (c2.f59826a != null && c2.f59826a.size() != 0) {
                                    String str10 = "&";
                                    if (!TextUtils.isEmpty(query) && (split = query.split("&")) != null) {
                                        for (String str11 : split) {
                                            String[] split2 = str11.split("=");
                                            if (split2 != null && split2.length == 2) {
                                                hashMap.put(StringUtil.ARRAY_START + split2[0] + "}", split2[1]);
                                            }
                                        }
                                    }
                                    hashMap.put("{client_version}", TbConfig.getVersion());
                                    hashMap.put("{client_type}", "2");
                                    hashMap.put("{is_yy_user}", TbSingleton.getInstance().getSyncYYSwitch() ? "1" : "0");
                                    Iterator<String> it3 = c2.f59826a.iterator();
                                    while (it3.hasNext()) {
                                        String next = it3.next();
                                        StringBuilder sb = new StringBuilder();
                                        String query2 = new URL(next).getQuery();
                                        if (TextUtils.isEmpty(query2)) {
                                            it = it3;
                                            str3 = str10;
                                        } else {
                                            String[] split3 = query2.split(str10);
                                            if (split3 != null) {
                                                int length = split3.length;
                                                int i2 = 0;
                                                boolean z = true;
                                                while (i2 < length) {
                                                    String str12 = split3[i2];
                                                    if (z) {
                                                        z = false;
                                                    } else {
                                                        sb.append(str10);
                                                    }
                                                    String[] split4 = str12.split("=");
                                                    if (split4 != null) {
                                                        it2 = it3;
                                                        str4 = str10;
                                                        if (split4.length == 2) {
                                                            String str13 = (String) hashMap.get(split4[1]);
                                                            if (str13 == null) {
                                                                str13 = split4[1];
                                                                if (str13.contains(StringUtil.ARRAY_START) && str13.contains("}")) {
                                                                    str13 = null;
                                                                }
                                                            }
                                                            sb.append(split4[0]);
                                                            sb.append("=");
                                                            if (!TextUtils.isEmpty(str13)) {
                                                                sb.append(str13);
                                                            }
                                                            i2++;
                                                            it3 = it2;
                                                            str10 = str4;
                                                        }
                                                    } else {
                                                        it2 = it3;
                                                        str4 = str10;
                                                    }
                                                    i2++;
                                                    it3 = it2;
                                                    str10 = str4;
                                                }
                                            }
                                            it = it3;
                                            str3 = str10;
                                            String sb2 = sb.toString();
                                            if (!TextUtils.isEmpty(sb2)) {
                                                next = next.replace(query2, sb2);
                                            }
                                        }
                                        QuickWebViewBridgeData quickWebViewBridgeData = new QuickWebViewBridgeData();
                                        quickWebViewBridgeData.type = "get";
                                        quickWebViewBridgeData.url = next;
                                        quickWebViewBridgeData.module = c2.f59827b;
                                        quickWebViewBridgeData.begin = System.currentTimeMillis();
                                        if (this.mProxy != null) {
                                            this.mProxy.f(quickWebViewBridgeData, null);
                                        }
                                        it3 = it;
                                        str10 = str3;
                                    }
                                    return str2;
                                }
                                return str2;
                            } catch (MalformedURLException unused2) {
                                str5 = str2;
                                return str5;
                            }
                        }
                        return null;
                    } catch (MalformedURLException unused3) {
                        str2 = null;
                    }
                } catch (MalformedURLException unused4) {
                    str5 = null;
                }
            }
        } catch (MalformedURLException unused5) {
        }
        return str5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleLongClick() {
        WebView.HitTestResult hitTestResult;
        BridgeWebView bridgeWebView = this.mWebView;
        if (bridgeWebView == null || (hitTestResult = bridgeWebView.getHitTestResult()) == null || hitTestResult.getType() != 5) {
            return false;
        }
        if (this.mOnDialogItemClickListener == null) {
            this.mOnDialogItemClickListener = new s();
        }
        this.mOnDialogItemClickListener.c(hitTestResult.getExtra());
        createListMenu(this.mOnDialogItemClickListener.b(), this.mOnDialogItemClickListener);
        showListMenu();
        return true;
    }

    private void handleShareResult(Intent intent, int i2) {
        if (this.mShareResultToFe) {
            this.mShareResultToFe = false;
            if (intent == null) {
                return;
            }
            String str = mShareToTypes.get(intent.getStringExtra("share_to"));
            HashMap hashMap = new HashMap();
            boolean z = i2 == -1;
            hashMap.put("bid", this.mBid);
            hashMap.put("result", Boolean.valueOf(z));
            hashMap.put("channel", str);
            d.a.j0.r.y.m j2 = d.a.j0.r.y.m.j("TBJS_COMMON_Share", "onShareResult", hashMap, 0L, false);
            d.a.j0.r.y.l lVar = this.mHybridBridge;
            if (lVar != null) {
                lVar.c(j2);
            }
            if (StringUtils.isNull(this.mUrl) || !this.mUrl.contains("topicgroupcallback=1") || intent == null || intent.getIntExtra("extra_share_status", -1) != 1) {
                return;
            }
            this.mWebView.loadUrl("javascript:window.__js_bridge_topic_group_share_action()");
        }
    }

    private void handleUploadResult(Intent intent, int i2) {
        if (i2 != -1 || intent == null) {
            return;
        }
        try {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(stringExtra);
            HashMap hashMap = new HashMap();
            JSONArray jSONArray = new JSONArray();
            if (writeImagesInfo.getChosedFiles() != null && writeImagesInfo.getChosedFiles().size() > 0) {
                Iterator<ImageFileInfo> it = writeImagesInfo.getChosedFiles().iterator();
                while (it.hasNext()) {
                    ImageFileInfo next = it.next();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("originalUrl", next.serverPicInfo.originPic.picUrl);
                    jSONObject.put("originalWidth", next.serverPicInfo.originPic.width);
                    jSONObject.put("originalHeight", next.serverPicInfo.originPic.height);
                    jSONObject.put("photoUrl", next.serverPicInfo.bigPic.picUrl);
                    jSONObject.put("photoWidth", next.serverPicInfo.bigPic.width);
                    jSONObject.put("photoHeight", next.serverPicInfo.bigPic.height);
                    jSONObject.put("photoThumbUrl", next.serverPicInfo.smallPic.picUrl);
                    jSONObject.put("filePath", next.getFilePath());
                    jSONArray.put(jSONObject);
                }
            }
            hashMap.put(TbConfig.LOCAL_PIC_DIR, jSONArray);
            d.a.j0.r.y.m j2 = d.a.j0.r.y.m.j("TBJS_COMMON_Image", "onImageUploadFinish", hashMap, 0L, false);
            if (this.mHybridBridge != null) {
                this.mHybridBridge.c(j2);
            }
        } catch (JSONException e2) {
            BdLog.e(e2.getMessage());
        }
    }

    private void handlerWebViewPause() {
        d.a.j0.t.l lVar = this.timerData;
        if (lVar == null || !lVar.c()) {
            return;
        }
        this.timerData.d();
        d.a.j0.r.d0.b.j().w(d.a.j0.r.d0.b.n("key_spring_festival_timer"), System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerWebViewResume() {
        d.a.j0.t.l lVar = this.timerData;
        if (lVar == null || !lVar.c() || this.timerData.b() || this.mCommonTbJsBridge == null) {
            return;
        }
        try {
            this.timerData.e(true);
            long currentTimeMillis = System.currentTimeMillis();
            long l2 = d.a.j0.r.d0.b.j().l(d.a.j0.r.d0.b.n("key_spring_festival_timer"), 0L);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("enter_time", String.valueOf(currentTimeMillis));
            String valueOf = String.valueOf(l2);
            if (l2 == 0) {
                valueOf = "";
            }
            jSONObject.put("leave_time", valueOf);
            jSONObject.put(MiPushCommandMessage.KEY_RESULT_CODE, 1);
            this.mCommonTbJsBridge.dealSpringFestivalTimer(this.timerData.a(), jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void newHandleShareResult(Intent intent, int i2) {
        if (this.mShareItem != null && i2 == -1) {
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            String stringExtra = intent.getStringExtra("complete_id");
            if (intExtra == 1) {
                sendCompleteTask(stringExtra);
                if (this.jsBridge != null) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("shareChannel", Integer.valueOf(intExtra2));
                    linkedHashMap.put("shareItem", this.mShareItem);
                    this.jsBridge.h(this.mWebView, CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, linkedHashMap);
                }
            }
            if (intExtra == 3) {
                if (intExtra2 == 8 || intExtra2 == 6) {
                    sendCompleteTask(stringExtra);
                    if (this.jsBridge != null) {
                        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                        linkedHashMap2.put("shareChannel", Integer.valueOf(intExtra2));
                        linkedHashMap2.put("shareItem", this.mShareItem);
                        this.jsBridge.h(this.mWebView, CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, linkedHashMap2);
                    }
                }
            }
        }
    }

    private void parserIntent() {
        Uri parse;
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        this.mPageTranslucent = intent.getStringExtra(WebViewActivityConfig.TAG_PAGE_TRANSLUCENT);
        this.loadMyself = intent.getBooleanExtra(WebViewActivityConfig.TAG_LOAD_BY_WEB_CLIENT, false);
        String stringExtra = intent.getStringExtra(WebViewActivityConfig.TAG_URL);
        if (TextUtils.isEmpty(stringExtra) || (parse = Uri.parse(stringExtra)) == null) {
            return;
        }
        try {
            this.mPageType = parse.getQueryParameter("page_type");
        } catch (Exception unused) {
        }
        try {
            boolean contains = stringExtra.contains("recClose=1");
            this.mPageFrom = n0.d(stringExtra, "page_from");
            if (contains) {
                WebViewBroadcastReceiver webViewBroadcastReceiver = new WebViewBroadcastReceiver();
                this.mWebViewCloseReceiver = webViewBroadcastReceiver;
                webViewBroadcastReceiver.register(this);
            }
        } catch (Exception unused2) {
        }
        try {
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            if (d.a.j0.a.f.c(uri)) {
                d.a.j0.a.f.b().i(uri);
            }
        } catch (Exception unused3) {
        }
    }

    private void registerGetShareContentTask() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016568, new i());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void sendCompleteTask(String str) {
        if (d.a.c.e.p.k.isEmpty(str)) {
            return;
        }
        CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(2);
        completeTaskReqMsg.completeId = str;
        sendMessage(completeTaskReqMsg);
    }

    private void sendDetailBroadcast(String str) {
        if ("live".equals(this.mPageFrom)) {
            Intent intent = new Intent();
            intent.putExtra("DetailLifecycle", str);
            intent.setAction("com.baidu.tieba.live.action.detail_broadcast");
            sendBroadcast(intent, WebViewBroadcastReceiver.BROADCAST_PERMISSION_CLOSE_WEBVIEW);
        }
    }

    private void showRightMoreIcon(int i2) {
        d.a.j0.l.e eVar = this.mView;
        if (eVar != null) {
            eVar.u(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRightShareIcon() {
        d.a.j0.l.e eVar = this.mView;
        if (eVar != null) {
            eVar.v();
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void addJavascriptInterface(Object obj, String str) {
        BridgeWebView bridgeWebView = this.mWebView;
        if (bridgeWebView != null) {
            bridgeWebView.addJavascriptInterface(obj, str);
        }
    }

    public void addJsPromptInterface(d.a.k0.d3.l0.b bVar) {
        if (bVar != null) {
            this.jsBridge.a(bVar);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (isTranslucent()) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        } else {
            super.closeAnimation();
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public View createWebView() {
        if (this.mWebView == null) {
            this.mWebView = new BridgeWebView(getPageContext().getPageActivity());
            if (isTranslucent()) {
                this.mWebView.setBackgroundColor(0);
            }
            this.mWebView.getSettings().setJavaScriptEnabled(true);
            this.mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.mWebView.getSettings().setAllowFileAccess(true);
            this.mWebView.getSettings().setDatabaseEnabled(true);
            this.mWebView.getSettings().setDomStorageEnabled(true);
            if (!isTranslucent()) {
                this.mWebView.getSettings().setSupportZoom(true);
                this.mWebView.getSettings().setBuiltInZoomControls(true);
                this.mWebView.getSettings().setUseWideViewPort(true);
            }
            this.mWebView.getSettings().setTextZoom(100);
            this.mWebView.getSettings().setDatabasePath(getApplicationContext().getDir("databases", 0).getAbsolutePath());
            this.mWebView.setHorizontalScrollBarEnabled(false);
            this.mWebView.setHorizontalScrollbarOverlay(false);
            if (!isTranslucent()) {
                this.mWebView.setInitialScale(100);
                this.mWebView.setScrollBarStyle(NTLMEngineImpl.FLAG_REQUEST_VERSION);
            }
            this.mWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.mWebView.setWebViewClient(new t());
            this.mWebView.setDownloadListener(new u(this, null));
            TbWebChromeClient tbWebChromeClient = new TbWebChromeClient(this);
            tbWebChromeClient.setOnJsPromptCallback(this.jsCallback);
            this.mWebView.setWebChromeClient(tbWebChromeClient);
            d.a.k0.i3.c.b().f(this, this.mWebView, tbWebChromeClient);
            if (this.mEnableJs) {
                addJavascriptInterface();
            }
            CompatibleUtile.getInstance().removeJavascriptInterface(this.mWebView);
            boolean isHybridBridgeEnabled = TbadkCoreApplication.getInst().isHybridBridgeEnabled();
            d.a.j0.r.y.l o2 = d.a.j0.r.y.q.o(isHybridBridgeEnabled, this.mWebView, null);
            this.mHybridBridge = o2;
            if (isHybridBridgeEnabled) {
                o2.d(new p(o2));
                o2.d(new d.a.j0.r.y.s.a(o2));
                o2.d(new d.a.j0.r.y.s.c(o2));
                o2.d(new d.a.j0.r.y.s.b(o2));
                o2.d(new q(o2));
                o2.d(new r(o2));
                o2.d(new a(o2));
                o2.d(new b(o2));
                o2.d(new d.a.j0.l.b(o2));
            }
            this.mWebView.setOnLongClickListener(new c());
        }
        return this.mWebView;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (!isTranslucent() && !this.mIsFromSchema) {
            super.enterExitAnimation();
        } else {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        sendDetailBroadcast(MissionEvent.MESSAGE_STOP);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public String getShareInfo() {
        return this.mShareInfo;
    }

    public ValueCallback<Uri> getUploadMessage() {
        return this.mUploadMessage;
    }

    public ValueCallback<Uri[]> getUploadMessageAboveL() {
        return this.mUploadMessageAboveL;
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public View getWebView() {
        return this.mWebView;
    }

    public void handleError() {
        BridgeWebView bridgeWebView = this.mWebView;
        if (bridgeWebView != null) {
            this.mUrl = bridgeWebView.getUrl();
            this.mWebView.stopLoading();
        }
        hideProgressBar();
        if (isTranslucent()) {
            BridgeWebView bridgeWebView2 = this.mWebView;
            if (bridgeWebView2 != null) {
                bridgeWebView2.setVisibility(8);
                return;
            }
            return;
        }
        showNoDataView();
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void initCookie() {
        d.a.j0.l.a.f(getApplicationContext());
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void initWebView() {
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0150  */
    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loadUrl(String str) {
        boolean z;
        d.a.j0.l.e eVar;
        String str2 = str;
        if (this.isShowFullScreen && (eVar = this.mView) != null) {
            eVar.q();
        }
        if (StringUtils.isNull(str)) {
            return;
        }
        if (TbSingleton.getInstance().isDebugToolMode() && TbDebugSingleton.getInstance().getUrlSwitchMap() != null) {
            HashMap<String, String> hashMap = TbDebugSingleton.getInstance().getUrlSwitchMap().f49410a;
            String str3 = null;
            for (String str4 : hashMap.keySet()) {
                if (!TextUtils.isEmpty(str4) && str2.contains(str4)) {
                    str3 = str4;
                }
            }
            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(hashMap.get(str3))) {
                String str5 = hashMap.get(str3);
                Uri parse = Uri.parse(str);
                String str6 = (TextUtils.isEmpty(parse.getScheme()) || TextUtils.isEmpty(parse.getHost())) ? "" : parse.getScheme() + "://" + parse.getHost();
                if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
                    str2 = str2.replace(str6, str5);
                }
            }
        }
        if (!str2.contains("javascript:")) {
            d.a.j0.r.z.a.a("OfflineCache", -1L, -1, "readCache", -1, "", "type", IntentConfig.START, "url", str2);
            if (QuickWebViewSwitch.getInOn()) {
                String localUrlByUrl = getLocalUrlByUrl(str2);
                if (!TextUtils.isEmpty(localUrlByUrl)) {
                    d.a.j0.r.z.a.a("OfflineCache", -1L, -1, "readCache", -1, "", "type", ProgressInfo.JSON_KEY_END, "url", localUrlByUrl, "hybridName", this.mModuleName, "hybridVersion", this.mVersion, "hybridResult", "success");
                    str2 = localUrlByUrl;
                    z = true;
                    String substring = str2.length() <= 100 ? str2.substring(0, 100) : str2;
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_QUICK_WEBVIEW_LOCAL_URL).param("obj_locate", !z ? "1" : "2").param("obj_source", substring).param("obj_type", this.mOfflineErrorType).param("obj_name", d.a.k0.q2.b.f59800h).param("obj_param1", this.mModuleName).param("obj_id", this.mVersion));
                    this.mOfflineErrorType = 0;
                    this.mVersion = "0.0.0.0";
                    this.mModuleName = "";
                    d.a.j0.r.z.a.a("search", -1L, 0, "LoadUrl", 0, "", "loadUrl", substring, SetImageWatermarkTypeReqMsg.SWITCH, Boolean.valueOf(QuickWebViewSwitch.getInOn()));
                }
            } else {
                this.mOfflineErrorType = 5;
            }
            z = false;
            if (str2.length() <= 100) {
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_QUICK_WEBVIEW_LOCAL_URL).param("obj_locate", !z ? "1" : "2").param("obj_source", substring).param("obj_type", this.mOfflineErrorType).param("obj_name", d.a.k0.q2.b.f59800h).param("obj_param1", this.mModuleName).param("obj_id", this.mVersion));
            this.mOfflineErrorType = 0;
            this.mVersion = "0.0.0.0";
            this.mModuleName = "";
            d.a.j0.r.z.a.a("search", -1L, 0, "LoadUrl", 0, "", "loadUrl", substring, SetImageWatermarkTypeReqMsg.SWITCH, Boolean.valueOf(QuickWebViewSwitch.getInOn()));
        }
        if (this.mWebView != null) {
            if (this.mCommonTbJsBridge != null) {
                this.mCommonTbJsBridge.setLastLoadUrlTime(System.currentTimeMillis());
            }
            if (this.loadMyself) {
                this.mWebView.loadUrl(str2);
            } else {
                CompatibleUtile.getInstance().loadUrl(this.mWebView, str2);
            }
        }
    }

    public boolean needDealClickGoBack() {
        if (!this.isDisableGoBack || this.mCommonTbJsBridge == null) {
            return false;
        }
        this.jsBridge.h(this.mWebView, CommonTbJsBridge.CLICK_GO_BACK_TO_H5, null);
        this.isDisableGoBack = false;
        return true;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        BridgeWebView bridgeWebView;
        Uri[] uriArr;
        if (i2 == 1) {
            if (i3 == -1) {
                if (Build.VERSION.SDK_INT >= 21) {
                    if (getUploadMessageAboveL() == null) {
                        return;
                    }
                    if (intent != null) {
                        String dataString = intent.getDataString();
                        ClipData clipData = intent.getClipData();
                        if (clipData != null) {
                            uriArr = new Uri[clipData.getItemCount()];
                            for (int i4 = 0; i4 < clipData.getItemCount(); i4++) {
                                uriArr[i4] = clipData.getItemAt(i4).getUri();
                            }
                        } else {
                            uriArr = null;
                        }
                        if (dataString != null) {
                            uriArr = new Uri[]{Uri.parse(dataString)};
                        }
                    } else {
                        uriArr = null;
                    }
                    if (uriArr != null) {
                        getUploadMessageAboveL().onReceiveValue(uriArr);
                    }
                    setUploadMessageAboveL(null);
                } else if (getUploadMessage() != null) {
                    getUploadMessage().onReceiveValue((intent == null || i3 != -1) ? null : intent.getData());
                    setUploadMessage(null);
                }
            }
        } else if (i2 == 1001) {
            if (this.mHybridBridge != null) {
                HashMap hashMap = new HashMap(4);
                hashMap.put("errNo", "0");
                hashMap.put("errMsg", "success");
                d.a.j0.r.y.m j2 = d.a.j0.r.y.m.j("TBHY_COMMON_COMMENT_FLOOR_CALLBACK", "onGameSubCommentSuccess", hashMap, 0L, false);
                d.a.j0.r.y.l lVar = this.mHybridBridge;
                if (lVar != null) {
                    lVar.c(j2);
                }
            }
        } else if (i2 == 11043) {
            if (-1 != i3 || this.mCommonTbJsBridge == null || intent == null) {
                return;
            }
            int intExtra = intent.getIntExtra("social_type", 0);
            String stringExtra = intent.getStringExtra("activity_id");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("social_type", Integer.valueOf(intExtra));
            linkedHashMap.put("activityId", stringExtra);
            this.jsBridge.h(this.mWebView, CommonTbJsBridge.RESULT_THIRD_PARTY_LOGIN, linkedHashMap);
        } else if (i2 == 12015) {
            handleUploadResult(intent, i3);
        } else if (i2 == 21002) {
            if (i3 != -1 || this.mHybridBridge == null) {
                return;
            }
            HashMap hashMap2 = new HashMap(4);
            hashMap2.put("errNo", "0");
            hashMap2.put("errMsg", "success");
            d.a.j0.r.y.m j3 = d.a.j0.r.y.m.j("TBJS_COMMON_Game_Comment", "onGameCommentSuccess", hashMap2, 0L, false);
            d.a.j0.r.y.l lVar2 = this.mHybridBridge;
            if (lVar2 != null) {
                lVar2.c(j3);
            }
        } else if (i2 == 24007) {
            handleShareResult(intent, i3);
            newHandleShareResult(intent, i3);
        } else if (i2 == 25042) {
            if (-1 == i3) {
                finish();
            }
        } else if (i2 == 25045) {
            BridgeWebView bridgeWebView2 = this.mWebView;
            if (bridgeWebView2 != null) {
                bridgeWebView2.reload();
            }
        } else if (i2 == 220010 && -1 == i3 && (bridgeWebView = this.mWebView) != null) {
            bridgeWebView.reload();
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, android.app.Activity
    public void onBackPressed() {
        if (needDealClickGoBack()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        if (this.jsBridge != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("skin", SkinManager.getCurrentSkinTypeString());
            this.jsBridge.h(this.mWebView, CommonTbJsBridge.CHANGE_SKIN_TYPE, linkedHashMap);
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        parserIntent();
        setIsTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT.equals(this.mPageTranslucent) || TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT.equals(this.mPageType));
        setIsAddSwipeBackLayout(!isTranslucent());
        super.onCreate(bundle);
        MessageManager.getInstance().runTask(2001308, (Class) null);
        this.jsBridge = new d.a.k0.d3.l0.a();
        this.mCommonTbJsBridge = new CommonTbJsBridge(getPageContext().getPageActivity(), this.mWebView);
        this.jsBridge.a(new XiubaTbJsBridge(getPageContext()));
        this.jsBridge.a(this.mCommonTbJsBridge);
        this.jsBridge.a(new UegTbJsBridge(getPageContext()));
        this.jsBridge.a(buildGameDownloadJSPrompt());
        this.mCommonTbJsBridge.setJsPromptBridge(this.jsBridge);
        this.mProxy = new d.a.k0.q2.a(this.mWebView);
        this.jsBridge.a(new SingleQuickWebViewBridge(this, this.mProxy));
        if (this.mNeedCookie) {
            initCookie();
        }
        registerListener(this.htmlLoadMessageListener);
        registerListener(this.mSharePage);
        registerListener(this.mSetShareInfoListener);
        registerListener(this.mSpringFestivalTimerListener);
        this.mSelfLoadJsListener.setSelfListener(true);
        registerListener(this.mSelfLoadJsListener);
        sendDetailBroadcast(MissionEvent.MESSAGE_START);
        registerResponsedEventListener(TopToastEvent.class, this.mTopToastEventListener);
        registerResponsedEventListener(TipEvent.class, this.mTipsEventListener);
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d.a.k0.q2.a aVar = this.mProxy;
        if (aVar != null) {
            aVar.e();
            this.mProxy = null;
        }
        CommonTbJsBridge commonTbJsBridge = this.mCommonTbJsBridge;
        if (commonTbJsBridge != null) {
            commonTbJsBridge.onDestroy();
        }
        WebViewBroadcastReceiver webViewBroadcastReceiver = this.mWebViewCloseReceiver;
        if (webViewBroadcastReceiver != null) {
            webViewBroadcastReceiver.unregister();
        }
        unRegisterResponsedEventListener();
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        sendDetailBroadcast(MissionEvent.MESSAGE_START);
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        BridgeWebView bridgeWebView = this.mWebView;
        if (bridgeWebView == null) {
            return;
        }
        try {
            bridgeWebView.onPause();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        handlerWebViewPause();
        callHiddenWebViewMethod(MissionEvent.MESSAGE_PAUSE);
        MessageManager.getInstance().unRegisterTask(2016568);
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void onReceivedError(int i2) {
        handleError();
    }

    public void onReceivedTitle() {
        handleError();
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mWebView == null) {
            return;
        }
        try {
            if (getUploadMessageAboveL() != null) {
                getUploadMessageAboveL().onReceiveValue(null);
                setUploadMessageAboveL(null);
            }
            this.mWebView.onResume();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        handlerWebViewResume();
        callHiddenWebViewMethod(MissionEvent.MESSAGE_RESUME);
        registerGetShareContentTask();
        d.a.k0.d3.l0.a aVar = this.jsBridge;
        if (aVar != null) {
            aVar.h(this.mWebView, CommonTbJsBridge.RE_SHOW, null);
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        if (this.jsBridge == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("isLogin", Boolean.valueOf(z));
        this.jsBridge.h(this.mWebView, CommonTbJsBridge.LOGIN_RESULT_TO_H5, linkedHashMap);
        setRefreshPage(false);
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void onWebViewLogin(boolean z) {
        super.onWebViewLogin(z);
        if (this.mWebView != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("no", z ? "1" : "0");
                loadUrl("javascript:tiebaClientLoginCallBack(" + jSONObject.toString() + SmallTailInfo.EMOTION_SUFFIX);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void refreshTitle(String str) {
        d.a.j0.l.e eVar;
        if (this.mFixTitle) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.mUrlTitle = str;
        }
        if (this.isShowFullScreen || (eVar = this.mView) == null) {
            return;
        }
        eVar.w(this.mUrlTitle);
    }

    public void removePromptInterface(d.a.k0.d3.l0.b bVar) {
        if (bVar != null) {
            this.jsBridge.g(bVar);
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void setFullScreen() {
        this.isShowFullScreen = true;
        if (1 == 0 || this.mView == null) {
            return;
        }
        runOnUiThread(new e());
    }

    public void setRefreshPage(boolean z) {
        this.isNeedRefresh = z;
    }

    public void setUploadMessage(ValueCallback<Uri> valueCallback) {
        this.mUploadMessage = valueCallback;
    }

    public void setUploadMessageAboveL(ValueCallback<Uri[]> valueCallback) {
        this.mUploadMessageAboveL = valueCallback;
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void showShare() {
        if (StringUtils.isNull(this.mShareParams)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.mShareParams);
            d.a.c.e.m.e.a().post(new h(createShareContent(jSONObject.optString("title"), jSONObject.optString("url"), jSONObject.optString("desc"), jSONObject.optString("img"))));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        try {
            super.unregisterReceiver(broadcastReceiver);
        } catch (Throwable unused) {
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void webViewDestory() {
        d.a.k0.d3.l0.a aVar = this.jsBridge;
        if (aVar != null) {
            aVar.f();
        }
        BridgeWebView bridgeWebView = this.mWebView;
        if (bridgeWebView != null) {
            bridgeWebView.getSettings().setBuiltInZoomControls(true);
            this.mWebView.setVisibility(8);
            d.a.c.e.m.e.a().postDelayed(new d(), ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public boolean webViewGoBack() {
        BridgeWebView bridgeWebView = this.mWebView;
        if (bridgeWebView != null && bridgeWebView.canGoBack()) {
            this.mWebView.goBack();
            return true;
        }
        return false;
    }
}
