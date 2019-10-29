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
    protected com.baidu.swan.apps.v.b.b aEi;
    private FrameLayout aEl;
    private com.baidu.swan.apps.res.widget.floatlayer.a aKZ;
    protected SwanAppActivity aQO;
    protected com.baidu.swan.apps.core.d.e aQP;
    private final ActivityResultDispatcher aQR;
    private com.baidu.swan.apps.ab.a aQT;
    protected com.baidu.swan.apps.view.b aQV;
    private Flow aQW;
    private boolean aQY;
    protected a.d aQQ = null;
    private final com.baidu.swan.apps.aj.f.b aQS = new com.baidu.swan.apps.aj.f.b();
    private com.baidu.swan.apps.ai.b aQU = null;
    private c aQX = new c();

    public abstract int AB();

    @NonNull
    protected abstract a.d Iw();

    public d(SwanAppActivity swanAppActivity) {
        this.aQO = swanAppActivity;
        this.aQR = new ActivityResultDispatcher(this.aQO, 1);
    }

    @CallSuper
    @DebugTrace
    public void onCreate(Bundle bundle) {
        this.aQX.Il();
        com.baidu.swan.apps.console.c.d("SwanApp", "onCreate: " + this);
        C(getIntent());
        if (com.baidu.swan.apps.console.a.d.Dk()) {
            com.baidu.swan.apps.core.j.c.release();
        }
        IA();
        Ip();
        com.baidu.swan.apps.ae.b.n(this.aEi);
        if (!com.baidu.swan.apps.ae.b.isDataValid()) {
            com.baidu.swan.apps.ak.a iL = new com.baidu.swan.apps.ak.a().as(5L).at(11L).iL("aiapp data is invalid");
            com.baidu.swan.apps.ak.e.TT().b(iL);
            com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().ia(com.baidu.swan.apps.statistic.e.eL(AB())).a(iL).s(this.aEi));
            com.baidu.swan.apps.an.b.N(this.aQO);
            return;
        }
        Iq();
    }

    public void onPostCreate(Bundle bundle) {
        com.baidu.swan.apps.console.c.d("SwanApp", "onPostCreate: " + this);
        bi(com.baidu.swan.apps.u.a.JD().Kc());
    }

    public boolean f(@NonNull com.baidu.swan.apps.v.b.b bVar) {
        if (this.aEi == null) {
            return false;
        }
        return TextUtils.equals(bVar.getAppId(), this.aEi.getAppId());
    }

    @CallSuper
    public void onNewIntent(Intent intent) {
    }

    public Intent getIntent() {
        if (this.aQO != null) {
            return this.aQO.getIntent();
        }
        return null;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.aQX.onKeyDown(i, keyEvent);
    }

    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.aQR;
    }

    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a AD() {
        if (this.aKZ == null) {
            this.aKZ = new com.baidu.swan.apps.res.widget.floatlayer.a(this.aQO, (FrameLayout) this.aQO.findViewById(16908290), 0);
        }
        return this.aKZ;
    }

    protected void Ip() {
    }

    public com.baidu.swan.apps.view.b AE() {
        return this.aQV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Iq() {
        if (this.aQQ == null) {
            this.aQQ = Iw();
        }
        Iy().a(Ix(), (a.e) null, this.aQQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ir() {
        Iy().Ir();
        this.aQQ = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Is() {
        Bundle KI;
        if (this.aEi != null && (KI = this.aEi.KI()) != null && KI.getLong("launch_flag_for_statistic") > 0) {
            f fVar = new f();
            fVar.mFrom = com.baidu.swan.apps.statistic.e.eL(AB());
            fVar.mAppId = this.aEi.getAppId();
            fVar.mSource = this.aEi.KE();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.h("status", "0");
            fVar.aI(com.baidu.swan.apps.statistic.e.hY(this.aEi.KF()));
            com.baidu.swan.apps.statistic.e.onEvent(fVar);
            KI.remove("launch_flag_for_statistic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void It() {
        Iu();
        Iv();
    }

    protected void Iu() {
        com.baidu.swan.apps.b.b.a Bz = com.baidu.swan.apps.ae.e.Rr().bks.get().AX().Bz();
        if (Bz != null) {
            Bz.aH(this.aQO);
        }
    }

    protected void Iv() {
        com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
        com.baidu.swan.apps.a.b bVar = null;
        if (QZ != null) {
            bVar = QZ.Re();
        }
        if (bVar != null) {
            bVar.setUid(bVar.getUid(AppRuntime.getAppContext()));
        }
    }

    @NonNull
    protected a.g Ix() {
        a.g gVar = new a.g();
        gVar.appId = this.aEi.getAppId();
        SwanAppCores swanAppCores = new SwanAppCores();
        swanAppCores.a(this.aEi.Hg());
        swanAppCores.a(this.aEi.Hh());
        gVar.bbo = swanAppCores;
        return gVar;
    }

    public void reset() {
        com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
        if (QZ != null) {
            QZ.purge();
        }
        com.baidu.swan.apps.ae.b.terminate();
        com.baidu.swan.apps.an.b.N(this.aQO);
        ac.i(new Runnable() { // from class: com.baidu.swan.apps.o.d.1
            @Override // java.lang.Runnable
            public void run() {
                Process.killProcess(Process.myPid());
            }
        });
    }

    protected void C(Intent intent) {
        if (intent != null) {
            g(com.baidu.swan.apps.v.b.b.L(intent));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(com.baidu.swan.apps.v.b.b bVar) {
        if (bVar != null) {
            this.aEi = bVar;
            if (!TextUtils.isEmpty(this.aEi.KT())) {
                com.baidu.swan.apps.console.a.d.setWebUrl(this.aEi.KT());
            }
            if (this.aEi.KI() != null) {
                this.aEi.aa(this.aEi.KI().getLong("aiapp_start_timestamp", -1L));
                if (!com.baidu.swan.apps.performance.f.bat) {
                    this.aEi.Z(this.aEi.KS());
                }
            }
            com.baidu.swan.apps.performance.f.k(this.aEi);
        }
    }

    public void onResume() {
        this.aQX.onActivityResumed();
        com.baidu.swan.apps.console.c.d("SwanApp", "onResume: " + this);
        this.aQW = com.baidu.swan.apps.statistic.e.hW("607");
        Iz();
        com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
        if (QZ != null) {
            QZ.L(this.aQO);
        }
        j.b(new Runnable() { // from class: com.baidu.swan.apps.o.d.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.network.c.a.MR().MT();
                if (d.DEBUG) {
                    Log.e("SwanAppBaseFrame", "try update on computation thread");
                }
                if (d.this.aQO != null && com.baidu.swan.apps.ae.b.QZ() != null) {
                    com.baidu.swan.apps.database.a.b.a(com.baidu.swan.apps.ae.b.QZ());
                }
            }
        }, "saveSwanAppHistory");
        com.baidu.swan.apps.performance.f.gz("startup").f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
        com.baidu.swan.apps.y.f.Mw().gj("na_page_show");
    }

    public void onStart() {
        this.aQX.Im();
    }

    public void onPause() {
        this.aQX.onActivityPaused();
        com.baidu.swan.apps.console.c.d("SwanApp", "onPause: " + this);
        if (this.aQW != null) {
            com.baidu.swan.apps.statistic.a.a aVar = new com.baidu.swan.apps.statistic.a.a();
            aVar.mFrom = com.baidu.swan.apps.statistic.e.eL(AB());
            aVar.mAppId = this.aEi.getAppId();
            aVar.mSource = this.aEi.KE();
            aVar.aI(com.baidu.swan.apps.statistic.e.hY(this.aEi.KF()));
            com.baidu.swan.apps.statistic.e.a(this.aQW, aVar);
            this.aQW = null;
        }
    }

    public void onStop() {
        this.aQX.In();
    }

    public com.baidu.swan.apps.process.messaging.client.a Iy() {
        return com.baidu.swan.apps.process.messaging.client.a.Op();
    }

    private void Iz() {
        if (this.aEi != null && this.aEi.isValid()) {
            a(this.aQO, this.aEi.Ht(), ac.a(this.aEi, "SwanAppBaseFrame", true), (int) this.aEi.KD());
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

    private void IA() {
        this.aQP = new com.baidu.swan.apps.core.d.e(this.aQO);
        IB();
    }

    protected void IB() {
    }

    public com.baidu.swan.apps.core.d.e AH() {
        return this.aQP;
    }

    public boolean zC() {
        return false;
    }

    public void onDestroy() {
        this.aQX.Io();
        com.baidu.swan.apps.console.c.d("SwanApp", "onDestroy: " + this);
        if (this.aQV != null) {
            this.aQV.CC();
            this.aQV = null;
        }
        com.baidu.swan.apps.network.c.a.MR().release();
        com.baidu.swan.apps.performance.c.d.releaseInstance();
        Ir();
    }

    public void onTrimMemory(int i) {
        com.baidu.swan.apps.console.c.w("SwanAppBaseFrame", "onTrimMemory level:" + i);
        AL().fo(i);
    }

    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean IC() {
        if (this.aQP.Ft() != 1) {
            return false;
        }
        this.aQO.moveTaskToBack(true);
        return true;
    }

    public com.baidu.swan.apps.v.b.b AJ() {
        return this.aEi;
    }

    public final void a(f fVar) {
        if (this.aEi != null && fVar != null) {
            fVar.mFrom = com.baidu.swan.apps.statistic.e.eL(AB());
            fVar.mAppId = this.aEi.getAppId();
            fVar.mSource = this.aEi.KE();
            fVar.aI(com.baidu.swan.apps.statistic.e.hY(this.aEi.KF()));
            if (TextUtils.isEmpty(fVar.mType)) {
                fVar.mType = "click";
            }
            com.baidu.swan.apps.statistic.e.onEvent(fVar);
            if (TextUtils.equals(fVar.mType, "click")) {
                com.baidu.swan.apps.statistic.b.b(fVar);
            }
        }
    }

    public void bi(boolean z) {
        k(z, true);
    }

    public void k(boolean z, boolean z2) {
        if (this.aQO == null || this.aQO.getWindow() == null) {
            if (DEBUG) {
                Log.e("SwanAppBaseFrame", "activity or window is null");
                return;
            }
            return;
        }
        if (this.aQU == null) {
            this.aQU = new com.baidu.swan.apps.ai.b();
        }
        ViewGroup viewGroup = (ViewGroup) this.aQO.getWindow().getDecorView();
        if (z) {
            this.aQU.m(viewGroup);
        } else {
            this.aQU.n(viewGroup);
        }
        if (z2) {
            com.baidu.swan.apps.process.messaging.client.a.Op().sendMessage(5);
        }
    }

    public void a(int i, @NonNull String[] strArr, a.InterfaceC0152a interfaceC0152a) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.aQT == null) {
                this.aQT = new com.baidu.swan.apps.ab.a();
            }
            this.aQT.a(this.aQO, i, strArr, interfaceC0152a);
            if (com.baidu.swan.apps.u.a.Jl().Bh()) {
                com.baidu.swan.apps.y.f.Mw().MC();
            }
        }
    }

    public boolean b(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.aQT != null) {
            this.aQT.onRequestPermissionsResult(i, strArr, iArr);
            return true;
        }
        return false;
    }

    public void showLoadingView() {
        this.aEl = (FrameLayout) this.aQO.findViewById(a.f.ai_apps_activity_root);
        com.baidu.swan.apps.res.widget.loadingview.a.d(this.aQO, this.aEl);
    }

    public void AK() {
        com.baidu.swan.apps.res.widget.loadingview.a.l(this.aEl);
    }

    @NonNull
    public com.baidu.swan.apps.aj.f.b AL() {
        return this.aQS;
    }

    public boolean isLandScape() {
        return false;
    }

    public void a(b bVar) {
        this.aQX.c(bVar);
    }

    public void b(b bVar) {
        this.aQX.d(bVar);
    }

    public boolean AM() {
        if (this.aQY || !com.baidu.swan.apps.p.a.IG().b(new WeakReference<>(this.aQO))) {
            return false;
        }
        this.aQY = true;
        return true;
    }
}
