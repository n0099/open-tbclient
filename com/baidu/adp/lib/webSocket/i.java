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
    private List<BasicNameValuePair> GF;
    private String[] GG;
    protected Handler GM;
    protected volatile m GN;
    protected volatile o GO;
    protected e.a GP;
    private URI GQ;
    private String GR;
    private String GU;
    private int GV;
    private String GW;
    private String GX;
    private g.a GY;
    protected l GZ;
    private boolean Ha = false;
    private boolean Hb = false;
    private volatile boolean Hc = false;
    private long Hd = 0;
    private c He = null;

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
                i.this.GP = eVar.a(i.this.GU, i.this.GV, i.this.GZ, false);
                if (i.this.Hc) {
                    i.this.u(new k.c());
                    return;
                }
                try {
                    if (!i.this.GP.isConnected()) {
                        i.this.u(new k.e(2, "cannot connect"));
                    } else {
                        i.this.Hd = System.currentTimeMillis() - currentTimeMillis;
                        i.this.lG();
                        i.this.lF();
                        k.b bVar = new k.b(i.this.GU + ":" + i.this.GV);
                        bVar.yz = i.this.GW;
                        bVar.mQuery = i.this.GX;
                        bVar.Hj = i.this.GG;
                        bVar.Hk = i.this.GF;
                        i.this.GO.x(bVar);
                        if (i.this.Hc) {
                            i.this.u(new k.c());
                        }
                    }
                } catch (Throwable th) {
                    if (i.this.lA()) {
                        BdLog.e("----WebSocketConnector error. e:" + th.getMessage());
                    }
                    i.this.u(new k.f(new Exception(th)));
                }
            } catch (Throwable th2) {
                i.this.u(new k.e(2, th2.getMessage()));
            }
        }
    }

    public i() {
        lE();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.He != null || !isOpen()) {
            if (lA()) {
            }
            if (cVar != null) {
                cVar.O(1);
                return false;
            }
            return false;
        }
        this.He = cVar;
        return d(this.He);
    }

    private boolean d(c cVar) {
        if (this.GO == null) {
            u(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.GO.x(new k.i(cVar));
    }

    public void close(int i, String str) {
        this.Ha = false;
        this.Hc = true;
        if (this.GN != null) {
            this.GN.quit();
            this.GN = null;
        }
        if (this.GO != null) {
            this.GO.quit();
            this.GO = null;
        }
        if (this.GP != null) {
            try {
                this.GP.close();
            } catch (Throwable th) {
                if (lA()) {
                    th.printStackTrace();
                }
            }
            this.GP = null;
        }
        g.a aVar = this.GY;
        this.GY = null;
        if (aVar != null) {
            try {
                aVar.f(i, str);
            } catch (Exception e) {
                if (lA()) {
                    BdLog.d(e.getMessage());
                }
            }
        }
    }

    public void a(String str, String[] strArr, g.a aVar, l lVar, List<BasicNameValuePair> list) throws WebSocketException {
        this.Hb = true;
        if (this.GP != null && this.GP.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.GQ = new URI(str);
            if (!this.GQ.getScheme().equals("ws") && !this.GQ.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.GQ.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.GR = this.GQ.getScheme();
            if (this.GQ.getPort() == -1) {
                if (this.GR.equals("ws")) {
                    this.GV = 80;
                } else {
                    this.GV = 443;
                }
            } else {
                this.GV = this.GQ.getPort();
            }
            if (this.GQ.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.GU = this.GQ.getHost();
            if (this.GQ.getPath() == null || this.GQ.getPath().equals("")) {
                this.GW = "/";
            } else {
                this.GW = this.GQ.getPath();
            }
            if (this.GQ.getQuery() == null || this.GQ.getQuery().equals("")) {
                this.GX = null;
            } else {
                this.GX = this.GQ.getQuery();
            }
            this.GG = strArr;
            this.GF = list;
            this.GY = aVar;
            this.GZ = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Object obj) {
        Message obtainMessage = this.GM.obtainMessage();
        obtainMessage.obj = obj;
        this.GM.sendMessage(obtainMessage);
    }

    protected void lE() {
        this.GM = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.GY != null) {
                        i.this.GY.aj(sVar.Hu);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.GY != null) {
                        i.this.GY.x(mVar.Hg);
                    } else if (i.this.lA()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.GY != null) {
                        i.this.GY.b(aVar);
                    } else if (i.this.lA()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0018k c0018k = new k.C0018k();
                    c0018k.Hg = ((k.j) message.obj).Hg;
                    i.this.GO.x(c0018k);
                } else if (message.obj instanceof k.C0018k) {
                    k.C0018k c0018k2 = (k.C0018k) message.obj;
                    if (i.this.GY != null) {
                        i.this.GY.lv();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.Hs) {
                        if (i.this.GY != null) {
                            i.this.GY.j(qVar.Ht);
                            i.this.Ha = true;
                            i.this.Hb = false;
                            if (i.this.GY != null) {
                                i.this.GY.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).Hm;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).Hq;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).Ho.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.Hn + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).Hn);
                } else if (message.obj instanceof k.r) {
                    if (i.this.GY != null) {
                        i.this.GY.b(((k.r) message.obj).Hr);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.He = null;
                    c cVar = ((k.g) message.obj).Hr;
                    if (i.this.GY != null) {
                        i.this.GY.c(cVar);
                    }
                    if (i.this.GY != null) {
                        i.this.GY.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.He = null;
                    c cVar2 = ((k.n) message.obj).Hr;
                    if (i.this.GY != null) {
                        i.this.GY.a(2, cVar2);
                    }
                    if (i.this.GY != null) {
                        i.this.GY.a(cVar2);
                    }
                } else {
                    i.this.v(message.obj);
                }
            }
        };
    }

    protected void v(Object obj) {
    }

    protected void lF() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.GO = new o(handlerThread.getLooper(), this.GM, this.GP, this.GZ);
    }

    protected void lG() {
        this.GN = new m(this.GM, this.GP, this.GZ, "WebSocketReader");
        this.GN.start();
    }

    public boolean lH() {
        return this.He != null;
    }

    public boolean isConnecting() {
        return this.Hb;
    }

    public boolean isOpen() {
        return this.Ha;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lA() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void lB() {
        if (this.GO != null) {
            this.GO.lB();
        }
    }

    public long getUpFlowSize() {
        if (this.GO != null) {
            return this.GO.getUpFlowSize();
        }
        return 0L;
    }

    public void lC() {
        if (this.GN != null) {
            this.GN.lC();
        }
    }

    public long getDownFlowSize() {
        if (this.GN != null) {
            return this.GN.getDownFlowSize();
        }
        return 0L;
    }

    public long lI() {
        if (this.GP != null) {
            return this.GP.lt();
        }
        return 0L;
    }

    public String lJ() {
        if (this.GP != null) {
            return this.GP.ls();
        }
        return null;
    }

    public long lK() {
        return this.Hd;
    }

    public String lc() {
        if (this.GP != null) {
            return this.GP.lc();
        }
        return null;
    }

    public String ld() {
        if (this.GP != null) {
            return this.GP.ld();
        }
        return null;
    }
}
