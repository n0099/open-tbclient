package com.baidu.android.imsdk.chatmessage.sync;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.sync.SyncStrategy;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class SyncGroupMessage extends SyncStrategy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "SyncGroupMessage";
    public transient /* synthetic */ FieldHolder $fh;
    public SyncStrategy.CompleteListener completeListener;
    public DialogRecord mDialogRecord;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(591220331, "Lcom/baidu/android/imsdk/chatmessage/sync/SyncGroupMessage;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(591220331, "Lcom/baidu/android/imsdk/chatmessage/sync/SyncGroupMessage;");
        }
    }

    public SyncGroupMessage(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context;
    }

    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    public boolean commitDeviceMaxNotifyMsgid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (DialogRecordDBManager.getInstance(this.mContext).add(this.mDialogRecord) >= 0) {
                return true;
            }
            LogUtils.e(TAG, "add dailogRecord exception!!");
            return false;
        }
        return invokeV.booleanValue;
    }

    public long getContacter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mDialogRecord.getContacter() : invokeV.longValue;
    }

    public DialogRecord getDialogRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mDialogRecord : (DialogRecord) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    public int getJumpToRecent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mDialogRecord.getJumpToRecent() : invokeV.intValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    public long getStartMsgid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mDialogRecord.getMaxMsgid() : invokeV.longValue;
    }

    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mState : invokeV.intValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    public void onComplete(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            String str = TAG;
            LogUtils.d(str, "SYNCGROUP complete code is " + i);
            SyncStrategy.CompleteListener completeListener = this.completeListener;
            if (completeListener != null) {
                completeListener.onComplete(this.mDialogRecord);
            }
        }
    }

    public void setCompleteListener(SyncStrategy.CompleteListener completeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, completeListener) == null) {
            this.completeListener = completeListener;
        }
    }

    public void setDialogRecord(DialogRecord dialogRecord) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dialogRecord) == null) {
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
    }

    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    public void updateData(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048585, this, context, j) == null) {
            String str = TAG;
            LogUtils.i(str, "updateData : " + j);
            if (j < 0) {
                return;
            }
            this.mDialogRecord.setMaxMsgid(j);
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy
    public boolean updateJumpToRecent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            this.mDialogRecord.setJumpToRecent(0);
            return true;
        }
        return invokeV.booleanValue;
    }
}
