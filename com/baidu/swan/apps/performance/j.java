package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import com.baidu.searchbox.perfframe.ioc.Constant;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes25.dex */
public class j {
    public static void rx(String str) {
        if (TextUtils.equals(i.cl("route", str).rp("sub_state"), "1")) {
            i.cl("route", str).f(new UbcFlowEvent("na_end_sub_package_download"));
        }
    }

    public static void a(b.a aVar, String str) {
        i.cl("route", str).f(new UbcFlowEvent("na_pre_load_slave_ok"));
        if (aVar != null) {
            if (aVar.cUE != null) {
                aVar.cUE.kX(str);
            }
            i.cl("route", str).f(new UbcFlowEvent("na_pre_load_slave_start").cx(aVar.cUG)).f(new UbcFlowEvent("na_pre_load_slave_end").cx(aVar.cUH));
        }
    }

    public static void ry(String str) {
        com.baidu.swan.apps.y.e.gg(true);
        com.baidu.swan.apps.inlinewidget.f.b.b.ayE();
        i.cp("route", str);
        i.cl("route", str).f(new UbcFlowEvent("na_first_receive_action")).co("sub_state", "0");
    }

    public static void al(int i, String str) {
        HybridUbcFlow cl = i.cl("route", str);
        if (i == 6 || i == 4 || i == 1) {
            cl.a(HybridUbcFlow.SubmitStrategy.ROUTE_NA);
        } else {
            cl.a(HybridUbcFlow.SubmitStrategy.ROUTE);
        }
        cl.q("type", Integer.valueOf(i));
    }

    public static void rz(String str) {
        b.a aio;
        com.baidu.swan.apps.runtime.e aJU = com.baidu.swan.apps.runtime.e.aJU();
        if (aJU != null && (aio = aJU.aio()) != null) {
            i.cl("route", str).co("appid", aio.getAppId()).co(Constant.KEY_LAUNCHID, aio.aBx()).q("from", "swan").co("web_widget_state", "0").aFL();
        }
    }

    public static void rA(String str) {
        i.cl("route", str).f(new UbcFlowEvent("web_widget_first_screen_finish")).co("web_widget_state", "1").aFN();
    }
}
