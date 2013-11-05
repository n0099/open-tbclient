package com.baidu.adp.lib.webSocket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
class h implements f {

    /* renamed from: a  reason: collision with root package name */
    private Socket f534a;
    private InputStream b;
    private OutputStream c;
    private byte[] d;

    public h(String str, int i, ai aiVar) {
        this.f534a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.f534a = new Socket();
        this.f534a.connect(new InetSocketAddress(str, i), aiVar.f());
        this.f534a.setSoTimeout(aiVar.e());
        this.f534a.setTcpNoDelay(aiVar.d());
        this.b = this.f534a.getInputStream();
        this.c = this.f534a.getOutputStream();
        this.d = new byte[1024];
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public void a() {
        try {
            this.b.close();
        } catch (Exception e) {
            com.baidu.adp.lib.h.d.a(e.getMessage());
        }
        try {
            this.c.close();
        } catch (Exception e2) {
            com.baidu.adp.lib.h.d.a(e2.getMessage());
        }
        if (this.f534a != null) {
            this.f534a.close();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public boolean b() {
        if (this.f534a != null) {
            return this.f534a.isConnected();
        }
        return false;
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public int a(ByteBuffer byteBuffer) {
        int read = this.b.read(this.d);
        if (read > 0) {
            byteBuffer.put(this.d, 0, read);
        }
        return read;
    }

    @Override // com.baidu.adp.lib.webSocket.f
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
