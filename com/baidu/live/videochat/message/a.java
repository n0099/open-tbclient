package com.baidu.live.videochat.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class a extends HttpMessage {
    private String action;
    private int type;

    public boolean WI() {
        return this.type == 2;
    }

    public boolean WJ() {
        return "ban".equals(this.action);
    }
}
