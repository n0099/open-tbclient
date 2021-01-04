package com.baidu.live.yuyingift.giftlist;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class c extends HttpMessage {
    private boolean bgw;
    private String giftId;
    private boolean isHost;

    public c(boolean z, boolean z2, String str) {
        super(1031058);
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
