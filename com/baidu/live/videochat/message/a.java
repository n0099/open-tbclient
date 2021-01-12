package com.baidu.live.videochat.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class a extends HttpMessage {
    private String action;
    private int type;

    public boolean UW() {
        return this.type == 2;
    }

    public boolean UX() {
        return "ban".equals(this.action);
    }
}
