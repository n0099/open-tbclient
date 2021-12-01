package com.baidu.cyberplayer.sdk.rtc;

import android.content.Context;
import android.view.Surface;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.cyberplayer.sdk.rtc.CyberRTCAudioSamples;
import com.baidu.cyberplayer.sdk.rtc.CyberRTCSetting;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
@Keep
/* loaded from: classes8.dex */
public abstract class RTCRoomProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Keep
    /* loaded from: classes8.dex */
    public static final class CyberRtcLiveTransferMode {
        public static /* synthetic */ Interceptable $ic;
        public static final CyberRtcLiveTransferMode RTC_LIVE_TRANSFER_MODE_ANCHOR_TRANSMISSION;
        public static final CyberRtcLiveTransferMode RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION;
        public static final /* synthetic */ CyberRtcLiveTransferMode[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1806424764, "Lcom/baidu/cyberplayer/sdk/rtc/RTCRoomProvider$CyberRtcLiveTransferMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1806424764, "Lcom/baidu/cyberplayer/sdk/rtc/RTCRoomProvider$CyberRtcLiveTransferMode;");
                    return;
                }
            }
            RTC_LIVE_TRANSFER_MODE_ANCHOR_TRANSMISSION = new CyberRtcLiveTransferMode("RTC_LIVE_TRANSFER_MODE_ANCHOR_TRANSMISSION", 0);
            CyberRtcLiveTransferMode cyberRtcLiveTransferMode = new CyberRtcLiveTransferMode("RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION", 1);
            RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION = cyberRtcLiveTransferMode;
            a = new CyberRtcLiveTransferMode[]{RTC_LIVE_TRANSFER_MODE_ANCHOR_TRANSMISSION, cyberRtcLiveTransferMode};
        }

        public CyberRtcLiveTransferMode(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static CyberRtcLiveTransferMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CyberRtcLiveTransferMode) Enum.valueOf(CyberRtcLiveTransferMode.class, str) : (CyberRtcLiveTransferMode) invokeL.objValue;
        }

        public static CyberRtcLiveTransferMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CyberRtcLiveTransferMode[]) a.clone() : (CyberRtcLiveTransferMode[]) invokeV.objValue;
        }
    }

    @Keep
    /* loaded from: classes8.dex */
    public static class CyberRtcRoomAudioLevel {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String nicName;
        public long userID;
        public int volumeLevel;

        public CyberRtcRoomAudioLevel(long j2, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2), str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.userID = j2;
            this.nicName = str;
            this.volumeLevel = i2;
        }
    }

    @Keep
    /* loaded from: classes8.dex */
    public interface CyberRtcRoomDelegate {
        void onEngineStatisticsInfo(int i2);

        void onErrorInfoUpdate(int i2);

        void onPeerConnectStateUpdate(int i2);

        void onRoomDataMessage(ByteBuffer byteBuffer);

        void onRoomEventUpdate(int i2, long j2, String str);

        void onStreamInfoUpdate(String[] strArr);
    }

    @Keep
    /* loaded from: classes8.dex */
    public static class CyberRtcRoomUserInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String attribute;
        public int role;
        public long userID;
        public String userName;

        public CyberRtcRoomUserInfo(long j2, String str, String str2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2), str, str2, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.userID = j2;
            this.userName = str;
            this.attribute = str2;
            this.role = i2;
        }
    }

    @Keep
    /* loaded from: classes8.dex */
    public static class CyberRtcRoomVideoDimension {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int videoHeight;
        public int videoRotation;
        public int videoWidth;

        public CyberRtcRoomVideoDimension() {
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
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Keep
    /* loaded from: classes8.dex */
    public static final class CyberRtcSoundMode {
        public static /* synthetic */ Interceptable $ic;
        public static final CyberRtcSoundMode RTC_SOUND_MODE_EAR;
        public static final CyberRtcSoundMode RTC_SOUND_MODE_SPEAKER;
        public static final /* synthetic */ CyberRtcSoundMode[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1215551218, "Lcom/baidu/cyberplayer/sdk/rtc/RTCRoomProvider$CyberRtcSoundMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1215551218, "Lcom/baidu/cyberplayer/sdk/rtc/RTCRoomProvider$CyberRtcSoundMode;");
                    return;
                }
            }
            RTC_SOUND_MODE_SPEAKER = new CyberRtcSoundMode("RTC_SOUND_MODE_SPEAKER", 0);
            CyberRtcSoundMode cyberRtcSoundMode = new CyberRtcSoundMode("RTC_SOUND_MODE_EAR", 1);
            RTC_SOUND_MODE_EAR = cyberRtcSoundMode;
            a = new CyberRtcSoundMode[]{RTC_SOUND_MODE_SPEAKER, cyberRtcSoundMode};
        }

        public CyberRtcSoundMode(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static CyberRtcSoundMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CyberRtcSoundMode) Enum.valueOf(CyberRtcSoundMode.class, str) : (CyberRtcSoundMode) invokeL.objValue;
        }

        public static CyberRtcSoundMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CyberRtcSoundMode[]) a.clone() : (CyberRtcSoundMode[]) invokeV.objValue;
        }
    }

    public RTCRoomProvider() {
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

    public abstract void changeSurfaceSize(long j2, int i2, int i3);

    public abstract boolean configLiveServerWithUrl(String str, boolean z, boolean z2, String str2, CyberRtcLiveTransferMode cyberRtcLiveTransferMode);

    public abstract void destroy();

    public abstract void destroyExternalSurface(long j2, Surface surface);

    public abstract void disbandRoom();

    public abstract void enableAgc(boolean z);

    public abstract void enableAns(boolean z);

    public abstract void enableExternalVideoCapturer(boolean z);

    public abstract void enableStatsToServer(boolean z, String str);

    public abstract CyberRtcRoomAudioLevel[] getRemoteAudioLevels();

    public abstract CyberRtcRoomVideoDimension getRemoteVideoDimension(long j2);

    public abstract void getUserAttribute(long j2);

    public abstract CyberRtcRoomUserInfo[] getUserListOfRoom();

    public abstract boolean initWithAppID(Context context, String str, String str2, String str3, boolean z);

    public abstract void kickOffUserWithID(long j2);

    public abstract boolean loginRtcRoomWithRoomName(String str, long j2, String str2);

    public abstract boolean loginRtcRoomWithRoomName(String str, long j2, String str2, boolean z);

    public abstract boolean loginRtcRoomWithRoomName(String str, long j2, String str2, boolean z, boolean z2);

    public abstract boolean logoutRtcRoom();

    public abstract void muteCamera(boolean z);

    public abstract void muteMicphone(boolean z);

    public abstract void presetLoudSpeaker(boolean z);

    public abstract void publishStreaming();

    public abstract void sendMessageToUser(String str, long j2);

    public abstract void setAudioRecordDelegate(CyberRTCAudioSamples.CyberRTCSamplesReadyCallback cyberRTCSamplesReadyCallback);

    public abstract void setCyberRTCRoomDelegate(CyberRtcRoomDelegate cyberRtcRoomDelegate);

    public abstract void setExternalSurface(long j2, Surface surface);

    public abstract void setParamSettings(CyberRTCSetting cyberRTCSetting, CyberRTCSetting.CyberRTCSettingType cyberRTCSettingType);

    public abstract void setRemoteAudioPlayState(boolean z, long j2);

    public abstract void setRemoteDisplay(CyberRTCVideoView cyberRTCVideoView);

    public abstract void setRemoteVideoPlayState(boolean z, long j2);

    public abstract void setSoundMod(CyberRtcSoundMode cyberRtcSoundMode);

    public abstract void setUserAttribute(String str);

    public abstract void shutUpUserWithID(long j2);

    public abstract void shutUpUserWithID(long j2, boolean z);

    public abstract void startPublish();

    public abstract void stopPublish();

    public abstract void stopSubscribeStreaming(long j2);

    public abstract void subscribeStreaming(int i2, long j2);

    public abstract void switchCamera();
}
