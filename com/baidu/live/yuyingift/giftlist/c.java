package com.baidu.live.yuyingift.giftlist;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class c extends HttpMessage {
    private boolean bbF;
    private String giftId;
    private boolean isHost;

    public c(boolean z, boolean z2, String str) {
        super(1031058);
        this.isHost = z;
        this.bbF = z2;
        this.giftId = str;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public String FX() {
        return this.giftId;
    }
}
