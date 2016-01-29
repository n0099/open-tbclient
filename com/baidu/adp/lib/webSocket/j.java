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
    private URI Aa;
    private String Ab;
    private String Ac;
    private int Ae;
    private String Af;
    private String Ag;
    private g.a Ah;
    protected n Ai;
    private boolean Aj = false;
    private boolean Ak = false;
    private volatile boolean Al = false;
    private long Am = 0;
    private c An = null;
    private List<BasicNameValuePair> zP;
    private String[] zQ;
    protected Handler zW;
    protected volatile o zX;
    protected volatile q zY;
    protected e.a zZ;

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
                j.this.zZ = eVar.a(j.this.Ac, j.this.Ae, j.this.Ai, false);
                if (!j.this.Al) {
                    try {
                        if (j.this.zZ.isConnected()) {
                            j.this.Am = System.currentTimeMillis() - currentTimeMillis;
                            j.this.jV();
                            j.this.jU();
                            m.b bVar = new m.b(String.valueOf(j.this.Ac) + ":" + j.this.Ae);
                            bVar.mPath = j.this.Af;
                            bVar.Ar = j.this.Ag;
                            bVar.At = j.this.zQ;
                            bVar.Au = j.this.zP;
                            j.this.zY.r(bVar);
                            if (j.this.Al) {
                                j.this.o(new m.c());
                            }
                        } else {
                            j.this.o(new m.e(2, "cannot connect"));
                        }
                        return;
                    } catch (Throwable th) {
                        if (j.this.isDebug()) {
                            BdLog.e("----WebSocketConnector error. e:" + th.getMessage());
                        }
                        j.this.o(new m.f(new Exception(th)));
                        return;
                    }
                }
                j.this.o(new m.c());
            } catch (Throwable th2) {
                j.this.o(new m.e(2, th2.getMessage()));
            }
        }
    }

    public j() {
        jT();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.An != null || !isOpen()) {
            isDebug();
            if (cVar != null) {
                cVar.J(1);
                return false;
            }
            return false;
        }
        this.An = cVar;
        return d(this.An);
    }

    private boolean d(c cVar) {
        if (this.zY == null) {
            o(new m.f(new Exception("mWriter = null")));
            return false;
        }
        return this.zY.r(new m.i(cVar));
    }

    public void close(int i, String str) {
        this.Aj = false;
        this.Al = true;
        if (this.zX != null) {
            this.zX.quit();
            this.zX = null;
        }
        if (this.zY != null) {
            this.zY.quit();
            this.zY = null;
        }
        if (this.zZ != null) {
            try {
                this.zZ.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.zZ = null;
        }
        g.a aVar = this.Ah;
        this.Ah = null;
        if (aVar != null) {
            try {
                aVar.l(i, str);
            } catch (Exception e) {
                if (isDebug()) {
                    BdLog.d(e.getMessage());
                }
            }
        }
    }

    public void a(String str, String[] strArr, g.a aVar, n nVar, List<BasicNameValuePair> list) {
        this.Ak = true;
        if (this.zZ != null && this.zZ.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.Aa = new URI(str);
            if (!this.Aa.getScheme().equals("ws") && !this.Aa.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.Aa.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.Ab = this.Aa.getScheme();
            if (this.Aa.getPort() == -1) {
                if (this.Ab.equals("ws")) {
                    this.Ae = 80;
                } else {
                    this.Ae = 443;
                }
            } else {
                this.Ae = this.Aa.getPort();
            }
            if (this.Aa.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.Ac = this.Aa.getHost();
            if (this.Aa.getPath() == null || this.Aa.getPath().equals("")) {
                this.Af = "/";
            } else {
                this.Af = this.Aa.getPath();
            }
            if (this.Aa.getQuery() == null || this.Aa.getQuery().equals("")) {
                this.Ag = null;
            } else {
                this.Ag = this.Aa.getQuery();
            }
            this.zQ = strArr;
            this.zP = list;
            this.Ah = aVar;
            this.Ai = new n(nVar);
            new a(this, null).start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Object obj) {
        Message obtainMessage = this.zW.obtainMessage();
        obtainMessage.obj = obj;
        this.zW.sendMessage(obtainMessage);
    }

    protected void jT() {
        this.zW = new k(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(Object obj) {
    }

    protected void jU() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.zY = new q(handlerThread.getLooper(), this.zW, this.zZ, this.Ai);
    }

    protected void jV() {
        this.zX = new o(this.zW, this.zZ, this.Ai, "WebSocketReader");
        this.zX.start();
    }

    public boolean jW() {
        return this.An != null;
    }

    public boolean jP() {
        return this.Ak;
    }

    public boolean isOpen() {
        return this.Aj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void jQ() {
        if (this.zY != null) {
            this.zY.jQ();
        }
    }

    public long getUpFlowSize() {
        if (this.zY != null) {
            return this.zY.getUpFlowSize();
        }
        return 0L;
    }

    public void jR() {
        if (this.zX != null) {
            this.zX.jR();
        }
    }

    public long getDownFlowSize() {
        if (this.zX != null) {
            return this.zX.getDownFlowSize();
        }
        return 0L;
    }

    public long jX() {
        if (this.zZ != null) {
            return this.zZ.jI();
        }
        return 0L;
    }

    public String jY() {
        if (this.zZ != null) {
            return this.zZ.jH();
        }
        return null;
    }

    public long jZ() {
        return this.Am;
    }

    public String jr() {
        if (this.zZ != null) {
            return this.zZ.jr();
        }
        return null;
    }

    public String js() {
        if (this.zZ != null) {
            return this.zZ.js();
        }
        return null;
    }
}
