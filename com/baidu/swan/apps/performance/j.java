package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import com.baidu.searchbox.perfframe.ioc.Constant;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.games.view.webview.GameWebViewJavascriptInterface;
/* loaded from: classes8.dex */
public class j {
    public static void qf(String str) {
        if (TextUtils.equals(i.cj("route", str).pX("sub_state"), "1")) {
            i.cj("route", str).f(new UbcFlowEvent("na_end_sub_package_download"));
        }
    }

    public static void a(b.a aVar, String str) {
        i.cj("route", str).f(new UbcFlowEvent("na_pre_load_slave_ok"));
        if (aVar != null) {
            if (aVar.cUO != null) {
                aVar.cUO.jF(str);
            }
            i.cj("route", str).f(new UbcFlowEvent("na_pre_load_slave_start").cy(aVar.cUQ)).f(new UbcFlowEvent("na_pre_load_slave_end").cy(aVar.cUR));
        }
    }

    public static void qg(String str) {
        com.baidu.swan.apps.y.e.gl(true);
        com.baidu.swan.apps.inlinewidget.f.b.b.awc();
        i.cn("route", str);
        i.cj("route", str).f(new UbcFlowEvent("na_first_receive_action")).cm("sub_state", "0");
    }

    public static void ao(int i, String str) {
        HybridUbcFlow cj = i.cj("route", str);
        if (i == 6 || i == 4 || i == 1) {
            cj.a(HybridUbcFlow.SubmitStrategy.ROUTE_NA);
        } else {
            cj.a(HybridUbcFlow.SubmitStrategy.ROUTE);
        }
        cj.q("type", Integer.valueOf(i));
    }

    public static void qh(String str) {
        b.a afB;
        com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
        if (aIr != null && (afB = aIr.afB()) != null) {
            i.cj("route", str).cm("appid", afB.getAppId()).cm(Constant.KEY_LAUNCHID, afB.ayV()).q("from", GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME).cm("web_widget_state", "0").aDm();
        }
    }

    public static void qi(String str) {
        i.cj("route", str).f(new UbcFlowEvent("web_widget_first_screen_finish")).cm("web_widget_state", "1").aDo();
    }
}
