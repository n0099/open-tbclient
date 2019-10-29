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
    private boolean aMx;
    private com.baidu.swan.games.e.a bAQ;
    private boolean bAR;
    private long bAS;

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
        com.baidu.swan.games.n.a.Xt().h(this.aQO);
        if (bundle == null) {
            Is();
        }
        x(this.aEi);
        com.baidu.swan.games.r.b.Ya().clear();
    }

    @Override // com.baidu.swan.apps.o.d
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        com.baidu.swan.apps.w.e.LD().bj(this.aQO);
    }

    @Override // com.baidu.swan.apps.o.d
    public int AB() {
        return 1;
    }

    private void x(com.baidu.swan.apps.v.b.b bVar) {
        kr();
        if (bVar != null) {
            com.baidu.swan.apps.w.e.LD().f(this.aQO);
            com.baidu.swan.apps.w.e.LD().a(bVar, new com.baidu.swan.apps.install.b() { // from class: com.baidu.swan.games.g.a.1
                @Override // com.baidu.swan.apps.install.b
                public void a(int i, com.baidu.swan.apps.install.a aVar) {
                    a.c cVar = (a.c) aVar;
                    if (cVar != null && !TextUtils.isEmpty(cVar.bBV)) {
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
        DuMixGameSurfaceView ca = com.baidu.swan.games.glsurface.a.Xe().ca(this.aQO);
        ca.setRenderMode(1);
        com.baidu.swan.games.glsurface.a.Xe().f(ca);
        this.bAQ = com.baidu.swan.games.e.f.a(new g.a().fS(2).jH("master").WK(), new b(cVar.bBV, cVar.bBX == null ? null : cVar.bBX.bDr), new C0244a(ca));
        this.bAQ.setFileSystemDelegatePolicy(new com.baidu.swan.games.e.c.d());
        this.bAQ.setContext(this.aQO);
        ca.setV8Engine(this.bAQ);
        WR();
    }

    @Override // com.baidu.swan.apps.o.d
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        f.bat = false;
        com.baidu.swan.apps.v.b.b L = com.baidu.swan.apps.v.b.b.L(intent);
        if (!f(L)) {
            this.aQO.G(intent);
            Ir();
            g(L);
            Ip();
            com.baidu.swan.apps.w.e.release();
            com.baidu.swan.games.r.b.Ya().clear();
            x(this.aEi);
            Iq();
        } else {
            this.aEi = L;
        }
        com.baidu.swan.apps.ae.b.n(this.aEi);
        Is();
        WW();
        com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
        if (QZ != null) {
            QZ.Rd().Sc();
            QZ.Re().clear();
        }
    }

    @Override // com.baidu.swan.apps.o.d
    protected void IB() {
        this.aQP.a(this);
    }

    @Override // com.baidu.swan.apps.core.d.e.a
    public void Fw() {
        com.baidu.swan.games.n.a.Xt().h(this.aQO);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onDestroy() {
        com.baidu.swan.games.n.a.Xt().MC();
        com.baidu.swan.apps.w.e.LD().bk(this.aQO);
        com.baidu.swan.apps.w.e.release();
        com.baidu.swan.games.u.a.Yn().release();
        if (this.bAQ != null) {
            this.bAQ.finish();
        }
        SwanInspectorEndpoint.Xn().close();
        com.baidu.swan.games.r.b.Ya().clear();
        super.onDestroy();
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return this.bAQ;
    }

    private void WR() {
        this.aQP.Fu().H(0, 0).FA().c(h.FI()).FC();
    }

    @Override // com.baidu.swan.apps.o.d
    @NonNull
    protected a.d Iw() {
        return new a.d() { // from class: com.baidu.swan.games.g.a.2
            @Override // com.baidu.swan.apps.process.messaging.client.a.d
            public boolean j(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.client.a.Op().sendMessage(4);
                        a.this.It();
                        a.this.u(a.this.bAQ);
                        a.this.reset();
                        return true;
                    case 102:
                        boolean Kc = com.baidu.swan.apps.u.a.JD().Kc();
                        com.baidu.swan.apps.u.a.JD().bI(Kc);
                        a.this.k(Kc, false);
                        return true;
                    case 103:
                        com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
                        if (QZ != null) {
                            QZ.Rd().clear();
                        }
                        a.this.It();
                        a.this.v(a.this.bAQ);
                        a.this.u(a.this.bAQ);
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
                        c.Yl().x((Bundle) message.obj);
                        return true;
                    case 112:
                        if (a.DEBUG) {
                            Log.e("SwanGameFrame", "MSG_TYPE_SC_GET_GAME_SUB_PACKAGE_SUCCESS");
                        }
                        c.Yl().w((Bundle) message.obj);
                        return true;
                    case 113:
                        if (a.DEBUG) {
                            Log.e("SwanGameFrame", "MSG_TYPE_SC_GET_GAME_SUB_PACKAGE_ON_PROGRESS");
                        }
                        c.Yl().z((Bundle) message.obj);
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
        private com.baidu.swan.games.inspector.a bAX;
        private String mBasePath;

        public b(String str, com.baidu.swan.games.inspector.a aVar) {
            this.mBasePath = str;
            this.bAX = aVar;
        }

        @Override // com.baidu.swan.games.e.d.b
        public V8EngineConfiguration.CodeCacheSetting Ga() {
            if (!com.baidu.swan.apps.u.a.Jl().Br()) {
                return null;
            }
            return com.baidu.swan.apps.core.b.a.ag("gameframe", com.baidu.swan.games.i.a.bk(Gb(), Gc()));
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String Gb() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String Gc() {
            return WX();
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void a(com.baidu.swan.games.e.a aVar) {
            new com.baidu.swan.games.binding.a().a(aVar, a.this.aQO);
            new com.baidu.swan.games.binding.b().a(aVar, a.this.aQO);
            aVar.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.games.g.a.b.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    if (a.DEBUG) {
                        Log.d("SwanGameFrame", "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath);
                    }
                    if (cacheInfo.cached && !TextUtils.isEmpty(cacheInfo.jsPath)) {
                        String bk = com.baidu.swan.games.i.a.bk(b.this.Gb(), b.this.Gc());
                        File file = new File(cacheInfo.jsPath);
                        try {
                            if (!TextUtils.isEmpty(bk) && file.getCanonicalPath().startsWith(new File(bk).getCanonicalPath())) {
                                a.this.aMx = true;
                            } else if (!TextUtils.isEmpty(b.this.mBasePath) && file.getCanonicalPath().startsWith(new File(b.this.mBasePath).getCanonicalPath())) {
                                a.this.bAR = true;
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
            if (com.baidu.swan.apps.u.a.Jl().Br()) {
                aVar.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.ag("gamejs", this.mBasePath));
            }
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.games.g.a.b.2
                @Override // java.lang.Runnable
                public void run() {
                    f.gz("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_index_js_start"));
                    aVar.bc(b.this.Gb(), b.this.WY());
                    f.gz("startup").f(new UbcFlowEvent("na_load_index_js_end"));
                    aVar.onLoad();
                }
            };
            aVar.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.g.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    a.C0246a a = com.baidu.swan.games.inspector.a.a(b.this.bAX);
                    if (a.isEnabled()) {
                        SwanInspectorEndpoint.Xn().a(b.this.bAX, a.this.bAQ, a, runnable);
                        return;
                    }
                    SwanInspectorEndpoint.Xn().a(a);
                    runnable.run();
                }
            });
            a.this.u(aVar);
        }

        private String WX() {
            return "swan-game.js";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String WY() {
            return "index.js";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.games.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0244a implements V8ThreadDelegatePolicy {
        private DuMixGameSurfaceView aLE;

        C0244a(DuMixGameSurfaceView duMixGameSurfaceView) {
            this.aLE = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(final V8Engine v8Engine) {
            if (a.DEBUG) {
                Log.d("SwanGameFrame", "startV8Engine");
            }
            this.aLE.queueEvent(new Runnable() { // from class: com.baidu.swan.games.g.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.DEBUG) {
                        Log.d("SwanGameFrame", "startEngineInternal");
                    }
                    C0244a.this.aLE.Xa();
                    v8Engine.startEngineInternal();
                    C0244a.this.aLE.Xb();
                }
            });
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable) {
            this.aLE.queueEvent(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            this.aLE.queueEvent(runnable, j);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            return this.aLE.getThread();
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
            aVar.Wx();
        }
    }

    private void w(com.baidu.swan.games.e.a aVar) {
        if (aVar != null) {
            aVar.Wy();
        }
    }

    @Override // com.baidu.swan.apps.o.d
    protected void Ip() {
        if (this.aQV == null) {
            this.aQV = new com.baidu.swan.apps.view.b(this.aQO);
        }
        this.aQV.l(true, this.aEi != null && this.aEi.getOrientation() == 1);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.d("SwanApp", "onBackPressed back stack count:" + this.aQP.Ft());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.b Fq = this.aQP.Fq();
        if (Fq == null || !Fq.Cn()) {
            if (IC()) {
                com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
                if (QZ != null) {
                    QZ.Ri().release();
                }
                ke("back");
                return;
            }
            this.aQP.eC("navigateBack").H(e.aLn, e.aLm).Fy().commit();
        }
    }

    @Override // com.baidu.swan.apps.o.d
    public boolean isLandScape() {
        return this.aEi != null && this.aEi.getOrientation() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WS() {
        int i = 2;
        if (AJ() != null && AJ().getOrientation() == 1) {
            i = 3;
        }
        if (AE() != null) {
            AE().fG(i);
        }
    }

    private void kr() {
        this.bAS = 0L;
        this.aMx = false;
        this.bAR = false;
    }

    public ArBridge.FirstFrameListener WT() {
        return new ArBridge.FirstFrameListener() { // from class: com.baidu.swan.games.g.a.3
            @Override // com.baidu.smallgame.sdk.ArBridge.FirstFrameListener
            public void onFirstFrameFinished() {
                ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.g.a.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.DEBUG) {
                            Log.e("SwanGameFrame", "onFirstFrameFinished");
                        }
                        a.this.bAS = System.currentTimeMillis();
                        a.this.WW();
                        f.gz("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).az("codecache", String.valueOf(com.baidu.swan.apps.core.b.a.i(a.this.aMx, a.this.bAR))).f(new UbcFlowEvent("na_first_paint")).Nl();
                        a.this.WS();
                    }
                });
            }
        };
    }

    public boolean WU() {
        return this.bAS > 0;
    }

    public long WV() {
        return this.bAS;
    }

    protected void WW() {
        Bundle KI;
        if (this.aEi != null && WU() && (KI = this.aEi.KI()) != null && KI.getLong("page_display_flag_for_statistic") > 0) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            a(fVar);
            KI.remove("page_display_flag_for_statistic");
        }
    }

    protected void ke(String str) {
        Bundle KI;
        if (this.aEi != null && !WU() && (KI = this.aEi.KI()) != null && KI.getLong("page_display_flag_for_statistic") > 0) {
            long j = KI.getLong("ext_launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realcancel";
            fVar.bpB = String.valueOf(currentTimeMillis - j);
            fVar.h(TiebaInitialize.LogFields.REASON, str);
            if (this.aEi.KO() == 1) {
                fVar.h("errorList", com.baidu.swan.games.r.b.Ya().Yb());
            }
            a(fVar);
            KI.remove("page_display_flag_for_statistic");
        }
    }
}
