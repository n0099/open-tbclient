package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.x.b.b;
/* loaded from: classes11.dex */
public class g {
    public static void jZ(String str) {
        if (TextUtils.equals(f.aX("route", str).jS("sub_state"), "1")) {
            f.aX("route", str).f(new UbcFlowEvent("na_end_sub_package_download"));
        }
    }

    public static void a(b.a aVar, String str) {
        f.aX("route", str).f(new UbcFlowEvent("na_pre_load_slave_ok"));
        if (aVar != null) {
            if (aVar.brX != null) {
                aVar.brX.fa(str);
            }
            f.aX("route", str).f(new UbcFlowEvent("na_pre_load_slave_start").au(aVar.bsa)).f(new UbcFlowEvent("na_pre_load_slave_end").au(aVar.bsb));
        }
    }

    public static void ka(String str) {
        com.baidu.swan.apps.ac.e.df(true);
        f.bb("route", str);
        f.aX("route", str).f(new UbcFlowEvent("na_first_receive_action")).ba("sub_state", "0");
    }

    public static void A(int i, String str) {
        HybridUbcFlow aX = f.aX("route", str);
        if (i == 6 || i == 4 || i == 1) {
            aX.a(HybridUbcFlow.SubmitStrategy.ROUTE_NA);
        } else {
            aX.a(HybridUbcFlow.SubmitStrategy.ROUTE);
        }
        aX.k("type", Integer.valueOf(i));
    }

    public static void kb(String str) {
        b.a GJ;
        com.baidu.swan.apps.runtime.e acI = com.baidu.swan.apps.runtime.e.acI();
        if (acI != null && (GJ = acI.GJ()) != null) {
            f.aX("route", str).ba("appid", GJ.getAppId()).ba("launchid", GJ.Wf()).k("from", "swan").ba("web_widget_state", "0").ZD();
        }
    }

    public static void kc(String str) {
        f.aX("route", str).f(new UbcFlowEvent("web_widget_first_screen_finish")).ba("web_widget_state", "1").ZG();
    }
}
