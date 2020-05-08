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
    private long cNy;

    public b(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void l(boolean z, boolean z2) {
        if (z) {
            aaD();
            if (z2) {
                d.d(Ov());
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        aaT();
        com.baidu.swan.games.u.b.axS().clear();
        com.baidu.swan.games.network.b.d.axj().release();
        akG().eK(true);
        awx();
        V8Engine.setCrashKeyValue("game_title", Ov() == null ? "" : Ov().YS());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void aak() {
        f.aeJ().bH(this.bHl);
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
        d.b(RGState.METHOD_NAME_EXIT, Ov());
        f.aeJ().bI(this.bHl);
        f.release();
        com.baidu.swan.games.z.a.ayh().release();
        SwanInspectorEndpoint.awV().close();
        com.baidu.swan.games.u.b.axS().clear();
        com.baidu.swan.games.network.b.d.axj().release();
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public int Ol() {
        return 1;
    }

    private void awx() {
        pC();
        if (com.baidu.swan.apps.runtime.d.akJ().ajq()) {
            f.aeJ().a(Ov(), new com.baidu.swan.apps.t.b() { // from class: com.baidu.swan.games.i.b.1
                @Override // com.baidu.swan.apps.t.b
                public void a(int i, com.baidu.swan.apps.t.a aVar) {
                    a.b bVar = (a.b) aVar;
                    if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
                        a.awo().e(b.this.Ov());
                        a.awo().a(bVar);
                        com.baidu.swan.games.audio.b.b.atS();
                        b.this.awy();
                    }
                }
            });
            if (a.awo().aws() && a.awo().awu()) {
                a.awo().l(this.bHl);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awy() {
        com.baidu.swan.games.utils.c.ayk().ayu();
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return a.awo().awp();
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b aaH() {
        return new a.b() { // from class: com.baidu.swan.games.i.b.2
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean m(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.aiS().a(new com.baidu.swan.apps.process.messaging.c(4));
                        b.this.aaE();
                        a.awo().awr();
                        com.baidu.swan.apps.runtime.d.akJ().akH();
                        return true;
                    case 102:
                        boolean nightModeSwitcherState = com.baidu.swan.apps.w.a.acj().getNightModeSwitcherState();
                        com.baidu.swan.apps.w.a.acj().cR(nightModeSwitcherState);
                        if (b.this.bHl != null) {
                            b.this.bHl.i(nightModeSwitcherState, false);
                            return true;
                        }
                        return true;
                    case 103:
                        e akM = e.akM();
                        if (akM != null) {
                            akM.akW().clear();
                            com.baidu.swan.apps.network.c.a.ahj().ahp();
                        }
                        b.this.aaE();
                        a.awo().awr();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.akJ().akH();
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
        com.baidu.swan.apps.console.c.d("SwanApp", "onBackPressed back stack count:" + this.bTW.Wg());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.b Wd = this.bTW.Wd();
        if (Wd == null || !Wd.Qy()) {
            if (aaL()) {
                e akM = e.akM();
                if (akM != null) {
                    akM.alb().release();
                }
                d.b("back", Ov());
                return;
            }
            this.bTW.io("navigateBack").ab(com.baidu.swan.apps.core.d.e.bMG, com.baidu.swan.apps.core.d.e.bMF).Wl().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean isLandScape() {
        return com.baidu.swan.apps.runtime.d.akJ().akG().Ov().getOrientation() == 1;
    }

    private void pC() {
        this.cNy = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void aaM() {
        super.aaM();
        a.awo().W(this.bHl);
    }

    public boolean awz() {
        return this.cNy > 0;
    }

    public long awA() {
        return this.cNy;
    }

    public void onFirstFrameFinished() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.i.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager onFirstFrameFinished");
                }
                b.this.cNy = System.currentTimeMillis();
                d.d(b.this.Ov());
                b.this.bHl.Oz();
                com.baidu.swan.apps.performance.f.bm("preload", "startup");
                int WX = a.awo().WX();
                HybridUbcFlow lb = com.baidu.swan.apps.performance.f.lb("startup");
                lb.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).bk("codecache", String.valueOf(WX)).f(new UbcFlowEvent("na_first_paint")).ahH();
                long s = lb.s("na_first_paint", "naStart");
                a.awo().a(new com.baidu.swan.games.o.b(s));
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + s);
                }
                com.baidu.swan.games.utils.c.ayk().ayq();
            }
        });
    }

    private void aaT() {
        if (akG().available()) {
            SwanCoreVersion YH = a.awo().YH();
            long nB = com.baidu.swan.apps.swancore.b.nB(Ov().adE());
            if (nB != 0 && YH != null && YH.swanCoreVersion != 0 && YH.swanCoreVersion < nB) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "release SwanGameCoreRuntime minSwanVersion:" + nB + ", runtimeSwanCoreVersion:" + YH.swanCoreVersion);
                }
                a.release();
                return;
            }
            SwanCoreVersion YH2 = Ov().YH();
            if ((YH == null || YH2 == null || YH.swanCoreVersion == 0 || YH.swanCoreVersion >= YH2.swanCoreVersion || !com.baidu.swan.apps.x.b.a.fk(Ov().adN())) ? false : true) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime版本过低释放并重新加载");
                }
                a.release();
            }
        }
    }
}
