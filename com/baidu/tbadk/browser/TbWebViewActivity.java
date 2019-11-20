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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsGameCommentActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGameSubPbActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.hybrid.BridgeWebView;
import com.baidu.tbadk.core.hybrid.l;
import com.baidu.tbadk.core.hybrid.m;
import com.baidu.tbadk.core.hybrid.n;
import com.baidu.tbadk.core.hybrid.o;
import com.baidu.tbadk.core.hybrid.q;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.data.i;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.t.bb;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class TbWebViewActivity extends BaseWebViewActivity {
    public static final int FILECHOOSER_RESULTCODE = 1;
    private static final String KEY_TASK_CENTER_PREFIX_URL = "https://haokan.baidu.com/activity/";
    private com.baidu.tieba.tbadkCore.e.a jsBridge;
    private String mBid;
    private com.baidu.tbadk.browser.b mCommonTbJsBridge;
    private l mHybridBridge;
    private a mOnDialogItemClickListener;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgement;
    private String mShareInfo;
    private com.baidu.tbadk.coreExtra.c.e mShareItem;
    private String mShareParams;
    private ValueCallback<Uri> mUploadMessage;
    private ValueCallback<Uri[]> mUploadMessageAboveL;
    private i timerData;
    private static boolean sFrameLostTracked = false;
    private static final HashMap<String, String> mShareToTypes = new HashMap<>();
    protected BridgeWebView mWebView = null;
    private com.baidu.tieba.tbadkCore.e.c jsCallback = new com.baidu.tieba.tbadkCore.e.c() { // from class: com.baidu.tbadk.browser.TbWebViewActivity.1
        @Override // com.baidu.tieba.tbadkCore.e.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            if (TbWebViewActivity.this.jsBridge != null) {
                return TbWebViewActivity.this.jsBridge.a(str, jsPromptResult);
            }
            return false;
        }
    };
    private boolean mShowShareItem = true;
    private String mPageType = "normal";
    public boolean isDisableGoBack = false;
    private final CustomMessageListener mSetShareInfoListener = new CustomMessageListener(2016566) { // from class: com.baidu.tbadk.browser.TbWebViewActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TbWebViewActivity.this.mShareInfo = (String) customResponsedMessage.getData();
            }
        }
    };
    private final CustomMessageListener mSpringFestivalTimerListener = new CustomMessageListener(2156673) { // from class: com.baidu.tbadk.browser.TbWebViewActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof i)) {
                TbWebViewActivity.this.timerData = (i) customResponsedMessage.getData();
                if (TbWebViewActivity.this.timerData.isOpen()) {
                    TbWebViewActivity.this.handlerWebViewResume();
                }
            }
        }
    };
    private final CustomMessageListener mSelfLoadJsListener = new CustomMessageListener(2921424) { // from class: com.baidu.tbadk.browser.TbWebViewActivity.12
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
    private boolean isShowFullScreen = false;
    CustomMessageListener htmlLoadMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_HTML_LOADED) { // from class: com.baidu.tbadk.browser.TbWebViewActivity.5
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
    private final CustomMessageListener mFinishThisPage = new CustomMessageListener(CmdConfigCustom.CMD_FINISH_THIS_PAGE) { // from class: com.baidu.tbadk.browser.TbWebViewActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                TbWebViewActivity.this.finish();
            }
        }
    };
    private final CustomMessageListener mSharePage = new CustomMessageListener(CmdConfigCustom.CMD_SHARE) { // from class: com.baidu.tbadk.browser.TbWebViewActivity.7
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
        Uri parse;
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra("tag_url");
            if (!TextUtils.isEmpty(stringExtra) && (parse = Uri.parse(stringExtra)) != null) {
                try {
                    this.mPageType = parse.getQueryParameter("page_type");
                } catch (Exception e) {
                }
            }
        }
        setIsTranslucent("open_full_screen_opacity_web_page".equals(this.mPageType));
        setIsAddSwipeBackLayout(!isTranslucent());
        super.onCreate(bundle);
        MessageManager.getInstance().runTask(CmdConfigCustom.CMD_WEBVIEW_PROXY, (Class) null);
        this.jsBridge = new com.baidu.tieba.tbadkCore.e.a();
        this.mCommonTbJsBridge = new com.baidu.tbadk.browser.b(getPageContext().getPageActivity(), this.mWebView);
        this.jsBridge.a(new XiubaTbJsBridge(getPageContext()));
        this.jsBridge.a(this.mCommonTbJsBridge);
        this.jsBridge.a(new e(getPageContext()));
        this.jsBridge.a(buildGameDownloadJSPrompt());
        if (this.mNeedCookie) {
            initCookie();
        }
        registerListener(this.htmlLoadMessageListener);
        registerListener(this.mFinishThisPage);
        registerListener(this.mSharePage);
        registerListener(this.mSetShareInfoListener);
        registerListener(this.mSpringFestivalTimerListener);
        this.mSelfLoadJsListener.setSelfListener(true);
        registerListener(this.mSelfLoadJsListener);
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
            callHiddenWebViewMethod("onResume");
            registerGetShareContentTask();
            if (this.mCommonTbJsBridge != null) {
                this.mCommonTbJsBridge.afN();
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
            callHiddenWebViewMethod("onPause");
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
            this.mWebView.getSettings().setDatabasePath(getApplicationContext().getDir("databases", 0).getAbsolutePath());
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
            com.baidu.tieba.r.c.cra().trackWebView(this, this.mWebView, tbWebChromeClient);
            if (this.mEnableJs) {
                addJavascriptInterface();
            }
            CompatibleUtile.getInstance().removeJavascriptInterface(this.mWebView);
            boolean isHybridBridgeEnabled = TbadkCoreApplication.getInst().isHybridBridgeEnabled();
            l a2 = q.a(isHybridBridgeEnabled, this.mWebView, (com.baidu.tbadk.core.hybrid.b) null);
            this.mHybridBridge = a2;
            if (isHybridBridgeEnabled) {
                a2.a(new n(a2) { // from class: com.baidu.tbadk.browser.TbWebViewActivity.13
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.n
                    public String afT() {
                        return "TBHY_COMMON_Performance";
                    }

                    @o(alB = false, value = "trackFPS")
                    private void trackFPS() {
                    }
                });
                a2.a(new com.baidu.tbadk.core.hybrid.a.a(a2));
                a2.a(new com.baidu.tbadk.core.hybrid.a.c(a2));
                a2.a(new com.baidu.tbadk.core.hybrid.a.b(a2));
                a2.a(new n(a2) { // from class: com.baidu.tbadk.browser.TbWebViewActivity.14
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.n
                    public String afT() {
                        return "TBHY_COMMON_Share";
                    }

                    @o(alB = false, value = TbConfig.TMP_SHARE_DIR_NAME)
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
                            final com.baidu.tbadk.coreExtra.c.e createShareContent = TbWebViewActivity.this.createShareContent(optString, optString4, optString2, optString3);
                            com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tbadk.browser.TbWebViewActivity.14.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    TbWebViewActivity.this.mView.a(createShareContent);
                                }
                            });
                        }
                    }
                });
                a2.a(new n(a2) { // from class: com.baidu.tbadk.browser.TbWebViewActivity.15
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.n
                    public String afT() {
                        return "TBHY_COMMON_UISwitch";
                    }

                    @o(alB = false, value = "viewHideSwitch")
                    private void viewHideSwitch(JSONObject jSONObject) {
                        if (jSONObject != null) {
                            String optString = jSONObject.optJSONObject(TbConfig.TMP_SHARE_DIR_NAME).optString("value");
                            if ("1".equals(optString)) {
                                TbWebViewActivity.this.mShowShareItem = true;
                            } else if ("0".equals(optString)) {
                                TbWebViewActivity.this.mShowShareItem = false;
                            }
                            TbWebViewActivity.this.mView.dR(TbWebViewActivity.this.mShowShareItem);
                        }
                    }
                });
                a2.a(new n(a2) { // from class: com.baidu.tbadk.browser.TbWebViewActivity.16
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.n
                    public String afT() {
                        return "TBHY_COMMON_GAME_COMMENT";
                    }

                    @o(alB = false, value = "gameComment")
                    private void goToGameComment(JSONObject jSONObject) {
                        if (jSONObject != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsGameCommentActivityConfig(TbWebViewActivity.this.getPageContext().getPageActivity(), jSONObject.optInt("score"), jSONObject.optInt("forum_id"))));
                        }
                    }
                });
                a2.a(new n(a2) { // from class: com.baidu.tbadk.browser.TbWebViewActivity.17
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.n
                    public String afT() {
                        return "TBHY_COMMON_COMMENT_FLOOR";
                    }

                    @o(alB = false, value = "enterCommentFloor")
                    private void goToFrsGameSubPbActivity(JSONObject jSONObject) {
                        if (jSONObject != null && bc.checkUpIsLogin(TbWebViewActivity.this.getPageContext().getPageActivity())) {
                            String optString = jSONObject.optString("forum_id");
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsGameSubPbActivityConfig(TbWebViewActivity.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.toInt(optString, 0), jSONObject.optString("comment_id"))));
                        }
                    }
                });
                a2.a(new com.baidu.tbadk.browser.c(a2));
            }
            this.mWebView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tbadk.browser.TbWebViewActivity.2
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
                    this.mCommonTbJsBridge.D(intent.getIntExtra(LoginActivityConfig.SOCIAL_TYPE, 0), intent.getStringExtra("activity_id"));
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
                if (this.mCommonTbJsBridge != null) {
                    this.mCommonTbJsBridge.a(intExtra2, this.mShareItem);
                }
            }
            if (intExtra == 3) {
                if (intExtra2 == 8 || intExtra2 == 6) {
                    sendCompleteTask(stringExtra);
                    if (this.mCommonTbJsBridge != null) {
                        this.mCommonTbJsBridge.a(intExtra2, this.mShareItem);
                    }
                }
            }
        }
    }

    private void sendCompleteTask(String str) {
        if (!aq.isEmpty(str)) {
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

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void loadUrl(String str) {
        if (this.isShowFullScreen && this.mView != null) {
            this.mView.setFullScreen();
        }
        if (this.mWebView != null) {
            CompatibleUtile.getInstance().loadUrl(this.mWebView, str);
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void webViewDestory() {
        if (this.jsBridge != null) {
            this.jsBridge.coR();
        }
        if (this.mWebView != null) {
            this.mWebView.getSettings().setBuiltInZoomControls(true);
            this.mWebView.setVisibility(8);
            com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tbadk.browser.TbWebViewActivity.3
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
        public boolean bUb;

        protected b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (TbWebViewActivity.this.mWebView != null) {
                this.bUb = false;
                TbWebViewActivity.this.mUrl = str;
                TbWebViewActivity.this.mWebView.loadUrl("javascript:window.local_obj.getIfFullScreen(document.getElementsByName(\"fc_fullscreen\")[0].content);");
                String title = TbWebViewActivity.this.mWebView.getTitle();
                if (!TbWebViewActivity.this.mFixTitle && !StringUtils.isNull(title)) {
                    TbWebViewActivity.this.mUrlTitle = title;
                }
                if (!TbWebViewActivity.this.isShowFullScreen) {
                    TbWebViewActivity.this.mView.mH(TbWebViewActivity.this.mUrlTitle);
                }
                if (TbWebViewActivity.this.isTranslucent()) {
                    TbWebViewActivity.this.mView.setNavBarVisibility(false);
                } else {
                    TbWebViewActivity.this.mView.setNavBarVisibility(TbWebViewActivity.this.mIsShowNavBar);
                }
                TbWebViewActivity.this.mView.dR(TbWebViewActivity.this.isNeedShowShareItem());
                if (!StringUtils.isNull(TbWebViewActivity.this.mUrl) && TbWebViewActivity.this.mUrl.contains(TbWebViewActivity.KEY_TASK_CENTER_PREFIX_URL)) {
                    TbWebViewActivity.this.mView.hm(8);
                }
                TbWebViewActivity.this.hideProgressBar();
                TbWebViewActivity.this.stopLoadTimer();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (TbWebViewActivity.this.mWebView != null) {
                this.bUb = false;
                TbWebViewActivity.this.mWebView.stopLoading();
                TbWebViewActivity.this.stopLoadTimer();
                TbWebViewActivity.this.onReceivedError(i);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (TbWebViewActivity.this.mWebView != null) {
                this.bUb = true;
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
            if (bb.isOn() && this.bUb && Build.VERSION.SDK_INT >= 26 && (UtilHelper.isOppoDevice() || UtilHelper.isVivoDevice())) {
                return false;
            }
            int a = ba.amO().a(TbWebViewActivity.this.getPageContext(), new String[]{str, TbWebViewActivity.this.mUrl});
            if (a == 1) {
                TbWebViewActivity.this.finish();
                return true;
            } else if (a == 0) {
                return true;
            } else {
                TbWebViewActivity.this.mUrl = str;
                if (TbWebViewActivity.this.isShowFullScreen) {
                    TbWebViewActivity.this.isShowFullScreen = false;
                    TbWebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.baidu.tbadk.browser.TbWebViewActivity.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TbWebViewActivity.this.mView.agg();
                        }
                    });
                }
                TbWebViewActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tbadk.browser.TbWebViewActivity.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        TbWebViewActivity.this.refresh();
                    }
                }, 30L);
                return true;
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
            runOnUiThread(new Runnable() { // from class: com.baidu.tbadk.browser.TbWebViewActivity.4
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
        this.mCommonTbJsBridge.afO();
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
        if (isTranslucent()) {
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
                this.mView.mH(this.mUrlTitle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRightShareIcon() {
        if (this.mView != null) {
            this.mView.afZ();
        }
    }

    private void showRightMoreIcon(int i) {
        if (this.mView != null) {
            this.mView.hm(i);
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    protected void showShare() {
        if (!StringUtils.isNull(this.mShareParams)) {
            try {
                JSONObject jSONObject = new JSONObject(this.mShareParams);
                final com.baidu.tbadk.coreExtra.c.e createShareContent = createShareContent(jSONObject.optString("title"), jSONObject.optString("url"), jSONObject.optString("desc"), jSONObject.optString("img"));
                com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tbadk.browser.TbWebViewActivity.8
                    @Override // java.lang.Runnable
                    public void run() {
                        TbWebViewActivity.this.mView.a(createShareContent);
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2016568, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tbadk.browser.TbWebViewActivity.9
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.tbadk.coreExtra.c.e> run(CustomMessage<String> customMessage) {
                if (customMessage == null || !(customMessage.getData() instanceof String)) {
                    return null;
                }
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
                    TbWebViewActivity.this.mShareItem.topic = optString5;
                    TbWebViewActivity.this.mShareItem.cyb = optString6;
                    TbWebViewActivity.this.mShareItem.cyc = optString7;
                    TbWebViewActivity.this.mShareItem.shareType = jSONObject.optInt("shareimg");
                    TbWebViewActivity.this.mShareItem.cyj = jSONObject.optInt("weixin_disable");
                    String optString8 = jSONObject.optString("extdata");
                    if (!StringUtils.isNull(optString8)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(optString8);
                            String optString9 = jSONObject2.optString("activityid");
                            String optString10 = jSONObject2.optString("missionid");
                            if (!StringUtils.isNull(optString9) && !StringUtils.isNull(optString10)) {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put(optString9, optString10);
                                TbWebViewActivity.this.mShareItem.cyd = jSONObject3.toString();
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
        this.mOnDialogItemClickListener.mD(hitTestResult.getExtra());
        createListMenu(this.mOnDialogItemClickListener.afX(), this.mOnDialogItemClickListener);
        showListMenu();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mCommonTbJsBridge != null) {
            this.mCommonTbJsBridge.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements b.a {
        private String bTY;
        private int bTX = 1;
        private List<Integer> bTZ = new ArrayList();

        a() {
        }

        public void mD(String str) {
            this.bTY = str;
        }

        protected String[] afX() {
            this.bTZ.clear();
            ArrayList arrayList = new ArrayList();
            arrayList.add(TbWebViewActivity.this.getPageContext().getString(R.string.save_to_local));
            this.bTZ.add(Integer.valueOf(this.bTX));
            return (String[]) arrayList.toArray(new String[0]);
        }

        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar == TbWebViewActivity.this.getListMenu() && i < this.bTZ.size() && i >= 0) {
                if (this.bTZ.get(i).intValue() == 1) {
                    if (TbWebViewActivity.this.mPermissionJudgement == null) {
                        TbWebViewActivity.this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
                    }
                    TbWebViewActivity.this.mPermissionJudgement.clearRequestPermissionList();
                    TbWebViewActivity.this.mPermissionJudgement.appendRequestPermission(TbWebViewActivity.this, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!TbWebViewActivity.this.mPermissionJudgement.startRequestPermission(TbWebViewActivity.this)) {
                        new com.baidu.tbadk.util.m(TbWebViewActivity.this.getActivity(), this.bTY, new m.a() { // from class: com.baidu.tbadk.browser.TbWebViewActivity.a.1
                            @Override // com.baidu.tbadk.util.m.a
                            public void onError(int i2, String str) {
                            }

                            @Override // com.baidu.tbadk.util.m.a
                            public void onSuccess(String str) {
                                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), (int) R.string.tb_webview_download_image_success_tip);
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
        if (this.timerData != null && this.timerData.isOpen() && !this.timerData.atA() && this.mCommonTbJsBridge != null) {
            try {
                this.timerData.eV(true);
                long currentTimeMillis = System.currentTimeMillis();
                long j = com.baidu.tbadk.core.sharedPref.b.alP().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_spring_festival_timer"), 0L);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("enter_time", String.valueOf(currentTimeMillis));
                String valueOf = String.valueOf(j);
                if (j == 0) {
                    valueOf = "";
                }
                jSONObject.put("leave_time", valueOf);
                jSONObject.put("resultCode", 1);
                this.mCommonTbJsBridge.k(this.timerData.getMethod(), jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void handlerWebViewPause() {
        if (this.timerData != null && this.timerData.isOpen()) {
            this.timerData.atB();
            com.baidu.tbadk.core.sharedPref.b.alP().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_spring_festival_timer"), System.currentTimeMillis());
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity
    protected void onUserChanged(boolean z) {
        if (this.mCommonTbJsBridge != null) {
            this.mCommonTbJsBridge.dQ(z);
            setRefreshPage(false);
        }
    }

    public void setRefreshPage(boolean z) {
        this.isNeedRefresh = z;
    }
}
