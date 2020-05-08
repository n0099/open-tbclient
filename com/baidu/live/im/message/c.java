package com.baidu.live.im.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class c extends HttpMessage {
    private long aNE;

    public c(int i) {
        super(i);
    }

    public void ah(long j) {
        this.aNE = j;
    }

    public boolean ai(long j) {
        return j - this.aNE >= 2000;
    }
}
