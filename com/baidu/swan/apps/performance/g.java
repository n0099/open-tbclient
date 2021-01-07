package com.baidu.swan.apps.performance;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.webkit.internal.ETAG;
import java.util.Locale;
/* loaded from: classes9.dex */
public class g implements com.baidu.swan.apps.ao.e.b<HybridUbcFlow> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ao.e.b
    /* renamed from: a */
    public void L(HybridUbcFlow hybridUbcFlow) {
        f(hybridUbcFlow);
    }

    @SuppressLint({"SwanDebugLog"})
    public void f(HybridUbcFlow hybridUbcFlow) {
        com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
        if (hybridUbcFlow != null && !hybridUbcFlow.dtd.isEmpty()) {
            long B = hybridUbcFlow.B("slave_first_rendered", "master_dispatch_start");
            com.baidu.swan.apps.al.e.dQL.ab(Long.valueOf(B));
            com.baidu.swan.apps.al.e.dQG.ab(Long.valueOf(hybridUbcFlow.B("slave_first_rendered", "naStart")));
            com.baidu.swan.apps.al.e.dQH.ab(Long.valueOf(hybridUbcFlow.B("aps_end_download", "aps_start_download", "aps_end_req", "aps_start_req", "naStart")));
            if ((DEBUG || com.baidu.swan.apps.ad.a.a.getBoolean("aiapps_startup_reporter", false)) && aMl != null) {
                long B2 = hybridUbcFlow.B("na_first_meaningful_paint", "naStart");
                if (B2 < 1) {
                    B2 = hybridUbcFlow.B("na_first_paint", "naStart");
                }
                long j = B2 < 1 ? 1L : B2;
                int i = com.baidu.swan.apps.ad.a.a.aIt().getInt("aiapps_startup_reporter_resolution", 100);
                String name = aMl.getName();
                if (TextUtils.isEmpty(name)) {
                    name = "";
                }
                Log.i("StartupReporter", "\n\n  小程序启动性能报告: " + name + " appID: " + (!TextUtils.isEmpty(aMl.id) ? aMl.id : "") + " speedLog\n");
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < i; i2++) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                Log.i("StartupReporter", String.format(" Cost [%s] Delta Src  Total Action", sb.toString()));
                long j2 = 0;
                long aHE = hybridUbcFlow.dtd.get(0).aHE();
                for (UbcFlowEvent ubcFlowEvent : hybridUbcFlow.dtd) {
                    if (!ubcFlowEvent.aHG() || com.baidu.swan.apps.ad.a.a.getBoolean("aiapps_startup_reporter_local_report", true)) {
                        long B3 = hybridUbcFlow.B(ubcFlowEvent.id, "naStart");
                        boolean z = B3 < 0;
                        boolean z2 = B3 > j;
                        if (z) {
                            B3 = 0;
                        }
                        if (z2) {
                            B3 = j;
                        }
                        long j3 = B3 - j2;
                        if (j3 < 0) {
                            j3 = 0;
                        }
                        int round = Math.round((float) ((i * B3) / j));
                        if (round > i) {
                            round = i;
                        }
                        int round2 = Math.round((float) ((i * j3) / j));
                        if (round2 > i) {
                            round2 = i;
                        }
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(String.format(Locale.getDefault(), " %5d ", Long.valueOf(B3)));
                        sb2.append(z ? "<" : "[");
                        for (int i3 = 0; i3 < i; i3++) {
                            if (i3 > round) {
                                sb2.append(".");
                            } else if (i3 > round2) {
                                sb2.append("=");
                            } else {
                                sb2.append("#");
                            }
                        }
                        sb2.append(z2 ? ">" : "]").append(String.format(Locale.getDefault(), "%5d", Long.valueOf(j3))).append(String.format("  %s", ubcFlowEvent.aHF())).append(String.format(Locale.getDefault(), " %6d ", Long.valueOf(ubcFlowEvent.aHE() - aHE))).append(ubcFlowEvent.id);
                        if (ubcFlowEvent.aHG()) {
                            sb2.append("(LocalRecord)");
                        }
                        Log.i("StartupReporter", sb2.toString());
                        j2 = B3;
                    }
                }
                Log.i("StartupReporter", "Total  ： " + hybridUbcFlow.dtd.size());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("\n========APS下载完成:" + hybridUbcFlow.B("aps_end_download", "naStart"));
                sb3.append("\n========解压包时长:" + hybridUbcFlow.B("package_end_unzip", "first_anim_start", "aps_end_download"));
                sb3.append("\n========第一次setData的调用:" + hybridUbcFlow.B("slave_first_loaded", "slave_js_parsed"));
                sb3.append("\n========master第一次和slave通信:" + hybridUbcFlow.B("slave_first_loaded", "master_first_init_data"));
                sb3.append("\n========slave第一次收到数据:" + hybridUbcFlow.B("slave_first_recieve_data", "master_first_init_data"));
                sb3.append("\n========slave第一次渲染完成:" + hybridUbcFlow.B("slave_first_rendered", "slave_first_recieve_data"));
                sb3.append("\n========第一次动画时长:" + hybridUbcFlow.B("first_anim_end", "first_anim_start"));
                sb3.append("\n========第二次动画时长:" + hybridUbcFlow.B("second_anim_end", "second_anim_start"));
                sb3.append("\n\n核心指标--------");
                sb3.append("\n========aps接口时长:" + hybridUbcFlow.B("aps_end_req", "aps_start_req", "naStart"));
                sb3.append("\n========aps纯下载时长:" + hybridUbcFlow.B("aps_end_download", "aps_start_download", "aps_end_req", "aps_start_req", "naStart"));
                sb3.append("\n========");
                sb3.append("\n========准备启动时长:" + hybridUbcFlow.B("na_launch_activity", "naStart"));
                sb3.append("\n========准备查库时长:" + hybridUbcFlow.B("na_query_db", "naStart"));
                sb3.append("\n========Activity调起时长:" + hybridUbcFlow.B("frame_start_create", "na_launch_activity"));
                sb3.append("\n========");
                sb3.append("\n========预加载等待时长:" + hybridUbcFlow.B("na_pre_load_ok", "na_pre_load_check"));
                sb3.append("\n========主线程阻塞时长:" + hybridUbcFlow.B("na_post_to_main_end", "na_post_to_main_start"));
                sb3.append("\n========本地小程序包加载及渲染总时长:" + hybridUbcFlow.B("slave_first_rendered", "first_anim_start"));
                sb3.append("\n\n启动线性跟踪分段指标简报--------");
                sb3.append("\n========取包（网络开销，从小程序入口，到APS及前置接口等网络交互完成）:" + hybridUbcFlow.B("first_anim_start", "naStart"));
                sb3.append("\n========安装（IO开销，从下载完成，到小程序包解压安装作业完成）:" + hybridUbcFlow.B("package_end_unzip", "first_anim_start"));
                sb3.append("\n========下载-安装（IO开销，从下载开始，到小程序包解压安装作业完成）:" + hybridUbcFlow.B("package_end_unzip", "aps_start_download"));
                sb3.append("\n========小程序框架启动总时长（NA开销，从开始，到 NA 准备完成）:" + hybridUbcFlow.B("master_dispatch_start", "naStart"));
                sb3.append("\n========小程序业务渲染总时长（H5开销，从 NA 准备完成，到页面渲染）:" + B);
                int optInt = hybridUbcFlow.aHf().optInt("type", -1);
                String ri = hybridUbcFlow.ri("preload_scene");
                String ri2 = hybridUbcFlow.ri("app_package_version");
                if (TextUtils.isEmpty(ri)) {
                    ri = "-1";
                }
                String ri3 = hybridUbcFlow.ri("package_type");
                if (TextUtils.isEmpty(ri3)) {
                    ri3 = "-1";
                }
                sb3.append("\n\n小程序启动总时长：========> " + j + " LaunchDiff=" + hybridUbcFlow.B("naStart", "user_action"));
                sb3.append(!hybridUbcFlow.dtb.contains("package_start_unzip") ? "(热启动)" : "(冷启动)").append("  relaunchType:" + optInt).append("  preloadType:" + ri).append(" packageType:" + ri3);
                if (!TextUtils.isEmpty(ri2)) {
                    sb3.append(" packageVersion:" + ri2);
                }
                Log.i("StartupReporter", "Report ： " + sb3.toString());
            }
        }
    }
}
