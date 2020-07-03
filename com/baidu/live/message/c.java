package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class c extends HttpMessage {
    private long aZe;
    private String mRequestType;

    public c(long j, String str) {
        super(1021050);
        this.aZe = 0L;
        this.aZe = j;
        this.mRequestType = str;
    }

    public void setParams() {
        addParam("live_id", this.aZe);
        addParam("query_type", "live_realtime_status");
        addParam("request_type", this.mRequestType);
    }
}
