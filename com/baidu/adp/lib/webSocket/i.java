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
    protected Handler zC;
    protected volatile m zD;
    protected volatile o zE;
    protected e.a zF;
    private URI zG;
    private String zH;
    private String zI;
    private int zJ;
    private String zK;
    private String zL;
    private g.a zM;
    protected l zN;
    private boolean zO = false;
    private boolean zP = false;
    private volatile boolean zQ = false;
    private long zR = 0;
    private c zS = null;
    private List<BasicNameValuePair> zv;
    private String[] zw;

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
                i.this.zF = eVar.a(i.this.zI, i.this.zJ, i.this.zN, false);
                if (i.this.zQ) {
                    i.this.q(new k.c());
                    return;
                }
                try {
                    if (!i.this.zF.isConnected()) {
                        i.this.q(new k.e(2, "cannot connect"));
                    } else {
                        i.this.zR = System.currentTimeMillis() - currentTimeMillis;
                        i.this.m5if();
                        i.this.ie();
                        k.b bVar = new k.b(i.this.zI + ":" + i.this.zJ);
                        bVar.mPath = i.this.zK;
                        bVar.zW = i.this.zL;
                        bVar.zY = i.this.zw;
                        bVar.zZ = i.this.zv;
                        i.this.zE.t(bVar);
                        if (i.this.zQ) {
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
        if (this.zS != null || !isOpen()) {
            if (hZ()) {
            }
            if (cVar != null) {
                cVar.L(1);
                return false;
            }
            return false;
        }
        this.zS = cVar;
        return d(this.zS);
    }

    private boolean d(c cVar) {
        if (this.zE == null) {
            q(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.zE.t(new k.i(cVar));
    }

    public void close(int i, String str) {
        this.zO = false;
        this.zQ = true;
        if (this.zD != null) {
            this.zD.quit();
            this.zD = null;
        }
        if (this.zE != null) {
            this.zE.quit();
            this.zE = null;
        }
        if (this.zF != null) {
            try {
                this.zF.close();
            } catch (Throwable th) {
                if (hZ()) {
                    th.printStackTrace();
                }
            }
            this.zF = null;
        }
        g.a aVar = this.zM;
        this.zM = null;
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
        this.zP = true;
        if (this.zF != null && this.zF.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.zG = new URI(str);
            if (!this.zG.getScheme().equals("ws") && !this.zG.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.zG.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.zH = this.zG.getScheme();
            if (this.zG.getPort() == -1) {
                if (this.zH.equals("ws")) {
                    this.zJ = 80;
                } else {
                    this.zJ = 443;
                }
            } else {
                this.zJ = this.zG.getPort();
            }
            if (this.zG.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.zI = this.zG.getHost();
            if (this.zG.getPath() == null || this.zG.getPath().equals("")) {
                this.zK = "/";
            } else {
                this.zK = this.zG.getPath();
            }
            if (this.zG.getQuery() == null || this.zG.getQuery().equals("")) {
                this.zL = null;
            } else {
                this.zL = this.zG.getQuery();
            }
            this.zw = strArr;
            this.zv = list;
            this.zM = aVar;
            this.zN = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(Object obj) {
        Message obtainMessage = this.zC.obtainMessage();
        obtainMessage.obj = obj;
        this.zC.sendMessage(obtainMessage);
    }

    protected void id() {
        this.zC = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.zM != null) {
                        i.this.zM.C(sVar.Ak);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.zM != null) {
                        i.this.zM.o(mVar.zU);
                    } else if (i.this.hZ()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.zM != null) {
                        i.this.zM.b(aVar);
                    } else if (i.this.hZ()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0008k c0008k = new k.C0008k();
                    c0008k.zU = ((k.j) message.obj).zU;
                    i.this.zE.t(c0008k);
                } else if (message.obj instanceof k.C0008k) {
                    k.C0008k c0008k2 = (k.C0008k) message.obj;
                    if (i.this.zM != null) {
                        i.this.zM.hT();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.Ai) {
                        if (i.this.zM != null) {
                            i.this.zM.e(qVar.Aj);
                            i.this.zO = true;
                            i.this.zP = false;
                            if (i.this.zM != null) {
                                i.this.zM.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).Ab;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).Ag;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).Ae.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.Ac + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).Ac);
                } else if (message.obj instanceof k.r) {
                    if (i.this.zM != null) {
                        i.this.zM.b(((k.r) message.obj).Ah);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.zS = null;
                    c cVar = ((k.g) message.obj).Ah;
                    if (i.this.zM != null) {
                        i.this.zM.c(cVar);
                    }
                    if (i.this.zM != null) {
                        i.this.zM.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.zS = null;
                    c cVar2 = ((k.n) message.obj).Ah;
                    if (i.this.zM != null) {
                        i.this.zM.a(2, cVar2);
                    }
                    if (i.this.zM != null) {
                        i.this.zM.a(cVar2);
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
        this.zE = new o(handlerThread.getLooper(), this.zC, this.zF, this.zN);
    }

    /* renamed from: if  reason: not valid java name */
    protected void m5if() {
        this.zD = new m(this.zC, this.zF, this.zN, "WebSocketReader");
        this.zD.start();
    }

    public boolean ig() {
        return this.zS != null;
    }

    public boolean hY() {
        return this.zP;
    }

    public boolean isOpen() {
        return this.zO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hZ() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void ia() {
        if (this.zE != null) {
            this.zE.ia();
        }
    }

    public long getUpFlowSize() {
        if (this.zE != null) {
            return this.zE.getUpFlowSize();
        }
        return 0L;
    }

    public void ib() {
        if (this.zD != null) {
            this.zD.ib();
        }
    }

    public long getDownFlowSize() {
        if (this.zD != null) {
            return this.zD.getDownFlowSize();
        }
        return 0L;
    }

    public long ih() {
        if (this.zF != null) {
            return this.zF.hR();
        }
        return 0L;
    }

    public String ii() {
        if (this.zF != null) {
            return this.zF.hQ();
        }
        return null;
    }

    public long ij() {
        return this.zR;
    }

    public String hz() {
        if (this.zF != null) {
            return this.zF.hz();
        }
        return null;
    }

    public String hA() {
        if (this.zF != null) {
            return this.zF.hA();
        }
        return null;
    }
}
