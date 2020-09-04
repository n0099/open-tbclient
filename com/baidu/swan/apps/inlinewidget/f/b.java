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
    private final a.InterfaceC0409a cul;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        super(aVar);
        this.cul = new a.InterfaceC0409a() { // from class: com.baidu.swan.apps.inlinewidget.f.b.1
            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0409a
            public void onPrepared() {
                if (b.this.ctl != null) {
                    b.this.ctl.onCallback(b.this, "onPrepared", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0409a
            public void mX(String str) {
                if (b.this.ctl != null) {
                    b.this.ctl.onCallback(b.this, "onPlayed", null);
                }
                j.aco().I(str, true);
                j.aco().ke(str);
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0409a
            public void mY(String str) {
                if (b.this.ctl != null) {
                    b.this.ctl.onCallback(b.this, "onPaused", null);
                }
                if (!TextUtils.isEmpty(str)) {
                    j.aco().I(str, false);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0409a
            public void onEnded() {
                if (b.this.ctl != null) {
                    b.this.ctl.onCallback(b.this, "onEnded", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0409a
            public void onError(int i) {
                if (b.this.ctl != null) {
                    b.this.ctl.onCallback(b.this, "onError", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0409a
            public void hU(int i) {
                if (b.this.ctl != null) {
                    b.this.ctl.onCallback(b.this, "onInfo", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0409a
            public void aog() {
                if (b.this.ctl != null) {
                    b.this.ctl.onCallback(b.this, "onVideoSizeChanged", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0409a
            public void onStateChange(int i) {
                if (b.this.ctl != null) {
                    b.this.ctl.onCallback(b.this, "onStateChange", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0409a
            public void mZ(@NonNull String str) {
                if (b.this.ctl != null) {
                    b.this.ctl.onCallback(b.this, "onNetStatus", str);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0409a
            public void gw(String str) {
                if (b.DEBUG) {
                    Log.i("InlineVideoController", "onRelease: " + str);
                }
                j.aco().kc(str);
            }
        };
        aVar.a(this.cul);
        j.aco().a(aVar);
        this.ctk.a(new com.baidu.swan.apps.inlinewidget.f.a.a());
        this.ctk.a(new com.baidu.swan.apps.inlinewidget.f.a.b());
        this.ctk.a(new com.baidu.swan.apps.inlinewidget.f.a.c());
        this.ctk.a(new com.baidu.swan.apps.inlinewidget.f.a.d());
        this.ctk.a(new e());
        this.ctk.a(new f());
        this.ctk.a(new g());
        this.ctk.a(new h());
        this.ctk.a(new com.baidu.swan.apps.inlinewidget.f.a.j());
        this.ctk.a(new k());
        this.ctk.a(new l());
        this.ctk.a(new m());
        this.ctk.a(new o());
        this.ctk.a(new p());
        this.ctk.a(new q());
        this.ctk.a(new s());
        this.ctk.a(new t());
        this.ctk.a(new n());
        this.ctk.a(new i());
        this.ctk.a(new r());
    }
}
