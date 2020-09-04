package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes7.dex */
public class c extends HttpMessage {
    private long bey;
    private String mRequestType;

    public c(long j, String str) {
        super(1021050);
        this.bey = 0L;
        this.bey = j;
        this.mRequestType = str;
    }

    public void setParams() {
        addParam("live_id", this.bey);
        addParam("query_type", "live_realtime_status");
        addParam("request_type", this.mRequestType);
    }
}
