package com.baidu.lcp.sdk.connect;

import android.content.Context;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class QuicMessageHandler extends d implements c {
    public native void closeStream(int i);

    public native void enableQuicCache(boolean z, String str);

    public native void initGlobalRef(c cVar);

    public native int sendMsg(byte[] bArr);

    public native int startConnect(String str, String str2);

    public native int stopConnect();

    static {
        System.loadLibrary("native-lib");
    }

    public QuicMessageHandler(Context context) {
        super(context);
        initGlobalRef(this);
    }

    @Override // com.baidu.lcp.sdk.connect.d
    public e y(String str, int i) {
        return null;
    }

    @Override // com.baidu.lcp.sdk.connect.d
    public boolean socketClose() throws IOException {
        return false;
    }

    @Override // com.baidu.lcp.sdk.connect.d
    public void a(e eVar) {
    }

    @Override // com.baidu.lcp.sdk.connect.d
    public void a(b bVar) throws IOException {
    }

    @Override // com.baidu.lcp.sdk.connect.d
    public InputStream vK() throws EOFException, IOException {
        return null;
    }
}
