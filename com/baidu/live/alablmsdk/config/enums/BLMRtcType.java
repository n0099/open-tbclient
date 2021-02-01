package com.baidu.live.alablmsdk.config.enums;
/* loaded from: classes11.dex */
public enum BLMRtcType {
    BDRTC("bdcloud"),
    YYRTC("yy"),
    NONE("");
    
    private String rtcType;

    BLMRtcType(String str) {
        this.rtcType = str;
    }

    public String getRtcType() {
        return this.rtcType;
    }
}
