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
/* loaded from: classes8.dex */
final class a extends com.baidu.swan.apps.inlinewidget.b<com.baidu.swan.apps.inlinewidget.f.c.a> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final a.InterfaceC0435a dfQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        super(aVar);
        this.dfQ = new a.InterfaceC0435a() { // from class: com.baidu.swan.apps.inlinewidget.f.a.1
            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void onPrepared() {
                if (a.this.deU != null) {
                    a.this.deU.onCallback(a.this, "onPrepared", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void ot(String str) {
                if (a.this.deU != null) {
                    a.this.deU.onCallback(a.this, "onPlayed", null);
                }
                j.akv().O(str, true);
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void ou(String str) {
                if (a.this.deU != null) {
                    a.this.deU.onCallback(a.this, "onPaused", null);
                }
                if (!TextUtils.isEmpty(str)) {
                    j.akv().O(str, false);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void onEnded() {
                if (a.this.deU != null) {
                    a.this.deU.onCallback(a.this, "onEnded", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void onError(int i) {
                if (a.this.deU != null) {
                    a.this.deU.onCallback(a.this, "onError", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void hI(int i) {
                if (a.this.deU != null) {
                    a.this.deU.onCallback(a.this, "onInfo", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void aww() {
                if (a.this.deU != null) {
                    a.this.deU.onCallback(a.this, "onVideoSizeChanged", null);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void hJ(int i) {
                if (a.this.deU != null) {
                    a.this.deU.onCallback(a.this, "onStateChange", Integer.valueOf(i));
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void ov(@NonNull String str) {
                if (a.this.deU != null) {
                    a.this.deU.onCallback(a.this, "onNetStatus", str);
                }
            }

            @Override // com.baidu.swan.apps.inlinewidget.f.c.a.InterfaceC0435a
            public void gE(String str) {
                j.akv().lx(str);
            }
        };
        aVar.a(this.dfQ);
        j.akv().a(aVar);
        this.deT.a(new com.baidu.swan.apps.inlinewidget.f.a.a());
        this.deT.a(new com.baidu.swan.apps.inlinewidget.f.a.b());
        this.deT.a(new com.baidu.swan.apps.inlinewidget.f.a.c());
        this.deT.a(new com.baidu.swan.apps.inlinewidget.f.a.d());
        this.deT.a(new e());
        this.deT.a(new f());
        this.deT.a(new g());
        this.deT.a(new h());
        this.deT.a(new com.baidu.swan.apps.inlinewidget.f.a.j());
        this.deT.a(new k());
        this.deT.a(new l());
        this.deT.a(new m());
        this.deT.a(new o());
        this.deT.a(new p());
        this.deT.a(new s());
        this.deT.a(new t());
        this.deT.a(new n());
        this.deT.a(new i());
        this.deT.a(new r());
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
        if (command != null && TextUtils.equals(command.what, k.dfT)) {
            if (DEBUG) {
                Log.d("LiveInlineController", "isRejectCommand: exempt release command");
                return false;
            }
            return false;
        }
        int awK = ((com.baidu.swan.apps.inlinewidget.f.c.a) this.deV).awK();
        if (DEBUG && awK != 1) {
            Log.d("LiveInlineController", "isRejectCommand: authorize type => " + ((com.baidu.swan.apps.inlinewidget.f.c.a) this.deV).awK() + " command=> " + (command == null ? "" : command.what));
        }
        return awK == 2;
    }
}
