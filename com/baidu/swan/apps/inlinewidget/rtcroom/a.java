package com.baidu.swan.apps.inlinewidget.rtcroom;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.a.f;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.a.g;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.a.h;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.a.i;
import com.baidu.swan.apps.inlinewidget.rtcroom.c.a;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes25.dex */
public class a extends com.baidu.swan.apps.inlinewidget.b<com.baidu.swan.apps.inlinewidget.rtcroom.c.a> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull com.baidu.swan.apps.inlinewidget.rtcroom.c.a aVar) {
        super(aVar);
        ayk();
        this.daY.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.d());
        this.daY.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.e());
        this.daY.a(new f());
        this.daY.a(new g());
        this.daY.a(new h());
        this.daY.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.a());
        this.daY.a(new i());
        this.daY.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.b());
        this.daY.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.c());
    }

    @Override // com.baidu.swan.apps.inlinewidget.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str = command == null ? "" : command.what;
        if (((com.baidu.swan.apps.inlinewidget.rtcroom.c.a) this.dba).abU()) {
            com.baidu.swan.apps.console.c.i("InlineRtcItemController", "isReleased command：" + str);
            return;
        }
        com.baidu.swan.apps.console.c.i("InlineRtcItemController", "authorize type：" + ((com.baidu.swan.apps.inlinewidget.rtcroom.c.a) this.dba).ayt() + " command：" + str);
        super.sendCommand(command);
    }

    private void ayk() {
        ((com.baidu.swan.apps.inlinewidget.rtcroom.c.a) this.dba).a(new a.InterfaceC0458a() { // from class: com.baidu.swan.apps.inlinewidget.rtcroom.a.1
        });
    }
}
