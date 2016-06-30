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
    protected Handler qB;
    protected volatile o qC;
    protected volatile q qD;
    protected e.a qE;
    private URI qF;
    private String qG;
    private String qH;
    private int qI;
    private String qJ;
    private String qK;
    private g.a qL;
    protected n qM;
    private boolean qN = false;
    private boolean qO = false;
    private volatile boolean qP = false;
    private long qQ = 0;
    private c qR = null;
    private List<BasicNameValuePair> qu;
    private String[] qv;

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
                j.this.qE = eVar.a(j.this.qH, j.this.qI, j.this.qM, false);
                if (!j.this.qP) {
                    try {
                        if (j.this.qE.isConnected()) {
                            j.this.qQ = System.currentTimeMillis() - currentTimeMillis;
                            j.this.gr();
                            j.this.gq();
                            m.b bVar = new m.b(String.valueOf(j.this.qH) + ":" + j.this.qI);
                            bVar.mPath = j.this.qJ;
                            bVar.qV = j.this.qK;
                            bVar.qX = j.this.qv;
                            bVar.qY = j.this.qu;
                            j.this.qD.r(bVar);
                            if (j.this.qP) {
                                j.this.o(new m.c());
                            }
                        } else {
                            j.this.o(new m.e(2, "cannot connect"));
                        }
                        return;
                    } catch (Throwable th) {
                        if (j.this.gl()) {
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
        gp();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.qR != null || !isOpen()) {
            gl();
            if (cVar != null) {
                cVar.x(1);
                return false;
            }
            return false;
        }
        this.qR = cVar;
        return d(this.qR);
    }

    private boolean d(c cVar) {
        if (this.qD == null) {
            o(new m.f(new Exception("mWriter = null")));
            return false;
        }
        return this.qD.r(new m.i(cVar));
    }

    public void close(int i, String str) {
        this.qN = false;
        this.qP = true;
        if (this.qC != null) {
            this.qC.quit();
            this.qC = null;
        }
        if (this.qD != null) {
            this.qD.quit();
            this.qD = null;
        }
        if (this.qE != null) {
            try {
                this.qE.close();
            } catch (Throwable th) {
                if (gl()) {
                    th.printStackTrace();
                }
            }
            this.qE = null;
        }
        g.a aVar = this.qL;
        this.qL = null;
        if (aVar != null) {
            try {
                aVar.e(i, str);
            } catch (Exception e) {
                if (gl()) {
                    BdLog.d(e.getMessage());
                }
            }
        }
    }

    public void a(String str, String[] strArr, g.a aVar, n nVar, List<BasicNameValuePair> list) {
        this.qO = true;
        if (this.qE != null && this.qE.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.qF = new URI(str);
            if (!this.qF.getScheme().equals("ws") && !this.qF.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.qF.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.qG = this.qF.getScheme();
            if (this.qF.getPort() == -1) {
                if (this.qG.equals("ws")) {
                    this.qI = 80;
                } else {
                    this.qI = 443;
                }
            } else {
                this.qI = this.qF.getPort();
            }
            if (this.qF.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.qH = this.qF.getHost();
            if (this.qF.getPath() == null || this.qF.getPath().equals("")) {
                this.qJ = "/";
            } else {
                this.qJ = this.qF.getPath();
            }
            if (this.qF.getQuery() == null || this.qF.getQuery().equals("")) {
                this.qK = null;
            } else {
                this.qK = this.qF.getQuery();
            }
            this.qv = strArr;
            this.qu = list;
            this.qL = aVar;
            this.qM = new n(nVar);
            new a(this, null).start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Object obj) {
        Message obtainMessage = this.qB.obtainMessage();
        obtainMessage.obj = obj;
        this.qB.sendMessage(obtainMessage);
    }

    protected void gp() {
        this.qB = new k(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(Object obj) {
    }

    protected void gq() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.qD = new q(handlerThread.getLooper(), this.qB, this.qE, this.qM);
    }

    protected void gr() {
        this.qC = new o(this.qB, this.qE, this.qM, "WebSocketReader");
        this.qC.start();
    }

    public boolean gs() {
        return this.qR != null;
    }

    public boolean gk() {
        return this.qO;
    }

    public boolean isOpen() {
        return this.qN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean gl() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void gm() {
        if (this.qD != null) {
            this.qD.gm();
        }
    }

    public long getUpFlowSize() {
        if (this.qD != null) {
            return this.qD.getUpFlowSize();
        }
        return 0L;
    }

    public void gn() {
        if (this.qC != null) {
            this.qC.gn();
        }
    }

    public long getDownFlowSize() {
        if (this.qC != null) {
            return this.qC.getDownFlowSize();
        }
        return 0L;
    }

    public long gt() {
        if (this.qE != null) {
            return this.qE.gd();
        }
        return 0L;
    }

    public String gu() {
        if (this.qE != null) {
            return this.qE.gb();
        }
        return null;
    }

    public long gv() {
        return this.qQ;
    }

    public String fJ() {
        if (this.qE != null) {
            return this.qE.fJ();
        }
        return null;
    }

    public String fK() {
        if (this.qE != null) {
            return this.qE.fK();
        }
        return null;
    }
}
