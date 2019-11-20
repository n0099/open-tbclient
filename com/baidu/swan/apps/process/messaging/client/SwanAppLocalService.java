package com.baidu.swan.apps.process.messaging.client;

import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.j.c;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.f;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.w.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SwanAppLocalService extends Service {
    public static final String ACTION_DEFAULT = "com.baidu.swan.action.SWAN_APP_LOCAL_SERVICE_DEFAULT";
    public static final String ACTION_PREFIX = "com.baidu.swan.action.SWAN_APP_LOCAL_SERVICE_";
    public static final String ACTION_REBIND_MSG_SERVICE = "com.baidu.swan.action.SWAN_APP_LOCAL_SERVICE_REBIND_MSG_SERVICE";
    private static final boolean DEBUG = b.DEBUG;
    private static final String TAG = "SwanAppLocalService";
    private final a mBinder = new a();

    public static void startForRebindMsgService(SwanAppProcessInfo swanAppProcessInfo) {
        if (swanAppProcessInfo.isSwanAppProcess()) {
            Application application = AppRuntime.getApplication();
            Intent intent = new Intent(application, swanAppProcessInfo.service);
            intent.setAction(ACTION_REBIND_MSG_SERVICE);
            try {
                application.startService(intent);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        SwanAppProcessInfo.init(getProcessInfo());
        super.onCreate();
        if (DEBUG) {
            Log.i(TAG, "onCreate " + getProcessInfo());
        }
        tryBindRemoteMsgService();
    }

    @Override // android.app.Service
    public void onDestroy() {
        unbindRemoteMsgService();
        super.onDestroy();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        boolean z;
        if (DEBUG) {
            Log.d(TAG, "onStartCommand: intent=" + intent);
        }
        String action = (intent == null || TextUtils.isEmpty(intent.getAction())) ? ACTION_DEFAULT : intent.getAction();
        if (TextUtils.isEmpty(action)) {
            action = ACTION_DEFAULT;
        }
        switch (action.hashCode()) {
            case -1286929614:
                if (action.equals(ACTION_DEFAULT)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 2058500407:
                if (action.equals(ACTION_REBIND_MSG_SERVICE)) {
                    z = false;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        switch (z) {
            case false:
                tryBindRemoteMsgService();
                break;
            default:
                onActionDefault(intent);
                break;
        }
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (DEBUG) {
            Log.d(TAG, "onBind: intent=" + intent);
        }
        return this.mBinder;
    }

    private void onActionDefault(Intent intent) {
        if (intent != null) {
            long currentTimeMillis = System.currentTimeMillis();
            long longExtra = intent.getLongExtra("bundle_key_preload_launch_time", currentTimeMillis);
            long longExtra2 = intent.getLongExtra("bundle_key_preload_swan_updated_time", currentTimeMillis);
            String stringExtra = intent.getStringExtra("bundle_key_preload_preload_scene");
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = "0";
            }
            HybridUbcFlow az = f.gz("preload").f(new UbcFlowEvent("na_pre_load_launch").ae(longExtra)).f(new UbcFlowEvent("na_pre_load_swan_updated").ae(longExtra2)).f(new UbcFlowEvent("na_pre_load_receive").ae(currentTimeMillis)).az("with_preload", "1");
            if (!TextUtils.isEmpty(stringExtra)) {
                az.az("preload_scene", stringExtra);
            }
            if (com.baidu.swan.apps.u.a.Jm() != null && com.baidu.swan.apps.u.a.Jm().Bh()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("time", currentTimeMillis);
                    jSONObject.put("process", intent.getIntExtra("bundle_key_process", -1));
                    jSONObject.put(BdStatsConstant.StatsKey.COST, currentTimeMillis - longExtra2);
                    jSONObject.put("is_preload_started", c.aNY);
                    jSONObject.put("is_preload_ready", c.GP().GU());
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                f.a gL = new f.a("812").gJ("swan").gK("receive").gL(intent.getStringExtra("bundle_key_preload_src"));
                gL.aI(jSONObject);
                f.onEvent(gL);
            }
            c.b.J(intent);
            e.LE().O(intent);
            ac.i(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.client.SwanAppLocalService.1
                @Override // java.lang.Runnable
                public void run() {
                    e.LE().BD();
                    com.baidu.swan.apps.u.a.JC().Kg();
                }
            });
        }
    }

    public void tryBindRemoteMsgService() {
        if (DEBUG) {
            Log.i(TAG, "tryBindRemoteMsgService");
        }
        if (!getRemoteMsgClient().Or()) {
            bindService(new Intent(this, SwanAppMessengerService.class), getRemoteMsgClient().baR, 1);
        }
    }

    public void unbindRemoteMsgService() {
        try {
            unbindService(getRemoteMsgClient().baR);
        } catch (IllegalArgumentException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private com.baidu.swan.apps.process.messaging.client.a getRemoteMsgClient() {
        return com.baidu.swan.apps.process.messaging.client.a.Oq();
    }

    protected SwanAppProcessInfo getProcessInfo() {
        return SwanAppProcessInfo.P0;
    }

    /* loaded from: classes2.dex */
    public class a extends Binder {
        public a() {
        }

        public SwanAppLocalService Op() {
            return SwanAppLocalService.this;
        }
    }
}
