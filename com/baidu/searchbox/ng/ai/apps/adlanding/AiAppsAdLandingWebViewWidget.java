package com.baidu.searchbox.ng.ai.apps.adlanding;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import com.baidu.browser.BrowserType;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.e;
import com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager;
import com.baidu.searchbox.ng.ai.apps.core.container.PullToRefreshWebView;
import com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsWebViewWidget;
import com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshBase;
/* loaded from: classes2.dex */
public class AiAppsAdLandingWebViewWidget extends AiAppsWebViewWidget {
    private static final boolean DEBUG = false;
    private static final String TAG = "AiAppAdLandingWVWidget";
    private AdLandingWebViewListener mWebViewListener;

    public AiAppsAdLandingWebViewWidget(Context context) {
        super(context);
        setExternalWebViewClient(new AdLandingWebViewClient());
        setExternalWebChromeClient(new AdLandingWebChromeClient());
        this.mNgWebView.setOnWebViewHookHandler(this);
    }

    public void setAdLandingWebViewListener(AdLandingWebViewListener adLandingWebViewListener) {
        this.mWebViewListener = adLandingWebViewListener;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsWebViewWidget, com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlaveManager, com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager
    public void loadUrl(String str) {
        this.mIsNeedCheckWebDomain = false;
        super.loadUrl(str);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager, com.baidu.searchbox.ng.ai.apps.core.container.NgWebView.OnWebViewHookHandler
    public void hookGoBack() {
        if (this.mWebViewListener != null) {
            this.mWebViewListener.goBack();
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsWebViewWidget, com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlaveManager, com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager
    protected BrowserType getBrowserType() {
        return BrowserType.AI_APPS_ADLANDING;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsWebViewWidget, com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager
    protected String getFrameName() {
        return AiAppsWebViewManager.FRAME_WHITE_LIST_AI_APPS_AD_LANDING;
    }

    public void addToParent(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null) {
            if (z) {
                this.mPullToRefreshWebView = new PullToRefreshWebView(this.mContext, this, PullToRefreshBase.HEADERTYPE.AIAPPS_HEADER);
                sendPullDownRefreshMessage(this.mPullToRefreshWebView);
                addView(viewGroup, this.mPullToRefreshWebView);
                return;
            }
            addView(viewGroup, getWebView());
        }
    }

    /* loaded from: classes2.dex */
    private class AdLandingWebViewClient extends AiAppsWebViewWidget.WebViewWidgetClient {
        private AdLandingWebViewClient() {
            super();
        }

        @Override // com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsWebViewWidget.WebViewWidgetClient, com.baidu.browser.sailor.h
        public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
            super.onPageStarted(bdSailorWebView, str, bitmap);
            if (AiAppsAdLandingWebViewWidget.this.mWebViewListener != null) {
                AiAppsAdLandingWebViewWidget.this.mWebViewListener.onPageStarted();
            }
        }

        @Override // com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsWebViewWidget.WebViewWidgetClient, com.baidu.browser.sailor.h
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (AiAppsAdLandingWebViewWidget.this.mWebViewListener != null) {
                return AiAppsAdLandingWebViewWidget.this.mWebViewListener.shouldOverrideUrlLoading(bdSailorWebView, str);
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    class AdLandingWebChromeClient extends e {
        AdLandingWebChromeClient() {
        }

        @Override // com.baidu.browser.sailor.e
        public void onReceivedTitle(BdSailorWebView bdSailorWebView, String str) {
            super.onReceivedTitle(bdSailorWebView, str);
            if (AiAppsAdLandingWebViewWidget.this.mWebViewListener != null) {
                AiAppsAdLandingWebViewWidget.this.mWebViewListener.onReceivedTitle(str);
            }
        }
    }
}
