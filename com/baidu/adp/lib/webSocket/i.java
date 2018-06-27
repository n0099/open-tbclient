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
    private String EA;
    private String EB;
    private int EC;
    private String ED;
    private String EE;
    private g.a EF;
    protected l EG;
    private boolean EH = false;
    private boolean EI = false;
    private volatile boolean EJ = false;
    private long EK = 0;
    private c EL = null;
    private List<BasicNameValuePair> Eo;
    private String[] Ep;
    protected Handler Ev;
    protected volatile m Ew;
    protected volatile o Ex;
    protected e.a Ey;
    private URI Ez;

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
                i.this.Ey = eVar.a(i.this.EB, i.this.EC, i.this.EG, false);
                if (i.this.EJ) {
                    i.this.t(new k.c());
                    return;
                }
                try {
                    if (!i.this.Ey.isConnected()) {
                        i.this.t(new k.e(2, "cannot connect"));
                    } else {
                        i.this.EK = System.currentTimeMillis() - currentTimeMillis;
                        i.this.ky();
                        i.this.kx();
                        k.b bVar = new k.b(i.this.EB + SystemInfoUtil.COLON + i.this.EC);
                        bVar.mPath = i.this.ED;
                        bVar.mQuery = i.this.EE;
                        bVar.ER = i.this.Ep;
                        bVar.ES = i.this.Eo;
                        i.this.Ex.w(bVar);
                        if (i.this.EJ) {
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
        if (this.EL != null || !isOpen()) {
            if (isDebug()) {
            }
            if (cVar != null) {
                cVar.G(1);
                return false;
            }
            return false;
        }
        this.EL = cVar;
        return d(this.EL);
    }

    private boolean d(c cVar) {
        if (this.Ex == null) {
            t(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.Ex.w(new k.i(cVar));
    }

    public void close(int i, String str) {
        this.EH = false;
        this.EJ = true;
        if (this.Ew != null) {
            this.Ew.quit();
            this.Ew = null;
        }
        if (this.Ex != null) {
            this.Ex.quit();
            this.Ex = null;
        }
        if (this.Ey != null) {
            try {
                this.Ey.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.Ey = null;
        }
        g.a aVar = this.EF;
        this.EF = null;
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
        this.EI = true;
        if (this.Ey != null && this.Ey.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.Ez = new URI(str);
            if (!this.Ez.getScheme().equals("ws") && !this.Ez.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.Ez.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.EA = this.Ez.getScheme();
            if (this.Ez.getPort() == -1) {
                if (this.EA.equals("ws")) {
                    this.EC = 80;
                } else {
                    this.EC = 443;
                }
            } else {
                this.EC = this.Ez.getPort();
            }
            if (this.Ez.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.EB = this.Ez.getHost();
            if (this.Ez.getPath() == null || this.Ez.getPath().equals("")) {
                this.ED = "/";
            } else {
                this.ED = this.Ez.getPath();
            }
            if (this.Ez.getQuery() == null || this.Ez.getQuery().equals("")) {
                this.EE = null;
            } else {
                this.EE = this.Ez.getQuery();
            }
            this.Ep = strArr;
            this.Eo = list;
            this.EF = aVar;
            this.EG = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Object obj) {
        Message obtainMessage = this.Ev.obtainMessage();
        obtainMessage.obj = obj;
        this.Ev.sendMessage(obtainMessage);
    }

    protected void kw() {
        this.Ev = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.EF != null) {
                        i.this.EF.S(sVar.Fc);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.EF != null) {
                        i.this.EF.r(mVar.EN);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.EF != null) {
                        i.this.EF.b(aVar);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0018k c0018k = new k.C0018k();
                    c0018k.EN = ((k.j) message.obj).EN;
                    i.this.Ex.w(c0018k);
                } else if (message.obj instanceof k.C0018k) {
                    k.C0018k c0018k2 = (k.C0018k) message.obj;
                    if (i.this.EF != null) {
                        i.this.EF.ko();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.Fa) {
                        if (i.this.EF != null) {
                            i.this.EF.i(qVar.Fb);
                            i.this.EH = true;
                            i.this.EI = false;
                            if (i.this.EF != null) {
                                i.this.EF.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).EU;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).EY;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).EW.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.EV + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).EV);
                } else if (message.obj instanceof k.r) {
                    if (i.this.EF != null) {
                        i.this.EF.b(((k.r) message.obj).EZ);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.EL = null;
                    c cVar = ((k.g) message.obj).EZ;
                    if (i.this.EF != null) {
                        i.this.EF.c(cVar);
                    }
                    if (i.this.EF != null) {
                        i.this.EF.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.EL = null;
                    c cVar2 = ((k.n) message.obj).EZ;
                    if (i.this.EF != null) {
                        i.this.EF.a(2, cVar2);
                    }
                    if (i.this.EF != null) {
                        i.this.EF.a(cVar2);
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
        this.Ex = new o(handlerThread.getLooper(), this.Ev, this.Ey, this.EG);
    }

    protected void ky() {
        this.Ew = new m(this.Ev, this.Ey, this.EG, "WebSocketReader");
        this.Ew.start();
    }

    public boolean kz() {
        return this.EL != null;
    }

    public boolean isConnecting() {
        return this.EI;
    }

    public boolean isOpen() {
        return this.EH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void kt() {
        if (this.Ex != null) {
            this.Ex.kt();
        }
    }

    public long getUpFlowSize() {
        if (this.Ex != null) {
            return this.Ex.getUpFlowSize();
        }
        return 0L;
    }

    public void ku() {
        if (this.Ew != null) {
            this.Ew.ku();
        }
    }

    public long getDownFlowSize() {
        if (this.Ew != null) {
            return this.Ew.getDownFlowSize();
        }
        return 0L;
    }

    public long kA() {
        if (this.Ey != null) {
            return this.Ey.km();
        }
        return 0L;
    }

    public String kB() {
        if (this.Ey != null) {
            return this.Ey.kl();
        }
        return null;
    }

    public long kC() {
        return this.EK;
    }

    public String jV() {
        if (this.Ey != null) {
            return this.Ey.jV();
        }
        return null;
    }

    public String jW() {
        if (this.Ey != null) {
            return this.Ey.jW();
        }
        return null;
    }
}
