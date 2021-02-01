package com.baidu.rtc;

import com.kwai.video.player.misc.KsMediaFormat;
/* loaded from: classes10.dex */
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
    public int cvr = -1;
    public RtcAudioBitrateMode cux = RtcAudioBitrateMode.RTC_AUDIO_BITRATE_CBR;
    public RtcAudioChannel cvF = RtcAudioChannel.RTC_AUDIO_MONNO;
    public int cvt = 7;
    public int cvp = 50;
    public int cvq = -1;
    public int cvs = -1;
    public int ConnectionTimeoutMs = 5000;
    public int ReadTimeoutMs = 5000;
    public boolean AutoPublish = true;
    public boolean AutoSubScribe = true;
    public int AudioContentType = 1;
    public RtcVideoRenderMode cvG = RtcVideoRenderMode.RTC_VIDEO_RENDER_MODE_INTERNAL;
    public boolean cvE = false;
    public boolean cvu = false;
    public boolean cvx = false;
    public boolean cvB = false;
    public boolean cvw = false;
    public boolean cvy = false;
    public boolean cvv = false;
    public boolean cvz = true;
    public boolean cvA = true;
    public String cvD = "";
    public int cvC = RtcVideoBitrateMode.RTC_VIDEO_CONTROLRATECONSTANT.ordinal();

    /* loaded from: classes10.dex */
    public enum RtcAudioBitrateMode {
        RTC_AUDIO_BITRATE_CBR,
        RTC_AUDIO_BITRATE_VBR
    }

    /* loaded from: classes10.dex */
    public enum RtcAudioChannel {
        RTC_AUDIO_MONNO,
        RTC_AUDIO_STEREO
    }

    /* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
    public enum RtcVideoBitrateMode {
        RTC_VIDEO_CONTROLRATEDISABLE,
        RTC_VIDEO_CONTROLRATEVARIABLE,
        RTC_VIDEO_CONTROLRATECONSTANT
    }

    /* loaded from: classes10.dex */
    public enum RtcVideoRenderMode {
        RTC_VIDEO_RENDER_MODE_INTERNAL,
        RTC_VIDEO_RENDER_MODE_EXTERNAL
    }

    public static RtcParameterSettings aeQ() {
        return new RtcParameterSettings();
    }
}
