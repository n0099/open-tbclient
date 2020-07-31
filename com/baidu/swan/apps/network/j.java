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
    private NetworkBroadcastReceiver cwP;
    private TelephonyManager cwQ;
    private a cwR;

    public j(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar);
    }

    public void b(CallbackHandler callbackHandler, String str) {
        if (this.cwP == null) {
            this.cwP = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.cwP, intentFilter);
        } else if (this.cwP != null) {
            this.cwP.updateCallback(callbackHandler, str);
        }
        c(callbackHandler, str);
    }

    public void c(CallbackHandler callbackHandler, String str) {
        if (this.cwQ == null) {
            this.cwQ = (TelephonyManager) getSystemService("phone");
            this.cwR = new a(callbackHandler, str);
            this.cwQ.listen(this.cwR, 64);
        } else if (this.cwR != null) {
            this.cwR.updateCallback(callbackHandler, str);
        }
    }

    public void amU() {
        if (this.cwQ != null && this.cwR != null) {
            this.cwQ.listen(this.cwR, 0);
        }
    }

    public void amV() {
        if (this.cwP != null) {
            unregisterReceiver(this.cwP);
        }
        amU();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class a extends PhoneStateListener {
        private WeakReference<CallbackHandler> cwS;
        private String cwT;
        private String cwU = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.cwS = new WeakReference<>(callbackHandler);
            this.cwT = str;
        }

        public void updateCallback(CallbackHandler callbackHandler, String str) {
            this.cwS = new WeakReference<>(callbackHandler);
            this.cwT = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            if (j.DEBUG) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i + " networkType " + i2);
            }
            if (2 == i) {
                String mobileNetworkType = SwanAppNetworkUtils.getMobileNetworkType(i2, null);
                if (!TextUtils.isEmpty(mobileNetworkType) && !mobileNetworkType.equals(this.cwU)) {
                    this.cwU = mobileNetworkType;
                    SwanAppNetworkUtils.a(j.this, this.cwS.get(), this.cwT);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        super.onDestroy();
        amV();
    }
}
