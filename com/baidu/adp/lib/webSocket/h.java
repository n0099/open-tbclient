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
    private static h GD = null;
    private String[] GG;
    private g.a GK;
    private String GE = null;
    private List<BasicNameValuePair> GF = null;
    private String GH = null;
    private i GI = null;
    private ArrayList<g.a> GJ = new ArrayList<>();

    public static h lw() {
        if (GD == null) {
            synchronized (h.class) {
                if (GD == null) {
                    GD = new h();
                }
            }
        }
        return GD;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.GE = str;
        this.GH = str2;
        this.GG = strArr;
        this.GF = list;
        if (lA()) {
        }
    }

    private h() {
        this.GK = null;
        this.GK = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void aj(String str) {
                Iterator it = h.this.GJ.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).aj(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void x(byte[] bArr) {
                Iterator it = h.this.GJ.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).x(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.GJ.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void j(Map<String, String> map) {
                Iterator it = h.this.GJ.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).j(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void f(int i, String str) {
                h.this.GI = null;
                Iterator it = h.this.GJ.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).f(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.GJ.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void lv() {
                Iterator it = h.this.GJ.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).lv();
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(c cVar) {
                if (cVar != null) {
                    cVar.gi();
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
                    cVar.gj();
                }
            }
        };
    }

    public boolean lx() {
        if (lA()) {
            com.baidu.adp.lib.util.l.kZ();
        }
        if (this.GI != null) {
            if (this.GI.isConnecting() || this.GI.isOpen()) {
                if (lA()) {
                }
                return true;
            }
            this.GI.close(1, null);
            this.GI = null;
        }
        this.GI = new i();
        try {
            l lVar = new l();
            lVar.bG(this.GH);
            this.GI.a(this.GE, this.GG, this.GK, lVar, this.GF);
            return true;
        } catch (WebSocketException e) {
            this.GI = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.GI != null) {
            i iVar = this.GI;
            this.GI = null;
            iVar.close(i, str);
            if (this.GI != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.GI = null;
            }
        }
    }

    public boolean ly() {
        if (lA()) {
            com.baidu.adp.lib.util.l.kZ();
        }
        return (this.GI == null || !this.GI.isOpen() || this.GI.lH()) ? false : true;
    }

    public boolean lz() {
        if (lA()) {
            com.baidu.adp.lib.util.l.kZ();
        }
        return this.GI != null && this.GI.isOpen();
    }

    public boolean isConnecting() {
        if (lA()) {
            com.baidu.adp.lib.util.l.kZ();
        }
        return this.GI != null && this.GI.isConnecting();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.kZ();
                if (this.GI != null) {
                    z = this.GI.sendMessage(cVar);
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
                if (!this.GJ.contains(aVar)) {
                    return this.GJ.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean lA() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void lB() {
        if (this.GI != null) {
            this.GI.lB();
        }
    }

    public long getUpFlowSize() {
        if (this.GI != null) {
            return this.GI.getUpFlowSize();
        }
        return -1L;
    }

    public void lC() {
        if (this.GI != null) {
            this.GI.lC();
        }
    }

    public long getDownFlowSize() {
        if (this.GI != null) {
            return this.GI.getDownFlowSize();
        }
        return -1L;
    }

    public long lt() {
        if (this.GI != null) {
            return this.GI.lI();
        }
        return -1L;
    }

    public String ls() {
        if (this.GI != null) {
            return this.GI.lJ();
        }
        return null;
    }

    public long lD() {
        if (this.GI != null) {
            return this.GI.lK();
        }
        return -1L;
    }

    public String lc() {
        if (this.GI != null) {
            return this.GI.lc();
        }
        return null;
    }

    public String ld() {
        if (this.GI != null) {
            return this.GI.ld();
        }
        return null;
    }

    public String getUrl() {
        return this.GE;
    }
}
