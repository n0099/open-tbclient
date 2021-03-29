package com.baidu.android.imsdk.conversation;

import android.content.Context;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import d.b.r.a;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class FetchConversationStudio {
    public static final int FETCH_INTERVAL_TIME = 1000;
    public static final int FIRST_RETRY = 0;
    public static final long FIRST_RETRY_TIME = 1000;
    public static final int MAX_RETRY_NUM = 3;
    public static int PULL_COUNT = 160;
    public static final long SECOND_RETRY_TIME = 5000;
    public static final String TAG = "FetchConversationStudio";
    public static final long THIRD_RETRY_TIME = 10000;
    public static long mLocalCursorMsgId;
    public long mCastId;
    public Context mContext;
    public int mFetchNum = 0;
    public AtomicInteger mReliableFetchCount = new AtomicInteger(0);
    public AtomicBoolean mReliableFetching = new AtomicBoolean(false);
    public long mMaxMsgId = 0;
    public Runnable fetchRunnable = new Runnable() { // from class: com.baidu.android.imsdk.conversation.FetchConversationStudio.1
        @Override // java.lang.Runnable
        public void run() {
            a.f64550c.removeCallbacks(FetchConversationStudio.this.fetchRunnable);
            if (FetchConversationStudio.this.mReliableFetchCount.get() > 0) {
                FetchConversationStudio.this.mReliableFetchCount.set(0);
                if (ConversationStudioManImpl.getInstance(FetchConversationStudio.this.mContext).isReliable(FetchConversationStudio.this.mCastId)) {
                    FetchConversationStudio.this.fetchCastMsgByMsgId();
                    a.f64550c.postDelayed(FetchConversationStudio.this.fetchRunnable, 1000L);
                    return;
                }
                return;
            }
            LogUtils.d(FetchConversationStudio.TAG, "fetchRunnable reliableFetching reset ");
            FetchConversationStudio.this.mReliableFetching.set(false);
        }
    };
    public IFetchMsgByIdListener mFetchMsgListener = new IFetchMsgByIdListener() { // from class: com.baidu.android.imsdk.conversation.FetchConversationStudio.2
        @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
        public void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j, long j2, long j3, int i3, int i4, long j4, ArrayList<ChatMsg> arrayList) {
            StringBuilder sb = new StringBuilder();
            sb.append("onFetchMsgByIdResult response :");
            sb.append(i);
            sb.append(", maxMsgid :");
            sb.append(j4);
            sb.append(", fetch :");
            sb.append(arrayList != null ? Integer.valueOf(arrayList.size()) : StringUtil.NULL_STRING);
            sb.append(", real :");
            sb.append(i4);
            sb.append(", count :");
            sb.append(i3);
            sb.append("，  mcastId ： ");
            sb.append(j);
            sb.append(", end :");
            sb.append(j3);
            LogUtils.w(FetchConversationStudio.TAG, sb.toString());
            FetchConversationStudio.this.mMaxMsgId = j3;
            if (i == 0) {
                if (i4 >= i3) {
                    a.f64550c.removeCallbacks(FetchConversationStudio.this.fetchRunnable);
                    a.f64550c.postDelayed(FetchConversationStudio.this.fetchRunnable, 1000L);
                }
            } else if (i == 1024) {
                int unused = FetchConversationStudio.PULL_COUNT = 80;
                LogUtils.e(FetchConversationStudio.TAG, "onFetchMsgByIdResult：fetch msg length over 1024*1024");
            } else if (FetchConversationStudio.this.mFetchNum == 0) {
                LogUtils.e(FetchConversationStudio.TAG, "onFetchMsgByIdResult：fetch msg failed and first retry.");
                a.f64550c.postDelayed(FetchConversationStudio.this.mReliableRunnable, 1000L);
            }
        }
    };
    public Runnable mReliableRunnable = new Runnable() { // from class: com.baidu.android.imsdk.conversation.FetchConversationStudio.3
        @Override // java.lang.Runnable
        public void run() {
            FetchConversationStudio.access$708(FetchConversationStudio.this);
            if (FetchConversationStudio.this.mFetchNum > 3) {
                FetchConversationStudio.this.mFetchNum = 0;
                a.f64550c.removeCallbacks(this);
                return;
            }
            FetchConversationStudio.this.fetchCastMsgByMsgId();
            a.f64550c.removeCallbacks(this);
            a.f64550c.postDelayed(this, FetchConversationStudio.this.mFetchNum != 3 ? 5000L : 10000L);
        }
    };

    public FetchConversationStudio(Context context, long j) {
        this.mCastId = -1L;
        this.mContext = context;
        this.mCastId = j;
    }

    public static /* synthetic */ int access$708(FetchConversationStudio fetchConversationStudio) {
        int i = fetchConversationStudio.mFetchNum;
        fetchConversationStudio.mFetchNum = i + 1;
        return i;
    }

    private void fetchCastMsg(long j, long j2, long j3) {
        ChatMsgManagerImpl.getInstance(this.mContext).fetchMsgidByMsgid(this.mContext, 4, j, j2, j3, PULL_COUNT, 2, 0, this.mFetchMsgListener, this.mFetchNum);
    }

    public void fetchCastMsgByMsgId() {
        long longValue = Utility.getReliableMaxMsgId(this.mContext, this.mCastId).longValue();
        LogUtils.d(TAG, "sp reliableMaxMsg:" + longValue);
        if (longValue > 0) {
            mLocalCursorMsgId = longValue;
        }
        fetchCastMsg(this.mCastId, longValue + 1, Long.MAX_VALUE);
    }

    public long getMcastId() {
        return this.mCastId;
    }

    public void toFetch(long j) {
        if (this.mCastId <= 0) {
            return;
        }
        this.mMaxMsgId = j;
        this.mReliableFetchCount.incrementAndGet();
        if (this.mReliableFetching.get()) {
            return;
        }
        LogUtils.d(TAG, "begin set fetchRunnable");
        this.mReliableFetching.set(true);
        a.f64550c.removeCallbacks(this.fetchRunnable);
        a.f64550c.postDelayed(this.fetchRunnable, 1000L);
    }
}
