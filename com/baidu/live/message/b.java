package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class b extends HttpMessage {
    private String aZb;
    private long aZc;
    private long mAlaId;
    private long mTime;

    public void setFrom(String str) {
        this.aZb = str;
    }

    public void setLiveId(long j) {
        this.aZc = j;
    }

    public void an(long j) {
        this.mTime = j;
    }

    public b() {
        super(1021007);
        this.aZb = "";
        this.aZc = 0L;
        this.mAlaId = 0L;
        this.mTime = 0L;
    }

    public void setParams() {
        addParam("from_type", this.aZb);
        addParam("live_id", this.aZc);
        addParam("enter_time", this.mTime);
    }
}
