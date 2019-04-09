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
import com.baidu.swan.apps.an.aa;
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
    private FrameLayout ajB;
    protected com.baidu.swan.apps.v.b.b ajy;
    private com.baidu.swan.apps.res.widget.floatlayer.a aqC;
    protected SwanAppActivity avZ;
    protected com.baidu.swan.apps.core.c.e awa;
    private final ActivityResultDispatcher awc;
    protected com.baidu.swan.apps.ab.a awe;
    protected com.baidu.swan.apps.view.b awg;
    private Flow awh;
    private boolean awj;
    protected a.d awb = null;
    private final com.baidu.swan.apps.aj.e.b awd = new com.baidu.swan.apps.aj.e.b();
    private com.baidu.swan.apps.ai.b awf = null;
    private c awi = new c();

    @NonNull
    protected abstract a.d BN();

    public abstract int us();

    public d(SwanAppActivity swanAppActivity) {
        this.avZ = swanAppActivity;
        this.awc = new ActivityResultDispatcher(this.avZ, 1);
    }

    @CallSuper
    @DebugTrace
    public void onCreate(Bundle bundle) {
        this.awi.BC();
        com.baidu.swan.apps.console.c.d("SwanApp", "onCreate: " + this);
        parseIntent(getIntent());
        if (com.baidu.swan.apps.console.a.d.wO()) {
            com.baidu.swan.apps.core.i.c.release();
        }
        BR();
        BG();
        com.baidu.swan.apps.ae.b.n(this.ajy);
        if (!com.baidu.swan.apps.ae.b.isDataValid()) {
            com.baidu.swan.apps.ak.a hx = new com.baidu.swan.apps.ak.a().L(5L).M(11L).hx("aiapp data is invalid");
            com.baidu.swan.apps.ak.e.LE().b(hx);
            com.baidu.swan.apps.statistic.c.a(new com.baidu.swan.apps.statistic.a.d().gS(com.baidu.swan.apps.statistic.c.dB(us())).a(hx).r(this.ajy));
            com.baidu.swan.apps.an.b.K(this.avZ);
            return;
        }
        BH();
    }

    public void onPostCreate(Bundle bundle) {
        com.baidu.swan.apps.console.c.d("SwanApp", "onPostCreate: " + this);
        aK(com.baidu.swan.apps.u.a.CR().Dq());
    }

    public boolean f(@NonNull com.baidu.swan.apps.v.b.b bVar) {
        if (this.ajy == null) {
            return false;
        }
        return TextUtils.equals(bVar.mAppId, this.ajy.mAppId);
    }

    @CallSuper
    public void onNewIntent(Intent intent) {
    }

    public Intent getIntent() {
        if (this.avZ != null) {
            return this.avZ.getIntent();
        }
        return null;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.awi.onKeyDown(i, keyEvent);
    }

    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.awc;
    }

    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a uu() {
        if (this.aqC == null) {
            this.aqC = new com.baidu.swan.apps.res.widget.floatlayer.a(this.avZ, (FrameLayout) this.avZ.findViewById(16908290), 0);
        }
        return this.aqC;
    }

    protected void BG() {
    }

    public com.baidu.swan.apps.view.b uv() {
        return this.awg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BH() {
        if (this.awb == null) {
            this.awb = BN();
        }
        BP().a(BO(), (a.e) null, this.awb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BI() {
        BP().BI();
        this.awb = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BJ() {
        Bundle bundle;
        if (this.ajy != null && (bundle = this.ajy.axU) != null && bundle.getLong("launch_flag_for_statistic") > 0) {
            f fVar = new f();
            fVar.mFrom = com.baidu.swan.apps.statistic.c.dB(us());
            fVar.mAppId = this.ajy.mAppId;
            fVar.mSource = this.ajy.axK;
            fVar.mType = "launch";
            fVar.mValue = "success";
            com.baidu.swan.apps.statistic.c.onEvent(fVar);
            bundle.remove("launch_flag_for_statistic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BK() {
        BL();
        BM();
    }

    protected void BL() {
        com.baidu.swan.apps.b.b.a uT = com.baidu.swan.apps.ae.e.Jm().aOd.get().uO().uT();
        if (uT != null) {
            uT.bm(this.avZ);
        }
    }

    protected void BM() {
        com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
        com.baidu.swan.apps.a.b bVar = null;
        if (IV != null) {
            bVar = IV.Ja();
        }
        if (bVar != null) {
            bVar.setUid(bVar.bl(AppRuntime.getAppContext()));
        }
    }

    @NonNull
    protected a.g BO() {
        a.g gVar = new a.g();
        gVar.appId = this.ajy.mAppId;
        SwanAppCores swanAppCores = new SwanAppCores();
        swanAppCores.a(this.ajy.atv);
        swanAppCores.a(this.ajy.atw);
        gVar.aFb = swanAppCores;
        return gVar;
    }

    public void reset() {
        com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
        if (IV != null) {
            IV.purge();
        }
        com.baidu.swan.apps.ae.b.terminate();
        com.baidu.swan.apps.an.b.K(this.avZ);
        aa.j(new Runnable() { // from class: com.baidu.swan.apps.o.d.1
            @Override // java.lang.Runnable
            public void run() {
                Process.killProcess(Process.myPid());
            }
        });
    }

    protected void parseIntent(Intent intent) {
        if (intent != null) {
            g(com.baidu.swan.apps.v.b.b.G(intent));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(com.baidu.swan.apps.v.b.b bVar) {
        if (bVar != null) {
            this.ajy = bVar;
            if (!TextUtils.isEmpty(this.ajy.ayg)) {
                com.baidu.swan.apps.console.a.d.setWebUrl(this.ajy.ayg);
            }
            if (this.ajy.axU != null) {
                this.ajy.ayf = this.ajy.axU.getLong("aiapp_start_timestamp", -1L);
                if (!com.baidu.swan.apps.performance.f.aEg) {
                    this.ajy.aye = this.ajy.ayf;
                }
            }
            com.baidu.swan.apps.performance.f.k(this.ajy);
        }
    }

    public void onResume() {
        this.awi.onActivityResumed();
        com.baidu.swan.apps.console.c.d("SwanApp", "onResume: " + this);
        this.awh = com.baidu.swan.apps.statistic.c.gQ("607");
        BQ();
        com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
        if (IV != null) {
            IV.I(this.avZ);
        }
        j.b(new Runnable() { // from class: com.baidu.swan.apps.o.d.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.network.c.a.Fd().Ff();
                if (d.DEBUG) {
                    Log.e("SwanAppBaseFrame", "try update on computation thread");
                }
                if (d.this.avZ != null && com.baidu.swan.apps.ae.b.IV() != null) {
                    com.baidu.swan.apps.database.a.b.a(com.baidu.swan.apps.ae.b.IV());
                }
            }
        }, "saveSwanAppHistory");
        com.baidu.swan.apps.performance.f.fz("startup").f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
        com.baidu.swan.apps.y.f.EP().fm("na_page_show");
    }

    public void onStart() {
        this.awi.BD();
    }

    public void onPause() {
        this.awi.onActivityPaused();
        com.baidu.swan.apps.console.c.d("SwanApp", "onPause: " + this);
        if (this.awh != null) {
            com.baidu.swan.apps.statistic.a.a aVar = new com.baidu.swan.apps.statistic.a.a();
            aVar.mFrom = com.baidu.swan.apps.statistic.c.dB(us());
            aVar.mAppId = this.ajy.mAppId;
            aVar.mSource = this.ajy.axK;
            aVar.ai(com.baidu.swan.apps.statistic.c.Kr());
            com.baidu.swan.apps.statistic.c.a(this.awh, aVar);
            this.awh = null;
        }
    }

    public void onStop() {
        this.awi.BE();
    }

    public com.baidu.swan.apps.process.messaging.client.a BP() {
        return com.baidu.swan.apps.process.messaging.client.a.Go();
    }

    private void BQ() {
        if (this.ajy != null && this.ajy.isValid()) {
            a(this.avZ, this.ajy.axH, aa.a(this.ajy, "SwanAppBaseFrame", true), (int) this.ajy.axJ);
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

    private void BR() {
        this.awa = new com.baidu.swan.apps.core.c.e(this.avZ);
        BS();
    }

    protected void BS() {
    }

    public com.baidu.swan.apps.core.c.e uy() {
        return this.awa;
    }

    public boolean tt() {
        return false;
    }

    public void onDestroy() {
        this.awi.BF();
        com.baidu.swan.apps.console.c.d("SwanApp", "onDestroy: " + this);
        if (this.awg != null) {
            this.awg.wl();
            this.awg = null;
        }
        com.baidu.swan.apps.network.c.a.Fd().release();
        com.baidu.swan.apps.performance.c.d.releaseInstance();
        BI();
    }

    public void onTrimMemory(int i) {
        com.baidu.swan.apps.console.c.w("SwanAppBaseFrame", "onTrimMemory level:" + i);
        uC().ee(i);
    }

    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean BT() {
        if (this.awa.yQ() != 1) {
            return false;
        }
        this.avZ.moveTaskToBack(true);
        return true;
    }

    public com.baidu.swan.apps.v.b.b uA() {
        return this.ajy;
    }

    public final void a(f fVar) {
        if (this.ajy != null && fVar != null) {
            fVar.mFrom = com.baidu.swan.apps.statistic.c.dB(us());
            if (TextUtils.isEmpty(fVar.mType)) {
                fVar.mType = "click";
            }
            fVar.mAppId = this.ajy.mAppId;
            fVar.mSource = this.ajy.axK;
            com.baidu.swan.apps.statistic.c.onEvent(fVar);
        }
    }

    public void aK(boolean z) {
        g(z, true);
    }

    public void g(boolean z, boolean z2) {
        if (this.avZ == null || this.avZ.getWindow() == null) {
            if (DEBUG) {
                Log.e("SwanAppBaseFrame", "activity or window is null");
                return;
            }
            return;
        }
        if (this.awf == null) {
            this.awf = new com.baidu.swan.apps.ai.b();
        }
        ViewGroup viewGroup = (ViewGroup) this.avZ.getWindow().getDecorView();
        if (z) {
            this.awf.j(viewGroup);
        } else {
            this.awf.k(viewGroup);
        }
        if (z2) {
            com.baidu.swan.apps.process.messaging.client.a.Go().sendMessage(5);
        }
    }

    public void a(int i, @NonNull String[] strArr, a.InterfaceC0108a interfaceC0108a) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.awe == null) {
                this.awe = new com.baidu.swan.apps.ab.a();
            }
            this.awe.a(this.avZ, i, strArr, interfaceC0108a);
            if (com.baidu.swan.apps.u.a.Cz().vg()) {
                com.baidu.swan.apps.y.f.EP().ES();
            }
        }
    }

    public boolean b(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.awe != null) {
            this.awe.onRequestPermissionsResult(i, strArr, iArr);
            return true;
        }
        return false;
    }

    public void showLoadingView() {
        this.ajB = (FrameLayout) this.avZ.findViewById(a.f.ai_apps_activity_root);
        com.baidu.swan.apps.res.widget.loadingview.a.d(this.avZ, this.ajB);
    }

    public void uB() {
        com.baidu.swan.apps.res.widget.loadingview.a.i(this.ajB);
    }

    @NonNull
    public com.baidu.swan.apps.aj.e.b uC() {
        return this.awd;
    }

    public boolean isLandScape() {
        return false;
    }

    public void a(b bVar) {
        this.awi.c(bVar);
    }

    public void b(b bVar) {
        this.awi.d(bVar);
    }

    public boolean uD() {
        if (this.awj || !com.baidu.swan.apps.p.a.BX().b(new WeakReference<>(this.avZ))) {
            return false;
        }
        this.awj = true;
        return true;
    }
}
