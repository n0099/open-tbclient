package com.baidu.swan.apps.view;

import android.content.Context;
import com.baidu.browser.sailor.BdSailorWebChromeClient;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.swan.apps.core.slave.SwanAppWebViewWidget;
import d.b.g0.a.e0.n.d;
/* loaded from: classes3.dex */
public class SwanAppSimpleH5Widget extends SwanAppWebViewWidget {

    /* loaded from: classes3.dex */
    public class SimpleWebChromeClient extends BdSailorWebChromeClient {
        public SimpleWebChromeClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedTitle(BdSailorWebView bdSailorWebView, String str) {
            super.onReceivedTitle(bdSailorWebView, str);
            if (SwanAppSimpleH5Widget.this.U != null) {
                SwanAppSimpleH5Widget.this.U.a(str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class SimpleWebViewClient extends SwanAppWebViewWidget.WebViewWidgetClient {
        public SimpleWebViewClient() {
            super();
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient, com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppSimpleH5Widget.this.U != null) {
                SwanAppSimpleH5Widget.this.U.d(str);
            }
            super.onPageFinished(bdSailorWebView, str);
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient, com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (SwanAppSimpleH5Widget.this.U != null) {
                SwanAppSimpleH5Widget.this.U.c(i, str, str2);
            }
            super.onReceivedError(bdSailorWebView, i, str, str2);
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient, com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            return SwanAppSimpleH5Widget.this.U != null && SwanAppSimpleH5Widget.this.U.b(str);
        }
    }

    public SwanAppSimpleH5Widget(Context context) {
        super(context);
        R0(new SimpleWebViewClient());
        Q0(new SimpleWebChromeClient());
        this.f12154f.setOnWebViewHookHandler(this);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget
    public boolean G1() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.b.g0.a.e0.k.c
    public boolean u() {
        d dVar = this.U;
        if (dVar != null) {
            dVar.goBack();
            return false;
        }
        return false;
    }
}
