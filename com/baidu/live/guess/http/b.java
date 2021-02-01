package com.baidu.live.guess.http;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class b extends HttpMessage {
    public b() {
        super(1021239);
    }

    public void setUserId(String str) {
        addParam("user_id", str);
    }

    public void setQuesId(long j) {
        addParam("ques_id", j);
    }

    public void ft(String str) {
        addParam("team_id", str);
    }

    public void setRoomId(long j) {
        addParam("room_id", j);
    }
}
