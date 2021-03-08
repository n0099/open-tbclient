package com.baidu.live.guess.http;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class a extends HttpMessage {
    public a() {
        super(1021237);
    }

    public void setQuesId(long j) {
        addParam("ques_id", j);
    }

    public void setIsFirst(int i) {
        addParam("is_first", i);
    }

    public void setUserId(String str) {
        addParam("user_id", str);
    }
}
