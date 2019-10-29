package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes6.dex */
public class b extends HttpMessage {
    private long ajM;
    private String ajR;

    public b(long j, String str) {
        super(1021050);
        this.ajM = 0L;
        this.ajM = j;
        this.ajR = str;
    }

    public void setParams() {
        addParam("live_id", this.ajM);
        addParam("query_type", "live_realtime_status");
        addParam("request_type", this.ajR);
    }
}
