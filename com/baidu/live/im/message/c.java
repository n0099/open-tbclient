package com.baidu.live.im.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class c extends HttpMessage {
    private long aXl;

    public c(int i) {
        super(i);
    }

    public void al(long j) {
        this.aXl = j;
    }

    public boolean am(long j) {
        return j - this.aXl >= 2000;
    }
}
