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
    private final a.InterfaceC0447a cWJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        super(aVar);
        this.cWJ = new a.InterfaceC0447a() { // from class: com.baidu.swan.apps.inlinewidget.f.a.1
            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0447a
            public void onPrepared() {
                if (a.this.cVN != null) {
                    a.this.cVN.onCallback(a.this, "onPrepared", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0447a
            public void oL(String str) {
                if (a.this.cVN != null) {
                    a.this.cVN.onCallback(a.this, "onPlayed", null);
                }
                j.akd().O(str, true);
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0447a
            public void oM(String str) {
                if (a.this.cVN != null) {
                    a.this.cVN.onCallback(a.this, "onPaused", null);
                }
                if (!TextUtils.isEmpty(str)) {
                    j.akd().O(str, false);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0447a
            public void onEnded() {
                if (a.this.cVN != null) {
                    a.this.cVN.onCallback(a.this, "onEnded", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0447a
            public void onError(int i) {
                if (a.this.cVN != null) {
                    a.this.cVN.onCallback(a.this, "onError", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0447a
            public void iV(int i) {
                if (a.this.cVN != null) {
                    a.this.cVN.onCallback(a.this, "onInfo", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0447a
            public void avX() {
                if (a.this.cVN != null) {
                    a.this.cVN.onCallback(a.this, "onVideoSizeChanged", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0447a
            public void iW(int i) {
                if (a.this.cVN != null) {
                    a.this.cVN.onCallback(a.this, "onStateChange", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0447a
            public void oN(@NonNull String str) {
                if (a.this.cVN != null) {
                    a.this.cVN.onCallback(a.this, "onNetStatus", str);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0447a
            public void hm(String str) {
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
        this.cVM.a(new s());
        this.cVM.a(new t());
        this.cVM.a(new n());
        this.cVM.a(new i());
        this.cVM.a(new r());
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
        if (command != null && TextUtils.equals(command.what, k.cWM)) {
            if (DEBUG) {
                Log.d("LiveInlineController", "isRejectCommand: exempt release command");
                return false;
            }
            return false;
        }
        int awl = ((com.baidu.swan.apps.inlinewidget.f.c.a) this.cVO).awl();
        if (DEBUG && awl != 1) {
            Log.d("LiveInlineController", "isRejectCommand: authorize type => " + ((com.baidu.swan.apps.inlinewidget.f.c.a) this.cVO).awl() + " command=> " + (command == null ? "" : command.what));
        }
        return awl == 2;
    }
}
