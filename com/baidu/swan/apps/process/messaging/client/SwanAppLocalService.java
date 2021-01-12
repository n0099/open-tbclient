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
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.p;
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
import com.baidu.swan.games.view.webview.GameWebViewJavascriptInterface;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
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
        com.baidu.swan.apps.t.a.axr().aic();
        super.onCreate();
        this.mMessenger = new Messenger(a.aFo().aFr());
        if (DEBUG) {
            Log.i(TAG, "onCreate " + getProcessInfo());
        }
        a.aFo().aFq();
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
            HybridUbcFlow cm = i.pS("preload").f(new UbcFlowEvent("na_pre_load_launch").cy(longExtra)).f(new UbcFlowEvent("na_pre_load_swan_updated").cy(longExtra2)).f(new UbcFlowEvent("na_pre_load_receive").cy(currentTimeMillis)).cm("with_preload", "1");
            if (!TextUtils.isEmpty(stringExtra)) {
                cm.cm("preload_scene", stringExtra);
            }
            if (com.baidu.swan.apps.t.a.awB() != null && com.baidu.swan.apps.t.a.awB().agh()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("time", currentTimeMillis);
                    jSONObject.put("process", intent.getIntExtra("bundle_key_process", -1));
                    jSONObject.put(BdStatsConstant.StatsKey.COST, currentTimeMillis - longExtra2);
                    jSONObject.put("is_preload_started", d.cVL);
                    jSONObject.put("is_preload_ready", d.arG().arO());
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                i.a qe = new i.a("812").qc(GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME).qd("receive").qe(intent.getStringExtra("bundle_key_preload_src"));
                qe.ck(jSONObject);
                i.onEvent(qe);
            }
            d.C0419d.s(intent);
            com.baidu.swan.games.utils.so.d.A(intent);
            f.azN().w(intent);
            com.baidu.swan.games.j.a.aWo().r(intent);
            if (!sFlagPreloaded) {
                sFlagPreloaded = true;
                ak.l(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.client.SwanAppLocalService.1
                    @Override // java.lang.Runnable
                    public void run() {
                        f.azN().ahr();
                        com.baidu.swan.apps.t.a.awQ().axZ();
                        c.dU(com.baidu.swan.apps.t.a.awy());
                        com.baidu.swan.apps.t.a.awW().ahq();
                        SwanAppLocalService.this.preloadActivityClass();
                    }
                });
            }
            if (com.baidu.swan.apps.performance.b.b.dpi && !com.baidu.swan.apps.performance.b.b.aDV()) {
                p.a(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.client.SwanAppLocalService.2
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
        final int i = com.baidu.swan.apps.t.a.awB().getSwitch(AB_SWAN_PRECLASS, 0);
        if (i > 0) {
            p.b(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.client.SwanAppLocalService.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ClassLoader classLoader = SwanAppLocalService.this.getClassLoader();
                        if (com.baidu.swan.apps.performance.b.c.aEd()) {
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
                        com.baidu.swan.apps.ao.c.a.a(classLoader, SwanAppProcessInfo.current().activity.newInstance()).a(com.baidu.swan.apps.ao.c.a.dOb).km(i);
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
