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
    private ByteBuffer lL = ByteBuffer.allocate(8192);

    private boolean k(byte[] bArr) {
        try {
            if (b() && bArr != null && bArr.length > 0) {
                int write = this.lJ.write(ByteBuffer.wrap(bArr));
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
            this.lJ = SocketChannel.open();
            this.lK = Selector.open();
            this.lJ.configureBlocking(false);
            this.lJ.connect(new InetSocketAddress(str, i));
            long currentTimeMillis = System.currentTimeMillis();
            while (true) {
                if (!this.lJ.finishConnect()) {
                    if (!this.e) {
                        break;
                    } else if (System.currentTimeMillis() - currentTimeMillis > 3000) {
                        a();
                        i2 = -994;
                        break;
                    }
                } else if (this.e) {
                    this.lJ.register(this.lK, 1);
                    i2 = 0;
                }
            }
        }
        return i2;
    }

    @Override // cn.jiguang.d.g.a
    public final void a() {
        super.a();
        if (this.lK != null) {
            try {
                this.lK.close();
            } catch (IOException e) {
            }
        }
        if (this.lJ != null) {
            try {
                this.lJ.close();
            } catch (Exception e2) {
            }
        }
        this.lJ = null;
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
                        if ((i > 0 ? this.lK.select(i) : this.lK.select()) != 0) {
                            Iterator<SelectionKey> it = this.lK.selectedKeys().iterator();
                            while (it.hasNext()) {
                                SelectionKey next = it.next();
                                SocketChannel socketChannel = (SocketChannel) next.channel();
                                if (next.isReadable()) {
                                    int read = socketChannel.read(this.lL);
                                    if (read < 0) {
                                        return new d(-996, "read len < 0:" + read);
                                    }
                                    this.lL.flip();
                                    int limit = this.lL.limit();
                                    if (this.a.remaining() < limit) {
                                        return new d(-996, "the total buf remaining less than readLen,remaining:" + this.a.remaining() + ",readLen:" + limit);
                                    }
                                    this.a.put(this.lL);
                                    this.c += limit;
                                    this.lL.compact();
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
