package com.baidu.live.im.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class c extends HttpMessage {
    private long bkx;

    public c(int i) {
        super(i);
    }

    public void an(long j) {
        this.bkx = j;
    }

    public boolean ao(long j) {
        return j - this.bkx >= 2000;
    }
}
