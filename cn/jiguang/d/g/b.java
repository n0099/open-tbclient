package cn.jiguang.d.g;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
/* loaded from: classes3.dex */
public final class b extends a {
    private ByteBuffer mq = ByteBuffer.allocate(8192);

    private boolean j(byte[] bArr) {
        try {
            if (b() && bArr != null && bArr.length > 0) {
                int write = this.mo.write(ByteBuffer.wrap(bArr));
                return write > 0 || write >= 0;
            }
            return false;
        } catch (Exception e) {
            cn.jiguang.e.c.c("NioSocketClient", "send data error:" + e.getMessage());
            a();
            return false;
        }
    }

    @Override // cn.jiguang.d.g.a
    public final d F(int i) {
        ByteBuffer G;
        if (b()) {
            int c = c();
            if (c <= 0 || (G = G(c)) == null) {
                int i2 = 1048576;
                while (b() && this.c < i2) {
                    try {
                        if ((i > 0 ? this.mp.select(i) : this.mp.select()) != 0) {
                            Iterator<SelectionKey> it = this.mp.selectedKeys().iterator();
                            while (it.hasNext()) {
                                SelectionKey next = it.next();
                                SocketChannel socketChannel = (SocketChannel) next.channel();
                                if (next.isReadable()) {
                                    int read = socketChannel.read(this.mq);
                                    if (read < 0) {
                                        return new d(-996, "read len < 0:" + read);
                                    }
                                    this.mq.flip();
                                    int limit = this.mq.limit();
                                    if (this.a.remaining() < limit) {
                                        return new d(-996, "the total buf remaining less than readLen,remaining:" + this.a.remaining() + ",readLen:" + limit);
                                    }
                                    this.a.put(this.mq);
                                    this.c += limit;
                                    this.mq.compact();
                                    i2 = this.c >= 20 ? c() : i2;
                                } else {
                                    next.isWritable();
                                }
                                it.remove();
                            }
                            continue;
                        } else if (i > 0) {
                            return new d(-994, "recv time out");
                        }
                    } catch (Throwable th) {
                        d dVar = new d(-997, th.getMessage());
                        if (th instanceof SocketTimeoutException) {
                            dVar.a(-994);
                            return dVar;
                        }
                        return dVar;
                    }
                }
                if (i2 == 1048576) {
                    return new d(-997, "recv empty data or tcp has close");
                }
                ByteBuffer G2 = G(i2);
                return G2 != null ? new d(0, G2) : new d(-1001, "parse error");
            }
            return new d(0, G);
        }
        return new d(-991, "recv error,the connect is invalid");
    }

    @Override // cn.jiguang.d.g.a
    public final synchronized int a(String str, int i) {
        int i2 = -991;
        synchronized (this) {
            super.a(str, i);
            this.mo = SocketChannel.open();
            this.mp = Selector.open();
            this.mo.configureBlocking(false);
            this.mo.connect(new InetSocketAddress(str, i));
            long currentTimeMillis = System.currentTimeMillis();
            while (true) {
                if (!this.mo.finishConnect()) {
                    if (!this.e) {
                        break;
                    } else if (System.currentTimeMillis() - currentTimeMillis > 3000) {
                        a();
                        i2 = -994;
                        break;
                    }
                } else if (this.e) {
                    this.mo.register(this.mp, 1);
                    i2 = 0;
                }
            }
        }
        return i2;
    }

    @Override // cn.jiguang.d.g.a
    public final void a() {
        super.a();
        if (this.mp != null) {
            try {
                this.mp.close();
            } catch (IOException e) {
            }
        }
        if (this.mo != null) {
            try {
                this.mo.close();
            } catch (Exception e2) {
            }
        }
        this.mo = null;
    }

    @Override // cn.jiguang.d.g.a
    public final int i(byte[] bArr) {
        if (bArr == null) {
            return 103;
        }
        if (bArr.length >= 8128) {
            return 6026;
        }
        return j(bArr) ? 0 : 103;
    }
}
