package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class c extends HttpMessage {
    private long buN;
    private String buO;
    private long mAlaId;
    private long mTime;

    public void setFrom(String str) {
        this.buO = str;
    }

    public void setLiveId(long j) {
        this.buN = j;
    }

    public void bd(long j) {
        this.mTime = j;
    }

    public c() {
        super(1021007);
        this.buO = "";
        this.buN = 0L;
        this.mAlaId = 0L;
        this.mTime = 0L;
    }

    public void setParams() {
        addParam("from_type", this.buO);
        addParam("live_id", this.buN);
        addParam("enter_time", this.mTime);
    }
}
