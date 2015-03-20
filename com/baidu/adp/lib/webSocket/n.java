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
public class n implements j {
    private String[] Aa;
    protected Handler Ah;
    protected volatile am Ai;
    protected volatile ap Aj;
    protected f Ak;
    private URI Al;
    private String Am;
    private String An;
    private int Ao;
    private String Ap;
    private String Aq;
    private k Ar;
    protected al As;
    private boolean At = false;
    private boolean Au = false;
    private volatile boolean Av = false;
    private long Aw = 0;
    private c Ax = null;
    private List<BasicNameValuePair> zZ;

    public n() {
        createHandler();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.Ax != null || !isOpen()) {
            jw();
            if (cVar != null) {
                cVar.v(1);
                return false;
            }
            return false;
        }
        this.Ax = cVar;
        return d(this.Ax);
    }

    private boolean d(c cVar) {
        if (this.Aj == null) {
            n(new x(new Exception("mWriter = null")));
            return false;
        }
        return this.Aj.q(new aa(cVar));
    }

    public void close(int i, String str) {
        this.At = false;
        this.Av = true;
        if (this.Ai != null) {
            this.Ai.quit();
            this.Ai = null;
        }
        if (this.Aj != null) {
            this.Aj.quit();
            this.Aj = null;
        }
        if (this.Ak != null) {
            try {
                this.Ak.close();
            } catch (Throwable th) {
                if (jw()) {
                    th.printStackTrace();
                }
            }
            this.Ak = null;
        }
        k kVar = this.Ar;
        this.Ar = null;
        if (kVar != null) {
            try {
                kVar.l(i, str);
            } catch (Exception e) {
                if (jw()) {
                    BdLog.d(e.getMessage());
                }
            }
        }
    }

    public void a(String str, String[] strArr, k kVar, al alVar, List<BasicNameValuePair> list) {
        this.Au = true;
        if (this.Ak != null && this.Ak.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.Al = new URI(str);
            if (!this.Al.getScheme().equals("ws") && !this.Al.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.Al.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.Am = this.Al.getScheme();
            if (this.Al.getPort() == -1) {
                if (this.Am.equals("ws")) {
                    this.Ao = 80;
                } else {
                    this.Ao = 443;
                }
            } else {
                this.Ao = this.Al.getPort();
            }
            if (this.Al.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.An = this.Al.getHost();
            if (this.Al.getPath() == null || this.Al.getPath().equals("")) {
                this.Ap = "/";
            } else {
                this.Ap = this.Al.getPath();
            }
            if (this.Al.getQuery() == null || this.Al.getQuery().equals("")) {
                this.Aq = null;
            } else {
                this.Aq = this.Al.getQuery();
            }
            this.Aa = strArr;
            this.zZ = list;
            this.Ar = kVar;
            this.As = new al(alVar);
            new p(this, null).start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Object obj) {
        Message obtainMessage = this.Ah.obtainMessage();
        obtainMessage.obj = obj;
        this.Ah.sendMessage(obtainMessage);
    }

    protected void createHandler() {
        this.Ah = new o(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void jA() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.Aj = new ap(handlerThread.getLooper(), this.Ah, this.Ak, this.As);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void jB() {
        this.Ai = new am(this.Ah, this.Ak, this.As, "WebSocketReader");
        this.Ai.start();
    }

    public boolean jC() {
        return this.Ax != null;
    }

    public boolean jv() {
        return this.Au;
    }

    public boolean isOpen() {
        return this.At;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean jw() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void jx() {
        if (this.Aj != null) {
            this.Aj.jx();
        }
    }

    public long getUpFlowSize() {
        if (this.Aj != null) {
            return this.Aj.getUpFlowSize();
        }
        return 0L;
    }

    public void jy() {
        if (this.Ai != null) {
            this.Ai.jy();
        }
    }

    public long getDownFlowSize() {
        if (this.Ai != null) {
            return this.Ai.getDownFlowSize();
        }
        return 0L;
    }

    public long jD() {
        if (this.Ak != null) {
            return this.Ak.jo();
        }
        return 0L;
    }

    public String jE() {
        if (this.Ak != null) {
            return this.Ak.jn();
        }
        return null;
    }

    public long jF() {
        return this.Aw;
    }

    public String iX() {
        if (this.Ak != null) {
            return this.Ak.iX();
        }
        return null;
    }

    public String iY() {
        if (this.Ak != null) {
            return this.Ak.iY();
        }
        return null;
    }
}
