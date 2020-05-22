package com.baidu.swan.apps.p.e;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.api.module.k.h;
import com.baidu.swan.apps.p.e.a.e;
import com.baidu.swan.apps.p.e.a.f;
import com.baidu.swan.apps.p.e.a.g;
import com.baidu.swan.apps.p.e.a.i;
import com.baidu.swan.apps.p.e.a.j;
import com.baidu.swan.apps.p.e.a.k;
import com.baidu.swan.apps.p.e.a.l;
import com.baidu.swan.apps.p.e.a.m;
import com.baidu.swan.apps.p.e.a.n;
import com.baidu.swan.apps.p.e.a.o;
import com.baidu.swan.apps.p.e.a.p;
import com.baidu.swan.apps.p.e.a.q;
import com.baidu.swan.apps.p.e.a.s;
import com.baidu.swan.apps.p.e.a.t;
import com.baidu.swan.apps.p.e.b.a;
/* loaded from: classes11.dex */
final class b extends com.baidu.swan.apps.p.b<com.baidu.swan.apps.p.e.b.a> {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final a.InterfaceC0364a cfX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull com.baidu.swan.apps.p.e.b.a aVar) {
        super(aVar);
        this.cfX = new a.InterfaceC0364a() { // from class: com.baidu.swan.apps.p.e.b.1
            @Override // com.baidu.swan.apps.p.e.b.a.InterfaceC0364a
            public void onPrepared() {
                if (b.this.cfi != null) {
                    b.this.cfi.onCallback(b.this, "onPrepared", null);
                }
            }

            @Override // com.baidu.swan.apps.p.e.b.a.InterfaceC0364a
            public void kz(String str) {
                if (b.this.cfi != null) {
                    b.this.cfi.onCallback(b.this, "onPlayed", null);
                }
                h.Uv().B(str, true);
                h.Uv().im(str);
            }

            @Override // com.baidu.swan.apps.p.e.b.a.InterfaceC0364a
            public void kA(String str) {
                if (b.this.cfi != null) {
                    b.this.cfi.onCallback(b.this, "onPaused", null);
                }
                if (!TextUtils.isEmpty(str)) {
                    h.Uv().B(str, false);
                }
            }

            @Override // com.baidu.swan.apps.p.e.b.a.InterfaceC0364a
            public void onEnded() {
                if (b.this.cfi != null) {
                    b.this.cfi.onCallback(b.this, "onEnded", null);
                }
            }

            @Override // com.baidu.swan.apps.p.e.b.a.InterfaceC0364a
            public void onError(int i) {
                if (b.this.cfi != null) {
                    b.this.cfi.onCallback(b.this, "onError", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.p.e.b.a.InterfaceC0364a
            public void ft(int i) {
                if (b.this.cfi != null) {
                    b.this.cfi.onCallback(b.this, "onInfo", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.p.e.b.a.InterfaceC0364a
            public void aex() {
                if (b.this.cfi != null) {
                    b.this.cfi.onCallback(b.this, "onVideoSizeChanged", null);
                }
            }

            @Override // com.baidu.swan.apps.p.e.b.a.InterfaceC0364a
            public void onStateChange(int i) {
                if (b.this.cfi != null) {
                    b.this.cfi.onCallback(b.this, "onStateChange", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.p.e.b.a.InterfaceC0364a
            public void kB(@NonNull String str) {
                if (b.this.cfi != null) {
                    b.this.cfi.onCallback(b.this, "onNetStatus", str);
                }
            }

            @Override // com.baidu.swan.apps.p.e.b.a.InterfaceC0364a
            public void eV(String str) {
                if (b.DEBUG) {
                    Log.i("InlineVideoController", "onRelease: " + str);
                }
                h.Uv().ik(str);
            }
        };
        aVar.a(this.cfX);
        h.Uv().a(aVar);
        this.cfh.a(new com.baidu.swan.apps.p.e.a.a());
        this.cfh.a(new com.baidu.swan.apps.p.e.a.b());
        this.cfh.a(new com.baidu.swan.apps.p.e.a.c());
        this.cfh.a(new com.baidu.swan.apps.p.e.a.d());
        this.cfh.a(new e());
        this.cfh.a(new f());
        this.cfh.a(new g());
        this.cfh.a(new com.baidu.swan.apps.p.e.a.h());
        this.cfh.a(new j());
        this.cfh.a(new k());
        this.cfh.a(new l());
        this.cfh.a(new m());
        this.cfh.a(new o());
        this.cfh.a(new p());
        this.cfh.a(new q());
        this.cfh.a(new s());
        this.cfh.a(new t());
        this.cfh.a(new n());
        this.cfh.a(new i());
    }
}
