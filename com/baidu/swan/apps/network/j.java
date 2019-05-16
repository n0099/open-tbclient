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
    private OkHttpClient aEr;
    private NetworkBroadcastReceiver aEs;
    private TelephonyManager aEt;
    private a aEu;

    public j(com.baidu.swan.apps.ae.b bVar) {
        super(bVar);
    }

    public void a(Request request, Callback callback) {
        Hc().newCall(request).enqueue(callback);
    }

    public void a(Request request, Interceptor interceptor, Callback callback) {
        Hc().newBuilder().addInterceptor(interceptor).build().newCall(request).enqueue(callback);
    }

    public OkHttpClient Hc() {
        com.baidu.swan.apps.ae.a.c Lr = LG().Lr();
        if (this.aEr == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (Lr != null && Lr.aQt != null) {
                builder.connectTimeout(Lr.aQt.aQk, TimeUnit.MILLISECONDS);
                builder.readTimeout(Lr.aQt.aQj, TimeUnit.MILLISECONDS);
                builder.writeTimeout(Lr.aQt.aQj, TimeUnit.MILLISECONDS);
                builder.addNetworkInterceptor(new com.baidu.swan.apps.network.a.c());
            }
            this.aEr = builder.build();
        }
        this.aEr.dispatcher().setMaxRequests(10);
        return this.aEr;
    }

    public void c(CallbackHandler callbackHandler, String str) {
        if (this.aEs == null) {
            this.aEs = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.aEs, intentFilter);
        } else if (this.aEs != null) {
            this.aEs.updateCallback(callbackHandler, str);
        }
        d(callbackHandler, str);
    }

    public void d(CallbackHandler callbackHandler, String str) {
        if (this.aEt == null) {
            this.aEt = (TelephonyManager) getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
            this.aEu = new a(callbackHandler, str);
            this.aEt.listen(this.aEu, 64);
        } else if (this.aEu != null) {
            this.aEu.updateCallback(callbackHandler, str);
        }
    }

    public void Hd() {
        if (this.aEt != null && this.aEu != null) {
            this.aEt.listen(this.aEu, 0);
        }
    }

    public void He() {
        if (this.aEs != null) {
            unregisterReceiver(this.aEs);
        }
        Hd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends PhoneStateListener {
        private WeakReference<CallbackHandler> aEv;
        private String aEw;
        private String aEx = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.aEv = new WeakReference<>(callbackHandler);
            this.aEw = str;
        }

        public void updateCallback(CallbackHandler callbackHandler, String str) {
            this.aEv = new WeakReference<>(callbackHandler);
            this.aEw = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            if (j.DEBUG) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i + " networkType " + i2);
            }
            if (2 == i) {
                String o = SwanAppNetworkUtils.o(i2, null);
                if (!TextUtils.isEmpty(o) && !o.equals(this.aEx)) {
                    this.aEx = o;
                    SwanAppNetworkUtils.a(j.this, this.aEv.get(), this.aEw);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.ae.c
    public void onDestroy() {
        super.onDestroy();
        He();
    }
}
