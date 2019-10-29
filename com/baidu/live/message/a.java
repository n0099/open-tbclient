package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes6.dex */
public class a extends HttpMessage {
    private String ajL;
    private long ajM;
    private long ajN;
    private long mTime;

    public void setFrom(String str) {
        this.ajL = str;
    }

    public void setLiveId(long j) {
        this.ajM = j;
    }

    public void C(long j) {
        this.mTime = j;
    }

    public a() {
        super(1021007);
        this.ajL = "";
        this.ajM = 0L;
        this.ajN = 0L;
        this.mTime = 0L;
    }

    public void setParams() {
        addParam("from_type", this.ajL);
        addParam("live_id", this.ajM);
        addParam("enter_time", this.mTime);
    }
}
