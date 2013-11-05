package com.baidu.adp.lib.webSocket;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
/* loaded from: classes.dex */
class g implements f {

    /* renamed from: a  reason: collision with root package name */
    private SocketChannel f533a;

    public g(String str, int i, ai aiVar) {
        this.f533a = null;
        this.f533a = SocketChannel.open();
        this.f533a.socket().connect(new InetSocketAddress(str, i), aiVar.f());
        this.f533a.socket().setSoTimeout(aiVar.e());
        this.f533a.socket().setTcpNoDelay(aiVar.d());
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public void a() {
        if (this.f533a != null) {
            this.f533a.close();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public boolean b() {
        if (this.f533a != null) {
            return this.f533a.isConnected();
        }
        return false;
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public int a(ByteBuffer byteBuffer) {
        return this.f533a.read(byteBuffer);
    }

    @Override // com.baidu.adp.lib.webSocket.f
    public int b(ByteBuffer byteBuffer) {
        return this.f533a.write(byteBuffer);
    }
}
