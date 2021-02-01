package com.baidu.live.im.message;

import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes11.dex */
public class AlaLocalIMCustomResponseMessage extends CustomResponsedMessage {
    private boolean aFW;
    private boolean bnI;
    private boolean bpG;
    private String content;
    private short msgType;

    public short Ln() {
        return this.msgType;
    }

    public boolean isOfficial() {
        return this.aFW;
    }

    public boolean Lx() {
        return this.bnI;
    }

    public boolean Ly() {
        return this.bpG;
    }

    public String getContent() {
        return this.content;
    }
}
