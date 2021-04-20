package com.baidu.mobads.container.landingpage;

import android.content.Context;
import android.content.IntentFilter;
import com.baidu.mobads.container.util.XAdRemoteEvent;
import com.baidu.mobads.container.util.XAdRemoteEventDispatcher;
/* loaded from: classes2.dex */
public class LpCloseController extends XAdRemoteEventDispatcher {
    public static LpCloseController sInstance;
    public Context mContext;
    public LpCloseReceiver mReceiver;

    public LpCloseController(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static LpCloseController getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LpCloseController.class) {
                if (sInstance == null) {
                    sInstance = new LpCloseController(context);
                }
            }
        }
        return sInstance;
    }

    public void onLpClosed() {
        dispatchEvent(new XAdRemoteEvent("AdLpClosed"));
        getInstance(this.mContext).removeEventListeners("AdLpClosed");
        getInstance(this.mContext).stopListener();
    }

    public void startListener() {
        try {
            if (this.mReceiver == null) {
                this.mReceiver = new LpCloseReceiver(this);
            }
            if (this.mContext != null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("lp_close");
                this.mContext.registerReceiver(this.mReceiver, intentFilter);
            }
        } catch (Exception unused) {
        }
    }

    public void stopListener() {
        LpCloseReceiver lpCloseReceiver;
        Context context = this.mContext;
        if (context == null || (lpCloseReceiver = this.mReceiver) == null) {
            return;
        }
        try {
            context.unregisterReceiver(lpCloseReceiver);
            this.mReceiver = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
