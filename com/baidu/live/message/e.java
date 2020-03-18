package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class e extends HttpMessage {
    private String alT;

    public e(String str) {
        super(1021120);
        this.alT = str;
        addParam("scene_from", this.alT);
    }
}
