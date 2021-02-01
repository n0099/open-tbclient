package com.baidu.lcp.sdk.connect;

import com.kwad.sdk.collector.AppStatusRules;
/* loaded from: classes3.dex */
public class b {
    public byte[] auJ = new byte[0];
    public long auK = 5000;
    public int errorCode = -1;
    public String errorMsg = "";
    public boolean auL = false;
    public byte[] auM = new byte[0];
    public long auN = AppStatusRules.DEFAULT_GRANULARITY;
    public long serviceId = -1;
    public long methodId = -1;
    public int auO = -1;
    public boolean isHeartbeat = false;
    public boolean auP = false;
    public boolean auQ = false;
    public long msgId = -1;
    public boolean needReplay = false;

    public String toString() {
        return this.auQ ? "Request correlationId :" + this.msgId + ", serviceId :" + this.serviceId + ", methodId :" + this.methodId + ", connectState :" + this.auO + ", isNotify :" + this.auL + ", bodySize :" + this.auJ.length + ", request :" + new String(this.auJ) : "Response correlationId " + this.msgId + ", serviceId :" + this.serviceId + ", methodId :" + this.methodId + ", errorCode :" + this.errorCode + ", errorMsg :" + this.errorMsg + ", intervalMs :" + this.auN + ", isNotify :" + this.auL + ", bodySize :" + this.auM.length + ", response :" + new String(this.auM);
    }
}
