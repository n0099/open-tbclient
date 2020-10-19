package com.baidu.live.guess.http;

import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    public a() {
        super(1021218);
    }

    public void setUserId(long j) {
        addParam("user_id", j);
    }

    public void setQuesId(long j) {
        addParam("ques_id", j);
    }

    public void setAnswer(int i) {
        addParam(UgcUBCUtils.QUESTION_REPLY_PAGE, i);
    }

    public void setCuid(String str) {
        addParam("cuid", str);
    }
}
