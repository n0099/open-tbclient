package com.baidu.swan.apps.inlinewidget.rtcroom;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.b.aa;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.b.ab;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.b.ac;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.b.ad;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.b.ae;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.b.af;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.b.ag;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.b.f;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.b.g;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.b.h;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.b.i;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.b.j;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.b.k;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.b.l;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.b.m;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.b.n;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.b.o;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.b.p;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.b.q;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.b.r;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.b.s;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.b.t;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.b.u;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.b.v;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.b.w;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.b.x;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.b.y;
import com.baidu.swan.apps.inlinewidget.rtcroom.a.b.z;
import com.baidu.swan.apps.inlinewidget.rtcroom.c.b;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes10.dex */
public class b extends com.baidu.swan.apps.inlinewidget.b<com.baidu.swan.apps.inlinewidget.rtcroom.c.b> {
    private b.a cWq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull com.baidu.swan.apps.inlinewidget.rtcroom.c.b bVar) {
        super(bVar);
        this.cWq = new b.a() { // from class: com.baidu.swan.apps.inlinewidget.rtcroom.b.1
        };
        bVar.a(this.cWq);
        this.cVM.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.b.a());
        this.cVM.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.b.b());
        this.cVM.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.b.c());
        this.cVM.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.b.e());
        this.cVM.a(new g());
        this.cVM.a(new h());
        this.cVM.a(new i());
        this.cVM.a(new j());
        this.cVM.a(new k());
        this.cVM.a(new l());
        this.cVM.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.b.d());
        this.cVM.a(new f());
        this.cVM.a(new m());
        this.cVM.a(new n());
        this.cVM.a(new o());
        this.cVM.a(new q());
        this.cVM.a(new p());
        this.cVM.a(new r());
        this.cVM.a(new s());
        this.cVM.a(new t());
        this.cVM.a(new u());
        this.cVM.a(new v());
        this.cVM.a(new w());
        this.cVM.a(new x());
        this.cVM.a(new y());
        this.cVM.a(new z());
        this.cVM.a(new aa());
        this.cVM.a(new ab());
        this.cVM.a(new ac());
        this.cVM.a(new ad());
        this.cVM.a(new ae());
        this.cVM.a(new ag());
        this.cVM.a(new af());
    }

    @Override // com.baidu.swan.apps.inlinewidget.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str = command == null ? "" : command.what;
        if (((com.baidu.swan.apps.inlinewidget.rtcroom.c.b) this.cVO).ZZ()) {
            com.baidu.swan.apps.console.c.i("InlineRtcRoomController", "isReleased command：" + str);
            return;
        }
        com.baidu.swan.apps.console.c.i("InlineRtcRoomController", "authorize type：" + ((com.baidu.swan.apps.inlinewidget.rtcroom.c.b) this.cVO).avT() + " command：" + str);
        super.sendCommand(command);
    }
}
