package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.e;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.adp.lib.webSocket.k;
import com.baidu.ar.util.SystemInfoUtil;
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class i implements g {
    private int EA;
    private String EB;
    private String EC;
    private g.a ED;
    protected l EE;
    private boolean EF = false;
    private boolean EG = false;
    private volatile boolean EH = false;
    private long EI = 0;
    private c EJ = null;
    private List<BasicNameValuePair> Em;
    private String[] En;
    protected Handler Et;
    protected volatile m Eu;
    protected volatile o Ev;
    protected e.a Ew;
    private URI Ex;
    private String Ey;
    private String Ez;

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
                i.this.Ew = eVar.a(i.this.Ez, i.this.EA, i.this.EE, false);
                if (i.this.EH) {
                    i.this.t(new k.c());
                    return;
                }
                try {
                    if (!i.this.Ew.isConnected()) {
                        i.this.t(new k.e(2, "cannot connect"));
                    } else {
                        i.this.EI = System.currentTimeMillis() - currentTimeMillis;
                        i.this.ky();
                        i.this.kx();
                        k.b bVar = new k.b(i.this.Ez + SystemInfoUtil.COLON + i.this.EA);
                        bVar.mPath = i.this.EB;
                        bVar.mQuery = i.this.EC;
                        bVar.EO = i.this.En;
                        bVar.EP = i.this.Em;
                        i.this.Ev.w(bVar);
                        if (i.this.EH) {
                            i.this.t(new k.c());
                        }
                    }
                } catch (Throwable th) {
                    if (i.this.isDebug()) {
                        BdLog.e("----WebSocketConnector error. e:" + th.getMessage());
                    }
                    i.this.t(new k.f(new Exception(th)));
                }
            } catch (Throwable th2) {
                i.this.t(new k.e(2, th2.getMessage()));
            }
        }
    }

    public i() {
        kw();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.EJ != null || !isOpen()) {
            if (isDebug()) {
            }
            if (cVar != null) {
                cVar.G(1);
                return false;
            }
            return false;
        }
        this.EJ = cVar;
        return d(this.EJ);
    }

    private boolean d(c cVar) {
        if (this.Ev == null) {
            t(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.Ev.w(new k.i(cVar));
    }

    public void close(int i, String str) {
        this.EF = false;
        this.EH = true;
        if (this.Eu != null) {
            this.Eu.quit();
            this.Eu = null;
        }
        if (this.Ev != null) {
            this.Ev.quit();
            this.Ev = null;
        }
        if (this.Ew != null) {
            try {
                this.Ew.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.Ew = null;
        }
        g.a aVar = this.ED;
        this.ED = null;
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
        this.EG = true;
        if (this.Ew != null && this.Ew.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.Ex = new URI(str);
            if (!this.Ex.getScheme().equals("ws") && !this.Ex.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.Ex.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.Ey = this.Ex.getScheme();
            if (this.Ex.getPort() == -1) {
                if (this.Ey.equals("ws")) {
                    this.EA = 80;
                } else {
                    this.EA = 443;
                }
            } else {
                this.EA = this.Ex.getPort();
            }
            if (this.Ex.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.Ez = this.Ex.getHost();
            if (this.Ex.getPath() == null || this.Ex.getPath().equals("")) {
                this.EB = "/";
            } else {
                this.EB = this.Ex.getPath();
            }
            if (this.Ex.getQuery() == null || this.Ex.getQuery().equals("")) {
                this.EC = null;
            } else {
                this.EC = this.Ex.getQuery();
            }
            this.En = strArr;
            this.Em = list;
            this.ED = aVar;
            this.EE = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Object obj) {
        Message obtainMessage = this.Et.obtainMessage();
        obtainMessage.obj = obj;
        this.Et.sendMessage(obtainMessage);
    }

    protected void kw() {
        this.Et = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.ED != null) {
                        i.this.ED.S(sVar.Fa);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.ED != null) {
                        i.this.ED.q(mVar.EL);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.ED != null) {
                        i.this.ED.b(aVar);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0018k c0018k = new k.C0018k();
                    c0018k.EL = ((k.j) message.obj).EL;
                    i.this.Ev.w(c0018k);
                } else if (message.obj instanceof k.C0018k) {
                    k.C0018k c0018k2 = (k.C0018k) message.obj;
                    if (i.this.ED != null) {
                        i.this.ED.ko();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.EY) {
                        if (i.this.ED != null) {
                            i.this.ED.i(qVar.EZ);
                            i.this.EF = true;
                            i.this.EG = false;
                            if (i.this.ED != null) {
                                i.this.ED.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).ES;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).EW;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).EU.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.ET + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).ET);
                } else if (message.obj instanceof k.r) {
                    if (i.this.ED != null) {
                        i.this.ED.b(((k.r) message.obj).EX);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.EJ = null;
                    c cVar = ((k.g) message.obj).EX;
                    if (i.this.ED != null) {
                        i.this.ED.c(cVar);
                    }
                    if (i.this.ED != null) {
                        i.this.ED.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.EJ = null;
                    c cVar2 = ((k.n) message.obj).EX;
                    if (i.this.ED != null) {
                        i.this.ED.a(2, cVar2);
                    }
                    if (i.this.ED != null) {
                        i.this.ED.a(cVar2);
                    }
                } else {
                    i.this.u(message.obj);
                }
            }
        };
    }

    protected void u(Object obj) {
    }

    protected void kx() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.Ev = new o(handlerThread.getLooper(), this.Et, this.Ew, this.EE);
    }

    protected void ky() {
        this.Eu = new m(this.Et, this.Ew, this.EE, "WebSocketReader");
        this.Eu.start();
    }

    public boolean kz() {
        return this.EJ != null;
    }

    public boolean isConnecting() {
        return this.EG;
    }

    public boolean isOpen() {
        return this.EF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void kt() {
        if (this.Ev != null) {
            this.Ev.kt();
        }
    }

    public long getUpFlowSize() {
        if (this.Ev != null) {
            return this.Ev.getUpFlowSize();
        }
        return 0L;
    }

    public void ku() {
        if (this.Eu != null) {
            this.Eu.ku();
        }
    }

    public long getDownFlowSize() {
        if (this.Eu != null) {
            return this.Eu.getDownFlowSize();
        }
        return 0L;
    }

    public long kA() {
        if (this.Ew != null) {
            return this.Ew.km();
        }
        return 0L;
    }

    public String kB() {
        if (this.Ew != null) {
            return this.Ew.kl();
        }
        return null;
    }

    public long kC() {
        return this.EI;
    }

    public String jV() {
        if (this.Ew != null) {
            return this.Ew.jV();
        }
        return null;
    }

    public String jW() {
        if (this.Ew != null) {
            return this.Ew.jW();
        }
        return null;
    }
}
