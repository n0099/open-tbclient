package com.baidu.swan.games.j;

import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.walknavi.fsm.RGState;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ap.ak;
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
/* loaded from: classes8.dex */
public class b extends com.baidu.swan.apps.framework.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private long dsZ;

    public b(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void p(boolean z, boolean z2) {
        if (z) {
            h.aCF();
            if (z2) {
                d.e(XZ());
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        ant();
        com.baidu.swan.games.v.b.aPn().clear();
        com.baidu.swan.games.network.b.d.aOE().release();
        azA().fL(true);
        aNN();
        V8Engine.setCrashKeyValue("game_title", XZ() == null ? "" : XZ().akO());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void amJ() {
        f.arY().cc(this.cbv);
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
        d.b(RGState.METHOD_NAME_EXIT, XZ());
        f.arY().cd(this.cbv);
        f.release();
        com.baidu.swan.games.aa.a.aPC().release();
        SwanInspectorEndpoint.aOm().close();
        com.baidu.swan.games.v.b.aPn().clear();
        com.baidu.swan.games.network.b.d.aOE().release();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int XP() {
        return 1;
    }

    private void aNN() {
        rz();
        if (com.baidu.swan.apps.runtime.d.azE().axR()) {
            f.arY().a(XZ(), new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.games.j.b.1
                @Override // com.baidu.swan.apps.r.b
                public void a(int i, com.baidu.swan.apps.r.a aVar) {
                    a.b bVar = (a.b) aVar;
                    if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
                        a.aNC().e(b.this.XZ());
                        a.aNC().a(bVar);
                        com.baidu.swan.games.audio.b.b.aLf();
                        b.this.aNO();
                        b.this.aNP();
                    }
                }
            });
            if (a.aNC().aNH() && a.aNC().aNJ()) {
                a.aNC().m(this.cbv);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNO() {
        com.baidu.swan.games.utils.c.aPG().aPR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNP() {
        com.baidu.swan.games.utils.c.aPG().aPQ();
    }

    public com.baidu.swan.games.f.a getV8Engine() {
        return a.aNC().aND();
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b ang() {
        return new a.b() { // from class: com.baidu.swan.games.j.b.2
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean l(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.axs().a(new com.baidu.swan.apps.process.messaging.c(4));
                        b.this.and();
                        a.aNC().aNG();
                        com.baidu.swan.apps.runtime.d.azE().azB();
                        return true;
                    case 102:
                        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.apf().getNightModeSwitcherState();
                        com.baidu.swan.apps.t.a.apf().dv(nightModeSwitcherState);
                        if (b.this.cbv != null) {
                            b.this.cbv.k(nightModeSwitcherState, false);
                            return true;
                        }
                        return true;
                    case 103:
                        e azI = e.azI();
                        if (azI != null) {
                            azI.azU().clear();
                            com.baidu.swan.apps.network.c.a.auW().avb();
                        }
                        b.this.and();
                        a.aNC().aNG();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.azE().azB();
                        return true;
                    case 107:
                        com.baidu.swan.apps.core.pms.h.m(message);
                        return true;
                    case Constants.METHOD_IM_FRIEND_GROUP_QUERY /* 123 */:
                        com.baidu.swan.apps.ap.b.O(message);
                        return true;
                    case Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER /* 124 */:
                        com.baidu.swan.apps.ap.b.P(message);
                        return true;
                    case Constants.METHOD_IM_FRIEND_GROUP_ASSIGN /* 125 */:
                        com.baidu.swan.apps.process.messaging.a.a.n(message);
                        return true;
                    case Opcodes.IAND /* 126 */:
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
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count:" + this.csn.ahp());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.c ahm = this.csn.ahm();
        if (ahm == null || !ahm.aaM()) {
            if (ank()) {
                e azI = e.azI();
                if (azI != null) {
                    azI.azZ().release();
                }
                d.b("back", XZ());
                return;
            }
            this.csn.lo("navigateBack").al(com.baidu.swan.apps.core.d.f.cim, com.baidu.swan.apps.core.d.f.cil).aht().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean isLandScape() {
        return com.baidu.swan.apps.runtime.d.azE().azA().XZ().getOrientation() == 1;
    }

    private void rz() {
        this.dsZ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void anl() {
        super.anl();
        a.aNC().U(this.cbv);
    }

    public boolean aNQ() {
        return this.dsZ > 0;
    }

    public long aNR() {
        return this.dsZ;
    }

    public void onFirstFrameFinished() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager onFirstFrameFinished");
                }
                b.this.dsZ = System.currentTimeMillis();
                d.e(b.this.XZ());
                b.this.cbv.Yc();
                com.baidu.swan.apps.performance.i.bY("preload", "startup");
                int aie = a.aNC().aie();
                HybridUbcFlow oX = com.baidu.swan.apps.performance.i.oX("startup");
                oX.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).bW("codecache", String.valueOf(aie)).f(new UbcFlowEvent("na_first_paint")).avx();
                long s = oX.s("na_first_paint", "naStart");
                a.aNC().a(new com.baidu.swan.games.p.b(s));
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + s);
                }
                com.baidu.swan.games.utils.c.aPG().aPM();
                com.baidu.swan.games.m.a.aOu().init();
            }
        });
        com.baidu.swan.games.utils.d.aPY();
    }

    private void ant() {
        if (azA().available()) {
            SwanCoreVersion akn = a.aNC().akn();
            long sc = com.baidu.swan.apps.swancore.b.sc(XZ().aqR());
            if (sc != 0 && akn != null && akn.swanCoreVersion != 0 && akn.swanCoreVersion < sc) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "release SwanGameCoreRuntime minSwanVersion:" + sc + ", runtimeSwanCoreVersion:" + akn.swanCoreVersion);
                }
                a.release();
                return;
            }
            SwanCoreVersion akn2 = XZ().akn();
            if ((akn == null || akn2 == null || akn.swanCoreVersion == 0 || akn.swanCoreVersion >= akn2.swanCoreVersion || !com.baidu.swan.apps.u.c.a.hY(XZ().ara())) ? false : true) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime版本过低释放并重新加载");
                }
                a.release();
            }
        }
    }
}
