package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class b extends HttpMessage {
    private String aWu;
    private long aWv;
    private long mAlaId;
    private long mTime;

    public void setFrom(String str) {
        this.aWu = str;
    }

    public void setLiveId(long j) {
        this.aWv = j;
    }

    public void an(long j) {
        this.mTime = j;
    }

    public b() {
        super(1021007);
        this.aWu = "";
        this.aWv = 0L;
        this.mAlaId = 0L;
        this.mTime = 0L;
    }

    public void setParams() {
        addParam("from_type", this.aWu);
        addParam("live_id", this.aWv);
        addParam("enter_time", this.mTime);
    }
}
