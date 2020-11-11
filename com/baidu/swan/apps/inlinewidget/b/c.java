package com.baidu.swan.apps.inlinewidget.b;

import android.support.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes10.dex */
public class c implements ZeusPluginFactory {
    private String cwA;

    public c(@NonNull String str) {
        this.cwA = str;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        return "media_extractor";
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        return new b(com.baidu.swan.apps.t.a.axo().e(invoker, this.cwA));
    }
}
