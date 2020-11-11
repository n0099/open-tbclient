package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes10.dex */
public class j {
    public static void qW(String str) {
        if (TextUtils.equals(i.cf("route", str).qO("sub_state"), "1")) {
            i.cf("route", str).f(new UbcFlowEvent("na_end_sub_package_download"));
        }
    }

    public static void a(b.a aVar, String str) {
        i.cf("route", str).f(new UbcFlowEvent("na_pre_load_slave_ok"));
        if (aVar != null) {
            if (aVar.cPv != null) {
                aVar.cPv.kw(str);
            }
            i.cf("route", str).f(new UbcFlowEvent("na_pre_load_slave_start").bY(aVar.cPx)).f(new UbcFlowEvent("na_pre_load_slave_end").bY(aVar.cPy));
        }
    }

    public static void qX(String str) {
        com.baidu.swan.apps.y.e.fO(true);
        com.baidu.swan.apps.inlinewidget.f.b.b.awe();
        i.cj("route", str);
        i.cf("route", str).f(new UbcFlowEvent("na_first_receive_action")).ci("sub_state", "0");
    }

    public static void al(int i, String str) {
        HybridUbcFlow cf = i.cf("route", str);
        if (i == 6 || i == 4 || i == 1) {
            cf.a(HybridUbcFlow.SubmitStrategy.ROUTE_NA);
        } else {
            cf.a(HybridUbcFlow.SubmitStrategy.ROUTE);
        }
        cf.r("type", Integer.valueOf(i));
    }

    public static void qY(String str) {
        b.a afO;
        com.baidu.swan.apps.runtime.e aHu = com.baidu.swan.apps.runtime.e.aHu();
        if (aHu != null && (afO = aHu.afO()) != null) {
            i.cf("route", str).ci("appid", afO.getAppId()).ci("launchid", afO.ayW()).r("from", "swan").ci("web_widget_state", "0").aDl();
        }
    }

    public static void qZ(String str) {
        i.cf("route", str).f(new UbcFlowEvent("web_widget_first_screen_finish")).ci("web_widget_state", "1").aDn();
    }
}
