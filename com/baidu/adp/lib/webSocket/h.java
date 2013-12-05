package com.baidu.adp.lib.webSocket;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
/* loaded from: classes.dex */
class h implements g {

    /* renamed from: a  reason: collision with root package name */
    private SocketChannel f537a;

    public h(String str, int i, am amVar) {
        this.f537a = null;
        this.f537a = SocketChannel.open();
        this.f537a.socket().connect(new InetSocketAddress(str, i), amVar.f());
        this.f537a.socket().setSoTimeout(amVar.e());
        this.f537a.socket().setTcpNoDelay(amVar.d());
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public void a() {
        if (this.f537a != null) {
            this.f537a.close();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public boolean b() {
        if (this.f537a != null) {
            return this.f537a.isConnected();
        }
        return false;
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public int a(ByteBuffer byteBuffer) {
        return this.f537a.read(byteBuffer);
    }

    @Override // com.baidu.adp.lib.webSocket.g
    public int b(ByteBuffer byteBuffer) {
        return this.f537a.write(byteBuffer);
    }
}
