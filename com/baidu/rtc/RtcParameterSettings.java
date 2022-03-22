package com.baidu.rtc;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class RtcParameterSettings {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int AudioBufferPackets;
    public int AudioChannel;
    public String AudioCodec;
    public int AudioCodecComplex;
    public int AudioContentType;
    public int AudioFrequency;
    public int AudioMaxkbps;
    public int AudioPlayoutDelay;
    public int AudioSource;
    public boolean AutoPublish;
    public boolean AutoSubScribe;
    public boolean CameraMuted;
    public int ConnectionTimeoutMs;
    public boolean DisableBuiltInAEC;
    public boolean DisableExtraCamera;
    public boolean EnableAacCodec;
    public boolean EnableFixedResolution;
    public boolean EnableHighProfile;
    public boolean EnableHisiH264HW;
    public boolean EnableMTKH264Decode;
    public boolean EnableRequiredResolutionAligment32;
    public int EncodeBitrateMode;
    public boolean HasAudio;
    public boolean HasData;
    public boolean HasVideo;
    public String MediaServerIP;
    public boolean MicPhoneMuted;
    public int ReadTimeoutMs;
    public RtcAudioChannel TransportAudioChannel;
    public String VideoCodec;
    public int VideoFps;
    public int VideoHeight;
    public int VideoMaxkbps;
    public int VideoMinkbps;
    public RtcVideoRenderMode VideoRenderMode;
    public String VideoResolution;
    public int VideoWidth;
    public RtcAudioBitrateMode audioBitrateMode;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class RtcAudioBitrateMode {
        public static final /* synthetic */ RtcAudioBitrateMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final RtcAudioBitrateMode RTC_AUDIO_BITRATE_CBR;
        public static final RtcAudioBitrateMode RTC_AUDIO_BITRATE_VBR;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1882680349, "Lcom/baidu/rtc/RtcParameterSettings$RtcAudioBitrateMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1882680349, "Lcom/baidu/rtc/RtcParameterSettings$RtcAudioBitrateMode;");
                    return;
                }
            }
            RTC_AUDIO_BITRATE_CBR = new RtcAudioBitrateMode("RTC_AUDIO_BITRATE_CBR", 0);
            RtcAudioBitrateMode rtcAudioBitrateMode = new RtcAudioBitrateMode("RTC_AUDIO_BITRATE_VBR", 1);
            RTC_AUDIO_BITRATE_VBR = rtcAudioBitrateMode;
            $VALUES = new RtcAudioBitrateMode[]{RTC_AUDIO_BITRATE_CBR, rtcAudioBitrateMode};
        }

        public RtcAudioBitrateMode(String str, int i) {
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

        public static RtcAudioBitrateMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (RtcAudioBitrateMode) Enum.valueOf(RtcAudioBitrateMode.class, str) : (RtcAudioBitrateMode) invokeL.objValue;
        }

        public static RtcAudioBitrateMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (RtcAudioBitrateMode[]) $VALUES.clone() : (RtcAudioBitrateMode[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class RtcAudioChannel {
        public static final /* synthetic */ RtcAudioChannel[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final RtcAudioChannel RTC_AUDIO_MONNO;
        public static final RtcAudioChannel RTC_AUDIO_STEREO;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(606600490, "Lcom/baidu/rtc/RtcParameterSettings$RtcAudioChannel;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(606600490, "Lcom/baidu/rtc/RtcParameterSettings$RtcAudioChannel;");
                    return;
                }
            }
            RTC_AUDIO_MONNO = new RtcAudioChannel("RTC_AUDIO_MONNO", 0);
            RtcAudioChannel rtcAudioChannel = new RtcAudioChannel("RTC_AUDIO_STEREO", 1);
            RTC_AUDIO_STEREO = rtcAudioChannel;
            $VALUES = new RtcAudioChannel[]{RTC_AUDIO_MONNO, rtcAudioChannel};
        }

        public RtcAudioChannel(String str, int i) {
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

        public static RtcAudioChannel valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (RtcAudioChannel) Enum.valueOf(RtcAudioChannel.class, str) : (RtcAudioChannel) invokeL.objValue;
        }

        public static RtcAudioChannel[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (RtcAudioChannel[]) $VALUES.clone() : (RtcAudioChannel[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class RtcParamSettingType {
        public static final /* synthetic */ RtcParamSettingType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final RtcParamSettingType RTC_AUDIO_PARAM_SETTINGS_AEC_DUMP;
        public static final RtcParamSettingType RTC_AUDIO_PARAM_SETTINGS_EXPORT_PLAYOUT;
        public static final RtcParamSettingType RTC_AUDIO_PARAM_SETTINGS_EXPORT_RECORD;
        public static final RtcParamSettingType RTC_AUDIO_PARAM_SETTINGS_EXPORT_RECORD_PLAYOUT_MIX;
        public static final RtcParamSettingType RTC_AUDIO_PARAM_SETTINGS_LEVEL_CONTROL;
        public static final RtcParamSettingType RTC_AUDIO_PARAM_SETTINGS_MANUAL_CONFIG;
        public static final RtcParamSettingType RTC_AUDIO_PARAM_SETTINGS_ONLY_AUDIO;
        public static final RtcParamSettingType RTC_PARAM_SETTINGS_ALL;
        public static final RtcParamSettingType RTC_PARAM_SETTINGS_OTHERS;
        public static final RtcParamSettingType RTC_VIDEO_PARAM_SETTINGS_BITRATE;
        public static final RtcParamSettingType RTC_VIDEO_PARAM_SETTINGS_CAPTURE_MODE;
        public static final RtcParamSettingType RTC_VIDEO_PARAM_SETTINGS_CODECTYPE;
        public static final RtcParamSettingType RTC_VIDEO_PARAM_SETTINGS_FPS;
        public static final RtcParamSettingType RTC_VIDEO_PARAM_SETTINGS_RENDER_MODE;
        public static final RtcParamSettingType RTC_VIDEO_PARAM_SETTINGS_RESOLUTION;
        public static final RtcParamSettingType RTC_VIDEO_PARAM_SETTINGS_SESSION_MODE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-435638630, "Lcom/baidu/rtc/RtcParameterSettings$RtcParamSettingType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-435638630, "Lcom/baidu/rtc/RtcParameterSettings$RtcParamSettingType;");
                    return;
                }
            }
            RTC_AUDIO_PARAM_SETTINGS_ONLY_AUDIO = new RtcParamSettingType("RTC_AUDIO_PARAM_SETTINGS_ONLY_AUDIO", 0);
            RTC_AUDIO_PARAM_SETTINGS_AEC_DUMP = new RtcParamSettingType("RTC_AUDIO_PARAM_SETTINGS_AEC_DUMP", 1);
            RTC_AUDIO_PARAM_SETTINGS_LEVEL_CONTROL = new RtcParamSettingType("RTC_AUDIO_PARAM_SETTINGS_LEVEL_CONTROL", 2);
            RTC_AUDIO_PARAM_SETTINGS_MANUAL_CONFIG = new RtcParamSettingType("RTC_AUDIO_PARAM_SETTINGS_MANUAL_CONFIG", 3);
            RTC_AUDIO_PARAM_SETTINGS_EXPORT_RECORD = new RtcParamSettingType("RTC_AUDIO_PARAM_SETTINGS_EXPORT_RECORD", 4);
            RTC_AUDIO_PARAM_SETTINGS_EXPORT_PLAYOUT = new RtcParamSettingType("RTC_AUDIO_PARAM_SETTINGS_EXPORT_PLAYOUT", 5);
            RTC_AUDIO_PARAM_SETTINGS_EXPORT_RECORD_PLAYOUT_MIX = new RtcParamSettingType("RTC_AUDIO_PARAM_SETTINGS_EXPORT_RECORD_PLAYOUT_MIX", 6);
            RTC_VIDEO_PARAM_SETTINGS_FPS = new RtcParamSettingType("RTC_VIDEO_PARAM_SETTINGS_FPS", 7);
            RTC_VIDEO_PARAM_SETTINGS_RESOLUTION = new RtcParamSettingType("RTC_VIDEO_PARAM_SETTINGS_RESOLUTION", 8);
            RTC_VIDEO_PARAM_SETTINGS_BITRATE = new RtcParamSettingType("RTC_VIDEO_PARAM_SETTINGS_BITRATE", 9);
            RTC_VIDEO_PARAM_SETTINGS_CODECTYPE = new RtcParamSettingType("RTC_VIDEO_PARAM_SETTINGS_CODECTYPE", 10);
            RTC_VIDEO_PARAM_SETTINGS_SESSION_MODE = new RtcParamSettingType("RTC_VIDEO_PARAM_SETTINGS_SESSION_MODE", 11);
            RTC_VIDEO_PARAM_SETTINGS_CAPTURE_MODE = new RtcParamSettingType("RTC_VIDEO_PARAM_SETTINGS_CAPTURE_MODE", 12);
            RTC_VIDEO_PARAM_SETTINGS_RENDER_MODE = new RtcParamSettingType("RTC_VIDEO_PARAM_SETTINGS_RENDER_MODE", 13);
            RTC_PARAM_SETTINGS_ALL = new RtcParamSettingType("RTC_PARAM_SETTINGS_ALL", 14);
            RtcParamSettingType rtcParamSettingType = new RtcParamSettingType("RTC_PARAM_SETTINGS_OTHERS", 15);
            RTC_PARAM_SETTINGS_OTHERS = rtcParamSettingType;
            $VALUES = new RtcParamSettingType[]{RTC_AUDIO_PARAM_SETTINGS_ONLY_AUDIO, RTC_AUDIO_PARAM_SETTINGS_AEC_DUMP, RTC_AUDIO_PARAM_SETTINGS_LEVEL_CONTROL, RTC_AUDIO_PARAM_SETTINGS_MANUAL_CONFIG, RTC_AUDIO_PARAM_SETTINGS_EXPORT_RECORD, RTC_AUDIO_PARAM_SETTINGS_EXPORT_PLAYOUT, RTC_AUDIO_PARAM_SETTINGS_EXPORT_RECORD_PLAYOUT_MIX, RTC_VIDEO_PARAM_SETTINGS_FPS, RTC_VIDEO_PARAM_SETTINGS_RESOLUTION, RTC_VIDEO_PARAM_SETTINGS_BITRATE, RTC_VIDEO_PARAM_SETTINGS_CODECTYPE, RTC_VIDEO_PARAM_SETTINGS_SESSION_MODE, RTC_VIDEO_PARAM_SETTINGS_CAPTURE_MODE, RTC_VIDEO_PARAM_SETTINGS_RENDER_MODE, RTC_PARAM_SETTINGS_ALL, rtcParamSettingType};
        }

        public RtcParamSettingType(String str, int i) {
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

        public static RtcParamSettingType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (RtcParamSettingType) Enum.valueOf(RtcParamSettingType.class, str) : (RtcParamSettingType) invokeL.objValue;
        }

        public static RtcParamSettingType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (RtcParamSettingType[]) $VALUES.clone() : (RtcParamSettingType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class RtcVideoBitrateMode {
        public static final /* synthetic */ RtcVideoBitrateMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final RtcVideoBitrateMode RTC_VIDEO_CONTROLRATECONSTANT;
        public static final RtcVideoBitrateMode RTC_VIDEO_CONTROLRATEDISABLE;
        public static final RtcVideoBitrateMode RTC_VIDEO_CONTROLRATEVARIABLE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-203877054, "Lcom/baidu/rtc/RtcParameterSettings$RtcVideoBitrateMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-203877054, "Lcom/baidu/rtc/RtcParameterSettings$RtcVideoBitrateMode;");
                    return;
                }
            }
            RTC_VIDEO_CONTROLRATEDISABLE = new RtcVideoBitrateMode("RTC_VIDEO_CONTROLRATEDISABLE", 0);
            RTC_VIDEO_CONTROLRATEVARIABLE = new RtcVideoBitrateMode("RTC_VIDEO_CONTROLRATEVARIABLE", 1);
            RtcVideoBitrateMode rtcVideoBitrateMode = new RtcVideoBitrateMode("RTC_VIDEO_CONTROLRATECONSTANT", 2);
            RTC_VIDEO_CONTROLRATECONSTANT = rtcVideoBitrateMode;
            $VALUES = new RtcVideoBitrateMode[]{RTC_VIDEO_CONTROLRATEDISABLE, RTC_VIDEO_CONTROLRATEVARIABLE, rtcVideoBitrateMode};
        }

        public RtcVideoBitrateMode(String str, int i) {
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

        public static RtcVideoBitrateMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (RtcVideoBitrateMode) Enum.valueOf(RtcVideoBitrateMode.class, str) : (RtcVideoBitrateMode) invokeL.objValue;
        }

        public static RtcVideoBitrateMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (RtcVideoBitrateMode[]) $VALUES.clone() : (RtcVideoBitrateMode[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class RtcVideoRenderMode {
        public static final /* synthetic */ RtcVideoRenderMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final RtcVideoRenderMode RTC_VIDEO_RENDER_MODE_EXTERNAL;
        public static final RtcVideoRenderMode RTC_VIDEO_RENDER_MODE_INTERNAL;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1478272405, "Lcom/baidu/rtc/RtcParameterSettings$RtcVideoRenderMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1478272405, "Lcom/baidu/rtc/RtcParameterSettings$RtcVideoRenderMode;");
                    return;
                }
            }
            RTC_VIDEO_RENDER_MODE_INTERNAL = new RtcVideoRenderMode("RTC_VIDEO_RENDER_MODE_INTERNAL", 0);
            RtcVideoRenderMode rtcVideoRenderMode = new RtcVideoRenderMode("RTC_VIDEO_RENDER_MODE_EXTERNAL", 1);
            RTC_VIDEO_RENDER_MODE_EXTERNAL = rtcVideoRenderMode;
            $VALUES = new RtcVideoRenderMode[]{RTC_VIDEO_RENDER_MODE_INTERNAL, rtcVideoRenderMode};
        }

        public RtcVideoRenderMode(String str, int i) {
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

        public static RtcVideoRenderMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (RtcVideoRenderMode) Enum.valueOf(RtcVideoRenderMode.class, str) : (RtcVideoRenderMode) invokeL.objValue;
        }

        public static RtcVideoRenderMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (RtcVideoRenderMode[]) $VALUES.clone() : (RtcVideoRenderMode[]) invokeV.objValue;
        }
    }

    public RtcParameterSettings() {
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
        this.HasVideo = true;
        this.HasAudio = true;
        this.HasData = false;
        this.VideoCodec = "h264";
        this.AudioCodec = "opus";
        this.AudioFrequency = 48000;
        this.AudioChannel = 1;
        this.VideoResolution = "640x480";
        this.VideoWidth = 640;
        this.VideoHeight = 480;
        this.VideoFps = 20;
        this.VideoMaxkbps = 1000;
        this.VideoMinkbps = 1000;
        this.AudioMaxkbps = -1;
        this.audioBitrateMode = RtcAudioBitrateMode.RTC_AUDIO_BITRATE_CBR;
        this.TransportAudioChannel = RtcAudioChannel.RTC_AUDIO_MONNO;
        this.AudioSource = 7;
        this.AudioBufferPackets = 50;
        this.AudioCodecComplex = -1;
        this.AudioPlayoutDelay = -1;
        this.ConnectionTimeoutMs = 5000;
        this.ReadTimeoutMs = 5000;
        this.AutoPublish = true;
        this.AutoSubScribe = true;
        this.AudioContentType = 1;
        this.VideoRenderMode = RtcVideoRenderMode.RTC_VIDEO_RENDER_MODE_INTERNAL;
        this.MicPhoneMuted = false;
        this.CameraMuted = false;
        this.EnableFixedResolution = false;
        this.EnableRequiredResolutionAligment32 = false;
        this.DisableExtraCamera = false;
        this.EnableHighProfile = false;
        this.DisableBuiltInAEC = false;
        this.EnableHisiH264HW = true;
        this.EnableMTKH264Decode = true;
        this.EnableAacCodec = false;
        this.MediaServerIP = "";
        this.EncodeBitrateMode = RtcVideoBitrateMode.RTC_VIDEO_CONTROLRATECONSTANT.ordinal();
    }

    public static RtcParameterSettings getDefaultSettings() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new RtcParameterSettings() : (RtcParameterSettings) invokeV.objValue;
    }
}
