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
        long u;
        String optString;
        com.baidu.swan.apps.runtime.e aEU = com.baidu.swan.apps.runtime.e.aEU();
        if (hybridUbcFlow != null && !hybridUbcFlow.dcQ.isEmpty() && DEBUG && aEU != null) {
            HybridUbcFlow.SubmitStrategy aAW = hybridUbcFlow.aAW();
            if (!hybridUbcFlow.dcO.contains("fe_route_start")) {
                str = "na_first_receive_action";
            } else {
                str = "fe_route_start";
            }
            if (aAW == HybridUbcFlow.SubmitStrategy.ROUTE) {
                u = hybridUbcFlow.u("fe_first_render_start", str);
            } else {
                u = aAW == HybridUbcFlow.SubmitStrategy.ROUTE_NA ? hybridUbcFlow.u("na_push_page_end", str) : hybridUbcFlow.u("web_widget_first_screen_finish", str);
            }
            if (u < 1) {
                u = 1;
            }
            String name = aEU.getName();
            if (TextUtils.isEmpty(name)) {
                name = "";
            }
            Log.i("RouteReporter", "\n\n  小程序路由性能报告: " + name + " appID: " + (!TextUtils.isEmpty(aEU.id) ? aEU.id : "") + " launchId ：" + (aEU.ado() != null ? aEU.ado().aww() : "") + " speedLog\n");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 100; i++) {
                sb.append(ETAG.ITEM_SEPARATOR);
            }
            Log.i("RouteReporter", String.format("Delta [%s]  Cost Src  Total Action", sb.toString()));
            long j = 0;
            long aBk = hybridUbcFlow.dcQ.get(0).aBk();
            for (UbcFlowEvent ubcFlowEvent : hybridUbcFlow.dcQ) {
                long u2 = hybridUbcFlow.u(ubcFlowEvent.id, str);
                boolean z = u2 < 0;
                boolean z2 = u2 > u;
                if (z) {
                    u2 = 0;
                }
                if (z2) {
                    u2 = u;
                }
                long j2 = u2 - j;
                if (j2 < 0) {
                    j2 = 0;
                }
                int round = Math.round((float) ((100 * u2) / u));
                if (round > 100) {
                    round = 100;
                }
                int round2 = Math.round((float) ((100 * j2) / u));
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
                sb2.append(z2 ? ">" : "]").append(String.format(Locale.getDefault(), " %5d", Long.valueOf(u2))).append(String.format("  %s", ubcFlowEvent.aBl())).append(String.format(Locale.getDefault(), " %6d ", Long.valueOf(ubcFlowEvent.aBk() - aBk))).append(ubcFlowEvent.id);
                if (ubcFlowEvent.aBm()) {
                    sb2.append("(LocalRecord)");
                }
                Log.i("RouteReporter", sb2.toString());
                j = u2;
            }
            Log.i("RouteReporter", "Total  ： " + hybridUbcFlow.dcQ.size());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("\n\n小程序路由总时长：========> " + u);
            sb3.append("\nsub_state :" + (TextUtils.equals(hybridUbcFlow.qA("sub_state"), "0") ? "无需下载分包" : "需要下载分包")).append("\npreload :" + (TextUtils.equals(hybridUbcFlow.qA("preload"), "0") ? "未完成" : "已完成")).append("\nhasWebViewWidget :" + (TextUtils.equals(hybridUbcFlow.qA("web_widget_state"), "0") ? "无webview组件" : "有webview组件")).append("\ntype ：" + (TextUtils.isEmpty(hybridUbcFlow.aAK().optString("type")) ? "" : optString));
            Log.i("RouteReporter", "Report ： " + sb3.toString());
        }
    }
}
