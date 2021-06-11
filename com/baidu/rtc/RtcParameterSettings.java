package com.baidu.rtc;

import com.kwai.video.player.misc.KsMediaFormat;
/* loaded from: classes2.dex */
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
    public int AudioMaxkbps = -1;
    public RtcAudioBitrateMode audioBitrateMode = RtcAudioBitrateMode.RTC_AUDIO_BITRATE_CBR;
    public RtcAudioChannel TransportAudioChannel = RtcAudioChannel.RTC_AUDIO_MONNO;
    public int AudioSource = 7;
    public int AudioBufferPackets = 50;
    public int AudioCodecComplex = -1;
    public int AudioPlayoutDelay = -1;
    public int ConnectionTimeoutMs = 5000;
    public int ReadTimeoutMs = 5000;
    public boolean AutoPublish = true;
    public boolean AutoSubScribe = true;
    public int AudioContentType = 1;
    public RtcVideoRenderMode VideoRenderMode = RtcVideoRenderMode.RTC_VIDEO_RENDER_MODE_INTERNAL;
    public boolean MicPhoneMuted = false;
    public boolean CameraMuted = false;
    public boolean EnableFixedResolution = false;
    public boolean EnableRequiredResolutionAligment32 = false;
    public boolean DisableExtraCamera = false;
    public boolean EnableHighProfile = false;
    public boolean DisableBuiltInAEC = false;
    public boolean EnableHisiH264HW = true;
    public boolean EnableMTKH264Decode = true;
    public String MediaServerIP = "";
    public int EncodeBitrateMode = RtcVideoBitrateMode.RTC_VIDEO_CONTROLRATECONSTANT.ordinal();

    /* loaded from: classes2.dex */
    public enum RtcAudioBitrateMode {
        RTC_AUDIO_BITRATE_CBR,
        RTC_AUDIO_BITRATE_VBR
    }

    /* loaded from: classes2.dex */
    public enum RtcAudioChannel {
        RTC_AUDIO_MONNO,
        RTC_AUDIO_STEREO
    }

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public enum RtcVideoBitrateMode {
        RTC_VIDEO_CONTROLRATEDISABLE,
        RTC_VIDEO_CONTROLRATEVARIABLE,
        RTC_VIDEO_CONTROLRATECONSTANT
    }

    /* loaded from: classes2.dex */
    public enum RtcVideoRenderMode {
        RTC_VIDEO_RENDER_MODE_INTERNAL,
        RTC_VIDEO_RENDER_MODE_EXTERNAL
    }

    public static RtcParameterSettings getDefaultSettings() {
        return new RtcParameterSettings();
    }
}
