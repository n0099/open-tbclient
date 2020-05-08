package com.baidu.live.videochat.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class a extends HttpMessage {
    private String action;
    private int type;

    public boolean GV() {
        return this.type == 2;
    }

    public boolean GW() {
        return "ban".equals(this.action);
    }
}
