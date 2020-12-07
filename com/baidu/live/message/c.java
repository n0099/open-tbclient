package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class c extends HttpMessage {
    private long brr;
    private String brs;
    private long mAlaId;
    private long mTime;

    public void setFrom(String str) {
        this.brs = str;
    }

    public void setLiveId(long j) {
        this.brr = j;
    }

    public void aZ(long j) {
        this.mTime = j;
    }

    public c() {
        super(1021007);
        this.brs = "";
        this.brr = 0L;
        this.mAlaId = 0L;
        this.mTime = 0L;
    }

    public void setParams() {
        addParam("from_type", this.brs);
        addParam("live_id", this.brr);
        addParam("enter_time", this.mTime);
    }
}
