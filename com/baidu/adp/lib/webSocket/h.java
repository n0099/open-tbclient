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
    private static h Hp = null;
    private String[] Hs;
    private g.a Hw;
    private String Hq = null;
    private List<BasicNameValuePair> Hr = null;
    private String Ht = null;
    private i Hu = null;
    private ArrayList<g.a> Hv = new ArrayList<>();

    public static h lF() {
        if (Hp == null) {
            synchronized (h.class) {
                if (Hp == null) {
                    Hp = new h();
                }
            }
        }
        return Hp;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.Hq = str;
        this.Ht = str2;
        this.Hs = strArr;
        this.Hr = list;
        if (isDebug()) {
        }
    }

    private h() {
        this.Hw = null;
        this.Hw = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void aj(String str) {
                Iterator it = h.this.Hv.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).aj(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void w(byte[] bArr) {
                Iterator it = h.this.Hv.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).w(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.Hv.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onOpen(Map<String, String> map) {
                Iterator it = h.this.Hv.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onOpen(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void f(int i, String str) {
                h.this.Hu = null;
                Iterator it = h.this.Hv.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).f(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.Hv.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void lE() {
                Iterator it = h.this.Hv.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).lE();
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(c cVar) {
                if (cVar != null) {
                    cVar.gA();
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(int i, c cVar) {
                if (cVar != null) {
                    cVar.af(i);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void c(c cVar) {
                if (cVar != null) {
                    cVar.gB();
                }
            }
        };
    }

    public boolean lG() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.lk();
        }
        if (this.Hu != null) {
            if (this.Hu.isConnecting() || this.Hu.isOpen()) {
                if (isDebug()) {
                }
                return true;
            }
            this.Hu.close(1, null);
            this.Hu = null;
        }
        this.Hu = new i();
        try {
            l lVar = new l();
            lVar.bF(this.Ht);
            this.Hu.a(this.Hq, this.Hs, this.Hw, lVar, this.Hr);
            return true;
        } catch (WebSocketException e) {
            this.Hu = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.Hu != null) {
            i iVar = this.Hu;
            this.Hu = null;
            iVar.close(i, str);
            if (this.Hu != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.Hu = null;
            }
        }
    }

    public boolean lH() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.lk();
        }
        return (this.Hu == null || !this.Hu.isOpen() || this.Hu.lP()) ? false : true;
    }

    public boolean lI() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.lk();
        }
        return this.Hu != null && this.Hu.isOpen();
    }

    public boolean isConnecting() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.lk();
        }
        return this.Hu != null && this.Hu.isConnecting();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.lk();
                if (this.Hu != null) {
                    z = this.Hu.sendMessage(cVar);
                } else if (cVar != null) {
                    cVar.af(1);
                }
            }
        }
        return z;
    }

    public boolean a(g.a aVar) {
        if (aVar != null) {
            synchronized (h.class) {
                if (!this.Hv.contains(aVar)) {
                    return this.Hv.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void lJ() {
        if (this.Hu != null) {
            this.Hu.lJ();
        }
    }

    public long getUpFlowSize() {
        if (this.Hu != null) {
            return this.Hu.getUpFlowSize();
        }
        return -1L;
    }

    public void lK() {
        if (this.Hu != null) {
            this.Hu.lK();
        }
    }

    public long getDownFlowSize() {
        if (this.Hu != null) {
            return this.Hu.getDownFlowSize();
        }
        return -1L;
    }

    public long lC() {
        if (this.Hu != null) {
            return this.Hu.lQ();
        }
        return -1L;
    }

    public String lB() {
        if (this.Hu != null) {
            return this.Hu.lR();
        }
        return null;
    }

    public long lL() {
        if (this.Hu != null) {
            return this.Hu.lS();
        }
        return -1L;
    }

    public String getLocalDns() {
        if (this.Hu != null) {
            return this.Hu.getLocalDns();
        }
        return null;
    }

    public String ln() {
        if (this.Hu != null) {
            return this.Hu.ln();
        }
        return null;
    }

    public String getUrl() {
        return this.Hq;
    }
}
