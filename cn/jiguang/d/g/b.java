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
    private ByteBuffer mu = ByteBuffer.allocate(8192);

    private boolean k(byte[] bArr) {
        try {
            if (b() && bArr != null && bArr.length > 0) {
                int write = this.mr.write(ByteBuffer.wrap(bArr));
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
    public final synchronized int a(String str, int i) {
        int i2 = -991;
        synchronized (this) {
            super.a(str, i);
            this.mr = SocketChannel.open();
            this.mt = Selector.open();
            this.mr.configureBlocking(false);
            this.mr.connect(new InetSocketAddress(str, i));
            long currentTimeMillis = System.currentTimeMillis();
            while (true) {
                if (!this.mr.finishConnect()) {
                    if (!this.e) {
                        break;
                    } else if (System.currentTimeMillis() - currentTimeMillis > 3000) {
                        a();
                        i2 = -994;
                        break;
                    }
                } else if (this.e) {
                    this.mr.register(this.mt, 1);
                    i2 = 0;
                }
            }
        }
        return i2;
    }

    @Override // cn.jiguang.d.g.a
    public final void a() {
        super.a();
        if (this.mt != null) {
            try {
                this.mt.close();
            } catch (IOException e) {
            }
        }
        if (this.mr != null) {
            try {
                this.mr.close();
            } catch (Exception e2) {
            }
        }
        this.mr = null;
    }

    @Override // cn.jiguang.d.g.a
    public final int j(byte[] bArr) {
        if (bArr == null) {
            return 103;
        }
        if (bArr.length >= 8128) {
            return 6026;
        }
        return k(bArr) ? 0 : 103;
    }

    @Override // cn.jiguang.d.g.a
    public final d o(int i) {
        ByteBuffer p;
        if (b()) {
            int c = c();
            if (c <= 0 || (p = p(c)) == null) {
                int i2 = 1048576;
                while (b() && this.c < i2) {
                    try {
                        if ((i > 0 ? this.mt.select(i) : this.mt.select()) != 0) {
                            Iterator<SelectionKey> it = this.mt.selectedKeys().iterator();
                            while (it.hasNext()) {
                                SelectionKey next = it.next();
                                SocketChannel socketChannel = (SocketChannel) next.channel();
                                if (next.isReadable()) {
                                    int read = socketChannel.read(this.mu);
                                    if (read < 0) {
                                        return new d(-996, "read len < 0:" + read);
                                    }
                                    this.mu.flip();
                                    int limit = this.mu.limit();
                                    if (this.a.remaining() < limit) {
                                        return new d(-996, "the total buf remaining less than readLen,remaining:" + this.a.remaining() + ",readLen:" + limit);
                                    }
                                    this.a.put(this.mu);
                                    this.c += limit;
                                    this.mu.compact();
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
                ByteBuffer p2 = p(i2);
                return p2 != null ? new d(0, p2) : new d(-1001, "parse error");
            }
            return new d(0, p);
        }
        return new d(-991, "recv error,the connect is invalid");
    }
}
