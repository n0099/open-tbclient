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
    private List<BasicNameValuePair> anI;
    private String[] anJ;
    protected Handler anP;
    protected volatile m anQ;
    protected volatile o anR;
    protected e.a anS;
    private URI anT;
    private String anU;
    private String anV;
    private int anW;
    private String anX;
    private String anY;
    private g.a anZ;
    protected l aoa;
    private boolean aob = false;
    private boolean aoc = false;
    private volatile boolean aod = false;
    private long aoe = 0;
    private c aof = null;

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
                i.this.anS = eVar.a(i.this.anV, i.this.anW, i.this.aoa, false);
                if (i.this.aod) {
                    i.this.av(new k.c());
                    return;
                }
                try {
                    if (!i.this.anS.isConnected()) {
                        i.this.av(new k.e(2, "cannot connect"));
                    } else {
                        i.this.aoe = System.currentTimeMillis() - currentTimeMillis;
                        i.this.pF();
                        i.this.pE();
                        k.b bVar = new k.b(i.this.anV + ":" + i.this.anW);
                        bVar.mPath = i.this.anX;
                        bVar.aoj = i.this.anY;
                        bVar.aol = i.this.anJ;
                        bVar.aom = i.this.anI;
                        i.this.anR.ay(bVar);
                        if (i.this.aod) {
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
        if (this.aof != null || !isOpen()) {
            if (pz()) {
            }
            if (cVar != null) {
                cVar.cF(1);
                return false;
            }
            return false;
        }
        this.aof = cVar;
        return d(this.aof);
    }

    private boolean d(c cVar) {
        if (this.anR == null) {
            av(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.anR.ay(new k.i(cVar));
    }

    public void close(int i, String str) {
        this.aob = false;
        this.aod = true;
        if (this.anQ != null) {
            this.anQ.quit();
            this.anQ = null;
        }
        if (this.anR != null) {
            this.anR.quit();
            this.anR = null;
        }
        if (this.anS != null) {
            try {
                this.anS.close();
            } catch (Throwable th) {
                if (pz()) {
                    th.printStackTrace();
                }
            }
            this.anS = null;
        }
        g.a aVar = this.anZ;
        this.anZ = null;
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
        this.aoc = true;
        if (this.anS != null && this.anS.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.anT = new URI(str);
            if (!this.anT.getScheme().equals("ws") && !this.anT.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.anT.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.anU = this.anT.getScheme();
            if (this.anT.getPort() == -1) {
                if (this.anU.equals("ws")) {
                    this.anW = 80;
                } else {
                    this.anW = 443;
                }
            } else {
                this.anW = this.anT.getPort();
            }
            if (this.anT.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.anV = this.anT.getHost();
            if (this.anT.getPath() == null || this.anT.getPath().equals("")) {
                this.anX = "/";
            } else {
                this.anX = this.anT.getPath();
            }
            if (this.anT.getQuery() == null || this.anT.getQuery().equals("")) {
                this.anY = null;
            } else {
                this.anY = this.anT.getQuery();
            }
            this.anJ = strArr;
            this.anI = list;
            this.anZ = aVar;
            this.aoa = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(Object obj) {
        Message obtainMessage = this.anP.obtainMessage();
        obtainMessage.obj = obj;
        this.anP.sendMessage(obtainMessage);
    }

    protected void pD() {
        this.anP = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.anZ != null) {
                        i.this.anZ.J(sVar.aow);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.anZ != null) {
                        i.this.anZ.o(mVar.aoh);
                    } else if (i.this.pz()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.anZ != null) {
                        i.this.anZ.b(aVar);
                    } else if (i.this.pz()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0021k c0021k = new k.C0021k();
                    c0021k.aoh = ((k.j) message.obj).aoh;
                    i.this.anR.ay(c0021k);
                } else if (message.obj instanceof k.C0021k) {
                    k.C0021k c0021k2 = (k.C0021k) message.obj;
                    if (i.this.anZ != null) {
                        i.this.anZ.pu();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.aou) {
                        if (i.this.anZ != null) {
                            i.this.anZ.e(qVar.aov);
                            i.this.aob = true;
                            i.this.aoc = false;
                            if (i.this.anZ != null) {
                                i.this.anZ.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).aoo;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).aos;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).aoq.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.aop + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).aop);
                } else if (message.obj instanceof k.r) {
                    if (i.this.anZ != null) {
                        i.this.anZ.b(((k.r) message.obj).aot);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.aof = null;
                    c cVar = ((k.g) message.obj).aot;
                    if (i.this.anZ != null) {
                        i.this.anZ.c(cVar);
                    }
                    if (i.this.anZ != null) {
                        i.this.anZ.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.aof = null;
                    c cVar2 = ((k.n) message.obj).aot;
                    if (i.this.anZ != null) {
                        i.this.anZ.a(2, cVar2);
                    }
                    if (i.this.anZ != null) {
                        i.this.anZ.a(cVar2);
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
        this.anR = new o(handlerThread.getLooper(), this.anP, this.anS, this.aoa);
    }

    protected void pF() {
        this.anQ = new m(this.anP, this.anS, this.aoa, "WebSocketReader");
        this.anQ.start();
    }

    public boolean pG() {
        return this.aof != null;
    }

    public boolean isConnecting() {
        return this.aoc;
    }

    public boolean isOpen() {
        return this.aob;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pz() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void pA() {
        if (this.anR != null) {
            this.anR.pA();
        }
    }

    public long getUpFlowSize() {
        if (this.anR != null) {
            return this.anR.getUpFlowSize();
        }
        return 0L;
    }

    public void pB() {
        if (this.anQ != null) {
            this.anQ.pB();
        }
    }

    public long getDownFlowSize() {
        if (this.anQ != null) {
            return this.anQ.getDownFlowSize();
        }
        return 0L;
    }

    public long pH() {
        if (this.anS != null) {
            return this.anS.ps();
        }
        return 0L;
    }

    public String pI() {
        if (this.anS != null) {
            return this.anS.pr();
        }
        return null;
    }

    public long pJ() {
        return this.aoe;
    }

    public String pb() {
        if (this.anS != null) {
            return this.anS.pb();
        }
        return null;
    }

    public String pc() {
        if (this.anS != null) {
            return this.anS.pc();
        }
        return null;
    }
}
