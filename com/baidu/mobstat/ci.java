package com.baidu.mobstat;

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
/* loaded from: classes3.dex */
public abstract class ci extends cf implements ce, Runnable {
    public static final /* synthetic */ boolean c = !ci.class.desiredAssertionStatus();
    public cg a;
    public URI b;
    public InputStream e;
    public OutputStream f;
    public Thread h;
    public cj i;
    public Map<String, String> j;
    public int m;
    public Socket d = null;
    public Proxy g = Proxy.NO_PROXY;
    public CountDownLatch k = new CountDownLatch(1);
    public CountDownLatch l = new CountDownLatch(1);

    public void a(int i, String str) {
    }

    public abstract void a(int i, String str, boolean z);

    public abstract void a(df dfVar);

    public abstract void a(Exception exc);

    public abstract void a(String str);

    public void a(ByteBuffer byteBuffer) {
    }

    public void b(int i, String str, boolean z) {
    }

    @Override // com.baidu.mobstat.ch
    public final void b(ce ceVar) {
    }

    public void b(cw cwVar) {
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setName("WebsocketWriteThread");
            while (!Thread.interrupted()) {
                try {
                    ByteBuffer take = ci.this.a.d.take();
                    ci.this.f.write(take.array(), 0, take.limit());
                    ci.this.f.flush();
                } catch (IOException unused) {
                    ci.this.a.b();
                    return;
                } catch (InterruptedException unused2) {
                    return;
                }
            }
        }
    }

    @Override // com.baidu.mobstat.ce
    public InetSocketAddress a() {
        return this.a.a();
    }

    public void b() {
        if (this.h == null) {
            Thread thread = new Thread(this);
            this.h = thread;
            thread.start();
            return;
        }
        throw new IllegalStateException("WebSocketClient objects are not reuseable");
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

    public boolean e() {
        return this.a.e();
    }

    public boolean f() {
        return this.a.f();
    }

    public boolean g() {
        return this.a.d();
    }

    public ci(URI uri, cj cjVar, Map<String, String> map, int i) {
        this.b = null;
        this.a = null;
        this.m = 0;
        if (uri != null) {
            if (cjVar != null) {
                this.b = uri;
                this.i = cjVar;
                this.j = map;
                this.m = i;
                this.a = new cg(this, cjVar);
                return;
            }
            throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
        }
        throw new IllegalArgumentException();
    }

    @Override // com.baidu.mobstat.ch
    public InetSocketAddress c(ce ceVar) {
        Socket socket = this.d;
        if (socket != null) {
            return (InetSocketAddress) socket.getLocalSocketAddress();
        }
        return null;
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
        String str;
        String rawPath = this.b.getRawPath();
        String rawQuery = this.b.getRawQuery();
        rawPath = (rawPath == null || rawPath.length() == 0) ? "/" : "/";
        if (rawQuery != null) {
            rawPath = rawPath + "?" + rawQuery;
        }
        int h = h();
        StringBuilder sb = new StringBuilder();
        sb.append(this.b.getHost());
        if (h != 80) {
            str = ":" + h;
        } else {
            str = "";
        }
        sb.append(str);
        String sb2 = sb.toString();
        db dbVar = new db();
        dbVar.a(rawPath);
        dbVar.a("Host", sb2);
        Map<String, String> map = this.j;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                dbVar.a(entry.getKey(), entry.getValue());
            }
        }
        this.a.a((cz) dbVar);
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
            Thread thread = new Thread(new a());
            this.h = thread;
            thread.start();
            byte[] bArr = new byte[cg.b];
            while (!g() && !f() && (read = this.e.read(bArr)) != -1) {
                try {
                    this.a.a(ByteBuffer.wrap(bArr, 0, read));
                } catch (IOException unused) {
                    this.a.b();
                } catch (RuntimeException e) {
                    a(e);
                    this.a.b(1006, e.getMessage());
                }
            }
            this.a.b();
            if (!c && !this.d.isClosed()) {
                throw new AssertionError();
            }
        } catch (Exception e2) {
            a(this.a, e2);
            this.a.b(-1, e2.getMessage());
        }
    }

    @Override // com.baidu.mobstat.ch
    public void a(ce ceVar, int i, String str) {
        a(i, str);
    }

    @Override // com.baidu.mobstat.ch
    public final void a(ce ceVar, int i, String str, boolean z) {
        Thread thread = this.h;
        if (thread != null) {
            thread.interrupt();
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
    public void b(ce ceVar, int i, String str, boolean z) {
        b(i, str, z);
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
    public final void a(ce ceVar, Exception exc) {
        a(exc);
    }

    @Override // com.baidu.mobstat.ch
    public final void a(ce ceVar, String str) {
        a(str);
    }

    @Override // com.baidu.mobstat.ch
    public final void a(ce ceVar, ByteBuffer byteBuffer) {
        a(byteBuffer);
    }

    @Override // com.baidu.mobstat.ce
    public void a(cw cwVar) {
        this.a.a(cwVar);
    }

    public void a(Socket socket) {
        if (this.d == null) {
            this.d = socket;
            return;
        }
        throw new IllegalStateException("socket has already been set");
    }

    public void a(byte[] bArr) throws NotYetConnectedException {
        this.a.a(bArr);
    }
}
