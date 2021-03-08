package com.baidu.rtc;

import com.kwai.video.player.misc.KsMediaFormat;
/* loaded from: classes9.dex */
public class RtcParameterSettings {
    public boolean HasVideo = true;
    public boolean HasAudio = true;
    public boolean HasData = false;
    public String VideoCodec = KsMediaFormat.CODEC_NAME_H264;
    public String AudioCodec = "opus";
    public int AudioFrequency = 48000;
    public int AudioChannel = 1;
    public String VideoResolution = "640x480";
    public int VideoWidth = 640;
    public int VideoHeight = 480;
    public int VideoFps = 20;
    public int VideoMaxkbps = 1000;
    public int VideoMinkbps = 1000;
    public int cwR = -1;
    public RtcAudioBitrateMode cvX = RtcAudioBitrateMode.RTC_AUDIO_BITRATE_CBR;
    public RtcAudioChannel cxf = RtcAudioChannel.RTC_AUDIO_MONNO;
    public int cwT = 7;
    public int cwP = 50;
    public int cwQ = -1;
    public int cwS = -1;
    public int ConnectionTimeoutMs = 5000;
    public int ReadTimeoutMs = 5000;
    public boolean AutoPublish = true;
    public boolean AutoSubScribe = true;
    public int AudioContentType = 1;
    public RtcVideoRenderMode cxg = RtcVideoRenderMode.RTC_VIDEO_RENDER_MODE_INTERNAL;
    public boolean cxe = false;
    public boolean cwU = false;
    public boolean cwX = false;
    public boolean cxb = false;
    public boolean cwW = false;
    public boolean cwY = false;
    public boolean cwV = false;
    public boolean cwZ = true;
    public boolean cxa = true;
    public String cxd = "";
    public int cxc = RtcVideoBitrateMode.RTC_VIDEO_CONTROLRATECONSTANT.ordinal();

    /* loaded from: classes9.dex */
    public enum RtcAudioBitrateMode {
        RTC_AUDIO_BITRATE_CBR,
        RTC_AUDIO_BITRATE_VBR
    }

    /* loaded from: classes9.dex */
    public enum RtcAudioChannel {
        RTC_AUDIO_MONNO,
        RTC_AUDIO_STEREO
    }

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
    public enum RtcVideoBitrateMode {
        RTC_VIDEO_CONTROLRATEDISABLE,
        RTC_VIDEO_CONTROLRATEVARIABLE,
        RTC_VIDEO_CONTROLRATECONSTANT
    }

    /* loaded from: classes9.dex */
    public enum RtcVideoRenderMode {
        RTC_VIDEO_RENDER_MODE_INTERNAL,
        RTC_VIDEO_RENDER_MODE_EXTERNAL
    }

    public static RtcParameterSettings aeT() {
        return new RtcParameterSettings();
    }
}
