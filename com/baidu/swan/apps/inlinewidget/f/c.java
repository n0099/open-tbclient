package com.baidu.swan.apps.inlinewidget.f;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes9.dex */
public class c implements ZeusPluginFactory {
    private String cGy;

    public c(@NonNull String str) {
        this.cGy = str;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        return "swan_live";
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        com.baidu.swan.apps.inlinewidget.f.c.a b2 = com.baidu.swan.apps.t.a.aBg().b(invoker, this.cGy);
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.i("【InlineLiveFactory】", "Factory 「Hash:" + hashCode() + "」 is creating inline live「Hash:" + b2.hashCode() + "」");
        }
        return new a(b2);
    }
}
