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
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class i implements g {
    private List<BasicNameValuePair> uN;
    private String[] uO;
    protected Handler uU;
    protected volatile m uV;
    protected volatile o uW;
    protected e.a uX;
    private URI uY;
    private String uZ;
    private String va;
    private int vb;
    private String vc;
    private String vd;
    private g.a ve;
    protected l vf;
    private boolean vg = false;
    private boolean vh = false;
    private volatile boolean vi = false;
    private long vj = 0;
    private c vk = null;

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
                i.this.uX = eVar.a(i.this.va, i.this.vb, i.this.vf, false);
                if (i.this.vi) {
                    i.this.s(new k.c());
                    return;
                }
                try {
                    if (!i.this.uX.isConnected()) {
                        i.this.s(new k.e(2, "cannot connect"));
                    } else {
                        i.this.vj = System.currentTimeMillis() - currentTimeMillis;
                        i.this.hU();
                        i.this.hT();
                        k.b bVar = new k.b(i.this.va + ":" + i.this.vb);
                        bVar.mPath = i.this.vc;
                        bVar.mQuery = i.this.vd;
                        bVar.vn = i.this.uO;
                        bVar.vo = i.this.uN;
                        i.this.uW.v(bVar);
                        if (i.this.vi) {
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
        hS();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.vk != null || !isOpen()) {
            if (isDebug()) {
            }
            if (cVar != null) {
                cVar.onSendError(1);
                return false;
            }
            return false;
        }
        this.vk = cVar;
        return d(this.vk);
    }

    private boolean d(c cVar) {
        if (this.uW == null) {
            s(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.uW.v(new k.i(cVar));
    }

    public void close(int i, String str) {
        if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
            com.baidu.adp.framework.client.socket.i.debug("more_log", 0, 0, "close", i, str);
        }
        this.vg = false;
        this.vi = true;
        if (this.uV != null) {
            this.uV.quit();
            this.uV = null;
        }
        if (this.uW != null) {
            this.uW.quit();
            this.uW = null;
        }
        if (this.uX != null) {
            try {
                this.uX.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.uX = null;
        }
        g.a aVar = this.ve;
        this.ve = null;
        if (aVar != null) {
            try {
                aVar.e(i, str);
            } catch (Exception e) {
                if (isDebug()) {
                    BdLog.d(e.getMessage());
                }
            }
        }
    }

    public void a(String str, String[] strArr, g.a aVar, l lVar, List<BasicNameValuePair> list) throws WebSocketException {
        this.vh = true;
        if (this.uX != null && this.uX.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.uY = new URI(str);
            if (!this.uY.getScheme().equals("ws") && !this.uY.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.uY.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.uZ = this.uY.getScheme();
            if (this.uY.getPort() == -1) {
                if (this.uZ.equals("ws")) {
                    this.vb = 80;
                } else {
                    this.vb = 443;
                }
            } else {
                this.vb = this.uY.getPort();
            }
            if (this.uY.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.va = this.uY.getHost();
            if (this.uY.getPath() == null || this.uY.getPath().equals("")) {
                this.vc = "/";
            } else {
                this.vc = this.uY.getPath();
            }
            if (this.uY.getQuery() == null || this.uY.getQuery().equals("")) {
                this.vd = null;
            } else {
                this.vd = this.uY.getQuery();
            }
            this.uO = strArr;
            this.uN = list;
            this.ve = aVar;
            this.vf = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Object obj) {
        Message obtainMessage = this.uU.obtainMessage();
        obtainMessage.obj = obj;
        this.uU.sendMessage(obtainMessage);
    }

    protected void hS() {
        this.uU = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.ve != null) {
                        i.this.ve.onTextMessage(sVar.vw);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.ve != null) {
                        i.this.ve.h(mVar.vm);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.ve != null) {
                        i.this.ve.b(aVar);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0021k c0021k = new k.C0021k();
                    c0021k.vm = ((k.j) message.obj).vm;
                    i.this.uW.v(c0021k);
                } else if (message.obj instanceof k.C0021k) {
                    k.C0021k c0021k2 = (k.C0021k) message.obj;
                    if (i.this.ve != null) {
                        i.this.ve.hL();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.mSuccess) {
                        if (i.this.ve != null) {
                            i.this.ve.onOpen(qVar.mHeaders);
                            i.this.vg = true;
                            i.this.vh = false;
                            if (i.this.ve != null) {
                                i.this.ve.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).vq;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).vu;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).vs.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.vr + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).vr);
                } else if (message.obj instanceof k.r) {
                    if (i.this.ve != null) {
                        i.this.ve.b(((k.r) message.obj).vv);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.vk = null;
                    c cVar = ((k.g) message.obj).vv;
                    if (i.this.ve != null) {
                        i.this.ve.c(cVar);
                    }
                    if (i.this.ve != null) {
                        i.this.ve.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.vk = null;
                    c cVar2 = ((k.n) message.obj).vv;
                    if (i.this.ve != null) {
                        i.this.ve.a(2, cVar2);
                    }
                    if (i.this.ve != null) {
                        i.this.ve.a(cVar2);
                    }
                } else {
                    i.this.t(message.obj);
                }
            }
        };
    }

    protected void t(Object obj) {
    }

    protected void hT() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.uW = new o(handlerThread.getLooper(), this.uU, this.uX, this.vf);
    }

    protected void hU() {
        this.uV = new m(this.uU, this.uX, this.vf, "WebSocketReader");
        this.uV.start();
    }

    public boolean hV() {
        return this.vk != null;
    }

    public boolean isConnecting() {
        return this.vh;
    }

    public boolean isOpen() {
        return this.vg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void hP() {
        if (this.uW != null) {
            this.uW.hP();
        }
    }

    public long getUpFlowSize() {
        if (this.uW != null) {
            return this.uW.getUpFlowSize();
        }
        return 0L;
    }

    public void hQ() {
        if (this.uV != null) {
            this.uV.hQ();
        }
    }

    public long getDownFlowSize() {
        if (this.uV != null) {
            return this.uV.getDownFlowSize();
        }
        return 0L;
    }

    public long hW() {
        if (this.uX != null) {
            return this.uX.hJ();
        }
        return 0L;
    }

    public String hX() {
        if (this.uX != null) {
            return this.uX.hI();
        }
        return null;
    }

    public long hY() {
        return this.vj;
    }

    public String getLocalDns() {
        if (this.uX != null) {
            return this.uX.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.uX != null) {
            return this.uX.getLocalDnsBak();
        }
        return null;
    }
}
