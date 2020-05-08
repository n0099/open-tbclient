package com.baidu.performance_monitor;

import android.support.annotation.NonNull;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.n.l;
import com.baidu.tbadk.n.m;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class PerformanceMonitorPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "performance_monitor").setMethodCallHandler(new PerformanceMonitorPlugin());
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str;
        if (methodCall.method.equals("reportFPS")) {
            if (methodCall.arguments == null) {
                result.error("arguments is empty", "", "");
                return;
            }
            String str2 = (String) methodCall.argument("page");
            double doubleValue = ((Double) methodCall.argument("fps")).doubleValue();
            a statsItem = BdStatisticsManager.getInstance().getStatsItem(BdStatsConstant.StatsType.PERFORMANCE);
            statsItem.append("action", "fluency");
            statsItem.append("page", str2);
            statsItem.append("fps", Double.valueOf(doubleValue));
            statsItem.append("flutter", 1);
            HashMap hashMap = (HashMap) methodCall.argument("fatal");
            if (hashMap != null) {
                if (hashMap.containsKey("blocks") && (hashMap.get("blocks") instanceof String)) {
                    statsItem.append("fatal_blocks", hashMap.get("blocks"));
                }
                if (hashMap.containsKey("vast") && (hashMap.get("vast") instanceof Boolean)) {
                    statsItem.append("fatal_vast", hashMap.get("vast"));
                }
            }
            HashMap hashMap2 = (HashMap) methodCall.argument("cont");
            if (hashMap2 != null) {
                if (hashMap2.containsKey("blocks") && (hashMap2.get("blocks") instanceof String)) {
                    statsItem.append("cont_blocks", hashMap2.get("blocks"));
                }
                if (hashMap2.containsKey("vast") && (hashMap2.get("vast") instanceof Boolean)) {
                    statsItem.append("cont_vast", hashMap2.get("vast"));
                }
            }
            BdStatisticsManager.getInstance().performance(str2, statsItem);
            result.success((Object) null);
        } else if (methodCall.method.equals("reportPageLoadPerformance")) {
            if (m.aZy().aZz()) {
                HashMap hashMap3 = (HashMap) methodCall.arguments;
                String str3 = (String) hashMap3.get("pageName");
                if ("SignAllForum".equals(str3)) {
                    str = "sign_all_flt";
                } else {
                    str = "MyTab".equals(str3) ? "user_center_flt" : str3;
                }
                if (hashMap3.get("viewCreateTime") != null && ((Double) hashMap3.get("viewCreateTime")).doubleValue() > 0.0d) {
                    a kW = l.kW();
                    kW.append("action", "time");
                    kW.append("ishttp", hashMap3.get("isHttp"));
                    kW.append("issuccess", hashMap3.get("errCode") == BasicPushStatus.SUCCESS_CODE ? "1" : "0");
                    kW.append("nettype", m.aZy().getNetType());
                    kW.append("wt", String.valueOf(hashMap3.get("whiteTime")));
                    kW.append("qt", "0");
                    kW.append("connt", hashMap3.get("netConTime"));
                    kW.append("rwt", hashMap3.get("netRWTime"));
                    kW.append("fbt", hashMap3.get("firstByteReachTime"));
                    kW.append("abt", hashMap3.get("allDataReadTime"));
                    kW.append("dect", hashMap3.get("dataDeCompressTime"));
                    kW.append("parset", hashMap3.get("dataParseTime"));
                    kW.append("tqt", "0");
                    kW.append("rendert", hashMap3.get("drawTime"));
                    if (hashMap3.get("isHttp") == "1") {
                        kW.append("hrtn", hashMap3.get("httpRetryNum"));
                        kW.append("hrtt", hashMap3.get("httpRetryCostTime"));
                    }
                    if (hashMap3.get("errCode") != "0") {
                        kW.append("errcode", hashMap3.get("errCode"));
                    }
                    kW.append(Config.EXCEPTION_CRASH_TYPE, hashMap3.get("viewCreateTime"));
                    kW.append("transt", hashMap3.get("channelTransTime"));
                    kW.append("dpt", hashMap3.get("dartItemParseTime"));
                    kW.append("hs", hashMap3.get("httpSize"));
                    BdStatisticsManager.getInstance().performance(str, kW);
                }
            }
        } else {
            result.notImplemented();
        }
    }
}
