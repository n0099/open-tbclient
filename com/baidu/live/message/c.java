package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class c extends HttpMessage {
    private long aWv;
    private String mRequestType;

    public c(long j, String str) {
        super(1021050);
        this.aWv = 0L;
        this.aWv = j;
        this.mRequestType = str;
    }

    public void setParams() {
        addParam("live_id", this.aWv);
        addParam("query_type", "live_realtime_status");
        addParam("request_type", this.mRequestType);
    }
}
