package com.baidu.swan.apps.process.messaging.client;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.core.turbo.d;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.g;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.view.c;
import com.baidu.swan.apps.w.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
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
        com.baidu.swan.apps.u.a.agO().TU();
        super.onCreate();
        this.mMessenger = new Messenger(a.anW().anZ());
        if (DEBUG) {
            Log.i(TAG, "onCreate " + getProcessInfo());
        }
        a.anW().anY();
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
            HybridUbcFlow bF = g.mx("preload").f(new UbcFlowEvent("na_pre_load_launch").bg(longExtra)).f(new UbcFlowEvent("na_pre_load_swan_updated").bg(longExtra2)).f(new UbcFlowEvent("na_pre_load_receive").bg(currentTimeMillis)).bF("with_preload", "1");
            if (!TextUtils.isEmpty(stringExtra)) {
                bF.bF("preload_scene", stringExtra);
            }
            if (com.baidu.swan.apps.u.a.aga() != null && com.baidu.swan.apps.u.a.aga().Sq()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("time", currentTimeMillis);
                    jSONObject.put("process", intent.getIntExtra("bundle_key_process", -1));
                    jSONObject.put(BdStatsConstant.StatsKey.COST, currentTimeMillis - longExtra2);
                    jSONObject.put("is_preload_started", d.cfI);
                    jSONObject.put("is_preload_ready", d.acr().acx());
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                g.a mI = new g.a("812").mG("swan").mH("receive").mI(intent.getStringExtra("bundle_key_preload_src"));
                mI.bA(jSONObject);
                g.onEvent(mI);
            }
            d.b.q(intent);
            com.baidu.swan.games.utils.so.d.x(intent);
            f.ajb().u(intent);
            com.baidu.swan.games.j.a.aBj().p(intent);
            if (!sFlagPreloaded) {
                sFlagPreloaded = true;
                aj.p(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.client.SwanAppLocalService.1
                    @Override // java.lang.Runnable
                    public void run() {
                        f.ajb().Tn();
                        com.baidu.swan.apps.u.a.agp().ahp();
                        c.cG(com.baidu.swan.apps.u.a.afX());
                        SwanAppLocalService.this.preloadActivityClass();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preloadActivityClass() {
        final int i = com.baidu.swan.apps.u.a.aga().getSwitch(AB_SWAN_PRECLASS, 0);
        if (i > 0) {
            n.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.client.SwanAppLocalService.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.baidu.swan.apps.aq.c.a.n(SwanAppProcessInfo.current().activity.newInstance()).a(com.baidu.swan.apps.aq.c.a.cPG).hX(i);
                    } catch (Throwable th) {
                        if (SwanAppLocalService.DEBUG) {
                            th.printStackTrace();
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
