package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes2.dex */
public class b extends HttpMessage {
    private String aru;
    private long arv;
    private long mAlaId;
    private long mTime;

    public void setFrom(String str) {
        this.aru = str;
    }

    public void setLiveId(long j) {
        this.arv = j;
    }

    public void D(long j) {
        this.mTime = j;
    }

    public b() {
        super(1021007);
        this.aru = "";
        this.arv = 0L;
        this.mAlaId = 0L;
        this.mTime = 0L;
    }

    public void setParams() {
        addParam("from_type", this.aru);
        addParam("live_id", this.arv);
        addParam("enter_time", this.mTime);
    }
}
