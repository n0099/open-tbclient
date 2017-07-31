package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.e;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.adp.lib.webSocket.k;
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class i implements g {
    private List<BasicNameValuePair> BA;
    private String[] BB;
    protected Handler BH;
    protected volatile m BI;
    protected volatile o BJ;
    protected e.a BK;
    private URI BL;
    private String BM;
    private String BN;
    private int BO;
    private String BP;
    private String BQ;
    private g.a BR;
    protected l BS;
    private boolean BT = false;
    private boolean BU = false;
    private volatile boolean BV = false;
    private long BW = 0;
    private c BX = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Thread {
        private a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Thread.currentThread().setName("WebSocketConnector");
            long currentTimeMillis = System.currentTimeMillis();
            try {
                e eVar = new e();
                i.this.BK = eVar.a(i.this.BN, i.this.BO, i.this.BS, false);
                if (i.this.BV) {
                    i.this.r(new k.c());
                    return;
                }
                try {
                    if (!i.this.BK.isConnected()) {
                        i.this.r(new k.e(2, "cannot connect"));
                    } else {
                        i.this.BW = System.currentTimeMillis() - currentTimeMillis;
                        i.this.io();
                        i.this.in();
                        k.b bVar = new k.b(i.this.BN + ":" + i.this.BO);
                        bVar.mPath = i.this.BP;
                        bVar.Cb = i.this.BQ;
                        bVar.Cd = i.this.BB;
                        bVar.Ce = i.this.BA;
                        i.this.BJ.u(bVar);
                        if (i.this.BV) {
                            i.this.r(new k.c());
                        }
                    }
                } catch (Throwable th) {
                    if (i.this.isDebug()) {
                        BdLog.e("----WebSocketConnector error. e:" + th.getMessage());
                    }
                    i.this.r(new k.f(new Exception(th)));
                }
            } catch (Throwable th2) {
                i.this.r(new k.e(2, th2.getMessage()));
            }
        }
    }

    public i() {
        im();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.BX != null || !isOpen()) {
            if (isDebug()) {
            }
            if (cVar != null) {
                cVar.P(1);
                return false;
            }
            return false;
        }
        this.BX = cVar;
        return d(this.BX);
    }

    private boolean d(c cVar) {
        if (this.BJ == null) {
            r(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.BJ.u(new k.i(cVar));
    }

    public void close(int i, String str) {
        this.BT = false;
        this.BV = true;
        if (this.BI != null) {
            this.BI.quit();
            this.BI = null;
        }
        if (this.BJ != null) {
            this.BJ.quit();
            this.BJ = null;
        }
        if (this.BK != null) {
            try {
                this.BK.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.BK = null;
        }
        g.a aVar = this.BR;
        this.BR = null;
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

    public void a(String str, String[] strArr, g.a aVar, l lVar, List<BasicNameValuePair> list) throws WebSocketException {
        this.BU = true;
        if (this.BK != null && this.BK.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.BL = new URI(str);
            if (!this.BL.getScheme().equals("ws") && !this.BL.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.BL.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.BM = this.BL.getScheme();
            if (this.BL.getPort() == -1) {
                if (this.BM.equals("ws")) {
                    this.BO = 80;
                } else {
                    this.BO = 443;
                }
            } else {
                this.BO = this.BL.getPort();
            }
            if (this.BL.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.BN = this.BL.getHost();
            if (this.BL.getPath() == null || this.BL.getPath().equals("")) {
                this.BP = "/";
            } else {
                this.BP = this.BL.getPath();
            }
            if (this.BL.getQuery() == null || this.BL.getQuery().equals("")) {
                this.BQ = null;
            } else {
                this.BQ = this.BL.getQuery();
            }
            this.BB = strArr;
            this.BA = list;
            this.BR = aVar;
            this.BS = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Object obj) {
        Message obtainMessage = this.BH.obtainMessage();
        obtainMessage.obj = obj;
        this.BH.sendMessage(obtainMessage);
    }

    protected void im() {
        this.BH = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.BR != null) {
                        i.this.BR.I(sVar.Co);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.BR != null) {
                        i.this.BR.u(mVar.BZ);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.BR != null) {
                        i.this.BR.b(aVar);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0009k c0009k = new k.C0009k();
                    c0009k.BZ = ((k.j) message.obj).BZ;
                    i.this.BJ.u(c0009k);
                } else if (message.obj instanceof k.C0009k) {
                    k.C0009k c0009k2 = (k.C0009k) message.obj;
                    if (i.this.BR != null) {
                        i.this.BR.id();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.Cm) {
                        if (i.this.BR != null) {
                            i.this.BR.f(qVar.Cn);
                            i.this.BT = true;
                            i.this.BU = false;
                            if (i.this.BR != null) {
                                i.this.BR.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).Cg;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).Ck;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).Ci.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.Ch + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).Ch);
                } else if (message.obj instanceof k.r) {
                    if (i.this.BR != null) {
                        i.this.BR.b(((k.r) message.obj).Cl);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.BX = null;
                    c cVar = ((k.g) message.obj).Cl;
                    if (i.this.BR != null) {
                        i.this.BR.c(cVar);
                    }
                    if (i.this.BR != null) {
                        i.this.BR.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.BX = null;
                    c cVar2 = ((k.n) message.obj).Cl;
                    if (i.this.BR != null) {
                        i.this.BR.a(2, cVar2);
                    }
                    if (i.this.BR != null) {
                        i.this.BR.a(cVar2);
                    }
                } else {
                    i.this.s(message.obj);
                }
            }
        };
    }

    protected void s(Object obj) {
    }

    protected void in() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.BJ = new o(handlerThread.getLooper(), this.BH, this.BK, this.BS);
    }

    protected void io() {
        this.BI = new m(this.BH, this.BK, this.BS, "WebSocketReader");
        this.BI.start();
    }

    public boolean ip() {
        return this.BX != null;
    }

    public boolean ii() {
        return this.BU;
    }

    public boolean isOpen() {
        return this.BT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void ij() {
        if (this.BJ != null) {
            this.BJ.ij();
        }
    }

    public long getUpFlowSize() {
        if (this.BJ != null) {
            return this.BJ.getUpFlowSize();
        }
        return 0L;
    }

    public void ik() {
        if (this.BI != null) {
            this.BI.ik();
        }
    }

    public long getDownFlowSize() {
        if (this.BI != null) {
            return this.BI.getDownFlowSize();
        }
        return 0L;
    }

    public long iq() {
        if (this.BK != null) {
            return this.BK.ib();
        }
        return 0L;
    }

    public String ir() {
        if (this.BK != null) {
            return this.BK.ia();
        }
        return null;
    }

    public long is() {
        return this.BW;
    }

    public String hJ() {
        if (this.BK != null) {
            return this.BK.hJ();
        }
        return null;
    }

    public String hK() {
        if (this.BK != null) {
            return this.BK.hK();
        }
        return null;
    }
}
