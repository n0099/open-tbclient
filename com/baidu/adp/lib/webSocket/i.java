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
    private List<BasicNameValuePair> Rb;
    private String[] Rc;
    protected Handler Ri;
    protected volatile m Rj;
    protected volatile o Rk;
    protected e.a Rl;
    private URI Rm;
    private String Rn;
    private String Ro;
    private int Rp;
    private String Rq;
    private String Rr;
    private g.a Rs;
    protected l Rt;
    private boolean Ru = false;
    private boolean Rv = false;
    private volatile boolean Rw = false;
    private long Rx = 0;
    private c Ry = null;

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
                i.this.Rl = eVar.a(i.this.Ro, i.this.Rp, i.this.Rt, false);
                if (i.this.Rw) {
                    i.this.x(new k.c());
                    return;
                }
                try {
                    if (!i.this.Rl.isConnected()) {
                        i.this.x(new k.e(2, "cannot connect"));
                    } else {
                        i.this.Rx = System.currentTimeMillis() - currentTimeMillis;
                        i.this.oL();
                        i.this.oK();
                        k.b bVar = new k.b(i.this.Ro + ":" + i.this.Rp);
                        bVar.mPath = i.this.Rq;
                        bVar.mQuery = i.this.Rr;
                        bVar.RB = i.this.Rc;
                        bVar.RC = i.this.Rb;
                        i.this.Rk.A(bVar);
                        if (i.this.Rw) {
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
        if (this.Ry != null || !isOpen()) {
            if (isDebug()) {
            }
            if (cVar != null) {
                cVar.onSendError(1);
                return false;
            }
            return false;
        }
        this.Ry = cVar;
        return d(this.Ry);
    }

    private boolean d(c cVar) {
        if (this.Rk == null) {
            x(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.Rk.A(new k.i(cVar));
    }

    public void close(int i, String str) {
        if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
            com.baidu.adp.framework.client.socket.i.debug("more_log", 0, 0, "close", i, str);
        }
        this.Ru = false;
        this.Rw = true;
        if (this.Rj != null) {
            this.Rj.quit();
            this.Rj = null;
        }
        if (this.Rk != null) {
            this.Rk.quit();
            this.Rk = null;
        }
        if (this.Rl != null) {
            try {
                this.Rl.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.Rl = null;
        }
        g.a aVar = this.Rs;
        this.Rs = null;
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
        this.Rv = true;
        if (this.Rl != null && this.Rl.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.Rm = new URI(str);
            if (!this.Rm.getScheme().equals("ws") && !this.Rm.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.Rm.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.Rn = this.Rm.getScheme();
            if (this.Rm.getPort() == -1) {
                if (this.Rn.equals("ws")) {
                    this.Rp = 80;
                } else {
                    this.Rp = Constants.SOCKET_PORT_SSL;
                }
            } else {
                this.Rp = this.Rm.getPort();
            }
            if (this.Rm.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.Ro = this.Rm.getHost();
            if (this.Rm.getPath() == null || this.Rm.getPath().equals("")) {
                this.Rq = "/";
            } else {
                this.Rq = this.Rm.getPath();
            }
            if (this.Rm.getQuery() == null || this.Rm.getQuery().equals("")) {
                this.Rr = null;
            } else {
                this.Rr = this.Rm.getQuery();
            }
            this.Rc = strArr;
            this.Rb = list;
            this.Rs = aVar;
            this.Rt = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(Object obj) {
        Message obtainMessage = this.Ri.obtainMessage();
        obtainMessage.obj = obj;
        this.Ri.sendMessage(obtainMessage);
    }

    protected void oJ() {
        this.Ri = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.Rs != null) {
                        i.this.Rs.onTextMessage(sVar.RJ);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.Rs != null) {
                        i.this.Rs.m(mVar.RA);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.Rs != null) {
                        i.this.Rs.b(aVar);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0024k c0024k = new k.C0024k();
                    c0024k.RA = ((k.j) message.obj).RA;
                    i.this.Rk.A(c0024k);
                } else if (message.obj instanceof k.C0024k) {
                    k.C0024k c0024k2 = (k.C0024k) message.obj;
                    if (i.this.Rs != null) {
                        i.this.Rs.oB();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.mSuccess) {
                        if (i.this.Rs != null) {
                            i.this.Rs.onOpen(qVar.mHeaders);
                            i.this.Ru = true;
                            i.this.Rv = false;
                            if (i.this.Rs != null) {
                                i.this.Rs.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).RD;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).RH;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).RF.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.RE + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).RE);
                } else if (message.obj instanceof k.r) {
                    if (i.this.Rs != null) {
                        i.this.Rs.b(((k.r) message.obj).RI);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.Ry = null;
                    c cVar = ((k.g) message.obj).RI;
                    if (i.this.Rs != null) {
                        i.this.Rs.c(cVar);
                    }
                    if (i.this.Rs != null) {
                        i.this.Rs.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.Ry = null;
                    c cVar2 = ((k.n) message.obj).RI;
                    if (i.this.Rs != null) {
                        i.this.Rs.a(2, cVar2);
                    }
                    if (i.this.Rs != null) {
                        i.this.Rs.a(cVar2);
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
        this.Rk = new o(handlerThread.getLooper(), this.Ri, this.Rl, this.Rt);
    }

    protected void oL() {
        this.Rj = new m(this.Ri, this.Rl, this.Rt, "WebSocketReader");
        this.Rj.start();
    }

    public boolean oM() {
        return this.Ry != null;
    }

    public boolean isConnecting() {
        return this.Rv;
    }

    public boolean isOpen() {
        return this.Ru;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void oG() {
        if (this.Rk != null) {
            this.Rk.oG();
        }
    }

    public long getUpFlowSize() {
        if (this.Rk != null) {
            return this.Rk.getUpFlowSize();
        }
        return 0L;
    }

    public void oH() {
        if (this.Rj != null) {
            this.Rj.oH();
        }
    }

    public long getDownFlowSize() {
        if (this.Rj != null) {
            return this.Rj.getDownFlowSize();
        }
        return 0L;
    }

    public long oN() {
        if (this.Rl != null) {
            return this.Rl.oz();
        }
        return 0L;
    }

    public String oO() {
        if (this.Rl != null) {
            return this.Rl.oy();
        }
        return null;
    }

    public long oP() {
        return this.Rx;
    }

    public String getLocalDns() {
        if (this.Rl != null) {
            return this.Rl.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.Rl != null) {
            return this.Rl.getLocalDnsBak();
        }
        return null;
    }
}
