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
    private String[] Aa;
    protected Handler Ah;
    protected volatile o Ai;
    protected volatile q Aj;
    protected e.a Ak;
    private URI Al;
    private String Am;
    private String An;
    private int Ao;
    private String Ap;
    private String Aq;
    private g.a Ar;
    protected n As;
    private boolean At = false;
    private boolean Au = false;
    private volatile boolean Av = false;
    private long Aw = 0;
    private c Ax = null;
    private List<BasicNameValuePair> zZ;

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
                j.this.Ak = eVar.a(j.this.An, j.this.Ao, j.this.As, false);
                if (!j.this.Av) {
                    try {
                        if (j.this.Ak.isConnected()) {
                            j.this.Aw = System.currentTimeMillis() - currentTimeMillis;
                            j.this.ih();
                            j.this.ig();
                            m.b bVar = new m.b(String.valueOf(j.this.An) + ":" + j.this.Ao);
                            bVar.mPath = j.this.Ap;
                            bVar.AB = j.this.Aq;
                            bVar.AD = j.this.Aa;
                            bVar.AE = j.this.zZ;
                            j.this.Aj.u(bVar);
                            if (j.this.Av) {
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
        if (this.Ax != null || !isOpen()) {
            isDebug();
            if (cVar != null) {
                cVar.M(1);
                return false;
            }
            return false;
        }
        this.Ax = cVar;
        return d(this.Ax);
    }

    private boolean d(c cVar) {
        if (this.Aj == null) {
            r(new m.f(new Exception("mWriter = null")));
            return false;
        }
        return this.Aj.u(new m.i(cVar));
    }

    public void close(int i, String str) {
        this.At = false;
        this.Av = true;
        if (this.Ai != null) {
            this.Ai.quit();
            this.Ai = null;
        }
        if (this.Aj != null) {
            this.Aj.quit();
            this.Aj = null;
        }
        if (this.Ak != null) {
            try {
                this.Ak.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.Ak = null;
        }
        g.a aVar = this.Ar;
        this.Ar = null;
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
        this.Au = true;
        if (this.Ak != null && this.Ak.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.Al = new URI(str);
            if (!this.Al.getScheme().equals("ws") && !this.Al.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.Al.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.Am = this.Al.getScheme();
            if (this.Al.getPort() == -1) {
                if (this.Am.equals("ws")) {
                    this.Ao = 80;
                } else {
                    this.Ao = 443;
                }
            } else {
                this.Ao = this.Al.getPort();
            }
            if (this.Al.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.An = this.Al.getHost();
            if (this.Al.getPath() == null || this.Al.getPath().equals("")) {
                this.Ap = "/";
            } else {
                this.Ap = this.Al.getPath();
            }
            if (this.Al.getQuery() == null || this.Al.getQuery().equals("")) {
                this.Aq = null;
            } else {
                this.Aq = this.Al.getQuery();
            }
            this.Aa = strArr;
            this.zZ = list;
            this.Ar = aVar;
            this.As = new n(nVar);
            new a(this, null).start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Object obj) {
        Message obtainMessage = this.Ah.obtainMessage();
        obtainMessage.obj = obj;
        this.Ah.sendMessage(obtainMessage);
    }

    /* renamed from: if  reason: not valid java name */
    protected void m5if() {
        this.Ah = new k(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(Object obj) {
    }

    protected void ig() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.Aj = new q(handlerThread.getLooper(), this.Ah, this.Ak, this.As);
    }

    protected void ih() {
        this.Ai = new o(this.Ah, this.Ak, this.As, "WebSocketReader");
        this.Ai.start();
    }

    public boolean ii() {
        return this.Ax != null;
    }

    public boolean ib() {
        return this.Au;
    }

    public boolean isOpen() {
        return this.At;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void ic() {
        if (this.Aj != null) {
            this.Aj.ic();
        }
    }

    public long getUpFlowSize() {
        if (this.Aj != null) {
            return this.Aj.getUpFlowSize();
        }
        return 0L;
    }

    public void id() {
        if (this.Ai != null) {
            this.Ai.id();
        }
    }

    public long getDownFlowSize() {
        if (this.Ai != null) {
            return this.Ai.getDownFlowSize();
        }
        return 0L;
    }

    public long ij() {
        if (this.Ak != null) {
            return this.Ak.hU();
        }
        return 0L;
    }

    public String ik() {
        if (this.Ak != null) {
            return this.Ak.hT();
        }
        return null;
    }

    public long il() {
        return this.Aw;
    }

    public String hC() {
        if (this.Ak != null) {
            return this.Ak.hC();
        }
        return null;
    }

    public String hD() {
        if (this.Ak != null) {
            return this.Ak.hD();
        }
        return null;
    }
}
