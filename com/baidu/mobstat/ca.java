package com.baidu.mobstat;

import com.baidu.mobstat.by;
import com.baidu.mobstat.cd;
import com.baidu.mobstat.cq;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes3.dex */
public class ca implements by {

    /* renamed from: a  reason: collision with root package name */
    public static final List<cd> f3783a;

    /* renamed from: b  reason: collision with root package name */
    public static int f3784b;
    public static boolean c;
    static final /* synthetic */ boolean h;
    public final BlockingQueue<ByteBuffer> d;
    public final BlockingQueue<ByteBuffer> e;
    public SelectionKey f;
    public ByteChannel g;
    private final cb i;
    private cd l;
    private by.b m;
    private volatile boolean j = false;
    private by.a k = by.a.NOT_YET_CONNECTED;
    private cq n = null;
    private ByteBuffer o = ByteBuffer.allocate(0);
    private cs p = null;
    private String q = null;
    private Integer r = null;
    private Boolean s = null;
    private String t = null;

    static {
        h = !ca.class.desiredAssertionStatus();
        f3783a = new ArrayList(4);
        f3784b = 16384;
        c = false;
        f3783a.add(new cf());
        f3783a.add(new ce());
    }

    public ca(cb cbVar, cd cdVar) {
        this.l = null;
        if (cbVar == null || cdVar == null) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.d = new LinkedBlockingQueue();
        this.e = new LinkedBlockingQueue();
        this.i = cbVar;
        this.m = by.b.CLIENT;
        if (cdVar != null) {
            this.l = cdVar.c();
        }
    }

    public void a(ByteBuffer byteBuffer) {
        if (!h && !byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
        if (c) {
            System.out.println("process(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining())) + "}");
        }
        if (this.k != by.a.NOT_YET_CONNECTED) {
            d(byteBuffer);
        } else if (c(byteBuffer)) {
            if (!h && this.o.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                d(byteBuffer);
            } else if (this.o.hasRemaining()) {
                d(this.o);
            }
        }
        if (!h && !d() && !e() && byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0138  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean c(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        if (this.o.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.o.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.o.capacity() + byteBuffer.remaining());
                this.o.flip();
                allocate.put(this.o);
                this.o = allocate;
            }
            this.o.put(byteBuffer);
            this.o.flip();
            byteBuffer2 = this.o;
        }
        byteBuffer2.mark();
        try {
        } catch (cg e) {
            if (this.o.capacity() != 0) {
            }
        }
        if (this.l == null && e(byteBuffer2) == cd.b.MATCHED) {
            try {
                f(ByteBuffer.wrap(dc.a(this.i.a(this))));
                a(-3, "");
            } catch (ch e2) {
                c(1006, "remote peer closed connection before flashpolicy could be transmitted", true);
            }
            return false;
        }
        try {
            if (this.m == by.b.CLIENT) {
                this.l.a(this.m);
                cx d = this.l.d(byteBuffer2);
                if (!(d instanceof cz)) {
                    b(1002, "wrong http function", false);
                    return false;
                }
                cz czVar = (cz) d;
                if (this.l.a(this.p, czVar) == cd.b.MATCHED) {
                    try {
                        this.i.a(this, this.p, czVar);
                        a(czVar);
                        return true;
                    } catch (ch e3) {
                        b(e3.a(), e3.getMessage(), false);
                        return false;
                    } catch (RuntimeException e4) {
                        this.i.a(this, e4);
                        b(-1, e4.getMessage(), false);
                        return false;
                    }
                }
                a(1002, "draft " + this.l + " refuses handshake");
            }
        } catch (cj e5) {
            a(e5);
        }
        return false;
        if (this.o.capacity() != 0) {
            byteBuffer2.reset();
            int a2 = e.a();
            if (a2 == 0) {
                a2 = byteBuffer2.capacity() + 16;
            } else if (!h && e.a() < byteBuffer2.remaining()) {
                throw new AssertionError();
            }
            this.o = ByteBuffer.allocate(a2);
            this.o.put(byteBuffer);
        } else {
            this.o.position(this.o.limit());
            this.o.limit(this.o.capacity());
        }
        return false;
    }

    private void d(ByteBuffer byteBuffer) {
        String str;
        try {
        } catch (ch e) {
            this.i.a(this, e);
            a(e);
            return;
        }
        for (cq cqVar : this.l.c(byteBuffer)) {
            if (c) {
                System.out.println("matched frame: " + cqVar);
            }
            cq.a f = cqVar.f();
            boolean d = cqVar.d();
            if (this.k != by.a.CLOSING) {
                if (f == cq.a.CLOSING) {
                    int i = 1005;
                    if (!(cqVar instanceof cn)) {
                        str = "";
                    } else {
                        cn cnVar = (cn) cqVar;
                        int a2 = cnVar.a();
                        str = cnVar.b();
                        i = a2;
                    }
                    if (this.k == by.a.CLOSING) {
                        a(i, str, true);
                    } else if (this.l.b() == cd.a.TWOWAY) {
                        c(i, str, true);
                    } else {
                        b(i, str, false);
                    }
                } else if (f == cq.a.PING) {
                    this.i.b(this, cqVar);
                } else if (f == cq.a.PONG) {
                    this.i.c(this, cqVar);
                } else {
                    if (!d || f == cq.a.CONTINUOUS) {
                        if (f != cq.a.CONTINUOUS) {
                            if (this.n != null) {
                                throw new ch(1002, "Previous continuous frame sequence not completed.");
                            }
                            this.n = cqVar;
                        } else if (d) {
                            if (this.n == null) {
                                throw new ch(1002, "Continuous frame sequence was not started.");
                            }
                            if (this.n.f() == cq.a.TEXT) {
                                int max = Math.max(this.n.c().limit() - 64, 0);
                                this.n.a(cqVar);
                                if (!dc.a(this.n.c(), max)) {
                                    throw new ch(1007);
                                }
                            }
                            this.n = null;
                        } else if (this.n == null) {
                            throw new ch(1002, "Continuous frame sequence was not started.");
                        }
                        if (f == cq.a.TEXT && !dc.b(cqVar.c())) {
                            throw new ch(1007);
                        }
                        if (f == cq.a.CONTINUOUS && this.n != null && this.n.f() == cq.a.TEXT) {
                            int max2 = Math.max(this.n.c().limit() - 64, 0);
                            this.n.a(cqVar);
                            if (!dc.a(this.n.c(), max2)) {
                                throw new ch(1007);
                            }
                        }
                        try {
                            this.i.a(this, cqVar);
                        } catch (RuntimeException e2) {
                            this.i.a(this, e2);
                        }
                    } else if (this.n != null) {
                        throw new ch(1002, "Continuous frame sequence not completed.");
                    } else {
                        if (f == cq.a.TEXT) {
                            try {
                                this.i.a(this, dc.a(cqVar.c()));
                            } catch (RuntimeException e3) {
                                this.i.a(this, e3);
                            }
                        } else if (f == cq.a.BINARY) {
                            try {
                                this.i.a(this, cqVar.c());
                            } catch (RuntimeException e4) {
                                this.i.a(this, e4);
                            }
                        } else {
                            throw new ch(1002, "non control or continious frame expected");
                        }
                    }
                    this.i.a(this, e);
                    a(e);
                    return;
                }
            } else {
                return;
            }
        }
    }

    private void c(int i, String str, boolean z) {
        if (this.k != by.a.CLOSING && this.k != by.a.CLOSED) {
            if (this.k == by.a.OPEN) {
                if (i == 1006) {
                    if (!h && z) {
                        throw new AssertionError();
                    }
                    this.k = by.a.CLOSING;
                    b(i, str, false);
                    return;
                }
                if (this.l.b() != cd.a.NONE) {
                    if (!z) {
                        try {
                            try {
                                this.i.a(this, i, str);
                            } catch (RuntimeException e) {
                                this.i.a(this, e);
                            }
                        } catch (ch e2) {
                            this.i.a(this, e2);
                            b(1006, "generated frame is invalid", false);
                        }
                    }
                    a(new co(i, str));
                }
                b(i, str, z);
            } else if (i == -3) {
                if (!h && !z) {
                    throw new AssertionError();
                }
                b(-3, str, true);
            } else {
                b(-1, str, false);
            }
            if (i == 1002) {
                b(i, str, z);
            }
            this.k = by.a.CLOSING;
            this.o = null;
        }
    }

    public void a(int i, String str) {
        c(i, str, false);
    }

    protected synchronized void a(int i, String str, boolean z) {
        if (this.k != by.a.CLOSED) {
            if (this.f != null) {
                this.f.cancel();
            }
            if (this.g != null) {
                try {
                    this.g.close();
                } catch (IOException e) {
                    this.i.a(this, e);
                }
            }
            try {
                this.i.a(this, i, str, z);
            } catch (RuntimeException e2) {
                this.i.a(this, e2);
            }
            if (this.l != null) {
                this.l.a();
            }
            this.p = null;
            this.k = by.a.CLOSED;
            this.d.clear();
        }
    }

    protected void a(int i, boolean z) {
        a(i, "", z);
    }

    public void b(int i, String str) {
        a(i, str, false);
    }

    protected synchronized void b(int i, String str, boolean z) {
        if (!this.j) {
            this.r = Integer.valueOf(i);
            this.q = str;
            this.s = Boolean.valueOf(z);
            this.j = true;
            this.i.b(this);
            try {
                this.i.b(this, i, str, z);
            } catch (RuntimeException e) {
                this.i.a(this, e);
            }
            if (this.l != null) {
                this.l.a();
            }
            this.p = null;
        }
    }

    public void b() {
        if (g() == by.a.NOT_YET_CONNECTED) {
            a(-1, true);
        } else if (this.j) {
            a(this.r.intValue(), this.q, this.s.booleanValue());
        } else if (this.l.b() == cd.a.NONE) {
            a(1000, true);
        } else if (this.l.b() == cd.a.ONEWAY) {
            a(1000, true);
        } else {
            a(1006, true);
        }
    }

    public void a(int i) {
        c(i, "", false);
    }

    public void a(ch chVar) {
        c(chVar.a(), chVar.getMessage(), false);
    }

    public void b(ByteBuffer byteBuffer) throws IllegalArgumentException, cm {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        a(this.l.a(byteBuffer, this.m == by.b.CLIENT));
    }

    public void a(byte[] bArr) throws IllegalArgumentException, cm {
        b(ByteBuffer.wrap(bArr));
    }

    private void a(Collection<cq> collection) {
        if (!c()) {
            throw new cm();
        }
        for (cq cqVar : collection) {
            a(cqVar);
        }
    }

    @Override // com.baidu.mobstat.by
    public void a(cq cqVar) {
        if (c) {
            System.out.println("send frame: " + cqVar);
        }
        f(this.l.a(cqVar));
    }

    private cd.b e(ByteBuffer byteBuffer) throws cg {
        byteBuffer.mark();
        if (byteBuffer.limit() > cd.c.length) {
            return cd.b.NOT_MATCHED;
        }
        if (byteBuffer.limit() < cd.c.length) {
            throw new cg(cd.c.length);
        }
        int i = 0;
        while (byteBuffer.hasRemaining()) {
            if (cd.c[i] == byteBuffer.get()) {
                i++;
            } else {
                byteBuffer.reset();
                return cd.b.NOT_MATCHED;
            }
        }
        return cd.b.MATCHED;
    }

    public void a(ct ctVar) throws cj {
        if (!h && this.k == by.a.CONNECTING) {
            throw new AssertionError("shall only be called once");
        }
        this.p = this.l.a(ctVar);
        this.t = ctVar.a();
        if (!h && this.t == null) {
            throw new AssertionError();
        }
        try {
            this.i.a((by) this, this.p);
            a(this.l.a(this.p, this.m));
        } catch (ch e) {
            throw new cj("Handshake data rejected by client.");
        } catch (RuntimeException e2) {
            this.i.a(this, e2);
            throw new cj("rejected because of" + e2);
        }
    }

    private void f(ByteBuffer byteBuffer) {
        if (c) {
            System.out.println("write(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())) + "}");
        }
        this.d.add(byteBuffer);
        this.i.b(this);
    }

    private void a(List<ByteBuffer> list) {
        for (ByteBuffer byteBuffer : list) {
            f(byteBuffer);
        }
    }

    private void a(cx cxVar) {
        if (c) {
            System.out.println("open using draft: " + this.l.getClass().getSimpleName());
        }
        this.k = by.a.OPEN;
        try {
            this.i.a(this, cxVar);
        } catch (RuntimeException e) {
            this.i.a(this, e);
        }
    }

    public boolean c() {
        if (!h && this.k == by.a.OPEN && this.j) {
            throw new AssertionError();
        }
        return this.k == by.a.OPEN;
    }

    public boolean d() {
        return this.k == by.a.CLOSING;
    }

    public boolean e() {
        return this.j;
    }

    public boolean f() {
        return this.k == by.a.CLOSED;
    }

    public by.a g() {
        return this.k;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    @Override // com.baidu.mobstat.by
    public InetSocketAddress a() {
        return this.i.c(this);
    }
}
