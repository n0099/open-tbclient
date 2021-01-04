package com.baidu.lcp.sdk.connect;

import com.kwad.sdk.collector.AppStatusRules;
/* loaded from: classes3.dex */
public class b {
    public byte[] azH = new byte[0];
    public long azI = 5000;
    public int errorCode = -1;
    public String errorMsg = "";
    public boolean azJ = false;
    public byte[] azK = new byte[0];
    public long azL = AppStatusRules.DEFAULT_GRANULARITY;
    public long serviceId = -1;
    public long methodId = -1;
    public int azM = -1;
    public boolean isHeartbeat = false;
    public boolean azN = false;
    public boolean azO = false;
    public long msgId = -1;
    public boolean needReplay = false;

    public String toString() {
        return this.azO ? "Request correlationId :" + this.msgId + ", serviceId :" + this.serviceId + ", methodId :" + this.methodId + ", connectState :" + this.azM + ", isNotify :" + this.azJ + ", bodySize :" + this.azH.length + ", request :" + new String(this.azH) : "Response correlationId " + this.msgId + ", serviceId :" + this.serviceId + ", methodId :" + this.methodId + ", errorCode :" + this.errorCode + ", errorMsg :" + this.errorMsg + ", intervalMs :" + this.azL + ", isNotify :" + this.azJ + ", bodySize :" + this.azK.length + ", response :" + new String(this.azK);
    }
}
