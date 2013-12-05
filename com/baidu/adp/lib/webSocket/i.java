package com.baidu.adp.lib.webSocket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
class i implements g {

    /* renamed from: a  reason: collision with root package name */
    private Socket f538a;
    private InputStream b;
    private OutputStream c;
    private byte[] d;

    public i(String str, int i, am amVar) {
        this.f538a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.f538a = new Socket();
        this.f538a.connect(new InetSocketAddress(str, i), amVar.f());
        this.f538a.setSoTimeout(amVar.e());
        this.f538a.setTcpNoDelay(amVar.d());
        this.b = this.f538a.getInputStream();
        this.c = this.f538a.getOutputStream();
        this.d = new byte[1024];
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public void a() {
        try {
            this.b.close();
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.a(e.getMessage());
        }
        try {
            this.c.close();
        } catch (Exception e2) {
            com.baidu.adp.lib.h.e.a(e2.getMessage());
        }
        if (this.f538a != null) {
            this.f538a.close();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public boolean b() {
        if (this.f538a != null) {
            return this.f538a.isConnected();
        }
        return false;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public int a(ByteBuffer byteBuffer) {
        int read = this.b.read(this.d);
        if (read > 0) {
            byteBuffer.put(this.d, 0, read);
        }
        return read;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public int b(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        if (remaining > 0) {
            byte[] bArr = new byte[remaining];
            byteBuffer.get(bArr);
            this.c.write(bArr);
        }
        return remaining;
    }
}
