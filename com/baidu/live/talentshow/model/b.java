package com.baidu.live.talentshow.model;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class b extends HttpMessage {
    public b() {
        super(1021223);
    }

    public void setLiveId(long j) {
        addParam("live_id", j);
    }

    public void setRoomId(long j) {
        addParam("room_id", j);
    }
}
