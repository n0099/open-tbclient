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
    private int pB;
    private String pC;
    private String pD;
    private l pE;
    protected am pF;
    private boolean pG = false;
    private boolean pH = false;
    private volatile boolean pI = false;
    private long pJ = 0;
    private d pK = null;
    private List<BasicNameValuePair> pl;
    private String[] po;
    protected Handler pu;
    protected volatile an pv;
    protected volatile aq pw;
    protected g px;
    private URI py;
    private String pz;

    public o() {
        gd();
    }

    public boolean sendMessage(d dVar) {
        if (dVar == null) {
            return false;
        }
        if (this.pK != null || !isOpen()) {
            fY();
            if (dVar != null) {
                dVar.i(1);
                return false;
            }
            return false;
        }
        this.pK = dVar;
        return d(this.pK);
    }

    private boolean d(d dVar) {
        if (this.pw == null) {
            l(new y(new Exception("mWriter = null")));
            return false;
        }
        return this.pw.o(new ab(dVar));
    }

    public void close(int i, String str) {
        this.pG = false;
        this.pI = true;
        if (this.pv != null) {
            this.pv.quit();
            this.pv = null;
        }
        if (this.pw != null) {
            this.pw.quit();
            this.pw = null;
        }
        if (this.px != null) {
            try {
                this.px.close();
            } catch (Throwable th) {
                if (fY()) {
                    th.printStackTrace();
                }
            }
            this.px = null;
        }
        l lVar = this.pE;
        this.pE = null;
        if (lVar != null) {
            try {
                lVar.b(i, str);
            } catch (Exception e) {
                if (fY()) {
                    BdLog.d(e.getMessage());
                }
            }
        }
    }

    public void a(String str, String[] strArr, l lVar, am amVar, List<BasicNameValuePair> list) {
        this.pH = true;
        if (this.px != null && this.px.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.py = new URI(str);
            if (!this.py.getScheme().equals("ws") && !this.py.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.py.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.pz = this.py.getScheme();
            if (this.py.getPort() == -1) {
                if (this.pz.equals("ws")) {
                    this.pB = 80;
                } else {
                    this.pB = 443;
                }
            } else {
                this.pB = this.py.getPort();
            }
            if (this.py.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.pA = this.py.getHost();
            if (this.py.getPath() == null || this.py.getPath().equals("")) {
                this.pC = "/";
            } else {
                this.pC = this.py.getPath();
            }
            if (this.py.getQuery() == null || this.py.getQuery().equals("")) {
                this.pD = null;
            } else {
                this.pD = this.py.getQuery();
            }
            this.po = strArr;
            this.pl = list;
            this.pE = lVar;
            this.pF = new am(amVar);
            new q(this, null).start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Object obj) {
        Message obtainMessage = this.pu.obtainMessage();
        obtainMessage.obj = obj;
        this.pu.sendMessage(obtainMessage);
    }

    protected void gd() {
        this.pu = new p(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ge() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.pw = new aq(handlerThread.getLooper(), this.pu, this.px, this.pF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void gf() {
        this.pv = new an(this.pu, this.px, this.pF, "WebSocketReader");
        this.pv.start();
    }

    public boolean gg() {
        return this.pK != null;
    }

    public boolean fX() {
        return this.pH;
    }

    public boolean isOpen() {
        return this.pG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fY() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void fZ() {
        if (this.pw != null) {
            this.pw.fZ();
        }
    }

    public long getUpFlowSize() {
        if (this.pw != null) {
            return this.pw.getUpFlowSize();
        }
        return 0L;
    }

    public void ga() {
        if (this.pv != null) {
            this.pv.ga();
        }
    }

    public long getDownFlowSize() {
        if (this.pv != null) {
            return this.pv.getDownFlowSize();
        }
        return 0L;
    }

    public long gh() {
        if (this.px != null) {
            return this.px.fR();
        }
        return 0L;
    }

    public String gi() {
        if (this.px != null) {
            return this.px.fQ();
        }
        return null;
    }

    public long gj() {
        return this.pJ;
    }

    public String fv() {
        if (this.px != null) {
            return this.px.fv();
        }
        return null;
    }

    public String fw() {
        if (this.px != null) {
            return this.px.fw();
        }
        return null;
    }
}
