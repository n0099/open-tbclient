package com.baidu.live.alablmsdk.config.enums;
/* loaded from: classes10.dex */
public enum BLMAudioEncodeType {
    OPUS("opus");
    
    private String encodeType;

    BLMAudioEncodeType(String str) {
        this.encodeType = str;
    }

    public String encodeType() {
        return this.encodeType;
    }
}
