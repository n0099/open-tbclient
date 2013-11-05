package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class n implements j {

    /* renamed from: a  reason: collision with root package name */
    protected Handler f538a;
    protected volatile aj b;
    protected volatile WebSocketWriter c;
    protected f d;
    protected ai e;
    private URI f;
    private String g;
    private String h;
    private int i;
    private String j;
    private String k;
    private String[] l;
    private List<BasicNameValuePair> m;
    private k n;
    private boolean o = false;
    private boolean p = false;
    private volatile boolean q = false;
    private am r = null;

    public n() {
        if (k()) {
            com.baidu.adp.lib.h.d.d("created");
        }
        a();
    }

    public boolean a(am amVar) {
        if (amVar == null) {
            return false;
        }
        if (this.r != null || !f()) {
            if (k()) {
                com.baidu.adp.lib.h.d.d("mWebSocketSendData not null");
            }
            if (amVar.d() != null) {
                amVar.d().b(amVar);
                return false;
            }
            return false;
        }
        this.r = amVar;
        if (amVar.a() == 1) {
            return a(this.r.b());
        }
        if (amVar.a() == 2) {
            return a(this.r.c());
        }
        return false;
    }

    private boolean a(String str) {
        if (this.c == null) {
            b(new x(new Exception("mWriter = null")));
            return false;
        }
        return this.c.a((Object) new ah(str));
    }

    private boolean a(byte[] bArr) {
        if (this.c == null) {
            b(new x(new Exception("mWriter = null")));
            return false;
        }
        return this.c.a((Object) new s(bArr));
    }

    public void a(int i, String str) {
        if (k()) {
            com.baidu.adp.lib.h.d.d("fail connection [code = " + i + ", reason = " + str);
        }
        this.o = false;
        this.q = true;
        if (this.b != null) {
            this.b.a();
            this.b = null;
        }
        if (this.c != null) {
            this.c.a();
            this.c = null;
        }
        if (this.d != null) {
            try {
                this.d.a();
            } catch (IOException e) {
                if (k()) {
                    e.printStackTrace();
                }
            }
            this.d = null;
        }
        if (this.n != null && this.r != null) {
            this.n.c(this.r);
        }
        this.r = null;
        if (this.n != null) {
            try {
                this.n.a(i, str);
            } catch (Exception e2) {
                if (k()) {
                    e2.printStackTrace();
                }
            }
            this.n = null;
        }
        if (k()) {
            com.baidu.adp.lib.h.d.d("worker threads stopped");
        }
    }

    public void a(String str, String[] strArr, k kVar, ai aiVar, List<BasicNameValuePair> list) {
        this.p = true;
        if (this.d != null && this.d.b()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.f = new URI(str);
            if (!this.f.getScheme().equals("ws") && !this.f.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.f.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.g = this.f.getScheme();
            if (this.f.getPort() == -1) {
                if (this.g.equals("ws")) {
                    this.i = 80;
                } else {
                    this.i = 443;
                }
            } else {
                this.i = this.f.getPort();
            }
            if (this.f.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.h = this.f.getHost();
            if (this.f.getPath() == null || this.f.getPath().equals("")) {
                this.j = "/";
            } else {
                this.j = this.f.getPath();
            }
            if (this.f.getQuery() == null || this.f.getQuery().equals("")) {
                this.k = null;
            } else {
                this.k = this.f.getQuery();
            }
            this.l = strArr;
            this.m = list;
            this.n = kVar;
            this.e = new ai(aiVar);
            new p(this, null).start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Object obj) {
        Message obtainMessage = this.f538a.obtainMessage();
        obtainMessage.obj = obj;
        this.f538a.sendMessage(obtainMessage);
    }

    protected void a() {
        this.f538a = new o(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.c = new WebSocketWriter(handlerThread.getLooper(), this.f538a, this.d, this.e);
        if (k()) {
            com.baidu.adp.lib.h.d.d("WS writer created and started");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        this.b = new aj(this.f538a, this.d, this.e, "WebSocketReader");
        this.b.start();
        if (k()) {
            com.baidu.adp.lib.h.d.d("WS reader created and started");
        }
    }

    public boolean d() {
        return this.r != null;
    }

    public boolean e() {
        return this.p;
    }

    public boolean f() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k() {
        return com.baidu.adp.a.b.a().b();
    }

    public void g() {
        if (this.c != null) {
            this.c.b();
        }
    }

    public long h() {
        if (this.c != null) {
            return this.c.c();
        }
        return 0L;
    }

    public void i() {
        if (this.b != null) {
            this.b.b();
        }
    }

    public long j() {
        if (this.b != null) {
            return this.b.c();
        }
        return 0L;
    }
}
