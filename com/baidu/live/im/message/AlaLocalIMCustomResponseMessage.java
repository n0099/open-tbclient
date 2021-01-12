package com.baidu.live.im.message;

import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes10.dex */
public class AlaLocalIMCustomResponseMessage extends CustomResponsedMessage {
    private boolean aEj;
    private boolean bkp;
    private boolean bmf;
    private String content;
    private short msgType;

    public short JP() {
        return this.msgType;
    }

    public boolean isOfficial() {
        return this.aEj;
    }

    public boolean JY() {
        return this.bkp;
    }

    public boolean JZ() {
        return this.bmf;
    }

    public String getContent() {
        return this.content;
    }
}
