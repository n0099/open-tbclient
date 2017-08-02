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
    private String[] Aa;
    protected Handler Ah;
    protected volatile m Ai;
    protected volatile o Aj;
    protected e.a Ak;
    private URI Al;
    private String Am;
    private String An;
    private int Ao;
    private String Ap;
    private String Aq;
    private g.a Ar;
    protected l As;
    private boolean At = false;
    private boolean Au = false;
    private volatile boolean Av = false;
    private long Aw = 0;
    private c Ax = null;
    private List<BasicNameValuePair> zZ;

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
                i.this.Ak = eVar.a(i.this.An, i.this.Ao, i.this.As, false);
                if (i.this.Av) {
                    i.this.r(new k.c());
                    return;
                }
                try {
                    if (!i.this.Ak.isConnected()) {
                        i.this.r(new k.e(2, "cannot connect"));
                    } else {
                        i.this.Aw = System.currentTimeMillis() - currentTimeMillis;
                        i.this.ie();
                        i.this.id();
                        k.b bVar = new k.b(i.this.An + ":" + i.this.Ao);
                        bVar.mPath = i.this.Ap;
                        bVar.AB = i.this.Aq;
                        bVar.AD = i.this.Aa;
                        bVar.AE = i.this.zZ;
                        i.this.Aj.u(bVar);
                        if (i.this.Av) {
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
        ic();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.Ax != null || !isOpen()) {
            if (isDebug()) {
            }
            if (cVar != null) {
                cVar.M(1);
                return false;
            }
            return false;
        }
        this.Ax = cVar;
        return d(this.Ax);
    }

    private boolean d(c cVar) {
        if (this.Aj == null) {
            r(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.Aj.u(new k.i(cVar));
    }

    public void close(int i, String str) {
        this.At = false;
        this.Av = true;
        if (this.Ai != null) {
            this.Ai.quit();
            this.Ai = null;
        }
        if (this.Aj != null) {
            this.Aj.quit();
            this.Aj = null;
        }
        if (this.Ak != null) {
            try {
                this.Ak.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.Ak = null;
        }
        g.a aVar = this.Ar;
        this.Ar = null;
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
        this.Au = true;
        if (this.Ak != null && this.Ak.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.Al = new URI(str);
            if (!this.Al.getScheme().equals("ws") && !this.Al.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.Al.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.Am = this.Al.getScheme();
            if (this.Al.getPort() == -1) {
                if (this.Am.equals("ws")) {
                    this.Ao = 80;
                } else {
                    this.Ao = 443;
                }
            } else {
                this.Ao = this.Al.getPort();
            }
            if (this.Al.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.An = this.Al.getHost();
            if (this.Al.getPath() == null || this.Al.getPath().equals("")) {
                this.Ap = "/";
            } else {
                this.Ap = this.Al.getPath();
            }
            if (this.Al.getQuery() == null || this.Al.getQuery().equals("")) {
                this.Aq = null;
            } else {
                this.Aq = this.Al.getQuery();
            }
            this.Aa = strArr;
            this.zZ = list;
            this.Ar = aVar;
            this.As = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Object obj) {
        Message obtainMessage = this.Ah.obtainMessage();
        obtainMessage.obj = obj;
        this.Ah.sendMessage(obtainMessage);
    }

    protected void ic() {
        this.Ah = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.Ar != null) {
                        i.this.Ar.C(sVar.AO);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.Ar != null) {
                        i.this.Ar.r(mVar.Az);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.Ar != null) {
                        i.this.Ar.b(aVar);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0009k c0009k = new k.C0009k();
                    c0009k.Az = ((k.j) message.obj).Az;
                    i.this.Aj.u(c0009k);
                } else if (message.obj instanceof k.C0009k) {
                    k.C0009k c0009k2 = (k.C0009k) message.obj;
                    if (i.this.Ar != null) {
                        i.this.Ar.hT();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.AM) {
                        if (i.this.Ar != null) {
                            i.this.Ar.e(qVar.AN);
                            i.this.At = true;
                            i.this.Au = false;
                            if (i.this.Ar != null) {
                                i.this.Ar.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).AG;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).AK;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).AI.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.AH + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).AH);
                } else if (message.obj instanceof k.r) {
                    if (i.this.Ar != null) {
                        i.this.Ar.b(((k.r) message.obj).AL);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.Ax = null;
                    c cVar = ((k.g) message.obj).AL;
                    if (i.this.Ar != null) {
                        i.this.Ar.c(cVar);
                    }
                    if (i.this.Ar != null) {
                        i.this.Ar.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.Ax = null;
                    c cVar2 = ((k.n) message.obj).AL;
                    if (i.this.Ar != null) {
                        i.this.Ar.a(2, cVar2);
                    }
                    if (i.this.Ar != null) {
                        i.this.Ar.a(cVar2);
                    }
                } else {
                    i.this.s(message.obj);
                }
            }
        };
    }

    protected void s(Object obj) {
    }

    protected void id() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.Aj = new o(handlerThread.getLooper(), this.Ah, this.Ak, this.As);
    }

    protected void ie() {
        this.Ai = new m(this.Ah, this.Ak, this.As, "WebSocketReader");
        this.Ai.start();
    }

    /* renamed from: if  reason: not valid java name */
    public boolean m5if() {
        return this.Ax != null;
    }

    public boolean hY() {
        return this.Au;
    }

    public boolean isOpen() {
        return this.At;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void hZ() {
        if (this.Aj != null) {
            this.Aj.hZ();
        }
    }

    public long getUpFlowSize() {
        if (this.Aj != null) {
            return this.Aj.getUpFlowSize();
        }
        return 0L;
    }

    public void ia() {
        if (this.Ai != null) {
            this.Ai.ia();
        }
    }

    public long getDownFlowSize() {
        if (this.Ai != null) {
            return this.Ai.getDownFlowSize();
        }
        return 0L;
    }

    public long ig() {
        if (this.Ak != null) {
            return this.Ak.hR();
        }
        return 0L;
    }

    public String ih() {
        if (this.Ak != null) {
            return this.Ak.hQ();
        }
        return null;
    }

    public long ii() {
        return this.Aw;
    }

    public String hz() {
        if (this.Ak != null) {
            return this.Ak.hz();
        }
        return null;
    }

    public String hA() {
        if (this.Ak != null) {
            return this.Ak.hA();
        }
        return null;
    }
}
