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
    private List<BasicNameValuePair> OL;
    private String[] OM;
    protected Handler OU;
    protected volatile m OV;
    protected volatile o OW;
    protected e.a OX;
    private URI OY;
    private String OZ;
    private String Pa;
    private int Pb;
    private String Pc;
    private String Pd;
    private g.a Pe;
    protected l Pf;
    private boolean Pg = false;
    private boolean Ph = false;
    private volatile boolean Pi = false;
    private long Pj = 0;
    private c Pk = null;

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
                i.this.OX = eVar.a(i.this.Pa, i.this.Pb, i.this.Pf, false);
                if (i.this.Pi) {
                    i.this.v(new k.c());
                    return;
                }
                try {
                    if (!i.this.OX.isConnected()) {
                        i.this.v(new k.e(2, "cannot connect"));
                    } else {
                        i.this.Pj = System.currentTimeMillis() - currentTimeMillis;
                        i.this.ng();
                        i.this.nf();
                        k.b bVar = new k.b(i.this.Pa + ":" + i.this.Pb);
                        bVar.mPath = i.this.Pc;
                        bVar.mQuery = i.this.Pd;
                        bVar.Pn = i.this.OM;
                        bVar.Po = i.this.OL;
                        i.this.OW.y(bVar);
                        if (i.this.Pi) {
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
        ne();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.Pk != null || !isOpen()) {
            if (isDebug()) {
            }
            if (cVar != null) {
                cVar.onSendError(1);
                return false;
            }
            return false;
        }
        this.Pk = cVar;
        return d(this.Pk);
    }

    private boolean d(c cVar) {
        if (this.OW == null) {
            v(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.OW.y(new k.i(cVar));
    }

    public void close(int i, String str) {
        if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
            com.baidu.adp.framework.client.socket.i.debug("more_log", 0, 0, "close", i, str);
        }
        this.Pg = false;
        this.Pi = true;
        if (this.OV != null) {
            this.OV.quit();
            this.OV = null;
        }
        if (this.OW != null) {
            this.OW.quit();
            this.OW = null;
        }
        if (this.OX != null) {
            try {
                this.OX.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.OX = null;
        }
        g.a aVar = this.Pe;
        this.Pe = null;
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
        this.Ph = true;
        if (this.OX != null && this.OX.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.OY = new URI(str);
            if (!this.OY.getScheme().equals("ws") && !this.OY.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.OY.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.OZ = this.OY.getScheme();
            if (this.OY.getPort() == -1) {
                if (this.OZ.equals("ws")) {
                    this.Pb = 80;
                } else {
                    this.Pb = Constants.SOCKET_PORT_SSL;
                }
            } else {
                this.Pb = this.OY.getPort();
            }
            if (this.OY.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.Pa = this.OY.getHost();
            if (this.OY.getPath() == null || this.OY.getPath().equals("")) {
                this.Pc = "/";
            } else {
                this.Pc = this.OY.getPath();
            }
            if (this.OY.getQuery() == null || this.OY.getQuery().equals("")) {
                this.Pd = null;
            } else {
                this.Pd = this.OY.getQuery();
            }
            this.OM = strArr;
            this.OL = list;
            this.Pe = aVar;
            this.Pf = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(Object obj) {
        Message obtainMessage = this.OU.obtainMessage();
        obtainMessage.obj = obj;
        this.OU.sendMessage(obtainMessage);
    }

    protected void ne() {
        this.OU = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.Pe != null) {
                        i.this.Pe.onTextMessage(sVar.Pw);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.Pe != null) {
                        i.this.Pe.m(mVar.Pm);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.Pe != null) {
                        i.this.Pe.b(aVar);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0025k c0025k = new k.C0025k();
                    c0025k.Pm = ((k.j) message.obj).Pm;
                    i.this.OW.y(c0025k);
                } else if (message.obj instanceof k.C0025k) {
                    k.C0025k c0025k2 = (k.C0025k) message.obj;
                    if (i.this.Pe != null) {
                        i.this.Pe.mX();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.Pv) {
                        if (i.this.Pe != null) {
                            i.this.Pe.onOpen(qVar.mHeaders);
                            i.this.Pg = true;
                            i.this.Ph = false;
                            if (i.this.Pe != null) {
                                i.this.Pe.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).Pp;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).Pt;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).Pr.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.Pq + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).Pq);
                } else if (message.obj instanceof k.r) {
                    if (i.this.Pe != null) {
                        i.this.Pe.b(((k.r) message.obj).Pu);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.Pk = null;
                    c cVar = ((k.g) message.obj).Pu;
                    if (i.this.Pe != null) {
                        i.this.Pe.c(cVar);
                    }
                    if (i.this.Pe != null) {
                        i.this.Pe.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.Pk = null;
                    c cVar2 = ((k.n) message.obj).Pu;
                    if (i.this.Pe != null) {
                        i.this.Pe.a(2, cVar2);
                    }
                    if (i.this.Pe != null) {
                        i.this.Pe.a(cVar2);
                    }
                } else {
                    i.this.w(message.obj);
                }
            }
        };
    }

    protected void w(Object obj) {
    }

    protected void nf() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.OW = new o(handlerThread.getLooper(), this.OU, this.OX, this.Pf);
    }

    protected void ng() {
        this.OV = new m(this.OU, this.OX, this.Pf, "WebSocketReader");
        this.OV.start();
    }

    public boolean nh() {
        return this.Pk != null;
    }

    public boolean isConnecting() {
        return this.Ph;
    }

    public boolean isOpen() {
        return this.Pg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void nb() {
        if (this.OW != null) {
            this.OW.nb();
        }
    }

    public long getUpFlowSize() {
        if (this.OW != null) {
            return this.OW.getUpFlowSize();
        }
        return 0L;
    }

    public void nc() {
        if (this.OV != null) {
            this.OV.nc();
        }
    }

    public long getDownFlowSize() {
        if (this.OV != null) {
            return this.OV.getDownFlowSize();
        }
        return 0L;
    }

    public long ni() {
        if (this.OX != null) {
            return this.OX.mV();
        }
        return 0L;
    }

    public String nj() {
        if (this.OX != null) {
            return this.OX.mU();
        }
        return null;
    }

    public long nk() {
        return this.Pj;
    }

    public String getLocalDns() {
        if (this.OX != null) {
            return this.OX.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.OX != null) {
            return this.OX.getLocalDnsBak();
        }
        return null;
    }
}
