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
/* loaded from: classes10.dex */
public class j extends com.baidu.swan.apps.runtime.f {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private OkHttpClient bCh;
    private NetworkBroadcastReceiver bCi;
    private TelephonyManager bCj;
    private a bCk;

    public j(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar);
    }

    public void a(Request request, Callback callback) {
        WG().newCall(request).enqueue(callback);
    }

    public void a(Request request, Interceptor interceptor, Callback callback) {
        WG().newBuilder().addInterceptor(interceptor).build().newCall(request).enqueue(callback);
    }

    public OkHttpClient WG() {
        SwanAppConfigData aav = aaL().aav();
        if (this.bCh == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (aav != null && aav.bLC != null) {
                builder.connectTimeout(aav.bLC.bLt, TimeUnit.MILLISECONDS);
                builder.readTimeout(aav.bLC.bLs, TimeUnit.MILLISECONDS);
                builder.writeTimeout(aav.bLC.bLs, TimeUnit.MILLISECONDS);
                builder.addNetworkInterceptor(new com.baidu.swan.apps.network.a.c());
            }
            this.bCh = builder.build();
        }
        this.bCh.dispatcher().setMaxRequests(10);
        return this.bCh;
    }

    public void c(CallbackHandler callbackHandler, String str) {
        if (this.bCi == null) {
            this.bCi = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.bCi, intentFilter);
        } else if (this.bCi != null) {
            this.bCi.updateCallback(callbackHandler, str);
        }
        d(callbackHandler, str);
    }

    public void d(CallbackHandler callbackHandler, String str) {
        if (this.bCj == null) {
            this.bCj = (TelephonyManager) getSystemService("phone");
            this.bCk = new a(callbackHandler, str);
            this.bCj.listen(this.bCk, 64);
        } else if (this.bCk != null) {
            this.bCk.updateCallback(callbackHandler, str);
        }
    }

    public void WH() {
        if (this.bCj != null && this.bCk != null) {
            this.bCj.listen(this.bCk, 0);
        }
    }

    public void WI() {
        if (this.bCi != null) {
            unregisterReceiver(this.bCi);
        }
        WH();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a extends PhoneStateListener {
        private WeakReference<CallbackHandler> bCl;
        private String bCm;
        private String bCn = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.bCl = new WeakReference<>(callbackHandler);
            this.bCm = str;
        }

        public void updateCallback(CallbackHandler callbackHandler, String str) {
            this.bCl = new WeakReference<>(callbackHandler);
            this.bCm = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            if (j.DEBUG) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i + " networkType " + i2);
            }
            if (2 == i) {
                String mobileNetworkType = SwanAppNetworkUtils.getMobileNetworkType(i2, null);
                if (!TextUtils.isEmpty(mobileNetworkType) && !mobileNetworkType.equals(this.bCn)) {
                    this.bCn = mobileNetworkType;
                    SwanAppNetworkUtils.a(j.this, this.bCl.get(), this.bCm);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        super.onDestroy();
        WI();
    }
}
