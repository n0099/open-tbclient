package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.e;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.adp.lib.webSocket.m;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class j implements g {
    private List<BasicNameValuePair> qW;
    private String[] qX;
    protected Handler rd;
    protected volatile o re;
    protected volatile q rf;
    protected e.a rg;
    private URI rh;
    private String ri;
    private String rj;
    private int rk;
    private String rl;
    private String rm;
    private g.a ro;
    protected n rp;
    private boolean rq = false;
    private boolean rr = false;
    private volatile boolean rs = false;
    private long rt = 0;
    private c ru = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Thread {
        private a() {
        }

        /* synthetic */ a(j jVar, a aVar) {
            this();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Thread.currentThread().setName("WebSocketConnector");
            long currentTimeMillis = System.currentTimeMillis();
            try {
                e eVar = new e();
                j.this.rg = eVar.a(j.this.rj, j.this.rk, j.this.rp, false);
                if (!j.this.rs) {
                    try {
                        if (j.this.rg.isConnected()) {
                            j.this.rt = System.currentTimeMillis() - currentTimeMillis;
                            j.this.gq();
                            j.this.gp();
                            m.b bVar = new m.b(String.valueOf(j.this.rj) + ":" + j.this.rk);
                            bVar.mPath = j.this.rl;
                            bVar.ry = j.this.rm;
                            bVar.rA = j.this.qX;
                            bVar.rB = j.this.qW;
                            j.this.rf.u(bVar);
                            if (j.this.rs) {
                                j.this.r(new m.c());
                            }
                        } else {
                            j.this.r(new m.e(2, "cannot connect"));
                        }
                        return;
                    } catch (Throwable th) {
                        if (j.this.gk()) {
                            BdLog.e("----WebSocketConnector error. e:" + th.getMessage());
                        }
                        j.this.r(new m.f(new Exception(th)));
                        return;
                    }
                }
                j.this.r(new m.c());
            } catch (Throwable th2) {
                j.this.r(new m.e(2, th2.getMessage()));
            }
        }
    }

    public j() {
        go();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.ru != null || !isOpen()) {
            gk();
            if (cVar != null) {
                cVar.A(1);
                return false;
            }
            return false;
        }
        this.ru = cVar;
        return d(this.ru);
    }

    private boolean d(c cVar) {
        if (this.rf == null) {
            r(new m.f(new Exception("mWriter = null")));
            return false;
        }
        return this.rf.u(new m.i(cVar));
    }

    public void close(int i, String str) {
        this.rq = false;
        this.rs = true;
        if (this.re != null) {
            this.re.quit();
            this.re = null;
        }
        if (this.rf != null) {
            this.rf.quit();
            this.rf = null;
        }
        if (this.rg != null) {
            try {
                this.rg.close();
            } catch (Throwable th) {
                if (gk()) {
                    th.printStackTrace();
                }
            }
            this.rg = null;
        }
        g.a aVar = this.ro;
        this.ro = null;
        if (aVar != null) {
            try {
                aVar.e(i, str);
            } catch (Exception e) {
                if (gk()) {
                    BdLog.d(e.getMessage());
                }
            }
        }
    }

    public void a(String str, String[] strArr, g.a aVar, n nVar, List<BasicNameValuePair> list) throws WebSocketException {
        this.rr = true;
        if (this.rg != null && this.rg.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.rh = new URI(str);
            if (!this.rh.getScheme().equals("ws") && !this.rh.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.rh.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.ri = this.rh.getScheme();
            if (this.rh.getPort() == -1) {
                if (this.ri.equals("ws")) {
                    this.rk = 80;
                } else {
                    this.rk = 443;
                }
            } else {
                this.rk = this.rh.getPort();
            }
            if (this.rh.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.rj = this.rh.getHost();
            if (this.rh.getPath() == null || this.rh.getPath().equals("")) {
                this.rl = "/";
            } else {
                this.rl = this.rh.getPath();
            }
            if (this.rh.getQuery() == null || this.rh.getQuery().equals("")) {
                this.rm = null;
            } else {
                this.rm = this.rh.getQuery();
            }
            this.qX = strArr;
            this.qW = list;
            this.ro = aVar;
            this.rp = new n(nVar);
            new a(this, null).start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Object obj) {
        Message obtainMessage = this.rd.obtainMessage();
        obtainMessage.obj = obj;
        this.rd.sendMessage(obtainMessage);
    }

    protected void go() {
        this.rd = new k(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(Object obj) {
    }

    protected void gp() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.rf = new q(handlerThread.getLooper(), this.rd, this.rg, this.rp);
    }

    protected void gq() {
        this.re = new o(this.rd, this.rg, this.rp, "WebSocketReader");
        this.re.start();
    }

    public boolean gr() {
        return this.ru != null;
    }

    public boolean gj() {
        return this.rr;
    }

    public boolean isOpen() {
        return this.rq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean gk() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void gl() {
        if (this.rf != null) {
            this.rf.gl();
        }
    }

    public long getUpFlowSize() {
        if (this.rf != null) {
            return this.rf.getUpFlowSize();
        }
        return 0L;
    }

    public void gm() {
        if (this.re != null) {
            this.re.gm();
        }
    }

    public long getDownFlowSize() {
        if (this.re != null) {
            return this.re.getDownFlowSize();
        }
        return 0L;
    }

    public long gs() {
        if (this.rg != null) {
            return this.rg.gb();
        }
        return 0L;
    }

    public String gt() {
        if (this.rg != null) {
            return this.rg.ga();
        }
        return null;
    }

    public long gu() {
        return this.rt;
    }

    public String fI() {
        if (this.rg != null) {
            return this.rg.fI();
        }
        return null;
    }

    public String fJ() {
        if (this.rg != null) {
            return this.rg.fJ();
        }
        return null;
    }
}
