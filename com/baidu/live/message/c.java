package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class c extends HttpMessage {
    private long aQg;
    private String mRequestType;

    public c(long j, String str) {
        super(1021050);
        this.aQg = 0L;
        this.aQg = j;
        this.mRequestType = str;
    }

    public void setParams() {
        addParam("live_id", this.aQg);
        addParam("query_type", "live_realtime_status");
        addParam("request_type", this.mRequestType);
    }
}
