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
    private final a.InterfaceC0277a bxu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull com.baidu.swan.apps.r.e.b.a aVar) {
        super(aVar);
        this.bxu = new a.InterfaceC0277a() { // from class: com.baidu.swan.apps.r.e.a.1
            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0277a
            public void onPrepared() {
                if (a.this.bwG != null) {
                    a.this.bwG.onCallback(a.this, "onPrepared", null);
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0277a
            public void onPlayed() {
                if (a.this.bwG != null) {
                    a.this.bwG.onCallback(a.this, "onPlayed", null);
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0277a
            public void onPaused() {
                if (a.this.bwG != null) {
                    a.this.bwG.onCallback(a.this, "onPaused", null);
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0277a
            public void onEnded() {
                if (a.this.bwG != null) {
                    a.this.bwG.onCallback(a.this, "onEnded", null);
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0277a
            public void onError(int i) {
                if (a.this.bwG != null) {
                    a.this.bwG.onCallback(a.this, "onError", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0277a
            public void fd(int i) {
                if (a.this.bwG != null) {
                    a.this.bwG.onCallback(a.this, "onInfo", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0277a
            public void TI() {
                if (a.this.bwG != null) {
                    a.this.bwG.onCallback(a.this, "onVideoSizeChanged", null);
                }
            }
        };
        aVar.a(this.bxu);
        this.bwF.a(new com.baidu.swan.apps.r.e.a.a());
        this.bwF.a(new com.baidu.swan.apps.r.e.a.b());
        this.bwF.a(new c());
        this.bwF.a(new d());
        this.bwF.a(new e());
        this.bwF.a(new f());
        this.bwF.a(new g());
        this.bwF.a(new h());
        this.bwF.a(new j());
        this.bwF.a(new k());
        this.bwF.a(new l());
        this.bwF.a(new m());
        this.bwF.a(new o());
        this.bwF.a(new p());
        this.bwF.a(new q());
        this.bwF.a(new r());
        this.bwF.a(new s());
        this.bwF.a(new n());
        this.bwF.a(new i());
    }
}
