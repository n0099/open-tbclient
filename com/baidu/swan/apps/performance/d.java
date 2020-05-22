package com.baidu.swan.apps.performance;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.webkit.internal.ETAG;
import java.util.Locale;
/* loaded from: classes11.dex */
public class d implements com.baidu.swan.apps.aq.e.b<HybridUbcFlow> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.aq.e.b
    /* renamed from: a */
    public void H(HybridUbcFlow hybridUbcFlow) {
        e(hybridUbcFlow);
    }

    @SuppressLint({"SwanDebugLog"})
    public void e(HybridUbcFlow hybridUbcFlow) {
        String str;
        long s;
        String optString;
        com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
        if (hybridUbcFlow != null && !hybridUbcFlow.cro.isEmpty() && DEBUG && aoF != null) {
            HybridUbcFlow.SubmitStrategy aln = hybridUbcFlow.aln();
            if (!hybridUbcFlow.crm.contains("fe_route_start")) {
                str = "na_first_receive_action";
            } else {
                str = "fe_route_start";
            }
            if (aln == HybridUbcFlow.SubmitStrategy.ROUTE) {
                s = hybridUbcFlow.s("fe_first_render_start", str);
            } else {
                s = aln == HybridUbcFlow.SubmitStrategy.ROUTE_NA ? hybridUbcFlow.s("na_push_page_end", str) : hybridUbcFlow.s("web_widget_first_screen_finish", str);
            }
            if (s < 1) {
                s = 1;
            }
            String name = aoF.getName();
            if (TextUtils.isEmpty(name)) {
                name = "";
            }
            Log.i("RouteReporter", "\n\n  小程序路由性能报告: " + name + " appID: " + (!TextUtils.isEmpty(aoF.id) ? aoF.id : "") + " launchId ：" + (aoF.QJ() != null ? aoF.QJ().ahd() : "") + " speedLog\n");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 100; i++) {
                sb.append(ETAG.ITEM_SEPARATOR);
            }
            Log.i("RouteReporter", String.format("Delta [%s]  Cost Src  Total Action", sb.toString()));
            long j = 0;
            long alB = hybridUbcFlow.cro.get(0).alB();
            for (UbcFlowEvent ubcFlowEvent : hybridUbcFlow.cro) {
                long s2 = hybridUbcFlow.s(ubcFlowEvent.id, str);
                boolean z = s2 < 0;
                boolean z2 = s2 > s;
                if (z) {
                    s2 = 0;
                }
                if (z2) {
                    s2 = s;
                }
                long j2 = s2 - j;
                if (j2 < 0) {
                    j2 = 0;
                }
                int round = Math.round((float) ((100 * s2) / s));
                if (round > 100) {
                    round = 100;
                }
                int round2 = Math.round((float) ((100 * j2) / s));
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
                sb2.append(z2 ? ">" : "]").append(String.format(Locale.getDefault(), " %5d", Long.valueOf(s2))).append(String.format("  %s", ubcFlowEvent.alC())).append(String.format(Locale.getDefault(), " %6d ", Long.valueOf(ubcFlowEvent.alB() - alB))).append(ubcFlowEvent.id);
                if (ubcFlowEvent.alD()) {
                    sb2.append("(LocalRecord)");
                }
                Log.i("RouteReporter", sb2.toString());
                j = s2;
            }
            Log.i("RouteReporter", "Total  ： " + hybridUbcFlow.cro.size());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("\n\n小程序路由总时长：========> " + s);
            sb3.append("\nsub_state :" + (TextUtils.equals(hybridUbcFlow.mu("sub_state"), "0") ? "无需下载分包" : "需要下载分包")).append("\npreload :" + (TextUtils.equals(hybridUbcFlow.mu("preload"), "0") ? "未完成" : "已完成")).append("\nhasWebViewWidget :" + (TextUtils.equals(hybridUbcFlow.mu("web_widget_state"), "0") ? "无webview组件" : "有webview组件")).append("\ntype ：" + (TextUtils.isEmpty(hybridUbcFlow.alb().optString("type")) ? "" : optString));
            Log.i("RouteReporter", "Report ： " + sb3.toString());
        }
    }
}
