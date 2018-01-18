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
    private List<BasicNameValuePair> anG;
    private String[] anH;
    protected Handler anN;
    protected volatile m anO;
    protected volatile o anP;
    protected e.a anQ;
    private URI anR;
    private String anS;
    private String anT;
    private int anU;
    private String anV;
    private String anW;
    private g.a anX;
    protected l anY;
    private boolean anZ = false;
    private boolean aoa = false;
    private volatile boolean aob = false;
    private long aoc = 0;
    private c aod = null;

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
                i.this.anQ = eVar.a(i.this.anT, i.this.anU, i.this.anY, false);
                if (i.this.aob) {
                    i.this.av(new k.c());
                    return;
                }
                try {
                    if (!i.this.anQ.isConnected()) {
                        i.this.av(new k.e(2, "cannot connect"));
                    } else {
                        i.this.aoc = System.currentTimeMillis() - currentTimeMillis;
                        i.this.pE();
                        i.this.pD();
                        k.b bVar = new k.b(i.this.anT + ":" + i.this.anU);
                        bVar.mPath = i.this.anV;
                        bVar.aoh = i.this.anW;
                        bVar.aoj = i.this.anH;
                        bVar.aok = i.this.anG;
                        i.this.anP.ay(bVar);
                        if (i.this.aob) {
                            i.this.av(new k.c());
                        }
                    }
                } catch (Throwable th) {
                    if (i.this.py()) {
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
        pC();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.aod != null || !isOpen()) {
            if (py()) {
            }
            if (cVar != null) {
                cVar.cF(1);
                return false;
            }
            return false;
        }
        this.aod = cVar;
        return d(this.aod);
    }

    private boolean d(c cVar) {
        if (this.anP == null) {
            av(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.anP.ay(new k.i(cVar));
    }

    public void close(int i, String str) {
        this.anZ = false;
        this.aob = true;
        if (this.anO != null) {
            this.anO.quit();
            this.anO = null;
        }
        if (this.anP != null) {
            this.anP.quit();
            this.anP = null;
        }
        if (this.anQ != null) {
            try {
                this.anQ.close();
            } catch (Throwable th) {
                if (py()) {
                    th.printStackTrace();
                }
            }
            this.anQ = null;
        }
        g.a aVar = this.anX;
        this.anX = null;
        if (aVar != null) {
            try {
                aVar.e(i, str);
            } catch (Exception e) {
                if (py()) {
                    BdLog.d(e.getMessage());
                }
            }
        }
    }

    public void a(String str, String[] strArr, g.a aVar, l lVar, List<BasicNameValuePair> list) throws WebSocketException {
        this.aoa = true;
        if (this.anQ != null && this.anQ.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.anR = new URI(str);
            if (!this.anR.getScheme().equals("ws") && !this.anR.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.anR.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.anS = this.anR.getScheme();
            if (this.anR.getPort() == -1) {
                if (this.anS.equals("ws")) {
                    this.anU = 80;
                } else {
                    this.anU = 443;
                }
            } else {
                this.anU = this.anR.getPort();
            }
            if (this.anR.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.anT = this.anR.getHost();
            if (this.anR.getPath() == null || this.anR.getPath().equals("")) {
                this.anV = "/";
            } else {
                this.anV = this.anR.getPath();
            }
            if (this.anR.getQuery() == null || this.anR.getQuery().equals("")) {
                this.anW = null;
            } else {
                this.anW = this.anR.getQuery();
            }
            this.anH = strArr;
            this.anG = list;
            this.anX = aVar;
            this.anY = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(Object obj) {
        Message obtainMessage = this.anN.obtainMessage();
        obtainMessage.obj = obj;
        this.anN.sendMessage(obtainMessage);
    }

    protected void pC() {
        this.anN = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.anX != null) {
                        i.this.anX.J(sVar.aou);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.anX != null) {
                        i.this.anX.o(mVar.aof);
                    } else if (i.this.py()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.anX != null) {
                        i.this.anX.b(aVar);
                    } else if (i.this.py()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0021k c0021k = new k.C0021k();
                    c0021k.aof = ((k.j) message.obj).aof;
                    i.this.anP.ay(c0021k);
                } else if (message.obj instanceof k.C0021k) {
                    k.C0021k c0021k2 = (k.C0021k) message.obj;
                    if (i.this.anX != null) {
                        i.this.anX.pt();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.aos) {
                        if (i.this.anX != null) {
                            i.this.anX.e(qVar.aot);
                            i.this.anZ = true;
                            i.this.aoa = false;
                            if (i.this.anX != null) {
                                i.this.anX.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).aom;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).aoq;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).aoo.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.aon + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).aon);
                } else if (message.obj instanceof k.r) {
                    if (i.this.anX != null) {
                        i.this.anX.b(((k.r) message.obj).aor);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.aod = null;
                    c cVar = ((k.g) message.obj).aor;
                    if (i.this.anX != null) {
                        i.this.anX.c(cVar);
                    }
                    if (i.this.anX != null) {
                        i.this.anX.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.aod = null;
                    c cVar2 = ((k.n) message.obj).aor;
                    if (i.this.anX != null) {
                        i.this.anX.a(2, cVar2);
                    }
                    if (i.this.anX != null) {
                        i.this.anX.a(cVar2);
                    }
                } else {
                    i.this.aw(message.obj);
                }
            }
        };
    }

    protected void aw(Object obj) {
    }

    protected void pD() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.anP = new o(handlerThread.getLooper(), this.anN, this.anQ, this.anY);
    }

    protected void pE() {
        this.anO = new m(this.anN, this.anQ, this.anY, "WebSocketReader");
        this.anO.start();
    }

    public boolean pF() {
        return this.aod != null;
    }

    public boolean isConnecting() {
        return this.aoa;
    }

    public boolean isOpen() {
        return this.anZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean py() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void pz() {
        if (this.anP != null) {
            this.anP.pz();
        }
    }

    public long getUpFlowSize() {
        if (this.anP != null) {
            return this.anP.getUpFlowSize();
        }
        return 0L;
    }

    public void pA() {
        if (this.anO != null) {
            this.anO.pA();
        }
    }

    public long getDownFlowSize() {
        if (this.anO != null) {
            return this.anO.getDownFlowSize();
        }
        return 0L;
    }

    public long pG() {
        if (this.anQ != null) {
            return this.anQ.pr();
        }
        return 0L;
    }

    public String pH() {
        if (this.anQ != null) {
            return this.anQ.pq();
        }
        return null;
    }

    public long pI() {
        return this.aoc;
    }

    public String pa() {
        if (this.anQ != null) {
            return this.anQ.pa();
        }
        return null;
    }

    public String pb() {
        if (this.anQ != null) {
            return this.anQ.pb();
        }
        return null;
    }
}
