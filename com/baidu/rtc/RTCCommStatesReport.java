package com.baidu.rtc;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.rtc.logreport.HUDStatistics;
import com.baidu.rtc.logreport.RTCBitrateTracker;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.math.BigInteger;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes7.dex */
public class RTCCommStatesReport {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mDebugStatesFlag;
    public BigInteger mPlayTransactionId;
    public String mRemoteHandleId;
    public String mRoomId;
    public HUDStatistics mStates;
    public String mUserId;

    public RTCCommStatesReport(BigInteger bigInteger, String str, String str2, String str3, HUDStatistics hUDStatistics) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bigInteger, str, str2, str3, hUDStatistics};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPlayTransactionId = null;
        this.mDebugStatesFlag = 31;
        this.mStates = hUDStatistics;
        this.mPlayTransactionId = bigInteger;
        this.mRoomId = str;
        this.mUserId = str2;
        this.mRemoteHandleId = str3;
    }

    private String formatPlayInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (this.mPlayTransactionId == null || this.mRoomId == null || this.mUserId == null || this.mRemoteHandleId == null) {
                return "";
            }
            return "PlayInfo: (transactionId)" + this.mPlayTransactionId + " | (handleId)" + this.mRemoteHandleId + " | (room)" + this.mRoomId + " | (user)" + this.mUserId + StringUtils.LF;
        }
        return (String) invokeV.objValue;
    }

    public int getAudioJitterBufferMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HUDStatistics hUDStatistics = this.mStates;
            if (hUDStatistics == null) {
                return 0;
            }
            return hUDStatistics.mAudioJitterBufferMs;
        }
        return invokeV.intValue;
    }

    public int getAudioRecvBitrate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            HUDStatistics hUDStatistics = this.mStates;
            if (hUDStatistics == null) {
                return -1;
            }
            return RTCBitrateTracker.bitrateToString(hUDStatistics.mAudioRecvBitrate);
        }
        return invokeV.intValue;
    }

    public int getConnRecvBitrate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HUDStatistics hUDStatistics = this.mStates;
            if (hUDStatistics == null) {
                return -1;
            }
            return RTCBitrateTracker.bitrateToString(hUDStatistics.mConnRecvBitrate);
        }
        return invokeV.intValue;
    }

    public String getRemoteAddr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            HUDStatistics hUDStatistics = this.mStates;
            return hUDStatistics == null ? "" : hUDStatistics.mRemoteIp;
        }
        return (String) invokeV.objValue;
    }

    public String getRoomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mRoomId : (String) invokeV.objValue;
    }

    public String getUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mUserId : (String) invokeV.objValue;
    }

    public int getVideoOutputFps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            HUDStatistics hUDStatistics = this.mStates;
            if (hUDStatistics == null || TextUtils.isEmpty(hUDStatistics.mVideoOutputFps)) {
                return -1;
            }
            return Integer.valueOf(this.mStates.mVideoOutputFps).intValue();
        }
        return invokeV.intValue;
    }

    public int getVideoPacketLostRatioPerMil() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            HUDStatistics hUDStatistics = this.mStates;
            if (hUDStatistics == null) {
                return 0;
            }
            return hUDStatistics.mVideoRecvPacketLostRatio;
        }
        return invokeV.intValue;
    }

    public int getVideoRecvBitrate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            HUDStatistics hUDStatistics = this.mStates;
            if (hUDStatistics == null) {
                return -1;
            }
            return RTCBitrateTracker.bitrateToString(hUDStatistics.mVideoRecvBitrate);
        }
        return invokeV.intValue;
    }

    public int getVideoRecvPacketLost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            HUDStatistics hUDStatistics = this.mStates;
            if (hUDStatistics == null || TextUtils.isEmpty(hUDStatistics.mVideoRecvPacketLost)) {
                return -1;
            }
            return Integer.valueOf(this.mStates.mVideoRecvPacketLost).intValue();
        }
        return invokeV.intValue;
    }

    public void setDebugFlag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.mDebugStatesFlag = i2;
        }
    }

    public void setPlayTransactionId(BigInteger bigInteger) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bigInteger) == null) {
            this.mPlayTransactionId = bigInteger;
        }
    }

    public void setRemoteHandleId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.mRemoteHandleId = str;
        }
    }

    public void setRoomId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.mRoomId = str;
        }
    }

    public void setUserId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.mUserId = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            String formatPlayInfo = formatPlayInfo();
            HUDStatistics hUDStatistics = this.mStates;
            String statsString = hUDStatistics != null ? hUDStatistics.statsString(this.mDebugStatesFlag) : "";
            return formatPlayInfo + statsString;
        }
        return (String) invokeV.objValue;
    }

    public void updateStates(HUDStatistics hUDStatistics) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, hUDStatistics) == null) {
            this.mStates = hUDStatistics;
        }
    }
}
