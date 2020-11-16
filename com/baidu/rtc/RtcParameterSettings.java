package com.baidu.rtc;

import com.baidu.ala.helper.StreamConfig;
/* loaded from: classes16.dex */
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
    public RtcVideoRenderMode ckw = RtcVideoRenderMode.RTC_VIDEO_RENDER_MODE_INTERNAL;
    public boolean ckv = false;
    public boolean cko = false;
    public boolean ckr = false;
    public boolean ckt = false;
    public boolean ckq = false;
    public boolean cks = false;
    public boolean ckp = false;
    public int cku = RtcVideoBitrateMode.RTC_VIDEO_CONTROLRATECONSTANT.ordinal();

    /* loaded from: classes16.dex */
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

    /* loaded from: classes16.dex */
    public enum RtcVideoBitrateMode {
        RTC_VIDEO_CONTROLRATEDISABLE,
        RTC_VIDEO_CONTROLRATEVARIABLE,
        RTC_VIDEO_CONTROLRATECONSTANT
    }

    /* loaded from: classes16.dex */
    public enum RtcVideoRenderMode {
        RTC_VIDEO_RENDER_MODE_INTERNAL,
        RTC_VIDEO_RENDER_MODE_EXTERNAL
    }

    public static RtcParameterSettings adl() {
        return new RtcParameterSettings();
    }
}
