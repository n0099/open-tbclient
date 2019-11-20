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
    private OkHttpClient aYu;
    private NetworkBroadcastReceiver aYv;
    private TelephonyManager aYw;
    private a aYx;

    public j(com.baidu.swan.apps.ae.b bVar) {
        super(bVar);
    }

    public void a(Request request, Callback callback) {
        MM().newCall(request).enqueue(callback);
    }

    public void a(Request request, Interceptor interceptor, Callback callback) {
        MM().newBuilder().addInterceptor(interceptor).build().newCall(request).enqueue(callback);
    }

    public OkHttpClient MM() {
        com.baidu.swan.apps.ae.a.c Rc = Rs().Rc();
        if (this.aYu == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (Rc != null && Rc.bkn != null) {
                builder.connectTimeout(Rc.bkn.bke, TimeUnit.MILLISECONDS);
                builder.readTimeout(Rc.bkn.bkd, TimeUnit.MILLISECONDS);
                builder.writeTimeout(Rc.bkn.bkd, TimeUnit.MILLISECONDS);
                builder.addNetworkInterceptor(new com.baidu.swan.apps.network.a.c());
            }
            this.aYu = builder.build();
        }
        this.aYu.dispatcher().setMaxRequests(10);
        return this.aYu;
    }

    public void c(CallbackHandler callbackHandler, String str) {
        if (this.aYv == null) {
            this.aYv = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.aYv, intentFilter);
        } else if (this.aYv != null) {
            this.aYv.updateCallback(callbackHandler, str);
        }
        d(callbackHandler, str);
    }

    public void d(CallbackHandler callbackHandler, String str) {
        if (this.aYw == null) {
            this.aYw = (TelephonyManager) getSystemService("phone");
            this.aYx = new a(callbackHandler, str);
            this.aYw.listen(this.aYx, 64);
        } else if (this.aYx != null) {
            this.aYx.updateCallback(callbackHandler, str);
        }
    }

    public void MN() {
        if (this.aYw != null && this.aYx != null) {
            this.aYw.listen(this.aYx, 0);
        }
    }

    public void MO() {
        if (this.aYv != null) {
            unregisterReceiver(this.aYv);
        }
        MN();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends PhoneStateListener {
        private String aYA = "";
        private WeakReference<CallbackHandler> aYy;
        private String aYz;

        public a(CallbackHandler callbackHandler, String str) {
            this.aYy = new WeakReference<>(callbackHandler);
            this.aYz = str;
        }

        public void updateCallback(CallbackHandler callbackHandler, String str) {
            this.aYy = new WeakReference<>(callbackHandler);
            this.aYz = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            if (j.DEBUG) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i + " networkType " + i2);
            }
            if (2 == i) {
                String s = SwanAppNetworkUtils.s(i2, null);
                if (!TextUtils.isEmpty(s) && !s.equals(this.aYA)) {
                    this.aYA = s;
                    SwanAppNetworkUtils.a(j.this, this.aYy.get(), this.aYz);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.ae.c
    public void onDestroy() {
        super.onDestroy();
        MO();
    }
}
