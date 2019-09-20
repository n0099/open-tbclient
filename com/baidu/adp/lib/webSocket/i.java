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
    protected l FA;
    private boolean FB = false;
    private boolean FC = false;
    private volatile boolean FD = false;
    private long FE = 0;
    private c FF = null;
    private List<BasicNameValuePair> Fi;
    private String[] Fj;
    protected Handler Fp;
    protected volatile m Fq;
    protected volatile o Fr;
    protected e.a Fs;
    private URI Ft;
    private String Fu;
    private String Fv;
    private int Fw;
    private String Fx;
    private String Fy;
    private g.a Fz;

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
                i.this.Fs = eVar.a(i.this.Fv, i.this.Fw, i.this.FA, false);
                if (i.this.FD) {
                    i.this.u(new k.c());
                    return;
                }
                try {
                    if (!i.this.Fs.isConnected()) {
                        i.this.u(new k.e(2, "cannot connect"));
                    } else {
                        i.this.FE = System.currentTimeMillis() - currentTimeMillis;
                        i.this.lb();
                        i.this.la();
                        k.b bVar = new k.b(i.this.Fv + ":" + i.this.Fw);
                        bVar.wX = i.this.Fx;
                        bVar.mQuery = i.this.Fy;
                        bVar.FK = i.this.Fj;
                        bVar.FL = i.this.Fi;
                        i.this.Fr.x(bVar);
                        if (i.this.FD) {
                            i.this.u(new k.c());
                        }
                    }
                } catch (Throwable th) {
                    if (i.this.isDebug()) {
                        BdLog.e("----WebSocketConnector error. e:" + th.getMessage());
                    }
                    i.this.u(new k.f(new Exception(th)));
                }
            } catch (Throwable th2) {
                i.this.u(new k.e(2, th2.getMessage()));
            }
        }
    }

    public i() {
        kZ();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.FF != null || !isOpen()) {
            if (isDebug()) {
            }
            if (cVar != null) {
                cVar.G(1);
                return false;
            }
            return false;
        }
        this.FF = cVar;
        return d(this.FF);
    }

    private boolean d(c cVar) {
        if (this.Fr == null) {
            u(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.Fr.x(new k.i(cVar));
    }

    public void close(int i, String str) {
        if (com.baidu.adp.lib.b.d.hS().az("need_more_logs") == 1) {
            com.baidu.adp.framework.client.socket.i.a("more_log", 0, 0, "onClose", i, str);
        }
        this.FB = false;
        this.FD = true;
        if (this.Fq != null) {
            this.Fq.quit();
            this.Fq = null;
        }
        if (this.Fr != null) {
            this.Fr.quit();
            this.Fr = null;
        }
        if (this.Fs != null) {
            try {
                this.Fs.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.Fs = null;
        }
        g.a aVar = this.Fz;
        this.Fz = null;
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
        this.FC = true;
        if (this.Fs != null && this.Fs.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.Ft = new URI(str);
            if (!this.Ft.getScheme().equals("ws") && !this.Ft.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.Ft.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.Fu = this.Ft.getScheme();
            if (this.Ft.getPort() == -1) {
                if (this.Fu.equals("ws")) {
                    this.Fw = 80;
                } else {
                    this.Fw = 443;
                }
            } else {
                this.Fw = this.Ft.getPort();
            }
            if (this.Ft.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.Fv = this.Ft.getHost();
            if (this.Ft.getPath() == null || this.Ft.getPath().equals("")) {
                this.Fx = "/";
            } else {
                this.Fx = this.Ft.getPath();
            }
            if (this.Ft.getQuery() == null || this.Ft.getQuery().equals("")) {
                this.Fy = null;
            } else {
                this.Fy = this.Ft.getQuery();
            }
            this.Fj = strArr;
            this.Fi = list;
            this.Fz = aVar;
            this.FA = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Object obj) {
        Message obtainMessage = this.Fp.obtainMessage();
        obtainMessage.obj = obj;
        this.Fp.sendMessage(obtainMessage);
    }

    protected void kZ() {
        this.Fp = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.Fz != null) {
                        i.this.Fz.S(sVar.FW);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.Fz != null) {
                        i.this.Fz.q(mVar.FH);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.Fz != null) {
                        i.this.Fz.b(aVar);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0019k c0019k = new k.C0019k();
                    c0019k.FH = ((k.j) message.obj).FH;
                    i.this.Fr.x(c0019k);
                } else if (message.obj instanceof k.C0019k) {
                    k.C0019k c0019k2 = (k.C0019k) message.obj;
                    if (i.this.Fz != null) {
                        i.this.Fz.kR();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.FU) {
                        if (i.this.Fz != null) {
                            i.this.Fz.onOpen(qVar.FV);
                            i.this.FB = true;
                            i.this.FC = false;
                            if (i.this.Fz != null) {
                                i.this.Fz.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).FN;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).FR;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).FP.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.FO + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).FO);
                } else if (message.obj instanceof k.r) {
                    if (i.this.Fz != null) {
                        i.this.Fz.b(((k.r) message.obj).FT);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.FF = null;
                    c cVar = ((k.g) message.obj).FT;
                    if (i.this.Fz != null) {
                        i.this.Fz.c(cVar);
                    }
                    if (i.this.Fz != null) {
                        i.this.Fz.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.FF = null;
                    c cVar2 = ((k.n) message.obj).FT;
                    if (i.this.Fz != null) {
                        i.this.Fz.a(2, cVar2);
                    }
                    if (i.this.Fz != null) {
                        i.this.Fz.a(cVar2);
                    }
                } else {
                    i.this.v(message.obj);
                }
            }
        };
    }

    protected void v(Object obj) {
    }

    protected void la() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.Fr = new o(handlerThread.getLooper(), this.Fp, this.Fs, this.FA);
    }

    protected void lb() {
        this.Fq = new m(this.Fp, this.Fs, this.FA, "WebSocketReader");
        this.Fq.start();
    }

    public boolean lc() {
        return this.FF != null;
    }

    public boolean isConnecting() {
        return this.FC;
    }

    public boolean isOpen() {
        return this.FB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void kW() {
        if (this.Fr != null) {
            this.Fr.kW();
        }
    }

    public long getUpFlowSize() {
        if (this.Fr != null) {
            return this.Fr.getUpFlowSize();
        }
        return 0L;
    }

    public void kX() {
        if (this.Fq != null) {
            this.Fq.kX();
        }
    }

    public long getDownFlowSize() {
        if (this.Fq != null) {
            return this.Fq.getDownFlowSize();
        }
        return 0L;
    }

    public long ld() {
        if (this.Fs != null) {
            return this.Fs.kP();
        }
        return 0L;
    }

    public String le() {
        if (this.Fs != null) {
            return this.Fs.kO();
        }
        return null;
    }

    public long lf() {
        return this.FE;
    }

    public String ku() {
        if (this.Fs != null) {
            return this.Fs.ku();
        }
        return null;
    }

    public String kv() {
        if (this.Fs != null) {
            return this.Fs.kv();
        }
        return null;
    }
}
