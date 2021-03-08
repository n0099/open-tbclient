package com.asus.msa.sdid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.Keep;
import com.asus.msa.a.a;
@Keep
/* loaded from: classes4.dex */
public class SupplementaryDIDManager {
    public static boolean DEBUG = false;
    public static final String TAG = "SupplementaryDIDManager";
    public Context mContext;
    public com.asus.msa.a.a mDidService;
    public a mListener;
    public boolean isBinded = false;
    public ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.asus.msa.sdid.SupplementaryDIDManager.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (SupplementaryDIDManager.DEBUG) {
                Log.i(SupplementaryDIDManager.TAG, "did service binded");
            }
            SupplementaryDIDManager.this.mDidService = a.AbstractBinderC0014a.a(iBinder);
            SupplementaryDIDManager.this.notifyAllListeners(true);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            SupplementaryDIDManager.this.notifyAllListeners(false);
        }
    };

    public SupplementaryDIDManager(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAllListeners(boolean z) {
        try {
            if (z) {
                this.mListener.a(this.mDidService);
            } else {
                this.mListener.a();
            }
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "notify did bind status error :" + e.getMessage());
            }
        }
    }

    public void deInit() {
        try {
            if (!this.isBinded || this.mServiceConnection == null || this.mContext == null) {
                return;
            }
            if (DEBUG) {
                Log.i(TAG, "start to unbind did service");
            }
            this.isBinded = false;
            this.mContext.unbindService(this.mServiceConnection);
        } catch (Exception e) {
            Log.w(TAG, e.getMessage());
        }
    }

    public void init(a aVar) {
        try {
            this.mListener = aVar;
            Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
            ComponentName componentName = new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService");
            Intent intent2 = new Intent(intent);
            intent2.setComponent(componentName);
            if (DEBUG) {
                Log.i(TAG, "start to bind did service.");
            }
            this.isBinded = this.mContext.bindService(intent2, this.mServiceConnection, 1);
        } catch (Exception e) {
            notifyAllListeners(false);
        }
    }

    public void showLog(boolean z) {
        DEBUG = z;
    }
}
