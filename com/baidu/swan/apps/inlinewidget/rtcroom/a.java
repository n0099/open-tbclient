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
        atk();
        this.cPT.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.d());
        this.cPT.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.e());
        this.cPT.a(new f());
        this.cPT.a(new g());
        this.cPT.a(new h());
        this.cPT.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.a());
        this.cPT.a(new i());
        this.cPT.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.b());
        this.cPT.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.c());
    }

    @Override // com.baidu.swan.apps.inlinewidget.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str = command == null ? "" : command.what;
        if (((com.baidu.swan.apps.inlinewidget.rtcroom.c.a) this.cPV).XA()) {
            com.baidu.swan.apps.console.c.i("InlineRtcItemController", "isReleased command：" + str);
            return;
        }
        com.baidu.swan.apps.console.c.i("InlineRtcItemController", "authorize type：" + ((com.baidu.swan.apps.inlinewidget.rtcroom.c.a) this.cPV).att() + " command：" + str);
        super.sendCommand(command);
    }

    private void atk() {
        ((com.baidu.swan.apps.inlinewidget.rtcroom.c.a) this.cPV).a(new a.InterfaceC0436a() { // from class: com.baidu.swan.apps.inlinewidget.rtcroom.a.1
        });
    }
}
