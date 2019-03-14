package com.baidu.mobstat;

import android.support.v4.view.PointerIconCompat;
import com.baidu.mobstat.ce;
import com.baidu.mobstat.cj;
import com.baidu.mobstat.cw;
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
/* loaded from: classes6.dex */
public class cg implements ce {
    public static final List<cj> a;
    public static int b;
    public static boolean c;
    static final /* synthetic */ boolean h;
    public final BlockingQueue<ByteBuffer> d;
    public final BlockingQueue<ByteBuffer> e;
    public SelectionKey f;
    public ByteChannel g;
    private final ch i;
    private cj l;
    private ce.b m;
    private volatile boolean j = false;
    private ce.a k = ce.a.NOT_YET_CONNECTED;
    private cw n = null;
    private ByteBuffer o = ByteBuffer.allocate(0);
    private cy p = null;
    private String q = null;
    private Integer r = null;
    private Boolean s = null;
    private String t = null;

    static {
        h = !cg.class.desiredAssertionStatus();
        a = new ArrayList(4);
        b = 16384;
        c = false;
        a.add(new cl());
        a.add(new ck());
    }

    public cg(ch chVar, cj cjVar) {
        this.l = null;
        if (chVar == null || cjVar == null) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.d = new LinkedBlockingQueue();
        this.e = new LinkedBlockingQueue();
        this.i = chVar;
        this.m = ce.b.CLIENT;
        if (cjVar != null) {
            this.l = cjVar.c();
        }
    }

    public void a(ByteBuffer byteBuffer) {
        if (!h && !byteBuffer.hasRemaining()) {
            throw new AssertionError();
        }
        if (c) {
            System.out.println("process(" + byteBuffer.remaining() + "): {" + (byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining())) + "}");
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
        } catch (cm e) {
            if (this.o.capacity() != 0) {
            }
        }
        if (this.l == null && e(byteBuffer2) == cj.b.MATCHED) {
            try {
                f(ByteBuffer.wrap(di.a(this.i.a(this))));
                a(-3, "");
            } catch (cn e2) {
                c(PointerIconCompat.TYPE_CELL, "remote peer closed connection before flashpolicy could be transmitted", true);
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
                    } catch (cn e3) {
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
        } catch (cp e5) {
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
        int i;
        try {
        } catch (cn e) {
            this.i.a(this, e);
            a(e);
            return;
        }
        for (cw cwVar : this.l.c(byteBuffer)) {
            if (c) {
                System.out.println("matched frame: " + cwVar);
            }
            cw.a f = cwVar.f();
            boolean d = cwVar.d();
            if (this.k != ce.a.CLOSING) {
                if (f == cw.a.CLOSING) {
                    if (!(cwVar instanceof ct)) {
                        str = "";
                        i = 1005;
                    } else {
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
                    if (!d || f == cw.a.CONTINUOUS) {
                        if (f != cw.a.CONTINUOUS) {
                            if (this.n != null) {
                                throw new cn(1002, "Previous continuous frame sequence not completed.");
                            }
                            this.n = cwVar;
                        } else if (d) {
                            if (this.n == null) {
                                throw new cn(1002, "Continuous frame sequence was not started.");
                            }
                            if (this.n.f() == cw.a.TEXT) {
                                int max = Math.max(this.n.c().limit() - 64, 0);
                                this.n.a(cwVar);
                                if (!di.a(this.n.c(), max)) {
                                    throw new cn(PointerIconCompat.TYPE_CROSSHAIR);
                                }
                            }
                            this.n = null;
                        } else if (this.n == null) {
                            throw new cn(1002, "Continuous frame sequence was not started.");
                        }
                        if (f == cw.a.TEXT && !di.b(cwVar.c())) {
                            throw new cn(PointerIconCompat.TYPE_CROSSHAIR);
                        }
                        if (f == cw.a.CONTINUOUS && this.n != null && this.n.f() == cw.a.TEXT) {
                            int max2 = Math.max(this.n.c().limit() - 64, 0);
                            this.n.a(cwVar);
                            if (!di.a(this.n.c(), max2)) {
                                throw new cn(PointerIconCompat.TYPE_CROSSHAIR);
                            }
                        }
                        try {
                            this.i.a(this, cwVar);
                        } catch (RuntimeException e2) {
                            this.i.a(this, e2);
                        }
                    } else if (this.n != null) {
                        throw new cn(1002, "Continuous frame sequence not completed.");
                    } else {
                        if (f == cw.a.TEXT) {
                            try {
                                this.i.a(this, di.a(cwVar.c()));
                            } catch (RuntimeException e3) {
                                this.i.a(this, e3);
                            }
                        } else if (f == cw.a.BINARY) {
                            try {
                                this.i.a(this, cwVar.c());
                            } catch (RuntimeException e4) {
                                this.i.a(this, e4);
                            }
                        } else {
                            throw new cn(1002, "non control or continious frame expected");
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
        if (this.k != ce.a.CLOSING && this.k != ce.a.CLOSED) {
            if (this.k == ce.a.OPEN) {
                if (i == 1006) {
                    if (!h && z) {
                        throw new AssertionError();
                    }
                    this.k = ce.a.CLOSING;
                    b(i, str, false);
                    return;
                }
                if (this.l.b() != cj.a.NONE) {
                    if (!z) {
                        try {
                            try {
                                this.i.a(this, i, str);
                            } catch (RuntimeException e) {
                                this.i.a(this, e);
                            }
                        } catch (cn e2) {
                            this.i.a(this, e2);
                            b(PointerIconCompat.TYPE_CELL, "generated frame is invalid", false);
                        }
                    }
                    a(new cu(i, str));
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

    public void a(int i, String str) {
        c(i, str, false);
    }

    protected synchronized void a(int i, String str, boolean z) {
        if (this.k != ce.a.CLOSED) {
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
        if (g() == ce.a.NOT_YET_CONNECTED) {
            a(-1, true);
        } else if (this.j) {
            a(this.r.intValue(), this.q, this.s.booleanValue());
        } else if (this.l.b() == cj.a.NONE) {
            a(1000, true);
        } else if (this.l.b() == cj.a.ONEWAY) {
            a(1000, true);
        } else {
            a(PointerIconCompat.TYPE_CELL, true);
        }
    }

    public void a(int i) {
        c(i, "", false);
    }

    public void a(cn cnVar) {
        c(cnVar.a(), cnVar.getMessage(), false);
    }

    public void b(ByteBuffer byteBuffer) throws IllegalArgumentException, cs {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        a(this.l.a(byteBuffer, this.m == ce.b.CLIENT));
    }

    public void a(byte[] bArr) throws IllegalArgumentException, cs {
        b(ByteBuffer.wrap(bArr));
    }

    private void a(Collection<cw> collection) {
        if (!c()) {
            throw new cs();
        }
        for (cw cwVar : collection) {
            a(cwVar);
        }
    }

    @Override // com.baidu.mobstat.ce
    public void a(cw cwVar) {
        if (c) {
            System.out.println("send frame: " + cwVar);
        }
        f(this.l.a(cwVar));
    }

    private cj.b e(ByteBuffer byteBuffer) throws cm {
        byteBuffer.mark();
        if (byteBuffer.limit() > cj.c.length) {
            return cj.b.NOT_MATCHED;
        }
        if (byteBuffer.limit() < cj.c.length) {
            throw new cm(cj.c.length);
        }
        int i = 0;
        while (byteBuffer.hasRemaining()) {
            if (cj.c[i] == byteBuffer.get()) {
                i++;
            } else {
                byteBuffer.reset();
                return cj.b.NOT_MATCHED;
            }
        }
        return cj.b.MATCHED;
    }

    public void a(cz czVar) throws cp {
        if (!h && this.k == ce.a.CONNECTING) {
            throw new AssertionError("shall only be called once");
        }
        this.p = this.l.a(czVar);
        this.t = czVar.a();
        if (!h && this.t == null) {
            throw new AssertionError();
        }
        try {
            this.i.a((ce) this, this.p);
            a(this.l.a(this.p, this.m));
        } catch (cn e) {
            throw new cp("Handshake data rejected by client.");
        } catch (RuntimeException e2) {
            this.i.a(this, e2);
            throw new cp("rejected because of" + e2);
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

    private void a(dd ddVar) {
        if (c) {
            System.out.println("open using draft: " + this.l.getClass().getSimpleName());
        }
        this.k = ce.a.OPEN;
        try {
            this.i.a(this, ddVar);
        } catch (RuntimeException e) {
            this.i.a(this, e);
        }
    }

    public boolean c() {
        if (!h && this.k == ce.a.OPEN && this.j) {
            throw new AssertionError();
        }
        return this.k == ce.a.OPEN;
    }

    public boolean d() {
        return this.k == ce.a.CLOSING;
    }

    public boolean e() {
        return this.j;
    }

    public boolean f() {
        return this.k == ce.a.CLOSED;
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

    @Override // com.baidu.mobstat.ce
    public InetSocketAddress a() {
        return this.i.c(this);
    }
}
