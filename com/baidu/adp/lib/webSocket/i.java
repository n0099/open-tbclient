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
    private g.a OA;
    protected l OB;
    private boolean OC = false;
    private boolean OD = false;
    private volatile boolean OE = false;
    private long OF = 0;
    private c OG = null;
    private List<BasicNameValuePair> Oi;
    private String[] Oj;
    protected Handler Oq;
    protected volatile m Or;
    protected volatile o Os;
    protected e.a Ot;
    private URI Ou;
    private String Ov;
    private String Ow;
    private int Ox;
    private String Oy;
    private String Oz;

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
                i.this.Ot = eVar.a(i.this.Ow, i.this.Ox, i.this.OB, false);
                if (i.this.OE) {
                    i.this.v(new k.c());
                    return;
                }
                try {
                    if (!i.this.Ot.isConnected()) {
                        i.this.v(new k.e(2, "cannot connect"));
                    } else {
                        i.this.OF = System.currentTimeMillis() - currentTimeMillis;
                        i.this.mP();
                        i.this.mO();
                        k.b bVar = new k.b(i.this.Ow + ":" + i.this.Ox);
                        bVar.mPath = i.this.Oy;
                        bVar.mQuery = i.this.Oz;
                        bVar.OJ = i.this.Oj;
                        bVar.OL = i.this.Oi;
                        i.this.Os.y(bVar);
                        if (i.this.OE) {
                            i.this.v(new k.c());
                        }
                    }
                } catch (Throwable th) {
                    if (i.this.isDebug()) {
                        BdLog.e("----WebSocketConnector error. e:" + th.getMessage());
                    }
                    i.this.v(new k.f(new Exception(th)));
                }
            } catch (Throwable th2) {
                i.this.v(new k.e(2, th2.getMessage()));
            }
        }
    }

    public i() {
        mN();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.OG != null || !isOpen()) {
            if (isDebug()) {
            }
            if (cVar != null) {
                cVar.onSendError(1);
                return false;
            }
            return false;
        }
        this.OG = cVar;
        return d(this.OG);
    }

    private boolean d(c cVar) {
        if (this.Os == null) {
            v(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.Os.y(new k.i(cVar));
    }

    public void close(int i, String str) {
        if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
            com.baidu.adp.framework.client.socket.i.debug("more_log", 0, 0, "close", i, str);
        }
        this.OC = false;
        this.OE = true;
        if (this.Or != null) {
            this.Or.quit();
            this.Or = null;
        }
        if (this.Os != null) {
            this.Os.quit();
            this.Os = null;
        }
        if (this.Ot != null) {
            try {
                this.Ot.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.Ot = null;
        }
        g.a aVar = this.OA;
        this.OA = null;
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
        this.OD = true;
        if (this.Ot != null && this.Ot.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.Ou = new URI(str);
            if (!this.Ou.getScheme().equals("ws") && !this.Ou.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.Ou.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.Ov = this.Ou.getScheme();
            if (this.Ou.getPort() == -1) {
                if (this.Ov.equals("ws")) {
                    this.Ox = 80;
                } else {
                    this.Ox = Constants.SOCKET_PORT_SSL;
                }
            } else {
                this.Ox = this.Ou.getPort();
            }
            if (this.Ou.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.Ow = this.Ou.getHost();
            if (this.Ou.getPath() == null || this.Ou.getPath().equals("")) {
                this.Oy = "/";
            } else {
                this.Oy = this.Ou.getPath();
            }
            if (this.Ou.getQuery() == null || this.Ou.getQuery().equals("")) {
                this.Oz = null;
            } else {
                this.Oz = this.Ou.getQuery();
            }
            this.Oj = strArr;
            this.Oi = list;
            this.OA = aVar;
            this.OB = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(Object obj) {
        Message obtainMessage = this.Oq.obtainMessage();
        obtainMessage.obj = obj;
        this.Oq.sendMessage(obtainMessage);
    }

    protected void mN() {
        this.Oq = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.OA != null) {
                        i.this.OA.onTextMessage(sVar.OV);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.OA != null) {
                        i.this.OA.k(mVar.OI);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.OA != null) {
                        i.this.OA.b(aVar);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0025k c0025k = new k.C0025k();
                    c0025k.OI = ((k.j) message.obj).OI;
                    i.this.Os.y(c0025k);
                } else if (message.obj instanceof k.C0025k) {
                    k.C0025k c0025k2 = (k.C0025k) message.obj;
                    if (i.this.OA != null) {
                        i.this.OA.mG();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.OU) {
                        if (i.this.OA != null) {
                            i.this.OA.onOpen(qVar.mHeaders);
                            i.this.OC = true;
                            i.this.OD = false;
                            if (i.this.OA != null) {
                                i.this.OA.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).OM;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).OR;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).OP.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.OO + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).OO);
                } else if (message.obj instanceof k.r) {
                    if (i.this.OA != null) {
                        i.this.OA.b(((k.r) message.obj).OT);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.OG = null;
                    c cVar = ((k.g) message.obj).OT;
                    if (i.this.OA != null) {
                        i.this.OA.c(cVar);
                    }
                    if (i.this.OA != null) {
                        i.this.OA.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.OG = null;
                    c cVar2 = ((k.n) message.obj).OT;
                    if (i.this.OA != null) {
                        i.this.OA.a(2, cVar2);
                    }
                    if (i.this.OA != null) {
                        i.this.OA.a(cVar2);
                    }
                } else {
                    i.this.w(message.obj);
                }
            }
        };
    }

    protected void w(Object obj) {
    }

    protected void mO() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.Os = new o(handlerThread.getLooper(), this.Oq, this.Ot, this.OB);
    }

    protected void mP() {
        this.Or = new m(this.Oq, this.Ot, this.OB, "WebSocketReader");
        this.Or.start();
    }

    public boolean mQ() {
        return this.OG != null;
    }

    public boolean isConnecting() {
        return this.OD;
    }

    public boolean isOpen() {
        return this.OC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void mK() {
        if (this.Os != null) {
            this.Os.mK();
        }
    }

    public long getUpFlowSize() {
        if (this.Os != null) {
            return this.Os.getUpFlowSize();
        }
        return 0L;
    }

    public void mL() {
        if (this.Or != null) {
            this.Or.mL();
        }
    }

    public long getDownFlowSize() {
        if (this.Or != null) {
            return this.Or.getDownFlowSize();
        }
        return 0L;
    }

    public long mR() {
        if (this.Ot != null) {
            return this.Ot.mE();
        }
        return 0L;
    }

    public String mS() {
        if (this.Ot != null) {
            return this.Ot.mD();
        }
        return null;
    }

    public long mT() {
        return this.OF;
    }

    public String getLocalDns() {
        if (this.Ot != null) {
            return this.Ot.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.Ot != null) {
            return this.Ot.getLocalDnsBak();
        }
        return null;
    }
}
