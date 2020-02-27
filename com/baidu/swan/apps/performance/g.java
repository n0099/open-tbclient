package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.x.b.b;
/* loaded from: classes11.dex */
public class g {
    public static void ka(String str) {
        if (TextUtils.equals(f.aY("route", str).jT("sub_state"), "1")) {
            f.aY("route", str).f(new UbcFlowEvent("na_end_sub_package_download"));
        }
    }

    public static void a(b.a aVar, String str) {
        f.aY("route", str).f(new UbcFlowEvent("na_pre_load_slave_ok"));
        if (aVar != null) {
            if (aVar.brJ != null) {
                aVar.brJ.fb(str);
            }
            f.aY("route", str).f(new UbcFlowEvent("na_pre_load_slave_start").au(aVar.brM)).f(new UbcFlowEvent("na_pre_load_slave_end").au(aVar.brN));
        }
    }

    public static void kb(String str) {
        com.baidu.swan.apps.ac.e.de(true);
        f.bc("route", str);
        f.aY("route", str).f(new UbcFlowEvent("na_first_receive_action")).bb("sub_state", "0");
    }

    public static void A(int i, String str) {
        HybridUbcFlow aY = f.aY("route", str);
        if (i == 6 || i == 4 || i == 1) {
            aY.a(HybridUbcFlow.SubmitStrategy.ROUTE_NA);
        } else {
            aY.a(HybridUbcFlow.SubmitStrategy.ROUTE);
        }
        aY.k("type", Integer.valueOf(i));
    }

    public static void kc(String str) {
        b.a GC;
        com.baidu.swan.apps.runtime.e acD = com.baidu.swan.apps.runtime.e.acD();
        if (acD != null && (GC = acD.GC()) != null) {
            f.aY("route", str).bb("appid", GC.getAppId()).bb("launchid", GC.Wa()).k("from", "swan").bb("web_widget_state", "0").Zy();
        }
    }

    public static void kd(String str) {
        f.aY("route", str).f(new UbcFlowEvent("web_widget_first_screen_finish")).bb("web_widget_state", "1").ZB();
    }
}
