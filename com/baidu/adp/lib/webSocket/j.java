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
    private List<BasicNameValuePair> zF;
    private String[] zG;
    protected Handler zM;
    protected volatile o zN;
    protected volatile q zO;
    protected e.a zP;
    private URI zQ;
    private String zR;
    private String zS;
    private int zT;
    private String zU;
    private String zV;
    private g.a zW;
    protected n zX;
    private boolean zY = false;
    private boolean zZ = false;
    private volatile boolean Aa = false;
    private long Ab = 0;
    private c Ac = null;

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
                j.this.zP = eVar.a(j.this.zS, j.this.zT, j.this.zX, false);
                if (!j.this.Aa) {
                    try {
                        if (j.this.zP.isConnected()) {
                            j.this.Ab = System.currentTimeMillis() - currentTimeMillis;
                            j.this.jL();
                            j.this.jK();
                            m.b bVar = new m.b(String.valueOf(j.this.zS) + ":" + j.this.zT);
                            bVar.mPath = j.this.zU;
                            bVar.Ah = j.this.zV;
                            bVar.Aj = j.this.zG;
                            bVar.Ak = j.this.zF;
                            j.this.zO.r(bVar);
                            if (j.this.Aa) {
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
        if (this.Ac != null || !isOpen()) {
            isDebug();
            if (cVar != null) {
                cVar.z(1);
                return false;
            }
            return false;
        }
        this.Ac = cVar;
        return d(this.Ac);
    }

    private boolean d(c cVar) {
        if (this.zO == null) {
            o(new m.f(new Exception("mWriter = null")));
            return false;
        }
        return this.zO.r(new m.i(cVar));
    }

    public void close(int i, String str) {
        this.zY = false;
        this.Aa = true;
        if (this.zN != null) {
            this.zN.quit();
            this.zN = null;
        }
        if (this.zO != null) {
            this.zO.quit();
            this.zO = null;
        }
        if (this.zP != null) {
            try {
                this.zP.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.zP = null;
        }
        g.a aVar = this.zW;
        this.zW = null;
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
        this.zZ = true;
        if (this.zP != null && this.zP.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.zQ = new URI(str);
            if (!this.zQ.getScheme().equals("ws") && !this.zQ.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.zQ.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.zR = this.zQ.getScheme();
            if (this.zQ.getPort() == -1) {
                if (this.zR.equals("ws")) {
                    this.zT = 80;
                } else {
                    this.zT = 443;
                }
            } else {
                this.zT = this.zQ.getPort();
            }
            if (this.zQ.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.zS = this.zQ.getHost();
            if (this.zQ.getPath() == null || this.zQ.getPath().equals("")) {
                this.zU = "/";
            } else {
                this.zU = this.zQ.getPath();
            }
            if (this.zQ.getQuery() == null || this.zQ.getQuery().equals("")) {
                this.zV = null;
            } else {
                this.zV = this.zQ.getQuery();
            }
            this.zG = strArr;
            this.zF = list;
            this.zW = aVar;
            this.zX = new n(nVar);
            new a(this, null).start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Object obj) {
        Message obtainMessage = this.zM.obtainMessage();
        obtainMessage.obj = obj;
        this.zM.sendMessage(obtainMessage);
    }

    protected void jJ() {
        this.zM = new k(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(Object obj) {
    }

    protected void jK() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.zO = new q(handlerThread.getLooper(), this.zM, this.zP, this.zX);
    }

    protected void jL() {
        this.zN = new o(this.zM, this.zP, this.zX, "WebSocketReader");
        this.zN.start();
    }

    public boolean jM() {
        return this.Ac != null;
    }

    public boolean jF() {
        return this.zZ;
    }

    public boolean isOpen() {
        return this.zY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void jG() {
        if (this.zO != null) {
            this.zO.jG();
        }
    }

    public long getUpFlowSize() {
        if (this.zO != null) {
            return this.zO.getUpFlowSize();
        }
        return 0L;
    }

    public void jH() {
        if (this.zN != null) {
            this.zN.jH();
        }
    }

    public long getDownFlowSize() {
        if (this.zN != null) {
            return this.zN.getDownFlowSize();
        }
        return 0L;
    }

    public long jN() {
        if (this.zP != null) {
            return this.zP.jy();
        }
        return 0L;
    }

    public String jO() {
        if (this.zP != null) {
            return this.zP.jx();
        }
        return null;
    }

    public long jP() {
        return this.Ab;
    }

    public String jh() {
        if (this.zP != null) {
            return this.zP.jh();
        }
        return null;
    }

    public String ji() {
        if (this.zP != null) {
            return this.zP.ji();
        }
        return null;
    }
}
