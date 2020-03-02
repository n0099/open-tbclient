package com.baidu.swan.apps.performance;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.webkit.internal.ETAG;
import java.util.Locale;
/* loaded from: classes11.dex */
public class d implements com.baidu.swan.apps.as.d.b<HybridUbcFlow> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.as.d.b
    /* renamed from: a */
    public void D(HybridUbcFlow hybridUbcFlow) {
        e(hybridUbcFlow);
    }

    @SuppressLint({"SwanDebugLog"})
    public void e(HybridUbcFlow hybridUbcFlow) {
        com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
        if (hybridUbcFlow != null && !hybridUbcFlow.bHv.isEmpty()) {
            long s = hybridUbcFlow.s("slave_first_rendered", "master_dispatch_start");
            com.baidu.swan.apps.ap.e.bXP.O(Long.valueOf(s));
            com.baidu.swan.apps.ap.e.bXK.O(Long.valueOf(hybridUbcFlow.s("slave_first_rendered", "naStart")));
            com.baidu.swan.apps.ap.e.bXL.O(Long.valueOf(hybridUbcFlow.s("aps_end_download", "aps_start_download", "aps_end_req", "aps_start_req", "naStart")));
            if (DEBUG && acF != null) {
                long s2 = hybridUbcFlow.s("na_first_meaningful_paint", "naStart");
                if (s2 < 1) {
                    s2 = hybridUbcFlow.s("na_first_paint", "naStart");
                }
                long j = s2 < 1 ? 1L : s2;
                String name = acF.getName();
                if (TextUtils.isEmpty(name)) {
                    name = "";
                }
                Log.i("StartupReporter", "\n\n  小程序启动性能报告: " + name + " appID: " + (!TextUtils.isEmpty(acF.id) ? acF.id : "") + " speedLog\n");
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 100; i++) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                Log.i("StartupReporter", String.format(" Cost [%s] Delta Src  Total Action", sb.toString()));
                long j2 = 0;
                long ZW = hybridUbcFlow.bHv.get(0).ZW();
                for (UbcFlowEvent ubcFlowEvent : hybridUbcFlow.bHv) {
                    long s3 = hybridUbcFlow.s(ubcFlowEvent.id, "naStart");
                    boolean z = s3 < 0;
                    boolean z2 = s3 > j;
                    if (z) {
                        s3 = 0;
                    }
                    if (z2) {
                        s3 = j;
                    }
                    long j3 = s3 - j2;
                    if (j3 < 0) {
                        j3 = 0;
                    }
                    int round = Math.round((float) ((100 * s3) / j));
                    if (round > 100) {
                        round = 100;
                    }
                    int round2 = Math.round((float) ((100 * j3) / j));
                    if (round2 > 100) {
                        round2 = 100;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(String.format(Locale.getDefault(), " %5d ", Long.valueOf(s3)));
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
                    sb2.append(z2 ? ">" : "]").append(String.format(Locale.getDefault(), "%5d", Long.valueOf(j3))).append(String.format("  %s", ubcFlowEvent.ZX())).append(String.format(Locale.getDefault(), " %6d ", Long.valueOf(ubcFlowEvent.ZW() - ZW))).append(ubcFlowEvent.id);
                    if (ubcFlowEvent.ZY()) {
                        sb2.append("(LocalRecord)");
                    }
                    Log.i("StartupReporter", sb2.toString());
                    j2 = s3;
                }
                Log.i("StartupReporter", "Total  ： " + hybridUbcFlow.bHv.size());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("\n========APS下载完成:" + hybridUbcFlow.s("aps_end_download", "naStart"));
                sb3.append("\n========解压包时长:" + hybridUbcFlow.s("package_end_unzip", "first_anim_start", "aps_end_download"));
                sb3.append("\n========第一次setData的调用:" + hybridUbcFlow.s("slave_first_loaded", "slave_js_parsed"));
                sb3.append("\n========master第一次和slave通信:" + hybridUbcFlow.s("slave_first_loaded", "master_first_init_data"));
                sb3.append("\n========slave第一次收到数据:" + hybridUbcFlow.s("slave_first_recieve_data", "master_first_init_data"));
                sb3.append("\n========slave第一次渲染完成:" + hybridUbcFlow.s("slave_first_rendered", "slave_first_recieve_data"));
                sb3.append("\n========第一次动画时长:" + hybridUbcFlow.s("first_anim_end", "first_anim_start"));
                sb3.append("\n========第二次动画时长:" + hybridUbcFlow.s("second_anim_end", "second_anim_start"));
                sb3.append("\n\n核心指标--------");
                sb3.append("\n========aps接口时长:" + hybridUbcFlow.s("aps_end_req", "aps_start_req", "naStart"));
                sb3.append("\n========aps纯下载时长:" + hybridUbcFlow.s("aps_end_download", "aps_start_download", "aps_end_req", "aps_start_req", "naStart"));
                sb3.append("\n========");
                sb3.append("\n========准备启动时长:" + hybridUbcFlow.s("na_launch_activity", "naStart"));
                sb3.append("\n========准备查库时长:" + hybridUbcFlow.s("na_query_db", "naStart"));
                sb3.append("\n========Activity调起时长:" + hybridUbcFlow.s("frame_start_create", "na_launch_activity"));
                sb3.append("\n========");
                sb3.append("\n========预加载等待时长:" + hybridUbcFlow.s("na_pre_load_ok", "na_pre_load_check"));
                sb3.append("\n========主线程阻塞时长:" + hybridUbcFlow.s("na_post_to_main_end", "na_post_to_main_start"));
                sb3.append("\n========本地小程序包加载及渲染总时长:" + hybridUbcFlow.s("slave_first_rendered", "first_anim_start"));
                sb3.append("\n\n启动线性跟踪分段指标简报--------");
                sb3.append("\n========取包（网络开销，从小程序入口，到APS及前置接口等网络交互完成）:" + hybridUbcFlow.s("first_anim_start", "naStart"));
                sb3.append("\n========安装（IO开销，从下载完成，到小程序包解压安装作业完成）:" + hybridUbcFlow.s("package_end_unzip", "first_anim_start"));
                sb3.append("\n========下载-安装（IO开销，从下载开始，到小程序包解压安装作业完成）:" + hybridUbcFlow.s("package_end_unzip", "aps_start_download"));
                sb3.append("\n========小程序框架启动总时长（NA开销，从开始，到 NA 准备完成）:" + hybridUbcFlow.s("master_dispatch_start", "naStart"));
                sb3.append("\n========小程序业务渲染总时长（H5开销，从 NA 准备完成，到页面渲染）:" + s);
                int optInt = hybridUbcFlow.Zz().optInt("type", -1);
                String jT = hybridUbcFlow.jT("preload_scene");
                String jT2 = hybridUbcFlow.jT("app_package_version");
                if (TextUtils.isEmpty(jT)) {
                    jT = "-1";
                }
                String jT3 = hybridUbcFlow.jT("package_type");
                if (TextUtils.isEmpty(jT3)) {
                    jT3 = "-1";
                }
                sb3.append("\n\n小程序启动总时长：========> " + j);
                sb3.append(!hybridUbcFlow.bHt.contains("package_start_unzip") ? "(热启动)" : "(冷启动)").append("  relaunchType:" + optInt).append("  preloadType:" + jT).append(" packageType:" + jT3);
                if (!TextUtils.isEmpty(jT2)) {
                    sb3.append(" packageVersion:" + jT2);
                }
                Log.i("StartupReporter", "Report ： " + sb3.toString());
            }
        }
    }
}
