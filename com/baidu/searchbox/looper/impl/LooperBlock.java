package com.baidu.searchbox.looper.impl;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.UUID;
/* loaded from: classes7.dex */
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
    public LinkedList<TrackUI> mTrackUIs;
    public String mType;

    public LooperBlock(String str, String str2, String str3, String str4, StringBuilder sb) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, sb};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mCpuRateInfo : (String) invokeV.objValue;
    }

    public String getCurrentPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mCurrentPage : (String) invokeV.objValue;
    }

    public String getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mDuration : (String) invokeV.objValue;
    }

    public String getEndLagTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mEndLagTime : (String) invokeV.objValue;
    }

    public String getLogID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mLogID : (String) invokeV.objValue;
    }

    public StringBuilder getStackSb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mStackSb : (StringBuilder) invokeV.objValue;
    }

    public String getStartLagTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mStartLagTime : (String) invokeV.objValue;
    }

    public LinkedList<TrackUI> getTrackUIs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mTrackUIs : (LinkedList) invokeV.objValue;
    }

    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mType : (String) invokeV.objValue;
    }

    public void setCurrentPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.mCurrentPage = str;
        }
    }

    public void setTrackUIs(LinkedList<TrackUI> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, linkedList) == null) {
            this.mTrackUIs = linkedList;
        }
    }
}
