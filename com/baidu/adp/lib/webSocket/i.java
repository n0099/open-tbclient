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
    private List<BasicNameValuePair> anC;
    private String[] anD;
    protected Handler anJ;
    protected volatile m anK;
    protected volatile o anL;
    protected e.a anM;
    private URI anN;
    private String anO;
    private String anP;
    private int anQ;
    private String anR;
    private String anS;
    private g.a anT;
    protected l anU;
    private boolean anV = false;
    private boolean anW = false;
    private volatile boolean anX = false;
    private long anY = 0;
    private c anZ = null;

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
                i.this.anM = eVar.a(i.this.anP, i.this.anQ, i.this.anU, false);
                if (i.this.anX) {
                    i.this.av(new k.c());
                    return;
                }
                try {
                    if (!i.this.anM.isConnected()) {
                        i.this.av(new k.e(2, "cannot connect"));
                    } else {
                        i.this.anY = System.currentTimeMillis() - currentTimeMillis;
                        i.this.pF();
                        i.this.pE();
                        k.b bVar = new k.b(i.this.anP + ":" + i.this.anQ);
                        bVar.mPath = i.this.anR;
                        bVar.aod = i.this.anS;
                        bVar.aof = i.this.anD;
                        bVar.aog = i.this.anC;
                        i.this.anL.ay(bVar);
                        if (i.this.anX) {
                            i.this.av(new k.c());
                        }
                    }
                } catch (Throwable th) {
                    if (i.this.pz()) {
                        BdLog.e("----WebSocketConnector error. e:" + th.getMessage());
                    }
                    i.this.av(new k.f(new Exception(th)));
                }
            } catch (Throwable th2) {
                i.this.av(new k.e(2, th2.getMessage()));
            }
        }
    }

    public i() {
        pD();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.anZ != null || !isOpen()) {
            if (pz()) {
            }
            if (cVar != null) {
                cVar.cF(1);
                return false;
            }
            return false;
        }
        this.anZ = cVar;
        return d(this.anZ);
    }

    private boolean d(c cVar) {
        if (this.anL == null) {
            av(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.anL.ay(new k.i(cVar));
    }

    public void close(int i, String str) {
        this.anV = false;
        this.anX = true;
        if (this.anK != null) {
            this.anK.quit();
            this.anK = null;
        }
        if (this.anL != null) {
            this.anL.quit();
            this.anL = null;
        }
        if (this.anM != null) {
            try {
                this.anM.close();
            } catch (Throwable th) {
                if (pz()) {
                    th.printStackTrace();
                }
            }
            this.anM = null;
        }
        g.a aVar = this.anT;
        this.anT = null;
        if (aVar != null) {
            try {
                aVar.e(i, str);
            } catch (Exception e) {
                if (pz()) {
                    BdLog.d(e.getMessage());
                }
            }
        }
    }

    public void a(String str, String[] strArr, g.a aVar, l lVar, List<BasicNameValuePair> list) throws WebSocketException {
        this.anW = true;
        if (this.anM != null && this.anM.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.anN = new URI(str);
            if (!this.anN.getScheme().equals("ws") && !this.anN.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.anN.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.anO = this.anN.getScheme();
            if (this.anN.getPort() == -1) {
                if (this.anO.equals("ws")) {
                    this.anQ = 80;
                } else {
                    this.anQ = 443;
                }
            } else {
                this.anQ = this.anN.getPort();
            }
            if (this.anN.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.anP = this.anN.getHost();
            if (this.anN.getPath() == null || this.anN.getPath().equals("")) {
                this.anR = "/";
            } else {
                this.anR = this.anN.getPath();
            }
            if (this.anN.getQuery() == null || this.anN.getQuery().equals("")) {
                this.anS = null;
            } else {
                this.anS = this.anN.getQuery();
            }
            this.anD = strArr;
            this.anC = list;
            this.anT = aVar;
            this.anU = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(Object obj) {
        Message obtainMessage = this.anJ.obtainMessage();
        obtainMessage.obj = obj;
        this.anJ.sendMessage(obtainMessage);
    }

    protected void pD() {
        this.anJ = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.anT != null) {
                        i.this.anT.J(sVar.aoq);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.anT != null) {
                        i.this.anT.o(mVar.aob);
                    } else if (i.this.pz()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.anT != null) {
                        i.this.anT.b(aVar);
                    } else if (i.this.pz()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0021k c0021k = new k.C0021k();
                    c0021k.aob = ((k.j) message.obj).aob;
                    i.this.anL.ay(c0021k);
                } else if (message.obj instanceof k.C0021k) {
                    k.C0021k c0021k2 = (k.C0021k) message.obj;
                    if (i.this.anT != null) {
                        i.this.anT.pu();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.aoo) {
                        if (i.this.anT != null) {
                            i.this.anT.e(qVar.aop);
                            i.this.anV = true;
                            i.this.anW = false;
                            if (i.this.anT != null) {
                                i.this.anT.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).aoi;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).aom;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).aok.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.aoj + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).aoj);
                } else if (message.obj instanceof k.r) {
                    if (i.this.anT != null) {
                        i.this.anT.b(((k.r) message.obj).aon);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.anZ = null;
                    c cVar = ((k.g) message.obj).aon;
                    if (i.this.anT != null) {
                        i.this.anT.c(cVar);
                    }
                    if (i.this.anT != null) {
                        i.this.anT.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.anZ = null;
                    c cVar2 = ((k.n) message.obj).aon;
                    if (i.this.anT != null) {
                        i.this.anT.a(2, cVar2);
                    }
                    if (i.this.anT != null) {
                        i.this.anT.a(cVar2);
                    }
                } else {
                    i.this.aw(message.obj);
                }
            }
        };
    }

    protected void aw(Object obj) {
    }

    protected void pE() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.anL = new o(handlerThread.getLooper(), this.anJ, this.anM, this.anU);
    }

    protected void pF() {
        this.anK = new m(this.anJ, this.anM, this.anU, "WebSocketReader");
        this.anK.start();
    }

    public boolean pG() {
        return this.anZ != null;
    }

    public boolean isConnecting() {
        return this.anW;
    }

    public boolean isOpen() {
        return this.anV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pz() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void pA() {
        if (this.anL != null) {
            this.anL.pA();
        }
    }

    public long getUpFlowSize() {
        if (this.anL != null) {
            return this.anL.getUpFlowSize();
        }
        return 0L;
    }

    public void pB() {
        if (this.anK != null) {
            this.anK.pB();
        }
    }

    public long getDownFlowSize() {
        if (this.anK != null) {
            return this.anK.getDownFlowSize();
        }
        return 0L;
    }

    public long pH() {
        if (this.anM != null) {
            return this.anM.ps();
        }
        return 0L;
    }

    public String pI() {
        if (this.anM != null) {
            return this.anM.pr();
        }
        return null;
    }

    public long pJ() {
        return this.anY;
    }

    public String pb() {
        if (this.anM != null) {
            return this.anM.pb();
        }
        return null;
    }

    public String pc() {
        if (this.anM != null) {
            return this.anM.pc();
        }
        return null;
    }
}
