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
    private long dPz;

    public b(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void p(boolean z, boolean z2) {
        if (z) {
            h.aHS();
            if (z2) {
                d.e(ado());
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        asK();
        com.baidu.swan.games.v.b.aUB().clear();
        com.baidu.swan.games.network.b.d.aTS().release();
        aEM().gs(true);
        aTb();
        V8Engine.setCrashKeyValue("game_title", ado() == null ? "" : ado().aqe());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void arZ() {
        f.axo().ch(this.cyp);
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
        d.b(RGState.METHOD_NAME_EXIT, ado());
        f.axo().ci(this.cyp);
        f.release();
        com.baidu.swan.games.aa.a.aUQ().release();
        SwanInspectorEndpoint.aTA().close();
        com.baidu.swan.games.v.b.aUB().clear();
        com.baidu.swan.games.network.b.d.aTS().release();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int ade() {
        return 1;
    }

    private void aTb() {
        rE();
        if (com.baidu.swan.apps.runtime.d.aEQ().aDd()) {
            f.axo().a(ado(), new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.games.j.b.1
                @Override // com.baidu.swan.apps.r.b
                public void a(int i, com.baidu.swan.apps.r.a aVar) {
                    a.b bVar = (a.b) aVar;
                    if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
                        a.aSQ().e(b.this.ado());
                        a.aSQ().a(bVar);
                        com.baidu.swan.games.audio.b.b.aQt();
                        b.this.aTc();
                        b.this.aTd();
                    }
                }
            });
            if (a.aSQ().aSV() && a.aSQ().aSX()) {
                a.aSQ().m(this.cyp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTc() {
        com.baidu.swan.games.utils.c.aUU().aVf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTd() {
        com.baidu.swan.games.utils.c.aUU().aVe();
    }

    public com.baidu.swan.games.f.a getV8Engine() {
        return a.aSQ().aSR();
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b asx() {
        return new a.b() { // from class: com.baidu.swan.games.j.b.2
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean l(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.aCE().a(new com.baidu.swan.apps.process.messaging.c(4));
                        b.this.asu();
                        a.aSQ().aSU();
                        com.baidu.swan.apps.runtime.d.aEQ().aEN();
                        return true;
                    case 102:
                        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.auw().getNightModeSwitcherState();
                        com.baidu.swan.apps.t.a.auw().ec(nightModeSwitcherState);
                        if (b.this.cyp != null) {
                            b.this.cyp.k(nightModeSwitcherState, false);
                            return true;
                        }
                        return true;
                    case 103:
                        e aEU = e.aEU();
                        if (aEU != null) {
                            aEU.aFg().clear();
                            com.baidu.swan.apps.network.c.a.aAk().aAp();
                        }
                        b.this.asu();
                        a.aSQ().aSU();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.aEQ().aEN();
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
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count:" + this.cOW.amE());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.c amB = this.cOW.amB();
        if (amB == null || !amB.agb()) {
            if (asB()) {
                e aEU = e.aEU();
                if (aEU != null) {
                    aEU.aFl().release();
                }
                d.b("back", ado());
                return;
            }
            this.cOW.mM("navigateBack").al(com.baidu.swan.apps.core.d.f.cFb, com.baidu.swan.apps.core.d.f.cFa).amI().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean isLandScape() {
        return com.baidu.swan.apps.runtime.d.aEQ().aEM().ado().getOrientation() == 1;
    }

    private void rE() {
        this.dPz = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void asC() {
        super.asC();
        a.aSQ().X(this.cyp);
    }

    public boolean aTe() {
        return this.dPz > 0;
    }

    public long aTf() {
        return this.dPz;
    }

    public void onFirstFrameFinished() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager onFirstFrameFinished");
                }
                b.this.dPz = System.currentTimeMillis();
                d.e(b.this.ado());
                b.this.cyp.adr();
                com.baidu.swan.apps.performance.i.ck("preload", "startup");
                int ant = a.aSQ().ant();
                HybridUbcFlow qv = com.baidu.swan.apps.performance.i.qv("startup");
                qv.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).ci("codecache", String.valueOf(ant)).f(new UbcFlowEvent("na_first_paint")).aAL();
                long u = qv.u("na_first_paint", "naStart");
                a.aSQ().a(new com.baidu.swan.games.p.b(u));
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + u);
                }
                com.baidu.swan.games.utils.c.aUU().aVa();
                com.baidu.swan.games.m.a.aTI().init();
            }
        });
        com.baidu.swan.games.utils.d.aVm();
    }

    private void asK() {
        if (aEM().available()) {
            SwanCoreVersion apD = a.aSQ().apD();
            long tB = com.baidu.swan.apps.swancore.b.tB(ado().awh());
            if (tB != 0 && apD != null && apD.swanCoreVersion != 0 && apD.swanCoreVersion < tB) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "release SwanGameCoreRuntime minSwanVersion:" + tB + ", runtimeSwanCoreVersion:" + apD.swanCoreVersion);
                }
                a.release();
                return;
            }
            SwanCoreVersion apD2 = ado().apD();
            if ((apD == null || apD2 == null || apD.swanCoreVersion == 0 || apD.swanCoreVersion >= apD2.swanCoreVersion || !com.baidu.swan.apps.u.c.a.iQ(ado().awq())) ? false : true) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime版本过低释放并重新加载");
                }
                a.release();
            }
        }
    }
}
