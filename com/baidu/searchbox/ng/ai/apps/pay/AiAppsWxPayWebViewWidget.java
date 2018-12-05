package com.baidu.searchbox.ng.ai.apps.pay;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.browser.BrowserType;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.searchbox.ng.ai.apps.core.container.PullToRefreshWebView;
import com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsWebViewWidget;
import com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.PullToRefreshBase;
/* loaded from: classes2.dex */
public class AiAppsWxPayWebViewWidget extends AiAppsWebViewWidget {
    private static final boolean DEBUG = false;
    private static final String TAG = "AiAppsWxPayWebViewWidget";
    private WxPayWebViewListener mWebViewListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AiAppsWxPayWebViewWidget(Context context) {
        super(context);
        setExternalWebViewClient(new WxPayWebViewClient());
        this.mNgWebView.setOnWebViewHookHandler(this);
    }

    public void setWxPayWebViewListener(WxPayWebViewListener wxPayWebViewListener) {
        this.mWebViewListener = wxPayWebViewListener;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsWebViewWidget, com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlaveManager, com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager
    public void loadUrl(String str) {
        this.mIsNeedCheckWebDomain = false;
        super.loadUrl(str);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsWebViewWidget, com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlaveManager, com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager
    protected BrowserType getBrowserType() {
        return BrowserType.AI_APPS_WEBVIEW;
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
    private class WxPayWebViewClient extends AiAppsWebViewWidget.WebViewWidgetClient {
        private WxPayWebViewClient() {
            super();
        }

        @Override // com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsWebViewWidget.WebViewWidgetClient, com.baidu.browser.sailor.h
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (AiAppsWxPayWebViewWidget.this.mWebViewListener != null) {
                return AiAppsWxPayWebViewWidget.this.mWebViewListener.shouldOverrideUrlLoading(bdSailorWebView, str);
            }
            return false;
        }
    }
}
