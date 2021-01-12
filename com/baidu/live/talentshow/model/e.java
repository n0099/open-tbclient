package com.baidu.live.talentshow.model;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class e extends HttpMessage {
    private com.baidu.live.talentshow.b.d bCL;

    public e() {
        super(1021225);
    }

    public void d(com.baidu.live.talentshow.b.d dVar) {
        this.bCL = dVar;
    }

    public com.baidu.live.talentshow.b.d RD() {
        return this.bCL;
    }

    public void setLiveId(long j) {
        addParam("live_id", j);
    }

    public void setRoomId(long j) {
        addParam("room_id", j);
    }

    public void k(long j, long j2) {
        addParam("connect_user_id1", j);
        addParam("connect_user_id2", j2);
    }

    public void setUserId(long j) {
        addParam("user_id", j);
    }

    public void setSource(String str) {
        addParam("source", str);
    }
}
