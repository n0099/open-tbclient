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
    private static h anF = null;
    private String[] anI;
    private g.a anM;
    private String anG = null;
    private List<BasicNameValuePair> anH = null;
    private String anJ = null;
    private i anK = null;
    private ArrayList<g.a> anL = new ArrayList<>();

    public static h pu() {
        if (anF == null) {
            synchronized (h.class) {
                if (anF == null) {
                    anF = new h();
                }
            }
        }
        return anF;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.anG = str;
        this.anJ = str2;
        this.anI = strArr;
        this.anH = list;
        if (py()) {
        }
    }

    private h() {
        this.anM = null;
        this.anM = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void J(String str) {
                Iterator it = h.this.anL.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).J(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void o(byte[] bArr) {
                Iterator it = h.this.anL.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).o(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.anL.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void e(Map<String, String> map) {
                Iterator it = h.this.anL.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).e(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void e(int i, String str) {
                h.this.anK = null;
                Iterator it = h.this.anL.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).e(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.anL.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void pt() {
                Iterator it = h.this.anL.iterator();
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
        if (this.anK != null) {
            if (this.anK.isConnecting() || this.anK.isOpen()) {
                if (py()) {
                }
                return true;
            }
            this.anK.close(1, null);
            this.anK = null;
        }
        this.anK = new i();
        try {
            l lVar = new l();
            lVar.bd(this.anJ);
            this.anK.a(this.anG, this.anI, this.anM, lVar, this.anH);
            return true;
        } catch (WebSocketException e) {
            this.anK = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.anK != null) {
            i iVar = this.anK;
            this.anK = null;
            iVar.close(i, str);
            if (this.anK != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.anK = null;
            }
        }
    }

    public boolean pw() {
        if (py()) {
            com.baidu.adp.lib.util.l.oX();
        }
        return (this.anK == null || !this.anK.isOpen() || this.anK.pF()) ? false : true;
    }

    public boolean px() {
        if (py()) {
            com.baidu.adp.lib.util.l.oX();
        }
        return this.anK != null && this.anK.isOpen();
    }

    public boolean isConnecting() {
        if (py()) {
            com.baidu.adp.lib.util.l.oX();
        }
        return this.anK != null && this.anK.isConnecting();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.oX();
                if (this.anK != null) {
                    z = this.anK.sendMessage(cVar);
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
                if (!this.anL.contains(aVar)) {
                    return this.anL.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean py() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void pz() {
        if (this.anK != null) {
            this.anK.pz();
        }
    }

    public long getUpFlowSize() {
        if (this.anK != null) {
            return this.anK.getUpFlowSize();
        }
        return -1L;
    }

    public void pA() {
        if (this.anK != null) {
            this.anK.pA();
        }
    }

    public long getDownFlowSize() {
        if (this.anK != null) {
            return this.anK.getDownFlowSize();
        }
        return -1L;
    }

    public long pr() {
        if (this.anK != null) {
            return this.anK.pG();
        }
        return -1L;
    }

    public String pq() {
        if (this.anK != null) {
            return this.anK.pH();
        }
        return null;
    }

    public long pB() {
        if (this.anK != null) {
            return this.anK.pI();
        }
        return -1L;
    }

    public String pa() {
        if (this.anK != null) {
            return this.anK.pa();
        }
        return null;
    }

    public String pb() {
        if (this.anK != null) {
            return this.anK.pb();
        }
        return null;
    }

    public String getUrl() {
        return this.anG;
    }
}
