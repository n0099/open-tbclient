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
    private static h zw = null;
    private g.a zD;
    private String[] zz;
    private String zx = null;
    private List<BasicNameValuePair> zy = null;
    private String zA = null;
    private i zB = null;
    private ArrayList<g.a> zC = new ArrayList<>();

    public static h hU() {
        if (zw == null) {
            synchronized (h.class) {
                if (zw == null) {
                    zw = new h();
                }
            }
        }
        return zw;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.zx = str;
        this.zA = str2;
        this.zz = strArr;
        this.zy = list;
        if (hZ()) {
        }
    }

    private h() {
        this.zD = null;
        this.zD = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void C(String str) {
                Iterator it = h.this.zC.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).C(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void o(byte[] bArr) {
                Iterator it = h.this.zC.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).o(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.zC.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void e(Map<String, String> map) {
                Iterator it = h.this.zC.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).e(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void e(int i, String str) {
                h.this.zB = null;
                Iterator it = h.this.zC.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).e(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.zC.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void hT() {
                Iterator it = h.this.zC.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).hT();
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(c cVar) {
                if (cVar != null) {
                    cVar.cD();
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(int i, c cVar) {
                if (cVar != null) {
                    cVar.M(i);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void c(c cVar) {
                if (cVar != null) {
                    cVar.cE();
                }
            }
        };
    }

    public boolean hV() {
        if (hZ()) {
            com.baidu.adp.lib.util.l.hw();
        }
        if (this.zB != null) {
            if (this.zB.hY() || this.zB.isOpen()) {
                if (hZ()) {
                }
                return true;
            }
            this.zB.close(1, null);
            this.zB = null;
        }
        this.zB = new i();
        try {
            l lVar = new l();
            lVar.aV(this.zA);
            this.zB.a(this.zx, this.zz, this.zD, lVar, this.zy);
            return true;
        } catch (WebSocketException e) {
            this.zB = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.zB != null) {
            i iVar = this.zB;
            this.zB = null;
            iVar.close(i, str);
            if (this.zB != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.zB = null;
            }
        }
    }

    public boolean hW() {
        if (hZ()) {
            com.baidu.adp.lib.util.l.hw();
        }
        return (this.zB == null || !this.zB.isOpen() || this.zB.ig()) ? false : true;
    }

    public boolean hX() {
        if (hZ()) {
            com.baidu.adp.lib.util.l.hw();
        }
        return this.zB != null && this.zB.isOpen();
    }

    public boolean hY() {
        if (hZ()) {
            com.baidu.adp.lib.util.l.hw();
        }
        return this.zB != null && this.zB.hY();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.hw();
                if (this.zB != null) {
                    z = this.zB.sendMessage(cVar);
                } else if (cVar != null) {
                    cVar.M(1);
                }
            }
        }
        return z;
    }

    public boolean a(g.a aVar) {
        if (aVar != null) {
            synchronized (h.class) {
                if (!this.zC.contains(aVar)) {
                    return this.zC.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean hZ() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void ia() {
        if (this.zB != null) {
            this.zB.ia();
        }
    }

    public long getUpFlowSize() {
        if (this.zB != null) {
            return this.zB.getUpFlowSize();
        }
        return -1L;
    }

    public void ib() {
        if (this.zB != null) {
            this.zB.ib();
        }
    }

    public long getDownFlowSize() {
        if (this.zB != null) {
            return this.zB.getDownFlowSize();
        }
        return -1L;
    }

    public long hR() {
        if (this.zB != null) {
            return this.zB.ih();
        }
        return -1L;
    }

    public String hQ() {
        if (this.zB != null) {
            return this.zB.ii();
        }
        return null;
    }

    public long ic() {
        if (this.zB != null) {
            return this.zB.ij();
        }
        return -1L;
    }

    public String hz() {
        if (this.zB != null) {
            return this.zB.hz();
        }
        return null;
    }

    public String hA() {
        if (this.zB != null) {
            return this.zB.hA();
        }
        return null;
    }

    public String getUrl() {
        return this.zx;
    }
}
