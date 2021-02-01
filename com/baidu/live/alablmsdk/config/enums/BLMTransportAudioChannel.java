package com.baidu.live.alablmsdk.config.enums;

import com.baidu.rtc.RtcParameterSettings;
/* loaded from: classes11.dex */
public enum BLMTransportAudioChannel {
    RTC_AUDIO_MONNO(RtcParameterSettings.RtcAudioChannel.RTC_AUDIO_MONNO),
    RTC_AUDIO_STEREO(RtcParameterSettings.RtcAudioChannel.RTC_AUDIO_STEREO);
    
    private RtcParameterSettings.RtcAudioChannel mValue;

    BLMTransportAudioChannel(RtcParameterSettings.RtcAudioChannel rtcAudioChannel) {
        this.mValue = rtcAudioChannel;
    }

    public RtcParameterSettings.RtcAudioChannel getValue() {
        return this.mValue;
    }
}
