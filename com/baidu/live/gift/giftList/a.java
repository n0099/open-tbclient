package com.baidu.live.gift.giftList;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class a extends HttpMessage {
    private boolean beM;
    private String giftId;
    private boolean isHost;

    public a(boolean z, boolean z2, String str) {
        super(1021089);
        this.isHost = z;
        this.beM = z2;
        this.giftId = str;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public String Hn() {
        return this.giftId;
    }
}
