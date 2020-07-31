package com.baidu.live.follow.http;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private String liveId;

    public a() {
        super(1021196);
    }

    public void setUserId(String str) {
        addParam("id", str);
    }

    public void eH(String str) {
        this.liveId = str;
        addParam("live_id", str);
    }
}
