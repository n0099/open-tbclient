package com.baidu.mobstat;

import java.net.InetSocketAddress;
/* loaded from: classes6.dex */
public interface ce {

    /* loaded from: classes6.dex */
    public enum a {
        NOT_YET_CONNECTED,
        CONNECTING,
        OPEN,
        CLOSING,
        CLOSED
    }

    /* loaded from: classes6.dex */
    public enum b {
        CLIENT
    }

    InetSocketAddress a();

    void a(cw cwVar);
}
