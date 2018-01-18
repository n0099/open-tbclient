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
    private static h anE = null;
    private String[] anH;
    private g.a anL;
    private String anF = null;
    private List<BasicNameValuePair> anG = null;
    private String anI = null;
    private i anJ = null;
    private ArrayList<g.a> anK = new ArrayList<>();

    public static h pu() {
        if (anE == null) {
            synchronized (h.class) {
                if (anE == null) {
                    anE = new h();
                }
            }
        }
        return anE;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.anF = str;
        this.anI = str2;
        this.anH = strArr;
        this.anG = list;
        if (py()) {
        }
    }

    private h() {
        this.anL = null;
        this.anL = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void J(String str) {
                Iterator it = h.this.anK.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).J(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void o(byte[] bArr) {
                Iterator it = h.this.anK.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).o(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.anK.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void e(Map<String, String> map) {
                Iterator it = h.this.anK.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).e(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void e(int i, String str) {
                h.this.anJ = null;
                Iterator it = h.this.anK.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).e(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.anK.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void pt() {
                Iterator it = h.this.anK.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).pt();
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

    public boolean pv() {
        if (py()) {
            com.baidu.adp.lib.util.l.oX();
        }
        if (this.anJ != null) {
            if (this.anJ.isConnecting() || this.anJ.isOpen()) {
                if (py()) {
                }
                return true;
            }
            this.anJ.close(1, null);
            this.anJ = null;
        }
        this.anJ = new i();
        try {
            l lVar = new l();
            lVar.bd(this.anI);
            this.anJ.a(this.anF, this.anH, this.anL, lVar, this.anG);
            return true;
        } catch (WebSocketException e) {
            this.anJ = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.anJ != null) {
            i iVar = this.anJ;
            this.anJ = null;
            iVar.close(i, str);
            if (this.anJ != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.anJ = null;
            }
        }
    }

    public boolean pw() {
        if (py()) {
            com.baidu.adp.lib.util.l.oX();
        }
        return (this.anJ == null || !this.anJ.isOpen() || this.anJ.pF()) ? false : true;
    }

    public boolean px() {
        if (py()) {
            com.baidu.adp.lib.util.l.oX();
        }
        return this.anJ != null && this.anJ.isOpen();
    }

    public boolean isConnecting() {
        if (py()) {
            com.baidu.adp.lib.util.l.oX();
        }
        return this.anJ != null && this.anJ.isConnecting();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.oX();
                if (this.anJ != null) {
                    z = this.anJ.sendMessage(cVar);
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
                if (!this.anK.contains(aVar)) {
                    return this.anK.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean py() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void pz() {
        if (this.anJ != null) {
            this.anJ.pz();
        }
    }

    public long getUpFlowSize() {
        if (this.anJ != null) {
            return this.anJ.getUpFlowSize();
        }
        return -1L;
    }

    public void pA() {
        if (this.anJ != null) {
            this.anJ.pA();
        }
    }

    public long getDownFlowSize() {
        if (this.anJ != null) {
            return this.anJ.getDownFlowSize();
        }
        return -1L;
    }

    public long pr() {
        if (this.anJ != null) {
            return this.anJ.pG();
        }
        return -1L;
    }

    public String pq() {
        if (this.anJ != null) {
            return this.anJ.pH();
        }
        return null;
    }

    public long pB() {
        if (this.anJ != null) {
            return this.anJ.pI();
        }
        return -1L;
    }

    public String pa() {
        if (this.anJ != null) {
            return this.anJ.pa();
        }
        return null;
    }

    public String pb() {
        if (this.anJ != null) {
            return this.anJ.pb();
        }
        return null;
    }

    public String getUrl() {
        return this.anF;
    }
}
