package com.baidu.live.videochat.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes4.dex */
public class b extends HttpMessage {
    private boolean bAF;

    public b(boolean z) {
        super(1021180);
        this.bAF = z;
    }

    public boolean Sy() {
        return this.bAF;
    }
}
