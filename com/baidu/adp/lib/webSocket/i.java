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
    protected Handler zE;
    protected volatile m zF;
    protected volatile o zG;
    protected e.a zH;
    private URI zI;
    private String zJ;
    private String zK;
    private int zL;
    private String zM;
    private String zN;
    private g.a zO;
    protected l zP;
    private boolean zQ = false;
    private boolean zR = false;
    private volatile boolean zS = false;
    private long zT = 0;
    private c zU = null;
    private List<BasicNameValuePair> zx;
    private String[] zy;

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
                i.this.zH = eVar.a(i.this.zK, i.this.zL, i.this.zP, false);
                if (i.this.zS) {
                    i.this.q(new k.c());
                    return;
                }
                try {
                    if (!i.this.zH.isConnected()) {
                        i.this.q(new k.e(2, "cannot connect"));
                    } else {
                        i.this.zT = System.currentTimeMillis() - currentTimeMillis;
                        i.this.m5if();
                        i.this.ie();
                        k.b bVar = new k.b(i.this.zK + ":" + i.this.zL);
                        bVar.mPath = i.this.zM;
                        bVar.zY = i.this.zN;
                        bVar.Aa = i.this.zy;
                        bVar.Ab = i.this.zx;
                        i.this.zG.t(bVar);
                        if (i.this.zS) {
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
        if (this.zU != null || !isOpen()) {
            if (hZ()) {
            }
            if (cVar != null) {
                cVar.M(1);
                return false;
            }
            return false;
        }
        this.zU = cVar;
        return d(this.zU);
    }

    private boolean d(c cVar) {
        if (this.zG == null) {
            q(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.zG.t(new k.i(cVar));
    }

    public void close(int i, String str) {
        this.zQ = false;
        this.zS = true;
        if (this.zF != null) {
            this.zF.quit();
            this.zF = null;
        }
        if (this.zG != null) {
            this.zG.quit();
            this.zG = null;
        }
        if (this.zH != null) {
            try {
                this.zH.close();
            } catch (Throwable th) {
                if (hZ()) {
                    th.printStackTrace();
                }
            }
            this.zH = null;
        }
        g.a aVar = this.zO;
        this.zO = null;
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
        this.zR = true;
        if (this.zH != null && this.zH.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.zI = new URI(str);
            if (!this.zI.getScheme().equals("ws") && !this.zI.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.zI.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.zJ = this.zI.getScheme();
            if (this.zI.getPort() == -1) {
                if (this.zJ.equals("ws")) {
                    this.zL = 80;
                } else {
                    this.zL = 443;
                }
            } else {
                this.zL = this.zI.getPort();
            }
            if (this.zI.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.zK = this.zI.getHost();
            if (this.zI.getPath() == null || this.zI.getPath().equals("")) {
                this.zM = "/";
            } else {
                this.zM = this.zI.getPath();
            }
            if (this.zI.getQuery() == null || this.zI.getQuery().equals("")) {
                this.zN = null;
            } else {
                this.zN = this.zI.getQuery();
            }
            this.zy = strArr;
            this.zx = list;
            this.zO = aVar;
            this.zP = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(Object obj) {
        Message obtainMessage = this.zE.obtainMessage();
        obtainMessage.obj = obj;
        this.zE.sendMessage(obtainMessage);
    }

    protected void id() {
        this.zE = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.zO != null) {
                        i.this.zO.C(sVar.Am);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.zO != null) {
                        i.this.zO.o(mVar.zW);
                    } else if (i.this.hZ()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.zO != null) {
                        i.this.zO.b(aVar);
                    } else if (i.this.hZ()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0008k c0008k = new k.C0008k();
                    c0008k.zW = ((k.j) message.obj).zW;
                    i.this.zG.t(c0008k);
                } else if (message.obj instanceof k.C0008k) {
                    k.C0008k c0008k2 = (k.C0008k) message.obj;
                    if (i.this.zO != null) {
                        i.this.zO.hT();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.Ak) {
                        if (i.this.zO != null) {
                            i.this.zO.e(qVar.Al);
                            i.this.zQ = true;
                            i.this.zR = false;
                            if (i.this.zO != null) {
                                i.this.zO.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).Ae;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).Ai;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).Ag.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.Af + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).Af);
                } else if (message.obj instanceof k.r) {
                    if (i.this.zO != null) {
                        i.this.zO.b(((k.r) message.obj).Aj);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.zU = null;
                    c cVar = ((k.g) message.obj).Aj;
                    if (i.this.zO != null) {
                        i.this.zO.c(cVar);
                    }
                    if (i.this.zO != null) {
                        i.this.zO.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.zU = null;
                    c cVar2 = ((k.n) message.obj).Aj;
                    if (i.this.zO != null) {
                        i.this.zO.a(2, cVar2);
                    }
                    if (i.this.zO != null) {
                        i.this.zO.a(cVar2);
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
        this.zG = new o(handlerThread.getLooper(), this.zE, this.zH, this.zP);
    }

    /* renamed from: if  reason: not valid java name */
    protected void m5if() {
        this.zF = new m(this.zE, this.zH, this.zP, "WebSocketReader");
        this.zF.start();
    }

    public boolean ig() {
        return this.zU != null;
    }

    public boolean hY() {
        return this.zR;
    }

    public boolean isOpen() {
        return this.zQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hZ() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void ia() {
        if (this.zG != null) {
            this.zG.ia();
        }
    }

    public long getUpFlowSize() {
        if (this.zG != null) {
            return this.zG.getUpFlowSize();
        }
        return 0L;
    }

    public void ib() {
        if (this.zF != null) {
            this.zF.ib();
        }
    }

    public long getDownFlowSize() {
        if (this.zF != null) {
            return this.zF.getDownFlowSize();
        }
        return 0L;
    }

    public long ih() {
        if (this.zH != null) {
            return this.zH.hR();
        }
        return 0L;
    }

    public String ii() {
        if (this.zH != null) {
            return this.zH.hQ();
        }
        return null;
    }

    public long ij() {
        return this.zT;
    }

    public String hz() {
        if (this.zH != null) {
            return this.zH.hz();
        }
        return null;
    }

    public String hA() {
        if (this.zH != null) {
            return this.zH.hA();
        }
        return null;
    }
}
