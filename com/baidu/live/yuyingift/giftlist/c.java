package com.baidu.live.yuyingift.giftlist;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class c extends HttpMessage {
    private String giftId;
    private boolean isHost;

    public c(boolean z, String str) {
        super(1031058);
        this.isHost = z;
        this.giftId = str;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public String Iy() {
        return this.giftId;
    }
}
