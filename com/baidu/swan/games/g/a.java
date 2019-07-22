package com.baidu.swan.games.g;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.smallgame.sdk.ArBridge;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.core.a.i;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.core.d.h;
import com.baidu.swan.apps.o.d;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.f;
import com.baidu.swan.apps.process.messaging.client.a;
import com.baidu.swan.games.e.g;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.swan.games.i.a;
import com.baidu.swan.games.inspector.SwanInspectorEndpoint;
import com.baidu.swan.games.inspector.a;
import com.baidu.swan.games.subpackage.c;
import com.baidu.swan.games.utils.so.SoLoader;
import java.io.File;
import java.io.IOException;
/* loaded from: classes2.dex */
public class a extends d implements e.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean asI;
    private com.baidu.swan.games.e.a bhC;
    private boolean bhD;
    private long bhE;

    static {
        SoLoader.load(AppRuntime.getAppContext(), "v8.engine");
    }

    public a(SwanAppActivity swanAppActivity) {
        super(swanAppActivity);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onCreate(Bundle bundle) {
        f.a(bundle != null, getIntent());
        f.c(System.currentTimeMillis(), false);
        super.onCreate(bundle);
        com.baidu.swan.games.n.a.Sy().h(this.axb);
        if (bundle == null) {
            Du();
        }
        x(this.ako);
        com.baidu.swan.games.r.b.Tf().clear();
    }

    @Override // com.baidu.swan.apps.o.d
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        com.baidu.swan.apps.w.e.GF().bh(this.axb);
    }

    @Override // com.baidu.swan.apps.o.d
    public int vD() {
        return 1;
    }

    private void x(com.baidu.swan.apps.v.b.b bVar) {
        pv();
        if (bVar != null) {
            com.baidu.swan.apps.w.e.GF().f(this.axb);
            com.baidu.swan.apps.w.e.GF().a(bVar, new com.baidu.swan.apps.install.b() { // from class: com.baidu.swan.games.g.a.1
                @Override // com.baidu.swan.apps.install.b
                public void a(int i, com.baidu.swan.apps.install.a aVar) {
                    a.c cVar = (a.c) aVar;
                    if (cVar != null && !TextUtils.isEmpty(cVar.biJ)) {
                        a.this.a(cVar);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void a(a.c cVar) {
        if (DEBUG) {
            Log.d("SwanGameFrame", "onLoadedSuccess");
        }
        DuMixGameSurfaceView ca = com.baidu.swan.games.glsurface.a.Sj().ca(this.axb);
        ca.setRenderMode(1);
        com.baidu.swan.games.glsurface.a.Sj().f(ca);
        this.bhC = com.baidu.swan.games.e.f.a(new g.a().eW(2).jc("master").RP(), new b(cVar.biJ, cVar.biL == null ? null : cVar.biL.bkf), new C0198a(ca));
        this.bhC.setFileSystemDelegatePolicy(new com.baidu.swan.games.e.c.d());
        this.bhC.setContext(this.axb);
        ca.setV8Engine(this.bhC);
        RW();
    }

    @Override // com.baidu.swan.apps.o.d
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        f.aGG = false;
        com.baidu.swan.apps.v.b.b F = com.baidu.swan.apps.v.b.b.F(intent);
        if (!f(F)) {
            this.axb.A(intent);
            Dt();
            g(F);
            Dr();
            com.baidu.swan.apps.w.e.release();
            com.baidu.swan.games.r.b.Tf().clear();
            x(this.ako);
            Ds();
        } else {
            this.ako = F;
        }
        com.baidu.swan.apps.ae.b.n(this.ako);
        Du();
        Sb();
        com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
        if (Md != null) {
            Md.Mh().Ni();
            Md.Mi().clear();
        }
    }

    @Override // com.baidu.swan.apps.o.d
    protected void DD() {
        this.axc.a(this);
    }

    @Override // com.baidu.swan.apps.core.d.e.a
    public void Ax() {
        com.baidu.swan.games.n.a.Sy().h(this.axb);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onDestroy() {
        com.baidu.swan.games.n.a.Sy().HE();
        com.baidu.swan.apps.w.e.GF().bi(this.axb);
        com.baidu.swan.apps.w.e.release();
        com.baidu.swan.games.u.a.Ts().release();
        if (this.bhC != null) {
            this.bhC.finish();
        }
        SwanInspectorEndpoint.Ss().close();
        com.baidu.swan.games.r.b.Tf().clear();
        super.onDestroy();
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return this.bhC;
    }

    private void RW() {
        this.axc.Av().B(0, 0).AB().c(h.AJ()).AD();
    }

    @Override // com.baidu.swan.apps.o.d
    @NonNull
    protected a.d Dy() {
        return new a.d() { // from class: com.baidu.swan.games.g.a.2
            @Override // com.baidu.swan.apps.process.messaging.client.a.d
            public boolean j(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.client.a.Jr().sendMessage(4);
                        a.this.Dv();
                        a.this.u(a.this.bhC);
                        a.this.reset();
                        return true;
                    case 102:
                        boolean Fe = com.baidu.swan.apps.u.a.EF().Fe();
                        com.baidu.swan.apps.u.a.EF().bq(Fe);
                        a.this.g(Fe, false);
                        return true;
                    case 103:
                        com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
                        if (Md != null) {
                            Md.Mh().clear();
                        }
                        a.this.Dv();
                        a.this.v(a.this.bhC);
                        a.this.u(a.this.bhC);
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
                        c.Tq().x((Bundle) message.obj);
                        return true;
                    case 112:
                        if (a.DEBUG) {
                            Log.e("SwanGameFrame", "MSG_TYPE_SC_GET_GAME_SUB_PACKAGE_SUCCESS");
                        }
                        c.Tq().w((Bundle) message.obj);
                        return true;
                    case 113:
                        if (a.DEBUG) {
                            Log.e("SwanGameFrame", "MSG_TYPE_SC_GET_GAME_SUB_PACKAGE_ON_PROGRESS");
                        }
                        c.Tq().z((Bundle) message.obj);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends com.baidu.swan.games.e.d.a {
        private com.baidu.swan.games.inspector.a bhJ;
        private String mBasePath;

        public b(String str, com.baidu.swan.games.inspector.a aVar) {
            this.mBasePath = str;
            this.bhJ = aVar;
        }

        @Override // com.baidu.swan.games.e.d.b
        public V8EngineConfiguration.CodeCacheSetting Bb() {
            if (!com.baidu.swan.apps.u.a.En().wt()) {
                return null;
            }
            return com.baidu.swan.apps.core.b.a.Y("gameframe", com.baidu.swan.games.i.a.bd(Bc(), Bd()));
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String Bc() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String Bd() {
            return Sc();
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void a(com.baidu.swan.games.e.a aVar) {
            new com.baidu.swan.games.binding.a().a(aVar, a.this.axb);
            new com.baidu.swan.games.binding.b().a(aVar, a.this.axb);
            aVar.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.games.g.a.b.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    if (a.DEBUG) {
                        Log.d("SwanGameFrame", "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath);
                    }
                    if (cacheInfo.cached && !TextUtils.isEmpty(cacheInfo.jsPath)) {
                        String bd = com.baidu.swan.games.i.a.bd(b.this.Bc(), b.this.Bd());
                        File file = new File(cacheInfo.jsPath);
                        try {
                            if (!TextUtils.isEmpty(bd) && file.getCanonicalPath().startsWith(new File(bd).getCanonicalPath())) {
                                a.this.asI = true;
                            } else if (!TextUtils.isEmpty(b.this.mBasePath) && file.getCanonicalPath().startsWith(new File(b.this.mBasePath).getCanonicalPath())) {
                                a.this.bhD = true;
                            }
                        } catch (IOException e) {
                            if (a.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });
            f.fS("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_swan_game_js_start"));
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void b(final com.baidu.swan.games.e.a aVar) {
            f.fS("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_swan_game_js_end"));
            f.fS("startup").f(new UbcFlowEvent("na_load_swan_game_js_end"));
            if (com.baidu.swan.apps.u.a.En().wt()) {
                aVar.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.Y("gamejs", this.mBasePath));
            }
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.games.g.a.b.2
                @Override // java.lang.Runnable
                public void run() {
                    f.fS("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_index_js_start"));
                    aVar.aV(b.this.Bc(), b.this.Sd());
                    f.fS("startup").f(new UbcFlowEvent("na_load_index_js_end"));
                    aVar.onLoad();
                }
            };
            aVar.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.g.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    a.C0200a a = com.baidu.swan.games.inspector.a.a(b.this.bhJ);
                    if (a.isEnabled()) {
                        SwanInspectorEndpoint.Ss().a(b.this.bhJ, a.this.bhC, a, runnable);
                        return;
                    }
                    SwanInspectorEndpoint.Ss().a(a);
                    runnable.run();
                }
            });
            a.this.u(aVar);
        }

        private String Sc() {
            return "swan-game.js";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String Sd() {
            return "index.js";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.games.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0198a implements V8ThreadDelegatePolicy {
        private DuMixGameSurfaceView arP;

        C0198a(DuMixGameSurfaceView duMixGameSurfaceView) {
            this.arP = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(final V8Engine v8Engine) {
            if (a.DEBUG) {
                Log.d("SwanGameFrame", "startV8Engine");
            }
            this.arP.queueEvent(new Runnable() { // from class: com.baidu.swan.games.g.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.DEBUG) {
                        Log.d("SwanGameFrame", "startEngineInternal");
                    }
                    C0198a.this.arP.Sf();
                    v8Engine.startEngineInternal();
                    C0198a.this.arP.Sg();
                }
            });
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable) {
            this.arP.queueEvent(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            this.arP.queueEvent(runnable, j);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            return this.arP.getThread();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(com.baidu.swan.games.e.a aVar) {
        if (aVar != null) {
            v(aVar);
            w(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(com.baidu.swan.games.e.a aVar) {
        if (aVar != null) {
            aVar.RC();
        }
    }

    private void w(com.baidu.swan.games.e.a aVar) {
        if (aVar != null) {
            aVar.RD();
        }
    }

    @Override // com.baidu.swan.apps.o.d
    protected void Dr() {
        if (this.axi == null) {
            this.axi = new com.baidu.swan.apps.view.b(this.axb);
        }
        this.axi.h(true, this.ako != null && this.ako.getOrientation() == 1);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.d("SwanApp", "onBackPressed back stack count:" + this.axc.Au());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.b Ar = this.axc.Ar();
        if (Ar == null || !Ar.xp()) {
            if (DE()) {
                com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
                if (Md != null) {
                    Md.Mm().release();
                }
                jA("back");
                return;
            }
            this.axc.dS("navigateBack").B(e.ary, e.arx).Az().commit();
        }
    }

    @Override // com.baidu.swan.apps.o.d
    public boolean isLandScape() {
        return this.ako != null && this.ako.getOrientation() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RX() {
        int i = 2;
        if (vL() != null && vL().getOrientation() == 1) {
            i = 3;
        }
        if (vG() != null) {
            vG().eK(i);
        }
    }

    private void pv() {
        this.bhE = 0L;
        this.asI = false;
        this.bhD = false;
    }

    public ArBridge.FirstFrameListener RY() {
        return new ArBridge.FirstFrameListener() { // from class: com.baidu.swan.games.g.a.3
            @Override // com.baidu.smallgame.sdk.ArBridge.FirstFrameListener
            public void onFirstFrameFinished() {
                ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.g.a.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.DEBUG) {
                            Log.e("SwanGameFrame", "onFirstFrameFinished");
                        }
                        a.this.bhE = System.currentTimeMillis();
                        a.this.Sb();
                        f.fS("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).ar("codecache", String.valueOf(com.baidu.swan.apps.core.b.a.e(a.this.asI, a.this.bhD))).f(new UbcFlowEvent("na_first_paint")).In();
                        a.this.RX();
                    }
                });
            }
        };
    }

    public boolean RZ() {
        return this.bhE > 0;
    }

    public long Sa() {
        return this.bhE;
    }

    protected void Sb() {
        Bundle FK;
        if (this.ako != null && RZ() && (FK = this.ako.FK()) != null && FK.getLong("page_display_flag_for_statistic") > 0) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            a(fVar);
            FK.remove("page_display_flag_for_statistic");
        }
    }

    protected void jA(String str) {
        Bundle FK;
        if (this.ako != null && !RZ() && (FK = this.ako.FK()) != null && FK.getLong("page_display_flag_for_statistic") > 0) {
            long j = FK.getLong("ext_launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realcancel";
            fVar.aVZ = String.valueOf(currentTimeMillis - j);
            fVar.k("reason", str);
            if (this.ako.FQ() == 1) {
                fVar.k("errorList", com.baidu.swan.games.r.b.Tf().Tg());
            }
            a(fVar);
            FK.remove("page_display_flag_for_statistic");
        }
    }
}
