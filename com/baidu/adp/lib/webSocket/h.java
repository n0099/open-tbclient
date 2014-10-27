package com.baidu.adp.lib.webSocket;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
/* loaded from: classes.dex */
class h implements g {
    private SocketChannel oY;
    private long oZ;
    private String pa;
    private String pd;
    private String pe;

    public h(String str, int i, am amVar) {
        this.oY = null;
        this.oZ = 0L;
        this.pa = null;
        this.pd = null;
        this.pe = null;
        this.oY = SocketChannel.open();
        long currentTimeMillis = System.currentTimeMillis();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
        if (inetSocketAddress.getAddress() != null) {
            this.pa = inetSocketAddress.getAddress().getHostAddress();
            this.oZ = System.currentTimeMillis() - currentTimeMillis;
        }
        this.oY.socket().connect(inetSocketAddress, amVar.go());
        this.oY.socket().setSoTimeout(amVar.gn());
        this.oY.socket().setTcpNoDelay(amVar.getTcpNoDelay());
        this.pd = com.baidu.adp.lib.util.m.fv();
        this.pe = com.baidu.adp.lib.util.m.fw();
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public void close() {
        if (this.oY != null) {
            this.oY.close();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public boolean isConnected() {
        if (this.oY != null) {
            return this.oY.isConnected();
        }
        return false;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public int read(ByteBuffer byteBuffer) {
        return this.oY.read(byteBuffer);
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public int write(ByteBuffer byteBuffer) {
        return this.oY.write(byteBuffer);
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public String fQ() {
        return this.pa;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public long fR() {
        return this.oZ;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public String fv() {
        return this.pd;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public String fw() {
        return this.pe;
    }
}
