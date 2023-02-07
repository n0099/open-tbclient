package com.baidu.searchbox.retrieve.timer.bean;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class FetchTimerBean extends FetchTimerBasicBean {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long mEndTime;
    public int mFrequency;
    public long mMaxTotalFileSize;
    public String mNetwork;
    public ArrayList<String> mSpace;
    public long mStartTime;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FetchTimerBean(String str, String str2, String str3, long j, long j2, long j3, long j4, ArrayList<String> arrayList, String str4, int i) {
        super(str, str2, str3, j);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r8;
            Object[] objArr = {str, str2, str3, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), arrayList, str4, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], ((Long) objArr2[3]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mStartTime = j2;
        this.mEndTime = j3;
        this.mMaxTotalFileSize = j4;
        this.mSpace = arrayList;
        this.mNetwork = str4;
        this.mFrequency = i;
    }

    public long getEndTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mEndTime;
        }
        return invokeV.longValue;
    }

    public int getFrequency() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mFrequency;
        }
        return invokeV.intValue;
    }

    public long getMaxTotalFileSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mMaxTotalFileSize;
        }
        return invokeV.longValue;
    }

    public String getNetwork() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mNetwork;
        }
        return (String) invokeV.objValue;
    }

    public ArrayList<String> getSpace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mSpace;
        }
        return (ArrayList) invokeV.objValue;
    }

    public long getStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mStartTime;
        }
        return invokeV.longValue;
    }

    public void setEndTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.mEndTime = j;
        }
    }

    public void setFrequency(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.mFrequency = i;
        }
    }

    public void setMaxTotalFileSize(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            this.mMaxTotalFileSize = j;
        }
    }

    public void setNetwork(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.mNetwork = str;
        }
    }

    public void setSpace(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, arrayList) == null) {
            this.mSpace = arrayList;
        }
    }

    public void setStartTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            this.mStartTime = j;
        }
    }

    @Override // com.baidu.searchbox.retrieve.timer.bean.FetchTimerBasicBean
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return "FetchTimerBean{mJobId='" + getJobId() + "', mType='" + getType() + "', mVersion='" + getVersion() + "', mExpiredTime=" + getExpiredTime() + ", mStartTime=" + this.mStartTime + ", mEndTime=" + this.mEndTime + ", mMaxTotalFileSize=" + this.mMaxTotalFileSize + ", mSpace=" + this.mSpace + ", mNetwork='" + this.mNetwork + "', mFrequency=" + this.mFrequency + '}';
        }
        return (String) invokeV.objValue;
    }
}
