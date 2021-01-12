package com.baidu.f.a;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.baidu.searchbox.perfframe.PerfFrame;
import com.baidu.searchbox.perfframe.ioc.Constant;
import com.baidu.searchbox.track.ui.TraceManager;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
/* loaded from: classes14.dex */
public class a implements FlutterPlugin, ActivityAware, MethodChannel.MethodCallHandler {
    private static Activity activity;
    static final long arh = System.currentTimeMillis();
    private MethodChannel channel;

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.channel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "flutter_exception_perf_plugin");
        this.channel.setMethodCallHandler(this);
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        if (methodCall.method.equals("reportException")) {
            String str = (String) methodCall.argument("page");
            String str2 = (String) methodCall.argument("message");
            long longValue = ((Long) methodCall.argument("excTime")).longValue();
            String str3 = (String) methodCall.argument(Constant.KEY_BUSINESS);
            PerfFrame create = new PerfFrame.Builder().setNeedStaticperf(true).setNeedPageTrace(true).setNeedMainStackTrace(true).setNeedDynamicperf(true).create();
            if (create != null) {
                create.submitPerformanceData("2301", "flutter", longValue, arh, str2, str, str3);
                result.success(true);
                return;
            }
            result.success(false);
        } else if (methodCall.method.equals("reportPageTrace")) {
            String str4 = (String) methodCall.argument("tag");
            ((Long) methodCall.argument("timeStamp")).longValue();
            TraceManager.getInstance().saveTraceInfo(activity, null, (String) methodCall.argument("page"), str4, "flutter", (String) methodCall.argument("event"));
            result.success(true);
        } else {
            result.notImplemented();
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.channel.setMethodCallHandler(null);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(@NonNull ActivityPluginBinding activityPluginBinding) {
        activity = activityPluginBinding.getActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        activity = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding activityPluginBinding) {
        activity = activityPluginBinding.getActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        activity = null;
    }
}
