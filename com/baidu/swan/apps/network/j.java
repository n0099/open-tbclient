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
    private OkHttpClient bGo;
    private NetworkBroadcastReceiver bGp;
    private TelephonyManager bGq;
    private a bGr;

    public j(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar);
    }

    public void a(Request request, Callback callback) {
        YW().newCall(request).enqueue(callback);
    }

    public void a(Request request, Interceptor interceptor, Callback callback) {
        YW().newBuilder().addInterceptor(interceptor).build().newCall(request).enqueue(callback);
    }

    public OkHttpClient YW() {
        SwanAppConfigData acL = adb().acL();
        if (this.bGo == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (acL != null && acL.bPI != null) {
                builder.connectTimeout(acL.bPI.bPz, TimeUnit.MILLISECONDS);
                builder.readTimeout(acL.bPI.bPy, TimeUnit.MILLISECONDS);
                builder.writeTimeout(acL.bPI.bPy, TimeUnit.MILLISECONDS);
                builder.addNetworkInterceptor(new com.baidu.swan.apps.network.a.c());
            }
            this.bGo = builder.build();
        }
        this.bGo.dispatcher().setMaxRequests(10);
        return this.bGo;
    }

    public void c(CallbackHandler callbackHandler, String str) {
        if (this.bGp == null) {
            this.bGp = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.bGp, intentFilter);
        } else if (this.bGp != null) {
            this.bGp.updateCallback(callbackHandler, str);
        }
        d(callbackHandler, str);
    }

    public void d(CallbackHandler callbackHandler, String str) {
        if (this.bGq == null) {
            this.bGq = (TelephonyManager) getSystemService("phone");
            this.bGr = new a(callbackHandler, str);
            this.bGq.listen(this.bGr, 64);
        } else if (this.bGr != null) {
            this.bGr.updateCallback(callbackHandler, str);
        }
    }

    public void YX() {
        if (this.bGq != null && this.bGr != null) {
            this.bGq.listen(this.bGr, 0);
        }
    }

    public void YY() {
        if (this.bGp != null) {
            unregisterReceiver(this.bGp);
        }
        YX();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a extends PhoneStateListener {
        private WeakReference<CallbackHandler> bGs;
        private String bGt;
        private String bGu = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.bGs = new WeakReference<>(callbackHandler);
            this.bGt = str;
        }

        public void updateCallback(CallbackHandler callbackHandler, String str) {
            this.bGs = new WeakReference<>(callbackHandler);
            this.bGt = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            if (j.DEBUG) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i + " networkType " + i2);
            }
            if (2 == i) {
                String mobileNetworkType = SwanAppNetworkUtils.getMobileNetworkType(i2, null);
                if (!TextUtils.isEmpty(mobileNetworkType) && !mobileNetworkType.equals(this.bGu)) {
                    this.bGu = mobileNetworkType;
                    SwanAppNetworkUtils.a(j.this, this.bGs.get(), this.bGt);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        super.onDestroy();
        YY();
    }
}
