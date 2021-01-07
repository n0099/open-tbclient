package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import com.baidu.searchbox.perfframe.ioc.Constant;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.games.view.webview.GameWebViewJavascriptInterface;
/* loaded from: classes9.dex */
public class j {
    public static void rq(String str) {
        if (TextUtils.equals(i.ck("route", str).ri("sub_state"), "1")) {
            i.ck("route", str).f(new UbcFlowEvent("na_end_sub_package_download"));
        }
    }

    public static void a(b.a aVar, String str) {
        i.ck("route", str).f(new UbcFlowEvent("na_pre_load_slave_ok"));
        if (aVar != null) {
            if (aVar.cZA != null) {
                aVar.cZA.kQ(str);
            }
            i.ck("route", str).f(new UbcFlowEvent("na_pre_load_slave_start").cy(aVar.cZC)).f(new UbcFlowEvent("na_pre_load_slave_end").cy(aVar.cZD));
        }
    }

    public static void rr(String str) {
        com.baidu.swan.apps.y.e.gp(true);
        com.baidu.swan.apps.inlinewidget.f.b.b.azW();
        i.co("route", str);
        i.ck("route", str).f(new UbcFlowEvent("na_first_receive_action")).cn("sub_state", "0");
    }

    public static void an(int i, String str) {
        HybridUbcFlow ck = i.ck("route", str);
        if (i == 6 || i == 4 || i == 1) {
            ck.a(HybridUbcFlow.SubmitStrategy.ROUTE_NA);
        } else {
            ck.a(HybridUbcFlow.SubmitStrategy.ROUTE);
        }
        ck.q("type", Integer.valueOf(i));
    }

    public static void rs(String str) {
        b.a ajv;
        com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
        if (aMl != null && (ajv = aMl.ajv()) != null) {
            i.ck("route", str).cn("appid", ajv.getAppId()).cn(Constant.KEY_LAUNCHID, ajv.aCP()).q("from", GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME).cn("web_widget_state", "0").aHg();
        }
    }

    public static void rt(String str) {
        i.ck("route", str).f(new UbcFlowEvent("web_widget_first_screen_finish")).cn("web_widget_state", "1").aHi();
    }
}
