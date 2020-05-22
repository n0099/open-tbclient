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
import okhttp3.OkHttpClient;
import okhttp3.Request;
/* loaded from: classes11.dex */
public class j extends com.baidu.swan.apps.runtime.f {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private OkHttpClient bBB;
    private NetworkBroadcastReceiver cpZ;
    private TelephonyManager cqa;
    private a cqb;

    public j(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar);
    }

    @Deprecated
    public void a(Request request, Callback callback) {
        akx().newCall(request).enqueue(callback);
    }

    @Deprecated
    public OkHttpClient akx() {
        SwanAppConfigData aoO = apd().aoO();
        if (this.bBB == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (aoO != null && aoO.cAy != null) {
                builder.connectTimeout(aoO.cAy.cAo, TimeUnit.MILLISECONDS);
                builder.readTimeout(60000L, TimeUnit.MILLISECONDS);
                builder.writeTimeout(60000L, TimeUnit.MILLISECONDS);
                builder.addNetworkInterceptor(new com.baidu.swan.apps.network.a.d());
                builder.addNetworkInterceptor(new com.baidu.swan.apps.network.a.c());
            }
            this.bBB = builder.build();
        }
        this.bBB.dispatcher().setMaxRequests(10);
        return this.bBB;
    }

    public void b(CallbackHandler callbackHandler, String str) {
        if (this.cpZ == null) {
            this.cpZ = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.cpZ, intentFilter);
        } else if (this.cpZ != null) {
            this.cpZ.updateCallback(callbackHandler, str);
        }
        c(callbackHandler, str);
    }

    public void c(CallbackHandler callbackHandler, String str) {
        if (this.cqa == null) {
            this.cqa = (TelephonyManager) getSystemService("phone");
            this.cqb = new a(callbackHandler, str);
            this.cqa.listen(this.cqb, 64);
        } else if (this.cqb != null) {
            this.cqb.updateCallback(callbackHandler, str);
        }
    }

    public void aky() {
        if (this.cqa != null && this.cqb != null) {
            this.cqa.listen(this.cqb, 0);
        }
    }

    public void akz() {
        if (this.cpZ != null) {
            unregisterReceiver(this.cpZ);
        }
        aky();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a extends PhoneStateListener {
        private WeakReference<CallbackHandler> cqc;
        private String cqd;
        private String cqe = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.cqc = new WeakReference<>(callbackHandler);
            this.cqd = str;
        }

        public void updateCallback(CallbackHandler callbackHandler, String str) {
            this.cqc = new WeakReference<>(callbackHandler);
            this.cqd = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            if (j.DEBUG) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i + " networkType " + i2);
            }
            if (2 == i) {
                String mobileNetworkType = SwanAppNetworkUtils.getMobileNetworkType(i2, null);
                if (!TextUtils.isEmpty(mobileNetworkType) && !mobileNetworkType.equals(this.cqe)) {
                    this.cqe = mobileNetworkType;
                    SwanAppNetworkUtils.a(j.this, this.cqc.get(), this.cqd);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        super.onDestroy();
        akz();
    }
}
