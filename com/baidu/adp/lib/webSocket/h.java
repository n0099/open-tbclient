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
    private static h zt = null;
    private g.a zA;
    private String[] zw;
    private String zu = null;
    private List<BasicNameValuePair> zv = null;
    private String zx = null;
    private i zy = null;
    private ArrayList<g.a> zz = new ArrayList<>();

    public static h hU() {
        if (zt == null) {
            synchronized (h.class) {
                if (zt == null) {
                    zt = new h();
                }
            }
        }
        return zt;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.zu = str;
        this.zx = str2;
        this.zw = strArr;
        this.zv = list;
        if (hZ()) {
        }
    }

    private h() {
        this.zA = null;
        this.zA = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void C(String str) {
                Iterator it = h.this.zz.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).C(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void o(byte[] bArr) {
                Iterator it = h.this.zz.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).o(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.zz.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void e(Map<String, String> map) {
                Iterator it = h.this.zz.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).e(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void e(int i, String str) {
                h.this.zy = null;
                Iterator it = h.this.zz.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).e(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.zz.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void hT() {
                Iterator it = h.this.zz.iterator();
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
        if (this.zy != null) {
            if (this.zy.hY() || this.zy.isOpen()) {
                if (hZ()) {
                }
                return true;
            }
            this.zy.close(1, null);
            this.zy = null;
        }
        this.zy = new i();
        try {
            l lVar = new l();
            lVar.aV(this.zx);
            this.zy.a(this.zu, this.zw, this.zA, lVar, this.zv);
            return true;
        } catch (WebSocketException e) {
            this.zy = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.zy != null) {
            i iVar = this.zy;
            this.zy = null;
            iVar.close(i, str);
            if (this.zy != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.zy = null;
            }
        }
    }

    public boolean hW() {
        if (hZ()) {
            com.baidu.adp.lib.util.l.hw();
        }
        return (this.zy == null || !this.zy.isOpen() || this.zy.ig()) ? false : true;
    }

    public boolean hX() {
        if (hZ()) {
            com.baidu.adp.lib.util.l.hw();
        }
        return this.zy != null && this.zy.isOpen();
    }

    public boolean hY() {
        if (hZ()) {
            com.baidu.adp.lib.util.l.hw();
        }
        return this.zy != null && this.zy.hY();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.hw();
                if (this.zy != null) {
                    z = this.zy.sendMessage(cVar);
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
                if (!this.zz.contains(aVar)) {
                    return this.zz.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean hZ() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void ia() {
        if (this.zy != null) {
            this.zy.ia();
        }
    }

    public long getUpFlowSize() {
        if (this.zy != null) {
            return this.zy.getUpFlowSize();
        }
        return -1L;
    }

    public void ib() {
        if (this.zy != null) {
            this.zy.ib();
        }
    }

    public long getDownFlowSize() {
        if (this.zy != null) {
            return this.zy.getDownFlowSize();
        }
        return -1L;
    }

    public long hR() {
        if (this.zy != null) {
            return this.zy.ih();
        }
        return -1L;
    }

    public String hQ() {
        if (this.zy != null) {
            return this.zy.ii();
        }
        return null;
    }

    public long ic() {
        if (this.zy != null) {
            return this.zy.ij();
        }
        return -1L;
    }

    public String hz() {
        if (this.zy != null) {
            return this.zy.hz();
        }
        return null;
    }

    public String hA() {
        if (this.zy != null) {
            return this.zy.hA();
        }
        return null;
    }

    public String getUrl() {
        return this.zu;
    }
}
