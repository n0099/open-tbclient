package com.baidu.android.imsdk.chatmessage.sync;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl;
import com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.group.db.GroupMessageDAOImpl;
import com.baidu.android.imsdk.internal.Dispatcher;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public abstract class SyncStrategy {
    public static final int DEFAULT_AOUNT_EACH_FETCH = 100;
    public static final int DEFAULT_COUNT_JUMP_TO_RECENT_EACH_FETCH = 200;
    public static final int DEFAULT_LOGIN_FETCH_SLEEP_TIME = 6000;
    protected static final String FETCHED_MAX_NOTIFY_MSGID = "fetched_max_msgid";
    protected static final int FETCHING = 1;
    protected static final int IDEL = 2;
    private static final int MAX_RETRY_TIMES = 2;
    protected static final int NONE_CATEGORY = -1;
    protected static final long NONE_CONTACTER = -1;
    private static final String TAG = SyncStrategy.class.getSimpleName();
    protected static final long UNLIMITEDMSGID = Long.MAX_VALUE;
    protected Context mContext;
    protected int mTriggerReason;
    protected AtomicInteger mCount = new AtomicInteger(0);
    protected volatile boolean mPassPortSwitch = false;
    protected int mJumpToRecent = -1;
    protected int mState = 2;
    protected Object mRetryTimesSync = new Object();
    protected int mReTryTimes = 0;
    private int mAmountEachFetch = 100;
    private int mCategory = -1;
    private long mContacter = -1;

    @FunctionalInterface
    /* loaded from: classes2.dex */
    public interface CompleteListener {
        void onComplete(DialogRecord dialogRecord);
    }

    protected abstract boolean commitDeviceMaxNotifyMsgid();

    protected abstract int getJumpToRecent();

    protected abstract long getStartMsgid();

    protected abstract void updateData(Context context, long j);

    protected abstract boolean updateJumpToRecent();

    /* JADX INFO: Access modifiers changed from: protected */
    public void onComplete(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SyncStrategy setCategory(int i) {
        this.mCategory = i;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SyncStrategy setContacter(long j) {
        this.mContacter = j;
        return this;
    }

    public void start(int i) {
        LogUtils.d(TAG, "******************start sync !************** " + this.mState);
        ChatMessageDBManager.getInstance(this.mContext).getMaxMsgid();
        this.mPassPortSwitch = false;
        if (this.mState != 1) {
            synchronized (this.mRetryTimesSync) {
                this.mReTryTimes = 0;
            }
            this.mTriggerReason = i;
            LogUtils.d(TAG, "----start sync category:" + this.mCategory + " contacter:" + this.mContacter);
            sync(this.mContext, true, -1L);
        }
    }

    public void start(int i, long j) {
        LogUtils.d(TAG, "******************start sync !************** " + this.mState);
        ChatMessageDBManager.getInstance(this.mContext).getMaxMsgid();
        this.mPassPortSwitch = false;
        if (this.mState != 1) {
            synchronized (this.mRetryTimesSync) {
                this.mReTryTimes = 0;
            }
            this.mTriggerReason = i;
            LogUtils.d(TAG, "----start sync category:" + this.mCategory + " contacter:" + this.mContacter);
            sync(this.mContext, true, j);
        }
    }

    private void sync(Context context, boolean z, long j) {
        long j2;
        LogUtils.d(TAG, "sync state: " + this.mState);
        this.mState = 1;
        long startMsgid = getStartMsgid();
        long j3 = Long.MAX_VALUE;
        LogUtils.i(TAG, "sync startId : " + startMsgid);
        if (startMsgid < 0) {
            LogUtils.d(TAG, "sync startId state: " + this.mState);
            this.mState = 2;
        } else if (this.mPassPortSwitch) {
            LogUtils.d(TAG, "sync mPassPortSwitch state: " + this.mState);
            this.mState = 2;
            commitDeviceMaxNotifyMsgid();
        } else {
            if (j == -1 || j >= startMsgid) {
                j2 = startMsgid + 1;
            } else {
                j3 = j;
                j2 = j;
            }
            if (getJumpToRecent() == 1) {
                this.mAmountEachFetch = 200;
            } else {
                this.mAmountEachFetch = 100;
            }
            LogUtils.i(TAG, "sync startId : " + j2 + " endId : " + j3);
            ChatMsgManagerImpl.getInstance(context).fetchMsgidByMsgid(context, this.mCategory, this.mContacter, j2, j3, this.mAmountEachFetch, this.mTriggerReason, getJumpToRecent(), new IFetchMsgByIdListener() { // from class: com.baidu.android.imsdk.chatmessage.sync.SyncStrategy.1
                @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
                public void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j4, long j5, long j6, int i3, int i4, long j7, ArrayList<ChatMsg> arrayList) {
                    LogUtils.i(SyncStrategy.TAG, "onFetchMsgByIdResult errorCode: " + i + ", maxMsgid :" + j7 + ",contacter: " + j4 + ",mContacter: " + SyncStrategy.this.mContacter + ",beginId: " + j5 + ",endId: " + j6 + ",realCount : " + i4);
                    SyncStrategy.this.deal(i, i3, i4, j7, str2, arrayList, i2, j4);
                }
            });
        }
    }

    protected boolean syncNotifyMessageStopCondition(int i, int i2, int i3, ArrayList<ChatMsg> arrayList) {
        boolean z = false;
        if (arrayList == null || i != 0) {
            if (this.mReTryTimes <= 2) {
                synchronized (this.mRetryTimesSync) {
                    this.mReTryTimes++;
                }
            }
            if (this.mReTryTimes > 2 || i == 1001 || i == 1004 || i == 6) {
                z = true;
            }
            return z;
        }
        synchronized (this.mRetryTimesSync) {
            this.mReTryTimes = 0;
        }
        return i3 < i2;
    }

    public void deal(int i, int i2, int i3, long j, String str, ArrayList<ChatMsg> arrayList, int i4, long j2) {
        LogUtils.d(TAG, "deal maxMsgid" + j + " , contactor : " + j2 + ",fetchedMsgs: " + arrayList);
        if (arrayList != null && !arrayList.isEmpty()) {
            LogUtils.d(TAG, "deal size" + arrayList.size());
            LogUtils.d(TAG, "deal maxMsgid" + j + " , contactor : " + j2);
            LogUtils.d(TAG, "deal realCount" + i3);
            if (1 != i4) {
                try {
                    Dispatcher.dispatchMessage(this.mContext, this.mTriggerReason, arrayList);
                } catch (Exception e) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                    LogUtils.e(LogUtils.TAG, e.getMessage(), e);
                }
            } else if (GroupMessageDAOImpl.isActiveGroup(this.mContext, String.valueOf(j2))) {
                try {
                    Dispatcher.dispatchMessage(this.mContext, this.mTriggerReason, arrayList);
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(LogUtils.TAG, e2.getMessage(), e2);
                }
            }
        }
        updateData(this.mContext, j);
        if (i == 0) {
            updateJumpToRecent();
        } else if (i == 603 || i == 607) {
            DialogRecordDBManager.getInstance(this.mContext).delete(i4, j2);
        }
        if (syncNotifyMessageStopCondition(i, i2, i3, arrayList)) {
            commitDeviceMaxNotifyMsgid();
            onComplete(i);
            this.mState = 2;
            if ((this.mTriggerReason == 0 || this.mTriggerReason == 1) && checkNeedSendSyncCompBroadcast()) {
                SyncManager.notifySyncDone();
                sendMsgSyncCompBroadcast();
                ChatSessionManagerImpl.getInstance(this.mContext).onSyncComplete();
                return;
            }
            return;
        }
        this.mState = 1;
        commitDeviceMaxNotifyMsgid();
        if (this.mTriggerReason == 0 || this.mTriggerReason == 1) {
            LogUtils.d(TAG, "fetch msg thread sleep for 6s");
            try {
                Thread.currentThread();
                Thread.sleep(6000L);
            } catch (Exception e3) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e3)).build();
                LogUtils.d(TAG, "fetch msg thread sleep exception");
            }
            LogUtils.d(TAG, "fetch msg thread sleep end, start to fetch");
        }
        sync(this.mContext, false, -1L);
    }

    public void sendMsgSyncCompBroadcast() {
        Intent intent = new Intent();
        intent.setAction(IMConstants.MSG_SYNC_COMPLETE);
        this.mContext.sendBroadcast(intent);
        LogUtils.i(TAG, "sendMsgSyncCompBroadcast sync done!");
    }

    private boolean checkNeedSendSyncCompBroadcast() {
        return SyncGroupMessageService.getInstance().getState(this.mContext) == 1 && SyncAllMessage.getInstance(this.mContext).getState() == 1;
    }
}
