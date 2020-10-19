package com.baidu.swan.apps.performance;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.webkit.internal.ETAG;
import java.util.Locale;
/* loaded from: classes10.dex */
public class f implements com.baidu.swan.apps.ap.e.b<HybridUbcFlow> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ap.e.b
    /* renamed from: a */
    public void M(HybridUbcFlow hybridUbcFlow) {
        f(hybridUbcFlow);
    }

    @SuppressLint({"SwanDebugLog"})
    public void f(HybridUbcFlow hybridUbcFlow) {
        String str;
        long t;
        String optString;
        com.baidu.swan.apps.runtime.e aDa = com.baidu.swan.apps.runtime.e.aDa();
        if (hybridUbcFlow != null && !hybridUbcFlow.cUr.isEmpty() && DEBUG && aDa != null) {
            HybridUbcFlow.SubmitStrategy azc = hybridUbcFlow.azc();
            if (!hybridUbcFlow.cUp.contains("fe_route_start")) {
                str = "na_first_receive_action";
            } else {
                str = "fe_route_start";
            }
            if (azc == HybridUbcFlow.SubmitStrategy.ROUTE) {
                t = hybridUbcFlow.t("fe_first_render_start", str);
            } else {
                t = azc == HybridUbcFlow.SubmitStrategy.ROUTE_NA ? hybridUbcFlow.t("na_push_page_end", str) : hybridUbcFlow.t("web_widget_first_screen_finish", str);
            }
            if (t < 1) {
                t = 1;
            }
            String name = aDa.getName();
            if (TextUtils.isEmpty(name)) {
                name = "";
            }
            Log.i("RouteReporter", "\n\n  小程序路由性能报告: " + name + " appID: " + (!TextUtils.isEmpty(aDa.id) ? aDa.id : "") + " launchId ：" + (aDa.abu() != null ? aDa.abu().auC() : "") + " speedLog\n");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 100; i++) {
                sb.append(ETAG.ITEM_SEPARATOR);
            }
            Log.i("RouteReporter", String.format("Delta [%s]  Cost Src  Total Action", sb.toString()));
            long j = 0;
            long azq = hybridUbcFlow.cUr.get(0).azq();
            for (UbcFlowEvent ubcFlowEvent : hybridUbcFlow.cUr) {
                long t2 = hybridUbcFlow.t(ubcFlowEvent.id, str);
                boolean z = t2 < 0;
                boolean z2 = t2 > t;
                if (z) {
                    t2 = 0;
                }
                if (z2) {
                    t2 = t;
                }
                long j2 = t2 - j;
                if (j2 < 0) {
                    j2 = 0;
                }
                int round = Math.round((float) ((100 * t2) / t));
                if (round > 100) {
                    round = 100;
                }
                int round2 = Math.round((float) ((100 * j2) / t));
                if (round2 > 100) {
                    round2 = 100;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(String.format(Locale.getDefault(), "%5d ", Long.valueOf(j2)));
                sb2.append(z ? "<" : "[");
                for (int i2 = 0; i2 < 100; i2++) {
                    if (i2 > round) {
                        sb2.append(".");
                    } else if (i2 > round2) {
                        sb2.append(ETAG.EQUAL);
                    } else {
                        sb2.append("#");
                    }
                }
                sb2.append(z2 ? ">" : "]").append(String.format(Locale.getDefault(), " %5d", Long.valueOf(t2))).append(String.format("  %s", ubcFlowEvent.azr())).append(String.format(Locale.getDefault(), " %6d ", Long.valueOf(ubcFlowEvent.azq() - azq))).append(ubcFlowEvent.id);
                if (ubcFlowEvent.azs()) {
                    sb2.append("(LocalRecord)");
                }
                Log.i("RouteReporter", sb2.toString());
                j = t2;
            }
            Log.i("RouteReporter", "Total  ： " + hybridUbcFlow.cUr.size());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("\n\n小程序路由总时长：========> " + t);
            sb3.append("\nsub_state :" + (TextUtils.equals(hybridUbcFlow.qh("sub_state"), "0") ? "无需下载分包" : "需要下载分包")).append("\npreload :" + (TextUtils.equals(hybridUbcFlow.qh("preload"), "0") ? "未完成" : "已完成")).append("\nhasWebViewWidget :" + (TextUtils.equals(hybridUbcFlow.qh("web_widget_state"), "0") ? "无webview组件" : "有webview组件")).append("\ntype ：" + (TextUtils.isEmpty(hybridUbcFlow.ayQ().optString("type")) ? "" : optString));
            Log.i("RouteReporter", "Report ： " + sb3.toString());
        }
    }
}
