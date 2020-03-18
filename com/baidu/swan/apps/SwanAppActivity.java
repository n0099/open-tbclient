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
    private static final String baS = SwanAppActivity.class.getName();
    private static final long baT = TimeUnit.SECONDS.toMillis(1);
    private static final long baU = TimeUnit.SECONDS.toMillis(5);
    private com.baidu.swan.apps.framework.c baV;
    private Messenger baW;
    private ActivityResultDispatcher baY;
    OrientationEventListener bba;
    private com.baidu.swan.apps.as.b bbb;
    protected com.baidu.swan.apps.view.c bbc;
    private com.baidu.swan.apps.res.widget.floatlayer.a bbd;
    private FrameLifeState baX = FrameLifeState.INACTIVATED;
    private String baZ = "sys";
    private boolean mIsFromSchema = false;
    private final com.baidu.swan.apps.runtime.b bbe = new com.baidu.swan.apps.runtime.b();

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        Bundle bundle2;
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(a.C0197a.aiapps_slide_in_from_right, a.C0197a.aiapps_hold);
        SwanAppProcessInfo.init(getProcessInfo());
        com.baidu.swan.apps.w.a.UR().IA();
        com.baidu.swan.apps.process.messaging.client.a.aaY().aba();
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
                GT();
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
            GO();
            com.baidu.swan.apps.runtime.d acF = com.baidu.swan.apps.runtime.d.acF();
            acF.j(this);
            acF.e(this.bbe);
            boolean I = com.baidu.swan.apps.x.b.d.I(intent);
            if (intent != null && (I || bundle == null)) {
                intent.putExtra("receive_launch_intent_time", currentTimeMillis);
                acF.c(intent.getExtras(), "update_tag_by_activity_on_create");
            }
            if (acF.abm() && I) {
                acF.acC().acL().iA("1250000000000000");
            }
            af.X(this);
            if (Build.VERSION.SDK_INT != 26) {
                this.bbb = new com.baidu.swan.apps.as.b(this);
            }
            if (this.bbb != null) {
                this.bbb.setCanSlide(false);
            }
            if (this.bbb != null) {
                this.bbb.onCreate();
            }
            m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.w.a.Ul().Id();
                }
            }, "initMobStat");
            ah.ahe();
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (this.bbb != null) {
            this.bbb.agy();
        }
    }

    public com.baidu.swan.apps.as.b Gy() {
        return this.bbb;
    }

    private boolean D(Intent intent) {
        if (intent != null) {
            ComponentName component = intent.getComponent();
            return (component == null || component.getClassName().startsWith(baS)) ? false : true;
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
            this.baW = new Messenger(iBinder);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceDisconnected: " + componentName);
        }
        this.baW = null;
    }

    public int Gz() {
        if (this.baV == null) {
            return -1;
        }
        return this.baV.Gz();
    }

    public com.baidu.swan.apps.framework.c GA() {
        return this.baV;
    }

    public synchronized boolean GB() {
        boolean z;
        if (!isDestroyed() && this.baV != null) {
            z = this.baV.SM().activated();
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
        if (this.bbb != null) {
            this.bbb.agz();
        }
        this.mIsFromSchema = true;
        com.baidu.swan.apps.runtime.d acF = com.baidu.swan.apps.runtime.d.acF();
        acF.c(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (acF.abm() && com.baidu.swan.apps.x.b.d.I(intent)) {
            acF.acC().GJ().iA("1250000000000000");
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.baV == null || !this.baV.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        if (this.baY == null) {
            this.baY = new ActivityResultDispatcher(this, 1);
        }
        return this.baY;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0283a
    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a GC() {
        if (this.bbd == null) {
            this.bbd = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (FrameLayout) findViewById(16908290), 0);
        }
        return this.bbd;
    }

    public com.baidu.swan.apps.view.c GD() {
        return this.bbc;
    }

    public void GE() {
        if (this.mIsFromSchema) {
            this.baZ = "schema";
        } else {
            this.baZ = "user";
        }
    }

    public String GF() {
        return this.baZ;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        if (this.bbb != null) {
            this.bbb.closePane();
        }
        a(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !com.baidu.swan.apps.runtime.d.acF().abm()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            com.baidu.swan.apps.runtime.d.acF().c(intent.getExtras(), "update_tag_by_activity_on_create");
            if (com.baidu.swan.apps.runtime.d.acF().abm() && com.baidu.swan.apps.x.b.d.I(intent)) {
                com.baidu.swan.apps.runtime.d.acF().acC().acL().iA("1250000000000000");
            }
        }
        GE();
        super.onResume();
        if (this.bba == null) {
            this.bba = new OrientationEventListener(this, 2) { // from class: com.baidu.swan.apps.SwanAppActivity.4
                @Override // android.view.OrientationEventListener
                public void onOrientationChanged(int i) {
                    com.baidu.swan.apps.runtime.d.acF().bPe = i;
                }
            };
        }
        this.bba.enable();
        if (this.bbb != null) {
            this.bbb.onResume();
        }
        a(FrameLifeState.JUST_RESUMED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        a(FrameLifeState.JUST_STARTED);
        this.mIsFromSchema = false;
        this.bba.disable();
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
            com.baidu.swan.apps.adaptation.b.a.c.Jb().Jc().Ja().onActivityResult(this, i, i2, intent);
        }
    }

    private synchronized void a(@NonNull FrameLifeState frameLifeState) {
        this.baX = frameLifeState;
        GG();
    }

    private synchronized void b(@NonNull FrameLifeState frameLifeState) {
        if (this.baV != null && !this.baV.Sx()) {
            this.baV.d(frameLifeState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void GG() {
        b(this.baX);
    }

    public com.baidu.swan.apps.core.d.e GH() {
        if (this.baV == null) {
            return null;
        }
        return this.baV.GH();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com.baidu.swan.apps.runtime.d.acF().f(this.bbe);
        if (DEBUG) {
            Log.d("SwanAppActivity", "——> onDestroy: ");
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onDestroy");
        this.bba = null;
        GI();
        if (this.baW != null) {
            unbindService(this);
        }
        com.baidu.swan.apps.w.a.UC().ID();
        if (this.bbb != null) {
            this.bbb.onDestroy();
        }
        com.baidu.swan.apps.runtime.d.acF().k(this);
        a(FrameLifeState.INACTIVATED);
        f.release();
        com.baidu.swan.apps.x.c.a iL = com.baidu.swan.apps.x.c.a.iL(com.baidu.swan.apps.runtime.d.acF().getAppId());
        iL.Wm().Wt();
        iL.Wn();
        com.baidu.swan.apps.runtime.d.acF().v(new String[0]);
        super.onDestroy();
    }

    public synchronized void GI() {
        if (this.bbc != null) {
            this.bbc.JE();
            this.bbc = null;
            if (DEBUG) {
                Log.i("SwanAppActivity", "destroyFrame resetLoadingView");
            }
        }
        com.baidu.swan.apps.core.d.e GH = GH();
        if (GH != null) {
            GH.Ou().Y(0, 0).OA().OC();
        }
        com.baidu.swan.apps.textarea.c.release();
        if (this.baV != null) {
            this.baV.d(FrameLifeState.INACTIVATED);
            this.baV.release();
            this.baV = null;
        }
        com.baidu.swan.apps.setting.oauth.c.release();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (DEBUG) {
            Log.d("SwanAppActivity", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onBackPressed");
        if (GB()) {
            this.baV.onBackPressed();
        } else {
            moveTaskToBack(true);
        }
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2 = false;
        if (!GB() || com.baidu.swan.apps.runtime.d.acF().acC().acM()) {
            com.baidu.swan.apps.statistic.f.afd();
            GT();
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

    public b.a GJ() {
        if (this.baV == null) {
            return null;
        }
        return this.baV.GJ();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (this.baV != null) {
            this.baV.a(fVar);
        }
    }

    public void m(Bundle bundle) {
        com.baidu.swan.apps.process.messaging.service.b.b(this, bundle);
    }

    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        if (this.baV != null) {
            this.baV.a(i, strArr, aVar);
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.swan.support.v4.app.a.InterfaceC0365a
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.baV != null && !this.baV.onRequestPermissionsResult(i, strArr, iArr)) {
            a(i, strArr, iArr);
        }
    }

    public void a(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void showLoadingView() {
        if (this.baV != null) {
            this.baV.showLoadingView();
        }
    }

    public void GK() {
        if (this.baV != null) {
            this.baV.GK();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (GB()) {
            this.baV.onTrimMemory(i);
        }
    }

    @Override // com.baidu.swan.apps.ao.f.c
    public com.baidu.swan.apps.ao.f.b GL() {
        if (this.baV == null) {
            return null;
        }
        return this.baV.GL();
    }

    public boolean isLandScape() {
        return this.baV != null && this.baV.isLandScape();
    }

    public void a(com.baidu.swan.apps.framework.b bVar) {
        if (this.baV != null) {
            this.baV.a(bVar);
        }
    }

    public void b(com.baidu.swan.apps.framework.b bVar) {
        if (this.baV != null) {
            this.baV.b(bVar);
        }
    }

    @UiThread
    public void dR(int i) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i + ", pid:" + Process.myPid());
        }
        com.baidu.swan.apps.w.a.UC().a(this, i, GJ());
    }

    public void GM() {
        if (this.bbc == null) {
            this.bbc = new com.baidu.swan.apps.view.c(this);
        }
        b.a acL = com.baidu.swan.apps.runtime.d.acF().acC().acL();
        U(acL.getOrientation(), acL.getAppFrameType());
        this.bbc.ek(1 == acL.getAppFrameType());
    }

    public void GN() {
        int i = 2;
        if (GJ() != null && GJ().getOrientation() == 1) {
            i = 3;
        }
        if (GD() != null) {
            GD().hk(i);
        }
    }

    private void GO() {
        this.bbe.a(new com.baidu.swan.apps.as.d.c<i.a, Boolean>() { // from class: com.baidu.swan.apps.SwanAppActivity.11
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
                SwanAppActivity.this.GR();
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
                SwanAppActivity.this.GP();
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
                SwanAppActivity.this.GG();
            }
        }, "event_first_action_launched");
        g.Xa().Xb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.x.b.a.c cVar) {
        if (GQ() && cVar.containsKey(" event_params_installer_progress")) {
            this.bbc.W(cVar.getFloat(" event_params_installer_progress"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GP() {
        if (!isDestroyed()) {
            if (com.baidu.swan.apps.runtime.d.acF().acC().available()) {
                bS(true);
            } else {
                com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppActivity.this.GT();
                    }
                }, baT);
            }
        }
    }

    private boolean GQ() {
        return (this.bbc == null || isDestroyed()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.x.b.a.c cVar) {
        if (GQ()) {
            this.bbc.mZ(cVar.getString("app_icon_url"));
            this.bbc.na(cVar.getString("app_name"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GR() {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        GM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.apps.x.b.a.c cVar) {
        if (this.baV != null && this.baV.SZ()) {
            bS("update_tag_by_activity_on_new_intent".equals(cVar.getString("app_update_tag")));
        }
    }

    public void q(String... strArr) {
        GI();
        HashSet dlf = strArr == null ? com.facebook.common.internal.i.dlf() : com.facebook.common.internal.i.L(strArr);
        if (dlf.contains("flag_finish_activity")) {
            if (dlf.contains("flag_remove_task")) {
                GT();
            } else {
                finish();
            }
        }
    }

    public String GS() {
        return this.baV == null ? "" : this.baV.bvR;
    }

    public boolean eZ(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.equals(str, GS());
    }

    private synchronized void bS(boolean z) {
        com.baidu.swan.apps.runtime.e acC = com.baidu.swan.apps.runtime.d.acF().acC();
        if (acC.available() && (eZ(acC.getAppId()) || a(acC))) {
            this.baV.a(this.baX, z);
            GU();
        }
    }

    private synchronized boolean a(com.baidu.swan.apps.runtime.e eVar) {
        boolean z;
        if (this.baV != null) {
            GI();
        }
        com.baidu.swan.apps.framework.c a = com.baidu.swan.apps.framework.e.a(this, eVar);
        if (a == null) {
            com.baidu.swan.apps.x.a.a.a(this, new com.baidu.swan.apps.ap.a().aI(5L).aJ(11L).mx("can not buildFramework"), eVar.Gz(), eVar.id);
            GT();
            z = false;
        } else {
            this.baV = a;
            m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.w.a.Ul().Ie();
                }
            }, "updateMobStat");
            U(eVar.acL().getOrientation(), eVar.Gz());
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GT() {
        com.baidu.swan.apps.as.c.T(this);
    }

    private void GU() {
        com.baidu.swan.apps.runtime.e acC = com.baidu.swan.apps.runtime.d.acF().acC();
        if (acC != null) {
            String Wf = acC.GJ().Wf();
            com.baidu.swan.apps.x.c.a iL = com.baidu.swan.apps.x.c.a.iL(acC.GJ().Wf());
            iL.iM("appId: " + acC.id + "  launchId: " + Wf).Wu();
            iL.Wn();
        }
    }
}
