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
    private boolean atg;
    private com.baidu.swan.games.e.a bia;
    private boolean bib;
    private long bic;

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
        com.baidu.swan.games.n.a.SC().h(this.axz);
        if (bundle == null) {
            Dy();
        }
        x(this.akM);
        com.baidu.swan.games.r.b.Tj().clear();
    }

    @Override // com.baidu.swan.apps.o.d
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        com.baidu.swan.apps.w.e.GJ().bh(this.axz);
    }

    @Override // com.baidu.swan.apps.o.d
    public int vH() {
        return 1;
    }

    private void x(com.baidu.swan.apps.v.b.b bVar) {
        pw();
        if (bVar != null) {
            com.baidu.swan.apps.w.e.GJ().f(this.axz);
            com.baidu.swan.apps.w.e.GJ().a(bVar, new com.baidu.swan.apps.install.b() { // from class: com.baidu.swan.games.g.a.1
                @Override // com.baidu.swan.apps.install.b
                public void a(int i, com.baidu.swan.apps.install.a aVar) {
                    a.c cVar = (a.c) aVar;
                    if (cVar != null && !TextUtils.isEmpty(cVar.bjh)) {
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
        DuMixGameSurfaceView ca = com.baidu.swan.games.glsurface.a.Sn().ca(this.axz);
        ca.setRenderMode(1);
        com.baidu.swan.games.glsurface.a.Sn().f(ca);
        this.bia = com.baidu.swan.games.e.f.a(new g.a().eX(2).je("master").RT(), new b(cVar.bjh, cVar.bjj == null ? null : cVar.bjj.bkD), new C0212a(ca));
        this.bia.setFileSystemDelegatePolicy(new com.baidu.swan.games.e.c.d());
        this.bia.setContext(this.axz);
        ca.setV8Engine(this.bia);
        Sa();
    }

    @Override // com.baidu.swan.apps.o.d
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        f.aHe = false;
        com.baidu.swan.apps.v.b.b F = com.baidu.swan.apps.v.b.b.F(intent);
        if (!f(F)) {
            this.axz.A(intent);
            Dx();
            g(F);
            Dv();
            com.baidu.swan.apps.w.e.release();
            com.baidu.swan.games.r.b.Tj().clear();
            x(this.akM);
            Dw();
        } else {
            this.akM = F;
        }
        com.baidu.swan.apps.ae.b.n(this.akM);
        Dy();
        Sf();
        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
        if (Mh != null) {
            Mh.Ml().Nm();
            Mh.Mm().clear();
        }
    }

    @Override // com.baidu.swan.apps.o.d
    protected void DH() {
        this.axA.a(this);
    }

    @Override // com.baidu.swan.apps.core.d.e.a
    public void AB() {
        com.baidu.swan.games.n.a.SC().h(this.axz);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onDestroy() {
        com.baidu.swan.games.n.a.SC().HI();
        com.baidu.swan.apps.w.e.GJ().bi(this.axz);
        com.baidu.swan.apps.w.e.release();
        com.baidu.swan.games.u.a.Tw().release();
        if (this.bia != null) {
            this.bia.finish();
        }
        SwanInspectorEndpoint.Sw().close();
        com.baidu.swan.games.r.b.Tj().clear();
        super.onDestroy();
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return this.bia;
    }

    private void Sa() {
        this.axA.Az().B(0, 0).AF().c(h.AN()).AH();
    }

    @Override // com.baidu.swan.apps.o.d
    @NonNull
    protected a.d DC() {
        return new a.d() { // from class: com.baidu.swan.games.g.a.2
            @Override // com.baidu.swan.apps.process.messaging.client.a.d
            public boolean j(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.client.a.Jv().sendMessage(4);
                        a.this.Dz();
                        a.this.u(a.this.bia);
                        a.this.reset();
                        return true;
                    case 102:
                        boolean Fi = com.baidu.swan.apps.u.a.EJ().Fi();
                        com.baidu.swan.apps.u.a.EJ().bq(Fi);
                        a.this.g(Fi, false);
                        return true;
                    case 103:
                        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
                        if (Mh != null) {
                            Mh.Ml().clear();
                        }
                        a.this.Dz();
                        a.this.v(a.this.bia);
                        a.this.u(a.this.bia);
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
                        c.Tu().x((Bundle) message.obj);
                        return true;
                    case 112:
                        if (a.DEBUG) {
                            Log.e("SwanGameFrame", "MSG_TYPE_SC_GET_GAME_SUB_PACKAGE_SUCCESS");
                        }
                        c.Tu().w((Bundle) message.obj);
                        return true;
                    case 113:
                        if (a.DEBUG) {
                            Log.e("SwanGameFrame", "MSG_TYPE_SC_GET_GAME_SUB_PACKAGE_ON_PROGRESS");
                        }
                        c.Tu().z((Bundle) message.obj);
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
        private com.baidu.swan.games.inspector.a bij;
        private String mBasePath;

        public b(String str, com.baidu.swan.games.inspector.a aVar) {
            this.mBasePath = str;
            this.bij = aVar;
        }

        @Override // com.baidu.swan.games.e.d.b
        public V8EngineConfiguration.CodeCacheSetting Bf() {
            if (!com.baidu.swan.apps.u.a.Er().wx()) {
                return null;
            }
            return com.baidu.swan.apps.core.b.a.Y("gameframe", com.baidu.swan.games.i.a.bd(Bg(), Bh()));
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String Bg() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String Bh() {
            return Sg();
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void a(com.baidu.swan.games.e.a aVar) {
            new com.baidu.swan.games.binding.a().a(aVar, a.this.axz);
            new com.baidu.swan.games.binding.b().a(aVar, a.this.axz);
            aVar.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.games.g.a.b.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    if (a.DEBUG) {
                        Log.d("SwanGameFrame", "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath);
                    }
                    if (cacheInfo.cached && !TextUtils.isEmpty(cacheInfo.jsPath)) {
                        String bd = com.baidu.swan.games.i.a.bd(b.this.Bg(), b.this.Bh());
                        File file = new File(cacheInfo.jsPath);
                        try {
                            if (!TextUtils.isEmpty(bd) && file.getCanonicalPath().startsWith(new File(bd).getCanonicalPath())) {
                                a.this.atg = true;
                            } else if (!TextUtils.isEmpty(b.this.mBasePath) && file.getCanonicalPath().startsWith(new File(b.this.mBasePath).getCanonicalPath())) {
                                a.this.bib = true;
                            }
                        } catch (IOException e) {
                            if (a.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });
            f.fU("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_swan_game_js_start"));
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void b(final com.baidu.swan.games.e.a aVar) {
            f.fU("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_swan_game_js_end"));
            f.fU("startup").f(new UbcFlowEvent("na_load_swan_game_js_end"));
            if (com.baidu.swan.apps.u.a.Er().wx()) {
                aVar.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.Y("gamejs", this.mBasePath));
            }
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.games.g.a.b.2
                @Override // java.lang.Runnable
                public void run() {
                    f.fU("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_index_js_start"));
                    aVar.aV(b.this.Bg(), b.this.Sh());
                    f.fU("startup").f(new UbcFlowEvent("na_load_index_js_end"));
                    aVar.onLoad();
                }
            };
            aVar.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.g.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    a.C0214a a = com.baidu.swan.games.inspector.a.a(b.this.bij);
                    if (a.isEnabled()) {
                        SwanInspectorEndpoint.Sw().a(b.this.bij, a.this.bia, a, runnable);
                        return;
                    }
                    SwanInspectorEndpoint.Sw().a(a);
                    runnable.run();
                }
            });
            a.this.u(aVar);
        }

        private String Sg() {
            return "swan-game.js";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String Sh() {
            return "index.js";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.games.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0212a implements V8ThreadDelegatePolicy {
        private DuMixGameSurfaceView asn;

        C0212a(DuMixGameSurfaceView duMixGameSurfaceView) {
            this.asn = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(final V8Engine v8Engine) {
            if (a.DEBUG) {
                Log.d("SwanGameFrame", "startV8Engine");
            }
            this.asn.queueEvent(new Runnable() { // from class: com.baidu.swan.games.g.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.DEBUG) {
                        Log.d("SwanGameFrame", "startEngineInternal");
                    }
                    C0212a.this.asn.Sj();
                    v8Engine.startEngineInternal();
                    C0212a.this.asn.Sk();
                }
            });
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable) {
            this.asn.queueEvent(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            this.asn.queueEvent(runnable, j);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            return this.asn.getThread();
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
            aVar.RG();
        }
    }

    private void w(com.baidu.swan.games.e.a aVar) {
        if (aVar != null) {
            aVar.RH();
        }
    }

    @Override // com.baidu.swan.apps.o.d
    protected void Dv() {
        if (this.axG == null) {
            this.axG = new com.baidu.swan.apps.view.b(this.axz);
        }
        this.axG.h(true, this.akM != null && this.akM.getOrientation() == 1);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.d("SwanApp", "onBackPressed back stack count:" + this.axA.Ay());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.b Av = this.axA.Av();
        if (Av == null || !Av.xt()) {
            if (DI()) {
                com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
                if (Mh != null) {
                    Mh.Mq().release();
                }
                jC("back");
                return;
            }
            this.axA.dU("navigateBack").B(e.arW, e.arV).AD().commit();
        }
    }

    @Override // com.baidu.swan.apps.o.d
    public boolean isLandScape() {
        return this.akM != null && this.akM.getOrientation() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sb() {
        int i = 2;
        if (vP() != null && vP().getOrientation() == 1) {
            i = 3;
        }
        if (vK() != null) {
            vK().eL(i);
        }
    }

    private void pw() {
        this.bic = 0L;
        this.atg = false;
        this.bib = false;
    }

    public ArBridge.FirstFrameListener Sc() {
        return new ArBridge.FirstFrameListener() { // from class: com.baidu.swan.games.g.a.3
            @Override // com.baidu.smallgame.sdk.ArBridge.FirstFrameListener
            public void onFirstFrameFinished() {
                ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.g.a.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.DEBUG) {
                            Log.e("SwanGameFrame", "onFirstFrameFinished");
                        }
                        a.this.bic = System.currentTimeMillis();
                        a.this.Sf();
                        f.fU("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).ar("codecache", String.valueOf(com.baidu.swan.apps.core.b.a.e(a.this.atg, a.this.bib))).f(new UbcFlowEvent("na_first_paint")).Ir();
                        a.this.Sb();
                    }
                });
            }
        };
    }

    public boolean Sd() {
        return this.bic > 0;
    }

    public long Se() {
        return this.bic;
    }

    protected void Sf() {
        Bundle FO;
        if (this.akM != null && Sd() && (FO = this.akM.FO()) != null && FO.getLong("page_display_flag_for_statistic") > 0) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            a(fVar);
            FO.remove("page_display_flag_for_statistic");
        }
    }

    protected void jC(String str) {
        Bundle FO;
        if (this.akM != null && !Sd() && (FO = this.akM.FO()) != null && FO.getLong("page_display_flag_for_statistic") > 0) {
            long j = FO.getLong("ext_launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realcancel";
            fVar.aWx = String.valueOf(currentTimeMillis - j);
            fVar.k("reason", str);
            if (this.akM.FU() == 1) {
                fVar.k("errorList", com.baidu.swan.games.r.b.Tj().Tk());
            }
            a(fVar);
            FO.remove("page_display_flag_for_statistic");
        }
    }
}
