package com.baidu.performance_monitor;

import android.support.annotation.NonNull;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
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
        if (methodCall.method.equals("reportFPS")) {
            if (methodCall.arguments == null) {
                result.error("arguments is empty", "", "");
                return;
            }
            String str = (String) methodCall.argument("page");
            double doubleValue = ((Double) methodCall.argument("fps")).doubleValue();
            a statsItem = BdStatisticsManager.getInstance().getStatsItem(BdStatsConstant.StatsType.PERFORMANCE);
            statsItem.append("action", "fluency");
            statsItem.append("page", str);
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
            BdStatisticsManager.getInstance().performance(str, statsItem);
            result.success((Object) null);
            return;
        }
        result.notImplemented();
    }
}
