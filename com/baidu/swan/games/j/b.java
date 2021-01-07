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
            h.aPi();
            if (z2) {
                d.e(ajv());
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        azc();
        com.baidu.swan.games.v.b.bbT().clear();
        com.baidu.swan.games.network.b.d.bbk().release();
        aMd().hl(true);
        bat();
        V8Engine.setCrashKeyValue("game_title", ajv() == null ? "" : ajv().awy());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void ays() {
        f.aDH().cV(this.cOo);
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
        d.b(RGState.METHOD_NAME_EXIT, ajv());
        f.aDH().cW(this.cOo);
        f.release();
        com.baidu.swan.games.aa.a.bci().release();
        SwanInspectorEndpoint.baS().close();
        com.baidu.swan.games.v.b.bbT().clear();
        com.baidu.swan.games.network.b.d.bbk().release();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int ajl() {
        return 1;
    }

    private void bat() {
        rh();
        if (com.baidu.swan.apps.runtime.d.aMh().aJx()) {
            f.aDH().a(ajv(), new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.games.j.b.1
                @Override // com.baidu.swan.apps.r.b
                public void a(int i, com.baidu.swan.apps.r.a aVar) {
                    a.b bVar = (a.b) aVar;
                    if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
                        a.bai().e(b.this.ajv());
                        a.bai().a(bVar);
                        com.baidu.swan.games.audio.b.b.aXL();
                        b.this.bau();
                        b.this.bav();
                    }
                }
            });
            if (a.bai().ban() && a.bai().bap()) {
                a.bai().m(this.cOo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bau() {
        com.baidu.swan.games.utils.c.bcm().bcx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bav() {
        com.baidu.swan.games.utils.c.bcm().bcw();
    }

    public com.baidu.swan.games.f.a getV8Engine() {
        return a.bai().baj();
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b ayP() {
        return new a.b() { // from class: com.baidu.swan.games.j.b.2
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean l(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.aIY().a(new com.baidu.swan.apps.process.messaging.c(4));
                        b.this.ayM();
                        a.bai().bam();
                        com.baidu.swan.apps.runtime.d.aMh().aMe();
                        return true;
                    case 102:
                        boolean alE = com.baidu.swan.apps.t.a.aAO().alE();
                        com.baidu.swan.apps.t.a.aAO().eM(alE);
                        if (b.this.cOo != null) {
                            b.this.cOo.k(alE, false);
                            return true;
                        }
                        return true;
                    case 103:
                        e aMl = e.aMl();
                        if (aMl != null) {
                            aMl.aMx().clear();
                            com.baidu.swan.apps.network.c.a.aGG().aGL();
                        }
                        b.this.ayM();
                        a.bai().bam();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.aMh().aMe();
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
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count:" + this.deW.asX());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.c asU = this.deW.asU();
        if (asU == null || !asU.amm()) {
            if (ayT()) {
                e aMl = e.aMl();
                if (aMl != null) {
                    aMl.aMC().release();
                }
                d.b("back", ajv());
                return;
            }
            this.deW.nv("navigateBack").ai(com.baidu.swan.apps.core.d.f.cVa, com.baidu.swan.apps.core.d.f.cUZ).atb().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean isLandScape() {
        return com.baidu.swan.apps.runtime.d.aMh().aMd().ajv().getOrientation() == 1;
    }

    private void rh() {
        this.ejE = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void ayU() {
        super.ayU();
        a.bai().Y(this.cOo);
    }

    public boolean baw() {
        return this.ejE > 0;
    }

    public long bax() {
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
                d.e(b.this.ajv());
                b.this.cOo.ajy();
                com.baidu.swan.apps.performance.i.cp("preload", "startup");
                int atM = a.bai().atM();
                HybridUbcFlow rd = com.baidu.swan.apps.performance.i.rd("startup");
                rd.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).cn("codecache", String.valueOf(atM)).f(new UbcFlowEvent("na_first_paint")).aHg();
                long B = rd.B("na_first_paint", "naStart");
                a.bai().a(new com.baidu.swan.games.p.b(B));
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + B);
                }
                com.baidu.swan.games.utils.c.bcm().bcs();
                com.baidu.swan.games.m.a.bba().init();
            }
        });
        com.baidu.swan.games.utils.d.bcE();
    }

    private void azc() {
        if (aMd().available()) {
            SwanCoreVersion avW = a.bai().avW();
            long uo = com.baidu.swan.apps.swancore.b.uo(ajv().aCA());
            if (uo != 0 && avW != null && avW.swanCoreVersion != 0 && avW.swanCoreVersion < uo) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "release SwanGameCoreRuntime minSwanVersion:" + uo + ", runtimeSwanCoreVersion:" + avW.swanCoreVersion);
                }
                a.release();
                return;
            }
            SwanCoreVersion avW2 = ajv().avW();
            if ((avW == null || avW2 == null || avW.swanCoreVersion == 0 || avW.swanCoreVersion >= avW2.swanCoreVersion || !com.baidu.swan.apps.u.c.a.jp(ajv().aCJ())) ? false : true) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime版本过低释放并重新加载");
                }
                a.release();
            }
        }
    }
}
