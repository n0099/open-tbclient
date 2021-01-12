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
    private List<BasicNameValuePair> Rc;
    private String[] Rd;
    protected Handler Rj;
    protected volatile m Rk;
    protected volatile o Rl;
    protected e.a Rm;
    private URI Rn;
    private String Ro;
    private String Rp;
    private int Rq;
    private String Rr;
    private String Rs;
    private g.a Rt;
    protected l Ru;
    private boolean Rv = false;
    private boolean Rw = false;
    private volatile boolean Rx = false;
    private long Ry = 0;
    private c Rz = null;

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
                i.this.Rm = eVar.a(i.this.Rp, i.this.Rq, i.this.Ru, false);
                if (i.this.Rx) {
                    i.this.t(new k.c());
                    return;
                }
                try {
                    if (!i.this.Rm.isConnected()) {
                        i.this.t(new k.e(2, "cannot connect"));
                    } else {
                        i.this.Ry = System.currentTimeMillis() - currentTimeMillis;
                        i.this.om();
                        i.this.ol();
                        k.b bVar = new k.b(i.this.Rp + ":" + i.this.Rq);
                        bVar.mPath = i.this.Rr;
                        bVar.mQuery = i.this.Rs;
                        bVar.RC = i.this.Rd;
                        bVar.RD = i.this.Rc;
                        i.this.Rl.w(bVar);
                        if (i.this.Rx) {
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
        ok();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.Rz != null || !isOpen()) {
            if (isDebug()) {
            }
            if (cVar != null) {
                cVar.onSendError(1);
                return false;
            }
            return false;
        }
        this.Rz = cVar;
        return d(this.Rz);
    }

    private boolean d(c cVar) {
        if (this.Rl == null) {
            t(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.Rl.w(new k.i(cVar));
    }

    public void close(int i, String str) {
        if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
            com.baidu.adp.framework.client.socket.i.debug("more_log", 0, 0, "close", i, str);
        }
        this.Rv = false;
        this.Rx = true;
        if (this.Rk != null) {
            this.Rk.quit();
            this.Rk = null;
        }
        if (this.Rl != null) {
            this.Rl.quit();
            this.Rl = null;
        }
        if (this.Rm != null) {
            try {
                this.Rm.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.Rm = null;
        }
        g.a aVar = this.Rt;
        this.Rt = null;
        if (aVar != null) {
            try {
                aVar.d(i, str);
            } catch (Exception e) {
                if (isDebug()) {
                    BdLog.d(e.getMessage());
                }
            }
        }
    }

    public void a(String str, String[] strArr, g.a aVar, l lVar, List<BasicNameValuePair> list) throws WebSocketException {
        this.Rw = true;
        if (this.Rm != null && this.Rm.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.Rn = new URI(str);
            if (!this.Rn.getScheme().equals("ws") && !this.Rn.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.Rn.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.Ro = this.Rn.getScheme();
            if (this.Rn.getPort() == -1) {
                if (this.Ro.equals("ws")) {
                    this.Rq = 80;
                } else {
                    this.Rq = Constants.SOCKET_PORT_SSL;
                }
            } else {
                this.Rq = this.Rn.getPort();
            }
            if (this.Rn.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.Rp = this.Rn.getHost();
            if (this.Rn.getPath() == null || this.Rn.getPath().equals("")) {
                this.Rr = "/";
            } else {
                this.Rr = this.Rn.getPath();
            }
            if (this.Rn.getQuery() == null || this.Rn.getQuery().equals("")) {
                this.Rs = null;
            } else {
                this.Rs = this.Rn.getQuery();
            }
            this.Rd = strArr;
            this.Rc = list;
            this.Rt = aVar;
            this.Ru = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Object obj) {
        Message obtainMessage = this.Rj.obtainMessage();
        obtainMessage.obj = obj;
        this.Rj.sendMessage(obtainMessage);
    }

    protected void ok() {
        this.Rj = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.Rt != null) {
                        i.this.Rt.onTextMessage(sVar.RK);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.Rt != null) {
                        i.this.Rt.m(mVar.RB);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.Rt != null) {
                        i.this.Rt.b(aVar);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0019k c0019k = new k.C0019k();
                    c0019k.RB = ((k.j) message.obj).RB;
                    i.this.Rl.w(c0019k);
                } else if (message.obj instanceof k.C0019k) {
                    k.C0019k c0019k2 = (k.C0019k) message.obj;
                    if (i.this.Rt != null) {
                        i.this.Rt.oc();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.mSuccess) {
                        if (i.this.Rt != null) {
                            i.this.Rt.onOpen(qVar.mHeaders);
                            i.this.Rv = true;
                            i.this.Rw = false;
                            if (i.this.Rt != null) {
                                i.this.Rt.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).RE;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).RI;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).RG.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.RF + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).RF);
                } else if (message.obj instanceof k.r) {
                    if (i.this.Rt != null) {
                        i.this.Rt.b(((k.r) message.obj).RJ);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.Rz = null;
                    c cVar = ((k.g) message.obj).RJ;
                    if (i.this.Rt != null) {
                        i.this.Rt.c(cVar);
                    }
                    if (i.this.Rt != null) {
                        i.this.Rt.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.Rz = null;
                    c cVar2 = ((k.n) message.obj).RJ;
                    if (i.this.Rt != null) {
                        i.this.Rt.a(2, cVar2);
                    }
                    if (i.this.Rt != null) {
                        i.this.Rt.a(cVar2);
                    }
                } else {
                    i.this.u(message.obj);
                }
            }
        };
    }

    protected void u(Object obj) {
    }

    protected void ol() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.Rl = new o(handlerThread.getLooper(), this.Rj, this.Rm, this.Ru);
    }

    protected void om() {
        this.Rk = new m(this.Rj, this.Rm, this.Ru, "WebSocketReader");
        this.Rk.start();
    }

    public boolean on() {
        return this.Rz != null;
    }

    public boolean isConnecting() {
        return this.Rw;
    }

    public boolean isOpen() {
        return this.Rv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void oh() {
        if (this.Rl != null) {
            this.Rl.oh();
        }
    }

    public long getUpFlowSize() {
        if (this.Rl != null) {
            return this.Rl.getUpFlowSize();
        }
        return 0L;
    }

    public void oi() {
        if (this.Rk != null) {
            this.Rk.oi();
        }
    }

    public long getDownFlowSize() {
        if (this.Rk != null) {
            return this.Rk.getDownFlowSize();
        }
        return 0L;
    }

    public long oo() {
        if (this.Rm != null) {
            return this.Rm.oa();
        }
        return 0L;
    }

    public String op() {
        if (this.Rm != null) {
            return this.Rm.nZ();
        }
        return null;
    }

    public long oq() {
        return this.Ry;
    }

    public String getLocalDns() {
        if (this.Rm != null) {
            return this.Rm.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.Rm != null) {
            return this.Rm.getLocalDnsBak();
        }
        return null;
    }
}
