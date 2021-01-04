package com.baidu.live.im.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class c extends HttpMessage {
    private long bqR;

    public c(int i) {
        super(i);
    }

    public void aW(long j) {
        this.bqR = j;
    }

    public boolean aX(long j) {
        return j - this.bqR >= 2000;
    }
}
