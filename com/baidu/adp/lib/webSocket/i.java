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
    private List<BasicNameValuePair> rP;
    private String[] rQ;
    protected Handler rW;
    protected volatile m rX;
    protected volatile o rY;
    protected e.a rZ;
    private URI sa;
    private String sc;
    private String se;
    private int sf;
    private String sg;
    private String sh;
    private g.a si;
    protected l sj;
    private boolean sk = false;
    private boolean sl = false;
    private volatile boolean sm = false;
    private long so = 0;
    private c sq = null;

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
                i.this.rZ = eVar.a(i.this.se, i.this.sf, i.this.sj, false);
                if (i.this.sm) {
                    i.this.r(new k.c());
                    return;
                }
                try {
                    if (!i.this.rZ.isConnected()) {
                        i.this.r(new k.e(2, "cannot connect"));
                    } else {
                        i.this.so = System.currentTimeMillis() - currentTimeMillis;
                        i.this.hA();
                        i.this.hz();
                        k.b bVar = new k.b(i.this.se + ":" + i.this.sf);
                        bVar.mPath = i.this.sg;
                        bVar.mQuery = i.this.sh;
                        bVar.sw = i.this.rQ;
                        bVar.sx = i.this.rP;
                        i.this.rY.u(bVar);
                        if (i.this.sm) {
                            i.this.r(new k.c());
                        }
                    }
                } catch (Throwable th) {
                    if (i.this.isDebug()) {
                        BdLog.e("----WebSocketConnector error. e:" + th.getMessage());
                    }
                    i.this.r(new k.f(new Exception(th)));
                }
            } catch (Throwable th2) {
                i.this.r(new k.e(2, th2.getMessage()));
            }
        }
    }

    public i() {
        hy();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.sq != null || !isOpen()) {
            if (isDebug()) {
            }
            if (cVar != null) {
                cVar.onSendError(1);
                return false;
            }
            return false;
        }
        this.sq = cVar;
        return d(this.sq);
    }

    private boolean d(c cVar) {
        if (this.rY == null) {
            r(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.rY.u(new k.i(cVar));
    }

    public void close(int i, String str) {
        if (com.baidu.adp.lib.b.d.ft().af("need_more_logs") == 1) {
            com.baidu.adp.framework.client.socket.i.debug("more_log", 0, 0, "onClose", i, str);
        }
        this.sk = false;
        this.sm = true;
        if (this.rX != null) {
            this.rX.quit();
            this.rX = null;
        }
        if (this.rY != null) {
            this.rY.quit();
            this.rY = null;
        }
        if (this.rZ != null) {
            try {
                this.rZ.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.rZ = null;
        }
        g.a aVar = this.si;
        this.si = null;
        if (aVar != null) {
            try {
                aVar.e(i, str);
            } catch (Exception e) {
                if (isDebug()) {
                    BdLog.d(e.getMessage());
                }
            }
        }
    }

    public void a(String str, String[] strArr, g.a aVar, l lVar, List<BasicNameValuePair> list) throws WebSocketException {
        this.sl = true;
        if (this.rZ != null && this.rZ.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.sa = new URI(str);
            if (!this.sa.getScheme().equals("ws") && !this.sa.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.sa.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.sc = this.sa.getScheme();
            if (this.sa.getPort() == -1) {
                if (this.sc.equals("ws")) {
                    this.sf = 80;
                } else {
                    this.sf = 443;
                }
            } else {
                this.sf = this.sa.getPort();
            }
            if (this.sa.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.se = this.sa.getHost();
            if (this.sa.getPath() == null || this.sa.getPath().equals("")) {
                this.sg = "/";
            } else {
                this.sg = this.sa.getPath();
            }
            if (this.sa.getQuery() == null || this.sa.getQuery().equals("")) {
                this.sh = null;
            } else {
                this.sh = this.sa.getQuery();
            }
            this.rQ = strArr;
            this.rP = list;
            this.si = aVar;
            this.sj = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Object obj) {
        Message obtainMessage = this.rW.obtainMessage();
        obtainMessage.obj = obj;
        this.rW.sendMessage(obtainMessage);
    }

    protected void hy() {
        this.rW = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.si != null) {
                        i.this.si.onTextMessage(sVar.sH);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.si != null) {
                        i.this.si.i(mVar.ss);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.si != null) {
                        i.this.si.b(aVar);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0019k c0019k = new k.C0019k();
                    c0019k.ss = ((k.j) message.obj).ss;
                    i.this.rY.u(c0019k);
                } else if (message.obj instanceof k.C0019k) {
                    k.C0019k c0019k2 = (k.C0019k) message.obj;
                    if (i.this.si != null) {
                        i.this.si.hq();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.sF) {
                        if (i.this.si != null) {
                            i.this.si.onOpen(qVar.sG);
                            i.this.sk = true;
                            i.this.sl = false;
                            if (i.this.si != null) {
                                i.this.si.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).sz;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).sD;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).sB.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.sA + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).sA);
                } else if (message.obj instanceof k.r) {
                    if (i.this.si != null) {
                        i.this.si.b(((k.r) message.obj).sE);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.sq = null;
                    c cVar = ((k.g) message.obj).sE;
                    if (i.this.si != null) {
                        i.this.si.c(cVar);
                    }
                    if (i.this.si != null) {
                        i.this.si.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.sq = null;
                    c cVar2 = ((k.n) message.obj).sE;
                    if (i.this.si != null) {
                        i.this.si.a(2, cVar2);
                    }
                    if (i.this.si != null) {
                        i.this.si.a(cVar2);
                    }
                } else {
                    i.this.s(message.obj);
                }
            }
        };
    }

    protected void s(Object obj) {
    }

    protected void hz() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.rY = new o(handlerThread.getLooper(), this.rW, this.rZ, this.sj);
    }

    protected void hA() {
        this.rX = new m(this.rW, this.rZ, this.sj, "WebSocketReader");
        this.rX.start();
    }

    public boolean hB() {
        return this.sq != null;
    }

    public boolean isConnecting() {
        return this.sl;
    }

    public boolean isOpen() {
        return this.sk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void hv() {
        if (this.rY != null) {
            this.rY.hv();
        }
    }

    public long getUpFlowSize() {
        if (this.rY != null) {
            return this.rY.getUpFlowSize();
        }
        return 0L;
    }

    public void hw() {
        if (this.rX != null) {
            this.rX.hw();
        }
    }

    public long getDownFlowSize() {
        if (this.rX != null) {
            return this.rX.getDownFlowSize();
        }
        return 0L;
    }

    public long hC() {
        if (this.rZ != null) {
            return this.rZ.ho();
        }
        return 0L;
    }

    public String hD() {
        if (this.rZ != null) {
            return this.rZ.hn();
        }
        return null;
    }

    public long hE() {
        return this.so;
    }

    public String getLocalDns() {
        if (this.rZ != null) {
            return this.rZ.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.rZ != null) {
            return this.rZ.getLocalDnsBak();
        }
        return null;
    }
}
