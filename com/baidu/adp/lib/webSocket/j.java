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
    protected Handler AD;
    protected volatile o AE;
    protected volatile q AF;
    protected e.a AG;
    private URI AH;
    private String AI;
    private String AJ;
    private int AK;
    private String AL;
    private String AM;
    private g.a AN;
    protected n AO;
    private boolean AP = false;
    private boolean AQ = false;
    private volatile boolean AR = false;
    private long AS = 0;
    private c AT = null;
    private List<BasicNameValuePair> Aw;
    private String[] Ax;

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
                j.this.AG = eVar.a(j.this.AJ, j.this.AK, j.this.AO, false);
                if (!j.this.AR) {
                    try {
                        if (j.this.AG.isConnected()) {
                            j.this.AS = System.currentTimeMillis() - currentTimeMillis;
                            j.this.id();
                            j.this.ic();
                            m.b bVar = new m.b(String.valueOf(j.this.AJ) + ":" + j.this.AK);
                            bVar.mPath = j.this.AL;
                            bVar.AX = j.this.AM;
                            bVar.AZ = j.this.Ax;
                            bVar.Ba = j.this.Aw;
                            j.this.AF.u(bVar);
                            if (j.this.AR) {
                                j.this.r(new m.c());
                            }
                        } else {
                            j.this.r(new m.e(2, "cannot connect"));
                        }
                        return;
                    } catch (Throwable th) {
                        if (j.this.hX()) {
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
        ib();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.AT != null || !isOpen()) {
            hX();
            if (cVar != null) {
                cVar.O(1);
                return false;
            }
            return false;
        }
        this.AT = cVar;
        return d(this.AT);
    }

    private boolean d(c cVar) {
        if (this.AF == null) {
            r(new m.f(new Exception("mWriter = null")));
            return false;
        }
        return this.AF.u(new m.i(cVar));
    }

    public void close(int i, String str) {
        this.AP = false;
        this.AR = true;
        if (this.AE != null) {
            this.AE.quit();
            this.AE = null;
        }
        if (this.AF != null) {
            this.AF.quit();
            this.AF = null;
        }
        if (this.AG != null) {
            try {
                this.AG.close();
            } catch (Throwable th) {
                if (hX()) {
                    th.printStackTrace();
                }
            }
            this.AG = null;
        }
        g.a aVar = this.AN;
        this.AN = null;
        if (aVar != null) {
            try {
                aVar.e(i, str);
            } catch (Exception e) {
                if (hX()) {
                    BdLog.d(e.getMessage());
                }
            }
        }
    }

    public void a(String str, String[] strArr, g.a aVar, n nVar, List<BasicNameValuePair> list) throws WebSocketException {
        this.AQ = true;
        if (this.AG != null && this.AG.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.AH = new URI(str);
            if (!this.AH.getScheme().equals("ws") && !this.AH.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.AH.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.AI = this.AH.getScheme();
            if (this.AH.getPort() == -1) {
                if (this.AI.equals("ws")) {
                    this.AK = 80;
                } else {
                    this.AK = 443;
                }
            } else {
                this.AK = this.AH.getPort();
            }
            if (this.AH.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.AJ = this.AH.getHost();
            if (this.AH.getPath() == null || this.AH.getPath().equals("")) {
                this.AL = "/";
            } else {
                this.AL = this.AH.getPath();
            }
            if (this.AH.getQuery() == null || this.AH.getQuery().equals("")) {
                this.AM = null;
            } else {
                this.AM = this.AH.getQuery();
            }
            this.Ax = strArr;
            this.Aw = list;
            this.AN = aVar;
            this.AO = new n(nVar);
            new a(this, null).start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Object obj) {
        Message obtainMessage = this.AD.obtainMessage();
        obtainMessage.obj = obj;
        this.AD.sendMessage(obtainMessage);
    }

    protected void ib() {
        this.AD = new k(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(Object obj) {
    }

    protected void ic() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.AF = new q(handlerThread.getLooper(), this.AD, this.AG, this.AO);
    }

    protected void id() {
        this.AE = new o(this.AD, this.AG, this.AO, "WebSocketReader");
        this.AE.start();
    }

    public boolean ie() {
        return this.AT != null;
    }

    public boolean hW() {
        return this.AQ;
    }

    public boolean isOpen() {
        return this.AP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hX() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void hY() {
        if (this.AF != null) {
            this.AF.hY();
        }
    }

    public long getUpFlowSize() {
        if (this.AF != null) {
            return this.AF.getUpFlowSize();
        }
        return 0L;
    }

    public void hZ() {
        if (this.AE != null) {
            this.AE.hZ();
        }
    }

    public long getDownFlowSize() {
        if (this.AE != null) {
            return this.AE.getDownFlowSize();
        }
        return 0L;
    }

    /* renamed from: if  reason: not valid java name */
    public long m5if() {
        if (this.AG != null) {
            return this.AG.hP();
        }
        return 0L;
    }

    public String ig() {
        if (this.AG != null) {
            return this.AG.hO();
        }
        return null;
    }

    public long ih() {
        return this.AS;
    }

    public String hw() {
        if (this.AG != null) {
            return this.AG.hw();
        }
        return null;
    }

    public String hx() {
        if (this.AG != null) {
            return this.AG.hx();
        }
        return null;
    }
}
