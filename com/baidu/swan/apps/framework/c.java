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
/* loaded from: classes9.dex */
public abstract class c extends l {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected final SwanAppActivity bdF;
    private final com.baidu.swan.apps.ao.g.b bqA;
    private com.baidu.swan.apps.af.c bqB;
    private FrameLayout bqC;
    private Flow bqD;
    private d bqE;
    public final String bqF;
    private FrameLifeState bqG;
    private FrameLifeState bqH;
    private boolean bqI;
    private boolean bqJ;
    protected com.baidu.swan.apps.core.d.e bqy;
    protected a.b bqz;

    protected abstract void PH();

    @NonNull
    protected abstract a.b Qe();

    protected abstract void k(boolean z, boolean z2);

    protected abstract void onCreate();

    protected abstract void onDestroy();

    protected abstract void onPause();

    protected abstract void onRelease();

    protected abstract void onResume();

    protected abstract void onStart();

    protected abstract void onStop();

    public c(SwanAppActivity swanAppActivity, String str) {
        super(com.baidu.swan.apps.runtime.d.ZP());
        this.bqz = null;
        this.bqA = new com.baidu.swan.apps.ao.g.b();
        this.bqG = FrameLifeState.INACTIVATED;
        this.bqH = null;
        this.bqI = false;
        this.bqJ = false;
        this.bdF = swanAppActivity;
        this.bqF = str;
        this.bqE = new d();
    }

    public final synchronized void a(FrameLifeState frameLifeState, boolean z) {
        boolean z2 = false;
        synchronized (this) {
            if (!this.bdF.isDestroyed()) {
                boolean z3 = (!this.bqG.hasCreated()) | z;
                if (this.bqG.hasCreated() && z3) {
                    z2 = true;
                }
                l(z3, z2);
                d(frameLifeState);
                if (z3 && (z2 || 1 == DH())) {
                    f.h(DR());
                }
            }
        }
    }

    public final synchronized void release() {
        d(FrameLifeState.INACTIVATED);
        PQ();
    }

    public boolean PI() {
        return this.bqJ;
    }

    private synchronized FrameLifeState c(@NonNull FrameLifeState frameLifeState) {
        return (frameLifeState.inactivated() || ZM().aan() || !frameLifeState.hasStarted() || frameLifeState.moreInactiveThan(this.bqG)) ? frameLifeState : this.bqG.hasCreated() ? this.bqG : FrameLifeState.JUST_CREATED;
    }

    public final synchronized void d(@NonNull FrameLifeState frameLifeState) {
        synchronized (this) {
            log(" transLifeState: target=" + frameLifeState + " holdon=" + this.bqI + " locked=" + this.bqJ + " thread=" + Thread.currentThread());
            if (!this.bqJ) {
                this.bqH = frameLifeState;
                this.bqJ = FrameLifeState.INACTIVATED == this.bqH;
            }
            if (!this.bqI) {
                this.bqI = true;
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.framework.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.PJ();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void PJ() {
        synchronized (this) {
            this.bqI = true;
            while (this.bqH != null && Qk()) {
                FrameLifeState c = c(this.bqH);
                log("syncLifeState: pendingTarget=" + this.bqH + " fixedTarget=" + c);
                this.bqH = null;
                switch (c) {
                    case JUST_CREATED:
                        PO();
                        PK();
                        break;
                    case JUST_STARTED:
                        PN();
                        PL();
                        break;
                    case JUST_RESUMED:
                        PM();
                        break;
                    default:
                        PP();
                        break;
                }
            }
            log("syncLifeState: done=" + this.bqG);
            this.bqJ = FrameLifeState.INACTIVATED == this.bqH;
            this.bqI = false;
        }
    }

    private synchronized void PK() {
        if (!this.bqG.hasCreated()) {
            PR();
            com.baidu.swan.apps.console.c.d("SwanApp", "onPostCreate: " + this);
            PH();
            this.bqG = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void PL() {
        PK();
        if (!this.bqG.hasStarted()) {
            PS();
            this.bqG = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void PM() {
        PL();
        if (!this.bqG.hasResumed()) {
            PT();
            this.bqG = FrameLifeState.JUST_RESUMED;
        }
    }

    private synchronized void PN() {
        if (this.bqG.hasResumed()) {
            PU();
            this.bqG = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void PO() {
        PN();
        if (this.bqG.hasStarted()) {
            PV();
            this.bqG = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void PP() {
        PO();
        if (this.bqG.hasCreated()) {
            PW();
            this.bqG = FrameLifeState.INACTIVATED;
        }
    }

    private synchronized void l(boolean z, boolean z2) {
        HybridUbcFlow jx = f.jx("startup");
        jx.f(new UbcFlowEvent("onUpdateInternalStart").cU(true));
        log("onUpdateInternal isLaunch=" + z + " isRelaunch=" + z2);
        if (z) {
            b.a DR = DR();
            if (!z2) {
                Qj();
            }
            if (!TextUtils.isEmpty(DR.Tl())) {
                com.baidu.swan.apps.console.debugger.a.e.setWebUrl(DR.Tl());
            }
        }
        com.baidu.swan.apps.y.f Uf = com.baidu.swan.apps.y.f.Uf();
        if (!Qk()) {
            Uf.i(this.bdF);
        }
        jx.f(new UbcFlowEvent("onUpdateStart").cU(true));
        k(z, z2);
        jx.f(new UbcFlowEvent("onUpdateEnd").cU(true));
    }

    private synchronized void PQ() {
        log("onReleaseInternal");
        onRelease();
        com.baidu.swan.apps.y.f.release();
    }

    @DebugTrace
    private synchronized void PR() {
        log("onCreateInternal");
        HybridUbcFlow jx = f.jx("startup");
        jx.f(new UbcFlowEvent("frame_start_create"));
        jx.f(new UbcFlowEvent("onCreateInternalStart").cU(true));
        this.bqE.PE();
        com.baidu.swan.apps.console.c.d("SwanApp", "onCreate: " + this);
        if (com.baidu.swan.apps.console.debugger.a.e.Jc()) {
            com.baidu.swan.apps.core.k.d.release();
        }
        Qg();
        com.baidu.swan.apps.runtime.d ZP = com.baidu.swan.apps.runtime.d.ZP();
        if (!ZP.Yw() || !ZP.ZM().available()) {
            com.baidu.swan.apps.ap.a mh = new com.baidu.swan.apps.ap.a().aB(5L).aC(11L).mh("aiapp data is invalid");
            com.baidu.swan.apps.ap.e.adF().f(mh);
            com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().lv(com.baidu.swan.apps.statistic.f.ga(DH())).e(mh).a(DR()));
            com.baidu.swan.apps.as.c.R(this.bdF);
        } else {
            com.baidu.swan.apps.runtime.e ZM = ZP.ZM();
            ZM.aac().abn();
            ZM.aad().clear();
            PY();
            jx.f(new UbcFlowEvent("onCreateStart").cU(true));
            onCreate();
            jx.f(new UbcFlowEvent("onCreateEnd").cU(true));
            com.baidu.swan.apps.as.b DG = this.bdF.DG();
            if (DG != null) {
                DG.adL();
            }
            jx.f(new UbcFlowEvent("onCreateInternalEnd").cU(true));
        }
    }

    private synchronized void PS() {
        HybridUbcFlow jx = f.jx("startup");
        jx.f(new UbcFlowEvent("onStartStart").cU(true));
        log("onStartInternal");
        this.bqE.PF();
        onStart();
        jx.f(new UbcFlowEvent("onStartEnd").cU(true));
    }

    private synchronized void PT() {
        HybridUbcFlow jx = f.jx("startup");
        jx.f(new UbcFlowEvent("onResumeInternalStart").cU(true));
        log("onResumeInternal");
        this.bqE.onActivityResumed();
        com.baidu.swan.apps.console.c.d("SwanApp", "onResume: " + this);
        this.bqD = com.baidu.swan.apps.statistic.f.lp("607");
        Qf();
        if (Yw()) {
            ZM().onActivityResume(this.bdF);
        }
        m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.framework.c.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.network.c.a.Wo().Wq();
                if (c.DEBUG) {
                    Log.e("SwanActivityFrame", "try update on computation thread");
                }
                if (c.this.bdF != null && com.baidu.swan.apps.runtime.e.ZS() != null) {
                    com.baidu.swan.apps.database.a.b.b(com.baidu.swan.apps.runtime.e.ZS());
                }
            }
        }, "saveSwanAppHistory");
        f.jx("startup").f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
        com.baidu.swan.apps.an.a.abU().lk("na_page_show");
        com.baidu.swan.apps.y.f.Uf().FL();
        jx.f(new UbcFlowEvent("onResumeStart").cU(true));
        onResume();
        jx.f(new UbcFlowEvent("onResumeEnd").cU(true));
    }

    private synchronized void PU() {
        log("onPauseInternal");
        onPause();
        com.baidu.swan.apps.y.f.Uf().FM();
        this.bqE.onActivityPaused();
        com.baidu.swan.apps.console.c.d("SwanApp", "onPause: " + this);
        if (this.bqD != null && Yw()) {
            com.baidu.swan.apps.statistic.a.a aVar = new com.baidu.swan.apps.statistic.a.a();
            b.a DR = DR();
            aVar.mFrom = com.baidu.swan.apps.statistic.f.ga(DH());
            aVar.mAppId = DR.getAppId();
            aVar.mSource = DR.SW();
            aVar.c(DR);
            aVar.lz(DR.Tc().getString("ubc"));
            aVar.ba(com.baidu.swan.apps.statistic.f.lq(DR.SY()));
            com.baidu.swan.apps.statistic.f.a(this.bqD, aVar);
            this.bqD = null;
        }
    }

    private synchronized void PV() {
        log("onStopInternal");
        onStop();
        this.bqE.PG();
    }

    private synchronized void PW() {
        log("onDestroyInternal");
        onDestroy();
        this.bqE.GX();
        com.baidu.swan.apps.console.c.d("SwanApp", "onDestroy: " + this);
        com.baidu.swan.apps.network.c.a.Wo().release();
        com.baidu.swan.apps.performance.b.d.releaseInstance();
        PZ();
        com.baidu.swan.apps.y.f.release();
    }

    public synchronized FrameLifeState PX() {
        return this.bqG;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.bqE.onKeyDown(i, keyEvent);
    }

    public void PY() {
        if (this.bqz == null) {
            this.bqz = Qe();
        }
        ZL().a((a.c) null, this.bqz);
    }

    public void PZ() {
        ZL().PZ();
        this.bqz = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Qa() {
        b.a DR;
        Bundle Tb;
        if (Yw() && (Tb = (DR = DR()).Tb()) != null && Tb.getLong("launch_flag_for_statistic") > 0) {
            long j = DR.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.ga(DH());
            fVar.mAppId = DR.getAppId();
            if (com.baidu.swan.apps.ah.a.a.jW(DR().Tl())) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = DR.SW();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.bQD = String.valueOf(currentTimeMillis - j);
            fVar.n("status", "0");
            fVar.lz(DR.Tc().getString("ubc"));
            fVar.ba(com.baidu.swan.apps.statistic.f.lq(DR.SY()));
            com.baidu.swan.apps.statistic.f.onEvent(fVar);
            Tb.remove("launch_flag_for_statistic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Qb() {
        Qc();
        Qd();
    }

    private void Qc() {
        com.baidu.swan.apps.adaptation.a.b Fg = ZR().Ei().Fg();
        if (Fg != null) {
            Fg.bk(this.bdF);
        }
    }

    protected void Qd() {
        com.baidu.swan.apps.runtime.e ZS = com.baidu.swan.apps.runtime.e.ZS();
        com.baidu.swan.apps.a.b bVar = null;
        if (ZS != null) {
            bVar = ZS.aad();
        }
        if (bVar != null) {
            bVar.setUid(bVar.getUid(AppRuntime.getAppContext()));
        }
    }

    private void Qf() {
        if (ZM().available()) {
            setTaskDescription(this.bdF, DR().Op(), ai.a((com.baidu.swan.apps.x.b.b) DR(), "SwanActivityFrame", true), (int) DR().SV());
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

    private void Qg() {
        this.bqy = new com.baidu.swan.apps.core.d.e(this.bdF);
        Qh();
    }

    protected void Qh() {
    }

    public com.baidu.swan.apps.core.d.e DP() {
        return this.bqy;
    }

    public void onTrimMemory(int i) {
        com.baidu.swan.apps.console.c.w("SwanActivityFrame", "onTrimMemory level:" + i);
        DT().gE(i);
    }

    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Qi() {
        if (this.bqy.LE() != 1) {
            return false;
        }
        this.bdF.moveTaskToBack(true);
        this.bdF.dA(2);
        return true;
    }

    public b.a DR() {
        return ZM().ZV();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (fVar != null && Yw()) {
            b.a DR = DR();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.ga(DH());
            fVar.mAppId = DR.getAppId();
            fVar.mSource = DR.SW();
            fVar.ba(com.baidu.swan.apps.statistic.f.lq(DR.SY()));
            if (TextUtils.isEmpty(fVar.mType)) {
                fVar.mType = "click";
            }
            fVar.lz(DR.Tc().getString("ubc"));
            if (TextUtils.equals(fVar.mType, "click")) {
                com.baidu.swan.apps.statistic.b.b(fVar);
            } else {
                com.baidu.swan.apps.statistic.f.onEvent(fVar);
            }
        }
    }

    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.bqB == null) {
                this.bqB = new com.baidu.swan.apps.af.c();
            }
            this.bqB.a(this.bdF, i, strArr, aVar);
        }
    }

    public boolean b(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.bqB != null) {
            this.bqB.a(this.bdF, i, strArr, iArr);
            return true;
        }
        return false;
    }

    public void showLoadingView() {
        this.bqC = (FrameLayout) this.bdF.findViewById(a.f.ai_apps_activity_root);
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(this.bdF, this.bqC);
    }

    public void DS() {
        com.baidu.swan.apps.res.widget.loadingview.a.removeLoadingView(this.bqC);
    }

    @NonNull
    public com.baidu.swan.apps.ao.g.b DT() {
        return this.bqA;
    }

    public boolean isLandScape() {
        return false;
    }

    public void a(b bVar) {
        this.bqE.c(bVar);
    }

    public void b(b bVar) {
        this.bqE.d(bVar);
    }

    public boolean hA(String str) {
        return TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Qj() {
    }

    public void GY() {
        this.bqE.GY();
    }

    public boolean Qk() {
        return com.baidu.swan.apps.y.f.Uf().Ug();
    }

    private void log(String str) {
        if (DEBUG) {
            Log.i("SwanActivityFrame", str);
        }
    }
}
