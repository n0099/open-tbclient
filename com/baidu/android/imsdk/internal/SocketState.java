package com.baidu.android.imsdk.internal;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class SocketState {
    Integer mSocketId = null;
    Boolean mSocketCreateOk = false;
    Boolean mSocketEnvOk = false;
    Socket mSocket = null;
    InputStream mInputStream = null;
    OutputStream mOutputStream = null;
}
