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
import com.baidu.ar.paddle.PaddleController;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.searchbox.ng.ai.apps.core.container.NgWebView;
import com.baidu.searchbox.ng.ai.apps.media.audio.event.AudioStatusCallback;
import com.baidu.searchbox.ng.ai.apps.network.AiAppNetworkUtils;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGameCommentActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGameSubPbActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.hybrid.BridgeWebView;
import com.baidu.tbadk.core.hybrid.l;
import com.baidu.tbadk.core.hybrid.m;
import com.baidu.tbadk.core.hybrid.n;
import com.baidu.tbadk.core.hybrid.o;
import com.baidu.tbadk.core.hybrid.q;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class TbWebViewActivity extends BaseWebViewActivity {
    public static final int FILECHOOSER_RESULTCODE = 1;
    private com.baidu.tieba.tbadkCore.e.a jsBridge;
    private String mBid;
    private com.baidu.tbadk.browser.b mCommonTbJsBridge;
    private l mHybridBridge;
    private String mShareInfo;
    private com.baidu.tbadk.coreExtra.c.d mShareItem;
    private String mShareParams;
    private ValueCallback<Uri> mUploadMessage;
    private ValueCallback<Uri[]> mUploadMessageAboveL;
    private static boolean sFrameLostTracked = false;
    private static final HashMap<String, String> mShareToTypes = new HashMap<>();
    protected BridgeWebView mWebView = null;
    private com.baidu.tieba.tbadkCore.e.c jsCallback = new com.baidu.tieba.tbadkCore.e.c() { // from class: com.baidu.tbadk.browser.TbWebViewActivity.1
        @Override // com.baidu.tieba.tbadkCore.e.c
        public boolean onJsPrompt(String str, JsPromptResult jsPromptResult) {
            if (TbWebViewActivity.this.jsBridge != null) {
                return TbWebViewActivity.this.jsBridge.b(str, jsPromptResult);
            }
            return false;
        }
    };
    private boolean mShowShareItem = true;
    private String mPageType = "normal";
    private final CustomMessageListener mSetShareInfoListener = new CustomMessageListener(2016566) { // from class: com.baidu.tbadk.browser.TbWebViewActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                TbWebViewActivity.this.mShareInfo = (String) customResponsedMessage.getData();
            }
        }
    };
    private boolean isShowFullScreen = false;
    CustomMessageListener htmlLoadMessageListener = new CustomMessageListener(2921023) { // from class: com.baidu.tbadk.browser.TbWebViewActivity.2
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
    private final CustomMessageListener mFinishThisPage = new CustomMessageListener(2921053) { // from class: com.baidu.tbadk.browser.TbWebViewActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                TbWebViewActivity.this.finish();
            }
        }
    };
    private final CustomMessageListener mSharePage = new CustomMessageListener(2921331) { // from class: com.baidu.tbadk.browser.TbWebViewActivity.4
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
        mShareToTypes.put("weixin_timeline", "weixin_timeline");
        mShareToTypes.put("weixin_friend", "weixin_friend");
        mShareToTypes.put("qqdenglu", "qq_zone");
        mShareToTypes.put("sinaweibo", "sina_weibo");
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
            String stringExtra = getIntent().getStringExtra(WebViewActivityConfig.TAG_URL);
            if (!TextUtils.isEmpty(stringExtra) && (parse = Uri.parse(stringExtra)) != null) {
                this.mPageType = parse.getQueryParameter("page_type");
            }
        }
        setIsTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT.equals(this.mPageType));
        setIsAddSwipeBackLayout(!isTranslucent());
        super.onCreate(bundle);
        MessageManager.getInstance().runTask(2001308, (Class) null);
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
        registerGetShareContentTask();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
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
            callHiddenWebViewMethod("onResume");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.mWebView != null) {
            try {
                this.mWebView.onPause();
            } catch (Exception e) {
                e.printStackTrace();
            }
            callHiddenWebViewMethod(AudioStatusCallback.ON_PAUSE);
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
            this.mWebView.getSettings().setDatabasePath(getApplicationContext().getDir(NgWebView.APP_DATABASE_PATH, 0).getAbsolutePath());
            this.mWebView.setHorizontalScrollBarEnabled(false);
            this.mWebView.setHorizontalScrollbarOverlay(false);
            if (!isTranslucent()) {
                this.mWebView.setInitialScale(100);
                this.mWebView.setScrollBarStyle(33554432);
            }
            this.mWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.mWebView.setWebViewClient(new a());
            this.mWebView.setDownloadListener(new b());
            TbWebChromeClient tbWebChromeClient = new TbWebChromeClient(this);
            tbWebChromeClient.setOnJsPromptCallback(this.jsCallback);
            this.mWebView.setWebChromeClient(tbWebChromeClient);
            com.baidu.tieba.q.c.bGm().trackWebView(this, this.mWebView, tbWebChromeClient);
            if (this.mEnableJs) {
                addJavascriptInterface();
            }
            CompatibleUtile.getInstance().removeJavascriptInterface(this.mWebView);
            boolean isHybridBridgeEnabled = TbadkCoreApplication.getInst().isHybridBridgeEnabled();
            l a2 = q.a(isHybridBridgeEnabled, this.mWebView, (com.baidu.tbadk.core.hybrid.b) null);
            this.mHybridBridge = a2;
            if (isHybridBridgeEnabled) {
                a2.a(new n(a2) { // from class: com.baidu.tbadk.browser.TbWebViewActivity.8
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.n
                    public String wQ() {
                        return "TBHY_COMMON_Performance";
                    }

                    @o(Cm = false, value = "trackFPS")
                    private void trackFPS() {
                    }
                });
                a2.a(new com.baidu.tbadk.core.hybrid.a.a(a2));
                a2.a(new com.baidu.tbadk.core.hybrid.a.c(a2));
                a2.a(new com.baidu.tbadk.core.hybrid.a.b(a2));
                a2.a(new n(a2) { // from class: com.baidu.tbadk.browser.TbWebViewActivity.9
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.n
                    public String wQ() {
                        return "TBHY_COMMON_Share";
                    }

                    @o(Cm = false, value = "share")
                    private void share(JSONObject jSONObject) {
                        if (jSONObject != null) {
                            String optString = jSONObject.optString("title");
                            String optString2 = jSONObject.optString("desc");
                            String optString3 = jSONObject.optString(SocialConstants.PARAM_IMG_URL);
                            String optString4 = jSONObject.optString("url");
                            String optString5 = jSONObject.optString("bid");
                            if (!StringUtils.isNULL(optString5)) {
                                TbWebViewActivity.this.mShareResultToFe = true;
                                TbWebViewActivity.this.mBid = optString5;
                            }
                            final com.baidu.tbadk.coreExtra.c.d createShareContent = TbWebViewActivity.this.createShareContent(optString, optString4, optString2, optString3);
                            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tbadk.browser.TbWebViewActivity.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    TbWebViewActivity.this.mView.a(createShareContent);
                                }
                            });
                        }
                    }
                });
                a2.a(new n(a2) { // from class: com.baidu.tbadk.browser.TbWebViewActivity.10
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.n
                    public String wQ() {
                        return "TBHY_COMMON_UISwitch";
                    }

                    @o(Cm = false, value = "viewHideSwitch")
                    private void viewHideSwitch(JSONObject jSONObject) {
                        if (jSONObject != null) {
                            String optString = jSONObject.optJSONObject("share").optString("value");
                            if ("1".equals(optString)) {
                                TbWebViewActivity.this.mShowShareItem = true;
                            } else if ("0".equals(optString)) {
                                TbWebViewActivity.this.mShowShareItem = false;
                            }
                            TbWebViewActivity.this.mView.aR(TbWebViewActivity.this.mShowShareItem);
                        }
                    }
                });
                a2.a(new n(a2) { // from class: com.baidu.tbadk.browser.TbWebViewActivity.11
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.n
                    public String wQ() {
                        return "TBHY_COMMON_GAME_COMMENT";
                    }

                    @o(Cm = false, value = "gameComment")
                    private void goToGameComment(JSONObject jSONObject) {
                        if (jSONObject != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsGameCommentActivityConfig(TbWebViewActivity.this.getPageContext().getPageActivity(), jSONObject.optInt(PaddleController.SDK_TO_LUA_GESTURE_RESULT_SCORE), jSONObject.optInt("forum_id"))));
                        }
                    }
                });
                a2.a(new n(a2) { // from class: com.baidu.tbadk.browser.TbWebViewActivity.12
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tbadk.core.hybrid.n
                    public String wQ() {
                        return "TBHY_COMMON_COMMENT_FLOOR";
                    }

                    @o(Cm = false, value = "enterCommentFloor")
                    private void goToFrsGameSubPbActivity(JSONObject jSONObject) {
                        if (jSONObject != null && ba.bJ(TbWebViewActivity.this.getPageContext().getPageActivity())) {
                            String optString = jSONObject.optString("forum_id");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsGameSubPbActivityConfig(TbWebViewActivity.this.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.l(optString, 0), jSONObject.optString("comment_id"))));
                        }
                    }
                });
                a2.a(new c(a2));
            }
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
            case IEventCenterService.EventId.EventMode.SAPIACCOUNT_LOGIN /* 12015 */:
                handleUploadResult(intent, i2);
                return;
            case 21002:
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
            case 24007:
                handleShareResult(intent, i2);
                newHandleShareResult(intent, i2);
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
        if (!ao.isEmpty(str)) {
            CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(2);
            completeTaskReqMsg.completeId = str;
            sendMessage(completeTaskReqMsg);
        }
    }

    private void handleUploadResult(Intent intent, int i) {
        if (i == -1 && intent != null) {
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
            this.jsBridge.bDS();
        }
        if (this.mWebView != null) {
            this.mWebView.getSettings().setBuiltInZoomControls(true);
            this.mWebView.setVisibility(8);
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tbadk.browser.TbWebViewActivity.13
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
    protected class a extends WebViewClient {
        protected a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (TbWebViewActivity.this.mWebView != null) {
                TbWebViewActivity.this.mUrl = str;
                TbWebViewActivity.this.mWebView.loadUrl("javascript:window.local_obj.getIfFullScreen(document.getElementsByName(\"fc_fullscreen\")[0].content);");
                String title = TbWebViewActivity.this.mWebView.getTitle();
                if (!TbWebViewActivity.this.mFixTitle && !StringUtils.isNull(title)) {
                    TbWebViewActivity.this.mUrlTitle = title;
                }
                if (!TbWebViewActivity.this.isShowFullScreen) {
                    TbWebViewActivity.this.mView.dW(TbWebViewActivity.this.mUrlTitle);
                }
                if (TbWebViewActivity.this.isTranslucent()) {
                    TbWebViewActivity.this.mView.setNavBarVisibility(false);
                } else {
                    TbWebViewActivity.this.mView.setNavBarVisibility(TbWebViewActivity.this.mIsShowNavBar);
                }
                TbWebViewActivity.this.mView.aR(TbWebViewActivity.this.isNeedShowShareItem());
                TbWebViewActivity.this.hideProgressBar();
                TbWebViewActivity.this.stopLoadTimer();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (TbWebViewActivity.this.mWebView != null) {
                TbWebViewActivity.this.mWebView.stopLoading();
                TbWebViewActivity.this.stopLoadTimer();
                TbWebViewActivity.this.onReceivedError(i);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (TbWebViewActivity.this.mWebView != null) {
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
            int b = ay.Ef().b(TbWebViewActivity.this.getPageContext(), new String[]{str, TbWebViewActivity.this.mUrl});
            if (b == 1) {
                TbWebViewActivity.this.finish();
                return true;
            } else if (b == 0) {
                return true;
            } else {
                TbWebViewActivity.this.mUrl = str;
                if (TbWebViewActivity.this.isShowFullScreen) {
                    TbWebViewActivity.this.isShowFullScreen = false;
                    TbWebViewActivity.this.runOnUiThread(new Runnable() { // from class: com.baidu.tbadk.browser.TbWebViewActivity.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TbWebViewActivity.this.mView.xc();
                        }
                    });
                }
                TbWebViewActivity.this.refresh();
                return true;
            }
        }
    }

    /* loaded from: classes.dex */
    private class b implements DownloadListener {
        private b() {
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
        com.baidu.tbadk.browser.a.br(getApplicationContext());
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void onReceivedError(int i) {
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
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001386, com.baidu.tieba.tbadkCore.e.b.class, getPageContext());
        if (runTask == null || runTask.getData() == null) {
            return null;
        }
        return (com.baidu.tieba.tbadkCore.e.b) runTask.getData();
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    protected void setFullScreen() {
        this.isShowFullScreen = true;
        if (this.isShowFullScreen && this.mView != null) {
            runOnUiThread(new Runnable() { // from class: com.baidu.tbadk.browser.TbWebViewActivity.14
                @Override // java.lang.Runnable
                public void run() {
                    TbWebViewActivity.this.mView.setFullScreen();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void onWebViewLogin(boolean z) {
        super.onWebViewLogin(z);
        if (this.mWebView != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(AiAppNetworkUtils.NETWORK_TYPE_CELL_UN_CONNECTED, z ? "1" : "0");
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
                this.mView.dW(this.mUrlTitle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRightShareIcon() {
        if (this.mView != null) {
            this.mView.wV();
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    protected void showShare() {
        if (!StringUtils.isNull(this.mShareParams)) {
            try {
                JSONObject jSONObject = new JSONObject(this.mShareParams);
                final com.baidu.tbadk.coreExtra.c.d createShareContent = createShareContent(jSONObject.optString("title"), jSONObject.optString("url"), jSONObject.optString("desc"), jSONObject.optString(SocialConstants.PARAM_IMG_URL));
                com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tbadk.browser.TbWebViewActivity.5
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2016568, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tbadk.browser.TbWebViewActivity.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.tbadk.coreExtra.c.d> run(CustomMessage<String> customMessage) {
                if (customMessage == null || !(customMessage.getData() instanceof String)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(customMessage.getData());
                    String optString = jSONObject.optString("title");
                    String optString2 = jSONObject.optString("desc");
                    String optString3 = jSONObject.optString(SocialConstants.PARAM_IMG_URL);
                    String optString4 = jSONObject.optString("url");
                    String optString5 = jSONObject.optString("topic");
                    TbWebViewActivity.this.mShareItem = TbWebViewActivity.this.createShareContent(optString, optString4, optString2, optString3);
                    TbWebViewActivity.this.mShareItem.topic = optString5;
                    TbWebViewActivity.this.mShareItem.shareType = jSONObject.optInt("shareimg");
                    String optString6 = jSONObject.optString("extdata");
                    if (!StringUtils.isNull(optString6)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(optString6);
                            String optString7 = jSONObject2.optString("activityid");
                            String optString8 = jSONObject2.optString("missionid");
                            if (!StringUtils.isNull(optString7) && !StringUtils.isNull(optString8)) {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put(optString7, optString8);
                                TbWebViewActivity.this.mShareItem.aSo = jSONObject3.toString();
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(2016568);
    }
}
