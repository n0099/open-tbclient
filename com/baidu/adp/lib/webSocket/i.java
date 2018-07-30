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
    private g.a EC;
    protected l ED;
    private boolean EE = false;
    private boolean EF = false;
    private volatile boolean EG = false;
    private long EH = 0;
    private c EI = null;
    private List<BasicNameValuePair> El;
    private String[] Em;
    protected Handler Es;
    protected volatile m Et;
    protected volatile o Eu;
    protected e.a Ev;
    private URI Ew;
    private String Ex;
    private String Ey;
    private int Ez;

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
                i.this.Ev = eVar.a(i.this.Ey, i.this.Ez, i.this.ED, false);
                if (i.this.EG) {
                    i.this.t(new k.c());
                    return;
                }
                try {
                    if (!i.this.Ev.isConnected()) {
                        i.this.t(new k.e(2, "cannot connect"));
                    } else {
                        i.this.EH = System.currentTimeMillis() - currentTimeMillis;
                        i.this.kA();
                        i.this.kz();
                        k.b bVar = new k.b(i.this.Ey + SystemInfoUtil.COLON + i.this.Ez);
                        bVar.wf = i.this.EA;
                        bVar.mQuery = i.this.EB;
                        bVar.EN = i.this.Em;
                        bVar.EO = i.this.El;
                        i.this.Eu.w(bVar);
                        if (i.this.EG) {
                            i.this.t(new k.c());
                        }
                    }
                } catch (Throwable th) {
                    if (i.this.ku()) {
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
        ky();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.EI != null || !isOpen()) {
            if (ku()) {
            }
            if (cVar != null) {
                cVar.G(1);
                return false;
            }
            return false;
        }
        this.EI = cVar;
        return d(this.EI);
    }

    private boolean d(c cVar) {
        if (this.Eu == null) {
            t(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.Eu.w(new k.i(cVar));
    }

    public void close(int i, String str) {
        this.EE = false;
        this.EG = true;
        if (this.Et != null) {
            this.Et.quit();
            this.Et = null;
        }
        if (this.Eu != null) {
            this.Eu.quit();
            this.Eu = null;
        }
        if (this.Ev != null) {
            try {
                this.Ev.close();
            } catch (Throwable th) {
                if (ku()) {
                    th.printStackTrace();
                }
            }
            this.Ev = null;
        }
        g.a aVar = this.EC;
        this.EC = null;
        if (aVar != null) {
            try {
                aVar.f(i, str);
            } catch (Exception e) {
                if (ku()) {
                    BdLog.d(e.getMessage());
                }
            }
        }
    }

    public void a(String str, String[] strArr, g.a aVar, l lVar, List<BasicNameValuePair> list) throws WebSocketException {
        this.EF = true;
        if (this.Ev != null && this.Ev.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.Ew = new URI(str);
            if (!this.Ew.getScheme().equals("ws") && !this.Ew.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.Ew.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.Ex = this.Ew.getScheme();
            if (this.Ew.getPort() == -1) {
                if (this.Ex.equals("ws")) {
                    this.Ez = 80;
                } else {
                    this.Ez = 443;
                }
            } else {
                this.Ez = this.Ew.getPort();
            }
            if (this.Ew.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.Ey = this.Ew.getHost();
            if (this.Ew.getPath() == null || this.Ew.getPath().equals("")) {
                this.EA = "/";
            } else {
                this.EA = this.Ew.getPath();
            }
            if (this.Ew.getQuery() == null || this.Ew.getQuery().equals("")) {
                this.EB = null;
            } else {
                this.EB = this.Ew.getQuery();
            }
            this.Em = strArr;
            this.El = list;
            this.EC = aVar;
            this.ED = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Object obj) {
        Message obtainMessage = this.Es.obtainMessage();
        obtainMessage.obj = obj;
        this.Es.sendMessage(obtainMessage);
    }

    protected void ky() {
        this.Es = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.EC != null) {
                        i.this.EC.S(sVar.EZ);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.EC != null) {
                        i.this.EC.p(mVar.EK);
                    } else if (i.this.ku()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.EC != null) {
                        i.this.EC.b(aVar);
                    } else if (i.this.ku()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0018k c0018k = new k.C0018k();
                    c0018k.EK = ((k.j) message.obj).EK;
                    i.this.Eu.w(c0018k);
                } else if (message.obj instanceof k.C0018k) {
                    k.C0018k c0018k2 = (k.C0018k) message.obj;
                    if (i.this.EC != null) {
                        i.this.EC.kp();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.EX) {
                        if (i.this.EC != null) {
                            i.this.EC.i(qVar.EY);
                            i.this.EE = true;
                            i.this.EF = false;
                            if (i.this.EC != null) {
                                i.this.EC.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).ER;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).EV;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).ET.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.ES + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).ES);
                } else if (message.obj instanceof k.r) {
                    if (i.this.EC != null) {
                        i.this.EC.b(((k.r) message.obj).EW);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.EI = null;
                    c cVar = ((k.g) message.obj).EW;
                    if (i.this.EC != null) {
                        i.this.EC.c(cVar);
                    }
                    if (i.this.EC != null) {
                        i.this.EC.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.EI = null;
                    c cVar2 = ((k.n) message.obj).EW;
                    if (i.this.EC != null) {
                        i.this.EC.a(2, cVar2);
                    }
                    if (i.this.EC != null) {
                        i.this.EC.a(cVar2);
                    }
                } else {
                    i.this.u(message.obj);
                }
            }
        };
    }

    protected void u(Object obj) {
    }

    protected void kz() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.Eu = new o(handlerThread.getLooper(), this.Es, this.Ev, this.ED);
    }

    protected void kA() {
        this.Et = new m(this.Es, this.Ev, this.ED, "WebSocketReader");
        this.Et.start();
    }

    public boolean kB() {
        return this.EI != null;
    }

    public boolean isConnecting() {
        return this.EF;
    }

    public boolean isOpen() {
        return this.EE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ku() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void kv() {
        if (this.Eu != null) {
            this.Eu.kv();
        }
    }

    public long getUpFlowSize() {
        if (this.Eu != null) {
            return this.Eu.getUpFlowSize();
        }
        return 0L;
    }

    public void kw() {
        if (this.Et != null) {
            this.Et.kw();
        }
    }

    public long getDownFlowSize() {
        if (this.Et != null) {
            return this.Et.getDownFlowSize();
        }
        return 0L;
    }

    public long kC() {
        if (this.Ev != null) {
            return this.Ev.kn();
        }
        return 0L;
    }

    public String kD() {
        if (this.Ev != null) {
            return this.Ev.km();
        }
        return null;
    }

    public long kE() {
        return this.EH;
    }

    public String jW() {
        if (this.Ev != null) {
            return this.Ev.jW();
        }
        return null;
    }

    public String jX() {
        if (this.Ev != null) {
            return this.Ev.jX();
        }
        return null;
    }
}
