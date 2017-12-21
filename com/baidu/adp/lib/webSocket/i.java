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
    protected Handler zD;
    protected volatile m zE;
    protected volatile o zF;
    protected e.a zG;
    private URI zH;
    private String zI;
    private String zJ;
    private int zK;
    private String zL;
    private String zM;
    private g.a zN;
    protected l zO;
    private boolean zP = false;
    private boolean zQ = false;
    private volatile boolean zR = false;
    private long zS = 0;
    private c zT = null;
    private List<BasicNameValuePair> zw;
    private String[] zx;

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
                i.this.zG = eVar.a(i.this.zJ, i.this.zK, i.this.zO, false);
                if (i.this.zR) {
                    i.this.q(new k.c());
                    return;
                }
                try {
                    if (!i.this.zG.isConnected()) {
                        i.this.q(new k.e(2, "cannot connect"));
                    } else {
                        i.this.zS = System.currentTimeMillis() - currentTimeMillis;
                        i.this.m5if();
                        i.this.ie();
                        k.b bVar = new k.b(i.this.zJ + ":" + i.this.zK);
                        bVar.mPath = i.this.zL;
                        bVar.zX = i.this.zM;
                        bVar.zZ = i.this.zx;
                        bVar.Aa = i.this.zw;
                        i.this.zF.t(bVar);
                        if (i.this.zR) {
                            i.this.q(new k.c());
                        }
                    }
                } catch (Throwable th) {
                    if (i.this.hZ()) {
                        BdLog.e("----WebSocketConnector error. e:" + th.getMessage());
                    }
                    i.this.q(new k.f(new Exception(th)));
                }
            } catch (Throwable th2) {
                i.this.q(new k.e(2, th2.getMessage()));
            }
        }
    }

    public i() {
        id();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.zT != null || !isOpen()) {
            if (hZ()) {
            }
            if (cVar != null) {
                cVar.L(1);
                return false;
            }
            return false;
        }
        this.zT = cVar;
        return d(this.zT);
    }

    private boolean d(c cVar) {
        if (this.zF == null) {
            q(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.zF.t(new k.i(cVar));
    }

    public void close(int i, String str) {
        this.zP = false;
        this.zR = true;
        if (this.zE != null) {
            this.zE.quit();
            this.zE = null;
        }
        if (this.zF != null) {
            this.zF.quit();
            this.zF = null;
        }
        if (this.zG != null) {
            try {
                this.zG.close();
            } catch (Throwable th) {
                if (hZ()) {
                    th.printStackTrace();
                }
            }
            this.zG = null;
        }
        g.a aVar = this.zN;
        this.zN = null;
        if (aVar != null) {
            try {
                aVar.e(i, str);
            } catch (Exception e) {
                if (hZ()) {
                    BdLog.d(e.getMessage());
                }
            }
        }
    }

    public void a(String str, String[] strArr, g.a aVar, l lVar, List<BasicNameValuePair> list) throws WebSocketException {
        this.zQ = true;
        if (this.zG != null && this.zG.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.zH = new URI(str);
            if (!this.zH.getScheme().equals("ws") && !this.zH.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.zH.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.zI = this.zH.getScheme();
            if (this.zH.getPort() == -1) {
                if (this.zI.equals("ws")) {
                    this.zK = 80;
                } else {
                    this.zK = 443;
                }
            } else {
                this.zK = this.zH.getPort();
            }
            if (this.zH.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.zJ = this.zH.getHost();
            if (this.zH.getPath() == null || this.zH.getPath().equals("")) {
                this.zL = "/";
            } else {
                this.zL = this.zH.getPath();
            }
            if (this.zH.getQuery() == null || this.zH.getQuery().equals("")) {
                this.zM = null;
            } else {
                this.zM = this.zH.getQuery();
            }
            this.zx = strArr;
            this.zw = list;
            this.zN = aVar;
            this.zO = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(Object obj) {
        Message obtainMessage = this.zD.obtainMessage();
        obtainMessage.obj = obj;
        this.zD.sendMessage(obtainMessage);
    }

    protected void id() {
        this.zD = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.zN != null) {
                        i.this.zN.C(sVar.Al);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.zN != null) {
                        i.this.zN.o(mVar.zV);
                    } else if (i.this.hZ()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.zN != null) {
                        i.this.zN.b(aVar);
                    } else if (i.this.hZ()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0008k c0008k = new k.C0008k();
                    c0008k.zV = ((k.j) message.obj).zV;
                    i.this.zF.t(c0008k);
                } else if (message.obj instanceof k.C0008k) {
                    k.C0008k c0008k2 = (k.C0008k) message.obj;
                    if (i.this.zN != null) {
                        i.this.zN.hT();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.Aj) {
                        if (i.this.zN != null) {
                            i.this.zN.e(qVar.Ak);
                            i.this.zP = true;
                            i.this.zQ = false;
                            if (i.this.zN != null) {
                                i.this.zN.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).Ac;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).Ah;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).Af.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.Ae + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).Ae);
                } else if (message.obj instanceof k.r) {
                    if (i.this.zN != null) {
                        i.this.zN.b(((k.r) message.obj).Ai);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.zT = null;
                    c cVar = ((k.g) message.obj).Ai;
                    if (i.this.zN != null) {
                        i.this.zN.c(cVar);
                    }
                    if (i.this.zN != null) {
                        i.this.zN.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.zT = null;
                    c cVar2 = ((k.n) message.obj).Ai;
                    if (i.this.zN != null) {
                        i.this.zN.a(2, cVar2);
                    }
                    if (i.this.zN != null) {
                        i.this.zN.a(cVar2);
                    }
                } else {
                    i.this.r(message.obj);
                }
            }
        };
    }

    protected void r(Object obj) {
    }

    protected void ie() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.zF = new o(handlerThread.getLooper(), this.zD, this.zG, this.zO);
    }

    /* renamed from: if  reason: not valid java name */
    protected void m5if() {
        this.zE = new m(this.zD, this.zG, this.zO, "WebSocketReader");
        this.zE.start();
    }

    public boolean ig() {
        return this.zT != null;
    }

    public boolean hY() {
        return this.zQ;
    }

    public boolean isOpen() {
        return this.zP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hZ() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void ia() {
        if (this.zF != null) {
            this.zF.ia();
        }
    }

    public long getUpFlowSize() {
        if (this.zF != null) {
            return this.zF.getUpFlowSize();
        }
        return 0L;
    }

    public void ib() {
        if (this.zE != null) {
            this.zE.ib();
        }
    }

    public long getDownFlowSize() {
        if (this.zE != null) {
            return this.zE.getDownFlowSize();
        }
        return 0L;
    }

    public long ih() {
        if (this.zG != null) {
            return this.zG.hR();
        }
        return 0L;
    }

    public String ii() {
        if (this.zG != null) {
            return this.zG.hQ();
        }
        return null;
    }

    public long ij() {
        return this.zS;
    }

    public String hz() {
        if (this.zG != null) {
            return this.zG.hz();
        }
        return null;
    }

    public String hA() {
        if (this.zG != null) {
            return this.zG.hA();
        }
        return null;
    }
}
