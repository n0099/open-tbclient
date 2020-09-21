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
/* loaded from: classes3.dex */
public class b extends com.baidu.swan.apps.framework.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private long dvb;

    public b(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void p(boolean z, boolean z2) {
        if (z) {
            h.aDp();
            if (z2) {
                d.e(YI());
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        aod();
        com.baidu.swan.games.v.b.aPY().clear();
        com.baidu.swan.games.network.b.d.aPp().release();
        aAj().fJ(true);
        aOy();
        V8Engine.setCrashKeyValue("game_title", YI() == null ? "" : YI().aly());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void ant() {
        f.asJ().cb(this.cdy);
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
        d.b(RGState.METHOD_NAME_EXIT, YI());
        f.asJ().cc(this.cdy);
        f.release();
        com.baidu.swan.games.aa.a.aQn().release();
        SwanInspectorEndpoint.aOX().close();
        com.baidu.swan.games.v.b.aPY().clear();
        com.baidu.swan.games.network.b.d.aPp().release();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int Yy() {
        return 1;
    }

    private void aOy() {
        rE();
        if (com.baidu.swan.apps.runtime.d.aAn().ayA()) {
            f.asJ().a(YI(), new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.games.j.b.1
                @Override // com.baidu.swan.apps.r.b
                public void a(int i, com.baidu.swan.apps.r.a aVar) {
                    a.b bVar = (a.b) aVar;
                    if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
                        a.aOn().e(b.this.YI());
                        a.aOn().a(bVar);
                        com.baidu.swan.games.audio.b.b.aLQ();
                        b.this.aOz();
                        b.this.aOA();
                    }
                }
            });
            if (a.aOn().aOs() && a.aOn().aOu()) {
                a.aOn().m(this.cdy);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOz() {
        com.baidu.swan.games.utils.c.aQr().aQC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOA() {
        com.baidu.swan.games.utils.c.aQr().aQB();
    }

    public com.baidu.swan.games.f.a getV8Engine() {
        return a.aOn().aOo();
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b anQ() {
        return new a.b() { // from class: com.baidu.swan.games.j.b.2
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean l(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.ayb().a(new com.baidu.swan.apps.process.messaging.c(4));
                        b.this.anN();
                        a.aOn().aOr();
                        com.baidu.swan.apps.runtime.d.aAn().aAk();
                        return true;
                    case 102:
                        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.apQ().getNightModeSwitcherState();
                        com.baidu.swan.apps.t.a.apQ().dt(nightModeSwitcherState);
                        if (b.this.cdy != null) {
                            b.this.cdy.k(nightModeSwitcherState, false);
                            return true;
                        }
                        return true;
                    case 103:
                        e aAr = e.aAr();
                        if (aAr != null) {
                            aAr.aAD().clear();
                            com.baidu.swan.apps.network.c.a.avF().avK();
                        }
                        b.this.anN();
                        a.aOn().aOr();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.aAn().aAk();
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
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count:" + this.cus.ahZ());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.c ahW = this.cus.ahW();
        if (ahW == null || !ahW.abv()) {
            if (anU()) {
                e aAr = e.aAr();
                if (aAr != null) {
                    aAr.aAI().release();
                }
                d.b("back", YI());
                return;
            }
            this.cus.lH("navigateBack").al(com.baidu.swan.apps.core.d.f.ckn, com.baidu.swan.apps.core.d.f.ckm).aid().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean isLandScape() {
        return com.baidu.swan.apps.runtime.d.aAn().aAj().YI().getOrientation() == 1;
    }

    private void rE() {
        this.dvb = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void anV() {
        super.anV();
        a.aOn().W(this.cdy);
    }

    public boolean aOB() {
        return this.dvb > 0;
    }

    public long aOC() {
        return this.dvb;
    }

    public void onFirstFrameFinished() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager onFirstFrameFinished");
                }
                b.this.dvb = System.currentTimeMillis();
                d.e(b.this.YI());
                b.this.cdy.YL();
                com.baidu.swan.apps.performance.i.bY("preload", "startup");
                int aiO = a.aOn().aiO();
                HybridUbcFlow pq = com.baidu.swan.apps.performance.i.pq("startup");
                pq.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).bW("codecache", String.valueOf(aiO)).f(new UbcFlowEvent("na_first_paint")).awg();
                long s = pq.s("na_first_paint", "naStart");
                a.aOn().a(new com.baidu.swan.games.p.b(s));
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + s);
                }
                com.baidu.swan.games.utils.c.aQr().aQx();
                com.baidu.swan.games.m.a.aPf().init();
            }
        });
        com.baidu.swan.games.utils.d.aQJ();
    }

    private void aod() {
        if (aAj().available()) {
            SwanCoreVersion akX = a.aOn().akX();
            long sw = com.baidu.swan.apps.swancore.b.sw(YI().arB());
            if (sw != 0 && akX != null && akX.swanCoreVersion != 0 && akX.swanCoreVersion < sw) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "release SwanGameCoreRuntime minSwanVersion:" + sw + ", runtimeSwanCoreVersion:" + akX.swanCoreVersion);
                }
                a.release();
                return;
            }
            SwanCoreVersion akX2 = YI().akX();
            if ((akX == null || akX2 == null || akX.swanCoreVersion == 0 || akX.swanCoreVersion >= akX2.swanCoreVersion || !com.baidu.swan.apps.u.c.a.ii(YI().arK())) ? false : true) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime版本过低释放并重新加载");
                }
                a.release();
            }
        }
    }
}
