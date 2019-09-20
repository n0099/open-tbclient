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
    private a aFA;
    private OkHttpClient aFx;
    private NetworkBroadcastReceiver aFy;
    private TelephonyManager aFz;

    public j(com.baidu.swan.apps.ae.b bVar) {
        super(bVar);
    }

    public void a(Request request, Callback callback) {
        HR().newCall(request).enqueue(callback);
    }

    public void a(Request request, Interceptor interceptor, Callback callback) {
        HR().newBuilder().addInterceptor(interceptor).build().newCall(request).enqueue(callback);
    }

    public OkHttpClient HR() {
        com.baidu.swan.apps.ae.a.c Mi = My().Mi();
        if (this.aFx == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (Mi != null && Mi.aRB != null) {
                builder.connectTimeout(Mi.aRB.aRs, TimeUnit.MILLISECONDS);
                builder.readTimeout(Mi.aRB.aRr, TimeUnit.MILLISECONDS);
                builder.writeTimeout(Mi.aRB.aRr, TimeUnit.MILLISECONDS);
                builder.addNetworkInterceptor(new com.baidu.swan.apps.network.a.c());
            }
            this.aFx = builder.build();
        }
        this.aFx.dispatcher().setMaxRequests(10);
        return this.aFx;
    }

    public void c(CallbackHandler callbackHandler, String str) {
        if (this.aFy == null) {
            this.aFy = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.aFy, intentFilter);
        } else if (this.aFy != null) {
            this.aFy.updateCallback(callbackHandler, str);
        }
        d(callbackHandler, str);
    }

    public void d(CallbackHandler callbackHandler, String str) {
        if (this.aFz == null) {
            this.aFz = (TelephonyManager) getSystemService("phone");
            this.aFA = new a(callbackHandler, str);
            this.aFz.listen(this.aFA, 64);
        } else if (this.aFA != null) {
            this.aFA.updateCallback(callbackHandler, str);
        }
    }

    public void HS() {
        if (this.aFz != null && this.aFA != null) {
            this.aFz.listen(this.aFA, 0);
        }
    }

    public void HT() {
        if (this.aFy != null) {
            unregisterReceiver(this.aFy);
        }
        HS();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends PhoneStateListener {
        private WeakReference<CallbackHandler> aFB;
        private String aFC;
        private String aFD = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.aFB = new WeakReference<>(callbackHandler);
            this.aFC = str;
        }

        public void updateCallback(CallbackHandler callbackHandler, String str) {
            this.aFB = new WeakReference<>(callbackHandler);
            this.aFC = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            if (j.DEBUG) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i + " networkType " + i2);
            }
            if (2 == i) {
                String o = SwanAppNetworkUtils.o(i2, null);
                if (!TextUtils.isEmpty(o) && !o.equals(this.aFD)) {
                    this.aFD = o;
                    SwanAppNetworkUtils.a(j.this, this.aFB.get(), this.aFC);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.ae.c
    public void onDestroy() {
        super.onDestroy();
        HT();
    }
}
