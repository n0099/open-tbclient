package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes10.dex */
public class j {
    public static void qI(String str) {
        if (TextUtils.equals(i.cf("route", str).qA("sub_state"), "1")) {
            i.cf("route", str).f(new UbcFlowEvent("na_end_sub_package_download"));
        }
    }

    public static void a(b.a aVar, String str) {
        i.cf("route", str).f(new UbcFlowEvent("na_pre_load_slave_ok"));
        if (aVar != null) {
            if (aVar.cJC != null) {
                aVar.cJC.kh(str);
            }
            i.cf("route", str).f(new UbcFlowEvent("na_pre_load_slave_start").bC(aVar.cJE)).f(new UbcFlowEvent("na_pre_load_slave_end").bC(aVar.cJF));
        }
    }

    public static void qJ(String str) {
        com.baidu.swan.apps.y.e.fF(true);
        com.baidu.swan.apps.inlinewidget.f.b.b.atE();
        i.cj("route", str);
        i.cf("route", str).f(new UbcFlowEvent("na_first_receive_action")).ci("sub_state", "0");
    }

    public static void ah(int i, String str) {
        HybridUbcFlow cf = i.cf("route", str);
        if (i == 6 || i == 4 || i == 1) {
            cf.a(HybridUbcFlow.SubmitStrategy.ROUTE_NA);
        } else {
            cf.a(HybridUbcFlow.SubmitStrategy.ROUTE);
        }
        cf.r("type", Integer.valueOf(i));
    }

    public static void qK(String str) {
        b.a ado;
        com.baidu.swan.apps.runtime.e aEU = com.baidu.swan.apps.runtime.e.aEU();
        if (aEU != null && (ado = aEU.ado()) != null) {
            i.cf("route", str).ci("appid", ado.getAppId()).ci("launchid", ado.aww()).r("from", "swan").ci("web_widget_state", "0").aAL();
        }
    }

    public static void qL(String str) {
        i.cf("route", str).f(new UbcFlowEvent("web_widget_first_screen_finish")).ci("web_widget_state", "1").aAN();
    }
}
