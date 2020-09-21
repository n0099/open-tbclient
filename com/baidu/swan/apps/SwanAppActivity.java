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
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.ap;
import com.baidu.swan.apps.ap.d;
import com.baidu.swan.apps.ap.e;
import com.baidu.swan.apps.ap.o;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.ap.u;
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
/* loaded from: classes3.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ServiceConnection, ActivityResultDispatcherHolder, com.baidu.swan.apps.al.f.c, a.InterfaceC0427a {
    private static final boolean DEBUG = b.DEBUG;
    private static final String bTy = SwanAppActivity.class.getName();
    private static final long bTz = TimeUnit.SECONDS.toMillis(1);
    private com.baidu.swan.apps.framework.c bTA;
    private Messenger bTB;
    private ActivityResultDispatcher bTD;
    @Nullable
    private com.baidu.swan.apps.ap.b bTE;
    OrientationEventListener bTG;
    private d bTH;
    protected com.baidu.swan.apps.view.c bTI;
    private com.baidu.swan.apps.res.widget.floatlayer.a bTJ;
    private boolean mIsBackground;
    private FrameLifeState bTC = FrameLifeState.INACTIVATED;
    private String bTF = "sys";
    private boolean mIsFromSchema = false;
    private final com.baidu.swan.apps.runtime.b bTK = new com.baidu.swan.apps.runtime.b();
    private boolean bTL = false;

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        Bundle bundle2;
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(a.C0326a.aiapps_slide_in_from_right, a.C0326a.aiapps_hold);
        SwanAppProcessInfo.init(getProcessInfo());
        com.baidu.swan.apps.t.a.aqn().abg();
        com.baidu.swan.apps.process.messaging.client.a.ayl().ayn();
        this.mIsFromSchema = true;
        g.jF(bundle == null ? 0 : 1);
        super.onCreate(bundle);
        a(FrameLifeState.JUST_CREATED);
        if (!u.checkActivityRefuseServiceAndFinish(this)) {
            Intent intent = getIntent();
            boolean v = com.baidu.swan.apps.u.c.d.v(intent);
            if (v) {
                intent.putExtra("launch_id", SwanLauncher.amf());
            }
            if (bundle != null && intent != null && (bundle2 = bundle.getBundle("swan_key_save_bundle")) != null) {
                intent.setExtrasClassLoader(getClass().getClassLoader());
                intent.putExtras(bundle2);
            }
            if (q(intent)) {
                YQ();
                return;
            }
            d.C0391d.s(intent);
            com.baidu.swan.games.utils.so.d.z(intent);
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
            YM();
            com.baidu.swan.apps.runtime.d aAn = com.baidu.swan.apps.runtime.d.aAn();
            aAn.j(this);
            aAn.v(this.bTK);
            if (intent != null && (v || bundle == null)) {
                intent.putExtra("receive_launch_intent_time", currentTimeMillis);
                aAn.e(intent.getExtras(), "update_tag_by_activity_on_create");
            }
            if (aAn.ayA() && v) {
                aAn.aAj().aAv().nY("1250000000000000");
            }
            ah.S(this);
            if (Build.VERSION.SDK_INT != 26) {
                this.bTH = new com.baidu.swan.apps.ap.d(this);
            }
            if (this.bTH != null) {
                this.bTH.setCanSlide(false);
            }
            if (this.bTH != null) {
                this.bTH.onCreate();
            }
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.t.a.apG().aaS();
                    o.P(SwanAppActivity.this);
                }
            }, "initOnCreate");
            if (bundle == null || bundle.getInt("swan_key_save_task_id") != getTaskId()) {
                z = false;
            }
            this.bTL = z;
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (this.bTH != null) {
            this.bTH.aFe();
        }
    }

    public com.baidu.swan.apps.ap.d Yx() {
        return this.bTH;
    }

    private boolean q(Intent intent) {
        if (intent != null) {
            ComponentName component = intent.getComponent();
            return (component == null || component.getClassName().startsWith(bTy)) ? false : true;
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

    private void ad(int i, int i2) {
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
            this.bTB = new Messenger(iBinder);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceDisconnected: " + componentName);
        }
        this.bTB = null;
    }

    public int Yy() {
        if (this.bTA == null) {
            return -1;
        }
        return this.bTA.Yy();
    }

    public com.baidu.swan.apps.framework.c Yz() {
        return this.bTA;
    }

    public synchronized boolean YA() {
        boolean z;
        if (!isDestroyed() && this.bTA != null) {
            z = this.bTA.anK().activated();
        }
        return z;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onNewIntent");
        setIntent(intent);
        overridePendingTransition(a.C0326a.aiapps_slide_in_from_right, a.C0326a.aiapps_hold);
        if (DEBUG) {
            Log.i("SwanAppActivity", "onNewIntent:REORDER_TO_FRONT = " + ((intent.getFlags() & 131072) == 131072));
        }
        if (this.bTH != null) {
            this.bTH.aFf();
        }
        this.mIsFromSchema = true;
        com.baidu.swan.apps.runtime.d aAn = com.baidu.swan.apps.runtime.d.aAn();
        aAn.e(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (aAn.ayA() && com.baidu.swan.apps.u.c.d.v(intent)) {
            aAn.aAj().YI().nY("1250000000000000");
        }
        if (this.bTE != null) {
            this.bTE.b(intent, getTaskId());
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bTA == null || !this.bTA.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        if (this.bTD == null) {
            this.bTD = new ActivityResultDispatcher(this, 1);
        }
        return this.bTD;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0427a
    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a YB() {
        if (this.bTJ == null) {
            this.bTJ = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (FrameLayout) findViewById(16908290), 0);
        }
        return this.bTJ;
    }

    public com.baidu.swan.apps.view.c YC() {
        return this.bTI;
    }

    public void YD() {
        if (this.mIsFromSchema) {
            this.bTF = "schema";
        } else {
            this.bTF = "user";
        }
    }

    public String YE() {
        return this.bTF;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        this.mIsBackground = false;
        if (this.bTH != null) {
            this.bTH.closePane();
        }
        a(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !com.baidu.swan.apps.runtime.d.aAn().ayA()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            com.baidu.swan.apps.runtime.d.aAn().e(intent.getExtras(), "update_tag_by_activity_on_create");
            if (com.baidu.swan.apps.runtime.d.aAn().ayA() && com.baidu.swan.apps.u.c.d.v(intent)) {
                com.baidu.swan.apps.runtime.d.aAn().aAj().aAv().nY("1250000000000000");
            }
        }
        YD();
        super.onResume();
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.6
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppActivity.this.bTG == null) {
                    SwanAppActivity.this.bTG = new OrientationEventListener(SwanAppActivity.this, 2) { // from class: com.baidu.swan.apps.SwanAppActivity.6.1
                        @Override // android.view.OrientationEventListener
                        public void onOrientationChanged(int i) {
                            com.baidu.swan.apps.runtime.d.aAn().cRZ = i;
                        }
                    };
                }
                if (SwanAppActivity.this.mResumed) {
                    SwanAppActivity.this.bTG.enable();
                }
            }
        }, "OrientationEventListener", 2);
        if (this.bTH != null) {
            this.bTH.onResume();
        }
        a(FrameLifeState.JUST_RESUMED);
        ap.aGh().reset();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        a(FrameLifeState.JUST_STARTED);
        this.mIsFromSchema = false;
        if (this.bTG != null) {
            this.bTG.disable();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        this.mIsBackground = true;
        a(FrameLifeState.JUST_CREATED);
        if (!YA()) {
            i.awC();
        }
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.swan.apps.ak.a.aCP().aCU();
                } catch (Exception e) {
                    if (SwanAppActivity.DEBUG) {
                        Log.e("SwanAppActivity", "SaveTraceException:", e);
                    }
                }
            }
        }, "tracer");
        com.baidu.swan.apps.t.a.aqv().flush(false);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            com.baidu.swan.apps.adaptation.b.a.c.abM().abN().abL().onActivityResult(this, i, i2, intent);
        }
    }

    private synchronized void a(@NonNull FrameLifeState frameLifeState) {
        this.bTC = frameLifeState;
        YF();
    }

    private synchronized void b(@NonNull FrameLifeState frameLifeState) {
        if (this.bTA != null && !this.bTA.anu()) {
            this.bTA.d(frameLifeState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void YF() {
        b(this.bTC);
    }

    @Nullable
    public f YG() {
        if (this.bTA == null) {
            return null;
        }
        return this.bTA.YG();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com.baidu.swan.apps.runtime.d.aAn().w(this.bTK);
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onDestroy");
        this.bTG = null;
        YH();
        if (this.bTB != null) {
            unbindService(this);
        }
        com.baidu.swan.apps.t.a.apY().abj();
        if (this.bTH != null) {
            this.bTH.onDestroy();
        }
        com.baidu.swan.apps.runtime.d.aAn().k(this);
        a(FrameLifeState.INACTIVATED);
        com.baidu.swan.apps.v.f.release();
        String appId = com.baidu.swan.apps.runtime.d.aAn().getAppId();
        if (DEBUG) {
            com.baidu.swan.apps.u.e.a ol = com.baidu.swan.apps.u.e.a.ol(appId);
            ol.arY().ase();
            ol.arZ();
        }
        com.baidu.swan.apps.runtime.d.aAn().w(new String[0]);
        this.bTE = null;
        super.onDestroy();
    }

    public synchronized void YH() {
        if (this.bTI != null) {
            this.bTI.acp();
            if (DEBUG) {
                Log.i("SwanAppActivity", "destroyFrame resetLoadingView");
            }
        }
        com.baidu.swan.apps.view.c.aGC();
        com.baidu.swan.apps.view.c.cP(com.baidu.swan.apps.t.a.apu());
        f YG = YG();
        if (YG != null) {
            YG.aia().al(0, 0).aif().aih();
        }
        com.baidu.swan.apps.textarea.c.release();
        if (this.bTA != null) {
            this.bTA.d(FrameLifeState.INACTIVATED);
            this.bTA.release();
            this.bTA = null;
        }
        com.baidu.swan.apps.setting.oauth.c.release();
        com.baidu.swan.apps.runtime.e aAj = com.baidu.swan.apps.runtime.d.aAn().aAj();
        aAj.aAD().aCa();
        aAj.aAE().clear();
        com.baidu.swan.apps.setting.b.a.aCO();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        if (YA()) {
            this.bTA.onBackPressed();
            return;
        }
        HybridUbcFlow awC = i.awC();
        if (awC != null) {
            awC.r("value", "cancel");
            awC.bW("exitType", String.valueOf(4));
            awC.awh();
        }
        com.baidu.swan.apps.v.g.asS().setForeground(false);
        moveTaskToBack(true);
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2;
        Exception e;
        b.a YI = YI();
        boolean z3 = YI != null && "1230000000000000".equals(YI.arx());
        if (this.bTE != null && !z3) {
            this.bTE.fY(false);
        }
        if (!YA() || com.baidu.swan.apps.runtime.d.aAn().aAj().aAw()) {
            h.aDo();
            YQ();
            return false;
        }
        try {
            z2 = super.moveTaskToBack(z);
            try {
                overridePendingTransition(0, a.C0326a.aiapps_slide_out_to_right_zadjustment_top);
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

    public b.a YI() {
        if (this.bTA == null) {
            return null;
        }
        return this.bTA.YI();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (this.bTA != null) {
            this.bTA.a(fVar);
        }
    }

    public void m(Bundle bundle) {
        com.baidu.swan.apps.process.messaging.service.b.b(this, bundle);
    }

    public void showLoadingView() {
        if (this.bTA != null) {
            this.bTA.showLoadingView();
        }
    }

    public void YJ() {
        if (this.bTA != null) {
            this.bTA.YJ();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (YA()) {
            this.bTA.onTrimMemory(i);
        }
    }

    @Override // com.baidu.swan.apps.al.f.c
    public com.baidu.swan.apps.al.f.b YK() {
        if (this.bTA == null) {
            return null;
        }
        return this.bTA.YK();
    }

    public boolean isLandScape() {
        return this.bTA != null && this.bTA.isLandScape();
    }

    public boolean isBackground() {
        return this.mIsBackground;
    }

    public void a(com.baidu.swan.apps.framework.b bVar) {
        if (this.bTA != null) {
            this.bTA.a(bVar);
        }
    }

    public void b(com.baidu.swan.apps.framework.b bVar) {
        if (this.bTA != null) {
            this.bTA.b(bVar);
        }
    }

    @UiThread
    public void gx(int i) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i + ", pid:" + Process.myPid());
        }
        com.baidu.swan.apps.t.a.apY().a(this, i, YI());
    }

    public void a(boolean z, @Nullable i.a aVar) {
        if (this.bTI == null) {
            this.bTI = new com.baidu.swan.apps.view.c(this);
        }
        this.bTI.a(1 == com.baidu.swan.apps.runtime.d.aAn().aAj().aAv().getAppFrameType(), z, aVar);
    }

    public void YL() {
        int i = 2;
        if (YI() != null && YI().getOrientation() == 1) {
            i = 3;
        }
        if (YC() != null) {
            YC().kF(i);
        }
    }

    private void YM() {
        this.bTK.a(new com.baidu.swan.apps.ap.e.c<i.a, Boolean>() { // from class: com.baidu.swan.apps.SwanAppActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.c
            /* renamed from: c */
            public Boolean K(i.a aVar) {
                return Boolean.valueOf(!SwanAppActivity.this.isDestroyed());
            }
        }).a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void J(i.a aVar) {
                SwanAppActivity.this.a(true, aVar);
            }
        }, "event_on_still_maintaining").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void J(i.a aVar) {
                SwanAppActivity.this.a(aVar);
            }
        }, "event_on_app_occupied").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void J(i.a aVar) {
                SwanAppActivity.this.c(aVar);
            }
        }, "event_on_app_updated").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void J(i.a aVar) {
                SwanAppActivity.this.b(aVar);
            }
        }, "event_on_app_icon_update").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void J(i.a aVar) {
                SwanAppActivity.this.YN();
            }
        }, "event_on_pkg_maintain_finish").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void J(i.a aVar) {
                SwanAppActivity.this.a((com.baidu.swan.apps.u.c.a.c) aVar);
            }
        }, "installer_on_progress").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void J(i.a aVar) {
                SwanAppActivity.this.YF();
            }
        }, "event_first_action_launched");
        com.baidu.swan.apps.v.g.asS().asT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.u.c.a.c cVar) {
        if (YO() && cVar.containsKey(" event_params_installer_progress")) {
            this.bTI.L(cVar.getFloat(" event_params_installer_progress"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YN() {
        if (!isDestroyed()) {
            if (com.baidu.swan.apps.runtime.d.aAn().aAj().available()) {
                m33do(true);
            } else {
                com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppActivity.this.YQ();
                    }
                }, bTz);
            }
        }
    }

    private boolean YO() {
        return (this.bTI == null || isDestroyed()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.u.c.a.c cVar) {
        if (YO()) {
            this.bTI.to(cVar.getString("app_icon_url"));
            this.bTI.ja(cVar.getString("app_name"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i.a aVar) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        b.a aAv = com.baidu.swan.apps.runtime.d.aAn().aAj().aAv();
        ad(aAv.getOrientation(), aAv.getAppFrameType());
        a(false, aVar);
        com.baidu.swan.apps.console.c.i("SwanAppActivity", "appName: " + aAv.aly() + " appId: " + aAv.getAppId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.apps.u.c.a.c cVar) {
        if (this.bTA != null && this.bTA.anW()) {
            m33do("update_tag_by_activity_on_new_intent".equals(cVar.getString("app_update_tag")));
        }
    }

    public void o(String... strArr) {
        YH();
        HashSet dSE = strArr == null ? com.facebook.common.internal.i.dSE() : com.facebook.common.internal.i.N(strArr);
        if (dSE.contains("flag_finish_activity")) {
            if (dSE.contains("flag_remove_task")) {
                YQ();
            } else {
                finish();
            }
        }
    }

    public String YP() {
        return this.bTA == null ? "" : this.bTA.cuz;
    }

    public boolean iR(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.equals(str, YP());
    }

    /* renamed from: do  reason: not valid java name */
    private synchronized void m33do(boolean z) {
        com.baidu.swan.apps.runtime.e aAj = com.baidu.swan.apps.runtime.d.aAn().aAj();
        if (aAj.available() && (iR(aAj.getAppId()) || a(aAj))) {
            this.bTA.a(this.bTC, z);
            if (DEBUG) {
                YR();
            }
            if (this.bTE == null && com.baidu.swan.apps.ap.b.aEX()) {
                this.bTE = com.baidu.swan.apps.ap.b.aEW();
                if (!this.bTL) {
                    this.bTE.a(YI(), getTaskId());
                }
            }
        }
    }

    private synchronized boolean a(com.baidu.swan.apps.runtime.e eVar) {
        boolean z;
        if (this.bTA != null) {
            YH();
        }
        com.baidu.swan.apps.framework.c a = com.baidu.swan.apps.framework.e.a(this, eVar);
        if (a == null) {
            com.baidu.swan.apps.u.b.a.a(this, new com.baidu.swan.apps.am.a().bP(5L).bQ(11L).sF("can not buildFramework"), eVar.Yy(), eVar.id);
            YQ();
            z = false;
        } else {
            this.bTA = a;
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.5
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.t.a.apG().aaT();
                }
            }, "updateMobStat");
            ad(eVar.aAv().getOrientation(), eVar.Yy());
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YQ() {
        e.M(this);
    }

    private void YR() {
        com.baidu.swan.apps.runtime.e aAj = com.baidu.swan.apps.runtime.d.aAn().aAj();
        if (aAj != null) {
            String arQ = aAj.YI().arQ();
            com.baidu.swan.apps.u.e.a ol = com.baidu.swan.apps.u.e.a.ol(aAj.YI().arQ());
            ol.om("appId: " + aAj.id + "  launchId: " + arQ).asf();
            ol.arZ();
        }
    }
}
