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
    private String[] zA;
    protected Handler zG;
    protected volatile o zH;
    protected volatile q zI;
    protected e.a zJ;
    private URI zK;
    private String zL;
    private String zM;
    private int zN;
    private String zO;
    private String zP;
    private g.a zQ;
    protected n zR;
    private boolean zS = false;
    private boolean zT = false;
    private volatile boolean zU = false;
    private long zV = 0;
    private c zW = null;
    private List<BasicNameValuePair> zz;

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
                j.this.zJ = eVar.a(j.this.zM, j.this.zN, j.this.zR, false);
                if (!j.this.zU) {
                    try {
                        if (j.this.zJ.isConnected()) {
                            j.this.zV = System.currentTimeMillis() - currentTimeMillis;
                            j.this.jJ();
                            j.this.jI();
                            m.b bVar = new m.b(String.valueOf(j.this.zM) + ":" + j.this.zN);
                            bVar.mPath = j.this.zO;
                            bVar.Aa = j.this.zP;
                            bVar.Ac = j.this.zA;
                            bVar.Ae = j.this.zz;
                            j.this.zI.r(bVar);
                            if (j.this.zU) {
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
        jH();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.zW != null || !isOpen()) {
            isDebug();
            if (cVar != null) {
                cVar.y(1);
                return false;
            }
            return false;
        }
        this.zW = cVar;
        return d(this.zW);
    }

    private boolean d(c cVar) {
        if (this.zI == null) {
            o(new m.f(new Exception("mWriter = null")));
            return false;
        }
        return this.zI.r(new m.i(cVar));
    }

    public void close(int i, String str) {
        this.zS = false;
        this.zU = true;
        if (this.zH != null) {
            this.zH.quit();
            this.zH = null;
        }
        if (this.zI != null) {
            this.zI.quit();
            this.zI = null;
        }
        if (this.zJ != null) {
            try {
                this.zJ.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.zJ = null;
        }
        g.a aVar = this.zQ;
        this.zQ = null;
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
        this.zT = true;
        if (this.zJ != null && this.zJ.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.zK = new URI(str);
            if (!this.zK.getScheme().equals("ws") && !this.zK.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.zK.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.zL = this.zK.getScheme();
            if (this.zK.getPort() == -1) {
                if (this.zL.equals("ws")) {
                    this.zN = 80;
                } else {
                    this.zN = 443;
                }
            } else {
                this.zN = this.zK.getPort();
            }
            if (this.zK.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.zM = this.zK.getHost();
            if (this.zK.getPath() == null || this.zK.getPath().equals("")) {
                this.zO = "/";
            } else {
                this.zO = this.zK.getPath();
            }
            if (this.zK.getQuery() == null || this.zK.getQuery().equals("")) {
                this.zP = null;
            } else {
                this.zP = this.zK.getQuery();
            }
            this.zA = strArr;
            this.zz = list;
            this.zQ = aVar;
            this.zR = new n(nVar);
            new a(this, null).start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Object obj) {
        Message obtainMessage = this.zG.obtainMessage();
        obtainMessage.obj = obj;
        this.zG.sendMessage(obtainMessage);
    }

    protected void jH() {
        this.zG = new k(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(Object obj) {
    }

    protected void jI() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.zI = new q(handlerThread.getLooper(), this.zG, this.zJ, this.zR);
    }

    protected void jJ() {
        this.zH = new o(this.zG, this.zJ, this.zR, "WebSocketReader");
        this.zH.start();
    }

    public boolean jK() {
        return this.zW != null;
    }

    public boolean jD() {
        return this.zT;
    }

    public boolean isOpen() {
        return this.zS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void jE() {
        if (this.zI != null) {
            this.zI.jE();
        }
    }

    public long getUpFlowSize() {
        if (this.zI != null) {
            return this.zI.getUpFlowSize();
        }
        return 0L;
    }

    public void jF() {
        if (this.zH != null) {
            this.zH.jF();
        }
    }

    public long getDownFlowSize() {
        if (this.zH != null) {
            return this.zH.getDownFlowSize();
        }
        return 0L;
    }

    public long jL() {
        if (this.zJ != null) {
            return this.zJ.jw();
        }
        return 0L;
    }

    public String jM() {
        if (this.zJ != null) {
            return this.zJ.jv();
        }
        return null;
    }

    public long jN() {
        return this.zV;
    }

    public String je() {
        if (this.zJ != null) {
            return this.zJ.je();
        }
        return null;
    }

    public String jf() {
        if (this.zJ != null) {
            return this.zJ.jf();
        }
        return null;
    }
}
