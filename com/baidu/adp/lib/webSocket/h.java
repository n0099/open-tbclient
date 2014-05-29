package com.baidu.adp.lib.webSocket;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
/* loaded from: classes.dex */
class h implements g {
    private SocketChannel a;
    private long b;
    private String c;
    private String d;
    private String e;

    public h(String str, int i, am amVar) {
        this.a = null;
        this.b = 0L;
        this.c = null;
        this.d = null;
        this.e = null;
        this.a = SocketChannel.open();
        long currentTimeMillis = System.currentTimeMillis();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
        if (inetSocketAddress.getAddress() != null) {
            this.c = inetSocketAddress.getAddress().getHostAddress();
            this.b = System.currentTimeMillis() - currentTimeMillis;
        }
        this.a.socket().connect(inetSocketAddress, amVar.f());
        this.a.socket().setSoTimeout(amVar.e());
        this.a.socket().setTcpNoDelay(amVar.d());
        this.d = com.baidu.adp.lib.util.k.e();
        this.e = com.baidu.adp.lib.util.k.f();
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public void a() {
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
        return this.a.read(byteBuffer);
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public int b(ByteBuffer byteBuffer) {
        return this.a.write(byteBuffer);
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public String c() {
        return this.c;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public long d() {
        return this.b;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public String e() {
        return this.d;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public String f() {
        return this.e;
    }
}
