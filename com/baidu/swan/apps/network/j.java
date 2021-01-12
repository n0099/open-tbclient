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
    private NetworkBroadcastReceiver dmK;
    private TelephonyManager dmL;
    private a dmM;

    public j(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar);
    }

    public void b(CallbackHandler callbackHandler, String str) {
        if (this.dmK == null) {
            this.dmK = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.dmK, intentFilter);
        } else if (this.dmK != null) {
            this.dmK.updateCallback(callbackHandler, str);
        }
        c(callbackHandler, str);
    }

    public void c(CallbackHandler callbackHandler, String str) {
        if (this.dmL == null) {
            this.dmL = (TelephonyManager) getSystemService("phone");
            this.dmM = new a(callbackHandler, str);
            this.dmL.listen(this.dmM, 64);
        } else if (this.dmM != null) {
            this.dmM.updateCallback(callbackHandler, str);
        }
    }

    public void aCH() {
        if (this.dmL != null && this.dmM != null) {
            this.dmL.listen(this.dmM, 0);
        }
    }

    public void aCI() {
        if (this.dmK != null) {
            unregisterReceiver(this.dmK);
        }
        aCH();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class a extends PhoneStateListener {
        private WeakReference<CallbackHandler> dmN;
        private String dmO;
        private String dmP = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.dmN = new WeakReference<>(callbackHandler);
            this.dmO = str;
        }

        public void updateCallback(CallbackHandler callbackHandler, String str) {
            this.dmN = new WeakReference<>(callbackHandler);
            this.dmO = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            if (j.DEBUG) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i + " networkType " + i2);
            }
            if (2 == i) {
                String mobileNetworkType = SwanAppNetworkUtils.getMobileNetworkType(i2, null);
                if (!TextUtils.isEmpty(mobileNetworkType) && !mobileNetworkType.equals(this.dmP)) {
                    this.dmP = mobileNetworkType;
                    SwanAppNetworkUtils.a(j.this, this.dmN.get(), this.dmO);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        super.onDestroy();
        aCI();
    }
}
