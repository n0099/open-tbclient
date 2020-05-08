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
public class SwanAppActivity extends SwanAppBaseActivity implements ServiceConnection, ActivityResultDispatcherHolder, com.baidu.swan.apps.ao.f.c, a.InterfaceC0334a {
    private static final boolean DEBUG = b.DEBUG;
    private static final String bzl = SwanAppActivity.class.getName();
    private static final long bzm = TimeUnit.SECONDS.toMillis(1);
    private static final long bzn = TimeUnit.SECONDS.toMillis(5);
    private com.baidu.swan.apps.framework.c bzo;
    private Messenger bzp;
    private ActivityResultDispatcher bzr;
    OrientationEventListener bzt;
    private com.baidu.swan.apps.as.b bzu;
    protected com.baidu.swan.apps.view.c bzv;
    private com.baidu.swan.apps.res.widget.floatlayer.a bzw;
    private FrameLifeState bzq = FrameLifeState.INACTIVATED;
    private String bzs = "sys";
    private boolean mIsFromSchema = false;
    private final com.baidu.swan.apps.runtime.b bzx = new com.baidu.swan.apps.runtime.b();

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        Bundle bundle2;
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(a.C0248a.aiapps_slide_in_from_right, a.C0248a.aiapps_hold);
        SwanAppProcessInfo.init(getProcessInfo());
        com.baidu.swan.apps.w.a.acF().Ql();
        com.baidu.swan.apps.process.messaging.client.a.ajc().aje();
        this.mIsFromSchema = true;
        e.gy(bundle == null ? 0 : 1);
        super.onCreate(bundle);
        a(FrameLifeState.JUST_CREATED);
        if (!r.checkActivityRefuseServiceAndFinish(this)) {
            Intent intent = getIntent();
            if (bundle != null && intent != null && (bundle2 = bundle.getBundle("swan_key_save_bundle")) != null) {
                bundle2.setClassLoader(getClass().getClassLoader());
                intent.putExtras(bundle2);
            }
            if (p(intent)) {
                OF();
                return;
            }
            d.b.r(intent);
            com.baidu.swan.games.utils.so.d.B(intent);
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
            OA();
            com.baidu.swan.apps.runtime.d akJ = com.baidu.swan.apps.runtime.d.akJ();
            akJ.j(this);
            akJ.e(this.bzx);
            boolean u = com.baidu.swan.apps.x.b.d.u(intent);
            if (intent != null && (u || bundle == null)) {
                intent.putExtra("receive_launch_intent_time", currentTimeMillis);
                akJ.c(intent.getExtras(), "update_tag_by_activity_on_create");
            }
            if (akJ.ajq() && u) {
                akJ.akG().akP().jN("1250000000000000");
            }
            af.T(this);
            if (Build.VERSION.SDK_INT != 26) {
                this.bzu = new com.baidu.swan.apps.as.b(this);
            }
            if (this.bzu != null) {
                this.bzu.setCanSlide(false);
            }
            if (this.bzu != null) {
                this.bzu.onCreate();
            }
            m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.w.a.abZ().PO();
                }
            }, "initMobStat");
            ah.apl();
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (this.bzu != null) {
            this.bzu.aoC();
        }
    }

    public com.baidu.swan.apps.as.b Ok() {
        return this.bzu;
    }

    private boolean p(Intent intent) {
        if (intent != null) {
            ComponentName component = intent.getComponent();
            return (component == null || component.getClassName().startsWith(bzl)) ? false : true;
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

    private void W(int i, int i2) {
        if (-1 < i) {
            setRequestedOrientation(i == 1 ? 0 : 1);
        }
        if (i2 == 1) {
            com.baidu.swan.apps.as.c.Q(this);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceConnected: " + componentName);
        }
        if (iBinder != null) {
            this.bzp = new Messenger(iBinder);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceDisconnected: " + componentName);
        }
        this.bzp = null;
    }

    public int Ol() {
        if (this.bzo == null) {
            return -1;
        }
        return this.bzo.Ol();
    }

    public com.baidu.swan.apps.framework.c Om() {
        return this.bzo;
    }

    public synchronized boolean On() {
        boolean z;
        if (!isDestroyed() && this.bzo != null) {
            z = this.bzo.aaA().activated();
        }
        return z;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onNewIntent");
        setIntent(intent);
        overridePendingTransition(a.C0248a.aiapps_slide_in_from_right, a.C0248a.aiapps_hold);
        if (DEBUG) {
            Log.i("SwanAppActivity", "onNewIntent:REORDER_TO_FRONT = " + ((intent.getFlags() & 131072) == 131072));
        }
        if (this.bzu != null) {
            this.bzu.aoD();
        }
        this.mIsFromSchema = true;
        com.baidu.swan.apps.runtime.d akJ = com.baidu.swan.apps.runtime.d.akJ();
        akJ.c(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (akJ.ajq() && com.baidu.swan.apps.x.b.d.u(intent)) {
            akJ.akG().Ov().jN("1250000000000000");
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bzo == null || !this.bzo.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        if (this.bzr == null) {
            this.bzr = new ActivityResultDispatcher(this, 1);
        }
        return this.bzr;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0334a
    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a Oo() {
        if (this.bzw == null) {
            this.bzw = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (FrameLayout) findViewById(16908290), 0);
        }
        return this.bzw;
    }

    public com.baidu.swan.apps.view.c Op() {
        return this.bzv;
    }

    public void Oq() {
        if (this.mIsFromSchema) {
            this.bzs = "schema";
        } else {
            this.bzs = "user";
        }
    }

    public String Or() {
        return this.bzs;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        if (this.bzu != null) {
            this.bzu.closePane();
        }
        a(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !com.baidu.swan.apps.runtime.d.akJ().ajq()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            com.baidu.swan.apps.runtime.d.akJ().c(intent.getExtras(), "update_tag_by_activity_on_create");
            if (com.baidu.swan.apps.runtime.d.akJ().ajq() && com.baidu.swan.apps.x.b.d.u(intent)) {
                com.baidu.swan.apps.runtime.d.akJ().akG().akP().jN("1250000000000000");
            }
        }
        Oq();
        super.onResume();
        if (this.bzt == null) {
            this.bzt = new OrientationEventListener(this, 2) { // from class: com.baidu.swan.apps.SwanAppActivity.4
                @Override // android.view.OrientationEventListener
                public void onOrientationChanged(int i) {
                    com.baidu.swan.apps.runtime.d.akJ().cnW = i;
                }
            };
        }
        this.bzt.enable();
        if (this.bzu != null) {
            this.bzu.onResume();
        }
        a(FrameLifeState.JUST_RESUMED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        a(FrameLifeState.JUST_STARTED);
        this.mIsFromSchema = false;
        this.bzt.disable();
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
            com.baidu.swan.apps.adaptation.b.a.c.QM().QN().QL().onActivityResult(this, i, i2, intent);
        }
    }

    private synchronized void a(@NonNull FrameLifeState frameLifeState) {
        this.bzq = frameLifeState;
        Os();
    }

    private synchronized void b(@NonNull FrameLifeState frameLifeState) {
        if (this.bzo != null && !this.bzo.aal()) {
            this.bzo.d(frameLifeState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Os() {
        b(this.bzq);
    }

    public com.baidu.swan.apps.core.d.e Ot() {
        if (this.bzo == null) {
            return null;
        }
        return this.bzo.Ot();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com.baidu.swan.apps.runtime.d.akJ().f(this.bzx);
        if (DEBUG) {
            Log.d("SwanAppActivity", "——> onDestroy: ");
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onDestroy");
        this.bzt = null;
        Ou();
        if (this.bzp != null) {
            unbindService(this);
        }
        com.baidu.swan.apps.w.a.acq().Qo();
        if (this.bzu != null) {
            this.bzu.onDestroy();
        }
        com.baidu.swan.apps.runtime.d.akJ().k(this);
        a(FrameLifeState.INACTIVATED);
        f.release();
        com.baidu.swan.apps.x.c.a jY = com.baidu.swan.apps.x.c.a.jY(com.baidu.swan.apps.runtime.d.akJ().getAppId());
        jY.aea().aeh();
        jY.aeb();
        com.baidu.swan.apps.runtime.d.akJ().v(new String[0]);
        super.onDestroy();
    }

    public synchronized void Ou() {
        if (this.bzv != null) {
            this.bzv.Rp();
            this.bzv = null;
            if (DEBUG) {
                Log.i("SwanAppActivity", "destroyFrame resetLoadingView");
            }
        }
        com.baidu.swan.apps.core.d.e Ot = Ot();
        if (Ot != null) {
            Ot.Wh().ab(0, 0).Wn().Wp();
        }
        com.baidu.swan.apps.textarea.c.release();
        if (this.bzo != null) {
            this.bzo.d(FrameLifeState.INACTIVATED);
            this.bzo.release();
            this.bzo = null;
        }
        com.baidu.swan.apps.setting.oauth.c.release();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (DEBUG) {
            Log.d("SwanAppActivity", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onBackPressed");
        if (On()) {
            this.bzo.onBackPressed();
        } else {
            moveTaskToBack(true);
        }
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2 = false;
        if (!On() || com.baidu.swan.apps.runtime.d.akJ().akG().akQ()) {
            com.baidu.swan.apps.statistic.f.anh();
            OF();
            return false;
        }
        try {
            z2 = super.moveTaskToBack(z);
            overridePendingTransition(0, a.C0248a.aiapps_slide_out_to_right_zadjustment_top);
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

    public b.a Ov() {
        if (this.bzo == null) {
            return null;
        }
        return this.bzo.Ov();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (this.bzo != null) {
            this.bzo.a(fVar);
        }
    }

    public void m(Bundle bundle) {
        com.baidu.swan.apps.process.messaging.service.b.b(this, bundle);
    }

    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        if (this.bzo != null) {
            this.bzo.a(i, strArr, aVar);
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.swan.support.v4.app.a.InterfaceC0416a
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.bzo != null && !this.bzo.onRequestPermissionsResult(i, strArr, iArr)) {
            a(i, strArr, iArr);
        }
    }

    public void a(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void showLoadingView() {
        if (this.bzo != null) {
            this.bzo.showLoadingView();
        }
    }

    public void Ow() {
        if (this.bzo != null) {
            this.bzo.Ow();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (On()) {
            this.bzo.onTrimMemory(i);
        }
    }

    @Override // com.baidu.swan.apps.ao.f.c
    public com.baidu.swan.apps.ao.f.b Ox() {
        if (this.bzo == null) {
            return null;
        }
        return this.bzo.Ox();
    }

    public boolean isLandScape() {
        return this.bzo != null && this.bzo.isLandScape();
    }

    public void a(com.baidu.swan.apps.framework.b bVar) {
        if (this.bzo != null) {
            this.bzo.a(bVar);
        }
    }

    public void b(com.baidu.swan.apps.framework.b bVar) {
        if (this.bzo != null) {
            this.bzo.b(bVar);
        }
    }

    @UiThread
    public void dW(int i) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i + ", pid:" + Process.myPid());
        }
        com.baidu.swan.apps.w.a.acq().a(this, i, Ov());
    }

    public void Oy() {
        if (this.bzv == null) {
            this.bzv = new com.baidu.swan.apps.view.c(this);
        }
        b.a akP = com.baidu.swan.apps.runtime.d.akJ().akG().akP();
        W(akP.getOrientation(), akP.getAppFrameType());
        this.bzv.fh(1 == akP.getAppFrameType());
    }

    public void Oz() {
        int i = 2;
        if (Ov() != null && Ov().getOrientation() == 1) {
            i = 3;
        }
        if (Op() != null) {
            Op().hr(i);
        }
    }

    private void OA() {
        this.bzx.a(new com.baidu.swan.apps.as.d.c<i.a, Boolean>() { // from class: com.baidu.swan.apps.SwanAppActivity.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.c
            /* renamed from: b */
            public Boolean G(i.a aVar) {
                return Boolean.valueOf(!SwanAppActivity.this.isDestroyed());
            }
        }).a(new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void F(i.a aVar) {
                SwanAppActivity.this.OD();
            }
        }, "event_on_app_occupied").a(new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void F(i.a aVar) {
                SwanAppActivity.this.c(aVar);
            }
        }, "event_on_app_updated").a(new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void F(i.a aVar) {
                SwanAppActivity.this.b(aVar);
            }
        }, "event_on_app_icon_update").a(new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void F(i.a aVar) {
                SwanAppActivity.this.OB();
            }
        }, "event_on_pkg_maintain_finish").a(new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void F(i.a aVar) {
                SwanAppActivity.this.a(aVar);
            }
        }, "installer_on_progress").a(new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void F(i.a aVar) {
                SwanAppActivity.this.Os();
            }
        }, "event_first_action_launched");
        g.aeP().aeQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.x.b.a.c cVar) {
        if (OC() && cVar.containsKey(" event_params_installer_progress")) {
            this.bzv.G(cVar.getFloat(" event_params_installer_progress"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OB() {
        if (!isDestroyed()) {
            if (com.baidu.swan.apps.runtime.d.akJ().akG().available()) {
                cO(true);
            } else {
                com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppActivity.this.OF();
                    }
                }, bzm);
            }
        }
    }

    private boolean OC() {
        return (this.bzv == null || isDestroyed()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.x.b.a.c cVar) {
        if (OC()) {
            this.bzv.oo(cVar.getString("app_icon_url"));
            this.bzv.op(cVar.getString("app_name"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OD() {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        Oy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.apps.x.b.a.c cVar) {
        if (this.bzo != null && this.bzo.aaN()) {
            cO("update_tag_by_activity_on_new_intent".equals(cVar.getString("app_update_tag")));
        }
    }

    public void q(String... strArr) {
        Ou();
        HashSet dmV = strArr == null ? com.facebook.common.internal.i.dmV() : com.facebook.common.internal.i.N(strArr);
        if (dmV.contains("flag_finish_activity")) {
            if (dmV.contains("flag_remove_task")) {
                OF();
            } else {
                finish();
            }
        }
    }

    public String OE() {
        return this.bzo == null ? "" : this.bzo.bUd;
    }

    public boolean gl(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.equals(str, OE());
    }

    private synchronized void cO(boolean z) {
        com.baidu.swan.apps.runtime.e akG = com.baidu.swan.apps.runtime.d.akJ().akG();
        if (akG.available() && (gl(akG.getAppId()) || a(akG))) {
            this.bzo.a(this.bzq, z);
            OG();
        }
    }

    private synchronized boolean a(com.baidu.swan.apps.runtime.e eVar) {
        boolean z;
        if (this.bzo != null) {
            Ou();
        }
        com.baidu.swan.apps.framework.c a = com.baidu.swan.apps.framework.e.a(this, eVar);
        if (a == null) {
            com.baidu.swan.apps.x.a.a.a(this, new com.baidu.swan.apps.ap.a().bn(5L).bo(11L).nK("can not buildFramework"), eVar.Ol(), eVar.id);
            OF();
            z = false;
        } else {
            this.bzo = a;
            m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.w.a.abZ().PP();
                }
            }, "updateMobStat");
            W(eVar.akP().getOrientation(), eVar.Ol());
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OF() {
        com.baidu.swan.apps.as.c.P(this);
    }

    private void OG() {
        com.baidu.swan.apps.runtime.e akG = com.baidu.swan.apps.runtime.d.akJ().akG();
        if (akG != null) {
            String adT = akG.Ov().adT();
            com.baidu.swan.apps.x.c.a jY = com.baidu.swan.apps.x.c.a.jY(akG.Ov().adT());
            jY.jZ("appId: " + akG.id + "  launchId: " + adT).aei();
            jY.aeb();
        }
    }
}
