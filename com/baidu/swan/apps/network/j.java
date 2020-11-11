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
    private NetworkBroadcastReceiver dhj;
    private TelephonyManager dhk;
    private a dhl;

    public j(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar);
    }

    public void b(CallbackHandler callbackHandler, String str) {
        if (this.dhj == null) {
            this.dhj = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.dhj, intentFilter);
        } else if (this.dhj != null) {
            this.dhj.updateCallback(callbackHandler, str);
        }
        c(callbackHandler, str);
    }

    public void c(CallbackHandler callbackHandler, String str) {
        if (this.dhk == null) {
            this.dhk = (TelephonyManager) getSystemService("phone");
            this.dhl = new a(callbackHandler, str);
            this.dhk.listen(this.dhl, 64);
        } else if (this.dhl != null) {
            this.dhl.updateCallback(callbackHandler, str);
        }
    }

    public void aCF() {
        if (this.dhk != null && this.dhl != null) {
            this.dhk.listen(this.dhl, 0);
        }
    }

    public void aCG() {
        if (this.dhj != null) {
            unregisterReceiver(this.dhj);
        }
        aCF();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a extends PhoneStateListener {
        private WeakReference<CallbackHandler> dhm;
        private String dhn;
        private String dho = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.dhm = new WeakReference<>(callbackHandler);
            this.dhn = str;
        }

        public void updateCallback(CallbackHandler callbackHandler, String str) {
            this.dhm = new WeakReference<>(callbackHandler);
            this.dhn = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            if (j.DEBUG) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i + " networkType " + i2);
            }
            if (2 == i) {
                String mobileNetworkType = SwanAppNetworkUtils.getMobileNetworkType(i2, null);
                if (!TextUtils.isEmpty(mobileNetworkType) && !mobileNetworkType.equals(this.dho)) {
                    this.dho = mobileNetworkType;
                    SwanAppNetworkUtils.a(j.this, this.dhm.get(), this.dhn);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        super.onDestroy();
        aCG();
    }
}
