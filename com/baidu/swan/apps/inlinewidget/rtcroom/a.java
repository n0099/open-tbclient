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
        azC();
        this.dfT.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.d());
        this.dfT.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.e());
        this.dfT.a(new f());
        this.dfT.a(new g());
        this.dfT.a(new h());
        this.dfT.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.a());
        this.dfT.a(new i());
        this.dfT.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.b());
        this.dfT.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.c());
    }

    @Override // com.baidu.swan.apps.inlinewidget.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str = command == null ? "" : command.what;
        if (((com.baidu.swan.apps.inlinewidget.rtcroom.c.a) this.dfV).adI()) {
            com.baidu.swan.apps.console.c.i("InlineRtcItemController", "isReleased command：" + str);
            return;
        }
        com.baidu.swan.apps.console.c.i("InlineRtcItemController", "authorize type：" + ((com.baidu.swan.apps.inlinewidget.rtcroom.c.a) this.dfV).azL() + " command：" + str);
        super.sendCommand(command);
    }

    private void azC() {
        ((com.baidu.swan.apps.inlinewidget.rtcroom.c.a) this.dfV).a(new a.InterfaceC0450a() { // from class: com.baidu.swan.apps.inlinewidget.rtcroom.a.1
        });
    }
}
