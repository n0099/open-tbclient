package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes2.dex */
public class e extends HttpMessage {
    private String aiQ;

    public e(String str) {
        super(1021120);
        this.aiQ = str;
        addParam("scene_from", this.aiQ);
    }
}
