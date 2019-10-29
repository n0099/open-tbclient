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
    protected Handler sA;
    protected volatile m sB;
    protected volatile o sC;
    protected e.a sD;
    private URI sE;
    private String sF;
    private String sG;
    private int sH;
    private String sI;
    private String sJ;
    private g.a sK;
    protected l sL;
    private boolean sM = false;
    private boolean sN = false;
    private volatile boolean sO = false;
    private long sP = 0;
    private c sQ = null;
    private List<BasicNameValuePair> ss;
    private String[] su;

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
                i.this.sD = eVar.a(i.this.sG, i.this.sH, i.this.sL, false);
                if (i.this.sO) {
                    i.this.r(new k.c());
                    return;
                }
                try {
                    if (!i.this.sD.isConnected()) {
                        i.this.r(new k.e(2, "cannot connect"));
                    } else {
                        i.this.sP = System.currentTimeMillis() - currentTimeMillis;
                        i.this.hA();
                        i.this.hz();
                        k.b bVar = new k.b(i.this.sG + ":" + i.this.sH);
                        bVar.mPath = i.this.sI;
                        bVar.mQuery = i.this.sJ;
                        bVar.sV = i.this.su;
                        bVar.sW = i.this.ss;
                        i.this.sC.u(bVar);
                        if (i.this.sO) {
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
        hy();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.sQ != null || !isOpen()) {
            if (isDebug()) {
            }
            if (cVar != null) {
                cVar.onSendError(1);
                return false;
            }
            return false;
        }
        this.sQ = cVar;
        return d(this.sQ);
    }

    private boolean d(c cVar) {
        if (this.sC == null) {
            r(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.sC.u(new k.i(cVar));
    }

    public void close(int i, String str) {
        if (com.baidu.adp.lib.b.d.ft().af("need_more_logs") == 1) {
            com.baidu.adp.framework.client.socket.i.debug("more_log", 0, 0, "onClose", i, str);
        }
        this.sM = false;
        this.sO = true;
        if (this.sB != null) {
            this.sB.quit();
            this.sB = null;
        }
        if (this.sC != null) {
            this.sC.quit();
            this.sC = null;
        }
        if (this.sD != null) {
            try {
                this.sD.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.sD = null;
        }
        g.a aVar = this.sK;
        this.sK = null;
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
        this.sN = true;
        if (this.sD != null && this.sD.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.sE = new URI(str);
            if (!this.sE.getScheme().equals("ws") && !this.sE.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.sE.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.sF = this.sE.getScheme();
            if (this.sE.getPort() == -1) {
                if (this.sF.equals("ws")) {
                    this.sH = 80;
                } else {
                    this.sH = 443;
                }
            } else {
                this.sH = this.sE.getPort();
            }
            if (this.sE.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.sG = this.sE.getHost();
            if (this.sE.getPath() == null || this.sE.getPath().equals("")) {
                this.sI = "/";
            } else {
                this.sI = this.sE.getPath();
            }
            if (this.sE.getQuery() == null || this.sE.getQuery().equals("")) {
                this.sJ = null;
            } else {
                this.sJ = this.sE.getQuery();
            }
            this.su = strArr;
            this.ss = list;
            this.sK = aVar;
            this.sL = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Object obj) {
        Message obtainMessage = this.sA.obtainMessage();
        obtainMessage.obj = obj;
        this.sA.sendMessage(obtainMessage);
    }

    protected void hy() {
        this.sA = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.sK != null) {
                        i.this.sK.onTextMessage(sVar.th);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.sK != null) {
                        i.this.sK.i(mVar.sS);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.sK != null) {
                        i.this.sK.b(aVar);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0019k c0019k = new k.C0019k();
                    c0019k.sS = ((k.j) message.obj).sS;
                    i.this.sC.u(c0019k);
                } else if (message.obj instanceof k.C0019k) {
                    k.C0019k c0019k2 = (k.C0019k) message.obj;
                    if (i.this.sK != null) {
                        i.this.sK.hq();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.tf) {
                        if (i.this.sK != null) {
                            i.this.sK.onOpen(qVar.tg);
                            i.this.sM = true;
                            i.this.sN = false;
                            if (i.this.sK != null) {
                                i.this.sK.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).sY;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).td;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).tb.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.sZ + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).sZ);
                } else if (message.obj instanceof k.r) {
                    if (i.this.sK != null) {
                        i.this.sK.b(((k.r) message.obj).te);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.sQ = null;
                    c cVar = ((k.g) message.obj).te;
                    if (i.this.sK != null) {
                        i.this.sK.c(cVar);
                    }
                    if (i.this.sK != null) {
                        i.this.sK.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.sQ = null;
                    c cVar2 = ((k.n) message.obj).te;
                    if (i.this.sK != null) {
                        i.this.sK.a(2, cVar2);
                    }
                    if (i.this.sK != null) {
                        i.this.sK.a(cVar2);
                    }
                } else {
                    i.this.s(message.obj);
                }
            }
        };
    }

    protected void s(Object obj) {
    }

    protected void hz() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.sC = new o(handlerThread.getLooper(), this.sA, this.sD, this.sL);
    }

    protected void hA() {
        this.sB = new m(this.sA, this.sD, this.sL, "WebSocketReader");
        this.sB.start();
    }

    public boolean hB() {
        return this.sQ != null;
    }

    public boolean isConnecting() {
        return this.sN;
    }

    public boolean isOpen() {
        return this.sM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void hv() {
        if (this.sC != null) {
            this.sC.hv();
        }
    }

    public long getUpFlowSize() {
        if (this.sC != null) {
            return this.sC.getUpFlowSize();
        }
        return 0L;
    }

    public void hw() {
        if (this.sB != null) {
            this.sB.hw();
        }
    }

    public long getDownFlowSize() {
        if (this.sB != null) {
            return this.sB.getDownFlowSize();
        }
        return 0L;
    }

    public long hC() {
        if (this.sD != null) {
            return this.sD.ho();
        }
        return 0L;
    }

    public String hD() {
        if (this.sD != null) {
            return this.sD.hn();
        }
        return null;
    }

    public long hE() {
        return this.sP;
    }

    public String getLocalDns() {
        if (this.sD != null) {
            return this.sD.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.sD != null) {
            return this.sD.getLocalDnsBak();
        }
        return null;
    }
}
