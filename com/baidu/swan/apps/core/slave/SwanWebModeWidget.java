package com.baidu.swan.apps.core.slave;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.slave.SwanAppWebViewWidget;
import com.baidu.tieba.cr3;
import com.baidu.tieba.d13;
import com.baidu.tieba.gb3;
import com.baidu.tieba.rh3;
import com.baidu.tieba.vc2;
import com.baidu.tieba.yo3;
import com.baidu.tieba.zq3;
/* loaded from: classes4.dex */
public class SwanWebModeWidget extends SwanAppWebViewWidget implements CallbackHandler {
    @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget
    public boolean S1() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget
    public boolean T1() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.px1
    public String Z() {
        return "swan_app_web_mode_widget";
    }

    /* loaded from: classes4.dex */
    public class SwanWebModeClient extends SwanAppWebViewWidget.WebViewWidgetClient {
        public SwanWebModeClient() {
            super();
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient, com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            vc2 vc2Var = SwanWebModeWidget.this.U;
            if (vc2Var != null) {
                vc2Var.e(str);
            }
            cr3.a().h(str);
            zq3.c().q(str);
            SwanWebModeWidget.this.W1();
            zq3.c().l(str);
            super.onPageFinished(bdSailorWebView, str);
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient, com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            vc2 vc2Var = SwanWebModeWidget.this.U;
            if (vc2Var != null && vc2Var.a(str)) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient, com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
            SwanWebModeWidget.this.f1071T = yo3.t();
            super.onPageStarted(bdSailorWebView, str, bitmap);
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient, com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            vc2 vc2Var = SwanWebModeWidget.this.U;
            if (vc2Var != null) {
                vc2Var.c(i, str, str2);
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
            cr3.a().c(str);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstImagePaintExt(bdSailorWebView, str);
            cr3.a().d(str);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            cr3.a().f(str);
            if (TextUtils.equals(zq3.c().f(), "3")) {
                rh3.s(gb3.K().q().W());
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstTextPaintExt(bdSailorWebView, str);
            cr3.a().e(str);
        }
    }

    public SwanWebModeWidget(Context context) {
        super(context);
        W0(new SwanWebModeClient());
        X0(new SwanWebWidgetClientExt());
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget, com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    public void S0(SwanAppWebViewManager.d dVar) {
        super.S0(dVar);
        dVar.b = true;
    }

    public void W1() {
        int b = d13.b();
        d13.g(b, d13.a(b));
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.ha2
    public boolean n() {
        vc2 vc2Var = this.U;
        if (vc2Var != null) {
            vc2Var.goBack();
        }
        return super.n();
    }
}
