package com.baidu.live.personmanager;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class g extends HttpMessage {
    private int mType;

    public g(int i) {
        super(1031049);
        this.mType = 1;
        this.mType = i;
        addParam("block_type", i);
    }
}
