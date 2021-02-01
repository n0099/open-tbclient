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
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import com.baidu.tbadk.BdToken.f;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGameCommentActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGameSubPbActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.hybrid.BridgeWebView;
import com.baidu.tbadk.core.hybrid.l;
import com.baidu.tbadk.core.hybrid.m;
import com.baidu.tbadk.core.hybrid.n;
import com.baidu.tbadk.core.hybrid.o;
import com.baidu.tbadk.core.hybrid.q;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mutiprocess.event.TipEvent;
import com.baidu.tbadk.mutiprocess.event.TopToastEvent;
import com.baidu.tbadk.mutiprocess.h;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.switchs.QuickWebViewSwitch;
import com.baidu.tbadk.switchs.RedirectInterceptionSwitch;
import com.baidu.tbadk.util.al;
import com.baidu.tbadk.util.p;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.quickWebView.SingleQuickWebViewBridge;
import com.baidu.tieba.quickWebView.data.QuickWebViewBridgeData;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.webkit.internal.ETAG;
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
/* loaded from: classes.dex */
public class TbWebViewActivity extends BaseWebViewActivity {
    public static final int FILECHOOSER_RESULTCODE = 1;
    private static final String KEY_TASK_CENTER_PREFIX_URL = "https://haokan.baidu.com/activity/";
    private static final int MAX_NUM_UPLOAD_CHAR = 100;
    private static final HashMap<String, String> mShareToTypes = new HashMap<>();
    private com.baidu.tieba.tbadkCore.e.a jsBridge;
    private String mBid;
    private CommonTbJsBridge mCommonTbJsBridge;
    private l mHybridBridge;
    private a mOnDialogItemClickListener;
    private String mPageFrom;
    private PermissionJudgePolicy mPermissionJudgement;
    private com.baidu.tieba.quickWebView.a mProxy;
    private String mShareInfo;
    private ShareItem mShareItem;
    private String mShareParams;
    private ValueCallback<Uri> mUploadMessage;
    private ValueCallback<Uri[]> mUploadMessageAboveL;
    private WebViewBroadcastReceiver mWebViewCloseReceiver;
    private com.baidu.tbadk.data.l timerData;
    protected BridgeWebView mWebView = null;
    private int mOfflineErrorType = 0;
    private String mModuleName = "";
    private String mVersion = "0.0.0.0";
    private com.baidu.tieba.tbadkCore.e.c jsCallback = new com.baidu.tieba.tbadkCore.e.c() { // from class: com.baidu.tbadk.browser.TbWebViewActivity.1
        @Override // com.baidu.tieba.tbadkCore.e.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            if (TbWebViewActivity.this.jsBridge != null) {
                return TbWebViewActivity.this.jsBridge.a(TbWebViewActivity.this.mWebView, str, jsPromptResult);
            }
            return false;
        }
    };
    private boolean mShowShareItem = true;
    private String mPageType = "normal";
    private String mPageTranslucent = "normal";
    public boolean isDisableGoBack = false;
    private boolean loadMyself = false;
    private final CustomMessageListener mSetShareInfoListener = new CustomMessageListener(2016566) { // from class: com.baidu.tbadk.browser.TbWebViewActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TbWebViewActivity.this.mShareInfo = (String) customResponsedMessage.getData();
            }
        }
    };
    private final CustomMessageListener mSpringFestivalTimerListener = new CustomMessageListener(2156673) { // from class: com.baidu.tbadk.browser.TbWebViewActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                TbWebViewActivity.this.timerData = (com.baidu.tbadk.data.l) customResponsedMessage.getData();
                if (TbWebViewActivity.this.timerData.isOpen()) {
                    TbWebViewActivity.this.handlerWebViewResume();
                }
            }
        }
    };
    private final CustomMessageListener mSelfLoadJsListener = new CustomMessageListener(2921434) { // from class: com.baidu.tbadk.browser.TbWebViewActivity.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    TbWebViewActivity.this.mWebView.loadUrl(str);
                }
            }
        }
    };
    private h mTipsEventListener = new h<TipEvent>() { // from class: com.baidu.tbadk.browser.TbWebViewActivity.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(TipEvent tipEvent) {
            if (!tipEvent.isCloseCurrentPage) {
                DefaultNavigationBarCoverTip.d(TbWebViewActivity.this.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            } else if (tipEvent.pageId > 0 && TbWebViewActivity.this.getPageId() == tipEvent.pageId) {
                DefaultNavigationBarCoverTip.d(TbWebViewActivity.this.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            } else {
                return true;
            }
        }
    };
    private h mTopToastEventListener = new h<TopToastEvent>() { // from class: com.baidu.tbadk.browser.TbWebViewActivity.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(TopToastEvent topToastEvent) {
            TbWebViewActivity.this.showTipToast(topToastEvent.isSuccess(), topToastEvent.getContent());
            return false;
        }
    };
    private boolean isShowFullScreen = false;
    CustomMessageListener htmlLoadMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_HTML_LOADED) { // from class: com.baidu.tbadk.browser.TbWebViewActivity.7
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
    };
    private final CustomMessageListener mSharePage = new CustomMessageListener(CmdConfigCustom.CMD_SHARE) { // from class: com.baidu.tbadk.browser.TbWebViewActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TbWebViewActivity.this.mShareParams = (String) customResponsedMessage.getData();
                TbWebViewActivity.this.showRightShareIcon();
            }
        }
    };

    static {
        mShareToTypes.put(LogConfig.LIVE_SHARE_WEIXIN_TIMELINE, LogConfig.LIVE_SHARE_WEIXIN_TIMELINE);
        mShareToTypes.put(LogConfig.LIVE_SHARE_WEIXIN_FRIEND, LogConfig.LIVE_SHARE_WEIXIN_FRIEND);
        mShareToTypes.put("qqdenglu", "qq_zone");
        mShareToTypes.put(LogConfig.LIVE_SHARE_WEIBO, "sina_weibo");
        mShareToTypes.put("qqweibo", "qq_weibo");
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        parserIntent();
        setIsTranslucent("open_full_screen_opacity_web_page".equals(this.mPageTranslucent) || "open_full_screen_opacity_web_page".equals(this.mPageType));
        setIsAddSwipeBackLayout(isTranslucent() ? false : true);
        super.onCreate(bundle);
        MessageManager.getInstance().runTask(CmdConfigCustom.CMD_WEBVIEW_PROXY, (Class) null);
        this.jsBridge = new com.baidu.tieba.tbadkCore.e.a();
        this.mCommonTbJsBridge = new CommonTbJsBridge(getPageContext().getPageActivity(), this.mWebView);
        this.jsBridge.a(new XiubaTbJsBridge(getPageContext()));
        this.jsBridge.a(this.mCommonTbJsBridge);
        this.jsBridge.a(new UegTbJsBridge(getPageContext()));
        this.jsBridge.a(buildGameDownloadJSPrompt());
        this.mCommonTbJsBridge.setJsPromptBridge(this.jsBridge);
        this.mProxy = new com.baidu.tieba.quickWebView.a(this.mWebView);
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

    private void parserIntent() {
        Uri parse;
        Intent intent = getIntent();
        if (intent != null) {
            this.mPageTranslucent = intent.getStringExtra(WebViewActivityConfig.TAG_PAGE_TRANSLUCENT);
            this.loadMyself = intent.getBooleanExtra(WebViewActivityConfig.TAG_LOAD_BY_WEB_CLIENT, false);
            String stringExtra = intent.getStringExtra("tag_url");
            if (!TextUtils.isEmpty(stringExtra) && (parse = Uri.parse(stringExtra)) != null) {
                try {
                    this.mPageType = parse.getQueryParameter("page_type");
                } catch (Exception e) {
                }
                try {
                    boolean contains = stringExtra.contains("recClose=1");
                    this.mPageFrom = al.getParamFromURL(stringExtra, "page_from");
                    if (contains) {
                        this.mWebViewCloseReceiver = new WebViewBroadcastReceiver();
                        this.mWebViewCloseReceiver.register(this);
                    }
                } catch (Exception e2) {
                }
                try {
                    Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
                    if (f.r(uri)) {
                        f.bhH().s(uri);
                    }
                } catch (Exception e3) {
                }
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        sendDetailBroadcast(MissionEvent.MESSAGE_START);
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.mWebView != null) {
            try {
                if (getUploadMessageAboveL() != null) {
                    getUploadMessageAboveL().onReceiveValue(null);
                    setUploadMessageAboveL(null);
                }
                this.mWebView.onResume();
            } catch (Exception e) {
                e.printStackTrace();
            }
            handlerWebViewResume();
            callHiddenWebViewMethod(MissionEvent.MESSAGE_RESUME);
            registerGetShareContentTask();
            if (this.jsBridge != null) {
                this.jsBridge.a(this.mWebView, "reshow", (HashMap) null);
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        if (this.mWebView != null) {
            try {
                this.mWebView.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
            handlerWebViewPause();
            callHiddenWebViewMethod(MissionEvent.MESSAGE_PAUSE);
            MessageManager.getInstance().unRegisterTask(2016568);
        }
    }

    public void addJsPromptInterface(com.baidu.tieba.tbadkCore.e.b bVar) {
        if (bVar != null) {
            this.jsBridge.a(bVar);
        }
    }

    public void removePromptInterface(com.baidu.tieba.tbadkCore.e.b bVar) {
        if (bVar != null) {
            this.jsBridge.b(bVar);
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
            this.mWebView.getSettings().setDatabasePath(getApplicationContext().getDir(NgWebView.APP_DATABASE_PATH, 0).getAbsolutePath());
            this.mWebView.setHorizontalScrollBarEnabled(false);
            this.mWebView.setHorizontalScrollbarOverlay(false);
            if (!isTranslucent()) {
                this.mWebView.setInitialScale(100);
                this.mWebView.setScrollBarStyle(33554432);
            }
            this.mWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.mWebView.setWebViewClient(new b());
            this.mWebView.setDownloadListener(new c());
            TbWebChromeClient tbWebChromeClient = new TbWebChromeClient(this);
            tbWebChromeClient.setOnJsPromptCallback(this.jsCallback);
            this.mWebView.setWebChromeClient(tbWebChromeClient);
            com.baidu.tieba.t.c.dQM().trackWebView(this, this.mWebView, tbWebChromeClient);
            if (this.mEnableJs) {
                addJavascriptInterface();
            }
            CompatibleUtile.getInstance().removeJavascriptInterface(this.mWebView);
            boolean isHybridBridgeEnabled = TbadkCoreApplication.getInst().isHybridBridgeEnabled();
            l a2 = q.a(isHybridBridgeEnabled, this.mWebView, (com.baidu.tbadk.core.hybrid.b) null);
            this.mHybridBridge = a2;
            if (isHybridBridgeEnabled) {
                a2.a(new n(a2) { // from class: com.baidu.tbadk.browser.TbWebViewActivity.16
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.n
                    public String bku() {
                        return "TBHY_COMMON_Performance";
                    }

                    @o(brB = false, value = "trackFPS")
                    private void trackFPS() {
                    }
                });
                a2.a(new com.baidu.tbadk.core.hybrid.a.a(a2));
                a2.a(new com.baidu.tbadk.core.hybrid.a.c(a2));
                a2.a(new com.baidu.tbadk.core.hybrid.a.b(a2));
                a2.a(new n(a2) { // from class: com.baidu.tbadk.browser.TbWebViewActivity.17
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.n
                    public String bku() {
                        return "TBHY_COMMON_Share";
                    }

                    @o(brB = false, value = TbConfig.TMP_SHARE_DIR_NAME)
                    private void share(JSONObject jSONObject) {
                        if (jSONObject != null) {
                            String optString = jSONObject.optString("title");
                            String optString2 = jSONObject.optString("desc");
                            String optString3 = jSONObject.optString("img");
                            String optString4 = jSONObject.optString("url");
                            String optString5 = jSONObject.optString("bid");
                            if (!StringUtils.isNULL(optString5)) {
                                TbWebViewActivity.this.mShareResultToFe = true;
                                TbWebViewActivity.this.mBid = optString5;
                            }
                            final ShareItem createShareContent = TbWebViewActivity.this.createShareContent(optString, optString4, optString2, optString3);
                            e.mA().post(new Runnable() { // from class: com.baidu.tbadk.browser.TbWebViewActivity.17.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    TbWebViewActivity.this.mView.showShareDialog(createShareContent);
                                }
                            });
                        }
                    }
                });
                a2.a(new n(a2) { // from class: com.baidu.tbadk.browser.TbWebViewActivity.18
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.n
                    public String bku() {
                        return "TBHY_COMMON_UISwitch";
                    }

                    @o(brB = false, value = "viewHideSwitch")
                    private void viewHideSwitch(JSONObject jSONObject) {
                        if (jSONObject != null) {
                            String optString = jSONObject.optJSONObject(TbConfig.TMP_SHARE_DIR_NAME).optString("value");
                            if ("1".equals(optString)) {
                                TbWebViewActivity.this.mShowShareItem = true;
                            } else if ("0".equals(optString)) {
                                TbWebViewActivity.this.mShowShareItem = false;
                            }
                            TbWebViewActivity.this.mView.jc(TbWebViewActivity.this.mShowShareItem);
                        }
                    }
                });
                a2.a(new n(a2) { // from class: com.baidu.tbadk.browser.TbWebViewActivity.2
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.n
                    public String bku() {
                        return "TBHY_COMMON_GAME_COMMENT";
                    }

                    @o(brB = false, value = "gameComment")
                    private void goToGameComment(JSONObject jSONObject) {
                        if (jSONObject != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsGameCommentActivityConfig(TbWebViewActivity.this.getPageContext().getPageActivity(), jSONObject.optInt(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE), jSONObject.optInt("forum_id"))));
                        }
                    }
                });
                a2.a(new n(a2) { // from class: com.baidu.tbadk.browser.TbWebViewActivity.3
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.n
                    public String bku() {
                        return "TBHY_COMMON_COMMENT_FLOOR";
                    }

                    @o(brB = false, value = "enterCommentFloor")
                    private void goToFrsGameSubPbActivity(JSONObject jSONObject) {
                        if (jSONObject != null && bh.checkUpIsLogin(TbWebViewActivity.this.getPageContext().getPageActivity())) {
                            String optString = jSONObject.optString("forum_id");
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsGameSubPbActivityConfig(TbWebViewActivity.this.getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toInt(optString, 0), jSONObject.optString("comment_id"))));
                        }
                    }
                });
                a2.a(new com.baidu.tbadk.browser.b(a2));
            }
            this.mWebView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tbadk.browser.TbWebViewActivity.4
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (TextUtils.isEmpty(TbWebViewActivity.this.mUrl) || !TbWebViewActivity.this.mUrl.contains("haokan.baidu.com/activity/")) {
                        return TbWebViewActivity.this.handleLongClick();
                    }
                    return false;
                }
            });
        }
        return this.mWebView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Uri[] uriArr;
        if (i == 1) {
            if (i2 == -1) {
                if (Build.VERSION.SDK_INT >= 21) {
                    if (getUploadMessageAboveL() != null) {
                        if (intent != null) {
                            String dataString = intent.getDataString();
                            ClipData clipData = intent.getClipData();
                            if (clipData != null) {
                                Uri[] uriArr2 = new Uri[clipData.getItemCount()];
                                for (int i3 = 0; i3 < clipData.getItemCount(); i3++) {
                                    uriArr2[i3] = clipData.getItemAt(i3).getUri();
                                }
                                uriArr = uriArr2;
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
                        return;
                    }
                    return;
                } else if (getUploadMessage() != null) {
                    getUploadMessage().onReceiveValue((intent == null || i2 != -1) ? null : intent.getData());
                    setUploadMessage(null);
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        switch (i) {
            case 1001:
                if (this.mHybridBridge != null) {
                    HashMap hashMap = new HashMap(4);
                    hashMap.put("errNo", "0");
                    hashMap.put("errMsg", "success");
                    m a2 = m.a("TBHY_COMMON_COMMENT_FLOOR_CALLBACK", "onGameSubCommentSuccess", hashMap, 0L, false);
                    if (this.mHybridBridge != null) {
                        this.mHybridBridge.a(a2);
                        return;
                    }
                    return;
                }
                return;
            case 11043:
                if (-1 == i2 && this.mCommonTbJsBridge != null && intent != null) {
                    int intExtra = intent.getIntExtra(LoginActivityConfig.SOCIAL_TYPE, 0);
                    String stringExtra = intent.getStringExtra("activity_id");
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put(LoginActivityConfig.SOCIAL_TYPE, Integer.valueOf(intExtra));
                    linkedHashMap.put("activityId", stringExtra);
                    this.jsBridge.a(this.mWebView, "thirdPartyLoginResultToH5", linkedHashMap);
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_WEBVIEW /* 12015 */:
                handleUploadResult(intent, i2);
                return;
            case RequestResponseCode.START_GAME_COMMENT_REQUEST_CODE /* 21002 */:
                if (i2 == -1 && this.mHybridBridge != null) {
                    HashMap hashMap2 = new HashMap(4);
                    hashMap2.put("errNo", "0");
                    hashMap2.put("errMsg", "success");
                    m a3 = m.a("TBJS_COMMON_Game_Comment", "onGameCommentSuccess", hashMap2, 0L, false);
                    if (this.mHybridBridge != null) {
                        this.mHybridBridge.a(a3);
                        return;
                    }
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                handleShareResult(intent, i2);
                newHandleShareResult(intent, i2);
                return;
            case RequestResponseCode.REQUEST_DO_YUANPACKAGE_PAY /* 25042 */:
                if (-1 == i2) {
                    finish();
                    return;
                }
                return;
            case RequestResponseCode.REQUEST_GUARD_CLUB_MEMBER_LIST /* 25045 */:
                if (this.mWebView != null) {
                    this.mWebView.reload();
                    return;
                }
                return;
            case 220010:
                if (-1 == i2 && this.mWebView != null) {
                    this.mWebView.reload();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void handleShareResult(Intent intent, int i) {
        if (this.mShareResultToFe) {
            this.mShareResultToFe = false;
            if (intent != null) {
                String str = mShareToTypes.get(intent.getStringExtra("share_to"));
                HashMap hashMap = new HashMap();
                boolean z = i == -1;
                hashMap.put("bid", this.mBid);
                hashMap.put("result", Boolean.valueOf(z));
                hashMap.put("channel", str);
                m a2 = m.a("TBJS_COMMON_Share", "onShareResult", hashMap, 0L, false);
                if (this.mHybridBridge != null) {
                    this.mHybridBridge.a(a2);
                }
                if (!StringUtils.isNull(this.mUrl) && this.mUrl.contains("topicgroupcallback=1") && intent != null && intent.getIntExtra("extra_share_status", -1) == 1) {
                    this.mWebView.loadUrl("javascript:window.__js_bridge_topic_group_share_action()");
                }
            }
        }
    }

    private void newHandleShareResult(Intent intent, int i) {
        if (this.mShareItem != null && i == -1) {
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            String stringExtra = intent.getStringExtra("complete_id");
            if (intExtra == 1) {
                sendCompleteTask(stringExtra);
                if (this.jsBridge != null) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("shareChannel", Integer.valueOf(intExtra2));
                    linkedHashMap.put("shareItem", this.mShareItem);
                    this.jsBridge.a(this.mWebView, "ShareSuccessNotification", linkedHashMap);
                }
            }
            if (intExtra == 3) {
                if (intExtra2 == 8 || intExtra2 == 6) {
                    sendCompleteTask(stringExtra);
                    if (this.jsBridge != null) {
                        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                        linkedHashMap2.put("shareChannel", Integer.valueOf(intExtra2));
                        linkedHashMap2.put("shareItem", this.mShareItem);
                        this.jsBridge.a(this.mWebView, "ShareSuccessNotification", linkedHashMap2);
                    }
                }
            }
        }
    }

    private void sendCompleteTask(String str) {
        if (!au.isEmpty(str)) {
            CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(2);
            completeTaskReqMsg.completeId = str;
            sendMessage(completeTaskReqMsg);
        }
    }

    private void handleUploadResult(Intent intent, int i) {
        if (i == -1 && intent != null) {
            try {
                String stringExtra = intent.getStringExtra("album_result");
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
                m a2 = m.a("TBJS_COMMON_Image", "onImageUploadFinish", hashMap, 0L, false);
                if (this.mHybridBridge != null) {
                    this.mHybridBridge.a(a2);
                }
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void addJavascriptInterface(Object obj, String str) {
        if (this.mWebView != null) {
            this.mWebView.addJavascriptInterface(obj, str);
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public View getWebView() {
        return this.mWebView;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0130  */
    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loadUrl(String str) {
        boolean z;
        if (this.isShowFullScreen && this.mView != null) {
            this.mView.setFullScreen();
        }
        if (!StringUtils.isNull(str)) {
            if (!str.contains("javascript:")) {
                com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readCache", -1, "", "type", "start", "url", str);
                if (QuickWebViewSwitch.getInOn()) {
                    String localUrlByUrl = getLocalUrlByUrl(str);
                    if (!TextUtils.isEmpty(localUrlByUrl)) {
                        com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readCache", -1, "", "type", "end", "url", localUrlByUrl, BdStatsConstant.StatsKey.TYPE, this.mModuleName);
                        z = true;
                        str = localUrlByUrl;
                        String substring = str.length() <= 100 ? str.substring(0, 100) : str;
                        TiebaStatic.log(new ar("c13835").dR("obj_locate", !z ? "1" : "2").dR("obj_source", substring).ap("obj_type", this.mOfflineErrorType).ap("obj_name", com.baidu.tieba.quickWebView.b.mPT).dR("obj_param1", this.mModuleName).dR("obj_id", this.mVersion));
                        this.mOfflineErrorType = 0;
                        this.mVersion = "0.0.0.0";
                        this.mModuleName = "";
                        com.baidu.tbadk.core.d.a.a("search", -1L, 0, "LoadUrl", 0, "", "loadUrl", substring, "switch", Boolean.valueOf(QuickWebViewSwitch.getInOn()));
                    }
                } else {
                    this.mOfflineErrorType = 5;
                }
                z = false;
                if (str.length() <= 100) {
                }
                TiebaStatic.log(new ar("c13835").dR("obj_locate", !z ? "1" : "2").dR("obj_source", substring).ap("obj_type", this.mOfflineErrorType).ap("obj_name", com.baidu.tieba.quickWebView.b.mPT).dR("obj_param1", this.mModuleName).dR("obj_id", this.mVersion));
                this.mOfflineErrorType = 0;
                this.mVersion = "0.0.0.0";
                this.mModuleName = "";
                com.baidu.tbadk.core.d.a.a("search", -1L, 0, "LoadUrl", 0, "", "loadUrl", substring, "switch", Boolean.valueOf(QuickWebViewSwitch.getInOn()));
            }
            if (this.mWebView != null) {
                if (this.mCommonTbJsBridge != null) {
                    this.mCommonTbJsBridge.setLastLoadUrlTime(System.currentTimeMillis());
                }
                if (this.loadMyself) {
                    this.mWebView.loadUrl(str);
                } else {
                    CompatibleUtile.getInstance().loadUrl(this.mWebView, str);
                }
            }
        }
    }

    private String getLocalUrlByUrl(String str) {
        String str2;
        URL url;
        com.baidu.tieba.quickWebView.data.a Rg;
        boolean z;
        String[] split;
        HashMap hashMap = new HashMap();
        try {
            url = new URL(str);
            Rg = com.baidu.tieba.quickWebView.c.dCM().Rg(url.getPath());
        } catch (MalformedURLException e) {
            str2 = null;
        }
        if (Rg == null) {
            if (com.baidu.tieba.quickWebView.c.dCM().dCN() != null) {
                this.mOfflineErrorType = 3;
            }
            return null;
        } else if (!Rg.mQg) {
            this.mOfflineErrorType = 4;
            com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readCache", -1, "processing bundle", "url", str, BdStatsConstant.StatsKey.TYPE, Rg.ktS);
            return null;
        } else {
            String Re = com.baidu.tieba.quickWebView.b.dCI().Re(Rg.ktS);
            if (TextUtils.isEmpty(Rg.ktS) || TextUtils.isEmpty(Rg.path) || TextUtils.isEmpty(Re)) {
                return null;
            }
            this.mModuleName = Rg.ktS;
            this.mVersion = Re;
            String str3 = com.baidu.tieba.quickWebView.b.dCI().getCacheDir() + "/" + Rg.ktS + "/" + Re + "/";
            String str4 = !Rg.path.endsWith(DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION) ? Rg.path + DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION : Rg.path;
            String str5 = str3 + str4;
            File file = new File(str5);
            ArrayList<String> arrayList = Rg.mQj;
            if (!str5.contains("/android_asset/")) {
                if (!file.exists()) {
                    this.mOfflineErrorType = 2;
                    com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readCache", -1, "path not found", BdStatsConstant.StatsKey.TYPE, this.mModuleName);
                    return null;
                } else if (y.isEmpty(arrayList)) {
                    return null;
                } else {
                    for (String str6 : arrayList) {
                        if (StringUtils.isNull(str6)) {
                            com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readCache", -1, "static file path is null", BdStatsConstant.StatsKey.TYPE, this.mModuleName);
                            this.mOfflineErrorType = 1;
                            return null;
                        } else if (!new File(str3, str6).exists()) {
                            this.mOfflineErrorType = 1;
                            com.baidu.tbadk.core.d.a.a("OfflineCache", -1L, -1, "readCache", -1, "bundle incomplete", "url", str6, BdStatsConstant.StatsKey.TYPE, this.mModuleName);
                            return null;
                        }
                    }
                }
            }
            String query = url.getQuery();
            String str7 = "file://" + str3 + str4;
            try {
                if (!TextUtils.isEmpty(query)) {
                    str7 = str7 + "?" + query;
                }
            } catch (MalformedURLException e2) {
                str2 = str7;
            }
            if (Rg.mQi != null && Rg.mQi.size() != 0) {
                if (!TextUtils.isEmpty(query) && (split = query.split(ETAG.ITEM_SEPARATOR)) != null) {
                    for (String str8 : split) {
                        String[] split2 = str8.split("=");
                        if (split2 != null && split2.length == 2) {
                            hashMap.put("{" + split2[0] + "}", split2[1]);
                        }
                    }
                }
                hashMap.put("{client_version}", TbConfig.getVersion());
                hashMap.put("{client_type}", "2");
                Iterator<String> it = Rg.mQi.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    StringBuilder sb = new StringBuilder();
                    String query2 = new URL(next).getQuery();
                    if (!TextUtils.isEmpty(query2)) {
                        String[] split3 = query2.split(ETAG.ITEM_SEPARATOR);
                        if (split3 != null) {
                            boolean z2 = true;
                            int length = split3.length;
                            int i = 0;
                            while (i < length) {
                                String str9 = split3[i];
                                if (!z2) {
                                    sb.append(ETAG.ITEM_SEPARATOR);
                                    z = z2;
                                } else {
                                    z = false;
                                }
                                String[] split4 = str9.split("=");
                                if (split4 != null && split4.length == 2) {
                                    String str10 = (String) hashMap.get(split4[1]);
                                    if (str10 == null) {
                                        str10 = split4[1];
                                        if (str10.contains("{") && str10.contains("}")) {
                                            str10 = null;
                                        }
                                    }
                                    sb.append(split4[0]);
                                    sb.append("=");
                                    if (!TextUtils.isEmpty(str10)) {
                                        sb.append(str10);
                                    }
                                }
                                i++;
                                z2 = z;
                            }
                        }
                        String sb2 = sb.toString();
                        if (!TextUtils.isEmpty(sb2)) {
                            next = next.replace(query2, sb2);
                        }
                    }
                    QuickWebViewBridgeData quickWebViewBridgeData = new QuickWebViewBridgeData();
                    quickWebViewBridgeData.type = "get";
                    quickWebViewBridgeData.url = next;
                    quickWebViewBridgeData.module = Rg.ktS;
                    quickWebViewBridgeData.begin = System.currentTimeMillis();
                    if (this.mProxy != null) {
                        this.mProxy.a(quickWebViewBridgeData, null);
                    }
                }
                str2 = str7;
                return str2;
            }
            return str7;
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void webViewDestory() {
        if (this.jsBridge != null) {
            this.jsBridge.dNZ();
        }
        if (this.mWebView != null) {
            this.mWebView.getSettings().setBuiltInZoomControls(true);
            this.mWebView.setVisibility(8);
            e.mA().postDelayed(new Runnable() { // from class: com.baidu.tbadk.browser.TbWebViewActivity.5
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
            }, ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    /* loaded from: classes.dex */
    protected class b extends WebViewClient {
        public boolean mIsPageLoading;

        /* JADX INFO: Access modifiers changed from: protected */
        public b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (TbWebViewActivity.this.mWebView != null) {
                this.mIsPageLoading = false;
                TbWebViewActivity.this.mUrl = str;
                TbWebViewActivity.this.mWebView.loadUrl("javascript:window.local_obj.getIfFullScreen(document.getElementsByName(\"fc_fullscreen\")[0].content);");
                String title = TbWebViewActivity.this.mWebView.getTitle();
                if (!TbWebViewActivity.this.mFixTitle && !StringUtils.isNull(title)) {
                    TbWebViewActivity.this.mUrlTitle = title;
                }
                if (!TbWebViewActivity.this.isShowFullScreen) {
                    TbWebViewActivity.this.mView.zD(TbWebViewActivity.this.mUrlTitle);
                }
                if (TbWebViewActivity.this.isTranslucent()) {
                    TbWebViewActivity.this.mView.setNavBarVisibility(false);
                } else {
                    TbWebViewActivity.this.mView.setNavBarVisibility(TbWebViewActivity.this.mIsShowNavBar);
                }
                TbWebViewActivity.this.mView.jc(TbWebViewActivity.this.isNeedShowShareItem());
                if (!StringUtils.isNull(TbWebViewActivity.this.mUrl) && TbWebViewActivity.this.mUrl.contains(TbWebViewActivity.KEY_TASK_CENTER_PREFIX_URL)) {
                    TbWebViewActivity.this.mView.mL(8);
                }
                TbWebViewActivity.this.hideProgressBar();
                TbWebViewActivity.this.stopLoadTimer();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (TbWebViewActivity.this.mWebView != null) {
                this.mIsPageLoading = false;
                TbWebViewActivity.this.mWebView.stopLoading();
                TbWebViewActivity.this.stopLoadTimer();
                TbWebViewActivity.this.onReceivedError(i);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (TbWebViewActivity.this.mWebView != null) {
                this.mIsPageLoading = true;
                TbWebViewActivity.this.mUrl = str;
                TbWebViewActivity.this.showProgressBar();
                TbWebViewActivity.this.startLoadTimer();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tbadk.browser.TbWebViewActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (RedirectInterceptionSwitch.isOn() && this.mIsPageLoading && Build.VERSION.SDK_INT >= 26 && (UtilHelper.isOppoDevice() || UtilHelper.isVivoDevice())) {
                if (URLUtil.isNetworkUrl(str) || !str.startsWith("tiebaclient://")) {
                    return false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2921361, str));
                return true;
            }
            int a2 = bf.bsV().a(TbWebViewActivity.this.getPageContext(), new String[]{str, TbWebViewActivity.this.mUrl});
            if (a2 == 1) {
                TbWebViewActivity.this.finish();
                return true;
            } else if (a2 == 0) {
                return true;
            } else {
                if (a2 != 2) {
                    TbWebViewActivity.this.mUrl = str;
                    if (TbWebViewActivity.this.isShowFullScreen) {
                        TbWebViewActivity.this.isShowFullScreen = false;
                        TbWebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.baidu.tbadk.browser.TbWebViewActivity.b.1
                            @Override // java.lang.Runnable
                            public void run() {
                                TbWebViewActivity.this.mView.bkH();
                            }
                        });
                    }
                    TbWebViewActivity.this.hideCrashTip();
                    if (URLUtil.isNetworkUrl(TbWebViewActivity.this.mUrl)) {
                        TbWebViewActivity.this.showProgressBar();
                        if (!TbWebViewActivity.this.isShowFullScreen || TbWebViewActivity.this.mView == null) {
                            return false;
                        }
                        TbWebViewActivity.this.mView.setFullScreen();
                        return false;
                    }
                    Intent parseIntentFromUrl = TbWebViewActivity.this.parseIntentFromUrl(TbWebViewActivity.this.getApplicationContext(), TbWebViewActivity.this.mUrl);
                    if (parseIntentFromUrl != null) {
                        try {
                            TbWebViewActivity.this.startActivity(parseIntentFromUrl);
                        } catch (Throwable th) {
                        }
                    }
                    return true;
                }
                return false;
            }
        }
    }

    /* loaded from: classes.dex */
    private class c implements DownloadListener {
        private c() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (!StringUtils.isNull(str)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                    TbWebViewActivity.this.startActivity(intent);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public boolean webViewGoBack() {
        if (this.mWebView != null && this.mWebView.canGoBack()) {
            this.mWebView.goBack();
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void initCookie() {
        com.baidu.tbadk.browser.a.initCookie(getApplicationContext());
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void onReceivedError(int i) {
        handleError();
    }

    public void handleError() {
        if (this.mWebView != null) {
            this.mUrl = this.mWebView.getUrl();
            this.mWebView.stopLoading();
        }
        hideProgressBar();
        if (isTranslucent()) {
            if (this.mWebView != null) {
                this.mWebView.setVisibility(8);
                return;
            }
            return;
        }
        showNoDataView();
    }

    public void onReceivedTitle() {
        handleError();
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void initWebView() {
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        try {
            super.unregisterReceiver(broadcastReceiver);
        } catch (Throwable th) {
        }
    }

    public ValueCallback<Uri> getUploadMessage() {
        return this.mUploadMessage;
    }

    public void setUploadMessage(ValueCallback<Uri> valueCallback) {
        this.mUploadMessage = valueCallback;
    }

    public ValueCallback<Uri[]> getUploadMessageAboveL() {
        return this.mUploadMessageAboveL;
    }

    public void setUploadMessageAboveL(ValueCallback<Uri[]> valueCallback) {
        this.mUploadMessageAboveL = valueCallback;
    }

    private com.baidu.tieba.tbadkCore.e.b buildGameDownloadJSPrompt() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GAME_JS_HANDLER_REGISTER, com.baidu.tieba.tbadkCore.e.b.class, getPageContext());
        if (runTask == null || runTask.getData() == null) {
            return null;
        }
        return (com.baidu.tieba.tbadkCore.e.b) runTask.getData();
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    protected void setFullScreen() {
        this.isShowFullScreen = true;
        if (this.isShowFullScreen && this.mView != null) {
            runOnUiThread(new Runnable() { // from class: com.baidu.tbadk.browser.TbWebViewActivity.6
                @Override // java.lang.Runnable
                public void run() {
                    TbWebViewActivity.this.mView.setFullScreen();
                }
            });
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, android.app.Activity
    public void onBackPressed() {
        if (!needDealClickGoBack()) {
            super.onBackPressed();
        }
    }

    public boolean needDealClickGoBack() {
        if (!this.isDisableGoBack || this.mCommonTbJsBridge == null) {
            return false;
        }
        this.jsBridge.a(this.mWebView, "clickGoBackToH5", (HashMap) null);
        this.isDisableGoBack = false;
        return true;
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    protected void onWebViewLogin(boolean z) {
        super.onWebViewLogin(z);
        if (this.mWebView != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("no", z ? "1" : "0");
                loadUrl("javascript:tiebaClientLoginCallBack(" + jSONObject.toString() + ")");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (isTranslucent() || this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            super.enterExitAnimation();
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

    public void refreshTitle(String str) {
        if (!this.mFixTitle) {
            if (!StringUtils.isNull(str)) {
                this.mUrlTitle = str;
            }
            if (!this.isShowFullScreen && this.mView != null) {
                this.mView.zD(this.mUrlTitle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRightShareIcon() {
        if (this.mView != null) {
            this.mView.bkz();
        }
    }

    private void showRightMoreIcon(int i) {
        if (this.mView != null) {
            this.mView.mL(i);
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    protected void showShare() {
        if (!StringUtils.isNull(this.mShareParams)) {
            try {
                JSONObject jSONObject = new JSONObject(this.mShareParams);
                final ShareItem createShareContent = createShareContent(jSONObject.optString("title"), jSONObject.optString("url"), jSONObject.optString("desc"), jSONObject.optString("img"));
                e.mA().post(new Runnable() { // from class: com.baidu.tbadk.browser.TbWebViewActivity.9
                    @Override // java.lang.Runnable
                    public void run() {
                        TbWebViewActivity.this.mView.showShareDialog(createShareContent);
                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    protected String getShareInfo() {
        return this.mShareInfo;
    }

    private void registerGetShareContentTask() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016568, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tbadk.browser.TbWebViewActivity.10
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<ShareItem> run(CustomMessage<String> customMessage) {
                if (customMessage == null || !(customMessage.getData() instanceof String)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(customMessage.getData());
                    String optString = jSONObject.optString("title");
                    String optString2 = jSONObject.optString("desc");
                    String optString3 = jSONObject.optString("img");
                    String optString4 = jSONObject.optString("url");
                    String optString5 = jSONObject.optString(AlbumActivityConfig.FROM_TOPIC);
                    String optString6 = jSONObject.optString("wbtitle");
                    String optString7 = jSONObject.optString("wbcontent");
                    TbWebViewActivity.this.mShareItem = TbWebViewActivity.this.createShareContent(optString, optString4, optString2, optString3);
                    TbWebViewActivity.this.mShareItem.topic = optString5;
                    TbWebViewActivity.this.mShareItem.fvd = optString6;
                    TbWebViewActivity.this.mShareItem.fve = optString7;
                    TbWebViewActivity.this.mShareItem.shareType = jSONObject.optInt("shareimg");
                    TbWebViewActivity.this.mShareItem.fvl = jSONObject.optInt("weixin_disable");
                    String optString8 = jSONObject.optString("extdata");
                    if (!StringUtils.isNull(optString8)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(optString8);
                            String optString9 = jSONObject2.optString("activityid");
                            String optString10 = jSONObject2.optString("missionid");
                            if (!StringUtils.isNull(optString9) && !StringUtils.isNull(optString10)) {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put(optString9, optString10);
                                TbWebViewActivity.this.mShareItem.taskCompleteId = jSONObject3.toString();
                            }
                        } catch (JSONException e) {
                        }
                    }
                    return new CustomResponsedMessage<>(2016568, TbWebViewActivity.this.mShareItem);
                } catch (JSONException e2) {
                    BdLog.e(e2);
                    return null;
                }
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleLongClick() {
        WebView.HitTestResult hitTestResult;
        if (this.mWebView == null || (hitTestResult = this.mWebView.getHitTestResult()) == null || hitTestResult.getType() != 5) {
            return false;
        }
        if (this.mOnDialogItemClickListener == null) {
            this.mOnDialogItemClickListener = new a();
        }
        this.mOnDialogItemClickListener.zC(hitTestResult.getExtra());
        createListMenu(this.mOnDialogItemClickListener.bky(), this.mOnDialogItemClickListener);
        showListMenu();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mProxy != null) {
            this.mProxy.onDestory();
            this.mProxy = null;
        }
        if (this.mCommonTbJsBridge != null) {
            this.mCommonTbJsBridge.onDestroy();
        }
        if (this.mWebViewCloseReceiver != null) {
            this.mWebViewCloseReceiver.unregister();
        }
        unRegisterResponsedEventListener();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements b.InterfaceC0558b {
        private String eHs;
        private int eHr = 1;
        private List<Integer> eHt = new ArrayList();

        a() {
        }

        public void zC(String str) {
            this.eHs = str;
        }

        protected String[] bky() {
            this.eHt.clear();
            ArrayList arrayList = new ArrayList();
            arrayList.add(TbWebViewActivity.this.getPageContext().getString(R.string.save_to_local));
            this.eHt.add(Integer.valueOf(this.eHr));
            return (String[]) arrayList.toArray(new String[0]);
        }

        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0558b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar == TbWebViewActivity.this.getListMenu() && i < this.eHt.size() && i >= 0) {
                if (this.eHt.get(i).intValue() == 1) {
                    if (TbWebViewActivity.this.mPermissionJudgement == null) {
                        TbWebViewActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    TbWebViewActivity.this.mPermissionJudgement.clearRequestPermissionList();
                    TbWebViewActivity.this.mPermissionJudgement.appendRequestPermission(TbWebViewActivity.this, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!TbWebViewActivity.this.mPermissionJudgement.startRequestPermission(TbWebViewActivity.this)) {
                        new p(TbWebViewActivity.this.getActivity(), this.eHs, new p.a() { // from class: com.baidu.tbadk.browser.TbWebViewActivity.a.1
                            @Override // com.baidu.tbadk.util.p.a
                            public void onError(int i2, String str) {
                            }

                            @Override // com.baidu.tbadk.util.p.a
                            public void onSuccess(String str) {
                                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.tb_webview_download_image_success_tip);
                            }
                        }).execute(new String[0]);
                    } else {
                        return;
                    }
                }
                bVar.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerWebViewResume() {
        if (this.timerData != null && this.timerData.isOpen() && !this.timerData.bAE() && this.mCommonTbJsBridge != null) {
            try {
                this.timerData.kE(true);
                long currentTimeMillis = System.currentTimeMillis();
                long j = com.baidu.tbadk.core.sharedPref.b.brQ().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_spring_festival_timer"), 0L);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("enter_time", String.valueOf(currentTimeMillis));
                String valueOf = String.valueOf(j);
                if (j == 0) {
                    valueOf = "";
                }
                jSONObject.put("leave_time", valueOf);
                jSONObject.put("resultCode", 1);
                this.mCommonTbJsBridge.dealSpringFestivalTimer(this.timerData.getMethod(), jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void handlerWebViewPause() {
        if (this.timerData != null && this.timerData.isOpen()) {
            this.timerData.bAF();
            com.baidu.tbadk.core.sharedPref.b.brQ().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_spring_festival_timer"), System.currentTimeMillis());
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity
    protected void onUserChanged(boolean z) {
        if (this.jsBridge != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("isLogin", Boolean.valueOf(z));
            this.jsBridge.a(this.mWebView, "loginResultToH5", linkedHashMap);
            setRefreshPage(false);
        }
    }

    public void setRefreshPage(boolean z) {
        this.isNeedRefresh = z;
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jsBridge != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("skin", ap.bsK());
            this.jsBridge.a(this.mWebView, "changeSkinType", linkedHashMap);
        }
    }

    private void sendDetailBroadcast(String str) {
        if ("live".equals(this.mPageFrom)) {
            Intent intent = new Intent();
            intent.putExtra("DetailLifecycle", str);
            intent.setAction("com.baidu.tieba.live.action.detail_broadcast");
            sendBroadcast(intent, WebViewBroadcastReceiver.BROADCAST_PERMISSION_CLOSE_WEBVIEW);
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        sendDetailBroadcast(MissionEvent.MESSAGE_STOP);
    }
}
