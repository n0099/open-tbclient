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
    private static h anA = null;
    private String[] anD;
    private g.a anH;
    private String anB = null;
    private List<BasicNameValuePair> anC = null;
    private String anE = null;
    private i anF = null;
    private ArrayList<g.a> anG = new ArrayList<>();

    public static h pv() {
        if (anA == null) {
            synchronized (h.class) {
                if (anA == null) {
                    anA = new h();
                }
            }
        }
        return anA;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.anB = str;
        this.anE = str2;
        this.anD = strArr;
        this.anC = list;
        if (pz()) {
        }
    }

    private h() {
        this.anH = null;
        this.anH = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void J(String str) {
                Iterator it = h.this.anG.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).J(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void o(byte[] bArr) {
                Iterator it = h.this.anG.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).o(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.anG.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void e(Map<String, String> map) {
                Iterator it = h.this.anG.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).e(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void e(int i, String str) {
                h.this.anF = null;
                Iterator it = h.this.anG.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).e(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.anG.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void pu() {
                Iterator it = h.this.anG.iterator();
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
        if (this.anF != null) {
            if (this.anF.isConnecting() || this.anF.isOpen()) {
                if (pz()) {
                }
                return true;
            }
            this.anF.close(1, null);
            this.anF = null;
        }
        this.anF = new i();
        try {
            l lVar = new l();
            lVar.bd(this.anE);
            this.anF.a(this.anB, this.anD, this.anH, lVar, this.anC);
            return true;
        } catch (WebSocketException e) {
            this.anF = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.anF != null) {
            i iVar = this.anF;
            this.anF = null;
            iVar.close(i, str);
            if (this.anF != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.anF = null;
            }
        }
    }

    public boolean px() {
        if (pz()) {
            com.baidu.adp.lib.util.l.oY();
        }
        return (this.anF == null || !this.anF.isOpen() || this.anF.pG()) ? false : true;
    }

    public boolean py() {
        if (pz()) {
            com.baidu.adp.lib.util.l.oY();
        }
        return this.anF != null && this.anF.isOpen();
    }

    public boolean isConnecting() {
        if (pz()) {
            com.baidu.adp.lib.util.l.oY();
        }
        return this.anF != null && this.anF.isConnecting();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.oY();
                if (this.anF != null) {
                    z = this.anF.sendMessage(cVar);
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
                if (!this.anG.contains(aVar)) {
                    return this.anG.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean pz() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void pA() {
        if (this.anF != null) {
            this.anF.pA();
        }
    }

    public long getUpFlowSize() {
        if (this.anF != null) {
            return this.anF.getUpFlowSize();
        }
        return -1L;
    }

    public void pB() {
        if (this.anF != null) {
            this.anF.pB();
        }
    }

    public long getDownFlowSize() {
        if (this.anF != null) {
            return this.anF.getDownFlowSize();
        }
        return -1L;
    }

    public long ps() {
        if (this.anF != null) {
            return this.anF.pH();
        }
        return -1L;
    }

    public String pr() {
        if (this.anF != null) {
            return this.anF.pI();
        }
        return null;
    }

    public long pC() {
        if (this.anF != null) {
            return this.anF.pJ();
        }
        return -1L;
    }

    public String pb() {
        if (this.anF != null) {
            return this.anF.pb();
        }
        return null;
    }

    public String pc() {
        if (this.anF != null) {
            return this.anF.pc();
        }
        return null;
    }

    public String getUrl() {
        return this.anB;
    }
}
