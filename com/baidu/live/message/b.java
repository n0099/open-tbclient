package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class b extends HttpMessage {
    private String blg;
    private long blh;
    private long mAlaId;
    private long mTime;

    public void setFrom(String str) {
        this.blg = str;
    }

    public void setLiveId(long j) {
        this.blh = j;
    }

    public void ao(long j) {
        this.mTime = j;
    }

    public b() {
        super(1021007);
        this.blg = "";
        this.blh = 0L;
        this.mAlaId = 0L;
        this.mTime = 0L;
    }

    public void setParams() {
        addParam("from_type", this.blg);
        addParam("live_id", this.blh);
        addParam("enter_time", this.mTime);
    }
}
