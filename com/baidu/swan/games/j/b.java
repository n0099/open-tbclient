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
    private long cYq;

    public b(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void m(boolean z, boolean z2) {
        if (z) {
            adE();
            if (z2) {
                d.d(QJ());
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        adU();
        com.baidu.swan.games.v.b.aBJ().clear();
        com.baidu.swan.games.network.b.d.aBa().release();
        aox().fd(true);
        aAm();
        V8Engine.setCrashKeyValue("game_title", QJ() == null ? "" : QJ().abT());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void adk() {
        f.ahV().bS(this.bQd);
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
        d.b(RGState.METHOD_NAME_EXIT, QJ());
        f.ahV().bT(this.bQd);
        f.release();
        com.baidu.swan.games.aa.a.aBY().release();
        SwanInspectorEndpoint.aAK().close();
        com.baidu.swan.games.v.b.aBJ().clear();
        com.baidu.swan.games.network.b.d.aBa().release();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int Qz() {
        return 1;
    }

    private void aAm() {
        pI();
        if (com.baidu.swan.apps.runtime.d.aoB().ane()) {
            f.ahV().a(QJ(), new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.games.j.b.1
                @Override // com.baidu.swan.apps.r.b
                public void a(int i, com.baidu.swan.apps.r.a aVar) {
                    a.b bVar = (a.b) aVar;
                    if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
                        a.aAd().e(b.this.QJ());
                        a.aAd().a(bVar);
                        com.baidu.swan.games.audio.b.b.axF();
                        b.this.aAn();
                    }
                }
            });
            if (a.aAd().aAh() && a.aAd().aAj()) {
                a.aAd().l(this.bQd);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAn() {
        com.baidu.swan.games.utils.c.aCc().aCm();
    }

    public com.baidu.swan.games.f.a getV8Engine() {
        return a.aAd().aAe();
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b adI() {
        return new a.b() { // from class: com.baidu.swan.games.j.b.2
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean m(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.amG().a(new com.baidu.swan.apps.process.messaging.c(4));
                        b.this.adF();
                        a.aAd().aAg();
                        com.baidu.swan.apps.runtime.d.aoB().aoy();
                        return true;
                    case 102:
                        boolean nightModeSwitcherState = com.baidu.swan.apps.u.a.afm().getNightModeSwitcherState();
                        com.baidu.swan.apps.u.a.afm().de(nightModeSwitcherState);
                        if (b.this.bQd != null) {
                            b.this.bQd.j(nightModeSwitcherState, false);
                            return true;
                        }
                        return true;
                    case 103:
                        e aoF = e.aoF();
                        if (aoF != null) {
                            aoF.aoR().clear();
                            com.baidu.swan.apps.network.c.a.akD().akJ();
                        }
                        b.this.adF();
                        a.aAd().aAg();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.aoB().aoy();
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
        com.baidu.swan.apps.console.c.d("SwanApp", "onBackPressed back stack count:" + this.cej.YS());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.b YP = this.cej.YP();
        if (YP == null || !YP.Tc()) {
            if (adM()) {
                e aoF = e.aoF();
                if (aoF != null) {
                    aoF.aoW().release();
                }
                d.b("back", QJ());
                return;
            }
            this.cej.jp("navigateBack").ae(com.baidu.swan.apps.core.d.e.bVP, com.baidu.swan.apps.core.d.e.bVO).YX().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean isLandScape() {
        return com.baidu.swan.apps.runtime.d.aoB().aox().QJ().getOrientation() == 1;
    }

    private void pI() {
        this.cYq = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void adN() {
        super.adN();
        a.aAd().U(this.bQd);
    }

    public boolean aAo() {
        return this.cYq > 0;
    }

    public long aAp() {
        return this.cYq;
    }

    public void onFirstFrameFinished() {
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager onFirstFrameFinished");
                }
                b.this.cYq = System.currentTimeMillis();
                d.d(b.this.QJ());
                b.this.bQd.QM();
                g.bF("preload", "startup");
                int ZJ = a.aAd().ZJ();
                HybridUbcFlow mp = g.mp("startup");
                mp.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).bD("codecache", String.valueOf(ZJ)).f(new UbcFlowEvent("na_first_paint")).alc();
                long s = mp.s("na_first_paint", "naStart");
                a.aAd().a(new com.baidu.swan.games.p.b(s));
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + s);
                }
                com.baidu.swan.games.utils.c.aCc().aCi();
            }
        });
    }

    private void adU() {
        if (aox().available()) {
            SwanCoreVersion abG = a.aAd().abG();
            long pi = com.baidu.swan.apps.swancore.b.pi(QJ().agO());
            if (pi != 0 && abG != null && abG.swanCoreVersion != 0 && abG.swanCoreVersion < pi) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "release SwanGameCoreRuntime minSwanVersion:" + pi + ", runtimeSwanCoreVersion:" + abG.swanCoreVersion);
                }
                a.release();
                return;
            }
            SwanCoreVersion abG2 = QJ().abG();
            if ((abG == null || abG2 == null || abG.swanCoreVersion == 0 || abG.swanCoreVersion >= abG2.swanCoreVersion || !com.baidu.swan.apps.v.b.a.fz(QJ().agX())) ? false : true) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime版本过低释放并重新加载");
                }
                a.release();
            }
        }
    }
}
