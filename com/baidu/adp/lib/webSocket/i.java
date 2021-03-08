package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.e;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.adp.lib.webSocket.k;
import com.baidu.android.imsdk.internal.Constants;
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class i implements g {
    protected Handler SC;
    protected volatile m SD;
    protected volatile o SF;
    protected e.a SG;
    private URI SH;
    private String SJ;
    private String SK;
    private int SL;
    private String SM;
    private String SO;
    private g.a SQ;
    protected l SR;
    private boolean SS = false;
    private boolean ST = false;
    private volatile boolean SU = false;
    private long SV = 0;
    private c SW = null;
    private List<BasicNameValuePair> Sv;
    private String[] Sw;

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
                i.this.SG = eVar.a(i.this.SK, i.this.SL, i.this.SR, false);
                if (i.this.SU) {
                    i.this.v(new k.c());
                    return;
                }
                try {
                    if (!i.this.SG.isConnected()) {
                        i.this.v(new k.e(2, "cannot connect"));
                    } else {
                        i.this.SV = System.currentTimeMillis() - currentTimeMillis;
                        i.this.ok();
                        i.this.oj();
                        k.b bVar = new k.b(i.this.SK + ":" + i.this.SL);
                        bVar.mPath = i.this.SM;
                        bVar.mQuery = i.this.SO;
                        bVar.SZ = i.this.Sw;
                        bVar.Ta = i.this.Sv;
                        i.this.SF.y(bVar);
                        if (i.this.SU) {
                            i.this.v(new k.c());
                        }
                    }
                } catch (Throwable th) {
                    if (i.this.isDebug()) {
                        BdLog.e("----WebSocketConnector error. e:" + th.getMessage());
                    }
                    i.this.v(new k.f(new Exception(th)));
                }
            } catch (Throwable th2) {
                i.this.v(new k.e(2, th2.getMessage()));
            }
        }
    }

    public i() {
        oi();
    }

    public boolean sendMessage(c cVar) {
        if (cVar == null) {
            return false;
        }
        if (this.SW != null || !isOpen()) {
            if (isDebug()) {
            }
            if (cVar != null) {
                cVar.onSendError(1);
                return false;
            }
            return false;
        }
        this.SW = cVar;
        return d(this.SW);
    }

    private boolean d(c cVar) {
        if (this.SF == null) {
            v(new k.f(new Exception("mWriter = null")));
            return false;
        }
        return this.SF.y(new k.i(cVar));
    }

    public void close(int i, String str) {
        if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
            com.baidu.adp.framework.client.socket.i.debug("more_log", 0, 0, "close", i, str);
        }
        this.SS = false;
        this.SU = true;
        if (this.SD != null) {
            this.SD.quit();
            this.SD = null;
        }
        if (this.SF != null) {
            this.SF.quit();
            this.SF = null;
        }
        if (this.SG != null) {
            try {
                this.SG.close();
            } catch (Throwable th) {
                if (isDebug()) {
                    th.printStackTrace();
                }
            }
            this.SG = null;
        }
        g.a aVar = this.SQ;
        this.SQ = null;
        if (aVar != null) {
            try {
                aVar.d(i, str);
            } catch (Exception e) {
                if (isDebug()) {
                    BdLog.d(e.getMessage());
                }
            }
        }
    }

    public void a(String str, String[] strArr, g.a aVar, l lVar, List<BasicNameValuePair> list) throws WebSocketException {
        this.ST = true;
        if (this.SG != null && this.SG.isConnected()) {
            throw new WebSocketException("already connected");
        }
        try {
            this.SH = new URI(str);
            if (!this.SH.getScheme().equals("ws") && !this.SH.getScheme().equals("wss")) {
                throw new WebSocketException("unsupported scheme for WebSockets URI");
            }
            if (this.SH.getScheme().equals("wss")) {
                throw new WebSocketException("secure WebSockets not implemented");
            }
            this.SJ = this.SH.getScheme();
            if (this.SH.getPort() == -1) {
                if (this.SJ.equals("ws")) {
                    this.SL = 80;
                } else {
                    this.SL = Constants.SOCKET_PORT_SSL;
                }
            } else {
                this.SL = this.SH.getPort();
            }
            if (this.SH.getHost() == null) {
                throw new WebSocketException("no host specified in WebSockets URI");
            }
            this.SK = this.SH.getHost();
            if (this.SH.getPath() == null || this.SH.getPath().equals("")) {
                this.SM = "/";
            } else {
                this.SM = this.SH.getPath();
            }
            if (this.SH.getQuery() == null || this.SH.getQuery().equals("")) {
                this.SO = null;
            } else {
                this.SO = this.SH.getQuery();
            }
            this.Sw = strArr;
            this.Sv = list;
            this.SQ = aVar;
            this.SR = new l(lVar);
            new a().start();
        } catch (URISyntaxException e) {
            throw new WebSocketException("invalid WebSockets URI");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(Object obj) {
        Message obtainMessage = this.SC.obtainMessage();
        obtainMessage.obj = obj;
        this.SC.sendMessage(obtainMessage);
    }

    protected void oi() {
        this.SC = new Handler() { // from class: com.baidu.adp.lib.webSocket.i.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.obj instanceof k.s) {
                    k.s sVar = (k.s) message.obj;
                    if (i.this.SQ != null) {
                        i.this.SQ.onTextMessage(sVar.Th);
                    }
                } else if (message.obj instanceof k.m) {
                    k.m mVar = (k.m) message.obj;
                    if (i.this.SQ != null) {
                        i.this.SQ.m(mVar.SY);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.a) {
                    k.a aVar = (k.a) message.obj;
                    if (i.this.SQ != null) {
                        i.this.SQ.b(aVar);
                    } else if (i.this.isDebug()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (message.obj instanceof k.j) {
                    k.C0025k c0025k = new k.C0025k();
                    c0025k.SY = ((k.j) message.obj).SY;
                    i.this.SF.y(c0025k);
                } else if (message.obj instanceof k.C0025k) {
                    k.C0025k c0025k2 = (k.C0025k) message.obj;
                    if (i.this.SQ != null) {
                        i.this.SQ.oa();
                    }
                } else if (message.obj instanceof k.c) {
                    i.this.close(1, null);
                } else if (message.obj instanceof k.q) {
                    k.q qVar = (k.q) message.obj;
                    if (qVar.mSuccess) {
                        if (i.this.SQ != null) {
                            i.this.SQ.onOpen(qVar.mHeaders);
                            i.this.SS = true;
                            i.this.ST = false;
                            if (i.this.SQ != null) {
                                i.this.SQ.a(null);
                                return;
                            }
                            return;
                        }
                        i.this.close(6, "handler already NULL");
                    }
                } else if (message.obj instanceof k.d) {
                    SocketException socketException = ((k.d) message.obj).Tb;
                    i.this.close(3, "WebSockets connection lost = " + (socketException != null ? socketException.getMessage() : null));
                } else if (message.obj instanceof k.l) {
                    WebSocketException webSocketException = ((k.l) message.obj).Tf;
                    i.this.close(4, "WebSockets protocol violation error = " + (webSocketException != null ? webSocketException.getMessage() : null));
                } else if (message.obj instanceof k.f) {
                    i.this.close(5, "WebSockets internal error (" + ((k.f) message.obj).Td.toString() + ")");
                } else if (message.obj instanceof k.p) {
                    k.p pVar = (k.p) message.obj;
                    i.this.close(6, "Server error " + pVar.mStatusCode + " (" + pVar.Tc + ")");
                } else if (message.obj instanceof k.e) {
                    i.this.close(2, "WebSockets connot connect:" + ((k.e) message.obj).Tc);
                } else if (message.obj instanceof k.r) {
                    if (i.this.SQ != null) {
                        i.this.SQ.b(((k.r) message.obj).Tg);
                    }
                } else if (message.obj instanceof k.g) {
                    i.this.SW = null;
                    c cVar = ((k.g) message.obj).Tg;
                    if (i.this.SQ != null) {
                        i.this.SQ.c(cVar);
                    }
                    if (i.this.SQ != null) {
                        i.this.SQ.a(cVar);
                    }
                } else if (message.obj instanceof k.n) {
                    i.this.SW = null;
                    c cVar2 = ((k.n) message.obj).Tg;
                    if (i.this.SQ != null) {
                        i.this.SQ.a(2, cVar2);
                    }
                    if (i.this.SQ != null) {
                        i.this.SQ.a(cVar2);
                    }
                } else {
                    i.this.w(message.obj);
                }
            }
        };
    }

    protected void w(Object obj) {
    }

    protected void oj() {
        HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
        handlerThread.start();
        this.SF = new o(handlerThread.getLooper(), this.SC, this.SG, this.SR);
    }

    protected void ok() {
        this.SD = new m(this.SC, this.SG, this.SR, "WebSocketReader");
        this.SD.start();
    }

    public boolean ol() {
        return this.SW != null;
    }

    public boolean isConnecting() {
        return this.ST;
    }

    public boolean isOpen() {
        return this.SS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void oe() {
        if (this.SF != null) {
            this.SF.oe();
        }
    }

    public long getUpFlowSize() {
        if (this.SF != null) {
            return this.SF.getUpFlowSize();
        }
        return 0L;
    }

    public void og() {
        if (this.SD != null) {
            this.SD.og();
        }
    }

    public long getDownFlowSize() {
        if (this.SD != null) {
            return this.SD.getDownFlowSize();
        }
        return 0L;
    }

    public long om() {
        if (this.SG != null) {
            return this.SG.nY();
        }
        return 0L;
    }

    public String on() {
        if (this.SG != null) {
            return this.SG.nX();
        }
        return null;
    }

    public long oo() {
        return this.SV;
    }

    public String getLocalDns() {
        if (this.SG != null) {
            return this.SG.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.SG != null) {
            return this.SG.getLocalDnsBak();
        }
        return null;
    }
}
