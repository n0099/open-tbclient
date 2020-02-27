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
    private long coi;

    public b(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void l(boolean z, boolean z2) {
        if (z) {
            SK();
            if (z2) {
                d.d(GC());
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        Ta();
        com.baidu.swan.games.u.b.apB().clear();
        com.baidu.swan.games.network.b.d.aoR().release();
        acx().dN(true);
        aof();
        V8Engine.setCrashKeyValue("game_title", GC() == null ? "" : GC().QZ());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void Sr() {
        f.WQ().cg(this.biJ);
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
        d.b(RGState.METHOD_NAME_EXIT, GC());
        f.WQ().ch(this.biJ);
        f.release();
        com.baidu.swan.games.z.a.apQ().release();
        SwanInspectorEndpoint.aoD().close();
        com.baidu.swan.games.u.b.apB().clear();
        com.baidu.swan.games.network.b.d.aoR().release();
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public int Gs() {
        return 1;
    }

    private void aof() {
        kY();
        if (com.baidu.swan.apps.runtime.d.acA().abh()) {
            f.WQ().a(GC(), new com.baidu.swan.apps.t.b() { // from class: com.baidu.swan.games.i.b.1
                @Override // com.baidu.swan.apps.t.b
                public void a(int i, com.baidu.swan.apps.t.a aVar) {
                    a.b bVar = (a.b) aVar;
                    if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
                        a.anW().e(b.this.GC());
                        a.anW().a(bVar);
                        com.baidu.swan.games.audio.b.b.alz();
                        b.this.aog();
                    }
                }
            });
            if (a.anW().aoa() && a.anW().aoc()) {
                a.anW().l(this.biJ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aog() {
        com.baidu.swan.games.utils.c.apT().aqd();
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return a.anW().anX();
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b SO() {
        return new a.b() { // from class: com.baidu.swan.games.i.b.2
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean m(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.aaJ().a(new com.baidu.swan.apps.process.messaging.c(4));
                        b.this.SL();
                        a.anW().anZ();
                        com.baidu.swan.apps.runtime.d.acA().acy();
                        return true;
                    case 102:
                        boolean nightModeSwitcherState = com.baidu.swan.apps.w.a.Uq().getNightModeSwitcherState();
                        com.baidu.swan.apps.w.a.Uq().bU(nightModeSwitcherState);
                        if (b.this.biJ != null) {
                            b.this.biJ.i(nightModeSwitcherState, false);
                            return true;
                        }
                        return true;
                    case 103:
                        e acD = e.acD();
                        if (acD != null) {
                            acD.acN().clear();
                            com.baidu.swan.apps.network.c.a.YZ().Zf();
                        }
                        b.this.SL();
                        a.anW().anZ();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.acA().acy();
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
        com.baidu.swan.apps.console.c.d("SwanApp", "onBackPressed back stack count:" + this.bvw.Oo());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.b Ol = this.bvw.Ol();
        if (Ol == null || !Ol.II()) {
            if (SS()) {
                e acD = e.acD();
                if (acD != null) {
                    acD.acS().release();
                }
                d.b("back", GC());
                return;
            }
            this.bvw.hb("navigateBack").Y(com.baidu.swan.apps.core.d.e.bog, com.baidu.swan.apps.core.d.e.bof).Ot().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean isLandScape() {
        return com.baidu.swan.apps.runtime.d.acA().acx().GC().getOrientation() == 1;
    }

    private void kY() {
        this.coi = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void ST() {
        super.ST();
        a.anW().aa(this.biJ);
    }

    public boolean aoh() {
        return this.coi > 0;
    }

    public long aoi() {
        return this.coi;
    }

    public void onFirstFrameFinished() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.i.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager onFirstFrameFinished");
                }
                b.this.coi = System.currentTimeMillis();
                d.d(b.this.GC());
                b.this.biJ.GG();
                com.baidu.swan.apps.performance.f.bd("preload", "startup");
                int Pe = a.anW().Pe();
                HybridUbcFlow jP = com.baidu.swan.apps.performance.f.jP("startup");
                jP.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).bb("codecache", String.valueOf(Pe)).f(new UbcFlowEvent("na_first_paint")).Zy();
                long s = jP.s("na_first_paint", "naStart");
                a.anW().a(new com.baidu.swan.games.o.b(s));
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + s);
                }
                com.baidu.swan.games.utils.c.apT().apZ();
            }
        });
    }

    private void Ta() {
        if (acx().available()) {
            SwanCoreVersion QO = a.anW().QO();
            long mp = com.baidu.swan.apps.swancore.b.mp(GC().VL());
            if (mp != 0 && QO != null && QO.swanCoreVersion != 0 && QO.swanCoreVersion < mp) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "release SwanGameCoreRuntime minSwanVersion:" + mp + ", runtimeSwanCoreVersion:" + QO.swanCoreVersion);
                }
                a.release();
                return;
            }
            SwanCoreVersion QO2 = GC().QO();
            if ((QO == null || QO2 == null || QO.swanCoreVersion == 0 || QO.swanCoreVersion >= QO2.swanCoreVersion || !com.baidu.swan.apps.x.b.a.ff(GC().VU())) ? false : true) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime版本过低释放并重新加载");
                }
                a.release();
            }
        }
    }
}
