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
    private long ejE;

    public b(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void p(boolean z, boolean z2) {
        if (z) {
            h.aPh();
            if (z2) {
                d.e(aju());
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        azb();
        com.baidu.swan.games.v.b.bbS().clear();
        com.baidu.swan.games.network.b.d.bbj().release();
        aMc().hl(true);
        bas();
        V8Engine.setCrashKeyValue("game_title", aju() == null ? "" : aju().awx());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void ayr() {
        f.aDG().cV(this.cOo);
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
        d.b(RGState.METHOD_NAME_EXIT, aju());
        f.aDG().cW(this.cOo);
        f.release();
        com.baidu.swan.games.aa.a.bch().release();
        SwanInspectorEndpoint.baR().close();
        com.baidu.swan.games.v.b.bbS().clear();
        com.baidu.swan.games.network.b.d.bbj().release();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int ajk() {
        return 1;
    }

    private void bas() {
        rh();
        if (com.baidu.swan.apps.runtime.d.aMg().aJw()) {
            f.aDG().a(aju(), new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.games.j.b.1
                @Override // com.baidu.swan.apps.r.b
                public void a(int i, com.baidu.swan.apps.r.a aVar) {
                    a.b bVar = (a.b) aVar;
                    if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
                        a.bah().e(b.this.aju());
                        a.bah().a(bVar);
                        com.baidu.swan.games.audio.b.b.aXK();
                        b.this.bat();
                        b.this.bau();
                    }
                }
            });
            if (a.bah().bam() && a.bah().bao()) {
                a.bah().m(this.cOo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bat() {
        com.baidu.swan.games.utils.c.bcl().bcw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bau() {
        com.baidu.swan.games.utils.c.bcl().bcv();
    }

    public com.baidu.swan.games.f.a getV8Engine() {
        return a.bah().bai();
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b ayO() {
        return new a.b() { // from class: com.baidu.swan.games.j.b.2
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean l(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.aIX().a(new com.baidu.swan.apps.process.messaging.c(4));
                        b.this.ayL();
                        a.bah().bal();
                        com.baidu.swan.apps.runtime.d.aMg().aMd();
                        return true;
                    case 102:
                        boolean alD = com.baidu.swan.apps.t.a.aAN().alD();
                        com.baidu.swan.apps.t.a.aAN().eM(alD);
                        if (b.this.cOo != null) {
                            b.this.cOo.k(alD, false);
                            return true;
                        }
                        return true;
                    case 103:
                        e aMk = e.aMk();
                        if (aMk != null) {
                            aMk.aMw().clear();
                            com.baidu.swan.apps.network.c.a.aGF().aGK();
                        }
                        b.this.ayL();
                        a.bah().bal();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.aMg().aMd();
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
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count:" + this.deW.asW());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.c asT = this.deW.asT();
        if (asT == null || !asT.aml()) {
            if (ayS()) {
                e aMk = e.aMk();
                if (aMk != null) {
                    aMk.aMB().release();
                }
                d.b("back", aju());
                return;
            }
            this.deW.nv("navigateBack").ai(com.baidu.swan.apps.core.d.f.cVa, com.baidu.swan.apps.core.d.f.cUZ).ata().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean isLandScape() {
        return com.baidu.swan.apps.runtime.d.aMg().aMc().aju().getOrientation() == 1;
    }

    private void rh() {
        this.ejE = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void ayT() {
        super.ayT();
        a.bah().Y(this.cOo);
    }

    public boolean bav() {
        return this.ejE > 0;
    }

    public long baw() {
        return this.ejE;
    }

    public void onFirstFrameFinished() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager onFirstFrameFinished");
                }
                b.this.ejE = System.currentTimeMillis();
                d.e(b.this.aju());
                b.this.cOo.ajx();
                com.baidu.swan.apps.performance.i.cp("preload", "startup");
                int atL = a.bah().atL();
                HybridUbcFlow rd = com.baidu.swan.apps.performance.i.rd("startup");
                rd.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).cn("codecache", String.valueOf(atL)).f(new UbcFlowEvent("na_first_paint")).aHf();
                long B = rd.B("na_first_paint", "naStart");
                a.bah().a(new com.baidu.swan.games.p.b(B));
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + B);
                }
                com.baidu.swan.games.utils.c.bcl().bcr();
                com.baidu.swan.games.m.a.baZ().init();
            }
        });
        com.baidu.swan.games.utils.d.bcD();
    }

    private void azb() {
        if (aMc().available()) {
            SwanCoreVersion avV = a.bah().avV();
            long uo = com.baidu.swan.apps.swancore.b.uo(aju().aCz());
            if (uo != 0 && avV != null && avV.swanCoreVersion != 0 && avV.swanCoreVersion < uo) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "release SwanGameCoreRuntime minSwanVersion:" + uo + ", runtimeSwanCoreVersion:" + avV.swanCoreVersion);
                }
                a.release();
                return;
            }
            SwanCoreVersion avV2 = aju().avV();
            if ((avV == null || avV2 == null || avV.swanCoreVersion == 0 || avV.swanCoreVersion >= avV2.swanCoreVersion || !com.baidu.swan.apps.u.c.a.jp(aju().aCI())) ? false : true) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime版本过低释放并重新加载");
                }
                a.release();
            }
        }
    }
}
