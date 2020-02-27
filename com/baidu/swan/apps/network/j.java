package com.baidu.swan.apps.network;

import android.content.IntentFilter;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
/* loaded from: classes11.dex */
public class j extends com.baidu.swan.apps.runtime.f {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private OkHttpClient bGn;
    private NetworkBroadcastReceiver bGo;
    private TelephonyManager bGp;
    private a bGq;

    public j(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar);
    }

    public void a(Request request, Callback callback) {
        YU().newCall(request).enqueue(callback);
    }

    public void a(Request request, Interceptor interceptor, Callback callback) {
        YU().newBuilder().addInterceptor(interceptor).build().newCall(request).enqueue(callback);
    }

    public OkHttpClient YU() {
        SwanAppConfigData acJ = acZ().acJ();
        if (this.bGn == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (acJ != null && acJ.bPH != null) {
                builder.connectTimeout(acJ.bPH.bPy, TimeUnit.MILLISECONDS);
                builder.readTimeout(acJ.bPH.bPx, TimeUnit.MILLISECONDS);
                builder.writeTimeout(acJ.bPH.bPx, TimeUnit.MILLISECONDS);
                builder.addNetworkInterceptor(new com.baidu.swan.apps.network.a.c());
            }
            this.bGn = builder.build();
        }
        this.bGn.dispatcher().setMaxRequests(10);
        return this.bGn;
    }

    public void c(CallbackHandler callbackHandler, String str) {
        if (this.bGo == null) {
            this.bGo = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.bGo, intentFilter);
        } else if (this.bGo != null) {
            this.bGo.updateCallback(callbackHandler, str);
        }
        d(callbackHandler, str);
    }

    public void d(CallbackHandler callbackHandler, String str) {
        if (this.bGp == null) {
            this.bGp = (TelephonyManager) getSystemService("phone");
            this.bGq = new a(callbackHandler, str);
            this.bGp.listen(this.bGq, 64);
        } else if (this.bGq != null) {
            this.bGq.updateCallback(callbackHandler, str);
        }
    }

    public void YV() {
        if (this.bGp != null && this.bGq != null) {
            this.bGp.listen(this.bGq, 0);
        }
    }

    public void YW() {
        if (this.bGo != null) {
            unregisterReceiver(this.bGo);
        }
        YV();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a extends PhoneStateListener {
        private WeakReference<CallbackHandler> bGr;
        private String bGs;
        private String bGt = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.bGr = new WeakReference<>(callbackHandler);
            this.bGs = str;
        }

        public void updateCallback(CallbackHandler callbackHandler, String str) {
            this.bGr = new WeakReference<>(callbackHandler);
            this.bGs = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            if (j.DEBUG) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i + " networkType " + i2);
            }
            if (2 == i) {
                String mobileNetworkType = SwanAppNetworkUtils.getMobileNetworkType(i2, null);
                if (!TextUtils.isEmpty(mobileNetworkType) && !mobileNetworkType.equals(this.bGt)) {
                    this.bGt = mobileNetworkType;
                    SwanAppNetworkUtils.a(j.this, this.bGr.get(), this.bGs);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        super.onDestroy();
        YW();
    }
}
