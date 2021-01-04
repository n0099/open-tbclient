package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class b extends HttpMessage {
    private long bvY;
    private String mRequestType;

    public b(long j, String str) {
        super(1031043);
        this.bvY = 0L;
        this.bvY = j;
        this.mRequestType = str;
    }

    public void setParams() {
        addParam("live_id", this.bvY);
        addParam("query_type", "live_realtime_status");
        addParam("request_type", this.mRequestType);
    }
}
