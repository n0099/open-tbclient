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
    private static h Ek = null;
    private String[] En;
    private g.a Er;
    private String El = null;
    private List<BasicNameValuePair> Em = null;
    private String Eo = null;
    private i Ep = null;
    private ArrayList<g.a> Eq = new ArrayList<>();

    public static h kp() {
        if (Ek == null) {
            synchronized (h.class) {
                if (Ek == null) {
                    Ek = new h();
                }
            }
        }
        return Ek;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.El = str;
        this.Eo = str2;
        this.En = strArr;
        this.Em = list;
        if (isDebug()) {
        }
    }

    private h() {
        this.Er = null;
        this.Er = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void S(String str) {
                Iterator it = h.this.Eq.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).S(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void q(byte[] bArr) {
                Iterator it = h.this.Eq.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).q(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.Eq.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void i(Map<String, String> map) {
                Iterator it = h.this.Eq.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).i(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void e(int i, String str) {
                h.this.Ep = null;
                Iterator it = h.this.Eq.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).e(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.Eq.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void ko() {
                Iterator it = h.this.Eq.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).ko();
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(c cVar) {
                if (cVar != null) {
                    cVar.fa();
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
                    cVar.fb();
                }
            }
        };
    }

    public boolean kq() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.jS();
        }
        if (this.Ep != null) {
            if (this.Ep.isConnecting() || this.Ep.isOpen()) {
                if (isDebug()) {
                }
                return true;
            }
            this.Ep.close(1, null);
            this.Ep = null;
        }
        this.Ep = new i();
        try {
            l lVar = new l();
            lVar.bm(this.Eo);
            this.Ep.a(this.El, this.En, this.Er, lVar, this.Em);
            return true;
        } catch (WebSocketException e) {
            this.Ep = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.Ep != null) {
            i iVar = this.Ep;
            this.Ep = null;
            iVar.close(i, str);
            if (this.Ep != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.Ep = null;
            }
        }
    }

    public boolean kr() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.jS();
        }
        return (this.Ep == null || !this.Ep.isOpen() || this.Ep.kz()) ? false : true;
    }

    public boolean ks() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.jS();
        }
        return this.Ep != null && this.Ep.isOpen();
    }

    public boolean isConnecting() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.jS();
        }
        return this.Ep != null && this.Ep.isConnecting();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.jS();
                if (this.Ep != null) {
                    z = this.Ep.sendMessage(cVar);
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
                if (!this.Eq.contains(aVar)) {
                    return this.Eq.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void kt() {
        if (this.Ep != null) {
            this.Ep.kt();
        }
    }

    public long getUpFlowSize() {
        if (this.Ep != null) {
            return this.Ep.getUpFlowSize();
        }
        return -1L;
    }

    public void ku() {
        if (this.Ep != null) {
            this.Ep.ku();
        }
    }

    public long getDownFlowSize() {
        if (this.Ep != null) {
            return this.Ep.getDownFlowSize();
        }
        return -1L;
    }

    public long km() {
        if (this.Ep != null) {
            return this.Ep.kA();
        }
        return -1L;
    }

    public String kl() {
        if (this.Ep != null) {
            return this.Ep.kB();
        }
        return null;
    }

    public long kv() {
        if (this.Ep != null) {
            return this.Ep.kC();
        }
        return -1L;
    }

    public String jV() {
        if (this.Ep != null) {
            return this.Ep.jV();
        }
        return null;
    }

    public String jW() {
        if (this.Ep != null) {
            return this.Ep.jW();
        }
        return null;
    }

    public String getUrl() {
        return this.El;
    }
}
