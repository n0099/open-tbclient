package com.baidu.live.im.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class c extends HttpMessage {
    private long aTK;

    public c(int i) {
        super(i);
    }

    public void al(long j) {
        this.aTK = j;
    }

    public boolean am(long j) {
        return j - this.aTK >= 2000;
    }
}
