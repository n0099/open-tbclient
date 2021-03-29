package com.baidu.cyberplayer.sdk.rtc;

import com.baidu.cyberplayer.sdk.Keep;
import com.kwai.video.player.misc.KsMediaFormat;
@Keep
/* loaded from: classes.dex */
public class CyberRTCSetting {
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
    public int ConnectionTimeoutMs = 5000;
    public int ReadTimeoutMs = 5000;
    public boolean AutoPublish = true;
    public boolean AutoSubScribe = true;
    public int AudioContentType = 1;
    public CyberRTCVideoRenderMode VideoRenderMode = CyberRTCVideoRenderMode.CYBER_RTC_VIDEO_RENDER_MODE_INTERNAL;

    @Keep
    /* loaded from: classes.dex */
    public enum CyberRTCSettingType {
        CYBER_RTC_AUDIO_PARAM_SETTINGS_ONLY_AUDIO,
        CYBER_RTC_AUDIO_PARAM_SETTINGS_AEC_DUMP,
        CYBER_RTC_AUDIO_PARAM_SETTINGS_LEVEL_CONTROL,
        CYBER_RTC_AUDIO_PARAM_SETTINGS_MANUAL_CONFIG,
        CYBER_RTC_AUDIO_PARAM_SETTINGS_EXPORT_RECORD,
        CYBER_RTC_AUDIO_PARAM_SETTINGS_EXPORT_PLAYOUT,
        CYBER_RTC_AUDIO_PARAM_SETTINGS_EXPORT_RECORD_PLAYOUT_MIX,
        CYBER_RTC_VIDEO_PARAM_SETTINGS_FPS,
        CYBER_RTC_VIDEO_PARAM_SETTINGS_RESOLUTION,
        CYBER_RTC_VIDEO_PARAM_SETTINGS_BITRATE,
        CYBER_RTC_VIDEO_PARAM_SETTINGS_CODECTYPE,
        CYBER_RTC_VIDEO_PARAM_SETTINGS_SESSION_MODE,
        CYBER_RTC_VIDEO_PARAM_SETTINGS_CAPTURE_MODE,
        CYBER_RTC_VIDEO_PARAM_SETTINGS_RENDER_MODE,
        CYBER_RTC_PARAM_SETTINGS_ALL,
        CYBER_RTC_PARAM_SETTINGS_OTHERS
    }

    @Keep
    /* loaded from: classes.dex */
    public enum CyberRTCVideoRenderMode {
        CYBER_RTC_VIDEO_RENDER_MODE_EXTERNAL,
        CYBER_RTC_VIDEO_RENDER_MODE_INTERNAL
    }

    public static CyberRTCSetting getDefaultSetting() {
        return new CyberRTCSetting();
    }
}
