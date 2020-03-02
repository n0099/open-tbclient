package com.baidu.swan.apps.framework;

import android.app.Activity;
import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.af.c;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.f;
import com.baidu.swan.apps.process.messaging.client.a;
import com.baidu.swan.apps.runtime.l;
import com.baidu.swan.apps.x.b.b;
import com.baidu.swan.ubc.Flow;
/* loaded from: classes11.dex */
public abstract class c extends l {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected final SwanAppActivity biK;
    private com.baidu.swan.apps.af.c bvA;
    private FrameLayout bvB;
    private Flow bvC;
    private d bvD;
    public final String bvE;
    private FrameLifeState bvF;
    private FrameLifeState bvG;
    private boolean bvH;
    private boolean bvI;
    protected com.baidu.swan.apps.core.d.e bvx;
    protected a.b bvy;
    private final com.baidu.swan.apps.ao.f.b bvz;

    @NonNull
    protected abstract a.b SQ();

    protected abstract void St();

    protected abstract void l(boolean z, boolean z2);

    protected abstract void onCreate();

    protected abstract void onDestroy();

    protected abstract void onPause();

    protected abstract void onRelease();

    protected abstract void onResume();

    protected abstract void onStart();

    protected abstract void onStop();

    public c(SwanAppActivity swanAppActivity, String str) {
        super(com.baidu.swan.apps.runtime.d.acC());
        this.bvy = null;
        this.bvz = new com.baidu.swan.apps.ao.f.b();
        this.bvF = FrameLifeState.INACTIVATED;
        this.bvG = null;
        this.bvH = false;
        this.bvI = false;
        this.biK = swanAppActivity;
        this.bvE = str;
        this.bvD = new d();
    }

    public final synchronized void a(FrameLifeState frameLifeState, boolean z) {
        boolean z2 = false;
        synchronized (this) {
            if (!this.biK.isDestroyed()) {
                boolean z3 = (!this.bvF.hasCreated()) | z;
                if (this.bvF.hasCreated() && z3) {
                    z2 = true;
                }
                m(z3, z2);
                d(frameLifeState);
                if (z3 && (z2 || 1 == Gu())) {
                    f.h(GE());
                }
            }
        }
    }

    public final synchronized void release() {
        d(FrameLifeState.INACTIVATED);
        SC();
    }

    public boolean Su() {
        return this.bvI;
    }

    private synchronized FrameLifeState c(@NonNull FrameLifeState frameLifeState) {
        return (frameLifeState.inactivated() || acz().ada() || !frameLifeState.hasStarted() || frameLifeState.moreInactiveThan(this.bvF)) ? frameLifeState : this.bvF.hasCreated() ? this.bvF : FrameLifeState.JUST_CREATED;
    }

    public final synchronized void d(@NonNull FrameLifeState frameLifeState) {
        synchronized (this) {
            log(" transLifeState: target=" + frameLifeState + " holdon=" + this.bvH + " locked=" + this.bvI + " thread=" + Thread.currentThread());
            if (!this.bvI) {
                this.bvG = frameLifeState;
                this.bvI = FrameLifeState.INACTIVATED == this.bvG;
            }
            if (!this.bvH) {
                this.bvH = true;
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.framework.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.Sv();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Sv() {
        synchronized (this) {
            this.bvH = true;
            while (this.bvG != null && SW()) {
                FrameLifeState c = c(this.bvG);
                log("syncLifeState: pendingTarget=" + this.bvG + " fixedTarget=" + c);
                this.bvG = null;
                switch (c) {
                    case JUST_CREATED:
                        SA();
                        Sw();
                        break;
                    case JUST_STARTED:
                        Sz();
                        Sx();
                        break;
                    case JUST_RESUMED:
                        Sy();
                        break;
                    default:
                        SB();
                        break;
                }
            }
            log("syncLifeState: done=" + this.bvF);
            this.bvI = FrameLifeState.INACTIVATED == this.bvG;
            this.bvH = false;
        }
    }

    private synchronized void Sw() {
        if (!this.bvF.hasCreated()) {
            SD();
            com.baidu.swan.apps.console.c.d("SwanApp", "onPostCreate: " + this);
            St();
            this.bvF = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void Sx() {
        Sw();
        if (!this.bvF.hasStarted()) {
            SE();
            this.bvF = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void Sy() {
        Sx();
        if (!this.bvF.hasResumed()) {
            SF();
            this.bvF = FrameLifeState.JUST_RESUMED;
        }
    }

    private synchronized void Sz() {
        if (this.bvF.hasResumed()) {
            SG();
            this.bvF = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void SA() {
        Sz();
        if (this.bvF.hasStarted()) {
            SH();
            this.bvF = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void SB() {
        SA();
        if (this.bvF.hasCreated()) {
            SI();
            this.bvF = FrameLifeState.INACTIVATED;
        }
    }

    private synchronized void m(boolean z, boolean z2) {
        HybridUbcFlow jP = f.jP("startup");
        jP.f(new UbcFlowEvent("onUpdateInternalStart").dg(true));
        log("onUpdateInternal isLaunch=" + z + " isRelaunch=" + z2);
        if (z) {
            b.a GE = GE();
            if (!z2) {
                SV();
            }
            if (!TextUtils.isEmpty(GE.VY())) {
                com.baidu.swan.apps.console.debugger.a.e.setWebUrl(GE.VY());
            }
        }
        com.baidu.swan.apps.y.f WS = com.baidu.swan.apps.y.f.WS();
        if (!SW()) {
            WS.i(this.biK);
        }
        jP.f(new UbcFlowEvent("onUpdateStart").dg(true));
        l(z, z2);
        jP.f(new UbcFlowEvent("onUpdateEnd").dg(true));
    }

    private synchronized void SC() {
        log("onReleaseInternal");
        onRelease();
        com.baidu.swan.apps.y.f.release();
    }

    @DebugTrace
    private synchronized void SD() {
        log("onCreateInternal");
        HybridUbcFlow jP = f.jP("startup");
        jP.f(new UbcFlowEvent("frame_start_create"));
        jP.f(new UbcFlowEvent("onCreateInternalStart").dg(true));
        this.bvD.Sq();
        com.baidu.swan.apps.console.c.d("SwanApp", "onCreate: " + this);
        if (com.baidu.swan.apps.console.debugger.a.e.LP()) {
            com.baidu.swan.apps.core.k.d.release();
        }
        SS();
        com.baidu.swan.apps.runtime.d acC = com.baidu.swan.apps.runtime.d.acC();
        if (!acC.abj() || !acC.acz().available()) {
            com.baidu.swan.apps.ap.a mz = new com.baidu.swan.apps.ap.a().aI(5L).aJ(11L).mz("aiapp data is invalid");
            com.baidu.swan.apps.ap.e.ago().f(mz);
            com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().lN(com.baidu.swan.apps.statistic.f.gs(Gu())).e(mz).a(GE()));
            com.baidu.swan.apps.as.c.T(this.biK);
        } else {
            com.baidu.swan.apps.runtime.e acz = acC.acz();
            acz.acP().aea();
            acz.acQ().clear();
            SK();
            jP.f(new UbcFlowEvent("onCreateStart").dg(true));
            onCreate();
            jP.f(new UbcFlowEvent("onCreateEnd").dg(true));
            com.baidu.swan.apps.as.b Gt = this.biK.Gt();
            if (Gt != null) {
                Gt.agu();
            }
            jP.f(new UbcFlowEvent("onCreateInternalEnd").dg(true));
        }
    }

    private synchronized void SE() {
        HybridUbcFlow jP = f.jP("startup");
        jP.f(new UbcFlowEvent("onStartStart").dg(true));
        log("onStartInternal");
        this.bvD.Sr();
        onStart();
        jP.f(new UbcFlowEvent("onStartEnd").dg(true));
    }

    private synchronized void SF() {
        HybridUbcFlow jP = f.jP("startup");
        jP.f(new UbcFlowEvent("onResumeInternalStart").dg(true));
        log("onResumeInternal");
        this.bvD.onActivityResumed();
        com.baidu.swan.apps.console.c.d("SwanApp", "onResume: " + this);
        this.bvC = com.baidu.swan.apps.statistic.f.lH("607");
        SR();
        if (abj()) {
            acz().onActivityResume(this.biK);
        }
        m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.framework.c.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.network.c.a.Zb().Zd();
                if (c.DEBUG) {
                    Log.e("SwanActivityFrame", "try update on computation thread");
                }
                if (c.this.biK != null && com.baidu.swan.apps.runtime.e.acF() != null) {
                    com.baidu.swan.apps.database.a.b.b(com.baidu.swan.apps.runtime.e.acF());
                }
            }
        }, "saveSwanAppHistory");
        f.jP("startup").f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
        com.baidu.swan.apps.an.a.aeH().lC("na_page_show");
        com.baidu.swan.apps.y.f.WS().Iy();
        jP.f(new UbcFlowEvent("onResumeStart").dg(true));
        onResume();
        jP.f(new UbcFlowEvent("onResumeEnd").dg(true));
    }

    private synchronized void SG() {
        log("onPauseInternal");
        onPause();
        com.baidu.swan.apps.y.f.WS().Iz();
        this.bvD.onActivityPaused();
        com.baidu.swan.apps.console.c.d("SwanApp", "onPause: " + this);
        if (this.bvC != null && abj()) {
            com.baidu.swan.apps.statistic.a.a aVar = new com.baidu.swan.apps.statistic.a.a();
            b.a GE = GE();
            aVar.mFrom = com.baidu.swan.apps.statistic.f.gs(Gu());
            aVar.mAppId = GE.getAppId();
            aVar.mSource = GE.VJ();
            aVar.c(GE);
            aVar.lR(GE.VP().getString("ubc"));
            aVar.ba(com.baidu.swan.apps.statistic.f.lI(GE.VL()));
            com.baidu.swan.apps.statistic.f.a(this.bvC, aVar);
            this.bvC = null;
        }
    }

    private synchronized void SH() {
        log("onStopInternal");
        onStop();
        this.bvD.Ss();
    }

    private synchronized void SI() {
        log("onDestroyInternal");
        onDestroy();
        this.bvD.JK();
        com.baidu.swan.apps.console.c.d("SwanApp", "onDestroy: " + this);
        com.baidu.swan.apps.network.c.a.Zb().release();
        com.baidu.swan.apps.performance.b.d.releaseInstance();
        SL();
        com.baidu.swan.apps.y.f.release();
    }

    public synchronized FrameLifeState SJ() {
        return this.bvF;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.bvD.onKeyDown(i, keyEvent);
    }

    public void SK() {
        if (this.bvy == null) {
            this.bvy = SQ();
        }
        acy().a((a.c) null, this.bvy);
    }

    public void SL() {
        acy().SL();
        this.bvy = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void SM() {
        b.a GE;
        Bundle VO;
        if (abj() && (VO = (GE = GE()).VO()) != null && VO.getLong("launch_flag_for_statistic") > 0) {
            long j = GE.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gs(Gu());
            fVar.mAppId = GE.getAppId();
            if (com.baidu.swan.apps.ah.a.a.ko(GE().VY())) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = GE.VJ();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.bVt = String.valueOf(currentTimeMillis - j);
            fVar.n("status", "0");
            fVar.lR(GE.VP().getString("ubc"));
            fVar.ba(com.baidu.swan.apps.statistic.f.lI(GE.VL()));
            com.baidu.swan.apps.statistic.f.onEvent(fVar);
            VO.remove("launch_flag_for_statistic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void SN() {
        SO();
        SP();
    }

    private void SO() {
        com.baidu.swan.apps.adaptation.a.b HT = acE().GV().HT();
        if (HT != null) {
            HT.bo(this.biK);
        }
    }

    protected void SP() {
        com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
        com.baidu.swan.apps.a.b bVar = null;
        if (acF != null) {
            bVar = acF.acQ();
        }
        if (bVar != null) {
            bVar.setUid(bVar.getUid(AppRuntime.getAppContext()));
        }
    }

    private void SR() {
        if (acz().available()) {
            setTaskDescription(this.biK, GE().Rb(), ai.a((com.baidu.swan.apps.x.b.b) GE(), "SwanActivityFrame", true), (int) GE().VI());
        }
    }

    private static void setTaskDescription(Activity activity, String str, Bitmap bitmap, int i) {
        if (i != 0 && Color.alpha(i) != 255) {
            i = Color.argb(255, Color.red(i), Color.green(i), Color.blue(i));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setTaskDescription(new ActivityManager.TaskDescription(str, bitmap, i));
        }
    }

    private void SS() {
        this.bvx = new com.baidu.swan.apps.core.d.e(this.biK);
        ST();
    }

    protected void ST() {
    }

    public com.baidu.swan.apps.core.d.e GC() {
        return this.bvx;
    }

    public void onTrimMemory(int i) {
        com.baidu.swan.apps.console.c.w("SwanActivityFrame", "onTrimMemory level:" + i);
        GG().gV(i);
    }

    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean SU() {
        if (this.bvx.Oq() != 1) {
            return false;
        }
        this.biK.moveTaskToBack(true);
        this.biK.dR(2);
        return true;
    }

    public b.a GE() {
        return acz().acI();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (fVar != null && abj()) {
            b.a GE = GE();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gs(Gu());
            fVar.mAppId = GE.getAppId();
            fVar.mSource = GE.VJ();
            fVar.ba(com.baidu.swan.apps.statistic.f.lI(GE.VL()));
            if (TextUtils.isEmpty(fVar.mType)) {
                fVar.mType = "click";
            }
            fVar.lR(GE.VP().getString("ubc"));
            if (TextUtils.equals(fVar.mType, "click")) {
                com.baidu.swan.apps.statistic.b.b(fVar);
            } else {
                com.baidu.swan.apps.statistic.f.onEvent(fVar);
            }
        }
    }

    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.bvA == null) {
                this.bvA = new com.baidu.swan.apps.af.c();
            }
            this.bvA.a(this.biK, i, strArr, aVar);
        }
    }

    public boolean onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.bvA != null) {
            this.bvA.a(this.biK, i, strArr, iArr);
            return true;
        }
        return false;
    }

    public void showLoadingView() {
        this.bvB = (FrameLayout) this.biK.findViewById(a.f.ai_apps_activity_root);
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(this.biK, this.bvB);
    }

    public void GF() {
        com.baidu.swan.apps.res.widget.loadingview.a.removeLoadingView(this.bvB);
    }

    @NonNull
    public com.baidu.swan.apps.ao.f.b GG() {
        return this.bvz;
    }

    public boolean isLandScape() {
        return false;
    }

    public void a(b bVar) {
        this.bvD.c(bVar);
    }

    public void b(b bVar) {
        this.bvD.d(bVar);
    }

    public boolean hS(String str) {
        return TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void SV() {
    }

    public void JL() {
        this.bvD.JL();
    }

    public boolean SW() {
        return com.baidu.swan.apps.y.f.WS().WT();
    }

    private void log(String str) {
        if (DEBUG) {
            Log.i("SwanActivityFrame", str);
        }
    }
}
