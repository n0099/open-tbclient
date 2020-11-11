package com.baidu.swan.apps.view;

import android.content.Context;
import com.baidu.browser.sailor.BdSailorWebChromeClient;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.swan.apps.core.slave.SwanAppWebViewWidget;
/* loaded from: classes10.dex */
public class SwanAppSimpleH5Widget extends SwanAppWebViewWidget {
    public SwanAppSimpleH5Widget(Context context) {
        super(context);
        a(new SimpleWebViewClient());
        a(new SimpleWebChromeClient());
        this.cIl.setOnWebViewHookHandler(this);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget
    protected boolean apr() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.core.container.c
    public boolean anj() {
        if (this.cPm != null) {
            this.cPm.goBack();
            return false;
        }
        return false;
    }

    /* loaded from: classes10.dex */
    private class SimpleWebViewClient extends SwanAppWebViewWidget.WebViewWidgetClient {
        private SimpleWebViewClient() {
            super();
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient, com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            return SwanAppSimpleH5Widget.this.cPm != null && SwanAppSimpleH5Widget.this.cPm.iQ(str);
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient, com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppSimpleH5Widget.this.cPm != null) {
                SwanAppSimpleH5Widget.this.cPm.hV(str);
            }
            super.onPageFinished(bdSailorWebView, str);
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient, com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (SwanAppSimpleH5Widget.this.cPm != null) {
                SwanAppSimpleH5Widget.this.cPm.e(i, str, str2);
            }
            super.onReceivedError(bdSailorWebView, i, str, str2);
        }
    }

    /* loaded from: classes10.dex */
    class SimpleWebChromeClient extends BdSailorWebChromeClient {
        SimpleWebChromeClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedTitle(BdSailorWebView bdSailorWebView, String str) {
            super.onReceivedTitle(bdSailorWebView, str);
            if (SwanAppSimpleH5Widget.this.cPm != null) {
                SwanAppSimpleH5Widget.this.cPm.iP(str);
            }
        }
    }
}
