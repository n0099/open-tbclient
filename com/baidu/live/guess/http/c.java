package com.baidu.live.guess.http;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class c extends HttpMessage {
    public c() {
        super(1021218);
    }

    public void setUserId(String str) {
        addParam("user_id", str);
    }

    public void setQuesId(long j) {
        addParam("ques_id", j);
    }

    public void setAnswer(int i) {
        addParam("answer", i);
    }

    public void setCuid(String str) {
        addParam("cuid", str);
    }

    public void aV(long j) {
        addParam("is_double_coupon", j);
    }
}
