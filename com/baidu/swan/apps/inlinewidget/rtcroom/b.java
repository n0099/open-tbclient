package com.baidu.swan.apps.inlinewidget.rtcroom;

import androidx.annotation.NonNull;
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
/* loaded from: classes8.dex */
public class b extends com.baidu.swan.apps.inlinewidget.b<com.baidu.swan.apps.inlinewidget.rtcroom.c.b> {
    private b.a dbI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull com.baidu.swan.apps.inlinewidget.rtcroom.c.b bVar) {
        super(bVar);
        this.dbI = new b.a() { // from class: com.baidu.swan.apps.inlinewidget.rtcroom.b.1
        };
        bVar.a(this.dbI);
        this.dbe.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.b.a());
        this.dbe.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.b.b());
        this.dbe.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.b.c());
        this.dbe.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.b.e());
        this.dbe.a(new g());
        this.dbe.a(new h());
        this.dbe.a(new i());
        this.dbe.a(new j());
        this.dbe.a(new k());
        this.dbe.a(new l());
        this.dbe.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.b.d());
        this.dbe.a(new f());
        this.dbe.a(new m());
        this.dbe.a(new n());
        this.dbe.a(new o());
        this.dbe.a(new q());
        this.dbe.a(new p());
        this.dbe.a(new r());
        this.dbe.a(new s());
        this.dbe.a(new t());
        this.dbe.a(new u());
        this.dbe.a(new v());
        this.dbe.a(new w());
        this.dbe.a(new x());
        this.dbe.a(new y());
        this.dbe.a(new z());
        this.dbe.a(new aa());
        this.dbe.a(new ab());
        this.dbe.a(new ac());
        this.dbe.a(new ad());
        this.dbe.a(new ae());
        this.dbe.a(new ag());
        this.dbe.a(new af());
    }

    @Override // com.baidu.swan.apps.inlinewidget.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str = command == null ? "" : command.what;
        if (((com.baidu.swan.apps.inlinewidget.rtcroom.c.b) this.dbg).ZP()) {
            com.baidu.swan.apps.console.c.i("InlineRtcRoomController", "isReleased command：" + str);
            return;
        }
        com.baidu.swan.apps.console.c.i("InlineRtcRoomController", "authorize type：" + ((com.baidu.swan.apps.inlinewidget.rtcroom.c.b) this.dbg).avR() + " command：" + str);
        super.sendCommand(command);
    }
}
