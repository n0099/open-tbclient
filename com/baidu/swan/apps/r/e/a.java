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
    private final a.InterfaceC0277a bxi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull com.baidu.swan.apps.r.e.b.a aVar) {
        super(aVar);
        this.bxi = new a.InterfaceC0277a() { // from class: com.baidu.swan.apps.r.e.a.1
            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0277a
            public void onPrepared() {
                if (a.this.bwu != null) {
                    a.this.bwu.onCallback(a.this, "onPrepared", null);
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0277a
            public void onPlayed() {
                if (a.this.bwu != null) {
                    a.this.bwu.onCallback(a.this, "onPlayed", null);
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0277a
            public void onPaused() {
                if (a.this.bwu != null) {
                    a.this.bwu.onCallback(a.this, "onPaused", null);
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0277a
            public void onEnded() {
                if (a.this.bwu != null) {
                    a.this.bwu.onCallback(a.this, "onEnded", null);
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0277a
            public void onError(int i) {
                if (a.this.bwu != null) {
                    a.this.bwu.onCallback(a.this, "onError", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0277a
            public void fd(int i) {
                if (a.this.bwu != null) {
                    a.this.bwu.onCallback(a.this, "onInfo", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0277a
            public void TF() {
                if (a.this.bwu != null) {
                    a.this.bwu.onCallback(a.this, "onVideoSizeChanged", null);
                }
            }
        };
        aVar.a(this.bxi);
        this.bwt.a(new com.baidu.swan.apps.r.e.a.a());
        this.bwt.a(new com.baidu.swan.apps.r.e.a.b());
        this.bwt.a(new c());
        this.bwt.a(new d());
        this.bwt.a(new e());
        this.bwt.a(new f());
        this.bwt.a(new g());
        this.bwt.a(new h());
        this.bwt.a(new j());
        this.bwt.a(new k());
        this.bwt.a(new l());
        this.bwt.a(new m());
        this.bwt.a(new o());
        this.bwt.a(new p());
        this.bwt.a(new q());
        this.bwt.a(new r());
        this.bwt.a(new s());
        this.bwt.a(new n());
        this.bwt.a(new i());
    }
}
