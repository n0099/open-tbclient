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
    public static final /* synthetic */ boolean f8723c = !cc.class.desiredAssertionStatus();

    /* renamed from: a  reason: collision with root package name */
    public ca f8724a;

    /* renamed from: b  reason: collision with root package name */
    public URI f8725b;

    /* renamed from: e  reason: collision with root package name */
    public InputStream f8727e;

    /* renamed from: f  reason: collision with root package name */
    public OutputStream f8728f;

    /* renamed from: h  reason: collision with root package name */
    public Thread f8730h;
    public cd i;
    public Map<String, String> j;
    public int m;

    /* renamed from: d  reason: collision with root package name */
    public Socket f8726d = null;

    /* renamed from: g  reason: collision with root package name */
    public Proxy f8729g = Proxy.NO_PROXY;
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
                    ByteBuffer take = cc.this.f8724a.f8719d.take();
                    cc.this.f8728f.write(take.array(), 0, take.limit());
                    cc.this.f8728f.flush();
                } catch (IOException unused) {
                    cc.this.f8724a.b();
                    return;
                } catch (InterruptedException unused2) {
                    return;
                }
            }
        }
    }

    public cc(URI uri, cd cdVar, Map<String, String> map, int i) {
        this.f8725b = null;
        this.f8724a = null;
        this.m = 0;
        if (uri == null) {
            throw new IllegalArgumentException();
        }
        if (cdVar != null) {
            this.f8725b = uri;
            this.i = cdVar;
            this.j = map;
            this.m = i;
            this.f8724a = new ca(this, cdVar);
            return;
        }
        throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
    }

    private int h() {
        int port = this.f8725b.getPort();
        if (port == -1) {
            String scheme = this.f8725b.getScheme();
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
        String rawPath = this.f8725b.getRawPath();
        String rawQuery = this.f8725b.getRawQuery();
        rawPath = (rawPath == null || rawPath.length() == 0) ? "/" : "/";
        if (rawQuery != null) {
            rawPath = rawPath + "?" + rawQuery;
        }
        int h2 = h();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8725b.getHost());
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
        this.f8724a.a((ct) cvVar);
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
        return this.f8724a.c();
    }

    public void d() {
        if (this.f8730h != null) {
            this.f8724a.a(1000);
        }
    }

    public boolean e() {
        return this.f8724a.e();
    }

    public boolean f() {
        return this.f8724a.f();
    }

    public boolean g() {
        return this.f8724a.d();
    }

    @Override // java.lang.Runnable
    public void run() {
        int read;
        try {
            if (this.f8726d == null) {
                this.f8726d = new Socket(this.f8729g);
            } else if (this.f8726d.isClosed()) {
                throw new IOException();
            }
            if (!this.f8726d.isBound()) {
                this.f8726d.connect(new InetSocketAddress(this.f8725b.getHost(), h()), this.m);
            }
            this.f8727e = this.f8726d.getInputStream();
            this.f8728f = this.f8726d.getOutputStream();
            i();
            Thread thread = new Thread(new a());
            this.f8730h = thread;
            thread.start();
            byte[] bArr = new byte[ca.f8716b];
            while (!g() && !f() && (read = this.f8727e.read(bArr)) != -1) {
                try {
                    this.f8724a.a(ByteBuffer.wrap(bArr, 0, read));
                } catch (IOException unused) {
                    this.f8724a.b();
                } catch (RuntimeException e2) {
                    a(e2);
                    this.f8724a.b(1006, e2.getMessage());
                }
            }
            this.f8724a.b();
            if (!f8723c && !this.f8726d.isClosed()) {
                throw new AssertionError();
            }
        } catch (Exception e3) {
            a(this.f8724a, e3);
            this.f8724a.b(-1, e3.getMessage());
        }
    }

    public void a(byte[] bArr) throws NotYetConnectedException {
        this.f8724a.a(bArr);
    }

    public void b() {
        if (this.f8730h == null) {
            Thread thread = new Thread(this);
            this.f8730h = thread;
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
        Socket socket = this.f8726d;
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
        Thread thread = this.f8730h;
        if (thread != null) {
            thread.interrupt();
        }
        try {
            if (this.f8726d != null) {
                this.f8726d.close();
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
        if (this.f8726d == null) {
            this.f8726d = socket;
            return;
        }
        throw new IllegalStateException("socket has already been set");
    }

    @Override // com.baidu.mobstat.by
    public void a(cq cqVar) {
        this.f8724a.a(cqVar);
    }

    @Override // com.baidu.mobstat.by
    public InetSocketAddress a() {
        return this.f8724a.a();
    }
}
