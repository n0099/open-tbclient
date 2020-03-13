package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class c extends HttpMessage {
    private long awt;
    private String mRequestType;

    public c(long j, String str) {
        super(1021050);
        this.awt = 0L;
        this.awt = j;
        this.mRequestType = str;
    }

    public void setParams() {
        addParam("live_id", this.awt);
        addParam("query_type", "live_realtime_status");
        addParam("request_type", this.mRequestType);
    }
}
