package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class b extends HttpMessage {
    private long brk;
    private String mRequestType;

    public b(long j, String str) {
        super(1031043);
        this.brk = 0L;
        this.brk = j;
        this.mRequestType = str;
    }

    public void setParams() {
        addParam("live_id", this.brk);
        addParam("query_type", "live_realtime_status");
        addParam("request_type", this.mRequestType);
    }
}
