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
public class SwanAppActivity extends SwanAppBaseActivity implements ServiceConnection, ActivityResultDispatcherHolder, com.baidu.swan.apps.ao.f.c, a.InterfaceC0313a {
    private static final boolean DEBUG = b.DEBUG;
    private static final String bzg = SwanAppActivity.class.getName();
    private static final long bzh = TimeUnit.SECONDS.toMillis(1);
    private static final long bzi = TimeUnit.SECONDS.toMillis(5);
    private com.baidu.swan.apps.framework.c bzj;
    private Messenger bzk;
    private ActivityResultDispatcher bzm;
    OrientationEventListener bzo;
    private com.baidu.swan.apps.as.b bzp;
    protected com.baidu.swan.apps.view.c bzq;
    private com.baidu.swan.apps.res.widget.floatlayer.a bzr;
    private FrameLifeState bzl = FrameLifeState.INACTIVATED;
    private String bzn = "sys";
    private boolean mIsFromSchema = false;
    private final com.baidu.swan.apps.runtime.b bzs = new com.baidu.swan.apps.runtime.b();

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        Bundle bundle2;
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(a.C0227a.aiapps_slide_in_from_right, a.C0227a.aiapps_hold);
        SwanAppProcessInfo.init(getProcessInfo());
        com.baidu.swan.apps.w.a.acG().Qm();
        com.baidu.swan.apps.process.messaging.client.a.ajd().ajf();
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
            if (C(intent)) {
                OG();
                return;
            }
            d.b.E(intent);
            com.baidu.swan.games.utils.so.d.O(intent);
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
            OB();
            com.baidu.swan.apps.runtime.d akK = com.baidu.swan.apps.runtime.d.akK();
            akK.j(this);
            akK.e(this.bzs);
            boolean H = com.baidu.swan.apps.x.b.d.H(intent);
            if (intent != null && (H || bundle == null)) {
                intent.putExtra("receive_launch_intent_time", currentTimeMillis);
                akK.c(intent.getExtras(), "update_tag_by_activity_on_create");
            }
            if (akK.ajr() && H) {
                akK.akH().akQ().jN("1250000000000000");
            }
            af.T(this);
            if (Build.VERSION.SDK_INT != 26) {
                this.bzp = new com.baidu.swan.apps.as.b(this);
            }
            if (this.bzp != null) {
                this.bzp.setCanSlide(false);
            }
            if (this.bzp != null) {
                this.bzp.onCreate();
            }
            m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.w.a.aca().PP();
                }
            }, "initMobStat");
            ah.apm();
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (this.bzp != null) {
            this.bzp.aoD();
        }
    }

    public com.baidu.swan.apps.as.b Ol() {
        return this.bzp;
    }

    private boolean C(Intent intent) {
        if (intent != null) {
            ComponentName component = intent.getComponent();
            return (component == null || component.getClassName().startsWith(bzg)) ? false : true;
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
            this.bzk = new Messenger(iBinder);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceDisconnected: " + componentName);
        }
        this.bzk = null;
    }

    public int Om() {
        if (this.bzj == null) {
            return -1;
        }
        return this.bzj.Om();
    }

    public com.baidu.swan.apps.framework.c On() {
        return this.bzj;
    }

    public synchronized boolean Oo() {
        boolean z;
        if (!isDestroyed() && this.bzj != null) {
            z = this.bzj.aaB().activated();
        }
        return z;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onNewIntent");
        setIntent(intent);
        overridePendingTransition(a.C0227a.aiapps_slide_in_from_right, a.C0227a.aiapps_hold);
        if (DEBUG) {
            Log.i("SwanAppActivity", "onNewIntent:REORDER_TO_FRONT = " + ((intent.getFlags() & 131072) == 131072));
        }
        if (this.bzp != null) {
            this.bzp.aoE();
        }
        this.mIsFromSchema = true;
        com.baidu.swan.apps.runtime.d akK = com.baidu.swan.apps.runtime.d.akK();
        akK.c(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (akK.ajr() && com.baidu.swan.apps.x.b.d.H(intent)) {
            akK.akH().Ow().jN("1250000000000000");
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bzj == null || !this.bzj.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        if (this.bzm == null) {
            this.bzm = new ActivityResultDispatcher(this, 1);
        }
        return this.bzm;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0313a
    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a Op() {
        if (this.bzr == null) {
            this.bzr = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (FrameLayout) findViewById(16908290), 0);
        }
        return this.bzr;
    }

    public com.baidu.swan.apps.view.c Oq() {
        return this.bzq;
    }

    public void Or() {
        if (this.mIsFromSchema) {
            this.bzn = "schema";
        } else {
            this.bzn = "user";
        }
    }

    public String Os() {
        return this.bzn;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        if (this.bzp != null) {
            this.bzp.closePane();
        }
        a(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !com.baidu.swan.apps.runtime.d.akK().ajr()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            com.baidu.swan.apps.runtime.d.akK().c(intent.getExtras(), "update_tag_by_activity_on_create");
            if (com.baidu.swan.apps.runtime.d.akK().ajr() && com.baidu.swan.apps.x.b.d.H(intent)) {
                com.baidu.swan.apps.runtime.d.akK().akH().akQ().jN("1250000000000000");
            }
        }
        Or();
        super.onResume();
        if (this.bzo == null) {
            this.bzo = new OrientationEventListener(this, 2) { // from class: com.baidu.swan.apps.SwanAppActivity.4
                @Override // android.view.OrientationEventListener
                public void onOrientationChanged(int i) {
                    com.baidu.swan.apps.runtime.d.akK().cnQ = i;
                }
            };
        }
        this.bzo.enable();
        if (this.bzp != null) {
            this.bzp.onResume();
        }
        a(FrameLifeState.JUST_RESUMED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        a(FrameLifeState.JUST_STARTED);
        this.mIsFromSchema = false;
        this.bzo.disable();
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
            com.baidu.swan.apps.adaptation.b.a.c.QN().QO().QM().onActivityResult(this, i, i2, intent);
        }
    }

    private synchronized void a(@NonNull FrameLifeState frameLifeState) {
        this.bzl = frameLifeState;
        Ot();
    }

    private synchronized void b(@NonNull FrameLifeState frameLifeState) {
        if (this.bzj != null && !this.bzj.aam()) {
            this.bzj.d(frameLifeState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Ot() {
        b(this.bzl);
    }

    public com.baidu.swan.apps.core.d.e Ou() {
        if (this.bzj == null) {
            return null;
        }
        return this.bzj.Ou();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com.baidu.swan.apps.runtime.d.akK().f(this.bzs);
        if (DEBUG) {
            Log.d("SwanAppActivity", "——> onDestroy: ");
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onDestroy");
        this.bzo = null;
        Ov();
        if (this.bzk != null) {
            unbindService(this);
        }
        com.baidu.swan.apps.w.a.acr().Qp();
        if (this.bzp != null) {
            this.bzp.onDestroy();
        }
        com.baidu.swan.apps.runtime.d.akK().k(this);
        a(FrameLifeState.INACTIVATED);
        f.release();
        com.baidu.swan.apps.x.c.a jY = com.baidu.swan.apps.x.c.a.jY(com.baidu.swan.apps.runtime.d.akK().getAppId());
        jY.aeb().aei();
        jY.aec();
        com.baidu.swan.apps.runtime.d.akK().v(new String[0]);
        super.onDestroy();
    }

    public synchronized void Ov() {
        if (this.bzq != null) {
            this.bzq.Rq();
            this.bzq = null;
            if (DEBUG) {
                Log.i("SwanAppActivity", "destroyFrame resetLoadingView");
            }
        }
        com.baidu.swan.apps.core.d.e Ou = Ou();
        if (Ou != null) {
            Ou.Wi().ab(0, 0).Wo().Wq();
        }
        com.baidu.swan.apps.textarea.c.release();
        if (this.bzj != null) {
            this.bzj.d(FrameLifeState.INACTIVATED);
            this.bzj.release();
            this.bzj = null;
        }
        com.baidu.swan.apps.setting.oauth.c.release();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (DEBUG) {
            Log.d("SwanAppActivity", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onBackPressed");
        if (Oo()) {
            this.bzj.onBackPressed();
        } else {
            moveTaskToBack(true);
        }
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2 = false;
        if (!Oo() || com.baidu.swan.apps.runtime.d.akK().akH().akR()) {
            com.baidu.swan.apps.statistic.f.ani();
            OG();
            return false;
        }
        try {
            z2 = super.moveTaskToBack(z);
            overridePendingTransition(0, a.C0227a.aiapps_slide_out_to_right_zadjustment_top);
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

    public b.a Ow() {
        if (this.bzj == null) {
            return null;
        }
        return this.bzj.Ow();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (this.bzj != null) {
            this.bzj.a(fVar);
        }
    }

    public void m(Bundle bundle) {
        com.baidu.swan.apps.process.messaging.service.b.b(this, bundle);
    }

    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        if (this.bzj != null) {
            this.bzj.a(i, strArr, aVar);
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.swan.support.v4.app.a.InterfaceC0395a
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.bzj != null && !this.bzj.onRequestPermissionsResult(i, strArr, iArr)) {
            a(i, strArr, iArr);
        }
    }

    public void a(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void showLoadingView() {
        if (this.bzj != null) {
            this.bzj.showLoadingView();
        }
    }

    public void Ox() {
        if (this.bzj != null) {
            this.bzj.Ox();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (Oo()) {
            this.bzj.onTrimMemory(i);
        }
    }

    @Override // com.baidu.swan.apps.ao.f.c
    public com.baidu.swan.apps.ao.f.b Oy() {
        if (this.bzj == null) {
            return null;
        }
        return this.bzj.Oy();
    }

    public boolean isLandScape() {
        return this.bzj != null && this.bzj.isLandScape();
    }

    public void a(com.baidu.swan.apps.framework.b bVar) {
        if (this.bzj != null) {
            this.bzj.a(bVar);
        }
    }

    public void b(com.baidu.swan.apps.framework.b bVar) {
        if (this.bzj != null) {
            this.bzj.b(bVar);
        }
    }

    @UiThread
    public void dW(int i) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i + ", pid:" + Process.myPid());
        }
        com.baidu.swan.apps.w.a.acr().a(this, i, Ow());
    }

    public void Oz() {
        if (this.bzq == null) {
            this.bzq = new com.baidu.swan.apps.view.c(this);
        }
        b.a akQ = com.baidu.swan.apps.runtime.d.akK().akH().akQ();
        W(akQ.getOrientation(), akQ.getAppFrameType());
        this.bzq.fh(1 == akQ.getAppFrameType());
    }

    public void OA() {
        int i = 2;
        if (Ow() != null && Ow().getOrientation() == 1) {
            i = 3;
        }
        if (Oq() != null) {
            Oq().hr(i);
        }
    }

    private void OB() {
        this.bzs.a(new com.baidu.swan.apps.as.d.c<i.a, Boolean>() { // from class: com.baidu.swan.apps.SwanAppActivity.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.c
            /* renamed from: b */
            public Boolean F(i.a aVar) {
                return Boolean.valueOf(!SwanAppActivity.this.isDestroyed());
            }
        }).a(new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void E(i.a aVar) {
                SwanAppActivity.this.OE();
            }
        }, "event_on_app_occupied").a(new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void E(i.a aVar) {
                SwanAppActivity.this.c(aVar);
            }
        }, "event_on_app_updated").a(new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void E(i.a aVar) {
                SwanAppActivity.this.b(aVar);
            }
        }, "event_on_app_icon_update").a(new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void E(i.a aVar) {
                SwanAppActivity.this.OC();
            }
        }, "event_on_pkg_maintain_finish").a(new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void E(i.a aVar) {
                SwanAppActivity.this.a(aVar);
            }
        }, "installer_on_progress").a(new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void E(i.a aVar) {
                SwanAppActivity.this.Ot();
            }
        }, "event_first_action_launched");
        g.aeQ().aeR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.x.b.a.c cVar) {
        if (OD() && cVar.containsKey(" event_params_installer_progress")) {
            this.bzq.G(cVar.getFloat(" event_params_installer_progress"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OC() {
        if (!isDestroyed()) {
            if (com.baidu.swan.apps.runtime.d.akK().akH().available()) {
                cO(true);
            } else {
                com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppActivity.this.OG();
                    }
                }, bzh);
            }
        }
    }

    private boolean OD() {
        return (this.bzq == null || isDestroyed()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.x.b.a.c cVar) {
        if (OD()) {
            this.bzq.oo(cVar.getString("app_icon_url"));
            this.bzq.op(cVar.getString("app_name"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OE() {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        Oz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.apps.x.b.a.c cVar) {
        if (this.bzj != null && this.bzj.aaO()) {
            cO("update_tag_by_activity_on_new_intent".equals(cVar.getString("app_update_tag")));
        }
    }

    public void q(String... strArr) {
        Ov();
        HashSet dmY = strArr == null ? com.facebook.common.internal.i.dmY() : com.facebook.common.internal.i.N(strArr);
        if (dmY.contains("flag_finish_activity")) {
            if (dmY.contains("flag_remove_task")) {
                OG();
            } else {
                finish();
            }
        }
    }

    public String OF() {
        return this.bzj == null ? "" : this.bzj.bTX;
    }

    public boolean gl(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.equals(str, OF());
    }

    private synchronized void cO(boolean z) {
        com.baidu.swan.apps.runtime.e akH = com.baidu.swan.apps.runtime.d.akK().akH();
        if (akH.available() && (gl(akH.getAppId()) || a(akH))) {
            this.bzj.a(this.bzl, z);
            OH();
        }
    }

    private synchronized boolean a(com.baidu.swan.apps.runtime.e eVar) {
        boolean z;
        if (this.bzj != null) {
            Ov();
        }
        com.baidu.swan.apps.framework.c a = com.baidu.swan.apps.framework.e.a(this, eVar);
        if (a == null) {
            com.baidu.swan.apps.x.a.a.a(this, new com.baidu.swan.apps.ap.a().bn(5L).bo(11L).nK("can not buildFramework"), eVar.Om(), eVar.id);
            OG();
            z = false;
        } else {
            this.bzj = a;
            m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.w.a.aca().PQ();
                }
            }, "updateMobStat");
            W(eVar.akQ().getOrientation(), eVar.Om());
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OG() {
        com.baidu.swan.apps.as.c.P(this);
    }

    private void OH() {
        com.baidu.swan.apps.runtime.e akH = com.baidu.swan.apps.runtime.d.akK().akH();
        if (akH != null) {
            String adU = akH.Ow().adU();
            com.baidu.swan.apps.x.c.a jY = com.baidu.swan.apps.x.c.a.jY(akH.Ow().adU());
            jY.jZ("appId: " + akH.id + "  launchId: " + adU).aej();
            jY.aec();
        }
    }
}
