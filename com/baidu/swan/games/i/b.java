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
    private long cNs;

    public b(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void l(boolean z, boolean z2) {
        if (z) {
            aaE();
            if (z2) {
                d.d(Ow());
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        aaU();
        com.baidu.swan.games.u.b.axS().clear();
        com.baidu.swan.games.network.b.d.axj().release();
        akH().eK(true);
        awx();
        V8Engine.setCrashKeyValue("game_title", Ow() == null ? "" : Ow().YT());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void aal() {
        f.aeK().bT(this.bHg);
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
        d.b(RGState.METHOD_NAME_EXIT, Ow());
        f.aeK().bU(this.bHg);
        f.release();
        com.baidu.swan.games.z.a.ayh().release();
        SwanInspectorEndpoint.awV().close();
        com.baidu.swan.games.u.b.axS().clear();
        com.baidu.swan.games.network.b.d.axj().release();
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public int Om() {
        return 1;
    }

    private void awx() {
        pC();
        if (com.baidu.swan.apps.runtime.d.akK().ajr()) {
            f.aeK().a(Ow(), new com.baidu.swan.apps.t.b() { // from class: com.baidu.swan.games.i.b.1
                @Override // com.baidu.swan.apps.t.b
                public void a(int i, com.baidu.swan.apps.t.a aVar) {
                    a.b bVar = (a.b) aVar;
                    if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
                        a.awo().e(b.this.Ow());
                        a.awo().a(bVar);
                        com.baidu.swan.games.audio.b.b.atS();
                        b.this.awy();
                    }
                }
            });
            if (a.awo().aws() && a.awo().awu()) {
                a.awo().l(this.bHg);
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
    protected a.b aaI() {
        return new a.b() { // from class: com.baidu.swan.games.i.b.2
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean m(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.aiT().a(new com.baidu.swan.apps.process.messaging.c(4));
                        b.this.aaF();
                        a.awo().awr();
                        com.baidu.swan.apps.runtime.d.akK().akI();
                        return true;
                    case 102:
                        boolean nightModeSwitcherState = com.baidu.swan.apps.w.a.ack().getNightModeSwitcherState();
                        com.baidu.swan.apps.w.a.ack().cR(nightModeSwitcherState);
                        if (b.this.bHg != null) {
                            b.this.bHg.i(nightModeSwitcherState, false);
                            return true;
                        }
                        return true;
                    case 103:
                        e akN = e.akN();
                        if (akN != null) {
                            akN.akX().clear();
                            com.baidu.swan.apps.network.c.a.ahk().ahq();
                        }
                        b.this.aaF();
                        a.awo().awr();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.akK().akI();
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
        com.baidu.swan.apps.console.c.d("SwanApp", "onBackPressed back stack count:" + this.bTQ.Wh());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.b We = this.bTQ.We();
        if (We == null || !We.Qz()) {
            if (aaM()) {
                e akN = e.akN();
                if (akN != null) {
                    akN.alc().release();
                }
                d.b("back", Ow());
                return;
            }
            this.bTQ.io("navigateBack").ab(com.baidu.swan.apps.core.d.e.bMB, com.baidu.swan.apps.core.d.e.bMA).Wm().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean isLandScape() {
        return com.baidu.swan.apps.runtime.d.akK().akH().Ow().getOrientation() == 1;
    }

    private void pC() {
        this.cNs = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void aaN() {
        super.aaN();
        a.awo().W(this.bHg);
    }

    public boolean awz() {
        return this.cNs > 0;
    }

    public long awA() {
        return this.cNs;
    }

    public void onFirstFrameFinished() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.i.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager onFirstFrameFinished");
                }
                b.this.cNs = System.currentTimeMillis();
                d.d(b.this.Ow());
                b.this.bHg.OA();
                com.baidu.swan.apps.performance.f.bm("preload", "startup");
                int WY = a.awo().WY();
                HybridUbcFlow lb = com.baidu.swan.apps.performance.f.lb("startup");
                lb.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).bk("codecache", String.valueOf(WY)).f(new UbcFlowEvent("na_first_paint")).ahI();
                long s = lb.s("na_first_paint", "naStart");
                a.awo().a(new com.baidu.swan.games.o.b(s));
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + s);
                }
                com.baidu.swan.games.utils.c.ayk().ayq();
            }
        });
    }

    private void aaU() {
        if (akH().available()) {
            SwanCoreVersion YI = a.awo().YI();
            long nB = com.baidu.swan.apps.swancore.b.nB(Ow().adF());
            if (nB != 0 && YI != null && YI.swanCoreVersion != 0 && YI.swanCoreVersion < nB) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "release SwanGameCoreRuntime minSwanVersion:" + nB + ", runtimeSwanCoreVersion:" + YI.swanCoreVersion);
                }
                a.release();
                return;
            }
            SwanCoreVersion YI2 = Ow().YI();
            if ((YI == null || YI2 == null || YI.swanCoreVersion == 0 || YI.swanCoreVersion >= YI2.swanCoreVersion || !com.baidu.swan.apps.x.b.a.fk(Ow().adO())) ? false : true) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime版本过低释放并重新加载");
                }
                a.release();
            }
        }
    }
}
