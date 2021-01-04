package com.baidu.live.follow.http;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class a extends HttpMessage {
    public a() {
        super(1021234);
    }

    public void setUserId(String str) {
        addParam("user_id", str);
    }
}
