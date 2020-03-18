package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class b extends HttpMessage {
    private String awC;
    private long awD;
    private long mAlaId;
    private long mTime;

    public void setFrom(String str) {
        this.awC = str;
    }

    public void setLiveId(long j) {
        this.awD = j;
    }

    public void H(long j) {
        this.mTime = j;
    }

    public b() {
        super(1021007);
        this.awC = "";
        this.awD = 0L;
        this.mAlaId = 0L;
        this.mTime = 0L;
    }

    public void setParams() {
        addParam("from_type", this.awC);
        addParam("live_id", this.awD);
        addParam("enter_time", this.mTime);
    }
}
