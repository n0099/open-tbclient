package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class b extends HttpMessage {
    private String aQl;
    private long aQm;
    private long mAlaId;
    private long mTime;

    public void setFrom(String str) {
        this.aQl = str;
    }

    public void setLiveId(long j) {
        this.aQm = j;
    }

    public void aj(long j) {
        this.mTime = j;
    }

    public b() {
        super(1021007);
        this.aQl = "";
        this.aQm = 0L;
        this.mAlaId = 0L;
        this.mTime = 0L;
    }

    public void setParams() {
        addParam("from_type", this.aQl);
        addParam("live_id", this.aQm);
        addParam("enter_time", this.mTime);
    }
}
