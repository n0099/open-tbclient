package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class c extends HttpMessage {
    private long bmk;
    private String bml;
    private long mAlaId;
    private long mTime;

    public void setFrom(String str) {
        this.bml = str;
    }

    public void setLiveId(long j) {
        this.bmk = j;
    }

    public void aB(long j) {
        this.mTime = j;
    }

    public c() {
        super(1021007);
        this.bml = "";
        this.bmk = 0L;
        this.mAlaId = 0L;
        this.mTime = 0L;
    }

    public void setParams() {
        addParam("from_type", this.bml);
        addParam("live_id", this.bmk);
        addParam("enter_time", this.mTime);
    }
}
