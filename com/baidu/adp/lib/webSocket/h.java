package com.baidu.adp.lib.webSocket;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
/* loaded from: classes.dex */
class h implements g {
    private SocketChannel pe;
    private long pf;
    private String pg;
    private String ph;
    private String pi;

    public h(String str, int i, am amVar) {
        this.pe = null;
        this.pf = 0L;
        this.pg = null;
        this.ph = null;
        this.pi = null;
        this.pe = SocketChannel.open();
        long currentTimeMillis = System.currentTimeMillis();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
        if (inetSocketAddress.getAddress() != null) {
            this.pg = inetSocketAddress.getAddress().getHostAddress();
            this.pf = System.currentTimeMillis() - currentTimeMillis;
        }
        this.pe.socket().connect(inetSocketAddress, amVar.go());
        this.pe.socket().setSoTimeout(amVar.gn());
        this.pe.socket().setTcpNoDelay(amVar.getTcpNoDelay());
        this.ph = com.baidu.adp.lib.util.l.fu();
        this.pi = com.baidu.adp.lib.util.l.fv();
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public void close() {
        if (this.pe != null) {
            this.pe.close();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public boolean isConnected() {
        if (this.pe != null) {
            return this.pe.isConnected();
        }
        return false;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public int read(ByteBuffer byteBuffer) {
        return this.pe.read(byteBuffer);
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public int write(ByteBuffer byteBuffer) {
        return this.pe.write(byteBuffer);
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public String fR() {
        return this.pg;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public long fS() {
        return this.pf;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public String fu() {
        return this.ph;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public String fv() {
        return this.pi;
    }
}
