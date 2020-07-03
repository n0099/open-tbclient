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
public class SwanAppActivity extends SwanAppBaseActivity implements ServiceConnection, ActivityResultDispatcherHolder, com.baidu.swan.apps.am.f.c, a.InterfaceC0383a {
    private static final boolean DEBUG = b.DEBUG;
    private static final String bLC = SwanAppActivity.class.getName();
    private static final long bLD = TimeUnit.SECONDS.toMillis(1);
    private com.baidu.swan.apps.framework.c bLE;
    private Messenger bLF;
    private ActivityResultDispatcher bLH;
    @Nullable
    private com.baidu.swan.apps.aq.a bLI;
    OrientationEventListener bLK;
    private com.baidu.swan.apps.aq.c bLL;
    protected com.baidu.swan.apps.view.c bLM;
    private com.baidu.swan.apps.res.widget.floatlayer.a bLN;
    private FrameLifeState bLG = FrameLifeState.INACTIVATED;
    private String bLJ = "sys";
    private boolean mIsFromSchema = false;
    private final com.baidu.swan.apps.runtime.b bLO = new com.baidu.swan.apps.runtime.b();
    private boolean bLP = false;

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        Bundle bundle2;
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(a.C0287a.aiapps_slide_in_from_right, a.C0287a.aiapps_hold);
        SwanAppProcessInfo.init(getProcessInfo());
        com.baidu.swan.apps.u.a.agO().TV();
        com.baidu.swan.apps.process.messaging.client.a.anW().anY();
        this.mIsFromSchema = true;
        g.he(bundle == null ? 0 : 1);
        super.onCreate(bundle);
        a(FrameLifeState.JUST_CREATED);
        if (!s.checkActivityRefuseServiceAndFinish(this)) {
            Intent intent = getIntent();
            if (bundle != null && intent != null && (bundle2 = bundle.getBundle("swan_key_save_bundle")) != null) {
                intent.setExtrasClassLoader(getClass().getClassLoader());
                intent.putExtras(bundle2);
            }
            if (o(intent)) {
                RX();
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
            RT();
            com.baidu.swan.apps.runtime.d apI = com.baidu.swan.apps.runtime.d.apI();
            apI.i(this);
            apI.n(this.bLO);
            boolean t = com.baidu.swan.apps.v.b.d.t(intent);
            if (intent != null && (t || bundle == null)) {
                intent.putExtra("receive_launch_intent_time", currentTimeMillis);
                apI.d(intent.getExtras(), "update_tag_by_activity_on_create");
            }
            if (apI.aok() && t) {
                apI.apE().apQ().lh("1250000000000000");
            }
            ag.R(this);
            if (Build.VERSION.SDK_INT != 26) {
                this.bLL = new com.baidu.swan.apps.aq.c(this);
            }
            if (this.bLL != null) {
                this.bLL.setCanSlide(false);
            }
            if (this.bLL != null) {
                this.bLL.onCreate();
            }
            n.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.u.a.agj().TK();
                }
            }, "initMobStat");
            ai.auR();
            if (bundle == null || bundle.getInt("swan_key_save_task_id") != getTaskId()) {
                z = false;
            }
            this.bLP = z;
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (this.bLL != null) {
            this.bLL.aui();
        }
    }

    public com.baidu.swan.apps.aq.c RE() {
        return this.bLL;
    }

    private boolean o(Intent intent) {
        if (intent != null) {
            ComponentName component = intent.getComponent();
            return (component == null || component.getClassName().startsWith(bLC)) ? false : true;
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
            com.baidu.swan.apps.aq.d.O(this);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceConnected: " + componentName);
        }
        if (iBinder != null) {
            this.bLF = new Messenger(iBinder);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceDisconnected: " + componentName);
        }
        this.bLF = null;
    }

    public int RF() {
        if (this.bLE == null) {
            return -1;
        }
        return this.bLE.RF();
    }

    public com.baidu.swan.apps.framework.c RG() {
        return this.bLE;
    }

    public synchronized boolean RH() {
        boolean z;
        if (!isDestroyed() && this.bLE != null) {
            z = this.bLE.aeH().activated();
        }
        return z;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onNewIntent");
        setIntent(intent);
        overridePendingTransition(a.C0287a.aiapps_slide_in_from_right, a.C0287a.aiapps_hold);
        if (DEBUG) {
            Log.i("SwanAppActivity", "onNewIntent:REORDER_TO_FRONT = " + ((intent.getFlags() & 131072) == 131072));
        }
        if (this.bLL != null) {
            this.bLL.auj();
        }
        this.mIsFromSchema = true;
        com.baidu.swan.apps.runtime.d apI = com.baidu.swan.apps.runtime.d.apI();
        apI.d(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (apI.aok() && com.baidu.swan.apps.v.b.d.t(intent)) {
            apI.apE().RP().lh("1250000000000000");
        }
        if (this.bLI != null) {
            this.bLI.b(intent, getTaskId());
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bLE == null || !this.bLE.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        if (this.bLH == null) {
            this.bLH = new ActivityResultDispatcher(this, 1);
        }
        return this.bLH;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0383a
    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a RI() {
        if (this.bLN == null) {
            this.bLN = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (FrameLayout) findViewById(16908290), 0);
        }
        return this.bLN;
    }

    public com.baidu.swan.apps.view.c RJ() {
        return this.bLM;
    }

    public void RK() {
        if (this.mIsFromSchema) {
            this.bLJ = "schema";
        } else {
            this.bLJ = "user";
        }
    }

    public String RL() {
        return this.bLJ;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        if (this.bLL != null) {
            this.bLL.closePane();
        }
        a(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !com.baidu.swan.apps.runtime.d.apI().aok()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            com.baidu.swan.apps.runtime.d.apI().d(intent.getExtras(), "update_tag_by_activity_on_create");
            if (com.baidu.swan.apps.runtime.d.apI().aok() && com.baidu.swan.apps.v.b.d.t(intent)) {
                com.baidu.swan.apps.runtime.d.apI().apE().apQ().lh("1250000000000000");
            }
        }
        RK();
        super.onResume();
        if (this.bLK == null) {
            this.bLK = new OrientationEventListener(this, 2) { // from class: com.baidu.swan.apps.SwanAppActivity.6
                @Override // android.view.OrientationEventListener
                public void onOrientationChanged(int i) {
                    com.baidu.swan.apps.runtime.d.apI().cEj = i;
                }
            };
        }
        this.bLK.enable();
        if (this.bLL != null) {
            this.bLL.onResume();
        }
        a(FrameLifeState.JUST_RESUMED);
        an.ave().reset();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        a(FrameLifeState.JUST_STARTED);
        this.mIsFromSchema = false;
        this.bLK.disable();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        a(FrameLifeState.JUST_CREATED);
        if (!RH()) {
            com.baidu.swan.apps.performance.g.amE();
        }
        n.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.swan.apps.al.a.arZ().ase();
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
            com.baidu.swan.apps.adaptation.b.a.c.Uw().Ux().Uv().onActivityResult(this, i, i2, intent);
        }
    }

    private synchronized void a(@NonNull FrameLifeState frameLifeState) {
        this.bLG = frameLifeState;
        RM();
    }

    private synchronized void b(@NonNull FrameLifeState frameLifeState) {
        if (this.bLE != null && !this.bLE.aer()) {
            this.bLE.d(frameLifeState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void RM() {
        b(this.bLG);
    }

    @Nullable
    public e RN() {
        if (this.bLE == null) {
            return null;
        }
        return this.bLE.RN();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com.baidu.swan.apps.runtime.d.apI().o(this.bLO);
        if (DEBUG) {
            Log.d("SwanAppActivity", "——> onDestroy: ");
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onDestroy");
        this.bLK = null;
        RO();
        if (this.bLF != null) {
            unbindService(this);
        }
        com.baidu.swan.apps.u.a.agz().TY();
        if (this.bLL != null) {
            this.bLL.onDestroy();
        }
        com.baidu.swan.apps.runtime.d.apI().j(this);
        a(FrameLifeState.INACTIVATED);
        f.release();
        com.baidu.swan.apps.v.c.a ls = com.baidu.swan.apps.v.c.a.ls(com.baidu.swan.apps.runtime.d.apI().getAppId());
        ls.aiq().aix();
        ls.air();
        com.baidu.swan.apps.runtime.d.apI().v(new String[0]);
        this.bLI = null;
        super.onDestroy();
    }

    public synchronized void RO() {
        if (this.bLM != null) {
            this.bLM.UV();
            if (DEBUG) {
                Log.i("SwanAppActivity", "destroyFrame resetLoadingView");
            }
        }
        com.baidu.swan.apps.view.c.avw();
        com.baidu.swan.apps.view.c.cF(com.baidu.swan.apps.u.a.afX());
        e RN = RN();
        if (RN != null) {
            RN.ZZ().ag(0, 0).aaf().aah();
        }
        com.baidu.swan.apps.textarea.c.release();
        if (this.bLE != null) {
            this.bLE.d(FrameLifeState.INACTIVATED);
            this.bLE.release();
            this.bLE = null;
        }
        com.baidu.swan.apps.setting.oauth.c.release();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (DEBUG) {
            Log.d("SwanAppActivity", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onBackPressed");
        if (RH()) {
            this.bLE.onBackPressed();
            return;
        }
        HybridUbcFlow amE = com.baidu.swan.apps.performance.g.amE();
        if (amE != null) {
            amE.bF("exitType", String.valueOf(4));
            amE.amj();
        }
        com.baidu.swan.apps.w.g.ajk().ei(false);
        moveTaskToBack(true);
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2;
        Exception e;
        b.a RP = RP();
        boolean z3 = RP != null && "1230000000000000".equals(RP.ahQ());
        if (this.bLI != null && !z3) {
            this.bLI.fx(false);
        }
        if (!RH() || com.baidu.swan.apps.runtime.d.apI().apE().apR()) {
            h.asx();
            RX();
            return false;
        }
        try {
            z2 = super.moveTaskToBack(z);
            try {
                overridePendingTransition(0, a.C0287a.aiapps_slide_out_to_right_zadjustment_top);
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

    public b.a RP() {
        if (this.bLE == null) {
            return null;
        }
        return this.bLE.RP();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (this.bLE != null) {
            this.bLE.a(fVar);
        }
    }

    public void o(Bundle bundle) {
        com.baidu.swan.apps.process.messaging.service.b.b(this, bundle);
    }

    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        if (this.bLE != null) {
            this.bLE.a(i, strArr, aVar);
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.swan.support.v4.app.a.InterfaceC0463a
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.bLE != null && !this.bLE.onRequestPermissionsResult(i, strArr, iArr)) {
            b(i, strArr, iArr);
        }
    }

    public void b(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void showLoadingView() {
        if (this.bLE != null) {
            this.bLE.showLoadingView();
        }
    }

    public void RQ() {
        if (this.bLE != null) {
            this.bLE.RQ();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (RH()) {
            this.bLE.onTrimMemory(i);
        }
    }

    @Override // com.baidu.swan.apps.am.f.c
    public com.baidu.swan.apps.am.f.b RR() {
        if (this.bLE == null) {
            return null;
        }
        return this.bLE.RR();
    }

    public boolean isLandScape() {
        return this.bLE != null && this.bLE.isLandScape();
    }

    public void a(com.baidu.swan.apps.framework.b bVar) {
        if (this.bLE != null) {
            this.bLE.a(bVar);
        }
    }

    public void b(com.baidu.swan.apps.framework.b bVar) {
        if (this.bLE != null) {
            this.bLE.b(bVar);
        }
    }

    @UiThread
    public void ep(int i) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i + ", pid:" + Process.myPid());
        }
        com.baidu.swan.apps.u.a.agz().a(this, i, RP());
    }

    public void a(boolean z, @Nullable i.a aVar) {
        if (this.bLM == null) {
            this.bLM = new com.baidu.swan.apps.view.c(this);
        }
        this.bLM.a(1 == com.baidu.swan.apps.runtime.d.apI().apE().apQ().getAppFrameType(), z, aVar);
    }

    public void RS() {
        int i = 2;
        if (RP() != null && RP().getOrientation() == 1) {
            i = 3;
        }
        if (RJ() != null) {
            RJ().ib(i);
        }
    }

    private void RT() {
        this.bLO.a(new com.baidu.swan.apps.aq.e.c<i.a, Boolean>() { // from class: com.baidu.swan.apps.SwanAppActivity.3
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
                SwanAppActivity.this.RU();
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
                SwanAppActivity.this.RM();
            }
        }, "event_first_action_launched");
        com.baidu.swan.apps.w.g.ajk().ajl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.v.b.a.c cVar) {
        if (RV() && cVar.containsKey(" event_params_installer_progress")) {
            this.bLM.H(cVar.getFloat(" event_params_installer_progress"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RU() {
        if (!isDestroyed()) {
            if (com.baidu.swan.apps.runtime.d.apI().apE().available()) {
                df(true);
            } else {
                com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppActivity.this.RX();
                    }
                }, bLD);
            }
        }
    }

    private boolean RV() {
        return (this.bLM == null || isDestroyed()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.v.b.a.c cVar) {
        if (RV()) {
            this.bLM.qd(cVar.getString("app_icon_url"));
            this.bLM.qe(cVar.getString("app_name"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i.a aVar) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        b.a apQ = com.baidu.swan.apps.runtime.d.apI().apE().apQ();
        ab(apQ.getOrientation(), apQ.getAppFrameType());
        a(false, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.apps.v.b.a.c cVar) {
        if (this.bLE != null && this.bLE.aeU()) {
            df("update_tag_by_activity_on_new_intent".equals(cVar.getString("app_update_tag")));
        }
    }

    public void o(String... strArr) {
        RO();
        HashSet dzg = strArr == null ? com.facebook.common.internal.i.dzg() : com.facebook.common.internal.i.O(strArr);
        if (dzg.contains("flag_finish_activity")) {
            if (dzg.contains("flag_remove_task")) {
                RX();
            } else {
                finish();
            }
        }
    }

    public String RW() {
        return this.bLE == null ? "" : this.bLE.cje;
    }

    public boolean hf(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.equals(str, RW());
    }

    private synchronized void df(boolean z) {
        com.baidu.swan.apps.runtime.e apE = com.baidu.swan.apps.runtime.d.apI().apE();
        if (apE.available() && (hf(apE.getAppId()) || a(apE))) {
            this.bLE.a(this.bLG, z);
            RY();
            if (this.bLI == null && com.baidu.swan.apps.aq.a.aud()) {
                this.bLI = com.baidu.swan.apps.aq.a.auc();
                if (!this.bLP) {
                    this.bLI.a(RP(), getTaskId());
                }
            }
        }
    }

    private synchronized boolean a(com.baidu.swan.apps.runtime.e eVar) {
        boolean z;
        if (this.bLE != null) {
            RO();
        }
        com.baidu.swan.apps.framework.c a = com.baidu.swan.apps.framework.e.a(this, eVar);
        if (a == null) {
            com.baidu.swan.apps.v.a.a.a(this, new com.baidu.swan.apps.an.a().bw(5L).bx(11L).pz("can not buildFramework"), eVar.RF(), eVar.id);
            RX();
            z = false;
        } else {
            this.bLE = a;
            n.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.5
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.u.a.agj().TL();
                }
            }, "updateMobStat");
            ab(eVar.apQ().getOrientation(), eVar.RF());
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RX() {
        com.baidu.swan.apps.aq.d.N(this);
    }

    private void RY() {
        com.baidu.swan.apps.runtime.e apE = com.baidu.swan.apps.runtime.d.apI().apE();
        if (apE != null) {
            String aij = apE.RP().aij();
            com.baidu.swan.apps.v.c.a ls = com.baidu.swan.apps.v.c.a.ls(apE.RP().aij());
            ls.lt("appId: " + apE.id + "  launchId: " + aij).aiy();
            ls.air();
        }
    }
}
