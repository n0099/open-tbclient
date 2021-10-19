package com.baidu.cyberplayer.sdk.rtc;

import android.content.Context;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.d;
import com.baidu.cyberplayer.sdk.rtc.CyberRTCAudioSamples;
import com.baidu.cyberplayer.sdk.rtc.CyberRTCSetting;
import com.baidu.cyberplayer.sdk.rtc.RTCRoomProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes5.dex */
public class CyberRTCRoom {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RTCRoomProvider f39265a;

    public CyberRTCRoom(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39265a = a.a().a(z);
    }

    public static void setRTCVerbose(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65537, null, z) == null) {
            d.a(z);
        }
    }

    public void changeSurfaceSize(long j2, int i2, int i3) {
        RTCRoomProvider rTCRoomProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || (rTCRoomProvider = this.f39265a) == null) {
            return;
        }
        rTCRoomProvider.changeSurfaceSize(j2, i2, i3);
    }

    public boolean configLiveServerWithUrl(String str, boolean z, boolean z2, String str2, RTCRoomProvider.CyberRtcLiveTransferMode cyberRtcLiveTransferMode) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), str2, cyberRtcLiveTransferMode})) == null) {
            RTCRoomProvider rTCRoomProvider = this.f39265a;
            if (rTCRoomProvider != null) {
                return rTCRoomProvider.configLiveServerWithUrl(str, z, z2, str2, cyberRtcLiveTransferMode);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RTCRoomProvider rTCRoomProvider = this.f39265a;
            if (rTCRoomProvider != null) {
                rTCRoomProvider.destroy();
            }
            this.f39265a = null;
        }
    }

    public void destroyExternalSurface(long j2, Surface surface) {
        RTCRoomProvider rTCRoomProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(1048579, this, j2, surface) == null) || (rTCRoomProvider = this.f39265a) == null) {
            return;
        }
        rTCRoomProvider.destroyExternalSurface(j2, surface);
    }

    public void disbandRoom() {
        RTCRoomProvider rTCRoomProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (rTCRoomProvider = this.f39265a) == null) {
            return;
        }
        rTCRoomProvider.disbandRoom();
    }

    public void enableAgc(boolean z) {
        RTCRoomProvider rTCRoomProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (rTCRoomProvider = this.f39265a) == null) {
            return;
        }
        rTCRoomProvider.enableAgc(z);
    }

    public void enableAns(boolean z) {
        RTCRoomProvider rTCRoomProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (rTCRoomProvider = this.f39265a) == null) {
            return;
        }
        rTCRoomProvider.enableAns(z);
    }

    public void enableExternalVideoCapturer(boolean z) {
        RTCRoomProvider rTCRoomProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (rTCRoomProvider = this.f39265a) == null) {
            return;
        }
        rTCRoomProvider.enableExternalVideoCapturer(z);
    }

    public void enableStatsToServer(boolean z, String str) {
        RTCRoomProvider rTCRoomProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z, str) == null) || (rTCRoomProvider = this.f39265a) == null) {
            return;
        }
        rTCRoomProvider.enableStatsToServer(z, str);
    }

    public RTCRoomProvider getProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f39265a : (RTCRoomProvider) invokeV.objValue;
    }

    public RTCRoomProvider.CyberRtcRoomAudioLevel[] getRemoteAudioLevels() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            RTCRoomProvider rTCRoomProvider = this.f39265a;
            return rTCRoomProvider != null ? rTCRoomProvider.getRemoteAudioLevels() : new RTCRoomProvider.CyberRtcRoomAudioLevel[0];
        }
        return (RTCRoomProvider.CyberRtcRoomAudioLevel[]) invokeV.objValue;
    }

    public RTCRoomProvider.CyberRtcRoomVideoDimension getRemoteVideoDimension(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j2)) == null) {
            RTCRoomProvider rTCRoomProvider = this.f39265a;
            return rTCRoomProvider != null ? rTCRoomProvider.getRemoteVideoDimension(j2) : new RTCRoomProvider.CyberRtcRoomVideoDimension();
        }
        return (RTCRoomProvider.CyberRtcRoomVideoDimension) invokeJ.objValue;
    }

    public void getUserAttribute(long j2) {
        RTCRoomProvider rTCRoomProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048588, this, j2) == null) || (rTCRoomProvider = this.f39265a) == null) {
            return;
        }
        rTCRoomProvider.getUserAttribute(j2);
    }

    public RTCRoomProvider.CyberRtcRoomUserInfo[] getUserListOfRoom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            RTCRoomProvider rTCRoomProvider = this.f39265a;
            return rTCRoomProvider != null ? rTCRoomProvider.getUserListOfRoom() : new RTCRoomProvider.CyberRtcRoomUserInfo[0];
        }
        return (RTCRoomProvider.CyberRtcRoomUserInfo[]) invokeV.objValue;
    }

    public synchronized boolean initWithAppID(Context context, String str, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{context, str, str2, str3, Boolean.valueOf(z)})) == null) {
            synchronized (this) {
                if (this.f39265a != null) {
                    return this.f39265a.initWithAppID(context, str, str2, str3, z);
                }
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public void kickOffUserWithID(long j2) {
        RTCRoomProvider rTCRoomProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048591, this, j2) == null) || (rTCRoomProvider = this.f39265a) == null) {
            return;
        }
        rTCRoomProvider.kickOffUserWithID(j2);
    }

    public boolean loginRtcRoomWithRoomName(String str, long j2, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{str, Long.valueOf(j2), str2})) == null) {
            RTCRoomProvider rTCRoomProvider = this.f39265a;
            if (rTCRoomProvider != null) {
                return rTCRoomProvider.loginRtcRoomWithRoomName(str, j2, str2);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean loginRtcRoomWithRoomName(String str, long j2, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{str, Long.valueOf(j2), str2, Boolean.valueOf(z)})) == null) {
            RTCRoomProvider rTCRoomProvider = this.f39265a;
            if (rTCRoomProvider != null) {
                return rTCRoomProvider.loginRtcRoomWithRoomName(str, j2, str2, z);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean loginRtcRoomWithRoomName(String str, long j2, String str2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{str, Long.valueOf(j2), str2, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            RTCRoomProvider rTCRoomProvider = this.f39265a;
            if (rTCRoomProvider != null) {
                return rTCRoomProvider.loginRtcRoomWithRoomName(str, j2, str2, z, z2);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean logoutRtcRoom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            RTCRoomProvider rTCRoomProvider = this.f39265a;
            if (rTCRoomProvider != null) {
                return rTCRoomProvider.logoutRtcRoom();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void muteCamera(boolean z) {
        RTCRoomProvider rTCRoomProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (rTCRoomProvider = this.f39265a) == null) {
            return;
        }
        rTCRoomProvider.muteCamera(z);
    }

    public void muteMicphone(boolean z) {
        RTCRoomProvider rTCRoomProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || (rTCRoomProvider = this.f39265a) == null) {
            return;
        }
        rTCRoomProvider.muteMicphone(z);
    }

    public void presetLoudSpeaker(boolean z) {
        RTCRoomProvider rTCRoomProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || (rTCRoomProvider = this.f39265a) == null) {
            return;
        }
        rTCRoomProvider.presetLoudSpeaker(z);
    }

    public void publishStreaming() {
        RTCRoomProvider rTCRoomProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (rTCRoomProvider = this.f39265a) == null) {
            return;
        }
        rTCRoomProvider.publishStreaming();
    }

    public void sendMessageToUser(String str, long j2) {
        RTCRoomProvider rTCRoomProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048600, this, str, j2) == null) || (rTCRoomProvider = this.f39265a) == null) {
            return;
        }
        rTCRoomProvider.sendMessageToUser(str, j2);
    }

    public void setAudioRecordDelegate(CyberRTCAudioSamples.CyberRTCSamplesReadyCallback cyberRTCSamplesReadyCallback) {
        RTCRoomProvider rTCRoomProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, cyberRTCSamplesReadyCallback) == null) || (rTCRoomProvider = this.f39265a) == null) {
            return;
        }
        rTCRoomProvider.setAudioRecordDelegate(cyberRTCSamplesReadyCallback);
    }

    public void setCyberRTCRoomDelegate(RTCRoomProvider.CyberRtcRoomDelegate cyberRtcRoomDelegate) {
        RTCRoomProvider rTCRoomProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, cyberRtcRoomDelegate) == null) || (rTCRoomProvider = this.f39265a) == null) {
            return;
        }
        rTCRoomProvider.setCyberRTCRoomDelegate(cyberRtcRoomDelegate);
    }

    public void setExternalSurface(long j2, Surface surface) {
        RTCRoomProvider rTCRoomProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(1048603, this, j2, surface) == null) || (rTCRoomProvider = this.f39265a) == null) {
            return;
        }
        rTCRoomProvider.setExternalSurface(j2, surface);
    }

    public void setParamSettings(CyberRTCSetting cyberRTCSetting, CyberRTCSetting.CyberRTCSettingType cyberRTCSettingType) {
        RTCRoomProvider rTCRoomProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048604, this, cyberRTCSetting, cyberRTCSettingType) == null) || (rTCRoomProvider = this.f39265a) == null) {
            return;
        }
        rTCRoomProvider.setParamSettings(cyberRTCSetting, cyberRTCSettingType);
    }

    public void setRemoteAudioPlayState(boolean z, long j2) {
        RTCRoomProvider rTCRoomProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j2)}) == null) || (rTCRoomProvider = this.f39265a) == null) {
            return;
        }
        rTCRoomProvider.setRemoteAudioPlayState(z, j2);
    }

    public void setRemoteDisplay(CyberRTCVideoView cyberRTCVideoView) {
        RTCRoomProvider rTCRoomProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, cyberRTCVideoView) == null) || (rTCRoomProvider = this.f39265a) == null) {
            return;
        }
        rTCRoomProvider.setRemoteDisplay(cyberRTCVideoView);
    }

    public void setRemoteVideoPlayState(boolean z, long j2) {
        RTCRoomProvider rTCRoomProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j2)}) == null) || (rTCRoomProvider = this.f39265a) == null) {
            return;
        }
        rTCRoomProvider.setRemoteVideoPlayState(z, j2);
    }

    public void setSoundMod(RTCRoomProvider.CyberRtcSoundMode cyberRtcSoundMode) {
        RTCRoomProvider rTCRoomProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, cyberRtcSoundMode) == null) || (rTCRoomProvider = this.f39265a) == null) {
            return;
        }
        rTCRoomProvider.setSoundMod(cyberRtcSoundMode);
    }

    public void setUserAttribute(String str) {
        RTCRoomProvider rTCRoomProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, str) == null) || (rTCRoomProvider = this.f39265a) == null) {
            return;
        }
        rTCRoomProvider.setUserAttribute(str);
    }

    public void shutUpUserWithID(long j2) {
        RTCRoomProvider rTCRoomProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048610, this, j2) == null) || (rTCRoomProvider = this.f39265a) == null) {
            return;
        }
        rTCRoomProvider.shutUpUserWithID(j2);
    }

    public void shutUpUserWithID(long j2, boolean z) {
        RTCRoomProvider rTCRoomProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)}) == null) || (rTCRoomProvider = this.f39265a) == null) {
            return;
        }
        rTCRoomProvider.shutUpUserWithID(j2, z);
    }

    public void startPublish() {
        RTCRoomProvider rTCRoomProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || (rTCRoomProvider = this.f39265a) == null) {
            return;
        }
        rTCRoomProvider.startPublish();
    }

    public void stopPublish() {
        RTCRoomProvider rTCRoomProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (rTCRoomProvider = this.f39265a) == null) {
            return;
        }
        rTCRoomProvider.stopPublish();
    }

    public void stopSubscribeStreaming(long j2) {
        RTCRoomProvider rTCRoomProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048614, this, j2) == null) || (rTCRoomProvider = this.f39265a) == null) {
            return;
        }
        rTCRoomProvider.stopSubscribeStreaming(j2);
    }

    public void subscribeStreaming(int i2, long j2) {
        RTCRoomProvider rTCRoomProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (rTCRoomProvider = this.f39265a) == null) {
            return;
        }
        rTCRoomProvider.subscribeStreaming(i2, j2);
    }

    public void switchCamera() {
        RTCRoomProvider rTCRoomProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || (rTCRoomProvider = this.f39265a) == null) {
            return;
        }
        rTCRoomProvider.switchCamera();
    }
}
