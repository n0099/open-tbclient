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
    private List<BasicNameValuePair> Qf;
    private String[] Qg;
    protected Handler Qm;
    protected volatile m Qn;
    protected volatile o Qo;
    protected e.a Qp;
    private URI Qq;
    private String Qr;
    private String Qs;
    private int Qt;
    private String Qu;
    private String Qv;
    private g.a Qw;
    protected l Qx;
    private boolean Qy = false;
    private boolean Qz = false;
    private volatile boolean QB = false;
    private long QC = 0;
    private c QD = null;

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
                i.this.Qp = eVar.a(i.this.Qs, i.this.Qt, i.this.Qx, false);
                if (i.this.QB) {
                    i.this.x(new k.c());
                    return;
                }
                try {
                    if (!i.this.Qp.isConnected()) {
                        i.this.x(new k.e(2, "cannot connect"));
                    } else {
                        i.this.QC = System.currentTimeMillis() - currentTimeMillis;
                        i.this.oL();
                        i.this.oK();
                        k.b bVar = new k.b(i.this.Qs + ":" + i.this.Qt);
                        bVar.mPath = i.this.Qu;
                        bVar.mQuery = i.this.Qv;
                        bVar.QG = i.this.Qg;
                        bVar.QH = i.this.Qf;
                        i.this.Qo.A(bVar);
                        if (i.this.QB) {
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
        if (this.QD != null || !isOpen()) {
            if (isDebug()) {
            }
            if (cVar != null) {
                cVar.onSendError(1);
                return false;
            }
            return false;
        }
        this.QD = cVar;
        return d(this.QD);
    }

    private boolean d(c cVar) {
        if (this.Qo == null) {
            x(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.Qo.A(new k.i(cVar));
    }

    public void close(int i, String str) {
        if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
            com.baidu.adp.framework.client.socket.i.debug("more_log", 0, 0, "close", i, str);
        }
        this.Qy = false;
        this.QB = true;
        if (this.Qn != null) {
            this.Qn.quit();
            this.Qn = null;
        }
        if (this.Qo != null) {
            this.Qo.quit();
            this.Qo = null;
        }
        if (this.Qp != null) {
            try {
                this.Qp.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.Qp = null;
        }
        g.a aVar = this.Qw;
        this.Qw = null;
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
        this.Qz = true;
        if (this.Qp != null && this.Qp.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.Qq = new URI(str);
            if (!this.Qq.getScheme().equals("ws") && !this.Qq.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.Qq.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.Qr = this.Qq.getScheme();
            if (this.Qq.getPort() == -1) {
                if (this.Qr.equals("ws")) {
                    this.Qt = 80;
                } else {
                    this.Qt = Constants.SOCKET_PORT_SSL;
                }
            } else {
                this.Qt = this.Qq.getPort();
            }
            if (this.Qq.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.Qs = this.Qq.getHost();
            if (this.Qq.getPath() == null || this.Qq.getPath().equals("")) {
                this.Qu = "/";
            } else {
                this.Qu = this.Qq.getPath();
            }
            if (this.Qq.getQuery() == null || this.Qq.getQuery().equals("")) {
                this.Qv = null;
            } else {
                this.Qv = this.Qq.getQuery();
            }
            this.Qg = strArr;
            this.Qf = list;
            this.Qw = aVar;
            this.Qx = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(Object obj) {
        Message obtainMessage = this.Qm.obtainMessage();
        obtainMessage.obj = obj;
        this.Qm.sendMessage(obtainMessage);
    }

    protected void oJ() {
        this.Qm = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.Qw != null) {
                        i.this.Qw.onTextMessage(sVar.QP);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.Qw != null) {
                        i.this.Qw.m(mVar.QF);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.Qw != null) {
                        i.this.Qw.b(aVar);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0024k c0024k = new k.C0024k();
                    c0024k.QF = ((k.j) message.obj).QF;
                    i.this.Qo.A(c0024k);
                } else if (message.obj instanceof k.C0024k) {
                    k.C0024k c0024k2 = (k.C0024k) message.obj;
                    if (i.this.Qw != null) {
                        i.this.Qw.oC();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.QO) {
                        if (i.this.Qw != null) {
                            i.this.Qw.onOpen(qVar.mHeaders);
                            i.this.Qy = true;
                            i.this.Qz = false;
                            if (i.this.Qw != null) {
                                i.this.Qw.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).QI;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).QM;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).QK.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.QJ + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).QJ);
                } else if (message.obj instanceof k.r) {
                    if (i.this.Qw != null) {
                        i.this.Qw.b(((k.r) message.obj).QN);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.QD = null;
                    c cVar = ((k.g) message.obj).QN;
                    if (i.this.Qw != null) {
                        i.this.Qw.c(cVar);
                    }
                    if (i.this.Qw != null) {
                        i.this.Qw.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.QD = null;
                    c cVar2 = ((k.n) message.obj).QN;
                    if (i.this.Qw != null) {
                        i.this.Qw.a(2, cVar2);
                    }
                    if (i.this.Qw != null) {
                        i.this.Qw.a(cVar2);
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
        this.Qo = new o(handlerThread.getLooper(), this.Qm, this.Qp, this.Qx);
    }

    protected void oL() {
        this.Qn = new m(this.Qm, this.Qp, this.Qx, "WebSocketReader");
        this.Qn.start();
    }

    public boolean oM() {
        return this.QD != null;
    }

    public boolean isConnecting() {
        return this.Qz;
    }

    public boolean isOpen() {
        return this.Qy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void oG() {
        if (this.Qo != null) {
            this.Qo.oG();
        }
    }

    public long getUpFlowSize() {
        if (this.Qo != null) {
            return this.Qo.getUpFlowSize();
        }
        return 0L;
    }

    public void oH() {
        if (this.Qn != null) {
            this.Qn.oH();
        }
    }

    public long getDownFlowSize() {
        if (this.Qn != null) {
            return this.Qn.getDownFlowSize();
        }
        return 0L;
    }

    public long oN() {
        if (this.Qp != null) {
            return this.Qp.oA();
        }
        return 0L;
    }

    public String oO() {
        if (this.Qp != null) {
            return this.Qp.oz();
        }
        return null;
    }

    public long oP() {
        return this.QC;
    }

    public String getLocalDns() {
        if (this.Qp != null) {
            return this.Qp.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.Qp != null) {
            return this.Qp.getLocalDnsBak();
        }
        return null;
    }
}
