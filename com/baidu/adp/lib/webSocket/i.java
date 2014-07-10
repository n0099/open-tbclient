package com.baidu.adp.lib.webSocket;

import com.baidu.adp.lib.util.BdLog;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
class i implements g {
    private Socket a;
    private InputStream b;
    private OutputStream c;
    private byte[] d;
    private long e;
    private String f;
    private String g;
    private String h;

    public i(String str, int i, am amVar) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = 0L;
        this.f = null;
        this.g = null;
        this.h = null;
        this.a = new Socket();
        long currentTimeMillis = System.currentTimeMillis();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
        if (inetSocketAddress.getAddress() != null) {
            this.f = inetSocketAddress.getAddress().getHostAddress();
            this.e = System.currentTimeMillis() - currentTimeMillis;
        }
        this.a.connect(inetSocketAddress, amVar.f());
        this.a.setSoTimeout(amVar.e());
        this.a.setTcpNoDelay(amVar.d());
        this.b = this.a.getInputStream();
        this.c = this.a.getOutputStream();
        this.d = new byte[1024];
        this.g = com.baidu.adp.lib.util.j.d();
        this.h = com.baidu.adp.lib.util.j.e();
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public void a() {
        try {
            this.b.close();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        try {
            this.c.close();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        if (this.a != null) {
            this.a.close();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public boolean b() {
        if (this.a != null) {
            return this.a.isConnected();
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

    @Override // com.baidu.adp.lib.webSocket.g
    public String c() {
        return this.f;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public long d() {
        return this.e;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public String e() {
        return this.g;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public String f() {
        return this.h;
    }
}
