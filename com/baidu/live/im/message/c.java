package com.baidu.live.im.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class c extends HttpMessage {
    private long bkg;

    public c(int i) {
        super(i);
    }

    public void az(long j) {
        this.bkg = j;
    }

    public boolean aA(long j) {
        return j - this.bkg >= 2000;
    }
}
