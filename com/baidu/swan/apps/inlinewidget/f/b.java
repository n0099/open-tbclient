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
/* loaded from: classes3.dex */
final class b extends com.baidu.swan.apps.inlinewidget.b<com.baidu.swan.apps.inlinewidget.f.c.a> {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final a.InterfaceC0404a cwo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        super(aVar);
        this.cwo = new a.InterfaceC0404a() { // from class: com.baidu.swan.apps.inlinewidget.f.b.1
            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0404a
            public void onPrepared() {
                if (b.this.cvr != null) {
                    b.this.cvr.onCallback(b.this, "onPrepared", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0404a
            public void nq(String str) {
                if (b.this.cvr != null) {
                    b.this.cvr.onCallback(b.this, "onPlayed", null);
                }
                j.acX().I(str, true);
                j.acX().kx(str);
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0404a
            public void nr(String str) {
                if (b.this.cvr != null) {
                    b.this.cvr.onCallback(b.this, "onPaused", null);
                }
                if (!TextUtils.isEmpty(str)) {
                    j.acX().I(str, false);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0404a
            public void onEnded() {
                if (b.this.cvr != null) {
                    b.this.cvr.onCallback(b.this, "onEnded", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0404a
            public void onError(int i) {
                if (b.this.cvr != null) {
                    b.this.cvr.onCallback(b.this, "onError", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0404a
            public void id(int i) {
                if (b.this.cvr != null) {
                    b.this.cvr.onCallback(b.this, "onInfo", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0404a
            public void aoQ() {
                if (b.this.cvr != null) {
                    b.this.cvr.onCallback(b.this, "onVideoSizeChanged", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0404a
            public void ie(int i) {
                if (b.this.cvr != null) {
                    b.this.cvr.onCallback(b.this, "onStateChange", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0404a
            public void ns(@NonNull String str) {
                if (b.this.cvr != null) {
                    b.this.cvr.onCallback(b.this, "onNetStatus", str);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0404a
            public void gG(String str) {
                if (b.DEBUG) {
                    Log.i("InlineVideoController", "onRelease: " + str);
                }
                j.acX().kv(str);
            }
        };
        aVar.a(this.cwo);
        j.acX().a(aVar);
        this.cvq.a(new com.baidu.swan.apps.inlinewidget.f.a.a());
        this.cvq.a(new com.baidu.swan.apps.inlinewidget.f.a.b());
        this.cvq.a(new com.baidu.swan.apps.inlinewidget.f.a.c());
        this.cvq.a(new com.baidu.swan.apps.inlinewidget.f.a.d());
        this.cvq.a(new e());
        this.cvq.a(new f());
        this.cvq.a(new g());
        this.cvq.a(new h());
        this.cvq.a(new com.baidu.swan.apps.inlinewidget.f.a.j());
        this.cvq.a(new k());
        this.cvq.a(new l());
        this.cvq.a(new m());
        this.cvq.a(new o());
        this.cvq.a(new p());
        this.cvq.a(new q());
        this.cvq.a(new s());
        this.cvq.a(new t());
        this.cvq.a(new n());
        this.cvq.a(new i());
        this.cvq.a(new r());
    }
}
