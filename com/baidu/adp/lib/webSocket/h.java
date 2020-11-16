package com.baidu.adp.lib.webSocket;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.adp.lib.webSocket.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class h {
    private static h Qf = null;
    private String[] Qi;
    private g.a Qm;
    private String Qg = null;
    private List<BasicNameValuePair> Qh = null;
    private String Qj = null;
    private i Qk = null;
    private ArrayList<g.a> Ql = new ArrayList<>();

    public static h oD() {
        if (Qf == null) {
            synchronized (h.class) {
                if (Qf == null) {
                    Qf = new h();
                }
            }
        }
        return Qf;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.Qg = str;
        this.Qj = str2;
        this.Qi = strArr;
        this.Qh = list;
        if (isDebug()) {
        }
    }

    private h() {
        this.Qm = null;
        this.Qm = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onTextMessage(String str) {
                Iterator it = h.this.Ql.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onTextMessage(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void m(byte[] bArr) {
                Iterator it = h.this.Ql.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).m(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.Ql.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onOpen(Map<String, String> map) {
                Iterator it = h.this.Ql.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onOpen(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void c(int i, String str) {
                h.this.Qk = null;
                Iterator it = h.this.Ql.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).c(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.Ql.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void oC() {
                Iterator it = h.this.Ql.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).oC();
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(c cVar) {
                if (cVar != null) {
                    cVar.onStartSend();
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(int i, c cVar) {
                if (cVar != null) {
                    cVar.onSendError(i);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void c(c cVar) {
                if (cVar != null) {
                    cVar.onFinishSend();
                }
            }
        };
    }

    public boolean oE() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        if (this.Qk != null) {
            if (this.Qk.isConnecting() || this.Qk.isOpen()) {
                if (isDebug()) {
                }
                return true;
            }
            this.Qk.close(1, null);
            this.Qk = null;
        }
        this.Qk = new i();
        try {
            l lVar = new l();
            lVar.cl(this.Qj);
            this.Qk.a(this.Qg, this.Qi, this.Qm, lVar, this.Qh);
            return true;
        } catch (WebSocketException e) {
            this.Qk = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.Qk != null) {
            i iVar = this.Qk;
            this.Qk = null;
            iVar.close(i, str);
            if (this.Qk != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.Qk = null;
            }
        }
    }

    public boolean getIsIdle() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return (this.Qk == null || !this.Qk.isOpen() || this.Qk.oM()) ? false : true;
    }

    public boolean oF() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.Qk != null && this.Qk.isOpen();
    }

    public boolean isConnecting() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.Qk != null && this.Qk.isConnecting();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.checkMainThread();
                if (this.Qk != null) {
                    z = this.Qk.sendMessage(cVar);
                } else if (cVar != null) {
                    cVar.onSendError(1);
                }
            }
        }
        return z;
    }

    public boolean a(g.a aVar) {
        if (aVar != null) {
            synchronized (h.class) {
                if (!this.Ql.contains(aVar)) {
                    return this.Ql.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void oG() {
        if (this.Qk != null) {
            this.Qk.oG();
        }
    }

    public long getUpFlowSize() {
        if (this.Qk != null) {
            return this.Qk.getUpFlowSize();
        }
        return -1L;
    }

    public void oH() {
        if (this.Qk != null) {
            this.Qk.oH();
        }
    }

    public long getDownFlowSize() {
        if (this.Qk != null) {
            return this.Qk.getDownFlowSize();
        }
        return -1L;
    }

    public long oA() {
        if (this.Qk != null) {
            return this.Qk.oN();
        }
        return -1L;
    }

    public String oz() {
        if (this.Qk != null) {
            return this.Qk.oO();
        }
        return null;
    }

    public long oI() {
        if (this.Qk != null) {
            return this.Qk.oP();
        }
        return -1L;
    }

    public String getLocalDns() {
        if (this.Qk != null) {
            return this.Qk.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.Qk != null) {
            return this.Qk.getLocalDnsBak();
        }
        return null;
    }

    public String getUrl() {
        return this.Qg;
    }
}
