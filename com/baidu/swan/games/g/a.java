package com.baidu.swan.games.g;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.util.Log;
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
    private boolean asf;
    private com.baidu.swan.games.e.a bgP;
    private boolean bgQ;
    private long bgR;

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
        com.baidu.swan.games.n.a.RF().h(this.aww);
        if (bundle == null) {
            CL();
        }
        x(this.ajM);
        com.baidu.swan.games.r.b.Sm().clear();
    }

    @Override // com.baidu.swan.apps.o.d
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        com.baidu.swan.apps.w.e.FV().bh(this.aww);
    }

    @Override // com.baidu.swan.apps.o.d
    public int vc() {
        return 1;
    }

    private void x(com.baidu.swan.apps.v.b.b bVar) {
        pa();
        if (bVar != null) {
            com.baidu.swan.apps.w.e.FV().f(this.aww);
            com.baidu.swan.apps.w.e.FV().a(bVar, new com.baidu.swan.apps.install.b() { // from class: com.baidu.swan.games.g.a.1
                @Override // com.baidu.swan.apps.install.b
                public void a(int i, com.baidu.swan.apps.install.a aVar) {
                    a.c cVar = (a.c) aVar;
                    if (cVar != null && !TextUtils.isEmpty(cVar.bhU)) {
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
        DuMixGameSurfaceView ca = com.baidu.swan.games.glsurface.a.Rq().ca(this.aww);
        ca.setRenderMode(1);
        com.baidu.swan.games.glsurface.a.Rq().f(ca);
        this.bgP = com.baidu.swan.games.e.f.a(new g.a().eS(2).iV("master").QW(), new b(cVar.bhU, cVar.bhW == null ? null : cVar.bhW.bjs), new C0201a(ca));
        this.bgP.setFileSystemDelegatePolicy(new com.baidu.swan.games.e.c.d());
        this.bgP.setContext(this.aww);
        ca.setV8Engine(this.bgP);
        Rd();
    }

    @Override // com.baidu.swan.apps.o.d
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        f.aFY = false;
        com.baidu.swan.apps.v.b.b F = com.baidu.swan.apps.v.b.b.F(intent);
        if (!f(F)) {
            this.aww.A(intent);
            CK();
            g(F);
            CI();
            com.baidu.swan.apps.w.e.release();
            com.baidu.swan.games.r.b.Sm().clear();
            x(this.ajM);
            CJ();
        } else {
            this.ajM = F;
        }
        com.baidu.swan.apps.ae.b.n(this.ajM);
        CL();
        Ri();
        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
        if (Lq != null) {
            Lq.Lu().Mu();
            Lq.Lv().clear();
        }
    }

    @Override // com.baidu.swan.apps.o.d
    protected void CU() {
        this.awx.a(this);
    }

    @Override // com.baidu.swan.apps.core.d.e.a
    public void zQ() {
        com.baidu.swan.games.n.a.RF().h(this.aww);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onDestroy() {
        com.baidu.swan.games.n.a.RF().GT();
        com.baidu.swan.apps.w.e.FV().bi(this.aww);
        com.baidu.swan.apps.w.e.release();
        com.baidu.swan.games.u.a.Sz().release();
        if (this.bgP != null) {
            this.bgP.finish();
        }
        SwanInspectorEndpoint.Rz().close();
        com.baidu.swan.games.r.b.Sm().clear();
        super.onDestroy();
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return this.bgP;
    }

    private void Rd() {
        this.awx.zO().y(0, 0).zU().c(h.Ac()).zW();
    }

    @Override // com.baidu.swan.apps.o.d
    @NonNull
    protected a.d CP() {
        return new a.d() { // from class: com.baidu.swan.games.g.a.2
            @Override // com.baidu.swan.apps.process.messaging.client.a.d
            public boolean j(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.client.a.IE().sendMessage(4);
                        a.this.CM();
                        a.this.u(a.this.bgP);
                        a.this.reset();
                        return true;
                    case 102:
                        boolean Ev = com.baidu.swan.apps.u.a.DW().Ev();
                        com.baidu.swan.apps.u.a.DW().bn(Ev);
                        a.this.g(Ev, false);
                        return true;
                    case 103:
                        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
                        if (Lq != null) {
                            Lq.Lu().clear();
                        }
                        a.this.CM();
                        a.this.v(a.this.bgP);
                        a.this.u(a.this.bgP);
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
                        c.Sx().x((Bundle) message.obj);
                        return true;
                    case 112:
                        if (a.DEBUG) {
                            Log.e("SwanGameFrame", "MSG_TYPE_SC_GET_GAME_SUB_PACKAGE_SUCCESS");
                        }
                        c.Sx().w((Bundle) message.obj);
                        return true;
                    case 113:
                        if (a.DEBUG) {
                            Log.e("SwanGameFrame", "MSG_TYPE_SC_GET_GAME_SUB_PACKAGE_ON_PROGRESS");
                        }
                        c.Sx().z((Bundle) message.obj);
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
        private com.baidu.swan.games.inspector.a bgW;
        private String mBasePath;

        public b(String str, com.baidu.swan.games.inspector.a aVar) {
            this.mBasePath = str;
            this.bgW = aVar;
        }

        @Override // com.baidu.swan.games.e.d.b
        public V8EngineConfiguration.CodeCacheSetting At() {
            if (!com.baidu.swan.apps.u.a.DE().vS()) {
                return null;
            }
            return com.baidu.swan.apps.core.b.a.Y("gameframe", com.baidu.swan.games.i.a.bd(Au(), Av()));
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String Au() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String Av() {
            return Rj();
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void a(com.baidu.swan.games.e.a aVar) {
            new com.baidu.swan.games.binding.a().a(aVar, a.this.aww);
            new com.baidu.swan.games.binding.b().a(aVar, a.this.aww);
            aVar.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.games.g.a.b.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    if (a.DEBUG) {
                        Log.d("SwanGameFrame", "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath);
                    }
                    if (cacheInfo.cached && !TextUtils.isEmpty(cacheInfo.jsPath)) {
                        String bd = com.baidu.swan.games.i.a.bd(b.this.Au(), b.this.Av());
                        File file = new File(cacheInfo.jsPath);
                        try {
                            if (!TextUtils.isEmpty(bd) && file.getCanonicalPath().startsWith(new File(bd).getCanonicalPath())) {
                                a.this.asf = true;
                            } else if (!TextUtils.isEmpty(b.this.mBasePath) && file.getCanonicalPath().startsWith(new File(b.this.mBasePath).getCanonicalPath())) {
                                a.this.bgQ = true;
                            }
                        } catch (IOException e) {
                            if (a.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });
            f.fO("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_swan_game_js_start"));
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void b(final com.baidu.swan.games.e.a aVar) {
            f.fO("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_swan_game_js_end"));
            f.fO("startup").f(new UbcFlowEvent("na_load_swan_game_js_end"));
            if (com.baidu.swan.apps.u.a.DE().vS()) {
                aVar.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.Y("gamejs", this.mBasePath));
            }
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.games.g.a.b.2
                @Override // java.lang.Runnable
                public void run() {
                    f.fO("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_index_js_start"));
                    aVar.aV(b.this.Au(), b.this.Rk());
                    f.fO("startup").f(new UbcFlowEvent("na_load_index_js_end"));
                    aVar.onLoad();
                }
            };
            aVar.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.g.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    a.C0203a a = com.baidu.swan.games.inspector.a.a(b.this.bgW);
                    if (a.isEnabled()) {
                        SwanInspectorEndpoint.Rz().a(b.this.bgW, a.this.bgP, a, runnable);
                        return;
                    }
                    SwanInspectorEndpoint.Rz().a(a);
                    runnable.run();
                }
            });
            a.this.u(aVar);
        }

        private String Rj() {
            return "swan-game.js";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String Rk() {
            return "index.js";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.games.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0201a implements V8ThreadDelegatePolicy {
        private DuMixGameSurfaceView arm;

        C0201a(DuMixGameSurfaceView duMixGameSurfaceView) {
            this.arm = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(final V8Engine v8Engine) {
            if (a.DEBUG) {
                Log.d("SwanGameFrame", "startV8Engine");
            }
            this.arm.queueEvent(new Runnable() { // from class: com.baidu.swan.games.g.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.DEBUG) {
                        Log.d("SwanGameFrame", "startEngineInternal");
                    }
                    C0201a.this.arm.Rm();
                    v8Engine.startEngineInternal();
                    C0201a.this.arm.Rn();
                }
            });
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable) {
            this.arm.queueEvent(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            this.arm.queueEvent(runnable, j);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            return this.arm.getThread();
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
            aVar.QJ();
        }
    }

    private void w(com.baidu.swan.games.e.a aVar) {
        if (aVar != null) {
            aVar.QK();
        }
    }

    @Override // com.baidu.swan.apps.o.d
    protected void CI() {
        if (this.awD == null) {
            this.awD = new com.baidu.swan.apps.view.b(this.aww);
        }
        this.awD.h(true, this.ajM != null && this.ajM.getOrientation() == 1);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.d("SwanApp", "onBackPressed back stack count:" + this.awx.zN());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.b zK = this.awx.zK();
        if (zK == null || !zK.wO()) {
            if (CV()) {
                com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
                if (Lq != null) {
                    Lq.Lz().release();
                }
                jt("back");
                return;
            }
            this.awx.dO("navigateBack").y(e.aqV, e.aqU).zS().commit();
        }
    }

    @Override // com.baidu.swan.apps.o.d
    public boolean isLandScape() {
        return this.ajM != null && this.ajM.getOrientation() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Re() {
        int i = 2;
        if (vk() != null && vk().getOrientation() == 1) {
            i = 3;
        }
        if (vf() != null) {
            vf().eH(i);
        }
    }

    private void pa() {
        this.bgR = 0L;
        this.asf = false;
        this.bgQ = false;
    }

    public ArBridge.FirstFrameListener Rf() {
        return new ArBridge.FirstFrameListener() { // from class: com.baidu.swan.games.g.a.3
            @Override // com.baidu.smallgame.sdk.ArBridge.FirstFrameListener
            public void onFirstFrameFinished() {
                ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.g.a.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.DEBUG) {
                            Log.e("SwanGameFrame", "onFirstFrameFinished");
                        }
                        a.this.bgR = System.currentTimeMillis();
                        a.this.Ri();
                        f.fO("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).ar("codecache", String.valueOf(com.baidu.swan.apps.core.b.a.e(a.this.asf, a.this.bgQ))).f(new UbcFlowEvent("na_first_paint")).HB();
                        a.this.Re();
                    }
                });
            }
        };
    }

    public boolean Rg() {
        return this.bgR > 0;
    }

    public long Rh() {
        return this.bgR;
    }

    protected void Ri() {
        Bundle Fa;
        if (this.ajM != null && Rg() && (Fa = this.ajM.Fa()) != null && Fa.getLong("page_display_flag_for_statistic") > 0) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mType = "launch";
            fVar.mValue = "realsuccess";
            a(fVar);
            Fa.remove("page_display_flag_for_statistic");
        }
    }

    protected void jt(String str) {
        Bundle Fa;
        if (this.ajM != null && !Rg() && (Fa = this.ajM.Fa()) != null && Fa.getLong("page_display_flag_for_statistic") > 0) {
            long j = Fa.getLong("ext_launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mType = "launch";
            fVar.mValue = "realcancel";
            fVar.aVp = String.valueOf(currentTimeMillis - j);
            fVar.k("reason", str);
            if (this.ajM.Fg() == 1) {
                fVar.k("errorList", com.baidu.swan.games.r.b.Sm().Sn());
            }
            a(fVar);
            Fa.remove("page_display_flag_for_statistic");
        }
    }
}
