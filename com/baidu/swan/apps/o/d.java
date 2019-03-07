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
import com.baidu.swan.apps.ab.a;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.messaging.client.a;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.ubc.Flow;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public abstract class d {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    protected com.baidu.swan.apps.v.b.b ajs;
    private FrameLayout ajv;
    private com.baidu.swan.apps.res.widget.floatlayer.a aqw;
    protected SwanAppActivity avU;
    protected com.baidu.swan.apps.core.c.e avV;
    private final ActivityResultDispatcher avX;
    protected com.baidu.swan.apps.ab.a avZ;
    protected com.baidu.swan.apps.view.b awb;
    private Flow awc;
    private boolean awe;
    protected a.d avW = null;
    private final com.baidu.swan.apps.aj.e.b avY = new com.baidu.swan.apps.aj.e.b();
    private com.baidu.swan.apps.ai.b awa = null;
    private c awd = new c();

    @NonNull
    protected abstract a.d BP();

    public abstract int ut();

    public d(SwanAppActivity swanAppActivity) {
        this.avU = swanAppActivity;
        this.avX = new ActivityResultDispatcher(this.avU, 1);
    }

    @CallSuper
    @DebugTrace
    public void onCreate(Bundle bundle) {
        this.awd.BE();
        com.baidu.swan.apps.console.c.d("SwanApp", "onCreate: " + this);
        parseIntent(getIntent());
        if (com.baidu.swan.apps.console.a.d.wP()) {
            com.baidu.swan.apps.core.i.c.release();
        }
        BT();
        BI();
        com.baidu.swan.apps.ae.b.n(this.ajs);
        if (!com.baidu.swan.apps.ae.b.isDataValid()) {
            com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(5L).M(11L).hw("aiapp data is invalid");
            com.baidu.swan.apps.ak.e.LG().b(hw);
            com.baidu.swan.apps.statistic.c.a(new com.baidu.swan.apps.statistic.a.d().gR(com.baidu.swan.apps.statistic.c.dC(ut())).a(hw).r(this.ajs));
            com.baidu.swan.apps.an.b.K(this.avU);
            return;
        }
        BJ();
    }

    public void onPostCreate(Bundle bundle) {
        com.baidu.swan.apps.console.c.d("SwanApp", "onPostCreate: " + this);
        aK(com.baidu.swan.apps.u.a.CT().Ds());
    }

    public boolean f(@NonNull com.baidu.swan.apps.v.b.b bVar) {
        if (this.ajs == null) {
            return false;
        }
        return TextUtils.equals(bVar.mAppId, this.ajs.mAppId);
    }

    @CallSuper
    public void onNewIntent(Intent intent) {
    }

    public Intent getIntent() {
        if (this.avU != null) {
            return this.avU.getIntent();
        }
        return null;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.awd.onKeyDown(i, keyEvent);
    }

    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.avX;
    }

    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a uv() {
        if (this.aqw == null) {
            this.aqw = new com.baidu.swan.apps.res.widget.floatlayer.a(this.avU, (FrameLayout) this.avU.findViewById(16908290), 0);
        }
        return this.aqw;
    }

    protected void BI() {
    }

    public com.baidu.swan.apps.view.b uw() {
        return this.awb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BJ() {
        if (this.avW == null) {
            this.avW = BP();
        }
        BR().a(BQ(), (a.e) null, this.avW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BK() {
        BR().BK();
        this.avW = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BL() {
        Bundle bundle;
        if (this.ajs != null && (bundle = this.ajs.axP) != null && bundle.getLong("launch_flag_for_statistic") > 0) {
            f fVar = new f();
            fVar.mFrom = com.baidu.swan.apps.statistic.c.dC(ut());
            fVar.mAppId = this.ajs.mAppId;
            fVar.mSource = this.ajs.axF;
            fVar.mType = "launch";
            fVar.mValue = "success";
            com.baidu.swan.apps.statistic.c.onEvent(fVar);
            bundle.remove("launch_flag_for_statistic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BM() {
        BN();
        BO();
    }

    protected void BN() {
        com.baidu.swan.apps.b.b.a uU = com.baidu.swan.apps.ae.e.Jo().aNY.get().uP().uU();
        if (uU != null) {
            uU.bm(this.avU);
        }
    }

    protected void BO() {
        com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
        com.baidu.swan.apps.a.b bVar = null;
        if (IX != null) {
            bVar = IX.Jc();
        }
        if (bVar != null) {
            bVar.setUid(bVar.bl(AppRuntime.getAppContext()));
        }
    }

    @NonNull
    protected a.g BQ() {
        a.g gVar = new a.g();
        gVar.appId = this.ajs.mAppId;
        SwanAppCores swanAppCores = new SwanAppCores();
        swanAppCores.a(this.ajs.atp);
        swanAppCores.a(this.ajs.atq);
        gVar.aEW = swanAppCores;
        return gVar;
    }

    public void reset() {
        com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
        if (IX != null) {
            IX.purge();
        }
        com.baidu.swan.apps.ae.b.terminate();
        com.baidu.swan.apps.an.b.K(this.avU);
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
            this.ajs = bVar;
            if (!TextUtils.isEmpty(this.ajs.ayb)) {
                com.baidu.swan.apps.console.a.d.setWebUrl(this.ajs.ayb);
            }
            if (this.ajs.axP != null) {
                this.ajs.aya = this.ajs.axP.getLong("aiapp_start_timestamp", -1L);
                if (!com.baidu.swan.apps.performance.f.aEb) {
                    this.ajs.axZ = this.ajs.aya;
                }
            }
            com.baidu.swan.apps.performance.f.k(this.ajs);
        }
    }

    public void onResume() {
        this.awd.onActivityResumed();
        com.baidu.swan.apps.console.c.d("SwanApp", "onResume: " + this);
        this.awc = com.baidu.swan.apps.statistic.c.gP("607");
        BS();
        com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
        if (IX != null) {
            IX.I(this.avU);
        }
        j.b(new Runnable() { // from class: com.baidu.swan.apps.o.d.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.network.c.a.Ff().Fh();
                if (d.DEBUG) {
                    Log.e("SwanAppBaseFrame", "try update on computation thread");
                }
                if (d.this.avU != null && com.baidu.swan.apps.ae.b.IX() != null) {
                    com.baidu.swan.apps.database.a.b.a(com.baidu.swan.apps.ae.b.IX());
                }
            }
        }, "saveSwanAppHistory");
        com.baidu.swan.apps.performance.f.fy("startup").f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
        com.baidu.swan.apps.y.f.ER().fl("na_page_show");
    }

    public void onStart() {
        this.awd.BF();
    }

    public void onPause() {
        this.awd.onActivityPaused();
        com.baidu.swan.apps.console.c.d("SwanApp", "onPause: " + this);
        if (this.awc != null) {
            com.baidu.swan.apps.statistic.a.a aVar = new com.baidu.swan.apps.statistic.a.a();
            aVar.mFrom = com.baidu.swan.apps.statistic.c.dC(ut());
            aVar.mAppId = this.ajs.mAppId;
            aVar.mSource = this.ajs.axF;
            aVar.ai(com.baidu.swan.apps.statistic.c.Kt());
            com.baidu.swan.apps.statistic.c.a(this.awc, aVar);
            this.awc = null;
        }
    }

    public void onStop() {
        this.awd.BG();
    }

    public com.baidu.swan.apps.process.messaging.client.a BR() {
        return com.baidu.swan.apps.process.messaging.client.a.Gq();
    }

    private void BS() {
        if (this.ajs != null && this.ajs.isValid()) {
            a(this.avU, this.ajs.axC, aa.a(this.ajs, "SwanAppBaseFrame", true), (int) this.ajs.axE);
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

    private void BT() {
        this.avV = new com.baidu.swan.apps.core.c.e(this.avU);
        BU();
    }

    protected void BU() {
    }

    public com.baidu.swan.apps.core.c.e uz() {
        return this.avV;
    }

    public boolean tu() {
        return false;
    }

    public void onDestroy() {
        this.awd.BH();
        com.baidu.swan.apps.console.c.d("SwanApp", "onDestroy: " + this);
        if (this.awb != null) {
            this.awb.wm();
            this.awb = null;
        }
        com.baidu.swan.apps.network.c.a.Ff().release();
        com.baidu.swan.apps.performance.c.d.releaseInstance();
        BK();
    }

    public void onTrimMemory(int i) {
        com.baidu.swan.apps.console.c.w("SwanAppBaseFrame", "onTrimMemory level:" + i);
        uD().ef(i);
    }

    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean BV() {
        if (this.avV.yR() != 1) {
            return false;
        }
        this.avU.moveTaskToBack(true);
        return true;
    }

    public com.baidu.swan.apps.v.b.b uB() {
        return this.ajs;
    }

    public final void a(f fVar) {
        if (this.ajs != null && fVar != null) {
            fVar.mFrom = com.baidu.swan.apps.statistic.c.dC(ut());
            if (TextUtils.isEmpty(fVar.mType)) {
                fVar.mType = "click";
            }
            fVar.mAppId = this.ajs.mAppId;
            fVar.mSource = this.ajs.axF;
            com.baidu.swan.apps.statistic.c.onEvent(fVar);
        }
    }

    public void aK(boolean z) {
        g(z, true);
    }

    public void g(boolean z, boolean z2) {
        if (this.avU == null || this.avU.getWindow() == null) {
            if (DEBUG) {
                Log.e("SwanAppBaseFrame", "activity or window is null");
                return;
            }
            return;
        }
        if (this.awa == null) {
            this.awa = new com.baidu.swan.apps.ai.b();
        }
        ViewGroup viewGroup = (ViewGroup) this.avU.getWindow().getDecorView();
        if (z) {
            this.awa.j(viewGroup);
        } else {
            this.awa.k(viewGroup);
        }
        if (z2) {
            com.baidu.swan.apps.process.messaging.client.a.Gq().sendMessage(5);
        }
    }

    public void a(int i, @NonNull String[] strArr, a.InterfaceC0078a interfaceC0078a) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.avZ == null) {
                this.avZ = new com.baidu.swan.apps.ab.a();
            }
            this.avZ.a(this.avU, i, strArr, interfaceC0078a);
            if (com.baidu.swan.apps.u.a.CB().vh()) {
                com.baidu.swan.apps.y.f.ER().EU();
            }
        }
    }

    public boolean b(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.avZ != null) {
            this.avZ.onRequestPermissionsResult(i, strArr, iArr);
            return true;
        }
        return false;
    }

    public void showLoadingView() {
        this.ajv = (FrameLayout) this.avU.findViewById(b.f.ai_apps_activity_root);
        com.baidu.swan.apps.res.widget.loadingview.a.d(this.avU, this.ajv);
    }

    public void uC() {
        com.baidu.swan.apps.res.widget.loadingview.a.i(this.ajv);
    }

    @NonNull
    public com.baidu.swan.apps.aj.e.b uD() {
        return this.avY;
    }

    public boolean isLandScape() {
        return false;
    }

    public void a(b bVar) {
        this.awd.c(bVar);
    }

    public void b(b bVar) {
        this.awd.d(bVar);
    }

    public boolean uE() {
        if (this.awe || !com.baidu.swan.apps.p.a.BZ().b(new WeakReference<>(this.avU))) {
            return false;
        }
        this.awe = true;
        return true;
    }
}
