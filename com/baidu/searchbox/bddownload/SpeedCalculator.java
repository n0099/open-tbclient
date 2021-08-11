package com.baidu.searchbox.bddownload;

import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class SpeedCalculator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long allIncreaseBytes;
    public long beginTimestamp;
    public long bytesPerSecond;
    public long endTimestamp;
    public long increaseBytes;
    public long timestamp;

    public SpeedCalculator() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String humanReadableSpeed(long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            return Util.humanReadableBytes(j2, z) + "/s";
        }
        return (String) invokeCommon.objValue;
    }

    public String averageSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? speedFromBegin() : (String) invokeV.objValue;
    }

    public synchronized void downloading(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            synchronized (this) {
                if (this.timestamp == 0) {
                    long nowMillis = nowMillis();
                    this.timestamp = nowMillis;
                    this.beginTimestamp = nowMillis;
                }
                this.increaseBytes += j2;
                this.allIncreaseBytes += j2;
            }
        }
    }

    public synchronized void endTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.endTimestamp = nowMillis();
            }
        }
    }

    public synchronized void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                long nowMillis = nowMillis();
                long j2 = this.increaseBytes;
                long max = Math.max(1L, nowMillis - this.timestamp);
                this.increaseBytes = 0L;
                this.timestamp = nowMillis;
                this.bytesPerSecond = (((float) j2) / ((float) max)) * 1000.0f;
            }
        }
    }

    public synchronized long getBytesPerSecondAndFlush() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                long nowMillis = nowMillis() - this.timestamp;
                if (nowMillis < 1000 && this.bytesPerSecond != 0) {
                    return this.bytesPerSecond;
                }
                if (this.bytesPerSecond != 0 || nowMillis >= 500) {
                    return getInstantBytesPerSecondAndFlush();
                }
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    public synchronized long getBytesPerSecondFromBegin() {
        InterceptResult invokeV;
        long max;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                max = (((float) this.allIncreaseBytes) / ((float) Math.max(1L, (this.endTimestamp == 0 ? nowMillis() : this.endTimestamp) - this.beginTimestamp))) * 1000.0f;
            }
            return max;
        }
        return invokeV.longValue;
    }

    public long getInstantBytesPerSecondAndFlush() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            flush();
            return this.bytesPerSecond;
        }
        return invokeV.longValue;
    }

    public synchronized long getInstantSpeedDurationMillis() {
        InterceptResult invokeV;
        long nowMillis;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                nowMillis = nowMillis() - this.timestamp;
            }
            return nowMillis;
        }
        return invokeV.longValue;
    }

    public String getSpeedWithBinaryAndFlush() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? humanReadableSpeed(getInstantBytesPerSecondAndFlush(), false) : (String) invokeV.objValue;
    }

    public String getSpeedWithSIAndFlush() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? humanReadableSpeed(getInstantBytesPerSecondAndFlush(), true) : (String) invokeV.objValue;
    }

    public String instantSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? getSpeedWithSIAndFlush() : (String) invokeV.objValue;
    }

    public String lastSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? humanReadableSpeed(this.bytesPerSecond, true) : (String) invokeV.objValue;
    }

    public long nowMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? SystemClock.uptimeMillis() : invokeV.longValue;
    }

    public synchronized void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this) {
                this.timestamp = 0L;
                this.increaseBytes = 0L;
                this.bytesPerSecond = 0L;
                this.beginTimestamp = 0L;
                this.endTimestamp = 0L;
                this.allIncreaseBytes = 0L;
            }
        }
    }

    public String speed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? humanReadableSpeed(getBytesPerSecondAndFlush(), true) : (String) invokeV.objValue;
    }

    public String speedFromBegin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? humanReadableSpeed(getBytesPerSecondFromBegin(), true) : (String) invokeV.objValue;
    }
}
