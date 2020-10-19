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
    private long dHc;

    public b(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void p(boolean z, boolean z2) {
        if (z) {
            h.aFY();
            if (z2) {
                d.e(abu());
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        aqP();
        com.baidu.swan.games.v.b.aSH().clear();
        com.baidu.swan.games.network.b.d.aRY().release();
        aCS().gf(true);
        aRh();
        V8Engine.setCrashKeyValue("game_title", abu() == null ? "" : abu().aoj());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void aqf() {
        f.avu().ch(this.cpO);
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
        d.b(RGState.METHOD_NAME_EXIT, abu());
        f.avu().ci(this.cpO);
        f.release();
        com.baidu.swan.games.aa.a.aSW().release();
        SwanInspectorEndpoint.aRG().close();
        com.baidu.swan.games.v.b.aSH().clear();
        com.baidu.swan.games.network.b.d.aRY().release();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int abk() {
        return 1;
    }

    private void aRh() {
        rE();
        if (com.baidu.swan.apps.runtime.d.aCW().aBj()) {
            f.avu().a(abu(), new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.games.j.b.1
                @Override // com.baidu.swan.apps.r.b
                public void a(int i, com.baidu.swan.apps.r.a aVar) {
                    a.b bVar = (a.b) aVar;
                    if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
                        a.aQW().e(b.this.abu());
                        a.aQW().a(bVar);
                        com.baidu.swan.games.audio.b.b.aOz();
                        b.this.aRi();
                        b.this.aRj();
                    }
                }
            });
            if (a.aQW().aRb() && a.aQW().aRd()) {
                a.aQW().m(this.cpO);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRi() {
        com.baidu.swan.games.utils.c.aTa().aTl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRj() {
        com.baidu.swan.games.utils.c.aTa().aTk();
    }

    public com.baidu.swan.games.f.a getV8Engine() {
        return a.aQW().aQX();
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b aqC() {
        return new a.b() { // from class: com.baidu.swan.games.j.b.2
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean l(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.aAK().a(new com.baidu.swan.apps.process.messaging.c(4));
                        b.this.aqz();
                        a.aQW().aRa();
                        com.baidu.swan.apps.runtime.d.aCW().aCT();
                        return true;
                    case 102:
                        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.asC().getNightModeSwitcherState();
                        com.baidu.swan.apps.t.a.asC().dP(nightModeSwitcherState);
                        if (b.this.cpO != null) {
                            b.this.cpO.k(nightModeSwitcherState, false);
                            return true;
                        }
                        return true;
                    case 103:
                        e aDa = e.aDa();
                        if (aDa != null) {
                            aDa.aDm().clear();
                            com.baidu.swan.apps.network.c.a.ayq().ayv();
                        }
                        b.this.aqz();
                        a.aQW().aRa();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.aCW().aCT();
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
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count:" + this.cGA.akK());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.c akH = this.cGA.akH();
        if (akH == null || !akH.aeh()) {
            if (aqG()) {
                e aDa = e.aDa();
                if (aDa != null) {
                    aDa.aDr().release();
                }
                d.b("back", abu());
                return;
            }
            this.cGA.mt("navigateBack").ak(com.baidu.swan.apps.core.d.f.cwF, com.baidu.swan.apps.core.d.f.cwE).akO().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean isLandScape() {
        return com.baidu.swan.apps.runtime.d.aCW().aCS().abu().getOrientation() == 1;
    }

    private void rE() {
        this.dHc = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void aqH() {
        super.aqH();
        a.aQW().X(this.cpO);
    }

    public boolean aRk() {
        return this.dHc > 0;
    }

    public long aRl() {
        return this.dHc;
    }

    public void onFirstFrameFinished() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager onFirstFrameFinished");
                }
                b.this.dHc = System.currentTimeMillis();
                d.e(b.this.abu());
                b.this.cpO.abx();
                com.baidu.swan.apps.performance.i.cd("preload", "startup");
                int alz = a.aQW().alz();
                HybridUbcFlow qc = com.baidu.swan.apps.performance.i.qc("startup");
                qc.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).cb("codecache", String.valueOf(alz)).f(new UbcFlowEvent("na_first_paint")).ayR();
                long t = qc.t("na_first_paint", "naStart");
                a.aQW().a(new com.baidu.swan.games.p.b(t));
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + t);
                }
                com.baidu.swan.games.utils.c.aTa().aTg();
                com.baidu.swan.games.m.a.aRO().init();
            }
        });
        com.baidu.swan.games.utils.d.aTs();
    }

    private void aqP() {
        if (aCS().available()) {
            SwanCoreVersion anI = a.aQW().anI();
            long ti = com.baidu.swan.apps.swancore.b.ti(abu().aun());
            if (ti != 0 && anI != null && anI.swanCoreVersion != 0 && anI.swanCoreVersion < ti) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "release SwanGameCoreRuntime minSwanVersion:" + ti + ", runtimeSwanCoreVersion:" + anI.swanCoreVersion);
                }
                a.release();
                return;
            }
            SwanCoreVersion anI2 = abu().anI();
            if ((anI == null || anI2 == null || anI.swanCoreVersion == 0 || anI.swanCoreVersion >= anI2.swanCoreVersion || !com.baidu.swan.apps.u.c.a.iF(abu().auw())) ? false : true) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime版本过低释放并重新加载");
                }
                a.release();
            }
        }
    }
}
