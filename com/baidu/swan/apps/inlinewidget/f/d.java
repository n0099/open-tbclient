package com.baidu.swan.apps.inlinewidget.f;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes8.dex */
public class d implements ZeusPluginFactory {
    private String bTJ;

    public d(@NonNull String str) {
        this.bTJ = str;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        return "inline_video";
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        com.baidu.swan.apps.inlinewidget.f.c.a a = com.baidu.swan.apps.t.a.apy().a(invoker, this.bTJ);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.i("【InlineFactory】", "Factory 「Hash:" + hashCode() + "」 is creating inline video「Hash:" + a.hashCode() + "」");
        }
        return new b(a);
    }
}
