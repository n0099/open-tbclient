package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.x.b.b;
/* loaded from: classes9.dex */
public class g {
    public static void jI(String str) {
        if (TextUtils.equals(f.aO("route", str).jB("sub_state"), "1")) {
            f.aO("route", str).f(new UbcFlowEvent("na_end_sub_package_download"));
        }
    }

    public static void a(b.a aVar, String str) {
        f.aO("route", str).f(new UbcFlowEvent("na_pre_load_slave_ok"));
        if (aVar != null) {
            if (aVar.bmM != null) {
                aVar.bmM.eJ(str);
            }
            f.aO("route", str).f(new UbcFlowEvent("na_pre_load_slave_start").an(aVar.bmP)).f(new UbcFlowEvent("na_pre_load_slave_end").an(aVar.bmQ));
        }
    }

    public static void jJ(String str) {
        com.baidu.swan.apps.ac.e.cS(true);
        f.aS("route", str);
        f.aO("route", str).f(new UbcFlowEvent("na_first_receive_action")).aR("sub_state", "0");
    }

    public static void v(int i, String str) {
        HybridUbcFlow aO = f.aO("route", str);
        if (i == 6 || i == 4 || i == 1) {
            aO.a(HybridUbcFlow.SubmitStrategy.ROUTE_NA);
        } else {
            aO.a(HybridUbcFlow.SubmitStrategy.ROUTE);
        }
        aO.k("type", Integer.valueOf(i));
    }

    public static void jK(String str) {
        b.a DR;
        com.baidu.swan.apps.runtime.e ZS = com.baidu.swan.apps.runtime.e.ZS();
        if (ZS != null && (DR = ZS.DR()) != null) {
            f.aO("route", str).aR("appid", DR.getAppId()).aR("launchid", DR.Tp()).k("from", "swan").aR("web_widget_state", "0").WN();
        }
    }

    public static void jL(String str) {
        f.aO("route", str).f(new UbcFlowEvent("web_widget_first_screen_finish")).aR("web_widget_state", "1").WQ();
    }
}
