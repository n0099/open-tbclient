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
    private List<BasicNameValuePair> Fc;
    private String[] Fd;
    protected Handler Fj;
    protected volatile m Fk;
    protected volatile o Fl;
    protected e.a Fm;
    private URI Fn;
    private String Fo;
    private String Fp;
    private int Fq;
    private String Fr;
    private String Fs;
    private g.a Ft;
    protected l Fu;
    private boolean Fv = false;
    private boolean Fw = false;
    private volatile boolean Fx = false;
    private long Fy = 0;
    private c Fz = null;

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
                i.this.Fm = eVar.a(i.this.Fp, i.this.Fq, i.this.Fu, false);
                if (i.this.Fx) {
                    i.this.u(new k.c());
                    return;
                }
                try {
                    if (!i.this.Fm.isConnected()) {
                        i.this.u(new k.e(2, "cannot connect"));
                    } else {
                        i.this.Fy = System.currentTimeMillis() - currentTimeMillis;
                        i.this.kM();
                        i.this.kL();
                        k.b bVar = new k.b(i.this.Fp + ":" + i.this.Fq);
                        bVar.wV = i.this.Fr;
                        bVar.mQuery = i.this.Fs;
                        bVar.FE = i.this.Fd;
                        bVar.FF = i.this.Fc;
                        i.this.Fl.x(bVar);
                        if (i.this.Fx) {
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
        if (this.Fz != null || !isOpen()) {
            if (isDebug()) {
            }
            if (cVar != null) {
                cVar.G(1);
                return false;
            }
            return false;
        }
        this.Fz = cVar;
        return d(this.Fz);
    }

    private boolean d(c cVar) {
        if (this.Fl == null) {
            u(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.Fl.x(new k.i(cVar));
    }

    public void close(int i, String str) {
        this.Fv = false;
        this.Fx = true;
        if (this.Fk != null) {
            this.Fk.quit();
            this.Fk = null;
        }
        if (this.Fl != null) {
            this.Fl.quit();
            this.Fl = null;
        }
        if (this.Fm != null) {
            try {
                this.Fm.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.Fm = null;
        }
        g.a aVar = this.Ft;
        this.Ft = null;
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
        this.Fw = true;
        if (this.Fm != null && this.Fm.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.Fn = new URI(str);
            if (!this.Fn.getScheme().equals("ws") && !this.Fn.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.Fn.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.Fo = this.Fn.getScheme();
            if (this.Fn.getPort() == -1) {
                if (this.Fo.equals("ws")) {
                    this.Fq = 80;
                } else {
                    this.Fq = 443;
                }
            } else {
                this.Fq = this.Fn.getPort();
            }
            if (this.Fn.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.Fp = this.Fn.getHost();
            if (this.Fn.getPath() == null || this.Fn.getPath().equals("")) {
                this.Fr = "/";
            } else {
                this.Fr = this.Fn.getPath();
            }
            if (this.Fn.getQuery() == null || this.Fn.getQuery().equals("")) {
                this.Fs = null;
            } else {
                this.Fs = this.Fn.getQuery();
            }
            this.Fd = strArr;
            this.Fc = list;
            this.Ft = aVar;
            this.Fu = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Object obj) {
        Message obtainMessage = this.Fj.obtainMessage();
        obtainMessage.obj = obj;
        this.Fj.sendMessage(obtainMessage);
    }

    protected void kK() {
        this.Fj = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.Ft != null) {
                        i.this.Ft.S(sVar.FP);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.Ft != null) {
                        i.this.Ft.p(mVar.FB);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.Ft != null) {
                        i.this.Ft.b(aVar);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0019k c0019k = new k.C0019k();
                    c0019k.FB = ((k.j) message.obj).FB;
                    i.this.Fl.x(c0019k);
                } else if (message.obj instanceof k.C0019k) {
                    k.C0019k c0019k2 = (k.C0019k) message.obj;
                    if (i.this.Ft != null) {
                        i.this.Ft.kC();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.FN) {
                        if (i.this.Ft != null) {
                            i.this.Ft.onOpen(qVar.FO);
                            i.this.Fv = true;
                            i.this.Fw = false;
                            if (i.this.Ft != null) {
                                i.this.Ft.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).FH;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).FL;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).FJ.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.FI + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).FI);
                } else if (message.obj instanceof k.r) {
                    if (i.this.Ft != null) {
                        i.this.Ft.b(((k.r) message.obj).FM);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.Fz = null;
                    c cVar = ((k.g) message.obj).FM;
                    if (i.this.Ft != null) {
                        i.this.Ft.c(cVar);
                    }
                    if (i.this.Ft != null) {
                        i.this.Ft.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.Fz = null;
                    c cVar2 = ((k.n) message.obj).FM;
                    if (i.this.Ft != null) {
                        i.this.Ft.a(2, cVar2);
                    }
                    if (i.this.Ft != null) {
                        i.this.Ft.a(cVar2);
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
        this.Fl = new o(handlerThread.getLooper(), this.Fj, this.Fm, this.Fu);
    }

    protected void kM() {
        this.Fk = new m(this.Fj, this.Fm, this.Fu, "WebSocketReader");
        this.Fk.start();
    }

    public boolean kN() {
        return this.Fz != null;
    }

    public boolean isConnecting() {
        return this.Fw;
    }

    public boolean isOpen() {
        return this.Fv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void kH() {
        if (this.Fl != null) {
            this.Fl.kH();
        }
    }

    public long getUpFlowSize() {
        if (this.Fl != null) {
            return this.Fl.getUpFlowSize();
        }
        return 0L;
    }

    public void kI() {
        if (this.Fk != null) {
            this.Fk.kI();
        }
    }

    public long getDownFlowSize() {
        if (this.Fk != null) {
            return this.Fk.getDownFlowSize();
        }
        return 0L;
    }

    public long kO() {
        if (this.Fm != null) {
            return this.Fm.kA();
        }
        return 0L;
    }

    public String kP() {
        if (this.Fm != null) {
            return this.Fm.kz();
        }
        return null;
    }

    public long kQ() {
        return this.Fy;
    }

    public String kj() {
        if (this.Fm != null) {
            return this.Fm.kj();
        }
        return null;
    }

    public String kk() {
        if (this.Fm != null) {
            return this.Fm.kk();
        }
        return null;
    }
}
