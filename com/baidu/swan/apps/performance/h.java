package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.v.b.b;
/* loaded from: classes11.dex */
public class h {
    public static void mB(String str) {
        if (TextUtils.equals(g.bA("route", str).mu("sub_state"), "1")) {
            g.bA("route", str).f(new UbcFlowEvent("na_end_sub_package_download"));
        }
    }

    public static void a(b.a aVar, String str) {
        g.bA("route", str).f(new UbcFlowEvent("na_pre_load_slave_ok"));
        if (aVar != null) {
            if (aVar.bZV != null) {
                aVar.bZV.gZ(str);
            }
            g.bA("route", str).f(new UbcFlowEvent("na_pre_load_slave_start").bg(aVar.bZX)).f(new UbcFlowEvent("na_pre_load_slave_end").bg(aVar.bZY));
        }
    }

    public static void mC(String str) {
        com.baidu.swan.apps.aa.e.es(true);
        g.bE("route", str);
        g.bA("route", str).f(new UbcFlowEvent("na_first_receive_action")).bD("sub_state", "0");
    }

    public static void S(int i, String str) {
        HybridUbcFlow bA = g.bA("route", str);
        if (i == 6 || i == 4 || i == 1) {
            bA.a(HybridUbcFlow.SubmitStrategy.ROUTE_NA);
        } else {
            bA.a(HybridUbcFlow.SubmitStrategy.ROUTE);
        }
        bA.r("type", Integer.valueOf(i));
    }

    public static void mD(String str) {
        b.a QJ;
        com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
        if (aoF != null && (QJ = aoF.QJ()) != null) {
            g.bA("route", str).bD("appid", QJ.getAppId()).bD("launchid", QJ.ahd()).r("from", "swan").bD("web_widget_state", "0").alc();
        }
    }

    public static void mE(String str) {
        g.bA("route", str).f(new UbcFlowEvent("web_widget_first_screen_finish")).bD("web_widget_state", "1").ale();
    }
}
