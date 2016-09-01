package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.e;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.adp.lib.webSocket.m;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class j implements g {
    private URI tA;
    private String tB;
    private String tC;
    private int tD;
    private String tE;
    private String tF;
    private g.a tG;
    protected n tH;
    private boolean tI = false;
    private boolean tJ = false;
    private volatile boolean tK = false;
    private long tL = 0;
    private c tM = null;
    private List<BasicNameValuePair> tp;
    private String[] tq;
    protected Handler tw;
    protected volatile o tx;
    protected volatile q ty;
    protected e.a tz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Thread {
        private a() {
        }

        /* synthetic */ a(j jVar, a aVar) {
            this();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Thread.currentThread().setName("WebSocketConnector");
            long currentTimeMillis = System.currentTimeMillis();
            try {
                e eVar = new e();
                j.this.tz = eVar.a(j.this.tC, j.this.tD, j.this.tH, false);
                if (!j.this.tK) {
                    try {
                        if (j.this.tz.isConnected()) {
                            j.this.tL = System.currentTimeMillis() - currentTimeMillis;
                            j.this.hl();
                            j.this.hk();
                            m.b bVar = new m.b(String.valueOf(j.this.tC) + ":" + j.this.tD);
                            bVar.mPath = j.this.tE;
                            bVar.tQ = j.this.tF;
                            bVar.tS = j.this.tq;
                            bVar.tT = j.this.tp;
                            j.this.ty.u(bVar);
                            if (j.this.tK) {
                                j.this.r(new m.c());
                            }
                        } else {
                            j.this.r(new m.e(2, "cannot connect"));
                        }
                        return;
                    } catch (Throwable th) {
                        if (j.this.hf()) {
                            BdLog.e("----WebSocketConnector error. e:" + th.getMessage());
                        }
                        j.this.r(new m.f(new Exception(th)));
                        return;
                    }
                }
                j.this.r(new m.c());
            } catch (Throwable th2) {
                j.this.r(new m.e(2, th2.getMessage()));
            }
        }
    }

    public j() {
        hj();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.tM != null || !isOpen()) {
            hf();
            if (cVar != null) {
                cVar.N(1);
                return false;
            }
            return false;
        }
        this.tM = cVar;
        return d(this.tM);
    }

    private boolean d(c cVar) {
        if (this.ty == null) {
            r(new m.f(new Exception("mWriter = null")));
            return false;
        }
        return this.ty.u(new m.i(cVar));
    }

    public void close(int i, String str) {
        this.tI = false;
        this.tK = true;
        if (this.tx != null) {
            this.tx.quit();
            this.tx = null;
        }
        if (this.ty != null) {
            this.ty.quit();
            this.ty = null;
        }
        if (this.tz != null) {
            try {
                this.tz.close();
            } catch (Throwable th) {
                if (hf()) {
                    th.printStackTrace();
                }
            }
            this.tz = null;
        }
        g.a aVar = this.tG;
        this.tG = null;
        if (aVar != null) {
            try {
                aVar.e(i, str);
            } catch (Exception e) {
                if (hf()) {
                    BdLog.d(e.getMessage());
                }
            }
        }
    }

    public void a(String str, String[] strArr, g.a aVar, n nVar, List<BasicNameValuePair> list) throws WebSocketException {
        this.tJ = true;
        if (this.tz != null && this.tz.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.tA = new URI(str);
            if (!this.tA.getScheme().equals("ws") && !this.tA.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.tA.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.tB = this.tA.getScheme();
            if (this.tA.getPort() == -1) {
                if (this.tB.equals("ws")) {
                    this.tD = 80;
                } else {
                    this.tD = 443;
                }
            } else {
                this.tD = this.tA.getPort();
            }
            if (this.tA.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.tC = this.tA.getHost();
            if (this.tA.getPath() == null || this.tA.getPath().equals("")) {
                this.tE = "/";
            } else {
                this.tE = this.tA.getPath();
            }
            if (this.tA.getQuery() == null || this.tA.getQuery().equals("")) {
                this.tF = null;
            } else {
                this.tF = this.tA.getQuery();
            }
            this.tq = strArr;
            this.tp = list;
            this.tG = aVar;
            this.tH = new n(nVar);
            new a(this, null).start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Object obj) {
        Message obtainMessage = this.tw.obtainMessage();
        obtainMessage.obj = obj;
        this.tw.sendMessage(obtainMessage);
    }

    protected void hj() {
        this.tw = new k(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(Object obj) {
    }

    protected void hk() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.ty = new q(handlerThread.getLooper(), this.tw, this.tz, this.tH);
    }

    protected void hl() {
        this.tx = new o(this.tw, this.tz, this.tH, "WebSocketReader");
        this.tx.start();
    }

    public boolean hm() {
        return this.tM != null;
    }

    public boolean he() {
        return this.tJ;
    }

    public boolean isOpen() {
        return this.tI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hf() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void hg() {
        if (this.ty != null) {
            this.ty.hg();
        }
    }

    public long getUpFlowSize() {
        if (this.ty != null) {
            return this.ty.getUpFlowSize();
        }
        return 0L;
    }

    public void hh() {
        if (this.tx != null) {
            this.tx.hh();
        }
    }

    public long getDownFlowSize() {
        if (this.tx != null) {
            return this.tx.getDownFlowSize();
        }
        return 0L;
    }

    public long hn() {
        if (this.tz != null) {
            return this.tz.gX();
        }
        return 0L;
    }

    public String ho() {
        if (this.tz != null) {
            return this.tz.gW();
        }
        return null;
    }

    public long hp() {
        return this.tL;
    }

    public String gE() {
        if (this.tz != null) {
            return this.tz.gE();
        }
        return null;
    }

    public String gF() {
        if (this.tz != null) {
            return this.tz.gF();
        }
        return null;
    }
}
