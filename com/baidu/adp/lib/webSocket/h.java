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
    private static h Qe = null;
    private String[] Qh;
    private g.a Ql;
    private String Qf = null;
    private List<BasicNameValuePair> Qg = null;
    private String Qi = null;
    private i Qj = null;
    private ArrayList<g.a> Qk = new ArrayList<>();

    public static h oD() {
        if (Qe == null) {
            synchronized (h.class) {
                if (Qe == null) {
                    Qe = new h();
                }
            }
        }
        return Qe;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.Qf = str;
        this.Qi = str2;
        this.Qh = strArr;
        this.Qg = list;
        if (isDebug()) {
        }
    }

    private h() {
        this.Ql = null;
        this.Ql = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onTextMessage(String str) {
                Iterator it = h.this.Qk.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onTextMessage(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void m(byte[] bArr) {
                Iterator it = h.this.Qk.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).m(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.Qk.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onOpen(Map<String, String> map) {
                Iterator it = h.this.Qk.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onOpen(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void c(int i, String str) {
                h.this.Qj = null;
                Iterator it = h.this.Qk.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).c(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.Qk.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void oC() {
                Iterator it = h.this.Qk.iterator();
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
        if (this.Qj != null) {
            if (this.Qj.isConnecting() || this.Qj.isOpen()) {
                if (isDebug()) {
                }
                return true;
            }
            this.Qj.close(1, null);
            this.Qj = null;
        }
        this.Qj = new i();
        try {
            l lVar = new l();
            lVar.ck(this.Qi);
            this.Qj.a(this.Qf, this.Qh, this.Ql, lVar, this.Qg);
            return true;
        } catch (WebSocketException e) {
            this.Qj = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.Qj != null) {
            i iVar = this.Qj;
            this.Qj = null;
            iVar.close(i, str);
            if (this.Qj != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.Qj = null;
            }
        }
    }

    public boolean getIsIdle() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return (this.Qj == null || !this.Qj.isOpen() || this.Qj.oM()) ? false : true;
    }

    public boolean oF() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.Qj != null && this.Qj.isOpen();
    }

    public boolean isConnecting() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.checkMainThread();
        }
        return this.Qj != null && this.Qj.isConnecting();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.checkMainThread();
                if (this.Qj != null) {
                    z = this.Qj.sendMessage(cVar);
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
                if (!this.Qk.contains(aVar)) {
                    return this.Qk.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void oG() {
        if (this.Qj != null) {
            this.Qj.oG();
        }
    }

    public long getUpFlowSize() {
        if (this.Qj != null) {
            return this.Qj.getUpFlowSize();
        }
        return -1L;
    }

    public void oH() {
        if (this.Qj != null) {
            this.Qj.oH();
        }
    }

    public long getDownFlowSize() {
        if (this.Qj != null) {
            return this.Qj.getDownFlowSize();
        }
        return -1L;
    }

    public long oA() {
        if (this.Qj != null) {
            return this.Qj.oN();
        }
        return -1L;
    }

    public String oz() {
        if (this.Qj != null) {
            return this.Qj.oO();
        }
        return null;
    }

    public long oI() {
        if (this.Qj != null) {
            return this.Qj.oP();
        }
        return -1L;
    }

    public String getLocalDns() {
        if (this.Qj != null) {
            return this.Qj.getLocalDns();
        }
        return null;
    }

    public String getLocalDnsBak() {
        if (this.Qj != null) {
            return this.Qj.getLocalDnsBak();
        }
        return null;
    }

    public String getUrl() {
        return this.Qf;
    }
}
