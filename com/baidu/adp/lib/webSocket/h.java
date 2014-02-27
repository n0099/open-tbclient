package com.baidu.adp.lib.webSocket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
final class h implements g {
    private Socket a;
    private InputStream b;
    private OutputStream c;
    private byte[] d;

    public h(String str, int i, al alVar) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.a = new Socket();
        this.a.connect(new InetSocketAddress(str, i), alVar.f());
        this.a.setSoTimeout(alVar.e());
        this.a.setTcpNoDelay(alVar.d());
        this.b = this.a.getInputStream();
        this.c = this.a.getOutputStream();
        this.d = new byte[1024];
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public final void a() {
        try {
            this.b.close();
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(e.getMessage());
        }
        try {
            this.c.close();
        } catch (Exception e2) {
            com.baidu.adp.lib.util.e.b(e2.getMessage());
        }
        if (this.a != null) {
            this.a.close();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public final boolean b() {
        if (this.a != null) {
            return this.a.isConnected();
        }
        return false;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public final int a(ByteBuffer byteBuffer) {
        int read = this.b.read(this.d);
        if (read > 0) {
            byteBuffer.put(this.d, 0, read);
        }
        return read;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public final int b(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        if (remaining > 0) {
            byte[] bArr = new byte[remaining];
            byteBuffer.get(bArr);
            this.c.write(bArr);
        }
        return remaining;
    }
}
