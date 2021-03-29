package com.baidu.android.imsdk.chatmessage.sync;

import android.content.Context;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
/* loaded from: classes.dex */
public class SyncAllMessage extends SyncStrategy {
    public static final String FETCHED_MAX_NOTIFY_MSGID = "fetched_max_msgid";
    public static final String TAG = "SyncAllMessage";
    public static SyncAllMessage mInstance;
    public long mMaxMsgid = -1;

    public SyncAllMessage(Context context) {
        this.mContext = context;
    }

    private long getDeviceMaxNotifyMsgid() {
        if (this.mMaxMsgid == -1) {
            Context context = this.mContext;
            this.mMaxMsgid = Utility.readLongData(context, "fetched_max_msgid" + AccountManager.getAppid(this.mContext) + AccountManager.getUid(this.mContext), -1L);
        }
        return this.mMaxMsgid;
    }

    public static SyncAllMessage getInstance(Context context) {
        synchronized (SyncAllMessage.class) {
            if (mInstance == null) {
                mInstance = new SyncAllMessage(context);
            }
        }
        return mInstance;
    }

    private void setDeviceMaxNotifyMsgid(long j) {
        String str = TAG;
        LogUtils.d(str, "deal setDeviceMaxNotifyMsgid:" + j);
        if (j > this.mMaxMsgid) {
            this.mMaxMsgid = j;
        }
    }

    public void clearCache() {
        reset();
        Context context = this.mContext;
        Utility.writeLongData(context, "fetched_max_msgid" + AccountManager.getAppid(this.mContext) + AccountManager.getUid(this.mContext), -1L);
    }

    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    public boolean commitDeviceMaxNotifyMsgid() {
        Context context = this.mContext;
        Utility.writeLongData(context, "fetched_max_msgid" + AccountManager.getAppid(this.mContext) + AccountManager.getUid(this.mContext), this.mMaxMsgid);
        this.mCount.set(0);
        return true;
    }

    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    public int getJumpToRecent() {
        if (this.mJumpToRecent == -1) {
            Context context = this.mContext;
            this.mJumpToRecent = Utility.readIntData(context, Utility.getJumpToRecentKey(context), 1);
        }
        return this.mJumpToRecent;
    }

    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    public long getStartMsgid() {
        return Math.max(0L, getDeviceMaxNotifyMsgid());
    }

    public int getState() {
        int i;
        return (this.mState == 1 && ((i = this.mTriggerReason) == 0 || i == 1)) ? 0 : 1;
    }

    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    public void onComplete(int i) {
        super.onComplete(i);
    }

    public void reset() {
        this.mMaxMsgid = -1L;
        this.mJumpToRecent = -1;
        this.mPassPortSwitch = true;
    }

    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    public void updateData(Context context, long j) {
        if (j <= 0) {
            return;
        }
        setDeviceMaxNotifyMsgid(j);
    }

    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    public boolean updateJumpToRecent() {
        if (this.mJumpToRecent != 0) {
            this.mJumpToRecent = 0;
            Context context = this.mContext;
            Utility.writeIntData(context, Utility.getJumpToRecentKey(context), this.mJumpToRecent);
            return true;
        }
        return true;
    }
}
