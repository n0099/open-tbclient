package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class c extends HttpMessage {
    private long aZc;
    private String mRequestType;

    public c(long j, String str) {
        super(1021050);
        this.aZc = 0L;
        this.aZc = j;
        this.mRequestType = str;
    }

    public void setParams() {
        addParam("live_id", this.aZc);
        addParam("query_type", "live_realtime_status");
        addParam("request_type", this.mRequestType);
    }
}
