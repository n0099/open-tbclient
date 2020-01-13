package com.baidu.swan.apps.performance;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.webkit.internal.ETAG;
import java.util.Locale;
/* loaded from: classes10.dex */
public class d implements com.baidu.swan.apps.as.d.b<HybridUbcFlow> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.as.d.b
    /* renamed from: a */
    public void B(HybridUbcFlow hybridUbcFlow) {
        e(hybridUbcFlow);
    }

    @SuppressLint({"SwanDebugLog"})
    public void e(HybridUbcFlow hybridUbcFlow) {
        com.baidu.swan.apps.runtime.e aap = com.baidu.swan.apps.runtime.e.aap();
        if (hybridUbcFlow != null && !hybridUbcFlow.bDo.isEmpty()) {
            long o = hybridUbcFlow.o("slave_first_rendered", "master_dispatch_start");
            com.baidu.swan.apps.ap.e.bTK.M(Long.valueOf(o));
            com.baidu.swan.apps.ap.e.bTF.M(Long.valueOf(hybridUbcFlow.o("slave_first_rendered", "naStart")));
            com.baidu.swan.apps.ap.e.bTG.M(Long.valueOf(hybridUbcFlow.o("aps_end_download", "aps_start_download", "aps_end_req", "aps_start_req", "naStart")));
            if (DEBUG && aap != null) {
                long o2 = hybridUbcFlow.o("na_first_meaningful_paint", "naStart");
                if (o2 < 1) {
                    o2 = hybridUbcFlow.o("na_first_paint", "naStart");
                }
                long j = o2 < 1 ? 1L : o2;
                String name = aap.getName();
                if (TextUtils.isEmpty(name)) {
                    name = "";
                }
                Log.i("StartupReporter", "\n\n  小程序启动性能报告: " + name + " appID: " + (!TextUtils.isEmpty(aap.id) ? aap.id : "") + " speedLog\n");
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 100; i++) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                Log.i("StartupReporter", String.format(" Cost [%s] Delta Src  Total Action", sb.toString()));
                long j2 = 0;
                long XG = hybridUbcFlow.bDo.get(0).XG();
                for (UbcFlowEvent ubcFlowEvent : hybridUbcFlow.bDo) {
                    long o3 = hybridUbcFlow.o(ubcFlowEvent.id, "naStart");
                    boolean z = o3 < 0;
                    boolean z2 = o3 > j;
                    if (z) {
                        o3 = 0;
                    }
                    if (z2) {
                        o3 = j;
                    }
                    long j3 = o3 - j2;
                    if (j3 < 0) {
                        j3 = 0;
                    }
                    int round = Math.round((float) ((100 * o3) / j));
                    if (round > 100) {
                        round = 100;
                    }
                    int round2 = Math.round((float) ((100 * j3) / j));
                    if (round2 > 100) {
                        round2 = 100;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(String.format(Locale.getDefault(), " %5d ", Long.valueOf(o3)));
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
                    sb2.append(z2 ? ">" : "]").append(String.format(Locale.getDefault(), "%5d", Long.valueOf(j3))).append(String.format("  %s", ubcFlowEvent.XH())).append(String.format(Locale.getDefault(), " %6d ", Long.valueOf(ubcFlowEvent.XG() - XG))).append(ubcFlowEvent.id);
                    if (ubcFlowEvent.XI()) {
                        sb2.append("(LocalRecord)");
                    }
                    Log.i("StartupReporter", sb2.toString());
                    j2 = o3;
                }
                Log.i("StartupReporter", "Total  ： " + hybridUbcFlow.bDo.size());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("\n========APS下载完成:" + hybridUbcFlow.o("aps_end_download", "naStart"));
                sb3.append("\n========解压包时长:" + hybridUbcFlow.o("package_end_unzip", "first_anim_start", "aps_end_download"));
                sb3.append("\n========第一次setData的调用:" + hybridUbcFlow.o("slave_first_loaded", "slave_js_parsed"));
                sb3.append("\n========master第一次和slave通信:" + hybridUbcFlow.o("slave_first_loaded", "master_first_init_data"));
                sb3.append("\n========slave第一次收到数据:" + hybridUbcFlow.o("slave_first_recieve_data", "master_first_init_data"));
                sb3.append("\n========slave第一次渲染完成:" + hybridUbcFlow.o("slave_first_rendered", "slave_first_recieve_data"));
                sb3.append("\n========第一次动画时长:" + hybridUbcFlow.o("first_anim_end", "first_anim_start"));
                sb3.append("\n========第二次动画时长:" + hybridUbcFlow.o("second_anim_end", "second_anim_start"));
                sb3.append("\n\n核心指标--------");
                sb3.append("\n========aps接口时长:" + hybridUbcFlow.o("aps_end_req", "aps_start_req", "naStart"));
                sb3.append("\n========aps纯下载时长:" + hybridUbcFlow.o("aps_end_download", "aps_start_download", "aps_end_req", "aps_start_req", "naStart"));
                sb3.append("\n========");
                sb3.append("\n========准备启动时长:" + hybridUbcFlow.o("na_launch_activity", "naStart"));
                sb3.append("\n========准备查库时长:" + hybridUbcFlow.o("na_query_db", "naStart"));
                sb3.append("\n========Activity调起时长:" + hybridUbcFlow.o("frame_start_create", "na_launch_activity"));
                sb3.append("\n========");
                sb3.append("\n========预加载等待时长:" + hybridUbcFlow.o("na_pre_load_ok", "na_pre_load_check"));
                sb3.append("\n========主线程阻塞时长:" + hybridUbcFlow.o("na_post_to_main_end", "na_post_to_main_start"));
                sb3.append("\n========本地小程序包加载及渲染总时长:" + hybridUbcFlow.o("slave_first_rendered", "first_anim_start"));
                sb3.append("\n\n启动线性跟踪分段指标简报--------");
                sb3.append("\n========取包（网络开销，从小程序入口，到APS及前置接口等网络交互完成）:" + hybridUbcFlow.o("first_anim_start", "naStart"));
                sb3.append("\n========安装（IO开销，从下载完成，到小程序包解压安装作业完成）:" + hybridUbcFlow.o("package_end_unzip", "first_anim_start"));
                sb3.append("\n========下载-安装（IO开销，从下载开始，到小程序包解压安装作业完成）:" + hybridUbcFlow.o("package_end_unzip", "aps_start_download"));
                sb3.append("\n========小程序框架启动总时长（NA开销，从开始，到 NA 准备完成）:" + hybridUbcFlow.o("master_dispatch_start", "naStart"));
                sb3.append("\n========小程序业务渲染总时长（H5开销，从 NA 准备完成，到页面渲染）:" + o);
                int optInt = hybridUbcFlow.Xj().optInt("type", -1);
                String jE = hybridUbcFlow.jE("preload_scene");
                String jE2 = hybridUbcFlow.jE("app_package_version");
                if (TextUtils.isEmpty(jE)) {
                    jE = "-1";
                }
                String jE3 = hybridUbcFlow.jE("package_type");
                if (TextUtils.isEmpty(jE3)) {
                    jE3 = "-1";
                }
                sb3.append("\n\n小程序启动总时长：========> " + j);
                sb3.append(!hybridUbcFlow.bDm.contains("package_start_unzip") ? "(热启动)" : "(冷启动)").append("  relaunchType:" + optInt).append("  preloadType:" + jE).append(" packageType:" + jE3);
                if (!TextUtils.isEmpty(jE2)) {
                    sb3.append(" packageVersion:" + jE2);
                }
                Log.i("StartupReporter", "Report ： " + sb3.toString());
            }
        }
    }
}
