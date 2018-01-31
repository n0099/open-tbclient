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
    private List<BasicNameValuePair> anJ;
    private String[] anK;
    protected Handler anQ;
    protected volatile m anR;
    protected volatile o anS;
    protected e.a anT;
    private URI anU;
    private String anV;
    private String anW;
    private int anX;
    private String anY;
    private String anZ;
    private g.a aoa;
    protected l aob;
    private boolean aoc = false;
    private boolean aod = false;
    private volatile boolean aoe = false;
    private long aof = 0;
    private c aog = null;

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
                i.this.anT = eVar.a(i.this.anW, i.this.anX, i.this.aob, false);
                if (i.this.aoe) {
                    i.this.av(new k.c());
                    return;
                }
                try {
                    if (!i.this.anT.isConnected()) {
                        i.this.av(new k.e(2, "cannot connect"));
                    } else {
                        i.this.aof = System.currentTimeMillis() - currentTimeMillis;
                        i.this.pF();
                        i.this.pE();
                        k.b bVar = new k.b(i.this.anW + ":" + i.this.anX);
                        bVar.mPath = i.this.anY;
                        bVar.aok = i.this.anZ;
                        bVar.aom = i.this.anK;
                        bVar.aon = i.this.anJ;
                        i.this.anS.ay(bVar);
                        if (i.this.aoe) {
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
        if (this.aog != null || !isOpen()) {
            if (pz()) {
            }
            if (cVar != null) {
                cVar.cF(1);
                return false;
            }
            return false;
        }
        this.aog = cVar;
        return d(this.aog);
    }

    private boolean d(c cVar) {
        if (this.anS == null) {
            av(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.anS.ay(new k.i(cVar));
    }

    public void close(int i, String str) {
        this.aoc = false;
        this.aoe = true;
        if (this.anR != null) {
            this.anR.quit();
            this.anR = null;
        }
        if (this.anS != null) {
            this.anS.quit();
            this.anS = null;
        }
        if (this.anT != null) {
            try {
                this.anT.close();
            } catch (Throwable th) {
                if (pz()) {
                    th.printStackTrace();
                }
            }
            this.anT = null;
        }
        g.a aVar = this.aoa;
        this.aoa = null;
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
        this.aod = true;
        if (this.anT != null && this.anT.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.anU = new URI(str);
            if (!this.anU.getScheme().equals("ws") && !this.anU.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.anU.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.anV = this.anU.getScheme();
            if (this.anU.getPort() == -1) {
                if (this.anV.equals("ws")) {
                    this.anX = 80;
                } else {
                    this.anX = 443;
                }
            } else {
                this.anX = this.anU.getPort();
            }
            if (this.anU.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.anW = this.anU.getHost();
            if (this.anU.getPath() == null || this.anU.getPath().equals("")) {
                this.anY = "/";
            } else {
                this.anY = this.anU.getPath();
            }
            if (this.anU.getQuery() == null || this.anU.getQuery().equals("")) {
                this.anZ = null;
            } else {
                this.anZ = this.anU.getQuery();
            }
            this.anK = strArr;
            this.anJ = list;
            this.aoa = aVar;
            this.aob = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(Object obj) {
        Message obtainMessage = this.anQ.obtainMessage();
        obtainMessage.obj = obj;
        this.anQ.sendMessage(obtainMessage);
    }

    protected void pD() {
        this.anQ = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.aoa != null) {
                        i.this.aoa.J(sVar.aox);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.aoa != null) {
                        i.this.aoa.o(mVar.aoi);
                    } else if (i.this.pz()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.aoa != null) {
                        i.this.aoa.b(aVar);
                    } else if (i.this.pz()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0021k c0021k = new k.C0021k();
                    c0021k.aoi = ((k.j) message.obj).aoi;
                    i.this.anS.ay(c0021k);
                } else if (message.obj instanceof k.C0021k) {
                    k.C0021k c0021k2 = (k.C0021k) message.obj;
                    if (i.this.aoa != null) {
                        i.this.aoa.pu();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.aov) {
                        if (i.this.aoa != null) {
                            i.this.aoa.e(qVar.aow);
                            i.this.aoc = true;
                            i.this.aod = false;
                            if (i.this.aoa != null) {
                                i.this.aoa.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).aop;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).aot;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).aor.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.aoq + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).aoq);
                } else if (message.obj instanceof k.r) {
                    if (i.this.aoa != null) {
                        i.this.aoa.b(((k.r) message.obj).aou);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.aog = null;
                    c cVar = ((k.g) message.obj).aou;
                    if (i.this.aoa != null) {
                        i.this.aoa.c(cVar);
                    }
                    if (i.this.aoa != null) {
                        i.this.aoa.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.aog = null;
                    c cVar2 = ((k.n) message.obj).aou;
                    if (i.this.aoa != null) {
                        i.this.aoa.a(2, cVar2);
                    }
                    if (i.this.aoa != null) {
                        i.this.aoa.a(cVar2);
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
        this.anS = new o(handlerThread.getLooper(), this.anQ, this.anT, this.aob);
    }

    protected void pF() {
        this.anR = new m(this.anQ, this.anT, this.aob, "WebSocketReader");
        this.anR.start();
    }

    public boolean pG() {
        return this.aog != null;
    }

    public boolean isConnecting() {
        return this.aod;
    }

    public boolean isOpen() {
        return this.aoc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pz() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void pA() {
        if (this.anS != null) {
            this.anS.pA();
        }
    }

    public long getUpFlowSize() {
        if (this.anS != null) {
            return this.anS.getUpFlowSize();
        }
        return 0L;
    }

    public void pB() {
        if (this.anR != null) {
            this.anR.pB();
        }
    }

    public long getDownFlowSize() {
        if (this.anR != null) {
            return this.anR.getDownFlowSize();
        }
        return 0L;
    }

    public long pH() {
        if (this.anT != null) {
            return this.anT.ps();
        }
        return 0L;
    }

    public String pI() {
        if (this.anT != null) {
            return this.anT.pr();
        }
        return null;
    }

    public long pJ() {
        return this.aof;
    }

    public String pb() {
        if (this.anT != null) {
            return this.anT.pb();
        }
        return null;
    }

    public String pc() {
        if (this.anT != null) {
            return this.anT.pc();
        }
        return null;
    }
}
