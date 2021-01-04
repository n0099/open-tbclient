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
    private List<BasicNameValuePair> Re;
    private String[] Rf;
    protected Handler Rl;
    protected volatile m Rm;
    protected volatile o Rn;
    protected e.a Ro;
    private URI Rp;
    private String Rq;
    private String Rr;
    private int Rs;
    private String Rt;
    private String Ru;
    private g.a Rv;
    protected l Rw;
    private boolean Rx = false;
    private boolean Ry = false;
    private volatile boolean Rz = false;
    private long RA = 0;
    private c RB = null;

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
                i.this.Ro = eVar.a(i.this.Rr, i.this.Rs, i.this.Rw, false);
                if (i.this.Rz) {
                    i.this.t(new k.c());
                    return;
                }
                try {
                    if (!i.this.Ro.isConnected()) {
                        i.this.t(new k.e(2, "cannot connect"));
                    } else {
                        i.this.RA = System.currentTimeMillis() - currentTimeMillis;
                        i.this.om();
                        i.this.ol();
                        k.b bVar = new k.b(i.this.Rr + ":" + i.this.Rs);
                        bVar.mPath = i.this.Rt;
                        bVar.mQuery = i.this.Ru;
                        bVar.RE = i.this.Rf;
                        bVar.RF = i.this.Re;
                        i.this.Rn.w(bVar);
                        if (i.this.Rz) {
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
        if (this.RB != null || !isOpen()) {
            if (isDebug()) {
            }
            if (cVar != null) {
                cVar.onSendError(1);
                return false;
            }
            return false;
        }
        this.RB = cVar;
        return d(this.RB);
    }

    private boolean d(c cVar) {
        if (this.Rn == null) {
            t(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.Rn.w(new k.i(cVar));
    }

    public void close(int i, String str) {
        if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
            com.baidu.adp.framework.client.socket.i.debug("more_log", 0, 0, "close", i, str);
        }
        this.Rx = false;
        this.Rz = true;
        if (this.Rm != null) {
            this.Rm.quit();
            this.Rm = null;
        }
        if (this.Rn != null) {
            this.Rn.quit();
            this.Rn = null;
        }
        if (this.Ro != null) {
            try {
                this.Ro.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.Ro = null;
        }
        g.a aVar = this.Rv;
        this.Rv = null;
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
        this.Ry = true;
        if (this.Ro != null && this.Ro.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.Rp = new URI(str);
            if (!this.Rp.getScheme().equals("ws") && !this.Rp.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.Rp.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.Rq = this.Rp.getScheme();
            if (this.Rp.getPort() == -1) {
                if (this.Rq.equals("ws")) {
                    this.Rs = 80;
                } else {
                    this.Rs = Constants.SOCKET_PORT_SSL;
                }
            } else {
                this.Rs = this.Rp.getPort();
            }
            if (this.Rp.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.Rr = this.Rp.getHost();
            if (this.Rp.getPath() == null || this.Rp.getPath().equals("")) {
                this.Rt = "/";
            } else {
                this.Rt = this.Rp.getPath();
            }
            if (this.Rp.getQuery() == null || this.Rp.getQuery().equals("")) {
                this.Ru = null;
            } else {
                this.Ru = this.Rp.getQuery();
            }
            this.Rf = strArr;
            this.Re = list;
            this.Rv = aVar;
            this.Rw = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Object obj) {
        Message obtainMessage = this.Rl.obtainMessage();
        obtainMessage.obj = obj;
        this.Rl.sendMessage(obtainMessage);
    }

    protected void ok() {
        this.Rl = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.Rv != null) {
                        i.this.Rv.onTextMessage(sVar.RO);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.Rv != null) {
                        i.this.Rv.m(mVar.RD);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.Rv != null) {
                        i.this.Rv.b(aVar);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0019k c0019k = new k.C0019k();
                    c0019k.RD = ((k.j) message.obj).RD;
                    i.this.Rn.w(c0019k);
                } else if (message.obj instanceof k.C0019k) {
                    k.C0019k c0019k2 = (k.C0019k) message.obj;
                    if (i.this.Rv != null) {
                        i.this.Rv.oc();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.mSuccess) {
                        if (i.this.Rv != null) {
                            i.this.Rv.onOpen(qVar.mHeaders);
                            i.this.Rx = true;
                            i.this.Ry = false;
                            if (i.this.Rv != null) {
                                i.this.Rv.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).RG;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).RK;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).RI.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.RH + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).RH);
                } else if (message.obj instanceof k.r) {
                    if (i.this.Rv != null) {
                        i.this.Rv.b(((k.r) message.obj).RL);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.RB = null;
                    c cVar = ((k.g) message.obj).RL;
                    if (i.this.Rv != null) {
                        i.this.Rv.c(cVar);
                    }
                    if (i.this.Rv != null) {
                        i.this.Rv.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.RB = null;
                    c cVar2 = ((k.n) message.obj).RL;
                    if (i.this.Rv != null) {
                        i.this.Rv.a(2, cVar2);
                    }
                    if (i.this.Rv != null) {
                        i.this.Rv.a(cVar2);
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
        this.Rn = new o(handlerThread.getLooper(), this.Rl, this.Ro, this.Rw);
    }

    protected void om() {
        this.Rm = new m(this.Rl, this.Ro, this.Rw, "WebSocketReader");
        this.Rm.start();
    }

    public boolean on() {
        return this.RB != null;
    }

    public boolean isConnecting() {
        return this.Ry;
    }

    public boolean isOpen() {
        return this.Rx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void oh() {
        if (this.Rn != null) {
            this.Rn.oh();
        }
    }

    public long getUpFlowSize() {
        if (this.Rn != null) {
            return this.Rn.getUpFlowSize();
        }
        return 0L;
    }

    public void oi() {
        if (this.Rm != null) {
            this.Rm.oi();
        }
    }

    public long getDownFlowSize() {
        if (this.Rm != null) {
            return this.Rm.getDownFlowSize();
        }
        return 0L;
    }

    public long oo() {
        if (this.Ro != null) {
            return this.Ro.oa();
        }
        return 0L;
    }

    public String op() {
        if (this.Ro != null) {
            return this.Ro.nZ();
        }
        return null;
    }

    public long oq() {
        return this.RA;
    }

    public String getLocalDns() {
        if (this.Ro != null) {
            return this.Ro.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.Ro != null) {
            return this.Ro.getLocalDnsBak();
        }
        return null;
    }
}
