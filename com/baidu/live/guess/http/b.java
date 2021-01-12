package com.baidu.live.guess.http;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class b extends HttpMessage {
    public b() {
        super(1021215);
    }

    public void setUserId(long j) {
        addParam("user_id", j);
    }

    public void dt(int i) {
        addParam("ques_id", i);
    }
}
