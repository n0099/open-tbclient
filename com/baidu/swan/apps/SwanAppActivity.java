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
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.searchbox.process.ipc.util.TranslucentUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ad.c;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.an;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.aq.s;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.core.turbo.d;
import com.baidu.swan.apps.framework.FrameLifeState;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.res.widget.floatlayer.a;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.statistic.g;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.v.b.b;
import com.baidu.swan.apps.w.f;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
/* loaded from: classes11.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ServiceConnection, ActivityResultDispatcherHolder, com.baidu.swan.apps.am.f.c, a.InterfaceC0377a {
    private static final boolean DEBUG = b.DEBUG;
    private static final String bGO = SwanAppActivity.class.getName();
    private static final long bGP = TimeUnit.SECONDS.toMillis(1);
    private com.baidu.swan.apps.framework.c bGQ;
    private Messenger bGR;
    private ActivityResultDispatcher bGT;
    @Nullable
    private com.baidu.swan.apps.aq.a bGU;
    OrientationEventListener bGW;
    private com.baidu.swan.apps.aq.c bGX;
    protected com.baidu.swan.apps.view.c bGY;
    private com.baidu.swan.apps.res.widget.floatlayer.a bGZ;
    private FrameLifeState bGS = FrameLifeState.INACTIVATED;
    private String bGV = "sys";
    private boolean mIsFromSchema = false;
    private final com.baidu.swan.apps.runtime.b bHa = new com.baidu.swan.apps.runtime.b();
    private boolean bHb = false;

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        Bundle bundle2;
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(a.C0281a.aiapps_slide_in_from_right, a.C0281a.aiapps_hold);
        SwanAppProcessInfo.init(getProcessInfo());
        com.baidu.swan.apps.u.a.afI().SP();
        com.baidu.swan.apps.process.messaging.client.a.amQ().amS();
        this.mIsFromSchema = true;
        g.gT(bundle == null ? 0 : 1);
        super.onCreate(bundle);
        a(FrameLifeState.JUST_CREATED);
        if (!s.checkActivityRefuseServiceAndFinish(this)) {
            Intent intent = getIntent();
            if (bundle != null && intent != null && (bundle2 = bundle.getBundle("swan_key_save_bundle")) != null) {
                intent.setExtrasClassLoader(getClass().getClassLoader());
                intent.putExtras(bundle2);
            }
            if (o(intent)) {
                QR();
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
            if (DEBUG) {
                Log.d("SwanAppActivity", "SwanAppActivity onCreate() savedInstanceState=" + bundle);
            }
            com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onCreate");
            setContentView(a.g.aiapps_activity);
            QN();
            com.baidu.swan.apps.runtime.d aoB = com.baidu.swan.apps.runtime.d.aoB();
            aoB.i(this);
            aoB.n(this.bHa);
            boolean t = com.baidu.swan.apps.v.b.d.t(intent);
            if (intent != null && (t || bundle == null)) {
                intent.putExtra("receive_launch_intent_time", currentTimeMillis);
                aoB.d(intent.getExtras(), "update_tag_by_activity_on_create");
            }
            if (aoB.ane() && t) {
                aoB.aox().aoJ().kZ("1250000000000000");
            }
            ag.R(this);
            if (Build.VERSION.SDK_INT != 26) {
                this.bGX = new com.baidu.swan.apps.aq.c(this);
            }
            if (this.bGX != null) {
                this.bGX.setCanSlide(false);
            }
            if (this.bGX != null) {
                this.bGX.onCreate();
            }
            n.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.u.a.afd().SE();
                }
            }, "initMobStat");
            ai.atL();
            if (bundle == null || bundle.getInt("swan_key_save_task_id") != getTaskId()) {
                z = false;
            }
            this.bHb = z;
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (this.bGX != null) {
            this.bGX.atc();
        }
    }

    public com.baidu.swan.apps.aq.c Qy() {
        return this.bGX;
    }

    private boolean o(Intent intent) {
        if (intent != null) {
            ComponentName component = intent.getComponent();
            return (component == null || component.getClassName().startsWith(bGO)) ? false : true;
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

    private void Z(int i, int i2) {
        if (-1 < i) {
            setRequestedOrientation(i == 1 ? 0 : 1);
        }
        if (i2 == 1) {
            com.baidu.swan.apps.aq.d.O(this);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceConnected: " + componentName);
        }
        if (iBinder != null) {
            this.bGR = new Messenger(iBinder);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceDisconnected: " + componentName);
        }
        this.bGR = null;
    }

    public int Qz() {
        if (this.bGQ == null) {
            return -1;
        }
        return this.bGQ.Qz();
    }

    public com.baidu.swan.apps.framework.c QA() {
        return this.bGQ;
    }

    public synchronized boolean QB() {
        boolean z;
        if (!isDestroyed() && this.bGQ != null) {
            z = this.bGQ.adB().activated();
        }
        return z;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onNewIntent");
        setIntent(intent);
        overridePendingTransition(a.C0281a.aiapps_slide_in_from_right, a.C0281a.aiapps_hold);
        if (DEBUG) {
            Log.i("SwanAppActivity", "onNewIntent:REORDER_TO_FRONT = " + ((intent.getFlags() & 131072) == 131072));
        }
        if (this.bGX != null) {
            this.bGX.atd();
        }
        this.mIsFromSchema = true;
        com.baidu.swan.apps.runtime.d aoB = com.baidu.swan.apps.runtime.d.aoB();
        aoB.d(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (aoB.ane() && com.baidu.swan.apps.v.b.d.t(intent)) {
            aoB.aox().QJ().kZ("1250000000000000");
        }
        if (this.bGU != null) {
            this.bGU.b(intent, getTaskId());
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bGQ == null || !this.bGQ.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        if (this.bGT == null) {
            this.bGT = new ActivityResultDispatcher(this, 1);
        }
        return this.bGT;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0377a
    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a QC() {
        if (this.bGZ == null) {
            this.bGZ = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (FrameLayout) findViewById(16908290), 0);
        }
        return this.bGZ;
    }

    public com.baidu.swan.apps.view.c QD() {
        return this.bGY;
    }

    public void QE() {
        if (this.mIsFromSchema) {
            this.bGV = "schema";
        } else {
            this.bGV = "user";
        }
    }

    public String QF() {
        return this.bGV;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        if (this.bGX != null) {
            this.bGX.closePane();
        }
        a(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !com.baidu.swan.apps.runtime.d.aoB().ane()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            com.baidu.swan.apps.runtime.d.aoB().d(intent.getExtras(), "update_tag_by_activity_on_create");
            if (com.baidu.swan.apps.runtime.d.aoB().ane() && com.baidu.swan.apps.v.b.d.t(intent)) {
                com.baidu.swan.apps.runtime.d.aoB().aox().aoJ().kZ("1250000000000000");
            }
        }
        QE();
        super.onResume();
        if (this.bGW == null) {
            this.bGW = new OrientationEventListener(this, 2) { // from class: com.baidu.swan.apps.SwanAppActivity.6
                @Override // android.view.OrientationEventListener
                public void onOrientationChanged(int i) {
                    com.baidu.swan.apps.runtime.d.aoB().czz = i;
                }
            };
        }
        this.bGW.enable();
        if (this.bGX != null) {
            this.bGX.onResume();
        }
        a(FrameLifeState.JUST_RESUMED);
        an.atY().reset();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        a(FrameLifeState.JUST_STARTED);
        this.mIsFromSchema = false;
        this.bGW.disable();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        a(FrameLifeState.JUST_CREATED);
        if (!QB()) {
            com.baidu.swan.apps.performance.g.aly();
        }
        n.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.swan.apps.al.a.aqT().aqY();
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
            com.baidu.swan.apps.adaptation.b.a.c.Tq().Tr().Tp().onActivityResult(this, i, i2, intent);
        }
    }

    private synchronized void a(@NonNull FrameLifeState frameLifeState) {
        this.bGS = frameLifeState;
        QG();
    }

    private synchronized void b(@NonNull FrameLifeState frameLifeState) {
        if (this.bGQ != null && !this.bGQ.adl()) {
            this.bGQ.d(frameLifeState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void QG() {
        b(this.bGS);
    }

    @Nullable
    public e QH() {
        if (this.bGQ == null) {
            return null;
        }
        return this.bGQ.QH();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com.baidu.swan.apps.runtime.d.aoB().o(this.bHa);
        if (DEBUG) {
            Log.d("SwanAppActivity", "——> onDestroy: ");
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onDestroy");
        this.bGW = null;
        QI();
        if (this.bGR != null) {
            unbindService(this);
        }
        com.baidu.swan.apps.u.a.aft().SS();
        if (this.bGX != null) {
            this.bGX.onDestroy();
        }
        com.baidu.swan.apps.runtime.d.aoB().j(this);
        a(FrameLifeState.INACTIVATED);
        f.release();
        com.baidu.swan.apps.v.c.a lk = com.baidu.swan.apps.v.c.a.lk(com.baidu.swan.apps.runtime.d.aoB().getAppId());
        lk.ahk().ahr();
        lk.ahl();
        com.baidu.swan.apps.runtime.d.aoB().w(new String[0]);
        this.bGU = null;
        super.onDestroy();
    }

    public synchronized void QI() {
        if (this.bGY != null) {
            this.bGY.TP();
            if (DEBUG) {
                Log.i("SwanAppActivity", "destroyFrame resetLoadingView");
            }
        }
        com.baidu.swan.apps.view.c.auq();
        com.baidu.swan.apps.view.c.cE(com.baidu.swan.apps.u.a.aeR());
        e QH = QH();
        if (QH != null) {
            QH.YT().ae(0, 0).YZ().Zb();
        }
        com.baidu.swan.apps.textarea.c.release();
        if (this.bGQ != null) {
            this.bGQ.d(FrameLifeState.INACTIVATED);
            this.bGQ.release();
            this.bGQ = null;
        }
        com.baidu.swan.apps.setting.oauth.c.release();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (DEBUG) {
            Log.d("SwanAppActivity", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onBackPressed");
        if (QB()) {
            this.bGQ.onBackPressed();
            return;
        }
        HybridUbcFlow aly = com.baidu.swan.apps.performance.g.aly();
        if (aly != null) {
            aly.bD("exitType", String.valueOf(4));
            aly.ald();
        }
        com.baidu.swan.apps.w.g.aie().ed(false);
        moveTaskToBack(true);
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2;
        Exception e;
        b.a QJ = QJ();
        boolean z3 = QJ != null && "1230000000000000".equals(QJ.agK());
        if (this.bGU != null && !z3) {
            this.bGU.fs(false);
        }
        if (!QB() || com.baidu.swan.apps.runtime.d.aoB().aox().aoK()) {
            h.arq();
            QR();
            return false;
        }
        try {
            z2 = super.moveTaskToBack(z);
            try {
                overridePendingTransition(0, a.C0281a.aiapps_slide_out_to_right_zadjustment_top);
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

    public b.a QJ() {
        if (this.bGQ == null) {
            return null;
        }
        return this.bGQ.QJ();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (this.bGQ != null) {
            this.bGQ.a(fVar);
        }
    }

    public void o(Bundle bundle) {
        com.baidu.swan.apps.process.messaging.service.b.b(this, bundle);
    }

    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        if (this.bGQ != null) {
            this.bGQ.a(i, strArr, aVar);
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.swan.support.v4.app.a.InterfaceC0457a
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.bGQ != null && !this.bGQ.onRequestPermissionsResult(i, strArr, iArr)) {
            b(i, strArr, iArr);
        }
    }

    public void b(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void showLoadingView() {
        if (this.bGQ != null) {
            this.bGQ.showLoadingView();
        }
    }

    public void QK() {
        if (this.bGQ != null) {
            this.bGQ.QK();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (QB()) {
            this.bGQ.onTrimMemory(i);
        }
    }

    @Override // com.baidu.swan.apps.am.f.c
    public com.baidu.swan.apps.am.f.b QL() {
        if (this.bGQ == null) {
            return null;
        }
        return this.bGQ.QL();
    }

    public boolean isLandScape() {
        return this.bGQ != null && this.bGQ.isLandScape();
    }

    public void a(com.baidu.swan.apps.framework.b bVar) {
        if (this.bGQ != null) {
            this.bGQ.a(bVar);
        }
    }

    public void b(com.baidu.swan.apps.framework.b bVar) {
        if (this.bGQ != null) {
            this.bGQ.b(bVar);
        }
    }

    @UiThread
    public void ee(int i) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i + ", pid:" + Process.myPid());
        }
        com.baidu.swan.apps.u.a.aft().a(this, i, QJ());
    }

    public void a(boolean z, @Nullable i.a aVar) {
        if (this.bGY == null) {
            this.bGY = new com.baidu.swan.apps.view.c(this);
        }
        this.bGY.a(1 == com.baidu.swan.apps.runtime.d.aoB().aox().aoJ().getAppFrameType(), z, aVar);
    }

    public void QM() {
        int i = 2;
        if (QJ() != null && QJ().getOrientation() == 1) {
            i = 3;
        }
        if (QD() != null) {
            QD().hQ(i);
        }
    }

    private void QN() {
        this.bHa.a(new com.baidu.swan.apps.aq.e.c<i.a, Boolean>() { // from class: com.baidu.swan.apps.SwanAppActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.c
            /* renamed from: c */
            public Boolean I(i.a aVar) {
                return Boolean.valueOf(!SwanAppActivity.this.isDestroyed());
            }
        }).a(new com.baidu.swan.apps.aq.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: b */
            public void H(i.a aVar) {
                SwanAppActivity.this.a(true, aVar);
            }
        }, "event_on_still_maintaining").a(new com.baidu.swan.apps.aq.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: b */
            public void H(i.a aVar) {
                SwanAppActivity.this.a(aVar);
            }
        }, "event_on_app_occupied").a(new com.baidu.swan.apps.aq.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: b */
            public void H(i.a aVar) {
                SwanAppActivity.this.c(aVar);
            }
        }, "event_on_app_updated").a(new com.baidu.swan.apps.aq.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: b */
            public void H(i.a aVar) {
                SwanAppActivity.this.b(aVar);
            }
        }, "event_on_app_icon_update").a(new com.baidu.swan.apps.aq.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: b */
            public void H(i.a aVar) {
                SwanAppActivity.this.QO();
            }
        }, "event_on_pkg_maintain_finish").a(new com.baidu.swan.apps.aq.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: b */
            public void H(i.a aVar) {
                SwanAppActivity.this.a((com.baidu.swan.apps.v.b.a.c) aVar);
            }
        }, "installer_on_progress").a(new com.baidu.swan.apps.aq.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: b */
            public void H(i.a aVar) {
                SwanAppActivity.this.QG();
            }
        }, "event_first_action_launched");
        com.baidu.swan.apps.w.g.aie().aif();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.v.b.a.c cVar) {
        if (QP() && cVar.containsKey(" event_params_installer_progress")) {
            this.bGY.F(cVar.getFloat(" event_params_installer_progress"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QO() {
        if (!isDestroyed()) {
            if (com.baidu.swan.apps.runtime.d.aoB().aox().available()) {
                da(true);
            } else {
                com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppActivity.this.QR();
                    }
                }, bGP);
            }
        }
    }

    private boolean QP() {
        return (this.bGY == null || isDestroyed()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.v.b.a.c cVar) {
        if (QP()) {
            this.bGY.pV(cVar.getString("app_icon_url"));
            this.bGY.pW(cVar.getString("app_name"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i.a aVar) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        b.a aoJ = com.baidu.swan.apps.runtime.d.aoB().aox().aoJ();
        Z(aoJ.getOrientation(), aoJ.getAppFrameType());
        a(false, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.apps.v.b.a.c cVar) {
        if (this.bGQ != null && this.bGQ.adO()) {
            da("update_tag_by_activity_on_new_intent".equals(cVar.getString("app_update_tag")));
        }
    }

    public void p(String... strArr) {
        QI();
        HashSet duD = strArr == null ? com.facebook.common.internal.i.duD() : com.facebook.common.internal.i.O(strArr);
        if (duD.contains("flag_finish_activity")) {
            if (duD.contains("flag_remove_task")) {
                QR();
            } else {
                finish();
            }
        }
    }

    public String QQ() {
        return this.bGQ == null ? "" : this.bGQ.ceq;
    }

    public boolean gX(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.equals(str, QQ());
    }

    private synchronized void da(boolean z) {
        com.baidu.swan.apps.runtime.e aox = com.baidu.swan.apps.runtime.d.aoB().aox();
        if (aox.available() && (gX(aox.getAppId()) || a(aox))) {
            this.bGQ.a(this.bGS, z);
            QS();
            if (this.bGU == null && com.baidu.swan.apps.aq.a.asX()) {
                this.bGU = com.baidu.swan.apps.aq.a.asW();
                if (!this.bHb) {
                    this.bGU.a(QJ(), getTaskId());
                }
            }
        }
    }

    private synchronized boolean a(com.baidu.swan.apps.runtime.e eVar) {
        boolean z;
        if (this.bGQ != null) {
            QI();
        }
        com.baidu.swan.apps.framework.c a = com.baidu.swan.apps.framework.e.a(this, eVar);
        if (a == null) {
            com.baidu.swan.apps.v.a.a.a(this, new com.baidu.swan.apps.an.a().bw(5L).bx(11L).pr("can not buildFramework"), eVar.Qz(), eVar.id);
            QR();
            z = false;
        } else {
            this.bGQ = a;
            n.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.5
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.u.a.afd().SF();
                }
            }, "updateMobStat");
            Z(eVar.aoJ().getOrientation(), eVar.Qz());
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QR() {
        com.baidu.swan.apps.aq.d.N(this);
    }

    private void QS() {
        com.baidu.swan.apps.runtime.e aox = com.baidu.swan.apps.runtime.d.aoB().aox();
        if (aox != null) {
            String ahd = aox.QJ().ahd();
            com.baidu.swan.apps.v.c.a lk = com.baidu.swan.apps.v.c.a.lk(aox.QJ().ahd());
            lk.ll("appId: " + aox.id + "  launchId: " + ahd).ahs();
            lk.ahl();
        }
    }
}
