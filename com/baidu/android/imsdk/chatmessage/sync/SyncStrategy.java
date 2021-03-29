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
/* loaded from: classes.dex */
public abstract class SyncStrategy {
    public static final int DEFAULT_AOUNT_EACH_FETCH = 100;
    public static final int DEFAULT_COUNT_JUMP_TO_RECENT_EACH_FETCH = 200;
    public static final int DEFAULT_LOGIN_FETCH_SLEEP_TIME = 6000;
    public static final String FETCHED_MAX_NOTIFY_MSGID = "fetched_max_msgid";
    public static final int FETCHING = 1;
    public static final int IDEL = 2;
    public static final int MAX_RETRY_TIMES = 2;
    public static final int NONE_CATEGORY = -1;
    public static final long NONE_CONTACTER = -1;
    public static final String TAG = "SyncStrategy";
    public static final long UNLIMITEDMSGID = Long.MAX_VALUE;
    public Context mContext;
    public int mTriggerReason;
    public AtomicInteger mCount = new AtomicInteger(0);
    public volatile boolean mPassPortSwitch = false;
    public int mJumpToRecent = -1;
    public int mState = 2;
    public Object mRetryTimesSync = new Object();
    public int mReTryTimes = 0;
    public int mAmountEachFetch = 100;
    public int mCategory = -1;
    public long mContacter = -1;

    @FunctionalInterface
    /* loaded from: classes.dex */
    public interface CompleteListener {
        void onComplete(DialogRecord dialogRecord);
    }

    private boolean checkNeedSendSyncCompBroadcast() {
        return SyncGroupMessageService.getInstance().getState(this.mContext) == 1 && SyncAllMessage.getInstance(this.mContext).getState() == 1;
    }

    private void sync(Context context, boolean z, long j) {
        long j2;
        long j3;
        LogUtils.d(TAG, "sync state: " + this.mState);
        this.mState = 1;
        long startMsgid = getStartMsgid();
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
                j3 = Long.MAX_VALUE;
            } else {
                j2 = j;
                j3 = j2;
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
                    String str3 = SyncStrategy.TAG;
                    LogUtils.i(str3, "onFetchMsgByIdResult errorCode: " + i + ", maxMsgid :" + j7 + ",contacter: " + j4 + ",mContacter: " + SyncStrategy.this.mContacter + ",beginId: " + j5 + ",endId: " + j6 + ",realCount : " + i4);
                    SyncStrategy.this.deal(i, i3, i4, j7, str2, arrayList, i2, j4);
                }
            });
        }
    }

    public abstract boolean commitDeviceMaxNotifyMsgid();

    public void deal(int i, int i2, int i3, long j, String str, ArrayList<ChatMsg> arrayList, int i4, long j2) {
        String str2 = TAG;
        LogUtils.d(str2, "deal maxMsgid" + j + " , contactor : " + j2 + ",fetchedMsgs: " + arrayList);
        if (arrayList != null && !arrayList.isEmpty()) {
            String str3 = TAG;
            LogUtils.d(str3, "deal size" + arrayList.size());
            String str4 = TAG;
            LogUtils.d(str4, "deal maxMsgid" + j + " , contactor : " + j2);
            String str5 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("deal realCount");
            sb.append(i3);
            LogUtils.d(str5, sb.toString());
            if (1 != i4) {
                try {
                    Dispatcher.dispatchMessage(this.mContext, this.mTriggerReason, arrayList);
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(LogUtils.TAG, e2.getMessage(), e2);
                }
            } else if (GroupMessageDAOImpl.isActiveGroup(this.mContext, String.valueOf(j2))) {
                try {
                    Dispatcher.dispatchMessage(this.mContext, this.mTriggerReason, arrayList);
                } catch (Exception e3) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e3)).build();
                    LogUtils.e(LogUtils.TAG, e3.getMessage(), e3);
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
            int i5 = this.mTriggerReason;
            if ((i5 == 0 || i5 == 1) && checkNeedSendSyncCompBroadcast()) {
                SyncManager.notifySyncDone();
                sendMsgSyncCompBroadcast();
                ChatSessionManagerImpl.getInstance(this.mContext).onSyncComplete();
                return;
            }
            return;
        }
        this.mState = 1;
        commitDeviceMaxNotifyMsgid();
        int i6 = this.mTriggerReason;
        if (i6 == 0 || i6 == 1) {
            LogUtils.d(TAG, "fetch msg thread sleep for 6s");
            try {
                Thread.currentThread();
                Thread.sleep(6000L);
            } catch (Exception e4) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e4)).build();
                LogUtils.d(TAG, "fetch msg thread sleep exception");
            }
            LogUtils.d(TAG, "fetch msg thread sleep end, start to fetch");
        }
        sync(this.mContext, false, -1L);
    }

    public abstract int getJumpToRecent();

    public abstract long getStartMsgid();

    public void onComplete(int i) {
    }

    public void sendMsgSyncCompBroadcast() {
        Intent intent = new Intent();
        intent.setAction(IMConstants.MSG_SYNC_COMPLETE);
        this.mContext.sendBroadcast(intent);
        LogUtils.i(TAG, "sendMsgSyncCompBroadcast sync done!");
    }

    public SyncStrategy setCategory(int i) {
        this.mCategory = i;
        return this;
    }

    public SyncStrategy setContacter(long j) {
        this.mContacter = j;
        return this;
    }

    public void start(int i) {
        String str = TAG;
        LogUtils.d(str, "******************start sync !************** " + this.mState);
        ChatMessageDBManager.getInstance(this.mContext).getMaxMsgid();
        this.mPassPortSwitch = false;
        if (this.mState == 1) {
            return;
        }
        synchronized (this.mRetryTimesSync) {
            this.mReTryTimes = 0;
        }
        this.mTriggerReason = i;
        String str2 = TAG;
        LogUtils.d(str2, "----start sync category:" + this.mCategory + " contacter:" + this.mContacter);
        sync(this.mContext, true, -1L);
    }

    public boolean syncNotifyMessageStopCondition(int i, int i2, int i3, ArrayList<ChatMsg> arrayList) {
        if (arrayList != null && i == 0) {
            synchronized (this.mRetryTimesSync) {
                this.mReTryTimes = 0;
            }
            return i3 < i2;
        }
        if (this.mReTryTimes <= 2) {
            synchronized (this.mRetryTimesSync) {
                this.mReTryTimes++;
            }
        }
        return this.mReTryTimes > 2 || i == 1001 || i == 1004 || i == 6;
    }

    public abstract void updateData(Context context, long j);

    public abstract boolean updateJumpToRecent();

    public void start(int i, long j) {
        String str = TAG;
        LogUtils.d(str, "******************start sync !************** " + this.mState);
        ChatMessageDBManager.getInstance(this.mContext).getMaxMsgid();
        this.mPassPortSwitch = false;
        if (this.mState == 1) {
            return;
        }
        synchronized (this.mRetryTimesSync) {
            this.mReTryTimes = 0;
        }
        this.mTriggerReason = i;
        String str2 = TAG;
        LogUtils.d(str2, "----start sync category:" + this.mCategory + " contacter:" + this.mContacter);
        sync(this.mContext, true, j);
    }
}
