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
import com.baidu.tieba.ab2;
import com.baidu.tieba.cl4;
import com.baidu.tieba.dr2;
import com.baidu.tieba.ed2;
import com.baidu.tieba.ej3;
import com.baidu.tieba.ek3;
import com.baidu.tieba.f33;
import com.baidu.tieba.fd2;
import com.baidu.tieba.hb2;
import com.baidu.tieba.i03;
import com.baidu.tieba.j63;
import com.baidu.tieba.l03;
import com.baidu.tieba.ll3;
import com.baidu.tieba.ma2;
import com.baidu.tieba.mj2;
import com.baidu.tieba.ml3;
import com.baidu.tieba.n03;
import com.baidu.tieba.p63;
import com.baidu.tieba.pa2;
import com.baidu.tieba.pz2;
import com.baidu.tieba.rp2;
import com.baidu.tieba.s52;
import com.baidu.tieba.sa2;
import com.baidu.tieba.sb2;
import com.baidu.tieba.sc3;
import com.baidu.tieba.sp2;
import com.baidu.tieba.t52;
import com.baidu.tieba.u03;
import com.baidu.tieba.ua2;
import com.baidu.tieba.uj3;
import com.baidu.tieba.vm1;
import com.baidu.tieba.vx1;
import com.baidu.tieba.xr2;
import com.baidu.tieba.y23;
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
    public static final boolean DEBUG = vm1.a;
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
            ej3.g();
            ej3.f();
            ej3.h();
            vx1.e(AppRuntime.getAppContext());
            if (rp2.V().b()) {
                rp2.I().d();
            }
            ml3.y(rp2.c());
            u03.a().c(R.layout.obfuscated_res_0x7f0d00af, R.layout.obfuscated_res_0x7f0d00cd, R.layout.obfuscated_res_0x7f0d00c2);
            rp2.V().a(rp2.u0().a());
            boolean z = ll3.i;
            dr2.c().d("screenSize", uj3.b());
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
                Class.forName(cl4.class.getName(), true, classLoader);
                Class.forName(t52.b.class.getName(), true, classLoader);
                Class.forName(s52.class.getName(), true, classLoader);
                Class.forName(SwanAppSlaveManager.class.getName(), true, classLoader);
                Class.forName(JsFunction.class.getName(), true, classLoader);
                Class.forName(p63.class.getName(), true, classLoader);
                Class.forName(SlideHelper.class.getName(), true, classLoader);
                Class.forName(mj2.class.getName(), true, classLoader);
                Class.forName(PullToRefreshBaseWebView.class.getName(), true, classLoader);
                Class.forName(SlidingPaneLayout.class.getName(), true, classLoader);
                Class.forName(sb2.class.getName(), true, classLoader);
                Class.forName(SwanAppConfigData.class.getName(), true, classLoader);
                Class.forName(y23.class.getName(), true, classLoader);
            } catch (Throwable th) {
                if (SwanAppLocalService.DEBUG) {
                    Log.d(SwanAppLocalService.TAG, Log.getStackTraceString(th));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preloadActivityClass() {
        ej3.k(new b(), "PreClassLoader");
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
                sc3.b bVar = new sc3.b(10013);
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
                    j63.K().y().R().handleMessage(message);
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
        n03.e().i();
        long currentTimeMillis = System.currentTimeMillis();
        long longExtra = intent.getLongExtra("bundle_key_preload_launch_time", currentTimeMillis);
        long longExtra2 = intent.getLongExtra("bundle_key_preload_swan_updated_time", currentTimeMillis);
        String stringExtra = intent.getStringExtra("bundle_key_preload_preload_scene");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "0";
        }
        HybridUbcFlow p = pz2.p("preload");
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
        if (rp2.g0() != null && rp2.g0().t()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("time", currentTimeMillis);
                jSONObject.put("process", intent.getIntExtra("bundle_key_process", -1));
                jSONObject.put("cost", currentTimeMillis - longExtra2);
                jSONObject.put("is_preload_started", ed2.D);
                jSONObject.put("is_preload_ready", ed2.V().n0());
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            pz2.d dVar = new pz2.d("812");
            dVar.g("swan");
            dVar.i(StatConstants.VALUE_TYPE_RECEIVE);
            dVar.h(intent.getStringExtra("bundle_key_preload_src"));
            dVar.e(jSONObject);
            pz2.onEvent(dVar);
        }
        ed2.v.g(intent);
        xr2.V().u(intent);
        preloadSwanGame(intent);
        if (l03.m()) {
            SwanPrefetchImageRes.b().c();
        }
        if (!sFlagPreloaded) {
            sFlagPreloaded = true;
            ek3.a0(new a());
        }
        fd2.c(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
        if ((java.lang.System.currentTimeMillis() - com.baidu.tieba.ef2.b(1)) < (r0 * 86400000)) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void preloadSwanGame(Intent intent) {
        int d = i03.d();
        boolean z = false;
        if (d >= 0) {
            if (d != 0) {
            }
            z = true;
        }
        if (z) {
            sp2.i().p(intent);
        }
        if (DEBUG) {
            Log.d(TAG, "strategy : " + d + " , canPreload swan game : " + z);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        SwanAppProcessInfo.init(getProcessInfo());
        rp2.G().a();
        super.onCreate();
        this.mMessenger = new Messenger(f33.Q().R());
        if (DEBUG) {
            Log.i(TAG, "onCreate " + getProcessInfo());
        }
        f33.Q().c0();
        pa2 a2 = pa2.a();
        pa2.b bVar = new pa2.b();
        bVar.i(52428800L);
        bVar.g(new sa2());
        bVar.h(new CustomStrategyImpl());
        a2.i(bVar);
        ma2.b().a(new ab2(this, ua2.d()));
        ma2.b().a(new hb2(this, null));
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
