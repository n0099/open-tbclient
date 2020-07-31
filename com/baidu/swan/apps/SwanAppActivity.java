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
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.OrientationEventListener;
import android.widget.FrameLayout;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.searchbox.process.ipc.util.TranslucentUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.ak;
import com.baidu.swan.apps.aq.aq;
import com.baidu.swan.apps.aq.d;
import com.baidu.swan.apps.aq.e;
import com.baidu.swan.apps.aq.o;
import com.baidu.swan.apps.aq.p;
import com.baidu.swan.apps.aq.u;
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
/* loaded from: classes7.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ServiceConnection, ActivityResultDispatcherHolder, com.baidu.swan.apps.am.f.c, a.InterfaceC0386a {
    private static final boolean DEBUG = b.DEBUG;
    private static final String bLY = SwanAppActivity.class.getName();
    private static final long bLZ = TimeUnit.SECONDS.toMillis(1);
    private com.baidu.swan.apps.framework.c bMa;
    private Messenger bMb;
    private ActivityResultDispatcher bMd;
    @Nullable
    private com.baidu.swan.apps.aq.b bMe;
    OrientationEventListener bMg;
    private d bMh;
    protected com.baidu.swan.apps.view.c bMi;
    private com.baidu.swan.apps.res.widget.floatlayer.a bMj;
    private FrameLifeState bMc = FrameLifeState.INACTIVATED;
    private String bMf = "sys";
    private boolean mIsFromSchema = false;
    private final com.baidu.swan.apps.runtime.b bMk = new com.baidu.swan.apps.runtime.b();
    private boolean bMl = false;

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        Bundle bundle2;
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(a.C0290a.aiapps_slide_in_from_right, a.C0290a.aiapps_hold);
        SwanAppProcessInfo.init(getProcessInfo());
        com.baidu.swan.apps.t.a.aib().Uv();
        com.baidu.swan.apps.process.messaging.client.a.apG().apI();
        this.mIsFromSchema = true;
        g.hn(bundle == null ? 0 : 1);
        super.onCreate(bundle);
        a(FrameLifeState.JUST_CREATED);
        if (!u.checkActivityRefuseServiceAndFinish(this)) {
            Intent intent = getIntent();
            boolean t = com.baidu.swan.apps.u.c.d.t(intent);
            if (t) {
                intent.putExtra("launch_id", SwanLauncher.aeM());
            }
            if (bundle != null && intent != null && (bundle2 = bundle.getBundle("swan_key_save_bundle")) != null) {
                intent.setExtrasClassLoader(getClass().getClassLoader());
                intent.putExtras(bundle2);
            }
            if (o(intent)) {
                Sm();
                return;
            }
            d.b.q(intent);
            com.baidu.swan.games.utils.so.d.x(intent);
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
            com.baidu.swan.apps.console.c.c("SwanAppActivity", "SwanAppActivity onCreate() savedInstanceState=", bundle);
            com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onCreate");
            setContentView(a.g.aiapps_activity);
            Si();
            com.baidu.swan.apps.runtime.d arr = com.baidu.swan.apps.runtime.d.arr();
            arr.j(this);
            arr.o(this.bMk);
            if (intent != null && (t || bundle == null)) {
                intent.putExtra("receive_launch_intent_time", currentTimeMillis);
                arr.d(intent.getExtras(), "update_tag_by_activity_on_create");
            }
            if (arr.apU() && t) {
                arr.arn().arz().lH("1250000000000000");
            }
            ai.S(this);
            if (Build.VERSION.SDK_INT != 26) {
                this.bMh = new com.baidu.swan.apps.aq.d(this);
            }
            if (this.bMh != null) {
                this.bMh.setCanSlide(false);
            }
            if (this.bMh != null) {
                this.bMh.onCreate();
            }
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!com.baidu.swan.apps.performance.b.b.aoo()) {
                        ak.awX();
                    }
                    com.baidu.swan.apps.t.a.ahv().Uh();
                    o.P(SwanAppActivity.this);
                }
            }, "initOnCreate");
            if (bundle == null || bundle.getInt("swan_key_save_task_id") != getTaskId()) {
                z = false;
            }
            this.bMl = z;
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (this.bMh != null) {
            this.bMh.awk();
        }
    }

    public com.baidu.swan.apps.aq.d RT() {
        return this.bMh;
    }

    private boolean o(Intent intent) {
        if (intent != null) {
            ComponentName component = intent.getComponent();
            return (component == null || component.getClassName().startsWith(bLY)) ? false : true;
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

    private void ab(int i, int i2) {
        if (-1 < i) {
            setRequestedOrientation(i == 1 ? 0 : 1);
        }
        if (i2 == 1) {
            e.N(this);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceConnected: " + componentName);
        }
        if (iBinder != null) {
            this.bMb = new Messenger(iBinder);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceDisconnected: " + componentName);
        }
        this.bMb = null;
    }

    public int RU() {
        if (this.bMa == null) {
            return -1;
        }
        return this.bMa.RU();
    }

    public com.baidu.swan.apps.framework.c RV() {
        return this.bMa;
    }

    public synchronized boolean RW() {
        boolean z;
        if (!isDestroyed() && this.bMa != null) {
            z = this.bMa.afT().activated();
        }
        return z;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onNewIntent");
        setIntent(intent);
        overridePendingTransition(a.C0290a.aiapps_slide_in_from_right, a.C0290a.aiapps_hold);
        if (DEBUG) {
            Log.i("SwanAppActivity", "onNewIntent:REORDER_TO_FRONT = " + ((intent.getFlags() & 131072) == 131072));
        }
        if (this.bMh != null) {
            this.bMh.awl();
        }
        this.mIsFromSchema = true;
        com.baidu.swan.apps.runtime.d arr = com.baidu.swan.apps.runtime.d.arr();
        arr.d(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (arr.apU() && com.baidu.swan.apps.u.c.d.t(intent)) {
            arr.arn().Se().lH("1250000000000000");
        }
        if (this.bMe != null) {
            this.bMe.b(intent, getTaskId());
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bMa == null || !this.bMa.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        if (this.bMd == null) {
            this.bMd = new ActivityResultDispatcher(this, 1);
        }
        return this.bMd;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0386a
    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a RX() {
        if (this.bMj == null) {
            this.bMj = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (FrameLayout) findViewById(16908290), 0);
        }
        return this.bMj;
    }

    public com.baidu.swan.apps.view.c RY() {
        return this.bMi;
    }

    public void RZ() {
        if (this.mIsFromSchema) {
            this.bMf = "schema";
        } else {
            this.bMf = "user";
        }
    }

    public String Sa() {
        return this.bMf;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        if (this.bMh != null) {
            this.bMh.closePane();
        }
        a(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !com.baidu.swan.apps.runtime.d.arr().apU()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            com.baidu.swan.apps.runtime.d.arr().d(intent.getExtras(), "update_tag_by_activity_on_create");
            if (com.baidu.swan.apps.runtime.d.arr().apU() && com.baidu.swan.apps.u.c.d.t(intent)) {
                com.baidu.swan.apps.runtime.d.arr().arn().arz().lH("1250000000000000");
            }
        }
        RZ();
        super.onResume();
        if (com.baidu.swan.apps.performance.b.b.aoo()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.7
                @Override // java.lang.Runnable
                public void run() {
                    if (SwanAppActivity.this.bMg == null) {
                        SwanAppActivity.this.bMg = new OrientationEventListener(SwanAppActivity.this, 2) { // from class: com.baidu.swan.apps.SwanAppActivity.7.1
                            @Override // android.view.OrientationEventListener
                            public void onOrientationChanged(int i) {
                                com.baidu.swan.apps.runtime.d.arr().cGW = i;
                            }
                        };
                    }
                    if (SwanAppActivity.this.mResumed) {
                        SwanAppActivity.this.bMg.enable();
                    }
                }
            }, "OrientationEventListener", 2);
        } else {
            if (this.bMg == null) {
                this.bMg = new OrientationEventListener(this, 2) { // from class: com.baidu.swan.apps.SwanAppActivity.8
                    @Override // android.view.OrientationEventListener
                    public void onOrientationChanged(int i) {
                        com.baidu.swan.apps.runtime.d.arr().cGW = i;
                    }
                };
            }
            this.bMg.enable();
        }
        if (this.bMh != null) {
            this.bMh.onResume();
        }
        a(FrameLifeState.JUST_RESUMED);
        aq.axo().reset();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        a(FrameLifeState.JUST_STARTED);
        this.mIsFromSchema = false;
        if (this.bMg != null) {
            this.bMg.disable();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        a(FrameLifeState.JUST_CREATED);
        if (!RW()) {
            i.anY();
        }
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.swan.apps.al.a.atW().aub();
                } catch (Exception e) {
                    if (SwanAppActivity.DEBUG) {
                        Log.e("SwanAppActivity", "SaveTraceException:", e);
                    }
                }
            }
        }, "tracer");
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            com.baidu.swan.apps.adaptation.b.a.c.UY().UZ().UX().onActivityResult(this, i, i2, intent);
        }
    }

    private synchronized void a(@NonNull FrameLifeState frameLifeState) {
        this.bMc = frameLifeState;
        Sb();
    }

    private synchronized void b(@NonNull FrameLifeState frameLifeState) {
        if (this.bMa != null && !this.bMa.afD()) {
            this.bMa.d(frameLifeState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Sb() {
        b(this.bMc);
    }

    @Nullable
    public f Sc() {
        if (this.bMa == null) {
            return null;
        }
        return this.bMa.Sc();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com.baidu.swan.apps.runtime.d.arr().p(this.bMk);
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onDestroy");
        this.bMg = null;
        Sd();
        if (this.bMb != null) {
            unbindService(this);
        }
        com.baidu.swan.apps.t.a.ahM().Uy();
        if (this.bMh != null) {
            this.bMh.onDestroy();
        }
        com.baidu.swan.apps.runtime.d.arr().k(this);
        a(FrameLifeState.INACTIVATED);
        com.baidu.swan.apps.v.f.release();
        String appId = com.baidu.swan.apps.runtime.d.arr().getAppId();
        if (com.baidu.swan.apps.performance.b.b.aoo()) {
            if (DEBUG) {
                com.baidu.swan.apps.u.d.a lT = com.baidu.swan.apps.u.d.a.lT(appId);
                lT.ajH().ajN();
                lT.ajI();
            }
        } else {
            com.baidu.swan.apps.u.d.a lT2 = com.baidu.swan.apps.u.d.a.lT(appId);
            lT2.ajH().ajN();
            lT2.ajI();
        }
        com.baidu.swan.apps.runtime.d.arr().v(new String[0]);
        this.bMe = null;
        super.onDestroy();
    }

    public synchronized void Sd() {
        if (this.bMi != null) {
            this.bMi.VA();
            if (DEBUG) {
                Log.i("SwanAppActivity", "destroyFrame resetLoadingView");
            }
        }
        com.baidu.swan.apps.view.c.axK();
        com.baidu.swan.apps.view.c.cK(com.baidu.swan.apps.t.a.ahj());
        f Sc = Sc();
        if (Sc != null) {
            Sc.abd().ag(0, 0).abj().abl();
        }
        com.baidu.swan.apps.textarea.c.release();
        if (this.bMa != null) {
            this.bMa.d(FrameLifeState.INACTIVATED);
            this.bMa.release();
            this.bMa = null;
        }
        com.baidu.swan.apps.setting.oauth.c.release();
        com.baidu.swan.apps.runtime.e arn = com.baidu.swan.apps.runtime.d.arr().arn();
        arn.arH().ati();
        arn.arI().clear();
        com.baidu.swan.apps.setting.b.a.atV();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        if (RW()) {
            this.bMa.onBackPressed();
            return;
        }
        HybridUbcFlow anY = i.anY();
        if (anY != null) {
            anY.r("value", "cancel");
            anY.bH("exitType", String.valueOf(4));
            anY.anD();
        }
        com.baidu.swan.apps.v.g.akA().eq(false);
        moveTaskToBack(true);
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2;
        Exception e;
        b.a Se = Se();
        boolean z3 = Se != null && "1230000000000000".equals(Se.ajg());
        if (this.bMe != null && !z3) {
            this.bMe.fG(false);
        }
        if (!RW() || com.baidu.swan.apps.runtime.d.arr().arn().arA()) {
            h.auv();
            Sm();
            return false;
        }
        try {
            z2 = super.moveTaskToBack(z);
            try {
                overridePendingTransition(0, a.C0290a.aiapps_slide_out_to_right_zadjustment_top);
                return z2;
            } catch (Exception e2) {
                e = e2;
                if (DEBUG) {
                    e.printStackTrace();
                    return z2;
                }
                return z2;
            }
        } catch (Exception e3) {
            z2 = false;
            e = e3;
        }
    }

    public SwanAppProcessInfo getProcessInfo() {
        return SwanAppProcessInfo.P0;
    }

    public b.a Se() {
        if (this.bMa == null) {
            return null;
        }
        return this.bMa.Se();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (this.bMa != null) {
            this.bMa.a(fVar);
        }
    }

    public void o(Bundle bundle) {
        com.baidu.swan.apps.process.messaging.service.b.b(this, bundle);
    }

    public void showLoadingView() {
        if (this.bMa != null) {
            this.bMa.showLoadingView();
        }
    }

    public void Sf() {
        if (this.bMa != null) {
            this.bMa.Sf();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (RW()) {
            this.bMa.onTrimMemory(i);
        }
    }

    @Override // com.baidu.swan.apps.am.f.c
    public com.baidu.swan.apps.am.f.b Sg() {
        if (this.bMa == null) {
            return null;
        }
        return this.bMa.Sg();
    }

    public boolean isLandScape() {
        return this.bMa != null && this.bMa.isLandScape();
    }

    public void a(com.baidu.swan.apps.framework.b bVar) {
        if (this.bMa != null) {
            this.bMa.a(bVar);
        }
    }

    public void b(com.baidu.swan.apps.framework.b bVar) {
        if (this.bMa != null) {
            this.bMa.b(bVar);
        }
    }

    @UiThread
    public void eq(int i) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i + ", pid:" + Process.myPid());
        }
        com.baidu.swan.apps.t.a.ahM().a(this, i, Se());
    }

    public void a(boolean z, @Nullable i.a aVar) {
        if (this.bMi == null) {
            this.bMi = new com.baidu.swan.apps.view.c(this);
        }
        this.bMi.a(1 == com.baidu.swan.apps.runtime.d.arr().arn().arz().getAppFrameType(), z, aVar);
    }

    public void Sh() {
        int i = 2;
        if (Se() != null && Se().getOrientation() == 1) {
            i = 3;
        }
        if (RY() != null) {
            RY().im(i);
        }
    }

    private void Si() {
        this.bMk.a(new com.baidu.swan.apps.aq.e.c<i.a, Boolean>() { // from class: com.baidu.swan.apps.SwanAppActivity.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.c
            /* renamed from: c */
            public Boolean I(i.a aVar) {
                return Boolean.valueOf(!SwanAppActivity.this.isDestroyed());
            }
        }).a(new com.baidu.swan.apps.aq.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: b */
            public void H(i.a aVar) {
                SwanAppActivity.this.a(true, aVar);
            }
        }, "event_on_still_maintaining").a(new com.baidu.swan.apps.aq.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: b */
            public void H(i.a aVar) {
                SwanAppActivity.this.a(aVar);
            }
        }, "event_on_app_occupied").a(new com.baidu.swan.apps.aq.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: b */
            public void H(i.a aVar) {
                SwanAppActivity.this.c(aVar);
            }
        }, "event_on_app_updated").a(new com.baidu.swan.apps.aq.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: b */
            public void H(i.a aVar) {
                SwanAppActivity.this.b(aVar);
            }
        }, "event_on_app_icon_update").a(new com.baidu.swan.apps.aq.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: b */
            public void H(i.a aVar) {
                SwanAppActivity.this.Sj();
            }
        }, "event_on_pkg_maintain_finish").a(new com.baidu.swan.apps.aq.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: b */
            public void H(i.a aVar) {
                SwanAppActivity.this.a((com.baidu.swan.apps.u.c.a.c) aVar);
            }
        }, "installer_on_progress").a(new com.baidu.swan.apps.aq.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: b */
            public void H(i.a aVar) {
                SwanAppActivity.this.Sb();
            }
        }, "event_first_action_launched");
        com.baidu.swan.apps.v.g.akA().akB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.u.c.a.c cVar) {
        if (Sk() && cVar.containsKey(" event_params_installer_progress")) {
            this.bMi.H(cVar.getFloat(" event_params_installer_progress"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj() {
        if (!isDestroyed()) {
            if (com.baidu.swan.apps.runtime.d.arr().arn().available()) {
                dh(true);
            } else {
                com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.5
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppActivity.this.Sm();
                    }
                }, bLZ);
            }
        }
    }

    private boolean Sk() {
        return (this.bMi == null || isDestroyed()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.u.c.a.c cVar) {
        if (Sk()) {
            this.bMi.qS(cVar.getString("app_icon_url"));
            this.bMi.hl(cVar.getString("app_name"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i.a aVar) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        b.a arz = com.baidu.swan.apps.runtime.d.arr().arn().arz();
        ab(arz.getOrientation(), arz.getAppFrameType());
        a(false, aVar);
        com.baidu.swan.apps.console.c.i("SwanAppActivity", "appName: " + arz.aee() + " appId: " + arz.getAppId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.apps.u.c.a.c cVar) {
        if (this.bMa != null && this.bMa.agf()) {
            dh("update_tag_by_activity_on_new_intent".equals(cVar.getString("app_update_tag")));
        }
    }

    public void o(String... strArr) {
        Sd();
        HashSet dCw = strArr == null ? com.facebook.common.internal.i.dCw() : com.facebook.common.internal.i.O(strArr);
        if (dCw.contains("flag_finish_activity")) {
            if (dCw.contains("flag_remove_task")) {
                Sm();
            } else {
                finish();
            }
        }
    }

    public String Sl() {
        return this.bMa == null ? "" : this.bMa.clc;
    }

    public boolean hd(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.equals(str, Sl());
    }

    private synchronized void dh(boolean z) {
        com.baidu.swan.apps.runtime.e arn = com.baidu.swan.apps.runtime.d.arr().arn();
        if (arn.available() && (hd(arn.getAppId()) || a(arn))) {
            this.bMa.a(this.bMc, z);
            if (com.baidu.swan.apps.performance.b.b.aoo()) {
                if (DEBUG) {
                    Sn();
                }
            } else {
                Sn();
            }
            if (this.bMe == null && com.baidu.swan.apps.aq.b.awe()) {
                this.bMe = com.baidu.swan.apps.aq.b.awd();
                if (!this.bMl) {
                    this.bMe.a(Se(), getTaskId());
                }
            }
        }
    }

    private synchronized boolean a(com.baidu.swan.apps.runtime.e eVar) {
        boolean z;
        if (this.bMa != null) {
            Sd();
        }
        com.baidu.swan.apps.framework.c a = com.baidu.swan.apps.framework.e.a(this, eVar);
        if (a == null) {
            com.baidu.swan.apps.u.b.a.a(this, new com.baidu.swan.apps.an.a().bJ(5L).bK(11L).qk("can not buildFramework"), eVar.RU(), eVar.id);
            Sm();
            z = false;
        } else {
            this.bMa = a;
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.6
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.t.a.ahv().Ui();
                }
            }, "updateMobStat");
            ab(eVar.arz().getOrientation(), eVar.RU());
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sm() {
        e.M(this);
    }

    private void Sn() {
        com.baidu.swan.apps.runtime.e arn = com.baidu.swan.apps.runtime.d.arr().arn();
        if (arn != null) {
            String ajz = arn.Se().ajz();
            com.baidu.swan.apps.u.d.a lT = com.baidu.swan.apps.u.d.a.lT(arn.Se().ajz());
            lT.lU("appId: " + arn.id + "  launchId: " + ajz).ajO();
            lT.ajI();
        }
    }
}
