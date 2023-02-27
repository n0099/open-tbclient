package com.baidu.mobstat;

import com.baidu.mobstat.ce;
import com.baidu.mobstat.cj;
import com.baidu.mobstat.cw;
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
public class cg implements ce {
    public static final List<cj> a;
    public static int b;
    public static boolean c;
    public static final /* synthetic */ boolean h = !cg.class.desiredAssertionStatus();
    public final BlockingQueue<ByteBuffer> d;
    public final BlockingQueue<ByteBuffer> e;
    public SelectionKey f;
    public ByteChannel g;
    public final ch i;
    public cj l;
    public ce.b m;
    public volatile boolean j = false;
    public ce.a k = ce.a.NOT_YET_CONNECTED;
    public cw n = null;
    public ByteBuffer o = ByteBuffer.allocate(0);
    public cy p = null;
    public String q = null;
    public Integer r = null;
    public Boolean s = null;
    public String t = null;

    static {
        ArrayList arrayList = new ArrayList(4);
        a = arrayList;
        b = 16384;
        c = false;
        arrayList.add(new cl());
        a.add(new ck());
    }

    @Override // com.baidu.mobstat.ce
    public InetSocketAddress a() {
        return this.i.c(this);
    }

    public boolean c() {
        if (!h && this.k == ce.a.OPEN && this.j) {
            throw new AssertionError();
        }
        if (this.k == ce.a.OPEN) {
            return true;
        }
        return false;
    }

    public boolean d() {
        if (this.k == ce.a.CLOSING) {
            return true;
        }
        return false;
    }

    public boolean e() {
        return this.j;
    }

    public boolean f() {
        if (this.k == ce.a.CLOSED) {
            return true;
        }
        return false;
    }

    public ce.a g() {
        return this.k;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    public cg(ch chVar, cj cjVar) {
        this.l = null;
        if (chVar != null && cjVar != null) {
            this.d = new LinkedBlockingQueue();
            this.e = new LinkedBlockingQueue();
            this.i = chVar;
            this.m = ce.b.CLIENT;
            if (cjVar != null) {
                this.l = cjVar.c();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("parameters must not be null");
    }

    private void a(dd ddVar) {
        if (c) {
            PrintStream printStream = System.out;
            printStream.println("open using draft: " + this.l.getClass().getSimpleName());
        }
        this.k = ce.a.OPEN;
        try {
            this.i.a(this, ddVar);
        } catch (RuntimeException e) {
            this.i.a(this, e);
        }
    }

    private cj.b e(ByteBuffer byteBuffer) throws cm {
        byteBuffer.mark();
        if (byteBuffer.limit() > cj.c.length) {
            return cj.b.NOT_MATCHED;
        }
        if (byteBuffer.limit() >= cj.c.length) {
            int i = 0;
            while (byteBuffer.hasRemaining()) {
                if (cj.c[i] != byteBuffer.get()) {
                    byteBuffer.reset();
                    return cj.b.NOT_MATCHED;
                }
                i++;
            }
            return cj.b.MATCHED;
        }
        throw new cm(cj.c.length);
    }

    private void a(Collection<cw> collection) {
        if (c()) {
            for (cw cwVar : collection) {
                a(cwVar);
            }
            return;
        }
        throw new cs();
    }

    public void b(ByteBuffer byteBuffer) throws IllegalArgumentException, cs {
        boolean z;
        if (byteBuffer != null) {
            cj cjVar = this.l;
            if (this.m == ce.b.CLIENT) {
                z = true;
            } else {
                z = false;
            }
            a(cjVar.a(byteBuffer, z));
            return;
        }
        throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
    }

    private void a(List<ByteBuffer> list) {
        for (ByteBuffer byteBuffer : list) {
            f(byteBuffer);
        }
    }

    private void c(int i, String str, boolean z) {
        ce.a aVar = this.k;
        if (aVar != ce.a.CLOSING && aVar != ce.a.CLOSED) {
            if (aVar == ce.a.OPEN) {
                if (i == 1006) {
                    if (!h && z) {
                        throw new AssertionError();
                    }
                    this.k = ce.a.CLOSING;
                    b(i, str, false);
                    return;
                }
                if (this.l.b() != cj.a.NONE) {
                    try {
                        if (!z) {
                            try {
                                this.i.a(this, i, str);
                            } catch (RuntimeException e) {
                                this.i.a(this, e);
                            }
                        }
                        a(new cu(i, str));
                    } catch (cn e2) {
                        this.i.a(this, e2);
                        b(1006, "generated frame is invalid", false);
                    }
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
            this.k = ce.a.CLOSING;
            this.o = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x011d  */
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
        } catch (cm e) {
            if (this.o.capacity() != 0) {
            }
        }
        if (this.l == null && e(byteBuffer2) == cj.b.MATCHED) {
            try {
                f(ByteBuffer.wrap(di.a(this.i.a(this))));
                a(-3, "");
            } catch (cn unused) {
                c(1006, "remote peer closed connection before flashpolicy could be transmitted", true);
            }
            return false;
        }
        try {
            if (this.m == ce.b.CLIENT) {
                this.l.a(this.m);
                dd d = this.l.d(byteBuffer2);
                if (!(d instanceof df)) {
                    b(1002, "wrong http function", false);
                    return false;
                }
                df dfVar = (df) d;
                if (this.l.a(this.p, dfVar) == cj.b.MATCHED) {
                    try {
                        this.i.a(this, this.p, dfVar);
                        a(dfVar);
                        return true;
                    } catch (cn e2) {
                        b(e2.a(), e2.getMessage(), false);
                        return false;
                    } catch (RuntimeException e3) {
                        this.i.a(this, e3);
                        b(-1, e3.getMessage(), false);
                        return false;
                    }
                }
                a(1002, "draft " + this.l + " refuses handshake");
            }
        } catch (cp e4) {
            a(e4);
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
        } catch (cn e) {
            this.i.a(this, e);
            a(e);
            return;
        }
        for (cw cwVar : this.l.c(byteBuffer)) {
            if (c) {
                PrintStream printStream = System.out;
                printStream.println("matched frame: " + cwVar);
            }
            cw.a f = cwVar.f();
            boolean d = cwVar.d();
            if (this.k == ce.a.CLOSING) {
                return;
            }
            if (f == cw.a.CLOSING) {
                int i = 1005;
                String str = "";
                if (cwVar instanceof ct) {
                    ct ctVar = (ct) cwVar;
                    i = ctVar.a();
                    str = ctVar.b();
                }
                if (this.k == ce.a.CLOSING) {
                    a(i, str, true);
                } else if (this.l.b() == cj.a.TWOWAY) {
                    c(i, str, true);
                } else {
                    b(i, str, false);
                }
            } else if (f == cw.a.PING) {
                this.i.b(this, cwVar);
            } else if (f == cw.a.PONG) {
                this.i.c(this, cwVar);
            } else {
                if (d && f != cw.a.CONTINUOUS) {
                    if (this.n == null) {
                        if (f == cw.a.TEXT) {
                            try {
                                this.i.a(this, di.a(cwVar.c()));
                            } catch (RuntimeException e2) {
                                this.i.a(this, e2);
                            }
                        } else if (f == cw.a.BINARY) {
                            try {
                                this.i.a(this, cwVar.c());
                            } catch (RuntimeException e3) {
                                this.i.a(this, e3);
                            }
                        } else {
                            throw new cn(1002, "non control or continious frame expected");
                        }
                        this.i.a(this, e);
                        a(e);
                        return;
                    }
                    throw new cn(1002, "Continuous frame sequence not completed.");
                }
                if (f != cw.a.CONTINUOUS) {
                    if (this.n == null) {
                        this.n = cwVar;
                    } else {
                        throw new cn(1002, "Previous continuous frame sequence not completed.");
                    }
                } else if (d) {
                    if (this.n != null) {
                        if (this.n.f() == cw.a.TEXT) {
                            int max = Math.max(this.n.c().limit() - 64, 0);
                            this.n.a(cwVar);
                            if (!di.a(this.n.c(), max)) {
                                throw new cn(1007);
                            }
                        }
                        this.n = null;
                    } else {
                        throw new cn(1002, "Continuous frame sequence was not started.");
                    }
                } else if (this.n == null) {
                    throw new cn(1002, "Continuous frame sequence was not started.");
                }
                if (f == cw.a.TEXT && !di.b(cwVar.c())) {
                    throw new cn(1007);
                }
                if (f == cw.a.CONTINUOUS && this.n != null && this.n.f() == cw.a.TEXT) {
                    int max2 = Math.max(this.n.c().limit() - 64, 0);
                    this.n.a(cwVar);
                    if (!di.a(this.n.c(), max2)) {
                        throw new cn(1007);
                    }
                }
                try {
                    this.i.a(this, cwVar);
                } catch (RuntimeException e4) {
                    this.i.a(this, e4);
                }
            }
        }
    }

    private void f(ByteBuffer byteBuffer) {
        String str;
        if (c) {
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("write(");
            sb.append(byteBuffer.remaining());
            sb.append("): {");
            if (byteBuffer.remaining() > 1000) {
                str = "too big to display";
            } else {
                str = new String(byteBuffer.array());
            }
            sb.append(str);
            sb.append("}");
            printStream.println(sb.toString());
        }
        this.d.add(byteBuffer);
        this.i.b(this);
    }

    public void a(int i) {
        c(i, "", false);
    }

    public void a(int i, String str) {
        c(i, str, false);
    }

    public void b(int i, String str) {
        a(i, str, false);
    }

    public synchronized void a(int i, String str, boolean z) {
        if (this.k == ce.a.CLOSED) {
            return;
        }
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
        this.k = ce.a.CLOSED;
        this.d.clear();
    }

    public void a(int i, boolean z) {
        a(i, "", z);
    }

    public void a(cn cnVar) {
        c(cnVar.a(), cnVar.getMessage(), false);
    }

    @Override // com.baidu.mobstat.ce
    public void a(cw cwVar) {
        if (c) {
            PrintStream printStream = System.out;
            printStream.println("send frame: " + cwVar);
        }
        f(this.l.a(cwVar));
    }

    public void a(cz czVar) throws cp {
        if (!h && this.k == ce.a.CONNECTING) {
            throw new AssertionError("shall only be called once");
        }
        this.p = this.l.a(czVar);
        String a2 = czVar.a();
        this.t = a2;
        if (!h && a2 == null) {
            throw new AssertionError();
        }
        try {
            this.i.a((ce) this, this.p);
            a(this.l.a(this.p, this.m));
        } catch (cn unused) {
            throw new cp("Handshake data rejected by client.");
        } catch (RuntimeException e) {
            this.i.a(this, e);
            throw new cp("rejected because of" + e);
        }
    }

    public void a(ByteBuffer byteBuffer) {
        String str;
        if (!h && !byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
        if (c) {
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("process(");
            sb.append(byteBuffer.remaining());
            sb.append("): {");
            if (byteBuffer.remaining() > 1000) {
                str = "too big to display";
            } else {
                str = new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining());
            }
            sb.append(str);
            sb.append("}");
            printStream.println(sb.toString());
        }
        if (this.k != ce.a.NOT_YET_CONNECTED) {
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

    public void a(byte[] bArr) throws IllegalArgumentException, cs {
        b(ByteBuffer.wrap(bArr));
    }

    public void b() {
        if (g() == ce.a.NOT_YET_CONNECTED) {
            a(-1, true);
        } else if (this.j) {
            a(this.r.intValue(), this.q, this.s.booleanValue());
        } else if (this.l.b() == cj.a.NONE) {
            a(1000, true);
        } else if (this.l.b() == cj.a.ONEWAY) {
            a(1000, true);
        } else {
            a(1006, true);
        }
    }

    public synchronized void b(int i, String str, boolean z) {
        if (this.j) {
            return;
        }
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
