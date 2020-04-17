package com.baidu.live.im.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class c extends HttpMessage {
    private long aNy;

    public c(int i) {
        super(i);
    }

    public void ah(long j) {
        this.aNy = j;
    }

    public boolean ai(long j) {
        return j - this.aNy >= 2000;
    }
}
