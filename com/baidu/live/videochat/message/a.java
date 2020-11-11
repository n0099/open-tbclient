package com.baidu.live.videochat.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class a extends HttpMessage {
    private String action;
    private int type;

    public boolean VQ() {
        return this.type == 2;
    }

    public boolean VR() {
        return "ban".equals(this.action);
    }
}
