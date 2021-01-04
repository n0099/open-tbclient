package com.baidu.live.follow.http;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class b extends HttpMessage {
    private String liveId;

    public b() {
        super(1021196);
    }

    public void setUserId(String str) {
        addParam("id", str);
    }

    public void setLiveId(String str) {
        this.liveId = str;
        addParam("live_id", str);
    }
}
