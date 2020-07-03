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
import okhttp3.OkHttpClient;
import okhttp3.Request;
/* loaded from: classes11.dex */
public class j extends com.baidu.swan.apps.runtime.f {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private OkHttpClient bGp;
    private NetworkBroadcastReceiver cuO;
    private TelephonyManager cuP;
    private a cuQ;

    public j(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar);
    }

    @Deprecated
    public void a(Request request, Callback callback) {
        alD().newCall(request).enqueue(callback);
    }

    @Deprecated
    public OkHttpClient alD() {
        SwanAppConfigData apV = aqk().apV();
        if (this.bGp == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (apV != null && apV.cFi != null) {
                builder.connectTimeout(apV.cFi.cEY, TimeUnit.MILLISECONDS);
                builder.readTimeout(60000L, TimeUnit.MILLISECONDS);
                builder.writeTimeout(60000L, TimeUnit.MILLISECONDS);
                builder.addNetworkInterceptor(new com.baidu.swan.apps.network.a.d());
                builder.addNetworkInterceptor(new com.baidu.swan.apps.network.a.c());
            }
            this.bGp = builder.build();
        }
        this.bGp.dispatcher().setMaxRequests(10);
        return this.bGp;
    }

    public void b(CallbackHandler callbackHandler, String str) {
        if (this.cuO == null) {
            this.cuO = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.cuO, intentFilter);
        } else if (this.cuO != null) {
            this.cuO.updateCallback(callbackHandler, str);
        }
        c(callbackHandler, str);
    }

    public void c(CallbackHandler callbackHandler, String str) {
        if (this.cuP == null) {
            this.cuP = (TelephonyManager) getSystemService("phone");
            this.cuQ = new a(callbackHandler, str);
            this.cuP.listen(this.cuQ, 64);
        } else if (this.cuQ != null) {
            this.cuQ.updateCallback(callbackHandler, str);
        }
    }

    public void alE() {
        if (this.cuP != null && this.cuQ != null) {
            this.cuP.listen(this.cuQ, 0);
        }
    }

    public void alF() {
        if (this.cuO != null) {
            unregisterReceiver(this.cuO);
        }
        alE();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a extends PhoneStateListener {
        private WeakReference<CallbackHandler> cuR;
        private String cuS;
        private String cuT = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.cuR = new WeakReference<>(callbackHandler);
            this.cuS = str;
        }

        public void updateCallback(CallbackHandler callbackHandler, String str) {
            this.cuR = new WeakReference<>(callbackHandler);
            this.cuS = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            if (j.DEBUG) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i + " networkType " + i2);
            }
            if (2 == i) {
                String mobileNetworkType = SwanAppNetworkUtils.getMobileNetworkType(i2, null);
                if (!TextUtils.isEmpty(mobileNetworkType) && !mobileNetworkType.equals(this.cuT)) {
                    this.cuT = mobileNetworkType;
                    SwanAppNetworkUtils.a(j.this, this.cuR.get(), this.cuS);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        super.onDestroy();
        alF();
    }
}
