package com.baidu.swan.apps.inlinewidget.rtcroom;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.a.f;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.a.g;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.a.h;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.a.i;
import com.baidu.swan.apps.inlinewidget.rtcroom.c.a;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes3.dex */
public class a extends com.baidu.swan.apps.inlinewidget.b<com.baidu.swan.apps.inlinewidget.rtcroom.c.a> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull com.baidu.swan.apps.inlinewidget.rtcroom.c.a aVar) {
        super(aVar);
        aoD();
        this.cvq.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.d());
        this.cvq.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.e());
        this.cvq.a(new f());
        this.cvq.a(new g());
        this.cvq.a(new h());
        this.cvq.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.a());
        this.cvq.a(new i());
        this.cvq.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.b());
        this.cvq.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.a.c());
    }

    @Override // com.baidu.swan.apps.inlinewidget.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str = command == null ? "" : command.what;
        if (((com.baidu.swan.apps.inlinewidget.rtcroom.c.a) this.cvs).TN()) {
            com.baidu.swan.apps.console.c.i("InlineRtcItemController", "isReleased command：" + str);
            return;
        }
        com.baidu.swan.apps.console.c.i("InlineRtcItemController", "authorize type：" + ((com.baidu.swan.apps.inlinewidget.rtcroom.c.a) this.cvs).aoM() + " command：" + str);
        super.sendCommand(command);
    }

    private void aoD() {
        ((com.baidu.swan.apps.inlinewidget.rtcroom.c.a) this.cvs).a(new a.InterfaceC0405a() { // from class: com.baidu.swan.apps.inlinewidget.rtcroom.a.1
        });
    }
}
