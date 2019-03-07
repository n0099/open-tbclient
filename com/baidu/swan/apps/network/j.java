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
    protected static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private OkHttpClient aCA;
    private NetworkBroadcastReceiver aCB;
    private TelephonyManager aCC;
    private a aCD;

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
        if (this.aCA == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (IY != null && IY.aOl != null) {
                builder.connectTimeout(IY.aOl.aOc, TimeUnit.MILLISECONDS);
                builder.readTimeout(IY.aOl.aOb, TimeUnit.MILLISECONDS);
                builder.writeTimeout(IY.aOl.aOb, TimeUnit.MILLISECONDS);
                builder.addNetworkInterceptor(new com.baidu.swan.apps.network.a.c());
            }
            this.aCA = builder.build();
        }
        this.aCA.dispatcher().setMaxRequests(10);
        return this.aCA;
    }

    public void c(CallbackHandler callbackHandler, String str) {
        if (this.aCB == null) {
            this.aCB = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.aCB, intentFilter);
        } else if (this.aCB != null) {
            this.aCB.updateCallback(callbackHandler, str);
        }
        d(callbackHandler, str);
    }

    public void d(CallbackHandler callbackHandler, String str) {
        if (this.aCC == null) {
            this.aCC = (TelephonyManager) getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
            this.aCD = new a(callbackHandler, str);
            this.aCC.listen(this.aCD, 64);
        } else if (this.aCD != null) {
            this.aCD.updateCallback(callbackHandler, str);
        }
    }

    public void Fa() {
        if (this.aCC != null && this.aCD != null) {
            this.aCC.listen(this.aCD, 0);
        }
    }

    public void Fb() {
        if (this.aCB != null) {
            unregisterReceiver(this.aCB);
        }
        Fa();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends PhoneStateListener {
        private WeakReference<CallbackHandler> aCE;
        private String aCF;
        private String aCG = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.aCE = new WeakReference<>(callbackHandler);
            this.aCF = str;
        }

        public void updateCallback(CallbackHandler callbackHandler, String str) {
            this.aCE = new WeakReference<>(callbackHandler);
            this.aCF = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            if (j.DEBUG) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i + " networkType " + i2);
            }
            if (2 == i) {
                String l = SwanAppNetworkUtils.l(i2, null);
                if (!TextUtils.isEmpty(l) && !l.equals(this.aCG)) {
                    this.aCG = l;
                    SwanAppNetworkUtils.a(j.this, this.aCE.get(), this.aCF);
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
