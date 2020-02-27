package com.baidu.live.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class e extends HttpMessage {
    private String alI;

    public e(String str) {
        super(1021120);
        this.alI = str;
        addParam("scene_from", this.alI);
    }
}
