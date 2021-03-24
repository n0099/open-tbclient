package com.baidu.mobstat;

import java.net.InetSocketAddress;
/* loaded from: classes2.dex */
public interface by {

    /* loaded from: classes2.dex */
    public enum a {
        NOT_YET_CONNECTED,
        CONNECTING,
        OPEN,
        CLOSING,
        CLOSED
    }

    /* loaded from: classes2.dex */
    public enum b {
        CLIENT
    }

    InetSocketAddress a();

    void a(cq cqVar);
}
