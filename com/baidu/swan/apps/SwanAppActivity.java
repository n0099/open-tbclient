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
/* loaded from: classes8.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ServiceConnection, ActivityResultDispatcherHolder, com.baidu.swan.apps.ak.f.c, a.InterfaceC0456a {
    private static final boolean DEBUG = b.DEBUG;
    private static final String czv = SwanAppActivity.class.getName();
    private static final long czw = TimeUnit.SECONDS.toMillis(1);
    private ActivityResultDispatcher czA;
    @Nullable
    private com.baidu.swan.apps.ao.b czB;
    OrientationEventListener czD;
    private d czE;
    protected com.baidu.swan.apps.view.c czF;
    private com.baidu.swan.apps.res.widget.floatlayer.a czG;
    private com.baidu.swan.apps.framework.c czx;
    private Messenger czy;
    private boolean mIsBackground;
    private FrameLifeState czz = FrameLifeState.INACTIVATED;
    private String czC = "sys";
    private boolean mIsFromSchema = false;
    private final com.baidu.swan.apps.runtime.b czH = new com.baidu.swan.apps.runtime.b();
    private boolean czI = false;

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        Bundle bundle2;
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(a.C0355a.aiapps_slide_in_from_right, a.C0355a.aiapps_hold);
        SwanAppProcessInfo.init(getProcessInfo());
        com.baidu.swan.apps.t.a.axr().aid();
        com.baidu.swan.apps.process.messaging.client.a.aFo().aFq();
        this.mIsFromSchema = true;
        g.setStartType(bundle == null ? 0 : 1);
        super.onCreate(bundle);
        a(FrameLifeState.JUST_CREATED);
        if (!u.S(this)) {
            Intent intent = getIntent();
            boolean v = com.baidu.swan.apps.u.c.d.v(intent);
            if (v) {
                intent.putExtra("launch_id", SwanLauncher.atl());
            }
            if (bundle != null && intent != null && (bundle2 = bundle.getBundle("swan_key_save_bundle")) != null) {
                intent.setExtrasClassLoader(getClass().getClassLoader());
                intent.putExtras(bundle2);
            }
            if (q(intent)) {
                afJ();
                return;
            }
            d.C0419d.s(intent);
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
            afF();
            com.baidu.swan.apps.runtime.d aIn = com.baidu.swan.apps.runtime.d.aIn();
            aIn.j(this);
            aIn.v(this.czH);
            if (intent != null && (v || bundle == null)) {
                intent.putExtra("receive_launch_intent_time", currentTimeMillis);
                aIn.e(intent.getExtras(), "update_tag_by_activity_on_create");
            }
            if (aIn.aFD() && v) {
                aIn.aIj().aIv().oC("1250000000000000");
            }
            ah.U(this);
            if (Build.VERSION.SDK_INT != 26) {
                this.czE = new com.baidu.swan.apps.ao.d(this);
            }
            if (this.czE != null) {
                this.czE.setCanSlide(false);
            }
            if (this.czE != null) {
                this.czE.onCreate();
            }
            p.a(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.t.a.awK().ahP();
                    o.Q(SwanAppActivity.this);
                }
            }, "initOnCreate");
            if (bundle == null || bundle.getInt("swan_key_save_task_id") != getTaskId()) {
                z = false;
            }
            this.czI = z;
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (this.czE != null) {
            this.czE.aNe();
        }
    }

    public com.baidu.swan.apps.ao.d afq() {
        return this.czE;
    }

    private boolean q(Intent intent) {
        if (intent != null) {
            ComponentName component = intent.getComponent();
            return (component == null || component.getClassName().startsWith(czv)) ? false : true;
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
            this.czy = new Messenger(iBinder);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceDisconnected: " + componentName);
        }
        this.czy = null;
    }

    public int afr() {
        if (this.czx == null) {
            return -1;
        }
        return this.czx.afr();
    }

    public com.baidu.swan.apps.framework.c afs() {
        return this.czx;
    }

    public synchronized boolean aft() {
        boolean z;
        if (!isDestroyed() && this.czx != null) {
            z = this.czx.auP().activated();
        }
        return z;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onNewIntent");
        setIntent(intent);
        overridePendingTransition(a.C0355a.aiapps_slide_in_from_right, a.C0355a.aiapps_hold);
        if (DEBUG) {
            Log.i("SwanAppActivity", "onNewIntent:REORDER_TO_FRONT = " + ((intent.getFlags() & 131072) == 131072));
        }
        if (this.czE != null) {
            this.czE.aNf();
        }
        this.mIsFromSchema = true;
        com.baidu.swan.apps.runtime.d aIn = com.baidu.swan.apps.runtime.d.aIn();
        aIn.e(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (aIn.aFD() && com.baidu.swan.apps.u.c.d.v(intent)) {
            aIn.aIj().afB().oC("1250000000000000");
        }
        if (this.czB != null) {
            this.czB.b(intent, getTaskId());
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.czx == null || !this.czx.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        if (this.czA == null) {
            this.czA = new ActivityResultDispatcher(this, 1);
        }
        return this.czA;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0456a
    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a afu() {
        if (this.czG == null) {
            this.czG = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (FrameLayout) findViewById(16908290), 0);
        }
        return this.czG;
    }

    public com.baidu.swan.apps.view.c afv() {
        return this.czF;
    }

    public void afw() {
        if (this.mIsFromSchema) {
            this.czC = "schema";
        } else {
            this.czC = "user";
        }
    }

    public String afx() {
        return this.czC;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        this.mIsBackground = false;
        if (this.czE != null) {
            this.czE.closePane();
        }
        a(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !com.baidu.swan.apps.runtime.d.aIn().aFD()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            com.baidu.swan.apps.runtime.d.aIn().e(intent.getExtras(), "update_tag_by_activity_on_create");
            if (com.baidu.swan.apps.runtime.d.aIn().aFD() && com.baidu.swan.apps.u.c.d.v(intent)) {
                com.baidu.swan.apps.runtime.d.aIn().aIj().aIv().oC("1250000000000000");
            }
        }
        afw();
        super.onResume();
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.6
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppActivity.this.czD == null) {
                    SwanAppActivity.this.czD = new OrientationEventListener(SwanAppActivity.this, 2) { // from class: com.baidu.swan.apps.SwanAppActivity.6.1
                        @Override // android.view.OrientationEventListener
                        public void onOrientationChanged(int i) {
                            com.baidu.swan.apps.runtime.d.aIn().dBO = i;
                        }
                    };
                }
                if (SwanAppActivity.this.mResumed) {
                    SwanAppActivity.this.czD.enable();
                }
            }
        }, "OrientationEventListener", 2);
        if (this.czE != null) {
            this.czE.onResume();
        }
        a(FrameLifeState.JUST_RESUMED);
        ap.aOh().reset();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        a(FrameLifeState.JUST_STARTED);
        this.mIsFromSchema = false;
        if (this.czD != null) {
            this.czD.disable();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        this.mIsBackground = true;
        a(FrameLifeState.JUST_CREATED);
        if (!aft()) {
            i.aDH();
        }
        p.a(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.swan.apps.aj.a.aKP().aKU();
                } catch (Exception e) {
                    if (SwanAppActivity.DEBUG) {
                        Log.e("SwanAppActivity", "SaveTraceException:", e);
                    }
                }
            }
        }, "tracer");
        com.baidu.swan.apps.t.a.axz().flush(false);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            com.baidu.swan.apps.adaptation.b.a.c.aiJ().aiK().aiI().onActivityResult(this, i, i2, intent);
        }
    }

    private synchronized void a(@NonNull FrameLifeState frameLifeState) {
        this.czz = frameLifeState;
        afy();
    }

    private synchronized void b(@NonNull FrameLifeState frameLifeState) {
        if (this.czx != null && !this.czx.auz()) {
            this.czx.d(frameLifeState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void afy() {
        b(this.czz);
    }

    @Nullable
    public f afz() {
        if (this.czx == null) {
            return null;
        }
        return this.czx.afz();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com.baidu.swan.apps.runtime.d.aIn().w(this.czH);
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onDestroy");
        this.czD = null;
        afA();
        if (this.czy != null) {
            unbindService(this);
        }
        com.baidu.swan.apps.t.a.axc().aig();
        if (this.czE != null) {
            this.czE.onDestroy();
        }
        com.baidu.swan.apps.runtime.d.aIn().k(this);
        a(FrameLifeState.INACTIVATED);
        com.baidu.swan.apps.v.f.release();
        String appId = com.baidu.swan.apps.runtime.d.aIn().getAppId();
        if (DEBUG) {
            com.baidu.swan.apps.u.e.a oO = com.baidu.swan.apps.u.e.a.oO(appId);
            oO.azd().azj();
            oO.aze();
        }
        com.baidu.swan.apps.runtime.d.aIn().F(new String[0]);
        this.czB = null;
        super.onDestroy();
    }

    public synchronized void afA() {
        if (this.czF != null) {
            this.czF.ajm();
            if (DEBUG) {
                Log.i("SwanAppActivity", "destroyFrame resetLoadingView");
            }
        }
        com.baidu.swan.apps.view.c.aOF();
        com.baidu.swan.apps.view.c.dT(com.baidu.swan.apps.t.a.awy());
        f afz = afz();
        if (afz != null) {
            afz.apc().ai(0, 0).aph().apk();
        }
        com.baidu.swan.apps.textarea.c.release();
        if (this.czx != null) {
            this.czx.d(FrameLifeState.INACTIVATED);
            this.czx.release();
            this.czx = null;
        }
        com.baidu.swan.apps.setting.oauth.c.release();
        com.baidu.swan.apps.runtime.e aIj = com.baidu.swan.apps.runtime.d.aIn().aIj();
        aIj.aID().aKa();
        aIj.aIE().clear();
        com.baidu.swan.apps.setting.b.a.aKO();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        if (aft()) {
            this.czx.onBackPressed();
            return;
        }
        HybridUbcFlow aDH = i.aDH();
        if (aDH != null) {
            aDH.q("value", "cancel");
            aDH.cm("exitType", String.valueOf(4));
            aDH.aDn();
        }
        com.baidu.swan.apps.v.g.azW().setForeground(false);
        moveTaskToBack(true);
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2;
        b.a afB = afB();
        boolean z3 = afB != null && "1230000000000000".equals(afB.ayC());
        if (this.czB != null && !z3) {
            this.czB.hw(false);
        }
        if (!aft() || com.baidu.swan.apps.runtime.d.aIn().aIj().aIw()) {
            h.aLn();
            afJ();
            return false;
        }
        try {
            z2 = super.moveTaskToBack(z);
            try {
                overridePendingTransition(0, a.C0355a.aiapps_slide_out_to_right_zadjustment_top);
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

    public b.a afB() {
        if (this.czx == null) {
            return null;
        }
        return this.czx.afB();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (this.czx != null) {
            this.czx.a(fVar);
        }
    }

    public void m(Bundle bundle) {
        com.baidu.swan.apps.process.messaging.service.b.b(this, bundle);
    }

    public void showLoadingView() {
        if (this.czx != null) {
            this.czx.showLoadingView();
        }
    }

    public void afC() {
        if (this.czx != null) {
            this.czx.afC();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (aft()) {
            this.czx.onTrimMemory(i);
        }
    }

    @Override // com.baidu.swan.apps.ak.f.c
    public com.baidu.swan.apps.ak.f.b afD() {
        if (this.czx == null) {
            return null;
        }
        return this.czx.afD();
    }

    public boolean isLandScape() {
        return this.czx != null && this.czx.isLandScape();
    }

    public boolean isBackground() {
        return this.mIsBackground;
    }

    public void a(com.baidu.swan.apps.framework.b bVar) {
        if (this.czx != null) {
            this.czx.a(bVar);
        }
    }

    public void b(com.baidu.swan.apps.framework.b bVar) {
        if (this.czx != null) {
            this.czx.b(bVar);
        }
    }

    @UiThread
    public void fW(int i) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i + ", pid:" + Process.myPid());
        }
        com.baidu.swan.apps.t.a.axc().a(this, i, afB());
    }

    public void a(boolean z, @Nullable i.a aVar) {
        if (this.czF == null) {
            this.czF = new com.baidu.swan.apps.view.c(this);
        }
        this.czF.a(1 == com.baidu.swan.apps.runtime.d.aIn().aIj().aIv().getAppFrameType(), z, aVar);
    }

    public void afE() {
        int i = 2;
        if (afB() != null && afB().getOrientation() == 1) {
            i = 3;
        }
        if (afv() != null) {
            afv().ks(i);
        }
    }

    private void afF() {
        this.czH.a(new com.baidu.swan.apps.ao.e.c<i.a, Boolean>() { // from class: com.baidu.swan.apps.SwanAppActivity.3
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
                SwanAppActivity.this.afG();
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
                SwanAppActivity.this.afy();
            }
        }, "event_first_action_launched");
        com.baidu.swan.apps.v.g.azW().azX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.u.c.a.c cVar) {
        if (afH() && cVar.containsKey(" event_params_installer_progress")) {
            this.czF.S(cVar.getFloat(" event_params_installer_progress"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afG() {
        if (!isDestroyed()) {
            if (com.baidu.swan.apps.runtime.d.aIn().aIj().available()) {
                eC(true);
            } else {
                com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppActivity.this.afJ();
                    }
                }, czw);
            }
        }
    }

    private boolean afH() {
        return (this.czF == null || isDestroyed()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.u.c.a.c cVar) {
        if (afH()) {
            this.czF.tX(cVar.getString("app_icon_url"));
            this.czF.jD(cVar.getString("app_name"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i.a aVar) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        b.a aIv = com.baidu.swan.apps.runtime.d.aIn().aIj().aIv();
        aa(aIv.getOrientation(), aIv.getAppFrameType());
        a(false, aVar);
        com.baidu.swan.apps.console.c.i("SwanAppActivity", "appName: " + aIv.asE() + " appId: " + aIv.getAppId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.apps.u.c.a.c cVar) {
        if (this.czx != null && this.czx.avb()) {
            eC("update_tag_by_activity_on_new_intent".equals(cVar.getString("app_update_tag")));
        }
    }

    public void x(String... strArr) {
        afA();
        HashSet eqf = strArr == null ? com.facebook.common.internal.i.eqf() : com.facebook.common.internal.i.R(strArr);
        if (eqf.contains("flag_finish_activity")) {
            if (eqf.contains("flag_remove_task")) {
                afJ();
            } else {
                finish();
            }
        }
    }

    public String afI() {
        return this.czx == null ? "" : this.czx.dal;
    }

    public boolean ju(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.equals(str, afI());
    }

    private synchronized void eC(boolean z) {
        com.baidu.swan.apps.runtime.e aIj = com.baidu.swan.apps.runtime.d.aIn().aIj();
        if (aIj.available() && (ju(aIj.getAppId()) || a(aIj))) {
            this.czx.a(this.czz, z);
            if (DEBUG) {
                afK();
            }
            if (this.czB == null && com.baidu.swan.apps.ao.b.aMX()) {
                this.czB = com.baidu.swan.apps.ao.b.aMW();
                if (!this.czI) {
                    this.czB.a(afB(), getTaskId());
                }
            }
        }
    }

    private synchronized boolean a(com.baidu.swan.apps.runtime.e eVar) {
        boolean z;
        if (this.czx != null) {
            afA();
        }
        com.baidu.swan.apps.framework.c a2 = com.baidu.swan.apps.framework.e.a(this, eVar);
        if (a2 == null) {
            com.baidu.swan.apps.u.b.a.a(this, new com.baidu.swan.apps.al.a().cV(5L).cW(11L).tm("can not buildFramework"), eVar.afr(), eVar.id);
            afJ();
            z = false;
        } else {
            this.czx = a2;
            p.a(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.5
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.t.a.awK().ahQ();
                }
            }, "updateMobStat");
            aa(eVar.aIv().getOrientation(), eVar.afr());
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afJ() {
        e.N(this);
    }

    private void afK() {
        com.baidu.swan.apps.runtime.e aIj = com.baidu.swan.apps.runtime.d.aIn().aIj();
        if (aIj != null) {
            String ayV = aIj.afB().ayV();
            com.baidu.swan.apps.u.e.a oO = com.baidu.swan.apps.u.e.a.oO(aIj.afB().ayV());
            oO.oP("appId: " + aIj.id + "  launchId: " + ayV).azk();
            oO.aze();
        }
    }
}
