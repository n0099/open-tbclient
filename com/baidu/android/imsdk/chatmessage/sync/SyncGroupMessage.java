package com.baidu.android.imsdk.chatmessage.sync;

import android.content.Context;
import com.baidu.android.imsdk.chatmessage.sync.SyncStrategy;
import com.baidu.android.imsdk.utils.LogUtils;
/* loaded from: classes4.dex */
public class SyncGroupMessage extends SyncStrategy {
    public static final String TAG = SyncGroupMessage.class.getSimpleName();
    private SyncStrategy.CompleteListener completeListener;
    private DialogRecord mDialogRecord;

    public SyncGroupMessage(Context context) {
        this.mContext = context;
    }

    public long getContacter() {
        return this.mDialogRecord.getContacter();
    }

    public DialogRecord getDialogRecord() {
        return this.mDialogRecord;
    }

    public void setDialogRecord(DialogRecord dialogRecord) {
        LogUtils.d(TAG, "state: " + this.mState + "old dialog record : " + this.mDialogRecord);
        LogUtils.d(TAG, "new dialog record : " + dialogRecord);
        this.mDialogRecord = dialogRecord;
        setCategory(dialogRecord.getCategory());
        setContacter(dialogRecord.getContacter());
        this.mReTryTimes = 0;
    }

    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    protected int getJumpToRecent() {
        return this.mDialogRecord.getJumpToRecent();
    }

    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    protected long getStartMsgid() {
        return this.mDialogRecord.getMaxMsgid();
    }

    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    protected boolean commitDeviceMaxNotifyMsgid() {
        if (DialogRecordDBManager.getInstance(this.mContext).add(this.mDialogRecord) >= 0) {
            return true;
        }
        LogUtils.e(TAG, "add dailogRecord exception!!");
        return false;
    }

    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    protected void updateData(Context context, long j) {
        LogUtils.i(TAG, "updateData : " + j);
        if (j >= 0) {
            this.mDialogRecord.setMaxMsgid(j);
        }
    }

    public int getState() {
        return this.mState;
    }

    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    protected boolean updateJumpToRecent() {
        this.mDialogRecord.setJumpToRecent(0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    public void onComplete(int i) {
        LogUtils.d(TAG, "SYNCGROUP complete code is " + i);
        if (this.completeListener != null) {
            this.completeListener.onComplete(this.mDialogRecord);
        }
    }

    public void setCompleteListener(SyncStrategy.CompleteListener completeListener) {
        this.completeListener = completeListener;
    }
}
