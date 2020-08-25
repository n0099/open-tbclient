package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes8.dex */
public class j {
    public static void pj(String str) {
        if (TextUtils.equals(i.bT("route", str).pb("sub_state"), "1")) {
            i.bT("route", str).f(new UbcFlowEvent("na_end_sub_package_download"));
        }
    }

    public static void a(b.a aVar, String str) {
        i.bT("route", str).f(new UbcFlowEvent("na_pre_load_slave_ok"));
        if (aVar != null) {
            if (aVar.cmK != null) {
                aVar.cmK.iI(str);
            }
            i.bT("route", str).f(new UbcFlowEvent("na_pre_load_slave_start").br(aVar.cmM)).f(new UbcFlowEvent("na_pre_load_slave_end").br(aVar.cmN));
        }
    }

    public static void pk(String str) {
        com.baidu.swan.apps.y.e.eX(true);
        com.baidu.swan.apps.inlinewidget.f.b.b.aon();
        i.bX("route", str);
        i.bT("route", str).f(new UbcFlowEvent("na_first_receive_action")).bW("sub_state", "0");
    }

    public static void T(int i, String str) {
        HybridUbcFlow bT = i.bT("route", str);
        if (i == 6 || i == 4 || i == 1) {
            bT.a(HybridUbcFlow.SubmitStrategy.ROUTE_NA);
        } else {
            bT.a(HybridUbcFlow.SubmitStrategy.ROUTE);
        }
        bT.r("type", Integer.valueOf(i));
    }

    public static void pl(String str) {
        b.a XZ;
        com.baidu.swan.apps.runtime.e azI = com.baidu.swan.apps.runtime.e.azI();
        if (azI != null && (XZ = azI.XZ()) != null) {
            i.bT("route", str).bW("appid", XZ.getAppId()).bW("launchid", XZ.arg()).r("from", "swan").bW("web_widget_state", "0").avx();
        }
    }

    public static void pm(String str) {
        i.bT("route", str).f(new UbcFlowEvent("web_widget_first_screen_finish")).bW("web_widget_state", "1").avz();
    }
}
