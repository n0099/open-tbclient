package com.baidu.live.im.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class c extends HttpMessage {
    private long bjc;

    public c(int i) {
        super(i);
    }

    public void am(long j) {
        this.bjc = j;
    }

    public boolean an(long j) {
        return j - this.bjc >= 2000;
    }
}
