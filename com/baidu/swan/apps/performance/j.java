package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes3.dex */
public class j {
    public static void pD(String str) {
        if (TextUtils.equals(i.bT("route", str).pv("sub_state"), "1")) {
            i.bT("route", str).f(new UbcFlowEvent("na_end_sub_package_download"));
        }
    }

    public static void a(b.a aVar, String str) {
        i.bT("route", str).f(new UbcFlowEvent("na_pre_load_slave_ok"));
        if (aVar != null) {
            if (aVar.coR != null) {
                aVar.coR.jc(str);
            }
            i.bT("route", str).f(new UbcFlowEvent("na_pre_load_slave_start").bs(aVar.coT)).f(new UbcFlowEvent("na_pre_load_slave_end").bs(aVar.coU));
        }
    }

    public static void pE(String str) {
        com.baidu.swan.apps.y.e.eW(true);
        com.baidu.swan.apps.inlinewidget.f.b.b.aoX();
        i.bX("route", str);
        i.bT("route", str).f(new UbcFlowEvent("na_first_receive_action")).bW("sub_state", "0");
    }

    public static void U(int i, String str) {
        HybridUbcFlow bT = i.bT("route", str);
        if (i == 6 || i == 4 || i == 1) {
            bT.a(HybridUbcFlow.SubmitStrategy.ROUTE_NA);
        } else {
            bT.a(HybridUbcFlow.SubmitStrategy.ROUTE);
        }
        bT.r("type", Integer.valueOf(i));
    }

    public static void pF(String str) {
        b.a YI;
        com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
        if (aAr != null && (YI = aAr.YI()) != null) {
            i.bT("route", str).bW("appid", YI.getAppId()).bW("launchid", YI.arQ()).r("from", "swan").bW("web_widget_state", "0").awg();
        }
    }

    public static void pG(String str) {
        i.bT("route", str).f(new UbcFlowEvent("web_widget_first_screen_finish")).bW("web_widget_state", "1").awi();
    }
}
