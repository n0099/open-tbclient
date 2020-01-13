package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes2.dex */
public class b extends HttpMessage {
    private String asg;
    private long ash;
    private long mAlaId;
    private long mTime;

    public void setFrom(String str) {
        this.asg = str;
    }

    public void setLiveId(long j) {
        this.ash = j;
    }

    public void D(long j) {
        this.mTime = j;
    }

    public b() {
        super(1021007);
        this.asg = "";
        this.ash = 0L;
        this.mAlaId = 0L;
        this.mTime = 0L;
    }

    public void setParams() {
        addParam("from_type", this.asg);
        addParam("live_id", this.ash);
        addParam("enter_time", this.mTime);
    }
}
