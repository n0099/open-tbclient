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
    private OkHttpClient bGA;
    private NetworkBroadcastReceiver bGB;
    private TelephonyManager bGC;
    private a bGD;

    public j(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar);
    }

    public void a(Request request, Callback callback) {
        YZ().newCall(request).enqueue(callback);
    }

    public void a(Request request, Interceptor interceptor, Callback callback) {
        YZ().newBuilder().addInterceptor(interceptor).build().newCall(request).enqueue(callback);
    }

    public OkHttpClient YZ() {
        SwanAppConfigData acO = ade().acO();
        if (this.bGA == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (acO != null && acO.bPU != null) {
                builder.connectTimeout(acO.bPU.bPL, TimeUnit.MILLISECONDS);
                builder.readTimeout(acO.bPU.bPK, TimeUnit.MILLISECONDS);
                builder.writeTimeout(acO.bPU.bPK, TimeUnit.MILLISECONDS);
                builder.addNetworkInterceptor(new com.baidu.swan.apps.network.a.c());
            }
            this.bGA = builder.build();
        }
        this.bGA.dispatcher().setMaxRequests(10);
        return this.bGA;
    }

    public void c(CallbackHandler callbackHandler, String str) {
        if (this.bGB == null) {
            this.bGB = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.bGB, intentFilter);
        } else if (this.bGB != null) {
            this.bGB.updateCallback(callbackHandler, str);
        }
        d(callbackHandler, str);
    }

    public void d(CallbackHandler callbackHandler, String str) {
        if (this.bGC == null) {
            this.bGC = (TelephonyManager) getSystemService("phone");
            this.bGD = new a(callbackHandler, str);
            this.bGC.listen(this.bGD, 64);
        } else if (this.bGD != null) {
            this.bGD.updateCallback(callbackHandler, str);
        }
    }

    public void Za() {
        if (this.bGC != null && this.bGD != null) {
            this.bGC.listen(this.bGD, 0);
        }
    }

    public void Zb() {
        if (this.bGB != null) {
            unregisterReceiver(this.bGB);
        }
        Za();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a extends PhoneStateListener {
        private WeakReference<CallbackHandler> bGE;
        private String bGF;
        private String bGG = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.bGE = new WeakReference<>(callbackHandler);
            this.bGF = str;
        }

        public void updateCallback(CallbackHandler callbackHandler, String str) {
            this.bGE = new WeakReference<>(callbackHandler);
            this.bGF = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            if (j.DEBUG) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i + " networkType " + i2);
            }
            if (2 == i) {
                String mobileNetworkType = SwanAppNetworkUtils.getMobileNetworkType(i2, null);
                if (!TextUtils.isEmpty(mobileNetworkType) && !mobileNetworkType.equals(this.bGG)) {
                    this.bGG = mobileNetworkType;
                    SwanAppNetworkUtils.a(j.this, this.bGE.get(), this.bGF);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        super.onDestroy();
        Zb();
    }
}
