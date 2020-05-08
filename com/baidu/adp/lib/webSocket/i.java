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
    private List<BasicNameValuePair> Oa;
    private String[] Ob;
    protected Handler Oi;
    protected volatile m Oj;
    protected volatile o Ok;
    protected e.a Ol;
    private URI Om;
    private String Oo;
    private String Op;
    private int Oq;
    private String Or;
    private String Os;
    private g.a Ot;
    protected l Ou;
    private boolean Ov = false;
    private boolean Ow = false;
    private volatile boolean Ox = false;
    private long Oy = 0;
    private c Oz = null;

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
                i.this.Ol = eVar.a(i.this.Op, i.this.Oq, i.this.Ou, false);
                if (i.this.Ox) {
                    i.this.t(new k.c());
                    return;
                }
                try {
                    if (!i.this.Ol.isConnected()) {
                        i.this.t(new k.e(2, "cannot connect"));
                    } else {
                        i.this.Oy = System.currentTimeMillis() - currentTimeMillis;
                        i.this.mN();
                        i.this.mM();
                        k.b bVar = new k.b(i.this.Op + ":" + i.this.Oq);
                        bVar.mPath = i.this.Or;
                        bVar.mQuery = i.this.Os;
                        bVar.OC = i.this.Ob;
                        bVar.OD = i.this.Oa;
                        i.this.Ok.w(bVar);
                        if (i.this.Ox) {
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
        mL();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.Oz != null || !isOpen()) {
            if (isDebug()) {
            }
            if (cVar != null) {
                cVar.onSendError(1);
                return false;
            }
            return false;
        }
        this.Oz = cVar;
        return d(this.Oz);
    }

    private boolean d(c cVar) {
        if (this.Ok == null) {
            t(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.Ok.w(new k.i(cVar));
    }

    public void close(int i, String str) {
        if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
            com.baidu.adp.framework.client.socket.i.debug("more_log", 0, 0, "close", i, str);
        }
        this.Ov = false;
        this.Ox = true;
        if (this.Oj != null) {
            this.Oj.quit();
            this.Oj = null;
        }
        if (this.Ok != null) {
            this.Ok.quit();
            this.Ok = null;
        }
        if (this.Ol != null) {
            try {
                this.Ol.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.Ol = null;
        }
        g.a aVar = this.Ot;
        this.Ot = null;
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
        this.Ow = true;
        if (this.Ol != null && this.Ol.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.Om = new URI(str);
            if (!this.Om.getScheme().equals("ws") && !this.Om.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.Om.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.Oo = this.Om.getScheme();
            if (this.Om.getPort() == -1) {
                if (this.Oo.equals("ws")) {
                    this.Oq = 80;
                } else {
                    this.Oq = Constants.SOCKET_PORT_SSL;
                }
            } else {
                this.Oq = this.Om.getPort();
            }
            if (this.Om.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.Op = this.Om.getHost();
            if (this.Om.getPath() == null || this.Om.getPath().equals("")) {
                this.Or = "/";
            } else {
                this.Or = this.Om.getPath();
            }
            if (this.Om.getQuery() == null || this.Om.getQuery().equals("")) {
                this.Os = null;
            } else {
                this.Os = this.Om.getQuery();
            }
            this.Ob = strArr;
            this.Oa = list;
            this.Ot = aVar;
            this.Ou = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Object obj) {
        Message obtainMessage = this.Oi.obtainMessage();
        obtainMessage.obj = obj;
        this.Oi.sendMessage(obtainMessage);
    }

    protected void mL() {
        this.Oi = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.Ot != null) {
                        i.this.Ot.onTextMessage(sVar.OM);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.Ot != null) {
                        i.this.Ot.k(mVar.OB);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.Ot != null) {
                        i.this.Ot.b(aVar);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0023k c0023k = new k.C0023k();
                    c0023k.OB = ((k.j) message.obj).OB;
                    i.this.Ok.w(c0023k);
                } else if (message.obj instanceof k.C0023k) {
                    k.C0023k c0023k2 = (k.C0023k) message.obj;
                    if (i.this.Ot != null) {
                        i.this.Ot.mE();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.OL) {
                        if (i.this.Ot != null) {
                            i.this.Ot.onOpen(qVar.mHeaders);
                            i.this.Ov = true;
                            i.this.Ow = false;
                            if (i.this.Ot != null) {
                                i.this.Ot.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).OE;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).OI;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).OG.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.OF + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).OF);
                } else if (message.obj instanceof k.r) {
                    if (i.this.Ot != null) {
                        i.this.Ot.b(((k.r) message.obj).OJ);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.Oz = null;
                    c cVar = ((k.g) message.obj).OJ;
                    if (i.this.Ot != null) {
                        i.this.Ot.c(cVar);
                    }
                    if (i.this.Ot != null) {
                        i.this.Ot.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.Oz = null;
                    c cVar2 = ((k.n) message.obj).OJ;
                    if (i.this.Ot != null) {
                        i.this.Ot.a(2, cVar2);
                    }
                    if (i.this.Ot != null) {
                        i.this.Ot.a(cVar2);
                    }
                } else {
                    i.this.u(message.obj);
                }
            }
        };
    }

    protected void u(Object obj) {
    }

    protected void mM() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.Ok = new o(handlerThread.getLooper(), this.Oi, this.Ol, this.Ou);
    }

    protected void mN() {
        this.Oj = new m(this.Oi, this.Ol, this.Ou, "WebSocketReader");
        this.Oj.start();
    }

    public boolean mO() {
        return this.Oz != null;
    }

    public boolean isConnecting() {
        return this.Ow;
    }

    public boolean isOpen() {
        return this.Ov;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void mI() {
        if (this.Ok != null) {
            this.Ok.mI();
        }
    }

    public long getUpFlowSize() {
        if (this.Ok != null) {
            return this.Ok.getUpFlowSize();
        }
        return 0L;
    }

    public void mJ() {
        if (this.Oj != null) {
            this.Oj.mJ();
        }
    }

    public long getDownFlowSize() {
        if (this.Oj != null) {
            return this.Oj.getDownFlowSize();
        }
        return 0L;
    }

    public long mP() {
        if (this.Ol != null) {
            return this.Ol.mC();
        }
        return 0L;
    }

    public String mQ() {
        if (this.Ol != null) {
            return this.Ol.mB();
        }
        return null;
    }

    public long mR() {
        return this.Oy;
    }

    public String getLocalDns() {
        if (this.Ol != null) {
            return this.Ol.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.Ol != null) {
            return this.Ol.getLocalDnsBak();
        }
        return null;
    }
}
