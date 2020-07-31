package com.baidu.swan.apps.p.a;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes7.dex */
public class b implements ZeusPluginFactory {
    private String bOl;

    public b(@NonNull String str) {
        this.bOl = str;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        return "swan_input";
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        c cVar = new c(invoker, this.bOl);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.i("【InlineInputFactory】", "Factory 「Hash:" + hashCode() + "」 is creating inline input「Hash:" + cVar.hashCode() + "」");
        }
        return new a(cVar);
    }
}
