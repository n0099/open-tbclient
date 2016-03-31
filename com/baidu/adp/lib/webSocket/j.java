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
    protected n AA;
    private boolean AB = false;
    private boolean AC = false;
    private volatile boolean AD = false;
    private long AE = 0;
    private c AF = null;
    private List<BasicNameValuePair> Ai;
    private String[] Aj;
    protected Handler Ap;
    protected volatile o Aq;
    protected volatile q Ar;
    protected e.a As;
    private URI At;
    private String Au;
    private String Av;
    private int Aw;
    private String Ax;
    private String Ay;
    private g.a Az;

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
                j.this.As = eVar.a(j.this.Av, j.this.Aw, j.this.AA, false);
                if (!j.this.AD) {
                    try {
                        if (j.this.As.isConnected()) {
                            j.this.AE = System.currentTimeMillis() - currentTimeMillis;
                            j.this.kb();
                            j.this.ka();
                            m.b bVar = new m.b(String.valueOf(j.this.Av) + ":" + j.this.Aw);
                            bVar.mPath = j.this.Ax;
                            bVar.AJ = j.this.Ay;
                            bVar.AL = j.this.Aj;
                            bVar.AM = j.this.Ai;
                            j.this.Ar.r(bVar);
                            if (j.this.AD) {
                                j.this.o(new m.c());
                            }
                        } else {
                            j.this.o(new m.e(2, "cannot connect"));
                        }
                        return;
                    } catch (Throwable th) {
                        if (j.this.isDebug()) {
                            BdLog.e("----WebSocketConnector error. e:" + th.getMessage());
                        }
                        j.this.o(new m.f(new Exception(th)));
                        return;
                    }
                }
                j.this.o(new m.c());
            } catch (Throwable th2) {
                j.this.o(new m.e(2, th2.getMessage()));
            }
        }
    }

    public j() {
        jZ();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.AF != null || !isOpen()) {
            isDebug();
            if (cVar != null) {
                cVar.I(1);
                return false;
            }
            return false;
        }
        this.AF = cVar;
        return d(this.AF);
    }

    private boolean d(c cVar) {
        if (this.Ar == null) {
            o(new m.f(new Exception("mWriter = null")));
            return false;
        }
        return this.Ar.r(new m.i(cVar));
    }

    public void close(int i, String str) {
        this.AB = false;
        this.AD = true;
        if (this.Aq != null) {
            this.Aq.quit();
            this.Aq = null;
        }
        if (this.Ar != null) {
            this.Ar.quit();
            this.Ar = null;
        }
        if (this.As != null) {
            try {
                this.As.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.As = null;
        }
        g.a aVar = this.Az;
        this.Az = null;
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

    public void a(String str, String[] strArr, g.a aVar, n nVar, List<BasicNameValuePair> list) {
        this.AC = true;
        if (this.As != null && this.As.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.At = new URI(str);
            if (!this.At.getScheme().equals("ws") && !this.At.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.At.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.Au = this.At.getScheme();
            if (this.At.getPort() == -1) {
                if (this.Au.equals("ws")) {
                    this.Aw = 80;
                } else {
                    this.Aw = 443;
                }
            } else {
                this.Aw = this.At.getPort();
            }
            if (this.At.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.Av = this.At.getHost();
            if (this.At.getPath() == null || this.At.getPath().equals("")) {
                this.Ax = "/";
            } else {
                this.Ax = this.At.getPath();
            }
            if (this.At.getQuery() == null || this.At.getQuery().equals("")) {
                this.Ay = null;
            } else {
                this.Ay = this.At.getQuery();
            }
            this.Aj = strArr;
            this.Ai = list;
            this.Az = aVar;
            this.AA = new n(nVar);
            new a(this, null).start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Object obj) {
        Message obtainMessage = this.Ap.obtainMessage();
        obtainMessage.obj = obj;
        this.Ap.sendMessage(obtainMessage);
    }

    protected void jZ() {
        this.Ap = new k(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(Object obj) {
    }

    protected void ka() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.Ar = new q(handlerThread.getLooper(), this.Ap, this.As, this.AA);
    }

    protected void kb() {
        this.Aq = new o(this.Ap, this.As, this.AA, "WebSocketReader");
        this.Aq.start();
    }

    public boolean kd() {
        return this.AF != null;
    }

    public boolean jV() {
        return this.AC;
    }

    public boolean isOpen() {
        return this.AB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void jW() {
        if (this.Ar != null) {
            this.Ar.jW();
        }
    }

    public long getUpFlowSize() {
        if (this.Ar != null) {
            return this.Ar.getUpFlowSize();
        }
        return 0L;
    }

    public void jX() {
        if (this.Aq != null) {
            this.Aq.jX();
        }
    }

    public long getDownFlowSize() {
        if (this.Aq != null) {
            return this.Aq.getDownFlowSize();
        }
        return 0L;
    }

    public long ke() {
        if (this.As != null) {
            return this.As.jO();
        }
        return 0L;
    }

    public String kf() {
        if (this.As != null) {
            return this.As.jN();
        }
        return null;
    }

    public long kg() {
        return this.AE;
    }

    public String jx() {
        if (this.As != null) {
            return this.As.jx();
        }
        return null;
    }

    public String jy() {
        if (this.As != null) {
            return this.As.jy();
        }
        return null;
    }
}
