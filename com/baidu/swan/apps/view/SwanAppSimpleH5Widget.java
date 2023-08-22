package com.baidu.swan.apps.view;

import android.content.Context;
import com.baidu.browser.sailor.BdSailorWebChromeClient;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.swan.apps.core.slave.SwanAppWebViewWidget;
import com.baidu.tieba.rc2;
/* loaded from: classes4.dex */
public class SwanAppSimpleH5Widget extends SwanAppWebViewWidget {
    @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget
    public boolean S1() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget
    public boolean T1() {
        return false;
    }

    /* loaded from: classes4.dex */
    public class SimpleWebChromeClient extends BdSailorWebChromeClient {
        public SimpleWebChromeClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedTitle(BdSailorWebView bdSailorWebView, String str) {
            super.onReceivedTitle(bdSailorWebView, str);
            if (SwanAppSimpleH5Widget.this.U != null) {
                SwanAppSimpleH5Widget.this.U.d(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class SimpleWebViewClient extends SwanAppWebViewWidget.WebViewWidgetClient {
        public SimpleWebViewClient() {
            super();
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient, com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppSimpleH5Widget.this.U != null) {
                SwanAppSimpleH5Widget.this.U.e(str);
            }
            super.onPageFinished(bdSailorWebView, str);
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient, com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppSimpleH5Widget.this.U != null && SwanAppSimpleH5Widget.this.U.a(str)) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient, com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (SwanAppSimpleH5Widget.this.U != null) {
                SwanAppSimpleH5Widget.this.U.c(i, str, str2);
            }
            super.onReceivedError(bdSailorWebView, i, str, str2);
        }
    }

    public SwanAppSimpleH5Widget(Context context) {
        super(context);
        W0(new SimpleWebViewClient());
        V0(new SimpleWebChromeClient());
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.da2
    public boolean n() {
        rc2 rc2Var = this.U;
        if (rc2Var != null) {
            rc2Var.goBack();
        }
        return super.n();
    }
}
