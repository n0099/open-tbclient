package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.v.b.b;
/* loaded from: classes11.dex */
public class h {
    public static void mJ(String str) {
        if (TextUtils.equals(g.bC("route", str).mC("sub_state"), "1")) {
            g.bC("route", str).f(new UbcFlowEvent("na_end_sub_package_download"));
        }
    }

    public static void a(b.a aVar, String str) {
        g.bC("route", str).f(new UbcFlowEvent("na_pre_load_slave_ok"));
        if (aVar != null) {
            if (aVar.ceL != null) {
                aVar.ceL.hh(str);
            }
            g.bC("route", str).f(new UbcFlowEvent("na_pre_load_slave_start").bg(aVar.ceN)).f(new UbcFlowEvent("na_pre_load_slave_end").bg(aVar.ceO));
        }
    }

    public static void mK(String str) {
        com.baidu.swan.apps.aa.e.ex(true);
        g.bG("route", str);
        g.bC("route", str).f(new UbcFlowEvent("na_first_receive_action")).bF("sub_state", "0");
    }

    public static void U(int i, String str) {
        HybridUbcFlow bC = g.bC("route", str);
        if (i == 6 || i == 4 || i == 1) {
            bC.a(HybridUbcFlow.SubmitStrategy.ROUTE_NA);
        } else {
            bC.a(HybridUbcFlow.SubmitStrategy.ROUTE);
        }
        bC.r("type", Integer.valueOf(i));
    }

    public static void mL(String str) {
        b.a RP;
        com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
        if (apM != null && (RP = apM.RP()) != null) {
            g.bC("route", str).bF("appid", RP.getAppId()).bF("launchid", RP.aij()).r("from", "swan").bF("web_widget_state", "0").ami();
        }
    }

    public static void mM(String str) {
        g.bC("route", str).f(new UbcFlowEvent("web_widget_first_screen_finish")).bF("web_widget_state", "1").amk();
    }
}
