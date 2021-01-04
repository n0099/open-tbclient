package com.baidu.live.im.message;

import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes11.dex */
public class AlaLocalIMCustomResponseMessage extends CustomResponsedMessage {
    private boolean aIW;
    private boolean bpc;
    private boolean bqS;
    private String content;
    private short msgType;

    public short NK() {
        return this.msgType;
    }

    public boolean isOfficial() {
        return this.aIW;
    }

    public boolean NT() {
        return this.bpc;
    }

    public boolean NU() {
        return this.bqS;
    }

    public String getContent() {
        return this.content;
    }
}
