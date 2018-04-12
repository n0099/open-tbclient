package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.baidu.adp.base.BdBaseApplication;
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
    private List<BasicNameValuePair> yf;
    private String[] yg;
    protected Handler ym;
    protected volatile m yn;
    protected volatile o yo;
    protected e.a yp;
    private URI yq;
    private String yr;
    private String ys;
    private int yt;
    private String yu;
    private String yv;
    private g.a yw;
    protected l yx;
    private boolean yy = false;
    private boolean yz = false;
    private volatile boolean yA = false;
    private long yB = 0;
    private c yC = null;

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
                i.this.yp = eVar.a(i.this.ys, i.this.yt, i.this.yx, false);
                if (i.this.yA) {
                    i.this.q(new k.c());
                    return;
                }
                try {
                    if (!i.this.yp.isConnected()) {
                        i.this.q(new k.e(2, "cannot connect"));
                    } else {
                        i.this.yB = System.currentTimeMillis() - currentTimeMillis;
                        i.this.hK();
                        i.this.hJ();
                        k.b bVar = new k.b(i.this.ys + ":" + i.this.yt);
                        bVar.mPath = i.this.yu;
                        bVar.yG = i.this.yv;
                        bVar.yI = i.this.yg;
                        bVar.yJ = i.this.yf;
                        i.this.yo.t(bVar);
                        if (i.this.yA) {
                            i.this.q(new k.c());
                        }
                    }
                } catch (Throwable th) {
                    if (i.this.isDebug()) {
                        BdLog.e("----WebSocketConnector error. e:" + th.getMessage());
                    }
                    i.this.q(new k.f(new Exception(th)));
                }
            } catch (Throwable th2) {
                i.this.q(new k.e(2, th2.getMessage()));
            }
        }
    }

    public i() {
        hI();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.yC != null || !isOpen()) {
            if (isDebug()) {
            }
            if (cVar != null) {
                cVar.F(1);
                return false;
            }
            return false;
        }
        this.yC = cVar;
        return d(this.yC);
    }

    private boolean d(c cVar) {
        if (this.yo == null) {
            q(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.yo.t(new k.i(cVar));
    }

    public void close(int i, String str) {
        this.yy = false;
        this.yA = true;
        if (this.yn != null) {
            this.yn.quit();
            this.yn = null;
        }
        if (this.yo != null) {
            this.yo.quit();
            this.yo = null;
        }
        if (this.yp != null) {
            try {
                this.yp.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.yp = null;
        }
        g.a aVar = this.yw;
        this.yw = null;
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
        this.yz = true;
        if (this.yp != null && this.yp.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.yq = new URI(str);
            if (!this.yq.getScheme().equals("ws") && !this.yq.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.yq.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.yr = this.yq.getScheme();
            if (this.yq.getPort() == -1) {
                if (this.yr.equals("ws")) {
                    this.yt = 80;
                } else {
                    this.yt = 443;
                }
            } else {
                this.yt = this.yq.getPort();
            }
            if (this.yq.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.ys = this.yq.getHost();
            if (this.yq.getPath() == null || this.yq.getPath().equals("")) {
                this.yu = "/";
            } else {
                this.yu = this.yq.getPath();
            }
            if (this.yq.getQuery() == null || this.yq.getQuery().equals("")) {
                this.yv = null;
            } else {
                this.yv = this.yq.getQuery();
            }
            this.yg = strArr;
            this.yf = list;
            this.yw = aVar;
            this.yx = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(Object obj) {
        Message obtainMessage = this.ym.obtainMessage();
        obtainMessage.obj = obj;
        this.ym.sendMessage(obtainMessage);
    }

    protected void hI() {
        this.ym = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.yw != null) {
                        i.this.yw.G(sVar.yT);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.yw != null) {
                        i.this.yw.q(mVar.yE);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.yw != null) {
                        i.this.yw.b(aVar);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0010k c0010k = new k.C0010k();
                    c0010k.yE = ((k.j) message.obj).yE;
                    i.this.yo.t(c0010k);
                } else if (message.obj instanceof k.C0010k) {
                    k.C0010k c0010k2 = (k.C0010k) message.obj;
                    if (i.this.yw != null) {
                        i.this.yw.hA();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.yR) {
                        if (i.this.yw != null) {
                            i.this.yw.e(qVar.yS);
                            i.this.yy = true;
                            i.this.yz = false;
                            if (i.this.yw != null) {
                                i.this.yw.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).yL;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).yP;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).yN.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.yM + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).yM);
                } else if (message.obj instanceof k.r) {
                    if (i.this.yw != null) {
                        i.this.yw.b(((k.r) message.obj).yQ);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.yC = null;
                    c cVar = ((k.g) message.obj).yQ;
                    if (i.this.yw != null) {
                        i.this.yw.c(cVar);
                    }
                    if (i.this.yw != null) {
                        i.this.yw.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.yC = null;
                    c cVar2 = ((k.n) message.obj).yQ;
                    if (i.this.yw != null) {
                        i.this.yw.a(2, cVar2);
                    }
                    if (i.this.yw != null) {
                        i.this.yw.a(cVar2);
                    }
                } else {
                    i.this.r(message.obj);
                }
            }
        };
    }

    protected void r(Object obj) {
    }

    protected void hJ() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.yo = new o(handlerThread.getLooper(), this.ym, this.yp, this.yx);
    }

    protected void hK() {
        this.yn = new m(this.ym, this.yp, this.yx, "WebSocketReader");
        this.yn.start();
    }

    public boolean hL() {
        return this.yC != null;
    }

    public boolean isConnecting() {
        return this.yz;
    }

    public boolean isOpen() {
        return this.yy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void hF() {
        if (this.yo != null) {
            this.yo.hF();
        }
    }

    public long getUpFlowSize() {
        if (this.yo != null) {
            return this.yo.getUpFlowSize();
        }
        return 0L;
    }

    public void hG() {
        if (this.yn != null) {
            this.yn.hG();
        }
    }

    public long getDownFlowSize() {
        if (this.yn != null) {
            return this.yn.getDownFlowSize();
        }
        return 0L;
    }

    public long hM() {
        if (this.yp != null) {
            return this.yp.hy();
        }
        return 0L;
    }

    public String hN() {
        if (this.yp != null) {
            return this.yp.hx();
        }
        return null;
    }

    public long hO() {
        return this.yB;
    }

    public String hh() {
        if (this.yp != null) {
            return this.yp.hh();
        }
        return null;
    }

    public String hi() {
        if (this.yp != null) {
            return this.yp.hi();
        }
        return null;
    }
}
