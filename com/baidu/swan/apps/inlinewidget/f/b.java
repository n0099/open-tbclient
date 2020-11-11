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
    private final a.InterfaceC0447a cWJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        super(aVar);
        this.cWJ = new a.InterfaceC0447a() { // from class: com.baidu.swan.apps.inlinewidget.f.b.1
            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0447a
            public void onPrepared() {
                if (b.this.cVN != null) {
                    b.this.cVN.onCallback(b.this, "onPrepared", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0447a
            public void oL(String str) {
                if (b.this.cVN != null) {
                    b.this.cVN.onCallback(b.this, "onPlayed", null);
                }
                j.akd().O(str, true);
                j.akd().lR(str);
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0447a
            public void oM(String str) {
                if (b.this.cVN != null) {
                    b.this.cVN.onCallback(b.this, "onPaused", null);
                }
                if (!TextUtils.isEmpty(str)) {
                    j.akd().O(str, false);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0447a
            public void onEnded() {
                if (b.this.cVN != null) {
                    b.this.cVN.onCallback(b.this, "onEnded", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0447a
            public void onError(int i) {
                if (b.this.cVN != null) {
                    b.this.cVN.onCallback(b.this, "onError", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0447a
            public void iV(int i) {
                if (b.this.cVN != null) {
                    b.this.cVN.onCallback(b.this, "onInfo", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0447a
            public void avX() {
                if (b.this.cVN != null) {
                    b.this.cVN.onCallback(b.this, "onVideoSizeChanged", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0447a
            public void iW(int i) {
                if (b.this.cVN != null) {
                    b.this.cVN.onCallback(b.this, "onStateChange", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0447a
            public void oN(@NonNull String str) {
                if (b.this.cVN != null) {
                    b.this.cVN.onCallback(b.this, "onNetStatus", str);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0447a
            public void hm(String str) {
                if (b.DEBUG) {
                    Log.i("InlineVideoController", "onRelease: " + str);
                }
                j.akd().lP(str);
            }
        };
        aVar.a(this.cWJ);
        j.akd().a(aVar);
        this.cVM.a(new com.baidu.swan.apps.inlinewidget.f.a.a());
        this.cVM.a(new com.baidu.swan.apps.inlinewidget.f.a.b());
        this.cVM.a(new com.baidu.swan.apps.inlinewidget.f.a.c());
        this.cVM.a(new com.baidu.swan.apps.inlinewidget.f.a.d());
        this.cVM.a(new e());
        this.cVM.a(new f());
        this.cVM.a(new g());
        this.cVM.a(new h());
        this.cVM.a(new com.baidu.swan.apps.inlinewidget.f.a.j());
        this.cVM.a(new k());
        this.cVM.a(new l());
        this.cVM.a(new m());
        this.cVM.a(new o());
        this.cVM.a(new p());
        this.cVM.a(new q());
        this.cVM.a(new s());
        this.cVM.a(new t());
        this.cVM.a(new n());
        this.cVM.a(new i());
        this.cVM.a(new r());
    }
}
