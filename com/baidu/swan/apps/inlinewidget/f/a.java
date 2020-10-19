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
import com.baidu.swan.apps.inlinewidget.f.a.r;
import com.baidu.swan.apps.inlinewidget.f.a.s;
import com.baidu.swan.apps.inlinewidget.f.a.t;
import com.baidu.swan.apps.inlinewidget.f.c.a;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes10.dex */
final class a extends com.baidu.swan.apps.inlinewidget.b<com.baidu.swan.apps.inlinewidget.f.c.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final a.InterfaceC0421a cIu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        super(aVar);
        this.cIu = new a.InterfaceC0421a() { // from class: com.baidu.swan.apps.inlinewidget.f.a.1
            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0421a
            public void onPrepared() {
                if (a.this.cHy != null) {
                    a.this.cHy.onCallback(a.this, "onPrepared", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0421a
            public void oc(String str) {
                if (a.this.cHy != null) {
                    a.this.cHy.onCallback(a.this, "onPlayed", null);
                }
                j.afJ().M(str, true);
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0421a
            public void od(String str) {
                if (a.this.cHy != null) {
                    a.this.cHy.onCallback(a.this, "onPaused", null);
                }
                if (!TextUtils.isEmpty(str)) {
                    j.afJ().M(str, false);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0421a
            public void onEnded() {
                if (a.this.cHy != null) {
                    a.this.cHy.onCallback(a.this, "onEnded", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0421a
            public void onError(int i) {
                if (a.this.cHy != null) {
                    a.this.cHy.onCallback(a.this, "onError", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0421a
            public void iA(int i) {
                if (a.this.cHy != null) {
                    a.this.cHy.onCallback(a.this, "onInfo", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0421a
            public void arC() {
                if (a.this.cHy != null) {
                    a.this.cHy.onCallback(a.this, "onVideoSizeChanged", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0421a
            public void iB(int i) {
                if (a.this.cHy != null) {
                    a.this.cHy.onCallback(a.this, "onStateChange", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0421a
            public void oe(@NonNull String str) {
                if (a.this.cHy != null) {
                    a.this.cHy.onCallback(a.this, "onNetStatus", str);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0421a
            public void gU(String str) {
                j.afJ().lh(str);
            }
        };
        aVar.a(this.cIu);
        j.afJ().a(aVar);
        this.cHx.a(new com.baidu.swan.apps.inlinewidget.f.a.a());
        this.cHx.a(new com.baidu.swan.apps.inlinewidget.f.a.b());
        this.cHx.a(new com.baidu.swan.apps.inlinewidget.f.a.c());
        this.cHx.a(new com.baidu.swan.apps.inlinewidget.f.a.d());
        this.cHx.a(new e());
        this.cHx.a(new f());
        this.cHx.a(new g());
        this.cHx.a(new h());
        this.cHx.a(new com.baidu.swan.apps.inlinewidget.f.a.j());
        this.cHx.a(new k());
        this.cHx.a(new l());
        this.cHx.a(new m());
        this.cHx.a(new o());
        this.cHx.a(new p());
        this.cHx.a(new s());
        this.cHx.a(new t());
        this.cHx.a(new n());
        this.cHx.a(new i());
        this.cHx.a(new r());
    }

    @Override // com.baidu.swan.apps.inlinewidget.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
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
        if (command != null && TextUtils.equals(command.what, k.cIx)) {
            if (DEBUG) {
                Log.d("LiveInlineController", "isRejectCommand: exempt release command");
                return false;
            }
            return false;
        }
        int arQ = ((com.baidu.swan.apps.inlinewidget.f.c.a) this.cHz).arQ();
        if (DEBUG && arQ != 1) {
            Log.d("LiveInlineController", "isRejectCommand: authorize type => " + ((com.baidu.swan.apps.inlinewidget.f.c.a) this.cHz).arQ() + " command=> " + (command == null ? "" : command.what));
        }
        return arQ == 2;
    }
}
