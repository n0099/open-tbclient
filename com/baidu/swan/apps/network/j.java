package com.baidu.swan.apps.network;

import android.content.IntentFilter;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
/* loaded from: classes2.dex */
public class j extends com.baidu.swan.apps.ae.c {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private OkHttpClient aYM;
    private NetworkBroadcastReceiver aYN;
    private TelephonyManager aYO;
    private a aYP;

    public j(com.baidu.swan.apps.ae.b bVar) {
        super(bVar);
    }

    public void a(Request request, Callback callback) {
        ML().newCall(request).enqueue(callback);
    }

    public void a(Request request, Interceptor interceptor, Callback callback) {
        ML().newBuilder().addInterceptor(interceptor).build().newCall(request).enqueue(callback);
    }

    public OkHttpClient ML() {
        com.baidu.swan.apps.ae.a.c Ra = Rq().Ra();
        if (this.aYM == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (Ra != null && Ra.bkF != null) {
                builder.connectTimeout(Ra.bkF.bkw, TimeUnit.MILLISECONDS);
                builder.readTimeout(Ra.bkF.bkv, TimeUnit.MILLISECONDS);
                builder.writeTimeout(Ra.bkF.bkv, TimeUnit.MILLISECONDS);
                builder.addNetworkInterceptor(new com.baidu.swan.apps.network.a.c());
            }
            this.aYM = builder.build();
        }
        this.aYM.dispatcher().setMaxRequests(10);
        return this.aYM;
    }

    public void c(CallbackHandler callbackHandler, String str) {
        if (this.aYN == null) {
            this.aYN = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.aYN, intentFilter);
        } else if (this.aYN != null) {
            this.aYN.updateCallback(callbackHandler, str);
        }
        d(callbackHandler, str);
    }

    public void d(CallbackHandler callbackHandler, String str) {
        if (this.aYO == null) {
            this.aYO = (TelephonyManager) getSystemService("phone");
            this.aYP = new a(callbackHandler, str);
            this.aYO.listen(this.aYP, 64);
        } else if (this.aYP != null) {
            this.aYP.updateCallback(callbackHandler, str);
        }
    }

    public void MM() {
        if (this.aYO != null && this.aYP != null) {
            this.aYO.listen(this.aYP, 0);
        }
    }

    public void MN() {
        if (this.aYN != null) {
            unregisterReceiver(this.aYN);
        }
        MM();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends PhoneStateListener {
        private WeakReference<CallbackHandler> aYQ;
        private String aYR;
        private String aYS = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.aYQ = new WeakReference<>(callbackHandler);
            this.aYR = str;
        }

        public void updateCallback(CallbackHandler callbackHandler, String str) {
            this.aYQ = new WeakReference<>(callbackHandler);
            this.aYR = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            if (j.DEBUG) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i + " networkType " + i2);
            }
            if (2 == i) {
                String s = SwanAppNetworkUtils.s(i2, null);
                if (!TextUtils.isEmpty(s) && !s.equals(this.aYS)) {
                    this.aYS = s;
                    SwanAppNetworkUtils.a(j.this, this.aYQ.get(), this.aYR);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.ae.c
    public void onDestroy() {
        super.onDestroy();
        MN();
    }
}
