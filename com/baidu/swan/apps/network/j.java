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
    private OkHttpClient bGp;
    private NetworkBroadcastReceiver bGq;
    private TelephonyManager bGr;
    private a bGs;

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
        if (this.bGp == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (acL != null && acL.bPJ != null) {
                builder.connectTimeout(acL.bPJ.bPA, TimeUnit.MILLISECONDS);
                builder.readTimeout(acL.bPJ.bPz, TimeUnit.MILLISECONDS);
                builder.writeTimeout(acL.bPJ.bPz, TimeUnit.MILLISECONDS);
                builder.addNetworkInterceptor(new com.baidu.swan.apps.network.a.c());
            }
            this.bGp = builder.build();
        }
        this.bGp.dispatcher().setMaxRequests(10);
        return this.bGp;
    }

    public void c(CallbackHandler callbackHandler, String str) {
        if (this.bGq == null) {
            this.bGq = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.bGq, intentFilter);
        } else if (this.bGq != null) {
            this.bGq.updateCallback(callbackHandler, str);
        }
        d(callbackHandler, str);
    }

    public void d(CallbackHandler callbackHandler, String str) {
        if (this.bGr == null) {
            this.bGr = (TelephonyManager) getSystemService("phone");
            this.bGs = new a(callbackHandler, str);
            this.bGr.listen(this.bGs, 64);
        } else if (this.bGs != null) {
            this.bGs.updateCallback(callbackHandler, str);
        }
    }

    public void YX() {
        if (this.bGr != null && this.bGs != null) {
            this.bGr.listen(this.bGs, 0);
        }
    }

    public void YY() {
        if (this.bGq != null) {
            unregisterReceiver(this.bGq);
        }
        YX();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a extends PhoneStateListener {
        private WeakReference<CallbackHandler> bGt;
        private String bGu;
        private String bGv = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.bGt = new WeakReference<>(callbackHandler);
            this.bGu = str;
        }

        public void updateCallback(CallbackHandler callbackHandler, String str) {
            this.bGt = new WeakReference<>(callbackHandler);
            this.bGu = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            if (j.DEBUG) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i + " networkType " + i2);
            }
            if (2 == i) {
                String mobileNetworkType = SwanAppNetworkUtils.getMobileNetworkType(i2, null);
                if (!TextUtils.isEmpty(mobileNetworkType) && !mobileNetworkType.equals(this.bGv)) {
                    this.bGv = mobileNetworkType;
                    SwanAppNetworkUtils.a(j.this, this.bGt.get(), this.bGu);
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
