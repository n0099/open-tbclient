package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class b extends HttpMessage {
    private String bhq;
    private long bhr;
    private long mAlaId;
    private long mTime;

    public void setFrom(String str) {
        this.bhq = str;
    }

    public void setLiveId(long j) {
        this.bhr = j;
    }

    public void an(long j) {
        this.mTime = j;
    }

    public b() {
        super(1021007);
        this.bhq = "";
        this.bhr = 0L;
        this.mAlaId = 0L;
        this.mTime = 0L;
    }

    public void setParams() {
        addParam("from_type", this.bhq);
        addParam("live_id", this.bhr);
        addParam("enter_time", this.mTime);
    }
}
