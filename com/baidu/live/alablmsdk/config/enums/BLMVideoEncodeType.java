package com.baidu.live.alablmsdk.config.enums;
/* loaded from: classes4.dex */
public enum BLMVideoEncodeType {
    H264("h264");
    
    private String encodeType;

    BLMVideoEncodeType(String str) {
        this.encodeType = str;
    }

    public String encodeType() {
        return this.encodeType;
    }
}
