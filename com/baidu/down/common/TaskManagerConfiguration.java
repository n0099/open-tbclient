package com.baidu.down.common;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class TaskManagerConfiguration {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int bufferSize;
    public boolean mDomainNameToIpEnable;
    public String mDomainNameToIpReg;
    public boolean mDownSpeedStatEnable;
    public String mHttpDnsServerIp;
    public boolean mHttpRetryStrategyEnable;
    public int mLogLevel;
    public String mPreResolveDomainName;
    public int mTrafficStatsTag;
    public String mURLRetryHostReg;
    public int maxBufferCount;
    public int maxTaskCount;
    public long[] retryIntervals;
    public boolean retryNetDetect;

    public TaskManagerConfiguration() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.maxTaskCount = 3;
        this.maxBufferCount = 100;
        this.bufferSize = 16384;
        this.retryIntervals = DownConstants.DF_RETRY_INTERVALS;
        this.retryNetDetect = true;
        this.mTrafficStatsTag = 0;
        this.mDomainNameToIpEnable = false;
        this.mHttpRetryStrategyEnable = false;
        this.mDownSpeedStatEnable = false;
    }

    public boolean geDomainNameToIpEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mDomainNameToIpEnable : invokeV.booleanValue;
    }

    public int getBufferSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.bufferSize : invokeV.intValue;
    }

    public String getDomainNameToIpReg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mDomainNameToIpReg : (String) invokeV.objValue;
    }

    public boolean getDownSpeedStatEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mDownSpeedStatEnable : invokeV.booleanValue;
    }

    public String getHttpDnsServerIp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mHttpDnsServerIp : (String) invokeV.objValue;
    }

    public boolean getHttpRetryStrategyEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mHttpRetryStrategyEnable : invokeV.booleanValue;
    }

    public int getLogLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mLogLevel : invokeV.intValue;
    }

    public int getMaxBufferCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.maxBufferCount : invokeV.intValue;
    }

    public int getMaxTaskCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.maxTaskCount : invokeV.intValue;
    }

    public String getPreResolveDominName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mPreResolveDomainName : (String) invokeV.objValue;
    }

    public long[] getRetryIntervals() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.retryIntervals : (long[]) invokeV.objValue;
    }

    public int getTrafficStatsTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mTrafficStatsTag : invokeV.intValue;
    }

    public String getURLRetryHostReg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mURLRetryHostReg : (String) invokeV.objValue;
    }

    public boolean isRetryNetDetect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.retryNetDetect : invokeV.booleanValue;
    }

    public void setBufferSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            if (i2 > 0) {
                this.bufferSize = i2;
                return;
            }
            throw new RuntimeException("### bufferSize should be bigger than 0!");
        }
    }

    public void setDomainNameToIpEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.mDomainNameToIpEnable = z;
        }
    }

    public void setDomainNameToIpReg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.mDomainNameToIpReg = str;
        }
    }

    public void setDownSpeedStatEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.mDownSpeedStatEnable = z;
        }
    }

    public void setHttpDnsServerIp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.mHttpDnsServerIp = str;
        }
    }

    public void setHttpRetryStrategyEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.mHttpRetryStrategyEnable = z;
        }
    }

    public void setLogLevel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.mLogLevel = i2;
        }
    }

    public void setMaxBufferCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            if (this.maxTaskCount > 0) {
                this.maxBufferCount = i2;
                return;
            }
            throw new RuntimeException("### maxBufferCount should be bigger than 0!");
        }
    }

    public void setMaxTaskCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            if (i2 > 0 && i2 <= 3) {
                this.maxTaskCount = i2;
                return;
            }
            throw new RuntimeException("### maxTaskCount should be 0-3");
        }
    }

    public void setPreResolveDominName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.mPreResolveDomainName = str;
        }
    }

    public void setRetryIntervals(long[] jArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, jArr) == null) || jArr == null) {
            return;
        }
        this.retryIntervals = jArr;
    }

    public void setRetryNetDetect(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.retryNetDetect = z;
        }
    }

    public void setTrafficStatsTag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.mTrafficStatsTag = i2;
        }
    }

    public void setURLRetryHostReg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.mURLRetryHostReg = str;
        }
    }
}
