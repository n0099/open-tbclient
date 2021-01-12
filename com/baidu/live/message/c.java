package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class c extends HttpMessage {
    private long brk;
    private String brl;
    private long mAlaId;
    private long mTime;

    public void setFrom(String str) {
        this.brl = str;
    }

    public void setLiveId(long j) {
        this.brk = j;
    }

    public void aZ(long j) {
        this.mTime = j;
    }

    public c() {
        super(1021007);
        this.brl = "";
        this.brk = 0L;
        this.mAlaId = 0L;
        this.mTime = 0L;
    }

    public void setParams() {
        addParam("from_type", this.brl);
        addParam("live_id", this.brk);
        addParam("enter_time", this.mTime);
    }
}
