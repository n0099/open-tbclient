package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class d extends HttpMessage {
    private long bwn;
    private String mRequestType;

    public d(long j, String str) {
        super(1021050);
        this.bwn = 0L;
        this.bwn = j;
        this.mRequestType = str;
    }

    public void setParams() {
        addParam("live_id", this.bwn);
        addParam("query_type", "live_realtime_status");
        addParam("request_type", this.mRequestType);
    }
}
