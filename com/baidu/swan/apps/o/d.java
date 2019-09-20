package com.baidu.swan.apps.o;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ab.a;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.messaging.client.a;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.ubc.Flow;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public abstract class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected com.baidu.swan.apps.v.b.b akM;
    private FrameLayout akP;
    private com.baidu.swan.apps.res.widget.floatlayer.a arI;
    protected com.baidu.swan.apps.core.d.e axA;
    private final ActivityResultDispatcher axC;
    private com.baidu.swan.apps.ab.a axE;
    protected com.baidu.swan.apps.view.b axG;
    private Flow axH;
    private boolean axJ;
    protected SwanAppActivity axz;
    protected a.d axB = null;
    private final com.baidu.swan.apps.aj.f.b axD = new com.baidu.swan.apps.aj.f.b();
    private com.baidu.swan.apps.ai.b axF = null;
    private c axI = new c();

    @NonNull
    protected abstract a.d DC();

    public abstract int vH();

    public d(SwanAppActivity swanAppActivity) {
        this.axz = swanAppActivity;
        this.axC = new ActivityResultDispatcher(this.axz, 1);
    }

    @CallSuper
    @DebugTrace
    public void onCreate(Bundle bundle) {
        this.axI.Dr();
        com.baidu.swan.apps.console.c.d("SwanApp", "onCreate: " + this);
        parseIntent(getIntent());
        if (com.baidu.swan.apps.console.a.d.yp()) {
            com.baidu.swan.apps.core.j.c.release();
        }
        DG();
        Dv();
        com.baidu.swan.apps.ae.b.n(this.akM);
        if (!com.baidu.swan.apps.ae.b.isDataValid()) {
            com.baidu.swan.apps.ak.a ii = new com.baidu.swan.apps.ak.a().Z(5L).aa(11L).ii("aiapp data is invalid");
            com.baidu.swan.apps.ak.e.Pd().b(ii);
            com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().hx(com.baidu.swan.apps.statistic.e.dQ(vH())).a(ii).s(this.akM));
            com.baidu.swan.apps.an.b.O(this.axz);
            return;
        }
        Dw();
    }

    public void onPostCreate(Bundle bundle) {
        com.baidu.swan.apps.console.c.d("SwanApp", "onPostCreate: " + this);
        aQ(com.baidu.swan.apps.u.a.EJ().Fi());
    }

    public boolean f(@NonNull com.baidu.swan.apps.v.b.b bVar) {
        if (this.akM == null) {
            return false;
        }
        return TextUtils.equals(bVar.getAppId(), this.akM.getAppId());
    }

    @CallSuper
    public void onNewIntent(Intent intent) {
    }

    public Intent getIntent() {
        if (this.axz != null) {
            return this.axz.getIntent();
        }
        return null;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.axI.onKeyDown(i, keyEvent);
    }

    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.axC;
    }

    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a vJ() {
        if (this.arI == null) {
            this.arI = new com.baidu.swan.apps.res.widget.floatlayer.a(this.axz, (FrameLayout) this.axz.findViewById(16908290), 0);
        }
        return this.arI;
    }

    protected void Dv() {
    }

    public com.baidu.swan.apps.view.b vK() {
        return this.axG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Dw() {
        if (this.axB == null) {
            this.axB = DC();
        }
        DE().a(DD(), (a.e) null, this.axB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Dx() {
        DE().Dx();
        this.axB = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Dy() {
        Bundle FO;
        if (this.akM != null && (FO = this.akM.FO()) != null && FO.getLong("launch_flag_for_statistic") > 0) {
            f fVar = new f();
            fVar.mFrom = com.baidu.swan.apps.statistic.e.dQ(vH());
            fVar.mAppId = this.akM.getAppId();
            fVar.mSource = this.akM.FK();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.k("status", "0");
            fVar.ak(com.baidu.swan.apps.statistic.e.hv(this.akM.FL()));
            com.baidu.swan.apps.statistic.e.onEvent(fVar);
            FO.remove("launch_flag_for_statistic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Dz() {
        DA();
        DB();
    }

    protected void DA() {
        com.baidu.swan.apps.b.b.a wF = com.baidu.swan.apps.ae.e.Mz().aRo.get().wd().wF();
        if (wF != null) {
            wF.aF(this.axz);
        }
    }

    protected void DB() {
        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
        com.baidu.swan.apps.a.b bVar = null;
        if (Mh != null) {
            bVar = Mh.Mm();
        }
        if (bVar != null) {
            bVar.setUid(bVar.aE(AppRuntime.getAppContext()));
        }
    }

    @NonNull
    protected a.g DD() {
        a.g gVar = new a.g();
        gVar.appId = this.akM.getAppId();
        SwanAppCores swanAppCores = new SwanAppCores();
        swanAppCores.a(this.akM.Cm());
        swanAppCores.a(this.akM.Cn());
        gVar.aIa = swanAppCores;
        return gVar;
    }

    public void reset() {
        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
        if (Mh != null) {
            Mh.purge();
        }
        com.baidu.swan.apps.ae.b.terminate();
        com.baidu.swan.apps.an.b.O(this.axz);
        ac.k(new Runnable() { // from class: com.baidu.swan.apps.o.d.1
            @Override // java.lang.Runnable
            public void run() {
                Process.killProcess(Process.myPid());
            }
        });
    }

    protected void parseIntent(Intent intent) {
        if (intent != null) {
            g(com.baidu.swan.apps.v.b.b.F(intent));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(com.baidu.swan.apps.v.b.b bVar) {
        if (bVar != null) {
            this.akM = bVar;
            if (!TextUtils.isEmpty(this.akM.FZ())) {
                com.baidu.swan.apps.console.a.d.setWebUrl(this.akM.FZ());
            }
            if (this.akM.FO() != null) {
                this.akM.H(this.akM.FO().getLong("aiapp_start_timestamp", -1L));
                if (!com.baidu.swan.apps.performance.f.aHe) {
                    this.akM.G(this.akM.FY());
                }
            }
            com.baidu.swan.apps.performance.f.k(this.akM);
        }
    }

    public void onResume() {
        this.axI.onActivityResumed();
        com.baidu.swan.apps.console.c.d("SwanApp", "onResume: " + this);
        this.axH = com.baidu.swan.apps.statistic.e.ht("607");
        DF();
        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
        if (Mh != null) {
            Mh.M(this.axz);
        }
        j.b(new Runnable() { // from class: com.baidu.swan.apps.o.d.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.network.c.a.HX().HZ();
                if (d.DEBUG) {
                    Log.e("SwanAppBaseFrame", "try update on computation thread");
                }
                if (d.this.axz != null && com.baidu.swan.apps.ae.b.Mh() != null) {
                    com.baidu.swan.apps.database.a.b.a(com.baidu.swan.apps.ae.b.Mh());
                }
            }
        }, "saveSwanAppHistory");
        com.baidu.swan.apps.performance.f.fU("startup").f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
        com.baidu.swan.apps.y.f.HC().fF("na_page_show");
    }

    public void onStart() {
        this.axI.Ds();
    }

    public void onPause() {
        this.axI.onActivityPaused();
        com.baidu.swan.apps.console.c.d("SwanApp", "onPause: " + this);
        if (this.axH != null) {
            com.baidu.swan.apps.statistic.a.a aVar = new com.baidu.swan.apps.statistic.a.a();
            aVar.mFrom = com.baidu.swan.apps.statistic.e.dQ(vH());
            aVar.mAppId = this.akM.getAppId();
            aVar.mSource = this.akM.FK();
            aVar.ak(com.baidu.swan.apps.statistic.e.hv(this.akM.FL()));
            com.baidu.swan.apps.statistic.e.a(this.axH, aVar);
            this.axH = null;
        }
    }

    public void onStop() {
        this.axI.Dt();
    }

    public com.baidu.swan.apps.process.messaging.client.a DE() {
        return com.baidu.swan.apps.process.messaging.client.a.Jv();
    }

    private void DF() {
        if (this.akM != null && this.akM.isValid()) {
            a(this.axz, this.akM.Cz(), ac.a(this.akM, "SwanAppBaseFrame", true), (int) this.akM.FJ());
        }
    }

    public static void a(Activity activity, String str, Bitmap bitmap, int i) {
        if (Color.alpha(i) != 255) {
            i = Color.argb(255, Color.red(i), Color.green(i), Color.blue(i));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setTaskDescription(new ActivityManager.TaskDescription(str, bitmap, i));
        }
    }

    private void DG() {
        this.axA = new com.baidu.swan.apps.core.d.e(this.axz);
        DH();
    }

    protected void DH() {
    }

    public com.baidu.swan.apps.core.d.e vN() {
        return this.axA;
    }

    public boolean uI() {
        return false;
    }

    public void onDestroy() {
        this.axI.Du();
        com.baidu.swan.apps.console.c.d("SwanApp", "onDestroy: " + this);
        if (this.axG != null) {
            this.axG.xI();
            this.axG = null;
        }
        com.baidu.swan.apps.network.c.a.HX().release();
        com.baidu.swan.apps.performance.c.d.releaseInstance();
        Dx();
    }

    public void onTrimMemory(int i) {
        com.baidu.swan.apps.console.c.w("SwanAppBaseFrame", "onTrimMemory level:" + i);
        vR().et(i);
    }

    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean DI() {
        if (this.axA.Ay() != 1) {
            return false;
        }
        this.axz.moveTaskToBack(true);
        return true;
    }

    public com.baidu.swan.apps.v.b.b vP() {
        return this.akM;
    }

    public final void a(f fVar) {
        if (this.akM != null && fVar != null) {
            fVar.mFrom = com.baidu.swan.apps.statistic.e.dQ(vH());
            fVar.mAppId = this.akM.getAppId();
            fVar.mSource = this.akM.FK();
            fVar.ak(com.baidu.swan.apps.statistic.e.hv(this.akM.FL()));
            if (TextUtils.isEmpty(fVar.mType)) {
                fVar.mType = "click";
            }
            com.baidu.swan.apps.statistic.e.onEvent(fVar);
            if (TextUtils.equals(fVar.mType, "click")) {
                com.baidu.swan.apps.statistic.b.b(fVar);
            }
        }
    }

    public void aQ(boolean z) {
        g(z, true);
    }

    public void g(boolean z, boolean z2) {
        if (this.axz == null || this.axz.getWindow() == null) {
            if (DEBUG) {
                Log.e("SwanAppBaseFrame", "activity or window is null");
                return;
            }
            return;
        }
        if (this.axF == null) {
            this.axF = new com.baidu.swan.apps.ai.b();
        }
        ViewGroup viewGroup = (ViewGroup) this.axz.getWindow().getDecorView();
        if (z) {
            this.axF.j(viewGroup);
        } else {
            this.axF.k(viewGroup);
        }
        if (z2) {
            com.baidu.swan.apps.process.messaging.client.a.Jv().sendMessage(5);
        }
    }

    public void a(int i, @NonNull String[] strArr, a.InterfaceC0120a interfaceC0120a) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.axE == null) {
                this.axE = new com.baidu.swan.apps.ab.a();
            }
            this.axE.a(this.axz, i, strArr, interfaceC0120a);
            if (com.baidu.swan.apps.u.a.Er().wn()) {
                com.baidu.swan.apps.y.f.HC().HI();
            }
        }
    }

    public boolean b(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.axE != null) {
            this.axE.onRequestPermissionsResult(i, strArr, iArr);
            return true;
        }
        return false;
    }

    public void showLoadingView() {
        this.akP = (FrameLayout) this.axz.findViewById(a.f.ai_apps_activity_root);
        com.baidu.swan.apps.res.widget.loadingview.a.d(this.axz, this.akP);
    }

    public void vQ() {
        com.baidu.swan.apps.res.widget.loadingview.a.i(this.akP);
    }

    @NonNull
    public com.baidu.swan.apps.aj.f.b vR() {
        return this.axD;
    }

    public boolean isLandScape() {
        return false;
    }

    public void a(b bVar) {
        this.axI.c(bVar);
    }

    public void b(b bVar) {
        this.axI.d(bVar);
    }

    public boolean vS() {
        if (this.axJ || !com.baidu.swan.apps.p.a.DM().b(new WeakReference<>(this.axz))) {
            return false;
        }
        this.axJ = true;
        return true;
    }
}
