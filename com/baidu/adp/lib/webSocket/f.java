package com.baidu.adp.lib.webSocket;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public interface f {
    void close();

    String iX();

    String iY();

    boolean isConnected();

    String jn();

    long jo();

    int jp();

    int read(ByteBuffer byteBuffer);

    int write(ByteBuffer byteBuffer);
}
