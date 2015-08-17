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
    private List<BasicNameValuePair> zA;
    private String[] zB;
    protected Handler zH;
    protected volatile o zI;
    protected volatile q zJ;
    protected e.a zK;
    private URI zL;
    private String zM;
    private String zN;
    private int zO;
    private String zP;
    private String zQ;
    private g.a zR;
    protected n zS;
    private boolean zT = false;
    private boolean zU = false;
    private volatile boolean zV = false;
    private long zW = 0;
    private c zX = null;

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
                j.this.zK = eVar.a(j.this.zN, j.this.zO, j.this.zS, false);
                if (!j.this.zV) {
                    try {
                        if (j.this.zK.isConnected()) {
                            j.this.zW = System.currentTimeMillis() - currentTimeMillis;
                            j.this.jL();
                            j.this.jK();
                            m.b bVar = new m.b(String.valueOf(j.this.zN) + ":" + j.this.zO);
                            bVar.mPath = j.this.zP;
                            bVar.Ab = j.this.zQ;
                            bVar.Ae = j.this.zB;
                            bVar.Af = j.this.zA;
                            j.this.zJ.r(bVar);
                            if (j.this.zV) {
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
        jJ();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.zX != null || !isOpen()) {
            isDebug();
            if (cVar != null) {
                cVar.y(1);
                return false;
            }
            return false;
        }
        this.zX = cVar;
        return d(this.zX);
    }

    private boolean d(c cVar) {
        if (this.zJ == null) {
            o(new m.f(new Exception("mWriter = null")));
            return false;
        }
        return this.zJ.r(new m.i(cVar));
    }

    public void close(int i, String str) {
        this.zT = false;
        this.zV = true;
        if (this.zI != null) {
            this.zI.quit();
            this.zI = null;
        }
        if (this.zJ != null) {
            this.zJ.quit();
            this.zJ = null;
        }
        if (this.zK != null) {
            try {
                this.zK.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.zK = null;
        }
        g.a aVar = this.zR;
        this.zR = null;
        if (aVar != null) {
            try {
                aVar.l(i, str);
            } catch (Exception e) {
                if (isDebug()) {
                    BdLog.d(e.getMessage());
                }
            }
        }
    }

    public void a(String str, String[] strArr, g.a aVar, n nVar, List<BasicNameValuePair> list) {
        this.zU = true;
        if (this.zK != null && this.zK.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.zL = new URI(str);
            if (!this.zL.getScheme().equals("ws") && !this.zL.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.zL.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.zM = this.zL.getScheme();
            if (this.zL.getPort() == -1) {
                if (this.zM.equals("ws")) {
                    this.zO = 80;
                } else {
                    this.zO = 443;
                }
            } else {
                this.zO = this.zL.getPort();
            }
            if (this.zL.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.zN = this.zL.getHost();
            if (this.zL.getPath() == null || this.zL.getPath().equals("")) {
                this.zP = "/";
            } else {
                this.zP = this.zL.getPath();
            }
            if (this.zL.getQuery() == null || this.zL.getQuery().equals("")) {
                this.zQ = null;
            } else {
                this.zQ = this.zL.getQuery();
            }
            this.zB = strArr;
            this.zA = list;
            this.zR = aVar;
            this.zS = new n(nVar);
            new a(this, null).start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Object obj) {
        Message obtainMessage = this.zH.obtainMessage();
        obtainMessage.obj = obj;
        this.zH.sendMessage(obtainMessage);
    }

    protected void jJ() {
        this.zH = new k(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(Object obj) {
    }

    protected void jK() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.zJ = new q(handlerThread.getLooper(), this.zH, this.zK, this.zS);
    }

    protected void jL() {
        this.zI = new o(this.zH, this.zK, this.zS, "WebSocketReader");
        this.zI.start();
    }

    public boolean jM() {
        return this.zX != null;
    }

    public boolean jF() {
        return this.zU;
    }

    public boolean isOpen() {
        return this.zT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void jG() {
        if (this.zJ != null) {
            this.zJ.jG();
        }
    }

    public long getUpFlowSize() {
        if (this.zJ != null) {
            return this.zJ.getUpFlowSize();
        }
        return 0L;
    }

    public void jH() {
        if (this.zI != null) {
            this.zI.jH();
        }
    }

    public long getDownFlowSize() {
        if (this.zI != null) {
            return this.zI.getDownFlowSize();
        }
        return 0L;
    }

    public long jN() {
        if (this.zK != null) {
            return this.zK.jy();
        }
        return 0L;
    }

    public String jO() {
        if (this.zK != null) {
            return this.zK.jx();
        }
        return null;
    }

    public long jP() {
        return this.zW;
    }

    public String jg() {
        if (this.zK != null) {
            return this.zK.jg();
        }
        return null;
    }

    public String jh() {
        if (this.zK != null) {
            return this.zK.jh();
        }
        return null;
    }
}
