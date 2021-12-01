package com.baidu.android.imsdk.chatmessage.sync;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class SyncAllMessage extends SyncStrategy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "SyncAllMessage";
    public static SyncAllMessage mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public long mMaxMsgid;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-88171123, "Lcom/baidu/android/imsdk/chatmessage/sync/SyncAllMessage;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-88171123, "Lcom/baidu/android/imsdk/chatmessage/sync/SyncAllMessage;");
        }
    }

    public SyncAllMessage(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mMaxMsgid = -1L;
        this.mContext = context;
    }

    private long getDeviceMaxNotifyMsgid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (this.mMaxMsgid == -1) {
                Context context = this.mContext;
                this.mMaxMsgid = Utility.readLongData(context, IMConstants.FETCHED_MAX_NOTIFY_MSGID + AccountManager.getAppid(this.mContext) + AccountManager.getUid(this.mContext), -1L);
            }
            return this.mMaxMsgid;
        }
        return invokeV.longValue;
    }

    public static SyncAllMessage getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            synchronized (SyncAllMessage.class) {
                if (mInstance == null) {
                    mInstance = new SyncAllMessage(context);
                }
            }
            return mInstance;
        }
        return (SyncAllMessage) invokeL.objValue;
    }

    private void setDeviceMaxNotifyMsgid(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, this, j2) == null) {
            String str = TAG;
            LogUtils.d(str, "deal setDeviceMaxNotifyMsgid:" + j2);
            if (j2 > this.mMaxMsgid) {
                this.mMaxMsgid = j2;
            }
        }
    }

    public void clearCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            reset();
            Context context = this.mContext;
            Utility.writeLongData(context, IMConstants.FETCHED_MAX_NOTIFY_MSGID + AccountManager.getAppid(this.mContext) + AccountManager.getUid(this.mContext), -1L);
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    public boolean commitDeviceMaxNotifyMsgid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Context context = this.mContext;
            Utility.writeLongData(context, IMConstants.FETCHED_MAX_NOTIFY_MSGID + AccountManager.getAppid(this.mContext) + AccountManager.getUid(this.mContext), this.mMaxMsgid);
            this.mCount.set(0);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    public int getJumpToRecent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mJumpToRecent == -1) {
                Context context = this.mContext;
                this.mJumpToRecent = Utility.readIntData(context, Utility.getJumpToRecentKey(context), 1);
            }
            return this.mJumpToRecent;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    public long getStartMsgid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Math.max(0L, getDeviceMaxNotifyMsgid()) : invokeV.longValue;
    }

    public int getState() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (this.mState == 1 && ((i2 = this.mTriggerReason) == 0 || i2 == 1)) ? 0 : 1 : invokeV.intValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    public void onComplete(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            super.onComplete(i2);
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mMaxMsgid = -1L;
            this.mJumpToRecent = -1;
            this.mPassPortSwitch = true;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    public void updateData(Context context, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048583, this, context, j2) == null) || j2 <= 0) {
            return;
        }
        setDeviceMaxNotifyMsgid(j2);
    }

    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    public boolean updateJumpToRecent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.mJumpToRecent != 0) {
                this.mJumpToRecent = 0;
                Context context = this.mContext;
                Utility.writeIntData(context, Utility.getJumpToRecentKey(context), this.mJumpToRecent);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
