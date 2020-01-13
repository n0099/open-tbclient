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
/* loaded from: classes10.dex */
final class a extends com.baidu.swan.apps.r.b<com.baidu.swan.apps.r.e.b.a> {
    private final a.InterfaceC0267a bsW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull com.baidu.swan.apps.r.e.b.a aVar) {
        super(aVar);
        this.bsW = new a.InterfaceC0267a() { // from class: com.baidu.swan.apps.r.e.a.1
            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0267a
            public void onPrepared() {
                if (a.this.bsi != null) {
                    a.this.bsi.onCallback(a.this, "onPrepared", null);
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0267a
            public void onPlayed() {
                if (a.this.bsi != null) {
                    a.this.bsi.onCallback(a.this, "onPlayed", null);
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0267a
            public void onPaused() {
                if (a.this.bsi != null) {
                    a.this.bsi.onCallback(a.this, "onPaused", null);
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0267a
            public void onEnded() {
                if (a.this.bsi != null) {
                    a.this.bsi.onCallback(a.this, "onEnded", null);
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0267a
            public void onError(int i) {
                if (a.this.bsi != null) {
                    a.this.bsi.onCallback(a.this, "onError", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0267a
            public void eN(int i) {
                if (a.this.bsi != null) {
                    a.this.bsi.onCallback(a.this, "onInfo", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0267a
            public void Rp() {
                if (a.this.bsi != null) {
                    a.this.bsi.onCallback(a.this, "onVideoSizeChanged", null);
                }
            }
        };
        aVar.a(this.bsW);
        this.bsh.a(new com.baidu.swan.apps.r.e.a.a());
        this.bsh.a(new com.baidu.swan.apps.r.e.a.b());
        this.bsh.a(new c());
        this.bsh.a(new d());
        this.bsh.a(new e());
        this.bsh.a(new f());
        this.bsh.a(new g());
        this.bsh.a(new h());
        this.bsh.a(new j());
        this.bsh.a(new k());
        this.bsh.a(new l());
        this.bsh.a(new m());
        this.bsh.a(new o());
        this.bsh.a(new p());
        this.bsh.a(new q());
        this.bsh.a(new r());
        this.bsh.a(new s());
        this.bsh.a(new n());
        this.bsh.a(new i());
    }
}
