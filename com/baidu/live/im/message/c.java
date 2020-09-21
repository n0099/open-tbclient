package com.baidu.live.im.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class c extends HttpMessage {
    private long bfq;

    public c(int i) {
        super(i);
    }

    public void al(long j) {
        this.bfq = j;
    }

    public boolean am(long j) {
        return j - this.bfq >= 2000;
    }
}
