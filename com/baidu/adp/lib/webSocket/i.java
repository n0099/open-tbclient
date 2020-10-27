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
    private List<BasicNameValuePair> Qg;
    private String[] Qh;
    protected Handler Qn;
    protected volatile m Qo;
    protected volatile o Qp;
    protected e.a Qq;
    private URI Qr;
    private String Qs;
    private String Qt;
    private int Qu;
    private String Qv;
    private String Qw;
    private g.a Qx;
    protected l Qy;
    private boolean Qz = false;
    private boolean QB = false;
    private volatile boolean QC = false;
    private long QD = 0;
    private c QE = null;

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
                i.this.Qq = eVar.a(i.this.Qt, i.this.Qu, i.this.Qy, false);
                if (i.this.QC) {
                    i.this.x(new k.c());
                    return;
                }
                try {
                    if (!i.this.Qq.isConnected()) {
                        i.this.x(new k.e(2, "cannot connect"));
                    } else {
                        i.this.QD = System.currentTimeMillis() - currentTimeMillis;
                        i.this.oL();
                        i.this.oK();
                        k.b bVar = new k.b(i.this.Qt + ":" + i.this.Qu);
                        bVar.mPath = i.this.Qv;
                        bVar.mQuery = i.this.Qw;
                        bVar.QH = i.this.Qh;
                        bVar.QI = i.this.Qg;
                        i.this.Qp.A(bVar);
                        if (i.this.QC) {
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
        if (this.QE != null || !isOpen()) {
            if (isDebug()) {
            }
            if (cVar != null) {
                cVar.onSendError(1);
                return false;
            }
            return false;
        }
        this.QE = cVar;
        return d(this.QE);
    }

    private boolean d(c cVar) {
        if (this.Qp == null) {
            x(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.Qp.A(new k.i(cVar));
    }

    public void close(int i, String str) {
        if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
            com.baidu.adp.framework.client.socket.i.debug("more_log", 0, 0, "close", i, str);
        }
        this.Qz = false;
        this.QC = true;
        if (this.Qo != null) {
            this.Qo.quit();
            this.Qo = null;
        }
        if (this.Qp != null) {
            this.Qp.quit();
            this.Qp = null;
        }
        if (this.Qq != null) {
            try {
                this.Qq.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.Qq = null;
        }
        g.a aVar = this.Qx;
        this.Qx = null;
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
        this.QB = true;
        if (this.Qq != null && this.Qq.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.Qr = new URI(str);
            if (!this.Qr.getScheme().equals("ws") && !this.Qr.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.Qr.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.Qs = this.Qr.getScheme();
            if (this.Qr.getPort() == -1) {
                if (this.Qs.equals("ws")) {
                    this.Qu = 80;
                } else {
                    this.Qu = Constants.SOCKET_PORT_SSL;
                }
            } else {
                this.Qu = this.Qr.getPort();
            }
            if (this.Qr.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.Qt = this.Qr.getHost();
            if (this.Qr.getPath() == null || this.Qr.getPath().equals("")) {
                this.Qv = "/";
            } else {
                this.Qv = this.Qr.getPath();
            }
            if (this.Qr.getQuery() == null || this.Qr.getQuery().equals("")) {
                this.Qw = null;
            } else {
                this.Qw = this.Qr.getQuery();
            }
            this.Qh = strArr;
            this.Qg = list;
            this.Qx = aVar;
            this.Qy = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(Object obj) {
        Message obtainMessage = this.Qn.obtainMessage();
        obtainMessage.obj = obj;
        this.Qn.sendMessage(obtainMessage);
    }

    protected void oJ() {
        this.Qn = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.Qx != null) {
                        i.this.Qx.onTextMessage(sVar.QR);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.Qx != null) {
                        i.this.Qx.m(mVar.QG);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.Qx != null) {
                        i.this.Qx.b(aVar);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0024k c0024k = new k.C0024k();
                    c0024k.QG = ((k.j) message.obj).QG;
                    i.this.Qp.A(c0024k);
                } else if (message.obj instanceof k.C0024k) {
                    k.C0024k c0024k2 = (k.C0024k) message.obj;
                    if (i.this.Qx != null) {
                        i.this.Qx.oC();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.QP) {
                        if (i.this.Qx != null) {
                            i.this.Qx.onOpen(qVar.mHeaders);
                            i.this.Qz = true;
                            i.this.QB = false;
                            if (i.this.Qx != null) {
                                i.this.Qx.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).QJ;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).QN;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).QL.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.QK + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).QK);
                } else if (message.obj instanceof k.r) {
                    if (i.this.Qx != null) {
                        i.this.Qx.b(((k.r) message.obj).QO);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.QE = null;
                    c cVar = ((k.g) message.obj).QO;
                    if (i.this.Qx != null) {
                        i.this.Qx.c(cVar);
                    }
                    if (i.this.Qx != null) {
                        i.this.Qx.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.QE = null;
                    c cVar2 = ((k.n) message.obj).QO;
                    if (i.this.Qx != null) {
                        i.this.Qx.a(2, cVar2);
                    }
                    if (i.this.Qx != null) {
                        i.this.Qx.a(cVar2);
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
        this.Qp = new o(handlerThread.getLooper(), this.Qn, this.Qq, this.Qy);
    }

    protected void oL() {
        this.Qo = new m(this.Qn, this.Qq, this.Qy, "WebSocketReader");
        this.Qo.start();
    }

    public boolean oM() {
        return this.QE != null;
    }

    public boolean isConnecting() {
        return this.QB;
    }

    public boolean isOpen() {
        return this.Qz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void oG() {
        if (this.Qp != null) {
            this.Qp.oG();
        }
    }

    public long getUpFlowSize() {
        if (this.Qp != null) {
            return this.Qp.getUpFlowSize();
        }
        return 0L;
    }

    public void oH() {
        if (this.Qo != null) {
            this.Qo.oH();
        }
    }

    public long getDownFlowSize() {
        if (this.Qo != null) {
            return this.Qo.getDownFlowSize();
        }
        return 0L;
    }

    public long oN() {
        if (this.Qq != null) {
            return this.Qq.oA();
        }
        return 0L;
    }

    public String oO() {
        if (this.Qq != null) {
            return this.Qq.oz();
        }
        return null;
    }

    public long oP() {
        return this.QD;
    }

    public String getLocalDns() {
        if (this.Qq != null) {
            return this.Qq.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.Qq != null) {
            return this.Qq.getLocalDnsBak();
        }
        return null;
    }
}
