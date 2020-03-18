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
    protected final SwanAppActivity biY;
    protected com.baidu.swan.apps.core.d.e bvK;
    protected a.b bvL;
    private final com.baidu.swan.apps.ao.f.b bvM;
    private com.baidu.swan.apps.af.c bvN;
    private FrameLayout bvO;
    private Flow bvP;
    private d bvQ;
    public final String bvR;
    private FrameLifeState bvS;
    private FrameLifeState bvT;
    private boolean bvU;
    private boolean bvV;

    @NonNull
    protected abstract a.b ST();

    protected abstract void Sw();

    protected abstract void m(boolean z, boolean z2);

    protected abstract void onCreate();

    protected abstract void onDestroy();

    protected abstract void onPause();

    protected abstract void onRelease();

    protected abstract void onResume();

    protected abstract void onStart();

    protected abstract void onStop();

    public c(SwanAppActivity swanAppActivity, String str) {
        super(com.baidu.swan.apps.runtime.d.acF());
        this.bvL = null;
        this.bvM = new com.baidu.swan.apps.ao.f.b();
        this.bvS = FrameLifeState.INACTIVATED;
        this.bvT = null;
        this.bvU = false;
        this.bvV = false;
        this.biY = swanAppActivity;
        this.bvR = str;
        this.bvQ = new d();
    }

    public final synchronized void a(FrameLifeState frameLifeState, boolean z) {
        boolean z2 = false;
        synchronized (this) {
            if (!this.biY.isDestroyed()) {
                boolean z3 = (!this.bvS.hasCreated()) | z;
                if (this.bvS.hasCreated() && z3) {
                    z2 = true;
                }
                n(z3, z2);
                d(frameLifeState);
                if (z3 && (z2 || 1 == Gz())) {
                    f.h(GJ());
                }
            }
        }
    }

    public final synchronized void release() {
        d(FrameLifeState.INACTIVATED);
        SF();
    }

    public boolean Sx() {
        return this.bvV;
    }

    private synchronized FrameLifeState c(@NonNull FrameLifeState frameLifeState) {
        return (frameLifeState.inactivated() || acC().add() || !frameLifeState.hasStarted() || frameLifeState.moreInactiveThan(this.bvS)) ? frameLifeState : this.bvS.hasCreated() ? this.bvS : FrameLifeState.JUST_CREATED;
    }

    public final synchronized void d(@NonNull FrameLifeState frameLifeState) {
        synchronized (this) {
            log(" transLifeState: target=" + frameLifeState + " holdon=" + this.bvU + " locked=" + this.bvV + " thread=" + Thread.currentThread());
            if (!this.bvV) {
                this.bvT = frameLifeState;
                this.bvV = FrameLifeState.INACTIVATED == this.bvT;
            }
            if (!this.bvU) {
                this.bvU = true;
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.framework.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.Sy();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Sy() {
        synchronized (this) {
            this.bvU = true;
            while (this.bvT != null && SZ()) {
                FrameLifeState c = c(this.bvT);
                log("syncLifeState: pendingTarget=" + this.bvT + " fixedTarget=" + c);
                this.bvT = null;
                switch (c) {
                    case JUST_CREATED:
                        SD();
                        Sz();
                        break;
                    case JUST_STARTED:
                        SC();
                        SA();
                        break;
                    case JUST_RESUMED:
                        SB();
                        break;
                    default:
                        SE();
                        break;
                }
            }
            log("syncLifeState: done=" + this.bvS);
            this.bvV = FrameLifeState.INACTIVATED == this.bvT;
            this.bvU = false;
        }
    }

    private synchronized void Sz() {
        if (!this.bvS.hasCreated()) {
            SG();
            com.baidu.swan.apps.console.c.d("SwanApp", "onPostCreate: " + this);
            Sw();
            this.bvS = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void SA() {
        Sz();
        if (!this.bvS.hasStarted()) {
            SH();
            this.bvS = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void SB() {
        SA();
        if (!this.bvS.hasResumed()) {
            SI();
            this.bvS = FrameLifeState.JUST_RESUMED;
        }
    }

    private synchronized void SC() {
        if (this.bvS.hasResumed()) {
            SJ();
            this.bvS = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void SD() {
        SC();
        if (this.bvS.hasStarted()) {
            SK();
            this.bvS = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void SE() {
        SD();
        if (this.bvS.hasCreated()) {
            SL();
            this.bvS = FrameLifeState.INACTIVATED;
        }
    }

    private synchronized void n(boolean z, boolean z2) {
        HybridUbcFlow jO = f.jO("startup");
        jO.f(new UbcFlowEvent("onUpdateInternalStart").dh(true));
        log("onUpdateInternal isLaunch=" + z + " isRelaunch=" + z2);
        if (z) {
            b.a GJ = GJ();
            if (!z2) {
                SY();
            }
            if (!TextUtils.isEmpty(GJ.Wb())) {
                com.baidu.swan.apps.console.debugger.a.e.setWebUrl(GJ.Wb());
            }
        }
        com.baidu.swan.apps.y.f WV = com.baidu.swan.apps.y.f.WV();
        if (!SZ()) {
            WV.i(this.biY);
        }
        jO.f(new UbcFlowEvent("onUpdateStart").dh(true));
        m(z, z2);
        jO.f(new UbcFlowEvent("onUpdateEnd").dh(true));
    }

    private synchronized void SF() {
        log("onReleaseInternal");
        onRelease();
        com.baidu.swan.apps.y.f.release();
    }

    @DebugTrace
    private synchronized void SG() {
        log("onCreateInternal");
        HybridUbcFlow jO = f.jO("startup");
        jO.f(new UbcFlowEvent("frame_start_create"));
        jO.f(new UbcFlowEvent("onCreateInternalStart").dh(true));
        this.bvQ.St();
        com.baidu.swan.apps.console.c.d("SwanApp", "onCreate: " + this);
        if (com.baidu.swan.apps.console.debugger.a.e.LS()) {
            com.baidu.swan.apps.core.k.d.release();
        }
        SV();
        com.baidu.swan.apps.runtime.d acF = com.baidu.swan.apps.runtime.d.acF();
        if (!acF.abm() || !acF.acC().available()) {
            com.baidu.swan.apps.ap.a my = new com.baidu.swan.apps.ap.a().aI(5L).aJ(11L).my("aiapp data is invalid");
            com.baidu.swan.apps.ap.e.agr().f(my);
            com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().lM(com.baidu.swan.apps.statistic.f.gs(Gz())).e(my).a(GJ()));
            com.baidu.swan.apps.as.c.T(this.biY);
        } else {
            com.baidu.swan.apps.runtime.e acC = acF.acC();
            acC.acS().aed();
            acC.acT().clear();
            SN();
            jO.f(new UbcFlowEvent("onCreateStart").dh(true));
            onCreate();
            jO.f(new UbcFlowEvent("onCreateEnd").dh(true));
            com.baidu.swan.apps.as.b Gy = this.biY.Gy();
            if (Gy != null) {
                Gy.agx();
            }
            jO.f(new UbcFlowEvent("onCreateInternalEnd").dh(true));
        }
    }

    private synchronized void SH() {
        HybridUbcFlow jO = f.jO("startup");
        jO.f(new UbcFlowEvent("onStartStart").dh(true));
        log("onStartInternal");
        this.bvQ.Su();
        onStart();
        jO.f(new UbcFlowEvent("onStartEnd").dh(true));
    }

    private synchronized void SI() {
        HybridUbcFlow jO = f.jO("startup");
        jO.f(new UbcFlowEvent("onResumeInternalStart").dh(true));
        log("onResumeInternal");
        this.bvQ.onActivityResumed();
        com.baidu.swan.apps.console.c.d("SwanApp", "onResume: " + this);
        this.bvP = com.baidu.swan.apps.statistic.f.lG("607");
        SU();
        if (abm()) {
            acC().onActivityResume(this.biY);
        }
        m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.framework.c.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.network.c.a.Ze().Zg();
                if (c.DEBUG) {
                    Log.e("SwanActivityFrame", "try update on computation thread");
                }
                if (c.this.biY != null && com.baidu.swan.apps.runtime.e.acI() != null) {
                    com.baidu.swan.apps.database.a.b.b(com.baidu.swan.apps.runtime.e.acI());
                }
            }
        }, "saveSwanAppHistory");
        f.jO("startup").f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
        com.baidu.swan.apps.an.a.aeK().lB("na_page_show");
        com.baidu.swan.apps.y.f.WV().IB();
        jO.f(new UbcFlowEvent("onResumeStart").dh(true));
        onResume();
        jO.f(new UbcFlowEvent("onResumeEnd").dh(true));
    }

    private synchronized void SJ() {
        log("onPauseInternal");
        onPause();
        com.baidu.swan.apps.y.f.WV().IC();
        this.bvQ.onActivityPaused();
        com.baidu.swan.apps.console.c.d("SwanApp", "onPause: " + this);
        if (this.bvP != null && abm()) {
            com.baidu.swan.apps.statistic.a.a aVar = new com.baidu.swan.apps.statistic.a.a();
            b.a GJ = GJ();
            aVar.mFrom = com.baidu.swan.apps.statistic.f.gs(Gz());
            aVar.mAppId = GJ.getAppId();
            aVar.mSource = GJ.VM();
            aVar.c(GJ);
            aVar.lQ(GJ.VS().getString("ubc"));
            aVar.ba(com.baidu.swan.apps.statistic.f.lH(GJ.VO()));
            com.baidu.swan.apps.statistic.f.a(this.bvP, aVar);
            this.bvP = null;
        }
    }

    private synchronized void SK() {
        log("onStopInternal");
        onStop();
        this.bvQ.Sv();
    }

    private synchronized void SL() {
        log("onDestroyInternal");
        onDestroy();
        this.bvQ.JN();
        com.baidu.swan.apps.console.c.d("SwanApp", "onDestroy: " + this);
        com.baidu.swan.apps.network.c.a.Ze().release();
        com.baidu.swan.apps.performance.b.d.releaseInstance();
        SO();
        com.baidu.swan.apps.y.f.release();
    }

    public synchronized FrameLifeState SM() {
        return this.bvS;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.bvQ.onKeyDown(i, keyEvent);
    }

    public void SN() {
        if (this.bvL == null) {
            this.bvL = ST();
        }
        acB().a((a.c) null, this.bvL);
    }

    public void SO() {
        acB().SO();
        this.bvL = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void SP() {
        b.a GJ;
        Bundle VR;
        if (abm() && (VR = (GJ = GJ()).VR()) != null && VR.getLong("launch_flag_for_statistic") > 0) {
            long j = GJ.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gs(Gz());
            fVar.mAppId = GJ.getAppId();
            if (com.baidu.swan.apps.ah.a.a.kn(GJ().Wb())) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = GJ.VM();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.bVF = String.valueOf(currentTimeMillis - j);
            fVar.n("status", "0");
            fVar.lQ(GJ.VS().getString("ubc"));
            fVar.ba(com.baidu.swan.apps.statistic.f.lH(GJ.VO()));
            com.baidu.swan.apps.statistic.f.onEvent(fVar);
            VR.remove("launch_flag_for_statistic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void SQ() {
        SR();
        SS();
    }

    private void SR() {
        com.baidu.swan.apps.adaptation.a.b HW = acH().Ha().HW();
        if (HW != null) {
            HW.bn(this.biY);
        }
    }

    protected void SS() {
        com.baidu.swan.apps.runtime.e acI = com.baidu.swan.apps.runtime.e.acI();
        com.baidu.swan.apps.a.b bVar = null;
        if (acI != null) {
            bVar = acI.acT();
        }
        if (bVar != null) {
            bVar.setUid(bVar.getUid(AppRuntime.getAppContext()));
        }
    }

    private void SU() {
        if (acC().available()) {
            setTaskDescription(this.biY, GJ().Re(), ai.a((com.baidu.swan.apps.x.b.b) GJ(), "SwanActivityFrame", true), (int) GJ().VL());
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

    private void SV() {
        this.bvK = new com.baidu.swan.apps.core.d.e(this.biY);
        SW();
    }

    protected void SW() {
    }

    public com.baidu.swan.apps.core.d.e GH() {
        return this.bvK;
    }

    public void onTrimMemory(int i) {
        com.baidu.swan.apps.console.c.w("SwanActivityFrame", "onTrimMemory level:" + i);
        GL().gV(i);
    }

    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean SX() {
        if (this.bvK.Ot() != 1) {
            return false;
        }
        this.biY.moveTaskToBack(true);
        this.biY.dR(2);
        return true;
    }

    public b.a GJ() {
        return acC().acL();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (fVar != null && abm()) {
            b.a GJ = GJ();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gs(Gz());
            fVar.mAppId = GJ.getAppId();
            fVar.mSource = GJ.VM();
            fVar.ba(com.baidu.swan.apps.statistic.f.lH(GJ.VO()));
            if (TextUtils.isEmpty(fVar.mType)) {
                fVar.mType = "click";
            }
            fVar.lQ(GJ.VS().getString("ubc"));
            if (TextUtils.equals(fVar.mType, "click")) {
                com.baidu.swan.apps.statistic.b.b(fVar);
            } else {
                com.baidu.swan.apps.statistic.f.onEvent(fVar);
            }
        }
    }

    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.bvN == null) {
                this.bvN = new com.baidu.swan.apps.af.c();
            }
            this.bvN.a(this.biY, i, strArr, aVar);
        }
    }

    public boolean onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.bvN != null) {
            this.bvN.a(this.biY, i, strArr, iArr);
            return true;
        }
        return false;
    }

    public void showLoadingView() {
        this.bvO = (FrameLayout) this.biY.findViewById(a.f.ai_apps_activity_root);
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(this.biY, this.bvO);
    }

    public void GK() {
        com.baidu.swan.apps.res.widget.loadingview.a.removeLoadingView(this.bvO);
    }

    @NonNull
    public com.baidu.swan.apps.ao.f.b GL() {
        return this.bvM;
    }

    public boolean isLandScape() {
        return false;
    }

    public void a(b bVar) {
        this.bvQ.c(bVar);
    }

    public void b(b bVar) {
        this.bvQ.d(bVar);
    }

    public boolean hR(String str) {
        return TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void SY() {
    }

    public void JO() {
        this.bvQ.JO();
    }

    public boolean SZ() {
        return com.baidu.swan.apps.y.f.WV().WW();
    }

    private void log(String str) {
        if (DEBUG) {
            Log.i("SwanActivityFrame", str);
        }
    }
}
