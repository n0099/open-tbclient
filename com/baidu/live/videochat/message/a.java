package com.baidu.live.videochat.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class a extends HttpMessage {
    private String action;
    private int type;

    public boolean GW() {
        return this.type == 2;
    }

    public boolean GX() {
        return "ban".equals(this.action);
    }
}
