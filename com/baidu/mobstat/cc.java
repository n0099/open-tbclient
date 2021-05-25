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
    public static final /* synthetic */ boolean f8747c = !cc.class.desiredAssertionStatus();

    /* renamed from: a  reason: collision with root package name */
    public ca f8748a;

    /* renamed from: b  reason: collision with root package name */
    public URI f8749b;

    /* renamed from: e  reason: collision with root package name */
    public InputStream f8751e;

    /* renamed from: f  reason: collision with root package name */
    public OutputStream f8752f;

    /* renamed from: h  reason: collision with root package name */
    public Thread f8754h;

    /* renamed from: i  reason: collision with root package name */
    public cd f8755i;
    public Map<String, String> j;
    public int m;

    /* renamed from: d  reason: collision with root package name */
    public Socket f8750d = null;

    /* renamed from: g  reason: collision with root package name */
    public Proxy f8753g = Proxy.NO_PROXY;
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
                    ByteBuffer take = cc.this.f8748a.f8742d.take();
                    cc.this.f8752f.write(take.array(), 0, take.limit());
                    cc.this.f8752f.flush();
                } catch (IOException unused) {
                    cc.this.f8748a.b();
                    return;
                } catch (InterruptedException unused2) {
                    return;
                }
            }
        }
    }

    public cc(URI uri, cd cdVar, Map<String, String> map, int i2) {
        this.f8749b = null;
        this.f8748a = null;
        this.m = 0;
        if (uri == null) {
            throw new IllegalArgumentException();
        }
        if (cdVar != null) {
            this.f8749b = uri;
            this.f8755i = cdVar;
            this.j = map;
            this.m = i2;
            this.f8748a = new ca(this, cdVar);
            return;
        }
        throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
    }

    private int h() {
        int port = this.f8749b.getPort();
        if (port == -1) {
            String scheme = this.f8749b.getScheme();
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
        String rawPath = this.f8749b.getRawPath();
        String rawQuery = this.f8749b.getRawQuery();
        rawPath = (rawPath == null || rawPath.length() == 0) ? "/" : "/";
        if (rawQuery != null) {
            rawPath = rawPath + "?" + rawQuery;
        }
        int h2 = h();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8749b.getHost());
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
        this.f8748a.a((ct) cvVar);
    }

    public void a(int i2, String str) {
    }

    public abstract void a(int i2, String str, boolean z);

    public abstract void a(cz czVar);

    public abstract void a(Exception exc);

    public abstract void a(String str);

    public void a(ByteBuffer byteBuffer) {
    }

    public void b(int i2, String str, boolean z) {
    }

    @Override // com.baidu.mobstat.cb
    public final void b(by byVar) {
    }

    public void b(cq cqVar) {
    }

    public boolean c() throws InterruptedException {
        b();
        this.k.await();
        return this.f8748a.c();
    }

    public void d() {
        if (this.f8754h != null) {
            this.f8748a.a(1000);
        }
    }

    public boolean e() {
        return this.f8748a.e();
    }

    public boolean f() {
        return this.f8748a.f();
    }

    public boolean g() {
        return this.f8748a.d();
    }

    @Override // java.lang.Runnable
    public void run() {
        int read;
        try {
            if (this.f8750d == null) {
                this.f8750d = new Socket(this.f8753g);
            } else if (this.f8750d.isClosed()) {
                throw new IOException();
            }
            if (!this.f8750d.isBound()) {
                this.f8750d.connect(new InetSocketAddress(this.f8749b.getHost(), h()), this.m);
            }
            this.f8751e = this.f8750d.getInputStream();
            this.f8752f = this.f8750d.getOutputStream();
            i();
            Thread thread = new Thread(new a());
            this.f8754h = thread;
            thread.start();
            byte[] bArr = new byte[ca.f8739b];
            while (!g() && !f() && (read = this.f8751e.read(bArr)) != -1) {
                try {
                    this.f8748a.a(ByteBuffer.wrap(bArr, 0, read));
                } catch (IOException unused) {
                    this.f8748a.b();
                } catch (RuntimeException e2) {
                    a(e2);
                    this.f8748a.b(1006, e2.getMessage());
                }
            }
            this.f8748a.b();
            if (!f8747c && !this.f8750d.isClosed()) {
                throw new AssertionError();
            }
        } catch (Exception e3) {
            a(this.f8748a, e3);
            this.f8748a.b(-1, e3.getMessage());
        }
    }

    public void a(byte[] bArr) throws NotYetConnectedException {
        this.f8748a.a(bArr);
    }

    public void b() {
        if (this.f8754h == null) {
            Thread thread = new Thread(this);
            this.f8754h = thread;
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
        Socket socket = this.f8750d;
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
    public void b(by byVar, int i2, String str, boolean z) {
        b(i2, str, z);
    }

    @Override // com.baidu.mobstat.cb
    public final void a(by byVar, int i2, String str, boolean z) {
        Thread thread = this.f8754h;
        if (thread != null) {
            thread.interrupt();
        }
        try {
            if (this.f8750d != null) {
                this.f8750d.close();
            }
        } catch (IOException e2) {
            a(this, e2);
        }
        a(i2, str, z);
        this.k.countDown();
        this.l.countDown();
    }

    @Override // com.baidu.mobstat.cb
    public final void a(by byVar, Exception exc) {
        a(exc);
    }

    @Override // com.baidu.mobstat.cb
    public void a(by byVar, int i2, String str) {
        a(i2, str);
    }

    public void a(Socket socket) {
        if (this.f8750d == null) {
            this.f8750d = socket;
            return;
        }
        throw new IllegalStateException("socket has already been set");
    }

    @Override // com.baidu.mobstat.by
    public void a(cq cqVar) {
        this.f8748a.a(cqVar);
    }

    @Override // com.baidu.mobstat.by
    public InetSocketAddress a() {
        return this.f8748a.a();
    }
}
