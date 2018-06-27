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
    private static h Em = null;
    private String[] Ep;
    private g.a Et;
    private String En = null;
    private List<BasicNameValuePair> Eo = null;
    private String Eq = null;
    private i Er = null;
    private ArrayList<g.a> Es = new ArrayList<>();

    public static h kp() {
        if (Em == null) {
            synchronized (h.class) {
                if (Em == null) {
                    Em = new h();
                }
            }
        }
        return Em;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.En = str;
        this.Eq = str2;
        this.Ep = strArr;
        this.Eo = list;
        if (isDebug()) {
        }
    }

    private h() {
        this.Et = null;
        this.Et = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void S(String str) {
                Iterator it = h.this.Es.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).S(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void r(byte[] bArr) {
                Iterator it = h.this.Es.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).r(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.Es.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void i(Map<String, String> map) {
                Iterator it = h.this.Es.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).i(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void e(int i, String str) {
                h.this.Er = null;
                Iterator it = h.this.Es.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).e(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.Es.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void ko() {
                Iterator it = h.this.Es.iterator();
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
        if (this.Er != null) {
            if (this.Er.isConnecting() || this.Er.isOpen()) {
                if (isDebug()) {
                }
                return true;
            }
            this.Er.close(1, null);
            this.Er = null;
        }
        this.Er = new i();
        try {
            l lVar = new l();
            lVar.bo(this.Eq);
            this.Er.a(this.En, this.Ep, this.Et, lVar, this.Eo);
            return true;
        } catch (WebSocketException e) {
            this.Er = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.Er != null) {
            i iVar = this.Er;
            this.Er = null;
            iVar.close(i, str);
            if (this.Er != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.Er = null;
            }
        }
    }

    public boolean kr() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.jS();
        }
        return (this.Er == null || !this.Er.isOpen() || this.Er.kz()) ? false : true;
    }

    public boolean ks() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.jS();
        }
        return this.Er != null && this.Er.isOpen();
    }

    public boolean isConnecting() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.jS();
        }
        return this.Er != null && this.Er.isConnecting();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.jS();
                if (this.Er != null) {
                    z = this.Er.sendMessage(cVar);
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
                if (!this.Es.contains(aVar)) {
                    return this.Es.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void kt() {
        if (this.Er != null) {
            this.Er.kt();
        }
    }

    public long getUpFlowSize() {
        if (this.Er != null) {
            return this.Er.getUpFlowSize();
        }
        return -1L;
    }

    public void ku() {
        if (this.Er != null) {
            this.Er.ku();
        }
    }

    public long getDownFlowSize() {
        if (this.Er != null) {
            return this.Er.getDownFlowSize();
        }
        return -1L;
    }

    public long km() {
        if (this.Er != null) {
            return this.Er.kA();
        }
        return -1L;
    }

    public String kl() {
        if (this.Er != null) {
            return this.Er.kB();
        }
        return null;
    }

    public long kv() {
        if (this.Er != null) {
            return this.Er.kC();
        }
        return -1L;
    }

    public String jV() {
        if (this.Er != null) {
            return this.Er.jV();
        }
        return null;
    }

    public String jW() {
        if (this.Er != null) {
            return this.Er.jW();
        }
        return null;
    }

    public String getUrl() {
        return this.En;
    }
}
