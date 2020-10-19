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
    private static h Qd = null;
    private String[] Qg;
    private g.a Qk;
    private String Qe = null;
    private List<BasicNameValuePair> Qf = null;
    private String Qh = null;
    private i Qi = null;
    private ArrayList<g.a> Qj = new ArrayList<>();

    public static h oD() {
        if (Qd == null) {
            synchronized (h.class) {
                if (Qd == null) {
                    Qd = new h();
                }
            }
        }
        return Qd;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.Qe = str;
        this.Qh = str2;
        this.Qg = strArr;
        this.Qf = list;
        if (isDebug()) {
        }
    }

    private h() {
        this.Qk = null;
        this.Qk = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onTextMessage(String str) {
                Iterator it = h.this.Qj.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onTextMessage(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void m(byte[] bArr) {
                Iterator it = h.this.Qj.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).m(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.Qj.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onOpen(Map<String, String> map) {
                Iterator it = h.this.Qj.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onOpen(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void c(int i, String str) {
                h.this.Qi = null;
                Iterator it = h.this.Qj.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).c(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.Qj.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void oC() {
                Iterator it = h.this.Qj.iterator();
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
        if (this.Qi != null) {
            if (this.Qi.isConnecting() || this.Qi.isOpen()) {
                if (isDebug()) {
                }
                return true;
            }
            this.Qi.close(1, null);
            this.Qi = null;
        }
        this.Qi = new i();
        try {
            l lVar = new l();
            lVar.ck(this.Qh);
            this.Qi.a(this.Qe, this.Qg, this.Qk, lVar, this.Qf);
            return true;
        } catch (WebSocketException e) {
            this.Qi = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.Qi != null) {
            i iVar = this.Qi;
            this.Qi = null;
            iVar.close(i, str);
            if (this.Qi != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.Qi = null;
            }
        }
    }

    public boolean getIsIdle() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return (this.Qi == null || !this.Qi.isOpen() || this.Qi.oM()) ? false : true;
    }

    public boolean oF() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.Qi != null && this.Qi.isOpen();
    }

    public boolean isConnecting() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.Qi != null && this.Qi.isConnecting();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.checkMainThread();
                if (this.Qi != null) {
                    z = this.Qi.sendMessage(cVar);
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
                if (!this.Qj.contains(aVar)) {
                    return this.Qj.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void oG() {
        if (this.Qi != null) {
            this.Qi.oG();
        }
    }

    public long getUpFlowSize() {
        if (this.Qi != null) {
            return this.Qi.getUpFlowSize();
        }
        return -1L;
    }

    public void oH() {
        if (this.Qi != null) {
            this.Qi.oH();
        }
    }

    public long getDownFlowSize() {
        if (this.Qi != null) {
            return this.Qi.getDownFlowSize();
        }
        return -1L;
    }

    public long oA() {
        if (this.Qi != null) {
            return this.Qi.oN();
        }
        return -1L;
    }

    public String oz() {
        if (this.Qi != null) {
            return this.Qi.oO();
        }
        return null;
    }

    public long oI() {
        if (this.Qi != null) {
            return this.Qi.oP();
        }
        return -1L;
    }

    public String getLocalDns() {
        if (this.Qi != null) {
            return this.Qi.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.Qi != null) {
            return this.Qi.getLocalDnsBak();
        }
        return null;
    }

    public String getUrl() {
        return this.Qe;
    }
}
