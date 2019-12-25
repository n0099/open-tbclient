package com.baidu.live.tbadk.util;

import android.util.SparseArray;
/* loaded from: classes2.dex */
public class ChatStatusManager {
    public static final int GROUP_CHAT = 2;
    public static final int OFFICIALBAR_CHAT = 1;
    public static final int OFFICIAL_MERGE = 4;
    public static final int PERSONAL_CHAT = 0;
    public static final int STRANGER_MERGE = 5;
    public static final int UPDATES = 6;
    public static final int VALIDATE = 7;
    private static ChatStatusManager instance;
    private SparseArray<ActivityStatus> mStatus = new SparseArray<>();

    /* loaded from: classes2.dex */
    public static class ActivityStatus {
        public String curId;
        public boolean isOpen;
    }

    public static synchronized ChatStatusManager getInst() {
        ChatStatusManager chatStatusManager;
        synchronized (ChatStatusManager.class) {
            if (instance == null) {
                instance = new ChatStatusManager();
            }
            chatStatusManager = instance;
        }
        return chatStatusManager;
    }

    public boolean getIsOpen(int i) {
        ActivityStatus activityStatus = this.mStatus.get(i);
        if (activityStatus == null) {
            return false;
        }
        return activityStatus.isOpen;
    }

    public String getCurId(int i) {
        ActivityStatus activityStatus = this.mStatus.get(i);
        if (activityStatus == null) {
            return "";
        }
        return activityStatus.curId;
    }

    public void setIsOpen(int i, boolean z) {
        ActivityStatus activityStatus = this.mStatus.get(i);
        if (activityStatus != null) {
            activityStatus.isOpen = z;
            return;
        }
        ActivityStatus activityStatus2 = new ActivityStatus();
        activityStatus2.isOpen = z;
        this.mStatus.put(i, activityStatus2);
    }

    public void setCurId(int i, String str) {
        ActivityStatus activityStatus = this.mStatus.get(i);
        if (activityStatus != null) {
            activityStatus.curId = str;
            return;
        }
        ActivityStatus activityStatus2 = new ActivityStatus();
        activityStatus2.curId = str;
        this.mStatus.put(i, activityStatus2);
    }

    public void remove(int i) {
        this.mStatus.delete(i);
    }
}
