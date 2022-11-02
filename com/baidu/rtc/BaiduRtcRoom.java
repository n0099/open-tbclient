package com.baidu.rtc;

import android.content.Context;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.rtc.RTCAudioSamples;
import com.baidu.rtc.RtcParameterSettings;
import com.baidu.rtc.config.Constraints;
import com.baidu.rtc.internal.BaiduRtcRoomImp;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public abstract class BaiduRtcRoom {
    public static /* synthetic */ Interceptable $ic;
    public static ArrayList<BaiduRtcRoomImp> mInstanceList;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public interface BaiduRtcRoomDelegate {
        public static final int RTC_ROOM_EVENTS_DISBAND_ROOM = 112;
        public static final int RTC_ROOM_EVENTS_LIVE_INTRERRUPT = 118;
        public static final int RTC_ROOM_EVENTS_LIVE_PUBLISH_FAIL = 117;
        public static final int RTC_ROOM_EVENTS_LIVE_PUBLISH_SUCCESS = 116;
        public static final int RTC_ROOM_EVENTS_SOMEBODY_DISSHUTUPED = 114;
        public static final int RTC_ROOM_EVENTS_SOMEBODY_KICKOFFED = 115;
        public static final int RTC_ROOM_EVENTS_SOMEBODY_SHUTUPED = 113;
        public static final int RTC_ROOM_EVENT_AVAILABLE_SEND_BITRATE = 200;
        public static final int RTC_ROOM_EVENT_AVAILABLE_SEND_PACKET_LOSS = 201;
        public static final int RTC_ROOM_EVENT_CONNECTION_LOST = 103;
        public static final int RTC_ROOM_EVENT_LOGIN_ERROR = 102;
        public static final int RTC_ROOM_EVENT_LOGIN_OK = 100;
        public static final int RTC_ROOM_EVENT_LOGIN_TIMEOUT = 101;
        public static final int RTC_ROOM_EVENT_ON_USER_ATTRIBUTE = 303;
        public static final int RTC_ROOM_EVENT_ON_USER_JOINED_ROOM = 300;
        public static final int RTC_ROOM_EVENT_ON_USER_LEAVING_ROOM = 301;
        public static final int RTC_ROOM_EVENT_ON_USER_MESSAGE = 302;
        public static final int RTC_ROOM_EVENT_REMOTE_AUDIO_ARRIVED = 108;
        public static final int RTC_ROOM_EVENT_REMOTE_AUDIO_REMOVED = 109;
        public static final int RTC_ROOM_EVENT_REMOTE_COMING = 104;
        public static final int RTC_ROOM_EVENT_REMOTE_GONE = 107;
        public static final int RTC_ROOM_EVENT_REMOTE_LEAVING = 105;
        public static final int RTC_ROOM_EVENT_REMOTE_RENDERING = 106;
        public static final int RTC_ROOM_EVENT_REMOTE_VIDEO_SIZE_CHANGE = 500;
        public static final int RTC_ROOM_PEER_CONNECTION_ERROR = 10000;
        public static final int RTC_ROOM_SERVER_KEEPALIVE_TIMEOUT_ERROR = 402;
        public static final int RTC_ROOM_SET_EXTERNAL_SURFACE_ERROR = 600;
        public static final int RTC_ROOM_SO_LATER_DOWNLOADING_FAIL = 400;
        public static final int RTC_ROOM_SO_LATER_LOADING_FAIL = 401;
        public static final int RTC_ROOM_USERID_ALREADY_EXIST_ERROR = 436;
        public static final int RTC_STATE_SENDING_MEDIA_FAILED = 2002;
        public static final int RTC_STATE_SENDING_MEDIA_OK = 2001;
        public static final int RTC_STATE_STREAM_DOWN = 2003;
        public static final int RTC_STATE_STREAM_SLOW_LINK_LEVEL0 = 2100;
        public static final int RTC_STATE_STREAM_SLOW_LINK_LEVEL1 = 2101;
        public static final int RTC_STATE_STREAM_SLOW_LINK_LEVEL2 = 2102;
        public static final int RTC_STATE_STREAM_SLOW_LINK_LEVEL3 = 2103;
        public static final int RTC_STATE_STREAM_SLOW_LINK_LEVEL4 = 2104;
        public static final int RTC_STATE_STREAM_SLOW_LINK_LEVEL5 = 2105;
        public static final int RTC_STATE_STREAM_SLOW_LINK_LEVEL6 = 2106;
        public static final int RTC_STATE_STREAM_SLOW_LINK_LEVEL7 = 2107;
        public static final int RTC_STATE_STREAM_SLOW_LINK_LEVEL8 = 2108;
        public static final int RTC_STATE_STREAM_SLOW_LINK_LEVEL9 = 2109;
        public static final int RTC_STATE_STREAM_UP = 2000;

        void onEngineStatisticsInfo(int i);

        void onErrorInfoUpdate(int i);

        void onPeerConnectStateUpdate(int i);

        void onRoomDataMessage(ByteBuffer byteBuffer);

        void onRoomEventUpdate(int i, long j, String str);

        void onStreamInfoUpdate(String[] strArr);
    }

    /* loaded from: classes2.dex */
    public interface BaiduRtcRoomVideoObserver {
        void getInputBuffer(int i, int i2, RtcVideoFormat rtcVideoFormat);

        void onVideoFrame(RTCVideoFrame rTCVideoFrame, long j);
    }

    public abstract void addExternalRenderer(long j, RTCVideoExternalRender rTCVideoExternalRender);

    public abstract void cameraFocusWithPoint(int i, int i2);

    public abstract void changeSurfaceSize(long j, int i, int i2);

    public abstract boolean configLiveServerWithUrl(String str, boolean z, boolean z2, String str2, RtcLiveTransferMode rtcLiveTransferMode);

    public abstract void destroyExternalSurface(long j, Surface surface);

    public abstract void disbandRoom();

    public abstract void enableAgc(boolean z);

    public abstract void enableAns(boolean z);

    public abstract void enableAudioMix(boolean z);

    public abstract void enableErrorInfoToServer(boolean z, String str);

    public abstract void enableExternalAudioRecord(boolean z);

    public abstract void enableExternalVideoCapturer(boolean z);

    public abstract void enableLaterLoadSo(String str);

    public abstract void enableStatsToServer(boolean z, String str);

    public abstract void enableStatsToServer(boolean z, boolean z2, String str);

    public abstract RTCAudioSamples.RTCExternalSamplesReadyCallback getExternalAudioSamplesCallback();

    public abstract RtcRoomAudioLevel[] getRemoteAudioLevels();

    public abstract RtcRoomVideoDimension getRemoteVideoDimension(long j);

    public abstract void getUserAttribute(long j);

    public abstract RtcRoomUserInfo[] getUserListOfRoom();

    public abstract boolean isExternalAudioRecord();

    public abstract boolean isSpeakerOn();

    public abstract void kickOffUserWithId(long j);

    public abstract boolean loginRtcRoomWithRoomName(String str, long j, String str2);

    public abstract boolean loginRtcRoomWithRoomName(String str, long j, String str2, boolean z);

    public abstract boolean loginRtcRoomWithRoomName(String str, long j, String str2, boolean z, boolean z2);

    public abstract boolean logoutRtcRoom();

    public abstract void muteCamera(boolean z);

    public abstract void muteMicphone(boolean z);

    public abstract void muteSpeaker(boolean z);

    public abstract void presetLoudSpeaker(boolean z);

    public abstract void publishStreaming();

    public abstract void queryEngineStatisticsInfo();

    public abstract UserList queryUserListOfRoom();

    public abstract void removeExternalRenderer(long j);

    public abstract void sendData(ByteBuffer byteBuffer);

    public abstract void sendMessageToUser(String str, long j);

    public abstract void setAudioRecordDelegate(RTCAudioSamples.RTCSamplesReadyCallback rTCSamplesReadyCallback);

    public abstract void setAuidoSamplesReadyCallback(RTCAudioSamples.RTCSamplesReadyCallback rTCSamplesReadyCallback);

    public void setBaiduRtcAppID(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048616, this, str, str2) == null) {
        }
    }

    public abstract boolean setBaiduRtcRoomDelegate(BaiduRtcRoomDelegate baiduRtcRoomDelegate);

    public abstract void setBuffingFactor(float f);

    public abstract void setCameraID(int i);

    public abstract void setEngineStateStatistics(boolean z);

    public abstract void setExternalSurface(long j, Surface surface);

    public abstract boolean setLiveStreamingMix(boolean z);

    public abstract boolean setLiveStreamingRole(String str);

    public abstract boolean setLiveStreamingURL(String str);

    public abstract void setLocalDisplay(RTCVideoView rTCVideoView);

    public abstract void setMediaServerURL(String str);

    public abstract boolean setMixLayoutPositionIndex(String str);

    public abstract void setMixedAudioSamplesCallback(RTCAudioSamples.RTCMixedSamplesReadyCallback rTCMixedSamplesReadyCallback);

    public abstract void setParamSettings(RtcParameterSettings rtcParameterSettings, RtcParameterSettings.RtcParamSettingType rtcParamSettingType);

    public abstract boolean setRecording(boolean z);

    public abstract void setRedenFactor(float f);

    public abstract void setRemoteAudioPlayState(boolean z, long j);

    public abstract void setRemoteAudioSamplesCallback(RTCAudioSamples.RTCRemoteSamplesReadyCallback rTCRemoteSamplesReadyCallback);

    public abstract void setRemoteDisplay(RTCVideoView rTCVideoView);

    public abstract void setRemoteDisplay(RTCVideoView rTCVideoView, long j);

    public abstract void setRemoteDisplayGroup(RTCVideoView[] rTCVideoViewArr);

    public abstract void setRemoteVideoPlayState(boolean z, long j);

    public abstract void setSoLaterLoadUrl(String str);

    public abstract void setSoundMod(RtcSoundMode rtcSoundMode);

    public abstract void setUserAttribute(String str);

    public abstract void setVideoCapture(RTCVideoCapture rTCVideoCapture);

    public abstract void setWhitenFactor(float f);

    public abstract void shutUpUserWithId(long j);

    public abstract void shutUpUserWithId(long j, boolean z);

    public abstract boolean startLiveServerStreaming(String str, boolean z, boolean z2, String str2, RtcLiveTransferMode rtcLiveTransferMode);

    public abstract void startPreview();

    public abstract void startPublish();

    public abstract boolean stopLiveServerStreaming(RtcLiveTransferMode rtcLiveTransferMode);

    public abstract void stopPreview();

    public abstract void stopPublish();

    public abstract void stopSubscribeStreaming(long j);

    public abstract void subscribeStreaming(int i, long j);

    public abstract void switchCamera();

    public abstract void switchLoundSpeaker();

    public abstract void upLoadLog();

    /* loaded from: classes2.dex */
    public static class RoomInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String MediaServerURL;
        public String RoomID;

        public RoomInfo() {
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
            this.MediaServerURL = "";
            this.RoomID = "";
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class RtcLiveTransferMode {
        public static final /* synthetic */ RtcLiveTransferMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final RtcLiveTransferMode RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION;
        public static final RtcLiveTransferMode RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1767943705, "Lcom/baidu/rtc/BaiduRtcRoom$RtcLiveTransferMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1767943705, "Lcom/baidu/rtc/BaiduRtcRoom$RtcLiveTransferMode;");
                    return;
                }
            }
            RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION = new RtcLiveTransferMode("RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION", 0);
            RtcLiveTransferMode rtcLiveTransferMode = new RtcLiveTransferMode("RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION", 1);
            RTC_LIVE_TRANSFER_MODE_ANCHOR_TRASNSMISSION = rtcLiveTransferMode;
            $VALUES = new RtcLiveTransferMode[]{RTC_LIVE_TRANSFER_MODE_ROOM_TRANSMISSION, rtcLiveTransferMode};
        }

        public RtcLiveTransferMode(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static RtcLiveTransferMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (RtcLiveTransferMode) Enum.valueOf(RtcLiveTransferMode.class, str);
            }
            return (RtcLiveTransferMode) invokeL.objValue;
        }

        public static RtcLiveTransferMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (RtcLiveTransferMode[]) $VALUES.clone();
            }
            return (RtcLiveTransferMode[]) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class RtcRoomAudioLevel {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String nicName;
        public long userId;
        public int volumeLevel;

        public RtcRoomAudioLevel() {
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
            this.userId = 0L;
            this.nicName = "";
            this.volumeLevel = 0;
        }
    }

    /* loaded from: classes2.dex */
    public static class RtcRoomUserInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String attribute;
        public int role;
        public long userId;
        public String userName;

        public RtcRoomUserInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class RtcRoomVideoDimension {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int videoHeight;
        public int videoRotation;
        public int videoWidth;

        public RtcRoomVideoDimension() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class RtcSoundMode {
        public static final /* synthetic */ RtcSoundMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final RtcSoundMode RTC_SOUND_MODE_EAR;
        public static final RtcSoundMode RTC_SOUND_MODE_SPEAKER;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1644192701, "Lcom/baidu/rtc/BaiduRtcRoom$RtcSoundMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1644192701, "Lcom/baidu/rtc/BaiduRtcRoom$RtcSoundMode;");
                    return;
                }
            }
            RTC_SOUND_MODE_SPEAKER = new RtcSoundMode("RTC_SOUND_MODE_SPEAKER", 0);
            RtcSoundMode rtcSoundMode = new RtcSoundMode("RTC_SOUND_MODE_EAR", 1);
            RTC_SOUND_MODE_EAR = rtcSoundMode;
            $VALUES = new RtcSoundMode[]{RTC_SOUND_MODE_SPEAKER, rtcSoundMode};
        }

        public RtcSoundMode(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static RtcSoundMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (RtcSoundMode) Enum.valueOf(RtcSoundMode.class, str);
            }
            return (RtcSoundMode) invokeL.objValue;
        }

        public static RtcSoundMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (RtcSoundMode[]) $VALUES.clone();
            }
            return (RtcSoundMode[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class RtcVideoFormat {
        public static final /* synthetic */ RtcVideoFormat[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final RtcVideoFormat RTC_VIDEO_FORMAT_RGBA;
        public static final RtcVideoFormat RTC_VIDEO_FORMAT_YUV420;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1277478083, "Lcom/baidu/rtc/BaiduRtcRoom$RtcVideoFormat;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1277478083, "Lcom/baidu/rtc/BaiduRtcRoom$RtcVideoFormat;");
                    return;
                }
            }
            RTC_VIDEO_FORMAT_YUV420 = new RtcVideoFormat("RTC_VIDEO_FORMAT_YUV420", 0);
            RtcVideoFormat rtcVideoFormat = new RtcVideoFormat("RTC_VIDEO_FORMAT_RGBA", 1);
            RTC_VIDEO_FORMAT_RGBA = rtcVideoFormat;
            $VALUES = new RtcVideoFormat[]{RTC_VIDEO_FORMAT_YUV420, rtcVideoFormat};
        }

        public RtcVideoFormat(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static RtcVideoFormat valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (RtcVideoFormat) Enum.valueOf(RtcVideoFormat.class, str);
            }
            return (RtcVideoFormat) invokeL.objValue;
        }

        public static RtcVideoFormat[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (RtcVideoFormat[]) $VALUES.clone();
            }
            return (RtcVideoFormat[]) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class UserList {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long[] Listeners;
        public long[] Publishers;

        public UserList(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (i > 0) {
                this.Publishers = new long[i];
            } else {
                this.Publishers = null;
            }
            if (i2 > 0) {
                this.Listeners = new long[i2];
            } else {
                this.Listeners = null;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(218527614, "Lcom/baidu/rtc/BaiduRtcRoom;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(218527614, "Lcom/baidu/rtc/BaiduRtcRoom;");
                return;
            }
        }
        mInstanceList = new ArrayList<>();
    }

    public BaiduRtcRoom() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String version() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return Constraints.version();
        }
        return (String) invokeV.objValue;
    }

    public synchronized void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if (mInstanceList.size() > 0) {
                    if (this instanceof BaiduRtcRoomImp) {
                        ((BaiduRtcRoomImp) this).doDestroy();
                    }
                    mInstanceList.remove(this);
                    System.gc();
                }
            }
        }
    }

    public static RoomInfo getRoomInfofromPlatformServer(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, str, str2, str3, str4)) == null) {
            return BaiduRtcRoomImp.getRoomInfofromPlatformServer(str, str2, str3, str4);
        }
        return (RoomInfo) invokeLLLL.objValue;
    }

    public static synchronized BaiduRtcRoom initWithAppID(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        BaiduRtcRoom initWithAppID;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, str2)) == null) {
            synchronized (BaiduRtcRoom.class) {
                initWithAppID = initWithAppID(context, str, str2, "", false);
            }
            return initWithAppID;
        }
        return (BaiduRtcRoom) invokeLLL.objValue;
    }

    public static synchronized BaiduRtcRoom initWithAppID(Context context, String str, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, str, str2, str3, Boolean.valueOf(z)})) == null) {
            synchronized (BaiduRtcRoom.class) {
                if (context != null) {
                    BaiduRtcRoomImp baiduRtcRoomImp = new BaiduRtcRoomImp(context, str, str2, str3, z);
                    mInstanceList.add(baiduRtcRoomImp);
                    return baiduRtcRoomImp;
                }
                return null;
            }
        }
        return (BaiduRtcRoom) invokeCommon.objValue;
    }

    public static void setUseTestEnv(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, null, z) == null) {
            BaiduRtcRoomImp.setUseTestEnv(z);
        }
    }

    public static void setVerbose(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65542, null, z) == null) {
            BaiduRtcRoomImp.setVerbose(z);
        }
    }
}
