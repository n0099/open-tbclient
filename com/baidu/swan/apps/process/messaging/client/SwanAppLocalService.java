package com.baidu.swan.apps.process.messaging.client;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.core.prefetch.image.config.image.CustomStrategyImpl;
import com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.tieba.R;
import com.baidu.tieba.ag2;
import com.baidu.tieba.b53;
import com.baidu.tieba.cb3;
import com.baidu.tieba.e53;
import com.baidu.tieba.eq3;
import com.baidu.tieba.ff2;
import com.baidu.tieba.fo2;
import com.baidu.tieba.fq3;
import com.baidu.tieba.g53;
import com.baidu.tieba.i43;
import com.baidu.tieba.ib3;
import com.baidu.tieba.if2;
import com.baidu.tieba.ku2;
import com.baidu.tieba.la2;
import com.baidu.tieba.lf2;
import com.baidu.tieba.lg2;
import com.baidu.tieba.lh3;
import com.baidu.tieba.lu2;
import com.baidu.tieba.ma2;
import com.baidu.tieba.n22;
import com.baidu.tieba.n53;
import com.baidu.tieba.nf2;
import com.baidu.tieba.no3;
import com.baidu.tieba.nr1;
import com.baidu.tieba.qw2;
import com.baidu.tieba.r73;
import com.baidu.tieba.tf2;
import com.baidu.tieba.wp4;
import com.baidu.tieba.wv2;
import com.baidu.tieba.xh2;
import com.baidu.tieba.xn3;
import com.baidu.tieba.xo3;
import com.baidu.tieba.y73;
import com.baidu.tieba.yh2;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SwanAppLocalService extends Service implements Handler.Callback {
    public static final String ACTION_PERLOAD = "com.baidu.swan.action.SWAN_APP_LOCAL_SERVICE_PERLOAD";
    public static final String ACTION_PREFIX = "com.baidu.swan.action.SWAN_APP_LOCAL_SERVICE_";
    public static final String ACTION_RECEIVER_MSG = "com.baidu.swan.action.SWAN_APP_LOCAL_SERVICE_RECEIVER_MSG";
    public static final String KEY_DATA = "data";
    public static final String TAG = "SwanAppLocalService";
    public Messenger mMessenger;
    public static final boolean DEBUG = nr1.a;
    public static boolean sFlagPreloaded = false;

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            xn3.g();
            xn3.f();
            xn3.h();
            n22.e(AppRuntime.getAppContext());
            if (ku2.V().b()) {
                ku2.I().d();
            }
            fq3.y(ku2.c());
            n53.a().c(R.layout.obfuscated_res_0x7f0d00ac, R.layout.obfuscated_res_0x7f0d00ca, R.layout.obfuscated_res_0x7f0d00bf);
            ku2.V().a(ku2.u0().a());
            boolean z = eq3.i;
            wv2.c().d("screenSize", no3.b());
            SwanAppLocalService.this.preloadActivityClass();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ClassLoader classLoader = SwanAppLocalService.this.getClassLoader();
                Class.forName(SwanAppProcessInfo.current().activity.getName(), true, classLoader);
                Class.forName(wp4.class.getName(), true, classLoader);
                Class.forName(ma2.b.class.getName(), true, classLoader);
                Class.forName(la2.class.getName(), true, classLoader);
                Class.forName(SwanAppSlaveManager.class.getName(), true, classLoader);
                Class.forName(JsFunction.class.getName(), true, classLoader);
                Class.forName(ib3.class.getName(), true, classLoader);
                Class.forName(SlideHelper.class.getName(), true, classLoader);
                Class.forName(fo2.class.getName(), true, classLoader);
                Class.forName(PullToRefreshBaseWebView.class.getName(), true, classLoader);
                Class.forName(SlidingPaneLayout.class.getName(), true, classLoader);
                Class.forName(lg2.class.getName(), true, classLoader);
                Class.forName(SwanAppConfigData.class.getName(), true, classLoader);
                Class.forName(r73.class.getName(), true, classLoader);
            } catch (Throwable th) {
                if (SwanAppLocalService.DEBUG) {
                    Log.d(SwanAppLocalService.TAG, Log.getStackTraceString(th));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preloadActivityClass() {
        xn3.k(new b(), "PreClassLoader");
    }

    public SwanAppProcessInfo getProcessInfo() {
        return SwanAppProcessInfo.P0;
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.mMessenger = null;
        super.onDestroy();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (DEBUG) {
            Log.d(TAG, "onBind: intent=" + intent);
        }
        onAction(intent);
        return this.mMessenger.getBinder();
    }

    private void onAction(Intent intent) {
        String action;
        if (DEBUG) {
            Log.i(TAG, "onAction: intent=" + intent);
        }
        if (intent == null) {
            action = "";
        } else {
            action = intent.getAction();
        }
        if (ACTION_PERLOAD.equals(action)) {
            try {
                onActionPreload(intent);
            } catch (Throwable th) {
                lh3.b bVar = new lh3.b(10013);
                bVar.i(th.getMessage());
                bVar.m();
                if (DEBUG) {
                    th.printStackTrace();
                }
            }
        } else if (ACTION_RECEIVER_MSG.equals(action)) {
            try {
                Message message = (Message) intent.getParcelableExtra("data");
                if (message != null) {
                    cb3.K().y().R().handleMessage(message);
                }
            } catch (Exception e) {
                Log.e(TAG, ACTION_RECEIVER_MSG, e);
            }
        }
    }

    private void onActionPreload(Intent intent) {
        if (intent == null) {
            return;
        }
        g53.e().i();
        long currentTimeMillis = System.currentTimeMillis();
        long longExtra = intent.getLongExtra("bundle_key_preload_launch_time", currentTimeMillis);
        long longExtra2 = intent.getLongExtra("bundle_key_preload_swan_updated_time", currentTimeMillis);
        String stringExtra = intent.getStringExtra("bundle_key_preload_preload_scene");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "0";
        }
        HybridUbcFlow p = i43.p("preload");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_pre_load_launch");
        ubcFlowEvent.h(longExtra);
        p.F(ubcFlowEvent);
        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_pre_load_swan_updated");
        ubcFlowEvent2.h(longExtra2);
        p.F(ubcFlowEvent2);
        UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("na_pre_load_receive");
        ubcFlowEvent3.h(currentTimeMillis);
        p.F(ubcFlowEvent3);
        p.D("with_preload", "1");
        if (!TextUtils.isEmpty(stringExtra)) {
            p.D("preload_scene", stringExtra);
        }
        if (ku2.g0() != null && ku2.g0().t()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("time", currentTimeMillis);
                jSONObject.put("process", intent.getIntExtra("bundle_key_process", -1));
                jSONObject.put("cost", currentTimeMillis - longExtra2);
                jSONObject.put("is_preload_started", xh2.D);
                jSONObject.put("is_preload_ready", xh2.U().m0());
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            i43.d dVar = new i43.d("812");
            dVar.g("swan");
            dVar.i(StatConstants.VALUE_TYPE_RECEIVE);
            dVar.h(intent.getStringExtra("bundle_key_preload_src"));
            dVar.e(jSONObject);
            i43.onEvent(dVar);
        }
        xh2.v.g(intent);
        qw2.T().t(intent);
        preloadSwanGame(intent);
        if (e53.m()) {
            SwanPrefetchImageRes.b().c();
        }
        if (!sFlagPreloaded) {
            sFlagPreloaded = true;
            xo3.a0(new a());
        }
        yh2.c(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
        if ((java.lang.System.currentTimeMillis() - com.baidu.tieba.xj2.b(1)) < (r0 * 86400000)) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void preloadSwanGame(Intent intent) {
        int d = b53.d();
        boolean z = false;
        if (d >= 0) {
            if (d != 0) {
            }
            z = true;
        }
        if (z) {
            lu2.i().p(intent);
        }
        if (DEBUG) {
            Log.d(TAG, "strategy : " + d + " , canPreload swan game : " + z);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        SwanAppProcessInfo.init(getProcessInfo());
        ku2.G().a();
        super.onCreate();
        this.mMessenger = new Messenger(y73.Q().R());
        if (DEBUG) {
            Log.i(TAG, "onCreate " + getProcessInfo());
        }
        y73.Q().c0();
        if2 a2 = if2.a();
        if2.b bVar = new if2.b();
        bVar.i(52428800L);
        bVar.g(new lf2());
        bVar.h(new CustomStrategyImpl());
        a2.i(bVar);
        ff2.b().a(new tf2(this, nf2.d()));
        ff2.b().a(new ag2(this, null));
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (DEBUG) {
            Log.d(TAG, "onStartCommand: intent=" + intent);
        }
        onAction(intent);
        return super.onStartCommand(intent, i, i2);
    }
}
