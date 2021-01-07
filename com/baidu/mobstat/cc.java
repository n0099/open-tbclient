package com.baidu.mobstat;

import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes15.dex */
public abstract class cc extends bz implements by, Runnable {
    static final /* synthetic */ boolean c;

    /* renamed from: a  reason: collision with root package name */
    private ca f3820a;

    /* renamed from: b  reason: collision with root package name */
    protected URI f3821b;
    private InputStream e;
    private OutputStream f;
    private Thread h;
    private cd i;
    private Map<String, String> j;
    private int m;
    private Socket d = null;
    private Proxy g = Proxy.NO_PROXY;
    private CountDownLatch k = new CountDownLatch(1);
    private CountDownLatch l = new CountDownLatch(1);

    public abstract void a(int i, String str, boolean z);

    public abstract void a(cz czVar);

    public abstract void a(Exception exc);

    public abstract void a(String str);

    static {
        c = !cc.class.desiredAssertionStatus();
    }

    public cc(URI uri, cd cdVar, Map<String, String> map, int i) {
        this.f3821b = null;
        this.f3820a = null;
        this.m = 0;
        if (uri == null) {
            throw new IllegalArgumentException();
        }
        if (cdVar == null) {
            throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
        }
        this.f3821b = uri;
        this.i = cdVar;
        this.j = map;
        this.m = i;
        this.f3820a = new ca(this, cdVar);
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
        return this.f3820a.c();
    }

    public void d() {
        if (this.h != null) {
            this.f3820a.a(1000);
        }
    }

    public void a(byte[] bArr) throws NotYetConnectedException {
        this.f3820a.a(bArr);
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
                this.d.connect(new InetSocketAddress(this.f3821b.getHost(), h()), this.m);
            }
            this.e = this.d.getInputStream();
            this.f = this.d.getOutputStream();
            i();
            this.h = new Thread(new a());
            this.h.start();
            byte[] bArr = new byte[ca.f3819b];
            while (!g() && !f() && (read = this.e.read(bArr)) != -1) {
                try {
                    this.f3820a.a(ByteBuffer.wrap(bArr, 0, read));
                } catch (IOException e) {
                    this.f3820a.b();
                } catch (RuntimeException e2) {
                    a(e2);
                    this.f3820a.b(1006, e2.getMessage());
                }
            }
            this.f3820a.b();
            if (!c && !this.d.isClosed()) {
                throw new AssertionError();
            }
        } catch (Exception e3) {
            a(this.f3820a, e3);
            this.f3820a.b(-1, e3.getMessage());
        }
    }

    private int h() {
        int port = this.f3821b.getPort();
        if (port == -1) {
            String scheme = this.f3821b.getScheme();
            if (scheme.equals("wss")) {
                return Constants.SOCKET_PORT_SSL;
            }
            if (scheme.equals("ws")) {
                return 80;
            }
            throw new RuntimeException("unknown scheme: " + scheme);
        }
        return port;
    }

    private void i() throws cj {
        int h;
        String rawPath = this.f3821b.getRawPath();
        String rawQuery = this.f3821b.getRawQuery();
        rawPath = (rawPath == null || rawPath.length() == 0) ? "/" : "/";
        if (rawQuery != null) {
            rawPath = rawPath + "?" + rawQuery;
        }
        cv cvVar = new cv();
        cvVar.a(rawPath);
        cvVar.a("Host", this.f3821b.getHost() + (h() != 80 ? ":" + h : ""));
        if (this.j != null) {
            for (Map.Entry<String, String> entry : this.j.entrySet()) {
                cvVar.a(entry.getKey(), entry.getValue());
            }
        }
        this.f3820a.a((ct) cvVar);
    }

    @Override // com.baidu.mobstat.cb
    public final void a(by byVar, String str) {
        a(str);
    }

    @Override // com.baidu.mobstat.cb
    public final void a(by byVar, ByteBuffer byteBuffer) {
        a(byteBuffer);
    }

    @Override // com.baidu.mobstat.bz, com.baidu.mobstat.cb
    public void a(by byVar, cq cqVar) {
        b(cqVar);
    }

    @Override // com.baidu.mobstat.cb
    public final void a(by byVar, cx cxVar) {
        a((cz) cxVar);
        this.k.countDown();
    }

    @Override // com.baidu.mobstat.cb
    public final void a(by byVar, int i, String str, boolean z) {
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

    @Override // com.baidu.mobstat.cb
    public final void a(by byVar, Exception exc) {
        a(exc);
    }

    @Override // com.baidu.mobstat.cb
    public final void b(by byVar) {
    }

    @Override // com.baidu.mobstat.cb
    public void a(by byVar, int i, String str) {
        a(i, str);
    }

    @Override // com.baidu.mobstat.cb
    public void b(by byVar, int i, String str, boolean z) {
        b(i, str, z);
    }

    public void a(int i, String str) {
    }

    public void b(int i, String str, boolean z) {
    }

    @Override // com.baidu.mobstat.cb
    public InetSocketAddress c(by byVar) {
        if (this.d != null) {
            return (InetSocketAddress) this.d.getLocalSocketAddress();
        }
        return null;
    }

    public void a(ByteBuffer byteBuffer) {
    }

    public void b(cq cqVar) {
    }

    /* loaded from: classes15.dex */
    class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setName("WebsocketWriteThread");
            while (!Thread.interrupted()) {
                try {
                    ByteBuffer take = cc.this.f3820a.d.take();
                    cc.this.f.write(take.array(), 0, take.limit());
                    cc.this.f.flush();
                } catch (IOException e) {
                    cc.this.f3820a.b();
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
        return this.f3820a.e();
    }

    public boolean f() {
        return this.f3820a.f();
    }

    public boolean g() {
        return this.f3820a.d();
    }

    @Override // com.baidu.mobstat.by
    public void a(cq cqVar) {
        this.f3820a.a(cqVar);
    }

    @Override // com.baidu.mobstat.by
    public InetSocketAddress a() {
        return this.f3820a.a();
    }
}
