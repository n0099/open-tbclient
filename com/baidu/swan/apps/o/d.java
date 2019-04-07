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
    private FrameLayout ajA;
    protected com.baidu.swan.apps.v.b.b ajx;
    private com.baidu.swan.apps.res.widget.floatlayer.a aqB;
    protected SwanAppActivity avY;
    protected com.baidu.swan.apps.core.c.e avZ;
    private final ActivityResultDispatcher awb;
    protected com.baidu.swan.apps.ab.a awd;
    protected com.baidu.swan.apps.view.b awf;
    private Flow awg;
    private boolean awi;
    protected a.d awa = null;
    private final com.baidu.swan.apps.aj.e.b awc = new com.baidu.swan.apps.aj.e.b();
    private com.baidu.swan.apps.ai.b awe = null;
    private c awh = new c();

    @NonNull
    protected abstract a.d BN();

    public abstract int us();

    public d(SwanAppActivity swanAppActivity) {
        this.avY = swanAppActivity;
        this.awb = new ActivityResultDispatcher(this.avY, 1);
    }

    @CallSuper
    @DebugTrace
    public void onCreate(Bundle bundle) {
        this.awh.BC();
        com.baidu.swan.apps.console.c.d("SwanApp", "onCreate: " + this);
        parseIntent(getIntent());
        if (com.baidu.swan.apps.console.a.d.wO()) {
            com.baidu.swan.apps.core.i.c.release();
        }
        BR();
        BG();
        com.baidu.swan.apps.ae.b.n(this.ajx);
        if (!com.baidu.swan.apps.ae.b.isDataValid()) {
            com.baidu.swan.apps.ak.a hx = new com.baidu.swan.apps.ak.a().L(5L).M(11L).hx("aiapp data is invalid");
            com.baidu.swan.apps.ak.e.LE().b(hx);
            com.baidu.swan.apps.statistic.c.a(new com.baidu.swan.apps.statistic.a.d().gS(com.baidu.swan.apps.statistic.c.dB(us())).a(hx).r(this.ajx));
            com.baidu.swan.apps.an.b.K(this.avY);
            return;
        }
        BH();
    }

    public void onPostCreate(Bundle bundle) {
        com.baidu.swan.apps.console.c.d("SwanApp", "onPostCreate: " + this);
        aK(com.baidu.swan.apps.u.a.CR().Dq());
    }

    public boolean f(@NonNull com.baidu.swan.apps.v.b.b bVar) {
        if (this.ajx == null) {
            return false;
        }
        return TextUtils.equals(bVar.mAppId, this.ajx.mAppId);
    }

    @CallSuper
    public void onNewIntent(Intent intent) {
    }

    public Intent getIntent() {
        if (this.avY != null) {
            return this.avY.getIntent();
        }
        return null;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.awh.onKeyDown(i, keyEvent);
    }

    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.awb;
    }

    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a uu() {
        if (this.aqB == null) {
            this.aqB = new com.baidu.swan.apps.res.widget.floatlayer.a(this.avY, (FrameLayout) this.avY.findViewById(16908290), 0);
        }
        return this.aqB;
    }

    protected void BG() {
    }

    public com.baidu.swan.apps.view.b uv() {
        return this.awf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BH() {
        if (this.awa == null) {
            this.awa = BN();
        }
        BP().a(BO(), (a.e) null, this.awa);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BI() {
        BP().BI();
        this.awa = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BJ() {
        Bundle bundle;
        if (this.ajx != null && (bundle = this.ajx.axT) != null && bundle.getLong("launch_flag_for_statistic") > 0) {
            f fVar = new f();
            fVar.mFrom = com.baidu.swan.apps.statistic.c.dB(us());
            fVar.mAppId = this.ajx.mAppId;
            fVar.mSource = this.ajx.axJ;
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
        com.baidu.swan.apps.b.b.a uT = com.baidu.swan.apps.ae.e.Jm().aOc.get().uO().uT();
        if (uT != null) {
            uT.bm(this.avY);
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
        gVar.appId = this.ajx.mAppId;
        SwanAppCores swanAppCores = new SwanAppCores();
        swanAppCores.a(this.ajx.atu);
        swanAppCores.a(this.ajx.atv);
        gVar.aFa = swanAppCores;
        return gVar;
    }

    public void reset() {
        com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
        if (IV != null) {
            IV.purge();
        }
        com.baidu.swan.apps.ae.b.terminate();
        com.baidu.swan.apps.an.b.K(this.avY);
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
            this.ajx = bVar;
            if (!TextUtils.isEmpty(this.ajx.ayf)) {
                com.baidu.swan.apps.console.a.d.setWebUrl(this.ajx.ayf);
            }
            if (this.ajx.axT != null) {
                this.ajx.aye = this.ajx.axT.getLong("aiapp_start_timestamp", -1L);
                if (!com.baidu.swan.apps.performance.f.aEf) {
                    this.ajx.ayd = this.ajx.aye;
                }
            }
            com.baidu.swan.apps.performance.f.k(this.ajx);
        }
    }

    public void onResume() {
        this.awh.onActivityResumed();
        com.baidu.swan.apps.console.c.d("SwanApp", "onResume: " + this);
        this.awg = com.baidu.swan.apps.statistic.c.gQ("607");
        BQ();
        com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
        if (IV != null) {
            IV.I(this.avY);
        }
        j.b(new Runnable() { // from class: com.baidu.swan.apps.o.d.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.network.c.a.Fd().Ff();
                if (d.DEBUG) {
                    Log.e("SwanAppBaseFrame", "try update on computation thread");
                }
                if (d.this.avY != null && com.baidu.swan.apps.ae.b.IV() != null) {
                    com.baidu.swan.apps.database.a.b.a(com.baidu.swan.apps.ae.b.IV());
                }
            }
        }, "saveSwanAppHistory");
        com.baidu.swan.apps.performance.f.fz("startup").f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
        com.baidu.swan.apps.y.f.EP().fm("na_page_show");
    }

    public void onStart() {
        this.awh.BD();
    }

    public void onPause() {
        this.awh.onActivityPaused();
        com.baidu.swan.apps.console.c.d("SwanApp", "onPause: " + this);
        if (this.awg != null) {
            com.baidu.swan.apps.statistic.a.a aVar = new com.baidu.swan.apps.statistic.a.a();
            aVar.mFrom = com.baidu.swan.apps.statistic.c.dB(us());
            aVar.mAppId = this.ajx.mAppId;
            aVar.mSource = this.ajx.axJ;
            aVar.ai(com.baidu.swan.apps.statistic.c.Kr());
            com.baidu.swan.apps.statistic.c.a(this.awg, aVar);
            this.awg = null;
        }
    }

    public void onStop() {
        this.awh.BE();
    }

    public com.baidu.swan.apps.process.messaging.client.a BP() {
        return com.baidu.swan.apps.process.messaging.client.a.Go();
    }

    private void BQ() {
        if (this.ajx != null && this.ajx.isValid()) {
            a(this.avY, this.ajx.axG, aa.a(this.ajx, "SwanAppBaseFrame", true), (int) this.ajx.axI);
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
        this.avZ = new com.baidu.swan.apps.core.c.e(this.avY);
        BS();
    }

    protected void BS() {
    }

    public com.baidu.swan.apps.core.c.e uy() {
        return this.avZ;
    }

    public boolean tt() {
        return false;
    }

    public void onDestroy() {
        this.awh.BF();
        com.baidu.swan.apps.console.c.d("SwanApp", "onDestroy: " + this);
        if (this.awf != null) {
            this.awf.wl();
            this.awf = null;
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
        if (this.avZ.yQ() != 1) {
            return false;
        }
        this.avY.moveTaskToBack(true);
        return true;
    }

    public com.baidu.swan.apps.v.b.b uA() {
        return this.ajx;
    }

    public final void a(f fVar) {
        if (this.ajx != null && fVar != null) {
            fVar.mFrom = com.baidu.swan.apps.statistic.c.dB(us());
            if (TextUtils.isEmpty(fVar.mType)) {
                fVar.mType = "click";
            }
            fVar.mAppId = this.ajx.mAppId;
            fVar.mSource = this.ajx.axJ;
            com.baidu.swan.apps.statistic.c.onEvent(fVar);
        }
    }

    public void aK(boolean z) {
        g(z, true);
    }

    public void g(boolean z, boolean z2) {
        if (this.avY == null || this.avY.getWindow() == null) {
            if (DEBUG) {
                Log.e("SwanAppBaseFrame", "activity or window is null");
                return;
            }
            return;
        }
        if (this.awe == null) {
            this.awe = new com.baidu.swan.apps.ai.b();
        }
        ViewGroup viewGroup = (ViewGroup) this.avY.getWindow().getDecorView();
        if (z) {
            this.awe.j(viewGroup);
        } else {
            this.awe.k(viewGroup);
        }
        if (z2) {
            com.baidu.swan.apps.process.messaging.client.a.Go().sendMessage(5);
        }
    }

    public void a(int i, @NonNull String[] strArr, a.InterfaceC0108a interfaceC0108a) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.awd == null) {
                this.awd = new com.baidu.swan.apps.ab.a();
            }
            this.awd.a(this.avY, i, strArr, interfaceC0108a);
            if (com.baidu.swan.apps.u.a.Cz().vg()) {
                com.baidu.swan.apps.y.f.EP().ES();
            }
        }
    }

    public boolean b(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.awd != null) {
            this.awd.onRequestPermissionsResult(i, strArr, iArr);
            return true;
        }
        return false;
    }

    public void showLoadingView() {
        this.ajA = (FrameLayout) this.avY.findViewById(a.f.ai_apps_activity_root);
        com.baidu.swan.apps.res.widget.loadingview.a.d(this.avY, this.ajA);
    }

    public void uB() {
        com.baidu.swan.apps.res.widget.loadingview.a.i(this.ajA);
    }

    @NonNull
    public com.baidu.swan.apps.aj.e.b uC() {
        return this.awc;
    }

    public boolean isLandScape() {
        return false;
    }

    public void a(b bVar) {
        this.awh.c(bVar);
    }

    public void b(b bVar) {
        this.awh.d(bVar);
    }

    public boolean uD() {
        if (this.awi || !com.baidu.swan.apps.p.a.BX().b(new WeakReference<>(this.avY))) {
            return false;
        }
        this.awi = true;
        return true;
    }
}
