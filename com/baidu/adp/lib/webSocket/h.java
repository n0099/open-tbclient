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
    private static h Hl = null;
    private String[] Ho;
    private g.a Hs;
    private String Hm = null;
    private List<BasicNameValuePair> Hn = null;
    private String Hp = null;
    private i Hq = null;
    private ArrayList<g.a> Hr = new ArrayList<>();

    public static h lH() {
        if (Hl == null) {
            synchronized (h.class) {
                if (Hl == null) {
                    Hl = new h();
                }
            }
        }
        return Hl;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.Hm = str;
        this.Hp = str2;
        this.Ho = strArr;
        this.Hn = list;
        if (isDebug()) {
        }
    }

    private h() {
        this.Hs = null;
        this.Hs = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void aj(String str) {
                Iterator it = h.this.Hr.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).aj(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void x(byte[] bArr) {
                Iterator it = h.this.Hr.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).x(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.Hr.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onOpen(Map<String, String> map) {
                Iterator it = h.this.Hr.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onOpen(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void f(int i, String str) {
                h.this.Hq = null;
                Iterator it = h.this.Hr.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).f(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.Hr.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void lG() {
                Iterator it = h.this.Hr.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).lG();
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(c cVar) {
                if (cVar != null) {
                    cVar.gB();
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(int i, c cVar) {
                if (cVar != null) {
                    cVar.O(i);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void c(c cVar) {
                if (cVar != null) {
                    cVar.gC();
                }
            }
        };
    }

    public boolean lI() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.lm();
        }
        if (this.Hq != null) {
            if (this.Hq.isConnecting() || this.Hq.isOpen()) {
                if (isDebug()) {
                }
                return true;
            }
            this.Hq.close(1, null);
            this.Hq = null;
        }
        this.Hq = new i();
        try {
            l lVar = new l();
            lVar.bF(this.Hp);
            this.Hq.a(this.Hm, this.Ho, this.Hs, lVar, this.Hn);
            return true;
        } catch (WebSocketException e) {
            this.Hq = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.Hq != null) {
            i iVar = this.Hq;
            this.Hq = null;
            iVar.close(i, str);
            if (this.Hq != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.Hq = null;
            }
        }
    }

    public boolean lJ() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.lm();
        }
        return (this.Hq == null || !this.Hq.isOpen() || this.Hq.lR()) ? false : true;
    }

    public boolean lK() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.lm();
        }
        return this.Hq != null && this.Hq.isOpen();
    }

    public boolean isConnecting() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.lm();
        }
        return this.Hq != null && this.Hq.isConnecting();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.lm();
                if (this.Hq != null) {
                    z = this.Hq.sendMessage(cVar);
                } else if (cVar != null) {
                    cVar.O(1);
                }
            }
        }
        return z;
    }

    public boolean a(g.a aVar) {
        if (aVar != null) {
            synchronized (h.class) {
                if (!this.Hr.contains(aVar)) {
                    return this.Hr.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void lL() {
        if (this.Hq != null) {
            this.Hq.lL();
        }
    }

    public long getUpFlowSize() {
        if (this.Hq != null) {
            return this.Hq.getUpFlowSize();
        }
        return -1L;
    }

    public void lM() {
        if (this.Hq != null) {
            this.Hq.lM();
        }
    }

    public long getDownFlowSize() {
        if (this.Hq != null) {
            return this.Hq.getDownFlowSize();
        }
        return -1L;
    }

    public long lE() {
        if (this.Hq != null) {
            return this.Hq.lS();
        }
        return -1L;
    }

    public String lD() {
        if (this.Hq != null) {
            return this.Hq.lT();
        }
        return null;
    }

    public long lN() {
        if (this.Hq != null) {
            return this.Hq.lU();
        }
        return -1L;
    }

    public String getLocalDns() {
        if (this.Hq != null) {
            return this.Hq.getLocalDns();
        }
        return null;
    }

    public String lp() {
        if (this.Hq != null) {
            return this.Hq.lp();
        }
        return null;
    }

    public String getUrl() {
        return this.Hm;
    }
}
