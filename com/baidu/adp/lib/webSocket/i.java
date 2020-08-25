package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.e;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.adp.lib.webSocket.k;
import com.baidu.android.imsdk.internal.Constants;
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class i implements g {
    protected e.a PD;
    private URI PE;
    private String PF;
    private String PG;
    private int PH;
    private String PI;
    private String PJ;
    private g.a PM;
    protected l PN;
    private boolean PO = false;
    private boolean PP = false;
    private volatile boolean PQ = false;
    private long PR = 0;
    private c PT = null;
    private List<BasicNameValuePair> Pq;
    private String[] Pr;
    protected Handler Px;
    protected volatile m Py;
    protected volatile o Pz;

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
                i.this.PD = eVar.a(i.this.PG, i.this.PH, i.this.PN, false);
                if (i.this.PQ) {
                    i.this.w(new k.c());
                    return;
                }
                try {
                    if (!i.this.PD.isConnected()) {
                        i.this.w(new k.e(2, "cannot connect"));
                    } else {
                        i.this.PR = System.currentTimeMillis() - currentTimeMillis;
                        i.this.oG();
                        i.this.oF();
                        k.b bVar = new k.b(i.this.PG + ":" + i.this.PH);
                        bVar.mPath = i.this.PI;
                        bVar.mQuery = i.this.PJ;
                        bVar.PW = i.this.Pr;
                        bVar.PY = i.this.Pq;
                        i.this.Pz.z(bVar);
                        if (i.this.PQ) {
                            i.this.w(new k.c());
                        }
                    }
                } catch (Throwable th) {
                    if (i.this.isDebug()) {
                        BdLog.e("----WebSocketConnector error. e:" + th.getMessage());
                    }
                    i.this.w(new k.f(new Exception(th)));
                }
            } catch (Throwable th2) {
                i.this.w(new k.e(2, th2.getMessage()));
            }
        }
    }

    public i() {
        oE();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.PT != null || !isOpen()) {
            if (isDebug()) {
            }
            if (cVar != null) {
                cVar.onSendError(1);
                return false;
            }
            return false;
        }
        this.PT = cVar;
        return d(this.PT);
    }

    private boolean d(c cVar) {
        if (this.Pz == null) {
            w(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.Pz.z(new k.i(cVar));
    }

    public void close(int i, String str) {
        if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
            com.baidu.adp.framework.client.socket.i.debug("more_log", 0, 0, "close", i, str);
        }
        this.PO = false;
        this.PQ = true;
        if (this.Py != null) {
            this.Py.quit();
            this.Py = null;
        }
        if (this.Pz != null) {
            this.Pz.quit();
            this.Pz = null;
        }
        if (this.PD != null) {
            try {
                this.PD.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.PD = null;
        }
        g.a aVar = this.PM;
        this.PM = null;
        if (aVar != null) {
            try {
                aVar.c(i, str);
            } catch (Exception e) {
                if (isDebug()) {
                    BdLog.d(e.getMessage());
                }
            }
        }
    }

    public void a(String str, String[] strArr, g.a aVar, l lVar, List<BasicNameValuePair> list) throws WebSocketException {
        this.PP = true;
        if (this.PD != null && this.PD.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.PE = new URI(str);
            if (!this.PE.getScheme().equals("ws") && !this.PE.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.PE.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.PF = this.PE.getScheme();
            if (this.PE.getPort() == -1) {
                if (this.PF.equals("ws")) {
                    this.PH = 80;
                } else {
                    this.PH = Constants.SOCKET_PORT_SSL;
                }
            } else {
                this.PH = this.PE.getPort();
            }
            if (this.PE.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.PG = this.PE.getHost();
            if (this.PE.getPath() == null || this.PE.getPath().equals("")) {
                this.PI = "/";
            } else {
                this.PI = this.PE.getPath();
            }
            if (this.PE.getQuery() == null || this.PE.getQuery().equals("")) {
                this.PJ = null;
            } else {
                this.PJ = this.PE.getQuery();
            }
            this.Pr = strArr;
            this.Pq = list;
            this.PM = aVar;
            this.PN = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(Object obj) {
        Message obtainMessage = this.Px.obtainMessage();
        obtainMessage.obj = obj;
        this.Px.sendMessage(obtainMessage);
    }

    protected void oE() {
        this.Px = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.PM != null) {
                        i.this.PM.onTextMessage(sVar.Qg);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.PM != null) {
                        i.this.PM.m(mVar.PV);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.PM != null) {
                        i.this.PM.b(aVar);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0022k c0022k = new k.C0022k();
                    c0022k.PV = ((k.j) message.obj).PV;
                    i.this.Pz.z(c0022k);
                } else if (message.obj instanceof k.C0022k) {
                    k.C0022k c0022k2 = (k.C0022k) message.obj;
                    if (i.this.PM != null) {
                        i.this.PM.ox();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.Qf) {
                        if (i.this.PM != null) {
                            i.this.PM.onOpen(qVar.mHeaders);
                            i.this.PO = true;
                            i.this.PP = false;
                            if (i.this.PM != null) {
                                i.this.PM.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).PZ;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).Qd;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).Qb.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.Qa + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).Qa);
                } else if (message.obj instanceof k.r) {
                    if (i.this.PM != null) {
                        i.this.PM.b(((k.r) message.obj).Qe);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.PT = null;
                    c cVar = ((k.g) message.obj).Qe;
                    if (i.this.PM != null) {
                        i.this.PM.c(cVar);
                    }
                    if (i.this.PM != null) {
                        i.this.PM.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.PT = null;
                    c cVar2 = ((k.n) message.obj).Qe;
                    if (i.this.PM != null) {
                        i.this.PM.a(2, cVar2);
                    }
                    if (i.this.PM != null) {
                        i.this.PM.a(cVar2);
                    }
                } else {
                    i.this.x(message.obj);
                }
            }
        };
    }

    protected void x(Object obj) {
    }

    protected void oF() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.Pz = new o(handlerThread.getLooper(), this.Px, this.PD, this.PN);
    }

    protected void oG() {
        this.Py = new m(this.Px, this.PD, this.PN, "WebSocketReader");
        this.Py.start();
    }

    public boolean oH() {
        return this.PT != null;
    }

    public boolean isConnecting() {
        return this.PP;
    }

    public boolean isOpen() {
        return this.PO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void oB() {
        if (this.Pz != null) {
            this.Pz.oB();
        }
    }

    public long getUpFlowSize() {
        if (this.Pz != null) {
            return this.Pz.getUpFlowSize();
        }
        return 0L;
    }

    public void oC() {
        if (this.Py != null) {
            this.Py.oC();
        }
    }

    public long getDownFlowSize() {
        if (this.Py != null) {
            return this.Py.getDownFlowSize();
        }
        return 0L;
    }

    public long oI() {
        if (this.PD != null) {
            return this.PD.ov();
        }
        return 0L;
    }

    public String oJ() {
        if (this.PD != null) {
            return this.PD.ou();
        }
        return null;
    }

    public long oK() {
        return this.PR;
    }

    public String getLocalDns() {
        if (this.PD != null) {
            return this.PD.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.PD != null) {
            return this.PD.getLocalDnsBak();
        }
        return null;
    }
}
