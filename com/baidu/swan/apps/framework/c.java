package com.baidu.swan.apps.framework;

import android.app.Activity;
import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.aq.aq;
import com.baidu.swan.apps.aq.p;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.messaging.client.a;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.runtime.m;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes7.dex */
public abstract class c extends m {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.apps.runtime.b bMk;
    protected final SwanAppActivity bVJ;
    protected f ckW;
    protected a.b ckX;
    private final com.baidu.swan.apps.am.f.b ckY;
    private FrameLayout ckZ;
    private com.baidu.swan.apps.statistic.a cla;
    private d clb;
    public final String clc;
    private FrameLifeState cld;
    private FrameLifeState cle;
    private boolean clf;
    private boolean clg;
    private boolean clh;

    protected abstract void afC();

    @NonNull
    protected abstract a.b afZ();

    protected abstract void m(boolean z, boolean z2);

    protected abstract void onCreate();

    protected abstract void onDestroy();

    protected abstract void onPause();

    protected abstract void onRelease();

    protected abstract void onResume();

    protected abstract void onStart();

    protected abstract void onStop();

    public c(SwanAppActivity swanAppActivity, String str) {
        super(com.baidu.swan.apps.runtime.d.arr());
        this.ckX = null;
        this.ckY = new com.baidu.swan.apps.am.f.b();
        this.cld = FrameLifeState.INACTIVATED;
        this.cle = null;
        this.clf = false;
        this.clg = false;
        this.bMk = new com.baidu.swan.apps.runtime.b();
        this.clh = true;
        this.bVJ = swanAppActivity;
        this.clc = str;
        this.clb = new d();
        o(this.bMk);
    }

    public final synchronized void a(FrameLifeState frameLifeState, boolean z) {
        final boolean z2 = false;
        synchronized (this) {
            if (!this.bVJ.isDestroyed()) {
                final boolean z3 = (!this.cld.hasCreated()) | z;
                if (this.cld.hasCreated() && z3) {
                    z2 = true;
                }
                this.clh = com.baidu.swan.apps.t.a.ahm().getSwitch("swan_fixed_relaunch_switch", true);
                if (this.clh && z2 && !arn().arS()) {
                    this.bMk.a(new com.baidu.swan.apps.aq.e.b<i.a>() { // from class: com.baidu.swan.apps.framework.c.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.aq.e.b
                        /* renamed from: b */
                        public void H(i.a aVar) {
                            if (com.baidu.swan.apps.runtime.d.arr().apU()) {
                                c.this.bMk.u("event_first_action_launched");
                                c.this.n(z3, z2);
                                c.this.afE();
                            }
                        }
                    }, "event_first_action_launched");
                } else {
                    n(z3, z2);
                }
                d(frameLifeState);
                if (z3 && (z2 || 1 == RU())) {
                    com.baidu.swan.apps.performance.i.a(Se(), z2);
                }
            }
        }
    }

    public final synchronized void release() {
        d(FrameLifeState.INACTIVATED);
        afL();
    }

    public boolean afD() {
        return this.clg;
    }

    private synchronized FrameLifeState c(@NonNull FrameLifeState frameLifeState) {
        return (frameLifeState.inactivated() || arn().arS() || !frameLifeState.hasStarted() || frameLifeState.moreInactiveThan(this.cld)) ? frameLifeState : this.cld.hasCreated() ? this.cld : FrameLifeState.JUST_CREATED;
    }

    public final synchronized void d(@NonNull FrameLifeState frameLifeState) {
        synchronized (this) {
            log(" transLifeState: target=" + frameLifeState + " holdon=" + this.clf + " locked=" + this.clg + " thread=" + Thread.currentThread());
            if (!this.clg) {
                this.cle = frameLifeState;
                this.clg = FrameLifeState.INACTIVATED == this.cle;
            }
            if (!this.clf) {
                this.clf = true;
                al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.framework.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.afE();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void afE() {
        synchronized (this) {
            this.clf = true;
            while (this.cle != null && agf()) {
                FrameLifeState c = c(this.cle);
                log("syncLifeState: pendingTarget=" + this.cle + " fixedTarget=" + c);
                this.cle = null;
                switch (c) {
                    case JUST_CREATED:
                        afJ();
                        afF();
                        break;
                    case JUST_STARTED:
                        afI();
                        afG();
                        break;
                    case JUST_RESUMED:
                        afH();
                        break;
                    default:
                        afK();
                        break;
                }
            }
            log("syncLifeState: done=" + this.cld);
            this.clg = FrameLifeState.INACTIVATED == this.cle;
            this.clf = false;
        }
    }

    private synchronized void afF() {
        if (!this.cld.hasCreated()) {
            afM();
            com.baidu.swan.apps.console.c.i("SwanApp", "onPostCreate: " + this);
            afC();
            this.cld = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void afG() {
        afF();
        if (!this.cld.hasStarted()) {
            afN();
            this.cld = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void afH() {
        afG();
        if (!this.cld.hasResumed()) {
            afO();
            this.cld = FrameLifeState.JUST_RESUMED;
        }
    }

    private synchronized void afI() {
        if (this.cld.hasResumed()) {
            afP();
            this.cld = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void afJ() {
        afI();
        if (this.cld.hasStarted()) {
            afQ();
            this.cld = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void afK() {
        afJ();
        if (this.cld.hasCreated()) {
            afR();
            this.cld = FrameLifeState.INACTIVATED;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void n(boolean z, boolean z2) {
        HybridUbcFlow mX = com.baidu.swan.apps.performance.i.mX("startup");
        mX.f(new UbcFlowEvent("onUpdateInternalStart").eI(true));
        log("onUpdateInternal isLaunch=" + z + " isRelaunch=" + z2);
        if (z) {
            b.a Se = Se();
            if (!z2) {
                age();
            }
            if (!TextUtils.isEmpty(Se.ajv())) {
                com.baidu.swan.apps.console.debugger.a.e.setWebUrl(Se.ajv());
            }
        }
        com.baidu.swan.apps.v.f.akr().i(this.bVJ);
        mX.f(new UbcFlowEvent("onUpdateStart").eI(true));
        m(z, z2);
        mX.f(new UbcFlowEvent("onUpdateEnd").eI(true));
    }

    private synchronized void afL() {
        log("onReleaseInternal");
        onRelease();
        com.baidu.swan.apps.v.f.release();
        com.baidu.swan.apps.core.pms.f.a.acy();
    }

    @DebugTrace
    private synchronized void afM() {
        log("onCreateInternal");
        HybridUbcFlow mX = com.baidu.swan.apps.performance.i.mX("startup");
        mX.f(new UbcFlowEvent("frame_start_create"));
        mX.f(new UbcFlowEvent("onCreateInternalStart").eI(true));
        this.clb.afA();
        com.baidu.swan.apps.console.c.i("SwanApp", "onCreate: " + this);
        if (com.baidu.swan.apps.console.debugger.a.e.XY()) {
            com.baidu.swan.apps.core.turbo.d.release(false);
        }
        agb();
        com.baidu.swan.apps.runtime.d arr = com.baidu.swan.apps.runtime.d.arr();
        if (!arr.apU() || !arr.arn().available()) {
            com.baidu.swan.apps.an.a qm = new com.baidu.swan.apps.an.a().bJ(5L).bK(11L).qm("aiapp data is invalid");
            com.baidu.swan.apps.an.e.avX().g(qm);
            h.b(new com.baidu.swan.apps.statistic.a.d().pu(h.ho(RU())).f(qm).a(Se()));
            com.baidu.swan.apps.performance.i.a(qm);
            com.baidu.swan.apps.aq.e.M(this.bVJ);
        } else {
            afU();
            mX.f(new UbcFlowEvent("onCreateStart").eI(true));
            onCreate();
            mX.f(new UbcFlowEvent("onCreateEnd").eI(true));
            com.baidu.swan.apps.aq.d RT = this.bVJ.RT();
            if (RT != null) {
                RT.awj();
            }
            mX.f(new UbcFlowEvent("onCreateInternalEnd").eI(true));
        }
    }

    private synchronized void afN() {
        HybridUbcFlow mX = com.baidu.swan.apps.performance.i.mX("startup");
        mX.f(new UbcFlowEvent("onStartStart").eI(true));
        log("onStartInternal");
        this.clb.afB();
        onStart();
        mX.f(new UbcFlowEvent("onStartEnd").eI(true));
    }

    private synchronized void afO() {
        HybridUbcFlow mX = com.baidu.swan.apps.performance.i.mX("startup");
        mX.f(new UbcFlowEvent("onResumeInternalStart").eI(true));
        log("onResumeInternal");
        this.clb.VL();
        com.baidu.swan.apps.console.c.i("SwanApp", "onResume: " + this);
        this.cla = h.pn("607");
        aga();
        if (apU()) {
            arn().onActivityResume(this.bVJ);
        }
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.framework.c.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.network.c.a.amZ().anb();
                if (c.DEBUG) {
                    Log.e("SwanActivityFrame", "try update on computation thread");
                }
                if (c.this.bVJ != null && com.baidu.swan.apps.runtime.e.arv() != null) {
                    com.baidu.swan.apps.database.a.b.a(com.baidu.swan.apps.runtime.e.arv(), com.baidu.swan.apps.env.b.c.aeQ().fy(10).aeR());
                }
            }
        }, "saveSwanAppHistory");
        com.baidu.swan.apps.performance.i.mX("startup").f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
        com.baidu.swan.apps.al.a.atW().pf("na_page_show");
        com.baidu.swan.apps.v.f.akr().Uw();
        mX.f(new UbcFlowEvent("onResumeStart").eI(true));
        onResume();
        mX.f(new UbcFlowEvent("onResumeEnd").eI(true));
    }

    private synchronized void afP() {
        log("onPauseInternal");
        onPause();
        com.baidu.swan.apps.v.f.akr().Ux();
        this.clb.Xe();
        com.baidu.swan.apps.console.c.i("SwanApp", "onPause: " + this);
        if (this.cla != null && apU()) {
            com.baidu.swan.apps.statistic.a.a aVar = new com.baidu.swan.apps.statistic.a.a();
            b.a Se = Se();
            aVar.mFrom = h.ho(RU());
            aVar.mAppId = Se.getAppId();
            aVar.mSource = Se.ajg();
            aVar.c(Se);
            aVar.py(Se.ajm().getString("ubc"));
            aVar.bG(h.pp(Se.aji()));
            h.a(this.cla, aVar);
            this.cla = null;
        }
    }

    private synchronized void afQ() {
        com.baidu.swan.apps.performance.i.anY();
        log("onStopInternal");
        onStop();
        this.clb.Zc();
    }

    private synchronized void afR() {
        log("onDestroyInternal");
        onDestroy();
        this.clb.VK();
        com.baidu.swan.apps.console.c.i("SwanApp", "onDestroy: " + this);
        com.baidu.swan.apps.network.c.a.amZ().release();
        com.baidu.swan.apps.core.i.a.acJ().release();
        com.baidu.swan.apps.api.b.c.Wt().release();
        com.baidu.swan.apps.performance.e.d.releaseInstance();
        afS();
        afV();
        com.baidu.swan.apps.v.f.release();
    }

    private void afS() {
        com.baidu.swan.apps.scheme.actions.k.c.cKH = null;
        com.baidu.swan.apps.performance.i.cyJ = null;
    }

    public synchronized FrameLifeState afT() {
        return this.cld;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.clb.onKeyDown(i, keyEvent);
    }

    public void afU() {
        if (this.ckX == null) {
            this.ckX = afZ();
        }
        arm().a((a.c) null, this.ckX);
    }

    public void afV() {
        arm().afV();
        this.ckX = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void afW() {
        afX();
        afY();
    }

    private void afX() {
        com.baidu.swan.apps.adaptation.a.b Ug = art().Sv().Ug();
        if (Ug != null) {
            Ug.bb(this.bVJ);
        }
    }

    protected void afY() {
        com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
        com.baidu.swan.apps.a.b bVar = null;
        if (arv != null) {
            bVar = arv.arI();
        }
        if (bVar != null) {
            bVar.setUid(bVar.getUid(AppRuntime.getAppContext()));
            bVar.bb(AppRuntime.getAppContext());
        }
    }

    private void aga() {
        if (arn().available()) {
            if (!com.baidu.swan.apps.performance.b.b.aon()) {
                l(al.a((com.baidu.swan.apps.u.c.b) Se(), "SwanActivityFrame", true));
            } else {
                ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.framework.c.4
                    @Override // java.lang.Runnable
                    public void run() {
                        final Bitmap a = al.a((com.baidu.swan.apps.u.c.b) c.this.Se(), "SwanActivityFrame", true);
                        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.framework.c.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (c.this.bVJ != null && com.baidu.swan.apps.runtime.e.arw() != null) {
                                    c.this.l(a);
                                }
                            }
                        });
                    }
                }, "updateTaskDescription", 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Bitmap bitmap) {
        if (arn().available()) {
            setTaskDescription(this.bVJ, Se().aee(), bitmap, (int) Se().ajf());
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

    private void agb() {
        this.ckW = new f(this.bVJ);
        agc();
    }

    protected void agc() {
    }

    public f Sc() {
        if (this.ckW == null) {
            agb();
        }
        return this.ckW;
    }

    public void onTrimMemory(int i) {
        com.baidu.swan.apps.console.c.w("SwanActivityFrame", "onTrimMemory level:" + i);
        Sg().hS(i);
    }

    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean agd() {
        if (this.ckW.abc() != 1) {
            return false;
        }
        this.bVJ.moveTaskToBack(true);
        this.bVJ.eq(2);
        aq.axo().ig(1);
        return true;
    }

    public b.a Se() {
        return arn().arz();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (fVar != null && apU()) {
            b.a Se = Se();
            fVar.mFrom = h.ho(RU());
            fVar.mAppId = Se.getAppId();
            fVar.mSource = Se.ajg();
            fVar.bG(h.pp(Se.aji()));
            if (TextUtils.isEmpty(fVar.mType)) {
                fVar.mType = "click";
            }
            fVar.py(Se.ajm().getString("ubc"));
            if (TextUtils.equals(fVar.mType, "click")) {
                com.baidu.swan.apps.statistic.d.b(fVar);
            } else {
                h.onEvent(fVar);
            }
        }
    }

    public void showLoadingView() {
        this.ckZ = (FrameLayout) this.bVJ.findViewById(a.f.ai_apps_activity_root);
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(this.bVJ, this.ckZ);
    }

    public void Sf() {
        com.baidu.swan.apps.res.widget.loadingview.a.removeLoadingView(this.ckZ);
    }

    @NonNull
    public com.baidu.swan.apps.am.f.b Sg() {
        return this.ckY;
    }

    public boolean isLandScape() {
        return false;
    }

    public void a(b bVar) {
        this.clb.c(bVar);
    }

    public void b(b bVar) {
        this.clb.d(bVar);
    }

    public boolean kR(String str) {
        return TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void age() {
    }

    public void VM() {
        this.clb.VM();
    }

    public boolean agf() {
        return com.baidu.swan.apps.v.f.akr().akt();
    }

    private void log(String str) {
        if (DEBUG) {
            Log.i("SwanActivityFrame", str);
        }
    }
}
