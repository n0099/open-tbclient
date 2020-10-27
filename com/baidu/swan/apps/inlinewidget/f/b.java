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
/* loaded from: classes10.dex */
final class b extends com.baidu.swan.apps.inlinewidget.b<com.baidu.swan.apps.inlinewidget.f.c.a> {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final a.InterfaceC0435a cQQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        super(aVar);
        this.cQQ = new a.InterfaceC0435a() { // from class: com.baidu.swan.apps.inlinewidget.f.b.1
            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void onPrepared() {
                if (b.this.cPU != null) {
                    b.this.cPU.onCallback(b.this, "onPrepared", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void ox(String str) {
                if (b.this.cPU != null) {
                    b.this.cPU.onCallback(b.this, "onPlayed", null);
                }
                j.ahD().O(str, true);
                j.ahD().lC(str);
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void oy(String str) {
                if (b.this.cPU != null) {
                    b.this.cPU.onCallback(b.this, "onPaused", null);
                }
                if (!TextUtils.isEmpty(str)) {
                    j.ahD().O(str, false);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void onEnded() {
                if (b.this.cPU != null) {
                    b.this.cPU.onCallback(b.this, "onEnded", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void onError(int i) {
                if (b.this.cPU != null) {
                    b.this.cPU.onCallback(b.this, "onError", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void iL(int i) {
                if (b.this.cPU != null) {
                    b.this.cPU.onCallback(b.this, "onInfo", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void atx() {
                if (b.this.cPU != null) {
                    b.this.cPU.onCallback(b.this, "onVideoSizeChanged", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void iM(int i) {
                if (b.this.cPU != null) {
                    b.this.cPU.onCallback(b.this, "onStateChange", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void oz(@NonNull String str) {
                if (b.this.cPU != null) {
                    b.this.cPU.onCallback(b.this, "onNetStatus", str);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void hf(String str) {
                if (b.DEBUG) {
                    Log.i("InlineVideoController", "onRelease: " + str);
                }
                j.ahD().lA(str);
            }
        };
        aVar.a(this.cQQ);
        j.ahD().a(aVar);
        this.cPT.a(new com.baidu.swan.apps.inlinewidget.f.a.a());
        this.cPT.a(new com.baidu.swan.apps.inlinewidget.f.a.b());
        this.cPT.a(new com.baidu.swan.apps.inlinewidget.f.a.c());
        this.cPT.a(new com.baidu.swan.apps.inlinewidget.f.a.d());
        this.cPT.a(new e());
        this.cPT.a(new f());
        this.cPT.a(new g());
        this.cPT.a(new h());
        this.cPT.a(new com.baidu.swan.apps.inlinewidget.f.a.j());
        this.cPT.a(new k());
        this.cPT.a(new l());
        this.cPT.a(new m());
        this.cPT.a(new o());
        this.cPT.a(new p());
        this.cPT.a(new q());
        this.cPT.a(new s());
        this.cPT.a(new t());
        this.cPT.a(new n());
        this.cPT.a(new i());
        this.cPT.a(new r());
    }
}
