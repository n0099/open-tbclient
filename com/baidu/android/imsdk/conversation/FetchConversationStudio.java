package com.baidu.android.imsdk.conversation;

import android.content.Context;
import android.os.Handler;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.tieba.h70;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class FetchConversationStudio {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FETCH_INTERVAL_TIME = 1000;
    public static final int FIRST_RETRY = 0;
    public static final long FIRST_RETRY_TIME = 1000;
    public static final int MAX_RETRY_NUM = 3;
    public static int PULL_COUNT = 160;
    public static final long SECOND_RETRY_TIME = 5000;
    public static final String TAG = "FetchConversationStudio";
    public static final long THIRD_RETRY_TIME = 10000;
    public static long mLocalCursorMsgId;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable fetchRunnable;
    public long mCastId;
    public Context mContext;
    public IFetchMsgByIdListener mFetchMsgListener;
    public int mFetchNum;
    public long mMaxMsgId;
    public AtomicInteger mReliableFetchCount;
    public AtomicBoolean mReliableFetching;
    public Runnable mReliableRunnable;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1144125965, "Lcom/baidu/android/imsdk/conversation/FetchConversationStudio;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1144125965, "Lcom/baidu/android/imsdk/conversation/FetchConversationStudio;");
        }
    }

    public FetchConversationStudio(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mFetchNum = 0;
        this.mReliableFetchCount = new AtomicInteger(0);
        this.mReliableFetching = new AtomicBoolean(false);
        this.mCastId = -1L;
        this.mMaxMsgId = 0L;
        this.fetchRunnable = new Runnable(this) { // from class: com.baidu.android.imsdk.conversation.FetchConversationStudio.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FetchConversationStudio this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    h70.c.removeCallbacks(this.this$0.fetchRunnable);
                    if (this.this$0.mReliableFetchCount.get() > 0) {
                        this.this$0.mReliableFetchCount.set(0);
                        if (ConversationStudioManImpl.getInstance(this.this$0.mContext).isReliable(this.this$0.mCastId)) {
                            this.this$0.fetchCastMsgByMsgId();
                            h70.c.postDelayed(this.this$0.fetchRunnable, 1000L);
                            return;
                        }
                        return;
                    }
                    LogUtils.d(FetchConversationStudio.TAG, "fetchRunnable reliableFetching reset ");
                    this.this$0.mReliableFetching.set(false);
                }
            }
        };
        this.mFetchMsgListener = new IFetchMsgByIdListener(this) { // from class: com.baidu.android.imsdk.conversation.FetchConversationStudio.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FetchConversationStudio this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
            public void onFetchMsgByIdResult(int i3, String str, String str2, int i4, long j2, long j3, long j4, int i5, int i6, long j5, ArrayList<ChatMsg> arrayList) {
                Object obj;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i3), str, str2, Integer.valueOf(i4), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i5), Integer.valueOf(i6), Long.valueOf(j5), arrayList}) == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onFetchMsgByIdResult response :");
                    sb.append(i3);
                    sb.append(", maxMsgid :");
                    sb.append(j5);
                    sb.append(", fetch :");
                    if (arrayList != null) {
                        obj = Integer.valueOf(arrayList.size());
                    } else {
                        obj = StringUtil.NULL_STRING;
                    }
                    sb.append(obj);
                    sb.append(", real :");
                    sb.append(i6);
                    sb.append(", count :");
                    sb.append(i5);
                    sb.append("，  mcastId ： ");
                    sb.append(j2);
                    sb.append(", end :");
                    sb.append(j4);
                    LogUtils.w(FetchConversationStudio.TAG, sb.toString());
                    this.this$0.mMaxMsgId = j4;
                    if (i3 == 0) {
                        if (i6 >= i5) {
                            h70.c.removeCallbacks(this.this$0.fetchRunnable);
                            h70.c.postDelayed(this.this$0.fetchRunnable, 1000L);
                        }
                    } else if (i3 == 1024) {
                        int unused = FetchConversationStudio.PULL_COUNT = 80;
                        LogUtils.e(FetchConversationStudio.TAG, "onFetchMsgByIdResult：fetch msg length over 1024*1024");
                    } else if (this.this$0.mFetchNum == 0) {
                        LogUtils.e(FetchConversationStudio.TAG, "onFetchMsgByIdResult：fetch msg failed and first retry.");
                        h70.c.postDelayed(this.this$0.mReliableRunnable, 1000L);
                    }
                }
            }
        };
        this.mReliableRunnable = new Runnable(this) { // from class: com.baidu.android.imsdk.conversation.FetchConversationStudio.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FetchConversationStudio this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    FetchConversationStudio.access$708(this.this$0);
                    if (this.this$0.mFetchNum <= 3) {
                        this.this$0.fetchCastMsgByMsgId();
                        h70.c.removeCallbacks(this);
                        Handler handler = h70.c;
                        if (this.this$0.mFetchNum != 3) {
                            j2 = 5000;
                        } else {
                            j2 = 10000;
                        }
                        handler.postDelayed(this, j2);
                        return;
                    }
                    this.this$0.mFetchNum = 0;
                    h70.c.removeCallbacks(this);
                }
            }
        };
        this.mContext = context;
        this.mCastId = j;
    }

    public static /* synthetic */ int access$708(FetchConversationStudio fetchConversationStudio) {
        int i = fetchConversationStudio.mFetchNum;
        fetchConversationStudio.mFetchNum = i + 1;
        return i;
    }

    private void fetchCastMsg(long j, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            ChatMsgManagerImpl.getInstance(this.mContext).fetchMsgidByMsgid(this.mContext, 4, j, j2, j3, -1L, -1L, "", PULL_COUNT, 2, 0, this.mFetchMsgListener, this.mFetchNum);
        }
    }

    public void fetchCastMsgByMsgId() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long longValue = Utility.getReliableMaxMsgId(this.mContext, this.mCastId).longValue();
            LogUtils.d(TAG, "sp reliableMaxMsg:" + longValue);
            if (longValue > 0) {
                mLocalCursorMsgId = longValue;
            }
            fetchCastMsg(this.mCastId, longValue + 1, Long.MAX_VALUE);
        }
    }

    public long getMcastId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mCastId;
        }
        return invokeV.longValue;
    }

    public void toFetch(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) != null) || this.mCastId <= 0) {
            return;
        }
        this.mMaxMsgId = j;
        this.mReliableFetchCount.incrementAndGet();
        if (!this.mReliableFetching.get()) {
            LogUtils.d(TAG, "begin set fetchRunnable");
            this.mReliableFetching.set(true);
            h70.c.removeCallbacks(this.fetchRunnable);
            h70.c.postDelayed(this.fetchRunnable, 1000L);
        }
    }
}
