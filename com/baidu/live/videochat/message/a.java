package com.baidu.live.videochat.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes7.dex */
public class a extends HttpMessage {
    private String action;
    private int type;

    public boolean Qa() {
        return this.type == 2;
    }

    public boolean Qb() {
        return "ban".equals(this.action);
    }
}
