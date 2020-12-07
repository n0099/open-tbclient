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
/* loaded from: classes25.dex */
final class a extends com.baidu.swan.apps.inlinewidget.b<com.baidu.swan.apps.inlinewidget.f.c.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final a.InterfaceC0457a dbV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        super(aVar);
        this.dbV = new a.InterfaceC0457a() { // from class: com.baidu.swan.apps.inlinewidget.f.a.1
            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0457a
            public void onPrepared() {
                if (a.this.daZ != null) {
                    a.this.daZ.onCallback(a.this, "onPrepared", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0457a
            public void pm(String str) {
                if (a.this.daZ != null) {
                    a.this.daZ.onCallback(a.this, "onPlayed", null);
                }
                j.amD().P(str, true);
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0457a
            public void pn(String str) {
                if (a.this.daZ != null) {
                    a.this.daZ.onCallback(a.this, "onPaused", null);
                }
                if (!TextUtils.isEmpty(str)) {
                    j.amD().P(str, false);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0457a
            public void onEnded() {
                if (a.this.daZ != null) {
                    a.this.daZ.onCallback(a.this, "onEnded", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0457a
            public void onError(int i) {
                if (a.this.daZ != null) {
                    a.this.daZ.onCallback(a.this, "onError", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0457a
            public void jp(int i) {
                if (a.this.daZ != null) {
                    a.this.daZ.onCallback(a.this, "onInfo", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0457a
            public void ayx() {
                if (a.this.daZ != null) {
                    a.this.daZ.onCallback(a.this, "onVideoSizeChanged", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0457a
            public void jq(int i) {
                if (a.this.daZ != null) {
                    a.this.daZ.onCallback(a.this, "onStateChange", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0457a
            public void po(@NonNull String str) {
                if (a.this.daZ != null) {
                    a.this.daZ.onCallback(a.this, "onNetStatus", str);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0457a
            public void hB(String str) {
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
        this.daY.a(new s());
        this.daY.a(new t());
        this.daY.a(new n());
        this.daY.a(new i());
        this.daY.a(new r());
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
        if (command != null && TextUtils.equals(command.what, k.dbY)) {
            if (DEBUG) {
                Log.d("LiveInlineController", "isRejectCommand: exempt release command");
                return false;
            }
            return false;
        }
        int ayL = ((com.baidu.swan.apps.inlinewidget.f.c.a) this.dba).ayL();
        if (DEBUG && ayL != 1) {
            Log.d("LiveInlineController", "isRejectCommand: authorize type => " + ((com.baidu.swan.apps.inlinewidget.f.c.a) this.dba).ayL() + " command=> " + (command == null ? "" : command.what));
        }
        return ayL == 2;
    }
}
