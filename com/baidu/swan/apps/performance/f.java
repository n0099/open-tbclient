package com.baidu.swan.apps.performance;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.webkit.internal.ETAG;
import java.util.Locale;
/* loaded from: classes7.dex */
public class f implements com.baidu.swan.apps.aq.e.b<HybridUbcFlow> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.aq.e.b
    /* renamed from: b */
    public void H(HybridUbcFlow hybridUbcFlow) {
        f(hybridUbcFlow);
    }

    @SuppressLint({"SwanDebugLog"})
    public void f(HybridUbcFlow hybridUbcFlow) {
        String str;
        long r;
        String optString;
        com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
        if (hybridUbcFlow != null && !hybridUbcFlow.cyq.isEmpty() && DEBUG && arv != null) {
            HybridUbcFlow.SubmitStrategy anN = hybridUbcFlow.anN();
            if (!hybridUbcFlow.cyo.contains("fe_route_start")) {
                str = "na_first_receive_action";
            } else {
                str = "fe_route_start";
            }
            if (anN == HybridUbcFlow.SubmitStrategy.ROUTE) {
                r = hybridUbcFlow.r("fe_first_render_start", str);
            } else {
                r = anN == HybridUbcFlow.SubmitStrategy.ROUTE_NA ? hybridUbcFlow.r("na_push_page_end", str) : hybridUbcFlow.r("web_widget_first_screen_finish", str);
            }
            if (r < 1) {
                r = 1;
            }
            String name = arv.getName();
            if (TextUtils.isEmpty(name)) {
                name = "";
            }
            Log.i("RouteReporter", "\n\n  小程序路由性能报告: " + name + " appID: " + (!TextUtils.isEmpty(arv.id) ? arv.id : "") + " launchId ：" + (arv.Se() != null ? arv.Se().ajz() : "") + " speedLog\n");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 100; i++) {
                sb.append(ETAG.ITEM_SEPARATOR);
            }
            Log.i("RouteReporter", String.format("Delta [%s]  Cost Src  Total Action", sb.toString()));
            long j = 0;
            long aob = hybridUbcFlow.cyq.get(0).aob();
            for (UbcFlowEvent ubcFlowEvent : hybridUbcFlow.cyq) {
                long r2 = hybridUbcFlow.r(ubcFlowEvent.id, str);
                boolean z = r2 < 0;
                boolean z2 = r2 > r;
                if (z) {
                    r2 = 0;
                }
                if (z2) {
                    r2 = r;
                }
                long j2 = r2 - j;
                if (j2 < 0) {
                    j2 = 0;
                }
                int round = Math.round((float) ((100 * r2) / r));
                if (round > 100) {
                    round = 100;
                }
                int round2 = Math.round((float) ((100 * j2) / r));
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
                sb2.append(z2 ? ">" : "]").append(String.format(Locale.getDefault(), " %5d", Long.valueOf(r2))).append(String.format("  %s", ubcFlowEvent.aoc())).append(String.format(Locale.getDefault(), " %6d ", Long.valueOf(ubcFlowEvent.aob() - aob))).append(ubcFlowEvent.id);
                if (ubcFlowEvent.aod()) {
                    sb2.append("(LocalRecord)");
                }
                Log.i("RouteReporter", sb2.toString());
                j = r2;
            }
            Log.i("RouteReporter", "Total  ： " + hybridUbcFlow.cyq.size());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("\n\n小程序路由总时长：========> " + r);
            sb3.append("\nsub_state :" + (TextUtils.equals(hybridUbcFlow.nc("sub_state"), "0") ? "无需下载分包" : "需要下载分包")).append("\npreload :" + (TextUtils.equals(hybridUbcFlow.nc("preload"), "0") ? "未完成" : "已完成")).append("\nhasWebViewWidget :" + (TextUtils.equals(hybridUbcFlow.nc("web_widget_state"), "0") ? "无webview组件" : "有webview组件")).append("\ntype ：" + (TextUtils.isEmpty(hybridUbcFlow.anB().optString("type")) ? "" : optString));
            Log.i("RouteReporter", "Report ： " + sb3.toString());
        }
    }
}
