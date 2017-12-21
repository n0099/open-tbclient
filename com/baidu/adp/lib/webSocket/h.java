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
    private static h zu = null;
    private g.a zB;
    private String[] zx;
    private String zv = null;
    private List<BasicNameValuePair> zw = null;
    private String zy = null;
    private i zz = null;
    private ArrayList<g.a> zA = new ArrayList<>();

    public static h hU() {
        if (zu == null) {
            synchronized (h.class) {
                if (zu == null) {
                    zu = new h();
                }
            }
        }
        return zu;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.zv = str;
        this.zy = str2;
        this.zx = strArr;
        this.zw = list;
        if (hZ()) {
        }
    }

    private h() {
        this.zB = null;
        this.zB = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void C(String str) {
                Iterator it = h.this.zA.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).C(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void o(byte[] bArr) {
                Iterator it = h.this.zA.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).o(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.zA.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void e(Map<String, String> map) {
                Iterator it = h.this.zA.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).e(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void e(int i, String str) {
                h.this.zz = null;
                Iterator it = h.this.zA.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).e(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.zA.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void hT() {
                Iterator it = h.this.zA.iterator();
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
                    cVar.L(i);
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
        if (this.zz != null) {
            if (this.zz.hY() || this.zz.isOpen()) {
                if (hZ()) {
                }
                return true;
            }
            this.zz.close(1, null);
            this.zz = null;
        }
        this.zz = new i();
        try {
            l lVar = new l();
            lVar.aV(this.zy);
            this.zz.a(this.zv, this.zx, this.zB, lVar, this.zw);
            return true;
        } catch (WebSocketException e) {
            this.zz = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.zz != null) {
            i iVar = this.zz;
            this.zz = null;
            iVar.close(i, str);
            if (this.zz != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.zz = null;
            }
        }
    }

    public boolean hW() {
        if (hZ()) {
            com.baidu.adp.lib.util.l.hw();
        }
        return (this.zz == null || !this.zz.isOpen() || this.zz.ig()) ? false : true;
    }

    public boolean hX() {
        if (hZ()) {
            com.baidu.adp.lib.util.l.hw();
        }
        return this.zz != null && this.zz.isOpen();
    }

    public boolean hY() {
        if (hZ()) {
            com.baidu.adp.lib.util.l.hw();
        }
        return this.zz != null && this.zz.hY();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.hw();
                if (this.zz != null) {
                    z = this.zz.sendMessage(cVar);
                } else if (cVar != null) {
                    cVar.L(1);
                }
            }
        }
        return z;
    }

    public boolean a(g.a aVar) {
        if (aVar != null) {
            synchronized (h.class) {
                if (!this.zA.contains(aVar)) {
                    return this.zA.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean hZ() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void ia() {
        if (this.zz != null) {
            this.zz.ia();
        }
    }

    public long getUpFlowSize() {
        if (this.zz != null) {
            return this.zz.getUpFlowSize();
        }
        return -1L;
    }

    public void ib() {
        if (this.zz != null) {
            this.zz.ib();
        }
    }

    public long getDownFlowSize() {
        if (this.zz != null) {
            return this.zz.getDownFlowSize();
        }
        return -1L;
    }

    public long hR() {
        if (this.zz != null) {
            return this.zz.ih();
        }
        return -1L;
    }

    public String hQ() {
        if (this.zz != null) {
            return this.zz.ii();
        }
        return null;
    }

    public long ic() {
        if (this.zz != null) {
            return this.zz.ij();
        }
        return -1L;
    }

    public String hz() {
        if (this.zz != null) {
            return this.zz.hz();
        }
        return null;
    }

    public String hA() {
        if (this.zz != null) {
            return this.zz.hA();
        }
        return null;
    }

    public String getUrl() {
        return this.zv;
    }
}
