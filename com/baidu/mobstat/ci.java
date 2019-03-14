package com.baidu.mobstat;

import android.support.v4.view.PointerIconCompat;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.NotYetConnectedException;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public abstract class ci extends cf implements ce, Runnable {
    static final /* synthetic */ boolean c;
    private cg a;
    protected URI b;
    private InputStream e;
    private OutputStream f;
    private Thread h;
    private cj i;
    private Map<String, String> j;
    private int m;
    private Socket d = null;
    private Proxy g = Proxy.NO_PROXY;
    private CountDownLatch k = new CountDownLatch(1);
    private CountDownLatch l = new CountDownLatch(1);

    public abstract void a(int i, String str, boolean z);

    public abstract void a(df dfVar);

    public abstract void a(Exception exc);

    public abstract void a(String str);

    static {
        c = !ci.class.desiredAssertionStatus();
    }

    public ci(URI uri, cj cjVar, Map<String, String> map, int i) {
        this.b = null;
        this.a = null;
        this.m = 0;
        if (uri == null) {
            throw new IllegalArgumentException();
        }
        if (cjVar == null) {
            throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
        }
        this.b = uri;
        this.i = cjVar;
        this.j = map;
        this.m = i;
        this.a = new cg(this, cjVar);
    }

    public void b() {
        if (this.h != null) {
            throw new IllegalStateException("WebSocketClient objects are not reuseable");
        }
        this.h = new Thread(this);
        this.h.start();
    }

    public boolean c() throws InterruptedException {
        b();
        this.k.await();
        return this.a.c();
    }

    public void d() {
        if (this.h != null) {
            this.a.a(1000);
        }
    }

    public void a(byte[] bArr) throws NotYetConnectedException {
        this.a.a(bArr);
    }

    @Override // java.lang.Runnable
    public void run() {
        int read;
        try {
            if (this.d == null) {
                this.d = new Socket(this.g);
            } else if (this.d.isClosed()) {
                throw new IOException();
            }
            if (!this.d.isBound()) {
                this.d.connect(new InetSocketAddress(this.b.getHost(), h()), this.m);
            }
            this.e = this.d.getInputStream();
            this.f = this.d.getOutputStream();
            i();
            this.h = new Thread(new a());
            this.h.start();
            byte[] bArr = new byte[cg.b];
            while (!g() && !f() && (read = this.e.read(bArr)) != -1) {
                try {
                    this.a.a(ByteBuffer.wrap(bArr, 0, read));
                } catch (IOException e) {
                    this.a.b();
                } catch (RuntimeException e2) {
                    a(e2);
                    this.a.b(PointerIconCompat.TYPE_CELL, e2.getMessage());
                }
            }
            this.a.b();
            if (!c && !this.d.isClosed()) {
                throw new AssertionError();
            }
        } catch (Exception e3) {
            a(this.a, e3);
            this.a.b(-1, e3.getMessage());
        }
    }

    private int h() {
        int port = this.b.getPort();
        if (port == -1) {
            String scheme = this.b.getScheme();
            if (scheme.equals("wss")) {
                return 443;
            }
            if (scheme.equals("ws")) {
                return 80;
            }
            throw new RuntimeException("unknown scheme: " + scheme);
        }
        return port;
    }

    private void i() throws cp {
        int h;
        String rawPath = this.b.getRawPath();
        String rawQuery = this.b.getRawQuery();
        rawPath = (rawPath == null || rawPath.length() == 0) ? "/" : "/";
        if (rawQuery != null) {
            rawPath = rawPath + "?" + rawQuery;
        }
        db dbVar = new db();
        dbVar.a(rawPath);
        dbVar.a(HTTP.TARGET_HOST, this.b.getHost() + (h() != 80 ? Config.TRACE_TODAY_VISIT_SPLIT + h : ""));
        if (this.j != null) {
            for (Map.Entry<String, String> entry : this.j.entrySet()) {
                dbVar.a(entry.getKey(), entry.getValue());
            }
        }
        this.a.a((cz) dbVar);
    }

    @Override // com.baidu.mobstat.ch
    public final void a(ce ceVar, String str) {
        a(str);
    }

    @Override // com.baidu.mobstat.ch
    public final void a(ce ceVar, ByteBuffer byteBuffer) {
        a(byteBuffer);
    }

    @Override // com.baidu.mobstat.cf, com.baidu.mobstat.ch
    public void a(ce ceVar, cw cwVar) {
        b(cwVar);
    }

    @Override // com.baidu.mobstat.ch
    public final void a(ce ceVar, dd ddVar) {
        a((df) ddVar);
        this.k.countDown();
    }

    @Override // com.baidu.mobstat.ch
    public final void a(ce ceVar, int i, String str, boolean z) {
        if (this.h != null) {
            this.h.interrupt();
        }
        try {
            if (this.d != null) {
                this.d.close();
            }
        } catch (IOException e) {
            a(this, e);
        }
        a(i, str, z);
        this.k.countDown();
        this.l.countDown();
    }

    @Override // com.baidu.mobstat.ch
    public final void a(ce ceVar, Exception exc) {
        a(exc);
    }

    @Override // com.baidu.mobstat.ch
    public final void b(ce ceVar) {
    }

    @Override // com.baidu.mobstat.ch
    public void a(ce ceVar, int i, String str) {
        a(i, str);
    }

    @Override // com.baidu.mobstat.ch
    public void b(ce ceVar, int i, String str, boolean z) {
        b(i, str, z);
    }

    public void a(int i, String str) {
    }

    public void b(int i, String str, boolean z) {
    }

    @Override // com.baidu.mobstat.ch
    public InetSocketAddress c(ce ceVar) {
        if (this.d != null) {
            return (InetSocketAddress) this.d.getLocalSocketAddress();
        }
        return null;
    }

    public void a(ByteBuffer byteBuffer) {
    }

    public void b(cw cwVar) {
    }

    /* loaded from: classes6.dex */
    class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setName("WebsocketWriteThread");
            while (!Thread.interrupted()) {
                try {
                    ByteBuffer take = ci.this.a.d.take();
                    ci.this.f.write(take.array(), 0, take.limit());
                    ci.this.f.flush();
                } catch (IOException e) {
                    ci.this.a.b();
                    return;
                } catch (InterruptedException e2) {
                    return;
                }
            }
        }
    }

    public void a(Socket socket) {
        if (this.d != null) {
            throw new IllegalStateException("socket has already been set");
        }
        this.d = socket;
    }

    public boolean e() {
        return this.a.e();
    }

    public boolean f() {
        return this.a.f();
    }

    public boolean g() {
        return this.a.d();
    }

    @Override // com.baidu.mobstat.ce
    public void a(cw cwVar) {
        this.a.a(cwVar);
    }

    @Override // com.baidu.mobstat.ce
    public InetSocketAddress a() {
        return this.a.a();
    }
}
