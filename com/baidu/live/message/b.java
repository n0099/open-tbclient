package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class b extends HttpMessage {
    private String aQf;
    private long aQg;
    private long mAlaId;
    private long mTime;

    public void setFrom(String str) {
        this.aQf = str;
    }

    public void setLiveId(long j) {
        this.aQg = j;
    }

    public void aj(long j) {
        this.mTime = j;
    }

    public b() {
        super(1021007);
        this.aQf = "";
        this.aQg = 0L;
        this.mAlaId = 0L;
        this.mTime = 0L;
    }

    public void setParams() {
        addParam("from_type", this.aQf);
        addParam("live_id", this.aQg);
        addParam("enter_time", this.mTime);
    }
}
