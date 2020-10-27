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
    private final a.InterfaceC0435a cQQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        super(aVar);
        this.cQQ = new a.InterfaceC0435a() { // from class: com.baidu.swan.apps.inlinewidget.f.a.1
            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void onPrepared() {
                if (a.this.cPU != null) {
                    a.this.cPU.onCallback(a.this, "onPrepared", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void ox(String str) {
                if (a.this.cPU != null) {
                    a.this.cPU.onCallback(a.this, "onPlayed", null);
                }
                j.ahD().O(str, true);
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void oy(String str) {
                if (a.this.cPU != null) {
                    a.this.cPU.onCallback(a.this, "onPaused", null);
                }
                if (!TextUtils.isEmpty(str)) {
                    j.ahD().O(str, false);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void onEnded() {
                if (a.this.cPU != null) {
                    a.this.cPU.onCallback(a.this, "onEnded", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void onError(int i) {
                if (a.this.cPU != null) {
                    a.this.cPU.onCallback(a.this, "onError", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void iL(int i) {
                if (a.this.cPU != null) {
                    a.this.cPU.onCallback(a.this, "onInfo", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void atx() {
                if (a.this.cPU != null) {
                    a.this.cPU.onCallback(a.this, "onVideoSizeChanged", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void iM(int i) {
                if (a.this.cPU != null) {
                    a.this.cPU.onCallback(a.this, "onStateChange", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void oz(@NonNull String str) {
                if (a.this.cPU != null) {
                    a.this.cPU.onCallback(a.this, "onNetStatus", str);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void hf(String str) {
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
        this.cPT.a(new s());
        this.cPT.a(new t());
        this.cPT.a(new n());
        this.cPT.a(new i());
        this.cPT.a(new r());
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
        if (command != null && TextUtils.equals(command.what, k.cQT)) {
            if (DEBUG) {
                Log.d("LiveInlineController", "isRejectCommand: exempt release command");
                return false;
            }
            return false;
        }
        int atL = ((com.baidu.swan.apps.inlinewidget.f.c.a) this.cPV).atL();
        if (DEBUG && atL != 1) {
            Log.d("LiveInlineController", "isRejectCommand: authorize type => " + ((com.baidu.swan.apps.inlinewidget.f.c.a) this.cPV).atL() + " command=> " + (command == null ? "" : command.what));
        }
        return atL == 2;
    }
}
