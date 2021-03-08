package com.baidu.live.im.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class c extends HttpMessage {
    private long brf;

    public c(int i) {
        super(i);
    }

    public void ba(long j) {
        this.brf = j;
    }

    public boolean bb(long j) {
        return j - this.brf >= 2000;
    }
}
