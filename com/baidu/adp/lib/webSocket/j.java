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
    protected e.a tA;
    private URI tB;
    private String tC;
    private String tD;
    private int tE;
    private String tF;
    private String tG;
    private g.a tH;
    protected n tI;
    private boolean tJ = false;
    private boolean tK = false;
    private volatile boolean tL = false;
    private long tM = 0;
    private c tN = null;
    private List<BasicNameValuePair> tq;
    private String[] tr;
    protected Handler tx;
    protected volatile o ty;
    protected volatile q tz;

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
                j.this.tA = eVar.a(j.this.tD, j.this.tE, j.this.tI, false);
                if (!j.this.tL) {
                    try {
                        if (j.this.tA.isConnected()) {
                            j.this.tM = System.currentTimeMillis() - currentTimeMillis;
                            j.this.hl();
                            j.this.hk();
                            m.b bVar = new m.b(String.valueOf(j.this.tD) + ":" + j.this.tE);
                            bVar.mPath = j.this.tF;
                            bVar.tR = j.this.tG;
                            bVar.tT = j.this.tr;
                            bVar.tU = j.this.tq;
                            j.this.tz.u(bVar);
                            if (j.this.tL) {
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
        if (this.tN != null || !isOpen()) {
            hf();
            if (cVar != null) {
                cVar.O(1);
                return false;
            }
            return false;
        }
        this.tN = cVar;
        return d(this.tN);
    }

    private boolean d(c cVar) {
        if (this.tz == null) {
            r(new m.f(new Exception("mWriter = null")));
            return false;
        }
        return this.tz.u(new m.i(cVar));
    }

    public void close(int i, String str) {
        this.tJ = false;
        this.tL = true;
        if (this.ty != null) {
            this.ty.quit();
            this.ty = null;
        }
        if (this.tz != null) {
            this.tz.quit();
            this.tz = null;
        }
        if (this.tA != null) {
            try {
                this.tA.close();
            } catch (Throwable th) {
                if (hf()) {
                    th.printStackTrace();
                }
            }
            this.tA = null;
        }
        g.a aVar = this.tH;
        this.tH = null;
        if (aVar != null) {
            try {
                aVar.d(i, str);
            } catch (Exception e) {
                if (hf()) {
                    BdLog.d(e.getMessage());
                }
            }
        }
    }

    public void a(String str, String[] strArr, g.a aVar, n nVar, List<BasicNameValuePair> list) throws WebSocketException {
        this.tK = true;
        if (this.tA != null && this.tA.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.tB = new URI(str);
            if (!this.tB.getScheme().equals("ws") && !this.tB.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.tB.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.tC = this.tB.getScheme();
            if (this.tB.getPort() == -1) {
                if (this.tC.equals("ws")) {
                    this.tE = 80;
                } else {
                    this.tE = 443;
                }
            } else {
                this.tE = this.tB.getPort();
            }
            if (this.tB.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.tD = this.tB.getHost();
            if (this.tB.getPath() == null || this.tB.getPath().equals("")) {
                this.tF = "/";
            } else {
                this.tF = this.tB.getPath();
            }
            if (this.tB.getQuery() == null || this.tB.getQuery().equals("")) {
                this.tG = null;
            } else {
                this.tG = this.tB.getQuery();
            }
            this.tr = strArr;
            this.tq = list;
            this.tH = aVar;
            this.tI = new n(nVar);
            new a(this, null).start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Object obj) {
        Message obtainMessage = this.tx.obtainMessage();
        obtainMessage.obj = obj;
        this.tx.sendMessage(obtainMessage);
    }

    protected void hj() {
        this.tx = new k(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(Object obj) {
    }

    protected void hk() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.tz = new q(handlerThread.getLooper(), this.tx, this.tA, this.tI);
    }

    protected void hl() {
        this.ty = new o(this.tx, this.tA, this.tI, "WebSocketReader");
        this.ty.start();
    }

    public boolean hm() {
        return this.tN != null;
    }

    public boolean he() {
        return this.tK;
    }

    public boolean isOpen() {
        return this.tJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hf() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void hg() {
        if (this.tz != null) {
            this.tz.hg();
        }
    }

    public long getUpFlowSize() {
        if (this.tz != null) {
            return this.tz.getUpFlowSize();
        }
        return 0L;
    }

    public void hh() {
        if (this.ty != null) {
            this.ty.hh();
        }
    }

    public long getDownFlowSize() {
        if (this.ty != null) {
            return this.ty.getDownFlowSize();
        }
        return 0L;
    }

    public long hn() {
        if (this.tA != null) {
            return this.tA.gX();
        }
        return 0L;
    }

    public String ho() {
        if (this.tA != null) {
            return this.tA.gW();
        }
        return null;
    }

    public long hp() {
        return this.tM;
    }

    public String gE() {
        if (this.tA != null) {
            return this.tA.gE();
        }
        return null;
    }

    public String gF() {
        if (this.tA != null) {
            return this.tA.gF();
        }
        return null;
    }
}
