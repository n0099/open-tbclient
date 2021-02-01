package com.baidu.live.guess.http;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class d extends HttpMessage {
    public d() {
        super(1021215);
    }

    public void setUserId(String str) {
        addParam("user_id", str);
    }

    public void dy(int i) {
        addParam("ques_id", i);
    }
}
