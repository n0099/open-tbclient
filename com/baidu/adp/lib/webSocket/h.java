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
    private static h Fa = null;
    private String[] Fd;
    private g.a Fh;
    private String Fb = null;
    private List<BasicNameValuePair> Fc = null;
    private String Fe = null;
    private i Ff = null;
    private ArrayList<g.a> Fg = new ArrayList<>();

    public static h kD() {
        if (Fa == null) {
            synchronized (h.class) {
                if (Fa == null) {
                    Fa = new h();
                }
            }
        }
        return Fa;
    }

    public void a(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        this.Fb = str;
        this.Fe = str2;
        this.Fd = strArr;
        this.Fc = list;
        if (isDebug()) {
        }
    }

    private h() {
        this.Fh = null;
        this.Fh = new g.a() { // from class: com.baidu.adp.lib.webSocket.h.1
            @Override // com.baidu.adp.lib.webSocket.g.a
            public void S(String str) {
                Iterator it = h.this.Fg.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).S(str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void p(byte[] bArr) {
                Iterator it = h.this.Fg.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).p(bArr);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(k.a aVar) {
                Iterator it = h.this.Fg.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).b(aVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void onOpen(Map<String, String> map) {
                Iterator it = h.this.Fg.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).onOpen(map);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void f(int i, String str) {
                h.this.Ff = null;
                Iterator it = h.this.Fg.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).f(i, str);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void a(c cVar) {
                Iterator it = h.this.Fg.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).a(cVar);
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void kC() {
                Iterator it = h.this.Fg.iterator();
                while (it.hasNext()) {
                    ((g.a) it.next()).kC();
                }
            }

            @Override // com.baidu.adp.lib.webSocket.g.a
            public void b(c cVar) {
                if (cVar != null) {
                    cVar.fp();
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
                    cVar.fq();
                }
            }
        };
    }

    public boolean kE() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.kg();
        }
        if (this.Ff != null) {
            if (this.Ff.isConnecting() || this.Ff.isOpen()) {
                if (isDebug()) {
                }
                return true;
            }
            this.Ff.close(1, null);
            this.Ff = null;
        }
        this.Ff = new i();
        try {
            l lVar = new l();
            lVar.bp(this.Fe);
            this.Ff.a(this.Fb, this.Fd, this.Fh, lVar, this.Fc);
            return true;
        } catch (WebSocketException e) {
            this.Ff = null;
            return false;
        }
    }

    public void close(int i, String str) {
        if (this.Ff != null) {
            i iVar = this.Ff;
            this.Ff = null;
            iVar.close(i, str);
            if (this.Ff != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.Ff = null;
            }
        }
    }

    public boolean kF() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.kg();
        }
        return (this.Ff == null || !this.Ff.isOpen() || this.Ff.kN()) ? false : true;
    }

    public boolean kG() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.kg();
        }
        return this.Ff != null && this.Ff.isOpen();
    }

    public boolean isConnecting() {
        if (isDebug()) {
            com.baidu.adp.lib.util.l.kg();
        }
        return this.Ff != null && this.Ff.isConnecting();
    }

    public synchronized boolean sendMessage(c cVar) {
        boolean z = false;
        synchronized (this) {
            if (cVar != null) {
                com.baidu.adp.lib.util.l.kg();
                if (this.Ff != null) {
                    z = this.Ff.sendMessage(cVar);
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
                if (!this.Fg.contains(aVar)) {
                    return this.Fg.add(aVar);
                }
            }
        }
        return false;
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void kH() {
        if (this.Ff != null) {
            this.Ff.kH();
        }
    }

    public long getUpFlowSize() {
        if (this.Ff != null) {
            return this.Ff.getUpFlowSize();
        }
        return -1L;
    }

    public void kI() {
        if (this.Ff != null) {
            this.Ff.kI();
        }
    }

    public long getDownFlowSize() {
        if (this.Ff != null) {
            return this.Ff.getDownFlowSize();
        }
        return -1L;
    }

    public long kA() {
        if (this.Ff != null) {
            return this.Ff.kO();
        }
        return -1L;
    }

    public String kz() {
        if (this.Ff != null) {
            return this.Ff.kP();
        }
        return null;
    }

    public long kJ() {
        if (this.Ff != null) {
            return this.Ff.kQ();
        }
        return -1L;
    }

    public String kj() {
        if (this.Ff != null) {
            return this.Ff.kj();
        }
        return null;
    }

    public String kk() {
        if (this.Ff != null) {
            return this.Ff.kk();
        }
        return null;
    }

    public String getUrl() {
        return this.Fb;
    }
}
