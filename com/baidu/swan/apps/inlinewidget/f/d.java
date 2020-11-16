package com.baidu.swan.apps.inlinewidget.f;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes7.dex */
public class d implements ZeusPluginFactory {
    private String cuQ;

    public d(@NonNull String str) {
        this.cuQ = str;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        return "inline_video";
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        com.baidu.swan.apps.inlinewidget.f.c.a a2 = com.baidu.swan.apps.t.a.awG().a(invoker, this.cuQ);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.i("【InlineFactory】", "Factory 「Hash:" + hashCode() + "」 is creating inline video「Hash:" + a2.hashCode() + "」");
        }
        return new b(a2);
    }
}
