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
    private final a.InterfaceC0277a bxh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull com.baidu.swan.apps.r.e.b.a aVar) {
        super(aVar);
        this.bxh = new a.InterfaceC0277a() { // from class: com.baidu.swan.apps.r.e.a.1
            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0277a
            public void onPrepared() {
                if (a.this.bwt != null) {
                    a.this.bwt.onCallback(a.this, "onPrepared", null);
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0277a
            public void onPlayed() {
                if (a.this.bwt != null) {
                    a.this.bwt.onCallback(a.this, "onPlayed", null);
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0277a
            public void onPaused() {
                if (a.this.bwt != null) {
                    a.this.bwt.onCallback(a.this, "onPaused", null);
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0277a
            public void onEnded() {
                if (a.this.bwt != null) {
                    a.this.bwt.onCallback(a.this, "onEnded", null);
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0277a
            public void onError(int i) {
                if (a.this.bwt != null) {
                    a.this.bwt.onCallback(a.this, "onError", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0277a
            public void fd(int i) {
                if (a.this.bwt != null) {
                    a.this.bwt.onCallback(a.this, "onInfo", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0277a
            public void TF() {
                if (a.this.bwt != null) {
                    a.this.bwt.onCallback(a.this, "onVideoSizeChanged", null);
                }
            }
        };
        aVar.a(this.bxh);
        this.bws.a(new com.baidu.swan.apps.r.e.a.a());
        this.bws.a(new com.baidu.swan.apps.r.e.a.b());
        this.bws.a(new c());
        this.bws.a(new d());
        this.bws.a(new e());
        this.bws.a(new f());
        this.bws.a(new g());
        this.bws.a(new h());
        this.bws.a(new j());
        this.bws.a(new k());
        this.bws.a(new l());
        this.bws.a(new m());
        this.bws.a(new o());
        this.bws.a(new p());
        this.bws.a(new q());
        this.bws.a(new r());
        this.bws.a(new s());
        this.bws.a(new n());
        this.bws.a(new i());
    }
}
