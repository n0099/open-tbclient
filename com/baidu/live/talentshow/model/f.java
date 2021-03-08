package com.baidu.live.talentshow.model;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.mobstat.Config;
/* loaded from: classes10.dex */
public class f extends HttpMessage {
    public f() {
        super(1021224);
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

    public void bs(long j) {
        addParam(Config.PACKAGE_NAME, j);
    }

    public void setSource(String str) {
        addParam("source", str);
    }
}
