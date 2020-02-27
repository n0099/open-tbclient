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
    private List<BasicNameValuePair> ve;
    private String[] vf;
    protected Handler vl;
    protected volatile m vm;
    protected volatile o vn;
    protected e.a vo;
    private URI vq;
    private String vr;
    private String vs;
    private int vt;
    private String vu;
    private String vv;
    private g.a vw;
    protected l vx;
    private boolean vy = false;
    private boolean vz = false;
    private volatile boolean vA = false;
    private long vB = 0;
    private c vC = null;

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
                i.this.vo = eVar.a(i.this.vs, i.this.vt, i.this.vx, false);
                if (i.this.vA) {
                    i.this.s(new k.c());
                    return;
                }
                try {
                    if (!i.this.vo.isConnected()) {
                        i.this.s(new k.e(2, "cannot connect"));
                    } else {
                        i.this.vB = System.currentTimeMillis() - currentTimeMillis;
                        i.this.ij();
                        i.this.ii();
                        k.b bVar = new k.b(i.this.vs + ":" + i.this.vt);
                        bVar.mPath = i.this.vu;
                        bVar.mQuery = i.this.vv;
                        bVar.vF = i.this.vf;
                        bVar.vG = i.this.ve;
                        i.this.vn.v(bVar);
                        if (i.this.vA) {
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
        ih();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.vC != null || !isOpen()) {
            if (isDebug()) {
            }
            if (cVar != null) {
                cVar.onSendError(1);
                return false;
            }
            return false;
        }
        this.vC = cVar;
        return d(this.vC);
    }

    private boolean d(c cVar) {
        if (this.vn == null) {
            s(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.vn.v(new k.i(cVar));
    }

    public void close(int i, String str) {
        if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
            com.baidu.adp.framework.client.socket.i.debug("more_log", 0, 0, "close", i, str);
        }
        this.vy = false;
        this.vA = true;
        if (this.vm != null) {
            this.vm.quit();
            this.vm = null;
        }
        if (this.vn != null) {
            this.vn.quit();
            this.vn = null;
        }
        if (this.vo != null) {
            try {
                this.vo.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.vo = null;
        }
        g.a aVar = this.vw;
        this.vw = null;
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
        this.vz = true;
        if (this.vo != null && this.vo.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.vq = new URI(str);
            if (!this.vq.getScheme().equals("ws") && !this.vq.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.vq.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.vr = this.vq.getScheme();
            if (this.vq.getPort() == -1) {
                if (this.vr.equals("ws")) {
                    this.vt = 80;
                } else {
                    this.vt = Constants.SOCKET_PORT_SSL;
                }
            } else {
                this.vt = this.vq.getPort();
            }
            if (this.vq.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.vs = this.vq.getHost();
            if (this.vq.getPath() == null || this.vq.getPath().equals("")) {
                this.vu = "/";
            } else {
                this.vu = this.vq.getPath();
            }
            if (this.vq.getQuery() == null || this.vq.getQuery().equals("")) {
                this.vv = null;
            } else {
                this.vv = this.vq.getQuery();
            }
            this.vf = strArr;
            this.ve = list;
            this.vw = aVar;
            this.vx = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Object obj) {
        Message obtainMessage = this.vl.obtainMessage();
        obtainMessage.obj = obj;
        this.vl.sendMessage(obtainMessage);
    }

    protected void ih() {
        this.vl = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.vw != null) {
                        i.this.vw.onTextMessage(sVar.vN);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.vw != null) {
                        i.this.vw.h(mVar.vE);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.vw != null) {
                        i.this.vw.b(aVar);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0021k c0021k = new k.C0021k();
                    c0021k.vE = ((k.j) message.obj).vE;
                    i.this.vn.v(c0021k);
                } else if (message.obj instanceof k.C0021k) {
                    k.C0021k c0021k2 = (k.C0021k) message.obj;
                    if (i.this.vw != null) {
                        i.this.vw.hZ();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.mSuccess) {
                        if (i.this.vw != null) {
                            i.this.vw.onOpen(qVar.mHeaders);
                            i.this.vy = true;
                            i.this.vz = false;
                            if (i.this.vw != null) {
                                i.this.vw.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).vH;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).vL;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).vJ.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.vI + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).vI);
                } else if (message.obj instanceof k.r) {
                    if (i.this.vw != null) {
                        i.this.vw.b(((k.r) message.obj).vM);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.vC = null;
                    c cVar = ((k.g) message.obj).vM;
                    if (i.this.vw != null) {
                        i.this.vw.c(cVar);
                    }
                    if (i.this.vw != null) {
                        i.this.vw.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.vC = null;
                    c cVar2 = ((k.n) message.obj).vM;
                    if (i.this.vw != null) {
                        i.this.vw.a(2, cVar2);
                    }
                    if (i.this.vw != null) {
                        i.this.vw.a(cVar2);
                    }
                } else {
                    i.this.t(message.obj);
                }
            }
        };
    }

    protected void t(Object obj) {
    }

    protected void ii() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.vn = new o(handlerThread.getLooper(), this.vl, this.vo, this.vx);
    }

    protected void ij() {
        this.vm = new m(this.vl, this.vo, this.vx, "WebSocketReader");
        this.vm.start();
    }

    public boolean ik() {
        return this.vC != null;
    }

    public boolean isConnecting() {
        return this.vz;
    }

    public boolean isOpen() {
        return this.vy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void ie() {
        if (this.vn != null) {
            this.vn.ie();
        }
    }

    public long getUpFlowSize() {
        if (this.vn != null) {
            return this.vn.getUpFlowSize();
        }
        return 0L;
    }

    /* renamed from: if  reason: not valid java name */
    public void m13if() {
        if (this.vm != null) {
            this.vm.m14if();
        }
    }

    public long getDownFlowSize() {
        if (this.vm != null) {
            return this.vm.getDownFlowSize();
        }
        return 0L;
    }

    public long il() {
        if (this.vo != null) {
            return this.vo.hX();
        }
        return 0L;
    }

    public String im() {
        if (this.vo != null) {
            return this.vo.hW();
        }
        return null;
    }

    public long in() {
        return this.vB;
    }

    public String getLocalDns() {
        if (this.vo != null) {
            return this.vo.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.vo != null) {
            return this.vo.getLocalDnsBak();
        }
        return null;
    }
}
