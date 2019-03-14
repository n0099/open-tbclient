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
    protected com.baidu.swan.apps.v.b.b ajt;
    private FrameLayout ajw;
    private com.baidu.swan.apps.res.widget.floatlayer.a aqx;
    protected SwanAppActivity avV;
    protected com.baidu.swan.apps.core.c.e avW;
    private final ActivityResultDispatcher avY;
    protected com.baidu.swan.apps.ab.a awa;
    protected com.baidu.swan.apps.view.b awc;
    private Flow awd;
    private boolean awf;
    protected a.d avX = null;
    private final com.baidu.swan.apps.aj.e.b avZ = new com.baidu.swan.apps.aj.e.b();
    private com.baidu.swan.apps.ai.b awb = null;
    private c awe = new c();

    @NonNull
    protected abstract a.d BP();

    public abstract int ut();

    public d(SwanAppActivity swanAppActivity) {
        this.avV = swanAppActivity;
        this.avY = new ActivityResultDispatcher(this.avV, 1);
    }

    @CallSuper
    @DebugTrace
    public void onCreate(Bundle bundle) {
        this.awe.BE();
        com.baidu.swan.apps.console.c.d("SwanApp", "onCreate: " + this);
        parseIntent(getIntent());
        if (com.baidu.swan.apps.console.a.d.wP()) {
            com.baidu.swan.apps.core.i.c.release();
        }
        BT();
        BI();
        com.baidu.swan.apps.ae.b.n(this.ajt);
        if (!com.baidu.swan.apps.ae.b.isDataValid()) {
            com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(5L).M(11L).hw("aiapp data is invalid");
            com.baidu.swan.apps.ak.e.LG().b(hw);
            com.baidu.swan.apps.statistic.c.a(new com.baidu.swan.apps.statistic.a.d().gR(com.baidu.swan.apps.statistic.c.dC(ut())).a(hw).r(this.ajt));
            com.baidu.swan.apps.an.b.K(this.avV);
            return;
        }
        BJ();
    }

    public void onPostCreate(Bundle bundle) {
        com.baidu.swan.apps.console.c.d("SwanApp", "onPostCreate: " + this);
        aK(com.baidu.swan.apps.u.a.CT().Ds());
    }

    public boolean f(@NonNull com.baidu.swan.apps.v.b.b bVar) {
        if (this.ajt == null) {
            return false;
        }
        return TextUtils.equals(bVar.mAppId, this.ajt.mAppId);
    }

    @CallSuper
    public void onNewIntent(Intent intent) {
    }

    public Intent getIntent() {
        if (this.avV != null) {
            return this.avV.getIntent();
        }
        return null;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.awe.onKeyDown(i, keyEvent);
    }

    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.avY;
    }

    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a uv() {
        if (this.aqx == null) {
            this.aqx = new com.baidu.swan.apps.res.widget.floatlayer.a(this.avV, (FrameLayout) this.avV.findViewById(16908290), 0);
        }
        return this.aqx;
    }

    protected void BI() {
    }

    public com.baidu.swan.apps.view.b uw() {
        return this.awc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BJ() {
        if (this.avX == null) {
            this.avX = BP();
        }
        BR().a(BQ(), (a.e) null, this.avX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BK() {
        BR().BK();
        this.avX = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BL() {
        Bundle bundle;
        if (this.ajt != null && (bundle = this.ajt.axQ) != null && bundle.getLong("launch_flag_for_statistic") > 0) {
            f fVar = new f();
            fVar.mFrom = com.baidu.swan.apps.statistic.c.dC(ut());
            fVar.mAppId = this.ajt.mAppId;
            fVar.mSource = this.ajt.axG;
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
        com.baidu.swan.apps.b.b.a uU = com.baidu.swan.apps.ae.e.Jo().aNZ.get().uP().uU();
        if (uU != null) {
            uU.bm(this.avV);
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
        gVar.appId = this.ajt.mAppId;
        SwanAppCores swanAppCores = new SwanAppCores();
        swanAppCores.a(this.ajt.atq);
        swanAppCores.a(this.ajt.atr);
        gVar.aEX = swanAppCores;
        return gVar;
    }

    public void reset() {
        com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
        if (IX != null) {
            IX.purge();
        }
        com.baidu.swan.apps.ae.b.terminate();
        com.baidu.swan.apps.an.b.K(this.avV);
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
            this.ajt = bVar;
            if (!TextUtils.isEmpty(this.ajt.ayc)) {
                com.baidu.swan.apps.console.a.d.setWebUrl(this.ajt.ayc);
            }
            if (this.ajt.axQ != null) {
                this.ajt.ayb = this.ajt.axQ.getLong("aiapp_start_timestamp", -1L);
                if (!com.baidu.swan.apps.performance.f.aEc) {
                    this.ajt.aya = this.ajt.ayb;
                }
            }
            com.baidu.swan.apps.performance.f.k(this.ajt);
        }
    }

    public void onResume() {
        this.awe.onActivityResumed();
        com.baidu.swan.apps.console.c.d("SwanApp", "onResume: " + this);
        this.awd = com.baidu.swan.apps.statistic.c.gP("607");
        BS();
        com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
        if (IX != null) {
            IX.I(this.avV);
        }
        j.b(new Runnable() { // from class: com.baidu.swan.apps.o.d.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.network.c.a.Ff().Fh();
                if (d.DEBUG) {
                    Log.e("SwanAppBaseFrame", "try update on computation thread");
                }
                if (d.this.avV != null && com.baidu.swan.apps.ae.b.IX() != null) {
                    com.baidu.swan.apps.database.a.b.a(com.baidu.swan.apps.ae.b.IX());
                }
            }
        }, "saveSwanAppHistory");
        com.baidu.swan.apps.performance.f.fy("startup").f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
        com.baidu.swan.apps.y.f.ER().fl("na_page_show");
    }

    public void onStart() {
        this.awe.BF();
    }

    public void onPause() {
        this.awe.onActivityPaused();
        com.baidu.swan.apps.console.c.d("SwanApp", "onPause: " + this);
        if (this.awd != null) {
            com.baidu.swan.apps.statistic.a.a aVar = new com.baidu.swan.apps.statistic.a.a();
            aVar.mFrom = com.baidu.swan.apps.statistic.c.dC(ut());
            aVar.mAppId = this.ajt.mAppId;
            aVar.mSource = this.ajt.axG;
            aVar.ai(com.baidu.swan.apps.statistic.c.Kt());
            com.baidu.swan.apps.statistic.c.a(this.awd, aVar);
            this.awd = null;
        }
    }

    public void onStop() {
        this.awe.BG();
    }

    public com.baidu.swan.apps.process.messaging.client.a BR() {
        return com.baidu.swan.apps.process.messaging.client.a.Gq();
    }

    private void BS() {
        if (this.ajt != null && this.ajt.isValid()) {
            a(this.avV, this.ajt.axD, aa.a(this.ajt, "SwanAppBaseFrame", true), (int) this.ajt.axF);
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
        this.avW = new com.baidu.swan.apps.core.c.e(this.avV);
        BU();
    }

    protected void BU() {
    }

    public com.baidu.swan.apps.core.c.e uz() {
        return this.avW;
    }

    public boolean tu() {
        return false;
    }

    public void onDestroy() {
        this.awe.BH();
        com.baidu.swan.apps.console.c.d("SwanApp", "onDestroy: " + this);
        if (this.awc != null) {
            this.awc.wm();
            this.awc = null;
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
        if (this.avW.yR() != 1) {
            return false;
        }
        this.avV.moveTaskToBack(true);
        return true;
    }

    public com.baidu.swan.apps.v.b.b uB() {
        return this.ajt;
    }

    public final void a(f fVar) {
        if (this.ajt != null && fVar != null) {
            fVar.mFrom = com.baidu.swan.apps.statistic.c.dC(ut());
            if (TextUtils.isEmpty(fVar.mType)) {
                fVar.mType = "click";
            }
            fVar.mAppId = this.ajt.mAppId;
            fVar.mSource = this.ajt.axG;
            com.baidu.swan.apps.statistic.c.onEvent(fVar);
        }
    }

    public void aK(boolean z) {
        g(z, true);
    }

    public void g(boolean z, boolean z2) {
        if (this.avV == null || this.avV.getWindow() == null) {
            if (DEBUG) {
                Log.e("SwanAppBaseFrame", "activity or window is null");
                return;
            }
            return;
        }
        if (this.awb == null) {
            this.awb = new com.baidu.swan.apps.ai.b();
        }
        ViewGroup viewGroup = (ViewGroup) this.avV.getWindow().getDecorView();
        if (z) {
            this.awb.j(viewGroup);
        } else {
            this.awb.k(viewGroup);
        }
        if (z2) {
            com.baidu.swan.apps.process.messaging.client.a.Gq().sendMessage(5);
        }
    }

    public void a(int i, @NonNull String[] strArr, a.InterfaceC0108a interfaceC0108a) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.awa == null) {
                this.awa = new com.baidu.swan.apps.ab.a();
            }
            this.awa.a(this.avV, i, strArr, interfaceC0108a);
            if (com.baidu.swan.apps.u.a.CB().vh()) {
                com.baidu.swan.apps.y.f.ER().EU();
            }
        }
    }

    public boolean b(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.awa != null) {
            this.awa.onRequestPermissionsResult(i, strArr, iArr);
            return true;
        }
        return false;
    }

    public void showLoadingView() {
        this.ajw = (FrameLayout) this.avV.findViewById(a.f.ai_apps_activity_root);
        com.baidu.swan.apps.res.widget.loadingview.a.d(this.avV, this.ajw);
    }

    public void uC() {
        com.baidu.swan.apps.res.widget.loadingview.a.i(this.ajw);
    }

    @NonNull
    public com.baidu.swan.apps.aj.e.b uD() {
        return this.avZ;
    }

    public boolean isLandScape() {
        return false;
    }

    public void a(b bVar) {
        this.awe.c(bVar);
    }

    public void b(b bVar) {
        this.awe.d(bVar);
    }

    public boolean uE() {
        if (this.awf || !com.baidu.swan.apps.p.a.BZ().b(new WeakReference<>(this.avV))) {
            return false;
        }
        this.awf = true;
        return true;
    }
}
