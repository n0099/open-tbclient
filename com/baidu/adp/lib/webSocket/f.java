package com.baidu.adp.lib.webSocket;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public interface f {
    void close();

    boolean isConnected();

    String jE();

    long jF();

    int jG();

    String jm();

    String jn();

    int read(ByteBuffer byteBuffer);

    int write(ByteBuffer byteBuffer);
}
