package com.baidu.live.im.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes7.dex */
public class c extends HttpMessage {
    private long bcD;

    public c(int i) {
        super(i);
    }

    public void am(long j) {
        this.bcD = j;
    }

    public boolean an(long j) {
        return j - this.bcD >= 2000;
    }
}
