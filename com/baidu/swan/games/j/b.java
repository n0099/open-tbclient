package com.baidu.swan.games.j;

import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.platform.comapi.walknavi.fsm.RGState;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.messaging.client.a;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.i.i;
import com.baidu.swan.games.inspector.SwanInspectorEndpoint;
import com.baidu.swan.games.l.a;
import com.baidu.swan.games.v.d;
/* loaded from: classes7.dex */
public class b extends com.baidu.swan.apps.framework.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private long diO;

    public b(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void m(boolean z, boolean z2) {
        if (z) {
            h.auw();
            if (z2) {
                d.d(Se());
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        agl();
        com.baidu.swan.games.v.b.aGw().clear();
        com.baidu.swan.games.network.b.d.aFN().release();
        arn().fr(true);
        aEY();
        V8Engine.setCrashKeyValue("game_title", Se() == null ? "" : Se().aee());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void afC() {
        f.akr().bW(this.bVJ);
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
        d.b(RGState.METHOD_NAME_EXIT, Se());
        f.akr().bX(this.bVJ);
        f.release();
        com.baidu.swan.games.aa.a.aGL().release();
        SwanInspectorEndpoint.aFx().close();
        com.baidu.swan.games.v.b.aGw().clear();
        com.baidu.swan.games.network.b.d.aFN().release();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int RU() {
        return 1;
    }

    private void aEY() {
        qa();
        if (com.baidu.swan.apps.runtime.d.arr().apU()) {
            f.akr().a(Se(), new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.games.j.b.1
                @Override // com.baidu.swan.apps.r.b
                public void a(int i, com.baidu.swan.apps.r.a aVar) {
                    a.b bVar = (a.b) aVar;
                    if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
                        a.aEO().e(b.this.Se());
                        a.aEO().a(bVar);
                        com.baidu.swan.games.audio.b.b.aCq();
                        b.this.aEZ();
                        b.this.aFa();
                    }
                }
            });
            if (a.aEO().aES() && a.aEO().aEU()) {
                a.aEO().m(this.bVJ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEZ() {
        com.baidu.swan.games.utils.c.aGP().aHa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFa() {
        com.baidu.swan.games.utils.c.aGP().aGZ();
    }

    public com.baidu.swan.games.f.a getV8Engine() {
        return a.aEO().aEP();
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b afZ() {
        return new a.b() { // from class: com.baidu.swan.games.j.b.2
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean m(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.apw().a(new com.baidu.swan.apps.process.messaging.c(4));
                        b.this.afW();
                        a.aEO().aER();
                        com.baidu.swan.apps.runtime.d.arr().aro();
                        return true;
                    case 102:
                        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.ahF().getNightModeSwitcherState();
                        com.baidu.swan.apps.t.a.ahF().dm(nightModeSwitcherState);
                        if (b.this.bVJ != null) {
                            b.this.bVJ.j(nightModeSwitcherState, false);
                            return true;
                        }
                        return true;
                    case 103:
                        e arv = e.arv();
                        if (arv != null) {
                            arv.arH().clear();
                            com.baidu.swan.apps.network.c.a.amZ().anf();
                        }
                        b.this.afW();
                        a.aEO().aER();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.arr().aro();
                        return true;
                    case 107:
                        com.baidu.swan.apps.core.pms.h.l(message);
                        return true;
                    case 123:
                        com.baidu.swan.apps.aq.b.N(message);
                        return true;
                    case 124:
                        com.baidu.swan.apps.aq.b.O(message);
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
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count:" + this.ckW.abc());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.c aaZ = this.ckW.aaZ();
        if (aaZ == null || !aaZ.UJ()) {
            if (agd()) {
                e arv = e.arv();
                if (arv != null) {
                    arv.arM().release();
                }
                d.b("back", Se());
                return;
            }
            this.ckW.jO("navigateBack").ag(com.baidu.swan.apps.core.d.f.cck, com.baidu.swan.apps.core.d.f.ccj).abh().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean isLandScape() {
        return com.baidu.swan.apps.runtime.d.arr().arn().Se().getOrientation() == 1;
    }

    private void qa() {
        this.diO = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void age() {
        super.age();
        a.aEO().V(this.bVJ);
    }

    public boolean aFb() {
        return this.diO > 0;
    }

    public long aFc() {
        return this.diO;
    }

    public void onFirstFrameFinished() {
        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager onFirstFrameFinished");
                }
                b.this.diO = System.currentTimeMillis();
                d.d(b.this.Se());
                b.this.bVJ.Sh();
                com.baidu.swan.apps.performance.i.bJ("preload", "startup");
                int abR = a.aEO().abR();
                HybridUbcFlow mX = com.baidu.swan.apps.performance.i.mX("startup");
                mX.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).bH("codecache", String.valueOf(abR)).f(new UbcFlowEvent("na_first_paint")).anC();
                long r = mX.r("na_first_paint", "naStart");
                a.aEO().a(new com.baidu.swan.games.p.b(r));
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + r);
                }
                com.baidu.swan.games.utils.c.aGP().aGV();
            }
        });
    }

    private void agl() {
        if (arn().available()) {
            SwanCoreVersion adQ = a.aEO().adQ();
            long qb = com.baidu.swan.apps.swancore.b.qb(Se().ajk());
            if (qb != 0 && adQ != null && adQ.swanCoreVersion != 0 && adQ.swanCoreVersion < qb) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "release SwanGameCoreRuntime minSwanVersion:" + qb + ", runtimeSwanCoreVersion:" + adQ.swanCoreVersion);
                }
                a.release();
                return;
            }
            SwanCoreVersion adQ2 = Se().adQ();
            if ((adQ == null || adQ2 == null || adQ.swanCoreVersion == 0 || adQ.swanCoreVersion >= adQ2.swanCoreVersion || !com.baidu.swan.apps.u.c.a.fU(Se().ajt())) ? false : true) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime版本过低释放并重新加载");
                }
                a.release();
            }
        }
    }
}
