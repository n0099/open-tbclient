package com.baidu.adp.lib.webSocket;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
interface g {
    void close();

    String fQ();

    long fR();

    String fv();

    String fw();

    boolean isConnected();

    int read(ByteBuffer byteBuffer);

    int write(ByteBuffer byteBuffer);
}
