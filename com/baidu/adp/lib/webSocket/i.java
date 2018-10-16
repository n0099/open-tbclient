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
    private String HA;
    private int HB;
    private String HC;
    private String HD;
    private g.a HE;
    protected l HF;
    private List<BasicNameValuePair> Hn;
    private String[] Ho;
    protected Handler Hu;
    protected volatile m Hv;
    protected volatile o Hw;
    protected e.a Hx;
    private URI Hy;
    private String Hz;
    private boolean mIsOpen = false;
    private boolean HG = false;
    private volatile boolean HH = false;
    private long HI = 0;
    private c HJ = null;

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
                i.this.Hx = eVar.a(i.this.HA, i.this.HB, i.this.HF, false);
                if (i.this.HH) {
                    i.this.x(new k.c());
                    return;
                }
                try {
                    if (!i.this.Hx.isConnected()) {
                        i.this.x(new k.e(2, "cannot connect"));
                    } else {
                        i.this.HI = System.currentTimeMillis() - currentTimeMillis;
                        i.this.lQ();
                        i.this.lP();
                        k.b bVar = new k.b(i.this.HA + ":" + i.this.HB);
                        bVar.mPath = i.this.HC;
                        bVar.mQuery = i.this.HD;
                        bVar.HM = i.this.Ho;
                        bVar.HN = i.this.Hn;
                        i.this.Hw.A(bVar);
                        if (i.this.HH) {
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
        lO();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.HJ != null || !isOpen()) {
            if (isDebug()) {
            }
            if (cVar != null) {
                cVar.O(1);
                return false;
            }
            return false;
        }
        this.HJ = cVar;
        return d(this.HJ);
    }

    private boolean d(c cVar) {
        if (this.Hw == null) {
            x(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.Hw.A(new k.i(cVar));
    }

    public void close(int i, String str) {
        this.mIsOpen = false;
        this.HH = true;
        if (this.Hv != null) {
            this.Hv.quit();
            this.Hv = null;
        }
        if (this.Hw != null) {
            this.Hw.quit();
            this.Hw = null;
        }
        if (this.Hx != null) {
            try {
                this.Hx.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.Hx = null;
        }
        g.a aVar = this.HE;
        this.HE = null;
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
        this.HG = true;
        if (this.Hx != null && this.Hx.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.Hy = new URI(str);
            if (!this.Hy.getScheme().equals("ws") && !this.Hy.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.Hy.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.Hz = this.Hy.getScheme();
            if (this.Hy.getPort() == -1) {
                if (this.Hz.equals("ws")) {
                    this.HB = 80;
                } else {
                    this.HB = 443;
                }
            } else {
                this.HB = this.Hy.getPort();
            }
            if (this.Hy.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.HA = this.Hy.getHost();
            if (this.Hy.getPath() == null || this.Hy.getPath().equals("")) {
                this.HC = "/";
            } else {
                this.HC = this.Hy.getPath();
            }
            if (this.Hy.getQuery() == null || this.Hy.getQuery().equals("")) {
                this.HD = null;
            } else {
                this.HD = this.Hy.getQuery();
            }
            this.Ho = strArr;
            this.Hn = list;
            this.HE = aVar;
            this.HF = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(Object obj) {
        Message obtainMessage = this.Hu.obtainMessage();
        obtainMessage.obj = obj;
        this.Hu.sendMessage(obtainMessage);
    }

    protected void lO() {
        this.Hu = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.HE != null) {
                        i.this.HE.aj(sVar.HW);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.HE != null) {
                        i.this.HE.x(mVar.HL);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.HE != null) {
                        i.this.HE.b(aVar);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0021k c0021k = new k.C0021k();
                    c0021k.HL = ((k.j) message.obj).HL;
                    i.this.Hw.A(c0021k);
                } else if (message.obj instanceof k.C0021k) {
                    k.C0021k c0021k2 = (k.C0021k) message.obj;
                    if (i.this.HE != null) {
                        i.this.HE.lG();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.HV) {
                        if (i.this.HE != null) {
                            i.this.HE.onOpen(qVar.mHeaders);
                            i.this.mIsOpen = true;
                            i.this.HG = false;
                            if (i.this.HE != null) {
                                i.this.HE.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).HP;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).HS;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).mException.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.HQ + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).HQ);
                } else if (message.obj instanceof k.r) {
                    if (i.this.HE != null) {
                        i.this.HE.b(((k.r) message.obj).HU);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.HJ = null;
                    c cVar = ((k.g) message.obj).HU;
                    if (i.this.HE != null) {
                        i.this.HE.c(cVar);
                    }
                    if (i.this.HE != null) {
                        i.this.HE.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.HJ = null;
                    c cVar2 = ((k.n) message.obj).HU;
                    if (i.this.HE != null) {
                        i.this.HE.a(2, cVar2);
                    }
                    if (i.this.HE != null) {
                        i.this.HE.a(cVar2);
                    }
                } else {
                    i.this.y(message.obj);
                }
            }
        };
    }

    protected void y(Object obj) {
    }

    protected void lP() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.Hw = new o(handlerThread.getLooper(), this.Hu, this.Hx, this.HF);
    }

    protected void lQ() {
        this.Hv = new m(this.Hu, this.Hx, this.HF, "WebSocketReader");
        this.Hv.start();
    }

    public boolean lR() {
        return this.HJ != null;
    }

    public boolean isConnecting() {
        return this.HG;
    }

    public boolean isOpen() {
        return this.mIsOpen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void lL() {
        if (this.Hw != null) {
            this.Hw.lL();
        }
    }

    public long getUpFlowSize() {
        if (this.Hw != null) {
            return this.Hw.getUpFlowSize();
        }
        return 0L;
    }

    public void lM() {
        if (this.Hv != null) {
            this.Hv.lM();
        }
    }

    public long getDownFlowSize() {
        if (this.Hv != null) {
            return this.Hv.getDownFlowSize();
        }
        return 0L;
    }

    public long lS() {
        if (this.Hx != null) {
            return this.Hx.lE();
        }
        return 0L;
    }

    public String lT() {
        if (this.Hx != null) {
            return this.Hx.lD();
        }
        return null;
    }

    public long lU() {
        return this.HI;
    }

    public String getLocalDns() {
        if (this.Hx != null) {
            return this.Hx.getLocalDns();
        }
        return null;
    }

    public String lp() {
        if (this.Hx != null) {
            return this.Hx.lp();
        }
        return null;
    }
}
