package com.baidu.swan.apps.inlinewidget.b;

import android.support.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes3.dex */
public class c implements ZeusPluginFactory {
    private String bVN;

    public c(@NonNull String str) {
        this.bVN = str;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        return "media_extractor";
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        return new b(com.baidu.swan.apps.t.a.aqi().e(invoker, this.bVN));
    }
}
