package com.baidu.live.yyrtc;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class c extends HttpMessage {
    public c() {
        super(1021240);
    }

    public void aZ(String str, String str2) {
        addParam("appid", str);
        addParam("uk", str2);
    }
}
