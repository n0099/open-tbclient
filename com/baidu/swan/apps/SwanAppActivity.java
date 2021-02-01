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
public class SwanAppActivity extends SwanAppBaseActivity implements ServiceConnection, ActivityResultDispatcherHolder, com.baidu.swan.apps.ak.f.c, a.InterfaceC0453a {
    private static final boolean DEBUG = b.DEBUG;
    private static final String cBR = SwanAppActivity.class.getName();
    private static final long cBS = TimeUnit.SECONDS.toMillis(1);
    private com.baidu.swan.apps.framework.c cBT;
    private Messenger cBU;
    private ActivityResultDispatcher cBW;
    @Nullable
    private com.baidu.swan.apps.ao.b cBX;
    OrientationEventListener cBZ;
    private d cCa;
    protected com.baidu.swan.apps.view.c cCb;
    private com.baidu.swan.apps.res.widget.floatlayer.a cCc;
    private boolean mIsBackground;
    private FrameLifeState cBV = FrameLifeState.INACTIVATED;
    private String cBY = "sys";
    private boolean mIsFromSchema = false;
    private final com.baidu.swan.apps.runtime.b cCd = new com.baidu.swan.apps.runtime.b();
    private boolean cCe = false;

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        Bundle bundle2;
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(a.C0352a.aiapps_slide_in_from_right, a.C0352a.aiapps_hold);
        SwanAppProcessInfo.init(getProcessInfo());
        com.baidu.swan.apps.t.a.axP().aiB();
        com.baidu.swan.apps.process.messaging.client.a.aFJ().aFL();
        this.mIsFromSchema = true;
        g.setStartType(bundle == null ? 0 : 1);
        super.onCreate(bundle);
        a(FrameLifeState.JUST_CREATED);
        if (!u.M(this)) {
            Intent intent = getIntent();
            boolean v = com.baidu.swan.apps.u.c.d.v(intent);
            if (v) {
                intent.putExtra("launch_id", SwanLauncher.atJ());
            }
            if (bundle != null && intent != null && (bundle2 = bundle.getBundle("swan_key_save_bundle")) != null) {
                intent.setExtrasClassLoader(getClass().getClassLoader());
                intent.putExtras(bundle2);
            }
            if (q(intent)) {
                agh();
                return;
            }
            d.C0416d.s(intent);
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
            agd();
            com.baidu.swan.apps.runtime.d aIG = com.baidu.swan.apps.runtime.d.aIG();
            aIG.j(this);
            aIG.v(this.cCd);
            if (intent != null && (v || bundle == null)) {
                intent.putExtra("receive_launch_intent_time", currentTimeMillis);
                aIG.e(intent.getExtras(), "update_tag_by_activity_on_create");
            }
            if (aIG.aFY() && v) {
                aIG.aIC().aIO().oU("1250000000000000");
            }
            ah.O(this);
            if (Build.VERSION.SDK_INT != 26) {
                this.cCa = new com.baidu.swan.apps.ao.d(this);
            }
            if (this.cCa != null) {
                this.cCa.setCanSlide(false);
            }
            if (this.cCa != null) {
                this.cCa.onCreate();
            }
            p.a(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.t.a.axi().ain();
                    o.K(SwanAppActivity.this);
                }
            }, "initOnCreate");
            if (bundle == null || bundle.getInt("swan_key_save_task_id") != getTaskId()) {
                z = false;
            }
            this.cCe = z;
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (this.cCa != null) {
            this.cCa.aNx();
        }
    }

    public com.baidu.swan.apps.ao.d afP() {
        return this.cCa;
    }

    private boolean q(Intent intent) {
        if (intent != null) {
            ComponentName component = intent.getComponent();
            return (component == null || component.getClassName().startsWith(cBR)) ? false : true;
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

    private void X(int i, int i2) {
        if (-1 < i) {
            setRequestedOrientation(i == 1 ? 0 : 1);
        }
        if (i2 == 1) {
            e.I(this);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceConnected: " + componentName);
        }
        if (iBinder != null) {
            this.cBU = new Messenger(iBinder);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceDisconnected: " + componentName);
        }
        this.cBU = null;
    }

    public int getFrameType() {
        if (this.cBT == null) {
            return -1;
        }
        return this.cBT.getFrameType();
    }

    public com.baidu.swan.apps.framework.c afQ() {
        return this.cBT;
    }

    public synchronized boolean afR() {
        boolean z;
        if (!isDestroyed() && this.cBT != null) {
            z = this.cBT.avn().activated();
        }
        return z;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onNewIntent");
        setIntent(intent);
        overridePendingTransition(a.C0352a.aiapps_slide_in_from_right, a.C0352a.aiapps_hold);
        if (DEBUG) {
            Log.i("SwanAppActivity", "onNewIntent:REORDER_TO_FRONT = " + ((intent.getFlags() & 131072) == 131072));
        }
        if (this.cCa != null) {
            this.cCa.aNy();
        }
        this.mIsFromSchema = true;
        com.baidu.swan.apps.runtime.d aIG = com.baidu.swan.apps.runtime.d.aIG();
        aIG.e(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (aIG.aFY() && com.baidu.swan.apps.u.c.d.v(intent)) {
            aIG.aIC().afZ().oU("1250000000000000");
        }
        if (this.cBX != null) {
            this.cBX.b(intent, getTaskId());
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.cBT == null || !this.cBT.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        if (this.cBW == null) {
            this.cBW = new ActivityResultDispatcher(this, 1);
        }
        return this.cBW;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0453a
    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a afS() {
        if (this.cCc == null) {
            this.cCc = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (FrameLayout) findViewById(16908290), 0);
        }
        return this.cCc;
    }

    public com.baidu.swan.apps.view.c afT() {
        return this.cCb;
    }

    public void afU() {
        if (this.mIsFromSchema) {
            this.cBY = "schema";
        } else {
            this.cBY = "user";
        }
    }

    public String afV() {
        return this.cBY;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        this.mIsBackground = false;
        if (this.cCa != null) {
            this.cCa.closePane();
        }
        a(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !com.baidu.swan.apps.runtime.d.aIG().aFY()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            com.baidu.swan.apps.runtime.d.aIG().e(intent.getExtras(), "update_tag_by_activity_on_create");
            if (com.baidu.swan.apps.runtime.d.aIG().aFY() && com.baidu.swan.apps.u.c.d.v(intent)) {
                com.baidu.swan.apps.runtime.d.aIG().aIC().aIO().oU("1250000000000000");
            }
        }
        afU();
        super.onResume();
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.6
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppActivity.this.cBZ == null) {
                    SwanAppActivity.this.cBZ = new OrientationEventListener(SwanAppActivity.this, 2) { // from class: com.baidu.swan.apps.SwanAppActivity.6.1
                        @Override // android.view.OrientationEventListener
                        public void onOrientationChanged(int i) {
                            com.baidu.swan.apps.runtime.d.aIG().dDS = i;
                        }
                    };
                }
                if (SwanAppActivity.this.mResumed) {
                    SwanAppActivity.this.cBZ.enable();
                }
            }
        }, "OrientationEventListener", 2);
        if (this.cCa != null) {
            this.cCa.onResume();
        }
        a(FrameLifeState.JUST_RESUMED);
        ap.aOA().reset();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        a(FrameLifeState.JUST_STARTED);
        this.mIsFromSchema = false;
        if (this.cBZ != null) {
            this.cBZ.disable();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        this.mIsBackground = true;
        a(FrameLifeState.JUST_CREATED);
        if (!afR()) {
            i.aEc();
        }
        p.a(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.swan.apps.aj.a.aLi().aLn();
                } catch (Exception e) {
                    if (SwanAppActivity.DEBUG) {
                        Log.e("SwanAppActivity", "SaveTraceException:", e);
                    }
                }
            }
        }, "tracer");
        com.baidu.swan.apps.t.a.axX().flush(false);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            com.baidu.swan.apps.adaptation.b.a.c.ajh().aji().ajg().onActivityResult(this, i, i2, intent);
        }
    }

    private synchronized void a(@NonNull FrameLifeState frameLifeState) {
        this.cBV = frameLifeState;
        afW();
    }

    private synchronized void b(@NonNull FrameLifeState frameLifeState) {
        if (this.cBT != null && !this.cBT.auX()) {
            this.cBT.d(frameLifeState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void afW() {
        b(this.cBV);
    }

    @Nullable
    public f afX() {
        if (this.cBT == null) {
            return null;
        }
        return this.cBT.afX();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com.baidu.swan.apps.runtime.d.aIG().w(this.cCd);
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onDestroy");
        this.cBZ = null;
        afY();
        if (this.cBU != null) {
            unbindService(this);
        }
        com.baidu.swan.apps.t.a.axA().aiE();
        if (this.cCa != null) {
            this.cCa.onDestroy();
        }
        com.baidu.swan.apps.runtime.d.aIG().k(this);
        a(FrameLifeState.INACTIVATED);
        com.baidu.swan.apps.v.f.release();
        String appId = com.baidu.swan.apps.runtime.d.aIG().getAppId();
        if (DEBUG) {
            com.baidu.swan.apps.u.e.a pg = com.baidu.swan.apps.u.e.a.pg(appId);
            pg.azB().azH();
            pg.azC();
        }
        com.baidu.swan.apps.runtime.d.aIG().F(new String[0]);
        this.cBX = null;
        super.onDestroy();
    }

    public synchronized void afY() {
        if (this.cCb != null) {
            this.cCb.ajK();
            if (DEBUG) {
                Log.i("SwanAppActivity", "destroyFrame resetLoadingView");
            }
        }
        com.baidu.swan.apps.view.c.aOY();
        com.baidu.swan.apps.view.c.dS(com.baidu.swan.apps.t.a.awW());
        f afX = afX();
        if (afX != null) {
            afX.apB().af(0, 0).apG().apI();
        }
        com.baidu.swan.apps.textarea.c.release();
        if (this.cBT != null) {
            this.cBT.d(FrameLifeState.INACTIVATED);
            this.cBT.release();
            this.cBT = null;
        }
        com.baidu.swan.apps.setting.oauth.c.release();
        com.baidu.swan.apps.runtime.e aIC = com.baidu.swan.apps.runtime.d.aIG().aIC();
        aIC.aIW().aKt();
        aIC.aIX().clear();
        com.baidu.swan.apps.setting.b.a.aLh();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        if (afR()) {
            this.cBT.onBackPressed();
            return;
        }
        HybridUbcFlow aEc = i.aEc();
        if (aEc != null) {
            aEc.o("value", "cancel");
            aEc.cg("exitType", String.valueOf(4));
            aEc.aDJ();
        }
        com.baidu.swan.apps.v.g.aAu().setForeground(false);
        moveTaskToBack(true);
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2;
        b.a afZ = afZ();
        boolean z3 = afZ != null && "1230000000000000".equals(afZ.aza());
        if (this.cBX != null && !z3) {
            this.cBX.hy(false);
        }
        if (!afR() || com.baidu.swan.apps.runtime.d.aIG().aIC().aIP()) {
            h.aLG();
            agh();
            return false;
        }
        try {
            z2 = super.moveTaskToBack(z);
            try {
                overridePendingTransition(0, a.C0352a.aiapps_slide_out_to_right_zadjustment_top);
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

    public b.a afZ() {
        if (this.cBT == null) {
            return null;
        }
        return this.cBT.afZ();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (this.cBT != null) {
            this.cBT.a(fVar);
        }
    }

    public void m(Bundle bundle) {
        com.baidu.swan.apps.process.messaging.service.b.b(this, bundle);
    }

    public void showLoadingView() {
        if (this.cBT != null) {
            this.cBT.showLoadingView();
        }
    }

    public void aga() {
        if (this.cBT != null) {
            this.cBT.aga();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (afR()) {
            this.cBT.onTrimMemory(i);
        }
    }

    @Override // com.baidu.swan.apps.ak.f.c
    public com.baidu.swan.apps.ak.f.b agb() {
        if (this.cBT == null) {
            return null;
        }
        return this.cBT.agb();
    }

    public boolean isLandScape() {
        return this.cBT != null && this.cBT.isLandScape();
    }

    public boolean isBackground() {
        return this.mIsBackground;
    }

    public void a(com.baidu.swan.apps.framework.b bVar) {
        if (this.cBT != null) {
            this.cBT.a(bVar);
        }
    }

    public void b(com.baidu.swan.apps.framework.b bVar) {
        if (this.cBT != null) {
            this.cBT.b(bVar);
        }
    }

    @UiThread
    public void fZ(int i) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i + ", pid:" + Process.myPid());
        }
        com.baidu.swan.apps.t.a.axA().a(this, i, afZ());
    }

    public void a(boolean z, @Nullable i.a aVar) {
        if (this.cCb == null) {
            this.cCb = new com.baidu.swan.apps.view.c(this);
        }
        this.cCb.a(1 == com.baidu.swan.apps.runtime.d.aIG().aIC().aIO().getAppFrameType(), z, aVar);
    }

    public void agc() {
        int i = 2;
        if (afZ() != null && afZ().getOrientation() == 1) {
            i = 3;
        }
        if (afT() != null) {
            afT().kv(i);
        }
    }

    private void agd() {
        this.cCd.a(new com.baidu.swan.apps.ao.e.c<i.a, Boolean>() { // from class: com.baidu.swan.apps.SwanAppActivity.3
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
                SwanAppActivity.this.age();
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
                SwanAppActivity.this.afW();
            }
        }, "event_first_action_launched");
        com.baidu.swan.apps.v.g.aAu().aAv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.u.c.a.c cVar) {
        if (agf() && cVar.containsKey(" event_params_installer_progress")) {
            this.cCb.T(cVar.getFloat(" event_params_installer_progress"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void age() {
        if (!isDestroyed()) {
            if (com.baidu.swan.apps.runtime.d.aIG().aIC().available()) {
                eE(true);
            } else {
                com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppActivity.this.agh();
                    }
                }, cBS);
            }
        }
    }

    private boolean agf() {
        return (this.cCb == null || isDestroyed()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.u.c.a.c cVar) {
        if (agf()) {
            this.cCb.uq(cVar.getString("app_icon_url"));
            this.cCb.jV(cVar.getString("app_name"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i.a aVar) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        b.a aIO = com.baidu.swan.apps.runtime.d.aIG().aIC().aIO();
        X(aIO.getOrientation(), aIO.getAppFrameType());
        a(false, aVar);
        com.baidu.swan.apps.console.c.i("SwanAppActivity", "appName: " + aIO.atc() + " appId: " + aIO.getAppId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.apps.u.c.a.c cVar) {
        if (this.cBT != null && this.cBT.avz()) {
            eE("update_tag_by_activity_on_new_intent".equals(cVar.getString("app_update_tag")));
        }
    }

    public void x(String... strArr) {
        afY();
        HashSet esy = strArr == null ? com.facebook.common.internal.i.esy() : com.facebook.common.internal.i.R(strArr);
        if (esy.contains("flag_finish_activity")) {
            if (esy.contains("flag_remove_task")) {
                agh();
            } else {
                finish();
            }
        }
    }

    public String agg() {
        return this.cBT == null ? "" : this.cBT.dcy;
    }

    public boolean jM(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.equals(str, agg());
    }

    private synchronized void eE(boolean z) {
        com.baidu.swan.apps.runtime.e aIC = com.baidu.swan.apps.runtime.d.aIG().aIC();
        if (aIC.available() && (jM(aIC.getAppId()) || a(aIC))) {
            this.cBT.a(this.cBV, z);
            if (DEBUG) {
                agi();
            }
            if (this.cBX == null && com.baidu.swan.apps.ao.b.aNq()) {
                this.cBX = com.baidu.swan.apps.ao.b.aNp();
                if (!this.cCe) {
                    this.cBX.a(afZ(), getTaskId());
                }
            }
        }
    }

    private synchronized boolean a(com.baidu.swan.apps.runtime.e eVar) {
        boolean z;
        if (this.cBT != null) {
            afY();
        }
        com.baidu.swan.apps.framework.c a2 = com.baidu.swan.apps.framework.e.a(this, eVar);
        if (a2 == null) {
            com.baidu.swan.apps.u.b.a.a(this, new com.baidu.swan.apps.al.a().db(5L).dc(11L).tF("can not buildFramework"), eVar.getFrameType(), eVar.id);
            agh();
            z = false;
        } else {
            this.cBT = a2;
            p.a(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.5
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.t.a.axi().aio();
                }
            }, "updateMobStat");
            X(eVar.aIO().getOrientation(), eVar.getFrameType());
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agh() {
        e.H(this);
    }

    private void agi() {
        com.baidu.swan.apps.runtime.e aIC = com.baidu.swan.apps.runtime.d.aIG().aIC();
        if (aIC != null) {
            String azt = aIC.afZ().azt();
            com.baidu.swan.apps.u.e.a pg = com.baidu.swan.apps.u.e.a.pg(aIC.afZ().azt());
            pg.ph("appId: " + aIC.id + "  launchId: " + azt).azI();
            pg.azC();
        }
    }
}
