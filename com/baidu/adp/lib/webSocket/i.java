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
    private List<BasicNameValuePair> Ra;
    private String[] Rb;
    protected Handler Rh;
    protected volatile m Ri;
    protected volatile o Rj;
    protected e.a Rk;
    private URI Rl;
    private String Rm;
    private String Rn;
    private int Ro;
    private String Rp;
    private String Rq;
    private g.a Rr;
    protected l Rs;
    private boolean Rt = false;
    private boolean Ru = false;
    private volatile boolean Rv = false;
    private long Rw = 0;
    private c Rx = null;

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
                i.this.Rk = eVar.a(i.this.Rn, i.this.Ro, i.this.Rs, false);
                if (i.this.Rv) {
                    i.this.t(new k.c());
                    return;
                }
                try {
                    if (!i.this.Rk.isConnected()) {
                        i.this.t(new k.e(2, "cannot connect"));
                    } else {
                        i.this.Rw = System.currentTimeMillis() - currentTimeMillis;
                        i.this.ok();
                        i.this.oj();
                        k.b bVar = new k.b(i.this.Rn + ":" + i.this.Ro);
                        bVar.mPath = i.this.Rp;
                        bVar.mQuery = i.this.Rq;
                        bVar.RA = i.this.Rb;
                        bVar.RB = i.this.Ra;
                        i.this.Rj.w(bVar);
                        if (i.this.Rv) {
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
        oi();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.Rx != null || !isOpen()) {
            if (isDebug()) {
            }
            if (cVar != null) {
                cVar.onSendError(1);
                return false;
            }
            return false;
        }
        this.Rx = cVar;
        return d(this.Rx);
    }

    private boolean d(c cVar) {
        if (this.Rj == null) {
            t(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.Rj.w(new k.i(cVar));
    }

    public void close(int i, String str) {
        if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
            com.baidu.adp.framework.client.socket.i.debug("more_log", 0, 0, "close", i, str);
        }
        this.Rt = false;
        this.Rv = true;
        if (this.Ri != null) {
            this.Ri.quit();
            this.Ri = null;
        }
        if (this.Rj != null) {
            this.Rj.quit();
            this.Rj = null;
        }
        if (this.Rk != null) {
            try {
                this.Rk.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.Rk = null;
        }
        g.a aVar = this.Rr;
        this.Rr = null;
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
        this.Ru = true;
        if (this.Rk != null && this.Rk.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.Rl = new URI(str);
            if (!this.Rl.getScheme().equals("ws") && !this.Rl.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.Rl.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.Rm = this.Rl.getScheme();
            if (this.Rl.getPort() == -1) {
                if (this.Rm.equals("ws")) {
                    this.Ro = 80;
                } else {
                    this.Ro = Constants.SOCKET_PORT_SSL;
                }
            } else {
                this.Ro = this.Rl.getPort();
            }
            if (this.Rl.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.Rn = this.Rl.getHost();
            if (this.Rl.getPath() == null || this.Rl.getPath().equals("")) {
                this.Rp = "/";
            } else {
                this.Rp = this.Rl.getPath();
            }
            if (this.Rl.getQuery() == null || this.Rl.getQuery().equals("")) {
                this.Rq = null;
            } else {
                this.Rq = this.Rl.getQuery();
            }
            this.Rb = strArr;
            this.Ra = list;
            this.Rr = aVar;
            this.Rs = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Object obj) {
        Message obtainMessage = this.Rh.obtainMessage();
        obtainMessage.obj = obj;
        this.Rh.sendMessage(obtainMessage);
    }

    protected void oi() {
        this.Rh = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.Rr != null) {
                        i.this.Rr.onTextMessage(sVar.RI);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.Rr != null) {
                        i.this.Rr.m(mVar.Rz);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.Rr != null) {
                        i.this.Rr.b(aVar);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0019k c0019k = new k.C0019k();
                    c0019k.Rz = ((k.j) message.obj).Rz;
                    i.this.Rj.w(c0019k);
                } else if (message.obj instanceof k.C0019k) {
                    k.C0019k c0019k2 = (k.C0019k) message.obj;
                    if (i.this.Rr != null) {
                        i.this.Rr.oa();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.mSuccess) {
                        if (i.this.Rr != null) {
                            i.this.Rr.onOpen(qVar.mHeaders);
                            i.this.Rt = true;
                            i.this.Ru = false;
                            if (i.this.Rr != null) {
                                i.this.Rr.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).RC;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).RG;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).RE.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.RD + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).RD);
                } else if (message.obj instanceof k.r) {
                    if (i.this.Rr != null) {
                        i.this.Rr.b(((k.r) message.obj).RH);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.Rx = null;
                    c cVar = ((k.g) message.obj).RH;
                    if (i.this.Rr != null) {
                        i.this.Rr.c(cVar);
                    }
                    if (i.this.Rr != null) {
                        i.this.Rr.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.Rx = null;
                    c cVar2 = ((k.n) message.obj).RH;
                    if (i.this.Rr != null) {
                        i.this.Rr.a(2, cVar2);
                    }
                    if (i.this.Rr != null) {
                        i.this.Rr.a(cVar2);
                    }
                } else {
                    i.this.u(message.obj);
                }
            }
        };
    }

    protected void u(Object obj) {
    }

    protected void oj() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.Rj = new o(handlerThread.getLooper(), this.Rh, this.Rk, this.Rs);
    }

    protected void ok() {
        this.Ri = new m(this.Rh, this.Rk, this.Rs, "WebSocketReader");
        this.Ri.start();
    }

    public boolean ol() {
        return this.Rx != null;
    }

    public boolean isConnecting() {
        return this.Ru;
    }

    public boolean isOpen() {
        return this.Rt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void oe() {
        if (this.Rj != null) {
            this.Rj.oe();
        }
    }

    public long getUpFlowSize() {
        if (this.Rj != null) {
            return this.Rj.getUpFlowSize();
        }
        return 0L;
    }

    public void og() {
        if (this.Ri != null) {
            this.Ri.og();
        }
    }

    public long getDownFlowSize() {
        if (this.Ri != null) {
            return this.Ri.getDownFlowSize();
        }
        return 0L;
    }

    public long om() {
        if (this.Rk != null) {
            return this.Rk.nY();
        }
        return 0L;
    }

    public String on() {
        if (this.Rk != null) {
            return this.Rk.nX();
        }
        return null;
    }

    public long oo() {
        return this.Rw;
    }

    public String getLocalDns() {
        if (this.Rk != null) {
            return this.Rk.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.Rk != null) {
            return this.Rk.getLocalDnsBak();
        }
        return null;
    }
}
