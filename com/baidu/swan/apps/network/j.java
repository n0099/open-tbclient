package com.baidu.swan.apps.network;

import android.content.IntentFilter;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class j extends com.baidu.swan.apps.runtime.f {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private NetworkBroadcastReceiver cEN;
    private TelephonyManager cEO;
    private a cEP;

    public j(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar);
    }

    public void b(CallbackHandler callbackHandler, String str) {
        if (this.cEN == null) {
            this.cEN = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.cEN, intentFilter);
        } else if (this.cEN != null) {
            this.cEN.updateCallback(callbackHandler, str);
        }
        c(callbackHandler, str);
    }

    public void c(CallbackHandler callbackHandler, String str) {
        if (this.cEO == null) {
            this.cEO = (TelephonyManager) getSystemService("phone");
            this.cEP = new a(callbackHandler, str);
            this.cEO.listen(this.cEP, 64);
        } else if (this.cEP != null) {
            this.cEP.updateCallback(callbackHandler, str);
        }
    }

    public void auR() {
        if (this.cEO != null && this.cEP != null) {
            this.cEO.listen(this.cEP, 0);
        }
    }

    public void auS() {
        if (this.cEN != null) {
            unregisterReceiver(this.cEN);
        }
        auR();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class a extends PhoneStateListener {
        private WeakReference<CallbackHandler> cEQ;
        private String cER;
        private String cES = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.cEQ = new WeakReference<>(callbackHandler);
            this.cER = str;
        }

        public void updateCallback(CallbackHandler callbackHandler, String str) {
            this.cEQ = new WeakReference<>(callbackHandler);
            this.cER = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            if (j.DEBUG) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i + " networkType " + i2);
            }
            if (2 == i) {
                String mobileNetworkType = SwanAppNetworkUtils.getMobileNetworkType(i2, null);
                if (!TextUtils.isEmpty(mobileNetworkType) && !mobileNetworkType.equals(this.cES)) {
                    this.cES = mobileNetworkType;
                    SwanAppNetworkUtils.a(j.this, this.cEQ.get(), this.cER);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        super.onDestroy();
        auS();
    }
}
