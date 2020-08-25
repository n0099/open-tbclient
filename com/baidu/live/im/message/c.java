package com.baidu.live.im.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes7.dex */
public class c extends HttpMessage {
    private long bcB;

    public c(int i) {
        super(i);
    }

    public void am(long j) {
        this.bcB = j;
    }

    public boolean an(long j) {
        return j - this.bcB >= 2000;
    }
}
