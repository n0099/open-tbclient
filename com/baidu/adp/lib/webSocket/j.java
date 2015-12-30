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
    private boolean Aa = false;
    private boolean Ab = false;
    private volatile boolean Ac = false;
    private long Ae = 0;
    private c Af = null;
    private List<BasicNameValuePair> zH;
    private String[] zI;
    protected Handler zO;
    protected volatile o zP;
    protected volatile q zQ;
    protected e.a zR;
    private URI zS;
    private String zT;
    private String zU;
    private int zV;
    private String zW;
    private String zX;
    private g.a zY;
    protected n zZ;

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
                j.this.zR = eVar.a(j.this.zU, j.this.zV, j.this.zZ, false);
                if (!j.this.Ac) {
                    try {
                        if (j.this.zR.isConnected()) {
                            j.this.Ae = System.currentTimeMillis() - currentTimeMillis;
                            j.this.jM();
                            j.this.jL();
                            m.b bVar = new m.b(String.valueOf(j.this.zU) + ":" + j.this.zV);
                            bVar.mPath = j.this.zW;
                            bVar.Aj = j.this.zX;
                            bVar.Al = j.this.zI;
                            bVar.Am = j.this.zH;
                            j.this.zQ.r(bVar);
                            if (j.this.Ac) {
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
        jK();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.Af != null || !isOpen()) {
            isDebug();
            if (cVar != null) {
                cVar.z(1);
                return false;
            }
            return false;
        }
        this.Af = cVar;
        return d(this.Af);
    }

    private boolean d(c cVar) {
        if (this.zQ == null) {
            o(new m.f(new Exception("mWriter = null")));
            return false;
        }
        return this.zQ.r(new m.i(cVar));
    }

    public void close(int i, String str) {
        this.Aa = false;
        this.Ac = true;
        if (this.zP != null) {
            this.zP.quit();
            this.zP = null;
        }
        if (this.zQ != null) {
            this.zQ.quit();
            this.zQ = null;
        }
        if (this.zR != null) {
            try {
                this.zR.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.zR = null;
        }
        g.a aVar = this.zY;
        this.zY = null;
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
        this.Ab = true;
        if (this.zR != null && this.zR.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.zS = new URI(str);
            if (!this.zS.getScheme().equals("ws") && !this.zS.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.zS.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.zT = this.zS.getScheme();
            if (this.zS.getPort() == -1) {
                if (this.zT.equals("ws")) {
                    this.zV = 80;
                } else {
                    this.zV = 443;
                }
            } else {
                this.zV = this.zS.getPort();
            }
            if (this.zS.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.zU = this.zS.getHost();
            if (this.zS.getPath() == null || this.zS.getPath().equals("")) {
                this.zW = "/";
            } else {
                this.zW = this.zS.getPath();
            }
            if (this.zS.getQuery() == null || this.zS.getQuery().equals("")) {
                this.zX = null;
            } else {
                this.zX = this.zS.getQuery();
            }
            this.zI = strArr;
            this.zH = list;
            this.zY = aVar;
            this.zZ = new n(nVar);
            new a(this, null).start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Object obj) {
        Message obtainMessage = this.zO.obtainMessage();
        obtainMessage.obj = obj;
        this.zO.sendMessage(obtainMessage);
    }

    protected void jK() {
        this.zO = new k(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(Object obj) {
    }

    protected void jL() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.zQ = new q(handlerThread.getLooper(), this.zO, this.zR, this.zZ);
    }

    protected void jM() {
        this.zP = new o(this.zO, this.zR, this.zZ, "WebSocketReader");
        this.zP.start();
    }

    public boolean jN() {
        return this.Af != null;
    }

    public boolean jG() {
        return this.Ab;
    }

    public boolean isOpen() {
        return this.Aa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void jH() {
        if (this.zQ != null) {
            this.zQ.jH();
        }
    }

    public long getUpFlowSize() {
        if (this.zQ != null) {
            return this.zQ.getUpFlowSize();
        }
        return 0L;
    }

    public void jI() {
        if (this.zP != null) {
            this.zP.jI();
        }
    }

    public long getDownFlowSize() {
        if (this.zP != null) {
            return this.zP.getDownFlowSize();
        }
        return 0L;
    }

    public long jO() {
        if (this.zR != null) {
            return this.zR.jz();
        }
        return 0L;
    }

    public String jP() {
        if (this.zR != null) {
            return this.zR.jy();
        }
        return null;
    }

    public long jQ() {
        return this.Ae;
    }

    public String ji() {
        if (this.zR != null) {
            return this.zR.ji();
        }
        return null;
    }

    public String jj() {
        if (this.zR != null) {
            return this.zR.jj();
        }
        return null;
    }
}
