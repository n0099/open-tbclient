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
import com.baidu.tieba.aq4;
import com.baidu.tieba.aw2;
import com.baidu.tieba.bi2;
import com.baidu.tieba.bo3;
import com.baidu.tieba.bp3;
import com.baidu.tieba.c83;
import com.baidu.tieba.ci2;
import com.baidu.tieba.eg2;
import com.baidu.tieba.f53;
import com.baidu.tieba.gb3;
import com.baidu.tieba.i53;
import com.baidu.tieba.iq3;
import com.baidu.tieba.jf2;
import com.baidu.tieba.jo2;
import com.baidu.tieba.jq3;
import com.baidu.tieba.k53;
import com.baidu.tieba.m43;
import com.baidu.tieba.mb3;
import com.baidu.tieba.mf2;
import com.baidu.tieba.ou2;
import com.baidu.tieba.pa2;
import com.baidu.tieba.pf2;
import com.baidu.tieba.pg2;
import com.baidu.tieba.ph3;
import com.baidu.tieba.pu2;
import com.baidu.tieba.qa2;
import com.baidu.tieba.r22;
import com.baidu.tieba.r53;
import com.baidu.tieba.rf2;
import com.baidu.tieba.ro3;
import com.baidu.tieba.rr1;
import com.baidu.tieba.uw2;
import com.baidu.tieba.v73;
import com.baidu.tieba.xf2;
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
    public static final boolean DEBUG = rr1.a;
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
            bo3.g();
            bo3.f();
            bo3.h();
            r22.e(AppRuntime.getAppContext());
            if (ou2.V().b()) {
                ou2.I().d();
            }
            jq3.y(ou2.c());
            r53.a().c(R.layout.obfuscated_res_0x7f0d00af, R.layout.obfuscated_res_0x7f0d00cd, R.layout.obfuscated_res_0x7f0d00c2);
            ou2.V().a(ou2.u0().a());
            boolean z = iq3.i;
            aw2.c().d("screenSize", ro3.b());
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
                Class.forName(aq4.class.getName(), true, classLoader);
                Class.forName(qa2.b.class.getName(), true, classLoader);
                Class.forName(pa2.class.getName(), true, classLoader);
                Class.forName(SwanAppSlaveManager.class.getName(), true, classLoader);
                Class.forName(JsFunction.class.getName(), true, classLoader);
                Class.forName(mb3.class.getName(), true, classLoader);
                Class.forName(SlideHelper.class.getName(), true, classLoader);
                Class.forName(jo2.class.getName(), true, classLoader);
                Class.forName(PullToRefreshBaseWebView.class.getName(), true, classLoader);
                Class.forName(SlidingPaneLayout.class.getName(), true, classLoader);
                Class.forName(pg2.class.getName(), true, classLoader);
                Class.forName(SwanAppConfigData.class.getName(), true, classLoader);
                Class.forName(v73.class.getName(), true, classLoader);
            } catch (Throwable th) {
                if (SwanAppLocalService.DEBUG) {
                    Log.d(SwanAppLocalService.TAG, Log.getStackTraceString(th));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preloadActivityClass() {
        bo3.k(new b(), "PreClassLoader");
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
                ph3.b bVar = new ph3.b(10013);
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
                    gb3.K().y().R().handleMessage(message);
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
        k53.e().i();
        long currentTimeMillis = System.currentTimeMillis();
        long longExtra = intent.getLongExtra("bundle_key_preload_launch_time", currentTimeMillis);
        long longExtra2 = intent.getLongExtra("bundle_key_preload_swan_updated_time", currentTimeMillis);
        String stringExtra = intent.getStringExtra("bundle_key_preload_preload_scene");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "0";
        }
        HybridUbcFlow p = m43.p("preload");
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
        if (ou2.g0() != null && ou2.g0().t()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("time", currentTimeMillis);
                jSONObject.put("process", intent.getIntExtra("bundle_key_process", -1));
                jSONObject.put("cost", currentTimeMillis - longExtra2);
                jSONObject.put("is_preload_started", bi2.D);
                jSONObject.put("is_preload_ready", bi2.U().m0());
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            m43.d dVar = new m43.d("812");
            dVar.g("swan");
            dVar.i(StatConstants.VALUE_TYPE_RECEIVE);
            dVar.h(intent.getStringExtra("bundle_key_preload_src"));
            dVar.e(jSONObject);
            m43.onEvent(dVar);
        }
        bi2.v.g(intent);
        uw2.T().t(intent);
        preloadSwanGame(intent);
        if (i53.m()) {
            SwanPrefetchImageRes.b().c();
        }
        if (!sFlagPreloaded) {
            sFlagPreloaded = true;
            bp3.a0(new a());
        }
        ci2.c(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
        if ((java.lang.System.currentTimeMillis() - com.baidu.tieba.bk2.b(1)) < (r0 * 86400000)) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void preloadSwanGame(Intent intent) {
        int d = f53.d();
        boolean z = false;
        if (d >= 0) {
            if (d != 0) {
            }
            z = true;
        }
        if (z) {
            pu2.i().p(intent);
        }
        if (DEBUG) {
            Log.d(TAG, "strategy : " + d + " , canPreload swan game : " + z);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        SwanAppProcessInfo.init(getProcessInfo());
        ou2.G().a();
        super.onCreate();
        this.mMessenger = new Messenger(c83.Q().R());
        if (DEBUG) {
            Log.i(TAG, "onCreate " + getProcessInfo());
        }
        c83.Q().c0();
        mf2 a2 = mf2.a();
        mf2.b bVar = new mf2.b();
        bVar.i(52428800L);
        bVar.g(new pf2());
        bVar.h(new CustomStrategyImpl());
        a2.i(bVar);
        jf2.b().a(new xf2(this, rf2.d()));
        jf2.b().a(new eg2(this, null));
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
