package com.baidu.live.gift.giftList;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class a extends HttpMessage {
    private boolean bgw;
    private String giftId;
    private boolean isHost;

    public a(boolean z, boolean z2, String str) {
        super(1021089);
        this.isHost = z;
        this.bgw = z2;
        this.giftId = str;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public String JS() {
        return this.giftId;
    }
}
