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
        awj();
        this.deT.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.d());
        this.deT.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.e());
        this.deT.a(new f());
        this.deT.a(new g());
        this.deT.a(new h());
        this.deT.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.a());
        this.deT.a(new i());
        this.deT.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.b());
        this.deT.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.c());
    }

    @Override // com.baidu.swan.apps.inlinewidget.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str = command == null ? "" : command.what;
        if (((com.baidu.swan.apps.inlinewidget.rtcroom.c.a) this.deV).isReleased()) {
            com.baidu.swan.apps.console.c.i("InlineRtcItemController", "isReleased command：" + str);
            return;
        }
        com.baidu.swan.apps.console.c.i("InlineRtcItemController", "authorize type：" + ((com.baidu.swan.apps.inlinewidget.rtcroom.c.a) this.deV).aws() + " command：" + str);
        super.sendCommand(command);
    }

    private void awj() {
        ((com.baidu.swan.apps.inlinewidget.rtcroom.c.a) this.deV).a(new a.InterfaceC0436a() { // from class: com.baidu.swan.apps.inlinewidget.rtcroom.a.1
        });
    }
}
