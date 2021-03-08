package com.baidu.swan.apps.inlinewidget.f;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes8.dex */
public class d implements ZeusPluginFactory {
    private String cFI;

    public d(@NonNull String str) {
        this.cFI = str;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        return "inline_video";
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        com.baidu.swan.apps.inlinewidget.f.c.a a2 = com.baidu.swan.apps.t.a.axN().a(invoker, this.cFI);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.i("【InlineFactory】", "Factory 「Hash:" + hashCode() + "」 is creating inline video「Hash:" + a2.hashCode() + "」");
        }
        return new b(a2);
    }
}
