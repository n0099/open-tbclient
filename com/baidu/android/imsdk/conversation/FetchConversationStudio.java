package com.baidu.android.imsdk.conversation;

import android.content.Context;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.imsdk.a;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public class FetchConversationStudio {
    private static final int FETCH_INTERVAL_TIME = 1000;
    private static final int FIRST_RETRY = 0;
    private static final long FIRST_RETRY_TIME = 1000;
    private static final int MAX_RETRY_NUM = 3;
    private static final long SECOND_RETRY_TIME = 5000;
    private static final String TAG = "FetchConversationStudio";
    private static final long THIRD_RETRY_TIME = 10000;
    private long mCastId;
    private Context mContext;
    private static int PULL_COUNT = 160;
    private static long mLocalCursorMsgId = 0;
    private int mFetchNum = 0;
    private AtomicInteger mReliableFetchCount = new AtomicInteger(0);
    private AtomicBoolean mReliableFetching = new AtomicBoolean(false);
    private long mMaxMsgId = 0;
    private Runnable fetchRunnable = new Runnable() { // from class: com.baidu.android.imsdk.conversation.FetchConversationStudio.1
        @Override // java.lang.Runnable
        public void run() {
            a.mHandler.removeCallbacks(FetchConversationStudio.this.fetchRunnable);
            if (FetchConversationStudio.this.mReliableFetchCount.get() > 0) {
                FetchConversationStudio.this.mReliableFetchCount.set(0);
                if (ConversationStudioManImpl.getInstance(FetchConversationStudio.this.mContext).isReliable(FetchConversationStudio.this.mCastId)) {
                    FetchConversationStudio.this.fetchCastMsgByMsgId(false);
                    a.mHandler.postDelayed(FetchConversationStudio.this.fetchRunnable, 1000L);
                    return;
                }
                return;
            }
            LogUtils.d(FetchConversationStudio.TAG, "fetchRunnable reliableFetching reset ");
            FetchConversationStudio.this.mReliableFetching.set(false);
        }
    };
    private IFetchMsgByIdListener mFetchMsgListener = new IFetchMsgByIdListener() { // from class: com.baidu.android.imsdk.conversation.FetchConversationStudio.2
        @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
        public void onFetchMsgByIdResult(int i, String str, String str2, int i2, long j, long j2, long j3, int i3, int i4, long j4, ArrayList<ChatMsg> arrayList) {
            LogUtils.w(FetchConversationStudio.TAG, "onFetchMsgByIdResult response :" + i + ", maxMsgid :" + j4 + ", fetch :" + (arrayList != null ? Integer.valueOf(arrayList.size()) : "null") + ", real :" + i4 + ", count :" + i3 + "，  mcastId ： " + j + ", end :" + j3);
            FetchConversationStudio.this.mMaxMsgId = j3;
            if (i == 0) {
                if (i4 >= i3) {
                    a.mHandler.removeCallbacks(FetchConversationStudio.this.fetchRunnable);
                    a.mHandler.postDelayed(FetchConversationStudio.this.fetchRunnable, 1000L);
                }
            } else if (i == 1024) {
                int unused = FetchConversationStudio.PULL_COUNT = 80;
                LogUtils.e(FetchConversationStudio.TAG, "onFetchMsgByIdResult：fetch msg length over 1024*1024");
            } else if (FetchConversationStudio.this.mFetchNum == 0) {
                LogUtils.e(FetchConversationStudio.TAG, "onFetchMsgByIdResult：fetch msg failed and first retry.");
                a.mHandler.postDelayed(FetchConversationStudio.this.mReliableRunnable, 1000L);
            }
        }
    };
    private Runnable mReliableRunnable = new Runnable() { // from class: com.baidu.android.imsdk.conversation.FetchConversationStudio.3
        @Override // java.lang.Runnable
        public void run() {
            FetchConversationStudio.access$708(FetchConversationStudio.this);
            if (FetchConversationStudio.this.mFetchNum > 3) {
                FetchConversationStudio.this.mFetchNum = 0;
                a.mHandler.removeCallbacks(this);
                return;
            }
            FetchConversationStudio.this.fetchCastMsgByMsgId(false);
            a.mHandler.removeCallbacks(this);
            a.mHandler.postDelayed(this, FetchConversationStudio.this.mFetchNum != 3 ? 5000L : FetchConversationStudio.THIRD_RETRY_TIME);
        }
    };

    static /* synthetic */ int access$708(FetchConversationStudio fetchConversationStudio) {
        int i = fetchConversationStudio.mFetchNum;
        fetchConversationStudio.mFetchNum = i + 1;
        return i;
    }

    public FetchConversationStudio(Context context, long j) {
        this.mCastId = -1L;
        this.mContext = context;
        this.mCastId = j;
    }

    public long getMcastId() {
        return this.mCastId;
    }

    public void toFetch(long j) {
        if (this.mCastId > 0) {
            this.mMaxMsgId = j;
            this.mReliableFetchCount.incrementAndGet();
            if (!this.mReliableFetching.get()) {
                LogUtils.d(TAG, "begin set fetchRunnable");
                this.mReliableFetching.set(true);
                a.mHandler.removeCallbacks(this.fetchRunnable);
                a.mHandler.postDelayed(this.fetchRunnable, 1000L);
            }
        }
    }

    private void fetchCastMsg(long j, long j2, long j3) {
        ChatMsgManagerImpl.getInstance(this.mContext).fetchMsgidByMsgid(this.mContext, 4, j, j2, j3, PULL_COUNT, 2, 0, this.mFetchMsgListener, this.mFetchNum);
    }

    public void fetchCastMsgByMsgId(boolean z) {
        long longValue = Utility.getReliableMaxMsgId(this.mContext, this.mCastId).longValue();
        LogUtils.d(TAG, "sp reliableMaxMsg:" + longValue);
        if (longValue > 0) {
            mLocalCursorMsgId = longValue;
        }
        fetchCastMsg(this.mCastId, longValue, z ? Long.MAX_VALUE : this.mMaxMsgId);
    }
}
