package com.baidu.live.gift.giftList;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes7.dex */
public class a extends HttpMessage {
    private boolean isHost;

    public a(boolean z) {
        super(1021089);
        this.isHost = z;
    }

    public boolean isHost() {
        return this.isHost;
    }
}
