package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class c extends HttpMessage {
    private long bnV;
    private String bnW;
    private long mAlaId;
    private long mTime;

    public void setFrom(String str) {
        this.bnW = str;
    }

    public void setLiveId(long j) {
        this.bnV = j;
    }

    public void aB(long j) {
        this.mTime = j;
    }

    public c() {
        super(1021007);
        this.bnW = "";
        this.bnV = 0L;
        this.mAlaId = 0L;
        this.mTime = 0L;
    }

    public void setParams() {
        addParam("from_type", this.bnW);
        addParam("live_id", this.bnV);
        addParam("enter_time", this.mTime);
    }
}
