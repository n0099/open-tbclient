package com.baidu.swan.apps.network;

import android.content.IntentFilter;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import java.lang.ref.WeakReference;
/* loaded from: classes9.dex */
public class j extends com.baidu.swan.apps.runtime.f {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private NetworkBroadcastReceiver drB;
    private TelephonyManager drC;
    private a drD;

    public j(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar);
    }

    public void b(CallbackHandler callbackHandler, String str) {
        if (this.drB == null) {
            this.drB = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.drB, intentFilter);
        } else if (this.drB != null) {
            this.drB.updateCallback(callbackHandler, str);
        }
        c(callbackHandler, str);
    }

    public void c(CallbackHandler callbackHandler, String str) {
        if (this.drC == null) {
            this.drC = (TelephonyManager) getSystemService("phone");
            this.drD = new a(callbackHandler, str);
            this.drC.listen(this.drD, 64);
        } else if (this.drD != null) {
            this.drD.updateCallback(callbackHandler, str);
        }
    }

    public void aGB() {
        if (this.drC != null && this.drD != null) {
            this.drC.listen(this.drD, 0);
        }
    }

    public void aGC() {
        if (this.drB != null) {
            unregisterReceiver(this.drB);
        }
        aGB();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a extends PhoneStateListener {
        private WeakReference<CallbackHandler> drE;
        private String drF;
        private String drG = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.drE = new WeakReference<>(callbackHandler);
            this.drF = str;
        }

        public void updateCallback(CallbackHandler callbackHandler, String str) {
            this.drE = new WeakReference<>(callbackHandler);
            this.drF = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            if (j.DEBUG) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i + " networkType " + i2);
            }
            if (2 == i) {
                String mobileNetworkType = SwanAppNetworkUtils.getMobileNetworkType(i2, null);
                if (!TextUtils.isEmpty(mobileNetworkType) && !mobileNetworkType.equals(this.drG)) {
                    this.drG = mobileNetworkType;
                    SwanAppNetworkUtils.a(j.this, this.drE.get(), this.drF);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        super.onDestroy();
        aGC();
    }
}
