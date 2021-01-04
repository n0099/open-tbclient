package com.baidu.live.alablmsdk.config.enums;

import com.kwai.video.player.misc.KsMediaFormat;
/* loaded from: classes11.dex */
public enum BLMVideoEncodeType {
    H264(KsMediaFormat.CODEC_NAME_H264);
    
    private String encodeType;

    BLMVideoEncodeType(String str) {
        this.encodeType = str;
    }

    public String encodeType() {
        return this.encodeType;
    }
}
