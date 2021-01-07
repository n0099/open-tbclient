package com.baidu.live.videochat.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes11.dex */
public class b extends HttpMessage {
    private boolean bRs;

    public b(boolean z) {
        super(1021180);
        this.bRs = z;
    }

    public boolean YX() {
        return this.bRs;
    }
}
