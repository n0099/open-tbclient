package com.baidu.rtc;

import com.baidu.ala.helper.StreamConfig;
/* loaded from: classes12.dex */
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
    public int crb = -1;
    public RtcAudioBitrateMode cqp = RtcAudioBitrateMode.RTC_AUDIO_BITRATE_CBR;
    public RtcAudioChannel crm = RtcAudioChannel.RTC_AUDIO_MONNO;
    public int ConnectionTimeoutMs = 5000;
    public int ReadTimeoutMs = 5000;
    public boolean AutoPublish = true;
    public boolean AutoSubScribe = true;
    public int AudioContentType = 1;
    public RtcVideoRenderMode crn = RtcVideoRenderMode.RTC_VIDEO_RENDER_MODE_INTERNAL;
    public boolean crl = false;
    public boolean crd = false;
    public boolean crg = false;
    public boolean crj = false;
    public boolean crf = false;
    public boolean crh = false;
    public boolean cre = false;
    public boolean cri = true;
    public int crk = RtcVideoBitrateMode.RTC_VIDEO_CONTROLRATECONSTANT.ordinal();

    /* loaded from: classes12.dex */
    public enum RtcAudioBitrateMode {
        RTC_AUDIO_BITRATE_CBR,
        RTC_AUDIO_BITRATE_VBR
    }

    /* loaded from: classes12.dex */
    public enum RtcAudioChannel {
        RTC_AUDIO_MONNO,
        RTC_AUDIO_STEREO
    }

    /* loaded from: classes12.dex */
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

    /* loaded from: classes12.dex */
    public enum RtcVideoBitrateMode {
        RTC_VIDEO_CONTROLRATEDISABLE,
        RTC_VIDEO_CONTROLRATEVARIABLE,
        RTC_VIDEO_CONTROLRATECONSTANT
    }

    /* loaded from: classes12.dex */
    public enum RtcVideoRenderMode {
        RTC_VIDEO_RENDER_MODE_INTERNAL,
        RTC_VIDEO_RENDER_MODE_EXTERNAL
    }

    public static RtcParameterSettings agu() {
        return new RtcParameterSettings();
    }
}
