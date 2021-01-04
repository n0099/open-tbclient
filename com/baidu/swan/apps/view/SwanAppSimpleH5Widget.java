package com.baidu.swan.apps.view;

import android.content.Context;
import com.baidu.browser.sailor.BdSailorWebChromeClient;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.swan.apps.core.slave.SwanAppWebViewWidget;
/* loaded from: classes9.dex */
public class SwanAppSimpleH5Widget extends SwanAppWebViewWidget {
    public SwanAppSimpleH5Widget(Context context) {
        super(context);
        a(new SimpleWebViewClient());
        a(new SimpleWebChromeClient());
        this.cSq.setOnWebViewHookHandler(this);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget
    protected boolean ati() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.core.container.c
    public boolean aqV() {
        if (this.cZr != null) {
            this.cZr.goBack();
            return false;
        }
        return false;
    }

    /* loaded from: classes9.dex */
    private class SimpleWebViewClient extends SwanAppWebViewWidget.WebViewWidgetClient {
        private SimpleWebViewClient() {
            super();
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient, com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            return SwanAppSimpleH5Widget.this.cZr != null && SwanAppSimpleH5Widget.this.cZr.jh(str);
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient, com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppSimpleH5Widget.this.cZr != null) {
                SwanAppSimpleH5Widget.this.cZr.ig(str);
            }
            super.onPageFinished(bdSailorWebView, str);
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient, com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (SwanAppSimpleH5Widget.this.cZr != null) {
                SwanAppSimpleH5Widget.this.cZr.g(i, str, str2);
            }
            super.onReceivedError(bdSailorWebView, i, str, str2);
        }
    }

    /* loaded from: classes9.dex */
    class SimpleWebChromeClient extends BdSailorWebChromeClient {
        SimpleWebChromeClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedTitle(BdSailorWebView bdSailorWebView, String str) {
            super.onReceivedTitle(bdSailorWebView, str);
            if (SwanAppSimpleH5Widget.this.cZr != null) {
                SwanAppSimpleH5Widget.this.cZr.jg(str);
            }
        }
    }
}
