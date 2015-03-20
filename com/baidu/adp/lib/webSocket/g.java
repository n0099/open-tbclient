package com.baidu.adp.lib.webSocket;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
/* loaded from: classes.dex */
class g implements f {
    private SocketChannel zQ;
    private long zR;
    private String zS;
    private String zT;
    private String zU;

    public g(String str, int i, al alVar) {
        this.zQ = null;
        this.zR = 0L;
        this.zS = null;
        this.zT = null;
        this.zU = null;
        this.zQ = SocketChannel.open();
        long currentTimeMillis = System.currentTimeMillis();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
        if (inetSocketAddress.getAddress() != null) {
            this.zS = inetSocketAddress.getAddress().getHostAddress();
            this.zR = System.currentTimeMillis() - currentTimeMillis;
        }
        this.zQ.socket().connect(inetSocketAddress, alVar.jK());
        this.zQ.socket().setSoTimeout(alVar.jJ());
        this.zQ.socket().setTcpNoDelay(alVar.getTcpNoDelay());
        this.zT = com.baidu.adp.lib.util.n.iX();
        this.zU = com.baidu.adp.lib.util.n.iY();
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public void close() {
        if (this.zQ != null) {
            this.zQ.close();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public boolean isConnected() {
        if (this.zQ != null) {
            return this.zQ.isConnected();
        }
        return false;
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public int read(ByteBuffer byteBuffer) {
        return this.zQ.read(byteBuffer);
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public int write(ByteBuffer byteBuffer) {
        return this.zQ.write(byteBuffer);
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public String jn() {
        return this.zS;
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public long jo() {
        return this.zR;
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public String iX() {
        return this.zT;
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public String iY() {
        return this.zU;
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public int jp() {
        return 0;
    }
}
