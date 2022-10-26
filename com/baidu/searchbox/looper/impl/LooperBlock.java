package com.baidu.searchbox.looper.impl;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.UUID;
/* loaded from: classes2.dex */
public class LooperBlock {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mCpuRateInfo;
    public String mCurrentPage;
    public String mDuration;
    public String mEndLagTime;
    public String mLogID;
    public StringBuilder mStackSb;
    public String mStartLagTime;
    public LinkedList mTrackUIs;
    public String mType;

    public LooperBlock(String str, String str2, String str3, String str4, StringBuilder sb) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, sb};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mType = "looper";
        this.mDuration = str;
        this.mCpuRateInfo = str2;
        this.mStartLagTime = str3;
        this.mEndLagTime = str4;
        this.mStackSb = sb;
        this.mLogID = UUID.randomUUID().toString().replace("-", "");
    }

    public String getCpuRateInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mCpuRateInfo;
        }
        return (String) invokeV.objValue;
    }

    public String getCurrentPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mCurrentPage;
        }
        return (String) invokeV.objValue;
    }

    public String getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mDuration;
        }
        return (String) invokeV.objValue;
    }

    public String getEndLagTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mEndLagTime;
        }
        return (String) invokeV.objValue;
    }

    public String getLogID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mLogID;
        }
        return (String) invokeV.objValue;
    }

    public StringBuilder getStackSb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mStackSb;
        }
        return (StringBuilder) invokeV.objValue;
    }

    public String getStartLagTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mStartLagTime;
        }
        return (String) invokeV.objValue;
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

    public void setCurrentPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.mCurrentPage = str;
        }
    }

    public void setTrackUIs(LinkedList linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, linkedList) == null) {
            this.mTrackUIs = linkedList;
        }
    }
}
