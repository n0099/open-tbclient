package com.baidu.swan.apps.p.f;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.api.module.k.h;
import com.baidu.swan.apps.p.f.a.e;
import com.baidu.swan.apps.p.f.a.f;
import com.baidu.swan.apps.p.f.a.g;
import com.baidu.swan.apps.p.f.a.i;
import com.baidu.swan.apps.p.f.a.j;
import com.baidu.swan.apps.p.f.a.k;
import com.baidu.swan.apps.p.f.a.l;
import com.baidu.swan.apps.p.f.a.m;
import com.baidu.swan.apps.p.f.a.n;
import com.baidu.swan.apps.p.f.a.o;
import com.baidu.swan.apps.p.f.a.p;
import com.baidu.swan.apps.p.f.a.q;
import com.baidu.swan.apps.p.f.a.s;
import com.baidu.swan.apps.p.f.a.t;
import com.baidu.swan.apps.p.f.b.a;
/* loaded from: classes7.dex */
final class b extends com.baidu.swan.apps.p.b<com.baidu.swan.apps.p.f.b.a> {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final a.InterfaceC0373a cmQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull com.baidu.swan.apps.p.f.b.a aVar) {
        super(aVar);
        this.cmQ = new a.InterfaceC0373a() { // from class: com.baidu.swan.apps.p.f.b.1
            @Override // com.baidu.swan.apps.p.f.b.a.InterfaceC0373a
            public void onPrepared() {
                if (b.this.clZ != null) {
                    b.this.clZ.onCallback(b.this, "onPrepared", null);
                }
            }

            @Override // com.baidu.swan.apps.p.f.b.a.InterfaceC0373a
            public void le(String str) {
                if (b.this.clZ != null) {
                    b.this.clZ.onCallback(b.this, "onPlayed", null);
                }
                h.Wh().D(str, true);
                h.Wh().iE(str);
            }

            @Override // com.baidu.swan.apps.p.f.b.a.InterfaceC0373a
            public void lf(String str) {
                if (b.this.clZ != null) {
                    b.this.clZ.onCallback(b.this, "onPaused", null);
                }
                if (!TextUtils.isEmpty(str)) {
                    h.Wh().D(str, false);
                }
            }

            @Override // com.baidu.swan.apps.p.f.b.a.InterfaceC0373a
            public void onEnded() {
                if (b.this.clZ != null) {
                    b.this.clZ.onCallback(b.this, "onEnded", null);
                }
            }

            @Override // com.baidu.swan.apps.p.f.b.a.InterfaceC0373a
            public void onError(int i) {
                if (b.this.clZ != null) {
                    b.this.clZ.onCallback(b.this, "onError", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.p.f.b.a.InterfaceC0373a
            public void fQ(int i) {
                if (b.this.clZ != null) {
                    b.this.clZ.onCallback(b.this, "onInfo", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.p.f.b.a.InterfaceC0373a
            public void agO() {
                if (b.this.clZ != null) {
                    b.this.clZ.onCallback(b.this, "onVideoSizeChanged", null);
                }
            }

            @Override // com.baidu.swan.apps.p.f.b.a.InterfaceC0373a
            public void onStateChange(int i) {
                if (b.this.clZ != null) {
                    b.this.clZ.onCallback(b.this, "onStateChange", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.p.f.b.a.InterfaceC0373a
            public void lg(@NonNull String str) {
                if (b.this.clZ != null) {
                    b.this.clZ.onCallback(b.this, "onNetStatus", str);
                }
            }

            @Override // com.baidu.swan.apps.p.f.b.a.InterfaceC0373a
            public void fa(String str) {
                if (b.DEBUG) {
                    Log.i("InlineVideoController", "onRelease: " + str);
                }
                h.Wh().iC(str);
            }
        };
        aVar.a(this.cmQ);
        h.Wh().a(aVar);
        this.clY.a(new com.baidu.swan.apps.p.f.a.a());
        this.clY.a(new com.baidu.swan.apps.p.f.a.b());
        this.clY.a(new com.baidu.swan.apps.p.f.a.c());
        this.clY.a(new com.baidu.swan.apps.p.f.a.d());
        this.clY.a(new e());
        this.clY.a(new f());
        this.clY.a(new g());
        this.clY.a(new com.baidu.swan.apps.p.f.a.h());
        this.clY.a(new j());
        this.clY.a(new k());
        this.clY.a(new l());
        this.clY.a(new m());
        this.clY.a(new o());
        this.clY.a(new p());
        this.clY.a(new q());
        this.clY.a(new s());
        this.clY.a(new t());
        this.clY.a(new n());
        this.clY.a(new i());
    }
}
