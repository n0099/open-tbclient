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
/* loaded from: classes10.dex */
public class b extends com.baidu.swan.apps.framework.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private long cke;

    public b(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void j(boolean z, boolean z2) {
        if (z) {
            Qw();
            if (z2) {
                d.d(En());
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        QM();
        com.baidu.swan.games.u.b.ann().clear();
        com.baidu.swan.games.network.b.d.amE().release();
        aaj().dG(true);
        alS();
        V8Engine.setCrashKeyValue("game_title", En() == null ? "" : En().OL());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void Qd() {
        f.UC().cc(this.bev);
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
        d.b(RGState.METHOD_NAME_EXIT, En());
        f.UC().cd(this.bev);
        f.release();
        com.baidu.swan.games.z.a.anC().release();
        SwanInspectorEndpoint.amq().close();
        com.baidu.swan.games.u.b.ann().clear();
        com.baidu.swan.games.network.b.d.amE().release();
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public int Ed() {
        return 1;
    }

    private void alS() {
        kJ();
        if (com.baidu.swan.apps.runtime.d.aam().YT()) {
            f.UC().a(En(), new com.baidu.swan.apps.t.b() { // from class: com.baidu.swan.games.i.b.1
                @Override // com.baidu.swan.apps.t.b
                public void a(int i, com.baidu.swan.apps.t.a aVar) {
                    a.b bVar = (a.b) aVar;
                    if (bVar != null && !TextUtils.isEmpty(bVar.clm)) {
                        a.alJ().e(b.this.En());
                        a.alJ().a(bVar);
                        com.baidu.swan.games.audio.b.b.ajl();
                        b.this.alT();
                    }
                }
            });
            if (a.alJ().alN() && a.alJ().alP()) {
                a.alJ().l(this.bev);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alT() {
        com.baidu.swan.games.utils.c.anF().anP();
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return a.alJ().alK();
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b QA() {
        return new a.b() { // from class: com.baidu.swan.games.i.b.2
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean m(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.Yv().a(new com.baidu.swan.apps.process.messaging.c(4));
                        b.this.Qx();
                        a.alJ().alM();
                        com.baidu.swan.apps.runtime.d.aam().aak();
                        return true;
                    case 102:
                        boolean nightModeSwitcherState = com.baidu.swan.apps.w.a.Sc().getNightModeSwitcherState();
                        com.baidu.swan.apps.w.a.Sc().bM(nightModeSwitcherState);
                        if (b.this.bev != null) {
                            b.this.bev.g(nightModeSwitcherState, false);
                            return true;
                        }
                        return true;
                    case 103:
                        e aap = e.aap();
                        if (aap != null) {
                            aap.aaz().clear();
                            com.baidu.swan.apps.network.c.a.WL().WR();
                        }
                        b.this.Qx();
                        a.alJ().alM();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.aam().aak();
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
        com.baidu.swan.apps.console.c.d("SwanApp", "onBackPressed back stack count:" + this.brm.Ma());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.b LX = this.brm.LX();
        if (LX == null || !LX.Gt()) {
            if (QE()) {
                e aap = e.aap();
                if (aap != null) {
                    aap.aaE().release();
                }
                d.b("back", En());
                return;
            }
            this.brm.gM("navigateBack").Y(com.baidu.swan.apps.core.d.e.bjW, com.baidu.swan.apps.core.d.e.bjV).Mf().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean isLandScape() {
        return com.baidu.swan.apps.runtime.d.aam().aaj().En().getOrientation() == 1;
    }

    private void kJ() {
        this.cke = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void QF() {
        super.QF();
        a.alJ().Z(this.bev);
    }

    public boolean alU() {
        return this.cke > 0;
    }

    public long alV() {
        return this.cke;
    }

    public void onFirstFrameFinished() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.i.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager onFirstFrameFinished");
                }
                b.this.cke = System.currentTimeMillis();
                d.d(b.this.En());
                b.this.bev.Er();
                com.baidu.swan.apps.performance.f.aU("preload", "startup");
                int MQ = a.alJ().MQ();
                HybridUbcFlow jA = com.baidu.swan.apps.performance.f.jA("startup");
                jA.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).aS("codecache", String.valueOf(MQ)).f(new UbcFlowEvent("na_first_paint")).Xk();
                long o = jA.o("na_first_paint", "naStart");
                a.alJ().a(new com.baidu.swan.games.o.b(o));
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + o);
                }
                com.baidu.swan.games.utils.c.anF().anL();
            }
        });
    }

    private void QM() {
        if (aaj().available()) {
            SwanCoreVersion OA = a.alJ().OA();
            long ma = com.baidu.swan.apps.swancore.b.ma(En().Tx());
            if (ma != 0 && OA != null && OA.swanCoreVersion != 0 && OA.swanCoreVersion < ma) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "release SwanGameCoreRuntime minSwanVersion:" + ma + ", runtimeSwanCoreVersion:" + OA.swanCoreVersion);
                }
                a.release();
                return;
            }
            SwanCoreVersion OA2 = En().OA();
            if ((OA == null || OA2 == null || OA.swanCoreVersion == 0 || OA.swanCoreVersion >= OA2.swanCoreVersion || !com.baidu.swan.apps.x.b.a.eP(En().TG())) ? false : true) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime版本过低释放并重新加载");
                }
                a.release();
            }
        }
    }
}
