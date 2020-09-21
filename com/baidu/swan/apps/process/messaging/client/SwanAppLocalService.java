package com.baidu.swan.apps.process.messaging.client;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.searchbox.widget.SlideHelper;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import com.baidu.swan.apps.core.turbo.d;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.j;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.apps.view.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SwanAppLocalService extends Service implements Handler.Callback {
    private static final String AB_SWAN_PRECLASS = "swan_preclass";
    public static final String ACTION_PERLOAD = "com.baidu.swan.action.SWAN_APP_LOCAL_SERVICE_PERLOAD";
    public static final String ACTION_PREFIX = "com.baidu.swan.action.SWAN_APP_LOCAL_SERVICE_";
    private static final String TAG = "SwanAppLocalService";
    private Messenger mMessenger;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean sFlagPreloaded = false;

    @Override // android.app.Service
    public void onCreate() {
        SwanAppProcessInfo.init(getProcessInfo());
        com.baidu.swan.apps.t.a.aqn().abf();
        super.onCreate();
        this.mMessenger = new Messenger(a.ayl().ayo());
        if (DEBUG) {
            Log.i(TAG, "onCreate " + getProcessInfo());
        }
        a.ayl().ayn();
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.mMessenger = null;
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (DEBUG) {
            Log.d(TAG, "onStartCommand: intent=" + intent);
        }
        onAction(intent);
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (DEBUG) {
            Log.d(TAG, "onBind: intent=" + intent);
        }
        onAction(intent);
        return this.mMessenger.getBinder();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    private void onAction(Intent intent) {
        if (DEBUG) {
            Log.i(TAG, "onAction: intent=" + intent);
        }
        if (ACTION_PERLOAD.equals(intent == null ? "" : intent.getAction())) {
            onActionPreload(intent);
        }
    }

    private void onActionPreload(Intent intent) {
        if (intent != null) {
            long currentTimeMillis = System.currentTimeMillis();
            long longExtra = intent.getLongExtra("bundle_key_preload_launch_time", currentTimeMillis);
            long longExtra2 = intent.getLongExtra("bundle_key_preload_swan_updated_time", currentTimeMillis);
            String stringExtra = intent.getStringExtra("bundle_key_preload_preload_scene");
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = "0";
            }
            HybridUbcFlow bW = i.pq("preload").f(new UbcFlowEvent("na_pre_load_launch").bs(longExtra)).f(new UbcFlowEvent("na_pre_load_swan_updated").bs(longExtra2)).f(new UbcFlowEvent("na_pre_load_receive").bs(currentTimeMillis)).bW("with_preload", "1");
            if (!TextUtils.isEmpty(stringExtra)) {
                bW.bW("preload_scene", stringExtra);
            }
            if (com.baidu.swan.apps.t.a.apx() != null && com.baidu.swan.apps.t.a.apx().Zm()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("time", currentTimeMillis);
                    jSONObject.put("process", intent.getIntExtra("bundle_key_process", -1));
                    jSONObject.put(BdStatsConstant.StatsKey.COST, currentTimeMillis - longExtra2);
                    jSONObject.put("is_preload_started", d.cpQ);
                    jSONObject.put("is_preload_ready", d.akC().akK());
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                i.a pC = new i.a("812").pA("swan").pB("receive").pC(intent.getStringExtra("bundle_key_preload_src"));
                pC.bQ(jSONObject);
                i.onEvent(pC);
            }
            d.C0391d.s(intent);
            com.baidu.swan.games.utils.so.d.z(intent);
            f.asJ().w(intent);
            com.baidu.swan.games.j.a.aOn().r(intent);
            if (!sFlagPreloaded) {
                sFlagPreloaded = true;
                ak.m(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.client.SwanAppLocalService.1
                    @Override // java.lang.Runnable
                    public void run() {
                        f.asJ().aaw();
                        com.baidu.swan.apps.t.a.apM().aqU();
                        c.cQ(com.baidu.swan.apps.t.a.apu());
                        com.baidu.swan.apps.t.a.apS().aav();
                        SwanAppLocalService.this.preloadActivityClass();
                    }
                });
            }
            if (com.baidu.swan.apps.performance.b.b.cJi && !com.baidu.swan.apps.performance.b.b.awQ()) {
                p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.client.SwanAppLocalService.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.baidu.swan.apps.performance.b.b.init();
                    }
                }, "SwanAbSwitchCache");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preloadActivityClass() {
        final int i = com.baidu.swan.apps.t.a.apx().getSwitch(AB_SWAN_PRECLASS, 0);
        if (i > 0) {
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.client.SwanAppLocalService.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ClassLoader classLoader = SwanAppLocalService.this.getClassLoader();
                        if (com.baidu.swan.apps.performance.b.c.awY()) {
                            Looper.prepare();
                            Class.forName(SwanAppProcessInfo.current().activity.getName(), true, classLoader);
                            Class.forName(com.baidu.swan.support.v4.c.f.class.getName(), true, classLoader);
                            Class.forName(f.b.class.getName(), true, classLoader);
                            Class.forName(e.class.getName(), true, classLoader);
                            Class.forName(SwanAppSlaveManager.class.getName(), true, classLoader);
                            Class.forName(JsFunction.class.getName(), true, classLoader);
                            Class.forName(j.class.getName(), true, classLoader);
                            Class.forName(SlideHelper.class.getName(), true, classLoader);
                            Class.forName(com.baidu.swan.apps.framework.a.a.class.getName(), true, classLoader);
                            Class.forName(PullToRefreshBaseWebView.class.getName(), true, classLoader);
                            Class.forName(SlidingPaneLayout.class.getName(), true, classLoader);
                            Class.forName(com.baidu.swan.apps.core.h.b.class.getName(), true, classLoader);
                        }
                        com.baidu.swan.apps.ap.c.a.a(classLoader, SwanAppProcessInfo.current().activity.newInstance()).a(com.baidu.swan.apps.ap.c.a.den).kB(i);
                    } catch (Throwable th) {
                        if (SwanAppLocalService.DEBUG) {
                            Log.d(SwanAppLocalService.TAG, Log.getStackTraceString(th));
                        }
                    }
                }
            }, AB_SWAN_PRECLASS);
        }
    }

    protected SwanAppProcessInfo getProcessInfo() {
        return SwanAppProcessInfo.P0;
    }
}
