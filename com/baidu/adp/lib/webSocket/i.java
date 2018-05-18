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
    private List<BasicNameValuePair> ye;
    private String[] yf;
    protected Handler yl;
    protected volatile m ym;
    protected volatile o yn;
    protected e.a yo;
    private URI yp;
    private String yq;
    private String yr;
    private int ys;
    private String yt;
    private String yu;
    private g.a yv;
    protected l yw;
    private boolean yx = false;
    private boolean yy = false;
    private volatile boolean yz = false;
    private long yA = 0;
    private c yB = null;

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
                i.this.yo = eVar.a(i.this.yr, i.this.ys, i.this.yw, false);
                if (i.this.yz) {
                    i.this.q(new k.c());
                    return;
                }
                try {
                    if (!i.this.yo.isConnected()) {
                        i.this.q(new k.e(2, "cannot connect"));
                    } else {
                        i.this.yA = System.currentTimeMillis() - currentTimeMillis;
                        i.this.hK();
                        i.this.hJ();
                        k.b bVar = new k.b(i.this.yr + ":" + i.this.ys);
                        bVar.mPath = i.this.yt;
                        bVar.yF = i.this.yu;
                        bVar.yH = i.this.yf;
                        bVar.yI = i.this.ye;
                        i.this.yn.t(bVar);
                        if (i.this.yz) {
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
        if (this.yB != null || !isOpen()) {
            if (isDebug()) {
            }
            if (cVar != null) {
                cVar.F(1);
                return false;
            }
            return false;
        }
        this.yB = cVar;
        return d(this.yB);
    }

    private boolean d(c cVar) {
        if (this.yn == null) {
            q(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.yn.t(new k.i(cVar));
    }

    public void close(int i, String str) {
        this.yx = false;
        this.yz = true;
        if (this.ym != null) {
            this.ym.quit();
            this.ym = null;
        }
        if (this.yn != null) {
            this.yn.quit();
            this.yn = null;
        }
        if (this.yo != null) {
            try {
                this.yo.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.yo = null;
        }
        g.a aVar = this.yv;
        this.yv = null;
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
        this.yy = true;
        if (this.yo != null && this.yo.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.yp = new URI(str);
            if (!this.yp.getScheme().equals("ws") && !this.yp.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.yp.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.yq = this.yp.getScheme();
            if (this.yp.getPort() == -1) {
                if (this.yq.equals("ws")) {
                    this.ys = 80;
                } else {
                    this.ys = 443;
                }
            } else {
                this.ys = this.yp.getPort();
            }
            if (this.yp.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.yr = this.yp.getHost();
            if (this.yp.getPath() == null || this.yp.getPath().equals("")) {
                this.yt = "/";
            } else {
                this.yt = this.yp.getPath();
            }
            if (this.yp.getQuery() == null || this.yp.getQuery().equals("")) {
                this.yu = null;
            } else {
                this.yu = this.yp.getQuery();
            }
            this.yf = strArr;
            this.ye = list;
            this.yv = aVar;
            this.yw = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(Object obj) {
        Message obtainMessage = this.yl.obtainMessage();
        obtainMessage.obj = obj;
        this.yl.sendMessage(obtainMessage);
    }

    protected void hI() {
        this.yl = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.yv != null) {
                        i.this.yv.G(sVar.yS);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.yv != null) {
                        i.this.yv.q(mVar.yD);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.yv != null) {
                        i.this.yv.b(aVar);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0010k c0010k = new k.C0010k();
                    c0010k.yD = ((k.j) message.obj).yD;
                    i.this.yn.t(c0010k);
                } else if (message.obj instanceof k.C0010k) {
                    k.C0010k c0010k2 = (k.C0010k) message.obj;
                    if (i.this.yv != null) {
                        i.this.yv.hA();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.yQ) {
                        if (i.this.yv != null) {
                            i.this.yv.e(qVar.yR);
                            i.this.yx = true;
                            i.this.yy = false;
                            if (i.this.yv != null) {
                                i.this.yv.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).yK;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).yO;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).yM.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.yL + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).yL);
                } else if (message.obj instanceof k.r) {
                    if (i.this.yv != null) {
                        i.this.yv.b(((k.r) message.obj).yP);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.yB = null;
                    c cVar = ((k.g) message.obj).yP;
                    if (i.this.yv != null) {
                        i.this.yv.c(cVar);
                    }
                    if (i.this.yv != null) {
                        i.this.yv.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.yB = null;
                    c cVar2 = ((k.n) message.obj).yP;
                    if (i.this.yv != null) {
                        i.this.yv.a(2, cVar2);
                    }
                    if (i.this.yv != null) {
                        i.this.yv.a(cVar2);
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
        this.yn = new o(handlerThread.getLooper(), this.yl, this.yo, this.yw);
    }

    protected void hK() {
        this.ym = new m(this.yl, this.yo, this.yw, "WebSocketReader");
        this.ym.start();
    }

    public boolean hL() {
        return this.yB != null;
    }

    public boolean isConnecting() {
        return this.yy;
    }

    public boolean isOpen() {
        return this.yx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void hF() {
        if (this.yn != null) {
            this.yn.hF();
        }
    }

    public long getUpFlowSize() {
        if (this.yn != null) {
            return this.yn.getUpFlowSize();
        }
        return 0L;
    }

    public void hG() {
        if (this.ym != null) {
            this.ym.hG();
        }
    }

    public long getDownFlowSize() {
        if (this.ym != null) {
            return this.ym.getDownFlowSize();
        }
        return 0L;
    }

    public long hM() {
        if (this.yo != null) {
            return this.yo.hy();
        }
        return 0L;
    }

    public String hN() {
        if (this.yo != null) {
            return this.yo.hx();
        }
        return null;
    }

    public long hO() {
        return this.yA;
    }

    public String hh() {
        if (this.yo != null) {
            return this.yo.hh();
        }
        return null;
    }

    public String hi() {
        if (this.yo != null) {
            return this.yo.hi();
        }
        return null;
    }
}
