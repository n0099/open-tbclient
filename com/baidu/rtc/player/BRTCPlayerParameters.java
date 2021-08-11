package com.baidu.rtc.player;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class BRTCPlayerParameters {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AAC = 2;
    public static final int DEFAULT_STATS_INTERVAL_MS = 1000;
    public static final int DEFAULT_STREAMING_INTERRUPT_INTERVAL_MS = 6000;
    public static final int OPUS = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int mAudioBufferMaintainableLevel;
    public int mAudioBufferUnderLoadLevel;
    public int mAudioDecodeFormat;
    public int mBufferingDetectIntervalMs;
    public String mCpuType;
    public boolean mEnableDebug;
    public boolean mIsEnableSoLaterLoad;
    public String mPullUrl;
    public String mSoLaterLoadUrl;
    public int mStatsReportIntervalMs;
    public int mStreamingInterruptDetectIntervalMs;
    public long mUserId;
    public double mVolume;

    public BRTCPlayerParameters() {
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
        this.mAudioDecodeFormat = 2;
        this.mVolume = 1.0d;
        this.mEnableDebug = false;
        this.mPullUrl = "https://rtc2.exp.bcelive.com/brtc/v3/pullstream";
        this.mSoLaterLoadUrl = "";
        this.mCpuType = "armeabi-v7a";
        this.mIsEnableSoLaterLoad = false;
        this.mStreamingInterruptDetectIntervalMs = 6000;
        this.mStatsReportIntervalMs = 1000;
        this.mAudioBufferUnderLoadLevel = 20;
        this.mAudioBufferMaintainableLevel = 50;
        this.mBufferingDetectIntervalMs = 200;
    }

    public void enableSoLaterLoad(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.mIsEnableSoLaterLoad = z;
        }
    }

    public int getAudioBufferMaintainableLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mAudioBufferMaintainableLevel : invokeV.intValue;
    }

    public int getAudioBufferUnderLoadLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mAudioBufferUnderLoadLevel : invokeV.intValue;
    }

    public int getAudioDecodeFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mAudioDecodeFormat : invokeV.intValue;
    }

    public int getBufferingDetectIntervalMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mBufferingDetectIntervalMs : invokeV.intValue;
    }

    public String getCpuType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mCpuType : (String) invokeV.objValue;
    }

    public boolean getEnableDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mEnableDebug : invokeV.booleanValue;
    }

    public String getPullUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mPullUrl : (String) invokeV.objValue;
    }

    public String getSoLaterLoadUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mSoLaterLoadUrl : (String) invokeV.objValue;
    }

    public int getStatsReportIntervalMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mStatsReportIntervalMs : invokeV.intValue;
    }

    public int getStreamingInterruptDetectInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mStreamingInterruptDetectIntervalMs : invokeV.intValue;
    }

    public long getUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mUserId : invokeV.longValue;
    }

    public double getVolume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mVolume : invokeV.doubleValue;
    }

    public boolean isEnableSoLaterLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mIsEnableSoLaterLoad : invokeV.booleanValue;
    }

    public void setAudioBufferMaintainableLevel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.mAudioBufferMaintainableLevel = i2;
        }
    }

    public void setAudioBufferUnderLoadLevel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.mAudioBufferUnderLoadLevel = i2;
        }
    }

    public void setAudioDecodeFormat(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.mAudioDecodeFormat = i2;
        }
    }

    public void setBufferingDetectIntervalMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.mBufferingDetectIntervalMs = i2;
        }
    }

    public void setCpuType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.mCpuType = str;
        }
    }

    public void setEnableDebug(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.mEnableDebug = z;
        }
    }

    public void setPullUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.mPullUrl = str;
        }
    }

    public void setSoLaterLoadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.mSoLaterLoadUrl = str;
        }
    }

    public void setStatsReportIntervalMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.mStatsReportIntervalMs = i2;
        }
    }

    public void setStreamingInterruptDetectIntervalMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.mStreamingInterruptDetectIntervalMs = i2;
        }
    }

    public void setUserId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048600, this, j2) == null) {
            this.mUserId = j2;
        }
    }

    public void setVolume(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.mVolume = d2;
        }
    }
}
