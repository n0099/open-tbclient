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
import com.baidu.tieba.a53;
import com.baidu.tieba.ac3;
import com.baidu.tieba.ag2;
import com.baidu.tieba.cv2;
import com.baidu.tieba.db2;
import com.baidu.tieba.dg2;
import com.baidu.tieba.dh2;
import com.baidu.tieba.di3;
import com.baidu.tieba.dv2;
import com.baidu.tieba.eb2;
import com.baidu.tieba.f32;
import com.baidu.tieba.f63;
import com.baidu.tieba.fg2;
import com.baidu.tieba.fp3;
import com.baidu.tieba.fs1;
import com.baidu.tieba.ix2;
import com.baidu.tieba.j83;
import com.baidu.tieba.lg2;
import com.baidu.tieba.oq4;
import com.baidu.tieba.ow2;
import com.baidu.tieba.pi2;
import com.baidu.tieba.po3;
import com.baidu.tieba.pp3;
import com.baidu.tieba.q83;
import com.baidu.tieba.qi2;
import com.baidu.tieba.sg2;
import com.baidu.tieba.t53;
import com.baidu.tieba.ub3;
import com.baidu.tieba.w53;
import com.baidu.tieba.wq3;
import com.baidu.tieba.xf2;
import com.baidu.tieba.xo2;
import com.baidu.tieba.xq3;
import com.baidu.tieba.y53;
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
    public static final boolean DEBUG = fs1.a;
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
            po3.g();
            po3.f();
            po3.h();
            f32.e(AppRuntime.getAppContext());
            if (cv2.V().b()) {
                cv2.I().d();
            }
            xq3.y(cv2.c());
            f63.a().c(R.layout.obfuscated_res_0x7f0d00aa, R.layout.obfuscated_res_0x7f0d00c8, R.layout.obfuscated_res_0x7f0d00bd);
            cv2.V().a(cv2.u0().a());
            boolean z = wq3.i;
            ow2.c().d("screenSize", fp3.b());
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
                Class.forName(oq4.class.getName(), true, classLoader);
                Class.forName(eb2.b.class.getName(), true, classLoader);
                Class.forName(db2.class.getName(), true, classLoader);
                Class.forName(SwanAppSlaveManager.class.getName(), true, classLoader);
                Class.forName(JsFunction.class.getName(), true, classLoader);
                Class.forName(ac3.class.getName(), true, classLoader);
                Class.forName(SlideHelper.class.getName(), true, classLoader);
                Class.forName(xo2.class.getName(), true, classLoader);
                Class.forName(PullToRefreshBaseWebView.class.getName(), true, classLoader);
                Class.forName(SlidingPaneLayout.class.getName(), true, classLoader);
                Class.forName(dh2.class.getName(), true, classLoader);
                Class.forName(SwanAppConfigData.class.getName(), true, classLoader);
                Class.forName(j83.class.getName(), true, classLoader);
            } catch (Throwable th) {
                if (SwanAppLocalService.DEBUG) {
                    Log.d(SwanAppLocalService.TAG, Log.getStackTraceString(th));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preloadActivityClass() {
        po3.k(new b(), "PreClassLoader");
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
                di3.b bVar = new di3.b(10013);
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
                    ub3.K().y().R().handleMessage(message);
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
        y53.e().i();
        long currentTimeMillis = System.currentTimeMillis();
        long longExtra = intent.getLongExtra("bundle_key_preload_launch_time", currentTimeMillis);
        long longExtra2 = intent.getLongExtra("bundle_key_preload_swan_updated_time", currentTimeMillis);
        String stringExtra = intent.getStringExtra("bundle_key_preload_preload_scene");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "0";
        }
        HybridUbcFlow p = a53.p("preload");
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
        if (cv2.g0() != null && cv2.g0().t()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("time", currentTimeMillis);
                jSONObject.put("process", intent.getIntExtra("bundle_key_process", -1));
                jSONObject.put("cost", currentTimeMillis - longExtra2);
                jSONObject.put("is_preload_started", pi2.D);
                jSONObject.put("is_preload_ready", pi2.U().m0());
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            a53.d dVar = new a53.d("812");
            dVar.g("swan");
            dVar.i(StatConstants.VALUE_TYPE_RECEIVE);
            dVar.h(intent.getStringExtra("bundle_key_preload_src"));
            dVar.e(jSONObject);
            a53.onEvent(dVar);
        }
        pi2.v.g(intent);
        ix2.T().t(intent);
        preloadSwanGame(intent);
        if (w53.m()) {
            SwanPrefetchImageRes.b().c();
        }
        if (!sFlagPreloaded) {
            sFlagPreloaded = true;
            pp3.a0(new a());
        }
        qi2.c(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
        if ((java.lang.System.currentTimeMillis() - com.baidu.tieba.pk2.b(1)) < (r0 * 86400000)) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void preloadSwanGame(Intent intent) {
        int d = t53.d();
        boolean z = false;
        if (d >= 0) {
            if (d != 0) {
            }
            z = true;
        }
        if (z) {
            dv2.i().p(intent);
        }
        if (DEBUG) {
            Log.d(TAG, "strategy : " + d + " , canPreload swan game : " + z);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        SwanAppProcessInfo.init(getProcessInfo());
        cv2.G().a();
        super.onCreate();
        this.mMessenger = new Messenger(q83.Q().R());
        if (DEBUG) {
            Log.i(TAG, "onCreate " + getProcessInfo());
        }
        q83.Q().c0();
        ag2 a2 = ag2.a();
        ag2.b bVar = new ag2.b();
        bVar.i(52428800L);
        bVar.g(new dg2());
        bVar.h(new CustomStrategyImpl());
        a2.i(bVar);
        xf2.b().a(new lg2(this, fg2.d()));
        xf2.b().a(new sg2(this, null));
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
