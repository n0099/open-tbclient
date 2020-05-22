package com.baidu.swan.apps.p.e;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes11.dex */
public class c implements ZeusPluginFactory {
    private String bIH;

    public c(@NonNull String str) {
        this.bIH = str;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        return "swan_live";
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        com.baidu.swan.apps.p.e.b.a b = com.baidu.swan.apps.u.a.afD().b(invoker, this.bIH);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.i("【InlineLiveFactory】", "Factory 「Hash:" + hashCode() + "」 is creating inline live「Hash:" + b.hashCode() + "」");
        }
        return new a(b);
    }
}
