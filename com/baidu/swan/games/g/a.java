package com.baidu.swan.games.g;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
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
    private boolean aMf;
    private boolean bAa;
    private long bAb;
    private com.baidu.swan.games.e.a bzZ;

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
        com.baidu.swan.games.n.a.Xr().h(this.aQw);
        if (bundle == null) {
            It();
        }
        x(this.aDQ);
        com.baidu.swan.games.r.b.XY().clear();
    }

    @Override // com.baidu.swan.apps.o.d
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        com.baidu.swan.apps.w.e.LE().bj(this.aQw);
    }

    @Override // com.baidu.swan.apps.o.d
    public int AC() {
        return 1;
    }

    private void x(com.baidu.swan.apps.v.b.b bVar) {
        kr();
        if (bVar != null) {
            com.baidu.swan.apps.w.e.LE().f(this.aQw);
            com.baidu.swan.apps.w.e.LE().a(bVar, new com.baidu.swan.apps.install.b() { // from class: com.baidu.swan.games.g.a.1
                @Override // com.baidu.swan.apps.install.b
                public void a(int i, com.baidu.swan.apps.install.a aVar) {
                    a.c cVar = (a.c) aVar;
                    if (cVar != null && !TextUtils.isEmpty(cVar.bBe)) {
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
        DuMixGameSurfaceView ca = com.baidu.swan.games.glsurface.a.Xc().ca(this.aQw);
        ca.setRenderMode(1);
        com.baidu.swan.games.glsurface.a.Xc().f(ca);
        this.bzZ = com.baidu.swan.games.e.f.a(new g.a().fR(2).jH("master").WI(), new b(cVar.bBe, cVar.bBg == null ? null : cVar.bBg.bCA), new C0239a(ca));
        this.bzZ.setFileSystemDelegatePolicy(new com.baidu.swan.games.e.c.d());
        this.bzZ.setContext(this.aQw);
        ca.setV8Engine(this.bzZ);
        WP();
    }

    @Override // com.baidu.swan.apps.o.d
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        f.bab = false;
        com.baidu.swan.apps.v.b.b L = com.baidu.swan.apps.v.b.b.L(intent);
        if (!f(L)) {
            this.aQw.G(intent);
            Is();
            g(L);
            Iq();
            com.baidu.swan.apps.w.e.release();
            com.baidu.swan.games.r.b.XY().clear();
            x(this.aDQ);
            Ir();
        } else {
            this.aDQ = L;
        }
        com.baidu.swan.apps.ae.b.n(this.aDQ);
        It();
        WU();
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        if (Ra != null) {
            Ra.Rf().Se();
            Ra.Rg().clear();
        }
    }

    @Override // com.baidu.swan.apps.o.d
    protected void IC() {
        this.aQx.a(this);
    }

    @Override // com.baidu.swan.apps.core.d.e.a
    public void Fx() {
        com.baidu.swan.games.n.a.Xr().h(this.aQw);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onDestroy() {
        com.baidu.swan.games.n.a.Xr().MD();
        com.baidu.swan.apps.w.e.LE().bk(this.aQw);
        com.baidu.swan.apps.w.e.release();
        com.baidu.swan.games.u.a.Yl().release();
        if (this.bzZ != null) {
            this.bzZ.finish();
        }
        SwanInspectorEndpoint.Xl().close();
        com.baidu.swan.games.r.b.XY().clear();
        super.onDestroy();
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return this.bzZ;
    }

    private void WP() {
        this.aQx.Fv().F(0, 0).FB().c(h.FJ()).FD();
    }

    @Override // com.baidu.swan.apps.o.d
    @NonNull
    protected a.d Ix() {
        return new a.d() { // from class: com.baidu.swan.games.g.a.2
            @Override // com.baidu.swan.apps.process.messaging.client.a.d
            public boolean j(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.client.a.Oq().sendMessage(4);
                        a.this.Iu();
                        a.this.u(a.this.bzZ);
                        a.this.reset();
                        return true;
                    case 102:
                        boolean Kd = com.baidu.swan.apps.u.a.JE().Kd();
                        com.baidu.swan.apps.u.a.JE().bI(Kd);
                        a.this.k(Kd, false);
                        return true;
                    case 103:
                        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
                        if (Ra != null) {
                            Ra.Rf().clear();
                        }
                        a.this.Iu();
                        a.this.v(a.this.bzZ);
                        a.this.u(a.this.bzZ);
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
                        c.Yj().x((Bundle) message.obj);
                        return true;
                    case 112:
                        if (a.DEBUG) {
                            Log.e("SwanGameFrame", "MSG_TYPE_SC_GET_GAME_SUB_PACKAGE_SUCCESS");
                        }
                        c.Yj().w((Bundle) message.obj);
                        return true;
                    case 113:
                        if (a.DEBUG) {
                            Log.e("SwanGameFrame", "MSG_TYPE_SC_GET_GAME_SUB_PACKAGE_ON_PROGRESS");
                        }
                        c.Yj().z((Bundle) message.obj);
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
        private com.baidu.swan.games.inspector.a bAg;
        private String mBasePath;

        public b(String str, com.baidu.swan.games.inspector.a aVar) {
            this.mBasePath = str;
            this.bAg = aVar;
        }

        @Override // com.baidu.swan.games.e.d.b
        public V8EngineConfiguration.CodeCacheSetting Gb() {
            if (!com.baidu.swan.apps.u.a.Jm().Bs()) {
                return null;
            }
            return com.baidu.swan.apps.core.b.a.ag("gameframe", com.baidu.swan.games.i.a.bk(Gc(), Gd()));
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String Gc() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String Gd() {
            return WV();
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void a(com.baidu.swan.games.e.a aVar) {
            new com.baidu.swan.games.binding.a().a(aVar, a.this.aQw);
            new com.baidu.swan.games.binding.b().a(aVar, a.this.aQw);
            aVar.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.games.g.a.b.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    if (a.DEBUG) {
                        Log.d("SwanGameFrame", "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath);
                    }
                    if (cacheInfo.cached && !TextUtils.isEmpty(cacheInfo.jsPath)) {
                        String bk = com.baidu.swan.games.i.a.bk(b.this.Gc(), b.this.Gd());
                        File file = new File(cacheInfo.jsPath);
                        try {
                            if (!TextUtils.isEmpty(bk) && file.getCanonicalPath().startsWith(new File(bk).getCanonicalPath())) {
                                a.this.aMf = true;
                            } else if (!TextUtils.isEmpty(b.this.mBasePath) && file.getCanonicalPath().startsWith(new File(b.this.mBasePath).getCanonicalPath())) {
                                a.this.bAa = true;
                            }
                        } catch (IOException e) {
                            if (a.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });
            f.gz("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_swan_game_js_start"));
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void b(final com.baidu.swan.games.e.a aVar) {
            f.gz("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_swan_game_js_end"));
            f.gz("startup").f(new UbcFlowEvent("na_load_swan_game_js_end"));
            if (com.baidu.swan.apps.u.a.Jm().Bs()) {
                aVar.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.ag("gamejs", this.mBasePath));
            }
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.games.g.a.b.2
                @Override // java.lang.Runnable
                public void run() {
                    f.gz("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_index_js_start"));
                    aVar.bc(b.this.Gc(), b.this.WW());
                    f.gz("startup").f(new UbcFlowEvent("na_load_index_js_end"));
                    aVar.onLoad();
                }
            };
            aVar.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.g.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    a.C0241a a = com.baidu.swan.games.inspector.a.a(b.this.bAg);
                    if (a.isEnabled()) {
                        SwanInspectorEndpoint.Xl().a(b.this.bAg, a.this.bzZ, a, runnable);
                        return;
                    }
                    SwanInspectorEndpoint.Xl().a(a);
                    runnable.run();
                }
            });
            a.this.u(aVar);
        }

        private String WV() {
            return "swan-game.js";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String WW() {
            return "index.js";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.games.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0239a implements V8ThreadDelegatePolicy {
        private DuMixGameSurfaceView aLm;

        C0239a(DuMixGameSurfaceView duMixGameSurfaceView) {
            this.aLm = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(final V8Engine v8Engine) {
            if (a.DEBUG) {
                Log.d("SwanGameFrame", "startV8Engine");
            }
            this.aLm.queueEvent(new Runnable() { // from class: com.baidu.swan.games.g.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.DEBUG) {
                        Log.d("SwanGameFrame", "startEngineInternal");
                    }
                    C0239a.this.aLm.WY();
                    v8Engine.startEngineInternal();
                    C0239a.this.aLm.WZ();
                }
            });
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable) {
            this.aLm.queueEvent(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            this.aLm.queueEvent(runnable, j);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            return this.aLm.getThread();
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
            aVar.Wv();
        }
    }

    private void w(com.baidu.swan.games.e.a aVar) {
        if (aVar != null) {
            aVar.Ww();
        }
    }

    @Override // com.baidu.swan.apps.o.d
    protected void Iq() {
        if (this.aQD == null) {
            this.aQD = new com.baidu.swan.apps.view.b(this.aQw);
        }
        this.aQD.l(true, this.aDQ != null && this.aDQ.getOrientation() == 1);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.d("SwanApp", "onBackPressed back stack count:" + this.aQx.Fu());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.b Fr = this.aQx.Fr();
        if (Fr == null || !Fr.Co()) {
            if (ID()) {
                com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
                if (Ra != null) {
                    Ra.Rk().release();
                }
                ke("back");
                return;
            }
            this.aQx.eC("navigateBack").F(e.aKV, e.aKU).Fz().commit();
        }
    }

    @Override // com.baidu.swan.apps.o.d
    public boolean isLandScape() {
        return this.aDQ != null && this.aDQ.getOrientation() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WQ() {
        int i = 2;
        if (AK() != null && AK().getOrientation() == 1) {
            i = 3;
        }
        if (AF() != null) {
            AF().fF(i);
        }
    }

    private void kr() {
        this.bAb = 0L;
        this.aMf = false;
        this.bAa = false;
    }

    public ArBridge.FirstFrameListener WR() {
        return new ArBridge.FirstFrameListener() { // from class: com.baidu.swan.games.g.a.3
            @Override // com.baidu.smallgame.sdk.ArBridge.FirstFrameListener
            public void onFirstFrameFinished() {
                ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.g.a.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.DEBUG) {
                            Log.e("SwanGameFrame", "onFirstFrameFinished");
                        }
                        a.this.bAb = System.currentTimeMillis();
                        a.this.WU();
                        f.gz("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).az("codecache", String.valueOf(com.baidu.swan.apps.core.b.a.i(a.this.aMf, a.this.bAa))).f(new UbcFlowEvent("na_first_paint")).Nm();
                        a.this.WQ();
                    }
                });
            }
        };
    }

    public boolean WS() {
        return this.bAb > 0;
    }

    public long WT() {
        return this.bAb;
    }

    protected void WU() {
        Bundle KJ;
        if (this.aDQ != null && WS() && (KJ = this.aDQ.KJ()) != null && KJ.getLong("page_display_flag_for_statistic") > 0) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            a(fVar);
            KJ.remove("page_display_flag_for_statistic");
        }
    }

    protected void ke(String str) {
        Bundle KJ;
        if (this.aDQ != null && !WS() && (KJ = this.aDQ.KJ()) != null && KJ.getLong("page_display_flag_for_statistic") > 0) {
            long j = KJ.getLong("ext_launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realcancel";
            fVar.bpj = String.valueOf(currentTimeMillis - j);
            fVar.h(TiebaInitialize.LogFields.REASON, str);
            if (this.aDQ.KP() == 1) {
                fVar.h("errorList", com.baidu.swan.games.r.b.XY().XZ());
            }
            a(fVar);
            KJ.remove("page_display_flag_for_statistic");
        }
    }
}
