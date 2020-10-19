package com.baidu.swan.apps.network;

import android.content.IntentFilter;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class j extends com.baidu.swan.apps.runtime.f {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private NetworkBroadcastReceiver cSQ;
    private TelephonyManager cSR;
    private a cSS;

    public j(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar);
    }

    public void b(CallbackHandler callbackHandler, String str) {
        if (this.cSQ == null) {
            this.cSQ = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.cSQ, intentFilter);
        } else if (this.cSQ != null) {
            this.cSQ.updateCallback(callbackHandler, str);
        }
        c(callbackHandler, str);
    }

    public void c(CallbackHandler callbackHandler, String str) {
        if (this.cSR == null) {
            this.cSR = (TelephonyManager) getSystemService("phone");
            this.cSS = new a(callbackHandler, str);
            this.cSR.listen(this.cSS, 64);
        } else if (this.cSS != null) {
            this.cSS.updateCallback(callbackHandler, str);
        }
    }

    public void ayl() {
        if (this.cSR != null && this.cSS != null) {
            this.cSR.listen(this.cSS, 0);
        }
    }

    public void aym() {
        if (this.cSQ != null) {
            unregisterReceiver(this.cSQ);
        }
        ayl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a extends PhoneStateListener {
        private WeakReference<CallbackHandler> cST;
        private String cSU;
        private String cSV = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.cST = new WeakReference<>(callbackHandler);
            this.cSU = str;
        }

        public void updateCallback(CallbackHandler callbackHandler, String str) {
            this.cST = new WeakReference<>(callbackHandler);
            this.cSU = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            if (j.DEBUG) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i + " networkType " + i2);
            }
            if (2 == i) {
                String mobileNetworkType = SwanAppNetworkUtils.getMobileNetworkType(i2, null);
                if (!TextUtils.isEmpty(mobileNetworkType) && !mobileNetworkType.equals(this.cSV)) {
                    this.cSV = mobileNetworkType;
                    SwanAppNetworkUtils.a(j.this, this.cST.get(), this.cSU);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        super.onDestroy();
        aym();
    }
}
