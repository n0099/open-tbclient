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
    private static h anH = null;
    private String[] anK;
    private g.a anO;
    private String anI = null;
    private List<BasicNameValuePair> anJ = null;
    private String anL = null;
    private i anM = null;
    private ArrayList<g.a> anN = new ArrayList<>();

    public static h pv() {
        if (anH == null) {
            synchronized (h.class) {
                if (anH == null) {
                    anH = new h();
                }
            }
        }
        return anH;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.anI = str;
        this.anL = str2;
        this.anK = strArr;
        this.anJ = list;
        if (pz()) {
        }
    }

    private h() {
        this.anO = null;
        this.anO = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void J(String str) {
                Iterator it = h.this.anN.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).J(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void o(byte[] bArr) {
                Iterator it = h.this.anN.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).o(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.anN.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void e(Map<String, String> map) {
                Iterator it = h.this.anN.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).e(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void e(int i, String str) {
                h.this.anM = null;
                Iterator it = h.this.anN.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).e(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.anN.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void pu() {
                Iterator it = h.this.anN.iterator();
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
        if (this.anM != null) {
            if (this.anM.isConnecting() || this.anM.isOpen()) {
                if (pz()) {
                }
                return true;
            }
            this.anM.close(1, null);
            this.anM = null;
        }
        this.anM = new i();
        try {
            l lVar = new l();
            lVar.bd(this.anL);
            this.anM.a(this.anI, this.anK, this.anO, lVar, this.anJ);
            return true;
        } catch (WebSocketException e) {
            this.anM = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.anM != null) {
            i iVar = this.anM;
            this.anM = null;
            iVar.close(i, str);
            if (this.anM != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.anM = null;
            }
        }
    }

    public boolean px() {
        if (pz()) {
            com.baidu.adp.lib.util.l.oY();
        }
        return (this.anM == null || !this.anM.isOpen() || this.anM.pG()) ? false : true;
    }

    public boolean py() {
        if (pz()) {
            com.baidu.adp.lib.util.l.oY();
        }
        return this.anM != null && this.anM.isOpen();
    }

    public boolean isConnecting() {
        if (pz()) {
            com.baidu.adp.lib.util.l.oY();
        }
        return this.anM != null && this.anM.isConnecting();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.oY();
                if (this.anM != null) {
                    z = this.anM.sendMessage(cVar);
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
                if (!this.anN.contains(aVar)) {
                    return this.anN.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean pz() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void pA() {
        if (this.anM != null) {
            this.anM.pA();
        }
    }

    public long getUpFlowSize() {
        if (this.anM != null) {
            return this.anM.getUpFlowSize();
        }
        return -1L;
    }

    public void pB() {
        if (this.anM != null) {
            this.anM.pB();
        }
    }

    public long getDownFlowSize() {
        if (this.anM != null) {
            return this.anM.getDownFlowSize();
        }
        return -1L;
    }

    public long ps() {
        if (this.anM != null) {
            return this.anM.pH();
        }
        return -1L;
    }

    public String pr() {
        if (this.anM != null) {
            return this.anM.pI();
        }
        return null;
    }

    public long pC() {
        if (this.anM != null) {
            return this.anM.pJ();
        }
        return -1L;
    }

    public String pb() {
        if (this.anM != null) {
            return this.anM.pb();
        }
        return null;
    }

    public String pc() {
        if (this.anM != null) {
            return this.anM.pc();
        }
        return null;
    }

    public String getUrl() {
        return this.anI;
    }
}
