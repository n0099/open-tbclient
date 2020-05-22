package com.baidu.swan.apps.p.e;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.api.module.k.h;
import com.baidu.swan.apps.p.e.a.e;
import com.baidu.swan.apps.p.e.a.f;
import com.baidu.swan.apps.p.e.a.g;
import com.baidu.swan.apps.p.e.a.i;
import com.baidu.swan.apps.p.e.a.j;
import com.baidu.swan.apps.p.e.a.k;
import com.baidu.swan.apps.p.e.a.l;
import com.baidu.swan.apps.p.e.a.m;
import com.baidu.swan.apps.p.e.a.n;
import com.baidu.swan.apps.p.e.a.o;
import com.baidu.swan.apps.p.e.a.p;
import com.baidu.swan.apps.p.e.a.r;
import com.baidu.swan.apps.p.e.a.s;
import com.baidu.swan.apps.p.e.a.t;
import com.baidu.swan.apps.p.e.b.a;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes11.dex */
final class a extends com.baidu.swan.apps.p.b<com.baidu.swan.apps.p.e.b.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final a.InterfaceC0364a cfX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull com.baidu.swan.apps.p.e.b.a aVar) {
        super(aVar);
        this.cfX = new a.InterfaceC0364a() { // from class: com.baidu.swan.apps.p.e.a.1
            @Override // com.baidu.swan.apps.p.e.b.a.InterfaceC0364a
            public void onPrepared() {
                if (a.this.cfi != null) {
                    a.this.cfi.onCallback(a.this, "onPrepared", null);
                }
            }

            @Override // com.baidu.swan.apps.p.e.b.a.InterfaceC0364a
            public void kz(String str) {
                if (a.this.cfi != null) {
                    a.this.cfi.onCallback(a.this, "onPlayed", null);
                }
                h.Uv().B(str, true);
                h.Uv().im(str);
            }

            @Override // com.baidu.swan.apps.p.e.b.a.InterfaceC0364a
            public void kA(String str) {
                if (a.this.cfi != null) {
                    a.this.cfi.onCallback(a.this, "onPaused", null);
                }
                if (!TextUtils.isEmpty(str)) {
                    h.Uv().B(str, false);
                }
            }

            @Override // com.baidu.swan.apps.p.e.b.a.InterfaceC0364a
            public void onEnded() {
                if (a.this.cfi != null) {
                    a.this.cfi.onCallback(a.this, "onEnded", null);
                }
            }

            @Override // com.baidu.swan.apps.p.e.b.a.InterfaceC0364a
            public void onError(int i) {
                if (a.this.cfi != null) {
                    a.this.cfi.onCallback(a.this, "onError", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.p.e.b.a.InterfaceC0364a
            public void ft(int i) {
                if (a.this.cfi != null) {
                    a.this.cfi.onCallback(a.this, "onInfo", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.p.e.b.a.InterfaceC0364a
            public void aex() {
                if (a.this.cfi != null) {
                    a.this.cfi.onCallback(a.this, "onVideoSizeChanged", null);
                }
            }

            @Override // com.baidu.swan.apps.p.e.b.a.InterfaceC0364a
            public void onStateChange(int i) {
                if (a.this.cfi != null) {
                    a.this.cfi.onCallback(a.this, "onStateChange", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.p.e.b.a.InterfaceC0364a
            public void kB(@NonNull String str) {
                if (a.this.cfi != null) {
                    a.this.cfi.onCallback(a.this, "onNetStatus", str);
                }
            }

            @Override // com.baidu.swan.apps.p.e.b.a.InterfaceC0364a
            public void eV(String str) {
                h.Uv().ik(str);
            }
        };
        aVar.a(this.cfX);
        h.Uv().a(aVar);
        this.cfh.a(new com.baidu.swan.apps.p.e.a.a());
        this.cfh.a(new com.baidu.swan.apps.p.e.a.b());
        this.cfh.a(new com.baidu.swan.apps.p.e.a.c());
        this.cfh.a(new com.baidu.swan.apps.p.e.a.d());
        this.cfh.a(new e());
        this.cfh.a(new f());
        this.cfh.a(new g());
        this.cfh.a(new com.baidu.swan.apps.p.e.a.h());
        this.cfh.a(new j());
        this.cfh.a(new k());
        this.cfh.a(new l());
        this.cfh.a(new m());
        this.cfh.a(new o());
        this.cfh.a(new p());
        this.cfh.a(new s());
        this.cfh.a(new t());
        this.cfh.a(new n());
        this.cfh.a(new i());
        this.cfh.a(new r());
    }

    @Override // com.baidu.swan.apps.p.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        if (b(command)) {
            if (DEBUG) {
                Log.d("LiveInlineController", "reject command => " + command.what);
                return;
            }
            return;
        }
        super.sendCommand(command);
    }

    private boolean b(ZeusPlugin.Command command) {
        if (command != null && TextUtils.equals(command.what, k.cga)) {
            if (DEBUG) {
                Log.d("LiveInlineController", "isRejectCommand: exempt release command");
                return false;
            }
            return false;
        }
        int aeD = ((com.baidu.swan.apps.p.e.b.a) this.cfj).aeD();
        if (DEBUG && aeD != 1) {
            Log.d("LiveInlineController", "isRejectCommand: authorize type => " + ((com.baidu.swan.apps.p.e.b.a) this.cfj).aeD() + " command=> " + (command == null ? "" : command.what));
        }
        return aeD == 2;
    }
}
