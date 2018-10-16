package com.baidu.searchbox.ng.ai.apps.process.binder;

import android.os.IBinder;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public final class BinderStatusHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "BinderStatusHelper";

    /* loaded from: classes2.dex */
    public interface BinderStatusCallback {
        void onBinderGone();
    }

    public static boolean listenBinderStatus(final IBinder iBinder, final BinderStatusCallback binderStatusCallback) {
        if (iBinder == null) {
            return false;
        }
        try {
            iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.baidu.searchbox.ng.ai.apps.process.binder.BinderStatusHelper.1
                @Override // android.os.IBinder.DeathRecipient
                public void binderDied() {
                    iBinder.unlinkToDeath(this, 0);
                    if (binderStatusCallback != null) {
                        binderStatusCallback.onBinderGone();
                    }
                }
            }, 0);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }
}
