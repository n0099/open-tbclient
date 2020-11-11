package com.baidu.live.talentshow.model;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class e extends HttpMessage {
    private com.baidu.live.talentshow.b.d bzn;

    public e() {
        super(1021226);
    }

    public void d(com.baidu.live.talentshow.b.d dVar) {
        this.bzn = dVar;
    }

    public com.baidu.live.talentshow.b.d SC() {
        return this.bzn;
    }

    public void setLiveId(long j) {
        addParam("live_id", j);
    }

    public void setRoomId(long j) {
        addParam("room_id", j);
    }

    public void h(long j, long j2) {
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
