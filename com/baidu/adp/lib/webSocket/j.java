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
    protected Handler zF;
    protected volatile o zG;
    protected volatile q zH;
    protected e.a zI;
    private URI zJ;
    private String zK;
    private String zL;
    private int zM;
    private String zN;
    private String zO;
    private g.a zP;
    protected n zQ;
    private boolean zR = false;
    private boolean zS = false;
    private volatile boolean zT = false;
    private long zU = 0;
    private c zV = null;
    private List<BasicNameValuePair> zy;
    private String[] zz;

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
                j.this.zI = eVar.a(j.this.zL, j.this.zM, j.this.zQ, false);
                if (!j.this.zT) {
                    try {
                        if (j.this.zI.isConnected()) {
                            j.this.zU = System.currentTimeMillis() - currentTimeMillis;
                            j.this.jI();
                            j.this.jH();
                            m.b bVar = new m.b(String.valueOf(j.this.zL) + ":" + j.this.zM);
                            bVar.mPath = j.this.zN;
                            bVar.zZ = j.this.zO;
                            bVar.Ab = j.this.zz;
                            bVar.Ac = j.this.zy;
                            j.this.zH.r(bVar);
                            if (j.this.zT) {
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
        jG();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.zV != null || !isOpen()) {
            isDebug();
            if (cVar != null) {
                cVar.y(1);
                return false;
            }
            return false;
        }
        this.zV = cVar;
        return d(this.zV);
    }

    private boolean d(c cVar) {
        if (this.zH == null) {
            o(new m.f(new Exception("mWriter = null")));
            return false;
        }
        return this.zH.r(new m.i(cVar));
    }

    public void close(int i, String str) {
        this.zR = false;
        this.zT = true;
        if (this.zG != null) {
            this.zG.quit();
            this.zG = null;
        }
        if (this.zH != null) {
            this.zH.quit();
            this.zH = null;
        }
        if (this.zI != null) {
            try {
                this.zI.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.zI = null;
        }
        g.a aVar = this.zP;
        this.zP = null;
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
        this.zS = true;
        if (this.zI != null && this.zI.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.zJ = new URI(str);
            if (!this.zJ.getScheme().equals("ws") && !this.zJ.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.zJ.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.zK = this.zJ.getScheme();
            if (this.zJ.getPort() == -1) {
                if (this.zK.equals("ws")) {
                    this.zM = 80;
                } else {
                    this.zM = 443;
                }
            } else {
                this.zM = this.zJ.getPort();
            }
            if (this.zJ.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.zL = this.zJ.getHost();
            if (this.zJ.getPath() == null || this.zJ.getPath().equals("")) {
                this.zN = "/";
            } else {
                this.zN = this.zJ.getPath();
            }
            if (this.zJ.getQuery() == null || this.zJ.getQuery().equals("")) {
                this.zO = null;
            } else {
                this.zO = this.zJ.getQuery();
            }
            this.zz = strArr;
            this.zy = list;
            this.zP = aVar;
            this.zQ = new n(nVar);
            new a(this, null).start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Object obj) {
        Message obtainMessage = this.zF.obtainMessage();
        obtainMessage.obj = obj;
        this.zF.sendMessage(obtainMessage);
    }

    protected void jG() {
        this.zF = new k(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(Object obj) {
    }

    protected void jH() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.zH = new q(handlerThread.getLooper(), this.zF, this.zI, this.zQ);
    }

    protected void jI() {
        this.zG = new o(this.zF, this.zI, this.zQ, "WebSocketReader");
        this.zG.start();
    }

    public boolean jJ() {
        return this.zV != null;
    }

    public boolean jC() {
        return this.zS;
    }

    public boolean isOpen() {
        return this.zR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void jD() {
        if (this.zH != null) {
            this.zH.jD();
        }
    }

    public long getUpFlowSize() {
        if (this.zH != null) {
            return this.zH.getUpFlowSize();
        }
        return 0L;
    }

    public void jE() {
        if (this.zG != null) {
            this.zG.jE();
        }
    }

    public long getDownFlowSize() {
        if (this.zG != null) {
            return this.zG.getDownFlowSize();
        }
        return 0L;
    }

    public long jK() {
        if (this.zI != null) {
            return this.zI.jv();
        }
        return 0L;
    }

    public String jL() {
        if (this.zI != null) {
            return this.zI.ju();
        }
        return null;
    }

    public long jM() {
        return this.zU;
    }

    public String jd() {
        if (this.zI != null) {
            return this.zI.jd();
        }
        return null;
    }

    public String je() {
        if (this.zI != null) {
            return this.zI.je();
        }
        return null;
    }
}
