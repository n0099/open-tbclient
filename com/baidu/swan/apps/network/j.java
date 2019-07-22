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
    private OkHttpClient aEZ;
    private NetworkBroadcastReceiver aFa;
    private TelephonyManager aFb;
    private a aFc;

    public j(com.baidu.swan.apps.ae.b bVar) {
        super(bVar);
    }

    public void a(Request request, Callback callback) {
        HN().newCall(request).enqueue(callback);
    }

    public void a(Request request, Interceptor interceptor, Callback callback) {
        HN().newBuilder().addInterceptor(interceptor).build().newCall(request).enqueue(callback);
    }

    public OkHttpClient HN() {
        com.baidu.swan.apps.ae.a.c Me = Mu().Me();
        if (this.aEZ == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (Me != null && Me.aRd != null) {
                builder.connectTimeout(Me.aRd.aQU, TimeUnit.MILLISECONDS);
                builder.readTimeout(Me.aRd.aQT, TimeUnit.MILLISECONDS);
                builder.writeTimeout(Me.aRd.aQT, TimeUnit.MILLISECONDS);
                builder.addNetworkInterceptor(new com.baidu.swan.apps.network.a.c());
            }
            this.aEZ = builder.build();
        }
        this.aEZ.dispatcher().setMaxRequests(10);
        return this.aEZ;
    }

    public void c(CallbackHandler callbackHandler, String str) {
        if (this.aFa == null) {
            this.aFa = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.aFa, intentFilter);
        } else if (this.aFa != null) {
            this.aFa.updateCallback(callbackHandler, str);
        }
        d(callbackHandler, str);
    }

    public void d(CallbackHandler callbackHandler, String str) {
        if (this.aFb == null) {
            this.aFb = (TelephonyManager) getSystemService("phone");
            this.aFc = new a(callbackHandler, str);
            this.aFb.listen(this.aFc, 64);
        } else if (this.aFc != null) {
            this.aFc.updateCallback(callbackHandler, str);
        }
    }

    public void HO() {
        if (this.aFb != null && this.aFc != null) {
            this.aFb.listen(this.aFc, 0);
        }
    }

    public void HP() {
        if (this.aFa != null) {
            unregisterReceiver(this.aFa);
        }
        HO();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends PhoneStateListener {
        private WeakReference<CallbackHandler> aFd;
        private String aFe;
        private String aFf = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.aFd = new WeakReference<>(callbackHandler);
            this.aFe = str;
        }

        public void updateCallback(CallbackHandler callbackHandler, String str) {
            this.aFd = new WeakReference<>(callbackHandler);
            this.aFe = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            if (j.DEBUG) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i + " networkType " + i2);
            }
            if (2 == i) {
                String o = SwanAppNetworkUtils.o(i2, null);
                if (!TextUtils.isEmpty(o) && !o.equals(this.aFf)) {
                    this.aFf = o;
                    SwanAppNetworkUtils.a(j.this, this.aFd.get(), this.aFe);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.ae.c
    public void onDestroy() {
        super.onDestroy();
        HP();
    }
}
