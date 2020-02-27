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
    private final a.InterfaceC0277a bxg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull com.baidu.swan.apps.r.e.b.a aVar) {
        super(aVar);
        this.bxg = new a.InterfaceC0277a() { // from class: com.baidu.swan.apps.r.e.a.1
            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0277a
            public void onPrepared() {
                if (a.this.bws != null) {
                    a.this.bws.onCallback(a.this, "onPrepared", null);
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0277a
            public void onPlayed() {
                if (a.this.bws != null) {
                    a.this.bws.onCallback(a.this, "onPlayed", null);
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0277a
            public void onPaused() {
                if (a.this.bws != null) {
                    a.this.bws.onCallback(a.this, "onPaused", null);
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0277a
            public void onEnded() {
                if (a.this.bws != null) {
                    a.this.bws.onCallback(a.this, "onEnded", null);
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0277a
            public void onError(int i) {
                if (a.this.bws != null) {
                    a.this.bws.onCallback(a.this, "onError", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0277a
            public void fd(int i) {
                if (a.this.bws != null) {
                    a.this.bws.onCallback(a.this, "onInfo", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.r.e.b.a.InterfaceC0277a
            public void TD() {
                if (a.this.bws != null) {
                    a.this.bws.onCallback(a.this, "onVideoSizeChanged", null);
                }
            }
        };
        aVar.a(this.bxg);
        this.bwr.a(new com.baidu.swan.apps.r.e.a.a());
        this.bwr.a(new com.baidu.swan.apps.r.e.a.b());
        this.bwr.a(new c());
        this.bwr.a(new d());
        this.bwr.a(new e());
        this.bwr.a(new f());
        this.bwr.a(new g());
        this.bwr.a(new h());
        this.bwr.a(new j());
        this.bwr.a(new k());
        this.bwr.a(new l());
        this.bwr.a(new m());
        this.bwr.a(new o());
        this.bwr.a(new p());
        this.bwr.a(new q());
        this.bwr.a(new r());
        this.bwr.a(new s());
        this.bwr.a(new n());
        this.bwr.a(new i());
    }
}
