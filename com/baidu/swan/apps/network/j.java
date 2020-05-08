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
    private OkHttpClient btX;
    private NetworkBroadcastReceiver cfq;
    private TelephonyManager cfr;
    private a cfs;

    public j(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar);
    }

    public void a(Request request, Callback callback) {
        ahe().newCall(request).enqueue(callback);
    }

    public void a(Request request, Interceptor interceptor, Callback callback) {
        ahe().newBuilder().addInterceptor(interceptor).build().newCall(request).enqueue(callback);
    }

    public OkHttpClient ahe() {
        SwanAppConfigData akS = ali().akS();
        if (this.btX == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (akS != null && akS.coM != null) {
                builder.connectTimeout(akS.coM.coD, TimeUnit.MILLISECONDS);
                builder.readTimeout(akS.coM.coC, TimeUnit.MILLISECONDS);
                builder.writeTimeout(akS.coM.coC, TimeUnit.MILLISECONDS);
                builder.addNetworkInterceptor(new com.baidu.swan.apps.network.a.c());
            }
            this.btX = builder.build();
        }
        this.btX.dispatcher().setMaxRequests(10);
        return this.btX;
    }

    public void c(CallbackHandler callbackHandler, String str) {
        if (this.cfq == null) {
            this.cfq = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.cfq, intentFilter);
        } else if (this.cfq != null) {
            this.cfq.updateCallback(callbackHandler, str);
        }
        d(callbackHandler, str);
    }

    public void d(CallbackHandler callbackHandler, String str) {
        if (this.cfr == null) {
            this.cfr = (TelephonyManager) getSystemService("phone");
            this.cfs = new a(callbackHandler, str);
            this.cfr.listen(this.cfs, 64);
        } else if (this.cfs != null) {
            this.cfs.updateCallback(callbackHandler, str);
        }
    }

    public void ahf() {
        if (this.cfr != null && this.cfs != null) {
            this.cfr.listen(this.cfs, 0);
        }
    }

    public void ahg() {
        if (this.cfq != null) {
            unregisterReceiver(this.cfq);
        }
        ahf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a extends PhoneStateListener {
        private WeakReference<CallbackHandler> cft;
        private String cfu;
        private String cfv = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.cft = new WeakReference<>(callbackHandler);
            this.cfu = str;
        }

        public void updateCallback(CallbackHandler callbackHandler, String str) {
            this.cft = new WeakReference<>(callbackHandler);
            this.cfu = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            if (j.DEBUG) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i + " networkType " + i2);
            }
            if (2 == i) {
                String mobileNetworkType = SwanAppNetworkUtils.getMobileNetworkType(i2, null);
                if (!TextUtils.isEmpty(mobileNetworkType) && !mobileNetworkType.equals(this.cfv)) {
                    this.cfv = mobileNetworkType;
                    SwanAppNetworkUtils.a(j.this, this.cft.get(), this.cfu);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        super.onDestroy();
        ahg();
    }
}
