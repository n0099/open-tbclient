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
    private String Aa;
    private String Ab;
    private int Ac;
    private String Ae;
    private String Af;
    private k Ag;
    protected al Ah;
    private boolean Ai = false;
    private boolean Aj = false;
    private volatile boolean Ak = false;
    private long Al = 0;
    private c Am = null;
    private List<BasicNameValuePair> zO;
    private String[] zP;
    protected Handler zV;
    protected volatile am zW;
    protected volatile ap zX;
    protected f zY;
    private URI zZ;

    public n() {
        createHandler();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.Am != null || !isOpen()) {
            jN();
            if (cVar != null) {
                cVar.w(1);
                return false;
            }
            return false;
        }
        this.Am = cVar;
        return d(this.Am);
    }

    private boolean d(c cVar) {
        if (this.zX == null) {
            n(new x(new Exception("mWriter = null")));
            return false;
        }
        return this.zX.q(new aa(cVar));
    }

    public void close(int i, String str) {
        this.Ai = false;
        this.Ak = true;
        if (this.zW != null) {
            this.zW.quit();
            this.zW = null;
        }
        if (this.zX != null) {
            this.zX.quit();
            this.zX = null;
        }
        if (this.zY != null) {
            try {
                this.zY.close();
            } catch (Throwable th) {
                if (jN()) {
                    th.printStackTrace();
                }
            }
            this.zY = null;
        }
        k kVar = this.Ag;
        this.Ag = null;
        if (kVar != null) {
            try {
                kVar.l(i, str);
            } catch (Exception e) {
                if (jN()) {
                    BdLog.d(e.getMessage());
                }
            }
        }
    }

    public void a(String str, String[] strArr, k kVar, al alVar, List<BasicNameValuePair> list) {
        this.Aj = true;
        if (this.zY != null && this.zY.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.zZ = new URI(str);
            if (!this.zZ.getScheme().equals("ws") && !this.zZ.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.zZ.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.Aa = this.zZ.getScheme();
            if (this.zZ.getPort() == -1) {
                if (this.Aa.equals("ws")) {
                    this.Ac = 80;
                } else {
                    this.Ac = 443;
                }
            } else {
                this.Ac = this.zZ.getPort();
            }
            if (this.zZ.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.Ab = this.zZ.getHost();
            if (this.zZ.getPath() == null || this.zZ.getPath().equals("")) {
                this.Ae = "/";
            } else {
                this.Ae = this.zZ.getPath();
            }
            if (this.zZ.getQuery() == null || this.zZ.getQuery().equals("")) {
                this.Af = null;
            } else {
                this.Af = this.zZ.getQuery();
            }
            this.zP = strArr;
            this.zO = list;
            this.Ag = kVar;
            this.Ah = new al(alVar);
            new p(this, null).start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Object obj) {
        Message obtainMessage = this.zV.obtainMessage();
        obtainMessage.obj = obj;
        this.zV.sendMessage(obtainMessage);
    }

    protected void createHandler() {
        this.zV = new o(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void jR() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.zX = new ap(handlerThread.getLooper(), this.zV, this.zY, this.Ah);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void jS() {
        this.zW = new am(this.zV, this.zY, this.Ah, "WebSocketReader");
        this.zW.start();
    }

    public boolean jT() {
        return this.Am != null;
    }

    public boolean jM() {
        return this.Aj;
    }

    public boolean isOpen() {
        return this.Ai;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean jN() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void jO() {
        if (this.zX != null) {
            this.zX.jO();
        }
    }

    public long getUpFlowSize() {
        if (this.zX != null) {
            return this.zX.getUpFlowSize();
        }
        return 0L;
    }

    public void jP() {
        if (this.zW != null) {
            this.zW.jP();
        }
    }

    public long getDownFlowSize() {
        if (this.zW != null) {
            return this.zW.getDownFlowSize();
        }
        return 0L;
    }

    public long jU() {
        if (this.zY != null) {
            return this.zY.jF();
        }
        return 0L;
    }

    public String jV() {
        if (this.zY != null) {
            return this.zY.jE();
        }
        return null;
    }

    public long jW() {
        return this.Al;
    }

    public String jm() {
        if (this.zY != null) {
            return this.zY.jm();
        }
        return null;
    }

    public String jn() {
        if (this.zY != null) {
            return this.zY.jn();
        }
        return null;
    }
}
