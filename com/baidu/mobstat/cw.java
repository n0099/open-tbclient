package com.baidu.mobstat;

import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public interface cw {

    /* loaded from: classes2.dex */
    public enum a {
        CONTINUOUS,
        TEXT,
        BINARY,
        PING,
        PONG,
        CLOSING
    }

    void a(cw cwVar) throws co;

    ByteBuffer c();

    boolean d();

    boolean e();

    a f();
}
