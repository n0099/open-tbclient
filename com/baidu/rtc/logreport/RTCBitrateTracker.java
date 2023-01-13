package com.baidu.rtc.logreport;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.defaultimpl.utils.MultiRatePlayUrlHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBitrate = 0.0d;
        this.mPreTimeMs = 0L;
        this.mPreByteCount = 0L;
    }

    public String bitRateString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return bitrateStringForBitrate(this.mBitrate);
        }
        return (String) invokeV.objValue;
    }

    public long getBytesDelta() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mBytesDelta;
        }
        return invokeV.longValue;
    }

    public static String bitrateStringForBitrate(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Double.valueOf(d)})) == null) {
            if (d > 1000000.0d) {
                return String.format("%.2fMbps", Double.valueOf(d * 1.0E-6d));
            }
            if (d > 1000.0d) {
                return String.format("%.0fKbps", Double.valueOf(d * 0.001d));
            }
            return String.format("%.0fbps", Double.valueOf(d));
        }
        return (String) invokeCommon.objValue;
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
                if (str.indexOf(MultiRatePlayUrlHelper.BPS) != -1) {
                    return Integer.parseInt(str.substring(0, str.indexOf(MultiRatePlayUrlHelper.BPS)));
                }
                Log.e("BRTC", "illegal input num");
                return -1;
            } catch (NumberFormatException e) {
                Log.e("RTCBitrateTracker", "bitrateToString dataFormat error: " + e);
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public void updataBitrateWidhCurrentByteCount(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = this.mPreTimeMs;
            long j3 = currentTimeMillis - j2;
            long j4 = this.mPreByteCount;
            long j5 = j - j4;
            this.mBytesDelta = j5;
            if (j3 <= 0) {
                return;
            }
            if (j2 != 0 && j > j4) {
                this.mBitrate = ((j5 * 8) * 1000) / j3;
            }
            this.mPreByteCount = j;
            this.mPreTimeMs = currentTimeMillis;
        }
    }
}
