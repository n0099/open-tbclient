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
/* loaded from: classes7.dex */
public class b extends com.baidu.swan.apps.framework.c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private long dTJ;

    public b(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void p(boolean z, boolean z2) {
        if (z) {
            h.aJK();
            if (z2) {
                d.e(afg());
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        auC();
        com.baidu.swan.games.v.b.aWt().clear();
        com.baidu.swan.games.network.b.d.aVK().release();
        aGE().gE(true);
        aUT();
        V8Engine.setCrashKeyValue("game_title", afg() == null ? "" : afg().arW());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void atS() {
        f.azg().ch(this.cCy);
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
        d.b(RGState.METHOD_NAME_EXIT, afg());
        f.azg().ci(this.cCy);
        f.release();
        com.baidu.swan.games.aa.a.aWI().release();
        SwanInspectorEndpoint.aVs().close();
        com.baidu.swan.games.v.b.aWt().clear();
        com.baidu.swan.games.network.b.d.aVK().release();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int aeW() {
        return 1;
    }

    private void aUT() {
        rE();
        if (com.baidu.swan.apps.runtime.d.aGI().aEV()) {
            f.azg().a(afg(), new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.games.j.b.1
                @Override // com.baidu.swan.apps.r.b
                public void a(int i, com.baidu.swan.apps.r.a aVar) {
                    a.b bVar = (a.b) aVar;
                    if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
                        a.aUI().e(b.this.afg());
                        a.aUI().a(bVar);
                        com.baidu.swan.games.audio.b.b.aSl();
                        b.this.aUU();
                        b.this.aUV();
                    }
                }
            });
            if (a.aUI().aUN() && a.aUI().aUP()) {
                a.aUI().m(this.cCy);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUU() {
        com.baidu.swan.games.utils.c.aWM().aWX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUV() {
        com.baidu.swan.games.utils.c.aWM().aWW();
    }

    public com.baidu.swan.games.f.a getV8Engine() {
        return a.aUI().aUJ();
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b aup() {
        return new a.b() { // from class: com.baidu.swan.games.j.b.2
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean l(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.aEw().a(new com.baidu.swan.apps.process.messaging.c(4));
                        b.this.aum();
                        a.aUI().aUM();
                        com.baidu.swan.apps.runtime.d.aGI().aGF();
                        return true;
                    case 102:
                        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.awo().getNightModeSwitcherState();
                        com.baidu.swan.apps.t.a.awo().eo(nightModeSwitcherState);
                        if (b.this.cCy != null) {
                            b.this.cCy.k(nightModeSwitcherState, false);
                            return true;
                        }
                        return true;
                    case 103:
                        e aGM = e.aGM();
                        if (aGM != null) {
                            aGM.aGY().clear();
                            com.baidu.swan.apps.network.c.a.aCc().aCh();
                        }
                        b.this.aum();
                        a.aUI().aUM();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.aGI().aGF();
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
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count:" + this.cTf.aow());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.c aot = this.cTf.aot();
        if (aot == null || !aot.ahT()) {
            if (aut()) {
                e aGM = e.aGM();
                if (aGM != null) {
                    aGM.aHd().release();
                }
                d.b("back", afg());
                return;
            }
            this.cTf.mV("navigateBack").al(com.baidu.swan.apps.core.d.f.cJk, com.baidu.swan.apps.core.d.f.cJj).aoA().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean isLandScape() {
        return com.baidu.swan.apps.runtime.d.aGI().aGE().afg().getOrientation() == 1;
    }

    private void rE() {
        this.dTJ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void auu() {
        super.auu();
        a.aUI().W(this.cCy);
    }

    public boolean aUW() {
        return this.dTJ > 0;
    }

    public long aUX() {
        return this.dTJ;
    }

    public void onFirstFrameFinished() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager onFirstFrameFinished");
                }
                b.this.dTJ = System.currentTimeMillis();
                d.e(b.this.afg());
                b.this.cCy.afj();
                com.baidu.swan.apps.performance.i.cj("preload", "startup");
                int apm = a.aUI().apm();
                HybridUbcFlow qD = com.baidu.swan.apps.performance.i.qD("startup");
                qD.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).ch("codecache", String.valueOf(apm)).f(new UbcFlowEvent("na_first_paint")).aCD();
                long u = qD.u("na_first_paint", "naStart");
                a.aUI().a(new com.baidu.swan.games.p.b(u));
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + u);
                }
                com.baidu.swan.games.utils.c.aWM().aWS();
                com.baidu.swan.games.m.a.aVA().init();
            }
        });
        com.baidu.swan.games.utils.d.aXe();
    }

    private void auC() {
        if (aGE().available()) {
            SwanCoreVersion arv = a.aUI().arv();
            long tK = com.baidu.swan.apps.swancore.b.tK(afg().axZ());
            if (tK != 0 && arv != null && arv.swanCoreVersion != 0 && arv.swanCoreVersion < tK) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "release SwanGameCoreRuntime minSwanVersion:" + tK + ", runtimeSwanCoreVersion:" + arv.swanCoreVersion);
                }
                a.release();
                return;
            }
            SwanCoreVersion arv2 = afg().arv();
            if ((arv == null || arv2 == null || arv.swanCoreVersion == 0 || arv.swanCoreVersion >= arv2.swanCoreVersion || !com.baidu.swan.apps.u.c.a.iW(afg().ayi())) ? false : true) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime版本过低释放并重新加载");
                }
                a.release();
            }
        }
    }
}
