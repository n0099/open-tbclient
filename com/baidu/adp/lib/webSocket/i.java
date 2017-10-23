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
    protected Handler zF;
    protected volatile m zG;
    protected volatile o zH;
    protected e.a zI;
    private URI zJ;
    private String zK;
    private String zL;
    private int zM;
    private String zN;
    private String zO;
    private g.a zP;
    protected l zQ;
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

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Thread.currentThread().setName("WebSocketConnector");
            long currentTimeMillis = System.currentTimeMillis();
            try {
                e eVar = new e();
                i.this.zI = eVar.a(i.this.zL, i.this.zM, i.this.zQ, false);
                if (i.this.zT) {
                    i.this.q(new k.c());
                    return;
                }
                try {
                    if (!i.this.zI.isConnected()) {
                        i.this.q(new k.e(2, "cannot connect"));
                    } else {
                        i.this.zU = System.currentTimeMillis() - currentTimeMillis;
                        i.this.m5if();
                        i.this.ie();
                        k.b bVar = new k.b(i.this.zL + ":" + i.this.zM);
                        bVar.mPath = i.this.zN;
                        bVar.zZ = i.this.zO;
                        bVar.Ab = i.this.zz;
                        bVar.Ac = i.this.zy;
                        i.this.zH.t(bVar);
                        if (i.this.zT) {
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
        if (this.zV != null || !isOpen()) {
            if (hZ()) {
            }
            if (cVar != null) {
                cVar.M(1);
                return false;
            }
            return false;
        }
        this.zV = cVar;
        return d(this.zV);
    }

    private boolean d(c cVar) {
        if (this.zH == null) {
            q(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.zH.t(new k.i(cVar));
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
                if (hZ()) {
                    th.printStackTrace();
                }
            }
            this.zI = null;
        }
        g.a aVar = this.zP;
        this.zP = null;
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
            this.zQ = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(Object obj) {
        Message obtainMessage = this.zF.obtainMessage();
        obtainMessage.obj = obj;
        this.zF.sendMessage(obtainMessage);
    }

    protected void id() {
        this.zF = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.zP != null) {
                        i.this.zP.C(sVar.An);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.zP != null) {
                        i.this.zP.o(mVar.zX);
                    } else if (i.this.hZ()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.zP != null) {
                        i.this.zP.b(aVar);
                    } else if (i.this.hZ()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0008k c0008k = new k.C0008k();
                    c0008k.zX = ((k.j) message.obj).zX;
                    i.this.zH.t(c0008k);
                } else if (message.obj instanceof k.C0008k) {
                    k.C0008k c0008k2 = (k.C0008k) message.obj;
                    if (i.this.zP != null) {
                        i.this.zP.hT();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.Al) {
                        if (i.this.zP != null) {
                            i.this.zP.e(qVar.Am);
                            i.this.zR = true;
                            i.this.zS = false;
                            if (i.this.zP != null) {
                                i.this.zP.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).Af;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).Aj;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).Ah.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.Ag + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).Ag);
                } else if (message.obj instanceof k.r) {
                    if (i.this.zP != null) {
                        i.this.zP.b(((k.r) message.obj).Ak);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.zV = null;
                    c cVar = ((k.g) message.obj).Ak;
                    if (i.this.zP != null) {
                        i.this.zP.c(cVar);
                    }
                    if (i.this.zP != null) {
                        i.this.zP.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.zV = null;
                    c cVar2 = ((k.n) message.obj).Ak;
                    if (i.this.zP != null) {
                        i.this.zP.a(2, cVar2);
                    }
                    if (i.this.zP != null) {
                        i.this.zP.a(cVar2);
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
        this.zH = new o(handlerThread.getLooper(), this.zF, this.zI, this.zQ);
    }

    /* renamed from: if  reason: not valid java name */
    protected void m5if() {
        this.zG = new m(this.zF, this.zI, this.zQ, "WebSocketReader");
        this.zG.start();
    }

    public boolean ig() {
        return this.zV != null;
    }

    public boolean hY() {
        return this.zS;
    }

    public boolean isOpen() {
        return this.zR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hZ() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void ia() {
        if (this.zH != null) {
            this.zH.ia();
        }
    }

    public long getUpFlowSize() {
        if (this.zH != null) {
            return this.zH.getUpFlowSize();
        }
        return 0L;
    }

    public void ib() {
        if (this.zG != null) {
            this.zG.ib();
        }
    }

    public long getDownFlowSize() {
        if (this.zG != null) {
            return this.zG.getDownFlowSize();
        }
        return 0L;
    }

    public long ih() {
        if (this.zI != null) {
            return this.zI.hR();
        }
        return 0L;
    }

    public String ii() {
        if (this.zI != null) {
            return this.zI.hQ();
        }
        return null;
    }

    public long ij() {
        return this.zU;
    }

    public String hz() {
        if (this.zI != null) {
            return this.zI.hz();
        }
        return null;
    }

    public String hA() {
        if (this.zI != null) {
            return this.zI.hA();
        }
        return null;
    }
}
