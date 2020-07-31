package com.baidu.android.imsdk.chatmessage.sync;

import android.content.Context;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
/* loaded from: classes3.dex */
public class SyncAllMessage extends SyncStrategy {
    public static final String FETCHED_MAX_NOTIFY_MSGID = "fetched_max_msgid";
    private static final String TAG = SyncAllMessage.class.getSimpleName();
    private static SyncAllMessage mInstance;
    private long mMaxMsgid = -1;

    private SyncAllMessage(Context context) {
        this.mContext = context;
    }

    public static SyncAllMessage getInstance(Context context) {
        synchronized (SyncAllMessage.class) {
            if (mInstance == null) {
                mInstance = new SyncAllMessage(context);
            }
        }
        return mInstance;
    }

    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    protected long getStartMsgid() {
        return Math.max(0L, getDeviceMaxNotifyMsgid());
    }

    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    public void updateData(Context context, long j) {
        if (j > 0) {
            setDeviceMaxNotifyMsgid(j);
        }
    }

    private long getDeviceMaxNotifyMsgid() {
        if (this.mMaxMsgid == -1) {
            this.mMaxMsgid = Utility.readLongData(this.mContext, FETCHED_MAX_NOTIFY_MSGID + AccountManager.getAppid(this.mContext) + AccountManager.getUid(this.mContext), -1L);
        }
        return this.mMaxMsgid;
    }

    private void setDeviceMaxNotifyMsgid(long j) {
        LogUtils.d(TAG, "deal setDeviceMaxNotifyMsgid:" + j);
        if (j > this.mMaxMsgid) {
            this.mMaxMsgid = j;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    protected boolean commitDeviceMaxNotifyMsgid() {
        boolean writeLongData = Utility.writeLongData(this.mContext, FETCHED_MAX_NOTIFY_MSGID + AccountManager.getAppid(this.mContext) + AccountManager.getUid(this.mContext), this.mMaxMsgid);
        if (writeLongData) {
            this.mCount.set(0);
        }
        return writeLongData;
    }

    public void reset() {
        this.mMaxMsgid = -1L;
        this.mJumpToRecent = -1;
        this.mPassPortSwitch = true;
    }

    public void clearCache() {
        reset();
        Utility.writeLongData(this.mContext, FETCHED_MAX_NOTIFY_MSGID + AccountManager.getAppid(this.mContext) + AccountManager.getUid(this.mContext), -1L);
    }

    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    protected int getJumpToRecent() {
        if (this.mJumpToRecent == -1) {
            this.mJumpToRecent = Utility.readIntData(this.mContext, Utility.getJumpToRecentKey(this.mContext), 1);
        }
        return this.mJumpToRecent;
    }

    public int getState() {
        if (this.mState == 1) {
            return (this.mTriggerReason == 0 || this.mTriggerReason == 1) ? 0 : 1;
        }
        return 1;
    }

    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    protected boolean updateJumpToRecent() {
        if (this.mJumpToRecent != 0) {
            this.mJumpToRecent = 0;
            return Utility.writeIntData(this.mContext, Utility.getJumpToRecentKey(this.mContext), this.mJumpToRecent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    public void onComplete(int i) {
        super.onComplete(i);
    }
}
