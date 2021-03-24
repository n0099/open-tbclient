package com.baidu.performance_monitor;

import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.mobstat.Config;
import com.baidu.tieba.flutter.util.OpenFlutter;
import com.baidu.wallet.router.RouterCallback;
import com.facebook.common.util.UriUtil;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import d.b.b.e.n.a;
import d.b.h0.m0.j;
import d.b.h0.m0.k;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class PerformanceMonitorPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    public static HashMap<String, String> flutterEngineStartInfo = new HashMap<>();
    public final CustomMessageListener mFlutterEngineInitListener = new CustomMessageListener(this, 2921451) { // from class: com.baidu.performance_monitor.PerformanceMonitorPlugin.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof HashMap)) {
                return;
            }
            PerformanceMonitorPlugin.flutterEngineStartInfo.clear();
            PerformanceMonitorPlugin.flutterEngineStartInfo.putAll((HashMap) customResponsedMessage.getData());
        }
    };

    /* loaded from: classes2.dex */
    public class PerfCPULogAsync extends BdAsyncTask<String, Integer, Boolean> {
        public final a mItem;
        public final String mPage;

        public PerfCPULogAsync(PerformanceMonitorPlugin performanceMonitorPlugin, String str, a aVar) {
            this.mPage = str;
            this.mItem = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            this.mItem.b("memp", String.valueOf(k.d().c()));
            this.mItem.b("cpu", k.d().b());
            BdStatisticsManager.getInstance().performance(this.mPage, this.mItem);
            return Boolean.TRUE;
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "performance_monitor").setMethodCallHandler(new PerformanceMonitorPlugin());
        MessageManager.getInstance().registerListener(this.mFlutterEngineInitListener);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MessageManager.getInstance().unRegisterListener(this.mFlutterEngineInitListener);
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        Object obj;
        HashMap hashMap;
        if (methodCall.method.equals("reportFPS")) {
            if (methodCall.arguments == null) {
                result.error("arguments is empty", "", "");
                return;
            }
            String str = (String) methodCall.argument("page");
            double doubleValue = ((Double) methodCall.argument("fps")).doubleValue();
            a statsItem = BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
            statsItem.b("action", "fluency");
            statsItem.b("page", str);
            statsItem.c("fps", Double.valueOf(doubleValue));
            statsItem.c("flutter", 1);
            HashMap hashMap2 = (HashMap) methodCall.argument("fatal");
            if (hashMap2 != null) {
                if (hashMap2.containsKey("blocks") && (hashMap2.get("blocks") instanceof String)) {
                    statsItem.c("fatal_blocks", hashMap2.get("blocks"));
                }
                if (hashMap2.containsKey("vast") && (hashMap2.get("vast") instanceof Boolean)) {
                    statsItem.c("fatal_vast", hashMap2.get("vast"));
                }
            }
            HashMap hashMap3 = (HashMap) methodCall.argument("cont");
            if (hashMap3 != null) {
                if (hashMap3.containsKey("blocks") && (hashMap3.get("blocks") instanceof String)) {
                    statsItem.c("cont_blocks", hashMap3.get("blocks"));
                }
                if (hashMap3.containsKey("vast") && (hashMap3.get("vast") instanceof Boolean)) {
                    statsItem.c("cont_vast", hashMap3.get("vast"));
                }
            }
            PerfCPULogAsync perfCPULogAsync = new PerfCPULogAsync(this, str, statsItem);
            perfCPULogAsync.setSelfExecute(true);
            perfCPULogAsync.execute(new String[0]);
            result.success(null);
        } else if (methodCall.method.equals("reportPageLoadPerformance")) {
            if (!k.d().g() || (obj = methodCall.arguments) == null || (hashMap = (HashMap) obj) == null || hashMap.get("viewCreateTime") == null || ((Double) hashMap.get("viewCreateTime")).doubleValue() <= 0.0d) {
                return;
            }
            String str2 = (String) hashMap.get("pageName");
            if (OpenFlutter.ACTIVITY_SIGN_TOGETHER.equals(str2)) {
                str2 = "sign_all_flt";
            } else if (OpenFlutter.FRAGMENT_MYTAB.equals(str2)) {
                str2 = "user_center_flt";
            }
            a a2 = j.a();
            a2.b("action", "time");
            a2.c("ishttp", hashMap.get("isHttp"));
            a2.b("issuccess", hashMap.get(RouterCallback.KEY_ERROR_CODE) == BasicPushStatus.SUCCESS_CODE ? "1" : "0");
            a2.b("nettype", k.d().f());
            if (hashMap.containsKey("whiteTime") && (hashMap.get("whiteTime") instanceof Double)) {
                a2.c("wt", Double.valueOf(((Double) hashMap.get("whiteTime")).doubleValue() * 1000.0d));
            }
            a2.c("qt", hashMap.get("queneTime"));
            a2.c("connt", hashMap.get("netConTime"));
            a2.c("rwt", hashMap.get("netRWTime"));
            a2.c("fbt", hashMap.get("firstByteTime"));
            a2.c("abt", hashMap.get("allDataReadTime"));
            a2.c("dect", hashMap.get("dataDeCompressTime"));
            a2.c("tqt", hashMap.get("taskWaitTime"));
            if (hashMap.containsKey("dataParseTime") && (hashMap.get("dataParseTime") instanceof Double)) {
                a2.c("parset", Double.valueOf(((Double) hashMap.get("dataParseTime")).doubleValue() * 1000.0d));
            }
            if (hashMap.containsKey("drawTime") && (hashMap.get("drawTime") instanceof Double)) {
                a2.c("rendert", Double.valueOf(((Double) hashMap.get("drawTime")).doubleValue() * 1000.0d));
            }
            if (hashMap.get("isHttp") == "1") {
                a2.c("hrtn", hashMap.get("httpRetryNum"));
                a2.c("hrtt", hashMap.get("httpRetryCostTime"));
            }
            if (hashMap.get(RouterCallback.KEY_ERROR_CODE) != "0") {
                a2.c("errcode", hashMap.get(RouterCallback.KEY_ERROR_CODE));
            }
            if (hashMap.containsKey("viewCreateTime") && (hashMap.get("viewCreateTime") instanceof Double)) {
                a2.c(Config.EXCEPTION_CRASH_TYPE, Double.valueOf(((Double) hashMap.get("viewCreateTime")).doubleValue() * 1000.0d));
            }
            if (hashMap.containsKey("channelTransTime") && (hashMap.get("channelTransTime") instanceof Double)) {
                a2.c("transt", Double.valueOf(((Double) hashMap.get("channelTransTime")).doubleValue() * 1000.0d));
            }
            if (hashMap.containsKey("dartItemParseTime") && (hashMap.get("dartItemParseTime") instanceof Double)) {
                a2.c("dpt", Double.valueOf(((Double) hashMap.get("dartItemParseTime")).doubleValue() * 1000.0d));
            }
            if (hashMap.containsKey("reqWaitTime") && (hashMap.get("reqWaitTime") instanceof Double)) {
                a2.c("rqwt", Double.valueOf(((Double) hashMap.get("reqWaitTime")).doubleValue() * 1000.0d));
            }
            if (hashMap.containsKey("renderTime") && (hashMap.get("renderTime") instanceof Double)) {
                a2.c("rdt", Double.valueOf(((Double) hashMap.get("renderTime")).doubleValue() * 1000.0d));
            }
            a2.c("hs", hashMap.get("httpSize"));
            BdStatisticsManager.getInstance().performance(str2, a2);
        } else if (methodCall.method.equals("reportImageLoadPerformance")) {
            Object obj2 = methodCall.arguments;
            if (obj2 != null && (obj2 instanceof HashMap)) {
                HashMap hashMap4 = (HashMap) obj2;
                a statsItem2 = BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
                statsItem2.b("action", "image_perf");
                statsItem2.c(UriUtil.LOCAL_RESOURCE_SCHEME, hashMap4.get("isBundleFile"));
                statsItem2.c("try", hashMap4.get("tryTimes"));
                statsItem2.c(Config.EXCEPTION_CRASH_TYPE, hashMap4.get("contentType"));
                statsItem2.c("dc", hashMap4.get("dartCodecCost"));
                statsItem2.c("lc", hashMap4.get("loadingCost"));
                statsItem2.c("trans", hashMap4.get("channelTransTime"));
                statsItem2.c("cc", hashMap4.get("codecCost"));
                statsItem2.c("tc", hashMap4.get("totalCost"));
                statsItem2.c("ds", hashMap4.get("imageDataSize"));
                statsItem2.c("nt", hashMap4.get("netType"));
                BdStatisticsManager.getInstance().performance("flt", statsItem2);
            }
        } else if (methodCall.method.equals("reportEnginePerformance")) {
            Object obj3 = methodCall.arguments;
            if (obj3 != null && (obj3 instanceof HashMap)) {
                HashMap hashMap5 = (HashMap) obj3;
                a statsItem3 = BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
                statsItem3.b("action", "engine_perf");
                HashMap<String, String> hashMap6 = flutterEngineStartInfo;
                if (hashMap6 != null && !hashMap6.isEmpty()) {
                    for (Map.Entry<String, String> entry : flutterEngineStartInfo.entrySet()) {
                        statsItem3.b(entry.getKey(), entry.getValue());
                    }
                }
                if (hashMap5 != null && !hashMap5.isEmpty()) {
                    for (Map.Entry entry2 : hashMap5.entrySet()) {
                        statsItem3.c(entry2.getKey(), entry2.getValue());
                    }
                }
                BdStatisticsManager.getInstance().performance("engine", statsItem3);
            }
        } else {
            result.notImplemented();
        }
    }
}
