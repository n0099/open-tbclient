package com.baidu.j;

import android.support.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.live.adp.framework.MessageConfig;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
/* loaded from: classes14.dex */
public class a implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private static CustomMessageListener Oe = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.j.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                boolean z = true;
                try {
                    z = j.isNetWorkAvailable();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
                a.mMethodChannel.invokeMethod("setNetInfo", Boolean.valueOf(z));
            }
        }
    };
    private static MethodChannel mMethodChannel;

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        mMethodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "network_info");
        mMethodChannel.setMethodCallHandler(new a());
        init();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }

    private static void init() {
        MessageManager.getInstance().registerListener(Oe);
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        if (methodCall.method.equals("isNetWorkAvailable")) {
            result.success(Boolean.valueOf(j.isNetWorkAvailable()));
        } else if (methodCall.method.equals("isNetworkAvailableForImmediately")) {
            result.success(Boolean.valueOf(j.isNetworkAvailableForImmediately()));
        } else {
            result.notImplemented();
        }
    }
}
