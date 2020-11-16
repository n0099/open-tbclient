package com.baidu.swan.apps.network;

import android.content.IntentFilter;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class j extends com.baidu.swan.apps.runtime.f {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private NetworkBroadcastReceiver dfC;
    private TelephonyManager dfD;
    private a dfE;

    public j(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar);
    }

    public void b(CallbackHandler callbackHandler, String str) {
        if (this.dfC == null) {
            this.dfC = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.dfC, intentFilter);
        } else if (this.dfC != null) {
            this.dfC.updateCallback(callbackHandler, str);
        }
        c(callbackHandler, str);
    }

    public void c(CallbackHandler callbackHandler, String str) {
        if (this.dfD == null) {
            this.dfD = (TelephonyManager) getSystemService("phone");
            this.dfE = new a(callbackHandler, str);
            this.dfD.listen(this.dfE, 64);
        } else if (this.dfE != null) {
            this.dfE.updateCallback(callbackHandler, str);
        }
    }

    public void aBX() {
        if (this.dfD != null && this.dfE != null) {
            this.dfD.listen(this.dfE, 0);
        }
    }

    public void aBY() {
        if (this.dfC != null) {
            unregisterReceiver(this.dfC);
        }
        aBX();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class a extends PhoneStateListener {
        private WeakReference<CallbackHandler> dfF;
        private String dfG;
        private String dfH = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.dfF = new WeakReference<>(callbackHandler);
            this.dfG = str;
        }

        public void updateCallback(CallbackHandler callbackHandler, String str) {
            this.dfF = new WeakReference<>(callbackHandler);
            this.dfG = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            if (j.DEBUG) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i + " networkType " + i2);
            }
            if (2 == i) {
                String mobileNetworkType = SwanAppNetworkUtils.getMobileNetworkType(i2, null);
                if (!TextUtils.isEmpty(mobileNetworkType) && !mobileNetworkType.equals(this.dfH)) {
                    this.dfH = mobileNetworkType;
                    SwanAppNetworkUtils.a(j.this, this.dfF.get(), this.dfG);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        super.onDestroy();
        aBY();
    }
}
