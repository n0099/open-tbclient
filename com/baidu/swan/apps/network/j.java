package com.baidu.swan.apps.network;

import android.content.IntentFilter;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import java.lang.ref.WeakReference;
/* loaded from: classes25.dex */
public class j extends com.baidu.swan.apps.runtime.f {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private NetworkBroadcastReceiver dmB;
    private TelephonyManager dmC;
    private a dmD;

    public j(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar);
    }

    public void b(CallbackHandler callbackHandler, String str) {
        if (this.dmB == null) {
            this.dmB = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.dmB, intentFilter);
        } else if (this.dmB != null) {
            this.dmB.updateCallback(callbackHandler, str);
        }
        c(callbackHandler, str);
    }

    public void c(CallbackHandler callbackHandler, String str) {
        if (this.dmC == null) {
            this.dmC = (TelephonyManager) getSystemService("phone");
            this.dmD = new a(callbackHandler, str);
            this.dmC.listen(this.dmD, 64);
        } else if (this.dmD != null) {
            this.dmD.updateCallback(callbackHandler, str);
        }
    }

    public void aFg() {
        if (this.dmC != null && this.dmD != null) {
            this.dmC.listen(this.dmD, 0);
        }
    }

    public void aFh() {
        if (this.dmB != null) {
            unregisterReceiver(this.dmB);
        }
        aFg();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public class a extends PhoneStateListener {
        private WeakReference<CallbackHandler> dmE;
        private String dmF;
        private String dmG = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.dmE = new WeakReference<>(callbackHandler);
            this.dmF = str;
        }

        public void updateCallback(CallbackHandler callbackHandler, String str) {
            this.dmE = new WeakReference<>(callbackHandler);
            this.dmF = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            if (j.DEBUG) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i + " networkType " + i2);
            }
            if (2 == i) {
                String mobileNetworkType = SwanAppNetworkUtils.getMobileNetworkType(i2, null);
                if (!TextUtils.isEmpty(mobileNetworkType) && !mobileNetworkType.equals(this.dmG)) {
                    this.dmG = mobileNetworkType;
                    SwanAppNetworkUtils.a(j.this, this.dmE.get(), this.dmF);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        super.onDestroy();
        aFh();
    }
}
