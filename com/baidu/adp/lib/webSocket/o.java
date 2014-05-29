package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class o implements k {
    protected Handler a;
    protected volatile an b;
    protected volatile aq c;
    protected g d;
    protected am e;
    private URI f;
    private String g;
    private String h;
    private int i;
    private String j;
    private String k;
    private String[] l;
    private List<BasicNameValuePair> m;
    private l n;
    private boolean o = false;
    private boolean p = false;
    private volatile boolean q = false;
    private long r = 0;
    private d s = null;

    public o() {
        if (p()) {
            BdLog.d("created");
        }
        a();
    }

    public boolean a(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.s != null || !f()) {
            if (p()) {
                BdLog.d("mWebSocketSendData not null");
            }
            if (dVar != null) {
                dVar.a(1);
                return false;
            }
            return false;
        }
        this.s = dVar;
        return b(this.s);
    }

    private boolean b(d dVar) {
        if (this.c == null) {
            b(new y(new Exception("mWriter = null")));
            return false;
        }
        return this.c.a((Object) new ab(dVar));
    }

    public void a(int i, String str) {
        if (p()) {
            BdLog.d("fail connection [code = " + i + ", reason = " + str);
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
                if (p()) {
                    e.printStackTrace();
                }
            }
            this.d = null;
        }
        l lVar = this.n;
        this.n = null;
        if (lVar != null) {
            try {
                lVar.a(i, str);
            } catch (Exception e2) {
                if (p()) {
                    BdLog.d(e2.getMessage());
                }
            }
        }
        if (p()) {
            BdLog.d("worker threads stopped");
        }
    }

    public void a(String str, String[] strArr, l lVar, am amVar, List<BasicNameValuePair> list) {
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
            this.n = lVar;
            this.e = new am(amVar);
            new q(this, null).start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Object obj) {
        Message obtainMessage = this.a.obtainMessage();
        obtainMessage.obj = obj;
        this.a.sendMessage(obtainMessage);
    }

    protected void a() {
        this.a = new p(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.c = new aq(handlerThread.getLooper(), this.a, this.d, this.e);
        if (p()) {
            BdLog.d("WS writer created and started");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        this.b = new an(this.a, this.d, this.e, "WebSocketReader");
        this.b.start();
        if (p()) {
            BdLog.d("WS reader created and started");
        }
    }

    public boolean d() {
        return this.s != null;
    }

    public boolean e() {
        return this.p;
    }

    public boolean f() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p() {
        return BdBaseApplication.getInst().isDebugMode();
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

    public long k() {
        if (this.d != null) {
            return this.d.d();
        }
        return 0L;
    }

    public String l() {
        if (this.d != null) {
            return this.d.c();
        }
        return null;
    }

    public long m() {
        return this.r;
    }

    public String n() {
        if (this.d != null) {
            return this.d.e();
        }
        return null;
    }

    public String o() {
        if (this.d != null) {
            return this.d.f();
        }
        return null;
    }
}
