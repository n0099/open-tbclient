package com.baidu.swan.apps.p.f;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes7.dex */
public class d implements ZeusPluginFactory {
    private String bOl;

    public d(@NonNull String str) {
        this.bOl = str;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        return "inline_video";
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        com.baidu.swan.apps.p.f.b.a a = com.baidu.swan.apps.t.a.ahW().a(invoker, this.bOl);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.i("【InlineFactory】", "Factory 「Hash:" + hashCode() + "」 is creating inline video「Hash:" + a.hashCode() + "」");
        }
        return new b(a);
    }
}
