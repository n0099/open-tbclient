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
    private List<BasicNameValuePair> anH;
    private String[] anI;
    protected Handler anO;
    protected volatile m anP;
    protected volatile o anQ;
    protected e.a anR;
    private URI anS;
    private String anT;
    private String anU;
    private int anV;
    private String anW;
    private String anX;
    private g.a anY;
    protected l anZ;
    private boolean aoa = false;
    private boolean aob = false;
    private volatile boolean aoc = false;
    private long aod = 0;
    private c aoe = null;

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
                i.this.anR = eVar.a(i.this.anU, i.this.anV, i.this.anZ, false);
                if (i.this.aoc) {
                    i.this.av(new k.c());
                    return;
                }
                try {
                    if (!i.this.anR.isConnected()) {
                        i.this.av(new k.e(2, "cannot connect"));
                    } else {
                        i.this.aod = System.currentTimeMillis() - currentTimeMillis;
                        i.this.pE();
                        i.this.pD();
                        k.b bVar = new k.b(i.this.anU + ":" + i.this.anV);
                        bVar.mPath = i.this.anW;
                        bVar.aoi = i.this.anX;
                        bVar.aok = i.this.anI;
                        bVar.aol = i.this.anH;
                        i.this.anQ.ay(bVar);
                        if (i.this.aoc) {
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
        if (this.aoe != null || !isOpen()) {
            if (py()) {
            }
            if (cVar != null) {
                cVar.cF(1);
                return false;
            }
            return false;
        }
        this.aoe = cVar;
        return d(this.aoe);
    }

    private boolean d(c cVar) {
        if (this.anQ == null) {
            av(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.anQ.ay(new k.i(cVar));
    }

    public void close(int i, String str) {
        this.aoa = false;
        this.aoc = true;
        if (this.anP != null) {
            this.anP.quit();
            this.anP = null;
        }
        if (this.anQ != null) {
            this.anQ.quit();
            this.anQ = null;
        }
        if (this.anR != null) {
            try {
                this.anR.close();
            } catch (Throwable th) {
                if (py()) {
                    th.printStackTrace();
                }
            }
            this.anR = null;
        }
        g.a aVar = this.anY;
        this.anY = null;
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
        this.aob = true;
        if (this.anR != null && this.anR.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.anS = new URI(str);
            if (!this.anS.getScheme().equals("ws") && !this.anS.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.anS.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.anT = this.anS.getScheme();
            if (this.anS.getPort() == -1) {
                if (this.anT.equals("ws")) {
                    this.anV = 80;
                } else {
                    this.anV = 443;
                }
            } else {
                this.anV = this.anS.getPort();
            }
            if (this.anS.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.anU = this.anS.getHost();
            if (this.anS.getPath() == null || this.anS.getPath().equals("")) {
                this.anW = "/";
            } else {
                this.anW = this.anS.getPath();
            }
            if (this.anS.getQuery() == null || this.anS.getQuery().equals("")) {
                this.anX = null;
            } else {
                this.anX = this.anS.getQuery();
            }
            this.anI = strArr;
            this.anH = list;
            this.anY = aVar;
            this.anZ = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(Object obj) {
        Message obtainMessage = this.anO.obtainMessage();
        obtainMessage.obj = obj;
        this.anO.sendMessage(obtainMessage);
    }

    protected void pC() {
        this.anO = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.anY != null) {
                        i.this.anY.J(sVar.aov);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.anY != null) {
                        i.this.anY.o(mVar.aog);
                    } else if (i.this.py()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.anY != null) {
                        i.this.anY.b(aVar);
                    } else if (i.this.py()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0021k c0021k = new k.C0021k();
                    c0021k.aog = ((k.j) message.obj).aog;
                    i.this.anQ.ay(c0021k);
                } else if (message.obj instanceof k.C0021k) {
                    k.C0021k c0021k2 = (k.C0021k) message.obj;
                    if (i.this.anY != null) {
                        i.this.anY.pt();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.aot) {
                        if (i.this.anY != null) {
                            i.this.anY.e(qVar.aou);
                            i.this.aoa = true;
                            i.this.aob = false;
                            if (i.this.anY != null) {
                                i.this.anY.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).aon;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).aor;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).aop.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.aoo + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).aoo);
                } else if (message.obj instanceof k.r) {
                    if (i.this.anY != null) {
                        i.this.anY.b(((k.r) message.obj).aos);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.aoe = null;
                    c cVar = ((k.g) message.obj).aos;
                    if (i.this.anY != null) {
                        i.this.anY.c(cVar);
                    }
                    if (i.this.anY != null) {
                        i.this.anY.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.aoe = null;
                    c cVar2 = ((k.n) message.obj).aos;
                    if (i.this.anY != null) {
                        i.this.anY.a(2, cVar2);
                    }
                    if (i.this.anY != null) {
                        i.this.anY.a(cVar2);
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
        this.anQ = new o(handlerThread.getLooper(), this.anO, this.anR, this.anZ);
    }

    protected void pE() {
        this.anP = new m(this.anO, this.anR, this.anZ, "WebSocketReader");
        this.anP.start();
    }

    public boolean pF() {
        return this.aoe != null;
    }

    public boolean isConnecting() {
        return this.aob;
    }

    public boolean isOpen() {
        return this.aoa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean py() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void pz() {
        if (this.anQ != null) {
            this.anQ.pz();
        }
    }

    public long getUpFlowSize() {
        if (this.anQ != null) {
            return this.anQ.getUpFlowSize();
        }
        return 0L;
    }

    public void pA() {
        if (this.anP != null) {
            this.anP.pA();
        }
    }

    public long getDownFlowSize() {
        if (this.anP != null) {
            return this.anP.getDownFlowSize();
        }
        return 0L;
    }

    public long pG() {
        if (this.anR != null) {
            return this.anR.pr();
        }
        return 0L;
    }

    public String pH() {
        if (this.anR != null) {
            return this.anR.pq();
        }
        return null;
    }

    public long pI() {
        return this.aod;
    }

    public String pa() {
        if (this.anR != null) {
            return this.anR.pa();
        }
        return null;
    }

    public String pb() {
        if (this.anR != null) {
            return this.anR.pb();
        }
        return null;
    }
}
