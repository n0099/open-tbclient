package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes7.dex */
public class j {
    public static void qQ(String str) {
        if (TextUtils.equals(i.ce("route", str).qI("sub_state"), "1")) {
            i.ce("route", str).f(new UbcFlowEvent("na_end_sub_package_download"));
        }
    }

    public static void a(b.a aVar, String str) {
        i.ce("route", str).f(new UbcFlowEvent("na_pre_load_slave_ok"));
        if (aVar != null) {
            if (aVar.cNL != null) {
                aVar.cNL.kq(str);
            }
            i.ce("route", str).f(new UbcFlowEvent("na_pre_load_slave_start").bY(aVar.cNN)).f(new UbcFlowEvent("na_pre_load_slave_end").bY(aVar.cNO));
        }
    }

    public static void qR(String str) {
        com.baidu.swan.apps.y.e.fR(true);
        com.baidu.swan.apps.inlinewidget.f.b.b.avw();
        i.ci("route", str);
        i.ce("route", str).f(new UbcFlowEvent("na_first_receive_action")).ch("sub_state", "0");
    }

    public static void al(int i, String str) {
        HybridUbcFlow ce = i.ce("route", str);
        if (i == 6 || i == 4 || i == 1) {
            ce.a(HybridUbcFlow.SubmitStrategy.ROUTE_NA);
        } else {
            ce.a(HybridUbcFlow.SubmitStrategy.ROUTE);
        }
        ce.r("type", Integer.valueOf(i));
    }

    public static void qS(String str) {
        b.a afg;
        com.baidu.swan.apps.runtime.e aGM = com.baidu.swan.apps.runtime.e.aGM();
        if (aGM != null && (afg = aGM.afg()) != null) {
            i.ce("route", str).ch("appid", afg.getAppId()).ch("launchid", afg.ayo()).r("from", "swan").ch("web_widget_state", "0").aCD();
        }
    }

    public static void qT(String str) {
        i.ce("route", str).f(new UbcFlowEvent("web_widget_first_screen_finish")).ch("web_widget_state", "1").aCF();
    }
}
