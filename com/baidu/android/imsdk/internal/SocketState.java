package com.baidu.android.imsdk.internal;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
/* loaded from: classes2.dex */
public class SocketState {
    public InputStream mInputStream;
    public OutputStream mOutputStream;
    public Socket mSocket;
    public Boolean mSocketCreateOk;
    public Boolean mSocketEnvOk;
    public Integer mSocketId = null;

    public SocketState() {
        Boolean bool = Boolean.FALSE;
        this.mSocketCreateOk = bool;
        this.mSocketEnvOk = bool;
        this.mSocket = null;
        this.mInputStream = null;
        this.mOutputStream = null;
    }
}
