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
    private boolean tA = false;
    private boolean tB = false;
    private volatile boolean tC = false;
    private long tD = 0;
    private c tE = null;
    private List<BasicNameValuePair> tf;
    private String[] tg;
    protected Handler tm;
    protected volatile o tp;
    protected volatile q tq;
    protected e.a tr;
    private URI ts;
    private String tt;
    private String tu;

    /* renamed from: tv  reason: collision with root package name */
    private int f2tv;
    private String tw;
    private String tx;
    private g.a ty;
    protected n tz;

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
                j.this.tr = eVar.a(j.this.tu, j.this.f2tv, j.this.tz, false);
                if (!j.this.tC) {
                    try {
                        if (j.this.tr.isConnected()) {
                            j.this.tD = System.currentTimeMillis() - currentTimeMillis;
                            j.this.hj();
                            j.this.hi();
                            m.b bVar = new m.b(String.valueOf(j.this.tu) + ":" + j.this.f2tv);
                            bVar.mPath = j.this.tw;
                            bVar.tI = j.this.tx;
                            bVar.tK = j.this.tg;
                            bVar.tL = j.this.tf;
                            j.this.tq.u(bVar);
                            if (j.this.tC) {
                                j.this.r(new m.c());
                            }
                        } else {
                            j.this.r(new m.e(2, "cannot connect"));
                        }
                        return;
                    } catch (Throwable th) {
                        if (j.this.hd()) {
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
        hh();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.tE != null || !isOpen()) {
            hd();
            if (cVar != null) {
                cVar.O(1);
                return false;
            }
            return false;
        }
        this.tE = cVar;
        return d(this.tE);
    }

    private boolean d(c cVar) {
        if (this.tq == null) {
            r(new m.f(new Exception("mWriter = null")));
            return false;
        }
        return this.tq.u(new m.i(cVar));
    }

    public void close(int i, String str) {
        this.tA = false;
        this.tC = true;
        if (this.tp != null) {
            this.tp.quit();
            this.tp = null;
        }
        if (this.tq != null) {
            this.tq.quit();
            this.tq = null;
        }
        if (this.tr != null) {
            try {
                this.tr.close();
            } catch (Throwable th) {
                if (hd()) {
                    th.printStackTrace();
                }
            }
            this.tr = null;
        }
        g.a aVar = this.ty;
        this.ty = null;
        if (aVar != null) {
            try {
                aVar.d(i, str);
            } catch (Exception e) {
                if (hd()) {
                    BdLog.d(e.getMessage());
                }
            }
        }
    }

    public void a(String str, String[] strArr, g.a aVar, n nVar, List<BasicNameValuePair> list) throws WebSocketException {
        this.tB = true;
        if (this.tr != null && this.tr.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.ts = new URI(str);
            if (!this.ts.getScheme().equals("ws") && !this.ts.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.ts.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.tt = this.ts.getScheme();
            if (this.ts.getPort() == -1) {
                if (this.tt.equals("ws")) {
                    this.f2tv = 80;
                } else {
                    this.f2tv = 443;
                }
            } else {
                this.f2tv = this.ts.getPort();
            }
            if (this.ts.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.tu = this.ts.getHost();
            if (this.ts.getPath() == null || this.ts.getPath().equals("")) {
                this.tw = "/";
            } else {
                this.tw = this.ts.getPath();
            }
            if (this.ts.getQuery() == null || this.ts.getQuery().equals("")) {
                this.tx = null;
            } else {
                this.tx = this.ts.getQuery();
            }
            this.tg = strArr;
            this.tf = list;
            this.ty = aVar;
            this.tz = new n(nVar);
            new a(this, null).start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Object obj) {
        Message obtainMessage = this.tm.obtainMessage();
        obtainMessage.obj = obj;
        this.tm.sendMessage(obtainMessage);
    }

    protected void hh() {
        this.tm = new k(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(Object obj) {
    }

    protected void hi() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.tq = new q(handlerThread.getLooper(), this.tm, this.tr, this.tz);
    }

    protected void hj() {
        this.tp = new o(this.tm, this.tr, this.tz, "WebSocketReader");
        this.tp.start();
    }

    public boolean hk() {
        return this.tE != null;
    }

    public boolean hc() {
        return this.tB;
    }

    public boolean isOpen() {
        return this.tA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hd() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void he() {
        if (this.tq != null) {
            this.tq.he();
        }
    }

    public long getUpFlowSize() {
        if (this.tq != null) {
            return this.tq.getUpFlowSize();
        }
        return 0L;
    }

    public void hf() {
        if (this.tp != null) {
            this.tp.hf();
        }
    }

    public long getDownFlowSize() {
        if (this.tp != null) {
            return this.tp.getDownFlowSize();
        }
        return 0L;
    }

    public long hl() {
        if (this.tr != null) {
            return this.tr.gV();
        }
        return 0L;
    }

    public String hm() {
        if (this.tr != null) {
            return this.tr.gU();
        }
        return null;
    }

    public long hn() {
        return this.tD;
    }

    public String gC() {
        if (this.tr != null) {
            return this.tr.gC();
        }
        return null;
    }

    public String gD() {
        if (this.tr != null) {
            return this.tr.gD();
        }
        return null;
    }
}
