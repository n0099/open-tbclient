package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes10.dex */
public class j {
    public static void qp(String str) {
        if (TextUtils.equals(i.bY("route", str).qh("sub_state"), "1")) {
            i.bY("route", str).f(new UbcFlowEvent("na_end_sub_package_download"));
        }
    }

    public static void a(b.a aVar, String str) {
        i.bY("route", str).f(new UbcFlowEvent("na_pre_load_slave_ok"));
        if (aVar != null) {
            if (aVar.cBg != null) {
                aVar.cBg.jO(str);
            }
            i.bY("route", str).f(new UbcFlowEvent("na_pre_load_slave_start").bA(aVar.cBi)).f(new UbcFlowEvent("na_pre_load_slave_end").bA(aVar.cBj));
        }
    }

    public static void qq(String str) {
        com.baidu.swan.apps.y.e.fs(true);
        com.baidu.swan.apps.inlinewidget.f.b.b.arJ();
        i.cc("route", str);
        i.bY("route", str).f(new UbcFlowEvent("na_first_receive_action")).cb("sub_state", "0");
    }

    public static void af(int i, String str) {
        HybridUbcFlow bY = i.bY("route", str);
        if (i == 6 || i == 4 || i == 1) {
            bY.a(HybridUbcFlow.SubmitStrategy.ROUTE_NA);
        } else {
            bY.a(HybridUbcFlow.SubmitStrategy.ROUTE);
        }
        bY.r("type", Integer.valueOf(i));
    }

    public static void qr(String str) {
        b.a abu;
        com.baidu.swan.apps.runtime.e aDa = com.baidu.swan.apps.runtime.e.aDa();
        if (aDa != null && (abu = aDa.abu()) != null) {
            i.bY("route", str).cb("appid", abu.getAppId()).cb("launchid", abu.auC()).r("from", "swan").cb("web_widget_state", "0").ayR();
        }
    }

    public static void qs(String str) {
        i.bY("route", str).f(new UbcFlowEvent("web_widget_first_screen_finish")).cb("web_widget_state", "1").ayT();
    }
}
