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
/* loaded from: classes9.dex */
public class b extends com.baidu.swan.apps.framework.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private long cjR;

    public b(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void k(boolean z, boolean z2) {
        if (z) {
            Qa();
            if (z2) {
                d.d(DR());
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        Qq();
        com.baidu.swan.games.u.b.amU().clear();
        com.baidu.swan.games.network.b.d.aml().release();
        ZM().dB(true);
        alz();
        V8Engine.setCrashKeyValue("game_title", DR() == null ? "" : DR().Op());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void PH() {
        f.Uf().cc(this.bdF);
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
        d.b(RGState.METHOD_NAME_EXIT, DR());
        f.Uf().cd(this.bdF);
        f.release();
        com.baidu.swan.games.z.a.anj().release();
        SwanInspectorEndpoint.alX().close();
        com.baidu.swan.games.u.b.amU().clear();
        com.baidu.swan.games.network.b.d.aml().release();
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public int DH() {
        return 1;
    }

    private void alz() {
        kI();
        if (com.baidu.swan.apps.runtime.d.ZP().Yw()) {
            f.Uf().a(DR(), new com.baidu.swan.apps.t.b() { // from class: com.baidu.swan.games.i.b.1
                @Override // com.baidu.swan.apps.t.b
                public void a(int i, com.baidu.swan.apps.t.a aVar) {
                    a.b bVar = (a.b) aVar;
                    if (bVar != null && !TextUtils.isEmpty(bVar.ckZ)) {
                        a.alq().e(b.this.DR());
                        a.alq().a(bVar);
                        com.baidu.swan.games.audio.b.b.aiS();
                        b.this.alA();
                    }
                }
            });
            if (a.alq().alu() && a.alq().alw()) {
                a.alq().l(this.bdF);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alA() {
        com.baidu.swan.games.utils.c.anm().anw();
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return a.alq().alr();
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b Qe() {
        return new a.b() { // from class: com.baidu.swan.games.i.b.2
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean m(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.XY().a(new com.baidu.swan.apps.process.messaging.c(4));
                        b.this.Qb();
                        a.alq().alt();
                        com.baidu.swan.apps.runtime.d.ZP().ZN();
                        return true;
                    case 102:
                        boolean nightModeSwitcherState = com.baidu.swan.apps.w.a.RG().getNightModeSwitcherState();
                        com.baidu.swan.apps.w.a.RG().bH(nightModeSwitcherState);
                        if (b.this.bdF != null) {
                            b.this.bdF.h(nightModeSwitcherState, false);
                            return true;
                        }
                        return true;
                    case 103:
                        e ZS = e.ZS();
                        if (ZS != null) {
                            ZS.aac().clear();
                            com.baidu.swan.apps.network.c.a.Wo().Wu();
                        }
                        b.this.Qb();
                        a.alq().alt();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.ZP().ZN();
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
        com.baidu.swan.apps.console.c.d("SwanApp", "onBackPressed back stack count:" + this.bqy.LE());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.b LB = this.bqy.LB();
        if (LB == null || !LB.FX()) {
            if (Qi()) {
                e ZS = e.ZS();
                if (ZS != null) {
                    ZS.aah().release();
                }
                d.b("back", DR());
                return;
            }
            this.bqy.gJ("navigateBack").U(com.baidu.swan.apps.core.d.e.bjh, com.baidu.swan.apps.core.d.e.bjg).LJ().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean isLandScape() {
        return com.baidu.swan.apps.runtime.d.ZP().ZM().DR().getOrientation() == 1;
    }

    private void kI() {
        this.cjR = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void Qj() {
        super.Qj();
        a.alq().Y(this.bdF);
    }

    public boolean alB() {
        return this.cjR > 0;
    }

    public long alC() {
        return this.cjR;
    }

    public void onFirstFrameFinished() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.i.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager onFirstFrameFinished");
                }
                b.this.cjR = System.currentTimeMillis();
                d.d(b.this.DR());
                b.this.bdF.DV();
                com.baidu.swan.apps.performance.f.aT("preload", "startup");
                int Mu = a.alq().Mu();
                HybridUbcFlow jx = com.baidu.swan.apps.performance.f.jx("startup");
                jx.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).aR("codecache", String.valueOf(Mu)).f(new UbcFlowEvent("na_first_paint")).WN();
                long o = jx.o("na_first_paint", "naStart");
                a.alq().a(new com.baidu.swan.games.o.b(o));
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + o);
                }
                com.baidu.swan.games.utils.c.anm().ans();
            }
        });
    }

    private void Qq() {
        if (ZM().available()) {
            SwanCoreVersion Oe = a.alq().Oe();
            long lX = com.baidu.swan.apps.swancore.b.lX(DR().Ta());
            if (lX != 0 && Oe != null && Oe.swanCoreVersion != 0 && Oe.swanCoreVersion < lX) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "release SwanGameCoreRuntime minSwanVersion:" + lX + ", runtimeSwanCoreVersion:" + Oe.swanCoreVersion);
                }
                a.release();
                return;
            }
            SwanCoreVersion Oe2 = DR().Oe();
            if ((Oe == null || Oe2 == null || Oe.swanCoreVersion == 0 || Oe.swanCoreVersion >= Oe2.swanCoreVersion || !com.baidu.swan.apps.x.b.a.eO(DR().Tj())) ? false : true) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime版本过低释放并重新加载");
                }
                a.release();
            }
        }
    }
}
