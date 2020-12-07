package com.baidu.live.im.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class c extends HttpMessage {
    private long bpk;

    public c(int i) {
        super(i);
    }

    public void aX(long j) {
        this.bpk = j;
    }

    public boolean aY(long j) {
        return j - this.bpk >= 2000;
    }
}
