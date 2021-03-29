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
/* loaded from: classes2.dex */
public abstract class cc extends bz implements by, Runnable {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ boolean f9149c = !cc.class.desiredAssertionStatus();

    /* renamed from: a  reason: collision with root package name */
    public ca f9150a;

    /* renamed from: b  reason: collision with root package name */
    public URI f9151b;

    /* renamed from: e  reason: collision with root package name */
    public InputStream f9153e;

    /* renamed from: f  reason: collision with root package name */
    public OutputStream f9154f;

    /* renamed from: h  reason: collision with root package name */
    public Thread f9156h;
    public cd i;
    public Map<String, String> j;
    public int m;

    /* renamed from: d  reason: collision with root package name */
    public Socket f9152d = null;

    /* renamed from: g  reason: collision with root package name */
    public Proxy f9155g = Proxy.NO_PROXY;
    public CountDownLatch k = new CountDownLatch(1);
    public CountDownLatch l = new CountDownLatch(1);

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setName("WebsocketWriteThread");
            while (!Thread.interrupted()) {
                try {
                    ByteBuffer take = cc.this.f9150a.f9145d.take();
                    cc.this.f9154f.write(take.array(), 0, take.limit());
                    cc.this.f9154f.flush();
                } catch (IOException unused) {
                    cc.this.f9150a.b();
                    return;
                } catch (InterruptedException unused2) {
                    return;
                }
            }
        }
    }

    public cc(URI uri, cd cdVar, Map<String, String> map, int i) {
        this.f9151b = null;
        this.f9150a = null;
        this.m = 0;
        if (uri == null) {
            throw new IllegalArgumentException();
        }
        if (cdVar != null) {
            this.f9151b = uri;
            this.i = cdVar;
            this.j = map;
            this.m = i;
            this.f9150a = new ca(this, cdVar);
            return;
        }
        throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
    }

    private int h() {
        int port = this.f9151b.getPort();
        if (port == -1) {
            String scheme = this.f9151b.getScheme();
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
        String rawPath = this.f9151b.getRawPath();
        String rawQuery = this.f9151b.getRawQuery();
        rawPath = (rawPath == null || rawPath.length() == 0) ? "/" : "/";
        if (rawQuery != null) {
            rawPath = rawPath + "?" + rawQuery;
        }
        int h2 = h();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f9151b.getHost());
        sb.append(h2 != 80 ? ":" + h2 : "");
        String sb2 = sb.toString();
        cv cvVar = new cv();
        cvVar.a(rawPath);
        cvVar.a("Host", sb2);
        Map<String, String> map = this.j;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                cvVar.a(entry.getKey(), entry.getValue());
            }
        }
        this.f9150a.a((ct) cvVar);
    }

    public void a(int i, String str) {
    }

    public abstract void a(int i, String str, boolean z);

    public abstract void a(cz czVar);

    public abstract void a(Exception exc);

    public abstract void a(String str);

    public void a(ByteBuffer byteBuffer) {
    }

    public void b(int i, String str, boolean z) {
    }

    @Override // com.baidu.mobstat.cb
    public final void b(by byVar) {
    }

    public void b(cq cqVar) {
    }

    public boolean c() throws InterruptedException {
        b();
        this.k.await();
        return this.f9150a.c();
    }

    public void d() {
        if (this.f9156h != null) {
            this.f9150a.a(1000);
        }
    }

    public boolean e() {
        return this.f9150a.e();
    }

    public boolean f() {
        return this.f9150a.f();
    }

    public boolean g() {
        return this.f9150a.d();
    }

    @Override // java.lang.Runnable
    public void run() {
        int read;
        try {
            if (this.f9152d == null) {
                this.f9152d = new Socket(this.f9155g);
            } else if (this.f9152d.isClosed()) {
                throw new IOException();
            }
            if (!this.f9152d.isBound()) {
                this.f9152d.connect(new InetSocketAddress(this.f9151b.getHost(), h()), this.m);
            }
            this.f9153e = this.f9152d.getInputStream();
            this.f9154f = this.f9152d.getOutputStream();
            i();
            Thread thread = new Thread(new a());
            this.f9156h = thread;
            thread.start();
            byte[] bArr = new byte[ca.f9142b];
            while (!g() && !f() && (read = this.f9153e.read(bArr)) != -1) {
                try {
                    this.f9150a.a(ByteBuffer.wrap(bArr, 0, read));
                } catch (IOException unused) {
                    this.f9150a.b();
                } catch (RuntimeException e2) {
                    a(e2);
                    this.f9150a.b(1006, e2.getMessage());
                }
            }
            this.f9150a.b();
            if (!f9149c && !this.f9152d.isClosed()) {
                throw new AssertionError();
            }
        } catch (Exception e3) {
            a(this.f9150a, e3);
            this.f9150a.b(-1, e3.getMessage());
        }
    }

    public void a(byte[] bArr) throws NotYetConnectedException {
        this.f9150a.a(bArr);
    }

    public void b() {
        if (this.f9156h == null) {
            Thread thread = new Thread(this);
            this.f9156h = thread;
            thread.start();
            return;
        }
        throw new IllegalStateException("WebSocketClient objects are not reuseable");
    }

    @Override // com.baidu.mobstat.cb
    public final void a(by byVar, String str) {
        a(str);
    }

    @Override // com.baidu.mobstat.cb
    public final void a(by byVar, ByteBuffer byteBuffer) {
        a(byteBuffer);
    }

    @Override // com.baidu.mobstat.cb
    public InetSocketAddress c(by byVar) {
        Socket socket = this.f9152d;
        if (socket != null) {
            return (InetSocketAddress) socket.getLocalSocketAddress();
        }
        return null;
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
    public void b(by byVar, int i, String str, boolean z) {
        b(i, str, z);
    }

    @Override // com.baidu.mobstat.cb
    public final void a(by byVar, int i, String str, boolean z) {
        Thread thread = this.f9156h;
        if (thread != null) {
            thread.interrupt();
        }
        try {
            if (this.f9152d != null) {
                this.f9152d.close();
            }
        } catch (IOException e2) {
            a(this, e2);
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
    public void a(by byVar, int i, String str) {
        a(i, str);
    }

    public void a(Socket socket) {
        if (this.f9152d == null) {
            this.f9152d = socket;
            return;
        }
        throw new IllegalStateException("socket has already been set");
    }

    @Override // com.baidu.mobstat.by
    public void a(cq cqVar) {
        this.f9150a.a(cqVar);
    }

    @Override // com.baidu.mobstat.by
    public InetSocketAddress a() {
        return this.f9150a.a();
    }
}
