package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class b extends HttpMessage {
    private String awr;
    private long aws;
    private long mAlaId;
    private long mTime;

    public void setFrom(String str) {
        this.awr = str;
    }

    public void setLiveId(long j) {
        this.aws = j;
    }

    public void H(long j) {
        this.mTime = j;
    }

    public b() {
        super(1021007);
        this.awr = "";
        this.aws = 0L;
        this.mAlaId = 0L;
        this.mTime = 0L;
    }

    public void setParams() {
        addParam("from_type", this.awr);
        addParam("live_id", this.aws);
        addParam("enter_time", this.mTime);
    }
}
