package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.x.b.b;
/* loaded from: classes10.dex */
public class g {
    public static void jL(String str) {
        if (TextUtils.equals(f.aP("route", str).jE("sub_state"), "1")) {
            f.aP("route", str).f(new UbcFlowEvent("na_end_sub_package_download"));
        }
    }

    public static void a(b.a aVar, String str) {
        f.aP("route", str).f(new UbcFlowEvent("na_pre_load_slave_ok"));
        if (aVar != null) {
            if (aVar.bnA != null) {
                aVar.bnA.eM(str);
            }
            f.aP("route", str).f(new UbcFlowEvent("na_pre_load_slave_start").aq(aVar.bnD)).f(new UbcFlowEvent("na_pre_load_slave_end").aq(aVar.bnE));
        }
    }

    public static void jM(String str) {
        com.baidu.swan.apps.ac.e.cX(true);
        f.aT("route", str);
        f.aP("route", str).f(new UbcFlowEvent("na_first_receive_action")).aS("sub_state", "0");
    }

    public static void y(int i, String str) {
        HybridUbcFlow aP = f.aP("route", str);
        if (i == 6 || i == 4 || i == 1) {
            aP.a(HybridUbcFlow.SubmitStrategy.ROUTE_NA);
        } else {
            aP.a(HybridUbcFlow.SubmitStrategy.ROUTE);
        }
        aP.k("type", Integer.valueOf(i));
    }

    public static void jN(String str) {
        b.a En;
        com.baidu.swan.apps.runtime.e aap = com.baidu.swan.apps.runtime.e.aap();
        if (aap != null && (En = aap.En()) != null) {
            f.aP("route", str).aS("appid", En.getAppId()).aS("launchid", En.TM()).k("from", "swan").aS("web_widget_state", "0").Xk();
        }
    }

    public static void jO(String str) {
        f.aP("route", str).f(new UbcFlowEvent("web_widget_first_screen_finish")).aS("web_widget_state", "1").Xn();
    }
}
