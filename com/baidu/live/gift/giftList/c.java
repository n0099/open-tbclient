package com.baidu.live.gift.giftList;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes6.dex */
public class c extends HttpMessage {
    private String abg;

    public c(String str) {
        super(1021120);
        this.abg = str;
        addParam("scene_from", this.abg);
    }
}
