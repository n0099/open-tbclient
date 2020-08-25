package com.baidu.e;

import android.support.annotation.NonNull;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
/* loaded from: classes4.dex */
public class c implements FlutterPlugin {
    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        flutterPluginBinding.getPlatformViewRegistry().registerViewFactory("common_platform_view", new b(flutterPluginBinding.getBinaryMessenger()));
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }
}
