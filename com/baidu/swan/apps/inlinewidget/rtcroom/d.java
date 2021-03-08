package com.baidu.swan.apps.inlinewidget.rtcroom;

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
        return "swan_rtc_room";
    }

    @Override // com.baidu.webkit.sdk.plugin.ZeusPluginFactory
    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        com.baidu.swan.apps.inlinewidget.rtcroom.c.b c = com.baidu.swan.apps.t.a.axN().c(invoker, this.cFI);
        com.baidu.swan.apps.console.c.i("【RtcRoomPluginFactory】", "Factory 「Hash:" + hashCode() + "」 is creating inline RtcRoom「Hash:" + c.hashCode() + "」");
        return new b(c);
    }
}
