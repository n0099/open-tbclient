package com.baidu.mobstat;

import com.baidu.mobstat.by;
import com.baidu.mobstat.cd;
import com.baidu.mobstat.cq;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes2.dex */
public class ca implements by {

    /* renamed from: a  reason: collision with root package name */
    public static final List<cd> f8738a;

    /* renamed from: b  reason: collision with root package name */
    public static int f8739b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f8740c;

    /* renamed from: h  reason: collision with root package name */
    public static final /* synthetic */ boolean f8741h = !ca.class.desiredAssertionStatus();

    /* renamed from: d  reason: collision with root package name */
    public final BlockingQueue<ByteBuffer> f8742d;

    /* renamed from: e  reason: collision with root package name */
    public final BlockingQueue<ByteBuffer> f8743e;

    /* renamed from: f  reason: collision with root package name */
    public SelectionKey f8744f;

    /* renamed from: g  reason: collision with root package name */
    public ByteChannel f8745g;

    /* renamed from: i  reason: collision with root package name */
    public final cb f8746i;
    public cd l;
    public by.b m;
    public volatile boolean j = false;
    public by.a k = by.a.NOT_YET_CONNECTED;
    public cq n = null;
    public ByteBuffer o = ByteBuffer.allocate(0);
    public cs p = null;
    public String q = null;
    public Integer r = null;
    public Boolean s = null;
    public String t = null;

    static {
        ArrayList arrayList = new ArrayList(4);
        f8738a = arrayList;
        f8739b = 16384;
        f8740c = false;
        arrayList.add(new cf());
        f8738a.add(new ce());
    }

    public ca(cb cbVar, cd cdVar) {
        this.l = null;
        if (cbVar != null && cdVar != null) {
            this.f8742d = new LinkedBlockingQueue();
            this.f8743e = new LinkedBlockingQueue();
            this.f8746i = cbVar;
            this.m = by.b.CLIENT;
            if (cdVar != null) {
                this.l = cdVar.c();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("parameters must not be null");
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x011c  */
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
        } catch (cg e2) {
            if (this.o.capacity() != 0) {
            }
        }
        if (this.l == null && e(byteBuffer2) == cd.b.MATCHED) {
            try {
                f(ByteBuffer.wrap(dc.a(this.f8746i.a(this))));
                a(-3, "");
            } catch (ch unused) {
                c(1006, "remote peer closed connection before flashpolicy could be transmitted", true);
            }
            return false;
        }
        try {
            if (this.m == by.b.CLIENT) {
                this.l.a(this.m);
                cx d2 = this.l.d(byteBuffer2);
                if (!(d2 instanceof cz)) {
                    b(1002, "wrong http function", false);
                    return false;
                }
                cz czVar = (cz) d2;
                if (this.l.a(this.p, czVar) == cd.b.MATCHED) {
                    try {
                        this.f8746i.a(this, this.p, czVar);
                        a(czVar);
                        return true;
                    } catch (ch e3) {
                        b(e3.a(), e3.getMessage(), false);
                        return false;
                    } catch (RuntimeException e4) {
                        this.f8746i.a(this, e4);
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
            int a2 = e2.a();
            if (a2 == 0) {
                a2 = byteBuffer2.capacity() + 16;
            } else if (!f8741h && e2.a() < byteBuffer2.remaining()) {
                throw new AssertionError();
            }
            ByteBuffer allocate2 = ByteBuffer.allocate(a2);
            this.o = allocate2;
            allocate2.put(byteBuffer);
        } else {
            ByteBuffer byteBuffer3 = this.o;
            byteBuffer3.position(byteBuffer3.limit());
            ByteBuffer byteBuffer4 = this.o;
            byteBuffer4.limit(byteBuffer4.capacity());
        }
        return false;
    }

    private void d(ByteBuffer byteBuffer) {
        try {
        } catch (ch e2) {
            this.f8746i.a(this, e2);
            a(e2);
            return;
        }
        for (cq cqVar : this.l.c(byteBuffer)) {
            if (f8740c) {
                PrintStream printStream = System.out;
                printStream.println("matched frame: " + cqVar);
            }
            cq.a f2 = cqVar.f();
            boolean d2 = cqVar.d();
            if (this.k == by.a.CLOSING) {
                return;
            }
            if (f2 == cq.a.CLOSING) {
                int i2 = 1005;
                String str = "";
                if (cqVar instanceof cn) {
                    cn cnVar = (cn) cqVar;
                    i2 = cnVar.a();
                    str = cnVar.b();
                }
                if (this.k == by.a.CLOSING) {
                    a(i2, str, true);
                } else if (this.l.b() == cd.a.TWOWAY) {
                    c(i2, str, true);
                } else {
                    b(i2, str, false);
                }
            } else if (f2 == cq.a.PING) {
                this.f8746i.b(this, cqVar);
            } else if (f2 == cq.a.PONG) {
                this.f8746i.c(this, cqVar);
            } else {
                if (d2 && f2 != cq.a.CONTINUOUS) {
                    if (this.n == null) {
                        if (f2 == cq.a.TEXT) {
                            try {
                                this.f8746i.a(this, dc.a(cqVar.c()));
                            } catch (RuntimeException e3) {
                                this.f8746i.a(this, e3);
                            }
                        } else if (f2 == cq.a.BINARY) {
                            try {
                                this.f8746i.a(this, cqVar.c());
                            } catch (RuntimeException e4) {
                                this.f8746i.a(this, e4);
                            }
                        } else {
                            throw new ch(1002, "non control or continious frame expected");
                        }
                        this.f8746i.a(this, e2);
                        a(e2);
                        return;
                    }
                    throw new ch(1002, "Continuous frame sequence not completed.");
                }
                if (f2 != cq.a.CONTINUOUS) {
                    if (this.n == null) {
                        this.n = cqVar;
                    } else {
                        throw new ch(1002, "Previous continuous frame sequence not completed.");
                    }
                } else if (d2) {
                    if (this.n != null) {
                        if (this.n.f() == cq.a.TEXT) {
                            int max = Math.max(this.n.c().limit() - 64, 0);
                            this.n.a(cqVar);
                            if (!dc.a(this.n.c(), max)) {
                                throw new ch(1007);
                            }
                        }
                        this.n = null;
                    } else {
                        throw new ch(1002, "Continuous frame sequence was not started.");
                    }
                } else if (this.n == null) {
                    throw new ch(1002, "Continuous frame sequence was not started.");
                }
                if (f2 == cq.a.TEXT && !dc.b(cqVar.c())) {
                    throw new ch(1007);
                }
                if (f2 == cq.a.CONTINUOUS && this.n != null && this.n.f() == cq.a.TEXT) {
                    int max2 = Math.max(this.n.c().limit() - 64, 0);
                    this.n.a(cqVar);
                    if (!dc.a(this.n.c(), max2)) {
                        throw new ch(1007);
                    }
                }
                try {
                    this.f8746i.a(this, cqVar);
                } catch (RuntimeException e5) {
                    this.f8746i.a(this, e5);
                }
            }
        }
    }

    private cd.b e(ByteBuffer byteBuffer) throws cg {
        byteBuffer.mark();
        if (byteBuffer.limit() > cd.f8759c.length) {
            return cd.b.NOT_MATCHED;
        }
        if (byteBuffer.limit() >= cd.f8759c.length) {
            int i2 = 0;
            while (byteBuffer.hasRemaining()) {
                if (cd.f8759c[i2] != byteBuffer.get()) {
                    byteBuffer.reset();
                    return cd.b.NOT_MATCHED;
                }
                i2++;
            }
            return cd.b.MATCHED;
        }
        throw new cg(cd.f8759c.length);
    }

    private void f(ByteBuffer byteBuffer) {
        if (f8740c) {
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("write(");
            sb.append(byteBuffer.remaining());
            sb.append("): {");
            sb.append(byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array()));
            sb.append("}");
            printStream.println(sb.toString());
        }
        this.f8742d.add(byteBuffer);
        this.f8746i.b(this);
    }

    public void a(ByteBuffer byteBuffer) {
        if (!f8741h && !byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
        if (f8740c) {
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("process(");
            sb.append(byteBuffer.remaining());
            sb.append("): {");
            sb.append(byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining()));
            sb.append("}");
            printStream.println(sb.toString());
        }
        if (this.k != by.a.NOT_YET_CONNECTED) {
            d(byteBuffer);
        } else if (c(byteBuffer)) {
            if (!f8741h && this.o.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (byteBuffer.hasRemaining()) {
                d(byteBuffer);
            } else if (this.o.hasRemaining()) {
                d(this.o);
            }
        }
        if (!f8741h && !d() && !e() && byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
    }

    public void b(int i2, String str) {
        a(i2, str, false);
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

    public synchronized void b(int i2, String str, boolean z) {
        if (this.j) {
            return;
        }
        this.r = Integer.valueOf(i2);
        this.q = str;
        this.s = Boolean.valueOf(z);
        this.j = true;
        this.f8746i.b(this);
        try {
            this.f8746i.b(this, i2, str, z);
        } catch (RuntimeException e2) {
            this.f8746i.a(this, e2);
        }
        if (this.l != null) {
            this.l.a();
        }
        this.p = null;
    }

    public boolean f() {
        return this.k == by.a.CLOSED;
    }

    public boolean e() {
        return this.j;
    }

    public void a(int i2, String str) {
        c(i2, str, false);
    }

    public synchronized void a(int i2, String str, boolean z) {
        if (this.k == by.a.CLOSED) {
            return;
        }
        if (this.f8744f != null) {
            this.f8744f.cancel();
        }
        if (this.f8745g != null) {
            try {
                this.f8745g.close();
            } catch (IOException e2) {
                this.f8746i.a(this, e2);
            }
        }
        try {
            this.f8746i.a(this, i2, str, z);
        } catch (RuntimeException e3) {
            this.f8746i.a(this, e3);
        }
        if (this.l != null) {
            this.l.a();
        }
        this.p = null;
        this.k = by.a.CLOSED;
        this.f8742d.clear();
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

    public void b(ByteBuffer byteBuffer) throws IllegalArgumentException, cm {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        a(this.l.a(byteBuffer, this.m == by.b.CLIENT));
    }

    public void a(int i2, boolean z) {
        a(i2, "", z);
    }

    public void a(int i2) {
        c(i2, "", false);
    }

    public void a(ch chVar) {
        c(chVar.a(), chVar.getMessage(), false);
    }

    public void a(byte[] bArr) throws IllegalArgumentException, cm {
        b(ByteBuffer.wrap(bArr));
    }

    private void a(Collection<cq> collection) {
        if (c()) {
            for (cq cqVar : collection) {
                a(cqVar);
            }
            return;
        }
        throw new cm();
    }

    @Override // com.baidu.mobstat.by
    public void a(cq cqVar) {
        if (f8740c) {
            PrintStream printStream = System.out;
            printStream.println("send frame: " + cqVar);
        }
        f(this.l.a(cqVar));
    }

    public void a(ct ctVar) throws cj {
        if (!f8741h && this.k == by.a.CONNECTING) {
            throw new AssertionError("shall only be called once");
        }
        this.p = this.l.a(ctVar);
        String a2 = ctVar.a();
        this.t = a2;
        if (!f8741h && a2 == null) {
            throw new AssertionError();
        }
        try {
            this.f8746i.a((by) this, this.p);
            a(this.l.a(this.p, this.m));
        } catch (ch unused) {
            throw new cj("Handshake data rejected by client.");
        } catch (RuntimeException e2) {
            this.f8746i.a(this, e2);
            throw new cj("rejected because of" + e2);
        }
    }

    private void c(int i2, String str, boolean z) {
        by.a aVar = this.k;
        if (aVar == by.a.CLOSING || aVar == by.a.CLOSED) {
            return;
        }
        if (aVar == by.a.OPEN) {
            if (i2 == 1006) {
                if (!f8741h && z) {
                    throw new AssertionError();
                }
                this.k = by.a.CLOSING;
                b(i2, str, false);
                return;
            }
            if (this.l.b() != cd.a.NONE) {
                try {
                    if (!z) {
                        try {
                            this.f8746i.a(this, i2, str);
                        } catch (RuntimeException e2) {
                            this.f8746i.a(this, e2);
                        }
                    }
                    a(new co(i2, str));
                } catch (ch e3) {
                    this.f8746i.a(this, e3);
                    b(1006, "generated frame is invalid", false);
                }
            }
            b(i2, str, z);
        } else if (i2 == -3) {
            if (!f8741h && !z) {
                throw new AssertionError();
            }
            b(-3, str, true);
        } else {
            b(-1, str, false);
        }
        if (i2 == 1002) {
            b(i2, str, z);
        }
        this.k = by.a.CLOSING;
        this.o = null;
    }

    private void a(List<ByteBuffer> list) {
        for (ByteBuffer byteBuffer : list) {
            f(byteBuffer);
        }
    }

    private void a(cx cxVar) {
        if (f8740c) {
            PrintStream printStream = System.out;
            printStream.println("open using draft: " + this.l.getClass().getSimpleName());
        }
        this.k = by.a.OPEN;
        try {
            this.f8746i.a(this, cxVar);
        } catch (RuntimeException e2) {
            this.f8746i.a(this, e2);
        }
    }

    @Override // com.baidu.mobstat.by
    public InetSocketAddress a() {
        return this.f8746i.c(this);
    }

    public boolean d() {
        return this.k == by.a.CLOSING;
    }

    public boolean c() {
        if (!f8741h && this.k == by.a.OPEN && this.j) {
            throw new AssertionError();
        }
        return this.k == by.a.OPEN;
    }
}
