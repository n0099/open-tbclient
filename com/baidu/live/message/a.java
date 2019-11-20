package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes6.dex */
public class a extends HttpMessage {
    private String ajt;
    private long aju;
    private long ajv;
    private long mTime;

    public void setFrom(String str) {
        this.ajt = str;
    }

    public void setLiveId(long j) {
        this.aju = j;
    }

    public void B(long j) {
        this.mTime = j;
    }

    public a() {
        super(1021007);
        this.ajt = "";
        this.aju = 0L;
        this.ajv = 0L;
        this.mTime = 0L;
    }

    public void setParams() {
        addParam("from_type", this.ajt);
        addParam("live_id", this.aju);
        addParam("enter_time", this.mTime);
    }
}
