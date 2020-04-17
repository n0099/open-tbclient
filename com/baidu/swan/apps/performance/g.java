package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.x.b.b;
/* loaded from: classes11.dex */
public class g {
    public static void lm(String str) {
        if (TextUtils.equals(f.bh("route", str).lf("sub_state"), "1")) {
            f.bh("route", str).f(new UbcFlowEvent("na_end_sub_package_download"));
        }
    }

    public static void a(b.a aVar, String str) {
        f.bh("route", str).f(new UbcFlowEvent("na_pre_load_slave_ok"));
        if (aVar != null) {
            if (aVar.bQe != null) {
                aVar.bQe.gm(str);
            }
            f.bh("route", str).f(new UbcFlowEvent("na_pre_load_slave_start").aZ(aVar.bQg)).f(new UbcFlowEvent("na_pre_load_slave_end").aZ(aVar.bQh));
        }
    }

    public static void ln(String str) {
        com.baidu.swan.apps.ac.e.eb(true);
        f.bl("route", str);
        f.bh("route", str).f(new UbcFlowEvent("na_first_receive_action")).bk("sub_state", "0");
    }

    public static void R(int i, String str) {
        HybridUbcFlow bh = f.bh("route", str);
        if (i == 6 || i == 4 || i == 1) {
            bh.a(HybridUbcFlow.SubmitStrategy.ROUTE_NA);
        } else {
            bh.a(HybridUbcFlow.SubmitStrategy.ROUTE);
        }
        bh.p("type", Integer.valueOf(i));
    }

    public static void lo(String str) {
        b.a Ow;
        com.baidu.swan.apps.runtime.e akN = com.baidu.swan.apps.runtime.e.akN();
        if (akN != null && (Ow = akN.Ow()) != null) {
            f.bh("route", str).bk("appid", Ow.getAppId()).bk("launchid", Ow.adU()).p("from", "swan").bk("web_widget_state", "0").ahI();
        }
    }

    public static void lp(String str) {
        f.bh("route", str).f(new UbcFlowEvent("web_widget_first_screen_finish")).bk("web_widget_state", "1").ahL();
    }
}
