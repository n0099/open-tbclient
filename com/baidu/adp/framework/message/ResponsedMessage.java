package com.baidu.adp.framework.message;

import androidx.core.view.InputDeviceCompat;
import c.a.d.c.e.c.h;
import c.a.d.c.i.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class ResponsedMessage<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int mCmd;
    public long mCostTime;
    public int mDownSize;
    public int mError;
    public String mErrorString;
    public Message<?> mOrginalMessage;
    public long mProcessTime;
    public long mStartTime;
    public a performanceData;

    public ResponsedMessage(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mError = 0;
        this.mErrorString = null;
        this.mStartTime = 0L;
        this.mProcessTime = 0L;
        this.mDownSize = 0;
        this.mCostTime = 0L;
        this.performanceData = new a();
        this.mCmd = i;
    }

    public void afterDispatchInBackGround(int i, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, t) == null) {
        }
    }

    public void beforeDispatchInBackGround(int i, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, t) == null) {
        }
    }

    public abstract /* synthetic */ void decodeInBackGround(int i, T t) throws Exception;

    public int getCmd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mCmd : invokeV.intValue;
    }

    public long getCostTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mCostTime : invokeV.longValue;
    }

    public int getDownSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mDownSize : invokeV.intValue;
    }

    public int getError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mError : invokeV.intValue;
    }

    public String getErrorString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mErrorString : (String) invokeV.objValue;
    }

    public Message<?> getOrginalMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mOrginalMessage : (Message) invokeV.objValue;
    }

    public long getProcessTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mProcessTime : invokeV.longValue;
    }

    public long getStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mStartTime : invokeV.longValue;
    }

    public Message<?> getmOrginalMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mOrginalMessage : (Message) invokeV.objValue;
    }

    public abstract boolean hasError();

    public void onDecodeFailedInBackGround(int i, T t, int i2) throws Exception {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), t, Integer.valueOf(i2)}) == null) && i2 == h.f1981c) {
            setError(TbErrInfo.ERR_SOKCET_SWITCH_HTTP);
        }
    }

    public void setCostTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
            this.mCostTime = j;
        }
    }

    public void setDownSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.mDownSize = i;
        }
    }

    public void setError(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.mError = i;
        }
    }

    public void setErrorString(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.mErrorString = str;
        }
    }

    public void setOrginalMessage(Message<?> message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, message) == null) {
            this.mOrginalMessage = message;
        }
    }

    public void setProcessTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j) == null) {
            this.mProcessTime = j;
        }
    }

    public void setStartTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j) == null) {
            this.mStartTime = j;
        }
    }

    public void setmOrginalMessage(Message<?> message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, message) == null) {
            this.mOrginalMessage = message;
        }
    }
}
