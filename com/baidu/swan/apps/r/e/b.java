package com.baidu.swan.apps.r.e;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes9.dex */
public class b implements ZeusPluginFactory {
    private String aXf;

    public b(@NonNull String str) {
        this.aXf = str;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        return "inline_video";
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        com.baidu.swan.apps.r.e.b.a a = com.baidu.swan.apps.w.a.RX().a(invoker, this.aXf);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.i("【InlineFactory】", "Factory 「Hash:" + hashCode() + "」 is creating inline player「Hash:" + a.hashCode() + "」");
        }
        return new a(a);
    }
}
