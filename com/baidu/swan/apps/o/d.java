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
    protected com.baidu.swan.apps.v.b.b ako;
    private FrameLayout akr;
    private com.baidu.swan.apps.res.widget.floatlayer.a ark;
    protected SwanAppActivity axb;
    protected com.baidu.swan.apps.core.d.e axc;
    private final ActivityResultDispatcher axe;
    private com.baidu.swan.apps.ab.a axg;
    protected com.baidu.swan.apps.view.b axi;
    private Flow axj;
    private boolean axl;
    protected a.d axd = null;
    private final com.baidu.swan.apps.aj.f.b axf = new com.baidu.swan.apps.aj.f.b();
    private com.baidu.swan.apps.ai.b axh = null;
    private c axk = new c();

    @NonNull
    protected abstract a.d Dy();

    public abstract int vD();

    public d(SwanAppActivity swanAppActivity) {
        this.axb = swanAppActivity;
        this.axe = new ActivityResultDispatcher(this.axb, 1);
    }

    @CallSuper
    @DebugTrace
    public void onCreate(Bundle bundle) {
        this.axk.Dn();
        com.baidu.swan.apps.console.c.d("SwanApp", "onCreate: " + this);
        parseIntent(getIntent());
        if (com.baidu.swan.apps.console.a.d.yl()) {
            com.baidu.swan.apps.core.j.c.release();
        }
        DC();
        Dr();
        com.baidu.swan.apps.ae.b.n(this.ako);
        if (!com.baidu.swan.apps.ae.b.isDataValid()) {
            com.baidu.swan.apps.ak.a ig = new com.baidu.swan.apps.ak.a().Z(5L).aa(11L).ig("aiapp data is invalid");
            com.baidu.swan.apps.ak.e.OZ().b(ig);
            com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().hv(com.baidu.swan.apps.statistic.e.dP(vD())).a(ig).s(this.ako));
            com.baidu.swan.apps.an.b.O(this.axb);
            return;
        }
        Ds();
    }

    public void onPostCreate(Bundle bundle) {
        com.baidu.swan.apps.console.c.d("SwanApp", "onPostCreate: " + this);
        aQ(com.baidu.swan.apps.u.a.EF().Fe());
    }

    public boolean f(@NonNull com.baidu.swan.apps.v.b.b bVar) {
        if (this.ako == null) {
            return false;
        }
        return TextUtils.equals(bVar.getAppId(), this.ako.getAppId());
    }

    @CallSuper
    public void onNewIntent(Intent intent) {
    }

    public Intent getIntent() {
        if (this.axb != null) {
            return this.axb.getIntent();
        }
        return null;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.axk.onKeyDown(i, keyEvent);
    }

    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.axe;
    }

    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a vF() {
        if (this.ark == null) {
            this.ark = new com.baidu.swan.apps.res.widget.floatlayer.a(this.axb, (FrameLayout) this.axb.findViewById(16908290), 0);
        }
        return this.ark;
    }

    protected void Dr() {
    }

    public com.baidu.swan.apps.view.b vG() {
        return this.axi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ds() {
        if (this.axd == null) {
            this.axd = Dy();
        }
        DA().a(Dz(), (a.e) null, this.axd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Dt() {
        DA().Dt();
        this.axd = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Du() {
        Bundle FK;
        if (this.ako != null && (FK = this.ako.FK()) != null && FK.getLong("launch_flag_for_statistic") > 0) {
            f fVar = new f();
            fVar.mFrom = com.baidu.swan.apps.statistic.e.dP(vD());
            fVar.mAppId = this.ako.getAppId();
            fVar.mSource = this.ako.FG();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.k("status", "0");
            fVar.ak(com.baidu.swan.apps.statistic.e.ht(this.ako.FH()));
            com.baidu.swan.apps.statistic.e.onEvent(fVar);
            FK.remove("launch_flag_for_statistic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Dv() {
        Dw();
        Dx();
    }

    protected void Dw() {
        com.baidu.swan.apps.b.b.a wB = com.baidu.swan.apps.ae.e.Mv().aQQ.get().vZ().wB();
        if (wB != null) {
            wB.aF(this.axb);
        }
    }

    protected void Dx() {
        com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
        com.baidu.swan.apps.a.b bVar = null;
        if (Md != null) {
            bVar = Md.Mi();
        }
        if (bVar != null) {
            bVar.setUid(bVar.aE(AppRuntime.getAppContext()));
        }
    }

    @NonNull
    protected a.g Dz() {
        a.g gVar = new a.g();
        gVar.appId = this.ako.getAppId();
        SwanAppCores swanAppCores = new SwanAppCores();
        swanAppCores.a(this.ako.Ci());
        swanAppCores.a(this.ako.Cj());
        gVar.aHC = swanAppCores;
        return gVar;
    }

    public void reset() {
        com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
        if (Md != null) {
            Md.purge();
        }
        com.baidu.swan.apps.ae.b.terminate();
        com.baidu.swan.apps.an.b.O(this.axb);
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
            this.ako = bVar;
            if (!TextUtils.isEmpty(this.ako.FV())) {
                com.baidu.swan.apps.console.a.d.setWebUrl(this.ako.FV());
            }
            if (this.ako.FK() != null) {
                this.ako.H(this.ako.FK().getLong("aiapp_start_timestamp", -1L));
                if (!com.baidu.swan.apps.performance.f.aGG) {
                    this.ako.G(this.ako.FU());
                }
            }
            com.baidu.swan.apps.performance.f.k(this.ako);
        }
    }

    public void onResume() {
        this.axk.onActivityResumed();
        com.baidu.swan.apps.console.c.d("SwanApp", "onResume: " + this);
        this.axj = com.baidu.swan.apps.statistic.e.hr("607");
        DB();
        com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
        if (Md != null) {
            Md.M(this.axb);
        }
        j.b(new Runnable() { // from class: com.baidu.swan.apps.o.d.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.network.c.a.HT().HV();
                if (d.DEBUG) {
                    Log.e("SwanAppBaseFrame", "try update on computation thread");
                }
                if (d.this.axb != null && com.baidu.swan.apps.ae.b.Md() != null) {
                    com.baidu.swan.apps.database.a.b.a(com.baidu.swan.apps.ae.b.Md());
                }
            }
        }, "saveSwanAppHistory");
        com.baidu.swan.apps.performance.f.fS("startup").f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
        com.baidu.swan.apps.y.f.Hy().fD("na_page_show");
    }

    public void onStart() {
        this.axk.Do();
    }

    public void onPause() {
        this.axk.onActivityPaused();
        com.baidu.swan.apps.console.c.d("SwanApp", "onPause: " + this);
        if (this.axj != null) {
            com.baidu.swan.apps.statistic.a.a aVar = new com.baidu.swan.apps.statistic.a.a();
            aVar.mFrom = com.baidu.swan.apps.statistic.e.dP(vD());
            aVar.mAppId = this.ako.getAppId();
            aVar.mSource = this.ako.FG();
            aVar.ak(com.baidu.swan.apps.statistic.e.ht(this.ako.FH()));
            com.baidu.swan.apps.statistic.e.a(this.axj, aVar);
            this.axj = null;
        }
    }

    public void onStop() {
        this.axk.Dp();
    }

    public com.baidu.swan.apps.process.messaging.client.a DA() {
        return com.baidu.swan.apps.process.messaging.client.a.Jr();
    }

    private void DB() {
        if (this.ako != null && this.ako.isValid()) {
            a(this.axb, this.ako.Cv(), ac.a(this.ako, "SwanAppBaseFrame", true), (int) this.ako.FF());
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

    private void DC() {
        this.axc = new com.baidu.swan.apps.core.d.e(this.axb);
        DD();
    }

    protected void DD() {
    }

    public com.baidu.swan.apps.core.d.e vJ() {
        return this.axc;
    }

    public boolean uE() {
        return false;
    }

    public void onDestroy() {
        this.axk.Dq();
        com.baidu.swan.apps.console.c.d("SwanApp", "onDestroy: " + this);
        if (this.axi != null) {
            this.axi.xE();
            this.axi = null;
        }
        com.baidu.swan.apps.network.c.a.HT().release();
        com.baidu.swan.apps.performance.c.d.releaseInstance();
        Dt();
    }

    public void onTrimMemory(int i) {
        com.baidu.swan.apps.console.c.w("SwanAppBaseFrame", "onTrimMemory level:" + i);
        vN().es(i);
    }

    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean DE() {
        if (this.axc.Au() != 1) {
            return false;
        }
        this.axb.moveTaskToBack(true);
        return true;
    }

    public com.baidu.swan.apps.v.b.b vL() {
        return this.ako;
    }

    public final void a(f fVar) {
        if (this.ako != null && fVar != null) {
            fVar.mFrom = com.baidu.swan.apps.statistic.e.dP(vD());
            fVar.mAppId = this.ako.getAppId();
            fVar.mSource = this.ako.FG();
            fVar.ak(com.baidu.swan.apps.statistic.e.ht(this.ako.FH()));
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
        if (this.axb == null || this.axb.getWindow() == null) {
            if (DEBUG) {
                Log.e("SwanAppBaseFrame", "activity or window is null");
                return;
            }
            return;
        }
        if (this.axh == null) {
            this.axh = new com.baidu.swan.apps.ai.b();
        }
        ViewGroup viewGroup = (ViewGroup) this.axb.getWindow().getDecorView();
        if (z) {
            this.axh.j(viewGroup);
        } else {
            this.axh.k(viewGroup);
        }
        if (z2) {
            com.baidu.swan.apps.process.messaging.client.a.Jr().sendMessage(5);
        }
    }

    public void a(int i, @NonNull String[] strArr, a.InterfaceC0106a interfaceC0106a) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.axg == null) {
                this.axg = new com.baidu.swan.apps.ab.a();
            }
            this.axg.a(this.axb, i, strArr, interfaceC0106a);
            if (com.baidu.swan.apps.u.a.En().wj()) {
                com.baidu.swan.apps.y.f.Hy().HE();
            }
        }
    }

    public boolean b(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.axg != null) {
            this.axg.onRequestPermissionsResult(i, strArr, iArr);
            return true;
        }
        return false;
    }

    public void showLoadingView() {
        this.akr = (FrameLayout) this.axb.findViewById(a.f.ai_apps_activity_root);
        com.baidu.swan.apps.res.widget.loadingview.a.d(this.axb, this.akr);
    }

    public void vM() {
        com.baidu.swan.apps.res.widget.loadingview.a.i(this.akr);
    }

    @NonNull
    public com.baidu.swan.apps.aj.f.b vN() {
        return this.axf;
    }

    public boolean isLandScape() {
        return false;
    }

    public void a(b bVar) {
        this.axk.c(bVar);
    }

    public void b(b bVar) {
        this.axk.d(bVar);
    }

    public boolean vO() {
        if (this.axl || !com.baidu.swan.apps.p.a.DI().b(new WeakReference<>(this.axb))) {
            return false;
        }
        this.axl = true;
        return true;
    }
}
