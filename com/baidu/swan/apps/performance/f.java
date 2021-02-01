package com.baidu.swan.apps.performance;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.webkit.internal.ETAG;
import java.util.Locale;
/* loaded from: classes9.dex */
public class f implements com.baidu.swan.apps.ao.e.b<HybridUbcFlow> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ao.e.b
    /* renamed from: a */
    public void L(HybridUbcFlow hybridUbcFlow) {
        f(hybridUbcFlow);
    }

    @SuppressLint({"SwanDebugLog"})
    public void f(HybridUbcFlow hybridUbcFlow) {
        String str;
        long B;
        String optString;
        com.baidu.swan.apps.runtime.e aIK = com.baidu.swan.apps.runtime.e.aIK();
        if (hybridUbcFlow != null && !hybridUbcFlow.dqz.isEmpty() && DEBUG && aIK != null) {
            HybridUbcFlow.SubmitStrategy aDT = hybridUbcFlow.aDT();
            if (!hybridUbcFlow.dqx.contains("fe_route_start")) {
                str = "na_first_receive_action";
            } else {
                str = "fe_route_start";
            }
            if (aDT == HybridUbcFlow.SubmitStrategy.ROUTE) {
                B = hybridUbcFlow.B("fe_first_render_start", str);
            } else {
                B = aDT == HybridUbcFlow.SubmitStrategy.ROUTE_NA ? hybridUbcFlow.B("na_push_page_end", str) : hybridUbcFlow.B("web_widget_first_screen_finish", str);
            }
            if (B < 1) {
                B = 1;
            }
            String name = aIK.getName();
            if (TextUtils.isEmpty(name)) {
                name = "";
            }
            Log.i("RouteReporter", "\n\n  小程序路由性能报告: " + name + " appID: " + (!TextUtils.isEmpty(aIK.id) ? aIK.id : "") + " launchId ：" + (aIK.afZ() != null ? aIK.afZ().azt() : "") + " speedLog\n");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 100; i++) {
                sb.append(ETAG.ITEM_SEPARATOR);
            }
            Log.i("RouteReporter", String.format("Delta [%s]  Cost Src  Total Action", sb.toString()));
            long j = 0;
            long aEf = hybridUbcFlow.dqz.get(0).aEf();
            for (UbcFlowEvent ubcFlowEvent : hybridUbcFlow.dqz) {
                long B2 = hybridUbcFlow.B(ubcFlowEvent.id, str);
                boolean z = B2 < 0;
                boolean z2 = B2 > B;
                if (z) {
                    B2 = 0;
                }
                if (z2) {
                    B2 = B;
                }
                long j2 = B2 - j;
                if (j2 < 0) {
                    j2 = 0;
                }
                int round = Math.round((float) ((100 * B2) / B));
                if (round > 100) {
                    round = 100;
                }
                int round2 = Math.round((float) ((100 * j2) / B));
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
                        sb2.append("=");
                    } else {
                        sb2.append("#");
                    }
                }
                sb2.append(z2 ? ">" : "]").append(String.format(Locale.getDefault(), " %5d", Long.valueOf(B2))).append(String.format("  %s", ubcFlowEvent.aEg())).append(String.format(Locale.getDefault(), " %6d ", Long.valueOf(ubcFlowEvent.aEf() - aEf))).append(ubcFlowEvent.id);
                if (ubcFlowEvent.aEh()) {
                    sb2.append("(LocalRecord)");
                }
                Log.i("RouteReporter", sb2.toString());
                j = B2;
            }
            Log.i("RouteReporter", "Total  ： " + hybridUbcFlow.dqz.size());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("\n\n小程序路由总时长：========> " + B);
            sb3.append("\nsub_state :" + (TextUtils.equals(hybridUbcFlow.qp("sub_state"), "0") ? "无需下载分包" : "需要下载分包")).append("\npreload :" + (TextUtils.equals(hybridUbcFlow.qp("preload"), "0") ? "未完成" : "已完成")).append("\nhasWebViewWidget :" + (TextUtils.equals(hybridUbcFlow.qp("web_widget_state"), "0") ? "无webview组件" : "有webview组件")).append("\ntype ：" + (TextUtils.isEmpty(hybridUbcFlow.aDH().optString("type")) ? "" : optString));
            Log.i("RouteReporter", "Report ： " + sb3.toString());
        }
    }
}
