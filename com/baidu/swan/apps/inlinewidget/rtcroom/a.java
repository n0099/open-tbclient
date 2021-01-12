package com.baidu.swan.apps.inlinewidget.rtcroom;

import androidx.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.a.f;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.a.g;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.a.h;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.a.i;
import com.baidu.swan.apps.inlinewidget.rtcroom.c.a;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes8.dex */
public class a extends com.baidu.swan.apps.inlinewidget.b<com.baidu.swan.apps.inlinewidget.rtcroom.c.a> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull com.baidu.swan.apps.inlinewidget.rtcroom.c.a aVar) {
        super(aVar);
        avI();
        this.dbe.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.d());
        this.dbe.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.e());
        this.dbe.a(new f());
        this.dbe.a(new g());
        this.dbe.a(new h());
        this.dbe.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.a());
        this.dbe.a(new i());
        this.dbe.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.b());
        this.dbe.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.c());
    }

    @Override // com.baidu.swan.apps.inlinewidget.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str = command == null ? "" : command.what;
        if (((com.baidu.swan.apps.inlinewidget.rtcroom.c.a) this.dbg).ZP()) {
            com.baidu.swan.apps.console.c.i("InlineRtcItemController", "isReleased command：" + str);
            return;
        }
        com.baidu.swan.apps.console.c.i("InlineRtcItemController", "authorize type：" + ((com.baidu.swan.apps.inlinewidget.rtcroom.c.a) this.dbg).avR() + " command：" + str);
        super.sendCommand(command);
    }

    private void avI() {
        ((com.baidu.swan.apps.inlinewidget.rtcroom.c.a) this.dbg).a(new a.InterfaceC0433a() { // from class: com.baidu.swan.apps.inlinewidget.rtcroom.a.1
        });
    }
}
