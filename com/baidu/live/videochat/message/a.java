package com.baidu.live.videochat.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class a extends HttpMessage {
    private String action;
    private int type;

    public boolean YP() {
        return this.type == 2;
    }

    public boolean YQ() {
        return "ban".equals(this.action);
    }
}
