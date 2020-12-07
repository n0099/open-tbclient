package com.baidu.lcp.sdk.connect;
/* loaded from: classes14.dex */
public class b {
    public byte[] azr = new byte[0];
    public long azs = 5000;
    public int errorCode = -1;
    public String errorMsg = "";
    public boolean azt = false;
    public byte[] azu = new byte[0];
    public long azv = 60000;
    public long serviceId = -1;
    public long methodId = -1;
    public int azw = -1;
    public boolean isHeartbeat = false;
    public boolean azx = false;
    public boolean azy = false;
    public long msgId = -1;
    public boolean needReplay = false;

    public String toString() {
        return this.azy ? "Request correlationId :" + this.msgId + ", serviceId :" + this.serviceId + ", methodId :" + this.methodId + ", connectState :" + this.azw + ", isNotify :" + this.azt + ", bodySize :" + this.azr.length + ", request :" + new String(this.azr) : "Response correlationId " + this.msgId + ", serviceId :" + this.serviceId + ", methodId :" + this.methodId + ", errorCode :" + this.errorCode + ", errorMsg :" + this.errorMsg + ", intervalMs :" + this.azv + ", isNotify :" + this.azt + ", bodySize :" + this.azu.length + ", response :" + new String(this.azu);
    }
}
