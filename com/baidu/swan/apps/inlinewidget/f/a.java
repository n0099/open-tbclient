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
import com.baidu.swan.apps.inlinewidget.f.a.r;
import com.baidu.swan.apps.inlinewidget.f.a.s;
import com.baidu.swan.apps.inlinewidget.f.a.t;
import com.baidu.swan.apps.inlinewidget.f.c.a;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes9.dex */
final class a extends com.baidu.swan.apps.inlinewidget.b<com.baidu.swan.apps.inlinewidget.f.c.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final a.InterfaceC0429a deo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        super(aVar);
        this.deo = new a.InterfaceC0429a() { // from class: com.baidu.swan.apps.inlinewidget.f.a.1
            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0429a
            public void onPrepared() {
                if (a.this.ddr != null) {
                    a.this.ddr.onCallback(a.this, "onPrepared", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0429a
            public void ol(String str) {
                if (a.this.ddr != null) {
                    a.this.ddr.onCallback(a.this, "onPlayed", null);
                }
                j.aks().O(str, true);
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0429a
            public void om(String str) {
                if (a.this.ddr != null) {
                    a.this.ddr.onCallback(a.this, "onPaused", null);
                }
                if (!TextUtils.isEmpty(str)) {
                    j.aks().O(str, false);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0429a
            public void onEnded() {
                if (a.this.ddr != null) {
                    a.this.ddr.onCallback(a.this, "onEnded", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0429a
            public void onError(int i) {
                if (a.this.ddr != null) {
                    a.this.ddr.onCallback(a.this, "onError", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0429a
            public void hH(int i) {
                if (a.this.ddr != null) {
                    a.this.ddr.onCallback(a.this, "onInfo", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0429a
            public void awt() {
                if (a.this.ddr != null) {
                    a.this.ddr.onCallback(a.this, "onVideoSizeChanged", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0429a
            public void hI(int i) {
                if (a.this.ddr != null) {
                    a.this.ddr.onCallback(a.this, "onStateChange", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0429a
            public void oo(@NonNull String str) {
                if (a.this.ddr != null) {
                    a.this.ddr.onCallback(a.this, "onNetStatus", str);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0429a
            public void gy(String str) {
                j.aks().lq(str);
            }
        };
        aVar.a(this.deo);
        j.aks().a(aVar);
        this.ddq.a(new com.baidu.swan.apps.inlinewidget.f.a.a());
        this.ddq.a(new com.baidu.swan.apps.inlinewidget.f.a.b());
        this.ddq.a(new com.baidu.swan.apps.inlinewidget.f.a.c());
        this.ddq.a(new com.baidu.swan.apps.inlinewidget.f.a.d());
        this.ddq.a(new e());
        this.ddq.a(new f());
        this.ddq.a(new g());
        this.ddq.a(new h());
        this.ddq.a(new com.baidu.swan.apps.inlinewidget.f.a.j());
        this.ddq.a(new k());
        this.ddq.a(new l());
        this.ddq.a(new m());
        this.ddq.a(new o());
        this.ddq.a(new p());
        this.ddq.a(new s());
        this.ddq.a(new t());
        this.ddq.a(new n());
        this.ddq.a(new i());
        this.ddq.a(new r());
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
        if (command != null && TextUtils.equals(command.what, k.der)) {
            if (DEBUG) {
                Log.d("LiveInlineController", "isRejectCommand: exempt release command");
                return false;
            }
            return false;
        }
        int awH = ((com.baidu.swan.apps.inlinewidget.f.c.a) this.dds).awH();
        if (DEBUG && awH != 1) {
            Log.d("LiveInlineController", "isRejectCommand: authorize type => " + ((com.baidu.swan.apps.inlinewidget.f.c.a) this.dds).awH() + " command=> " + (command == null ? "" : command.what));
        }
        return awH == 2;
    }
}
