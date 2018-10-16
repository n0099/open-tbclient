package com.baidu.searchbox.ng.ai.apps.core.fragment;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.console.ConsoleController;
import com.baidu.searchbox.ng.ai.apps.core.console.ConsoleMessageHelper;
import com.baidu.searchbox.ng.ai.apps.core.container.NgWebView;
import com.baidu.searchbox.ng.ai.apps.core.container.PullToRefreshWebView;
import com.baidu.searchbox.ng.ai.apps.core.listener.IOnScrollChangedListener;
import com.baidu.searchbox.ng.ai.apps.core.listener.IWebViewWidgetChangeListener;
import com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlaveManager;
import com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlavePool;
import com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsWebViewWidget;
import com.baidu.searchbox.ng.ai.apps.core.turbo.PageReadyEvent;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsCommonMessage;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsLifecycleMessage;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsRouteMessage;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerManager;
import com.baidu.searchbox.ng.ai.apps.media.audio.AiAppsAudioPlayer;
import com.baidu.searchbox.ng.ai.apps.model.AiAppsPageParam;
import com.baidu.searchbox.ng.ai.apps.model.AiAppsParam;
import com.baidu.searchbox.ng.ai.apps.performance.AiAppsPerformanceTrace;
import com.baidu.searchbox.ng.ai.apps.res.widget.floatlayer.FloatLayer;
import com.baidu.searchbox.ng.ai.apps.res.widget.toast.UniversalToast;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.runtime.config.AiAppsConfigData;
import com.baidu.searchbox.ng.ai.apps.runtime.config.WindowConfig;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.route.ActionUtils;
import com.baidu.searchbox.ng.ai.apps.shortcut.AiAppsShortcutHelper;
import com.baidu.searchbox.ng.ai.apps.skin.AiAppNightModeHelper;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.searchbox.ng.ai.apps.tabbar.controller.AiAppsBottomBarViewController;
import com.baidu.searchbox.ng.ai.apps.util.AiAppRomUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import com.baidu.searchbox.ng.ai.apps.view.AiAppsNARootViewManager;
import com.baidu.searchbox.ng.ai.apps.view.Immersion.AiAppsImmersionHelper;
import com.baidu.searchbox.ng.ai.apps.view.decorate.AiAppsMenuDecorate;
import com.baidu.searchbox.ng.aiapps.menu.AiAppMenu;
import com.baidu.searchbox.ng.aiapps.menu.AiAppMenuItem;
import com.baidu.searchbox.ng.aiapps.menu.AiAppMenuStatisticConstants;
import com.baidu.searchbox.ng.aiapps.menu.OnAiAppMenuItemClickListener;
import com.baidu.searchbox.support.v4.app.FragmentActivity;
import com.baidu.webkit.sdk.WebView;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public class AiAppsFragment extends AiAppsBaseFragment implements FloatLayer.Holder {
    private static final boolean DEBUG = false;
    private static final String PARAM_KEY = "ai_apps_param";
    public static final String TAG = "AiAppsFragment";
    private static String sRouteType;
    private Activity mActivity;
    private AiAppsBottomBarViewController mAiAppsBottomBarViewController;
    private String mCurPage;
    private AiAppsSlaveManager mCurWebViewManager;
    private WindowConfig mCurWindowConfig;
    private FloatLayer mFloatLayer;
    private IOnScrollChangedListener mOnScrollChangedForTransparentBar;
    private View mRootView;
    private Map<String, AiAppsSlaveManager> mTabMap = new TreeMap();
    private int mTransparentBarChangeSpacing = 0;
    private FrameLayout mWebViewContainer;
    private static final int TRANSPARENT_BAR_CHANGE_CRITICAL = AiAppsUIUtils.dp2px(149.0f);
    public static String DEFAULT_FROM_WEBVIEW_ID = AiAppsAudioPlayer.ERROR_UNKNOWN;
    private static String mTopWebViewId = DEFAULT_FROM_WEBVIEW_ID;

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        restoreArguments();
        AiAppsPerformanceTrace.log(AiAppsPerformanceTrace.ROUTE_TAG, "fragment create.");
    }

    private void restoreArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mParam = AiAppsParam.createAiAppsParam(arguments.getString(PARAM_KEY));
            this.mCurPage = this.mParam != null ? this.mParam.getPage() : "";
            this.mCurWindowConfig = AiAppsController.getInstance().getPageWindowConfig(TextUtils.isEmpty(this.mCurPage) ? "" : this.mCurPage);
            this.mTransparentBarChangeSpacing = AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.aiapps_normal_base_action_bar_height);
        }
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = activity;
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    @DebugTrace
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AiAppsPerformanceTrace.log(AiAppsPerformanceTrace.ROUTE_TAG, "fragment onCreateView.");
        View inflate = layoutInflater.inflate(R.layout.aiapps_fragment, viewGroup, false);
        this.mWebViewContainer = (FrameLayout) inflate.findViewById(R.id.ai_apps_fragment_content);
        initActionBar(inflate);
        this.mAiAppsBottomBarViewController = new AiAppsBottomBarViewController(this);
        createSlaveWebView(inflate);
        this.mRootView = enableSliding(immersionEnabled() ? initImmersion(inflate) : inflate, this);
        return this.mRootView;
    }

    public PullToRefreshWebView getPullToRefreshWebView() {
        if (this.mCurWebViewManager != null) {
            return this.mCurWebViewManager.getPullToRefreshWebView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    public void initActionBar(View view) {
        super.initActionBar(view);
        setBackViewVisible(isLandingFragment());
        if (isNeedShowHomeButton()) {
            loadHaveHomeActionBar();
        }
        refreshBarTransparentType();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    protected void onActionBarSettingPressed() {
        this.mCurWebViewManager.checkInputMethod();
        initToolMenu();
        this.mToolMenu.show(AiAppNightModeHelper.getNightModeSwitcherState());
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    protected void onActionBarHomePressed() {
        handleBackToHome();
        AiAppsUBCStatistic.AiAppsUBCEvent aiAppsUBCEvent = new AiAppsUBCStatistic.AiAppsUBCEvent();
        aiAppsUBCEvent.mValue = AiAppsUBCStatistic.VALUE_GOHOME;
        aiAppsUBCEvent.mSource = AiAppsUBCStatistic.SOURCE_BAR;
        doUBCEventStatistic(aiAppsUBCEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    public void applyImmersion(int i) {
        if (!isEnableBarTransparent()) {
            super.applyImmersion(i);
            return;
        }
        boolean isEnableBarTransparent = isEnableBarTransparent();
        if (isEnableBarTransparent) {
            isEnableBarTransparent = !AiAppRomUtils.hasNotch(this.mActivity);
        }
        applyImmersion(i, isEnableBarTransparent);
        refreshBarTransparentType();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    public boolean setActionBarBackgroundColor(int i) {
        boolean actionBarBackgroundColor = super.setActionBarBackgroundColor(i);
        refreshBarTransparentType();
        return actionBarBackgroundColor;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    public void resetWithCurImmersion() {
        super.resetWithCurImmersion();
        refreshBarTransparentType();
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        performResume();
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        performPause();
    }

    private void performResume() {
        if (getUserVisibleHint()) {
            resume();
        }
    }

    private void performPause() {
        if (getUserVisibleHint()) {
            pause();
        }
    }

    public static void setRouteType(String str) {
        sRouteType = str;
    }

    private void sendRouteMessage() {
        if (!TextUtils.equals(mTopWebViewId, this.mCurWebViewManager.getWebViewId())) {
            AiAppsRouteMessage aiAppsRouteMessage = new AiAppsRouteMessage();
            aiAppsRouteMessage.mFromId = mTopWebViewId;
            aiAppsRouteMessage.mToId = this.mCurWebViewManager.getWebViewId();
            aiAppsRouteMessage.mRouteType = sRouteType;
            aiAppsRouteMessage.mToPage = this.mCurPage;
            sRouteType = "";
            AiAppsController.getInstance().sendJSMessage(aiAppsRouteMessage);
            mTopWebViewId = this.mCurWebViewManager.getWebViewId();
        }
    }

    private void sendLifecycleMessage(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(AiAppsLifecycleMessage.EVENT_TYPE_KEY, str);
        hashMap.put("wvID", this.mCurWebViewManager.getWebViewId());
        AiAppsController.getInstance().sendJSMessage(new AiAppsLifecycleMessage(hashMap));
    }

    private void toolMenuItemClickListener() {
        this.mToolMenu.setOnItemClickListener(new OnAiAppMenuItemClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragment.1
            @Override // com.baidu.searchbox.ng.aiapps.menu.OnAiAppMenuItemClickListener
            public boolean onClick(View view, AiAppMenuItem aiAppMenuItem) {
                switch (aiAppMenuItem.getItemId()) {
                    case 4:
                        AiAppsFragment.this.share();
                        return true;
                    case 5:
                        AiAppsFragment.this.processNightMode(AiAppsFragment.this.getContext());
                        return true;
                    case 34:
                        AiAppsFragment.this.handleBackToHome();
                        AiAppsUBCStatistic.AiAppsUBCEvent aiAppsUBCEvent = new AiAppsUBCStatistic.AiAppsUBCEvent();
                        aiAppsUBCEvent.mValue = AiAppsUBCStatistic.VALUE_GOHOME;
                        aiAppsUBCEvent.mSource = "menu";
                        AiAppsFragment.this.doUBCEventStatistic(aiAppsUBCEvent);
                        return true;
                    case 35:
                        if (AiAppsFragment.this.mActivity == null) {
                            return true;
                        }
                        AiAppsShortcutHelper.addShortcut(view.getContext(), AiApp.get().getLaunchInfo());
                        AiAppsUBCStatistic.AiAppsUBCEvent aiAppsUBCEvent2 = new AiAppsUBCStatistic.AiAppsUBCEvent();
                        aiAppsUBCEvent2.mValue = AiAppsUBCStatistic.VALUE_ADD_SHORTCUT;
                        AiAppsFragment.this.doUBCEventStatistic(aiAppsUBCEvent2);
                        return true;
                    case 36:
                        AiAppsFragment.this.startAboutFragment();
                        AiAppsUBCStatistic.AiAppsUBCEvent aiAppsUBCEvent3 = new AiAppsUBCStatistic.AiAppsUBCEvent();
                        aiAppsUBCEvent3.mValue = "about";
                        AiAppsFragment.this.doUBCEventStatistic(aiAppsUBCEvent3);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void share() {
        if (this.mCurWebViewManager != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("wvID", this.mCurWebViewManager.getWebViewId());
            AiAppsController.getInstance().sendJSMessage(new AiAppsCommonMessage("sharebtn", hashMap));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAboutFragment() {
        AiAppsFragmentManager aiAppsFragmentManager = AiAppsController.getInstance().getAiAppsFragmentManager();
        if (aiAppsFragmentManager == null) {
            if (this.mActivity != null) {
                UniversalToast.makeText(this.mActivity, R.string.aiapps_open_fragment_failed_toast).showToast();
                return;
            }
            return;
        }
        aiAppsFragmentManager.createTransaction(AiAppsRouteMessage.TYPE_NAVIGATE_TO).setCustomAnimations(AiAppsFragmentManager.ANIM_ENTER, AiAppsFragmentManager.ANIM_HOLD).pushFragment("about", null).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleBackToHome() {
        ActionUtils.dispatchRouteRequest(ActionUtils.BACK_TO_HOME_REQUEST, "menu", AiAppsController.getInstance().getFirstPageUrl());
    }

    private void createSlaveWebView(View view) {
        AiAppsPerformanceTrace.log(AiAppsPerformanceTrace.ROUTE_TAG, "createSlaveWebView start.");
        String baseUrl = this.mParam.getBaseUrl();
        String params = this.mParam.getParams();
        String page = this.mParam.getPage();
        this.mCurWebViewManager = AiAppsSlavePool.getSlaveManager(AiAppsUtils.buildPageUrl(baseUrl, page, params));
        if (this.mCurWebViewManager == null) {
            this.mCurWebViewManager = createSlaveAndLoad(baseUrl, page, params);
        }
        this.mCurWebViewManager.addToParent(this.mWebViewContainer, AiAppsController.getInstance().getPageWindowConfig(page));
        tryAddTransparentBarScrollListener(page, this.mCurWebViewManager);
        if (isTabFragment()) {
            this.mTabMap.put(page, this.mCurWebViewManager);
            this.mAiAppsBottomBarViewController.addBottomBar(view, getContext(), page);
        }
        AiAppsPerformanceTrace.log(AiAppsPerformanceTrace.ROUTE_TAG, "createSlaveWebView end.");
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment, com.baidu.searchbox.support.v4.app.Fragment
    public void onDetach() {
        this.mActivity = null;
        super.onDetach();
    }

    @Override // com.baidu.searchbox.support.v4.app.Fragment
    public void onDestroy() {
        if (this.mTabMap != null && !this.mTabMap.isEmpty()) {
            for (AiAppsSlaveManager aiAppsSlaveManager : this.mTabMap.values()) {
                if (aiAppsSlaveManager != null) {
                    tryRemoveTransparentBarScrollListener(aiAppsSlaveManager);
                    aiAppsSlaveManager.destroy();
                }
            }
            this.mTabMap.clear();
        } else if (this.mCurWebViewManager != null) {
            tryRemoveTransparentBarScrollListener(this.mCurWebViewManager);
            this.mCurWebViewManager.destroy();
        }
        this.mCurWebViewManager = null;
        super.onDestroy();
        AiAppsSlavePool.preloadSlaveManager(AiAppsController.getInstance().getActivity());
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment, com.baidu.searchbox.support.v4.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (isAdded()) {
            if (z) {
                resume();
            } else {
                pause();
            }
        }
    }

    public void resume() {
        sendRouteMessage();
        sendLifecycleMessage(AiAppsLifecycleMessage.TYPE_SHOW);
        AiAppsLog.d(AiApp.MODEL_TAG, AiAppsLifecycleMessage.TYPE_SHOW);
        AiAppsPlayerManager.onForegroundStateChanged(this.mCurWebViewManager.getWebViewId(), true);
        if (AiAppsLog.getConsoleSwitch()) {
            ConsoleMessageHelper.requestFullSanData();
        }
    }

    public void pause() {
        getFloatLayer().reset();
        sendLifecycleMessage(AiAppsLifecycleMessage.TYPE_HIDE);
        AiAppsLog.d(AiApp.MODEL_TAG, AiAppsLifecycleMessage.TYPE_HIDE);
        AiAppsPlayerManager.onForegroundStateChanged(this.mCurWebViewManager.getWebViewId(), false);
        PullToRefreshWebView pullToRefreshWebView = this.mCurWebViewManager.getPullToRefreshWebView();
        if (pullToRefreshWebView != null) {
            pullToRefreshWebView.onPullDownRefreshComplete(false);
        }
    }

    public String getTabWebViewId(String str) {
        if (this.mTabMap.containsKey(str)) {
            return this.mTabMap.get(str).getWebViewId();
        }
        return null;
    }

    public void switchTab(AiAppsPageParam aiAppsPageParam) {
        this.mAiAppsBottomBarViewController.updateTabUI(aiAppsPageParam.mPage);
        doSwitchTab(aiAppsPageParam);
    }

    private void createTabSlaveWebView(AiAppsPageParam aiAppsPageParam) {
        if (this.mTabMap.get(aiAppsPageParam.mPage) == null) {
            AiAppsSlaveManager slaveManager = AiAppsSlavePool.getSlaveManager(AiAppsUtils.buildPageUrl(aiAppsPageParam.mBaseUrl, aiAppsPageParam.mPage, aiAppsPageParam.mParams));
            if (slaveManager != null) {
                this.mTabMap.put(aiAppsPageParam.mPage, slaveManager);
            } else {
                slaveManager = createSlaveAndLoad(aiAppsPageParam.mBaseUrl, aiAppsPageParam.mPage, aiAppsPageParam.mParams);
                this.mTabMap.put(aiAppsPageParam.mPage, slaveManager);
            }
            tryAddTransparentBarScrollListener(aiAppsPageParam.mPage, slaveManager);
        }
    }

    private AiAppsSlaveManager createSlaveAndLoad(final String str, final String str2, final String str3) {
        final AiAppsSlavePool.PreloadSlaveManager preloadSlaveManager = AiAppsSlavePool.getPreloadSlaveManager(getActivity());
        AiAppsSlavePool.requestPreloadOnReady(preloadSlaveManager, new AiAppsSlavePool.PreloadStatusCallback() { // from class: com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragment.2
            @Override // com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlavePool.PreloadStatusCallback
            public void onReady() {
                PageReadyEvent pageReadyEvent = new PageReadyEvent();
                pageReadyEvent.appPath = str;
                if (!TextUtils.isEmpty(str3)) {
                    pageReadyEvent.pagePath = str2 + "?" + str3;
                } else {
                    pageReadyEvent.pagePath = str2;
                }
                pageReadyEvent.onReachBottomDistance = AiAppsController.getInstance().getPageWindowConfig(str2).mOnReachBottomDistance;
                pageReadyEvent.sConsole = String.valueOf(ConsoleController.isConsoleEnabled());
                AiAppsController.getInstance().sendJSMessage(preloadSlaveManager.slaveManager.getWebViewId(), PageReadyEvent.createPageReadyMessage(pageReadyEvent));
            }
        });
        return preloadSlaveManager.slaveManager;
    }

    public void doSwitchTab(AiAppsPageParam aiAppsPageParam) {
        String str = aiAppsPageParam.mPage;
        WindowConfig pageWindowConfig = AiAppsController.getInstance().getPageWindowConfig(TextUtils.isEmpty(str) ? "" : str);
        this.mCurPage = str;
        this.mCurWindowConfig = pageWindowConfig;
        if (isTabWebViewCreated(str)) {
            switchTabWebView(str);
        } else {
            createTabSlaveWebView(aiAppsPageParam);
            switchTabWebView(str);
        }
        setActionbarTitle(pageWindowConfig.mNavigationBarTitle);
        setActionBarBackgroundColor(pageWindowConfig.mNavigationBarBgColor);
        refreshBarTransparentType();
    }

    private void switchTabWebView(String str) {
        AiAppsSlaveManager aiAppsSlaveManager = this.mTabMap.get(str);
        if (this.mCurWebViewManager != aiAppsSlaveManager) {
            if (!aiAppsSlaveManager.hasParent()) {
                aiAppsSlaveManager.addToParent(this.mWebViewContainer, AiAppsController.getInstance().getPageWindowConfig(str));
            }
            aiAppsSlaveManager.setSlaveVisibility(0);
            if (this.mCurWebViewManager != null) {
                this.mCurWebViewManager.setSlaveVisibility(8);
            }
            this.mCurWebViewManager = aiAppsSlaveManager;
        }
    }

    public FrameLayout getWebViewContainer() {
        return this.mWebViewContainer;
    }

    private boolean isTabWebViewCreated(String str) {
        return (this.mTabMap.isEmpty() || this.mTabMap.get(str) == null) ? false : true;
    }

    public static AiAppsFragment newInstance(AiAppsParam aiAppsParam) {
        AiAppsFragment aiAppsFragment = new AiAppsFragment();
        if (aiAppsParam != null) {
            Bundle bundle = new Bundle();
            bundle.putString(PARAM_KEY, aiAppsParam.toJSONString());
            aiAppsFragment.setArguments(bundle);
        }
        return aiAppsFragment;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable() {
        return isLandingFragment() && this.mCurWebViewManager.isSlidable();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    public boolean isTabFragment() {
        AiAppsConfigData configData;
        AiAppsController aiAppsController = AiAppsController.getInstance();
        if (aiAppsController == null || (configData = aiAppsController.getConfigData()) == null || !configData.hasTabItemInfo() || this.mParam == null) {
            return false;
        }
        return configData.isInTabUrl(this.mParam.getPage());
    }

    protected final boolean isNeedShowHomeButton() {
        AiAppsConfigData configData;
        AiAppsFragmentManager aiAppsFragmentManager = getAiAppsFragmentManager();
        return (aiAppsFragmentManager == null || (configData = AiAppsController.getInstance().getConfigData()) == null || isHomePageInStack(aiAppsFragmentManager, configData)) ? false : true;
    }

    private boolean isHomePageInStack(AiAppsFragmentManager aiAppsFragmentManager, AiAppsConfigData aiAppsConfigData) {
        AiAppsBaseFragment fragment = aiAppsFragmentManager.getFragment(0);
        if (fragment == null || !(fragment instanceof AiAppsFragment)) {
            return false;
        }
        String curPage = ((AiAppsFragment) fragment).getCurPage();
        return aiAppsConfigData.isInTabUrl(curPage) || TextUtils.equals(aiAppsConfigData.getFirstPageUrl(), curPage);
    }

    private boolean isShowBackHomePage() {
        AiAppsConfigData configData = AiAppsController.getInstance().getConfigData();
        return (configData == null || TextUtils.equals(configData.getFirstPageUrl(), this.mCurPage)) ? false : true;
    }

    public String getSlaveWebViewId() {
        return this.mCurWebViewManager != null ? this.mCurWebViewManager.getWebViewId() : "";
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    public boolean handleBackPressed() {
        if (AiAppsRuntime.getPaymentRuntime().removeWalletUI()) {
            return true;
        }
        if (this.mCurWebViewManager != null) {
            if (AiAppsPlayerManager.handleBackPressed(this.mCurWebViewManager.getWebViewId())) {
                return true;
            }
            return this.mCurWebViewManager.handleBackPressed();
        }
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsBaseFragment
    @DebugTrace
    protected void initToolMenu() {
        FragmentActivity activity = getActivity();
        if (activity != null && this.mToolMenu == null) {
            this.mToolMenu = new AiAppMenu(activity, this.mAiAppsActionBar, isShowBackHomePage() ? 12 : 15, new AiAppsMenuDecorate());
            this.mToolMenu.setStatisticSource(AiAppMenuStatisticConstants.SOURCE_TOOL);
            this.mToolMenu.setMenuSource("swan");
            toolMenuItemClickListener();
        }
    }

    @NonNull
    public Pair<Integer, Integer> getCurWindowSize() {
        if (this.mCurWebViewManager == null) {
            return new Pair<>(0, 0);
        }
        NgWebView webView = this.mCurWebViewManager.getWebView();
        return webView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(webView.getWidth()), Integer.valueOf(webView.getHeight()));
    }

    public AiAppsBottomBarViewController getAiAppsBottomBarViewController() {
        return this.mAiAppsBottomBarViewController;
    }

    public String getCurPage() {
        return this.mCurPage;
    }

    public AiAppsNARootViewManager getAiAppsNARootViewManager() {
        return this.mCurWebViewManager.mAiAppsNARootViewManager;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.widget.floatlayer.FloatLayer.Holder
    @NonNull
    public FloatLayer getFloatLayer() {
        if (this.mFloatLayer == null) {
            this.mFloatLayer = new FloatLayer(this, (LinearLayout) this.mRootView.findViewById(R.id.ai_apps_fragment_base_view), AppRuntime.getAppContext().getResources().getDimensionPixelOffset(R.dimen.aiapps_normal_base_action_bar_height));
        }
        return this.mFloatLayer;
    }

    public WindowConfig getCurWindowConfig() {
        return this.mCurWindowConfig;
    }

    @Nullable
    public AiAppsImmersionHelper getImmersionHelper() {
        return this.mImmersionHelper;
    }

    private boolean isEnableBarTransparent() {
        return this.mCurWindowConfig != null && this.mCurWindowConfig.mEnableOpacityNavigationBar;
    }

    private void tryAddTransparentBarScrollListener(String str, AiAppsSlaveManager aiAppsSlaveManager) {
        if (aiAppsSlaveManager != null) {
            AiAppsController aiAppsController = AiAppsController.getInstance();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (aiAppsController.getPageWindowConfig(str).mEnableOpacityNavigationBar) {
                if (this.mOnScrollChangedForTransparentBar == null) {
                    this.mOnScrollChangedForTransparentBar = new IOnScrollChangedListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragment.3
                        @Override // com.baidu.searchbox.ng.ai.apps.core.listener.IOnScrollChangedListener
                        public void onScrollChanged(int i, int i2, int i3, int i4) {
                            AiAppsFragment.this.updateBarTransparentDegree(i2);
                        }
                    };
                }
                aiAppsSlaveManager.addOnScrollChangedListener(this.mOnScrollChangedForTransparentBar);
                aiAppsSlaveManager.setWebViewWidgetChangeListener(new IWebViewWidgetChangeListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragment.4
                    @Override // com.baidu.searchbox.ng.ai.apps.core.listener.IWebViewWidgetChangeListener
                    public void onWebViewWidgetInsert(AiAppsWebViewWidget aiAppsWebViewWidget) {
                        if (aiAppsWebViewWidget != null) {
                            aiAppsWebViewWidget.addOnScrollChangedListener(AiAppsFragment.this.mOnScrollChangedForTransparentBar);
                        }
                    }

                    @Override // com.baidu.searchbox.ng.ai.apps.core.listener.IWebViewWidgetChangeListener
                    public void onWebViewWidgetRemove(AiAppsWebViewWidget aiAppsWebViewWidget) {
                        if (aiAppsWebViewWidget != null) {
                            aiAppsWebViewWidget.removeOnScrollChangedListener(AiAppsFragment.this.mOnScrollChangedForTransparentBar);
                        }
                    }
                });
            }
        }
    }

    private void tryRemoveTransparentBarScrollListener(AiAppsSlaveManager aiAppsSlaveManager) {
        if (this.mOnScrollChangedForTransparentBar != null && aiAppsSlaveManager != null) {
            aiAppsSlaveManager.removeOnScrollChangedListener(this.mOnScrollChangedForTransparentBar);
            if (aiAppsSlaveManager.getWebViewWidget() != null) {
                aiAppsSlaveManager.removeOnScrollChangedListener(this.mOnScrollChangedForTransparentBar);
            }
        }
    }

    private void refreshBarTransparentType() {
        int i;
        TextView titleViewCenter;
        NgWebView webView;
        WebView currentWebView;
        if (this.mAiAppsActionBar != null) {
            if (isEnableBarTransparent()) {
                if (this.mCurWebViewManager != null) {
                    if (this.mCurWebViewManager.getWebViewWidget() != null) {
                        webView = this.mCurWebViewManager.getWebViewWidget().getWebView();
                    } else {
                        webView = this.mCurWebViewManager.getWebView();
                    }
                    if (webView != null && (currentWebView = webView.getCurrentWebView()) != null) {
                        i = currentWebView.getWebViewScrollY();
                        updateBarTransparentDegree(i);
                        if (this.mCurWindowConfig != null && !this.mCurWindowConfig.mEnableOpacityNavigationBarText && (titleViewCenter = this.mAiAppsActionBar.getTitleViewCenter()) != null) {
                            titleViewCenter.setAlpha(1.0f);
                        }
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mWebViewContainer.getLayoutParams();
                        layoutParams.topMargin = 0;
                        this.mWebViewContainer.setLayoutParams(layoutParams);
                        if (this.mImmersionHelper == null && this.mImmersionHelper.isOccupyStatusBar()) {
                            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mAiAppsActionBarRoot.getLayoutParams();
                            layoutParams2.topMargin = AiAppsUIUtils.getStatusBarHeight();
                            this.mAiAppsActionBarRoot.setLayoutParams(layoutParams2);
                            return;
                        }
                        return;
                    }
                }
                i = 0;
                updateBarTransparentDegree(i);
                if (this.mCurWindowConfig != null) {
                    titleViewCenter.setAlpha(1.0f);
                }
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.mWebViewContainer.getLayoutParams();
                layoutParams3.topMargin = 0;
                this.mWebViewContainer.setLayoutParams(layoutParams3);
                if (this.mImmersionHelper == null) {
                    return;
                }
                return;
            }
            updateBarTransparentDegree(TRANSPARENT_BAR_CHANGE_CRITICAL + this.mTransparentBarChangeSpacing);
            TextView titleViewCenter2 = this.mAiAppsActionBar.getTitleViewCenter();
            if (titleViewCenter2 != null) {
                titleViewCenter2.setAlpha(1.0f);
            }
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.mWebViewContainer.getLayoutParams();
            layoutParams4.topMargin = getResources().getDimensionPixelSize(R.dimen.aiapps_normal_base_action_bar_height);
            this.mWebViewContainer.setLayoutParams(layoutParams4);
            FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) this.mAiAppsActionBarRoot.getLayoutParams();
            layoutParams5.topMargin = 0;
            this.mAiAppsActionBarRoot.setLayoutParams(layoutParams5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBarTransparentDegree(int i) {
        TextView titleViewCenter;
        View curStatusBarView;
        Drawable background;
        float f = 0.0f;
        float f2 = ((i - TRANSPARENT_BAR_CHANGE_CRITICAL) * 1.0f) / (this.mTransparentBarChangeSpacing == 0 ? 1 : this.mTransparentBarChangeSpacing);
        if (f2 > 0.0f) {
            f = f2 >= 1.0f ? 1.0f : f2;
        }
        int i2 = (int) (255.0f * f);
        if (this.mImmersionHelper != null && this.mImmersionHelper.isOccupyStatusBar() && (curStatusBarView = this.mImmersionHelper.getCurStatusBarView()) != null && (background = curStatusBarView.getBackground()) != null) {
            background.setAlpha(i2);
        }
        Drawable background2 = this.mAiAppsActionBar.getBackground();
        if (background2 != null) {
            background2.setAlpha(i2);
        }
        if (this.mCurWindowConfig != null && this.mCurWindowConfig.mEnableOpacityNavigationBarText && (titleViewCenter = this.mAiAppsActionBar.getTitleViewCenter()) != null) {
            titleViewCenter.setAlpha(f);
        }
        Drawable background3 = this.mTitleShadowView.getBackground();
        if (background3 != null) {
            background3.setAlpha(i2);
        }
    }
}
