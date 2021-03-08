package com.baidu.lcp.sdk.connect;

import com.kwad.sdk.collector.AppStatusRules;
/* loaded from: classes3.dex */
public class b {
    public byte[] awj = new byte[0];
    public long awk = 5000;
    public int errorCode = -1;
    public String errorMsg = "";
    public boolean awl = false;
    public byte[] awm = new byte[0];
    public long awn = AppStatusRules.DEFAULT_GRANULARITY;
    public long serviceId = -1;
    public long methodId = -1;
    public int awo = -1;
    public boolean isHeartbeat = false;
    public boolean awp = false;
    public boolean awq = false;
    public long msgId = -1;
    public boolean needReplay = false;

    public String toString() {
        return this.awq ? "Request correlationId :" + this.msgId + ", serviceId :" + this.serviceId + ", methodId :" + this.methodId + ", connectState :" + this.awo + ", isNotify :" + this.awl + ", bodySize :" + this.awj.length + ", request :" + new String(this.awj) : "Response correlationId " + this.msgId + ", serviceId :" + this.serviceId + ", methodId :" + this.methodId + ", errorCode :" + this.errorCode + ", errorMsg :" + this.errorMsg + ", intervalMs :" + this.awn + ", isNotify :" + this.awl + ", bodySize :" + this.awm.length + ", response :" + new String(this.awm);
    }
}
