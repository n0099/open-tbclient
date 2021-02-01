package com.baidu.swan.games.j;

import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.walknavi.fsm.RGState;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ao.ak;
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
/* loaded from: classes9.dex */
public class b extends com.baidu.swan.apps.framework.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private long egZ;

    public b(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void q(boolean z, boolean z2) {
        if (z) {
            h.aLH();
            if (z2) {
                d.e(afZ());
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        avG();
        com.baidu.swan.games.v.b.aYl().clear();
        com.baidu.swan.games.network.b.d.aXC().release();
        aIC().hj(true);
        aWL();
        V8Engine.setCrashKeyValue("game_title", afZ() == null ? "" : afZ().atc());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void auW() {
        f.aAl().cT(this.cLQ);
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
        d.b(RGState.METHOD_NAME_EXIT, afZ());
        f.aAl().cU(this.cLQ);
        f.release();
        com.baidu.swan.games.aa.a.aYA().release();
        SwanInspectorEndpoint.aXk().close();
        com.baidu.swan.games.v.b.aYl().clear();
        com.baidu.swan.games.network.b.d.aXC().release();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int getFrameType() {
        return 1;
    }

    private void aWL() {
        rf();
        if (com.baidu.swan.apps.runtime.d.aIG().aFY()) {
            f.aAl().a(afZ(), new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.games.j.b.1
                @Override // com.baidu.swan.apps.r.b
                public void a(int i, com.baidu.swan.apps.r.a aVar) {
                    a.b bVar = (a.b) aVar;
                    if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
                        a.aWA().e(b.this.afZ());
                        a.aWA().a(bVar);
                        com.baidu.swan.games.audio.b.b.aUd();
                        b.this.aWM();
                        b.this.aWN();
                    }
                }
            });
            if (a.aWA().aWF() && a.aWA().aWH()) {
                a.aWA().m(this.cLQ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWM() {
        com.baidu.swan.games.utils.c.aYE().aYP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWN() {
        com.baidu.swan.games.utils.c.aYE().aYO();
    }

    public com.baidu.swan.games.f.a getV8Engine() {
        return a.aWA().aWB();
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b avt() {
        return new a.b() { // from class: com.baidu.swan.games.j.b.2
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean l(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.aFz().a(new com.baidu.swan.apps.process.messaging.c(4));
                        b.this.avq();
                        a.aWA().aWE();
                        com.baidu.swan.apps.runtime.d.aIG().aID();
                        return true;
                    case 102:
                        boolean aii = com.baidu.swan.apps.t.a.axs().aii();
                        com.baidu.swan.apps.t.a.axs().eK(aii);
                        if (b.this.cLQ != null) {
                            b.this.cLQ.l(aii, false);
                            return true;
                        }
                        return true;
                    case 103:
                        e aIK = e.aIK();
                        if (aIK != null) {
                            aIK.aIW().clear();
                            com.baidu.swan.apps.network.c.a.aDi().aDn();
                        }
                        b.this.avq();
                        a.aWA().aWE();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.aIG().aID();
                        return true;
                    case 107:
                        com.baidu.swan.apps.core.pms.h.m(message);
                        return true;
                    case Constants.METHOD_IM_FRIEND_GROUP_QUERY /* 123 */:
                        com.baidu.swan.apps.ao.b.O(message);
                        return true;
                    case Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER /* 124 */:
                        com.baidu.swan.apps.ao.b.P(message);
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
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count:" + this.dcr.apA());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.c apx = this.dcr.apx();
        if (apx == null || !apx.aiQ()) {
            if (avx()) {
                e aIK = e.aIK();
                if (aIK != null) {
                    aIK.aJb().release();
                }
                d.b("back", afZ());
                return;
            }
            this.dcr.mC("navigateBack").af(com.baidu.swan.apps.core.d.f.cSB, com.baidu.swan.apps.core.d.f.cSA).apE().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean isLandScape() {
        return com.baidu.swan.apps.runtime.d.aIG().aIC().afZ().getOrientation() == 1;
    }

    private void rf() {
        this.egZ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void avy() {
        super.avy();
        a.aWA().S(this.cLQ);
    }

    public boolean aWO() {
        return this.egZ > 0;
    }

    public long aWP() {
        return this.egZ;
    }

    public void onFirstFrameFinished() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager onFirstFrameFinished");
                }
                b.this.egZ = System.currentTimeMillis();
                d.e(b.this.afZ());
                b.this.cLQ.agc();
                com.baidu.swan.apps.performance.i.ci("preload", "startup");
                int aqp = a.aWA().aqp();
                HybridUbcFlow qk = com.baidu.swan.apps.performance.i.qk("startup");
                qk.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).cg("codecache", String.valueOf(aqp)).f(new UbcFlowEvent("na_first_paint")).aDI();
                long B = qk.B("na_first_paint", "naStart");
                a.aWA().a(new com.baidu.swan.games.p.b(B));
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + B);
                }
                com.baidu.swan.games.utils.c.aYE().aYK();
                com.baidu.swan.games.m.a.aXs().init();
            }
        });
        com.baidu.swan.games.utils.d.aYW();
    }

    private void avG() {
        if (aIC().available()) {
            SwanCoreVersion asA = a.aWA().asA();
            long tw = com.baidu.swan.apps.swancore.b.tw(afZ().aze());
            if (tw != 0 && asA != null && asA.swanCoreVersion != 0 && asA.swanCoreVersion < tw) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "release SwanGameCoreRuntime minSwanVersion:" + tw + ", runtimeSwanCoreVersion:" + asA.swanCoreVersion);
                }
                a.release();
                return;
            }
            SwanCoreVersion asA2 = afZ().asA();
            if ((asA == null || asA2 == null || asA.swanCoreVersion == 0 || asA.swanCoreVersion >= asA2.swanCoreVersion || !com.baidu.swan.apps.u.c.a.hM(afZ().azn())) ? false : true) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime版本过低释放并重新加载");
                }
                a.release();
            }
        }
    }
}
