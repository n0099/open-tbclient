package com.baidu.live.im.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class c extends HttpMessage {
    private long bme;

    public c(int i) {
        super(i);
    }

    public void aW(long j) {
        this.bme = j;
    }

    public boolean aX(long j) {
        return j - this.bme >= 2000;
    }
}
