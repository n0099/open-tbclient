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
/* loaded from: classes8.dex */
final class b extends com.baidu.swan.apps.inlinewidget.b<com.baidu.swan.apps.inlinewidget.f.c.a> {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final a.InterfaceC0432a dcb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        super(aVar);
        this.dcb = new a.InterfaceC0432a() { // from class: com.baidu.swan.apps.inlinewidget.f.b.1
            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0432a
            public void onPrepared() {
                if (b.this.dbf != null) {
                    b.this.dbf.onCallback(b.this, "onPrepared", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0432a
            public void nS(String str) {
                if (b.this.dbf != null) {
                    b.this.dbf.onCallback(b.this, "onPlayed", null);
                }
                j.ajU().P(str, true);
                j.ajU().la(str);
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0432a
            public void nT(String str) {
                if (b.this.dbf != null) {
                    b.this.dbf.onCallback(b.this, "onPaused", null);
                }
                if (!TextUtils.isEmpty(str)) {
                    j.ajU().P(str, false);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0432a
            public void onEnded() {
                if (b.this.dbf != null) {
                    b.this.dbf.onCallback(b.this, "onEnded", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0432a
            public void onError(int i) {
                if (b.this.dbf != null) {
                    b.this.dbf.onCallback(b.this, "onError", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0432a
            public void hE(int i) {
                if (b.this.dbf != null) {
                    b.this.dbf.onCallback(b.this, "onInfo", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0432a
            public void avV() {
                if (b.this.dbf != null) {
                    b.this.dbf.onCallback(b.this, "onVideoSizeChanged", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0432a
            public void hF(int i) {
                if (b.this.dbf != null) {
                    b.this.dbf.onCallback(b.this, "onStateChange", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0432a
            public void nU(@NonNull String str) {
                if (b.this.dbf != null) {
                    b.this.dbf.onCallback(b.this, "onNetStatus", str);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0432a
            public void ga(String str) {
                if (b.DEBUG) {
                    Log.i("InlineVideoController", "onRelease: " + str);
                }
                j.ajU().kY(str);
            }
        };
        aVar.a(this.dcb);
        j.ajU().a(aVar);
        this.dbe.a(new com.baidu.swan.apps.inlinewidget.f.a.a());
        this.dbe.a(new com.baidu.swan.apps.inlinewidget.f.a.b());
        this.dbe.a(new com.baidu.swan.apps.inlinewidget.f.a.c());
        this.dbe.a(new com.baidu.swan.apps.inlinewidget.f.a.d());
        this.dbe.a(new e());
        this.dbe.a(new f());
        this.dbe.a(new g());
        this.dbe.a(new h());
        this.dbe.a(new com.baidu.swan.apps.inlinewidget.f.a.j());
        this.dbe.a(new k());
        this.dbe.a(new l());
        this.dbe.a(new m());
        this.dbe.a(new o());
        this.dbe.a(new p());
        this.dbe.a(new q());
        this.dbe.a(new s());
        this.dbe.a(new t());
        this.dbe.a(new n());
        this.dbe.a(new i());
        this.dbe.a(new r());
    }
}
