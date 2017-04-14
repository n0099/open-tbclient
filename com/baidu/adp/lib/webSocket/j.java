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
    protected Handler Ae;
    protected volatile o Af;
    protected volatile q Ag;
    protected e.a Ah;
    private URI Ai;
    private String Aj;
    private String Ak;
    private int Al;
    private String Am;
    private String An;
    private g.a Ao;
    protected n Ap;
    private boolean Aq = false;
    private boolean Ar = false;
    private volatile boolean As = false;
    private long At = 0;
    private c Au = null;
    private List<BasicNameValuePair> zW;
    private String[] zX;

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
                j.this.Ah = eVar.a(j.this.Ak, j.this.Al, j.this.Ap, false);
                if (!j.this.As) {
                    try {
                        if (j.this.Ah.isConnected()) {
                            j.this.At = System.currentTimeMillis() - currentTimeMillis;
                            j.this.ih();
                            j.this.ig();
                            m.b bVar = new m.b(String.valueOf(j.this.Ak) + ":" + j.this.Al);
                            bVar.mPath = j.this.Am;
                            bVar.Ay = j.this.An;
                            bVar.AA = j.this.zX;
                            bVar.AB = j.this.zW;
                            j.this.Ag.u(bVar);
                            if (j.this.As) {
                                j.this.r(new m.c());
                            }
                        } else {
                            j.this.r(new m.e(2, "cannot connect"));
                        }
                        return;
                    } catch (Throwable th) {
                        if (j.this.isDebug()) {
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
        m5if();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.Au != null || !isOpen()) {
            isDebug();
            if (cVar != null) {
                cVar.M(1);
                return false;
            }
            return false;
        }
        this.Au = cVar;
        return d(this.Au);
    }

    private boolean d(c cVar) {
        if (this.Ag == null) {
            r(new m.f(new Exception("mWriter = null")));
            return false;
        }
        return this.Ag.u(new m.i(cVar));
    }

    public void close(int i, String str) {
        this.Aq = false;
        this.As = true;
        if (this.Af != null) {
            this.Af.quit();
            this.Af = null;
        }
        if (this.Ag != null) {
            this.Ag.quit();
            this.Ag = null;
        }
        if (this.Ah != null) {
            try {
                this.Ah.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.Ah = null;
        }
        g.a aVar = this.Ao;
        this.Ao = null;
        if (aVar != null) {
            try {
                aVar.e(i, str);
            } catch (Exception e) {
                if (isDebug()) {
                    BdLog.d(e.getMessage());
                }
            }
        }
    }

    public void a(String str, String[] strArr, g.a aVar, n nVar, List<BasicNameValuePair> list) throws WebSocketException {
        this.Ar = true;
        if (this.Ah != null && this.Ah.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.Ai = new URI(str);
            if (!this.Ai.getScheme().equals("ws") && !this.Ai.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.Ai.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.Aj = this.Ai.getScheme();
            if (this.Ai.getPort() == -1) {
                if (this.Aj.equals("ws")) {
                    this.Al = 80;
                } else {
                    this.Al = 443;
                }
            } else {
                this.Al = this.Ai.getPort();
            }
            if (this.Ai.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.Ak = this.Ai.getHost();
            if (this.Ai.getPath() == null || this.Ai.getPath().equals("")) {
                this.Am = "/";
            } else {
                this.Am = this.Ai.getPath();
            }
            if (this.Ai.getQuery() == null || this.Ai.getQuery().equals("")) {
                this.An = null;
            } else {
                this.An = this.Ai.getQuery();
            }
            this.zX = strArr;
            this.zW = list;
            this.Ao = aVar;
            this.Ap = new n(nVar);
            new a(this, null).start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Object obj) {
        Message obtainMessage = this.Ae.obtainMessage();
        obtainMessage.obj = obj;
        this.Ae.sendMessage(obtainMessage);
    }

    /* renamed from: if  reason: not valid java name */
    protected void m5if() {
        this.Ae = new k(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(Object obj) {
    }

    protected void ig() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.Ag = new q(handlerThread.getLooper(), this.Ae, this.Ah, this.Ap);
    }

    protected void ih() {
        this.Af = new o(this.Ae, this.Ah, this.Ap, "WebSocketReader");
        this.Af.start();
    }

    public boolean ii() {
        return this.Au != null;
    }

    public boolean ib() {
        return this.Ar;
    }

    public boolean isOpen() {
        return this.Aq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void ic() {
        if (this.Ag != null) {
            this.Ag.ic();
        }
    }

    public long getUpFlowSize() {
        if (this.Ag != null) {
            return this.Ag.getUpFlowSize();
        }
        return 0L;
    }

    public void id() {
        if (this.Af != null) {
            this.Af.id();
        }
    }

    public long getDownFlowSize() {
        if (this.Af != null) {
            return this.Af.getDownFlowSize();
        }
        return 0L;
    }

    public long ij() {
        if (this.Ah != null) {
            return this.Ah.hU();
        }
        return 0L;
    }

    public String ik() {
        if (this.Ah != null) {
            return this.Ah.hT();
        }
        return null;
    }

    public long il() {
        return this.At;
    }

    public String hB() {
        if (this.Ah != null) {
            return this.Ah.hB();
        }
        return null;
    }

    public String hC() {
        if (this.Ah != null) {
            return this.Ah.hC();
        }
        return null;
    }
}
