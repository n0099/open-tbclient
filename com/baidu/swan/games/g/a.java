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
import com.baidu.swan.games.subpackage.c;
import com.baidu.swan.games.utils.so.SoLoader;
/* loaded from: classes2.dex */
public class a extends d implements e.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.e.a bcM;

    static {
        SoLoader.load(AppRuntime.getAppContext(), "v8.engine");
    }

    public a(SwanAppActivity swanAppActivity) {
        super(swanAppActivity);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.swan.games.m.a.OA().h(this.avZ);
        if (bundle == null) {
            BJ();
        }
        v(this.ajy);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        com.baidu.swan.apps.w.e.Ea().bL(this.avZ);
    }

    @Override // com.baidu.swan.apps.o.d
    public int us() {
        return 1;
    }

    private void v(com.baidu.swan.apps.v.b.b bVar) {
        if (bVar != null) {
            com.baidu.swan.apps.w.e.Ea().f(this.avZ);
            com.baidu.swan.apps.w.e.Ea().a(bVar, new com.baidu.swan.apps.install.b() { // from class: com.baidu.swan.games.g.a.1
                @Override // com.baidu.swan.apps.install.b
                public void a(int i, com.baidu.swan.apps.install.a aVar) {
                    a.b bVar2 = (a.b) aVar;
                    if (bVar2 != null && !TextUtils.isEmpty(bVar2.bdG)) {
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
                DuMixGameSurfaceView cx = com.baidu.swan.games.glsurface.a.Oq().cx(a.this.avZ);
                cx.setRenderMode(1);
                com.baidu.swan.games.glsurface.a.Oq().f(cx);
                a.this.bcM = f.a(new g.a().eC(2).im("master").Ob(), new b(bVar.bdG, bVar.bdI == null ? null : bVar.bdI.bfc), new C0191a(cx));
                a.this.bcM.setFileSystemDelegatePolicy(new com.baidu.swan.games.e.c.d());
                a.this.bcM.setContext(a.this.avZ);
                cx.setV8Engine(a.this.bcM);
                a.this.Oj();
            }
        });
    }

    @Override // com.baidu.swan.apps.o.d
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        com.baidu.swan.apps.v.b.b G = com.baidu.swan.apps.v.b.b.G(intent);
        if (!f(G)) {
            this.avZ.B(intent);
            BI();
            g(G);
            BG();
            com.baidu.swan.apps.w.e.release();
            v(this.ajy);
            BH();
        } else {
            this.ajy = G;
        }
        com.baidu.swan.apps.ae.b.n(this.ajy);
        BJ();
        com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
        if (IV != null) {
            IV.IZ().JU();
            IV.Ja().clear();
        }
    }

    @Override // com.baidu.swan.apps.o.d
    protected void BS() {
        this.awa.a(this);
    }

    @Override // com.baidu.swan.apps.core.c.e.a
    public void yT() {
        com.baidu.swan.games.m.a.OA().h(this.avZ);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onDestroy() {
        com.baidu.swan.games.m.a.OA().ES();
        com.baidu.swan.apps.w.e.Ea().bM(this.avZ);
        com.baidu.swan.apps.w.e.release();
        com.baidu.swan.games.s.a.Pg().release();
        if (this.bcM != null) {
            this.bcM.finish();
        }
        SwanInspectorEndpoint.Ox().close();
        super.onDestroy();
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return this.bcM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oj() {
        this.awa.yR().A(0, 0).yX().b(h.zf()).yZ();
    }

    @Override // com.baidu.swan.apps.o.d
    @NonNull
    protected a.d BN() {
        return new a.d() { // from class: com.baidu.swan.games.g.a.3
            @Override // com.baidu.swan.apps.process.messaging.client.a.d
            public boolean j(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.client.a.Go().sendMessage(4);
                        a.this.BK();
                        a.this.l(a.this.bcM);
                        a.this.reset();
                        return true;
                    case 102:
                        boolean Dq = com.baidu.swan.apps.u.a.CR().Dq();
                        com.baidu.swan.apps.u.a.CR().bg(Dq);
                        a.this.g(Dq, false);
                        return true;
                    case 103:
                        com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
                        if (IV != null) {
                            IV.IZ().clear();
                        }
                        a.this.BK();
                        a.this.Oh();
                        a.this.l(a.this.bcM);
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
                        c.Pe().w((Bundle) message.obj);
                        return true;
                    case 112:
                        if (a.DEBUG) {
                            Log.e("SwanGameFrame", "MSG_TYPE_SC_GET_GAME_SUB_PACKAGE_SUCCESS");
                        }
                        c.Pe().v((Bundle) message.obj);
                        return true;
                    case 113:
                        if (a.DEBUG) {
                            Log.e("SwanGameFrame", "MSG_TYPE_SC_GET_GAME_SUB_PACKAGE_ON_PROGRESS");
                        }
                        c.Pe().y((Bundle) message.obj);
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
        private com.baidu.swan.games.inspector.a bcS;
        private String mBasePath;

        public b(String str, com.baidu.swan.games.inspector.a aVar) {
            this.mBasePath = str;
            this.bcS = aVar;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String zt() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String zu() {
            return Om();
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void a(com.baidu.swan.games.e.a aVar) {
            new com.baidu.swan.games.binding.a().a(aVar, a.this.avZ);
            new com.baidu.swan.games.binding.b().a(aVar, a.this.avZ);
            com.baidu.swan.apps.performance.f.fz("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_swan_game_js_start"));
        }

        private String Om() {
            return "swan-game.js";
        }
    }

    /* renamed from: com.baidu.swan.games.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0191a implements V8ThreadDelegatePolicy {
        private DuMixGameSurfaceView arh;

        C0191a(DuMixGameSurfaceView duMixGameSurfaceView) {
            this.arh = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(final V8Engine v8Engine) {
            if (a.DEBUG) {
                Log.d("SwanGameFrame", "startV8Engine");
            }
            this.arh.queueEvent(new Runnable() { // from class: com.baidu.swan.games.g.a.a.1
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
            this.arh.queueEvent(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            return this.arh.getThread();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oh() {
        com.baidu.swan.games.f.g.Oh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(com.baidu.swan.games.e.a aVar) {
        if (aVar != null) {
            aVar.NQ();
        }
    }

    @Override // com.baidu.swan.apps.o.d
    protected void BG() {
        if (this.awg == null) {
            this.awg = new com.baidu.swan.apps.view.b(this.avZ);
        }
        this.awg.h(true, this.ajy != null && this.ajy.orientation == 1);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.d("SwanApp", "onBackPressed back stack count:" + this.awa.yQ());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.c.b yN = this.awa.yN();
        if (yN == null || !yN.vX()) {
            if (BT()) {
                com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
                if (IV != null) {
                    IV.Je().release();
                    return;
                }
                return;
            }
            this.awa.ea("navigateBack").A(e.aqQ, e.aqP).yV().commit();
        }
    }

    @Override // com.baidu.swan.apps.o.d
    public boolean isLandScape() {
        return this.ajy != null && this.ajy.orientation == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ok() {
        int i = 2;
        if (uA() != null && uA().orientation == 1) {
            i = 3;
        }
        uv().ev(i);
    }

    public ArBridge.FirstFrameListener Ol() {
        return new ArBridge.FirstFrameListener() { // from class: com.baidu.swan.games.g.a.4
            @Override // com.baidu.smallgame.sdk.ArBridge.FirstFrameListener
            public void onFirstFrameFinished() {
                aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.g.a.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.DEBUG) {
                            Log.e("SwanGameFrame", "onFirstFrameFinished");
                        }
                        com.baidu.swan.apps.performance.f.fz("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_first_paint")).Ft();
                        a.this.Ok();
                    }
                });
            }
        };
    }
}
