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
    private final a.InterfaceC0449a dgQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        super(aVar);
        this.dgQ = new a.InterfaceC0449a() { // from class: com.baidu.swan.apps.inlinewidget.f.b.1
            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0449a
            public void onPrepared() {
                if (b.this.dfU != null) {
                    b.this.dfU.onCallback(b.this, "onPrepared", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0449a
            public void pf(String str) {
                if (b.this.dfU != null) {
                    b.this.dfU.onCallback(b.this, "onPlayed", null);
                }
                j.anO().P(str, true);
                j.anO().ml(str);
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0449a
            public void pg(String str) {
                if (b.this.dfU != null) {
                    b.this.dfU.onCallback(b.this, "onPaused", null);
                }
                if (!TextUtils.isEmpty(str)) {
                    j.anO().P(str, false);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0449a
            public void onEnded() {
                if (b.this.dfU != null) {
                    b.this.dfU.onCallback(b.this, "onEnded", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0449a
            public void onError(int i) {
                if (b.this.dfU != null) {
                    b.this.dfU.onCallback(b.this, "onError", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0449a
            public void jk(int i) {
                if (b.this.dfU != null) {
                    b.this.dfU.onCallback(b.this, "onInfo", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0449a
            public void azP() {
                if (b.this.dfU != null) {
                    b.this.dfU.onCallback(b.this, "onVideoSizeChanged", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0449a
            public void jl(int i) {
                if (b.this.dfU != null) {
                    b.this.dfU.onCallback(b.this, "onStateChange", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0449a
            public void ph(@NonNull String str) {
                if (b.this.dfU != null) {
                    b.this.dfU.onCallback(b.this, "onNetStatus", str);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0449a
            public void hm(String str) {
                if (b.DEBUG) {
                    Log.i("InlineVideoController", "onRelease: " + str);
                }
                j.anO().mj(str);
            }
        };
        aVar.a(this.dgQ);
        j.anO().a(aVar);
        this.dfT.a(new com.baidu.swan.apps.inlinewidget.f.a.a());
        this.dfT.a(new com.baidu.swan.apps.inlinewidget.f.a.b());
        this.dfT.a(new com.baidu.swan.apps.inlinewidget.f.a.c());
        this.dfT.a(new com.baidu.swan.apps.inlinewidget.f.a.d());
        this.dfT.a(new e());
        this.dfT.a(new f());
        this.dfT.a(new g());
        this.dfT.a(new h());
        this.dfT.a(new com.baidu.swan.apps.inlinewidget.f.a.j());
        this.dfT.a(new k());
        this.dfT.a(new l());
        this.dfT.a(new m());
        this.dfT.a(new o());
        this.dfT.a(new p());
        this.dfT.a(new q());
        this.dfT.a(new s());
        this.dfT.a(new t());
        this.dfT.a(new n());
        this.dfT.a(new i());
        this.dfT.a(new r());
    }
}
