package com.baidu.lcp.sdk.client.bean;
/* loaded from: classes3.dex */
public class BLCPRequest {
    public long serviceId = -1;
    public long methodId = -1;
    public byte[] auG = new byte[0];
    public long msgId = -1;
    public SendTimeoutSecond auH = SendTimeoutSecond.TIMEOUT_120s;

    /* loaded from: classes3.dex */
    public enum SendTimeoutSecond {
        TIMEOUT_20s,
        TIMEOUT_30s,
        TIMEOUT_50s,
        TIMEOUT_120s
    }
}
