package com.baidu.live.videochat.message;

import com.baidu.live.adp.framework.message.HttpMessage;
/* loaded from: classes3.dex */
public class b extends HttpMessage {
    private boolean bgB;

    public b(boolean z) {
        super(1021180);
        this.bgB = z;
    }

    public boolean IW() {
        return this.bgB;
    }
}
