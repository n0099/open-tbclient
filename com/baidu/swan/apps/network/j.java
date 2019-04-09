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
    private OkHttpClient aCF;
    private NetworkBroadcastReceiver aCG;
    private TelephonyManager aCH;
    private a aCI;

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
        if (this.aCF == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (IW != null && IW.aOq != null) {
                builder.connectTimeout(IW.aOq.aOh, TimeUnit.MILLISECONDS);
                builder.readTimeout(IW.aOq.aOg, TimeUnit.MILLISECONDS);
                builder.writeTimeout(IW.aOq.aOg, TimeUnit.MILLISECONDS);
                builder.addNetworkInterceptor(new com.baidu.swan.apps.network.a.c());
            }
            this.aCF = builder.build();
        }
        this.aCF.dispatcher().setMaxRequests(10);
        return this.aCF;
    }

    public void c(CallbackHandler callbackHandler, String str) {
        if (this.aCG == null) {
            this.aCG = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.aCG, intentFilter);
        } else if (this.aCG != null) {
            this.aCG.updateCallback(callbackHandler, str);
        }
        d(callbackHandler, str);
    }

    public void d(CallbackHandler callbackHandler, String str) {
        if (this.aCH == null) {
            this.aCH = (TelephonyManager) getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
            this.aCI = new a(callbackHandler, str);
            this.aCH.listen(this.aCI, 64);
        } else if (this.aCI != null) {
            this.aCI.updateCallback(callbackHandler, str);
        }
    }

    public void EY() {
        if (this.aCH != null && this.aCI != null) {
            this.aCH.listen(this.aCI, 0);
        }
    }

    public void EZ() {
        if (this.aCG != null) {
            unregisterReceiver(this.aCG);
        }
        EY();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends PhoneStateListener {
        private WeakReference<CallbackHandler> aCJ;
        private String aCK;
        private String aCL = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.aCJ = new WeakReference<>(callbackHandler);
            this.aCK = str;
        }

        public void updateCallback(CallbackHandler callbackHandler, String str) {
            this.aCJ = new WeakReference<>(callbackHandler);
            this.aCK = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            if (j.DEBUG) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i + " networkType " + i2);
            }
            if (2 == i) {
                String l = SwanAppNetworkUtils.l(i2, null);
                if (!TextUtils.isEmpty(l) && !l.equals(this.aCL)) {
                    this.aCL = l;
                    SwanAppNetworkUtils.a(j.this, this.aCJ.get(), this.aCK);
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
