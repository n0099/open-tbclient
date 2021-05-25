package com.baidu.swan.apps.process.messaging.client;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
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
import d.a.l0.a.a2.d;
import d.a.l0.a.a2.j;
import d.a.l0.a.h0.g.g;
import d.a.l0.a.h0.o.h.d.a;
import d.a.l0.a.h0.u.g;
import d.a.l0.a.j2.c;
import d.a.l0.a.k;
import d.a.l0.a.r1.h;
import d.a.l0.a.u.e.p.g;
import d.a.l0.a.v2.g0;
import d.a.l0.a.v2.q;
import d.a.l0.a.v2.q0;
import d.a.l0.a.w2.e;
import d.a.l0.o.a.d.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SwanAppLocalService extends Service implements Handler.Callback {
    public static final String ACTION_PERLOAD = "com.baidu.swan.action.SWAN_APP_LOCAL_SERVICE_PERLOAD";
    public static final String ACTION_PREFIX = "com.baidu.swan.action.SWAN_APP_LOCAL_SERVICE_";
    public static final String ACTION_RECEIVER_MSG = "com.baidu.swan.action.SWAN_APP_LOCAL_SERVICE_RECEIVER_MSG";
    public static final String KEY_DATA = "data";
    public static final String TAG = "SwanAppLocalService";
    public Messenger mMessenger;
    public static final boolean DEBUG = k.f43199a;
    public static boolean sFlagPreloaded = false;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            q.f();
            q.e();
            q.g();
            g.d(AppRuntime.getAppContext());
            d.a.l0.a.c1.a.E().d();
            e.z(d.a.l0.a.c1.a.b());
            d.a.l0.a.r1.n.a.a().c(d.a.l0.a.g.aiapps_fragment, d.a.l0.a.g.aiapps_pull_to_load_footer);
            d.a.l0.a.c1.a.Q().a(d.a.l0.a.c1.a.l0().a());
            if (d.a.l0.a.r1.l.e.j()) {
                boolean z = d.a.l0.a.w2.d.b.f45658i;
                d.a.l0.a.f1.c.b.c().d("screenSize", g0.b());
            }
            SwanAppLocalService.this.preloadActivityClass();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ClassLoader classLoader = SwanAppLocalService.this.getClassLoader();
                Class.forName(SwanAppProcessInfo.current().activity.getName(), true, classLoader);
                Class.forName(f.class.getName(), true, classLoader);
                Class.forName(g.b.class.getName(), true, classLoader);
                Class.forName(d.a.l0.a.h0.g.f.class.getName(), true, classLoader);
                Class.forName(SwanAppSlaveManager.class.getName(), true, classLoader);
                Class.forName(JsFunction.class.getName(), true, classLoader);
                Class.forName(j.class.getName(), true, classLoader);
                Class.forName(SlideHelper.class.getName(), true, classLoader);
                Class.forName(d.a.l0.a.t0.f.a.class.getName(), true, classLoader);
                Class.forName(PullToRefreshBaseWebView.class.getName(), true, classLoader);
                Class.forName(SlidingPaneLayout.class.getName(), true, classLoader);
                Class.forName(d.a.l0.a.h0.p.b.class.getName(), true, classLoader);
                Class.forName(SwanAppConfigData.class.getName(), true, classLoader);
                Class.forName(d.a.l0.a.v1.b.e.class.getName(), true, classLoader);
            } catch (Throwable th) {
                if (SwanAppLocalService.DEBUG) {
                    Log.d(SwanAppLocalService.TAG, Log.getStackTraceString(th));
                }
            }
        }
    }

    private void onAction(Intent intent) {
        if (DEBUG) {
            Log.i(TAG, "onAction: intent=" + intent);
        }
        String action = intent == null ? "" : intent.getAction();
        if (ACTION_PERLOAD.equals(action)) {
            try {
                onActionPreload(intent);
            } catch (Throwable th) {
                c.b bVar = new c.b(CyberPlayerManager.MEDIA_INFO_START_PULL_STREAM);
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
                    d.g().z().F().handleMessage(message);
                }
            } catch (Exception e2) {
                Log.e(TAG, ACTION_RECEIVER_MSG, e2);
            }
        }
    }

    private void onActionPreload(Intent intent) {
        if (intent == null) {
            return;
        }
        d.a.l0.a.r1.l.f.a.e().i();
        long currentTimeMillis = System.currentTimeMillis();
        long longExtra = intent.getLongExtra("bundle_key_preload_launch_time", currentTimeMillis);
        long longExtra2 = intent.getLongExtra("bundle_key_preload_swan_updated_time", currentTimeMillis);
        String stringExtra = intent.getStringExtra("bundle_key_preload_preload_scene");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "0";
        }
        HybridUbcFlow p = h.p("preload");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_pre_load_launch");
        ubcFlowEvent.h(longExtra);
        p.C(ubcFlowEvent);
        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_pre_load_swan_updated");
        ubcFlowEvent2.h(longExtra2);
        p.C(ubcFlowEvent2);
        UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("na_pre_load_receive");
        ubcFlowEvent3.h(currentTimeMillis);
        p.C(ubcFlowEvent3);
        p.A("with_preload", "1");
        if (!TextUtils.isEmpty(stringExtra)) {
            p.A("preload_scene", stringExtra);
        }
        if (d.a.l0.a.c1.a.Z() != null && d.a.l0.a.c1.a.Z().w()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("time", currentTimeMillis);
                jSONObject.put("process", intent.getIntExtra("bundle_key_process", -1));
                jSONObject.put("cost", currentTimeMillis - longExtra2);
                jSONObject.put("is_preload_started", d.a.l0.a.h0.u.g.y);
                jSONObject.put("is_preload_ready", d.a.l0.a.h0.u.g.N().c0());
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            h.d dVar = new h.d("812");
            dVar.g("swan");
            dVar.i("receive");
            dVar.h(intent.getStringExtra("bundle_key_preload_src"));
            dVar.e(jSONObject);
            h.onEvent(dVar);
        }
        g.t.g(intent);
        d.a.l0.a.g1.f.V().t(intent);
        preloadSwanGame(intent);
        if (d.a.l0.a.r1.l.e.n()) {
            SwanPrefetchImageRes.b().c();
        }
        if (sFlagPreloaded) {
            return;
        }
        sFlagPreloaded = true;
        q0.X(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preloadActivityClass() {
        q.j(new b(), "PreClassLoader");
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
        if ((java.lang.System.currentTimeMillis() - d.a.l0.a.n0.i.a.b(1)) < (r0 * 86400000)) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void preloadSwanGame(Intent intent) {
        int h2 = d.a.l0.a.r1.l.b.h();
        boolean z = false;
        if (h2 >= 0) {
            if (h2 != 0) {
            }
            z = true;
        }
        if (z) {
            d.a.l0.a.c1.b.i().q(intent);
        }
        if (DEBUG) {
            Log.d(TAG, "strategy : " + h2 + " , canPreload swan game : " + z);
        }
    }

    public SwanAppProcessInfo getProcessInfo() {
        return SwanAppProcessInfo.P0;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (DEBUG) {
            Log.d(TAG, "onBind: intent=" + intent);
        }
        onAction(intent);
        return this.mMessenger.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        SwanAppProcessInfo.init(getProcessInfo());
        d.a.l0.a.c1.a.C().a();
        super.onCreate();
        this.mMessenger = new Messenger(d.a.l0.a.v1.c.e.a.E().F());
        if (DEBUG) {
            Log.i(TAG, "onCreate " + getProcessInfo());
        }
        d.a.l0.a.v1.c.e.a.E().Q();
        d.a.l0.a.h0.o.h.d.a a2 = d.a.l0.a.h0.o.h.d.a.a();
        a.b bVar = new a.b();
        bVar.i(52428800L);
        bVar.g(new d.a.l0.a.h0.o.h.d.c.b());
        bVar.h(new CustomStrategyImpl());
        a2.i(bVar);
        d.a.l0.a.h0.o.h.a.b().a(new d.a.l0.a.h0.o.h.b(this, d.a.l0.a.h0.o.h.f.a.d()));
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.mMessenger = null;
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        if (DEBUG) {
            Log.d(TAG, "onStartCommand: intent=" + intent);
        }
        onAction(intent);
        return super.onStartCommand(intent, i2, i3);
    }
}
