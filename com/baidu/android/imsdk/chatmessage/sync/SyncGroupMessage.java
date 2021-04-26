package com.baidu.android.imsdk.chatmessage.sync;

import android.content.Context;
import com.baidu.android.imsdk.chatmessage.sync.SyncStrategy;
import com.baidu.android.imsdk.utils.LogUtils;
/* loaded from: classes.dex */
public class SyncGroupMessage extends SyncStrategy {
    public static final String TAG = "SyncGroupMessage";
    public SyncStrategy.CompleteListener completeListener;
    public DialogRecord mDialogRecord;

    public SyncGroupMessage(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    public boolean commitDeviceMaxNotifyMsgid() {
        if (DialogRecordDBManager.getInstance(this.mContext).add(this.mDialogRecord) >= 0) {
            return true;
        }
        LogUtils.e(TAG, "add dailogRecord exception!!");
        return false;
    }

    public long getContacter() {
        return this.mDialogRecord.getContacter();
    }

    public DialogRecord getDialogRecord() {
        return this.mDialogRecord;
    }

    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    public int getJumpToRecent() {
        return this.mDialogRecord.getJumpToRecent();
    }

    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    public long getStartMsgid() {
        return this.mDialogRecord.getMaxMsgid();
    }

    public int getState() {
        return this.mState;
    }

    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    public void onComplete(int i2) {
        String str = TAG;
        LogUtils.d(str, "SYNCGROUP complete code is " + i2);
        SyncStrategy.CompleteListener completeListener = this.completeListener;
        if (completeListener != null) {
            completeListener.onComplete(this.mDialogRecord);
        }
    }

    public void setCompleteListener(SyncStrategy.CompleteListener completeListener) {
        this.completeListener = completeListener;
    }

    public void setDialogRecord(DialogRecord dialogRecord) {
        String str = TAG;
        LogUtils.d(str, "state: " + this.mState + "old dialog record : " + this.mDialogRecord);
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("new dialog record : ");
        sb.append(dialogRecord);
        LogUtils.d(str2, sb.toString());
        this.mDialogRecord = dialogRecord;
        setCategory(dialogRecord.getCategory());
        setContacter(dialogRecord.getContacter());
        this.mReTryTimes = 0;
    }

    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    public void updateData(Context context, long j) {
        String str = TAG;
        LogUtils.i(str, "updateData : " + j);
        if (j < 0) {
            return;
        }
        this.mDialogRecord.setMaxMsgid(j);
    }

    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    public boolean updateJumpToRecent() {
        this.mDialogRecord.setJumpToRecent(0);
        return true;
    }
}
