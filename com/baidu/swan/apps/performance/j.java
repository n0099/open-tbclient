package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import com.baidu.searchbox.perfframe.ioc.Constant;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.games.view.webview.GameWebViewJavascriptInterface;
/* loaded from: classes9.dex */
public class j {
    public static void qx(String str) {
        if (TextUtils.equals(i.cd("route", str).qp("sub_state"), "1")) {
            i.cd("route", str).f(new UbcFlowEvent("na_end_sub_package_download"));
        }
    }

    public static void a(b.a aVar, String str) {
        i.cd("route", str).f(new UbcFlowEvent("na_pre_load_slave_ok"));
        if (aVar != null) {
            if (aVar.cXb != null) {
                aVar.cXb.jX(str);
            }
            i.cd("route", str).f(new UbcFlowEvent("na_pre_load_slave_start").cE(aVar.cXd)).f(new UbcFlowEvent("na_pre_load_slave_end").cE(aVar.cXe));
        }
    }

    public static void qy(String str) {
        com.baidu.swan.apps.y.e.gn(true);
        com.baidu.swan.apps.inlinewidget.f.b.b.awA();
        i.ch("route", str);
        i.cd("route", str).f(new UbcFlowEvent("na_first_receive_action")).cg("sub_state", "0");
    }

    public static void as(int i, String str) {
        HybridUbcFlow cd = i.cd("route", str);
        if (i == 6 || i == 4 || i == 1) {
            cd.a(HybridUbcFlow.SubmitStrategy.ROUTE_NA);
        } else {
            cd.a(HybridUbcFlow.SubmitStrategy.ROUTE);
        }
        cd.o("type", Integer.valueOf(i));
    }

    public static void qz(String str) {
        b.a afZ;
        com.baidu.swan.apps.runtime.e aIK = com.baidu.swan.apps.runtime.e.aIK();
        if (aIK != null && (afZ = aIK.afZ()) != null) {
            i.cd("route", str).cg("appid", afZ.getAppId()).cg(Constant.KEY_LAUNCHID, afZ.azt()).o("from", GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME).cg("web_widget_state", "0").aDI();
        }
    }

    public static void qA(String str) {
        i.cd("route", str).f(new UbcFlowEvent("web_widget_first_screen_finish")).cg("web_widget_state", "1").aDK();
    }
}
