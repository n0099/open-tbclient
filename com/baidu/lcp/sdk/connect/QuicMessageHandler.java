package com.baidu.lcp.sdk.connect;

import android.content.Context;
import d.b.s.a.c.b;
import d.b.s.a.c.c;
import d.b.s.a.c.d;
import d.b.s.a.c.e;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class QuicMessageHandler extends d implements c {
    static {
        System.loadLibrary("native-lib");
    }

    public QuicMessageHandler(Context context) {
        super(context);
        initGlobalRef(this);
    }

    @Override // d.b.s.a.c.d
    public InputStream b() throws EOFException, IOException {
        return null;
    }

    @Override // d.b.s.a.c.d
    public void c(e eVar) {
    }

    public native void closeStream(int i);

    @Override // d.b.s.a.c.d
    public boolean d() throws IOException {
        return false;
    }

    @Override // d.b.s.a.c.d
    public e e(String str, int i) {
        return null;
    }

    public native void enableQuicCache(boolean z, String str);

    @Override // d.b.s.a.c.d
    public void f(b bVar) throws IOException {
    }

    public native void initGlobalRef(c cVar);

    public native int sendMsg(byte[] bArr);

    public native int startConnect(String str, String str2);

    public native int stopConnect();
}
