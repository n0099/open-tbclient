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
/* loaded from: classes7.dex */
final class a extends com.baidu.swan.apps.inlinewidget.b<com.baidu.swan.apps.inlinewidget.f.c.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final a.InterfaceC0445a cUZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        super(aVar);
        this.cUZ = new a.InterfaceC0445a() { // from class: com.baidu.swan.apps.inlinewidget.f.a.1
            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0445a
            public void onPrepared() {
                if (a.this.cUd != null) {
                    a.this.cUd.onCallback(a.this, "onPrepared", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0445a
            public void oF(String str) {
                if (a.this.cUd != null) {
                    a.this.cUd.onCallback(a.this, "onPlayed", null);
                }
                j.ajv().O(str, true);
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0445a
            public void oG(String str) {
                if (a.this.cUd != null) {
                    a.this.cUd.onCallback(a.this, "onPaused", null);
                }
                if (!TextUtils.isEmpty(str)) {
                    j.ajv().O(str, false);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0445a
            public void onEnded() {
                if (a.this.cUd != null) {
                    a.this.cUd.onCallback(a.this, "onEnded", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0445a
            public void onError(int i) {
                if (a.this.cUd != null) {
                    a.this.cUd.onCallback(a.this, "onError", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0445a
            public void iR(int i) {
                if (a.this.cUd != null) {
                    a.this.cUd.onCallback(a.this, "onInfo", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0445a
            public void avp() {
                if (a.this.cUd != null) {
                    a.this.cUd.onCallback(a.this, "onVideoSizeChanged", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0445a
            public void iS(int i) {
                if (a.this.cUd != null) {
                    a.this.cUd.onCallback(a.this, "onStateChange", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0445a
            public void oH(@NonNull String str) {
                if (a.this.cUd != null) {
                    a.this.cUd.onCallback(a.this, "onNetStatus", str);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0445a
            public void hg(String str) {
                j.ajv().lJ(str);
            }
        };
        aVar.a(this.cUZ);
        j.ajv().a(aVar);
        this.cUc.a(new com.baidu.swan.apps.inlinewidget.f.a.a());
        this.cUc.a(new com.baidu.swan.apps.inlinewidget.f.a.b());
        this.cUc.a(new com.baidu.swan.apps.inlinewidget.f.a.c());
        this.cUc.a(new com.baidu.swan.apps.inlinewidget.f.a.d());
        this.cUc.a(new e());
        this.cUc.a(new f());
        this.cUc.a(new g());
        this.cUc.a(new h());
        this.cUc.a(new com.baidu.swan.apps.inlinewidget.f.a.j());
        this.cUc.a(new k());
        this.cUc.a(new l());
        this.cUc.a(new m());
        this.cUc.a(new o());
        this.cUc.a(new p());
        this.cUc.a(new s());
        this.cUc.a(new t());
        this.cUc.a(new n());
        this.cUc.a(new i());
        this.cUc.a(new r());
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
        if (command != null && TextUtils.equals(command.what, k.cVc)) {
            if (DEBUG) {
                Log.d("LiveInlineController", "isRejectCommand: exempt release command");
                return false;
            }
            return false;
        }
        int avD = ((com.baidu.swan.apps.inlinewidget.f.c.a) this.cUe).avD();
        if (DEBUG && avD != 1) {
            Log.d("LiveInlineController", "isRejectCommand: authorize type => " + ((com.baidu.swan.apps.inlinewidget.f.c.a) this.cUe).avD() + " command=> " + (command == null ? "" : command.what));
        }
        return avD == 2;
    }
}
