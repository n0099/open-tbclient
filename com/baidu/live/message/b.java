package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class b extends HttpMessage {
    private String aZd;
    private long aZe;
    private long mAlaId;
    private long mTime;

    public void setFrom(String str) {
        this.aZd = str;
    }

    public void setLiveId(long j) {
        this.aZe = j;
    }

    public void an(long j) {
        this.mTime = j;
    }

    public b() {
        super(1021007);
        this.aZd = "";
        this.aZe = 0L;
        this.mAlaId = 0L;
        this.mTime = 0L;
    }

    public void setParams() {
        addParam("from_type", this.aZd);
        addParam("live_id", this.aZe);
        addParam("enter_time", this.mTime);
    }
}
