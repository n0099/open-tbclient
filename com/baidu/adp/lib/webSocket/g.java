package com.baidu.adp.lib.webSocket;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
interface g {
    void close();

    String fR();

    long fS();

    String fu();

    String fv();

    boolean isConnected();

    int read(ByteBuffer byteBuffer);

    int write(ByteBuffer byteBuffer);
}
