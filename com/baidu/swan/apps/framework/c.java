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
/* loaded from: classes10.dex */
public abstract class c extends l {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected final SwanAppActivity bev;
    protected com.baidu.swan.apps.core.d.e brm;
    protected a.b brn;
    private final com.baidu.swan.apps.ao.f.b bro;
    private com.baidu.swan.apps.af.c brp;
    private FrameLayout brq;
    private Flow brr;
    private d brs;
    public final String brt;
    private FrameLifeState bru;
    private FrameLifeState brv;
    private boolean brw;
    private boolean brx;

    @NonNull
    protected abstract a.b QA();

    protected abstract void Qd();

    protected abstract void j(boolean z, boolean z2);

    protected abstract void onCreate();

    protected abstract void onDestroy();

    protected abstract void onPause();

    protected abstract void onRelease();

    protected abstract void onResume();

    protected abstract void onStart();

    protected abstract void onStop();

    public c(SwanAppActivity swanAppActivity, String str) {
        super(com.baidu.swan.apps.runtime.d.aam());
        this.brn = null;
        this.bro = new com.baidu.swan.apps.ao.f.b();
        this.bru = FrameLifeState.INACTIVATED;
        this.brv = null;
        this.brw = false;
        this.brx = false;
        this.bev = swanAppActivity;
        this.brt = str;
        this.brs = new d();
    }

    public final synchronized void a(FrameLifeState frameLifeState, boolean z) {
        boolean z2 = false;
        synchronized (this) {
            if (!this.bev.isDestroyed()) {
                boolean z3 = (!this.bru.hasCreated()) | z;
                if (this.bru.hasCreated() && z3) {
                    z2 = true;
                }
                k(z3, z2);
                d(frameLifeState);
                if (z3 && (z2 || 1 == Ed())) {
                    f.h(En());
                }
            }
        }
    }

    public final synchronized void release() {
        d(FrameLifeState.INACTIVATED);
        Qm();
    }

    public boolean Qe() {
        return this.brx;
    }

    private synchronized FrameLifeState c(@NonNull FrameLifeState frameLifeState) {
        return (frameLifeState.inactivated() || aaj().aaK() || !frameLifeState.hasStarted() || frameLifeState.moreInactiveThan(this.bru)) ? frameLifeState : this.bru.hasCreated() ? this.bru : FrameLifeState.JUST_CREATED;
    }

    public final synchronized void d(@NonNull FrameLifeState frameLifeState) {
        synchronized (this) {
            log(" transLifeState: target=" + frameLifeState + " holdon=" + this.brw + " locked=" + this.brx + " thread=" + Thread.currentThread());
            if (!this.brx) {
                this.brv = frameLifeState;
                this.brx = FrameLifeState.INACTIVATED == this.brv;
            }
            if (!this.brw) {
                this.brw = true;
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.framework.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.Qf();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Qf() {
        synchronized (this) {
            this.brw = true;
            while (this.brv != null && QG()) {
                FrameLifeState c = c(this.brv);
                log("syncLifeState: pendingTarget=" + this.brv + " fixedTarget=" + c);
                this.brv = null;
                switch (c) {
                    case JUST_CREATED:
                        Qk();
                        Qg();
                        break;
                    case JUST_STARTED:
                        Qj();
                        Qh();
                        break;
                    case JUST_RESUMED:
                        Qi();
                        break;
                    default:
                        Ql();
                        break;
                }
            }
            log("syncLifeState: done=" + this.bru);
            this.brx = FrameLifeState.INACTIVATED == this.brv;
            this.brw = false;
        }
    }

    private synchronized void Qg() {
        if (!this.bru.hasCreated()) {
            Qn();
            com.baidu.swan.apps.console.c.d("SwanApp", "onPostCreate: " + this);
            Qd();
            this.bru = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void Qh() {
        Qg();
        if (!this.bru.hasStarted()) {
            Qo();
            this.bru = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void Qi() {
        Qh();
        if (!this.bru.hasResumed()) {
            Qp();
            this.bru = FrameLifeState.JUST_RESUMED;
        }
    }

    private synchronized void Qj() {
        if (this.bru.hasResumed()) {
            Qq();
            this.bru = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void Qk() {
        Qj();
        if (this.bru.hasStarted()) {
            Qr();
            this.bru = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void Ql() {
        Qk();
        if (this.bru.hasCreated()) {
            Qs();
            this.bru = FrameLifeState.INACTIVATED;
        }
    }

    private synchronized void k(boolean z, boolean z2) {
        HybridUbcFlow jA = f.jA("startup");
        jA.f(new UbcFlowEvent("onUpdateInternalStart").cZ(true));
        log("onUpdateInternal isLaunch=" + z + " isRelaunch=" + z2);
        if (z) {
            b.a En = En();
            if (!z2) {
                QF();
            }
            if (!TextUtils.isEmpty(En.TI())) {
                com.baidu.swan.apps.console.debugger.a.e.setWebUrl(En.TI());
            }
        }
        com.baidu.swan.apps.y.f UC = com.baidu.swan.apps.y.f.UC();
        if (!QG()) {
            UC.i(this.bev);
        }
        jA.f(new UbcFlowEvent("onUpdateStart").cZ(true));
        j(z, z2);
        jA.f(new UbcFlowEvent("onUpdateEnd").cZ(true));
    }

    private synchronized void Qm() {
        log("onReleaseInternal");
        onRelease();
        com.baidu.swan.apps.y.f.release();
    }

    @DebugTrace
    private synchronized void Qn() {
        log("onCreateInternal");
        HybridUbcFlow jA = f.jA("startup");
        jA.f(new UbcFlowEvent("frame_start_create"));
        jA.f(new UbcFlowEvent("onCreateInternalStart").cZ(true));
        this.brs.Qa();
        com.baidu.swan.apps.console.c.d("SwanApp", "onCreate: " + this);
        if (com.baidu.swan.apps.console.debugger.a.e.Jy()) {
            com.baidu.swan.apps.core.k.d.release();
        }
        QC();
        com.baidu.swan.apps.runtime.d aam = com.baidu.swan.apps.runtime.d.aam();
        if (!aam.YT() || !aam.aaj().available()) {
            com.baidu.swan.apps.ap.a mk = new com.baidu.swan.apps.ap.a().aE(5L).aF(11L).mk("aiapp data is invalid");
            com.baidu.swan.apps.ap.e.adY().f(mk);
            com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().ly(com.baidu.swan.apps.statistic.f.gb(Ed())).e(mk).a(En()));
            com.baidu.swan.apps.as.c.S(this.bev);
        } else {
            com.baidu.swan.apps.runtime.e aaj = aam.aaj();
            aaj.aaz().abK();
            aaj.aaA().clear();
            Qu();
            jA.f(new UbcFlowEvent("onCreateStart").cZ(true));
            onCreate();
            jA.f(new UbcFlowEvent("onCreateEnd").cZ(true));
            com.baidu.swan.apps.as.b Ec = this.bev.Ec();
            if (Ec != null) {
                Ec.aee();
            }
            jA.f(new UbcFlowEvent("onCreateInternalEnd").cZ(true));
        }
    }

    private synchronized void Qo() {
        HybridUbcFlow jA = f.jA("startup");
        jA.f(new UbcFlowEvent("onStartStart").cZ(true));
        log("onStartInternal");
        this.brs.Qb();
        onStart();
        jA.f(new UbcFlowEvent("onStartEnd").cZ(true));
    }

    private synchronized void Qp() {
        HybridUbcFlow jA = f.jA("startup");
        jA.f(new UbcFlowEvent("onResumeInternalStart").cZ(true));
        log("onResumeInternal");
        this.brs.onActivityResumed();
        com.baidu.swan.apps.console.c.d("SwanApp", "onResume: " + this);
        this.brr = com.baidu.swan.apps.statistic.f.ls("607");
        QB();
        if (YT()) {
            aaj().onActivityResume(this.bev);
        }
        m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.framework.c.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.network.c.a.WL().WN();
                if (c.DEBUG) {
                    Log.e("SwanActivityFrame", "try update on computation thread");
                }
                if (c.this.bev != null && com.baidu.swan.apps.runtime.e.aap() != null) {
                    com.baidu.swan.apps.database.a.b.b(com.baidu.swan.apps.runtime.e.aap());
                }
            }
        }, "saveSwanAppHistory");
        f.jA("startup").f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
        com.baidu.swan.apps.an.a.acr().ln("na_page_show");
        com.baidu.swan.apps.y.f.UC().Gh();
        jA.f(new UbcFlowEvent("onResumeStart").cZ(true));
        onResume();
        jA.f(new UbcFlowEvent("onResumeEnd").cZ(true));
    }

    private synchronized void Qq() {
        log("onPauseInternal");
        onPause();
        com.baidu.swan.apps.y.f.UC().Gi();
        this.brs.onActivityPaused();
        com.baidu.swan.apps.console.c.d("SwanApp", "onPause: " + this);
        if (this.brr != null && YT()) {
            com.baidu.swan.apps.statistic.a.a aVar = new com.baidu.swan.apps.statistic.a.a();
            b.a En = En();
            aVar.mFrom = com.baidu.swan.apps.statistic.f.gb(Ed());
            aVar.mAppId = En.getAppId();
            aVar.mSource = En.Tt();
            aVar.c(En);
            aVar.lC(En.Tz().getString("ubc"));
            aVar.ba(com.baidu.swan.apps.statistic.f.lt(En.Tv()));
            com.baidu.swan.apps.statistic.f.a(this.brr, aVar);
            this.brr = null;
        }
    }

    private synchronized void Qr() {
        log("onStopInternal");
        onStop();
        this.brs.Qc();
    }

    private synchronized void Qs() {
        log("onDestroyInternal");
        onDestroy();
        this.brs.Ht();
        com.baidu.swan.apps.console.c.d("SwanApp", "onDestroy: " + this);
        com.baidu.swan.apps.network.c.a.WL().release();
        com.baidu.swan.apps.performance.b.d.releaseInstance();
        Qv();
        com.baidu.swan.apps.y.f.release();
    }

    public synchronized FrameLifeState Qt() {
        return this.bru;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.brs.onKeyDown(i, keyEvent);
    }

    public void Qu() {
        if (this.brn == null) {
            this.brn = QA();
        }
        aai().a((a.c) null, this.brn);
    }

    public void Qv() {
        aai().Qv();
        this.brn = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Qw() {
        b.a En;
        Bundle Ty;
        if (YT() && (Ty = (En = En()).Ty()) != null && Ty.getLong("launch_flag_for_statistic") > 0) {
            long j = En.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gb(Ed());
            fVar.mAppId = En.getAppId();
            if (com.baidu.swan.apps.ah.a.a.jZ(En().TI())) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = En.Tt();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.bRn = String.valueOf(currentTimeMillis - j);
            fVar.n("status", "0");
            fVar.lC(En.Tz().getString("ubc"));
            fVar.ba(com.baidu.swan.apps.statistic.f.lt(En.Tv()));
            com.baidu.swan.apps.statistic.f.onEvent(fVar);
            Ty.remove("launch_flag_for_statistic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Qx() {
        Qy();
        Qz();
    }

    private void Qy() {
        com.baidu.swan.apps.adaptation.a.b FC = aao().EE().FC();
        if (FC != null) {
            FC.bk(this.bev);
        }
    }

    protected void Qz() {
        com.baidu.swan.apps.runtime.e aap = com.baidu.swan.apps.runtime.e.aap();
        com.baidu.swan.apps.a.b bVar = null;
        if (aap != null) {
            bVar = aap.aaA();
        }
        if (bVar != null) {
            bVar.setUid(bVar.getUid(AppRuntime.getAppContext()));
        }
    }

    private void QB() {
        if (aaj().available()) {
            setTaskDescription(this.bev, En().OL(), ai.a((com.baidu.swan.apps.x.b.b) En(), "SwanActivityFrame", true), (int) En().Ts());
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

    private void QC() {
        this.brm = new com.baidu.swan.apps.core.d.e(this.bev);
        QD();
    }

    protected void QD() {
    }

    public com.baidu.swan.apps.core.d.e El() {
        return this.brm;
    }

    public void onTrimMemory(int i) {
        com.baidu.swan.apps.console.c.w("SwanActivityFrame", "onTrimMemory level:" + i);
        Ep().gE(i);
    }

    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean QE() {
        if (this.brm.Ma() != 1) {
            return false;
        }
        this.bev.moveTaskToBack(true);
        this.bev.dB(2);
        return true;
    }

    public b.a En() {
        return aaj().aas();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (fVar != null && YT()) {
            b.a En = En();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gb(Ed());
            fVar.mAppId = En.getAppId();
            fVar.mSource = En.Tt();
            fVar.ba(com.baidu.swan.apps.statistic.f.lt(En.Tv()));
            if (TextUtils.isEmpty(fVar.mType)) {
                fVar.mType = "click";
            }
            fVar.lC(En.Tz().getString("ubc"));
            if (TextUtils.equals(fVar.mType, "click")) {
                com.baidu.swan.apps.statistic.b.b(fVar);
            } else {
                com.baidu.swan.apps.statistic.f.onEvent(fVar);
            }
        }
    }

    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.brp == null) {
                this.brp = new com.baidu.swan.apps.af.c();
            }
            this.brp.a(this.bev, i, strArr, aVar);
        }
    }

    public boolean b(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.brp != null) {
            this.brp.a(this.bev, i, strArr, iArr);
            return true;
        }
        return false;
    }

    public void showLoadingView() {
        this.brq = (FrameLayout) this.bev.findViewById(a.f.ai_apps_activity_root);
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(this.bev, this.brq);
    }

    public void Eo() {
        com.baidu.swan.apps.res.widget.loadingview.a.removeLoadingView(this.brq);
    }

    @NonNull
    public com.baidu.swan.apps.ao.f.b Ep() {
        return this.bro;
    }

    public boolean isLandScape() {
        return false;
    }

    public void a(b bVar) {
        this.brs.c(bVar);
    }

    public void b(b bVar) {
        this.brs.d(bVar);
    }

    public boolean hD(String str) {
        return TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void QF() {
    }

    public void Hu() {
        this.brs.Hu();
    }

    public boolean QG() {
        return com.baidu.swan.apps.y.f.UC().UD();
    }

    private void log(String str) {
        if (DEBUG) {
            Log.i("SwanActivityFrame", str);
        }
    }
}
