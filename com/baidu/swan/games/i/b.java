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
    private long coj;

    public b(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void l(boolean z, boolean z2) {
        if (z) {
            SM();
            if (z2) {
                d.d(GE());
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        Tc();
        com.baidu.swan.games.u.b.apD().clear();
        com.baidu.swan.games.network.b.d.aoT().release();
        acz().dN(true);
        aoh();
        V8Engine.setCrashKeyValue("game_title", GE() == null ? "" : GE().Rb());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void St() {
        f.WS().cg(this.biK);
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
        d.b(RGState.METHOD_NAME_EXIT, GE());
        f.WS().ch(this.biK);
        f.release();
        com.baidu.swan.games.z.a.apS().release();
        SwanInspectorEndpoint.aoF().close();
        com.baidu.swan.games.u.b.apD().clear();
        com.baidu.swan.games.network.b.d.aoT().release();
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public int Gu() {
        return 1;
    }

    private void aoh() {
        kY();
        if (com.baidu.swan.apps.runtime.d.acC().abj()) {
            f.WS().a(GE(), new com.baidu.swan.apps.t.b() { // from class: com.baidu.swan.games.i.b.1
                @Override // com.baidu.swan.apps.t.b
                public void a(int i, com.baidu.swan.apps.t.a aVar) {
                    a.b bVar = (a.b) aVar;
                    if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
                        a.anY().e(b.this.GE());
                        a.anY().a(bVar);
                        com.baidu.swan.games.audio.b.b.alB();
                        b.this.aoi();
                    }
                }
            });
            if (a.anY().aoc() && a.anY().aoe()) {
                a.anY().l(this.biK);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoi() {
        com.baidu.swan.games.utils.c.apV().aqf();
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return a.anY().anZ();
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b SQ() {
        return new a.b() { // from class: com.baidu.swan.games.i.b.2
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean m(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.aaL().a(new com.baidu.swan.apps.process.messaging.c(4));
                        b.this.SN();
                        a.anY().aob();
                        com.baidu.swan.apps.runtime.d.acC().acA();
                        return true;
                    case 102:
                        boolean nightModeSwitcherState = com.baidu.swan.apps.w.a.Us().getNightModeSwitcherState();
                        com.baidu.swan.apps.w.a.Us().bU(nightModeSwitcherState);
                        if (b.this.biK != null) {
                            b.this.biK.i(nightModeSwitcherState, false);
                            return true;
                        }
                        return true;
                    case 103:
                        e acF = e.acF();
                        if (acF != null) {
                            acF.acP().clear();
                            com.baidu.swan.apps.network.c.a.Zb().Zh();
                        }
                        b.this.SN();
                        a.anY().aob();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.acC().acA();
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
        com.baidu.swan.apps.console.c.d("SwanApp", "onBackPressed back stack count:" + this.bvx.Oq());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.b On = this.bvx.On();
        if (On == null || !On.IK()) {
            if (SU()) {
                e acF = e.acF();
                if (acF != null) {
                    acF.acU().release();
                }
                d.b("back", GE());
                return;
            }
            this.bvx.hb("navigateBack").Y(com.baidu.swan.apps.core.d.e.boh, com.baidu.swan.apps.core.d.e.bog).Ov().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean isLandScape() {
        return com.baidu.swan.apps.runtime.d.acC().acz().GE().getOrientation() == 1;
    }

    private void kY() {
        this.coj = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void SV() {
        super.SV();
        a.anY().aa(this.biK);
    }

    public boolean aoj() {
        return this.coj > 0;
    }

    public long aok() {
        return this.coj;
    }

    public void onFirstFrameFinished() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.i.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager onFirstFrameFinished");
                }
                b.this.coj = System.currentTimeMillis();
                d.d(b.this.GE());
                b.this.biK.GI();
                com.baidu.swan.apps.performance.f.bd("preload", "startup");
                int Pg = a.anY().Pg();
                HybridUbcFlow jP = com.baidu.swan.apps.performance.f.jP("startup");
                jP.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).bb("codecache", String.valueOf(Pg)).f(new UbcFlowEvent("na_first_paint")).ZA();
                long s = jP.s("na_first_paint", "naStart");
                a.anY().a(new com.baidu.swan.games.o.b(s));
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + s);
                }
                com.baidu.swan.games.utils.c.apV().aqb();
            }
        });
    }

    private void Tc() {
        if (acz().available()) {
            SwanCoreVersion QQ = a.anY().QQ();
            long mp = com.baidu.swan.apps.swancore.b.mp(GE().VN());
            if (mp != 0 && QQ != null && QQ.swanCoreVersion != 0 && QQ.swanCoreVersion < mp) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "release SwanGameCoreRuntime minSwanVersion:" + mp + ", runtimeSwanCoreVersion:" + QQ.swanCoreVersion);
                }
                a.release();
                return;
            }
            SwanCoreVersion QQ2 = GE().QQ();
            if ((QQ == null || QQ2 == null || QQ.swanCoreVersion == 0 || QQ.swanCoreVersion >= QQ2.swanCoreVersion || !com.baidu.swan.apps.x.b.a.ff(GE().VW())) ? false : true) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime版本过低释放并重新加载");
                }
                a.release();
            }
        }
    }
}
