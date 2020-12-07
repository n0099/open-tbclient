package com.baidu.live.gift.giftList;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private String giftId;
    private boolean isHost;

    public a(boolean z, String str) {
        super(1021089);
        this.isHost = z;
        this.giftId = str;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public String Kq() {
        return this.giftId;
    }
}
