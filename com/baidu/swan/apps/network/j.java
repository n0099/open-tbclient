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
    private NetworkBroadcastReceiver doX;
    private TelephonyManager doY;
    private a doZ;

    public j(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar);
    }

    public void b(CallbackHandler callbackHandler, String str) {
        if (this.doX == null) {
            this.doX = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.doX, intentFilter);
        } else if (this.doX != null) {
            this.doX.updateCallback(callbackHandler, str);
        }
        c(callbackHandler, str);
    }

    public void c(CallbackHandler callbackHandler, String str) {
        if (this.doY == null) {
            this.doY = (TelephonyManager) getSystemService("phone");
            this.doZ = new a(callbackHandler, str);
            this.doY.listen(this.doZ, 64);
        } else if (this.doZ != null) {
            this.doZ.updateCallback(callbackHandler, str);
        }
    }

    public void aDd() {
        if (this.doY != null && this.doZ != null) {
            this.doY.listen(this.doZ, 0);
        }
    }

    public void aDe() {
        if (this.doX != null) {
            unregisterReceiver(this.doX);
        }
        aDd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a extends PhoneStateListener {
        private WeakReference<CallbackHandler> dpa;
        private String dpb;
        private String dpc = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.dpa = new WeakReference<>(callbackHandler);
            this.dpb = str;
        }

        public void updateCallback(CallbackHandler callbackHandler, String str) {
            this.dpa = new WeakReference<>(callbackHandler);
            this.dpb = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            if (j.DEBUG) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i + " networkType " + i2);
            }
            if (2 == i) {
                String mobileNetworkType = SwanAppNetworkUtils.getMobileNetworkType(i2, null);
                if (!TextUtils.isEmpty(mobileNetworkType) && !mobileNetworkType.equals(this.dpc)) {
                    this.dpc = mobileNetworkType;
                    SwanAppNetworkUtils.a(j.this, this.dpa.get(), this.dpb);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        super.onDestroy();
        aDe();
    }
}
