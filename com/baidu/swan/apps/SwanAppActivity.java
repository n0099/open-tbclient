package com.baidu.swan.apps;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.OrientationEventListener;
import android.widget.FrameLayout;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.searchbox.process.ipc.util.TranslucentUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.af.c;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ah;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.as.r;
import com.baidu.swan.apps.core.k.d;
import com.baidu.swan.apps.framework.FrameLifeState;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.res.widget.floatlayer.a;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.statistic.e;
import com.baidu.swan.apps.x.b.b;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.apps.y.g;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
/* loaded from: classes11.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ServiceConnection, ActivityResultDispatcherHolder, com.baidu.swan.apps.ao.f.c, a.InterfaceC0283a {
    private static final boolean DEBUG = b.DEBUG;
    private static final String baD = SwanAppActivity.class.getName();
    private static final long baE = TimeUnit.SECONDS.toMillis(1);
    private static final long baF = TimeUnit.SECONDS.toMillis(5);
    private com.baidu.swan.apps.framework.c baG;
    private Messenger baH;
    private ActivityResultDispatcher baJ;
    OrientationEventListener baL;
    private com.baidu.swan.apps.as.b baM;
    protected com.baidu.swan.apps.view.c baN;
    private com.baidu.swan.apps.res.widget.floatlayer.a baO;
    private FrameLifeState baI = FrameLifeState.INACTIVATED;
    private String baK = "sys";
    private boolean mIsFromSchema = false;
    private final com.baidu.swan.apps.runtime.b baP = new com.baidu.swan.apps.runtime.b();

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        Bundle bundle2;
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(a.C0197a.aiapps_slide_in_from_right, a.C0197a.aiapps_hold);
        SwanAppProcessInfo.init(getProcessInfo());
        com.baidu.swan.apps.w.a.UM().Iv();
        com.baidu.swan.apps.process.messaging.client.a.aaT().aaV();
        this.mIsFromSchema = true;
        e.gr(bundle == null ? 0 : 1);
        super.onCreate(bundle);
        a(FrameLifeState.JUST_CREATED);
        if (!r.checkActivityRefuseServiceAndFinish(this)) {
            Intent intent = getIntent();
            if (bundle != null && intent != null && (bundle2 = bundle.getBundle("swan_key_save_bundle")) != null) {
                bundle2.setClassLoader(getClass().getClassLoader());
                intent.putExtras(bundle2);
            }
            if (D(intent)) {
                GM();
                return;
            }
            d.b.F(intent);
            com.baidu.swan.games.utils.so.d.P(intent);
            if (DEBUG) {
                Log.i("SwanAppActivity", "onCreate: bindService");
            }
            try {
                bindService(new Intent(this, getProcessInfo().service), this, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            if (Build.VERSION.SDK_INT == 26) {
                TranslucentUtils.convertFromTranslucent(this);
            }
            if (DEBUG) {
                Log.d("SwanAppActivity", "SwanAppActivity onCreate() savedInstanceState=" + bundle);
            }
            com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onCreate");
            setContentView(a.g.aiapps_activity);
            GH();
            com.baidu.swan.apps.runtime.d acA = com.baidu.swan.apps.runtime.d.acA();
            acA.j(this);
            acA.e(this.baP);
            boolean I = com.baidu.swan.apps.x.b.d.I(intent);
            if (intent != null && (I || bundle == null)) {
                intent.putExtra("receive_launch_intent_time", currentTimeMillis);
                acA.c(intent.getExtras(), "update_tag_by_activity_on_create");
            }
            if (acA.abh() && I) {
                acA.acx().acG().iB("1250000000000000");
            }
            af.X(this);
            if (Build.VERSION.SDK_INT != 26) {
                this.baM = new com.baidu.swan.apps.as.b(this);
            }
            if (this.baM != null) {
                this.baM.setCanSlide(false);
            }
            if (this.baM != null) {
                this.baM.onCreate();
            }
            m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.w.a.Ug().HY();
                }
            }, "initMobStat");
            ah.agZ();
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (this.baM != null) {
            this.baM.agt();
        }
    }

    public com.baidu.swan.apps.as.b Gr() {
        return this.baM;
    }

    private boolean D(Intent intent) {
        if (intent != null) {
            ComponentName component = intent.getComponent();
            return (component == null || component.getClassName().startsWith(baD)) ? false : true;
        }
        return true;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle.get("android:support:fragments") != null) {
            bundle.remove("android:support:fragments");
        }
        Intent intent = getIntent();
        if (intent != null) {
            bundle.putBundle("swan_key_save_bundle", intent.getExtras());
        }
    }

    private void U(int i, int i2) {
        if (-1 < i) {
            setRequestedOrientation(i == 1 ? 0 : 1);
        }
        if (i2 == 1) {
            com.baidu.swan.apps.as.c.U(this);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceConnected: " + componentName);
        }
        if (iBinder != null) {
            this.baH = new Messenger(iBinder);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceDisconnected: " + componentName);
        }
        this.baH = null;
    }

    public int Gs() {
        if (this.baG == null) {
            return -1;
        }
        return this.baG.Gs();
    }

    public com.baidu.swan.apps.framework.c Gt() {
        return this.baG;
    }

    public synchronized boolean Gu() {
        boolean z;
        if (!isDestroyed() && this.baG != null) {
            z = this.baG.SH().activated();
        }
        return z;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onNewIntent");
        setIntent(intent);
        overridePendingTransition(a.C0197a.aiapps_slide_in_from_right, a.C0197a.aiapps_hold);
        if (DEBUG) {
            Log.i("SwanAppActivity", "onNewIntent:REORDER_TO_FRONT = " + ((intent.getFlags() & 131072) == 131072));
        }
        if (this.baM != null) {
            this.baM.agu();
        }
        this.mIsFromSchema = true;
        com.baidu.swan.apps.runtime.d acA = com.baidu.swan.apps.runtime.d.acA();
        acA.c(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (acA.abh() && com.baidu.swan.apps.x.b.d.I(intent)) {
            acA.acx().GC().iB("1250000000000000");
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.baG == null || !this.baG.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        if (this.baJ == null) {
            this.baJ = new ActivityResultDispatcher(this, 1);
        }
        return this.baJ;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0283a
    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a Gv() {
        if (this.baO == null) {
            this.baO = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (FrameLayout) findViewById(16908290), 0);
        }
        return this.baO;
    }

    public com.baidu.swan.apps.view.c Gw() {
        return this.baN;
    }

    public void Gx() {
        if (this.mIsFromSchema) {
            this.baK = "schema";
        } else {
            this.baK = "user";
        }
    }

    public String Gy() {
        return this.baK;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        if (this.baM != null) {
            this.baM.closePane();
        }
        a(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !com.baidu.swan.apps.runtime.d.acA().abh()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            com.baidu.swan.apps.runtime.d.acA().c(intent.getExtras(), "update_tag_by_activity_on_create");
            if (com.baidu.swan.apps.runtime.d.acA().abh() && com.baidu.swan.apps.x.b.d.I(intent)) {
                com.baidu.swan.apps.runtime.d.acA().acx().acG().iB("1250000000000000");
            }
        }
        Gx();
        super.onResume();
        if (this.baL == null) {
            this.baL = new OrientationEventListener(this, 2) { // from class: com.baidu.swan.apps.SwanAppActivity.4
                @Override // android.view.OrientationEventListener
                public void onOrientationChanged(int i) {
                    com.baidu.swan.apps.runtime.d.acA().bOR = i;
                }
            };
        }
        this.baL.enable();
        if (this.baM != null) {
            this.baM.onResume();
        }
        a(FrameLifeState.JUST_RESUMED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        a(FrameLifeState.JUST_STARTED);
        this.mIsFromSchema = false;
        this.baL.disable();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        a(FrameLifeState.JUST_CREATED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            com.baidu.swan.apps.adaptation.b.a.c.IW().IX().IV().onActivityResult(this, i, i2, intent);
        }
    }

    private synchronized void a(@NonNull FrameLifeState frameLifeState) {
        this.baI = frameLifeState;
        Gz();
    }

    private synchronized void b(@NonNull FrameLifeState frameLifeState) {
        if (this.baG != null && !this.baG.Ss()) {
            this.baG.d(frameLifeState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Gz() {
        b(this.baI);
    }

    public com.baidu.swan.apps.core.d.e GA() {
        if (this.baG == null) {
            return null;
        }
        return this.baG.GA();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com.baidu.swan.apps.runtime.d.acA().f(this.baP);
        if (DEBUG) {
            Log.d("SwanAppActivity", "——> onDestroy: ");
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onDestroy");
        this.baL = null;
        GB();
        if (this.baH != null) {
            unbindService(this);
        }
        com.baidu.swan.apps.w.a.Ux().Iy();
        if (this.baM != null) {
            this.baM.onDestroy();
        }
        com.baidu.swan.apps.runtime.d.acA().k(this);
        a(FrameLifeState.INACTIVATED);
        f.release();
        com.baidu.swan.apps.x.c.a iM = com.baidu.swan.apps.x.c.a.iM(com.baidu.swan.apps.runtime.d.acA().getAppId());
        iM.Wh().Wo();
        iM.Wi();
        com.baidu.swan.apps.runtime.d.acA().v(new String[0]);
        super.onDestroy();
    }

    public synchronized void GB() {
        if (this.baN != null) {
            this.baN.Jz();
            this.baN = null;
            if (DEBUG) {
                Log.i("SwanAppActivity", "destroyFrame resetLoadingView");
            }
        }
        com.baidu.swan.apps.core.d.e GA = GA();
        if (GA != null) {
            GA.Op().Y(0, 0).Ov().Ox();
        }
        com.baidu.swan.apps.textarea.c.release();
        if (this.baG != null) {
            this.baG.d(FrameLifeState.INACTIVATED);
            this.baG.release();
            this.baG = null;
        }
        com.baidu.swan.apps.setting.oauth.c.release();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (DEBUG) {
            Log.d("SwanAppActivity", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onBackPressed");
        if (Gu()) {
            this.baG.onBackPressed();
        } else {
            moveTaskToBack(true);
        }
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2 = false;
        if (!Gu() || com.baidu.swan.apps.runtime.d.acA().acx().acH()) {
            com.baidu.swan.apps.statistic.f.aeY();
            GM();
            return false;
        }
        try {
            z2 = super.moveTaskToBack(z);
            overridePendingTransition(0, a.C0197a.aiapps_slide_out_to_right_zadjustment_top);
            return z2;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
                return z2;
            }
            return z2;
        }
    }

    public SwanAppProcessInfo getProcessInfo() {
        return SwanAppProcessInfo.P0;
    }

    public b.a GC() {
        if (this.baG == null) {
            return null;
        }
        return this.baG.GC();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (this.baG != null) {
            this.baG.a(fVar);
        }
    }

    public void m(Bundle bundle) {
        com.baidu.swan.apps.process.messaging.service.b.b(this, bundle);
    }

    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        if (this.baG != null) {
            this.baG.a(i, strArr, aVar);
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.swan.support.v4.app.a.InterfaceC0365a
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.baG != null && !this.baG.onRequestPermissionsResult(i, strArr, iArr)) {
            a(i, strArr, iArr);
        }
    }

    public void a(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void showLoadingView() {
        if (this.baG != null) {
            this.baG.showLoadingView();
        }
    }

    public void GD() {
        if (this.baG != null) {
            this.baG.GD();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (Gu()) {
            this.baG.onTrimMemory(i);
        }
    }

    @Override // com.baidu.swan.apps.ao.f.c
    public com.baidu.swan.apps.ao.f.b GE() {
        if (this.baG == null) {
            return null;
        }
        return this.baG.GE();
    }

    public boolean isLandScape() {
        return this.baG != null && this.baG.isLandScape();
    }

    public void a(com.baidu.swan.apps.framework.b bVar) {
        if (this.baG != null) {
            this.baG.a(bVar);
        }
    }

    public void b(com.baidu.swan.apps.framework.b bVar) {
        if (this.baG != null) {
            this.baG.b(bVar);
        }
    }

    @UiThread
    public void dR(int i) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i + ", pid:" + Process.myPid());
        }
        com.baidu.swan.apps.w.a.Ux().a(this, i, GC());
    }

    public void GF() {
        if (this.baN == null) {
            this.baN = new com.baidu.swan.apps.view.c(this);
        }
        b.a acG = com.baidu.swan.apps.runtime.d.acA().acx().acG();
        U(acG.getOrientation(), acG.getAppFrameType());
        this.baN.ej(1 == acG.getAppFrameType());
    }

    public void GG() {
        int i = 2;
        if (GC() != null && GC().getOrientation() == 1) {
            i = 3;
        }
        if (Gw() != null) {
            Gw().hk(i);
        }
    }

    private void GH() {
        this.baP.a(new com.baidu.swan.apps.as.d.c<i.a, Boolean>() { // from class: com.baidu.swan.apps.SwanAppActivity.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.c
            /* renamed from: b */
            public Boolean E(i.a aVar) {
                return Boolean.valueOf(!SwanAppActivity.this.isDestroyed());
            }
        }).a(new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void D(i.a aVar) {
                SwanAppActivity.this.GK();
            }
        }, "event_on_app_occupied").a(new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void D(i.a aVar) {
                SwanAppActivity.this.c(aVar);
            }
        }, "event_on_app_updated").a(new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void D(i.a aVar) {
                SwanAppActivity.this.b(aVar);
            }
        }, "event_on_app_icon_update").a(new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void D(i.a aVar) {
                SwanAppActivity.this.GI();
            }
        }, "event_on_pkg_maintain_finish").a(new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void D(i.a aVar) {
                SwanAppActivity.this.a(aVar);
            }
        }, "installer_on_progress").a(new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void D(i.a aVar) {
                SwanAppActivity.this.Gz();
            }
        }, "event_first_action_launched");
        g.WV().WW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.x.b.a.c cVar) {
        if (GJ() && cVar.containsKey(" event_params_installer_progress")) {
            this.baN.W(cVar.getFloat(" event_params_installer_progress"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GI() {
        if (!isDestroyed()) {
            if (com.baidu.swan.apps.runtime.d.acA().acx().available()) {
                bR(true);
            } else {
                com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppActivity.this.GM();
                    }
                }, baE);
            }
        }
    }

    private boolean GJ() {
        return (this.baN == null || isDestroyed()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.x.b.a.c cVar) {
        if (GJ()) {
            this.baN.na(cVar.getString("app_icon_url"));
            this.baN.nb(cVar.getString("app_name"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GK() {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        GF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.apps.x.b.a.c cVar) {
        if (this.baG != null && this.baG.SU()) {
            bR("update_tag_by_activity_on_new_intent".equals(cVar.getString("app_update_tag")));
        }
    }

    public void q(String... strArr) {
        GB();
        HashSet dkF = strArr == null ? com.facebook.common.internal.i.dkF() : com.facebook.common.internal.i.K(strArr);
        if (dkF.contains("flag_finish_activity")) {
            if (dkF.contains("flag_remove_task")) {
                GM();
            } else {
                finish();
            }
        }
    }

    public String GL() {
        return this.baG == null ? "" : this.baG.bvD;
    }

    public boolean fa(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.equals(str, GL());
    }

    private synchronized void bR(boolean z) {
        com.baidu.swan.apps.runtime.e acx = com.baidu.swan.apps.runtime.d.acA().acx();
        if (acx.available() && (fa(acx.getAppId()) || a(acx))) {
            this.baG.a(this.baI, z);
            GN();
        }
    }

    private synchronized boolean a(com.baidu.swan.apps.runtime.e eVar) {
        boolean z;
        if (this.baG != null) {
            GB();
        }
        com.baidu.swan.apps.framework.c a = com.baidu.swan.apps.framework.e.a(this, eVar);
        if (a == null) {
            com.baidu.swan.apps.x.a.a.a(this, new com.baidu.swan.apps.ap.a().aI(5L).aJ(11L).my("can not buildFramework"), eVar.Gs(), eVar.id);
            GM();
            z = false;
        } else {
            this.baG = a;
            m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.w.a.Ug().HZ();
                }
            }, "updateMobStat");
            U(eVar.acG().getOrientation(), eVar.Gs());
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GM() {
        com.baidu.swan.apps.as.c.T(this);
    }

    private void GN() {
        com.baidu.swan.apps.runtime.e acx = com.baidu.swan.apps.runtime.d.acA().acx();
        if (acx != null) {
            String Wa = acx.GC().Wa();
            com.baidu.swan.apps.x.c.a iM = com.baidu.swan.apps.x.c.a.iM(acx.GC().Wa());
            iM.iN("appId: " + acx.id + "  launchId: " + Wa).Wp();
            iM.Wi();
        }
    }
}
