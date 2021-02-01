package com.baidu.swan.apps.inlinewidget.rtcroom;

import androidx.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.a.f;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.a.g;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.a.h;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.a.i;
import com.baidu.swan.apps.inlinewidget.rtcroom.c.a;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes9.dex */
public class a extends com.baidu.swan.apps.inlinewidget.b<com.baidu.swan.apps.inlinewidget.rtcroom.c.a> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull com.baidu.swan.apps.inlinewidget.rtcroom.c.a aVar) {
        super(aVar);
        awg();
        this.ddq.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.d());
        this.ddq.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.e());
        this.ddq.a(new f());
        this.ddq.a(new g());
        this.ddq.a(new h());
        this.ddq.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.a());
        this.ddq.a(new i());
        this.ddq.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.b());
        this.ddq.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.c());
    }

    @Override // com.baidu.swan.apps.inlinewidget.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str = command == null ? "" : command.what;
        if (((com.baidu.swan.apps.inlinewidget.rtcroom.c.a) this.dds).isReleased()) {
            com.baidu.swan.apps.console.c.i("InlineRtcItemController", "isReleased command：" + str);
            return;
        }
        com.baidu.swan.apps.console.c.i("InlineRtcItemController", "authorize type：" + ((com.baidu.swan.apps.inlinewidget.rtcroom.c.a) this.dds).awp() + " command：" + str);
        super.sendCommand(command);
    }

    private void awg() {
        ((com.baidu.swan.apps.inlinewidget.rtcroom.c.a) this.dds).a(new a.InterfaceC0430a() { // from class: com.baidu.swan.apps.inlinewidget.rtcroom.a.1
        });
    }
}
