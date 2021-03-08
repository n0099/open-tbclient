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
    private TelephonyManager dqA;
    private a dqB;
    private NetworkBroadcastReceiver dqz;

    public j(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar);
    }

    public void b(CallbackHandler callbackHandler, String str) {
        if (this.dqz == null) {
            this.dqz = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.dqz, intentFilter);
        } else if (this.dqz != null) {
            this.dqz.updateCallback(callbackHandler, str);
        }
        c(callbackHandler, str);
    }

    public void c(CallbackHandler callbackHandler, String str) {
        if (this.dqA == null) {
            this.dqA = (TelephonyManager) getSystemService("phone");
            this.dqB = new a(callbackHandler, str);
            this.dqA.listen(this.dqB, 64);
        } else if (this.dqB != null) {
            this.dqB.updateCallback(callbackHandler, str);
        }
    }

    public void aDg() {
        if (this.dqA != null && this.dqB != null) {
            this.dqA.listen(this.dqB, 0);
        }
    }

    public void aDh() {
        if (this.dqz != null) {
            unregisterReceiver(this.dqz);
        }
        aDg();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class a extends PhoneStateListener {
        private WeakReference<CallbackHandler> dqC;
        private String dqD;
        private String dqE = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.dqC = new WeakReference<>(callbackHandler);
            this.dqD = str;
        }

        public void updateCallback(CallbackHandler callbackHandler, String str) {
            this.dqC = new WeakReference<>(callbackHandler);
            this.dqD = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            if (j.DEBUG) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i + " networkType " + i2);
            }
            if (2 == i) {
                String mobileNetworkType = SwanAppNetworkUtils.getMobileNetworkType(i2, null);
                if (!TextUtils.isEmpty(mobileNetworkType) && !mobileNetworkType.equals(this.dqE)) {
                    this.dqE = mobileNetworkType;
                    SwanAppNetworkUtils.a(j.this, this.dqC.get(), this.dqD);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        super.onDestroy();
        aDh();
    }
}
