package com.baidu.searchbox.ng.ai.apps.core.aps;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public final class AiAppsAPSStatusSync {
    private static final boolean DEBUG = false;
    private static final String TAG = "AiAppsAPSStatusSync";
    private static AiAppsAPSStatusSync sInstance;
    private HashMap<String, APSStatus> mStatusHashMap = new HashMap<>();
    private HashMap<String, Set<OnCompleteListener>> mListenerHashMap = new HashMap<>();

    /* loaded from: classes2.dex */
    public interface OnCompleteListener {
        void onDownloadComplete(String str);
    }

    private AiAppsAPSStatusSync() {
    }

    public static AiAppsAPSStatusSync getInstance() {
        if (sInstance == null) {
            synchronized (AiAppsAPSStatusSync.class) {
                if (sInstance == null) {
                    sInstance = new AiAppsAPSStatusSync();
                }
            }
        }
        return sInstance;
    }

    public synchronized void aiAppPreDownloadFailed(String str) {
        if (!TextUtils.isEmpty(str)) {
            APSStatus aPSStatus = new APSStatus(2, 1);
            if (this.mStatusHashMap != null) {
                this.mStatusHashMap.put(str, aPSStatus);
            }
            if (this.mListenerHashMap != null) {
                this.mListenerHashMap.remove(str);
            }
        }
    }

    public synchronized void aiAppPreDownloadFinish(String str) {
        if (!TextUtils.isEmpty(str)) {
            APSStatus aPSStatus = new APSStatus(2, 0);
            if (this.mStatusHashMap != null) {
                this.mStatusHashMap.put(str, aPSStatus);
            }
            if (this.mListenerHashMap != null) {
                Set<OnCompleteListener> set = this.mListenerHashMap.get(str);
                if (set != null) {
                    for (OnCompleteListener onCompleteListener : set) {
                        if (onCompleteListener != null) {
                            onCompleteListener.onDownloadComplete(str);
                        }
                    }
                }
                this.mListenerHashMap.remove(str);
            }
        }
    }

    public synchronized void registerStatusListener(String str, OnCompleteListener onCompleteListener) {
        APSStatus aPSStatus;
        if (!TextUtils.isEmpty(str) && onCompleteListener != null) {
            if (this.mStatusHashMap != null && (aPSStatus = this.mStatusHashMap.get(str)) != null && aPSStatus.mStatus == 0) {
                onCompleteListener.onDownloadComplete(str);
            } else if (this.mListenerHashMap != null) {
                Set<OnCompleteListener> set = this.mListenerHashMap.get(str);
                if (set == null) {
                    set = new HashSet<>();
                }
                set.add(onCompleteListener);
                this.mListenerHashMap.put(str, set);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class APSStatus {
        public static final int STATUS_COMPLETE = 0;
        public static final int STATUS_FAILED = 1;
        public static final int TYPE_LAUNCH = 0;
        public static final int TYPE_LAUNCH_ASYNC = 1;
        public static final int TYPE_PRE_DOWNLOAD = 2;
        public int mStatus;
        public int mType;

        public APSStatus(int i, int i2) {
            this.mType = i;
            this.mStatus = i2;
        }
    }
}
