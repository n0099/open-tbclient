package com.baidu.swan.apps.core.slave;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.slave.SwanAppWebViewWidget;
import com.baidu.tieba.bc3;
import com.baidu.tieba.mi3;
import com.baidu.tieba.qd2;
import com.baidu.tieba.tp3;
import com.baidu.tieba.ur3;
import com.baidu.tieba.xr3;
import com.baidu.tieba.y13;
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

    @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.ky1
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
            qd2 qd2Var = SwanWebModeWidget.this.U;
            if (qd2Var != null) {
                qd2Var.e(str);
            }
            xr3.a().h(str);
            ur3.c().q(str);
            SwanWebModeWidget.this.W1();
            ur3.c().l(str);
            super.onPageFinished(bdSailorWebView, str);
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient, com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            qd2 qd2Var = SwanWebModeWidget.this.U;
            if (qd2Var != null && qd2Var.a(str)) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient, com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
            SwanWebModeWidget.this.f1072T = tp3.t();
            super.onPageStarted(bdSailorWebView, str, bitmap);
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget.WebViewWidgetClient, com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            qd2 qd2Var = SwanWebModeWidget.this.U;
            if (qd2Var != null) {
                qd2Var.c(i, str, str2);
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
            xr3.a().c(str);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstImagePaintExt(bdSailorWebView, str);
            xr3.a().d(str);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            xr3.a().f(str);
            if (TextUtils.equals(ur3.c().f(), "3")) {
                mi3.s(bc3.K().q().W());
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstTextPaintExt(bdSailorWebView, str);
            xr3.a().e(str);
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
        int b = y13.b();
        y13.g(b, y13.a(b));
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.cb2
    public boolean n() {
        qd2 qd2Var = this.U;
        if (qd2Var != null) {
            qd2Var.goBack();
        }
        return super.n();
    }
}
