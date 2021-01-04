package com.baidu.live.alablmsdk.config.enums;

import com.baidu.ala.helper.StreamConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
/* loaded from: classes11.dex */
public enum BLMAudioSampleRate {
    BLM_AUDIO_SAMPLE_RATE_11025HZ(RequestResponseCode.REQUEST_LOGIN_PB_AT),
    BLM_AUDIO_SAMPLE_RATE_22050HZ(22050),
    BLM_AUDIO_SAMPLE_RATE_44100HZ(44100),
    BLM_AUDIO_SAMPLE_RATE_48000HZ(StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K);
    
    private int sampleRate;

    BLMAudioSampleRate(int i) {
        this.sampleRate = i;
    }

    public int getSampleRate() {
        return this.sampleRate;
    }
}
