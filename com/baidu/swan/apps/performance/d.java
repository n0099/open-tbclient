package com.baidu.swan.apps.performance;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import java.util.Locale;
/* loaded from: classes2.dex */
public class d implements com.baidu.swan.apps.an.d.a<HybridUbcFlow> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.an.d.a
    /* renamed from: a */
    public void D(HybridUbcFlow hybridUbcFlow) {
        d(hybridUbcFlow);
    }

    public void d(HybridUbcFlow hybridUbcFlow) {
        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
        if (hybridUbcFlow != null && !hybridUbcFlow.aGB.isEmpty()) {
            long m = hybridUbcFlow.m("slave_first_rendered", "master_dispatch_start");
            com.baidu.swan.apps.ak.e.baa.K(Long.valueOf(m));
            com.baidu.swan.apps.ak.e.aZV.K(Long.valueOf(hybridUbcFlow.m("slave_first_rendered", "naStart")));
            com.baidu.swan.apps.ak.e.aZW.K(Long.valueOf(hybridUbcFlow.m("aps_end_download", "aps_start_download", "aps_end_req", "aps_start_req", "naStart")));
            if (DEBUG && Mh != null) {
                long m2 = hybridUbcFlow.m("slave_first_rendered", "naStart");
                long j = m2 < 1 ? 1L : m2;
                String name = Mh.getName();
                if (TextUtils.isEmpty(name)) {
                    name = "";
                }
                Log.i("StartupReporter", "\n\n  小程序启动性能报告: " + name + " appID: " + (!TextUtils.isEmpty(Mh.id) ? Mh.id : "") + " speedLog\n");
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 100; i++) {
                    sb.append("&");
                }
                Log.i("StartupReporter", String.format("Delta [%s]  Cost Src  Total Action", sb.toString()));
                long j2 = 0;
                long IQ = hybridUbcFlow.aGB.get(0).IQ();
                for (UbcFlowEvent ubcFlowEvent : hybridUbcFlow.aGB) {
                    long m3 = hybridUbcFlow.m(ubcFlowEvent.id, "naStart");
                    boolean z = m3 < 0;
                    boolean z2 = m3 > j;
                    if (z) {
                        m3 = 0;
                    }
                    if (z2) {
                        m3 = j;
                    }
                    long j3 = m3 - j2;
                    if (j3 < 0) {
                        j3 = 0;
                    }
                    int round = Math.round((float) ((100 * m3) / j));
                    if (round > 100) {
                        round = 100;
                    }
                    int round2 = Math.round((float) ((100 * j3) / j));
                    if (round2 > 100) {
                        round2 = 100;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(String.format(Locale.getDefault(), "%5d ", Long.valueOf(j3)));
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
                    sb2.append(z2 ? ">" : "]").append(String.format(Locale.getDefault(), " %5d", Long.valueOf(m3))).append(String.format("  %s", ubcFlowEvent.IR())).append(String.format(Locale.getDefault(), " %6d ", Long.valueOf(ubcFlowEvent.IQ() - IQ))).append(ubcFlowEvent.id);
                    if (ubcFlowEvent.IS()) {
                        sb2.append("(LocalRecord)");
                    }
                    Log.i("StartupReporter", sb2.toString());
                    j2 = m3;
                }
                Log.i("StartupReporter", "Total  ： " + hybridUbcFlow.aGB.size());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("\n========APS下载完成:" + hybridUbcFlow.m("aps_end_download", "naStart"));
                sb3.append("\n========解压包时长:" + hybridUbcFlow.m("package_end_unzip", "first_anim_start", "aps_end_download"));
                sb3.append("\n========第一次setData的调用:" + hybridUbcFlow.m("slave_first_loaded", "slave_js_parsed"));
                sb3.append("\n========master第一次和slave通信:" + hybridUbcFlow.m("slave_first_loaded", "master_first_init_data"));
                sb3.append("\n========slave第一次收到数据:" + hybridUbcFlow.m("slave_first_recieve_data", "master_first_init_data"));
                sb3.append("\n========slave第一次渲染完成:" + hybridUbcFlow.m("slave_first_rendered", "slave_first_recieve_data"));
                sb3.append("\n========第一次动画时长:" + hybridUbcFlow.m("first_anim_end", "first_anim_start"));
                sb3.append("\n========第二次动画时长:" + hybridUbcFlow.m("second_anim_end", "second_anim_start"));
                sb3.append("\n\n核心指标--------");
                sb3.append("\n========aps接口时长:" + hybridUbcFlow.m("aps_end_req", "aps_start_req", "naStart"));
                sb3.append("\n========aps纯下载时长:" + hybridUbcFlow.m("aps_end_download", "aps_start_download", "aps_end_req", "aps_start_req", "naStart"));
                sb3.append("\n========");
                sb3.append("\n========准备启动时长:" + hybridUbcFlow.m("na_launch_activity", "naStart"));
                sb3.append("\n========准备查库时长:" + hybridUbcFlow.m("na_query_db", "naStart"));
                sb3.append("\n========Activity调起时长:" + hybridUbcFlow.m("frame_start_create", "na_launch_activity"));
                sb3.append("\n========");
                sb3.append("\n========预加载等待时长:" + hybridUbcFlow.m("na_pre_load_ok", "na_pre_load_check"));
                sb3.append("\n========主线程阻塞时长:" + hybridUbcFlow.m("na_post_to_main_end", "na_post_to_main_start"));
                sb3.append("\n========本地小程序包加载及渲染总时长:" + hybridUbcFlow.m("slave_first_rendered", "first_anim_start"));
                sb3.append("\n\n启动线性跟踪分段指标简报--------");
                sb3.append("\n========取包（网络开销，从小程序入口，到APS及前置接口等网络交互完成）:" + hybridUbcFlow.m("first_anim_start", "naStart"));
                sb3.append("\n========安装（IO开销，从下载完成，到小程序包解压安装作业完成）:" + hybridUbcFlow.m("package_end_unzip", "first_anim_start"));
                sb3.append("\n========下载-安装（IO开销，从下载开始，到小程序包解压安装作业完成）:" + hybridUbcFlow.m("package_end_unzip", "aps_start_download"));
                sb3.append("\n========小程序框架启动总时长（NA开销，从开始，到 NA 准备完成）:" + hybridUbcFlow.m("master_dispatch_start", "naStart"));
                sb3.append("\n========小程序业务渲染总时长（H5开销，从 NA 准备完成，到页面渲染）:" + m);
                int optInt = hybridUbcFlow.Iq().optInt("type", -1);
                String fY = hybridUbcFlow.fY("preload_scene");
                if (TextUtils.isEmpty(fY)) {
                    fY = LivenessStat.TYPE_STRING_DEFAULT;
                }
                sb3.append("\n\n小程序启动总时长：========> " + j);
                sb3.append(!hybridUbcFlow.aGz.contains("package_start_unzip") ? "(热启动)" : "(冷启动)").append("  relaunchType:" + optInt).append("  preloadType:" + fY);
                Log.i("StartupReporter", "Report ： " + sb3.toString());
            }
        }
    }
}
