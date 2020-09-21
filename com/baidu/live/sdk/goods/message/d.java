package com.baidu.live.sdk.goods.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class d extends HttpMessage {
    public String gid;
    public String liveId;
    public int type;

    public d() {
        super(1021208);
    }

    public void gi(String str) {
        this.liveId = str;
        addParam("live_id", str);
    }

    public void setGid(String str) {
        this.gid = str;
        addParam("gid", str);
    }

    public void setType(int i) {
        this.type = i;
        addParam("type", i);
    }
}
