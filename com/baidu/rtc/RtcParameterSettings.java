package com.baidu.rtc;

import com.baidu.ala.helper.StreamConfig;
/* loaded from: classes9.dex */
public class RtcParameterSettings {
    public boolean HasVideo = true;
    public boolean HasAudio = true;
    public boolean HasData = false;
    public String VideoCodec = "h264";
    public String AudioCodec = "opus";
    public int AudioFrequency = StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K;
    public int AudioChannel = 1;
    public String VideoResolution = "640x480";
    public int VideoWidth = 640;
    public int VideoHeight = 480;
    public int VideoFps = 20;
    public int VideoMaxkbps = 1000;
    public int VideoMinkbps = 1000;
    public int ConnectionTimeoutMs = 5000;
    public int ReadTimeoutMs = 5000;
    public boolean AutoPublish = true;
    public boolean AutoSubScribe = true;
    public int AudioContentType = 1;
    public RtcVideoRenderMode bXP = RtcVideoRenderMode.RTC_VIDEO_RENDER_MODE_INTERNAL;
    public boolean bXO = false;
    public boolean bXJ = false;
    public boolean bXL = false;
    public boolean bXN = false;
    public boolean bXK = false;
    public boolean bXM = false;

    /* loaded from: classes9.dex */
    public enum RtcParamSettingType {
        RTC_AUDIO_PARAM_SETTINGS_ONLY_AUDIO,
        RTC_AUDIO_PARAM_SETTINGS_AEC_DUMP,
        RTC_AUDIO_PARAM_SETTINGS_LEVEL_CONTROL,
        RTC_AUDIO_PARAM_SETTINGS_MANUAL_CONFIG,
        RTC_AUDIO_PARAM_SETTINGS_EXPORT_RECORD,
        RTC_AUDIO_PARAM_SETTINGS_EXPORT_PLAYOUT,
        RTC_AUDIO_PARAM_SETTINGS_EXPORT_RECORD_PLAYOUT_MIX,
        RTC_VIDEO_PARAM_SETTINGS_FPS,
        RTC_VIDEO_PARAM_SETTINGS_RESOLUTION,
        RTC_VIDEO_PARAM_SETTINGS_BITRATE,
        RTC_VIDEO_PARAM_SETTINGS_CODECTYPE,
        RTC_VIDEO_PARAM_SETTINGS_SESSION_MODE,
        RTC_VIDEO_PARAM_SETTINGS_CAPTURE_MODE,
        RTC_VIDEO_PARAM_SETTINGS_RENDER_MODE,
        RTC_PARAM_SETTINGS_ALL,
        RTC_PARAM_SETTINGS_OTHERS
    }

    /* loaded from: classes9.dex */
    public enum RtcVideoRenderMode {
        RTC_VIDEO_RENDER_MODE_INTERNAL,
        RTC_VIDEO_RENDER_MODE_EXTERNAL
    }

    public static RtcParameterSettings ZA() {
        return new RtcParameterSettings();
    }
}
