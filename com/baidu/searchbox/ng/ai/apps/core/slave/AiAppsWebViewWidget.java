package com.baidu.searchbox.ng.ai.apps.core.slave;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.browser.BrowserType;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.h;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.core.AiAppsCoreUtils;
import com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager;
import com.baidu.searchbox.ng.ai.apps.network.AiAppNetworkUtils;
import com.baidu.searchbox.ng.ai.apps.res.ui.EfficientProgressBar;
import com.baidu.searchbox.ng.ai.apps.res.ui.NetworkErrorView;
import com.baidu.searchbox.ng.ai.apps.safe.webview.WebSafeCheckers;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.www.WWWParams;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.www.WebViewPostMsgAction;
/* loaded from: classes2.dex */
public class AiAppsWebViewWidget extends AiAppsSlaveManager {
    private static final boolean DEBUG = false;
    private static final String TAG = "AiAppsWebViewWidget";
    private WWWErrorView mErrorView;
    protected boolean mIsNeedCheckWebDomain;
    @Nullable
    private WWWParams mParams;
    private WWWProgressBar mProgressBar;

    public AiAppsWebViewWidget(Context context) {
        super(context);
        this.mIsNeedCheckWebDomain = true;
        AiAppsCoreUtils.syncBdussCookie(context);
        setExternalWebViewClient(new WebViewWidgetClient());
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager
    protected void injectJsInterfaces(Context context, AiAppsWebViewManager aiAppsWebViewManager) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlaveManager, com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager
    public void onInitConfig(AiAppsWebViewManager.Config config) {
        super.onInitConfig(config);
        config.isBgTransparentMode = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlaveManager, com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager
    public void postInit() {
        super.postInit();
        WebViewPostMsgAction webViewPostMsgAction = new WebViewPostMsgAction(this.mAiAppsDispatcher);
        webViewPostMsgAction.setWebViewWidget(this);
        this.mAiAppsDispatcher.regAction(webViewPostMsgAction);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlaveManager, com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager
    public void loadUrl(String str) {
        if (this.mIsNeedCheckWebDomain && !WebSafeCheckers.checkWebDomain(str)) {
            getErrorView().showErrorView();
        } else {
            super.loadUrl(str);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager
    protected String getFrameName() {
        return AiAppsWebViewManager.FRAME_WHITE_LIST_AI_APPS_WIDGET;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlaveManager, com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager
    protected BrowserType getBrowserType() {
        return BrowserType.AI_APPS_WEBVIEW;
    }

    @Nullable
    public WWWParams getParams() {
        return this.mParams;
    }

    public void setParams(@Nullable WWWParams wWWParams) {
        this.mParams = wWWParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WWWProgressBar getProgressBar() {
        if (this.mProgressBar == null) {
            this.mProgressBar = new WWWProgressBar(getWebView().getContext(), getWebView());
        }
        return this.mProgressBar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WWWErrorView getErrorView() {
        if (this.mErrorView == null) {
            this.mErrorView = new WWWErrorView(getWebView().getContext(), getWebView());
            this.mErrorView.setReloadListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsWebViewWidget.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AiAppNetworkUtils.isNetworkConnected(AiAppsWebViewWidget.this.getWebView().getContext()) && WebSafeCheckers.checkWebDomain(AiAppsWebViewWidget.this.getWebView().getUrl())) {
                        AiAppsWebViewWidget.this.getWebView().reload();
                        AiAppsWebViewWidget.this.mErrorView.hideErrorView();
                    }
                }
            });
        }
        return this.mErrorView;
    }

    /* loaded from: classes2.dex */
    protected class WebViewWidgetClient extends h {
        /* JADX INFO: Access modifiers changed from: protected */
        public WebViewWidgetClient() {
        }

        @Override // com.baidu.browser.sailor.h
        public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
            AiAppsWebViewWidget.this.getProgressBar().startProgress();
        }

        @Override // com.baidu.browser.sailor.h
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            super.onReceivedError(bdSailorWebView, i, str, str2);
            if (i != -10) {
                AiAppsWebViewWidget.this.getErrorView().showErrorView();
            }
        }

        @Override // com.baidu.browser.sailor.h
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            AiAppsWebViewWidget.this.getProgressBar().hideProgressBar();
        }

        @Override // com.baidu.browser.sailor.h
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            return !WebSafeCheckers.checkWebDomain(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class WWWProgressBar {
        private static final int PROGRESS_START_VALUE = 0;
        private EfficientProgressBar mProgressBar;

        public WWWProgressBar(Context context, ViewGroup viewGroup) {
            this.mProgressBar = null;
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.mProgressBar = new EfficientProgressBar(context);
            this.mProgressBar.setProgressDrawable(context.getResources().getDrawable(R.drawable.aiapps_progress_thumb));
            this.mProgressBar.setId(R.id.aiapps_nbsearch_web_loading_progress_bar);
            this.mProgressBar.setVisibility(4);
            this.mProgressBar.setFocusable(false);
            this.mProgressBar.setClickable(false);
            viewGroup.addView(this.mProgressBar);
        }

        public void startProgress() {
            this.mProgressBar.reset();
            updateProgress(0);
        }

        public void updateProgress(int i) {
            this.mProgressBar.setProgress(i, true);
        }

        public void hideProgressBar() {
            this.mProgressBar.setProgress(100, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class WWWErrorView {
        private NetworkErrorView mErrorView;

        public WWWErrorView(Context context, ViewGroup viewGroup) {
            if (context == null || viewGroup == null) {
                throw new IllegalArgumentException("context and viewGroup must not be null.");
            }
            this.mErrorView = new NetworkErrorView(context);
            this.mErrorView.setBackgroundColor(context.getResources().getColor(R.color.aiapps_white));
            viewGroup.addView(this.mErrorView, new FrameLayout.LayoutParams(-1, -1));
            this.mErrorView.setVisibility(8);
        }

        public void showErrorView() {
            this.mErrorView.setVisibility(0);
        }

        public void hideErrorView() {
            this.mErrorView.setVisibility(8);
        }

        public void setReloadListener(View.OnClickListener onClickListener) {
            this.mErrorView.setOnClickListener(onClickListener);
            this.mErrorView.setReloadClickListener(onClickListener);
        }
    }
}
