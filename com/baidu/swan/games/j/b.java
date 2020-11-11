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
/* loaded from: classes10.dex */
public class b extends com.baidu.swan.apps.framework.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private long dVr;

    public b(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void p(boolean z, boolean z2) {
        if (z) {
            h.aKs();
            if (z2) {
                d.e(afO());
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        avk();
        com.baidu.swan.games.v.b.aXb().clear();
        com.baidu.swan.games.network.b.d.aWs().release();
        aHm().gB(true);
        aVB();
        V8Engine.setCrashKeyValue("game_title", afO() == null ? "" : afO().asF());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void auA() {
        f.azO().ch(this.cEi);
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
        d.b(RGState.METHOD_NAME_EXIT, afO());
        f.azO().ci(this.cEi);
        f.release();
        com.baidu.swan.games.aa.a.aXq().release();
        SwanInspectorEndpoint.aWa().close();
        com.baidu.swan.games.v.b.aXb().clear();
        com.baidu.swan.games.network.b.d.aWs().release();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int afE() {
        return 1;
    }

    private void aVB() {
        rE();
        if (com.baidu.swan.apps.runtime.d.aHq().aFD()) {
            f.azO().a(afO(), new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.games.j.b.1
                @Override // com.baidu.swan.apps.r.b
                public void a(int i, com.baidu.swan.apps.r.a aVar) {
                    a.b bVar = (a.b) aVar;
                    if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
                        a.aVq().e(b.this.afO());
                        a.aVq().a(bVar);
                        com.baidu.swan.games.audio.b.b.aST();
                        b.this.aVC();
                        b.this.aVD();
                    }
                }
            });
            if (a.aVq().aVv() && a.aVq().aVx()) {
                a.aVq().m(this.cEi);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVC() {
        com.baidu.swan.games.utils.c.aXu().aXF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVD() {
        com.baidu.swan.games.utils.c.aXu().aXE();
    }

    public com.baidu.swan.games.f.a getV8Engine() {
        return a.aVq().aVr();
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b auX() {
        return new a.b() { // from class: com.baidu.swan.games.j.b.2
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean l(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.aFe().a(new com.baidu.swan.apps.process.messaging.c(4));
                        b.this.auU();
                        a.aVq().aVu();
                        com.baidu.swan.apps.runtime.d.aHq().aHn();
                        return true;
                    case 102:
                        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.awW().getNightModeSwitcherState();
                        com.baidu.swan.apps.t.a.awW().el(nightModeSwitcherState);
                        if (b.this.cEi != null) {
                            b.this.cEi.k(nightModeSwitcherState, false);
                            return true;
                        }
                        return true;
                    case 103:
                        e aHu = e.aHu();
                        if (aHu != null) {
                            aHu.aHG().clear();
                            com.baidu.swan.apps.network.c.a.aCK().aCP();
                        }
                        b.this.auU();
                        a.aVq().aVu();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.aHq().aHn();
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
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count:" + this.cUP.ape());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.c apb = this.cUP.apb();
        if (apb == null || !apb.aiB()) {
            if (avb()) {
                e aHu = e.aHu();
                if (aHu != null) {
                    aHu.aHL().release();
                }
                d.b("back", afO());
                return;
            }
            this.cUP.nb("navigateBack").al(com.baidu.swan.apps.core.d.f.cKU, com.baidu.swan.apps.core.d.f.cKT).apj().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean isLandScape() {
        return com.baidu.swan.apps.runtime.d.aHq().aHm().afO().getOrientation() == 1;
    }

    private void rE() {
        this.dVr = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void avc() {
        super.avc();
        a.aVq().X(this.cEi);
    }

    public boolean aVE() {
        return this.dVr > 0;
    }

    public long aVF() {
        return this.dVr;
    }

    public void onFirstFrameFinished() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager onFirstFrameFinished");
                }
                b.this.dVr = System.currentTimeMillis();
                d.e(b.this.afO());
                b.this.cEi.afR();
                com.baidu.swan.apps.performance.i.ck("preload", "startup");
                int apU = a.aVq().apU();
                HybridUbcFlow qJ = com.baidu.swan.apps.performance.i.qJ("startup");
                qJ.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).ci("codecache", String.valueOf(apU)).f(new UbcFlowEvent("na_first_paint")).aDl();
                long u = qJ.u("na_first_paint", "naStart");
                a.aVq().a(new com.baidu.swan.games.p.b(u));
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + u);
                }
                com.baidu.swan.games.utils.c.aXu().aXA();
                com.baidu.swan.games.m.a.aWi().init();
            }
        });
        com.baidu.swan.games.utils.d.aXM();
    }

    private void avk() {
        if (aHm().available()) {
            SwanCoreVersion asd = a.aVq().asd();
            long tP = com.baidu.swan.apps.swancore.b.tP(afO().ayH());
            if (tP != 0 && asd != null && asd.swanCoreVersion != 0 && asd.swanCoreVersion < tP) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "release SwanGameCoreRuntime minSwanVersion:" + tP + ", runtimeSwanCoreVersion:" + asd.swanCoreVersion);
                }
                a.release();
                return;
            }
            SwanCoreVersion asd2 = afO().asd();
            if ((asd == null || asd2 == null || asd.swanCoreVersion == 0 || asd.swanCoreVersion >= asd2.swanCoreVersion || !com.baidu.swan.apps.u.c.a.ja(afO().ayQ())) ? false : true) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime版本过低释放并重新加载");
                }
                a.release();
            }
        }
    }
}
