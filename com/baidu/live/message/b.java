package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes7.dex */
public class b extends HttpMessage {
    private String bex;
    private long bey;
    private long mAlaId;
    private long mTime;

    public void setFrom(String str) {
        this.bex = str;
    }

    public void setLiveId(long j) {
        this.bey = j;
    }

    public void ao(long j) {
        this.mTime = j;
    }

    public b() {
        super(1021007);
        this.bex = "";
        this.bey = 0L;
        this.mAlaId = 0L;
        this.mTime = 0L;
    }

    public void setParams() {
        addParam("from_type", this.bex);
        addParam("live_id", this.bey);
        addParam("enter_time", this.mTime);
    }
}
