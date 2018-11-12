package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.e;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.adp.lib.webSocket.k;
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class i implements g {
    protected volatile o HA;
    protected e.a HB;
    private URI HC;
    private String HD;
    private String HE;
    private int HF;
    private String HG;
    private String HH;
    private g.a HI;
    protected l HJ;
    private List<BasicNameValuePair> Hr;
    private String[] Hs;
    protected Handler Hy;
    protected volatile m Hz;
    private boolean mIsOpen = false;
    private boolean HK = false;
    private volatile boolean HL = false;
    private long HM = 0;
    private c HN = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Thread {
        private a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Thread.currentThread().setName("WebSocketConnector");
            long currentTimeMillis = System.currentTimeMillis();
            try {
                e eVar = new e();
                i.this.HB = eVar.a(i.this.HE, i.this.HF, i.this.HJ, false);
                if (i.this.HL) {
                    i.this.x(new k.c());
                    return;
                }
                try {
                    if (!i.this.HB.isConnected()) {
                        i.this.x(new k.e(2, "cannot connect"));
                    } else {
                        i.this.HM = System.currentTimeMillis() - currentTimeMillis;
                        i.this.lO();
                        i.this.lN();
                        k.b bVar = new k.b(i.this.HE + ":" + i.this.HF);
                        bVar.mPath = i.this.HG;
                        bVar.mQuery = i.this.HH;
                        bVar.HQ = i.this.Hs;
                        bVar.HR = i.this.Hr;
                        i.this.HA.A(bVar);
                        if (i.this.HL) {
                            i.this.x(new k.c());
                        }
                    }
                } catch (Throwable th) {
                    if (i.this.isDebug()) {
                        BdLog.e("----WebSocketConnector error. e:" + th.getMessage());
                    }
                    i.this.x(new k.f(new Exception(th)));
                }
            } catch (Throwable th2) {
                i.this.x(new k.e(2, th2.getMessage()));
            }
        }
    }

    public i() {
        lM();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.HN != null || !isOpen()) {
            if (isDebug()) {
            }
            if (cVar != null) {
                cVar.af(1);
                return false;
            }
            return false;
        }
        this.HN = cVar;
        return d(this.HN);
    }

    private boolean d(c cVar) {
        if (this.HA == null) {
            x(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.HA.A(new k.i(cVar));
    }

    public void close(int i, String str) {
        this.mIsOpen = false;
        this.HL = true;
        if (this.Hz != null) {
            this.Hz.quit();
            this.Hz = null;
        }
        if (this.HA != null) {
            this.HA.quit();
            this.HA = null;
        }
        if (this.HB != null) {
            try {
                this.HB.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.HB = null;
        }
        g.a aVar = this.HI;
        this.HI = null;
        if (aVar != null) {
            try {
                aVar.f(i, str);
            } catch (Exception e) {
                if (isDebug()) {
                    BdLog.d(e.getMessage());
                }
            }
        }
    }

    public void a(String str, String[] strArr, g.a aVar, l lVar, List<BasicNameValuePair> list) throws WebSocketException {
        this.HK = true;
        if (this.HB != null && this.HB.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.HC = new URI(str);
            if (!this.HC.getScheme().equals("ws") && !this.HC.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.HC.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.HD = this.HC.getScheme();
            if (this.HC.getPort() == -1) {
                if (this.HD.equals("ws")) {
                    this.HF = 80;
                } else {
                    this.HF = 443;
                }
            } else {
                this.HF = this.HC.getPort();
            }
            if (this.HC.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.HE = this.HC.getHost();
            if (this.HC.getPath() == null || this.HC.getPath().equals("")) {
                this.HG = "/";
            } else {
                this.HG = this.HC.getPath();
            }
            if (this.HC.getQuery() == null || this.HC.getQuery().equals("")) {
                this.HH = null;
            } else {
                this.HH = this.HC.getQuery();
            }
            this.Hs = strArr;
            this.Hr = list;
            this.HI = aVar;
            this.HJ = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(Object obj) {
        Message obtainMessage = this.Hy.obtainMessage();
        obtainMessage.obj = obj;
        this.Hy.sendMessage(obtainMessage);
    }

    protected void lM() {
        this.Hy = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.HI != null) {
                        i.this.HI.aj(sVar.Ia);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.HI != null) {
                        i.this.HI.w(mVar.HP);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.HI != null) {
                        i.this.HI.b(aVar);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0021k c0021k = new k.C0021k();
                    c0021k.HP = ((k.j) message.obj).HP;
                    i.this.HA.A(c0021k);
                } else if (message.obj instanceof k.C0021k) {
                    k.C0021k c0021k2 = (k.C0021k) message.obj;
                    if (i.this.HI != null) {
                        i.this.HI.lE();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.HZ) {
                        if (i.this.HI != null) {
                            i.this.HI.onOpen(qVar.mHeaders);
                            i.this.mIsOpen = true;
                            i.this.HK = false;
                            if (i.this.HI != null) {
                                i.this.HI.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).HU;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).HX;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).mException.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.HV + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).HV);
                } else if (message.obj instanceof k.r) {
                    if (i.this.HI != null) {
                        i.this.HI.b(((k.r) message.obj).HY);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.HN = null;
                    c cVar = ((k.g) message.obj).HY;
                    if (i.this.HI != null) {
                        i.this.HI.c(cVar);
                    }
                    if (i.this.HI != null) {
                        i.this.HI.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.HN = null;
                    c cVar2 = ((k.n) message.obj).HY;
                    if (i.this.HI != null) {
                        i.this.HI.a(2, cVar2);
                    }
                    if (i.this.HI != null) {
                        i.this.HI.a(cVar2);
                    }
                } else {
                    i.this.y(message.obj);
                }
            }
        };
    }

    protected void y(Object obj) {
    }

    protected void lN() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.HA = new o(handlerThread.getLooper(), this.Hy, this.HB, this.HJ);
    }

    protected void lO() {
        this.Hz = new m(this.Hy, this.HB, this.HJ, "WebSocketReader");
        this.Hz.start();
    }

    public boolean lP() {
        return this.HN != null;
    }

    public boolean isConnecting() {
        return this.HK;
    }

    public boolean isOpen() {
        return this.mIsOpen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void lJ() {
        if (this.HA != null) {
            this.HA.lJ();
        }
    }

    public long getUpFlowSize() {
        if (this.HA != null) {
            return this.HA.getUpFlowSize();
        }
        return 0L;
    }

    public void lK() {
        if (this.Hz != null) {
            this.Hz.lK();
        }
    }

    public long getDownFlowSize() {
        if (this.Hz != null) {
            return this.Hz.getDownFlowSize();
        }
        return 0L;
    }

    public long lQ() {
        if (this.HB != null) {
            return this.HB.lC();
        }
        return 0L;
    }

    public String lR() {
        if (this.HB != null) {
            return this.HB.lB();
        }
        return null;
    }

    public long lS() {
        return this.HM;
    }

    public String getLocalDns() {
        if (this.HB != null) {
            return this.HB.getLocalDns();
        }
        return null;
    }

    public String ln() {
        if (this.HB != null) {
            return this.HB.ln();
        }
        return null;
    }
}
