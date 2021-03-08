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
    private final a.InterfaceC0435a dfQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        super(aVar);
        this.dfQ = new a.InterfaceC0435a() { // from class: com.baidu.swan.apps.inlinewidget.f.b.1
            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void onPrepared() {
                if (b.this.deU != null) {
                    b.this.deU.onCallback(b.this, "onPrepared", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void ot(String str) {
                if (b.this.deU != null) {
                    b.this.deU.onCallback(b.this, "onPlayed", null);
                }
                j.akv().O(str, true);
                j.akv().lz(str);
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void ou(String str) {
                if (b.this.deU != null) {
                    b.this.deU.onCallback(b.this, "onPaused", null);
                }
                if (!TextUtils.isEmpty(str)) {
                    j.akv().O(str, false);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void onEnded() {
                if (b.this.deU != null) {
                    b.this.deU.onCallback(b.this, "onEnded", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void onError(int i) {
                if (b.this.deU != null) {
                    b.this.deU.onCallback(b.this, "onError", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void hI(int i) {
                if (b.this.deU != null) {
                    b.this.deU.onCallback(b.this, "onInfo", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void aww() {
                if (b.this.deU != null) {
                    b.this.deU.onCallback(b.this, "onVideoSizeChanged", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void hJ(int i) {
                if (b.this.deU != null) {
                    b.this.deU.onCallback(b.this, "onStateChange", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void ov(@NonNull String str) {
                if (b.this.deU != null) {
                    b.this.deU.onCallback(b.this, "onNetStatus", str);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void gE(String str) {
                if (b.DEBUG) {
                    Log.i("InlineVideoController", "onRelease: " + str);
                }
                j.akv().lx(str);
            }
        };
        aVar.a(this.dfQ);
        j.akv().a(aVar);
        this.deT.a(new com.baidu.swan.apps.inlinewidget.f.a.a());
        this.deT.a(new com.baidu.swan.apps.inlinewidget.f.a.b());
        this.deT.a(new com.baidu.swan.apps.inlinewidget.f.a.c());
        this.deT.a(new com.baidu.swan.apps.inlinewidget.f.a.d());
        this.deT.a(new e());
        this.deT.a(new f());
        this.deT.a(new g());
        this.deT.a(new h());
        this.deT.a(new com.baidu.swan.apps.inlinewidget.f.a.j());
        this.deT.a(new k());
        this.deT.a(new l());
        this.deT.a(new m());
        this.deT.a(new o());
        this.deT.a(new p());
        this.deT.a(new q());
        this.deT.a(new s());
        this.deT.a(new t());
        this.deT.a(new n());
        this.deT.a(new i());
        this.deT.a(new r());
    }
}
