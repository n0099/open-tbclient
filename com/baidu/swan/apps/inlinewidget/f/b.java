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
/* loaded from: classes25.dex */
final class b extends com.baidu.swan.apps.inlinewidget.b<com.baidu.swan.apps.inlinewidget.f.c.a> {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final a.InterfaceC0457a dbV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        super(aVar);
        this.dbV = new a.InterfaceC0457a() { // from class: com.baidu.swan.apps.inlinewidget.f.b.1
            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0457a
            public void onPrepared() {
                if (b.this.daZ != null) {
                    b.this.daZ.onCallback(b.this, "onPrepared", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0457a
            public void pm(String str) {
                if (b.this.daZ != null) {
                    b.this.daZ.onCallback(b.this, "onPlayed", null);
                }
                j.amD().P(str, true);
                j.amD().ms(str);
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0457a
            public void pn(String str) {
                if (b.this.daZ != null) {
                    b.this.daZ.onCallback(b.this, "onPaused", null);
                }
                if (!TextUtils.isEmpty(str)) {
                    j.amD().P(str, false);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0457a
            public void onEnded() {
                if (b.this.daZ != null) {
                    b.this.daZ.onCallback(b.this, "onEnded", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0457a
            public void onError(int i) {
                if (b.this.daZ != null) {
                    b.this.daZ.onCallback(b.this, "onError", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0457a
            public void jp(int i) {
                if (b.this.daZ != null) {
                    b.this.daZ.onCallback(b.this, "onInfo", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0457a
            public void ayx() {
                if (b.this.daZ != null) {
                    b.this.daZ.onCallback(b.this, "onVideoSizeChanged", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0457a
            public void jq(int i) {
                if (b.this.daZ != null) {
                    b.this.daZ.onCallback(b.this, "onStateChange", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0457a
            public void po(@NonNull String str) {
                if (b.this.daZ != null) {
                    b.this.daZ.onCallback(b.this, "onNetStatus", str);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0457a
            public void hB(String str) {
                if (b.DEBUG) {
                    Log.i("InlineVideoController", "onRelease: " + str);
                }
                j.amD().mq(str);
            }
        };
        aVar.a(this.dbV);
        j.amD().a(aVar);
        this.daY.a(new com.baidu.swan.apps.inlinewidget.f.a.a());
        this.daY.a(new com.baidu.swan.apps.inlinewidget.f.a.b());
        this.daY.a(new com.baidu.swan.apps.inlinewidget.f.a.c());
        this.daY.a(new com.baidu.swan.apps.inlinewidget.f.a.d());
        this.daY.a(new e());
        this.daY.a(new f());
        this.daY.a(new g());
        this.daY.a(new h());
        this.daY.a(new com.baidu.swan.apps.inlinewidget.f.a.j());
        this.daY.a(new k());
        this.daY.a(new l());
        this.daY.a(new m());
        this.daY.a(new o());
        this.daY.a(new p());
        this.daY.a(new q());
        this.daY.a(new s());
        this.daY.a(new t());
        this.daY.a(new n());
        this.daY.a(new i());
        this.daY.a(new r());
    }
}
