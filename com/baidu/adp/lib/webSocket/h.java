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
    private static h Ej = null;
    private String[] Em;
    private g.a Eq;
    private String Ek = null;
    private List<BasicNameValuePair> El = null;
    private String En = null;
    private i Eo = null;
    private ArrayList<g.a> Ep = new ArrayList<>();

    public static h kq() {
        if (Ej == null) {
            synchronized (h.class) {
                if (Ej == null) {
                    Ej = new h();
                }
            }
        }
        return Ej;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.Ek = str;
        this.En = str2;
        this.Em = strArr;
        this.El = list;
        if (ku()) {
        }
    }

    private h() {
        this.Eq = null;
        this.Eq = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void S(String str) {
                Iterator it = h.this.Ep.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).S(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void p(byte[] bArr) {
                Iterator it = h.this.Ep.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).p(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.Ep.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void i(Map<String, String> map) {
                Iterator it = h.this.Ep.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).i(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void f(int i, String str) {
                h.this.Eo = null;
                Iterator it = h.this.Ep.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).f(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.Ep.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void kp() {
                Iterator it = h.this.Ep.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).kp();
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(c cVar) {
                if (cVar != null) {
                    cVar.eZ();
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(int i, c cVar) {
                if (cVar != null) {
                    cVar.G(i);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void c(c cVar) {
                if (cVar != null) {
                    cVar.fa();
                }
            }
        };
    }

    public boolean kr() {
        if (ku()) {
            com.baidu.adp.lib.util.l.jT();
        }
        if (this.Eo != null) {
            if (this.Eo.isConnecting() || this.Eo.isOpen()) {
                if (ku()) {
                }
                return true;
            }
            this.Eo.close(1, null);
            this.Eo = null;
        }
        this.Eo = new i();
        try {
            l lVar = new l();
            lVar.bp(this.En);
            this.Eo.a(this.Ek, this.Em, this.Eq, lVar, this.El);
            return true;
        } catch (WebSocketException e) {
            this.Eo = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.Eo != null) {
            i iVar = this.Eo;
            this.Eo = null;
            iVar.close(i, str);
            if (this.Eo != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.Eo = null;
            }
        }
    }

    public boolean ks() {
        if (ku()) {
            com.baidu.adp.lib.util.l.jT();
        }
        return (this.Eo == null || !this.Eo.isOpen() || this.Eo.kB()) ? false : true;
    }

    public boolean kt() {
        if (ku()) {
            com.baidu.adp.lib.util.l.jT();
        }
        return this.Eo != null && this.Eo.isOpen();
    }

    public boolean isConnecting() {
        if (ku()) {
            com.baidu.adp.lib.util.l.jT();
        }
        return this.Eo != null && this.Eo.isConnecting();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.jT();
                if (this.Eo != null) {
                    z = this.Eo.sendMessage(cVar);
                } else if (cVar != null) {
                    cVar.G(1);
                }
            }
        }
        return z;
    }

    public boolean a(g.a aVar) {
        if (aVar != null) {
            synchronized (h.class) {
                if (!this.Ep.contains(aVar)) {
                    return this.Ep.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean ku() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void kv() {
        if (this.Eo != null) {
            this.Eo.kv();
        }
    }

    public long getUpFlowSize() {
        if (this.Eo != null) {
            return this.Eo.getUpFlowSize();
        }
        return -1L;
    }

    public void kw() {
        if (this.Eo != null) {
            this.Eo.kw();
        }
    }

    public long getDownFlowSize() {
        if (this.Eo != null) {
            return this.Eo.getDownFlowSize();
        }
        return -1L;
    }

    public long kn() {
        if (this.Eo != null) {
            return this.Eo.kC();
        }
        return -1L;
    }

    public String km() {
        if (this.Eo != null) {
            return this.Eo.kD();
        }
        return null;
    }

    public long kx() {
        if (this.Eo != null) {
            return this.Eo.kE();
        }
        return -1L;
    }

    public String jW() {
        if (this.Eo != null) {
            return this.Eo.jW();
        }
        return null;
    }

    public String jX() {
        if (this.Eo != null) {
            return this.Eo.jX();
        }
        return null;
    }

    public String getUrl() {
        return this.Ek;
    }
}
