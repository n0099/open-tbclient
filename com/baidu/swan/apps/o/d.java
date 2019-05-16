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
    protected com.baidu.swan.apps.v.b.b ajM;
    private FrameLayout ajP;
    private com.baidu.swan.apps.res.widget.floatlayer.a aqH;
    private com.baidu.swan.apps.ab.a awB;
    protected com.baidu.swan.apps.view.b awD;
    private Flow awE;
    private boolean awG;
    protected SwanAppActivity aww;
    protected com.baidu.swan.apps.core.d.e awx;
    private final ActivityResultDispatcher awz;
    protected a.d awy = null;
    private final com.baidu.swan.apps.aj.f.b awA = new com.baidu.swan.apps.aj.f.b();
    private com.baidu.swan.apps.ai.b awC = null;
    private c awF = new c();

    @NonNull
    protected abstract a.d CP();

    public abstract int vc();

    public d(SwanAppActivity swanAppActivity) {
        this.aww = swanAppActivity;
        this.awz = new ActivityResultDispatcher(this.aww, 1);
    }

    @CallSuper
    @DebugTrace
    public void onCreate(Bundle bundle) {
        this.awF.CE();
        com.baidu.swan.apps.console.c.d("SwanApp", "onCreate: " + this);
        parseIntent(getIntent());
        if (com.baidu.swan.apps.console.a.d.xG()) {
            com.baidu.swan.apps.core.j.c.release();
        }
        CT();
        CI();
        com.baidu.swan.apps.ae.b.n(this.ajM);
        if (!com.baidu.swan.apps.ae.b.isDataValid()) {
            com.baidu.swan.apps.ak.a hZ = new com.baidu.swan.apps.ak.a().Y(5L).Z(11L).hZ("aiapp data is invalid");
            com.baidu.swan.apps.ak.e.Ok().b(hZ);
            com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().hp(com.baidu.swan.apps.statistic.e.dM(vc())).a(hZ).s(this.ajM));
            com.baidu.swan.apps.an.b.L(this.aww);
            return;
        }
        CJ();
    }

    public void onPostCreate(Bundle bundle) {
        com.baidu.swan.apps.console.c.d("SwanApp", "onPostCreate: " + this);
        aN(com.baidu.swan.apps.u.a.DW().Ev());
    }

    public boolean f(@NonNull com.baidu.swan.apps.v.b.b bVar) {
        if (this.ajM == null) {
            return false;
        }
        return TextUtils.equals(bVar.getAppId(), this.ajM.getAppId());
    }

    @CallSuper
    public void onNewIntent(Intent intent) {
    }

    public Intent getIntent() {
        if (this.aww != null) {
            return this.aww.getIntent();
        }
        return null;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.awF.onKeyDown(i, keyEvent);
    }

    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.awz;
    }

    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a ve() {
        if (this.aqH == null) {
            this.aqH = new com.baidu.swan.apps.res.widget.floatlayer.a(this.aww, (FrameLayout) this.aww.findViewById(16908290), 0);
        }
        return this.aqH;
    }

    protected void CI() {
    }

    public com.baidu.swan.apps.view.b vf() {
        return this.awD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CJ() {
        if (this.awy == null) {
            this.awy = CP();
        }
        CR().a(CQ(), (a.e) null, this.awy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CK() {
        CR().CK();
        this.awy = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CL() {
        Bundle Fa;
        if (this.ajM != null && (Fa = this.ajM.Fa()) != null && Fa.getLong("launch_flag_for_statistic") > 0) {
            f fVar = new f();
            fVar.mFrom = com.baidu.swan.apps.statistic.e.dM(vc());
            fVar.mAppId = this.ajM.getAppId();
            fVar.mSource = this.ajM.EW();
            fVar.mType = "launch";
            fVar.mValue = "success";
            fVar.k("status", "0");
            fVar.ak(com.baidu.swan.apps.statistic.e.hn(this.ajM.EX()));
            com.baidu.swan.apps.statistic.e.onEvent(fVar);
            Fa.remove("launch_flag_for_statistic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CM() {
        CN();
        CO();
    }

    protected void CN() {
        com.baidu.swan.apps.b.b.a wa = com.baidu.swan.apps.ae.e.LH().aQg.get().vy().wa();
        if (wa != null) {
            wa.aF(this.aww);
        }
    }

    protected void CO() {
        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
        com.baidu.swan.apps.a.b bVar = null;
        if (Lq != null) {
            bVar = Lq.Lv();
        }
        if (bVar != null) {
            bVar.setUid(bVar.aE(AppRuntime.getAppContext()));
        }
    }

    @NonNull
    protected a.g CQ() {
        a.g gVar = new a.g();
        gVar.appId = this.ajM.getAppId();
        SwanAppCores swanAppCores = new SwanAppCores();
        swanAppCores.a(this.ajM.BA());
        swanAppCores.a(this.ajM.BB());
        gVar.aGU = swanAppCores;
        return gVar;
    }

    public void reset() {
        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
        if (Lq != null) {
            Lq.purge();
        }
        com.baidu.swan.apps.ae.b.terminate();
        com.baidu.swan.apps.an.b.L(this.aww);
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
            this.ajM = bVar;
            if (!TextUtils.isEmpty(this.ajM.Fl())) {
                com.baidu.swan.apps.console.a.d.setWebUrl(this.ajM.Fl());
            }
            if (this.ajM.Fa() != null) {
                this.ajM.H(this.ajM.Fa().getLong("aiapp_start_timestamp", -1L));
                if (!com.baidu.swan.apps.performance.f.aFY) {
                    this.ajM.G(this.ajM.Fk());
                }
            }
            com.baidu.swan.apps.performance.f.k(this.ajM);
        }
    }

    public void onResume() {
        this.awF.onActivityResumed();
        com.baidu.swan.apps.console.c.d("SwanApp", "onResume: " + this);
        this.awE = com.baidu.swan.apps.statistic.e.hl("607");
        CS();
        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
        if (Lq != null) {
            Lq.J(this.aww);
        }
        j.b(new Runnable() { // from class: com.baidu.swan.apps.o.d.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.network.c.a.Hi().Hk();
                if (d.DEBUG) {
                    Log.e("SwanAppBaseFrame", "try update on computation thread");
                }
                if (d.this.aww != null && com.baidu.swan.apps.ae.b.Lq() != null) {
                    com.baidu.swan.apps.database.a.b.a(com.baidu.swan.apps.ae.b.Lq());
                }
            }
        }, "saveSwanAppHistory");
        com.baidu.swan.apps.performance.f.fO("startup").f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
        com.baidu.swan.apps.y.f.GN().fz("na_page_show");
    }

    public void onStart() {
        this.awF.CF();
    }

    public void onPause() {
        this.awF.onActivityPaused();
        com.baidu.swan.apps.console.c.d("SwanApp", "onPause: " + this);
        if (this.awE != null) {
            com.baidu.swan.apps.statistic.a.a aVar = new com.baidu.swan.apps.statistic.a.a();
            aVar.mFrom = com.baidu.swan.apps.statistic.e.dM(vc());
            aVar.mAppId = this.ajM.getAppId();
            aVar.mSource = this.ajM.EW();
            aVar.ak(com.baidu.swan.apps.statistic.e.hn(this.ajM.EX()));
            com.baidu.swan.apps.statistic.e.a(this.awE, aVar);
            this.awE = null;
        }
    }

    public void onStop() {
        this.awF.CG();
    }

    public com.baidu.swan.apps.process.messaging.client.a CR() {
        return com.baidu.swan.apps.process.messaging.client.a.IE();
    }

    private void CS() {
        if (this.ajM != null && this.ajM.isValid()) {
            a(this.aww, this.ajM.BM(), ac.a(this.ajM, "SwanAppBaseFrame", true), (int) this.ajM.EV());
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

    private void CT() {
        this.awx = new com.baidu.swan.apps.core.d.e(this.aww);
        CU();
    }

    protected void CU() {
    }

    public com.baidu.swan.apps.core.d.e vi() {
        return this.awx;
    }

    public boolean ue() {
        return false;
    }

    public void onDestroy() {
        this.awF.CH();
        com.baidu.swan.apps.console.c.d("SwanApp", "onDestroy: " + this);
        if (this.awD != null) {
            this.awD.xd();
            this.awD = null;
        }
        com.baidu.swan.apps.network.c.a.Hi().release();
        com.baidu.swan.apps.performance.c.d.releaseInstance();
        CK();
    }

    public void onTrimMemory(int i) {
        com.baidu.swan.apps.console.c.w("SwanAppBaseFrame", "onTrimMemory level:" + i);
        vm().ep(i);
    }

    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean CV() {
        if (this.awx.zN() != 1) {
            return false;
        }
        this.aww.moveTaskToBack(true);
        return true;
    }

    public com.baidu.swan.apps.v.b.b vk() {
        return this.ajM;
    }

    public final void a(f fVar) {
        if (this.ajM != null && fVar != null) {
            fVar.mFrom = com.baidu.swan.apps.statistic.e.dM(vc());
            fVar.mAppId = this.ajM.getAppId();
            fVar.mSource = this.ajM.EW();
            fVar.ak(com.baidu.swan.apps.statistic.e.hn(this.ajM.EX()));
            if (TextUtils.isEmpty(fVar.mType)) {
                fVar.mType = "click";
            }
            com.baidu.swan.apps.statistic.e.onEvent(fVar);
            if (TextUtils.equals(fVar.mType, "click")) {
                com.baidu.swan.apps.statistic.b.b(fVar);
            }
        }
    }

    public void aN(boolean z) {
        g(z, true);
    }

    public void g(boolean z, boolean z2) {
        if (this.aww == null || this.aww.getWindow() == null) {
            if (DEBUG) {
                Log.e("SwanAppBaseFrame", "activity or window is null");
                return;
            }
            return;
        }
        if (this.awC == null) {
            this.awC = new com.baidu.swan.apps.ai.b();
        }
        ViewGroup viewGroup = (ViewGroup) this.aww.getWindow().getDecorView();
        if (z) {
            this.awC.j(viewGroup);
        } else {
            this.awC.k(viewGroup);
        }
        if (z2) {
            com.baidu.swan.apps.process.messaging.client.a.IE().sendMessage(5);
        }
    }

    public void a(int i, @NonNull String[] strArr, a.InterfaceC0109a interfaceC0109a) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.awB == null) {
                this.awB = new com.baidu.swan.apps.ab.a();
            }
            this.awB.a(this.aww, i, strArr, interfaceC0109a);
            if (com.baidu.swan.apps.u.a.DE().vI()) {
                com.baidu.swan.apps.y.f.GN().GT();
            }
        }
    }

    public boolean b(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.awB != null) {
            this.awB.onRequestPermissionsResult(i, strArr, iArr);
            return true;
        }
        return false;
    }

    public void showLoadingView() {
        this.ajP = (FrameLayout) this.aww.findViewById(a.f.ai_apps_activity_root);
        com.baidu.swan.apps.res.widget.loadingview.a.d(this.aww, this.ajP);
    }

    public void vl() {
        com.baidu.swan.apps.res.widget.loadingview.a.i(this.ajP);
    }

    @NonNull
    public com.baidu.swan.apps.aj.f.b vm() {
        return this.awA;
    }

    public boolean isLandScape() {
        return false;
    }

    public void a(b bVar) {
        this.awF.c(bVar);
    }

    public void b(b bVar) {
        this.awF.d(bVar);
    }

    public boolean vn() {
        if (this.awG || !com.baidu.swan.apps.p.a.CZ().b(new WeakReference<>(this.aww))) {
            return false;
        }
        this.awG = true;
        return true;
    }
}
