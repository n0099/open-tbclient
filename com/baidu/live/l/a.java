package com.baidu.live.l;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes2.dex */
public class a extends HttpMessage {
    private int mType;

    public a(int i) {
        super(1021031);
        this.mType = 1;
        this.mType = i;
        addParam("block_type", i);
    }
}
