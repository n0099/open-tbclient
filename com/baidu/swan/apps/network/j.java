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
    private OkHttpClient btT;
    private NetworkBroadcastReceiver cfk;
    private TelephonyManager cfl;
    private a cfm;

    public j(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar);
    }

    public void a(Request request, Callback callback) {
        ahf().newCall(request).enqueue(callback);
    }

    public void a(Request request, Interceptor interceptor, Callback callback) {
        ahf().newBuilder().addInterceptor(interceptor).build().newCall(request).enqueue(callback);
    }

    public OkHttpClient ahf() {
        SwanAppConfigData akT = alj().akT();
        if (this.btT == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (akT != null && akT.coG != null) {
                builder.connectTimeout(akT.coG.cox, TimeUnit.MILLISECONDS);
                builder.readTimeout(akT.coG.cow, TimeUnit.MILLISECONDS);
                builder.writeTimeout(akT.coG.cow, TimeUnit.MILLISECONDS);
                builder.addNetworkInterceptor(new com.baidu.swan.apps.network.a.c());
            }
            this.btT = builder.build();
        }
        this.btT.dispatcher().setMaxRequests(10);
        return this.btT;
    }

    public void c(CallbackHandler callbackHandler, String str) {
        if (this.cfk == null) {
            this.cfk = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.cfk, intentFilter);
        } else if (this.cfk != null) {
            this.cfk.updateCallback(callbackHandler, str);
        }
        d(callbackHandler, str);
    }

    public void d(CallbackHandler callbackHandler, String str) {
        if (this.cfl == null) {
            this.cfl = (TelephonyManager) getSystemService("phone");
            this.cfm = new a(callbackHandler, str);
            this.cfl.listen(this.cfm, 64);
        } else if (this.cfm != null) {
            this.cfm.updateCallback(callbackHandler, str);
        }
    }

    public void ahg() {
        if (this.cfl != null && this.cfm != null) {
            this.cfl.listen(this.cfm, 0);
        }
    }

    public void ahh() {
        if (this.cfk != null) {
            unregisterReceiver(this.cfk);
        }
        ahg();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a extends PhoneStateListener {
        private WeakReference<CallbackHandler> cfn;
        private String cfo;
        private String cfp = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.cfn = new WeakReference<>(callbackHandler);
            this.cfo = str;
        }

        public void updateCallback(CallbackHandler callbackHandler, String str) {
            this.cfn = new WeakReference<>(callbackHandler);
            this.cfo = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            if (j.DEBUG) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i + " networkType " + i2);
            }
            if (2 == i) {
                String mobileNetworkType = SwanAppNetworkUtils.getMobileNetworkType(i2, null);
                if (!TextUtils.isEmpty(mobileNetworkType) && !mobileNetworkType.equals(this.cfp)) {
                    this.cfp = mobileNetworkType;
                    SwanAppNetworkUtils.a(j.this, this.cfn.get(), this.cfo);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        super.onDestroy();
        ahh();
    }
}
