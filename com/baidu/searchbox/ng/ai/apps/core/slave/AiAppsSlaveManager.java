package com.baidu.searchbox.ng.ai.apps.core.slave;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.browser.BrowserType;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
import com.baidu.searchbox.ng.ai.apps.ar.manager.ARCameraUtil;
import com.baidu.searchbox.ng.ai.apps.camera.AiAppsCameraManager;
import com.baidu.searchbox.ng.ai.apps.canvas.model.CanvasViewModel;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.console.debugger.RemoteDebugger;
import com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager;
import com.baidu.searchbox.ng.ai.apps.core.console.ConsoleMessageHelper;
import com.baidu.searchbox.ng.ai.apps.core.container.NgWebView;
import com.baidu.searchbox.ng.ai.apps.core.container.PullToRefreshWebView;
import com.baidu.searchbox.ng.ai.apps.core.listener.IWebViewWidgetChangeListener;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsCommonMessage;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerManager;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsRectPosition;
import com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshBase;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.runtime.config.WindowConfig;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.GetSlaveIdSyncAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.www.WWWParams;
import com.baidu.searchbox.ng.ai.apps.setting.actions.PrivateGetUserInfoAction;
import com.baidu.searchbox.ng.ai.apps.statistic.search.AiAppsSearchFlowUBC;
import com.baidu.searchbox.ng.ai.apps.statistic.search.SearchFlowEvent;
import com.baidu.searchbox.ng.ai.apps.textarea.parser.TextAreaBaseParser;
import com.baidu.searchbox.ng.ai.apps.textarea.parser.TextAreaSecondaryParser;
import com.baidu.searchbox.ng.ai.apps.util.AiAppKeyboardUtils;
import com.baidu.searchbox.ng.ai.apps.view.AiAppsNARootViewManager;
import com.baidu.searchbox.ng.ai.apps.view.container.AiAppsNAViewContainer;
import com.baidu.searchbox.ng.ai.apps.view.container.util.NAViewFinder;
import com.baidu.webkit.sdk.WebViewClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class AiAppsSlaveManager extends AiAppsWebViewManager {
    private static final boolean DEBUG = false;
    private static final String PULL_DOWN_REFRESH_EVENT_NAME = "PullDownRefresh";
    public static final int SLAVE_WEBVIEW_ID_DEFAULT = 10;
    private static final String TAG = "AiAppsSlaveManager";
    private static int sWebViewIdIndex = 10;
    public AiAppsNARootViewManager mAiAppsNARootViewManager;
    private List<CanvasViewModel> mCanvasList;
    protected Context mContext;
    protected PullToRefreshWebView mPullToRefreshWebView;
    private String mWebViewId;
    private AiAppsWebViewWidget mWebViewWidget;
    private IWebViewWidgetChangeListener mWebViewWidgetChangeListener;

    public AiAppsSlaveManager(Context context) {
        super(context);
        this.mCanvasList = new ArrayList();
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager
    public void onInitConfig(AiAppsWebViewManager.Config config) {
        super.onInitConfig(config);
        config.isBgTransparentMode = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager
    public void postInit() {
        super.postInit();
        initWebViewId();
        GetSlaveIdSyncAction getSlaveIdSyncAction = new GetSlaveIdSyncAction(this.mAiAppsDispatcher);
        getSlaveIdSyncAction.setSalveWebViewManager(this);
        this.mAiAppsDispatcher.regAction(getSlaveIdSyncAction);
        setExternalWebViewClientExt(new AiAppsSlaveWebviewClientExt());
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager
    protected BrowserType getBrowserType() {
        return BrowserType.AI_APPS_SLAVE;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager
    public void onResume() {
        super.onResume();
        AiAppsRuntime.getMapRuntime().resume(this);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager
    public void onPause() {
        super.onPause();
        AiAppsRuntime.getMapRuntime().pause(this);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager
    public boolean isSlidable() {
        return this.mWebViewWidget != null ? this.mWebViewWidget.isSlidable() : this.mNgWebView.isSlidable();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager
    public void loadUrl(String str) {
        if (RemoteDebugger.isRemoteDebug()) {
            str = RemoteDebugger.getSlaveWebViewUrl();
        }
        super.loadUrl(str);
        if (AiAppsLog.getConsoleSwitch()) {
            ConsoleMessageHelper.requestFullSanData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager
    public void initAiAppsDispatcher() {
        super.initAiAppsDispatcher();
        this.mAiAppsDispatcher.regAction(new PrivateGetUserInfoAction(this.mAiAppsDispatcher));
    }

    public boolean hasParent() {
        return getWebView().getParent() != null;
    }

    public void addToParent(FrameLayout frameLayout, WindowConfig windowConfig) {
        if (frameLayout != null) {
            frameLayout.setBackgroundColor(windowConfig.mBackgroundColor);
            if (windowConfig.mEnablePullRefresh) {
                this.mPullToRefreshWebView = new PullToRefreshWebView(this.mContext, this, PullToRefreshBase.HEADERTYPE.AIAPPS_HEADER);
                sendPullDownRefreshMessage(this.mPullToRefreshWebView);
                addView(frameLayout, this.mPullToRefreshWebView);
            } else {
                addView(frameLayout, getWebView());
            }
            if (this.mAiAppsNARootViewManager == null) {
                this.mAiAppsNARootViewManager = new AiAppsNARootViewManager(this.mContext, this, frameLayout);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendPullDownRefreshMessage(PullToRefreshWebView pullToRefreshWebView) {
        if (pullToRefreshWebView != null) {
            this.mPullToRefreshWebView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<NgWebView>() { // from class: com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlaveManager.1
                @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshBase.OnRefreshListener
                public void onPullDownToRefresh(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                    AiAppsController.getInstance().sendJSMessage(AiAppsSlaveManager.this.getWebViewId(), new AiAppsCommonMessage(AiAppsSlaveManager.PULL_DOWN_REFRESH_EVENT_NAME));
                }

                @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshBase.OnRefreshListener
                public void onPullUpToRefresh(PullToRefreshBase<NgWebView> pullToRefreshBase) {
                }
            });
        }
    }

    public PullToRefreshWebView getPullToRefreshWebView() {
        if (this.mPullToRefreshWebView == null) {
            return null;
        }
        return this.mPullToRefreshWebView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addView(ViewGroup viewGroup, View view) {
        if (viewGroup != null && view != null && !hasChildView(viewGroup, view)) {
            viewGroup.addView(view, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void removeView(ViewGroup viewGroup, View view) {
        if (viewGroup != null && view != null && hasChildView(viewGroup, view)) {
            viewGroup.removeView(view);
        }
    }

    private boolean hasChildView(ViewGroup viewGroup, View view) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (viewGroup.getChildAt(i) == view) {
                return true;
            }
        }
        return false;
    }

    private void initWebViewId() {
        this.mWebViewId = String.valueOf(sWebViewIdIndex);
        sWebViewIdIndex++;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager
    public String getWebViewId() {
        return this.mWebViewId;
    }

    public boolean insertWebViewWidget(WWWParams wWWParams) {
        if (wWWParams == null) {
            return false;
        }
        if (this.mPullToRefreshWebView != null) {
            this.mPullToRefreshWebView.onPullDownRefreshComplete(false);
            this.mPullToRefreshWebView.setPullRefreshEnabled(false);
        }
        if (this.mWebViewWidget == null) {
            this.mWebViewWidget = new AiAppsWebViewWidget(this.mActivity != null ? this.mActivity : this.mContext);
            if (wWWParams.position == null) {
                wWWParams.position = AiAppsRectPosition.createDefaultPosition();
            }
            new AiAppsNAViewContainer(this.mContext).insertView(this.mWebViewWidget.getWebView(), wWWParams);
            this.mWebViewWidget.loadUrl(wWWParams.mSrc);
            this.mWebViewWidget.setParams(wWWParams);
            if (this.mWebViewWidgetChangeListener != null) {
                this.mWebViewWidgetChangeListener.onWebViewWidgetInsert(this.mWebViewWidget);
            }
            return true;
        }
        return false;
    }

    public boolean updateWebViewWidget(WWWParams wWWParams) {
        if (this.mWebViewWidget != null) {
            this.mWebViewWidget.loadUrl(wWWParams.mSrc);
            this.mWebViewWidget.setParams(wWWParams);
            if (wWWParams.position == null) {
                wWWParams.position = AiAppsRectPosition.createDefaultPosition();
            }
            AiAppsNAViewContainer findNAViewContainer = NAViewFinder.findNAViewContainer(wWWParams, null);
            if (findNAViewContainer != null) {
                findNAViewContainer.updateView(wWWParams);
            }
            return true;
        }
        return false;
    }

    public boolean removeWebViewWidget(WWWParams wWWParams) {
        if (this.mWebViewWidget != null) {
            if (this.mWebViewWidgetChangeListener != null) {
                this.mWebViewWidgetChangeListener.onWebViewWidgetRemove(this.mWebViewWidget);
            }
            if (wWWParams != null) {
                AiAppsNAViewContainer findNAViewContainer = NAViewFinder.findNAViewContainer(wWWParams, null);
                if (findNAViewContainer != null) {
                    findNAViewContainer.removeView();
                }
            } else {
                removeView(getWebView(), this.mWebViewWidget.getWebView());
            }
            this.mWebViewWidget.setParams(wWWParams);
            this.mWebViewWidget.destroy();
            this.mWebViewWidget = null;
            if (this.mPullToRefreshWebView != null) {
                this.mPullToRefreshWebView.setPullRefreshEnabled(true);
                return true;
            }
            return true;
        }
        return false;
    }

    public boolean handleBackPressed() {
        if (this.mWebViewWidget == null || !this.mWebViewWidget.getWebView().canGoBack()) {
            return false;
        }
        this.mWebViewWidget.getWebView().goBack();
        return true;
    }

    public void insertCanvas(CanvasViewModel canvasViewModel) {
        if (canvasViewModel != null) {
            this.mCanvasList.add(canvasViewModel);
        }
    }

    public void removeCanvas(CanvasViewModel canvasViewModel) {
        if (canvasViewModel != null) {
            this.mCanvasList.remove(canvasViewModel);
            canvasViewModel.release();
        }
    }

    public CanvasViewModel getCanvasViewModelByCanvasId(String str) {
        CanvasViewModel canvasViewModel;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<CanvasViewModel> it = this.mCanvasList.iterator();
        while (true) {
            if (!it.hasNext()) {
                canvasViewModel = null;
                break;
            }
            canvasViewModel = it.next();
            if (canvasViewModel != null && TextUtils.equals(str, canvasViewModel.canvasId)) {
                break;
            }
        }
        return canvasViewModel;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager
    public void destroy() {
        removeWebViewWidget(null);
        checkInputMethod();
        AiAppsCameraManager.getIns().removeCameraPreviewBySlaveId(this.mWebViewId);
        removeTextArea();
        ARCameraUtil.getInstance().removeCameraViewBySlaveId(this.mWebViewId);
        super.destroy();
        this.mCanvasList.clear();
        AiAppsRuntime.getMapRuntime().release(this);
        AiAppsPlayerManager.destroy(this.mWebViewId);
        if (this.mAiAppsNARootViewManager != null) {
            this.mAiAppsNARootViewManager.destroy();
        }
    }

    public void checkInputMethod() {
        Activity activity;
        AiApp aiApp = AiApp.get();
        if (aiApp != null && (activity = aiApp.getActivity()) != null) {
            AiAppKeyboardUtils.forceHiddenSoftInput(activity, activity.getWindow().getDecorView().getWindowToken());
        }
    }

    private void removeTextArea() {
        TextAreaSecondaryParser textAreaSecondaryParser = TextAreaBaseParser.getInstance().getTextAreaSecondaryParser(this.mWebViewId);
        if (textAreaSecondaryParser != null) {
            textAreaSecondaryParser.removeAllTextArea(this.mWebViewId);
        }
    }

    public void setSlaveVisibility(int i) {
        getWebView().setVisibility(i);
        if (this.mAiAppsNARootViewManager != null) {
            this.mAiAppsNARootViewManager.setParentViewVisibility(i);
        }
        if (getPullToRefreshWebView() != null) {
            getPullToRefreshWebView().setVisibility(i);
        }
    }

    public AiAppsNARootViewManager getNARootViewManager() {
        return this.mAiAppsNARootViewManager;
    }

    public IWebViewWidgetChangeListener getWebViewWidgetChangeListener() {
        return this.mWebViewWidgetChangeListener;
    }

    public void setWebViewWidgetChangeListener(IWebViewWidgetChangeListener iWebViewWidgetChangeListener) {
        this.mWebViewWidgetChangeListener = iWebViewWidgetChangeListener;
    }

    @Nullable
    public AiAppsWebViewWidget getWebViewWidget() {
        return this.mWebViewWidget;
    }

    /* loaded from: classes2.dex */
    private class AiAppsSlaveWebviewClientExt extends BdSailorWebViewClientExt {
        private AiAppsSlaveWebviewClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstLayoutDidExt(bdSailorWebView, str);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFullScreenModeExt(BdSailorWebView bdSailorWebView, boolean z, int i, int i2) {
            super.onFullScreenModeExt(bdSailorWebView, z, i, i2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPreloadUrlFoundExt(BdSailorWebView bdSailorWebView, String str) {
            super.onPreloadUrlFoundExt(bdSailorWebView, str);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageCanBeScaledExt(BdSailorWebView bdSailorWebView, boolean z) {
            super.onPageCanBeScaledExt(bdSailorWebView, z);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstPaintDidExt(bdSailorWebView, str);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent(SearchFlowEvent.ID_DOM_FIRST_PAINT);
            searchFlowEvent.eventType = SearchFlowEvent.EventType.END;
            AiAppsSearchFlowUBC.addEvent(searchFlowEvent);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageBackOrForwardExt(BdSailorWebView bdSailorWebView, int i) {
            super.onPageBackOrForwardExt(bdSailorWebView, i);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean shouldHandleImageExt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, boolean z) {
            return super.shouldHandleImageExt(bdSailorWebView, str, str2, str3, z);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onSecurityCheckResultExt(BdSailorWebView bdSailorWebView, String str, WebViewClient.SecurityInfo securityInfo) {
            super.onSecurityCheckResultExt(bdSailorWebView, str, securityInfo);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onKeywordExtensionExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            return super.onKeywordExtensionExt(bdSailorWebView, str, str2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public String onGetErrorHtmlExt(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            return super.onGetErrorHtmlExt(bdSailorWebView, i, str, str2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onUrlRedirectedExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            super.onUrlRedirectedExt(bdSailorWebView, str, str2);
        }
    }
}
