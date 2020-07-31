package com.baidu.live.sdk.goods.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    public a() {
        super(1021202);
    }

    public void a(long j, long j2, String str, long j3, long j4) {
        addParam("live_id", j);
        addParam("user_id", j2);
        addParam("user_name", str);
        addParam("anchor_id", j3);
        addParam("group_id", j4);
    }
}
