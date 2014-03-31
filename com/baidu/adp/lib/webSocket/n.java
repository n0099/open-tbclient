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
public final class n implements j {
    protected Handler a;
    protected volatile am b;
    protected volatile ap c;
    protected g d;
    protected al e;
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
    private long r = 0;
    private d s = null;

    public n() {
        if (com.baidu.adp.a.b.a().d()) {
            com.baidu.adp.lib.util.f.e("created");
        }
        this.a = new o(this);
    }

    public final boolean a(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.s != null || !this.o) {
            if (com.baidu.adp.a.b.a().d()) {
                com.baidu.adp.lib.util.f.e("mWebSocketSendData not null");
            }
            if (dVar != null) {
                dVar.a(1);
                return false;
            }
            return false;
        }
        this.s = dVar;
        d dVar2 = this.s;
        if (this.c == null) {
            a(new x(new Exception("mWriter = null")));
            return false;
        }
        return this.c.a(new aa(dVar2));
    }

    public final void a(int i, String str) {
        if (com.baidu.adp.a.b.a().d()) {
            com.baidu.adp.lib.util.f.e("fail connection [code = " + i + ", reason = " + str);
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
                if (com.baidu.adp.a.b.a().d()) {
                    e.printStackTrace();
                }
            }
            this.d = null;
        }
        k kVar = this.n;
        this.n = null;
        if (kVar != null) {
            try {
                kVar.a(i, str);
            } catch (Exception e2) {
                if (com.baidu.adp.a.b.a().d()) {
                    com.baidu.adp.lib.util.f.e(e2.getMessage());
                }
            }
        }
        if (com.baidu.adp.a.b.a().d()) {
            com.baidu.adp.lib.util.f.e("worker threads stopped");
        }
    }

    public final void a(String str, String[] strArr, k kVar, al alVar, List<BasicNameValuePair> list) {
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
            this.e = new al(alVar);
            new p(this, (byte) 0).start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object obj) {
        Message obtainMessage = this.a.obtainMessage();
        obtainMessage.obj = obj;
        this.a.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.c = new ap(handlerThread.getLooper(), this.a, this.d, this.e);
        if (com.baidu.adp.a.b.a().d()) {
            com.baidu.adp.lib.util.f.e("WS writer created and started");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() {
        this.b = new am(this.a, this.d, this.e, "WebSocketReader");
        this.b.start();
        if (com.baidu.adp.a.b.a().d()) {
            com.baidu.adp.lib.util.f.e("WS reader created and started");
        }
    }

    public final boolean c() {
        return this.s != null;
    }

    public final boolean d() {
        return this.p;
    }

    public final boolean e() {
        return this.o;
    }

    public final void f() {
        if (this.c != null) {
            ap apVar = this.c;
            ap.b();
        }
    }

    public final long g() {
        if (this.c != null) {
            ap apVar = this.c;
            return ap.c();
        }
        return 0L;
    }

    public final void h() {
        if (this.b != null) {
            am amVar = this.b;
            am.b();
        }
    }

    public final long i() {
        if (this.b != null) {
            am amVar = this.b;
            return am.c();
        }
        return 0L;
    }

    public final long j() {
        if (this.d != null) {
            return this.d.d();
        }
        return 0L;
    }

    public final String k() {
        if (this.d != null) {
            return this.d.c();
        }
        return null;
    }

    public final long l() {
        return this.r;
    }
}
