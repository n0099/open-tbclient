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
    private static h zv = null;
    private g.a zC;
    private String[] zy;
    private String zw = null;
    private List<BasicNameValuePair> zx = null;
    private String zz = null;
    private i zA = null;
    private ArrayList<g.a> zB = new ArrayList<>();

    public static h hU() {
        if (zv == null) {
            synchronized (h.class) {
                if (zv == null) {
                    zv = new h();
                }
            }
        }
        return zv;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.zw = str;
        this.zz = str2;
        this.zy = strArr;
        this.zx = list;
        if (hZ()) {
        }
    }

    private h() {
        this.zC = null;
        this.zC = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void C(String str) {
                Iterator it = h.this.zB.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).C(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void o(byte[] bArr) {
                Iterator it = h.this.zB.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).o(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.zB.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void e(Map<String, String> map) {
                Iterator it = h.this.zB.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).e(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void e(int i, String str) {
                h.this.zA = null;
                Iterator it = h.this.zB.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).e(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.zB.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void hT() {
                Iterator it = h.this.zB.iterator();
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
        if (this.zA != null) {
            if (this.zA.hY() || this.zA.isOpen()) {
                if (hZ()) {
                }
                return true;
            }
            this.zA.close(1, null);
            this.zA = null;
        }
        this.zA = new i();
        try {
            l lVar = new l();
            lVar.aV(this.zz);
            this.zA.a(this.zw, this.zy, this.zC, lVar, this.zx);
            return true;
        } catch (WebSocketException e) {
            this.zA = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.zA != null) {
            i iVar = this.zA;
            this.zA = null;
            iVar.close(i, str);
            if (this.zA != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.zA = null;
            }
        }
    }

    public boolean hW() {
        if (hZ()) {
            com.baidu.adp.lib.util.l.hw();
        }
        return (this.zA == null || !this.zA.isOpen() || this.zA.ig()) ? false : true;
    }

    public boolean hX() {
        if (hZ()) {
            com.baidu.adp.lib.util.l.hw();
        }
        return this.zA != null && this.zA.isOpen();
    }

    public boolean hY() {
        if (hZ()) {
            com.baidu.adp.lib.util.l.hw();
        }
        return this.zA != null && this.zA.hY();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.hw();
                if (this.zA != null) {
                    z = this.zA.sendMessage(cVar);
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
                if (!this.zB.contains(aVar)) {
                    return this.zB.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean hZ() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void ia() {
        if (this.zA != null) {
            this.zA.ia();
        }
    }

    public long getUpFlowSize() {
        if (this.zA != null) {
            return this.zA.getUpFlowSize();
        }
        return -1L;
    }

    public void ib() {
        if (this.zA != null) {
            this.zA.ib();
        }
    }

    public long getDownFlowSize() {
        if (this.zA != null) {
            return this.zA.getDownFlowSize();
        }
        return -1L;
    }

    public long hR() {
        if (this.zA != null) {
            return this.zA.ih();
        }
        return -1L;
    }

    public String hQ() {
        if (this.zA != null) {
            return this.zA.ii();
        }
        return null;
    }

    public long ic() {
        if (this.zA != null) {
            return this.zA.ij();
        }
        return -1L;
    }

    public String hz() {
        if (this.zA != null) {
            return this.zA.hz();
        }
        return null;
    }

    public String hA() {
        if (this.zA != null) {
            return this.zA.hA();
        }
        return null;
    }

    public String getUrl() {
        return this.zw;
    }
}
