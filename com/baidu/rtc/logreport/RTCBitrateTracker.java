package com.baidu.rtc.logreport;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class RTCBitrateTracker {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public double mBitrate;
    public long mBytesDelta;
    public long mPreByteCount;
    public long mPreTimeMs;

    public RTCBitrateTracker() {
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
        this.mBitrate = 0.0d;
        this.mPreTimeMs = 0L;
        this.mPreByteCount = 0L;
    }

    public static String bitrateStringForBitrate(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Double.valueOf(d2)})) == null) ? d2 > 1000000.0d ? String.format("%.2fMbps", Double.valueOf(d2 * 1.0E-6d)) : d2 > 1000.0d ? String.format("%.0fKbps", Double.valueOf(d2 * 0.001d)) : String.format("%.0fbps", Double.valueOf(d2)) : (String) invokeCommon.objValue;
    }

    public static int bitrateToString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str == null) {
                return -1;
            }
            try {
                if (str.indexOf("Mbps") != -1) {
                    return (int) Math.round(Double.parseDouble(str.substring(0, str.indexOf("Mbps"))) * 1000000.0d);
                }
                if (str.indexOf("Kbps") != -1) {
                    return (int) (Integer.parseInt(str.substring(0, str.indexOf("Kbps"))) * 1000.0d);
                }
                if (str.indexOf("bps") != -1) {
                    return Integer.parseInt(str.substring(0, str.indexOf("bps")));
                }
                return -1;
            } catch (NumberFormatException e2) {
                String str2 = "bitrateToString dataFormat error: " + e2;
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public String bitRateString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? bitrateStringForBitrate(this.mBitrate) : (String) invokeV.objValue;
    }

    public long getBytesDelta() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mBytesDelta : invokeV.longValue;
    }

    public void updataBitrateWidhCurrentByteCount(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = this.mPreTimeMs;
            long j4 = currentTimeMillis - j3;
            long j5 = this.mPreByteCount;
            long j6 = j2 - j5;
            this.mBytesDelta = j6;
            if (j4 <= 0) {
                return;
            }
            if (j3 != 0 && j2 > j5) {
                this.mBitrate = ((j6 * 8) * 1000) / j4;
            }
            this.mPreByteCount = j2;
            this.mPreTimeMs = currentTimeMillis;
        }
    }
}
