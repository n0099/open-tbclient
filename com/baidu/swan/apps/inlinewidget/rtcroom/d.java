package com.baidu.swan.apps.inlinewidget.rtcroom;

import android.support.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes10.dex */
public class d implements ZeusPluginFactory {
    private String cwA;

    public d(@NonNull String str) {
        this.cwA = str;
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public String name() {
        return "swan_rtc_room";
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        com.baidu.swan.apps.inlinewidget.rtcroom.c.b c = com.baidu.swan.apps.t.a.axo().c(invoker, this.cwA);
        com.baidu.swan.apps.console.c.i("【RtcRoomPluginFactory】", "Factory 「Hash:" + hashCode() + "」 is creating inline RtcRoom「Hash:" + c.hashCode() + "」");
        return new b(c);
    }
}
