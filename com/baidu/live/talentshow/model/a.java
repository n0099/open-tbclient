package com.baidu.live.talentshow.model;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    public a() {
        super(1021222);
    }

    public void setLiveId(long j) {
        addParam("live_id", j);
    }

    public void setRoomId(long j) {
        addParam("room_id", j);
    }

    public void setImUK(long j) {
        addParam("im_uk", j);
    }

    public void it(String str) {
        addParam("subapp_type", str);
    }

    public void setSource(String str) {
        addParam("source", str);
    }
}
