package com.baidu.live.personmanager;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class c extends HttpMessage {
    private int mType;

    public c(int i) {
        super(1021031);
        this.mType = 1;
        this.mType = i;
        addParam("block_type", i);
    }
}
