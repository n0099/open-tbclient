package com.baidu.android.imsdk.chatmessage.sync;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.GroupMemberDelMsg;
import com.baidu.android.imsdk.group.db.GroupMessageDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.Dispatcher;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
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
    /* loaded from: classes.dex */
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

    public abstract boolean commitDeviceMaxNotifyMsgid();

    public abstract int getJumpToRecent();

    public abstract long getStartMsgid();

    public void onComplete(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
        }
    }

    public abstract void updateData(Context context, long j);

    public abstract boolean updateJumpToRecent();

    public SyncStrategy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (SyncGroupMessageService.getInstance().getState(this.mContext) == 1 && SyncAllMessage.getInstance(this.mContext).getState() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void resetFetchState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mState = 2;
        }
    }

    public SyncStrategy setCategory(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            this.mCategory = i;
            return this;
        }
        return (SyncStrategy) invokeI.objValue;
    }

    public SyncStrategy setContacter(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
            this.mContacter = j;
            return this;
        }
        return (SyncStrategy) invokeJ.objValue;
    }

    private boolean isMaxNotifyMsgIdSaveAble(int i, ArrayList<ChatMsg> arrayList) {
        InterceptResult invokeIL;
        ArrayList<String> memberBuids;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65541, this, i, arrayList)) == null) {
            if (1 == i && arrayList != null && arrayList.size() > 0) {
                if (arrayList.get(arrayList.size() - 1).getMsgType() == 1003) {
                    return false;
                }
                String uid = AccountManager.getUid(this.mContext);
                Iterator<ChatMsg> it = arrayList.iterator();
                while (it.hasNext()) {
                    ChatMsg next = it.next();
                    if (next.getMsgType() == 1004 && (next instanceof GroupMemberDelMsg) && (memberBuids = ((GroupMemberDelMsg) next).getMemberBuids()) != null && memberBuids.contains(uid)) {
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    private void sync(Context context, boolean z, long j, long j2, String str) {
        long j3;
        long j4;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, this, new Object[]{context, Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2), str}) == null) {
            LogUtils.d(TAG, "sync state: " + this.mState);
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
                if (j != -1 && j < startMsgid) {
                    j3 = j;
                    j4 = j3;
                } else {
                    j3 = startMsgid + 1;
                    j4 = Long.MAX_VALUE;
                }
                if (getJumpToRecent() == 1) {
                    this.mAmountEachFetch = 200;
                } else {
                    this.mAmountEachFetch = 100;
                }
                this.mState = 1;
                LogUtils.i(TAG, "sync startId : " + j3 + " endId : " + j4);
                if (j2 > 0 && !AccountManager.getMediaRole(this.mContext) && this.mCategory == 0) {
                    str2 = Utility.appendEventList(str, "CIMBeforeFetch");
                } else {
                    str2 = str;
                }
                ChatMsgManagerImpl.getInstance(context).fetchMsgidByMsgid(context, this.mCategory, this.mContacter, j3, j4, j, j2, str2, this.mAmountEachFetch, this.mTriggerReason, getJumpToRecent(), new IFetchMsgByIdListener(this) { // from class: com.baidu.android.imsdk.chatmessage.sync.SyncStrategy.1
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
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
                    public void onFetchMsgByIdResult(int i, String str3, String str4, int i2, long j5, long j6, long j7, int i3, int i4, long j8, ArrayList<ChatMsg> arrayList) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str3, str4, Integer.valueOf(i2), Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j8), arrayList}) == null) {
                            String str5 = SyncStrategy.TAG;
                            LogUtils.i(str5, "onFetchMsgByIdResult errorCode: " + i + ", maxMsgid :" + j8 + ",contacter: " + j5 + ",mContacter: " + this.this$0.mContacter + ",beginId: " + j6 + ",endId: " + j7 + ",realCount : " + i4);
                            this.this$0.deal(i, i3, i4, j8, str4, arrayList, i2, j5);
                        }
                    }
                });
            }
        }
    }

    public void deal(int i, int i2, int i3, long j, String str, ArrayList<ChatMsg> arrayList, int i4, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), str, arrayList, Integer.valueOf(i4), Long.valueOf(j2)}) == null) {
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
                    } catch (Exception e) {
                        LogUtils.e(LogUtils.TAG, e.getMessage(), e);
                    }
                } else if (GroupMessageDAOImpl.isActiveGroup(this.mContext, String.valueOf(j2))) {
                    try {
                        Dispatcher.dispatchMessage(this.mContext, this.mTriggerReason, arrayList);
                    } catch (Exception e2) {
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
                if (isMaxNotifyMsgIdSaveAble(i4, arrayList)) {
                    commitDeviceMaxNotifyMsgid();
                }
                onComplete(i);
                this.mState = 2;
                int i5 = this.mTriggerReason;
                if ((i5 == 0 || i5 == 1) && checkNeedSendSyncCompBroadcast()) {
                    SyncManager.notifySyncDone();
                    return;
                }
                return;
            }
            this.mState = 1;
            if (isMaxNotifyMsgIdSaveAble(i4, arrayList)) {
                commitDeviceMaxNotifyMsgid();
            }
            int i6 = this.mTriggerReason;
            if (i6 == 0 || i6 == 1) {
                LogUtils.d(TAG, "fetch msg thread sleep for 6s");
                try {
                    Thread.currentThread();
                    Thread.sleep(LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION);
                } catch (Exception unused) {
                    LogUtils.d(TAG, "fetch msg thread sleep exception");
                }
                LogUtils.d(TAG, "fetch msg thread sleep end, start to fetch");
            }
            sync(this.mContext, false, -1L, -1L, "");
        }
    }

    public void start(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            String str = TAG;
            LogUtils.d(str, "******************start sync !************** mState = " + this.mState);
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
            sync(this.mContext, true, -1L, -1L, "");
        }
    }

    public void start(int i, long j, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), str}) == null) {
            String str2 = TAG;
            LogUtils.d(str2, "******************start sync !************** " + this.mState + ", notifyId :" + j2);
            this.mPassPortSwitch = false;
            if (this.mState == 1) {
                return;
            }
            synchronized (this.mRetryTimesSync) {
                this.mReTryTimes = 0;
            }
            this.mTriggerReason = i;
            String str3 = TAG;
            LogUtils.d(str3, "----start sync category:" + this.mCategory + " contacter:" + this.mContacter);
            if (j2 > 0 && !AccountManager.getMediaRole(this.mContext) && this.mCategory == 0) {
                str = Utility.appendEventList(str, "CIMSyncFetch");
            }
            sync(this.mContext, true, j, j2, str);
        }
    }

    public boolean syncNotifyMessageStopCondition(int i, int i2, int i3, ArrayList<ChatMsg> arrayList) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), arrayList})) == null) {
            if (arrayList != null && i == 0) {
                synchronized (this.mRetryTimesSync) {
                    this.mReTryTimes = 0;
                }
                if (i3 >= i2) {
                    return false;
                }
                return true;
            }
            if (this.mReTryTimes <= 2) {
                synchronized (this.mRetryTimesSync) {
                    this.mReTryTimes++;
                }
            }
            if (this.mReTryTimes <= 2 && i != 1001 && i != 1004 && i != 6) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
