package com.baidu.live.alablmsdk.config.enums;

import com.baidu.ala.recorder.video.hardware.AudioEncoderCore;
/* loaded from: classes10.dex */
public enum BLMAudioBitRate {
    BLM_AUDIO_BIT_RATE_32KBPS(32000),
    BLM_AUDIO_BIT_RATE_64KBPS(AudioEncoderCore.EncodeConfig.BIT_RATE),
    BLM_AUDIO_BIT_RATE_96KBPS(96000),
    BLM_AUDIO_BIT_RATE_128KBPS(128000);
    
    private int bitRate;

    BLMAudioBitRate(int i) {
        this.bitRate = i;
    }

    public int encodeType() {
        return this.bitRate;
    }
}
