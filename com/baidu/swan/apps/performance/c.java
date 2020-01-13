package com.baidu.swan.apps.performance;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.webkit.internal.ETAG;
import java.util.Locale;
/* loaded from: classes10.dex */
public class c implements com.baidu.swan.apps.as.d.b<HybridUbcFlow> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.as.d.b
    /* renamed from: a */
    public void B(HybridUbcFlow hybridUbcFlow) {
        e(hybridUbcFlow);
    }

    @SuppressLint({"SwanDebugLog"})
    public void e(HybridUbcFlow hybridUbcFlow) {
        String str;
        long o;
        String optString;
        com.baidu.swan.apps.runtime.e aap = com.baidu.swan.apps.runtime.e.aap();
        if (hybridUbcFlow != null && !hybridUbcFlow.bDo.isEmpty() && DEBUG && aap != null) {
            HybridUbcFlow.SubmitStrategy Xy = hybridUbcFlow.Xy();
            if (!hybridUbcFlow.bDm.contains("fe_route_start")) {
                str = "na_first_receive_action";
            } else {
                str = "fe_route_start";
            }
            if (Xy == HybridUbcFlow.SubmitStrategy.ROUTE) {
                o = hybridUbcFlow.o("fe_first_render_start", str);
            } else {
                o = Xy == HybridUbcFlow.SubmitStrategy.ROUTE_NA ? hybridUbcFlow.o("na_push_page_end", str) : hybridUbcFlow.o("web_widget_first_screen_finish", str);
            }
            if (o < 1) {
                o = 1;
            }
            String name = aap.getName();
            if (TextUtils.isEmpty(name)) {
                name = "";
            }
            Log.i("RouteReporter", "\n\n  小程序路由性能报告: " + name + " appID: " + (!TextUtils.isEmpty(aap.id) ? aap.id : "") + " launchId ：" + (aap.En() != null ? aap.En().TM() : "") + " speedLog\n");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 100; i++) {
                sb.append(ETAG.ITEM_SEPARATOR);
            }
            Log.i("RouteReporter", String.format("Delta [%s]  Cost Src  Total Action", sb.toString()));
            long j = 0;
            long XG = hybridUbcFlow.bDo.get(0).XG();
            for (UbcFlowEvent ubcFlowEvent : hybridUbcFlow.bDo) {
                long o2 = hybridUbcFlow.o(ubcFlowEvent.id, str);
                boolean z = o2 < 0;
                boolean z2 = o2 > o;
                if (z) {
                    o2 = 0;
                }
                if (z2) {
                    o2 = o;
                }
                long j2 = o2 - j;
                if (j2 < 0) {
                    j2 = 0;
                }
                int round = Math.round((float) ((100 * o2) / o));
                if (round > 100) {
                    round = 100;
                }
                int round2 = Math.round((float) ((100 * j2) / o));
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
                sb2.append(z2 ? ">" : "]").append(String.format(Locale.getDefault(), " %5d", Long.valueOf(o2))).append(String.format("  %s", ubcFlowEvent.XH())).append(String.format(Locale.getDefault(), " %6d ", Long.valueOf(ubcFlowEvent.XG() - XG))).append(ubcFlowEvent.id);
                if (ubcFlowEvent.XI()) {
                    sb2.append("(LocalRecord)");
                }
                Log.i("RouteReporter", sb2.toString());
                j = o2;
            }
            Log.i("RouteReporter", "Total  ： " + hybridUbcFlow.bDo.size());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("\n\n小程序路由总时长：========> " + o);
            sb3.append("\nsub_state :" + (TextUtils.equals(hybridUbcFlow.jE("sub_state"), "0") ? "无需下载分包" : "需要下载分包")).append("\npreload :" + (TextUtils.equals(hybridUbcFlow.jE("preload"), "0") ? "未完成" : "已完成")).append("\nhasWebViewWidget :" + (TextUtils.equals(hybridUbcFlow.jE("web_widget_state"), "0") ? "无webview组件" : "有webview组件")).append("\ntype ：" + (TextUtils.isEmpty(hybridUbcFlow.Xj().optString("type")) ? "" : optString));
            Log.i("RouteReporter", "Report ： " + sb3.toString());
        }
    }
}
