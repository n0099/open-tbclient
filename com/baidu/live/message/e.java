package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class e extends HttpMessage {
    private String aEp;

    public e(String str) {
        super(1021120);
        this.aEp = str;
        addParam("scene_from", this.aEp);
    }
}
