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
/* loaded from: classes25.dex */
public class b extends com.baidu.swan.apps.inlinewidget.b<com.baidu.swan.apps.inlinewidget.rtcroom.c.b> {
    private b.a dbC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull com.baidu.swan.apps.inlinewidget.rtcroom.c.b bVar) {
        super(bVar);
        this.dbC = new b.a() { // from class: com.baidu.swan.apps.inlinewidget.rtcroom.b.1
        };
        bVar.a(this.dbC);
        this.daY.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.b.a());
        this.daY.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.b.b());
        this.daY.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.b.c());
        this.daY.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.b.e());
        this.daY.a(new g());
        this.daY.a(new h());
        this.daY.a(new i());
        this.daY.a(new j());
        this.daY.a(new k());
        this.daY.a(new l());
        this.daY.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.b.d());
        this.daY.a(new f());
        this.daY.a(new m());
        this.daY.a(new n());
        this.daY.a(new o());
        this.daY.a(new q());
        this.daY.a(new p());
        this.daY.a(new r());
        this.daY.a(new s());
        this.daY.a(new t());
        this.daY.a(new u());
        this.daY.a(new v());
        this.daY.a(new w());
        this.daY.a(new x());
        this.daY.a(new y());
        this.daY.a(new z());
        this.daY.a(new aa());
        this.daY.a(new ab());
        this.daY.a(new ac());
        this.daY.a(new ad());
        this.daY.a(new ae());
        this.daY.a(new ag());
        this.daY.a(new af());
    }

    @Override // com.baidu.swan.apps.inlinewidget.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str = command == null ? "" : command.what;
        if (((com.baidu.swan.apps.inlinewidget.rtcroom.c.b) this.dba).abU()) {
            com.baidu.swan.apps.console.c.i("InlineRtcRoomController", "isReleased command：" + str);
            return;
        }
        com.baidu.swan.apps.console.c.i("InlineRtcRoomController", "authorize type：" + ((com.baidu.swan.apps.inlinewidget.rtcroom.c.b) this.dba).ayt() + " command：" + str);
        super.sendCommand(command);
    }
}
