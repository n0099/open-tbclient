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
    private static h anG = null;
    private String[] anJ;
    private g.a anN;
    private String anH = null;
    private List<BasicNameValuePair> anI = null;
    private String anK = null;
    private i anL = null;
    private ArrayList<g.a> anM = new ArrayList<>();

    public static h pv() {
        if (anG == null) {
            synchronized (h.class) {
                if (anG == null) {
                    anG = new h();
                }
            }
        }
        return anG;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.anH = str;
        this.anK = str2;
        this.anJ = strArr;
        this.anI = list;
        if (pz()) {
        }
    }

    private h() {
        this.anN = null;
        this.anN = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void J(String str) {
                Iterator it = h.this.anM.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).J(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void o(byte[] bArr) {
                Iterator it = h.this.anM.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).o(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.anM.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void e(Map<String, String> map) {
                Iterator it = h.this.anM.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).e(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void e(int i, String str) {
                h.this.anL = null;
                Iterator it = h.this.anM.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).e(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.anM.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void pu() {
                Iterator it = h.this.anM.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).pu();
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(c cVar) {
                if (cVar != null) {
                    cVar.ki();
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(int i, c cVar) {
                if (cVar != null) {
                    cVar.cF(i);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void c(c cVar) {
                if (cVar != null) {
                    cVar.kj();
                }
            }
        };
    }

    public boolean pw() {
        if (pz()) {
            com.baidu.adp.lib.util.l.oY();
        }
        if (this.anL != null) {
            if (this.anL.isConnecting() || this.anL.isOpen()) {
                if (pz()) {
                }
                return true;
            }
            this.anL.close(1, null);
            this.anL = null;
        }
        this.anL = new i();
        try {
            l lVar = new l();
            lVar.bd(this.anK);
            this.anL.a(this.anH, this.anJ, this.anN, lVar, this.anI);
            return true;
        } catch (WebSocketException e) {
            this.anL = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.anL != null) {
            i iVar = this.anL;
            this.anL = null;
            iVar.close(i, str);
            if (this.anL != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.anL = null;
            }
        }
    }

    public boolean px() {
        if (pz()) {
            com.baidu.adp.lib.util.l.oY();
        }
        return (this.anL == null || !this.anL.isOpen() || this.anL.pG()) ? false : true;
    }

    public boolean py() {
        if (pz()) {
            com.baidu.adp.lib.util.l.oY();
        }
        return this.anL != null && this.anL.isOpen();
    }

    public boolean isConnecting() {
        if (pz()) {
            com.baidu.adp.lib.util.l.oY();
        }
        return this.anL != null && this.anL.isConnecting();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.oY();
                if (this.anL != null) {
                    z = this.anL.sendMessage(cVar);
                } else if (cVar != null) {
                    cVar.cF(1);
                }
            }
        }
        return z;
    }

    public boolean a(g.a aVar) {
        if (aVar != null) {
            synchronized (h.class) {
                if (!this.anM.contains(aVar)) {
                    return this.anM.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean pz() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void pA() {
        if (this.anL != null) {
            this.anL.pA();
        }
    }

    public long getUpFlowSize() {
        if (this.anL != null) {
            return this.anL.getUpFlowSize();
        }
        return -1L;
    }

    public void pB() {
        if (this.anL != null) {
            this.anL.pB();
        }
    }

    public long getDownFlowSize() {
        if (this.anL != null) {
            return this.anL.getDownFlowSize();
        }
        return -1L;
    }

    public long ps() {
        if (this.anL != null) {
            return this.anL.pH();
        }
        return -1L;
    }

    public String pr() {
        if (this.anL != null) {
            return this.anL.pI();
        }
        return null;
    }

    public long pC() {
        if (this.anL != null) {
            return this.anL.pJ();
        }
        return -1L;
    }

    public String pb() {
        if (this.anL != null) {
            return this.anL.pb();
        }
        return null;
    }

    public String pc() {
        if (this.anL != null) {
            return this.anL.pc();
        }
        return null;
    }

    public String getUrl() {
        return this.anH;
    }
}
