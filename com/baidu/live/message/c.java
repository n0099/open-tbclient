package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class c extends HttpMessage {
    private long bhr;
    private String mRequestType;

    public c(long j, String str) {
        super(1021050);
        this.bhr = 0L;
        this.bhr = j;
        this.mRequestType = str;
    }

    public void setParams() {
        addParam("live_id", this.bhr);
        addParam("query_type", "live_realtime_status");
        addParam("request_type", this.mRequestType);
    }
}
