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
        long r;
        String optString;
        com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
        if (hybridUbcFlow != null && !hybridUbcFlow.cwc.isEmpty() && DEBUG && apM != null) {
            HybridUbcFlow.SubmitStrategy amt = hybridUbcFlow.amt();
            if (!hybridUbcFlow.cwa.contains("fe_route_start")) {
                str = "na_first_receive_action";
            } else {
                str = "fe_route_start";
            }
            if (amt == HybridUbcFlow.SubmitStrategy.ROUTE) {
                r = hybridUbcFlow.r("fe_first_render_start", str);
            } else {
                r = amt == HybridUbcFlow.SubmitStrategy.ROUTE_NA ? hybridUbcFlow.r("na_push_page_end", str) : hybridUbcFlow.r("web_widget_first_screen_finish", str);
            }
            if (r < 1) {
                r = 1;
            }
            String name = apM.getName();
            if (TextUtils.isEmpty(name)) {
                name = "";
            }
            Log.i("RouteReporter", "\n\n  小程序路由性能报告: " + name + " appID: " + (!TextUtils.isEmpty(apM.id) ? apM.id : "") + " launchId ：" + (apM.RP() != null ? apM.RP().aij() : "") + " speedLog\n");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 100; i++) {
                sb.append(ETAG.ITEM_SEPARATOR);
            }
            Log.i("RouteReporter", String.format("Delta [%s]  Cost Src  Total Action", sb.toString()));
            long j = 0;
            long amH = hybridUbcFlow.cwc.get(0).amH();
            for (UbcFlowEvent ubcFlowEvent : hybridUbcFlow.cwc) {
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
                sb2.append(z2 ? ">" : "]").append(String.format(Locale.getDefault(), " %5d", Long.valueOf(r2))).append(String.format("  %s", ubcFlowEvent.amI())).append(String.format(Locale.getDefault(), " %6d ", Long.valueOf(ubcFlowEvent.amH() - amH))).append(ubcFlowEvent.id);
                if (ubcFlowEvent.amJ()) {
                    sb2.append("(LocalRecord)");
                }
                Log.i("RouteReporter", sb2.toString());
                j = r2;
            }
            Log.i("RouteReporter", "Total  ： " + hybridUbcFlow.cwc.size());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("\n\n小程序路由总时长：========> " + r);
            sb3.append("\nsub_state :" + (TextUtils.equals(hybridUbcFlow.mC("sub_state"), "0") ? "无需下载分包" : "需要下载分包")).append("\npreload :" + (TextUtils.equals(hybridUbcFlow.mC("preload"), "0") ? "未完成" : "已完成")).append("\nhasWebViewWidget :" + (TextUtils.equals(hybridUbcFlow.mC("web_widget_state"), "0") ? "无webview组件" : "有webview组件")).append("\ntype ：" + (TextUtils.isEmpty(hybridUbcFlow.amh().optString("type")) ? "" : optString));
            Log.i("RouteReporter", "Report ： " + sb3.toString());
        }
    }
}
