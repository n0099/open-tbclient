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
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.c.a.g;
import com.baidu.swan.apps.core.k.d;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.f;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class SwanAppLocalService extends Service implements Handler.Callback {
    public static final String ACTION_PERLOAD = "com.baidu.swan.action.SWAN_APP_LOCAL_SERVICE_PERLOAD";
    public static final String ACTION_PREFIX = "com.baidu.swan.action.SWAN_APP_LOCAL_SERVICE_";
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = "SwanAppLocalService";
    private Messenger mMessenger;

    @Override // android.app.Service
    public void onCreate() {
        SwanAppProcessInfo.init(getProcessInfo());
        com.baidu.swan.apps.w.a.UM().Iu();
        super.onCreate();
        this.mMessenger = new Messenger(a.aaT().aaW());
        if (DEBUG) {
            Log.i(TAG, "onCreate " + getProcessInfo());
        }
        a.aaT().aaV();
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
            HybridUbcFlow bb = f.jP("preload").f(new UbcFlowEvent("na_pre_load_launch").au(longExtra)).f(new UbcFlowEvent("na_pre_load_swan_updated").au(longExtra2)).f(new UbcFlowEvent("na_pre_load_receive").au(currentTimeMillis)).bb("with_preload", "1");
            if (!TextUtils.isEmpty(stringExtra)) {
                bb.bb("preload_scene", stringExtra);
            }
            if (com.baidu.swan.apps.w.a.TX() != null && com.baidu.swan.apps.w.a.TX().Hf()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("time", currentTimeMillis);
                    jSONObject.put("process", intent.getIntExtra("bundle_key_process", -1));
                    jSONObject.put(BdStatsConstant.StatsKey.COST, currentTimeMillis - longExtra2);
                    jSONObject.put("is_preload_started", d.bsH);
                    jSONObject.put("is_preload_ready", d.Qu().Qz());
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                f.a jZ = new f.a("812").jX("swan").jY("receive").jZ(intent.getStringExtra("bundle_key_preload_src"));
                jZ.aZ(jSONObject);
                f.onEvent(jZ);
            }
            d.b.F(intent);
            com.baidu.swan.games.utils.so.d.P(intent);
            com.baidu.swan.apps.y.f.WQ().J(intent);
            com.baidu.swan.games.i.a.anW().E(intent);
            ai.l(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.client.SwanAppLocalService.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.y.f.WQ().HD();
                    com.baidu.swan.apps.w.a.Un().Vg();
                }
            });
            m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.client.SwanAppLocalService.2
                @Override // java.lang.Runnable
                public void run() {
                    g.bcp.Jr();
                }
            }, "updateMaBduss");
        }
    }

    protected SwanAppProcessInfo getProcessInfo() {
        return SwanAppProcessInfo.P0;
    }
}
