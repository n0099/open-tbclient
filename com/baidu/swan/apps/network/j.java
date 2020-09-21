package com.baidu.swan.apps.network;

import android.content.IntentFilter;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class j extends com.baidu.swan.apps.runtime.f {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private NetworkBroadcastReceiver cGN;
    private TelephonyManager cGO;
    private a cGP;

    public j(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar);
    }

    public void b(CallbackHandler callbackHandler, String str) {
        if (this.cGN == null) {
            this.cGN = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.cGN, intentFilter);
        } else if (this.cGN != null) {
            this.cGN.updateCallback(callbackHandler, str);
        }
        c(callbackHandler, str);
    }

    public void c(CallbackHandler callbackHandler, String str) {
        if (this.cGO == null) {
            this.cGO = (TelephonyManager) getSystemService("phone");
            this.cGP = new a(callbackHandler, str);
            this.cGO.listen(this.cGP, 64);
        } else if (this.cGP != null) {
            this.cGP.updateCallback(callbackHandler, str);
        }
    }

    public void avA() {
        if (this.cGO != null && this.cGP != null) {
            this.cGO.listen(this.cGP, 0);
        }
    }

    public void avB() {
        if (this.cGN != null) {
            unregisterReceiver(this.cGN);
        }
        avA();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends PhoneStateListener {
        private WeakReference<CallbackHandler> cGQ;
        private String cGR;
        private String cGS = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.cGQ = new WeakReference<>(callbackHandler);
            this.cGR = str;
        }

        public void updateCallback(CallbackHandler callbackHandler, String str) {
            this.cGQ = new WeakReference<>(callbackHandler);
            this.cGR = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            if (j.DEBUG) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i + " networkType " + i2);
            }
            if (2 == i) {
                String mobileNetworkType = SwanAppNetworkUtils.getMobileNetworkType(i2, null);
                if (!TextUtils.isEmpty(mobileNetworkType) && !mobileNetworkType.equals(this.cGS)) {
                    this.cGS = mobileNetworkType;
                    SwanAppNetworkUtils.a(j.this, this.cGQ.get(), this.cGR);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        super.onDestroy();
        avB();
    }
}
