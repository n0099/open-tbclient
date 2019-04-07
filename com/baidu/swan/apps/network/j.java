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
    private OkHttpClient aCE;
    private NetworkBroadcastReceiver aCF;
    private TelephonyManager aCG;
    private a aCH;

    public j(com.baidu.swan.apps.ae.b bVar) {
        super(bVar);
    }

    public void a(Request request, Callback callback) {
        EX().newCall(request).enqueue(callback);
    }

    public void a(Request request, Interceptor interceptor, Callback callback) {
        EX().newBuilder().addInterceptor(interceptor).build().newCall(request).enqueue(callback);
    }

    public OkHttpClient EX() {
        com.baidu.swan.apps.ae.a.c IW = Jl().IW();
        if (this.aCE == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (IW != null && IW.aOp != null) {
                builder.connectTimeout(IW.aOp.aOg, TimeUnit.MILLISECONDS);
                builder.readTimeout(IW.aOp.aOf, TimeUnit.MILLISECONDS);
                builder.writeTimeout(IW.aOp.aOf, TimeUnit.MILLISECONDS);
                builder.addNetworkInterceptor(new com.baidu.swan.apps.network.a.c());
            }
            this.aCE = builder.build();
        }
        this.aCE.dispatcher().setMaxRequests(10);
        return this.aCE;
    }

    public void c(CallbackHandler callbackHandler, String str) {
        if (this.aCF == null) {
            this.aCF = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.aCF, intentFilter);
        } else if (this.aCF != null) {
            this.aCF.updateCallback(callbackHandler, str);
        }
        d(callbackHandler, str);
    }

    public void d(CallbackHandler callbackHandler, String str) {
        if (this.aCG == null) {
            this.aCG = (TelephonyManager) getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
            this.aCH = new a(callbackHandler, str);
            this.aCG.listen(this.aCH, 64);
        } else if (this.aCH != null) {
            this.aCH.updateCallback(callbackHandler, str);
        }
    }

    public void EY() {
        if (this.aCG != null && this.aCH != null) {
            this.aCG.listen(this.aCH, 0);
        }
    }

    public void EZ() {
        if (this.aCF != null) {
            unregisterReceiver(this.aCF);
        }
        EY();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends PhoneStateListener {
        private WeakReference<CallbackHandler> aCI;
        private String aCJ;
        private String aCK = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.aCI = new WeakReference<>(callbackHandler);
            this.aCJ = str;
        }

        public void updateCallback(CallbackHandler callbackHandler, String str) {
            this.aCI = new WeakReference<>(callbackHandler);
            this.aCJ = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            if (j.DEBUG) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i + " networkType " + i2);
            }
            if (2 == i) {
                String l = SwanAppNetworkUtils.l(i2, null);
                if (!TextUtils.isEmpty(l) && !l.equals(this.aCK)) {
                    this.aCK = l;
                    SwanAppNetworkUtils.a(j.this, this.aCI.get(), this.aCJ);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.ae.c
    public void onDestroy() {
        super.onDestroy();
        EZ();
    }
}
