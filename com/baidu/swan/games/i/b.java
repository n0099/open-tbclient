package com.baidu.swan.games.i;

import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.platform.comapi.walknavi.fsm.RGState;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.messaging.client.a;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.games.h.h;
import com.baidu.swan.games.inspector.SwanInspectorEndpoint;
import com.baidu.swan.games.k.a;
import com.baidu.swan.games.u.d;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.apps.framework.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private long cov;

    public b(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void m(boolean z, boolean z2) {
        if (z) {
            SP();
            if (z2) {
                d.d(GJ());
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        Tf();
        com.baidu.swan.games.u.b.apG().clear();
        com.baidu.swan.games.network.b.d.aoW().release();
        acC().dO(true);
        aok();
        V8Engine.setCrashKeyValue("game_title", GJ() == null ? "" : GJ().Re());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void Sw() {
        f.WV().cf(this.biY);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStart() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onResume() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onPause() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStop() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onDestroy() {
        h.release();
        d.b(RGState.METHOD_NAME_EXIT, GJ());
        f.WV().cg(this.biY);
        f.release();
        com.baidu.swan.games.z.a.apV().release();
        SwanInspectorEndpoint.aoI().close();
        com.baidu.swan.games.u.b.apG().clear();
        com.baidu.swan.games.network.b.d.aoW().release();
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public int Gz() {
        return 1;
    }

    private void aok() {
        kY();
        if (com.baidu.swan.apps.runtime.d.acF().abm()) {
            f.WV().a(GJ(), new com.baidu.swan.apps.t.b() { // from class: com.baidu.swan.games.i.b.1
                @Override // com.baidu.swan.apps.t.b
                public void a(int i, com.baidu.swan.apps.t.a aVar) {
                    a.b bVar = (a.b) aVar;
                    if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
                        a.aob().e(b.this.GJ());
                        a.aob().a(bVar);
                        com.baidu.swan.games.audio.b.b.alE();
                        b.this.aol();
                    }
                }
            });
            if (a.aob().aof() && a.aob().aoh()) {
                a.aob().l(this.biY);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aol() {
        com.baidu.swan.games.utils.c.apY().aqi();
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return a.aob().aoc();
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b ST() {
        return new a.b() { // from class: com.baidu.swan.games.i.b.2
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean m(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.aaO().a(new com.baidu.swan.apps.process.messaging.c(4));
                        b.this.SQ();
                        a.aob().aoe();
                        com.baidu.swan.apps.runtime.d.acF().acD();
                        return true;
                    case 102:
                        boolean nightModeSwitcherState = com.baidu.swan.apps.w.a.Uv().getNightModeSwitcherState();
                        com.baidu.swan.apps.w.a.Uv().bV(nightModeSwitcherState);
                        if (b.this.biY != null) {
                            b.this.biY.j(nightModeSwitcherState, false);
                            return true;
                        }
                        return true;
                    case 103:
                        e acI = e.acI();
                        if (acI != null) {
                            acI.acS().clear();
                            com.baidu.swan.apps.network.c.a.Ze().Zk();
                        }
                        b.this.SQ();
                        a.aob().aoe();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.acF().acD();
                        return true;
                    case 107:
                        com.baidu.swan.apps.core.pms.h.l(message);
                        return true;
                    case 301:
                        com.baidu.swan.apps.process.messaging.a.a.n(message);
                        return true;
                    case 302:
                        com.baidu.swan.apps.process.messaging.a.a.q(message);
                        return true;
                    default:
                        return false;
                }
            }
        };
    }

    @Override // com.baidu.swan.apps.framework.c
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.d("SwanApp", "onBackPressed back stack count:" + this.bvK.Ot());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.b Oq = this.bvK.Oq();
        if (Oq == null || !Oq.IN()) {
            if (SX()) {
                e acI = e.acI();
                if (acI != null) {
                    acI.acX().release();
                }
                d.b("back", GJ());
                return;
            }
            this.bvK.ha("navigateBack").Y(com.baidu.swan.apps.core.d.e.bou, com.baidu.swan.apps.core.d.e.bot).Oy().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean isLandScape() {
        return com.baidu.swan.apps.runtime.d.acF().acC().GJ().getOrientation() == 1;
    }

    private void kY() {
        this.cov = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void SY() {
        super.SY();
        a.aob().aa(this.biY);
    }

    public boolean aom() {
        return this.cov > 0;
    }

    public long aon() {
        return this.cov;
    }

    public void onFirstFrameFinished() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.i.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager onFirstFrameFinished");
                }
                b.this.cov = System.currentTimeMillis();
                d.d(b.this.GJ());
                b.this.biY.GN();
                com.baidu.swan.apps.performance.f.bc("preload", "startup");
                int Pj = a.aob().Pj();
                HybridUbcFlow jO = com.baidu.swan.apps.performance.f.jO("startup");
                jO.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).ba("codecache", String.valueOf(Pj)).f(new UbcFlowEvent("na_first_paint")).ZD();
                long s = jO.s("na_first_paint", "naStart");
                a.aob().a(new com.baidu.swan.games.o.b(s));
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + s);
                }
                com.baidu.swan.games.utils.c.apY().aqe();
            }
        });
    }

    private void Tf() {
        if (acC().available()) {
            SwanCoreVersion QT = a.aob().QT();
            long mo = com.baidu.swan.apps.swancore.b.mo(GJ().VQ());
            if (mo != 0 && QT != null && QT.swanCoreVersion != 0 && QT.swanCoreVersion < mo) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "release SwanGameCoreRuntime minSwanVersion:" + mo + ", runtimeSwanCoreVersion:" + QT.swanCoreVersion);
                }
                a.release();
                return;
            }
            SwanCoreVersion QT2 = GJ().QT();
            if ((QT == null || QT2 == null || QT.swanCoreVersion == 0 || QT.swanCoreVersion >= QT2.swanCoreVersion || !com.baidu.swan.apps.x.b.a.ff(GJ().VZ())) ? false : true) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime版本过低释放并重新加载");
                }
                a.release();
            }
        }
    }
}
