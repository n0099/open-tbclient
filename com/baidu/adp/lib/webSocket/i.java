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
    private List<BasicNameValuePair> Fb;
    private String[] Fc;
    protected Handler Fi;
    protected volatile m Fj;
    protected volatile o Fk;
    protected e.a Fl;
    private URI Fm;
    private String Fn;
    private String Fo;
    private int Fp;
    private String Fq;
    private String Fr;
    private g.a Fs;
    protected l Ft;
    private boolean Fu = false;
    private boolean Fv = false;
    private volatile boolean Fw = false;
    private long Fx = 0;
    private c Fy = null;

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
                i.this.Fl = eVar.a(i.this.Fo, i.this.Fp, i.this.Ft, false);
                if (i.this.Fw) {
                    i.this.u(new k.c());
                    return;
                }
                try {
                    if (!i.this.Fl.isConnected()) {
                        i.this.u(new k.e(2, "cannot connect"));
                    } else {
                        i.this.Fx = System.currentTimeMillis() - currentTimeMillis;
                        i.this.kM();
                        i.this.kL();
                        k.b bVar = new k.b(i.this.Fo + ":" + i.this.Fp);
                        bVar.wU = i.this.Fq;
                        bVar.mQuery = i.this.Fr;
                        bVar.FD = i.this.Fc;
                        bVar.FE = i.this.Fb;
                        i.this.Fk.x(bVar);
                        if (i.this.Fw) {
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
        kK();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.Fy != null || !isOpen()) {
            if (isDebug()) {
            }
            if (cVar != null) {
                cVar.G(1);
                return false;
            }
            return false;
        }
        this.Fy = cVar;
        return d(this.Fy);
    }

    private boolean d(c cVar) {
        if (this.Fk == null) {
            u(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.Fk.x(new k.i(cVar));
    }

    public void close(int i, String str) {
        this.Fu = false;
        this.Fw = true;
        if (this.Fj != null) {
            this.Fj.quit();
            this.Fj = null;
        }
        if (this.Fk != null) {
            this.Fk.quit();
            this.Fk = null;
        }
        if (this.Fl != null) {
            try {
                this.Fl.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.Fl = null;
        }
        g.a aVar = this.Fs;
        this.Fs = null;
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
        this.Fv = true;
        if (this.Fl != null && this.Fl.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.Fm = new URI(str);
            if (!this.Fm.getScheme().equals("ws") && !this.Fm.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.Fm.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.Fn = this.Fm.getScheme();
            if (this.Fm.getPort() == -1) {
                if (this.Fn.equals("ws")) {
                    this.Fp = 80;
                } else {
                    this.Fp = 443;
                }
            } else {
                this.Fp = this.Fm.getPort();
            }
            if (this.Fm.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.Fo = this.Fm.getHost();
            if (this.Fm.getPath() == null || this.Fm.getPath().equals("")) {
                this.Fq = "/";
            } else {
                this.Fq = this.Fm.getPath();
            }
            if (this.Fm.getQuery() == null || this.Fm.getQuery().equals("")) {
                this.Fr = null;
            } else {
                this.Fr = this.Fm.getQuery();
            }
            this.Fc = strArr;
            this.Fb = list;
            this.Fs = aVar;
            this.Ft = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Object obj) {
        Message obtainMessage = this.Fi.obtainMessage();
        obtainMessage.obj = obj;
        this.Fi.sendMessage(obtainMessage);
    }

    protected void kK() {
        this.Fi = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.Fs != null) {
                        i.this.Fs.S(sVar.FO);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.Fs != null) {
                        i.this.Fs.p(mVar.FA);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.Fs != null) {
                        i.this.Fs.b(aVar);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0019k c0019k = new k.C0019k();
                    c0019k.FA = ((k.j) message.obj).FA;
                    i.this.Fk.x(c0019k);
                } else if (message.obj instanceof k.C0019k) {
                    k.C0019k c0019k2 = (k.C0019k) message.obj;
                    if (i.this.Fs != null) {
                        i.this.Fs.kC();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.FM) {
                        if (i.this.Fs != null) {
                            i.this.Fs.onOpen(qVar.FN);
                            i.this.Fu = true;
                            i.this.Fv = false;
                            if (i.this.Fs != null) {
                                i.this.Fs.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).FG;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).FK;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).FI.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.FH + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).FH);
                } else if (message.obj instanceof k.r) {
                    if (i.this.Fs != null) {
                        i.this.Fs.b(((k.r) message.obj).FL);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.Fy = null;
                    c cVar = ((k.g) message.obj).FL;
                    if (i.this.Fs != null) {
                        i.this.Fs.c(cVar);
                    }
                    if (i.this.Fs != null) {
                        i.this.Fs.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.Fy = null;
                    c cVar2 = ((k.n) message.obj).FL;
                    if (i.this.Fs != null) {
                        i.this.Fs.a(2, cVar2);
                    }
                    if (i.this.Fs != null) {
                        i.this.Fs.a(cVar2);
                    }
                } else {
                    i.this.v(message.obj);
                }
            }
        };
    }

    protected void v(Object obj) {
    }

    protected void kL() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.Fk = new o(handlerThread.getLooper(), this.Fi, this.Fl, this.Ft);
    }

    protected void kM() {
        this.Fj = new m(this.Fi, this.Fl, this.Ft, "WebSocketReader");
        this.Fj.start();
    }

    public boolean kN() {
        return this.Fy != null;
    }

    public boolean isConnecting() {
        return this.Fv;
    }

    public boolean isOpen() {
        return this.Fu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void kH() {
        if (this.Fk != null) {
            this.Fk.kH();
        }
    }

    public long getUpFlowSize() {
        if (this.Fk != null) {
            return this.Fk.getUpFlowSize();
        }
        return 0L;
    }

    public void kI() {
        if (this.Fj != null) {
            this.Fj.kI();
        }
    }

    public long getDownFlowSize() {
        if (this.Fj != null) {
            return this.Fj.getDownFlowSize();
        }
        return 0L;
    }

    public long kO() {
        if (this.Fl != null) {
            return this.Fl.kA();
        }
        return 0L;
    }

    public String kP() {
        if (this.Fl != null) {
            return this.Fl.kz();
        }
        return null;
    }

    public long kQ() {
        return this.Fx;
    }

    public String kj() {
        if (this.Fl != null) {
            return this.Fl.kj();
        }
        return null;
    }

    public String kk() {
        if (this.Fl != null) {
            return this.Fl.kk();
        }
        return null;
    }
}
