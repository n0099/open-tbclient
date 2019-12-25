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
/* loaded from: classes9.dex */
public class j extends com.baidu.swan.apps.runtime.f {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private OkHttpClient bBv;
    private NetworkBroadcastReceiver bBw;
    private TelephonyManager bBx;
    private a bBy;

    public j(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar);
    }

    public void a(Request request, Callback callback) {
        Wj().newCall(request).enqueue(callback);
    }

    public void a(Request request, Interceptor interceptor, Callback callback) {
        Wj().newBuilder().addInterceptor(interceptor).build().newCall(request).enqueue(callback);
    }

    public OkHttpClient Wj() {
        SwanAppConfigData ZY = aao().ZY();
        if (this.bBv == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (ZY != null && ZY.bKS != null) {
                builder.connectTimeout(ZY.bKS.bKJ, TimeUnit.MILLISECONDS);
                builder.readTimeout(ZY.bKS.bKI, TimeUnit.MILLISECONDS);
                builder.writeTimeout(ZY.bKS.bKI, TimeUnit.MILLISECONDS);
                builder.addNetworkInterceptor(new com.baidu.swan.apps.network.a.c());
            }
            this.bBv = builder.build();
        }
        this.bBv.dispatcher().setMaxRequests(10);
        return this.bBv;
    }

    public void c(CallbackHandler callbackHandler, String str) {
        if (this.bBw == null) {
            this.bBw = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.bBw, intentFilter);
        } else if (this.bBw != null) {
            this.bBw.updateCallback(callbackHandler, str);
        }
        d(callbackHandler, str);
    }

    public void d(CallbackHandler callbackHandler, String str) {
        if (this.bBx == null) {
            this.bBx = (TelephonyManager) getSystemService("phone");
            this.bBy = new a(callbackHandler, str);
            this.bBx.listen(this.bBy, 64);
        } else if (this.bBy != null) {
            this.bBy.updateCallback(callbackHandler, str);
        }
    }

    public void Wk() {
        if (this.bBx != null && this.bBy != null) {
            this.bBx.listen(this.bBy, 0);
        }
    }

    public void Wl() {
        if (this.bBw != null) {
            unregisterReceiver(this.bBw);
        }
        Wk();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a extends PhoneStateListener {
        private String bBA;
        private String bBB = "";
        private WeakReference<CallbackHandler> bBz;

        public a(CallbackHandler callbackHandler, String str) {
            this.bBz = new WeakReference<>(callbackHandler);
            this.bBA = str;
        }

        public void updateCallback(CallbackHandler callbackHandler, String str) {
            this.bBz = new WeakReference<>(callbackHandler);
            this.bBA = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            if (j.DEBUG) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i + " networkType " + i2);
            }
            if (2 == i) {
                String mobileNetworkType = SwanAppNetworkUtils.getMobileNetworkType(i2, null);
                if (!TextUtils.isEmpty(mobileNetworkType) && !mobileNetworkType.equals(this.bBB)) {
                    this.bBB = mobileNetworkType;
                    SwanAppNetworkUtils.a(j.this, this.bBz.get(), this.bBA);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        super.onDestroy();
        Wl();
    }
}
