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
    private boolean QB = false;
    private boolean QC = false;
    private volatile boolean QD = false;
    private long QE = 0;
    private c QF = null;
    private List<BasicNameValuePair> Qh;
    private String[] Qi;
    protected Handler Qo;
    protected volatile m Qp;
    protected volatile o Qq;
    protected e.a Qr;
    private URI Qs;
    private String Qt;
    private String Qu;
    private int Qv;
    private String Qw;
    private String Qx;
    private g.a Qy;
    protected l Qz;

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
                i.this.Qr = eVar.a(i.this.Qu, i.this.Qv, i.this.Qz, false);
                if (i.this.QD) {
                    i.this.x(new k.c());
                    return;
                }
                try {
                    if (!i.this.Qr.isConnected()) {
                        i.this.x(new k.e(2, "cannot connect"));
                    } else {
                        i.this.QE = System.currentTimeMillis() - currentTimeMillis;
                        i.this.oL();
                        i.this.oK();
                        k.b bVar = new k.b(i.this.Qu + ":" + i.this.Qv);
                        bVar.mPath = i.this.Qw;
                        bVar.mQuery = i.this.Qx;
                        bVar.QI = i.this.Qi;
                        bVar.QJ = i.this.Qh;
                        i.this.Qq.A(bVar);
                        if (i.this.QD) {
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
        if (this.QF != null || !isOpen()) {
            if (isDebug()) {
            }
            if (cVar != null) {
                cVar.onSendError(1);
                return false;
            }
            return false;
        }
        this.QF = cVar;
        return d(this.QF);
    }

    private boolean d(c cVar) {
        if (this.Qq == null) {
            x(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.Qq.A(new k.i(cVar));
    }

    public void close(int i, String str) {
        if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
            com.baidu.adp.framework.client.socket.i.debug("more_log", 0, 0, "close", i, str);
        }
        this.QB = false;
        this.QD = true;
        if (this.Qp != null) {
            this.Qp.quit();
            this.Qp = null;
        }
        if (this.Qq != null) {
            this.Qq.quit();
            this.Qq = null;
        }
        if (this.Qr != null) {
            try {
                this.Qr.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.Qr = null;
        }
        g.a aVar = this.Qy;
        this.Qy = null;
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
        this.QC = true;
        if (this.Qr != null && this.Qr.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.Qs = new URI(str);
            if (!this.Qs.getScheme().equals("ws") && !this.Qs.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.Qs.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.Qt = this.Qs.getScheme();
            if (this.Qs.getPort() == -1) {
                if (this.Qt.equals("ws")) {
                    this.Qv = 80;
                } else {
                    this.Qv = Constants.SOCKET_PORT_SSL;
                }
            } else {
                this.Qv = this.Qs.getPort();
            }
            if (this.Qs.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.Qu = this.Qs.getHost();
            if (this.Qs.getPath() == null || this.Qs.getPath().equals("")) {
                this.Qw = "/";
            } else {
                this.Qw = this.Qs.getPath();
            }
            if (this.Qs.getQuery() == null || this.Qs.getQuery().equals("")) {
                this.Qx = null;
            } else {
                this.Qx = this.Qs.getQuery();
            }
            this.Qi = strArr;
            this.Qh = list;
            this.Qy = aVar;
            this.Qz = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(Object obj) {
        Message obtainMessage = this.Qo.obtainMessage();
        obtainMessage.obj = obj;
        this.Qo.sendMessage(obtainMessage);
    }

    protected void oJ() {
        this.Qo = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.Qy != null) {
                        i.this.Qy.onTextMessage(sVar.QS);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.Qy != null) {
                        i.this.Qy.m(mVar.QH);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.Qy != null) {
                        i.this.Qy.b(aVar);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0024k c0024k = new k.C0024k();
                    c0024k.QH = ((k.j) message.obj).QH;
                    i.this.Qq.A(c0024k);
                } else if (message.obj instanceof k.C0024k) {
                    k.C0024k c0024k2 = (k.C0024k) message.obj;
                    if (i.this.Qy != null) {
                        i.this.Qy.oC();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.QR) {
                        if (i.this.Qy != null) {
                            i.this.Qy.onOpen(qVar.mHeaders);
                            i.this.QB = true;
                            i.this.QC = false;
                            if (i.this.Qy != null) {
                                i.this.Qy.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).QK;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).QO;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).QM.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.QL + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).QL);
                } else if (message.obj instanceof k.r) {
                    if (i.this.Qy != null) {
                        i.this.Qy.b(((k.r) message.obj).QP);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.QF = null;
                    c cVar = ((k.g) message.obj).QP;
                    if (i.this.Qy != null) {
                        i.this.Qy.c(cVar);
                    }
                    if (i.this.Qy != null) {
                        i.this.Qy.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.QF = null;
                    c cVar2 = ((k.n) message.obj).QP;
                    if (i.this.Qy != null) {
                        i.this.Qy.a(2, cVar2);
                    }
                    if (i.this.Qy != null) {
                        i.this.Qy.a(cVar2);
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
        this.Qq = new o(handlerThread.getLooper(), this.Qo, this.Qr, this.Qz);
    }

    protected void oL() {
        this.Qp = new m(this.Qo, this.Qr, this.Qz, "WebSocketReader");
        this.Qp.start();
    }

    public boolean oM() {
        return this.QF != null;
    }

    public boolean isConnecting() {
        return this.QC;
    }

    public boolean isOpen() {
        return this.QB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void oG() {
        if (this.Qq != null) {
            this.Qq.oG();
        }
    }

    public long getUpFlowSize() {
        if (this.Qq != null) {
            return this.Qq.getUpFlowSize();
        }
        return 0L;
    }

    public void oH() {
        if (this.Qp != null) {
            this.Qp.oH();
        }
    }

    public long getDownFlowSize() {
        if (this.Qp != null) {
            return this.Qp.getDownFlowSize();
        }
        return 0L;
    }

    public long oN() {
        if (this.Qr != null) {
            return this.Qr.oA();
        }
        return 0L;
    }

    public String oO() {
        if (this.Qr != null) {
            return this.Qr.oz();
        }
        return null;
    }

    public long oP() {
        return this.QE;
    }

    public String getLocalDns() {
        if (this.Qr != null) {
            return this.Qr.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.Qr != null) {
            return this.Qr.getLocalDnsBak();
        }
        return null;
    }
}
