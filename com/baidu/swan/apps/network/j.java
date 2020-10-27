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
    private NetworkBroadcastReceiver dbo;
    private TelephonyManager dbp;
    private a dbq;

    public j(com.baidu.swan.apps.runtime.e eVar) {
        super(eVar);
    }

    public void b(CallbackHandler callbackHandler, String str) {
        if (this.dbo == null) {
            this.dbo = new NetworkBroadcastReceiver(callbackHandler, str);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(this.dbo, intentFilter);
        } else if (this.dbo != null) {
            this.dbo.updateCallback(callbackHandler, str);
        }
        c(callbackHandler, str);
    }

    public void c(CallbackHandler callbackHandler, String str) {
        if (this.dbp == null) {
            this.dbp = (TelephonyManager) getSystemService("phone");
            this.dbq = new a(callbackHandler, str);
            this.dbp.listen(this.dbq, 64);
        } else if (this.dbq != null) {
            this.dbq.updateCallback(callbackHandler, str);
        }
    }

    public void aAf() {
        if (this.dbp != null && this.dbq != null) {
            this.dbp.listen(this.dbq, 0);
        }
    }

    public void aAg() {
        if (this.dbo != null) {
            unregisterReceiver(this.dbo);
        }
        aAf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a extends PhoneStateListener {
        private WeakReference<CallbackHandler> dbr;
        private String dbs;
        private String dbt = "";

        public a(CallbackHandler callbackHandler, String str) {
            this.dbr = new WeakReference<>(callbackHandler);
            this.dbs = str;
        }

        public void updateCallback(CallbackHandler callbackHandler, String str) {
            this.dbr = new WeakReference<>(callbackHandler);
            this.dbs = str;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            if (j.DEBUG) {
                Log.d("PhoneStateListener", "——> onDataConnectionStateChanged: state " + i + " networkType " + i2);
            }
            if (2 == i) {
                String mobileNetworkType = SwanAppNetworkUtils.getMobileNetworkType(i2, null);
                if (!TextUtils.isEmpty(mobileNetworkType) && !mobileNetworkType.equals(this.dbt)) {
                    this.dbt = mobileNetworkType;
                    SwanAppNetworkUtils.a(j.this, this.dbr.get(), this.dbs);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        super.onDestroy();
        aAg();
    }
}
