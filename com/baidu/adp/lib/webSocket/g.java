package com.baidu.adp.lib.webSocket;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
/* loaded from: classes.dex */
class g implements f {
    private SocketChannel zF;
    private long zG;
    private String zH;
    private String zI;
    private String zJ;

    public g(String str, int i, al alVar) {
        this.zF = null;
        this.zG = 0L;
        this.zH = null;
        this.zI = null;
        this.zJ = null;
        this.zF = SocketChannel.open();
        long currentTimeMillis = System.currentTimeMillis();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
        if (inetSocketAddress.getAddress() != null) {
            this.zH = inetSocketAddress.getAddress().getHostAddress();
            this.zG = System.currentTimeMillis() - currentTimeMillis;
        }
        this.zF.socket().connect(inetSocketAddress, alVar.kb());
        this.zF.socket().setSoTimeout(alVar.ka());
        this.zF.socket().setTcpNoDelay(alVar.getTcpNoDelay());
        this.zI = com.baidu.adp.lib.util.n.jm();
        this.zJ = com.baidu.adp.lib.util.n.jn();
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public void close() {
        if (this.zF != null) {
            this.zF.close();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public boolean isConnected() {
        if (this.zF != null) {
            return this.zF.isConnected();
        }
        return false;
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public int read(ByteBuffer byteBuffer) {
        return this.zF.read(byteBuffer);
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public int write(ByteBuffer byteBuffer) {
        return this.zF.write(byteBuffer);
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public String jE() {
        return this.zH;
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public long jF() {
        return this.zG;
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public String jm() {
        return this.zI;
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public String jn() {
        return this.zJ;
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public int jG() {
        return 0;
    }
}
