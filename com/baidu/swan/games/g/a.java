package com.baidu.swan.games.g;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.smallgame.sdk.ArBridge;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.c;
import com.baidu.swan.apps.core.a.i;
import com.baidu.swan.apps.core.c.e;
import com.baidu.swan.apps.core.c.h;
import com.baidu.swan.apps.o.d;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.messaging.client.a;
import com.baidu.swan.games.e.f;
import com.baidu.swan.games.e.g;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.swan.games.i.a;
import com.baidu.swan.games.inspector.SwanInspectorEndpoint;
import com.baidu.swan.games.utils.so.SoLoader;
/* loaded from: classes2.dex */
public class a extends d implements e.a {
    private static final boolean DEBUG = c.DEBUG;
    private com.baidu.swan.games.e.a bcH;

    static {
        SoLoader.load(AppRuntime.getAppContext(), "v8.engine");
    }

    public a(SwanAppActivity swanAppActivity) {
        super(swanAppActivity);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.swan.games.m.a.OC().h(this.avU);
        if (bundle == null) {
            BL();
        }
        v(this.ajs);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        com.baidu.swan.apps.w.e.Ec().bL(this.avU);
    }

    @Override // com.baidu.swan.apps.o.d
    public int ut() {
        return 1;
    }

    private void v(com.baidu.swan.apps.v.b.b bVar) {
        if (bVar != null) {
            com.baidu.swan.apps.w.e.Ec().f(this.avU);
            com.baidu.swan.apps.w.e.Ec().a(bVar, new com.baidu.swan.apps.install.b() { // from class: com.baidu.swan.games.g.a.1
                @Override // com.baidu.swan.apps.install.b
                public void a(int i, com.baidu.swan.apps.install.a aVar) {
                    a.b bVar2 = (a.b) aVar;
                    if (bVar2 != null && !TextUtils.isEmpty(bVar2.bdB)) {
                        a.this.a(bVar2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a.b bVar) {
        aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.g.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.DEBUG) {
                    Log.d("SwanGameFrame", "onLoadedSuccess");
                }
                DuMixGameSurfaceView cx = com.baidu.swan.games.glsurface.a.Os().cx(a.this.avU);
                cx.setRenderMode(1);
                com.baidu.swan.games.glsurface.a.Os().f(cx);
                a.this.bcH = f.a(new g.a().eD(2).il("master").Od(), new b(bVar.bdB, bVar.bdD == null ? null : bVar.bdD.beW), new C0162a(cx));
                a.this.bcH.setFileSystemDelegatePolicy(new com.baidu.swan.games.e.c.d());
                a.this.bcH.setContext(a.this.avU);
                cx.setV8Engine(a.this.bcH);
                a.this.Ol();
            }
        });
    }

    @Override // com.baidu.swan.apps.o.d
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        com.baidu.swan.apps.v.b.b G = com.baidu.swan.apps.v.b.b.G(intent);
        if (!f(G)) {
            this.avU.B(intent);
            BK();
            g(G);
            BI();
            com.baidu.swan.apps.w.e.release();
            v(this.ajs);
            BJ();
        } else {
            this.ajs = G;
        }
        com.baidu.swan.apps.ae.b.n(this.ajs);
        BL();
        com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
        if (IX != null) {
            IX.Jb().JW();
            IX.Jc().clear();
        }
    }

    @Override // com.baidu.swan.apps.o.d
    protected void BU() {
        this.avV.a(this);
    }

    @Override // com.baidu.swan.apps.core.c.e.a
    public void yU() {
        com.baidu.swan.games.m.a.OC().h(this.avU);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onDestroy() {
        com.baidu.swan.games.m.a.OC().EU();
        com.baidu.swan.apps.w.e.Ec().bM(this.avU);
        com.baidu.swan.apps.w.e.release();
        com.baidu.swan.games.s.a.Pi().release();
        if (this.bcH != null) {
            this.bcH.finish();
        }
        SwanInspectorEndpoint.Oz().close();
        super.onDestroy();
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return this.bcH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ol() {
        this.avV.yS().A(0, 0).yY().b(h.zg()).za();
    }

    @Override // com.baidu.swan.apps.o.d
    @NonNull
    protected a.d BP() {
        return new a.d() { // from class: com.baidu.swan.games.g.a.3
            @Override // com.baidu.swan.apps.process.messaging.client.a.d
            public boolean j(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.client.a.Gq().sendMessage(4);
                        a.this.BM();
                        a.this.l(a.this.bcH);
                        a.this.reset();
                        return true;
                    case 102:
                        boolean Ds = com.baidu.swan.apps.u.a.CT().Ds();
                        com.baidu.swan.apps.u.a.CT().bg(Ds);
                        a.this.g(Ds, false);
                        return true;
                    case 103:
                        com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
                        if (IX != null) {
                            IX.Jb().clear();
                        }
                        a.this.BM();
                        a.this.Oj();
                        a.this.l(a.this.bcH);
                        return true;
                    case 106:
                        a.this.reset();
                        return true;
                    case 107:
                        i.i(message);
                        return true;
                    case 111:
                        if (a.DEBUG) {
                            Log.e("SwanGameFrame", "MSG_TYPE_SC_GET_GAME_SUB_PACKAGE_FAILED");
                        }
                        com.baidu.swan.games.subpackage.c.Pg().w((Bundle) message.obj);
                        return true;
                    case 112:
                        if (a.DEBUG) {
                            Log.e("SwanGameFrame", "MSG_TYPE_SC_GET_GAME_SUB_PACKAGE_SUCCESS");
                        }
                        com.baidu.swan.games.subpackage.c.Pg().v((Bundle) message.obj);
                        return true;
                    case 113:
                        if (a.DEBUG) {
                            Log.e("SwanGameFrame", "MSG_TYPE_SC_GET_GAME_SUB_PACKAGE_ON_PROGRESS");
                        }
                        com.baidu.swan.games.subpackage.c.Pg().y((Bundle) message.obj);
                        return true;
                    case 301:
                        com.baidu.swan.apps.process.messaging.a.a.l(message);
                        return true;
                    case 302:
                        com.baidu.swan.apps.process.messaging.a.a.o(message);
                        return true;
                    default:
                        return false;
                }
            }
        };
    }

    /* loaded from: classes2.dex */
    private class b extends com.baidu.swan.games.e.d.a {
        private com.baidu.swan.games.inspector.a bcN;
        private String mBasePath;

        public b(String str, com.baidu.swan.games.inspector.a aVar) {
            this.mBasePath = str;
            this.bcN = aVar;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String zu() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String zv() {
            return Oo();
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void a(com.baidu.swan.games.e.a aVar) {
            new com.baidu.swan.games.binding.a().a(aVar, a.this.avU);
            new com.baidu.swan.games.binding.b().a(aVar, a.this.avU);
            com.baidu.swan.apps.performance.f.fy("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_swan_game_js_start"));
        }

        private String Oo() {
            return "swan-game.js";
        }
    }

    /* renamed from: com.baidu.swan.games.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0162a implements V8ThreadDelegatePolicy {
        private DuMixGameSurfaceView arb;

        C0162a(DuMixGameSurfaceView duMixGameSurfaceView) {
            this.arb = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(final V8Engine v8Engine) {
            if (a.DEBUG) {
                Log.d("SwanGameFrame", "startV8Engine");
            }
            this.arb.queueEvent(new Runnable() { // from class: com.baidu.swan.games.g.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.DEBUG) {
                        Log.d("SwanGameFrame", "startEngineInternal");
                    }
                    v8Engine.startEngineInternal();
                }
            });
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable) {
            this.arb.queueEvent(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            return this.arb.getThread();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oj() {
        com.baidu.swan.games.f.g.Oj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(com.baidu.swan.games.e.a aVar) {
        if (aVar != null) {
            aVar.NS();
        }
    }

    @Override // com.baidu.swan.apps.o.d
    protected void BI() {
        if (this.awb == null) {
            this.awb = new com.baidu.swan.apps.view.b(this.avU);
        }
        this.awb.h(true, this.ajs != null && this.ajs.orientation == 1);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.d("SwanApp", "onBackPressed back stack count:" + this.avV.yR());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.c.b yO = this.avV.yO();
        if (yO == null || !yO.vY()) {
            if (BV()) {
                com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
                if (IX != null) {
                    IX.Jg().release();
                    return;
                }
                return;
            }
            this.avV.dY("navigateBack").A(e.aqK, e.aqJ).yW().commit();
        }
    }

    @Override // com.baidu.swan.apps.o.d
    public boolean isLandScape() {
        return this.ajs != null && this.ajs.orientation == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Om() {
        int i = 2;
        if (uB() != null && uB().orientation == 1) {
            i = 3;
        }
        uw().ew(i);
    }

    public ArBridge.FirstFrameListener On() {
        return new ArBridge.FirstFrameListener() { // from class: com.baidu.swan.games.g.a.4
            @Override // com.baidu.smallgame.sdk.ArBridge.FirstFrameListener
            public void onFirstFrameFinished() {
                aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.g.a.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.DEBUG) {
                            Log.e("SwanGameFrame", "onFirstFrameFinished");
                        }
                        com.baidu.swan.apps.performance.f.fy("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_first_paint")).Fv();
                        a.this.Om();
                    }
                });
            }
        };
    }
}
