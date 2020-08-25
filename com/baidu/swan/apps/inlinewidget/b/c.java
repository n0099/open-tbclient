package com.baidu.swan.apps.inlinewidget.b;

import android.support.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes8.dex */
public class c implements ZeusPluginFactory {
    private String bTJ;

    public c(@NonNull String str) {
        this.bTJ = str;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        return "media_extractor";
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        return new b(com.baidu.swan.apps.t.a.apy().e(invoker, this.bTJ));
    }
}
