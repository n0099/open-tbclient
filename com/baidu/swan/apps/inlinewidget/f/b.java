package com.baidu.swan.apps.inlinewidget.f;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.api.module.k.j;
import com.baidu.swan.apps.inlinewidget.f.a.e;
import com.baidu.swan.apps.inlinewidget.f.a.f;
import com.baidu.swan.apps.inlinewidget.f.a.g;
import com.baidu.swan.apps.inlinewidget.f.a.h;
import com.baidu.swan.apps.inlinewidget.f.a.i;
import com.baidu.swan.apps.inlinewidget.f.a.k;
import com.baidu.swan.apps.inlinewidget.f.a.l;
import com.baidu.swan.apps.inlinewidget.f.a.m;
import com.baidu.swan.apps.inlinewidget.f.a.n;
import com.baidu.swan.apps.inlinewidget.f.a.o;
import com.baidu.swan.apps.inlinewidget.f.a.p;
import com.baidu.swan.apps.inlinewidget.f.a.q;
import com.baidu.swan.apps.inlinewidget.f.a.r;
import com.baidu.swan.apps.inlinewidget.f.a.s;
import com.baidu.swan.apps.inlinewidget.f.a.t;
import com.baidu.swan.apps.inlinewidget.f.c.a;
/* loaded from: classes8.dex */
final class b extends com.baidu.swan.apps.inlinewidget.b<com.baidu.swan.apps.inlinewidget.f.c.a> {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final a.InterfaceC0409a cuh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        super(aVar);
        this.cuh = new a.InterfaceC0409a() { // from class: com.baidu.swan.apps.inlinewidget.f.b.1
            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0409a
            public void onPrepared() {
                if (b.this.cth != null) {
                    b.this.cth.onCallback(b.this, "onPrepared", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0409a
            public void mW(String str) {
                if (b.this.cth != null) {
                    b.this.cth.onCallback(b.this, "onPlayed", null);
                }
                j.aco().I(str, true);
                j.aco().kd(str);
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0409a
            public void mX(String str) {
                if (b.this.cth != null) {
                    b.this.cth.onCallback(b.this, "onPaused", null);
                }
                if (!TextUtils.isEmpty(str)) {
                    j.aco().I(str, false);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0409a
            public void onEnded() {
                if (b.this.cth != null) {
                    b.this.cth.onCallback(b.this, "onEnded", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0409a
            public void onError(int i) {
                if (b.this.cth != null) {
                    b.this.cth.onCallback(b.this, "onError", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0409a
            public void hU(int i) {
                if (b.this.cth != null) {
                    b.this.cth.onCallback(b.this, "onInfo", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0409a
            public void aog() {
                if (b.this.cth != null) {
                    b.this.cth.onCallback(b.this, "onVideoSizeChanged", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0409a
            public void onStateChange(int i) {
                if (b.this.cth != null) {
                    b.this.cth.onCallback(b.this, "onStateChange", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0409a
            public void mY(@NonNull String str) {
                if (b.this.cth != null) {
                    b.this.cth.onCallback(b.this, "onNetStatus", str);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0409a
            public void gv(String str) {
                if (b.DEBUG) {
                    Log.i("InlineVideoController", "onRelease: " + str);
                }
                j.aco().kb(str);
            }
        };
        aVar.a(this.cuh);
        j.aco().a(aVar);
        this.ctg.a(new com.baidu.swan.apps.inlinewidget.f.a.a());
        this.ctg.a(new com.baidu.swan.apps.inlinewidget.f.a.b());
        this.ctg.a(new com.baidu.swan.apps.inlinewidget.f.a.c());
        this.ctg.a(new com.baidu.swan.apps.inlinewidget.f.a.d());
        this.ctg.a(new e());
        this.ctg.a(new f());
        this.ctg.a(new g());
        this.ctg.a(new h());
        this.ctg.a(new com.baidu.swan.apps.inlinewidget.f.a.j());
        this.ctg.a(new k());
        this.ctg.a(new l());
        this.ctg.a(new m());
        this.ctg.a(new o());
        this.ctg.a(new p());
        this.ctg.a(new q());
        this.ctg.a(new s());
        this.ctg.a(new t());
        this.ctg.a(new n());
        this.ctg.a(new i());
        this.ctg.a(new r());
    }
}
