package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes7.dex */
public class b extends HttpMessage {
    private String bev;
    private long bew;
    private long mAlaId;
    private long mTime;

    public void setFrom(String str) {
        this.bev = str;
    }

    public void setLiveId(long j) {
        this.bew = j;
    }

    public void ao(long j) {
        this.mTime = j;
    }

    public b() {
        super(1021007);
        this.bev = "";
        this.bew = 0L;
        this.mAlaId = 0L;
        this.mTime = 0L;
    }

    public void setParams() {
        addParam("from_type", this.bev);
        addParam("live_id", this.bew);
        addParam("enter_time", this.mTime);
    }
}
