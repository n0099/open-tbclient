package com.baidu.live.gift.giftList;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes6.dex */
public class c extends HttpMessage {
    private String aaN;

    public c(String str) {
        super(1021120);
        this.aaN = str;
        addParam("scene_from", this.aaN);
    }
}
