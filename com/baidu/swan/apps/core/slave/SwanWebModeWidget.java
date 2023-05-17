package com.baidu.swan.apps.core.slave;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.slave.SwanAppWebViewWidget;
import com.baidu.tieba.bp3;
import com.baidu.tieba.cz2;
import com.baidu.tieba.f93;
import com.baidu.tieba.qf3;
import com.baidu.tieba.ua2;
import com.baidu.tieba.xm3;
import com.baidu.tieba.yo3;
/* loaded from: classes4.dex */
public class SwanWebModeWidget extends SwanAppWebViewWidget implements CallbackHandler {
    @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget
    public boolean U1() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget
    public boolean V1() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.ov1
    public String b0() {
        return "swan_app_web_mode_widget";
    }

    /* loaded from: classes4.dex */
    public class SwanWebModeClient extends SwanAppWebViewWidget.WebViewWidgetClient {
        public SwanWebModeClient() {
            super();
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient, com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            ua2 ua2Var = SwanWebModeWidget.this.U;
            if (ua2Var != null) {
                ua2Var.e(str);
            }
            bp3.a().h(str);
            yo3.c().q(str);
            SwanWebModeWidget.this.Y1();
            yo3.c().l(str);
            super.onPageFinished(bdSailorWebView, str);
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient, com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            ua2 ua2Var = SwanWebModeWidget.this.U;
            if (ua2Var != null && ua2Var.a(str)) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient, com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
            SwanWebModeWidget.this.T = xm3.t();
            super.onPageStarted(bdSailorWebView, str, bitmap);
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient, com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            ua2 ua2Var = SwanWebModeWidget.this.U;
            if (ua2Var != null) {
                ua2Var.c(i, str, str2);
            }
            super.onReceivedError(bdSailorWebView, i, str, str2);
        }
    }

    /* loaded from: classes4.dex */
    public class SwanWebWidgetClientExt extends BdSailorWebViewClientExt {
        public SwanWebWidgetClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            bp3.a().c(str);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstImagePaintExt(bdSailorWebView, str);
            bp3.a().d(str);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            bp3.a().f(str);
            if (TextUtils.equals(yo3.c().f(), "3")) {
                qf3.s(f93.K().q().W());
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstTextPaintExt(bdSailorWebView, str);
            bp3.a().e(str);
        }
    }

    public SwanWebModeWidget(Context context) {
        super(context);
        Y0(new SwanWebModeClient());
        Z0(new SwanWebWidgetClientExt());
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget, com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    public void U0(SwanAppWebViewManager.d dVar) {
        super.U0(dVar);
        dVar.b = true;
    }

    public void Y1() {
        int b = cz2.b();
        cz2.g(b, cz2.a(b));
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.g82
    public boolean o() {
        ua2 ua2Var = this.U;
        if (ua2Var != null) {
            ua2Var.goBack();
        }
        return super.o();
    }
}
