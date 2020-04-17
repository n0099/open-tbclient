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
    private List<BasicNameValuePair> NW;
    private String[] NX;
    protected Handler Oe;
    protected volatile m Of;
    protected volatile o Og;
    protected e.a Oh;
    private URI Oi;
    private String Oj;
    private String Ok;
    private int Ol;
    private String Om;
    private String Oo;
    private g.a Op;
    protected l Oq;
    private boolean Or = false;
    private boolean Os = false;
    private volatile boolean Ot = false;
    private long Ou = 0;
    private c Ov = null;

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
                i.this.Oh = eVar.a(i.this.Ok, i.this.Ol, i.this.Oq, false);
                if (i.this.Ot) {
                    i.this.s(new k.c());
                    return;
                }
                try {
                    if (!i.this.Oh.isConnected()) {
                        i.this.s(new k.e(2, "cannot connect"));
                    } else {
                        i.this.Ou = System.currentTimeMillis() - currentTimeMillis;
                        i.this.mN();
                        i.this.mM();
                        k.b bVar = new k.b(i.this.Ok + ":" + i.this.Ol);
                        bVar.mPath = i.this.Om;
                        bVar.mQuery = i.this.Oo;
                        bVar.Oy = i.this.NX;
                        bVar.Oz = i.this.NW;
                        i.this.Og.v(bVar);
                        if (i.this.Ot) {
                            i.this.s(new k.c());
                        }
                    }
                } catch (Throwable th) {
                    if (i.this.isDebug()) {
                        BdLog.e("----WebSocketConnector error. e:" + th.getMessage());
                    }
                    i.this.s(new k.f(new Exception(th)));
                }
            } catch (Throwable th2) {
                i.this.s(new k.e(2, th2.getMessage()));
            }
        }
    }

    public i() {
        mL();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.Ov != null || !isOpen()) {
            if (isDebug()) {
            }
            if (cVar != null) {
                cVar.onSendError(1);
                return false;
            }
            return false;
        }
        this.Ov = cVar;
        return d(this.Ov);
    }

    private boolean d(c cVar) {
        if (this.Og == null) {
            s(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.Og.v(new k.i(cVar));
    }

    public void close(int i, String str) {
        if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
            com.baidu.adp.framework.client.socket.i.debug("more_log", 0, 0, "close", i, str);
        }
        this.Or = false;
        this.Ot = true;
        if (this.Of != null) {
            this.Of.quit();
            this.Of = null;
        }
        if (this.Og != null) {
            this.Og.quit();
            this.Og = null;
        }
        if (this.Oh != null) {
            try {
                this.Oh.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.Oh = null;
        }
        g.a aVar = this.Op;
        this.Op = null;
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
        this.Os = true;
        if (this.Oh != null && this.Oh.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.Oi = new URI(str);
            if (!this.Oi.getScheme().equals("ws") && !this.Oi.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.Oi.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.Oj = this.Oi.getScheme();
            if (this.Oi.getPort() == -1) {
                if (this.Oj.equals("ws")) {
                    this.Ol = 80;
                } else {
                    this.Ol = Constants.SOCKET_PORT_SSL;
                }
            } else {
                this.Ol = this.Oi.getPort();
            }
            if (this.Oi.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.Ok = this.Oi.getHost();
            if (this.Oi.getPath() == null || this.Oi.getPath().equals("")) {
                this.Om = "/";
            } else {
                this.Om = this.Oi.getPath();
            }
            if (this.Oi.getQuery() == null || this.Oi.getQuery().equals("")) {
                this.Oo = null;
            } else {
                this.Oo = this.Oi.getQuery();
            }
            this.NX = strArr;
            this.NW = list;
            this.Op = aVar;
            this.Oq = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Object obj) {
        Message obtainMessage = this.Oe.obtainMessage();
        obtainMessage.obj = obj;
        this.Oe.sendMessage(obtainMessage);
    }

    protected void mL() {
        this.Oe = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.Op != null) {
                        i.this.Op.onTextMessage(sVar.OH);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.Op != null) {
                        i.this.Op.k(mVar.Ox);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.Op != null) {
                        i.this.Op.b(aVar);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0023k c0023k = new k.C0023k();
                    c0023k.Ox = ((k.j) message.obj).Ox;
                    i.this.Og.v(c0023k);
                } else if (message.obj instanceof k.C0023k) {
                    k.C0023k c0023k2 = (k.C0023k) message.obj;
                    if (i.this.Op != null) {
                        i.this.Op.mE();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.OG) {
                        if (i.this.Op != null) {
                            i.this.Op.onOpen(qVar.mHeaders);
                            i.this.Or = true;
                            i.this.Os = false;
                            if (i.this.Op != null) {
                                i.this.Op.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).OA;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).OE;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).OC.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.OB + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).OB);
                } else if (message.obj instanceof k.r) {
                    if (i.this.Op != null) {
                        i.this.Op.b(((k.r) message.obj).OF);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.Ov = null;
                    c cVar = ((k.g) message.obj).OF;
                    if (i.this.Op != null) {
                        i.this.Op.c(cVar);
                    }
                    if (i.this.Op != null) {
                        i.this.Op.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.Ov = null;
                    c cVar2 = ((k.n) message.obj).OF;
                    if (i.this.Op != null) {
                        i.this.Op.a(2, cVar2);
                    }
                    if (i.this.Op != null) {
                        i.this.Op.a(cVar2);
                    }
                } else {
                    i.this.t(message.obj);
                }
            }
        };
    }

    protected void t(Object obj) {
    }

    protected void mM() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.Og = new o(handlerThread.getLooper(), this.Oe, this.Oh, this.Oq);
    }

    protected void mN() {
        this.Of = new m(this.Oe, this.Oh, this.Oq, "WebSocketReader");
        this.Of.start();
    }

    public boolean mO() {
        return this.Ov != null;
    }

    public boolean isConnecting() {
        return this.Os;
    }

    public boolean isOpen() {
        return this.Or;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void mI() {
        if (this.Og != null) {
            this.Og.mI();
        }
    }

    public long getUpFlowSize() {
        if (this.Og != null) {
            return this.Og.getUpFlowSize();
        }
        return 0L;
    }

    public void mJ() {
        if (this.Of != null) {
            this.Of.mJ();
        }
    }

    public long getDownFlowSize() {
        if (this.Of != null) {
            return this.Of.getDownFlowSize();
        }
        return 0L;
    }

    public long mP() {
        if (this.Oh != null) {
            return this.Oh.mC();
        }
        return 0L;
    }

    public String mQ() {
        if (this.Oh != null) {
            return this.Oh.mB();
        }
        return null;
    }

    public long mR() {
        return this.Ou;
    }

    public String getLocalDns() {
        if (this.Oh != null) {
            return this.Oh.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.Oh != null) {
            return this.Oh.getLocalDnsBak();
        }
        return null;
    }
}
