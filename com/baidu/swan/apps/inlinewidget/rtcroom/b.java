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
/* loaded from: classes8.dex */
public class b extends com.baidu.swan.apps.inlinewidget.b<com.baidu.swan.apps.inlinewidget.rtcroom.c.b> {
    private b.a ctM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull com.baidu.swan.apps.inlinewidget.rtcroom.c.b bVar) {
        super(bVar);
        this.ctM = new b.a() { // from class: com.baidu.swan.apps.inlinewidget.rtcroom.b.1
        };
        bVar.a(this.ctM);
        this.ctg.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.b.a());
        this.ctg.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.b.b());
        this.ctg.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.b.c());
        this.ctg.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.b.e());
        this.ctg.a(new g());
        this.ctg.a(new h());
        this.ctg.a(new i());
        this.ctg.a(new j());
        this.ctg.a(new k());
        this.ctg.a(new l());
        this.ctg.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.b.d());
        this.ctg.a(new f());
        this.ctg.a(new m());
        this.ctg.a(new n());
        this.ctg.a(new o());
        this.ctg.a(new q());
        this.ctg.a(new p());
        this.ctg.a(new r());
        this.ctg.a(new s());
        this.ctg.a(new t());
        this.ctg.a(new u());
        this.ctg.a(new v());
        this.ctg.a(new w());
        this.ctg.a(new x());
        this.ctg.a(new y());
        this.ctg.a(new z());
        this.ctg.a(new aa());
        this.ctg.a(new ab());
        this.ctg.a(new ac());
        this.ctg.a(new ad());
        this.ctg.a(new ae());
        this.ctg.a(new ag());
        this.ctg.a(new af());
    }

    @Override // com.baidu.swan.apps.inlinewidget.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str = command == null ? "" : command.what;
        if (((com.baidu.swan.apps.inlinewidget.rtcroom.c.b) this.cti).SW()) {
            com.baidu.swan.apps.console.c.i("InlineRtcRoomController", "isReleased command：" + str);
            return;
        }
        com.baidu.swan.apps.console.c.i("InlineRtcRoomController", "authorize type：" + ((com.baidu.swan.apps.inlinewidget.rtcroom.c.b) this.cti).aoc() + " command：" + str);
        super.sendCommand(command);
    }
}
