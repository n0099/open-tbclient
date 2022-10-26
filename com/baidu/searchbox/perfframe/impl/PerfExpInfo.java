package com.baidu.searchbox.perfframe.impl;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class PerfExpInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mBusiness;
    public String mException;
    public boolean mIsNeedDynamicperf;
    public boolean mIsNeedMainStackTrace;
    public boolean mIsNeedPageTrace;
    public boolean mIsNeedStaticperf;
    public long mLaunchTime;
    public String mLogId;
    public String mPage;
    public long mTime;
    public LinkedList mTrackUIs;
    public String mType;
    public String mUbcId;

    public PerfExpInfo(String str, String str2, long j, long j2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Long.valueOf(j), Long.valueOf(j2), str3, str4, str5};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mUbcId = str;
        this.mType = str2;
        this.mTime = j;
        this.mLaunchTime = j2;
        this.mException = str3;
        this.mPage = str4;
        this.mBusiness = str5;
    }

    public String getBusiness() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mBusiness;
        }
        return (String) invokeV.objValue;
    }

    public String getException() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mException;
        }
        return (String) invokeV.objValue;
    }

    public long getLaunchTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mLaunchTime;
        }
        return invokeV.longValue;
    }

    public String getLogId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mLogId;
        }
        return (String) invokeV.objValue;
    }

    public String getPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mPage;
        }
        return (String) invokeV.objValue;
    }

    public String getProcessDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return String.valueOf(getTime() - getLaunchTime());
        }
        return (String) invokeV.objValue;
    }

    public long getTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mTime;
        }
        return invokeV.longValue;
    }

    public LinkedList getTrackUIs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mTrackUIs;
        }
        return (LinkedList) invokeV.objValue;
    }

    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mType;
        }
        return (String) invokeV.objValue;
    }

    public String getUbcId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mUbcId;
        }
        return (String) invokeV.objValue;
    }

    public boolean isNeedDynamicperf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mIsNeedDynamicperf;
        }
        return invokeV.booleanValue;
    }

    public boolean isNeedMainStackTrace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mIsNeedMainStackTrace;
        }
        return invokeV.booleanValue;
    }

    public boolean isNeedPageTrace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mIsNeedPageTrace;
        }
        return invokeV.booleanValue;
    }

    public boolean isNeedStaticperf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mIsNeedStaticperf;
        }
        return invokeV.booleanValue;
    }

    public void setBusiness(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.mBusiness = str;
        }
    }

    public void setException(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.mException = str;
        }
    }

    public void setLaunchTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            this.mLaunchTime = j;
        }
    }

    public void setLogId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.mLogId = str;
        }
    }

    public void setNeedDynamicperf(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.mIsNeedDynamicperf = z;
        }
    }

    public void setNeedMainStackTrace(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.mIsNeedMainStackTrace = z;
        }
    }

    public void setNeedPageTrace(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.mIsNeedPageTrace = z;
        }
    }

    public void setNeedStaticperf(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.mIsNeedStaticperf = z;
        }
    }

    public void setPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.mPage = str;
        }
    }

    public void setTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048599, this, j) == null) {
            this.mTime = j;
        }
    }

    public void setTrackUIs(LinkedList linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, linkedList) == null) {
            this.mTrackUIs = linkedList;
        }
    }

    public void setType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.mType = str;
        }
    }

    public void setUbcId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.mUbcId = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return "PerfExpInfo{mUbcId='" + this.mUbcId + "', mType='" + this.mType + "', mLogId='" + this.mLogId + "', mTime=" + this.mTime + ", mException='" + this.mException + "', mPage='" + this.mPage + "', mLaunchTime=" + this.mLaunchTime + ", mBusiness='" + this.mBusiness + "', mTrackUIs=" + this.mTrackUIs + ", mIsNeedPageTrace=" + this.mIsNeedPageTrace + ", mIsNeedDynamicperf=" + this.mIsNeedDynamicperf + ", mIsNeedStaticperf=" + this.mIsNeedStaticperf + ", mIsNeedMainStackTrace=" + this.mIsNeedMainStackTrace + '}';
        }
        return (String) invokeV.objValue;
    }
}
