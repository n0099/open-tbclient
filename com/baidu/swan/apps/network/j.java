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
    private NetworkBroadcastReceiver cEJ;
    private TelephonyManager cEK;
    private a cEL;

    public j(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar);
    }

    public void b(CallbackHandler callbackHandler, String str) {
        if (this.cEJ == null) {
            this.cEJ = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.cEJ, intentFilter);
        } else if (this.cEJ != null) {
            this.cEJ.updateCallback(callbackHandler, str);
        }
        c(callbackHandler, str);
    }

    public void c(CallbackHandler callbackHandler, String str) {
        if (this.cEK == null) {
            this.cEK = (TelephonyManager) getSystemService("phone");
            this.cEL = new a(callbackHandler, str);
            this.cEK.listen(this.cEL, 64);
        } else if (this.cEL != null) {
            this.cEL.updateCallback(callbackHandler, str);
        }
    }

    public void auR() {
        if (this.cEK != null && this.cEL != null) {
            this.cEK.listen(this.cEL, 0);
        }
    }

    public void auS() {
        if (this.cEJ != null) {
            unregisterReceiver(this.cEJ);
        }
        auR();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class a extends PhoneStateListener {
        private WeakReference<CallbackHandler> cEM;
        private String cEN;
        private String cEO = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.cEM = new WeakReference<>(callbackHandler);
            this.cEN = str;
        }

        public void updateCallback(CallbackHandler callbackHandler, String str) {
            this.cEM = new WeakReference<>(callbackHandler);
            this.cEN = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            if (j.DEBUG) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i + " networkType " + i2);
            }
            if (2 == i) {
                String mobileNetworkType = SwanAppNetworkUtils.getMobileNetworkType(i2, null);
                if (!TextUtils.isEmpty(mobileNetworkType) && !mobileNetworkType.equals(this.cEO)) {
                    this.cEO = mobileNetworkType;
                    SwanAppNetworkUtils.a(j.this, this.cEM.get(), this.cEN);
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
