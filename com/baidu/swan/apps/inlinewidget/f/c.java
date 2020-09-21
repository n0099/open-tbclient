package com.baidu.swan.apps.inlinewidget.f;

import android.support.annotation.NonNull;
import android.util.Log;
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
        return "swan_live";
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        com.baidu.swan.apps.inlinewidget.f.c.a b = com.baidu.swan.apps.t.a.aqi().b(invoker, this.bVN);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.i("【InlineLiveFactory】", "Factory 「Hash:" + hashCode() + "」 is creating inline live「Hash:" + b.hashCode() + "」");
        }
        return new a(b);
    }
}
