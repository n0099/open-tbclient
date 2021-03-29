package com.baidu.android.imsdk.chatmessage.sync;

import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class SyncManager {
    public static boolean sSyncDone = false;
    public static ArrayList<ISyncStateListener> sSyncStateListeners = new ArrayList<>();

    public static Boolean isSyncDone() {
        return Boolean.valueOf(sSyncDone);
    }

    public static synchronized void notifySyncDone() {
        synchronized (SyncManager.class) {
            sSyncDone = true;
            Iterator<ISyncStateListener> it = sSyncStateListeners.iterator();
            while (it.hasNext()) {
                it.next().onSyncDone();
            }
            sSyncStateListeners.clear();
        }
    }

    public static synchronized void registerSyncStateListener(ISyncStateListener iSyncStateListener) {
        synchronized (SyncManager.class) {
            if (iSyncStateListener != null) {
                if (sSyncDone) {
                    iSyncStateListener.onSyncDone();
                } else if (!sSyncStateListeners.contains(iSyncStateListener)) {
                    sSyncStateListeners.add(iSyncStateListener);
                }
            }
        }
    }
}
