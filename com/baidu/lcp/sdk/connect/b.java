package com.baidu.lcp.sdk.connect;

import com.kwad.sdk.collector.AppStatusRules;
/* loaded from: classes3.dex */
public class b {
    public byte[] auU = new byte[0];
    public long auV = 5000;
    public int errorCode = -1;
    public String errorMsg = "";
    public boolean auW = false;
    public byte[] auX = new byte[0];
    public long auY = AppStatusRules.DEFAULT_GRANULARITY;
    public long serviceId = -1;
    public long methodId = -1;
    public int auZ = -1;
    public boolean isHeartbeat = false;
    public boolean ava = false;
    public boolean avb = false;
    public long msgId = -1;
    public boolean needReplay = false;

    public String toString() {
        return this.avb ? "Request correlationId :" + this.msgId + ", serviceId :" + this.serviceId + ", methodId :" + this.methodId + ", connectState :" + this.auZ + ", isNotify :" + this.auW + ", bodySize :" + this.auU.length + ", request :" + new String(this.auU) : "Response correlationId " + this.msgId + ", serviceId :" + this.serviceId + ", methodId :" + this.methodId + ", errorCode :" + this.errorCode + ", errorMsg :" + this.errorMsg + ", intervalMs :" + this.auY + ", isNotify :" + this.auW + ", bodySize :" + this.auX.length + ", response :" + new String(this.auX);
    }
}
