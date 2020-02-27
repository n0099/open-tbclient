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
    protected final SwanAppActivity biJ;
    private FrameLayout bvA;
    private Flow bvB;
    private d bvC;
    public final String bvD;
    private FrameLifeState bvE;
    private FrameLifeState bvF;
    private boolean bvG;
    private boolean bvH;
    protected com.baidu.swan.apps.core.d.e bvw;
    protected a.b bvx;
    private final com.baidu.swan.apps.ao.f.b bvy;
    private com.baidu.swan.apps.af.c bvz;

    @NonNull
    protected abstract a.b SO();

    protected abstract void Sr();

    protected abstract void l(boolean z, boolean z2);

    protected abstract void onCreate();

    protected abstract void onDestroy();

    protected abstract void onPause();

    protected abstract void onRelease();

    protected abstract void onResume();

    protected abstract void onStart();

    protected abstract void onStop();

    public c(SwanAppActivity swanAppActivity, String str) {
        super(com.baidu.swan.apps.runtime.d.acA());
        this.bvx = null;
        this.bvy = new com.baidu.swan.apps.ao.f.b();
        this.bvE = FrameLifeState.INACTIVATED;
        this.bvF = null;
        this.bvG = false;
        this.bvH = false;
        this.biJ = swanAppActivity;
        this.bvD = str;
        this.bvC = new d();
    }

    public final synchronized void a(FrameLifeState frameLifeState, boolean z) {
        boolean z2 = false;
        synchronized (this) {
            if (!this.biJ.isDestroyed()) {
                boolean z3 = (!this.bvE.hasCreated()) | z;
                if (this.bvE.hasCreated() && z3) {
                    z2 = true;
                }
                m(z3, z2);
                d(frameLifeState);
                if (z3 && (z2 || 1 == Gs())) {
                    f.h(GC());
                }
            }
        }
    }

    public final synchronized void release() {
        d(FrameLifeState.INACTIVATED);
        SA();
    }

    public boolean Ss() {
        return this.bvH;
    }

    private synchronized FrameLifeState c(@NonNull FrameLifeState frameLifeState) {
        return (frameLifeState.inactivated() || acx().acY() || !frameLifeState.hasStarted() || frameLifeState.moreInactiveThan(this.bvE)) ? frameLifeState : this.bvE.hasCreated() ? this.bvE : FrameLifeState.JUST_CREATED;
    }

    public final synchronized void d(@NonNull FrameLifeState frameLifeState) {
        synchronized (this) {
            log(" transLifeState: target=" + frameLifeState + " holdon=" + this.bvG + " locked=" + this.bvH + " thread=" + Thread.currentThread());
            if (!this.bvH) {
                this.bvF = frameLifeState;
                this.bvH = FrameLifeState.INACTIVATED == this.bvF;
            }
            if (!this.bvG) {
                this.bvG = true;
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.framework.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.St();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void St() {
        synchronized (this) {
            this.bvG = true;
            while (this.bvF != null && SU()) {
                FrameLifeState c = c(this.bvF);
                log("syncLifeState: pendingTarget=" + this.bvF + " fixedTarget=" + c);
                this.bvF = null;
                switch (c) {
                    case JUST_CREATED:
                        Sy();
                        Su();
                        break;
                    case JUST_STARTED:
                        Sx();
                        Sv();
                        break;
                    case JUST_RESUMED:
                        Sw();
                        break;
                    default:
                        Sz();
                        break;
                }
            }
            log("syncLifeState: done=" + this.bvE);
            this.bvH = FrameLifeState.INACTIVATED == this.bvF;
            this.bvG = false;
        }
    }

    private synchronized void Su() {
        if (!this.bvE.hasCreated()) {
            SB();
            com.baidu.swan.apps.console.c.d("SwanApp", "onPostCreate: " + this);
            Sr();
            this.bvE = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void Sv() {
        Su();
        if (!this.bvE.hasStarted()) {
            SC();
            this.bvE = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void Sw() {
        Sv();
        if (!this.bvE.hasResumed()) {
            SD();
            this.bvE = FrameLifeState.JUST_RESUMED;
        }
    }

    private synchronized void Sx() {
        if (this.bvE.hasResumed()) {
            SE();
            this.bvE = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void Sy() {
        Sx();
        if (this.bvE.hasStarted()) {
            SF();
            this.bvE = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void Sz() {
        Sy();
        if (this.bvE.hasCreated()) {
            SG();
            this.bvE = FrameLifeState.INACTIVATED;
        }
    }

    private synchronized void m(boolean z, boolean z2) {
        HybridUbcFlow jP = f.jP("startup");
        jP.f(new UbcFlowEvent("onUpdateInternalStart").dg(true));
        log("onUpdateInternal isLaunch=" + z + " isRelaunch=" + z2);
        if (z) {
            b.a GC = GC();
            if (!z2) {
                ST();
            }
            if (!TextUtils.isEmpty(GC.VW())) {
                com.baidu.swan.apps.console.debugger.a.e.setWebUrl(GC.VW());
            }
        }
        com.baidu.swan.apps.y.f WQ = com.baidu.swan.apps.y.f.WQ();
        if (!SU()) {
            WQ.i(this.biJ);
        }
        jP.f(new UbcFlowEvent("onUpdateStart").dg(true));
        l(z, z2);
        jP.f(new UbcFlowEvent("onUpdateEnd").dg(true));
    }

    private synchronized void SA() {
        log("onReleaseInternal");
        onRelease();
        com.baidu.swan.apps.y.f.release();
    }

    @DebugTrace
    private synchronized void SB() {
        log("onCreateInternal");
        HybridUbcFlow jP = f.jP("startup");
        jP.f(new UbcFlowEvent("frame_start_create"));
        jP.f(new UbcFlowEvent("onCreateInternalStart").dg(true));
        this.bvC.So();
        com.baidu.swan.apps.console.c.d("SwanApp", "onCreate: " + this);
        if (com.baidu.swan.apps.console.debugger.a.e.LN()) {
            com.baidu.swan.apps.core.k.d.release();
        }
        SQ();
        com.baidu.swan.apps.runtime.d acA = com.baidu.swan.apps.runtime.d.acA();
        if (!acA.abh() || !acA.acx().available()) {
            com.baidu.swan.apps.ap.a mz = new com.baidu.swan.apps.ap.a().aI(5L).aJ(11L).mz("aiapp data is invalid");
            com.baidu.swan.apps.ap.e.agm().f(mz);
            com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().lN(com.baidu.swan.apps.statistic.f.gs(Gs())).e(mz).a(GC()));
            com.baidu.swan.apps.as.c.T(this.biJ);
        } else {
            com.baidu.swan.apps.runtime.e acx = acA.acx();
            acx.acN().adY();
            acx.acO().clear();
            SI();
            jP.f(new UbcFlowEvent("onCreateStart").dg(true));
            onCreate();
            jP.f(new UbcFlowEvent("onCreateEnd").dg(true));
            com.baidu.swan.apps.as.b Gr = this.biJ.Gr();
            if (Gr != null) {
                Gr.ags();
            }
            jP.f(new UbcFlowEvent("onCreateInternalEnd").dg(true));
        }
    }

    private synchronized void SC() {
        HybridUbcFlow jP = f.jP("startup");
        jP.f(new UbcFlowEvent("onStartStart").dg(true));
        log("onStartInternal");
        this.bvC.Sp();
        onStart();
        jP.f(new UbcFlowEvent("onStartEnd").dg(true));
    }

    private synchronized void SD() {
        HybridUbcFlow jP = f.jP("startup");
        jP.f(new UbcFlowEvent("onResumeInternalStart").dg(true));
        log("onResumeInternal");
        this.bvC.onActivityResumed();
        com.baidu.swan.apps.console.c.d("SwanApp", "onResume: " + this);
        this.bvB = com.baidu.swan.apps.statistic.f.lH("607");
        SP();
        if (abh()) {
            acx().onActivityResume(this.biJ);
        }
        m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.framework.c.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.network.c.a.YZ().Zb();
                if (c.DEBUG) {
                    Log.e("SwanActivityFrame", "try update on computation thread");
                }
                if (c.this.biJ != null && com.baidu.swan.apps.runtime.e.acD() != null) {
                    com.baidu.swan.apps.database.a.b.b(com.baidu.swan.apps.runtime.e.acD());
                }
            }
        }, "saveSwanAppHistory");
        f.jP("startup").f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
        com.baidu.swan.apps.an.a.aeF().lC("na_page_show");
        com.baidu.swan.apps.y.f.WQ().Iw();
        jP.f(new UbcFlowEvent("onResumeStart").dg(true));
        onResume();
        jP.f(new UbcFlowEvent("onResumeEnd").dg(true));
    }

    private synchronized void SE() {
        log("onPauseInternal");
        onPause();
        com.baidu.swan.apps.y.f.WQ().Ix();
        this.bvC.onActivityPaused();
        com.baidu.swan.apps.console.c.d("SwanApp", "onPause: " + this);
        if (this.bvB != null && abh()) {
            com.baidu.swan.apps.statistic.a.a aVar = new com.baidu.swan.apps.statistic.a.a();
            b.a GC = GC();
            aVar.mFrom = com.baidu.swan.apps.statistic.f.gs(Gs());
            aVar.mAppId = GC.getAppId();
            aVar.mSource = GC.VH();
            aVar.c(GC);
            aVar.lR(GC.VN().getString("ubc"));
            aVar.ba(com.baidu.swan.apps.statistic.f.lI(GC.VJ()));
            com.baidu.swan.apps.statistic.f.a(this.bvB, aVar);
            this.bvB = null;
        }
    }

    private synchronized void SF() {
        log("onStopInternal");
        onStop();
        this.bvC.Sq();
    }

    private synchronized void SG() {
        log("onDestroyInternal");
        onDestroy();
        this.bvC.JI();
        com.baidu.swan.apps.console.c.d("SwanApp", "onDestroy: " + this);
        com.baidu.swan.apps.network.c.a.YZ().release();
        com.baidu.swan.apps.performance.b.d.releaseInstance();
        SJ();
        com.baidu.swan.apps.y.f.release();
    }

    public synchronized FrameLifeState SH() {
        return this.bvE;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.bvC.onKeyDown(i, keyEvent);
    }

    public void SI() {
        if (this.bvx == null) {
            this.bvx = SO();
        }
        acw().a((a.c) null, this.bvx);
    }

    public void SJ() {
        acw().SJ();
        this.bvx = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void SK() {
        b.a GC;
        Bundle VM;
        if (abh() && (VM = (GC = GC()).VM()) != null && VM.getLong("launch_flag_for_statistic") > 0) {
            long j = GC.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gs(Gs());
            fVar.mAppId = GC.getAppId();
            if (com.baidu.swan.apps.ah.a.a.ko(GC().VW())) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = GC.VH();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.bVs = String.valueOf(currentTimeMillis - j);
            fVar.n("status", "0");
            fVar.lR(GC.VN().getString("ubc"));
            fVar.ba(com.baidu.swan.apps.statistic.f.lI(GC.VJ()));
            com.baidu.swan.apps.statistic.f.onEvent(fVar);
            VM.remove("launch_flag_for_statistic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void SL() {
        SM();
        SN();
    }

    private void SM() {
        com.baidu.swan.apps.adaptation.a.b HR = acC().GT().HR();
        if (HR != null) {
            HR.bo(this.biJ);
        }
    }

    protected void SN() {
        com.baidu.swan.apps.runtime.e acD = com.baidu.swan.apps.runtime.e.acD();
        com.baidu.swan.apps.a.b bVar = null;
        if (acD != null) {
            bVar = acD.acO();
        }
        if (bVar != null) {
            bVar.setUid(bVar.getUid(AppRuntime.getAppContext()));
        }
    }

    private void SP() {
        if (acx().available()) {
            setTaskDescription(this.biJ, GC().QZ(), ai.a((com.baidu.swan.apps.x.b.b) GC(), "SwanActivityFrame", true), (int) GC().VG());
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

    private void SQ() {
        this.bvw = new com.baidu.swan.apps.core.d.e(this.biJ);
        SR();
    }

    protected void SR() {
    }

    public com.baidu.swan.apps.core.d.e GA() {
        return this.bvw;
    }

    public void onTrimMemory(int i) {
        com.baidu.swan.apps.console.c.w("SwanActivityFrame", "onTrimMemory level:" + i);
        GE().gV(i);
    }

    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean SS() {
        if (this.bvw.Oo() != 1) {
            return false;
        }
        this.biJ.moveTaskToBack(true);
        this.biJ.dR(2);
        return true;
    }

    public b.a GC() {
        return acx().acG();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (fVar != null && abh()) {
            b.a GC = GC();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gs(Gs());
            fVar.mAppId = GC.getAppId();
            fVar.mSource = GC.VH();
            fVar.ba(com.baidu.swan.apps.statistic.f.lI(GC.VJ()));
            if (TextUtils.isEmpty(fVar.mType)) {
                fVar.mType = "click";
            }
            fVar.lR(GC.VN().getString("ubc"));
            if (TextUtils.equals(fVar.mType, "click")) {
                com.baidu.swan.apps.statistic.b.b(fVar);
            } else {
                com.baidu.swan.apps.statistic.f.onEvent(fVar);
            }
        }
    }

    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.bvz == null) {
                this.bvz = new com.baidu.swan.apps.af.c();
            }
            this.bvz.a(this.biJ, i, strArr, aVar);
        }
    }

    public boolean onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.bvz != null) {
            this.bvz.a(this.biJ, i, strArr, iArr);
            return true;
        }
        return false;
    }

    public void showLoadingView() {
        this.bvA = (FrameLayout) this.biJ.findViewById(a.f.ai_apps_activity_root);
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(this.biJ, this.bvA);
    }

    public void GD() {
        com.baidu.swan.apps.res.widget.loadingview.a.removeLoadingView(this.bvA);
    }

    @NonNull
    public com.baidu.swan.apps.ao.f.b GE() {
        return this.bvy;
    }

    public boolean isLandScape() {
        return false;
    }

    public void a(b bVar) {
        this.bvC.c(bVar);
    }

    public void b(b bVar) {
        this.bvC.d(bVar);
    }

    public boolean hS(String str) {
        return TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ST() {
    }

    public void JJ() {
        this.bvC.JJ();
    }

    public boolean SU() {
        return com.baidu.swan.apps.y.f.WQ().WR();
    }

    private void log(String str) {
        if (DEBUG) {
            Log.i("SwanActivityFrame", str);
        }
    }
}
