package com.baidu.swan.apps.inlinewidget.rtcroom;

import android.support.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes10.dex */
public class c implements ZeusPluginFactory {
    private String cqC;

    public c(@NonNull String str) {
        this.cqC = str;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        return "swan_rtc_item";
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        com.baidu.swan.apps.inlinewidget.rtcroom.c.a d = com.baidu.swan.apps.t.a.auO().d(invoker, this.cqC);
        com.baidu.swan.apps.console.c.i("【RtcItemPluginFactory】", "Factory 「Hash:" + hashCode() + "」 is creating inline RtcItem「Hash:" + d.hashCode() + "」");
        return new a(d);
    }
}
