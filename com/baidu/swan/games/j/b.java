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
/* loaded from: classes8.dex */
public class b extends com.baidu.swan.apps.framework.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private long eeR;

    public b(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void p(boolean z, boolean z2) {
        if (z) {
            h.aLo();
            if (z2) {
                d.e(afB());
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        avi();
        com.baidu.swan.games.v.b.aXZ().clear();
        com.baidu.swan.games.network.b.d.aXq().release();
        aIj().hh(true);
        aWz();
        V8Engine.setCrashKeyValue("game_title", afB() == null ? "" : afB().asE());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void auy() {
        f.azN().cU(this.cJC);
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
        d.b(RGState.METHOD_NAME_EXIT, afB());
        f.azN().cV(this.cJC);
        f.release();
        com.baidu.swan.games.aa.a.aYo().release();
        SwanInspectorEndpoint.aWY().close();
        com.baidu.swan.games.v.b.aXZ().clear();
        com.baidu.swan.games.network.b.d.aXq().release();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int afr() {
        return 1;
    }

    private void aWz() {
        rh();
        if (com.baidu.swan.apps.runtime.d.aIn().aFD()) {
            f.azN().a(afB(), new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.games.j.b.1
                @Override // com.baidu.swan.apps.r.b
                public void a(int i, com.baidu.swan.apps.r.a aVar) {
                    a.b bVar = (a.b) aVar;
                    if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
                        a.aWo().e(b.this.afB());
                        a.aWo().a(bVar);
                        com.baidu.swan.games.audio.b.b.aTR();
                        b.this.aWA();
                        b.this.aWB();
                    }
                }
            });
            if (a.aWo().aWt() && a.aWo().aWv()) {
                a.aWo().m(this.cJC);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWA() {
        com.baidu.swan.games.utils.c.aYs().aYD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWB() {
        com.baidu.swan.games.utils.c.aYs().aYC();
    }

    public com.baidu.swan.games.f.a getV8Engine() {
        return a.aWo().aWp();
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b auV() {
        return new a.b() { // from class: com.baidu.swan.games.j.b.2
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean l(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.aFe().a(new com.baidu.swan.apps.process.messaging.c(4));
                        b.this.auS();
                        a.aWo().aWs();
                        com.baidu.swan.apps.runtime.d.aIn().aIk();
                        return true;
                    case 102:
                        boolean ahK = com.baidu.swan.apps.t.a.awU().ahK();
                        com.baidu.swan.apps.t.a.awU().eI(ahK);
                        if (b.this.cJC != null) {
                            b.this.cJC.k(ahK, false);
                            return true;
                        }
                        return true;
                    case 103:
                        e aIr = e.aIr();
                        if (aIr != null) {
                            aIr.aID().clear();
                            com.baidu.swan.apps.network.c.a.aCM().aCR();
                        }
                        b.this.auS();
                        a.aWo().aWs();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.aIn().aIk();
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
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count:" + this.daf.apb());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.c aoY = this.daf.aoY();
        if (aoY == null || !aoY.ais()) {
            if (auZ()) {
                e aIr = e.aIr();
                if (aIr != null) {
                    aIr.aII().release();
                }
                d.b("back", afB());
                return;
            }
            this.daf.mk("navigateBack").ai(com.baidu.swan.apps.core.d.f.cQo, com.baidu.swan.apps.core.d.f.cQn).apf().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean isLandScape() {
        return com.baidu.swan.apps.runtime.d.aIn().aIj().afB().getOrientation() == 1;
    }

    private void rh() {
        this.eeR = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void ava() {
        super.ava();
        a.aWo().Y(this.cJC);
    }

    public boolean aWC() {
        return this.eeR > 0;
    }

    public long aWD() {
        return this.eeR;
    }

    public void onFirstFrameFinished() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager onFirstFrameFinished");
                }
                b.this.eeR = System.currentTimeMillis();
                d.e(b.this.afB());
                b.this.cJC.afE();
                com.baidu.swan.apps.performance.i.co("preload", "startup");
                int apR = a.aWo().apR();
                HybridUbcFlow pS = com.baidu.swan.apps.performance.i.pS("startup");
                pS.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).cm("codecache", String.valueOf(apR)).f(new UbcFlowEvent("na_first_paint")).aDm();
                long B = pS.B("na_first_paint", "naStart");
                a.aWo().a(new com.baidu.swan.games.p.b(B));
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + B);
                }
                com.baidu.swan.games.utils.c.aYs().aYy();
                com.baidu.swan.games.m.a.aXg().init();
            }
        });
        com.baidu.swan.games.utils.d.aYK();
    }

    private void avi() {
        if (aIj().available()) {
            SwanCoreVersion asb = a.aWo().asb();
            long td = com.baidu.swan.apps.swancore.b.td(afB().ayG());
            if (td != 0 && asb != null && asb.swanCoreVersion != 0 && asb.swanCoreVersion < td) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "release SwanGameCoreRuntime minSwanVersion:" + td + ", runtimeSwanCoreVersion:" + asb.swanCoreVersion);
                }
                a.release();
                return;
            }
            SwanCoreVersion asb2 = afB().asb();
            if ((asb == null || asb2 == null || asb.swanCoreVersion == 0 || asb.swanCoreVersion >= asb2.swanCoreVersion || !com.baidu.swan.apps.u.c.a.hJ(afB().ayP())) ? false : true) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime版本过低释放并重新加载");
                }
                a.release();
            }
        }
    }
}
