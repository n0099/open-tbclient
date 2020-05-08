package com.baidu.swan.apps.r.e;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.r.e.a.c;
import com.baidu.swan.apps.r.e.a.d;
import com.baidu.swan.apps.r.e.a.e;
import com.baidu.swan.apps.r.e.a.f;
import com.baidu.swan.apps.r.e.a.g;
import com.baidu.swan.apps.r.e.a.h;
import com.baidu.swan.apps.r.e.a.i;
import com.baidu.swan.apps.r.e.a.j;
import com.baidu.swan.apps.r.e.a.k;
import com.baidu.swan.apps.r.e.a.l;
import com.baidu.swan.apps.r.e.a.m;
import com.baidu.swan.apps.r.e.a.n;
import com.baidu.swan.apps.r.e.a.o;
import com.baidu.swan.apps.r.e.a.p;
import com.baidu.swan.apps.r.e.a.q;
import com.baidu.swan.apps.r.e.a.r;
import com.baidu.swan.apps.r.e.a.s;
import com.baidu.swan.apps.r.e.b.a;
/* loaded from: classes11.dex */
final class a extends com.baidu.swan.apps.r.b<com.baidu.swan.apps.r.e.b.a> {
    private final a.InterfaceC0328a bVG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull com.baidu.swan.apps.r.e.b.a aVar) {
        super(aVar);
        this.bVG = new a.InterfaceC0328a() { // from class: com.baidu.swan.apps.r.e.a.1
            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0328a
            public void onPrepared() {
                if (a.this.bUS != null) {
                    a.this.bUS.onCallback(a.this, "onPrepared", null);
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0328a
            public void onPlayed() {
                if (a.this.bUS != null) {
                    a.this.bUS.onCallback(a.this, "onPlayed", null);
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0328a
            public void onPaused() {
                if (a.this.bUS != null) {
                    a.this.bUS.onCallback(a.this, "onPaused", null);
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0328a
            public void onEnded() {
                if (a.this.bUS != null) {
                    a.this.bUS.onCallback(a.this, "onEnded", null);
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0328a
            public void onError(int i) {
                if (a.this.bUS != null) {
                    a.this.bUS.onCallback(a.this, "onError", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0328a
            public void fi(int i) {
                if (a.this.bUS != null) {
                    a.this.bUS.onCallback(a.this, "onInfo", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0328a
            public void abw() {
                if (a.this.bUS != null) {
                    a.this.bUS.onCallback(a.this, "onVideoSizeChanged", null);
                }
            }
        };
        aVar.a(this.bVG);
        this.bUR.a(new com.baidu.swan.apps.r.e.a.a());
        this.bUR.a(new com.baidu.swan.apps.r.e.a.b());
        this.bUR.a(new c());
        this.bUR.a(new d());
        this.bUR.a(new e());
        this.bUR.a(new f());
        this.bUR.a(new g());
        this.bUR.a(new h());
        this.bUR.a(new j());
        this.bUR.a(new k());
        this.bUR.a(new l());
        this.bUR.a(new m());
        this.bUR.a(new o());
        this.bUR.a(new p());
        this.bUR.a(new q());
        this.bUR.a(new r());
        this.bUR.a(new s());
        this.bUR.a(new n());
        this.bUR.a(new i());
    }
}
