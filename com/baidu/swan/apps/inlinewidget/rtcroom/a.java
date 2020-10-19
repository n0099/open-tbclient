package com.baidu.swan.apps.inlinewidget.rtcroom;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.a.f;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.a.g;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.a.h;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.a.i;
import com.baidu.swan.apps.inlinewidget.rtcroom.c.a;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes10.dex */
public class a extends com.baidu.swan.apps.inlinewidget.b<com.baidu.swan.apps.inlinewidget.rtcroom.c.a> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull com.baidu.swan.apps.inlinewidget.rtcroom.c.a aVar) {
        super(aVar);
        arp();
        this.cHx.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.d());
        this.cHx.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.e());
        this.cHx.a(new f());
        this.cHx.a(new g());
        this.cHx.a(new h());
        this.cHx.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.a());
        this.cHx.a(new i());
        this.cHx.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.b());
        this.cHx.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.c());
    }

    @Override // com.baidu.swan.apps.inlinewidget.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str = command == null ? "" : command.what;
        if (((com.baidu.swan.apps.inlinewidget.rtcroom.c.a) this.cHz).VG()) {
            com.baidu.swan.apps.console.c.i("InlineRtcItemController", "isReleased command：" + str);
            return;
        }
        com.baidu.swan.apps.console.c.i("InlineRtcItemController", "authorize type：" + ((com.baidu.swan.apps.inlinewidget.rtcroom.c.a) this.cHz).ary() + " command：" + str);
        super.sendCommand(command);
    }

    private void arp() {
        ((com.baidu.swan.apps.inlinewidget.rtcroom.c.a) this.cHz).a(new a.InterfaceC0422a() { // from class: com.baidu.swan.apps.inlinewidget.rtcroom.a.1
        });
    }
}
