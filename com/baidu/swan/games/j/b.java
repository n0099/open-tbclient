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
    private long eiA;

    public b(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void q(boolean z, boolean z2) {
        if (z) {
            h.aLK();
            if (z2) {
                d.e(agc());
            }
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        avJ();
        com.baidu.swan.games.v.b.aYo().clear();
        com.baidu.swan.games.network.b.d.aXF().release();
        aIF().hj(true);
        aWO();
        V8Engine.setCrashKeyValue("game_title", agc() == null ? "" : agc().atf());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void auZ() {
        f.aAo().cS(this.cNq);
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
        d.b(RGState.METHOD_NAME_EXIT, agc());
        f.aAo().cT(this.cNq);
        f.release();
        com.baidu.swan.games.aa.a.aYD().release();
        SwanInspectorEndpoint.aXn().close();
        com.baidu.swan.games.v.b.aYo().clear();
        com.baidu.swan.games.network.b.d.aXF().release();
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int getFrameType() {
        return 1;
    }

    private void aWO() {
        rf();
        if (com.baidu.swan.apps.runtime.d.aIJ().aGb()) {
            f.aAo().a(agc(), new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.games.j.b.1
                @Override // com.baidu.swan.apps.r.b
                public void a(int i, com.baidu.swan.apps.r.a aVar) {
                    a.b bVar = (a.b) aVar;
                    if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
                        a.aWD().e(b.this.agc());
                        a.aWD().a(bVar);
                        com.baidu.swan.games.audio.b.b.aUg();
                        b.this.aWP();
                        b.this.aWQ();
                    }
                }
            });
            if (a.aWD().aWI() && a.aWD().aWK()) {
                a.aWD().m(this.cNq);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWP() {
        com.baidu.swan.games.utils.c.aYH().aYS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWQ() {
        com.baidu.swan.games.utils.c.aYH().aYR();
    }

    public com.baidu.swan.games.f.a getV8Engine() {
        return a.aWD().aWE();
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b avw() {
        return new a.b() { // from class: com.baidu.swan.games.j.b.2
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean l(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.aFC().a(new com.baidu.swan.apps.process.messaging.c(4));
                        b.this.avt();
                        a.aWD().aWH();
                        com.baidu.swan.apps.runtime.d.aIJ().aIG();
                        return true;
                    case 102:
                        boolean ail = com.baidu.swan.apps.t.a.axv().ail();
                        com.baidu.swan.apps.t.a.axv().eK(ail);
                        if (b.this.cNq != null) {
                            b.this.cNq.l(ail, false);
                            return true;
                        }
                        return true;
                    case 103:
                        e aIN = e.aIN();
                        if (aIN != null) {
                            aIN.aIZ().clear();
                            com.baidu.swan.apps.network.c.a.aDl().aDq();
                        }
                        b.this.avt();
                        a.aWD().aWH();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.aIJ().aIG();
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
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count:" + this.ddU.apD());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.c apA = this.ddU.apA();
        if (apA == null || !apA.aiT()) {
            if (avA()) {
                e aIN = e.aIN();
                if (aIN != null) {
                    aIN.aJe().release();
                }
                d.b("back", agc());
                return;
            }
            this.ddU.mJ("navigateBack").af(com.baidu.swan.apps.core.d.f.cUb, com.baidu.swan.apps.core.d.f.cUa).apH().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean isLandScape() {
        return com.baidu.swan.apps.runtime.d.aIJ().aIF().agc().getOrientation() == 1;
    }

    private void rf() {
        this.eiA = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void avB() {
        super.avB();
        a.aWD().S(this.cNq);
    }

    public boolean aWR() {
        return this.eiA > 0;
    }

    public long aWS() {
        return this.eiA;
    }

    public void onFirstFrameFinished() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager onFirstFrameFinished");
                }
                b.this.eiA = System.currentTimeMillis();
                d.e(b.this.agc());
                b.this.cNq.agf();
                com.baidu.swan.apps.performance.i.ci("preload", "startup");
                int aqs = a.aWD().aqs();
                HybridUbcFlow qr = com.baidu.swan.apps.performance.i.qr("startup");
                qr.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).cg("codecache", String.valueOf(aqs)).f(new UbcFlowEvent("na_first_paint")).aDL();
                long B = qr.B("na_first_paint", "naStart");
                a.aWD().a(new com.baidu.swan.games.p.b(B));
                if (b.DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + B);
                }
                com.baidu.swan.games.utils.c.aYH().aYN();
                com.baidu.swan.games.m.a.aXv().init();
            }
        });
        com.baidu.swan.games.utils.d.aYZ();
    }

    private void avJ() {
        if (aIF().available()) {
            SwanCoreVersion asD = a.aWD().asD();
            long tD = com.baidu.swan.apps.swancore.b.tD(agc().azh());
            if (tD != 0 && asD != null && asD.swanCoreVersion != 0 && asD.swanCoreVersion < tD) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "release SwanGameCoreRuntime minSwanVersion:" + tD + ", runtimeSwanCoreVersion:" + asD.swanCoreVersion);
                }
                a.release();
                return;
            }
            SwanCoreVersion asD2 = agc().asD();
            if ((asD == null || asD2 == null || asD.swanCoreVersion == 0 || asD.swanCoreVersion >= asD2.swanCoreVersion || !com.baidu.swan.apps.u.c.a.hN(agc().azq())) ? false : true) {
                if (DEBUG) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime版本过低释放并重新加载");
                }
                a.release();
            }
        }
    }
}
