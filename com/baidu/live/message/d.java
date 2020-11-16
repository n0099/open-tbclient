package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class d extends HttpMessage {
    private long bmk;
    private String mRequestType;

    public d(long j, String str) {
        super(1021050);
        this.bmk = 0L;
        this.bmk = j;
        this.mRequestType = str;
    }

    public void setParams() {
        addParam("live_id", this.bmk);
        addParam("query_type", "live_realtime_status");
        addParam("request_type", this.mRequestType);
    }
}
