package com.baidu.adp.lib.webSocket;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
/* loaded from: classes.dex */
class h implements g {
    private SocketChannel a;

    public h(String str, int i, am amVar) {
        this.a = null;
        this.a = SocketChannel.open();
        this.a.socket().connect(new InetSocketAddress(str, i), amVar.f());
        this.a.socket().setSoTimeout(amVar.e());
        this.a.socket().setTcpNoDelay(amVar.d());
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
}
