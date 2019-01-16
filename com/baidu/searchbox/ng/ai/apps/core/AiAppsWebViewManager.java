package com.baidu.searchbox.ng.ai.apps.core;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import com.baidu.browser.BrowserType;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
import com.baidu.browser.sailor.e;
import com.baidu.browser.sailor.g;
import com.baidu.browser.sailor.h;
import com.baidu.browser.sailor.j;
import com.baidu.browser.sailor.util.a;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.ng.ai.apps.address.action.ChooseAddressAction;
import com.baidu.searchbox.ng.ai.apps.adlanding.AdLandingAction;
import com.baidu.searchbox.ng.ai.apps.ar.action.ARCameraInsertAction;
import com.baidu.searchbox.ng.ai.apps.ar.action.ARCameraRemoveAction;
import com.baidu.searchbox.ng.ai.apps.ar.action.ARCameraStartRecordAction;
import com.baidu.searchbox.ng.ai.apps.ar.action.ARCameraStopRecordAction;
import com.baidu.searchbox.ng.ai.apps.ar.action.ARCameraTakePhotoAction;
import com.baidu.searchbox.ng.ai.apps.ar.action.ARCameraUpdateAction;
import com.baidu.searchbox.ng.ai.apps.barcode.ScanCodeAction;
import com.baidu.searchbox.ng.ai.apps.camera.action.CameraInsertAction;
import com.baidu.searchbox.ng.ai.apps.camera.action.CameraStartRecordAction;
import com.baidu.searchbox.ng.ai.apps.camera.action.CameraStopRecordAction;
import com.baidu.searchbox.ng.ai.apps.camera.action.CameraTakePhotoAction;
import com.baidu.searchbox.ng.ai.apps.camera.action.CameraUpdateAction;
import com.baidu.searchbox.ng.ai.apps.canvas.action.CanvasDrawAction;
import com.baidu.searchbox.ng.ai.apps.canvas.action.CanvasInsertAction;
import com.baidu.searchbox.ng.ai.apps.canvas.action.CanvasMeasureTextAction;
import com.baidu.searchbox.ng.ai.apps.canvas.action.CanvasRemoveAction;
import com.baidu.searchbox.ng.ai.apps.canvas.action.CanvasToTempFilePath;
import com.baidu.searchbox.ng.ai.apps.canvas.action.CanvasUpdateAction;
import com.baidu.searchbox.ng.ai.apps.channel.AiAppChannelAction;
import com.baidu.searchbox.ng.ai.apps.channel.im.AiAppPullMsgAction;
import com.baidu.searchbox.ng.ai.apps.console.debugger.RemoteDebugAction;
import com.baidu.searchbox.ng.ai.apps.contact.action.SetPhoneContactAction;
import com.baidu.searchbox.ng.ai.apps.core.console.ConsoleAction;
import com.baidu.searchbox.ng.ai.apps.core.container.NgWebView;
import com.baidu.searchbox.ng.ai.apps.core.handler.AiAppPageDialogsHandler;
import com.baidu.searchbox.ng.ai.apps.core.listener.IOnScrollChangedListener;
import com.baidu.searchbox.ng.ai.apps.input.CloseInputAction;
import com.baidu.searchbox.ng.ai.apps.input.OpenInputAction;
import com.baidu.searchbox.ng.ai.apps.input.UpdateInputAction;
import com.baidu.searchbox.ng.ai.apps.invoice.ChooseInvoiceAction;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.jsbridge.AiAppBaseJsBridge;
import com.baidu.searchbox.ng.ai.apps.jsbridge.AiAppGlobalJsBridge;
import com.baidu.searchbox.ng.ai.apps.jsbridge.AiAppUtilsJavaScriptInterface;
import com.baidu.searchbox.ng.ai.apps.jsbridge.AiAppsJsBridge;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsWebViewCallback;
import com.baidu.searchbox.ng.ai.apps.map.MapAction;
import com.baidu.searchbox.ng.ai.apps.media.audio.action.AudioBGPlayerAction;
import com.baidu.searchbox.ng.ai.apps.media.audio.action.AudioPlayerAction;
import com.baidu.searchbox.ng.ai.apps.media.chooser.action.ChooseVideoAction;
import com.baidu.searchbox.ng.ai.apps.media.live.AiAppsLivePlayerFactory;
import com.baidu.searchbox.ng.ai.apps.media.live.action.LivePlayerAction;
import com.baidu.searchbox.ng.ai.apps.media.video.AiAppsVideoPlayerFactory;
import com.baidu.searchbox.ng.ai.apps.media.video.action.VideoPlayerAction;
import com.baidu.searchbox.ng.ai.apps.network.NetworkStatusChangeAction;
import com.baidu.searchbox.ng.ai.apps.permission.AiAppsPermission;
import com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.RefreshableViewFactory;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.safe.webview.WebSafeHolder;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.GetAppInfoSyncAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.GetSwanHistoryAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.RMSwanHistoryAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.RequestPolymerPaymentAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.interaction.HideLoadingAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.interaction.ShowLoadingAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.location.GetLocationAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.navigationbar.HideNavigationBarLoadingAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.navigationbar.SetNavigationBarColorAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.navigationbar.SetNavigationBarTitleAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.navigationbar.ShowNavigationBarLoadingAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.pulldownrefresh.StartPullDownRefreshAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.pulldownrefresh.StopPullDownRefreshAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.route.NavigateBackAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.route.NavigateToAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.route.ReLaunchAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.route.RedirectToAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.route.SwitchTabAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.www.InsertWebViewAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.www.RemoveWebViewAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.www.UpdateWebViewAction;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.ScopeInfo;
import com.baidu.searchbox.ng.ai.apps.storage.actions.GetFileInfoAction;
import com.baidu.searchbox.ng.ai.apps.storage.actions.GetSavedFileInfoAction;
import com.baidu.searchbox.ng.ai.apps.storage.actions.GetSavedFileListAction;
import com.baidu.searchbox.ng.ai.apps.storage.actions.RemoveSavedFileAction;
import com.baidu.searchbox.ng.ai.apps.storage.actions.SaveFileAction;
import com.baidu.searchbox.ng.ai.apps.system.brightness.actions.BrightnessAction;
import com.baidu.searchbox.ng.ai.apps.system.memory.action.MemoryWarningAction;
import com.baidu.searchbox.ng.ai.apps.system.vibrate.actions.LongVibrateAction;
import com.baidu.searchbox.ng.ai.apps.system.vibrate.actions.ShortVibrateAction;
import com.baidu.searchbox.ng.ai.apps.tabbar.action.CloseTabBarAction;
import com.baidu.searchbox.ng.ai.apps.tabbar.action.CloseTabBarBadgeAction;
import com.baidu.searchbox.ng.ai.apps.tabbar.action.CloseTabBarRedDotAction;
import com.baidu.searchbox.ng.ai.apps.tabbar.action.OpenTabBarAction;
import com.baidu.searchbox.ng.ai.apps.tabbar.action.OpenTabBarRedDotAction;
import com.baidu.searchbox.ng.ai.apps.tabbar.action.SetTabBarBadgeAction;
import com.baidu.searchbox.ng.ai.apps.tabbar.action.SetTabBarItemAction;
import com.baidu.searchbox.ng.ai.apps.tabbar.action.SetTabBarStyleAction;
import com.baidu.searchbox.ng.ai.apps.textarea.action.CloseTextAreaAction;
import com.baidu.searchbox.ng.ai.apps.textarea.action.OpenTextAreaAction;
import com.baidu.searchbox.ng.ai.apps.textarea.action.UpdateTextAreaAction;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
import com.baidu.searchbox.ng.ai.apps.view.coverview.action.CoverImageAction;
import com.baidu.searchbox.ng.ai.apps.view.coverview.action.CoverViewAction;
import com.baidu.searchbox.ng.ai.apps.view.lottie.AiAppAnimateViewAction;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.webkit.sdk.ClientCertRequest;
import com.baidu.webkit.sdk.GeolocationPermissions;
import com.baidu.webkit.sdk.HttpAuthHandler;
import com.baidu.webkit.sdk.JsPromptResult;
import com.baidu.webkit.sdk.JsResult;
import com.baidu.webkit.sdk.WebChromeClient;
import com.baidu.webkit.sdk.WebResourceResponse;
import com.baidu.webkit.sdk.WebSettings;
import com.baidu.webkit.sdk.WebStorage;
import com.baidu.webkit.sdk.WebViewClient;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class AiAppsWebViewManager implements NgWebView.OnCommonEventHandler, NgWebView.OnWebViewHookHandler, RefreshableViewFactory<NgWebView>, WebSafeHolder, CallbackHandler {
    private static final boolean DEBUG = false;
    public static final String FRAME_WHITE_LIST_AI_APPS = "ai_apps";
    public static final String FRAME_WHITE_LIST_AI_APPS_AD_LANDING = "ai_apps_ad_landing";
    public static final String FRAME_WHITE_LIST_AI_APPS_WIDGET = "ai_apps_widget";
    public static final String SHARE_SOURCE_AI_APPS = "swan_";
    private static final String TAG = "AiAppsWebViewManager";
    private static final int WEB_VIEW_TEXT_SIZE_MIDDLE = 100;
    private static AiAppsWebViewCallback sWebViewCallback;
    protected Activity mActivity;
    private AiAppBaseJsBridge mAiAppGlobalJsBridge;
    protected UnitedSchemeAiAppDispatcher mAiAppsDispatcher;
    private AiAppBaseJsBridge mAiAppsJsBridge;
    protected Context mContext;
    private e mExternalWebChromeClient;
    private h mExternalWebViewClient;
    private BdSailorWebViewClientExt mExternalWebViewClientExt;
    private UnitedSchemeMainDispatcher mMainDispatcher;
    protected NgWebView mNgWebView;
    private AiAppsWebPageCallback mPageCallback;
    private AiAppPageDialogsHandler mPageDialogsHandler;
    protected AiAppUtilsJavaScriptInterface mUtilsJavaScriptInterface;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private final Config mConfig = new Config();
    private List<IOnScrollChangedListener> mOnScrollChangedListenerList = new ArrayList();

    protected abstract BrowserType getBrowserType();

    public abstract String getWebViewId();

    public AiAppsWebViewManager(Context context) {
        init(context);
        onCreate();
    }

    @DebugTrace
    private void init(Context context) {
        onInitConfig(this.mConfig);
        initNgWebView(context);
        injectJsInterfaces(context, this);
        initDispatcher();
        initAiAppsDispatcher();
        initSchemeJsBridge();
        initSettings();
        postInit();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onInitConfig(Config config) {
    }

    private void initNgWebView(Context context) {
        this.mContext = context;
        this.mNgWebView = new NgWebView(context);
        if (AiAppsRuntime.getConfigRuntime().disableJsPromptS()) {
            this.mNgWebView.getSettings().aE(false);
        }
        if (this.mConfig.isBgTransparentMode && a.qY()) {
            this.mNgWebView.setBackgroundColor(0);
        }
        this.mNgWebView.setScrollBarStyle(0);
        this.mNgWebView.getCurrentWebView().setLongClickable(false);
        this.mPageDialogsHandler = new AiAppPageDialogsHandler(this.mContext);
        this.mNgWebView.setWebViewClient(new AiAppsWebViewClient());
        this.mNgWebView.setWebViewClientExt(new AiAppsWebViewClientExt());
        this.mNgWebView.setWebChromeClient(new AiAppsWebChromeClient());
        this.mNgWebView.setOverScrollMode(2);
        this.mNgWebView.setOnCommonEventHandler(this);
        this.mNgWebView.getCurrentWebView().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.mNgWebView.getCurrentWebView().addZeusPluginFactory(new AiAppsLivePlayerFactory());
        this.mNgWebView.getCurrentWebView().setVideoPlayerFactory(new AiAppsVideoPlayerFactory());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.RefreshableViewFactory
    public NgWebView createRefreshableView(Context context) {
        if (this.mNgWebView == null) {
            initNgWebView(context);
        }
        return this.mNgWebView;
    }

    protected void injectJsInterfaces(Context context, AiAppsWebViewManager aiAppsWebViewManager) {
        this.mUtilsJavaScriptInterface = new AiAppUtilsJavaScriptInterface(context, this.mNgWebView);
        this.mUtilsJavaScriptInterface.setSource(SHARE_SOURCE_AI_APPS);
        this.mUtilsJavaScriptInterface.setBrowserType(BrowserType.AI_APPS);
        this.mUtilsJavaScriptInterface.setForceShareLight(true);
        this.mNgWebView.addJavascriptInterface(this.mUtilsJavaScriptInterface, AiAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
    }

    private void initDispatcher() {
        if (this.mMainDispatcher == null) {
            this.mMainDispatcher = new UnitedSchemeMainDispatcher();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initAiAppsDispatcher() {
        if (this.mMainDispatcher == null) {
            throw new IllegalStateException("initAiAppsDispatcher() must be called after initDispatcher()");
        }
        this.mAiAppsDispatcher = new UnitedSchemeAiAppDispatcher();
        this.mMainDispatcher.setDynamicDispatcher("swan", this.mAiAppsDispatcher);
        this.mAiAppsDispatcher.regAction(new NavigateToAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new NavigateBackAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new SwitchTabAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new RedirectToAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new ReLaunchAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new SetNavigationBarTitleAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new SetNavigationBarColorAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new HideNavigationBarLoadingAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new ShowNavigationBarLoadingAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new StopPullDownRefreshAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new StartPullDownRefreshAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new InsertWebViewAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new UpdateWebViewAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new RemoveWebViewAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new GetAppInfoSyncAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new GetLocationAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new CanvasInsertAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new CanvasRemoveAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new CanvasUpdateAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new CanvasDrawAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new CanvasMeasureTextAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new CanvasToTempFilePath(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new AudioPlayerAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new AudioBGPlayerAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new LivePlayerAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new VideoPlayerAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new ConsoleAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new RemoteDebugAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new SaveFileAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new GetSavedFileInfoAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new GetSavedFileListAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new RemoveSavedFileAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new NetworkStatusChangeAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new OpenInputAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new CloseInputAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new UpdateInputAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new CloseTabBarAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new CloseTabBarBadgeAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new CloseTabBarRedDotAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new OpenTabBarAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new OpenTabBarRedDotAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new SetTabBarBadgeAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new SetTabBarItemAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new SetTabBarStyleAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new RequestPolymerPaymentAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new MapAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new GetSwanHistoryAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new RMSwanHistoryAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new CameraInsertAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new CameraUpdateAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new CameraTakePhotoAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new CameraStartRecordAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new CameraStopRecordAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new CoverViewAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new CoverImageAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new ChooseInvoiceAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new ChooseAddressAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new LongVibrateAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new ShortVibrateAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new BrightnessAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new AiAppAnimateViewAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new ScanCodeAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new AiAppChannelAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new AiAppPullMsgAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new ChooseVideoAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new GetFileInfoAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new SetPhoneContactAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new ARCameraInsertAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new ARCameraUpdateAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new ARCameraTakePhotoAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new ARCameraStartRecordAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new ARCameraStopRecordAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new ARCameraRemoveAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new OpenTextAreaAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new CloseTextAreaAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new UpdateTextAreaAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new AdLandingAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new MemoryWarningAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new ShowLoadingAction(this.mAiAppsDispatcher));
        this.mAiAppsDispatcher.regAction(new HideLoadingAction(this.mAiAppsDispatcher));
    }

    private void initSchemeJsBridge() {
        this.mAiAppGlobalJsBridge = new AiAppGlobalJsBridge(this.mContext, this.mMainDispatcher, this);
        this.mNgWebView.addJavascriptInterface(this.mAiAppGlobalJsBridge, AiAppGlobalJsBridge.JAVASCRIPT_INTERFACE_NAME);
        this.mAiAppsJsBridge = new AiAppsJsBridge(this.mContext, this.mMainDispatcher, this);
        this.mNgWebView.addJavascriptInterface(this.mAiAppsJsBridge, AiAppsJsBridge.JAVASCRIPT_INTERFACE_NAME);
    }

    public void attachContextToBridge(Activity activity) {
        if (this.mAiAppGlobalJsBridge != null) {
            this.mAiAppGlobalJsBridge.setActivityRef(activity);
        }
        if (this.mAiAppsJsBridge != null) {
            this.mAiAppsJsBridge.setActivityRef(activity);
        }
        if (this.mUtilsJavaScriptInterface != null) {
            this.mUtilsJavaScriptInterface.setActivity(activity);
        }
        this.mActivity = activity;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void initSettings() {
        g settings = this.mNgWebView.getSettings();
        j settingsExt = this.mNgWebView.getSettingsExt();
        settings.cw(getFrameName());
        settings.setLightTouchEnabled(false);
        settings.setNeedInitialFocus(false);
        settings.setJavaScriptEnabled(true);
        settings.setMixedContentMode(0);
        settings.setLoadsImagesAutomatically(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        settings.setSupportMultipleWindows(false);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setTextZoom(100);
        settingsExt.aF(false);
        com.baidu.browser.sailor.a.qr().enableFeature("GEO");
        com.baidu.browser.sailor.a.qr().enableFeature("ADBLOCK");
        com.baidu.browser.sailor.a.qr().disableFeature("SSL");
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAppCacheEnabled(true);
        String path = this.mContext.getDir(NgWebView.APP_DATABASE_PATH, 0).getPath();
        String path2 = this.mContext.getDir(NgWebView.APP_GEO_PATH, 0).getPath();
        String path3 = this.mContext.getDir(NgWebView.APP_CACHE_PATH, 0).getPath();
        settings.setGeolocationDatabasePath(path2);
        settings.setDatabasePath(path);
        settings.setAppCachePath(path3);
        if (((ActivityManager) this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getMemoryClass() > 16) {
            settings.setPageCacheCapacity(5);
        } else {
            settings.setPageCacheCapacity(1);
        }
        String userAgentString = settings.getUserAgentString();
        String processUserAgent = AiAppsRuntime.getAiAppAccountRuntime().processUserAgent(userAgentString, getBrowserType());
        if (!TextUtils.equals(userAgentString, processUserAgent)) {
            settings.setUserAgentString(processUserAgent);
        }
        try {
            settings.setPluginState(WebSettings.PluginState.ON_DEMAND);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (NoClassDefFoundError e2) {
            e2.printStackTrace();
        }
        if (AiAppsController.getInstance().getCloudConfigData().isCrossOriginAllowed()) {
            settings.setAllowUniversalAccessFromFileURLs(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void postInit() {
    }

    protected String getFrameName() {
        return FRAME_WHITE_LIST_AI_APPS;
    }

    public UnitedSchemeMainDispatcher getDispatcher() {
        return this.mMainDispatcher;
    }

    public void loadJavaScript(final String str) {
        AiAppsUtils.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager.2
            @Override // java.lang.Runnable
            public void run() {
                String str2 = str;
                if (!str2.startsWith("javascript:")) {
                    str2 = "javascript:" + str2;
                }
                AiAppsWebViewManager.this.mNgWebView.evaluateJavascript(str2, null);
            }
        });
    }

    public boolean isSlidable() {
        if (this.mNgWebView != null) {
            return this.mNgWebView.isSlidable();
        }
        return true;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.safe.webview.WebSafeHolder
    public NgWebView getWebView() {
        return this.mNgWebView;
    }

    public void loadUrl(String str) {
        this.mNgWebView.loadUrl(str);
    }

    @CallSuper
    public void onCreate() {
        if (sWebViewCallback != null) {
            sWebViewCallback.onCreate(this);
        }
    }

    @CallSuper
    public void onResume() {
        this.mNgWebView.onResume();
        if (sWebViewCallback != null) {
            sWebViewCallback.onResume(this);
        }
    }

    @CallSuper
    public void onPause() {
        this.mNgWebView.onPause();
        if (sWebViewCallback != null) {
            sWebViewCallback.onPause(this);
        }
    }

    @CallSuper
    public void onDestroy() {
        if (sWebViewCallback != null) {
            sWebViewCallback.onDestroy(this);
        }
    }

    public void goBack() {
        this.mNgWebView.goBack();
    }

    public void hookGoBack() {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.container.NgWebView.OnWebViewHookHandler
    public boolean hookCanGoBack(boolean z) {
        return z;
    }

    public void goBackOrForward(int i) {
        this.mNgWebView.goBackOrForward(i);
    }

    public void goForward() {
        this.mNgWebView.goForward();
    }

    public void reload() {
        this.mNgWebView.reload();
    }

    public void destroy() {
        this.mHandler.removeCallbacks(null);
        this.mNgWebView.destroy();
        this.mOnScrollChangedListenerList.clear();
        onDestroy();
    }

    public static void setWebViewCallback(AiAppsWebViewCallback aiAppsWebViewCallback) {
        sWebViewCallback = aiAppsWebViewCallback;
    }

    public void setWebPageCallback(AiAppsWebPageCallback aiAppsWebPageCallback) {
        this.mPageCallback = aiAppsWebPageCallback;
    }

    public void addOnScrollChangedListener(IOnScrollChangedListener iOnScrollChangedListener) {
        if (iOnScrollChangedListener != null && !this.mOnScrollChangedListenerList.contains(iOnScrollChangedListener)) {
            this.mOnScrollChangedListenerList.add(iOnScrollChangedListener);
        }
    }

    public void removeOnScrollChangedListener(IOnScrollChangedListener iOnScrollChangedListener) {
        if (iOnScrollChangedListener != null && this.mOnScrollChangedListenerList.contains(iOnScrollChangedListener)) {
            this.mOnScrollChangedListenerList.remove(iOnScrollChangedListener);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.container.NgWebView.OnCommonEventHandler
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.mNgWebView.canGoBack()) {
            goBack();
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.container.NgWebView.OnCommonEventHandler
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        if (this.mOnScrollChangedListenerList != null) {
            for (IOnScrollChangedListener iOnScrollChangedListener : this.mOnScrollChangedListenerList) {
                if (iOnScrollChangedListener != null) {
                    iOnScrollChangedListener.onScrollChanged(i, i2, i3, i4);
                }
            }
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.container.NgWebView.OnCommonEventHandler
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.container.NgWebView.OnCommonEventHandler
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void clear() {
        this.mNgWebView.stopLoading();
        this.mNgWebView.getCurrentWebView().clearFocus();
        this.mNgWebView.clearView();
        destroy();
    }

    public final void setExternalWebViewClient(h hVar) {
        this.mExternalWebViewClient = hVar;
    }

    public final void setExternalWebViewClientExt(BdSailorWebViewClientExt bdSailorWebViewClientExt) {
        this.mExternalWebViewClientExt = bdSailorWebViewClientExt;
    }

    public final void setExternalWebChromeClient(e eVar) {
        this.mExternalWebChromeClient = eVar;
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public void handleSchemeDispatchCallback(final String str, final String str2) {
        final String quote;
        if (TextUtils.isEmpty(str2)) {
            quote = "";
        } else {
            quote = JSONObject.quote(str2);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager.3
            @Override // java.lang.Runnable
            public void run() {
                if (!AiAppsWebViewManager.this.mNgWebView.isDestroyed()) {
                    AiAppsWebViewManager.this.mNgWebView.evaluateJavascript("javascript:" + str + "(" + quote + ")", null);
                }
            }
        });
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public String getCurrentPageUrl() {
        return getWebView().getUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class AiAppsWebViewClient extends h {
        private AiAppsWebViewClient() {
        }

        @Override // com.baidu.browser.sailor.h
        public void doUpdateVisitedHistory(BdSailorWebView bdSailorWebView, String str, boolean z) {
            if (AiAppsWebViewManager.this.mExternalWebViewClient != null) {
                AiAppsWebViewManager.this.mExternalWebViewClient.doUpdateVisitedHistory(bdSailorWebView, str, z);
            } else {
                super.doUpdateVisitedHistory(bdSailorWebView, str, z);
            }
        }

        @Override // com.baidu.browser.sailor.h
        public void onFormResubmission(BdSailorWebView bdSailorWebView, Message message, Message message2) {
            if (AiAppsWebViewManager.this.mExternalWebViewClient != null) {
                AiAppsWebViewManager.this.mExternalWebViewClient.onFormResubmission(bdSailorWebView, message, message2);
            } else {
                super.onFormResubmission(bdSailorWebView, message, message2);
            }
        }

        @Override // com.baidu.browser.sailor.h
        public void onLoadResource(BdSailorWebView bdSailorWebView, String str) {
            if (AiAppsWebViewManager.this.mExternalWebViewClient != null) {
                AiAppsWebViewManager.this.mExternalWebViewClient.onLoadResource(bdSailorWebView, str);
            } else {
                super.onLoadResource(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.h
        public void onReceivedLoginRequest(BdSailorWebView bdSailorWebView, String str, String str2, String str3) {
            if (AiAppsWebViewManager.this.mExternalWebViewClient != null) {
                AiAppsWebViewManager.this.mExternalWebViewClient.onReceivedLoginRequest(bdSailorWebView, str, str2, str3);
            } else {
                super.onReceivedLoginRequest(bdSailorWebView, str, str2, str3);
            }
        }

        @Override // com.baidu.browser.sailor.h
        public void onScaleChanged(BdSailorWebView bdSailorWebView, float f, float f2) {
            if (AiAppsWebViewManager.this.mExternalWebViewClient != null) {
                AiAppsWebViewManager.this.mExternalWebViewClient.onScaleChanged(bdSailorWebView, f, f2);
            } else {
                super.onScaleChanged(bdSailorWebView, f, f2);
            }
        }

        @Override // com.baidu.browser.sailor.h
        public void onUnhandledKeyEvent(BdSailorWebView bdSailorWebView, KeyEvent keyEvent) {
            if (AiAppsWebViewManager.this.mExternalWebViewClient != null) {
                AiAppsWebViewManager.this.mExternalWebViewClient.onUnhandledKeyEvent(bdSailorWebView, keyEvent);
            } else {
                super.onUnhandledKeyEvent(bdSailorWebView, keyEvent);
            }
        }

        @Override // com.baidu.browser.sailor.h
        public WebResourceResponse shouldInterceptRequest(BdSailorWebView bdSailorWebView, String str) {
            WebResourceResponse shouldInterceptRequest;
            if (AiAppsWebViewManager.this.mExternalWebViewClient != null) {
                shouldInterceptRequest = AiAppsWebViewManager.this.mExternalWebViewClient.shouldInterceptRequest(bdSailorWebView, str);
            } else {
                shouldInterceptRequest = super.shouldInterceptRequest(bdSailorWebView, str);
            }
            if (AiAppsController.getInstance().getCloudConfigData().isCrossOriginAllowed() && !TextUtils.isEmpty(str)) {
                Uri parse = Uri.parse(str);
                String lastPathSegment = parse.getLastPathSegment();
                if (TextUtils.equals("file", parse.getScheme()) && !TextUtils.isEmpty(lastPathSegment) && lastPathSegment.endsWith(".js")) {
                    File file = new File(parse.getPath());
                    if (file.exists()) {
                        if (shouldInterceptRequest == null) {
                            try {
                                shouldInterceptRequest = new WebResourceResponse("application/javascript", "UTF-8", new FileInputStream(file));
                            } catch (FileNotFoundException e) {
                            }
                        }
                        Map<String, String> responseHeaders = shouldInterceptRequest.getResponseHeaders();
                        if (responseHeaders == null) {
                            responseHeaders = new HashMap<>();
                        }
                        responseHeaders.put("Access-Control-Allow-Origin", "*");
                        shouldInterceptRequest.setResponseHeaders(responseHeaders);
                    }
                }
            }
            return shouldInterceptRequest;
        }

        @Override // com.baidu.browser.sailor.h
        public boolean shouldOverrideKeyEvent(BdSailorWebView bdSailorWebView, KeyEvent keyEvent) {
            if (AiAppsWebViewManager.this.mExternalWebViewClient == null || !AiAppsWebViewManager.this.mExternalWebViewClient.shouldOverrideKeyEvent(bdSailorWebView, keyEvent)) {
                return super.shouldOverrideKeyEvent(bdSailorWebView, keyEvent);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.h
        public void onReceivedClientCertRequest(BdSailorWebView bdSailorWebView, ClientCertRequest clientCertRequest) {
            if (AiAppsWebViewManager.this.mExternalWebViewClient != null) {
                AiAppsWebViewManager.this.mExternalWebViewClient.onReceivedClientCertRequest(bdSailorWebView, clientCertRequest);
            } else {
                super.onReceivedClientCertRequest(bdSailorWebView, clientCertRequest);
            }
        }

        @Override // com.baidu.browser.sailor.h
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (AiAppsWebViewManager.this.mExternalWebViewClient != null) {
                return AiAppsWebViewManager.this.mExternalWebViewClient.shouldOverrideUrlLoading(bdSailorWebView, str);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.h
        public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
            if (AiAppsWebViewManager.this.mExternalWebViewClient != null) {
                AiAppsWebViewManager.this.mExternalWebViewClient.onPageStarted(bdSailorWebView, str, bitmap);
            } else {
                super.onPageStarted(bdSailorWebView, str, bitmap);
            }
        }

        @Override // com.baidu.browser.sailor.h
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            if (AiAppsWebViewManager.this.mPageCallback != null) {
                AiAppsWebViewManager.this.mPageCallback.onPageFinished(bdSailorWebView, str);
            }
            if (AiAppsWebViewManager.this.mExternalWebViewClient != null) {
                AiAppsWebViewManager.this.mExternalWebViewClient.onPageFinished(bdSailorWebView, str);
            } else {
                super.onPageFinished(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.h
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (AiAppsWebViewManager.this.mExternalWebViewClient != null) {
                AiAppsWebViewManager.this.mExternalWebViewClient.onReceivedError(bdSailorWebView, i, str, str2);
            } else {
                super.onReceivedError(bdSailorWebView, i, str, str2);
            }
        }

        @Override // com.baidu.browser.sailor.h
        public void onReceivedSslError(BdSailorWebView bdSailorWebView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (AiAppsWebViewManager.this.mNgWebView.isShown()) {
                AiAppsWebViewManager.this.mPageDialogsHandler.showSslErrorDialog(bdSailorWebView, sslErrorHandler, sslError);
            } else {
                sslErrorHandler.cancel();
            }
        }

        @Override // com.baidu.browser.sailor.h
        public void onReceivedHttpAuthRequest(BdSailorWebView bdSailorWebView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            String str3;
            String[] httpAuthUsernamePassword;
            String str4 = null;
            if (!httpAuthHandler.useHttpAuthUsernamePassword() || bdSailorWebView == null || (httpAuthUsernamePassword = bdSailorWebView.getHttpAuthUsernamePassword(str, str2)) == null || httpAuthUsernamePassword.length != 2) {
                str3 = null;
            } else {
                str3 = httpAuthUsernamePassword[0];
                str4 = httpAuthUsernamePassword[1];
            }
            if (str3 != null && str4 != null) {
                httpAuthHandler.proceed(str3, str4);
            } else if (AiAppsWebViewManager.this.mNgWebView.isShown()) {
                AiAppsWebViewManager.this.mPageDialogsHandler.showHttpAuthentication(bdSailorWebView, httpAuthHandler, str, str2);
            } else {
                httpAuthHandler.cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class AiAppsWebViewClientExt extends BdSailorWebViewClientExt {
        private AiAppsWebViewClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            if (AiAppsWebViewManager.this.mExternalWebViewClientExt != null) {
                AiAppsWebViewManager.this.mExternalWebViewClientExt.onFirstLayoutDidExt(bdSailorWebView, str);
            } else {
                super.onFirstLayoutDidExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFullScreenModeExt(BdSailorWebView bdSailorWebView, boolean z, int i, int i2) {
            if (AiAppsWebViewManager.this.mExternalWebViewClientExt != null) {
                AiAppsWebViewManager.this.mExternalWebViewClientExt.onFullScreenModeExt(bdSailorWebView, z, i, i2);
            } else {
                super.onFullScreenModeExt(bdSailorWebView, z, i, i2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPreloadUrlFoundExt(BdSailorWebView bdSailorWebView, String str) {
            if (AiAppsWebViewManager.this.mExternalWebViewClientExt != null) {
                AiAppsWebViewManager.this.mExternalWebViewClientExt.onPreloadUrlFoundExt(bdSailorWebView, str);
            } else {
                super.onPreloadUrlFoundExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageCanBeScaledExt(BdSailorWebView bdSailorWebView, boolean z) {
            if (AiAppsWebViewManager.this.mExternalWebViewClientExt != null) {
                AiAppsWebViewManager.this.mExternalWebViewClientExt.onPageCanBeScaledExt(bdSailorWebView, z);
            } else {
                super.onPageCanBeScaledExt(bdSailorWebView, z);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            if (AiAppsWebViewManager.this.mExternalWebViewClientExt != null) {
                AiAppsWebViewManager.this.mExternalWebViewClientExt.onFirstPaintDidExt(bdSailorWebView, str);
            } else {
                super.onFirstPaintDidExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            if (AiAppsWebViewManager.this.mExternalWebViewClientExt != null) {
                AiAppsWebViewManager.this.mExternalWebViewClientExt.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            } else {
                super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageBackOrForwardExt(BdSailorWebView bdSailorWebView, int i) {
            if (AiAppsWebViewManager.this.mExternalWebViewClientExt != null) {
                AiAppsWebViewManager.this.mExternalWebViewClientExt.onPageBackOrForwardExt(bdSailorWebView, i);
            } else {
                super.onPageBackOrForwardExt(bdSailorWebView, i);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean shouldHandleImageExt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, boolean z) {
            if (AiAppsWebViewManager.this.mExternalWebViewClientExt == null || !AiAppsWebViewManager.this.mExternalWebViewClientExt.shouldHandleImageExt(bdSailorWebView, str, str2, str3, z)) {
                return super.shouldHandleImageExt(bdSailorWebView, str, str2, str3, z);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onSecurityCheckResultExt(BdSailorWebView bdSailorWebView, String str, WebViewClient.SecurityInfo securityInfo) {
            if (AiAppsWebViewManager.this.mExternalWebViewClientExt != null) {
                AiAppsWebViewManager.this.mExternalWebViewClientExt.onSecurityCheckResultExt(bdSailorWebView, str, securityInfo);
            } else {
                super.onSecurityCheckResultExt(bdSailorWebView, str, securityInfo);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onKeywordExtensionExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            return AiAppsWebViewManager.this.mExternalWebViewClientExt != null ? AiAppsWebViewManager.this.mExternalWebViewClientExt.onKeywordExtensionExt(bdSailorWebView, str, str2) : super.onKeywordExtensionExt(bdSailorWebView, str, str2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public String onGetErrorHtmlExt(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            return AiAppsWebViewManager.this.mExternalWebViewClientExt != null ? AiAppsWebViewManager.this.mExternalWebViewClientExt.onGetErrorHtmlExt(bdSailorWebView, i, str, str2) : super.onGetErrorHtmlExt(bdSailorWebView, i, str, str2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onUrlRedirectedExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            if (AiAppsWebViewManager.this.mExternalWebViewClientExt != null) {
                AiAppsWebViewManager.this.mExternalWebViewClientExt.onUrlRedirectedExt(bdSailorWebView, str, str2);
            } else {
                super.onUrlRedirectedExt(bdSailorWebView, str, str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class AiAppsWebChromeClient extends e {
        private AiAppsWebChromeClient() {
        }

        @Override // com.baidu.browser.sailor.e
        public void onCloseWindow(BdSailorWebView bdSailorWebView) {
            if (AiAppsWebViewManager.this.mExternalWebChromeClient != null) {
                AiAppsWebViewManager.this.mExternalWebChromeClient.onCloseWindow(bdSailorWebView);
            } else {
                super.onCloseWindow(bdSailorWebView);
            }
        }

        @Override // com.baidu.browser.sailor.e
        public boolean onConsoleMessage(BdSailorWebView bdSailorWebView, ConsoleMessage consoleMessage) {
            if (AiAppsWebViewManager.this.mExternalWebChromeClient == null || !AiAppsWebViewManager.this.mExternalWebChromeClient.onConsoleMessage(bdSailorWebView, consoleMessage)) {
                return super.onConsoleMessage(bdSailorWebView, consoleMessage);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.e
        public boolean onCreateWindow(BdSailorWebView bdSailorWebView, boolean z, boolean z2, Message message) {
            if (AiAppsWebViewManager.this.mExternalWebChromeClient == null || !AiAppsWebViewManager.this.mExternalWebChromeClient.onCreateWindow(bdSailorWebView, z, z2, message)) {
                return super.onCreateWindow(bdSailorWebView, z, z2, message);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.e
        public void onExceededDatabaseQuota(BdSailorWebView bdSailorWebView, String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
            if (AiAppsWebViewManager.this.mExternalWebChromeClient != null) {
                AiAppsWebViewManager.this.mExternalWebChromeClient.onExceededDatabaseQuota(bdSailorWebView, str, str2, j, j2, j3, quotaUpdater);
            } else {
                super.onExceededDatabaseQuota(bdSailorWebView, str, str2, j, j2, j3, quotaUpdater);
            }
        }

        @Override // com.baidu.browser.sailor.e
        public boolean onJsBeforeUnload(BdSailorWebView bdSailorWebView, String str, String str2, JsResult jsResult) {
            if (AiAppsWebViewManager.this.mExternalWebChromeClient == null || !AiAppsWebViewManager.this.mExternalWebChromeClient.onJsBeforeUnload(bdSailorWebView, str, str2, jsResult)) {
                return super.onJsBeforeUnload(bdSailorWebView, str, str2, jsResult);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.e
        public boolean onJsTimeout(BdSailorWebView bdSailorWebView) {
            if (AiAppsWebViewManager.this.mExternalWebChromeClient == null || !AiAppsWebViewManager.this.mExternalWebChromeClient.onJsTimeout(bdSailorWebView)) {
                return super.onJsTimeout(bdSailorWebView);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.e
        public void onReachedMaxAppCacheSize(BdSailorWebView bdSailorWebView, long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
            if (AiAppsWebViewManager.this.mExternalWebChromeClient != null) {
                AiAppsWebViewManager.this.mExternalWebChromeClient.onReachedMaxAppCacheSize(bdSailorWebView, j, j2, quotaUpdater);
            } else {
                super.onReachedMaxAppCacheSize(bdSailorWebView, j, j2, quotaUpdater);
            }
        }

        @Override // com.baidu.browser.sailor.e
        public void onReceivedIcon(BdSailorWebView bdSailorWebView, Bitmap bitmap) {
            if (AiAppsWebViewManager.this.mExternalWebChromeClient != null) {
                AiAppsWebViewManager.this.mExternalWebChromeClient.onReceivedIcon(bdSailorWebView, bitmap);
            } else {
                super.onReceivedIcon(bdSailorWebView, bitmap);
            }
        }

        @Override // com.baidu.browser.sailor.e
        public void onReceivedTouchIconUrl(BdSailorWebView bdSailorWebView, String str, boolean z) {
            if (AiAppsWebViewManager.this.mExternalWebChromeClient != null) {
                AiAppsWebViewManager.this.mExternalWebChromeClient.onReceivedTouchIconUrl(bdSailorWebView, str, z);
            } else {
                super.onReceivedTouchIconUrl(bdSailorWebView, str, z);
            }
        }

        @Override // com.baidu.browser.sailor.e
        public void onRequestFocus(BdSailorWebView bdSailorWebView) {
            if (AiAppsWebViewManager.this.mExternalWebChromeClient != null) {
                AiAppsWebViewManager.this.mExternalWebChromeClient.onRequestFocus(bdSailorWebView);
            } else {
                super.onRequestFocus(bdSailorWebView);
            }
        }

        @Override // com.baidu.browser.sailor.e
        public void openFileChooser(BdSailorWebView bdSailorWebView, ValueCallback valueCallback) {
            if (AiAppsWebViewManager.this.mExternalWebChromeClient != null) {
                AiAppsWebViewManager.this.mExternalWebChromeClient.openFileChooser(bdSailorWebView, valueCallback);
            } else {
                super.openFileChooser(bdSailorWebView, valueCallback);
            }
        }

        @Override // com.baidu.browser.sailor.e
        public void openFileChooser(BdSailorWebView bdSailorWebView, ValueCallback valueCallback, String str) {
            if (AiAppsWebViewManager.this.mExternalWebChromeClient != null) {
                AiAppsWebViewManager.this.mExternalWebChromeClient.openFileChooser(bdSailorWebView, valueCallback, str);
            } else {
                super.openFileChooser(bdSailorWebView, valueCallback, str);
            }
        }

        @Override // com.baidu.browser.sailor.e
        public void openFileChooser(BdSailorWebView bdSailorWebView, ValueCallback valueCallback, String str, String str2) {
            if (AiAppsWebViewManager.this.mExternalWebChromeClient != null) {
                AiAppsWebViewManager.this.mExternalWebChromeClient.openFileChooser(bdSailorWebView, valueCallback, str, str2);
            } else {
                super.openFileChooser(bdSailorWebView, valueCallback, str, str2);
            }
        }

        @Override // com.baidu.browser.sailor.e
        public boolean onShowFileChooser(BdSailorWebView bdSailorWebView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            return super.onShowFileChooser(bdSailorWebView, valueCallback, fileChooserParams);
        }

        @Override // com.baidu.browser.sailor.e
        public void onProgressChanged(BdSailorWebView bdSailorWebView, int i) {
            if (AiAppsWebViewManager.this.mExternalWebChromeClient != null) {
                AiAppsWebViewManager.this.mExternalWebChromeClient.onProgressChanged(bdSailorWebView, i);
            } else {
                super.onProgressChanged(bdSailorWebView, i);
            }
        }

        @Override // com.baidu.browser.sailor.e
        public void onReceivedTitle(BdSailorWebView bdSailorWebView, String str) {
            if (AiAppsWebViewManager.this.mExternalWebChromeClient != null) {
                AiAppsWebViewManager.this.mExternalWebChromeClient.onReceivedTitle(bdSailorWebView, str);
            } else {
                super.onReceivedTitle(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.e
        public boolean onJsPrompt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            return AiAppsWebViewManager.this.mPageDialogsHandler.showJsPrompt(str, str2, str3, jsPromptResult);
        }

        @Override // com.baidu.browser.sailor.e
        public boolean onJsAlert(BdSailorWebView bdSailorWebView, String str, String str2, JsResult jsResult) {
            return AiAppsWebViewManager.this.mPageDialogsHandler.showJsAlert(str, str2, jsResult);
        }

        @Override // com.baidu.browser.sailor.e
        public boolean onJsConfirm(BdSailorWebView bdSailorWebView, String str, String str2, JsResult jsResult) {
            return AiAppsWebViewManager.this.mPageDialogsHandler.showJsConfirm(str, str2, jsResult);
        }

        @Override // com.baidu.browser.sailor.e
        public void onGeolocationPermissionsHidePrompt(BdSailorWebView bdSailorWebView) {
        }

        @Override // com.baidu.browser.sailor.e
        public void onGeolocationPermissionsShowPrompt(BdSailorWebView bdSailorWebView, final String str, final GeolocationPermissions.Callback callback) {
            AiApp aiApp = AiApp.get();
            if (aiApp == null || aiApp.getActivity() == null) {
                AiAppsWebViewManager.this.rejectGeoLocationOnce(str, callback);
            } else {
                aiApp.getSetting().checkOrAuthorize(aiApp.getActivity(), ScopeInfo.SCOPE_ID_LOCATION, new TypedCallback<Boolean>() { // from class: com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager.AiAppsWebChromeClient.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
                    public void onCallback(Boolean bool) {
                        if (bool.booleanValue()) {
                            AiAppsWebViewManager.this.handleLocationAuthorized(str, callback);
                        } else {
                            AiAppsWebViewManager.this.rejectGeoLocationOnce(str, callback);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void allowGeoLocationOnce(String str, GeolocationPermissions.Callback callback) {
        callback.invoke(str, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rejectGeoLocationOnce(String str, GeolocationPermissions.Callback callback) {
        callback.invoke(str, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void handleLocationAuthorized(final String str, final GeolocationPermissions.Callback callback) {
        if (AiAppsUtils.isLocationPermissionGranted()) {
            allowGeoLocationOnce(str, callback);
        } else {
            AiAppsController.getInstance().requestPermissionsExt(0, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, new AiAppsPermission.PermissionCallback() { // from class: com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager.4
                @Override // com.baidu.searchbox.ng.ai.apps.permission.AiAppsPermission.PermissionCallback
                public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                    if (i != 0) {
                        AiAppsWebViewManager.this.rejectGeoLocationOnce(str, callback);
                        return;
                    }
                    for (int i2 : iArr) {
                        if (i2 == -1) {
                            AiAppsWebViewManager.this.rejectGeoLocationOnce(str, callback);
                            return;
                        }
                    }
                    AiAppsWebViewManager.this.allowGeoLocationOnce(str, callback);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public class Config {
        public boolean isBgTransparentMode = false;

        protected Config() {
        }
    }
}
