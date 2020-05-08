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
    protected final SwanAppActivity bHl;
    protected com.baidu.swan.apps.core.d.e bTW;
    protected a.b bTX;
    private final com.baidu.swan.apps.ao.f.b bTY;
    private com.baidu.swan.apps.af.c bTZ;
    private FrameLayout bUa;
    private Flow bUb;
    private d bUc;
    public final String bUd;
    private FrameLifeState bUe;
    private FrameLifeState bUf;
    private boolean bUg;
    private boolean bUh;

    @NonNull
    protected abstract a.b aaH();

    protected abstract void aak();

    protected abstract void l(boolean z, boolean z2);

    protected abstract void onCreate();

    protected abstract void onDestroy();

    protected abstract void onPause();

    protected abstract void onRelease();

    protected abstract void onResume();

    protected abstract void onStart();

    protected abstract void onStop();

    public c(SwanAppActivity swanAppActivity, String str) {
        super(com.baidu.swan.apps.runtime.d.akJ());
        this.bTX = null;
        this.bTY = new com.baidu.swan.apps.ao.f.b();
        this.bUe = FrameLifeState.INACTIVATED;
        this.bUf = null;
        this.bUg = false;
        this.bUh = false;
        this.bHl = swanAppActivity;
        this.bUd = str;
        this.bUc = new d();
    }

    public final synchronized void a(FrameLifeState frameLifeState, boolean z) {
        boolean z2 = false;
        synchronized (this) {
            if (!this.bHl.isDestroyed()) {
                boolean z3 = (!this.bUe.hasCreated()) | z;
                if (this.bUe.hasCreated() && z3) {
                    z2 = true;
                }
                m(z3, z2);
                d(frameLifeState);
                if (z3 && (z2 || 1 == Ol())) {
                    f.h(Ov());
                }
            }
        }
    }

    public final synchronized void release() {
        d(FrameLifeState.INACTIVATED);
        aat();
    }

    public boolean aal() {
        return this.bUh;
    }

    private synchronized FrameLifeState c(@NonNull FrameLifeState frameLifeState) {
        return (frameLifeState.inactivated() || akG().alh() || !frameLifeState.hasStarted() || frameLifeState.moreInactiveThan(this.bUe)) ? frameLifeState : this.bUe.hasCreated() ? this.bUe : FrameLifeState.JUST_CREATED;
    }

    public final synchronized void d(@NonNull FrameLifeState frameLifeState) {
        synchronized (this) {
            log(" transLifeState: target=" + frameLifeState + " holdon=" + this.bUg + " locked=" + this.bUh + " thread=" + Thread.currentThread());
            if (!this.bUh) {
                this.bUf = frameLifeState;
                this.bUh = FrameLifeState.INACTIVATED == this.bUf;
            }
            if (!this.bUg) {
                this.bUg = true;
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.framework.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.aam();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aam() {
        synchronized (this) {
            this.bUg = true;
            while (this.bUf != null && aaN()) {
                FrameLifeState c = c(this.bUf);
                log("syncLifeState: pendingTarget=" + this.bUf + " fixedTarget=" + c);
                this.bUf = null;
                switch (c) {
                    case JUST_CREATED:
                        aar();
                        aan();
                        break;
                    case JUST_STARTED:
                        aaq();
                        aao();
                        break;
                    case JUST_RESUMED:
                        aap();
                        break;
                    default:
                        aas();
                        break;
                }
            }
            log("syncLifeState: done=" + this.bUe);
            this.bUh = FrameLifeState.INACTIVATED == this.bUf;
            this.bUg = false;
        }
    }

    private synchronized void aan() {
        if (!this.bUe.hasCreated()) {
            aau();
            com.baidu.swan.apps.console.c.d("SwanApp", "onPostCreate: " + this);
            aak();
            this.bUe = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void aao() {
        aan();
        if (!this.bUe.hasStarted()) {
            aav();
            this.bUe = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void aap() {
        aao();
        if (!this.bUe.hasResumed()) {
            aaw();
            this.bUe = FrameLifeState.JUST_RESUMED;
        }
    }

    private synchronized void aaq() {
        if (this.bUe.hasResumed()) {
            aax();
            this.bUe = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void aar() {
        aaq();
        if (this.bUe.hasStarted()) {
            aay();
            this.bUe = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void aas() {
        aar();
        if (this.bUe.hasCreated()) {
            aaz();
            this.bUe = FrameLifeState.INACTIVATED;
        }
    }

    private synchronized void m(boolean z, boolean z2) {
        HybridUbcFlow lb = f.lb("startup");
        lb.f(new UbcFlowEvent("onUpdateInternalStart").ed(true));
        log("onUpdateInternal isLaunch=" + z + " isRelaunch=" + z2);
        if (z) {
            b.a Ov = Ov();
            if (!z2) {
                aaM();
            }
            if (!TextUtils.isEmpty(Ov.adP())) {
                com.baidu.swan.apps.console.debugger.a.e.setWebUrl(Ov.adP());
            }
        }
        com.baidu.swan.apps.y.f aeJ = com.baidu.swan.apps.y.f.aeJ();
        if (!aaN()) {
            aeJ.i(this.bHl);
        }
        lb.f(new UbcFlowEvent("onUpdateStart").ed(true));
        l(z, z2);
        lb.f(new UbcFlowEvent("onUpdateEnd").ed(true));
    }

    private synchronized void aat() {
        log("onReleaseInternal");
        onRelease();
        com.baidu.swan.apps.y.f.release();
    }

    @DebugTrace
    private synchronized void aau() {
        log("onCreateInternal");
        HybridUbcFlow lb = f.lb("startup");
        lb.f(new UbcFlowEvent("frame_start_create"));
        lb.f(new UbcFlowEvent("onCreateInternalStart").ed(true));
        this.bUc.aah();
        com.baidu.swan.apps.console.c.d("SwanApp", "onCreate: " + this);
        if (com.baidu.swan.apps.console.debugger.a.e.TF()) {
            com.baidu.swan.apps.core.k.d.release();
        }
        aaJ();
        com.baidu.swan.apps.runtime.d akJ = com.baidu.swan.apps.runtime.d.akJ();
        if (!akJ.ajq() || !akJ.akG().available()) {
            com.baidu.swan.apps.ap.a nL = new com.baidu.swan.apps.ap.a().bn(5L).bo(11L).nL("aiapp data is invalid");
            com.baidu.swan.apps.ap.e.aov().f(nL);
            com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().mZ(com.baidu.swan.apps.statistic.f.gz(Ol())).e(nL).a(Ov()));
            com.baidu.swan.apps.as.c.P(this.bHl);
        } else {
            com.baidu.swan.apps.runtime.e akG = akJ.akG();
            akG.akW().amh();
            akG.akX().clear();
            aaB();
            lb.f(new UbcFlowEvent("onCreateStart").ed(true));
            onCreate();
            lb.f(new UbcFlowEvent("onCreateEnd").ed(true));
            com.baidu.swan.apps.as.b Ok = this.bHl.Ok();
            if (Ok != null) {
                Ok.aoB();
            }
            lb.f(new UbcFlowEvent("onCreateInternalEnd").ed(true));
        }
    }

    private synchronized void aav() {
        HybridUbcFlow lb = f.lb("startup");
        lb.f(new UbcFlowEvent("onStartStart").ed(true));
        log("onStartInternal");
        this.bUc.aai();
        onStart();
        lb.f(new UbcFlowEvent("onStartEnd").ed(true));
    }

    private synchronized void aaw() {
        HybridUbcFlow lb = f.lb("startup");
        lb.f(new UbcFlowEvent("onResumeInternalStart").ed(true));
        log("onResumeInternal");
        this.bUc.Rz();
        com.baidu.swan.apps.console.c.d("SwanApp", "onResume: " + this);
        this.bUb = com.baidu.swan.apps.statistic.f.mT("607");
        aaI();
        if (ajq()) {
            akG().onActivityResume(this.bHl);
        }
        m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.framework.c.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.network.c.a.ahj().ahl();
                if (c.DEBUG) {
                    Log.e("SwanActivityFrame", "try update on computation thread");
                }
                if (c.this.bHl != null && com.baidu.swan.apps.runtime.e.akM() != null) {
                    com.baidu.swan.apps.database.a.b.b(com.baidu.swan.apps.runtime.e.akM());
                }
            }
        }, "saveSwanAppHistory");
        f.lb("startup").f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
        com.baidu.swan.apps.an.a.amO().mO("na_page_show");
        com.baidu.swan.apps.y.f.aeJ().Qm();
        lb.f(new UbcFlowEvent("onResumeStart").ed(true));
        onResume();
        lb.f(new UbcFlowEvent("onResumeEnd").ed(true));
    }

    private synchronized void aax() {
        log("onPauseInternal");
        onPause();
        com.baidu.swan.apps.y.f.aeJ().Qn();
        this.bUc.SG();
        com.baidu.swan.apps.console.c.d("SwanApp", "onPause: " + this);
        if (this.bUb != null && ajq()) {
            com.baidu.swan.apps.statistic.a.a aVar = new com.baidu.swan.apps.statistic.a.a();
            b.a Ov = Ov();
            aVar.mFrom = com.baidu.swan.apps.statistic.f.gz(Ol());
            aVar.mAppId = Ov.getAppId();
            aVar.mSource = Ov.adA();
            aVar.c(Ov);
            aVar.nd(Ov.adG().getString("ubc"));
            aVar.bl(com.baidu.swan.apps.statistic.f.mU(Ov.adC()));
            com.baidu.swan.apps.statistic.f.a(this.bUb, aVar);
            this.bUb = null;
        }
    }

    private synchronized void aay() {
        log("onStopInternal");
        onStop();
        this.bUc.aaj();
    }

    private synchronized void aaz() {
        log("onDestroyInternal");
        onDestroy();
        this.bUc.Ry();
        com.baidu.swan.apps.console.c.d("SwanApp", "onDestroy: " + this);
        com.baidu.swan.apps.network.c.a.ahj().release();
        com.baidu.swan.apps.performance.b.d.releaseInstance();
        aaC();
        com.baidu.swan.apps.y.f.release();
    }

    public synchronized FrameLifeState aaA() {
        return this.bUe;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.bUc.onKeyDown(i, keyEvent);
    }

    public void aaB() {
        if (this.bTX == null) {
            this.bTX = aaH();
        }
        akF().a((a.c) null, this.bTX);
    }

    public void aaC() {
        akF().aaC();
        this.bTX = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aaD() {
        b.a Ov;
        Bundle adF;
        if (ajq() && (adF = (Ov = Ov()).adF()) != null && adF.getLong("launch_flag_for_statistic") > 0) {
            long j = Ov.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gz(Ol());
            fVar.mAppId = Ov.getAppId();
            if (com.baidu.swan.apps.ah.a.a.lA(Ov().adP())) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = Ov.adA();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.cuD = String.valueOf(currentTimeMillis - j);
            fVar.s("status", "0");
            fVar.nd(Ov.adG().getString("ubc"));
            fVar.bl(com.baidu.swan.apps.statistic.f.mU(Ov.adC()));
            com.baidu.swan.apps.statistic.f.onEvent(fVar);
            adF.remove("launch_flag_for_statistic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aaE() {
        aaF();
        aaG();
    }

    private void aaF() {
        com.baidu.swan.apps.adaptation.a.b PH = akL().OM().PH();
        if (PH != null) {
            PH.aP(this.bHl);
        }
    }

    protected void aaG() {
        com.baidu.swan.apps.runtime.e akM = com.baidu.swan.apps.runtime.e.akM();
        com.baidu.swan.apps.a.b bVar = null;
        if (akM != null) {
            bVar = akM.akX();
        }
        if (bVar != null) {
            bVar.setUid(bVar.getUid(AppRuntime.getAppContext()));
        }
    }

    private void aaI() {
        if (akG().available()) {
            setTaskDescription(this.bHl, Ov().YS(), ai.a((com.baidu.swan.apps.x.b.b) Ov(), "SwanActivityFrame", true), (int) Ov().adz());
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

    private void aaJ() {
        this.bTW = new com.baidu.swan.apps.core.d.e(this.bHl);
        aaK();
    }

    protected void aaK() {
    }

    public com.baidu.swan.apps.core.d.e Ot() {
        return this.bTW;
    }

    public void onTrimMemory(int i) {
        com.baidu.swan.apps.console.c.w("SwanActivityFrame", "onTrimMemory level:" + i);
        Ox().hc(i);
    }

    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aaL() {
        if (this.bTW.Wg() != 1) {
            return false;
        }
        this.bHl.moveTaskToBack(true);
        this.bHl.dW(2);
        return true;
    }

    public b.a Ov() {
        return akG().akP();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (fVar != null && ajq()) {
            b.a Ov = Ov();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gz(Ol());
            fVar.mAppId = Ov.getAppId();
            fVar.mSource = Ov.adA();
            fVar.bl(com.baidu.swan.apps.statistic.f.mU(Ov.adC()));
            if (TextUtils.isEmpty(fVar.mType)) {
                fVar.mType = "click";
            }
            fVar.nd(Ov.adG().getString("ubc"));
            if (TextUtils.equals(fVar.mType, "click")) {
                com.baidu.swan.apps.statistic.b.b(fVar);
            } else {
                com.baidu.swan.apps.statistic.f.onEvent(fVar);
            }
        }
    }

    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.bTZ == null) {
                this.bTZ = new com.baidu.swan.apps.af.c();
            }
            this.bTZ.a(this.bHl, i, strArr, aVar);
        }
    }

    public boolean onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.bTZ != null) {
            this.bTZ.a(this.bHl, i, strArr, iArr);
            return true;
        }
        return false;
    }

    public void showLoadingView() {
        this.bUa = (FrameLayout) this.bHl.findViewById(a.f.ai_apps_activity_root);
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(this.bHl, this.bUa);
    }

    public void Ow() {
        com.baidu.swan.apps.res.widget.loadingview.a.removeLoadingView(this.bUa);
    }

    @NonNull
    public com.baidu.swan.apps.ao.f.b Ox() {
        return this.bTY;
    }

    public boolean isLandScape() {
        return false;
    }

    public void a(b bVar) {
        this.bUc.c(bVar);
    }

    public void b(b bVar) {
        this.bUc.d(bVar);
    }

    public boolean jf(String str) {
        return TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aaM() {
    }

    public void RA() {
        this.bUc.RA();
    }

    public boolean aaN() {
        return com.baidu.swan.apps.y.f.aeJ().aeL();
    }

    private void log(String str) {
        if (DEBUG) {
            Log.i("SwanActivityFrame", str);
        }
    }
}
