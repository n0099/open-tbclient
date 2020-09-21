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
/* loaded from: classes3.dex */
public class b extends com.baidu.swan.apps.inlinewidget.b<com.baidu.swan.apps.inlinewidget.rtcroom.c.b> {
    private b.a cvU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull com.baidu.swan.apps.inlinewidget.rtcroom.c.b bVar) {
        super(bVar);
        this.cvU = new b.a() { // from class: com.baidu.swan.apps.inlinewidget.rtcroom.b.1
        };
        bVar.a(this.cvU);
        this.cvq.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.b.a());
        this.cvq.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.b.b());
        this.cvq.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.b.c());
        this.cvq.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.b.e());
        this.cvq.a(new g());
        this.cvq.a(new h());
        this.cvq.a(new i());
        this.cvq.a(new j());
        this.cvq.a(new k());
        this.cvq.a(new l());
        this.cvq.a(new com.baidu.swan.apps.inlinewidget.rtcroom.a.b.d());
        this.cvq.a(new f());
        this.cvq.a(new m());
        this.cvq.a(new n());
        this.cvq.a(new o());
        this.cvq.a(new q());
        this.cvq.a(new p());
        this.cvq.a(new r());
        this.cvq.a(new s());
        this.cvq.a(new t());
        this.cvq.a(new u());
        this.cvq.a(new v());
        this.cvq.a(new w());
        this.cvq.a(new x());
        this.cvq.a(new y());
        this.cvq.a(new z());
        this.cvq.a(new aa());
        this.cvq.a(new ab());
        this.cvq.a(new ac());
        this.cvq.a(new ad());
        this.cvq.a(new ae());
        this.cvq.a(new ag());
        this.cvq.a(new af());
    }

    @Override // com.baidu.swan.apps.inlinewidget.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str = command == null ? "" : command.what;
        if (((com.baidu.swan.apps.inlinewidget.rtcroom.c.b) this.cvs).TN()) {
            com.baidu.swan.apps.console.c.i("InlineRtcRoomController", "isReleased command：" + str);
            return;
        }
        com.baidu.swan.apps.console.c.i("InlineRtcRoomController", "authorize type：" + ((com.baidu.swan.apps.inlinewidget.rtcroom.c.b) this.cvs).aoM() + " command：" + str);
        super.sendCommand(command);
    }
}
