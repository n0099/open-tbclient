package com.baidu.mobstat;

import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public interface cq {

    /* loaded from: classes2.dex */
    public enum a {
        CONTINUOUS,
        TEXT,
        BINARY,
        PING,
        PONG,
        CLOSING
    }

    void a(cq cqVar) throws ci;

    ByteBuffer c();

    boolean d();

    boolean e();

    a f();
}
