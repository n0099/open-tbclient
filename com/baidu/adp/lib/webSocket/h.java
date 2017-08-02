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
    private static h zX = null;
    private String[] Aa;
    private g.a Af;
    private String zY = null;
    private List<BasicNameValuePair> zZ = null;
    private String Ab = null;
    private i Ac = null;
    private ArrayList<g.a> Ae = new ArrayList<>();

    public static h hU() {
        if (zX == null) {
            synchronized (h.class) {
                if (zX == null) {
                    zX = new h();
                }
            }
        }
        return zX;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.zY = str;
        this.Ab = str2;
        this.Aa = strArr;
        this.zZ = list;
        if (isDebug()) {
        }
    }

    private h() {
        this.Af = null;
        this.Af = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void C(String str) {
                Iterator it = h.this.Ae.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).C(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void r(byte[] bArr) {
                Iterator it = h.this.Ae.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).r(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.Ae.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void e(Map<String, String> map) {
                Iterator it = h.this.Ae.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).e(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void e(int i, String str) {
                h.this.Ac = null;
                Iterator it = h.this.Ae.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).e(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.Ae.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void hT() {
                Iterator it = h.this.Ae.iterator();
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
        if (isDebug()) {
            com.baidu.adp.lib.util.k.hw();
        }
        if (this.Ac != null) {
            if (this.Ac.hY() || this.Ac.isOpen()) {
                if (isDebug()) {
                }
                return true;
            }
            this.Ac.close(1, null);
            this.Ac = null;
        }
        this.Ac = new i();
        try {
            l lVar = new l();
            lVar.aS(this.Ab);
            this.Ac.a(this.zY, this.Aa, this.Af, lVar, this.zZ);
            return true;
        } catch (WebSocketException e) {
            this.Ac = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.Ac != null) {
            i iVar = this.Ac;
            this.Ac = null;
            iVar.close(i, str);
            if (this.Ac != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.Ac = null;
            }
        }
    }

    public boolean hW() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.hw();
        }
        return (this.Ac == null || !this.Ac.isOpen() || this.Ac.m5if()) ? false : true;
    }

    public boolean hX() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.hw();
        }
        return this.Ac != null && this.Ac.isOpen();
    }

    public boolean hY() {
        if (isDebug()) {
            com.baidu.adp.lib.util.k.hw();
        }
        return this.Ac != null && this.Ac.hY();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.k.hw();
                if (this.Ac != null) {
                    z = this.Ac.sendMessage(cVar);
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
                if (!this.Ae.contains(aVar)) {
                    return this.Ae.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void hZ() {
        if (this.Ac != null) {
            this.Ac.hZ();
        }
    }

    public long getUpFlowSize() {
        if (this.Ac != null) {
            return this.Ac.getUpFlowSize();
        }
        return -1L;
    }

    public void ia() {
        if (this.Ac != null) {
            this.Ac.ia();
        }
    }

    public long getDownFlowSize() {
        if (this.Ac != null) {
            return this.Ac.getDownFlowSize();
        }
        return -1L;
    }

    public long hR() {
        if (this.Ac != null) {
            return this.Ac.ig();
        }
        return -1L;
    }

    public String hQ() {
        if (this.Ac != null) {
            return this.Ac.ih();
        }
        return null;
    }

    public long ib() {
        if (this.Ac != null) {
            return this.Ac.ii();
        }
        return -1L;
    }

    public String hz() {
        if (this.Ac != null) {
            return this.Ac.hz();
        }
        return null;
    }

    public String hA() {
        if (this.Ac != null) {
            return this.Ac.hA();
        }
        return null;
    }

    public String getUrl() {
        return this.zY;
    }
}
