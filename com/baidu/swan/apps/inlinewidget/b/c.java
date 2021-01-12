package com.baidu.swan.apps.inlinewidget.b;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes8.dex */
public class c implements ZeusPluginFactory {
    private String cBM;

    public c(@NonNull String str) {
        this.cBM = str;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        return "media_extractor";
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        return new b(com.baidu.swan.apps.t.a.axm().e(invoker, this.cBM));
    }
}
