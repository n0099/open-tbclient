package com.baidu.android.imsdk.chatmessage.sync;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl;
import com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.group.db.GroupMessageDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.Dispatcher;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public abstract class SyncStrategy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_AOUNT_EACH_FETCH = 100;
    public static final int DEFAULT_COUNT_JUMP_TO_RECENT_EACH_FETCH = 200;
    public static final int DEFAULT_LOGIN_FETCH_SLEEP_TIME = 6000;
    public static final int FETCHING = 1;
    public static final int IDEL = 2;
    public static final int MAX_RETRY_TIMES = 2;
    public static final int NONE_CATEGORY = -1;
    public static final long NONE_CONTACTER = -1;
    public static final String TAG = "SyncStrategy";
    public static final long UNLIMITEDMSGID = Long.MAX_VALUE;
    public transient /* synthetic */ FieldHolder $fh;
    public int mAmountEachFetch;
    public int mCategory;
    public long mContacter;
    public Context mContext;
    public AtomicInteger mCount;
    public int mJumpToRecent;
    public volatile boolean mPassPortSwitch;
    public int mReTryTimes;
    public Object mRetryTimesSync;
    public int mState;
    public int mTriggerReason;

    @FunctionalInterface
    /* loaded from: classes8.dex */
    public interface CompleteListener {
        void onComplete(DialogRecord dialogRecord);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1924810976, "Lcom/baidu/android/imsdk/chatmessage/sync/SyncStrategy;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1924810976, "Lcom/baidu/android/imsdk/chatmessage/sync/SyncStrategy;");
        }
    }

    public SyncStrategy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mCount = new AtomicInteger(0);
        this.mPassPortSwitch = false;
        this.mJumpToRecent = -1;
        this.mState = 2;
        this.mRetryTimesSync = new Object();
        this.mReTryTimes = 0;
        this.mAmountEachFetch = 100;
        this.mCategory = -1;
        this.mContacter = -1L;
    }

    private boolean checkNeedSendSyncCompBroadcast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? SyncGroupMessageService.getInstance().getState(this.mContext) == 1 && SyncAllMessage.getInstance(this.mContext).getState() == 1 : invokeV.booleanValue;
    }

    private void sync(Context context, boolean z, long j2) {
        long j3;
        long j4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{context, Boolean.valueOf(z), Long.valueOf(j2)}) == null) {
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
                if (j2 == -1 || j2 >= startMsgid) {
                    j3 = startMsgid + 1;
                    j4 = Long.MAX_VALUE;
                } else {
                    j3 = j2;
                    j4 = j3;
                }
                if (getJumpToRecent() == 1) {
                    this.mAmountEachFetch = 200;
                } else {
                    this.mAmountEachFetch = 100;
                }
                LogUtils.i(TAG, "sync startId : " + j3 + " endId : " + j4);
                ChatMsgManagerImpl.getInstance(context).fetchMsgidByMsgid(context, this.mCategory, this.mContacter, j3, j4, this.mAmountEachFetch, this.mTriggerReason, getJumpToRecent(), new IFetchMsgByIdListener(this) { // from class: com.baidu.android.imsdk.chatmessage.sync.SyncStrategy.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SyncStrategy this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
                    public void onFetchMsgByIdResult(int i2, String str, String str2, int i3, long j5, long j6, long j7, int i4, int i5, long j8, ArrayList<ChatMsg> arrayList) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, str2, Integer.valueOf(i3), Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7), Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(j8), arrayList}) == null) {
                            String str3 = SyncStrategy.TAG;
                            LogUtils.i(str3, "onFetchMsgByIdResult errorCode: " + i2 + ", maxMsgid :" + j8 + ",contacter: " + j5 + ",mContacter: " + this.this$0.mContacter + ",beginId: " + j6 + ",endId: " + j7 + ",realCount : " + i5);
                            this.this$0.deal(i2, i4, i5, j8, str2, arrayList, i3, j5);
                        }
                    }
                });
            }
        }
    }

    public abstract boolean commitDeviceMaxNotifyMsgid();

    public void deal(int i2, int i3, int i4, long j2, String str, ArrayList<ChatMsg> arrayList, int i5, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j2), str, arrayList, Integer.valueOf(i5), Long.valueOf(j3)}) == null) {
            String str2 = TAG;
            LogUtils.d(str2, "deal maxMsgid" + j2 + " , contactor : " + j3 + ",fetchedMsgs: " + arrayList);
            if (arrayList != null && !arrayList.isEmpty()) {
                String str3 = TAG;
                LogUtils.d(str3, "deal size" + arrayList.size());
                String str4 = TAG;
                LogUtils.d(str4, "deal maxMsgid" + j2 + " , contactor : " + j3);
                String str5 = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("deal realCount");
                sb.append(i4);
                LogUtils.d(str5, sb.toString());
                if (1 != i5) {
                    try {
                        Dispatcher.dispatchMessage(this.mContext, this.mTriggerReason, arrayList);
                    } catch (Exception e2) {
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                        LogUtils.e(LogUtils.TAG, e2.getMessage(), e2);
                    }
                } else if (GroupMessageDAOImpl.isActiveGroup(this.mContext, String.valueOf(j3))) {
                    try {
                        Dispatcher.dispatchMessage(this.mContext, this.mTriggerReason, arrayList);
                    } catch (Exception e3) {
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e3)).build();
                        LogUtils.e(LogUtils.TAG, e3.getMessage(), e3);
                    }
                }
            }
            updateData(this.mContext, j2);
            if (i2 == 0) {
                updateJumpToRecent();
            } else if (i2 == 603 || i2 == 607) {
                DialogRecordDBManager.getInstance(this.mContext).delete(i5, j3);
            }
            if (syncNotifyMessageStopCondition(i2, i3, i4, arrayList)) {
                commitDeviceMaxNotifyMsgid();
                onComplete(i2);
                this.mState = 2;
                int i6 = this.mTriggerReason;
                if ((i6 == 0 || i6 == 1) && checkNeedSendSyncCompBroadcast()) {
                    SyncManager.notifySyncDone();
                    sendMsgSyncCompBroadcast();
                    ChatSessionManagerImpl.getInstance(this.mContext).onSyncComplete();
                    return;
                }
                return;
            }
            this.mState = 1;
            commitDeviceMaxNotifyMsgid();
            int i7 = this.mTriggerReason;
            if (i7 == 0 || i7 == 1) {
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
    }

    public abstract int getJumpToRecent();

    public abstract long getStartMsgid();

    public void onComplete(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
        }
    }

    public void sendMsgSyncCompBroadcast() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Intent intent = new Intent();
            intent.setAction(IMConstants.MSG_SYNC_COMPLETE);
            this.mContext.sendBroadcast(intent);
            LogUtils.i(TAG, "sendMsgSyncCompBroadcast sync done!");
        }
    }

    public SyncStrategy setCategory(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            this.mCategory = i2;
            return this;
        }
        return (SyncStrategy) invokeI.objValue;
    }

    public SyncStrategy setContacter(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j2)) == null) {
            this.mContacter = j2;
            return this;
        }
        return (SyncStrategy) invokeJ.objValue;
    }

    public void start(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
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
            this.mTriggerReason = i2;
            String str2 = TAG;
            LogUtils.d(str2, "----start sync category:" + this.mCategory + " contacter:" + this.mContacter);
            sync(this.mContext, true, -1L);
        }
    }

    public boolean syncNotifyMessageStopCondition(int i2, int i3, int i4, ArrayList<ChatMsg> arrayList) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), arrayList})) == null) {
            if (arrayList != null && i2 == 0) {
                synchronized (this.mRetryTimesSync) {
                    this.mReTryTimes = 0;
                }
                return i4 < i3;
            }
            if (this.mReTryTimes <= 2) {
                synchronized (this.mRetryTimesSync) {
                    this.mReTryTimes++;
                }
            }
            return this.mReTryTimes > 2 || i2 == 1001 || i2 == 1004 || i2 == 6;
        }
        return invokeCommon.booleanValue;
    }

    public abstract void updateData(Context context, long j2);

    public abstract boolean updateJumpToRecent();

    public void start(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
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
            this.mTriggerReason = i2;
            String str2 = TAG;
            LogUtils.d(str2, "----start sync category:" + this.mCategory + " contacter:" + this.mContacter);
            sync(this.mContext, true, j2);
        }
    }
}
