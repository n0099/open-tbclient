package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class b extends HttpMessage {
    private String aws;
    private long awt;
    private long mAlaId;
    private long mTime;

    public void setFrom(String str) {
        this.aws = str;
    }

    public void setLiveId(long j) {
        this.awt = j;
    }

    public void H(long j) {
        this.mTime = j;
    }

    public b() {
        super(1021007);
        this.aws = "";
        this.awt = 0L;
        this.mAlaId = 0L;
        this.mTime = 0L;
    }

    public void setParams() {
        addParam("from_type", this.aws);
        addParam("live_id", this.awt);
        addParam("enter_time", this.mTime);
    }
}
