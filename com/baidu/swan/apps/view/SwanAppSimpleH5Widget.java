package com.baidu.swan.apps.view;

import android.content.Context;
import com.baidu.browser.sailor.BdSailorWebChromeClient;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.swan.apps.core.slave.SwanAppWebViewWidget;
import d.a.i0.a.h0.j.d;
/* loaded from: classes3.dex */
public class SwanAppSimpleH5Widget extends SwanAppWebViewWidget {

    /* loaded from: classes3.dex */
    public class SimpleWebChromeClient extends BdSailorWebChromeClient {
        public SimpleWebChromeClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedTitle(BdSailorWebView bdSailorWebView, String str) {
            super.onReceivedTitle(bdSailorWebView, str);
            if (SwanAppSimpleH5Widget.this.W != null) {
                SwanAppSimpleH5Widget.this.W.a(str);
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
            if (SwanAppSimpleH5Widget.this.W != null) {
                SwanAppSimpleH5Widget.this.W.e(str);
            }
            super.onPageFinished(bdSailorWebView, str);
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient, com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i2, String str, String str2) {
            if (SwanAppSimpleH5Widget.this.W != null) {
                SwanAppSimpleH5Widget.this.W.d(i2, str, str2);
            }
            super.onReceivedError(bdSailorWebView, i2, str, str2);
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient, com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            return SwanAppSimpleH5Widget.this.W != null && SwanAppSimpleH5Widget.this.W.c(str);
        }
    }

    public SwanAppSimpleH5Widget(Context context) {
        super(context);
        Y0(new SimpleWebViewClient());
        X0(new SimpleWebChromeClient());
        this.f10803f.setOnWebViewHookHandler(this);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget
    public boolean R1() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.i0.a.h0.f.c
    public boolean q() {
        d dVar = this.W;
        if (dVar != null) {
            dVar.goBack();
            return false;
        }
        return false;
    }
}
