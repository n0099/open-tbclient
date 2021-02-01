package com.baidu.live.im.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class c extends HttpMessage {
    private long bpF;

    public c(int i) {
        super(i);
    }

    public void ba(long j) {
        this.bpF = j;
    }

    public boolean bb(long j) {
        return j - this.bpF >= 2000;
    }
}
