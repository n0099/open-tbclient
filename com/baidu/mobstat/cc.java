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
    public static final /* synthetic */ boolean f8847c = !cc.class.desiredAssertionStatus();

    /* renamed from: a  reason: collision with root package name */
    public ca f8848a;

    /* renamed from: b  reason: collision with root package name */
    public URI f8849b;

    /* renamed from: e  reason: collision with root package name */
    public InputStream f8851e;

    /* renamed from: f  reason: collision with root package name */
    public OutputStream f8852f;

    /* renamed from: h  reason: collision with root package name */
    public Thread f8854h;

    /* renamed from: i  reason: collision with root package name */
    public cd f8855i;
    public Map<String, String> j;
    public int m;

    /* renamed from: d  reason: collision with root package name */
    public Socket f8850d = null;

    /* renamed from: g  reason: collision with root package name */
    public Proxy f8853g = Proxy.NO_PROXY;
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
                    ByteBuffer take = cc.this.f8848a.f8842d.take();
                    cc.this.f8852f.write(take.array(), 0, take.limit());
                    cc.this.f8852f.flush();
                } catch (IOException unused) {
                    cc.this.f8848a.b();
                    return;
                } catch (InterruptedException unused2) {
                    return;
                }
            }
        }
    }

    public cc(URI uri, cd cdVar, Map<String, String> map, int i2) {
        this.f8849b = null;
        this.f8848a = null;
        this.m = 0;
        if (uri == null) {
            throw new IllegalArgumentException();
        }
        if (cdVar != null) {
            this.f8849b = uri;
            this.f8855i = cdVar;
            this.j = map;
            this.m = i2;
            this.f8848a = new ca(this, cdVar);
            return;
        }
        throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
    }

    private int h() {
        int port = this.f8849b.getPort();
        if (port == -1) {
            String scheme = this.f8849b.getScheme();
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
        String rawPath = this.f8849b.getRawPath();
        String rawQuery = this.f8849b.getRawQuery();
        rawPath = (rawPath == null || rawPath.length() == 0) ? "/" : "/";
        if (rawQuery != null) {
            rawPath = rawPath + "?" + rawQuery;
        }
        int h2 = h();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8849b.getHost());
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
        this.f8848a.a((ct) cvVar);
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
        return this.f8848a.c();
    }

    public void d() {
        if (this.f8854h != null) {
            this.f8848a.a(1000);
        }
    }

    public boolean e() {
        return this.f8848a.e();
    }

    public boolean f() {
        return this.f8848a.f();
    }

    public boolean g() {
        return this.f8848a.d();
    }

    @Override // java.lang.Runnable
    public void run() {
        int read;
        try {
            if (this.f8850d == null) {
                this.f8850d = new Socket(this.f8853g);
            } else if (this.f8850d.isClosed()) {
                throw new IOException();
            }
            if (!this.f8850d.isBound()) {
                this.f8850d.connect(new InetSocketAddress(this.f8849b.getHost(), h()), this.m);
            }
            this.f8851e = this.f8850d.getInputStream();
            this.f8852f = this.f8850d.getOutputStream();
            i();
            Thread thread = new Thread(new a());
            this.f8854h = thread;
            thread.start();
            byte[] bArr = new byte[ca.f8839b];
            while (!g() && !f() && (read = this.f8851e.read(bArr)) != -1) {
                try {
                    this.f8848a.a(ByteBuffer.wrap(bArr, 0, read));
                } catch (IOException unused) {
                    this.f8848a.b();
                } catch (RuntimeException e2) {
                    a(e2);
                    this.f8848a.b(1006, e2.getMessage());
                }
            }
            this.f8848a.b();
            if (!f8847c && !this.f8850d.isClosed()) {
                throw new AssertionError();
            }
        } catch (Exception e3) {
            a(this.f8848a, e3);
            this.f8848a.b(-1, e3.getMessage());
        }
    }

    public void a(byte[] bArr) throws NotYetConnectedException {
        this.f8848a.a(bArr);
    }

    public void b() {
        if (this.f8854h == null) {
            Thread thread = new Thread(this);
            this.f8854h = thread;
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
        Socket socket = this.f8850d;
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
        Thread thread = this.f8854h;
        if (thread != null) {
            thread.interrupt();
        }
        try {
            if (this.f8850d != null) {
                this.f8850d.close();
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
        if (this.f8850d == null) {
            this.f8850d = socket;
            return;
        }
        throw new IllegalStateException("socket has already been set");
    }

    @Override // com.baidu.mobstat.by
    public void a(cq cqVar) {
        this.f8848a.a(cqVar);
    }

    @Override // com.baidu.mobstat.by
    public InetSocketAddress a() {
        return this.f8848a.a();
    }
}
