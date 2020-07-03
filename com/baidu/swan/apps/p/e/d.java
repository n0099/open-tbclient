package com.baidu.swan.apps.p.e;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes11.dex */
public class d implements ZeusPluginFactory {
    private String bNv;

    public d(@NonNull String str) {
        this.bNv = str;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        return "inline_video";
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        com.baidu.swan.apps.p.e.b.a a = com.baidu.swan.apps.u.a.agJ().a(invoker, this.bNv);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.i("【InlineFactory】", "Factory 「Hash:" + hashCode() + "」 is creating inline video「Hash:" + a.hashCode() + "」");
        }
        return new b(a);
    }
}
