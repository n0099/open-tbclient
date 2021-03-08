package com.baidu.live.alablmsdk.config.enums;
/* loaded from: classes10.dex */
public enum BLMAudioBitDepth {
    BLM_AUDIO_BIT_DEPTH_UINT8(8),
    BLM_AUDIO_BIT_DEPTH_UINT16(16),
    BLM_AUDIO_BIT_DEPTH_UINT32(32);
    
    private int bitDepth;

    BLMAudioBitDepth(int i) {
        this.bitDepth = i;
    }

    public int encodeType() {
        return this.bitDepth;
    }
}
