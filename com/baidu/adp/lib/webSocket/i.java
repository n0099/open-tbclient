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
    private List<BasicNameValuePair> uK;
    private String[] uL;
    protected Handler uR;
    protected volatile m uS;
    protected volatile o uT;
    protected e.a uU;
    private URI uV;
    private String uW;
    private String uX;
    private int uY;
    private String uZ;
    private String va;
    private g.a vb;
    protected l vc;
    private boolean vd = false;
    private boolean ve = false;
    private volatile boolean vf = false;
    private long vg = 0;
    private c vh = null;

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
                i.this.uU = eVar.a(i.this.uX, i.this.uY, i.this.vc, false);
                if (i.this.vf) {
                    i.this.s(new k.c());
                    return;
                }
                try {
                    if (!i.this.uU.isConnected()) {
                        i.this.s(new k.e(2, "cannot connect"));
                    } else {
                        i.this.vg = System.currentTimeMillis() - currentTimeMillis;
                        i.this.hV();
                        i.this.hU();
                        k.b bVar = new k.b(i.this.uX + ":" + i.this.uY);
                        bVar.mPath = i.this.uZ;
                        bVar.mQuery = i.this.va;
                        bVar.vk = i.this.uL;
                        bVar.vl = i.this.uK;
                        i.this.uT.v(bVar);
                        if (i.this.vf) {
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
        hT();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.vh != null || !isOpen()) {
            if (isDebug()) {
            }
            if (cVar != null) {
                cVar.onSendError(1);
                return false;
            }
            return false;
        }
        this.vh = cVar;
        return d(this.vh);
    }

    private boolean d(c cVar) {
        if (this.uT == null) {
            s(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.uT.v(new k.i(cVar));
    }

    public void close(int i, String str) {
        if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
            com.baidu.adp.framework.client.socket.i.debug("more_log", 0, 0, "close", i, str);
        }
        this.vd = false;
        this.vf = true;
        if (this.uS != null) {
            this.uS.quit();
            this.uS = null;
        }
        if (this.uT != null) {
            this.uT.quit();
            this.uT = null;
        }
        if (this.uU != null) {
            try {
                this.uU.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.uU = null;
        }
        g.a aVar = this.vb;
        this.vb = null;
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
        this.ve = true;
        if (this.uU != null && this.uU.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.uV = new URI(str);
            if (!this.uV.getScheme().equals("ws") && !this.uV.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.uV.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.uW = this.uV.getScheme();
            if (this.uV.getPort() == -1) {
                if (this.uW.equals("ws")) {
                    this.uY = 80;
                } else {
                    this.uY = 443;
                }
            } else {
                this.uY = this.uV.getPort();
            }
            if (this.uV.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.uX = this.uV.getHost();
            if (this.uV.getPath() == null || this.uV.getPath().equals("")) {
                this.uZ = "/";
            } else {
                this.uZ = this.uV.getPath();
            }
            if (this.uV.getQuery() == null || this.uV.getQuery().equals("")) {
                this.va = null;
            } else {
                this.va = this.uV.getQuery();
            }
            this.uL = strArr;
            this.uK = list;
            this.vb = aVar;
            this.vc = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Object obj) {
        Message obtainMessage = this.uR.obtainMessage();
        obtainMessage.obj = obj;
        this.uR.sendMessage(obtainMessage);
    }

    protected void hT() {
        this.uR = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.vb != null) {
                        i.this.vb.onTextMessage(sVar.vt);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.vb != null) {
                        i.this.vb.h(mVar.vj);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.vb != null) {
                        i.this.vb.b(aVar);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0021k c0021k = new k.C0021k();
                    c0021k.vj = ((k.j) message.obj).vj;
                    i.this.uT.v(c0021k);
                } else if (message.obj instanceof k.C0021k) {
                    k.C0021k c0021k2 = (k.C0021k) message.obj;
                    if (i.this.vb != null) {
                        i.this.vb.hM();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.mSuccess) {
                        if (i.this.vb != null) {
                            i.this.vb.onOpen(qVar.mHeaders);
                            i.this.vd = true;
                            i.this.ve = false;
                            if (i.this.vb != null) {
                                i.this.vb.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).vm;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).vr;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).vo.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.vn + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).vn);
                } else if (message.obj instanceof k.r) {
                    if (i.this.vb != null) {
                        i.this.vb.b(((k.r) message.obj).vs);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.vh = null;
                    c cVar = ((k.g) message.obj).vs;
                    if (i.this.vb != null) {
                        i.this.vb.c(cVar);
                    }
                    if (i.this.vb != null) {
                        i.this.vb.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.vh = null;
                    c cVar2 = ((k.n) message.obj).vs;
                    if (i.this.vb != null) {
                        i.this.vb.a(2, cVar2);
                    }
                    if (i.this.vb != null) {
                        i.this.vb.a(cVar2);
                    }
                } else {
                    i.this.t(message.obj);
                }
            }
        };
    }

    protected void t(Object obj) {
    }

    protected void hU() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.uT = new o(handlerThread.getLooper(), this.uR, this.uU, this.vc);
    }

    protected void hV() {
        this.uS = new m(this.uR, this.uU, this.vc, "WebSocketReader");
        this.uS.start();
    }

    public boolean hW() {
        return this.vh != null;
    }

    public boolean isConnecting() {
        return this.ve;
    }

    public boolean isOpen() {
        return this.vd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void hQ() {
        if (this.uT != null) {
            this.uT.hQ();
        }
    }

    public long getUpFlowSize() {
        if (this.uT != null) {
            return this.uT.getUpFlowSize();
        }
        return 0L;
    }

    public void hR() {
        if (this.uS != null) {
            this.uS.hR();
        }
    }

    public long getDownFlowSize() {
        if (this.uS != null) {
            return this.uS.getDownFlowSize();
        }
        return 0L;
    }

    public long hX() {
        if (this.uU != null) {
            return this.uU.hK();
        }
        return 0L;
    }

    public String hY() {
        if (this.uU != null) {
            return this.uU.hJ();
        }
        return null;
    }

    public long hZ() {
        return this.vg;
    }

    public String getLocalDns() {
        if (this.uU != null) {
            return this.uU.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.uU != null) {
            return this.uU.getLocalDnsBak();
        }
        return null;
    }
}
