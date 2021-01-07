package com.baidu.swan.apps;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.OrientationEventListener;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.searchbox.process.ipc.util.TranslucentUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.ap;
import com.baidu.swan.apps.ao.d;
import com.baidu.swan.apps.ao.e;
import com.baidu.swan.apps.ao.o;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.ao.u;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.core.turbo.d;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.framework.FrameLifeState;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.res.widget.floatlayer.a;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.statistic.g;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ServiceConnection, ActivityResultDispatcherHolder, com.baidu.swan.apps.ak.f.c, a.InterfaceC0473a {
    private static final boolean DEBUG = b.DEBUG;
    private static final String cEh = SwanAppActivity.class.getName();
    private static final long cEi = TimeUnit.SECONDS.toMillis(1);
    private com.baidu.swan.apps.framework.c cEj;
    private Messenger cEk;
    private ActivityResultDispatcher cEm;
    @Nullable
    private com.baidu.swan.apps.ao.b cEn;
    OrientationEventListener cEp;
    private d cEq;
    protected com.baidu.swan.apps.view.c cEr;
    private com.baidu.swan.apps.res.widget.floatlayer.a cEs;
    private boolean mIsBackground;
    private FrameLifeState cEl = FrameLifeState.INACTIVATED;
    private String cEo = "sys";
    private boolean mIsFromSchema = false;
    private final com.baidu.swan.apps.runtime.b cEt = new com.baidu.swan.apps.runtime.b();
    private boolean cEu = false;

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        Bundle bundle2;
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(a.C0372a.aiapps_slide_in_from_right, a.C0372a.aiapps_hold);
        SwanAppProcessInfo.init(getProcessInfo());
        com.baidu.swan.apps.t.a.aBl().alX();
        com.baidu.swan.apps.process.messaging.client.a.aJi().aJk();
        this.mIsFromSchema = true;
        g.setStartType(bundle == null ? 0 : 1);
        super.onCreate(bundle);
        a(FrameLifeState.JUST_CREATED);
        if (!u.S(this)) {
            Intent intent = getIntent();
            boolean v = com.baidu.swan.apps.u.c.d.v(intent);
            if (v) {
                intent.putExtra("launch_id", SwanLauncher.axf());
            }
            if (bundle != null && intent != null && (bundle2 = bundle.getBundle("swan_key_save_bundle")) != null) {
                intent.setExtrasClassLoader(getClass().getClassLoader());
                intent.putExtras(bundle2);
            }
            if (q(intent)) {
                ajD();
                return;
            }
            d.C0436d.s(intent);
            com.baidu.swan.games.utils.so.d.A(intent);
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
            com.baidu.swan.apps.console.c.d("SwanAppActivity", "SwanAppActivity onCreate() savedInstanceState=", bundle);
            com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onCreate");
            setContentView(a.g.aiapps_activity);
            ajz();
            com.baidu.swan.apps.runtime.d aMh = com.baidu.swan.apps.runtime.d.aMh();
            aMh.j(this);
            aMh.v(this.cEt);
            if (intent != null && (v || bundle == null)) {
                intent.putExtra("receive_launch_intent_time", currentTimeMillis);
                aMh.e(intent.getExtras(), "update_tag_by_activity_on_create");
            }
            if (aMh.aJx() && v) {
                aMh.aMd().aMp().pN("1250000000000000");
            }
            ah.U(this);
            if (Build.VERSION.SDK_INT != 26) {
                this.cEq = new com.baidu.swan.apps.ao.d(this);
            }
            if (this.cEq != null) {
                this.cEq.setCanSlide(false);
            }
            if (this.cEq != null) {
                this.cEq.onCreate();
            }
            p.a(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.t.a.aAE().alJ();
                    o.Q(SwanAppActivity.this);
                }
            }, "initOnCreate");
            if (bundle == null || bundle.getInt("swan_key_save_task_id") != getTaskId()) {
                z = false;
            }
            this.cEu = z;
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (this.cEq != null) {
            this.cEq.aQY();
        }
    }

    public com.baidu.swan.apps.ao.d ajk() {
        return this.cEq;
    }

    private boolean q(Intent intent) {
        if (intent != null) {
            ComponentName component = intent.getComponent();
            return (component == null || component.getClassName().startsWith(cEh)) ? false : true;
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
            bundle.putInt("swan_key_save_task_id", getTaskId());
        }
    }

    private void aa(int i, int i2) {
        if (-1 < i) {
            setRequestedOrientation(i == 1 ? 0 : 1);
        }
        if (i2 == 1) {
            e.O(this);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceConnected: " + componentName);
        }
        if (iBinder != null) {
            this.cEk = new Messenger(iBinder);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceDisconnected: " + componentName);
        }
        this.cEk = null;
    }

    public int ajl() {
        if (this.cEj == null) {
            return -1;
        }
        return this.cEj.ajl();
    }

    public com.baidu.swan.apps.framework.c ajm() {
        return this.cEj;
    }

    public synchronized boolean ajn() {
        boolean z;
        if (!isDestroyed() && this.cEj != null) {
            z = this.cEj.ayJ().activated();
        }
        return z;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onNewIntent");
        setIntent(intent);
        overridePendingTransition(a.C0372a.aiapps_slide_in_from_right, a.C0372a.aiapps_hold);
        if (DEBUG) {
            Log.i("SwanAppActivity", "onNewIntent:REORDER_TO_FRONT = " + ((intent.getFlags() & 131072) == 131072));
        }
        if (this.cEq != null) {
            this.cEq.aQZ();
        }
        this.mIsFromSchema = true;
        com.baidu.swan.apps.runtime.d aMh = com.baidu.swan.apps.runtime.d.aMh();
        aMh.e(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (aMh.aJx() && com.baidu.swan.apps.u.c.d.v(intent)) {
            aMh.aMd().ajv().pN("1250000000000000");
        }
        if (this.cEn != null) {
            this.cEn.b(intent, getTaskId());
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.cEj == null || !this.cEj.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        if (this.cEm == null) {
            this.cEm = new ActivityResultDispatcher(this, 1);
        }
        return this.cEm;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0473a
    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a ajo() {
        if (this.cEs == null) {
            this.cEs = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (FrameLayout) findViewById(16908290), 0);
        }
        return this.cEs;
    }

    public com.baidu.swan.apps.view.c ajp() {
        return this.cEr;
    }

    public void ajq() {
        if (this.mIsFromSchema) {
            this.cEo = "schema";
        } else {
            this.cEo = "user";
        }
    }

    public String ajr() {
        return this.cEo;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        this.mIsBackground = false;
        if (this.cEq != null) {
            this.cEq.closePane();
        }
        a(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !com.baidu.swan.apps.runtime.d.aMh().aJx()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            com.baidu.swan.apps.runtime.d.aMh().e(intent.getExtras(), "update_tag_by_activity_on_create");
            if (com.baidu.swan.apps.runtime.d.aMh().aJx() && com.baidu.swan.apps.u.c.d.v(intent)) {
                com.baidu.swan.apps.runtime.d.aMh().aMd().aMp().pN("1250000000000000");
            }
        }
        ajq();
        super.onResume();
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.6
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppActivity.this.cEp == null) {
                    SwanAppActivity.this.cEp = new OrientationEventListener(SwanAppActivity.this, 2) { // from class: com.baidu.swan.apps.SwanAppActivity.6.1
                        @Override // android.view.OrientationEventListener
                        public void onOrientationChanged(int i) {
                            com.baidu.swan.apps.runtime.d.aMh().dGA = i;
                        }
                    };
                }
                if (SwanAppActivity.this.mResumed) {
                    SwanAppActivity.this.cEp.enable();
                }
            }
        }, "OrientationEventListener", 2);
        if (this.cEq != null) {
            this.cEq.onResume();
        }
        a(FrameLifeState.JUST_RESUMED);
        ap.aSb().reset();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        a(FrameLifeState.JUST_STARTED);
        this.mIsFromSchema = false;
        if (this.cEp != null) {
            this.cEp.disable();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        this.mIsBackground = true;
        a(FrameLifeState.JUST_CREATED);
        if (!ajn()) {
            i.aHB();
        }
        p.a(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.swan.apps.aj.a.aOJ().aOO();
                } catch (Exception e) {
                    if (SwanAppActivity.DEBUG) {
                        Log.e("SwanAppActivity", "SaveTraceException:", e);
                    }
                }
            }
        }, "tracer");
        com.baidu.swan.apps.t.a.aBt().flush(false);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            com.baidu.swan.apps.adaptation.b.a.c.amD().amE().amC().onActivityResult(this, i, i2, intent);
        }
    }

    private synchronized void a(@NonNull FrameLifeState frameLifeState) {
        this.cEl = frameLifeState;
        ajs();
    }

    private synchronized void b(@NonNull FrameLifeState frameLifeState) {
        if (this.cEj != null && !this.cEj.ayt()) {
            this.cEj.d(frameLifeState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ajs() {
        b(this.cEl);
    }

    @Nullable
    public f ajt() {
        if (this.cEj == null) {
            return null;
        }
        return this.cEj.ajt();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com.baidu.swan.apps.runtime.d.aMh().w(this.cEt);
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onDestroy");
        this.cEp = null;
        aju();
        if (this.cEk != null) {
            unbindService(this);
        }
        com.baidu.swan.apps.t.a.aAW().ama();
        if (this.cEq != null) {
            this.cEq.onDestroy();
        }
        com.baidu.swan.apps.runtime.d.aMh().k(this);
        a(FrameLifeState.INACTIVATED);
        com.baidu.swan.apps.v.f.release();
        String appId = com.baidu.swan.apps.runtime.d.aMh().getAppId();
        if (DEBUG) {
            com.baidu.swan.apps.u.e.a pZ = com.baidu.swan.apps.u.e.a.pZ(appId);
            pZ.aCX().aDd();
            pZ.aCY();
        }
        com.baidu.swan.apps.runtime.d.aMh().F(new String[0]);
        this.cEn = null;
        super.onDestroy();
    }

    public synchronized void aju() {
        if (this.cEr != null) {
            this.cEr.ang();
            if (DEBUG) {
                Log.i("SwanAppActivity", "destroyFrame resetLoadingView");
            }
        }
        com.baidu.swan.apps.view.c.aSz();
        com.baidu.swan.apps.view.c.dU(com.baidu.swan.apps.t.a.aAs());
        f ajt = ajt();
        if (ajt != null) {
            ajt.asY().ai(0, 0).atd().atf();
        }
        com.baidu.swan.apps.textarea.c.release();
        if (this.cEj != null) {
            this.cEj.d(FrameLifeState.INACTIVATED);
            this.cEj.release();
            this.cEj = null;
        }
        com.baidu.swan.apps.setting.oauth.c.release();
        com.baidu.swan.apps.runtime.e aMd = com.baidu.swan.apps.runtime.d.aMh().aMd();
        aMd.aMx().aNU();
        aMd.aMy().clear();
        com.baidu.swan.apps.setting.b.a.aOI();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        if (ajn()) {
            this.cEj.onBackPressed();
            return;
        }
        HybridUbcFlow aHB = i.aHB();
        if (aHB != null) {
            aHB.q("value", "cancel");
            aHB.cn("exitType", String.valueOf(4));
            aHB.aHh();
        }
        com.baidu.swan.apps.v.g.aDQ().setForeground(false);
        moveTaskToBack(true);
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2;
        b.a ajv = ajv();
        boolean z3 = ajv != null && "1230000000000000".equals(ajv.aCw());
        if (this.cEn != null && !z3) {
            this.cEn.hA(false);
        }
        if (!ajn() || com.baidu.swan.apps.runtime.d.aMh().aMd().aMq()) {
            h.aPh();
            ajD();
            return false;
        }
        try {
            z2 = super.moveTaskToBack(z);
            try {
                overridePendingTransition(0, a.C0372a.aiapps_slide_out_to_right_zadjustment_top);
                return z2;
            } catch (Exception e) {
                e = e;
                if (DEBUG) {
                    e.printStackTrace();
                    return z2;
                }
                return z2;
            }
        } catch (Exception e2) {
            e = e2;
            z2 = false;
        }
    }

    public SwanAppProcessInfo getProcessInfo() {
        return SwanAppProcessInfo.P0;
    }

    public b.a ajv() {
        if (this.cEj == null) {
            return null;
        }
        return this.cEj.ajv();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (this.cEj != null) {
            this.cEj.a(fVar);
        }
    }

    public void m(Bundle bundle) {
        com.baidu.swan.apps.process.messaging.service.b.b(this, bundle);
    }

    public void showLoadingView() {
        if (this.cEj != null) {
            this.cEj.showLoadingView();
        }
    }

    public void ajw() {
        if (this.cEj != null) {
            this.cEj.ajw();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (ajn()) {
            this.cEj.onTrimMemory(i);
        }
    }

    @Override // com.baidu.swan.apps.ak.f.c
    public com.baidu.swan.apps.ak.f.b ajx() {
        if (this.cEj == null) {
            return null;
        }
        return this.cEj.ajx();
    }

    public boolean isLandScape() {
        return this.cEj != null && this.cEj.isLandScape();
    }

    public boolean isBackground() {
        return this.mIsBackground;
    }

    public void a(com.baidu.swan.apps.framework.b bVar) {
        if (this.cEj != null) {
            this.cEj.a(bVar);
        }
    }

    public void b(com.baidu.swan.apps.framework.b bVar) {
        if (this.cEj != null) {
            this.cEj.b(bVar);
        }
    }

    @UiThread
    public void hD(int i) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i + ", pid:" + Process.myPid());
        }
        com.baidu.swan.apps.t.a.aAW().a(this, i, ajv());
    }

    public void a(boolean z, @Nullable i.a aVar) {
        if (this.cEr == null) {
            this.cEr = new com.baidu.swan.apps.view.c(this);
        }
        this.cEr.a(1 == com.baidu.swan.apps.runtime.d.aMh().aMd().aMp().getAppFrameType(), z, aVar);
    }

    public void ajy() {
        int i = 2;
        if (ajv() != null && ajv().getOrientation() == 1) {
            i = 3;
        }
        if (ajp() != null) {
            ajp().lY(i);
        }
    }

    private void ajz() {
        this.cEt.a(new com.baidu.swan.apps.ao.e.c<i.a, Boolean>() { // from class: com.baidu.swan.apps.SwanAppActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.c
            /* renamed from: c */
            public Boolean M(i.a aVar) {
                return Boolean.valueOf(!SwanAppActivity.this.isDestroyed());
            }
        }).a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: b */
            public void L(i.a aVar) {
                SwanAppActivity.this.a(true, aVar);
            }
        }, "event_on_still_maintaining").a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: b */
            public void L(i.a aVar) {
                SwanAppActivity.this.a(aVar);
            }
        }, "event_on_app_occupied").a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: b */
            public void L(i.a aVar) {
                SwanAppActivity.this.c(aVar);
            }
        }, "event_on_app_updated").a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: b */
            public void L(i.a aVar) {
                SwanAppActivity.this.b(aVar);
            }
        }, "event_on_app_icon_update").a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: b */
            public void L(i.a aVar) {
                SwanAppActivity.this.ajA();
            }
        }, "event_on_pkg_maintain_finish").a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: b */
            public void L(i.a aVar) {
                SwanAppActivity.this.a((com.baidu.swan.apps.u.c.a.c) aVar);
            }
        }, "installer_on_progress").a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: b */
            public void L(i.a aVar) {
                SwanAppActivity.this.ajs();
            }
        }, "event_first_action_launched");
        com.baidu.swan.apps.v.g.aDQ().aDR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.u.c.a.c cVar) {
        if (ajB() && cVar.containsKey(" event_params_installer_progress")) {
            this.cEr.S(cVar.getFloat(" event_params_installer_progress"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajA() {
        if (!isDestroyed()) {
            if (com.baidu.swan.apps.runtime.d.aMh().aMd().available()) {
                eG(true);
            } else {
                com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppActivity.this.ajD();
                    }
                }, cEi);
            }
        }
    }

    private boolean ajB() {
        return (this.cEr == null || isDestroyed()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.u.c.a.c cVar) {
        if (ajB()) {
            this.cEr.vi(cVar.getString("app_icon_url"));
            this.cEr.kO(cVar.getString("app_name"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i.a aVar) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        b.a aMp = com.baidu.swan.apps.runtime.d.aMh().aMd().aMp();
        aa(aMp.getOrientation(), aMp.getAppFrameType());
        a(false, aVar);
        com.baidu.swan.apps.console.c.i("SwanAppActivity", "appName: " + aMp.awy() + " appId: " + aMp.getAppId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.apps.u.c.a.c cVar) {
        if (this.cEj != null && this.cEj.ayV()) {
            eG("update_tag_by_activity_on_new_intent".equals(cVar.getString("app_update_tag")));
        }
    }

    public void x(String... strArr) {
        aju();
        HashSet etZ = strArr == null ? com.facebook.common.internal.i.etZ() : com.facebook.common.internal.i.R(strArr);
        if (etZ.contains("flag_finish_activity")) {
            if (etZ.contains("flag_remove_task")) {
                ajD();
            } else {
                finish();
            }
        }
    }

    public String ajC() {
        return this.cEj == null ? "" : this.cEj.dfc;
    }

    public boolean kF(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.equals(str, ajC());
    }

    private synchronized void eG(boolean z) {
        com.baidu.swan.apps.runtime.e aMd = com.baidu.swan.apps.runtime.d.aMh().aMd();
        if (aMd.available() && (kF(aMd.getAppId()) || a(aMd))) {
            this.cEj.a(this.cEl, z);
            if (DEBUG) {
                ajE();
            }
            if (this.cEn == null && com.baidu.swan.apps.ao.b.aQR()) {
                this.cEn = com.baidu.swan.apps.ao.b.aQQ();
                if (!this.cEu) {
                    this.cEn.a(ajv(), getTaskId());
                }
            }
        }
    }

    private synchronized boolean a(com.baidu.swan.apps.runtime.e eVar) {
        boolean z;
        if (this.cEj != null) {
            aju();
        }
        com.baidu.swan.apps.framework.c a2 = com.baidu.swan.apps.framework.e.a(this, eVar);
        if (a2 == null) {
            com.baidu.swan.apps.u.b.a.a(this, new com.baidu.swan.apps.al.a().cV(5L).cW(11L).ux("can not buildFramework"), eVar.ajl(), eVar.id);
            ajD();
            z = false;
        } else {
            this.cEj = a2;
            p.a(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.5
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.t.a.aAE().alK();
                }
            }, "updateMobStat");
            aa(eVar.aMp().getOrientation(), eVar.ajl());
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajD() {
        e.N(this);
    }

    private void ajE() {
        com.baidu.swan.apps.runtime.e aMd = com.baidu.swan.apps.runtime.d.aMh().aMd();
        if (aMd != null) {
            String aCP = aMd.ajv().aCP();
            com.baidu.swan.apps.u.e.a pZ = com.baidu.swan.apps.u.e.a.pZ(aMd.ajv().aCP());
            pZ.qa("appId: " + aMd.id + "  launchId: " + aCP).aDe();
            pZ.aCY();
        }
    }
}
