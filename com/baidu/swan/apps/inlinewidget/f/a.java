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
/* loaded from: classes8.dex */
final class a extends com.baidu.swan.apps.inlinewidget.b<com.baidu.swan.apps.inlinewidget.f.c.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final a.InterfaceC0409a cul;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        super(aVar);
        this.cul = new a.InterfaceC0409a() { // from class: com.baidu.swan.apps.inlinewidget.f.a.1
            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0409a
            public void onPrepared() {
                if (a.this.ctl != null) {
                    a.this.ctl.onCallback(a.this, "onPrepared", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0409a
            public void mX(String str) {
                if (a.this.ctl != null) {
                    a.this.ctl.onCallback(a.this, "onPlayed", null);
                }
                j.aco().I(str, true);
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0409a
            public void mY(String str) {
                if (a.this.ctl != null) {
                    a.this.ctl.onCallback(a.this, "onPaused", null);
                }
                if (!TextUtils.isEmpty(str)) {
                    j.aco().I(str, false);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0409a
            public void onEnded() {
                if (a.this.ctl != null) {
                    a.this.ctl.onCallback(a.this, "onEnded", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0409a
            public void onError(int i) {
                if (a.this.ctl != null) {
                    a.this.ctl.onCallback(a.this, "onError", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0409a
            public void hU(int i) {
                if (a.this.ctl != null) {
                    a.this.ctl.onCallback(a.this, "onInfo", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0409a
            public void aog() {
                if (a.this.ctl != null) {
                    a.this.ctl.onCallback(a.this, "onVideoSizeChanged", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0409a
            public void onStateChange(int i) {
                if (a.this.ctl != null) {
                    a.this.ctl.onCallback(a.this, "onStateChange", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0409a
            public void mZ(@NonNull String str) {
                if (a.this.ctl != null) {
                    a.this.ctl.onCallback(a.this, "onNetStatus", str);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0409a
            public void gw(String str) {
                j.aco().kc(str);
            }
        };
        aVar.a(this.cul);
        j.aco().a(aVar);
        this.ctk.a(new com.baidu.swan.apps.inlinewidget.f.a.a());
        this.ctk.a(new com.baidu.swan.apps.inlinewidget.f.a.b());
        this.ctk.a(new com.baidu.swan.apps.inlinewidget.f.a.c());
        this.ctk.a(new com.baidu.swan.apps.inlinewidget.f.a.d());
        this.ctk.a(new e());
        this.ctk.a(new f());
        this.ctk.a(new g());
        this.ctk.a(new h());
        this.ctk.a(new com.baidu.swan.apps.inlinewidget.f.a.j());
        this.ctk.a(new k());
        this.ctk.a(new l());
        this.ctk.a(new m());
        this.ctk.a(new o());
        this.ctk.a(new p());
        this.ctk.a(new s());
        this.ctk.a(new t());
        this.ctk.a(new n());
        this.ctk.a(new i());
        this.ctk.a(new r());
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
        if (command != null && TextUtils.equals(command.what, k.cuo)) {
            if (DEBUG) {
                Log.d("LiveInlineController", "isRejectCommand: exempt release command");
                return false;
            }
            return false;
        }
        int aou = ((com.baidu.swan.apps.inlinewidget.f.c.a) this.ctm).aou();
        if (DEBUG && aou != 1) {
            Log.d("LiveInlineController", "isRejectCommand: authorize type => " + ((com.baidu.swan.apps.inlinewidget.f.c.a) this.ctm).aou() + " command=> " + (command == null ? "" : command.what));
        }
        return aou == 2;
    }
}
