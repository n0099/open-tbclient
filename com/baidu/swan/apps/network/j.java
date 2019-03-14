package com.baidu.swan.apps.network;

import android.content.IntentFilter;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
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
    private OkHttpClient aCB;
    private NetworkBroadcastReceiver aCC;
    private TelephonyManager aCD;
    private a aCE;

    public j(com.baidu.swan.apps.ae.b bVar) {
        super(bVar);
    }

    public void a(Request request, Callback callback) {
        EZ().newCall(request).enqueue(callback);
    }

    public void a(Request request, Interceptor interceptor, Callback callback) {
        EZ().newBuilder().addInterceptor(interceptor).build().newCall(request).enqueue(callback);
    }

    public OkHttpClient EZ() {
        com.baidu.swan.apps.ae.a.c IY = Jn().IY();
        if (this.aCB == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (IY != null && IY.aOm != null) {
                builder.connectTimeout(IY.aOm.aOd, TimeUnit.MILLISECONDS);
                builder.readTimeout(IY.aOm.aOc, TimeUnit.MILLISECONDS);
                builder.writeTimeout(IY.aOm.aOc, TimeUnit.MILLISECONDS);
                builder.addNetworkInterceptor(new com.baidu.swan.apps.network.a.c());
            }
            this.aCB = builder.build();
        }
        this.aCB.dispatcher().setMaxRequests(10);
        return this.aCB;
    }

    public void c(CallbackHandler callbackHandler, String str) {
        if (this.aCC == null) {
            this.aCC = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.aCC, intentFilter);
        } else if (this.aCC != null) {
            this.aCC.updateCallback(callbackHandler, str);
        }
        d(callbackHandler, str);
    }

    public void d(CallbackHandler callbackHandler, String str) {
        if (this.aCD == null) {
            this.aCD = (TelephonyManager) getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
            this.aCE = new a(callbackHandler, str);
            this.aCD.listen(this.aCE, 64);
        } else if (this.aCE != null) {
            this.aCE.updateCallback(callbackHandler, str);
        }
    }

    public void Fa() {
        if (this.aCD != null && this.aCE != null) {
            this.aCD.listen(this.aCE, 0);
        }
    }

    public void Fb() {
        if (this.aCC != null) {
            unregisterReceiver(this.aCC);
        }
        Fa();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends PhoneStateListener {
        private WeakReference<CallbackHandler> aCF;
        private String aCG;
        private String aCH = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.aCF = new WeakReference<>(callbackHandler);
            this.aCG = str;
        }

        public void updateCallback(CallbackHandler callbackHandler, String str) {
            this.aCF = new WeakReference<>(callbackHandler);
            this.aCG = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            if (j.DEBUG) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i + " networkType " + i2);
            }
            if (2 == i) {
                String l = SwanAppNetworkUtils.l(i2, null);
                if (!TextUtils.isEmpty(l) && !l.equals(this.aCH)) {
                    this.aCH = l;
                    SwanAppNetworkUtils.a(j.this, this.aCF.get(), this.aCG);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.ae.c
    public void onDestroy() {
        super.onDestroy();
        Fb();
    }
}
