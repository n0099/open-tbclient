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
    private final a.InterfaceC0370a ckL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull com.baidu.swan.apps.p.e.b.a aVar) {
        super(aVar);
        this.ckL = new a.InterfaceC0370a() { // from class: com.baidu.swan.apps.p.e.a.1
            @Override // com.baidu.swan.apps.p.e.b.a.InterfaceC0370a
            public void onPrepared() {
                if (a.this.cjW != null) {
                    a.this.cjW.onCallback(a.this, "onPrepared", null);
                }
            }

            @Override // com.baidu.swan.apps.p.e.b.a.InterfaceC0370a
            public void kH(String str) {
                if (a.this.cjW != null) {
                    a.this.cjW.onCallback(a.this, "onPlayed", null);
                }
                h.VB().D(str, true);
                h.VB().iu(str);
            }

            @Override // com.baidu.swan.apps.p.e.b.a.InterfaceC0370a
            public void kI(String str) {
                if (a.this.cjW != null) {
                    a.this.cjW.onCallback(a.this, "onPaused", null);
                }
                if (!TextUtils.isEmpty(str)) {
                    h.VB().D(str, false);
                }
            }

            @Override // com.baidu.swan.apps.p.e.b.a.InterfaceC0370a
            public void onEnded() {
                if (a.this.cjW != null) {
                    a.this.cjW.onCallback(a.this, "onEnded", null);
                }
            }

            @Override // com.baidu.swan.apps.p.e.b.a.InterfaceC0370a
            public void onError(int i) {
                if (a.this.cjW != null) {
                    a.this.cjW.onCallback(a.this, "onError", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.p.e.b.a.InterfaceC0370a
            public void fG(int i) {
                if (a.this.cjW != null) {
                    a.this.cjW.onCallback(a.this, "onInfo", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.p.e.b.a.InterfaceC0370a
            public void afD() {
                if (a.this.cjW != null) {
                    a.this.cjW.onCallback(a.this, "onVideoSizeChanged", null);
                }
            }

            @Override // com.baidu.swan.apps.p.e.b.a.InterfaceC0370a
            public void onStateChange(int i) {
                if (a.this.cjW != null) {
                    a.this.cjW.onCallback(a.this, "onStateChange", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.p.e.b.a.InterfaceC0370a
            public void kJ(@NonNull String str) {
                if (a.this.cjW != null) {
                    a.this.cjW.onCallback(a.this, "onNetStatus", str);
                }
            }

            @Override // com.baidu.swan.apps.p.e.b.a.InterfaceC0370a
            public void fb(String str) {
                h.VB().is(str);
            }
        };
        aVar.a(this.ckL);
        h.VB().a(aVar);
        this.cjV.a(new com.baidu.swan.apps.p.e.a.a());
        this.cjV.a(new com.baidu.swan.apps.p.e.a.b());
        this.cjV.a(new com.baidu.swan.apps.p.e.a.c());
        this.cjV.a(new com.baidu.swan.apps.p.e.a.d());
        this.cjV.a(new e());
        this.cjV.a(new f());
        this.cjV.a(new g());
        this.cjV.a(new com.baidu.swan.apps.p.e.a.h());
        this.cjV.a(new j());
        this.cjV.a(new k());
        this.cjV.a(new l());
        this.cjV.a(new m());
        this.cjV.a(new o());
        this.cjV.a(new p());
        this.cjV.a(new s());
        this.cjV.a(new t());
        this.cjV.a(new n());
        this.cjV.a(new i());
        this.cjV.a(new r());
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
        if (command != null && TextUtils.equals(command.what, k.ckO)) {
            if (DEBUG) {
                Log.d("LiveInlineController", "isRejectCommand: exempt release command");
                return false;
            }
            return false;
        }
        int afJ = ((com.baidu.swan.apps.p.e.b.a) this.cjX).afJ();
        if (DEBUG && afJ != 1) {
            Log.d("LiveInlineController", "isRejectCommand: authorize type => " + ((com.baidu.swan.apps.p.e.b.a) this.cjX).afJ() + " command=> " + (command == null ? "" : command.what));
        }
        return afJ == 2;
    }
}
