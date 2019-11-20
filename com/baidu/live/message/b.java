package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes6.dex */
public class b extends HttpMessage {
    private long aju;
    private String ajz;

    public b(long j, String str) {
        super(1021050);
        this.aju = 0L;
        this.aju = j;
        this.ajz = str;
    }

    public void setParams() {
        addParam("live_id", this.aju);
        addParam("query_type", "live_realtime_status");
        addParam("request_type", this.ajz);
    }
}
