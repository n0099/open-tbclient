package com.baidu.swan.apps.inlinewidget.f;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
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
/* loaded from: classes9.dex */
final class b extends com.baidu.swan.apps.inlinewidget.b<com.baidu.swan.apps.inlinewidget.f.c.a> {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final a.InterfaceC0429a deo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        super(aVar);
        this.deo = new a.InterfaceC0429a() { // from class: com.baidu.swan.apps.inlinewidget.f.b.1
            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0429a
            public void onPrepared() {
                if (b.this.ddr != null) {
                    b.this.ddr.onCallback(b.this, "onPrepared", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0429a
            public void ol(String str) {
                if (b.this.ddr != null) {
                    b.this.ddr.onCallback(b.this, "onPlayed", null);
                }
                j.aks().O(str, true);
                j.aks().ls(str);
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0429a
            public void om(String str) {
                if (b.this.ddr != null) {
                    b.this.ddr.onCallback(b.this, "onPaused", null);
                }
                if (!TextUtils.isEmpty(str)) {
                    j.aks().O(str, false);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0429a
            public void onEnded() {
                if (b.this.ddr != null) {
                    b.this.ddr.onCallback(b.this, "onEnded", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0429a
            public void onError(int i) {
                if (b.this.ddr != null) {
                    b.this.ddr.onCallback(b.this, "onError", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0429a
            public void hH(int i) {
                if (b.this.ddr != null) {
                    b.this.ddr.onCallback(b.this, "onInfo", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0429a
            public void awt() {
                if (b.this.ddr != null) {
                    b.this.ddr.onCallback(b.this, "onVideoSizeChanged", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0429a
            public void hI(int i) {
                if (b.this.ddr != null) {
                    b.this.ddr.onCallback(b.this, "onStateChange", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0429a
            public void oo(@NonNull String str) {
                if (b.this.ddr != null) {
                    b.this.ddr.onCallback(b.this, "onNetStatus", str);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0429a
            public void gy(String str) {
                if (b.DEBUG) {
                    Log.i("InlineVideoController", "onRelease: " + str);
                }
                j.aks().lq(str);
            }
        };
        aVar.a(this.deo);
        j.aks().a(aVar);
        this.ddq.a(new com.baidu.swan.apps.inlinewidget.f.a.a());
        this.ddq.a(new com.baidu.swan.apps.inlinewidget.f.a.b());
        this.ddq.a(new com.baidu.swan.apps.inlinewidget.f.a.c());
        this.ddq.a(new com.baidu.swan.apps.inlinewidget.f.a.d());
        this.ddq.a(new e());
        this.ddq.a(new f());
        this.ddq.a(new g());
        this.ddq.a(new h());
        this.ddq.a(new com.baidu.swan.apps.inlinewidget.f.a.j());
        this.ddq.a(new k());
        this.ddq.a(new l());
        this.ddq.a(new m());
        this.ddq.a(new o());
        this.ddq.a(new p());
        this.ddq.a(new q());
        this.ddq.a(new s());
        this.ddq.a(new t());
        this.ddq.a(new n());
        this.ddq.a(new i());
        this.ddq.a(new r());
    }
}
