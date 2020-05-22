package com.baidu.performance_monitor;

import android.support.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.baidu.tbadk.n.l;
import com.baidu.tbadk.n.m;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class PerformanceMonitorPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private static HashMap<String, String> flutterEngineStartInfo = new HashMap<>();
    private final CustomMessageListener mFlutterEngineInitListener = new CustomMessageListener(2921451) { // from class: com.baidu.performance_monitor.PerformanceMonitorPlugin.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof HashMap)) {
                PerformanceMonitorPlugin.flutterEngineStartInfo.clear();
                PerformanceMonitorPlugin.flutterEngineStartInfo.putAll((HashMap) customResponsedMessage.getData());
            }
        }
    };

    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "performance_monitor").setMethodCallHandler(new PerformanceMonitorPlugin());
        MessageManager.getInstance().registerListener(this.mFlutterEngineInitListener);
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MessageManager.getInstance().unRegisterListener(this.mFlutterEngineInitListener);
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        HashMap hashMap;
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
            HashMap hashMap2 = (HashMap) methodCall.argument("fatal");
            if (hashMap2 != null) {
                if (hashMap2.containsKey("blocks") && (hashMap2.get("blocks") instanceof String)) {
                    statsItem.append("fatal_blocks", hashMap2.get("blocks"));
                }
                if (hashMap2.containsKey("vast") && (hashMap2.get("vast") instanceof Boolean)) {
                    statsItem.append("fatal_vast", hashMap2.get("vast"));
                }
            }
            HashMap hashMap3 = (HashMap) methodCall.argument("cont");
            if (hashMap3 != null) {
                if (hashMap3.containsKey("blocks") && (hashMap3.get("blocks") instanceof String)) {
                    statsItem.append("cont_blocks", hashMap3.get("blocks"));
                }
                if (hashMap3.containsKey("vast") && (hashMap3.get("vast") instanceof Boolean)) {
                    statsItem.append("cont_vast", hashMap3.get("vast"));
                }
            }
            BdStatisticsManager.getInstance().performance(str2, statsItem);
            result.success((Object) null);
        } else if (methodCall.method.equals("reportPageLoadPerformance")) {
            if (m.bfI().bfJ() && methodCall.arguments != null && (hashMap = (HashMap) methodCall.arguments) != null && hashMap.get("viewCreateTime") != null && ((Double) hashMap.get("viewCreateTime")).doubleValue() > 0.0d) {
                String str3 = (String) hashMap.get("pageName");
                if ("SignAllForum".equals(str3)) {
                    str = "sign_all_flt";
                } else {
                    str = "MyTab".equals(str3) ? "user_center_flt" : str3;
                }
                a kY = l.kY();
                kY.append("action", "time");
                kY.append("ishttp", hashMap.get("isHttp"));
                kY.append("issuccess", hashMap.get("errCode") == BasicPushStatus.SUCCESS_CODE ? "1" : "0");
                kY.append("nettype", m.bfI().getNetType());
                if (hashMap.containsKey("whiteTime") && (hashMap.get("whiteTime") instanceof Double)) {
                    kY.append("wt", Double.valueOf(((Double) hashMap.get("whiteTime")).doubleValue() * 1000.0d));
                }
                kY.append("qt", hashMap.get("queneTime"));
                kY.append("connt", hashMap.get("netConTime"));
                kY.append("rwt", hashMap.get("netRWTime"));
                kY.append("fbt", hashMap.get("firstByteReachTime"));
                kY.append("abt", hashMap.get("allDataReadTime"));
                kY.append("dect", hashMap.get("dataDeCompressTime"));
                kY.append("tqt", "0");
                if (hashMap.containsKey("dataParseTime") && (hashMap.get("dataParseTime") instanceof Double)) {
                    kY.append("parset", Double.valueOf(((Double) hashMap.get("dataParseTime")).doubleValue() * 1000.0d));
                }
                if (hashMap.containsKey("drawTime") && (hashMap.get("drawTime") instanceof Double)) {
                    kY.append("rendert", Double.valueOf(((Double) hashMap.get("drawTime")).doubleValue() * 1000.0d));
                }
                if (hashMap.get("isHttp") == "1") {
                    kY.append("hrtn", hashMap.get("httpRetryNum"));
                    kY.append("hrtt", hashMap.get("httpRetryCostTime"));
                }
                if (hashMap.get("errCode") != "0") {
                    kY.append("errcode", hashMap.get("errCode"));
                }
                if (hashMap.containsKey("viewCreateTime") && (hashMap.get("viewCreateTime") instanceof Double)) {
                    kY.append(Config.EXCEPTION_CRASH_TYPE, Double.valueOf(((Double) hashMap.get("viewCreateTime")).doubleValue() * 1000.0d));
                }
                if (hashMap.containsKey("channelTransTime") && (hashMap.get("channelTransTime") instanceof Double)) {
                    kY.append("transt", Double.valueOf(((Double) hashMap.get("channelTransTime")).doubleValue() * 1000.0d));
                }
                if (hashMap.containsKey("dartItemParseTime") && (hashMap.get("dartItemParseTime") instanceof Double)) {
                    kY.append("dpt", Double.valueOf(((Double) hashMap.get("dartItemParseTime")).doubleValue() * 1000.0d));
                }
                kY.append("hs", hashMap.get("httpSize"));
                BdStatisticsManager.getInstance().performance(str, kY);
            }
        } else if (methodCall.method.equals("reportImageLoadPerformance")) {
            if (methodCall.arguments != null && (methodCall.arguments instanceof HashMap)) {
                HashMap hashMap4 = (HashMap) methodCall.arguments;
                a statsItem2 = BdStatisticsManager.getInstance().getStatsItem(BdStatsConstant.StatsType.PERFORMANCE);
                statsItem2.append("action", "image_perf");
                statsItem2.append("res", hashMap4.get("isBundleFile"));
                statsItem2.append("try", hashMap4.get("tryTimes"));
                statsItem2.append(Config.EXCEPTION_CRASH_TYPE, hashMap4.get(CameraActivityConfig.KEY_CONTENT_TYPE));
                statsItem2.append("dc", hashMap4.get("dartCodecCost"));
                statsItem2.append(j.g, hashMap4.get("loadingCost"));
                statsItem2.append("trans", hashMap4.get("channelTransTime"));
                statsItem2.append("cc", hashMap4.get("codecCost"));
                statsItem2.append("tc", hashMap4.get("totalCost"));
                statsItem2.append("ds", hashMap4.get("imageDataSize"));
                statsItem2.append("nt", hashMap4.get("netType"));
                BdStatisticsManager.getInstance().performance("flt", statsItem2);
            }
        } else if (methodCall.method.equals("reportEnginePerformance")) {
            if (methodCall.arguments != null && (methodCall.arguments instanceof HashMap)) {
                HashMap hashMap5 = (HashMap) methodCall.arguments;
                a statsItem3 = BdStatisticsManager.getInstance().getStatsItem(BdStatsConstant.StatsType.PERFORMANCE);
                statsItem3.append("action", "engine_perf");
                if (flutterEngineStartInfo != null && !flutterEngineStartInfo.isEmpty()) {
                    for (Map.Entry<String, String> entry : flutterEngineStartInfo.entrySet()) {
                        statsItem3.append(entry.getKey(), entry.getValue());
                    }
                }
                if (hashMap5 != null && !hashMap5.isEmpty()) {
                    for (Map.Entry entry2 : hashMap5.entrySet()) {
                        statsItem3.append(entry2.getKey(), entry2.getValue());
                    }
                }
                BdStatisticsManager.getInstance().performance("engine", statsItem3);
            }
        } else {
            result.notImplemented();
        }
    }
}
