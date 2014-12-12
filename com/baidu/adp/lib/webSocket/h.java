package com.baidu.adp.lib.webSocket;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
/* loaded from: classes.dex */
class h implements g {
    private SocketChannel oX;
    private long oY;
    private String oZ;
    private String pa;
    private String pd;

    public h(String str, int i, am amVar) {
        this.oX = null;
        this.oY = 0L;
        this.oZ = null;
        this.pa = null;
        this.pd = null;
        this.oX = SocketChannel.open();
        long currentTimeMillis = System.currentTimeMillis();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
        if (inetSocketAddress.getAddress() != null) {
            this.oZ = inetSocketAddress.getAddress().getHostAddress();
            this.oY = System.currentTimeMillis() - currentTimeMillis;
        }
        this.oX.socket().connect(inetSocketAddress, amVar.gp());
        this.oX.socket().setSoTimeout(amVar.go());
        this.oX.socket().setTcpNoDelay(amVar.getTcpNoDelay());
        this.pa = com.baidu.adp.lib.util.l.fv();
        this.pd = com.baidu.adp.lib.util.l.fw();
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public void close() {
        if (this.oX != null) {
            this.oX.close();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public boolean isConnected() {
        if (this.oX != null) {
            return this.oX.isConnected();
        }
        return false;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public int read(ByteBuffer byteBuffer) {
        return this.oX.read(byteBuffer);
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public int write(ByteBuffer byteBuffer) {
        return this.oX.write(byteBuffer);
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public String fS() {
        return this.oZ;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public long fT() {
        return this.oY;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public String fv() {
        return this.pa;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public String fw() {
        return this.pd;
    }
}
