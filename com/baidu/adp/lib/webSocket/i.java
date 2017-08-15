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
    private List<BasicNameValuePair> BC;
    private String[] BD;
    protected Handler BJ;
    protected volatile m BK;
    protected volatile o BL;
    protected e.a BM;
    private URI BN;
    private String BO;
    private String BP;
    private int BQ;
    private String BR;
    private String BS;
    private g.a BT;
    protected l BU;
    private boolean BV = false;
    private boolean BW = false;
    private volatile boolean BX = false;
    private long BY = 0;
    private c BZ = null;

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
                i.this.BM = eVar.a(i.this.BP, i.this.BQ, i.this.BU, false);
                if (i.this.BX) {
                    i.this.r(new k.c());
                    return;
                }
                try {
                    if (!i.this.BM.isConnected()) {
                        i.this.r(new k.e(2, "cannot connect"));
                    } else {
                        i.this.BY = System.currentTimeMillis() - currentTimeMillis;
                        i.this.io();
                        i.this.in();
                        k.b bVar = new k.b(i.this.BP + ":" + i.this.BQ);
                        bVar.mPath = i.this.BR;
                        bVar.Cd = i.this.BS;
                        bVar.Cf = i.this.BD;
                        bVar.Cg = i.this.BC;
                        i.this.BL.u(bVar);
                        if (i.this.BX) {
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
        if (this.BZ != null || !isOpen()) {
            if (isDebug()) {
            }
            if (cVar != null) {
                cVar.P(1);
                return false;
            }
            return false;
        }
        this.BZ = cVar;
        return d(this.BZ);
    }

    private boolean d(c cVar) {
        if (this.BL == null) {
            r(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.BL.u(new k.i(cVar));
    }

    public void close(int i, String str) {
        this.BV = false;
        this.BX = true;
        if (this.BK != null) {
            this.BK.quit();
            this.BK = null;
        }
        if (this.BL != null) {
            this.BL.quit();
            this.BL = null;
        }
        if (this.BM != null) {
            try {
                this.BM.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.BM = null;
        }
        g.a aVar = this.BT;
        this.BT = null;
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
        this.BW = true;
        if (this.BM != null && this.BM.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.BN = new URI(str);
            if (!this.BN.getScheme().equals("ws") && !this.BN.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.BN.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.BO = this.BN.getScheme();
            if (this.BN.getPort() == -1) {
                if (this.BO.equals("ws")) {
                    this.BQ = 80;
                } else {
                    this.BQ = 443;
                }
            } else {
                this.BQ = this.BN.getPort();
            }
            if (this.BN.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.BP = this.BN.getHost();
            if (this.BN.getPath() == null || this.BN.getPath().equals("")) {
                this.BR = "/";
            } else {
                this.BR = this.BN.getPath();
            }
            if (this.BN.getQuery() == null || this.BN.getQuery().equals("")) {
                this.BS = null;
            } else {
                this.BS = this.BN.getQuery();
            }
            this.BD = strArr;
            this.BC = list;
            this.BT = aVar;
            this.BU = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Object obj) {
        Message obtainMessage = this.BJ.obtainMessage();
        obtainMessage.obj = obj;
        this.BJ.sendMessage(obtainMessage);
    }

    protected void im() {
        this.BJ = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.BT != null) {
                        i.this.BT.I(sVar.Cq);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.BT != null) {
                        i.this.BT.u(mVar.Cb);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.BT != null) {
                        i.this.BT.b(aVar);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0008k c0008k = new k.C0008k();
                    c0008k.Cb = ((k.j) message.obj).Cb;
                    i.this.BL.u(c0008k);
                } else if (message.obj instanceof k.C0008k) {
                    k.C0008k c0008k2 = (k.C0008k) message.obj;
                    if (i.this.BT != null) {
                        i.this.BT.id();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.Co) {
                        if (i.this.BT != null) {
                            i.this.BT.f(qVar.Cp);
                            i.this.BV = true;
                            i.this.BW = false;
                            if (i.this.BT != null) {
                                i.this.BT.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).Ci;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).Cm;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).Ck.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.Cj + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).Cj);
                } else if (message.obj instanceof k.r) {
                    if (i.this.BT != null) {
                        i.this.BT.b(((k.r) message.obj).Cn);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.BZ = null;
                    c cVar = ((k.g) message.obj).Cn;
                    if (i.this.BT != null) {
                        i.this.BT.c(cVar);
                    }
                    if (i.this.BT != null) {
                        i.this.BT.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.BZ = null;
                    c cVar2 = ((k.n) message.obj).Cn;
                    if (i.this.BT != null) {
                        i.this.BT.a(2, cVar2);
                    }
                    if (i.this.BT != null) {
                        i.this.BT.a(cVar2);
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
        this.BL = new o(handlerThread.getLooper(), this.BJ, this.BM, this.BU);
    }

    protected void io() {
        this.BK = new m(this.BJ, this.BM, this.BU, "WebSocketReader");
        this.BK.start();
    }

    public boolean ip() {
        return this.BZ != null;
    }

    public boolean ii() {
        return this.BW;
    }

    public boolean isOpen() {
        return this.BV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void ij() {
        if (this.BL != null) {
            this.BL.ij();
        }
    }

    public long getUpFlowSize() {
        if (this.BL != null) {
            return this.BL.getUpFlowSize();
        }
        return 0L;
    }

    public void ik() {
        if (this.BK != null) {
            this.BK.ik();
        }
    }

    public long getDownFlowSize() {
        if (this.BK != null) {
            return this.BK.getDownFlowSize();
        }
        return 0L;
    }

    public long iq() {
        if (this.BM != null) {
            return this.BM.ib();
        }
        return 0L;
    }

    public String ir() {
        if (this.BM != null) {
            return this.BM.ia();
        }
        return null;
    }

    public long is() {
        return this.BY;
    }

    public String hJ() {
        if (this.BM != null) {
            return this.BM.hJ();
        }
        return null;
    }

    public String hK() {
        if (this.BM != null) {
            return this.BM.hK();
        }
        return null;
    }
}
