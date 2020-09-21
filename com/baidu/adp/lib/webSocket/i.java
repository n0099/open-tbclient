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
    private List<BasicNameValuePair> PN;
    private String[] PO;
    protected Handler PV;
    protected volatile m PW;
    protected volatile o PY;
    protected e.a PZ;
    private URI Qa;
    private String Qb;
    private String Qc;
    private int Qd;
    private String Qe;
    private String Qf;
    private g.a Qg;
    protected l Qh;
    private boolean Qi = false;
    private boolean Qj = false;
    private volatile boolean Qk = false;
    private long Ql = 0;
    private c Qm = null;

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
                i.this.PZ = eVar.a(i.this.Qc, i.this.Qd, i.this.Qh, false);
                if (i.this.Qk) {
                    i.this.x(new k.c());
                    return;
                }
                try {
                    if (!i.this.PZ.isConnected()) {
                        i.this.x(new k.e(2, "cannot connect"));
                    } else {
                        i.this.Ql = System.currentTimeMillis() - currentTimeMillis;
                        i.this.oL();
                        i.this.oK();
                        k.b bVar = new k.b(i.this.Qc + ":" + i.this.Qd);
                        bVar.mPath = i.this.Qe;
                        bVar.mQuery = i.this.Qf;
                        bVar.Qp = i.this.PO;
                        bVar.Qq = i.this.PN;
                        i.this.PY.A(bVar);
                        if (i.this.Qk) {
                            i.this.x(new k.c());
                        }
                    }
                } catch (Throwable th) {
                    if (i.this.isDebug()) {
                        BdLog.e("----WebSocketConnector error. e:" + th.getMessage());
                    }
                    i.this.x(new k.f(new Exception(th)));
                }
            } catch (Throwable th2) {
                i.this.x(new k.e(2, th2.getMessage()));
            }
        }
    }

    public i() {
        oJ();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.Qm != null || !isOpen()) {
            if (isDebug()) {
            }
            if (cVar != null) {
                cVar.onSendError(1);
                return false;
            }
            return false;
        }
        this.Qm = cVar;
        return d(this.Qm);
    }

    private boolean d(c cVar) {
        if (this.PY == null) {
            x(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.PY.A(new k.i(cVar));
    }

    public void close(int i, String str) {
        if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
            com.baidu.adp.framework.client.socket.i.debug("more_log", 0, 0, "close", i, str);
        }
        this.Qi = false;
        this.Qk = true;
        if (this.PW != null) {
            this.PW.quit();
            this.PW = null;
        }
        if (this.PY != null) {
            this.PY.quit();
            this.PY = null;
        }
        if (this.PZ != null) {
            try {
                this.PZ.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.PZ = null;
        }
        g.a aVar = this.Qg;
        this.Qg = null;
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
        this.Qj = true;
        if (this.PZ != null && this.PZ.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.Qa = new URI(str);
            if (!this.Qa.getScheme().equals("ws") && !this.Qa.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.Qa.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.Qb = this.Qa.getScheme();
            if (this.Qa.getPort() == -1) {
                if (this.Qb.equals("ws")) {
                    this.Qd = 80;
                } else {
                    this.Qd = Constants.SOCKET_PORT_SSL;
                }
            } else {
                this.Qd = this.Qa.getPort();
            }
            if (this.Qa.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.Qc = this.Qa.getHost();
            if (this.Qa.getPath() == null || this.Qa.getPath().equals("")) {
                this.Qe = "/";
            } else {
                this.Qe = this.Qa.getPath();
            }
            if (this.Qa.getQuery() == null || this.Qa.getQuery().equals("")) {
                this.Qf = null;
            } else {
                this.Qf = this.Qa.getQuery();
            }
            this.PO = strArr;
            this.PN = list;
            this.Qg = aVar;
            this.Qh = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(Object obj) {
        Message obtainMessage = this.PV.obtainMessage();
        obtainMessage.obj = obj;
        this.PV.sendMessage(obtainMessage);
    }

    protected void oJ() {
        this.PV = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.Qg != null) {
                        i.this.Qg.onTextMessage(sVar.Qy);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.Qg != null) {
                        i.this.Qg.m(mVar.Qo);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.Qg != null) {
                        i.this.Qg.b(aVar);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0023k c0023k = new k.C0023k();
                    c0023k.Qo = ((k.j) message.obj).Qo;
                    i.this.PY.A(c0023k);
                } else if (message.obj instanceof k.C0023k) {
                    k.C0023k c0023k2 = (k.C0023k) message.obj;
                    if (i.this.Qg != null) {
                        i.this.Qg.oC();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.Qx) {
                        if (i.this.Qg != null) {
                            i.this.Qg.onOpen(qVar.mHeaders);
                            i.this.Qi = true;
                            i.this.Qj = false;
                            if (i.this.Qg != null) {
                                i.this.Qg.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).Qr;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).Qv;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).Qt.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.Qs + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).Qs);
                } else if (message.obj instanceof k.r) {
                    if (i.this.Qg != null) {
                        i.this.Qg.b(((k.r) message.obj).Qw);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.Qm = null;
                    c cVar = ((k.g) message.obj).Qw;
                    if (i.this.Qg != null) {
                        i.this.Qg.c(cVar);
                    }
                    if (i.this.Qg != null) {
                        i.this.Qg.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.Qm = null;
                    c cVar2 = ((k.n) message.obj).Qw;
                    if (i.this.Qg != null) {
                        i.this.Qg.a(2, cVar2);
                    }
                    if (i.this.Qg != null) {
                        i.this.Qg.a(cVar2);
                    }
                } else {
                    i.this.y(message.obj);
                }
            }
        };
    }

    protected void y(Object obj) {
    }

    protected void oK() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.PY = new o(handlerThread.getLooper(), this.PV, this.PZ, this.Qh);
    }

    protected void oL() {
        this.PW = new m(this.PV, this.PZ, this.Qh, "WebSocketReader");
        this.PW.start();
    }

    public boolean oM() {
        return this.Qm != null;
    }

    public boolean isConnecting() {
        return this.Qj;
    }

    public boolean isOpen() {
        return this.Qi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void oG() {
        if (this.PY != null) {
            this.PY.oG();
        }
    }

    public long getUpFlowSize() {
        if (this.PY != null) {
            return this.PY.getUpFlowSize();
        }
        return 0L;
    }

    public void oH() {
        if (this.PW != null) {
            this.PW.oH();
        }
    }

    public long getDownFlowSize() {
        if (this.PW != null) {
            return this.PW.getDownFlowSize();
        }
        return 0L;
    }

    public long oN() {
        if (this.PZ != null) {
            return this.PZ.oA();
        }
        return 0L;
    }

    public String oO() {
        if (this.PZ != null) {
            return this.PZ.oz();
        }
        return null;
    }

    public long oP() {
        return this.Ql;
    }

    public String getLocalDns() {
        if (this.PZ != null) {
            return this.PZ.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.PZ != null) {
            return this.PZ.getLocalDnsBak();
        }
        return null;
    }
}
