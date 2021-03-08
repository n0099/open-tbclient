package com.baidu.live.im.message;

import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes10.dex */
public class AlaLocalIMCustomResponseMessage extends CustomResponsedMessage {
    private boolean aHw;
    private boolean bpi;
    private boolean brg;
    private String content;
    private short msgType;

    public short Lq() {
        return this.msgType;
    }

    public boolean isOfficial() {
        return this.aHw;
    }

    public boolean LA() {
        return this.bpi;
    }

    public boolean LB() {
        return this.brg;
    }

    public String getContent() {
        return this.content;
    }
}
