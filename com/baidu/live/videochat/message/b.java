package com.baidu.live.videochat.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes10.dex */
public class b extends HttpMessage {
    private boolean bMG;

    public b(boolean z) {
        super(1021180);
        this.bMG = z;
    }

    public boolean Ve() {
        return this.bMG;
    }
}
