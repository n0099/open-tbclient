package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes7.dex */
public class j {
    public static void nl(String str) {
        if (TextUtils.equals(i.bE("route", str).nc("sub_state"), "1")) {
            i.bE("route", str).f(new UbcFlowEvent("na_end_sub_package_download"));
        }
    }

    public static void a(b.a aVar, String str) {
        i.bE("route", str).f(new UbcFlowEvent("na_pre_load_slave_ok"));
        if (aVar != null) {
            if (aVar.cgw != null) {
                aVar.cgw.hn(str);
            }
            i.bE("route", str).f(new UbcFlowEvent("na_pre_load_slave_start").bm(aVar.cgy)).f(new UbcFlowEvent("na_pre_load_slave_end").bm(aVar.cgz));
        }
    }

    public static void nm(String str) {
        com.baidu.swan.apps.z.e.eG(true);
        i.bI("route", str);
        i.bE("route", str).f(new UbcFlowEvent("na_first_receive_action")).bH("sub_state", "0");
    }

    public static void U(int i, String str) {
        HybridUbcFlow bE = i.bE("route", str);
        if (i == 6 || i == 4 || i == 1) {
            bE.a(HybridUbcFlow.SubmitStrategy.ROUTE_NA);
        } else {
            bE.a(HybridUbcFlow.SubmitStrategy.ROUTE);
        }
        bE.r("type", Integer.valueOf(i));
    }

    public static void nn(String str) {
        b.a Se;
        com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
        if (arv != null && (Se = arv.Se()) != null) {
            i.bE("route", str).bH("appid", Se.getAppId()).bH("launchid", Se.ajz()).r("from", "swan").bH("web_widget_state", "0").anC();
        }
    }

    public static void no(String str) {
        i.bE("route", str).f(new UbcFlowEvent("web_widget_first_screen_finish")).bH("web_widget_state", "1").anE();
    }
}
