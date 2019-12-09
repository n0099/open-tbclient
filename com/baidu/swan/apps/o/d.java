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
    protected com.baidu.swan.apps.v.b.b aDQ;
    private FrameLayout aDT;
    private com.baidu.swan.apps.res.widget.floatlayer.a aKH;
    private com.baidu.swan.apps.ab.a aQB;
    protected com.baidu.swan.apps.view.b aQD;
    private Flow aQE;
    private boolean aQG;
    protected SwanAppActivity aQw;
    protected com.baidu.swan.apps.core.d.e aQx;
    private final ActivityResultDispatcher aQz;
    protected a.d aQy = null;
    private final com.baidu.swan.apps.aj.f.b aQA = new com.baidu.swan.apps.aj.f.b();
    private com.baidu.swan.apps.ai.b aQC = null;
    private c aQF = new c();

    public abstract int AC();

    @NonNull
    protected abstract a.d Ix();

    public d(SwanAppActivity swanAppActivity) {
        this.aQw = swanAppActivity;
        this.aQz = new ActivityResultDispatcher(this.aQw, 1);
    }

    @CallSuper
    @DebugTrace
    public void onCreate(Bundle bundle) {
        this.aQF.Im();
        com.baidu.swan.apps.console.c.d("SwanApp", "onCreate: " + this);
        C(getIntent());
        if (com.baidu.swan.apps.console.a.d.Dl()) {
            com.baidu.swan.apps.core.j.c.release();
        }
        IB();
        Iq();
        com.baidu.swan.apps.ae.b.n(this.aDQ);
        if (!com.baidu.swan.apps.ae.b.isDataValid()) {
            com.baidu.swan.apps.ak.a iL = new com.baidu.swan.apps.ak.a().ar(5L).as(11L).iL("aiapp data is invalid");
            com.baidu.swan.apps.ak.e.TR().b(iL);
            com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().ia(com.baidu.swan.apps.statistic.e.eL(AC())).a(iL).s(this.aDQ));
            com.baidu.swan.apps.an.b.N(this.aQw);
            return;
        }
        Ir();
    }

    public void onPostCreate(Bundle bundle) {
        com.baidu.swan.apps.console.c.d("SwanApp", "onPostCreate: " + this);
        bi(com.baidu.swan.apps.u.a.JE().Kd());
    }

    public boolean f(@NonNull com.baidu.swan.apps.v.b.b bVar) {
        if (this.aDQ == null) {
            return false;
        }
        return TextUtils.equals(bVar.getAppId(), this.aDQ.getAppId());
    }

    @CallSuper
    public void onNewIntent(Intent intent) {
    }

    public Intent getIntent() {
        if (this.aQw != null) {
            return this.aQw.getIntent();
        }
        return null;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.aQF.onKeyDown(i, keyEvent);
    }

    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.aQz;
    }

    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a AE() {
        if (this.aKH == null) {
            this.aKH = new com.baidu.swan.apps.res.widget.floatlayer.a(this.aQw, (FrameLayout) this.aQw.findViewById(16908290), 0);
        }
        return this.aKH;
    }

    protected void Iq() {
    }

    public com.baidu.swan.apps.view.b AF() {
        return this.aQD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ir() {
        if (this.aQy == null) {
            this.aQy = Ix();
        }
        Iz().a(Iy(), (a.e) null, this.aQy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Is() {
        Iz().Is();
        this.aQy = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void It() {
        Bundle KJ;
        if (this.aDQ != null && (KJ = this.aDQ.KJ()) != null && KJ.getLong("launch_flag_for_statistic") > 0) {
            f fVar = new f();
            fVar.mFrom = com.baidu.swan.apps.statistic.e.eL(AC());
            fVar.mAppId = this.aDQ.getAppId();
            fVar.mSource = this.aDQ.KF();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.h("status", "0");
            fVar.aJ(com.baidu.swan.apps.statistic.e.hY(this.aDQ.KG()));
            com.baidu.swan.apps.statistic.e.onEvent(fVar);
            KJ.remove("launch_flag_for_statistic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Iu() {
        Iv();
        Iw();
    }

    protected void Iv() {
        com.baidu.swan.apps.b.b.a BA = com.baidu.swan.apps.ae.e.Rt().bka.get().AY().BA();
        if (BA != null) {
            BA.aH(this.aQw);
        }
    }

    protected void Iw() {
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        com.baidu.swan.apps.a.b bVar = null;
        if (Ra != null) {
            bVar = Ra.Rg();
        }
        if (bVar != null) {
            bVar.setUid(bVar.getUid(AppRuntime.getAppContext()));
        }
    }

    @NonNull
    protected a.g Iy() {
        a.g gVar = new a.g();
        gVar.appId = this.aDQ.getAppId();
        SwanAppCores swanAppCores = new SwanAppCores();
        swanAppCores.a(this.aDQ.Hh());
        swanAppCores.a(this.aDQ.Hi());
        gVar.baW = swanAppCores;
        return gVar;
    }

    public void reset() {
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        if (Ra != null) {
            Ra.Rb();
        }
        com.baidu.swan.apps.ae.b.terminate();
        com.baidu.swan.apps.an.b.N(this.aQw);
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
            this.aDQ = bVar;
            if (!TextUtils.isEmpty(this.aDQ.KU())) {
                com.baidu.swan.apps.console.a.d.setWebUrl(this.aDQ.KU());
            }
            if (this.aDQ.KJ() != null) {
                this.aDQ.Z(this.aDQ.KJ().getLong("aiapp_start_timestamp", -1L));
                if (!com.baidu.swan.apps.performance.f.bab) {
                    this.aDQ.Y(this.aDQ.KT());
                }
            }
            com.baidu.swan.apps.performance.f.k(this.aDQ);
        }
    }

    public void onResume() {
        this.aQF.onActivityResumed();
        com.baidu.swan.apps.console.c.d("SwanApp", "onResume: " + this);
        this.aQE = com.baidu.swan.apps.statistic.e.hW("607");
        IA();
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        if (Ra != null) {
            Ra.L(this.aQw);
        }
        j.b(new Runnable() { // from class: com.baidu.swan.apps.o.d.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.network.c.a.MS().MU();
                if (d.DEBUG) {
                    Log.e("SwanAppBaseFrame", "try update on computation thread");
                }
                if (d.this.aQw != null && com.baidu.swan.apps.ae.b.Ra() != null) {
                    com.baidu.swan.apps.database.a.b.a(com.baidu.swan.apps.ae.b.Ra());
                }
            }
        }, "saveSwanAppHistory");
        com.baidu.swan.apps.performance.f.gz("startup").f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
        com.baidu.swan.apps.y.f.Mx().gj("na_page_show");
    }

    public void onStart() {
        this.aQF.In();
    }

    public void onPause() {
        this.aQF.onActivityPaused();
        com.baidu.swan.apps.console.c.d("SwanApp", "onPause: " + this);
        if (this.aQE != null) {
            com.baidu.swan.apps.statistic.a.a aVar = new com.baidu.swan.apps.statistic.a.a();
            aVar.mFrom = com.baidu.swan.apps.statistic.e.eL(AC());
            aVar.mAppId = this.aDQ.getAppId();
            aVar.mSource = this.aDQ.KF();
            aVar.aJ(com.baidu.swan.apps.statistic.e.hY(this.aDQ.KG()));
            com.baidu.swan.apps.statistic.e.a(this.aQE, aVar);
            this.aQE = null;
        }
    }

    public void onStop() {
        this.aQF.Io();
    }

    public com.baidu.swan.apps.process.messaging.client.a Iz() {
        return com.baidu.swan.apps.process.messaging.client.a.Oq();
    }

    private void IA() {
        if (this.aDQ != null && this.aDQ.isValid()) {
            a(this.aQw, this.aDQ.Hu(), ac.a(this.aDQ, "SwanAppBaseFrame", true), (int) this.aDQ.KE());
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

    private void IB() {
        this.aQx = new com.baidu.swan.apps.core.d.e(this.aQw);
        IC();
    }

    protected void IC() {
    }

    public com.baidu.swan.apps.core.d.e AI() {
        return this.aQx;
    }

    public boolean zD() {
        return false;
    }

    public void onDestroy() {
        this.aQF.Ip();
        com.baidu.swan.apps.console.c.d("SwanApp", "onDestroy: " + this);
        if (this.aQD != null) {
            this.aQD.CD();
            this.aQD = null;
        }
        com.baidu.swan.apps.network.c.a.MS().release();
        com.baidu.swan.apps.performance.c.d.releaseInstance();
        Is();
    }

    public void onTrimMemory(int i) {
        com.baidu.swan.apps.console.c.w("SwanAppBaseFrame", "onTrimMemory level:" + i);
        AM().fn(i);
    }

    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ID() {
        if (this.aQx.Fu() != 1) {
            return false;
        }
        this.aQw.moveTaskToBack(true);
        return true;
    }

    public com.baidu.swan.apps.v.b.b AK() {
        return this.aDQ;
    }

    public final void a(f fVar) {
        if (this.aDQ != null && fVar != null) {
            fVar.mFrom = com.baidu.swan.apps.statistic.e.eL(AC());
            fVar.mAppId = this.aDQ.getAppId();
            fVar.mSource = this.aDQ.KF();
            fVar.aJ(com.baidu.swan.apps.statistic.e.hY(this.aDQ.KG()));
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
        if (this.aQw == null || this.aQw.getWindow() == null) {
            if (DEBUG) {
                Log.e("SwanAppBaseFrame", "activity or window is null");
                return;
            }
            return;
        }
        if (this.aQC == null) {
            this.aQC = new com.baidu.swan.apps.ai.b();
        }
        ViewGroup viewGroup = (ViewGroup) this.aQw.getWindow().getDecorView();
        if (z) {
            this.aQC.m(viewGroup);
        } else {
            this.aQC.n(viewGroup);
        }
        if (z2) {
            com.baidu.swan.apps.process.messaging.client.a.Oq().sendMessage(5);
        }
    }

    public void a(int i, @NonNull String[] strArr, a.InterfaceC0147a interfaceC0147a) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.aQB == null) {
                this.aQB = new com.baidu.swan.apps.ab.a();
            }
            this.aQB.a(this.aQw, i, strArr, interfaceC0147a);
            if (com.baidu.swan.apps.u.a.Jm().Bi()) {
                com.baidu.swan.apps.y.f.Mx().MD();
            }
        }
    }

    public boolean b(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.aQB != null) {
            this.aQB.onRequestPermissionsResult(i, strArr, iArr);
            return true;
        }
        return false;
    }

    public void showLoadingView() {
        this.aDT = (FrameLayout) this.aQw.findViewById(a.f.ai_apps_activity_root);
        com.baidu.swan.apps.res.widget.loadingview.a.d(this.aQw, this.aDT);
    }

    public void AL() {
        com.baidu.swan.apps.res.widget.loadingview.a.l(this.aDT);
    }

    @NonNull
    public com.baidu.swan.apps.aj.f.b AM() {
        return this.aQA;
    }

    public boolean isLandScape() {
        return false;
    }

    public void a(b bVar) {
        this.aQF.c(bVar);
    }

    public void b(b bVar) {
        this.aQF.d(bVar);
    }

    public boolean AN() {
        if (this.aQG || !com.baidu.swan.apps.p.a.IH().b(new WeakReference<>(this.aQw))) {
            return false;
        }
        this.aQG = true;
        return true;
    }
}
