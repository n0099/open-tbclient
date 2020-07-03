package com.baidu.live.im.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class c extends HttpMessage {
    private long aWr;

    public c(int i) {
        super(i);
    }

    public void al(long j) {
        this.aWr = j;
    }

    public boolean am(long j) {
        return j - this.aWr >= 2000;
    }
}
