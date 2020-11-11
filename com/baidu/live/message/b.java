package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class b extends HttpMessage {
    private long bnV;
    private String mRequestType;

    public b(long j, String str) {
        super(1031043);
        this.bnV = 0L;
        this.bnV = j;
        this.mRequestType = str;
    }

    public void setParams() {
        addParam("live_id", this.bnV);
        addParam("query_type", "live_realtime_status");
        addParam("request_type", this.mRequestType);
    }
}
