package com.baidu.swan.apps.r.c;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes11.dex */
public class b implements ZeusPluginFactory {
    private String bcj;

    public b(@NonNull String str) {
        this.bcj = str;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        return "swan_textarea";
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        c cVar = new c(invoker, this.bcj);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.i(" [[InlineTextAreaFactory]] ", "Factory 「Hash:" + hashCode() + "」 is creating inline textArea「Hash:" + cVar.hashCode() + "」");
        }
        return new a(cVar);
    }
}
