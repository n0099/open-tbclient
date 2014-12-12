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
    private String pA;
    private String pB;
    private l pC;
    protected am pD;
    private boolean pE = false;
    private boolean pF = false;
    private volatile boolean pG = false;
    private long pH = 0;
    private d pI = null;
    private List<BasicNameValuePair> pi;
    private String[] pj;
    protected Handler ps;
    protected volatile an pt;
    protected volatile aq pu;
    protected g pv;
    private URI pw;
    private String px;
    private String py;
    private int pz;

    public o() {
        createHandler();
    }

    public boolean sendMessage(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.pI != null || !isOpen()) {
            ga();
            if (dVar != null) {
                dVar.u(1);
                return false;
            }
            return false;
        }
        this.pI = dVar;
        return d(this.pI);
    }

    private boolean d(d dVar) {
        if (this.pu == null) {
            n(new y(new Exception("mWriter = null")));
            return false;
        }
        return this.pu.q(new ab(dVar));
    }

    public void close(int i, String str) {
        this.pE = false;
        this.pG = true;
        if (this.pt != null) {
            this.pt.quit();
            this.pt = null;
        }
        if (this.pu != null) {
            this.pu.quit();
            this.pu = null;
        }
        if (this.pv != null) {
            try {
                this.pv.close();
            } catch (Throwable th) {
                if (ga()) {
                    th.printStackTrace();
                }
            }
            this.pv = null;
        }
        l lVar = this.pC;
        this.pC = null;
        if (lVar != null) {
            try {
                lVar.l(i, str);
            } catch (Exception e) {
                if (ga()) {
                    BdLog.d(e.getMessage());
                }
            }
        }
    }

    public void a(String str, String[] strArr, l lVar, am amVar, List<BasicNameValuePair> list) {
        this.pF = true;
        if (this.pv != null && this.pv.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.pw = new URI(str);
            if (!this.pw.getScheme().equals("ws") && !this.pw.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.pw.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.px = this.pw.getScheme();
            if (this.pw.getPort() == -1) {
                if (this.px.equals("ws")) {
                    this.pz = 80;
                } else {
                    this.pz = 443;
                }
            } else {
                this.pz = this.pw.getPort();
            }
            if (this.pw.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.py = this.pw.getHost();
            if (this.pw.getPath() == null || this.pw.getPath().equals("")) {
                this.pA = "/";
            } else {
                this.pA = this.pw.getPath();
            }
            if (this.pw.getQuery() == null || this.pw.getQuery().equals("")) {
                this.pB = null;
            } else {
                this.pB = this.pw.getQuery();
            }
            this.pj = strArr;
            this.pi = list;
            this.pC = lVar;
            this.pD = new am(amVar);
            new q(this, null).start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Object obj) {
        Message obtainMessage = this.ps.obtainMessage();
        obtainMessage.obj = obj;
        this.ps.sendMessage(obtainMessage);
    }

    protected void createHandler() {
        this.ps = new p(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void gf() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.pu = new aq(handlerThread.getLooper(), this.ps, this.pv, this.pD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void gg() {
        this.pt = new an(this.ps, this.pv, this.pD, "WebSocketReader");
        this.pt.start();
    }

    public boolean gh() {
        return this.pI != null;
    }

    public boolean fZ() {
        return this.pF;
    }

    public boolean isOpen() {
        return this.pE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ga() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void gb() {
        if (this.pu != null) {
            this.pu.gb();
        }
    }

    public long getUpFlowSize() {
        if (this.pu != null) {
            return this.pu.getUpFlowSize();
        }
        return 0L;
    }

    public void gd() {
        if (this.pt != null) {
            this.pt.gd();
        }
    }

    public long getDownFlowSize() {
        if (this.pt != null) {
            return this.pt.getDownFlowSize();
        }
        return 0L;
    }

    public long gi() {
        if (this.pv != null) {
            return this.pv.fT();
        }
        return 0L;
    }

    public String gj() {
        if (this.pv != null) {
            return this.pv.fS();
        }
        return null;
    }

    public long gk() {
        return this.pH;
    }

    public String fv() {
        if (this.pv != null) {
            return this.pv.fv();
        }
        return null;
    }

    public String fw() {
        if (this.pv != null) {
            return this.pv.fw();
        }
        return null;
    }
}
