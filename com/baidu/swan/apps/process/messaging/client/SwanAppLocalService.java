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
import com.baidu.tieba.am1;
import com.baidu.tieba.ax1;
import com.baidu.tieba.cr2;
import com.baidu.tieba.d23;
import com.baidu.tieba.fa2;
import com.baidu.tieba.hk4;
import com.baidu.tieba.iq2;
import com.baidu.tieba.jc2;
import com.baidu.tieba.ji3;
import com.baidu.tieba.jj3;
import com.baidu.tieba.k23;
import com.baidu.tieba.kc2;
import com.baidu.tieba.ma2;
import com.baidu.tieba.nz2;
import com.baidu.tieba.o53;
import com.baidu.tieba.qk3;
import com.baidu.tieba.qz2;
import com.baidu.tieba.r92;
import com.baidu.tieba.ri2;
import com.baidu.tieba.rk3;
import com.baidu.tieba.sz2;
import com.baidu.tieba.u53;
import com.baidu.tieba.u92;
import com.baidu.tieba.uy2;
import com.baidu.tieba.wo2;
import com.baidu.tieba.x42;
import com.baidu.tieba.x92;
import com.baidu.tieba.xa2;
import com.baidu.tieba.xb3;
import com.baidu.tieba.xo2;
import com.baidu.tieba.y42;
import com.baidu.tieba.z92;
import com.baidu.tieba.zi3;
import com.baidu.tieba.zz2;
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
    public static final boolean DEBUG = am1.a;
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
            ji3.g();
            ji3.f();
            ji3.h();
            ax1.e(AppRuntime.getAppContext());
            if (wo2.V().b()) {
                wo2.I().d();
            }
            rk3.y(wo2.c());
            zz2.a().c(R.layout.obfuscated_res_0x7f0d00ac, R.layout.obfuscated_res_0x7f0d00ca, R.layout.obfuscated_res_0x7f0d00bf);
            wo2.V().a(wo2.u0().a());
            boolean z = qk3.i;
            iq2.c().d("screenSize", zi3.b());
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
                Class.forName(hk4.class.getName(), true, classLoader);
                Class.forName(y42.b.class.getName(), true, classLoader);
                Class.forName(x42.class.getName(), true, classLoader);
                Class.forName(SwanAppSlaveManager.class.getName(), true, classLoader);
                Class.forName(JsFunction.class.getName(), true, classLoader);
                Class.forName(u53.class.getName(), true, classLoader);
                Class.forName(SlideHelper.class.getName(), true, classLoader);
                Class.forName(ri2.class.getName(), true, classLoader);
                Class.forName(PullToRefreshBaseWebView.class.getName(), true, classLoader);
                Class.forName(SlidingPaneLayout.class.getName(), true, classLoader);
                Class.forName(xa2.class.getName(), true, classLoader);
                Class.forName(SwanAppConfigData.class.getName(), true, classLoader);
                Class.forName(d23.class.getName(), true, classLoader);
            } catch (Throwable th) {
                if (SwanAppLocalService.DEBUG) {
                    Log.d(SwanAppLocalService.TAG, Log.getStackTraceString(th));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preloadActivityClass() {
        ji3.k(new b(), "PreClassLoader");
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
                xb3.b bVar = new xb3.b(10013);
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
                    o53.K().y().R().handleMessage(message);
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
        sz2.e().i();
        long currentTimeMillis = System.currentTimeMillis();
        long longExtra = intent.getLongExtra("bundle_key_preload_launch_time", currentTimeMillis);
        long longExtra2 = intent.getLongExtra("bundle_key_preload_swan_updated_time", currentTimeMillis);
        String stringExtra = intent.getStringExtra("bundle_key_preload_preload_scene");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "0";
        }
        HybridUbcFlow p = uy2.p("preload");
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
        if (wo2.g0() != null && wo2.g0().t()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("time", currentTimeMillis);
                jSONObject.put("process", intent.getIntExtra("bundle_key_process", -1));
                jSONObject.put("cost", currentTimeMillis - longExtra2);
                jSONObject.put("is_preload_started", jc2.D);
                jSONObject.put("is_preload_ready", jc2.V().n0());
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            uy2.d dVar = new uy2.d("812");
            dVar.g("swan");
            dVar.i(StatConstants.VALUE_TYPE_RECEIVE);
            dVar.h(intent.getStringExtra("bundle_key_preload_src"));
            dVar.e(jSONObject);
            uy2.onEvent(dVar);
        }
        jc2.v.g(intent);
        cr2.V().u(intent);
        preloadSwanGame(intent);
        if (qz2.m()) {
            SwanPrefetchImageRes.b().c();
        }
        if (!sFlagPreloaded) {
            sFlagPreloaded = true;
            jj3.a0(new a());
        }
        kc2.c(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
        if ((java.lang.System.currentTimeMillis() - com.baidu.tieba.je2.b(1)) < (r0 * 86400000)) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void preloadSwanGame(Intent intent) {
        int d = nz2.d();
        boolean z = false;
        if (d >= 0) {
            if (d != 0) {
            }
            z = true;
        }
        if (z) {
            xo2.i().p(intent);
        }
        if (DEBUG) {
            Log.d(TAG, "strategy : " + d + " , canPreload swan game : " + z);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        SwanAppProcessInfo.init(getProcessInfo());
        wo2.G().a();
        super.onCreate();
        this.mMessenger = new Messenger(k23.Q().R());
        if (DEBUG) {
            Log.i(TAG, "onCreate " + getProcessInfo());
        }
        k23.Q().c0();
        u92 a2 = u92.a();
        u92.b bVar = new u92.b();
        bVar.i(52428800L);
        bVar.g(new x92());
        bVar.h(new CustomStrategyImpl());
        a2.i(bVar);
        r92.b().a(new fa2(this, z92.d()));
        r92.b().a(new ma2(this, null));
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
