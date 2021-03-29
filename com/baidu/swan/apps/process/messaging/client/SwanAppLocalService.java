package com.baidu.swan.apps.process.messaging.client;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidubce.services.vod.VodClient;
import d.b.g0.a.e0.w.d;
import d.b.g0.a.i2.k0;
import d.b.g0.a.i2.p;
import d.b.g0.a.j1.i;
import d.b.g0.a.j2.d;
import d.b.g0.a.k;
import d.b.g0.a.z0.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SwanAppLocalService extends Service implements Handler.Callback {
    public static final String AB_SWAN_PRECLASS = "swan_preclass";
    public static final String ACTION_PERLOAD = "com.baidu.swan.action.SWAN_APP_LOCAL_SERVICE_PERLOAD";
    public static final String ACTION_PREFIX = "com.baidu.swan.action.SWAN_APP_LOCAL_SERVICE_";
    public static final String TAG = "SwanAppLocalService";
    public Messenger mMessenger;
    public static final boolean DEBUG = k.f45051a;
    public static boolean sFlagPreloaded = false;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.V().c0();
            d.b.g0.a.w0.a.w().h();
            d.u(d.b.g0.a.w0.a.c());
            d.b.g0.a.w0.a.Y().a();
            SwanAppLocalService.this.preloadActivityClass();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.j1.m.b.f();
        }
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
        if (intent == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long longExtra = intent.getLongExtra("bundle_key_preload_launch_time", currentTimeMillis);
        long longExtra2 = intent.getLongExtra("bundle_key_preload_swan_updated_time", currentTimeMillis);
        String stringExtra = intent.getStringExtra("bundle_key_preload_preload_scene");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "0";
        }
        HybridUbcFlow o = i.o("preload");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_pre_load_launch");
        ubcFlowEvent.h(longExtra);
        o.A(ubcFlowEvent);
        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_pre_load_swan_updated");
        ubcFlowEvent2.h(longExtra2);
        o.A(ubcFlowEvent2);
        UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("na_pre_load_receive");
        ubcFlowEvent3.h(currentTimeMillis);
        o.A(ubcFlowEvent3);
        o.y("with_preload", "1");
        if (!TextUtils.isEmpty(stringExtra)) {
            o.y("preload_scene", stringExtra);
        }
        if (d.b.g0.a.w0.a.N() != null && d.b.g0.a.w0.a.N().j()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("time", currentTimeMillis);
                jSONObject.put(VodClient.PARA_PROCESS, intent.getIntExtra("bundle_key_process", -1));
                jSONObject.put("cost", currentTimeMillis - longExtra2);
                jSONObject.put("is_preload_started", d.b.g0.a.e0.w.d.x);
                jSONObject.put("is_preload_ready", d.b.g0.a.e0.w.d.L().a0());
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
            i.d dVar = new i.d("812");
            dVar.g("swan");
            dVar.i("receive");
            dVar.h(intent.getStringExtra("bundle_key_preload_src"));
            dVar.e(jSONObject);
            i.onEvent(dVar);
        }
        d.p.g(intent);
        d.b.g0.g.i0.f.d.k(intent);
        f.V().J(intent);
        d.b.g0.g.m.a.m().z(intent);
        if (!sFlagPreloaded) {
            sFlagPreloaded = true;
            k0.T(new a());
        }
        if (!d.b.g0.a.j1.m.b.f44922b || d.b.g0.a.j1.m.b.i()) {
            return;
        }
        p.k(new b(), "SwanAbSwitchCache");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preloadActivityClass() {
        d.b.g0.a.w0.a.N().getSwitch(AB_SWAN_PRECLASS, 0);
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
        d.b.g0.a.w0.a.u().b();
        super.onCreate();
        this.mMessenger = new Messenger(d.b.g0.a.n1.c.e.a.C().D());
        if (DEBUG) {
            Log.i(TAG, "onCreate " + getProcessInfo());
        }
        d.b.g0.a.n1.c.e.a.C().O();
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
}
