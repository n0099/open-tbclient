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
/* loaded from: classes9.dex */
final class a extends com.baidu.swan.apps.r.b<com.baidu.swan.apps.r.e.b.a> {
    private final a.InterfaceC0265a bsi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull com.baidu.swan.apps.r.e.b.a aVar) {
        super(aVar);
        this.bsi = new a.InterfaceC0265a() { // from class: com.baidu.swan.apps.r.e.a.1
            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0265a
            public void onPrepared() {
                if (a.this.bru != null) {
                    a.this.bru.onCallback(a.this, "onPrepared", null);
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0265a
            public void onPlayed() {
                if (a.this.bru != null) {
                    a.this.bru.onCallback(a.this, "onPlayed", null);
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0265a
            public void onPaused() {
                if (a.this.bru != null) {
                    a.this.bru.onCallback(a.this, "onPaused", null);
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0265a
            public void onEnded() {
                if (a.this.bru != null) {
                    a.this.bru.onCallback(a.this, "onEnded", null);
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0265a
            public void onError(int i) {
                if (a.this.bru != null) {
                    a.this.bru.onCallback(a.this, "onError", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0265a
            public void eM(int i) {
                if (a.this.bru != null) {
                    a.this.bru.onCallback(a.this, "onInfo", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0265a
            public void QT() {
                if (a.this.bru != null) {
                    a.this.bru.onCallback(a.this, "onVideoSizeChanged", null);
                }
            }
        };
        aVar.a(this.bsi);
        this.brt.a(new com.baidu.swan.apps.r.e.a.a());
        this.brt.a(new com.baidu.swan.apps.r.e.a.b());
        this.brt.a(new c());
        this.brt.a(new d());
        this.brt.a(new e());
        this.brt.a(new f());
        this.brt.a(new g());
        this.brt.a(new h());
        this.brt.a(new j());
        this.brt.a(new k());
        this.brt.a(new l());
        this.brt.a(new m());
        this.brt.a(new o());
        this.brt.a(new p());
        this.brt.a(new q());
        this.brt.a(new r());
        this.brt.a(new s());
        this.brt.a(new n());
        this.brt.a(new i());
    }
}
