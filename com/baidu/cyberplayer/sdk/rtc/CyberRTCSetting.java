package com.baidu.cyberplayer.sdk.rtc;

import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.rtc.record.MediaEncodeParams;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes5.dex */
public class CyberRTCSetting {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int AudioChannel;
    public String AudioCodec;
    public int AudioContentType;
    public int AudioFrequency;
    public boolean AutoPublish;
    public boolean AutoSubScribe;
    public int ConnectionTimeoutMs;
    public boolean HasAudio;
    public boolean HasData;
    public boolean HasVideo;
    public int ReadTimeoutMs;
    public String VideoCodec;
    public int VideoFps;
    public int VideoHeight;
    public int VideoMaxkbps;
    public int VideoMinkbps;
    public CyberRTCVideoRenderMode VideoRenderMode;
    public String VideoResolution;
    public int VideoWidth;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Keep
    /* loaded from: classes5.dex */
    public static final class CyberRTCSettingType {
        public static /* synthetic */ Interceptable $ic;
        public static final CyberRTCSettingType CYBER_RTC_AUDIO_PARAM_SETTINGS_AEC_DUMP;
        public static final CyberRTCSettingType CYBER_RTC_AUDIO_PARAM_SETTINGS_EXPORT_PLAYOUT;
        public static final CyberRTCSettingType CYBER_RTC_AUDIO_PARAM_SETTINGS_EXPORT_RECORD;
        public static final CyberRTCSettingType CYBER_RTC_AUDIO_PARAM_SETTINGS_EXPORT_RECORD_PLAYOUT_MIX;
        public static final CyberRTCSettingType CYBER_RTC_AUDIO_PARAM_SETTINGS_LEVEL_CONTROL;
        public static final CyberRTCSettingType CYBER_RTC_AUDIO_PARAM_SETTINGS_MANUAL_CONFIG;
        public static final CyberRTCSettingType CYBER_RTC_AUDIO_PARAM_SETTINGS_ONLY_AUDIO;
        public static final CyberRTCSettingType CYBER_RTC_PARAM_SETTINGS_ALL;
        public static final CyberRTCSettingType CYBER_RTC_PARAM_SETTINGS_OTHERS;
        public static final CyberRTCSettingType CYBER_RTC_VIDEO_PARAM_SETTINGS_BITRATE;
        public static final CyberRTCSettingType CYBER_RTC_VIDEO_PARAM_SETTINGS_CAPTURE_MODE;
        public static final CyberRTCSettingType CYBER_RTC_VIDEO_PARAM_SETTINGS_CODECTYPE;
        public static final CyberRTCSettingType CYBER_RTC_VIDEO_PARAM_SETTINGS_FPS;
        public static final CyberRTCSettingType CYBER_RTC_VIDEO_PARAM_SETTINGS_RENDER_MODE;
        public static final CyberRTCSettingType CYBER_RTC_VIDEO_PARAM_SETTINGS_RESOLUTION;
        public static final CyberRTCSettingType CYBER_RTC_VIDEO_PARAM_SETTINGS_SESSION_MODE;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ CyberRTCSettingType[] f39203a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1471319643, "Lcom/baidu/cyberplayer/sdk/rtc/CyberRTCSetting$CyberRTCSettingType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1471319643, "Lcom/baidu/cyberplayer/sdk/rtc/CyberRTCSetting$CyberRTCSettingType;");
                    return;
                }
            }
            CYBER_RTC_AUDIO_PARAM_SETTINGS_ONLY_AUDIO = new CyberRTCSettingType("CYBER_RTC_AUDIO_PARAM_SETTINGS_ONLY_AUDIO", 0);
            CYBER_RTC_AUDIO_PARAM_SETTINGS_AEC_DUMP = new CyberRTCSettingType("CYBER_RTC_AUDIO_PARAM_SETTINGS_AEC_DUMP", 1);
            CYBER_RTC_AUDIO_PARAM_SETTINGS_LEVEL_CONTROL = new CyberRTCSettingType("CYBER_RTC_AUDIO_PARAM_SETTINGS_LEVEL_CONTROL", 2);
            CYBER_RTC_AUDIO_PARAM_SETTINGS_MANUAL_CONFIG = new CyberRTCSettingType("CYBER_RTC_AUDIO_PARAM_SETTINGS_MANUAL_CONFIG", 3);
            CYBER_RTC_AUDIO_PARAM_SETTINGS_EXPORT_RECORD = new CyberRTCSettingType("CYBER_RTC_AUDIO_PARAM_SETTINGS_EXPORT_RECORD", 4);
            CYBER_RTC_AUDIO_PARAM_SETTINGS_EXPORT_PLAYOUT = new CyberRTCSettingType("CYBER_RTC_AUDIO_PARAM_SETTINGS_EXPORT_PLAYOUT", 5);
            CYBER_RTC_AUDIO_PARAM_SETTINGS_EXPORT_RECORD_PLAYOUT_MIX = new CyberRTCSettingType("CYBER_RTC_AUDIO_PARAM_SETTINGS_EXPORT_RECORD_PLAYOUT_MIX", 6);
            CYBER_RTC_VIDEO_PARAM_SETTINGS_FPS = new CyberRTCSettingType("CYBER_RTC_VIDEO_PARAM_SETTINGS_FPS", 7);
            CYBER_RTC_VIDEO_PARAM_SETTINGS_RESOLUTION = new CyberRTCSettingType("CYBER_RTC_VIDEO_PARAM_SETTINGS_RESOLUTION", 8);
            CYBER_RTC_VIDEO_PARAM_SETTINGS_BITRATE = new CyberRTCSettingType("CYBER_RTC_VIDEO_PARAM_SETTINGS_BITRATE", 9);
            CYBER_RTC_VIDEO_PARAM_SETTINGS_CODECTYPE = new CyberRTCSettingType("CYBER_RTC_VIDEO_PARAM_SETTINGS_CODECTYPE", 10);
            CYBER_RTC_VIDEO_PARAM_SETTINGS_SESSION_MODE = new CyberRTCSettingType("CYBER_RTC_VIDEO_PARAM_SETTINGS_SESSION_MODE", 11);
            CYBER_RTC_VIDEO_PARAM_SETTINGS_CAPTURE_MODE = new CyberRTCSettingType("CYBER_RTC_VIDEO_PARAM_SETTINGS_CAPTURE_MODE", 12);
            CYBER_RTC_VIDEO_PARAM_SETTINGS_RENDER_MODE = new CyberRTCSettingType("CYBER_RTC_VIDEO_PARAM_SETTINGS_RENDER_MODE", 13);
            CYBER_RTC_PARAM_SETTINGS_ALL = new CyberRTCSettingType("CYBER_RTC_PARAM_SETTINGS_ALL", 14);
            CyberRTCSettingType cyberRTCSettingType = new CyberRTCSettingType("CYBER_RTC_PARAM_SETTINGS_OTHERS", 15);
            CYBER_RTC_PARAM_SETTINGS_OTHERS = cyberRTCSettingType;
            f39203a = new CyberRTCSettingType[]{CYBER_RTC_AUDIO_PARAM_SETTINGS_ONLY_AUDIO, CYBER_RTC_AUDIO_PARAM_SETTINGS_AEC_DUMP, CYBER_RTC_AUDIO_PARAM_SETTINGS_LEVEL_CONTROL, CYBER_RTC_AUDIO_PARAM_SETTINGS_MANUAL_CONFIG, CYBER_RTC_AUDIO_PARAM_SETTINGS_EXPORT_RECORD, CYBER_RTC_AUDIO_PARAM_SETTINGS_EXPORT_PLAYOUT, CYBER_RTC_AUDIO_PARAM_SETTINGS_EXPORT_RECORD_PLAYOUT_MIX, CYBER_RTC_VIDEO_PARAM_SETTINGS_FPS, CYBER_RTC_VIDEO_PARAM_SETTINGS_RESOLUTION, CYBER_RTC_VIDEO_PARAM_SETTINGS_BITRATE, CYBER_RTC_VIDEO_PARAM_SETTINGS_CODECTYPE, CYBER_RTC_VIDEO_PARAM_SETTINGS_SESSION_MODE, CYBER_RTC_VIDEO_PARAM_SETTINGS_CAPTURE_MODE, CYBER_RTC_VIDEO_PARAM_SETTINGS_RENDER_MODE, CYBER_RTC_PARAM_SETTINGS_ALL, cyberRTCSettingType};
        }

        public CyberRTCSettingType(String str, int i2) {
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

        public static CyberRTCSettingType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CyberRTCSettingType) Enum.valueOf(CyberRTCSettingType.class, str) : (CyberRTCSettingType) invokeL.objValue;
        }

        public static CyberRTCSettingType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CyberRTCSettingType[]) f39203a.clone() : (CyberRTCSettingType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Keep
    /* loaded from: classes5.dex */
    public static final class CyberRTCVideoRenderMode {
        public static /* synthetic */ Interceptable $ic;
        public static final CyberRTCVideoRenderMode CYBER_RTC_VIDEO_RENDER_MODE_EXTERNAL;
        public static final CyberRTCVideoRenderMode CYBER_RTC_VIDEO_RENDER_MODE_INTERNAL;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ CyberRTCVideoRenderMode[] f39204a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1356942609, "Lcom/baidu/cyberplayer/sdk/rtc/CyberRTCSetting$CyberRTCVideoRenderMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1356942609, "Lcom/baidu/cyberplayer/sdk/rtc/CyberRTCSetting$CyberRTCVideoRenderMode;");
                    return;
                }
            }
            CYBER_RTC_VIDEO_RENDER_MODE_EXTERNAL = new CyberRTCVideoRenderMode("CYBER_RTC_VIDEO_RENDER_MODE_EXTERNAL", 0);
            CyberRTCVideoRenderMode cyberRTCVideoRenderMode = new CyberRTCVideoRenderMode("CYBER_RTC_VIDEO_RENDER_MODE_INTERNAL", 1);
            CYBER_RTC_VIDEO_RENDER_MODE_INTERNAL = cyberRTCVideoRenderMode;
            f39204a = new CyberRTCVideoRenderMode[]{CYBER_RTC_VIDEO_RENDER_MODE_EXTERNAL, cyberRTCVideoRenderMode};
        }

        public CyberRTCVideoRenderMode(String str, int i2) {
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

        public static CyberRTCVideoRenderMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CyberRTCVideoRenderMode) Enum.valueOf(CyberRTCVideoRenderMode.class, str) : (CyberRTCVideoRenderMode) invokeL.objValue;
        }

        public static CyberRTCVideoRenderMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CyberRTCVideoRenderMode[]) f39204a.clone() : (CyberRTCVideoRenderMode[]) invokeV.objValue;
        }
    }

    public CyberRTCSetting() {
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
        this.HasVideo = true;
        this.HasAudio = true;
        this.HasData = false;
        this.VideoCodec = "h264";
        this.AudioCodec = "opus";
        this.AudioFrequency = MediaEncodeParams.AUDIO_SAMPLE_RATE;
        this.AudioChannel = 1;
        this.VideoResolution = "640x480";
        this.VideoWidth = 640;
        this.VideoHeight = 480;
        this.VideoFps = 20;
        this.VideoMaxkbps = 1000;
        this.VideoMinkbps = 1000;
        this.ConnectionTimeoutMs = 5000;
        this.ReadTimeoutMs = 5000;
        this.AutoPublish = true;
        this.AutoSubScribe = true;
        this.AudioContentType = 1;
        this.VideoRenderMode = CyberRTCVideoRenderMode.CYBER_RTC_VIDEO_RENDER_MODE_INTERNAL;
    }

    public static CyberRTCSetting getDefaultSetting() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new CyberRTCSetting() : (CyberRTCSetting) invokeV.objValue;
    }
}
