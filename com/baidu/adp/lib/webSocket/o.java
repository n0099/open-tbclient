package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class o implements k {
    protected g pA;
    private URI pB;
    private String pC;
    private String pD;
    private int pE;
    private String pF;
    private String pG;
    private l pH;
    protected am pI;
    private boolean pJ = false;
    private boolean pK = false;
    private volatile boolean pL = false;
    private long pM = 0;
    private d pN = null;
    private List<BasicNameValuePair> pq;
    private String[] pr;
    protected Handler px;
    protected volatile an py;
    protected volatile aq pz;

    public o() {
        createHandler();
    }

    public boolean sendMessage(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.pN != null || !isOpen()) {
            fZ();
            if (dVar != null) {
                dVar.u(1);
                return false;
            }
            return false;
        }
        this.pN = dVar;
        return d(this.pN);
    }

    private boolean d(d dVar) {
        if (this.pz == null) {
            n(new y(new Exception("mWriter = null")));
            return false;
        }
        return this.pz.q(new ab(dVar));
    }

    public void close(int i, String str) {
        this.pJ = false;
        this.pL = true;
        if (this.py != null) {
            this.py.quit();
            this.py = null;
        }
        if (this.pz != null) {
            this.pz.quit();
            this.pz = null;
        }
        if (this.pA != null) {
            try {
                this.pA.close();
            } catch (Throwable th) {
                if (fZ()) {
                    th.printStackTrace();
                }
            }
            this.pA = null;
        }
        l lVar = this.pH;
        this.pH = null;
        if (lVar != null) {
            try {
                lVar.l(i, str);
            } catch (Exception e) {
                if (fZ()) {
                    BdLog.d(e.getMessage());
                }
            }
        }
    }

    public void a(String str, String[] strArr, l lVar, am amVar, List<BasicNameValuePair> list) {
        this.pK = true;
        if (this.pA != null && this.pA.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.pB = new URI(str);
            if (!this.pB.getScheme().equals("ws") && !this.pB.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.pB.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.pC = this.pB.getScheme();
            if (this.pB.getPort() == -1) {
                if (this.pC.equals("ws")) {
                    this.pE = 80;
                } else {
                    this.pE = 443;
                }
            } else {
                this.pE = this.pB.getPort();
            }
            if (this.pB.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.pD = this.pB.getHost();
            if (this.pB.getPath() == null || this.pB.getPath().equals("")) {
                this.pF = "/";
            } else {
                this.pF = this.pB.getPath();
            }
            if (this.pB.getQuery() == null || this.pB.getQuery().equals("")) {
                this.pG = null;
            } else {
                this.pG = this.pB.getQuery();
            }
            this.pr = strArr;
            this.pq = list;
            this.pH = lVar;
            this.pI = new am(amVar);
            new q(this, null).start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Object obj) {
        Message obtainMessage = this.px.obtainMessage();
        obtainMessage.obj = obj;
        this.px.sendMessage(obtainMessage);
    }

    protected void createHandler() {
        this.px = new p(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ge() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.pz = new aq(handlerThread.getLooper(), this.px, this.pA, this.pI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void gf() {
        this.py = new an(this.px, this.pA, this.pI, "WebSocketReader");
        this.py.start();
    }

    public boolean gg() {
        return this.pN != null;
    }

    public boolean fY() {
        return this.pK;
    }

    public boolean isOpen() {
        return this.pJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fZ() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void ga() {
        if (this.pz != null) {
            this.pz.ga();
        }
    }

    public long getUpFlowSize() {
        if (this.pz != null) {
            return this.pz.getUpFlowSize();
        }
        return 0L;
    }

    public void gb() {
        if (this.py != null) {
            this.py.gb();
        }
    }

    public long getDownFlowSize() {
        if (this.py != null) {
            return this.py.getDownFlowSize();
        }
        return 0L;
    }

    public long gh() {
        if (this.pA != null) {
            return this.pA.fS();
        }
        return 0L;
    }

    public String gi() {
        if (this.pA != null) {
            return this.pA.fR();
        }
        return null;
    }

    public long gj() {
        return this.pM;
    }

    public String fu() {
        if (this.pA != null) {
            return this.pA.fu();
        }
        return null;
    }

    public String fv() {
        if (this.pA != null) {
            return this.pA.fv();
        }
        return null;
    }
}
