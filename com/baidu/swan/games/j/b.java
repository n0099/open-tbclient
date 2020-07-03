package com.baidu.swan.games.j;

import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.platform.comapi.walknavi.fsm.RGState;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.core.pms.h;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.g;
import com.baidu.swan.apps.process.messaging.client.a;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.w.f;
import com.baidu.swan.games.i.i;
import com.baidu.swan.games.inspector.SwanInspectorEndpoint;
import com.baidu.swan.games.l.a;
import com.baidu.swan.games.v.d;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.apps.framework.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private long ddd;

    public b(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void m(boolean z, boolean z2) {
        if (z) {
            aeK();
            if (z2) {
                d.d(RP());
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        afa();
        com.baidu.swan.games.v.b.aCP().clear();
        com.baidu.swan.games.network.b.d.aCg().release();
        apE().fi(true);
        aBs();
        V8Engine.setCrashKeyValue("game_title", RP() == null ? "" : RP().acZ());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void aeq() {
        f.ajb().bT(this.bUR);
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
        com.baidu.swan.games.b.d.release();
        i.release();
        d.b(RGState.METHOD_NAME_EXIT, RP());
        f.ajb().bU(this.bUR);
        f.release();
        com.baidu.swan.games.aa.a.aDe().release();
        SwanInspectorEndpoint.aBQ().close();
        com.baidu.swan.games.v.b.aCP().clear();
        com.baidu.swan.games.network.b.d.aCg().release();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int RF() {
        return 1;
    }

    private void aBs() {
        pZ();
        if (com.baidu.swan.apps.runtime.d.apI().aok()) {
            f.ajb().a(RP(), new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.games.j.b.1
                @Override // com.baidu.swan.apps.r.b
                public void a(int i, com.baidu.swan.apps.r.a aVar) {
                    a.b bVar = (a.b) aVar;
                    if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
                        a.aBj().e(b.this.RP());
                        a.aBj().a(bVar);
                        com.baidu.swan.games.audio.b.b.ayL();
                        b.this.aBt();
                    }
                }
            });
            if (a.aBj().aBn() && a.aBj().aBp()) {
                a.aBj().l(this.bUR);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBt() {
        com.baidu.swan.games.utils.c.aDi().aDs();
    }

    public com.baidu.swan.games.f.a getV8Engine() {
        return a.aBj().aBk();
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b aeO() {
        return new a.b() { // from class: com.baidu.swan.games.j.b.2
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean m(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.anM().a(new com.baidu.swan.apps.process.messaging.c(4));
                        b.this.aeL();
                        a.aBj().aBm();
                        com.baidu.swan.apps.runtime.d.apI().apF();
                        return true;
                    case 102:
                        boolean nightModeSwitcherState = com.baidu.swan.apps.u.a.ags().getNightModeSwitcherState();
                        com.baidu.swan.apps.u.a.ags().dj(nightModeSwitcherState);
                        if (b.this.bUR != null) {
                            b.this.bUR.j(nightModeSwitcherState, false);
                            return true;
                        }
                        return true;
                    case 103:
                        e apM = e.apM();
                        if (apM != null) {
                            apM.apY().clear();
                            com.baidu.swan.apps.network.c.a.alJ().alP();
                        }
                        b.this.aeL();
                        a.aBj().aBm();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.apI().apF();
                        return true;
                    case 107:
                        h.l(message);
                        return true;
                    case 123:
                        com.baidu.swan.apps.aq.a.N(message);
                        return true;
                    case 124:
                        com.baidu.swan.apps.aq.a.O(message);
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
        com.baidu.swan.apps.console.c.d("SwanApp", "onBackPressed back stack count:" + this.ciX.ZY());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.b ZV = this.ciX.ZV();
        if (ZV == null || !ZV.Ui()) {
            if (aeS()) {
                e apM = e.apM();
                if (apM != null) {
                    apM.aqd().release();
                }
                d.b("back", RP());
                return;
            }
            this.ciX.jx("navigateBack").ag(com.baidu.swan.apps.core.d.e.caD, com.baidu.swan.apps.core.d.e.caC).aad().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean isLandScape() {
        return com.baidu.swan.apps.runtime.d.apI().apE().RP().getOrientation() == 1;
    }

    private void pZ() {
        this.ddd = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void aeT() {
        super.aeT();
        a.aBj().U(this.bUR);
    }

    public boolean aBu() {
        return this.ddd > 0;
    }

    public long aBv() {
        return this.ddd;
    }

    public void onFirstFrameFinished() {
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager onFirstFrameFinished");
                }
                b.this.ddd = System.currentTimeMillis();
                d.d(b.this.RP());
                b.this.bUR.RS();
                g.bH("preload", "startup");
                int aaP = a.aBj().aaP();
                HybridUbcFlow mx = g.mx("startup");
                mx.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).bF("codecache", String.valueOf(aaP)).f(new UbcFlowEvent("na_first_paint")).ami();
                long r = mx.r("na_first_paint", "naStart");
                a.aBj().a(new com.baidu.swan.games.p.b(r));
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + r);
                }
                com.baidu.swan.games.utils.c.aDi().aDo();
            }
        });
    }

    private void afa() {
        if (apE().available()) {
            SwanCoreVersion acM = a.aBj().acM();
            long pq = com.baidu.swan.apps.swancore.b.pq(RP().ahU());
            if (pq != 0 && acM != null && acM.swanCoreVersion != 0 && acM.swanCoreVersion < pq) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "release SwanGameCoreRuntime minSwanVersion:" + pq + ", runtimeSwanCoreVersion:" + acM.swanCoreVersion);
                }
                a.release();
                return;
            }
            SwanCoreVersion acM2 = RP().acM();
            if ((acM == null || acM2 == null || acM.swanCoreVersion == 0 || acM.swanCoreVersion >= acM2.swanCoreVersion || !com.baidu.swan.apps.v.b.a.fK(RP().aid())) ? false : true) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime版本过低释放并重新加载");
                }
                a.release();
            }
        }
    }
}
